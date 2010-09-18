/**
 * 
 */
package org.drools.util;

import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Properties;

import org.drools.RuntimeDroolsException;

/**
 * A helper class to deal with the key store and signing process during 
 * Serialisation
 * 
 * This class will read and use the following system properties:
 * 
 * drools.serialisation.sign = <false|true>
 * drools.serialisation.private.keyStoreURL = <URL>
 * drools.serialisation.private.keyStorePwd = <password>
 * drools.serialisation.private.keyAlias = <key>
 * drools.serialisation.private.keyPwd = <password>
 * drools.serialisation.public.keyStoreURL = <URL>
 * drools.serialisation.public.keyStorePwd = <password>
 * drools.serialisation.public.keyAlias = <key>
 * 
 * @author etirelli
 *
 */
public class KeyStoreHelper {

    // true if packages should be signed during serialization
    public static final String PROP_SIGN       = "drools.serialisation.sign";
    // the URL to the key store where the private key is stored
    public static final String PROP_PVT_KS_URL = "drools.serialisation.private.keyStoreURL";
    // the key store password
    public static final String PROP_PVT_KS_PWD = "drools.serialisation.private.keyStorePwd";
    // the private key identifier
    public static final String PROP_PVT_ALIAS  = "drools.serialisation.private.keyAlias";
    // the private key password
    public static final String PROP_PVT_PWD    = "drools.serialisation.private.keyPwd";
    // the URL to the key store where the public key is stored
    public static final String PROP_PUB_KS_URL = "drools.serialisation.public.keyStoreURL";
    // the key store password
    public static final String PROP_PUB_KS_PWD = "drools.serialisation.public.keyStorePwd";
    // the public key identifier
    public static final String PROP_PUB_ALIAS  = "drools.serialisation.public.keyAlias";

    private boolean            signed;
    private URL                pvtKeyStoreURL;
    private char[]             pvtKeyStorePwd;
    private String             pvtKeyAlias;
    private char[]             pvtKeyPassword;
    private URL                pubKeyStoreURL;
    private char[]             pubKeyStorePwd;
    private String             pubKeyAlias;

    private KeyStore           pvtKeyStore;
    private KeyStore           pubKeyStore;

    /**
     * Creates a KeyStoreHelper and initialises the KeyStore, by loading its entries.
     * 
     * @throws RuntimeDroolsException in case any error happens when initialising and loading the keystore.
     */
    public KeyStoreHelper() {
        try {
            Properties prop = System.getProperties();
            this.signed = Boolean.valueOf( prop.getProperty( PROP_SIGN,
                                                             "false" ) );
            String url = prop.getProperty( PROP_PVT_KS_URL,
                                           "" );
            if ( url.length() > 0 ) {
                this.pvtKeyStoreURL = new URL( url );
            }
            this.pvtKeyStorePwd = prop.getProperty( PROP_PVT_KS_PWD,
                                                    "" ).toCharArray();
            this.pvtKeyAlias = prop.getProperty( PROP_PVT_ALIAS,
                                                 "" );
            this.pvtKeyPassword = prop.getProperty( PROP_PVT_PWD,
                                                    "" ).toCharArray();

            url = prop.getProperty( PROP_PUB_KS_URL,
                                    "" );
            if ( url.length() > 0 ) {
                this.pubKeyStoreURL = new URL( url );
            }
            this.pubKeyStorePwd = prop.getProperty( PROP_PUB_KS_PWD,
                                                    "" ).toCharArray();
            this.pubKeyAlias = prop.getProperty( PROP_PUB_ALIAS,
                                                 "" );
            initKeyStore();
        } catch ( Exception e ) {
            throw new RuntimeDroolsException( "Error initialising KeyStore: " + e.getMessage(),
                                              e );
        }
    }

    private void initKeyStore() throws NoSuchAlgorithmException,
                               CertificateException,
                               IOException,
                               KeyStoreException {
        if ( pvtKeyStoreURL != null ) {
            this.pvtKeyStore = KeyStore.getInstance( "JKS" );
            this.pvtKeyStore.load( pvtKeyStoreURL.openStream(),
                                   pvtKeyStorePwd );
        }
        if ( pubKeyStoreURL != null ) {
            this.pubKeyStore = KeyStore.getInstance( "JKS" );
            this.pubKeyStore.load( pubKeyStoreURL.openStream(),
                                   pubKeyStorePwd );
        }
    }

    /**
     * Generates the signature for the given byte[] using MD5 with RSA algorithm and the 
     * private key with which this helper was initialised. 
     *  
     * @param data the byte[] of data to be signed
     * 
     * @return the signature, encrypted with the private key 
     * 
     * @throws UnrecoverableKeyException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public byte[] signDataWithPrivateKey(byte[] data) throws UnrecoverableKeyException,
                                                     KeyStoreException,
                                                     NoSuchAlgorithmException,
                                                     InvalidKeyException,
                                                     SignatureException {
        PrivateKey pvtkey = (PrivateKey) pvtKeyStore.getKey( pvtKeyAlias,
                                                             pvtKeyPassword );
        Signature sig = Signature.getInstance( "MD5withRSA" );
        sig.initSign( pvtkey );
        sig.update( data );
        return sig.sign();
    }

    /**
     * Checks the given byte[] data against the signature, using the 
     * public key with which this helper was initialised and the algorithm
     * MD5 with RSA.
     * 
     * @param data the original data that was signed
     * @param signature the provided signature
     * 
     * @return true in case the signature matches, false otherwise.
     *  
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public boolean checkDataWithPublicKey(byte[] data,
                                          byte[] signature) throws KeyStoreException,
                                                           NoSuchAlgorithmException,
                                                           InvalidKeyException,
                                                           SignatureException {
        Certificate cert = pubKeyStore.getCertificate( pubKeyAlias );
        Signature sig = Signature.getInstance( "MD5withRSA" );
        sig.initVerify( cert.getPublicKey() );
        sig.update( data );
        return sig.verify( signature );
    }

    public boolean isSigned() {
        return signed;
    }

    public URL getPvtKeyStoreURL() {
        return pvtKeyStoreURL;
    }

    public char[] getPvtKeyStorePwd() {
        return pvtKeyStorePwd;
    }

    public String getPvtKeyAlias() {
        return pvtKeyAlias;
    }

    public char[] getPvtKeyPassword() {
        return pvtKeyPassword;
    }

    public URL getPubKeyStoreURL() {
        return pubKeyStoreURL;
    }

    public char[] getPubKeyStorePwd() {
        return pubKeyStorePwd;
    }

    public String getPubKeyAlias() {
        return pubKeyAlias;
    }

    public KeyStore getPvtKeyStore() {
        return pvtKeyStore;
    }

    public KeyStore getPubKeyStore() {
        return pubKeyStore;
    }

}
