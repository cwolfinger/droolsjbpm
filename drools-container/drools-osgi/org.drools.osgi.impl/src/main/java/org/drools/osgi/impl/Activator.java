package org.drools.osgi.impl;

import java.util.Hashtable;

import org.drools.KnowledgeBaseProvider;
import org.drools.builder.KnowledgeBuilderProvider;
import org.drools.builder.impl.KnowledgeBuilderProviderImpl;
import org.drools.impl.KnowledgeBaseProviderImpl;
import org.drools.io.ResourceProvider;
import org.drools.io.impl.ResourceProviderImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator
    implements
    BundleActivator {
    private ServiceRegistration kbuilderReg;
    private ServiceRegistration resourceReg;
    private ServiceRegistration kbaseReg;

    public void start(BundleContext bc) throws Exception {
        this.kbuilderReg = bc.registerService( KnowledgeBuilderProvider.class.getName(),
                                               new KnowledgeBuilderProviderImpl(),
                                               new Hashtable() );
        this.resourceReg = bc.registerService( ResourceProvider.class.getName(),
                                               new ResourceProviderImpl(),
                                               new Hashtable() );
        this.kbaseReg = bc.registerService( KnowledgeBaseProvider.class.getName(),
                                            new KnowledgeBaseProviderImpl(),
                                            new Hashtable() );
        System.out.println( "impl registered" );
    }

    public void stop(BundleContext bc) throws Exception {
        this.kbuilderReg.unregister();
        this.resourceReg.unregister();
        this.kbaseReg.unregister();
    }
}
