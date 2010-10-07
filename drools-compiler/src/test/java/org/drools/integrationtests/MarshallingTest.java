package org.drools.integrationtests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.net.URL;

import junit.framework.TestCase;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;
import org.drools.util.KeyStoreHelper;

public class MarshallingTest extends TestCase {
    /*
     *  Testing the signature framework 
     */
    public void testSignedSerialization1() throws Exception {
        try {
            setPrivateKeyProperties();
            setPublicKeyProperties();

            // compile and load package
            Package pkg = loadPackage();

            // Test package serialization/deserialization
            pkg = serialisePackage( pkg );

            // Create a rulebase
            RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage( pkg );

            // Test rulebase serialization/deserialization
            byte[] serializedRulebase = serializeOut( ruleBase );
            ruleBase = (RuleBase) serializeIn( serializedRulebase );
        } finally {
            unsetPrivateKeyProperties();
            unsetPublicKeyProperties();
        }
    }

    /*
     *  Deserializing a signed package without the proper public key 
     *  should fail. 
     */
    public void testSignedSerialization2() throws Exception {
        try {
            // set only the serialisation properties, but not the deserialization
            setPrivateKeyProperties();

            // compile and load package
            Package pkg = loadPackage();

            try {
                // Test package serialization/deserialization
                serialisePackage( pkg );
                fail( "Deserialisation should have failed." );
            } catch ( Exception e ) {
                // success
            }
        } finally {
            unsetPrivateKeyProperties();
        }
    }

    /*
     *  Deserializing a signed rulebase without the proper public key 
     *  should fail. 
     */
    public void testSignedSerialization3() throws Exception {
        try {
            // set only the serialisation properties, but not the deserialization
            setPrivateKeyProperties();

            // compile and load package
            Package pkg = loadPackage();

            // Create a rulebase
            RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage( pkg );

            // Test rulebase serialization/deserialization
            byte[] serializedRulebase = serializeOut( ruleBase );

            try {
                ruleBase = (RuleBase) serializeIn( serializedRulebase );
                fail( "Deserialisation should have failed." );
            } catch ( Exception e ) {
                // success
            }
        } finally {
            unsetPrivateKeyProperties();
        }
    }

    /*
     *  A client environment configured to use signed serialization
     *  should refuse any non-signed serialized rulebase 
     */
    public void testSignedSerialization4() throws Exception {

        // compile and load package
        Package pkg = loadPackage();

        // Create a rulebase
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage( pkg );

        // Test rulebase serialization/deserialization
        byte[] serializedRulebase = serializeOut( ruleBase );

        try {
            // set only the deserialisation properties, but not the serialization
            setPublicKeyProperties();
            ruleBase = (RuleBase) serializeIn( serializedRulebase );
            fail( "Should not deserialize an unsigned rulebase on an environment configured to work with signed rulebases." );
        } catch ( Exception e ) {
            // success
        } finally {
            unsetPublicKeyProperties();
        }
    }

    private void setPublicKeyProperties() {
        // Set the client properties to de-serialise the signed packages
        URL clientKeyStoreURL = getClass().getResource( "droolsClient.keystore" );
        System.setProperty( KeyStoreHelper.PROP_SIGN,
                            "true" );
        System.setProperty( KeyStoreHelper.PROP_PUB_KS_URL,
                            clientKeyStoreURL.toExternalForm() );
        System.setProperty( KeyStoreHelper.PROP_PUB_KS_PWD,
                            "clientpwd" );
    }

    private void unsetPublicKeyProperties() {
        // Un-set the client properties to de-serialise the signed packages
        System.setProperty( KeyStoreHelper.PROP_SIGN,
                            "" );
        System.setProperty( KeyStoreHelper.PROP_PUB_KS_URL,
                            "" );
        System.setProperty( KeyStoreHelper.PROP_PUB_KS_PWD,
                            "" );
    }

    private void setPrivateKeyProperties() {
        // Set the server properties to serialise the signed packages 
        URL serverKeyStoreURL = getClass().getResource( "droolsServer.keystore" );
        System.setProperty( KeyStoreHelper.PROP_SIGN,
                            "true" );
        System.setProperty( KeyStoreHelper.PROP_PVT_KS_URL,
                            serverKeyStoreURL.toExternalForm() );
        System.setProperty( KeyStoreHelper.PROP_PVT_KS_PWD,
                            "serverpwd" );
        System.setProperty( KeyStoreHelper.PROP_PVT_ALIAS,
                            "droolsKey" );
        System.setProperty( KeyStoreHelper.PROP_PVT_PWD,
                            "keypwd" );
    }

    private void unsetPrivateKeyProperties() {
        // Un-set the server properties to serialise the signed packages 
        System.setProperty( KeyStoreHelper.PROP_SIGN,
                            "" );
        System.setProperty( KeyStoreHelper.PROP_PVT_KS_URL,
                            "" );
        System.setProperty( KeyStoreHelper.PROP_PVT_KS_PWD,
                            "" );
        System.setProperty( KeyStoreHelper.PROP_PVT_ALIAS,
                            "" );
        System.setProperty( KeyStoreHelper.PROP_PVT_PWD,
                            "" );
    }

    private Package loadPackage() throws DroolsParserException,
                                 IOException {
        String source = "package org.drools.test;\n" +
                        "import org.drools.Cheese;\n" +
                        "global java.util.List results;\n" +
                        "rule \"like stilton\"\n" +
                        "    salience 50\n" +
                        "when\n" +
                        "    $cheese :Cheese( type:type == \"stilton\" )\n" +
                        "then\n" +
                        "    results.add( $cheese );\n" +
                        "end\n";
        //Compile a package
        PackageBuilder builder = new PackageBuilder();
        builder.addPackageFromDrl( new StringReader( source ) );
        Package pkg = builder.getPackage();
        return pkg;
    }

    protected Package serialisePackage(Package pkg) {
        try {
            byte[] bytes = serializeOut( pkg );
            return (Package) serializeIn( bytes );
        } catch ( Exception e ) {
            throw new RuntimeException( "trouble serialising package.",
                                        e );
        }
    }

    protected Object serializeIn(final byte[] bytes) throws IOException,
                                                    ClassNotFoundException {
        final ObjectInput in = new ObjectInputStream( new ByteArrayInputStream( bytes ) );
        final Object obj = in.readObject();
        in.close();
        return obj;
    }

    protected byte[] serializeOut(final Object obj) throws IOException {
        // Serialize to a byte array
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutput out = new ObjectOutputStream( bos );
        out.writeObject( obj );
        out.close();

        // Get the bytes of the serialized object
        final byte[] bytes = bos.toByteArray();
        return bytes;
    }
}
