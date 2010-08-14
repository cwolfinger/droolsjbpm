package org.drools.grid.remote;

import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.ResourceConfiguration;
import org.drools.builder.ResourceType;
//import org.drools.command.FinishedCommand;
import org.drools.command.KnowledgeContextResolveFromContextCommand;
import org.drools.command.builder.KnowledgeBuilderAddCommand;
import org.drools.command.builder.KnowledgeBuilderGetErrorsCommand;
import org.drools.command.builder.KnowledgeBuilderHasErrorsCommand;
import org.drools.definition.KnowledgePackage;
import org.drools.io.Resource;
import org.drools.runtime.ExecutionResults;
import org.drools.grid.internal.CollectionClient;
import org.drools.grid.GenericNodeConnector;
import org.drools.grid.internal.Message;
import org.drools.grid.internal.MessageSession;

public class KnowledgeBuilderRemoteClient
    implements
    KnowledgeBuilder {
    
    private String                     instanceId;
    private final GenericNodeConnector connector;
    private final MessageSession messageSession;

    public KnowledgeBuilderRemoteClient(String instanceId,
                                        GenericNodeConnector connector, MessageSession messageSession) {
        this.instanceId = instanceId;
        this.connector = connector;
        this.messageSession = messageSession;
    }

    public void add(Resource resource,
                    ResourceType resourceType) {
        add( resource,
             resourceType,
             null );
    }

    public void add(Resource resource,
                    ResourceType resourceType,
                    ResourceConfiguration configuration) {
        Message msg = new Message( messageSession.getSessionId(),
                                   messageSession.counter.incrementAndGet(),
                                   false,
                                   new KnowledgeContextResolveFromContextCommand( new KnowledgeBuilderAddCommand( resource,
                                                                                                                  resourceType,
                                                                                                                  configuration ),
                                                                                  instanceId,
                                                                                  null,
                                                                                  null,
                                                                                  null ) );

        try {
            connector.connect();
            Object object = connector.write( msg ).getPayload();

//            if ( !(object instanceof FinishedCommand) ) {
//                throw new RuntimeException( "Response was not correctly ended" );
//            }
            connector.disconnect();
        } catch ( Exception e ) {
            throw new RuntimeException( "Unable to execute message",
                                        e );
        }

    }

    public KnowledgeBuilderErrors getErrors() {
        String commandId = "kbuilder.getErrors_" + messageSession.getNextId();
        String kresultsId = "kresults_" + messageSession.getSessionId();

        Message msg = new Message( messageSession.getSessionId(),
                                   messageSession.counter.incrementAndGet(),
                                   false,
                                   new KnowledgeContextResolveFromContextCommand( new KnowledgeBuilderGetErrorsCommand( commandId ),
                                                                                  instanceId,
                                                                                  null,
                                                                                  null,
                                                                                  kresultsId ) );

        try {
            connector.connect();
            Object object = connector.write( msg ).getPayload();

            if ( object == null ) {
                throw new RuntimeException( "Response was not correctly received" );
            }
            connector.disconnect();
            return (KnowledgeBuilderErrors) ((ExecutionResults) object).getValue( commandId );            

        } catch ( Exception e ) {
            throw new RuntimeException( "Unable to execute message",
                                        e );
        }
        
    }

    public Collection<KnowledgePackage> getKnowledgePackages() {
        return new CollectionClient<KnowledgePackage>( this.instanceId );
    }

    public boolean hasErrors() {
        String commandId = "kbuilder.hasErrors_" + messageSession.getNextId();
        String kresultsId = "kresults_" + messageSession.getSessionId();

        Message msg = new Message( messageSession.getSessionId(),
                                   messageSession.getNextId(),
                                   false,
                                   new KnowledgeContextResolveFromContextCommand( new KnowledgeBuilderHasErrorsCommand( commandId ),
                                                                                  instanceId,
                                                                                  null,
                                                                                  null,
                                                                                  kresultsId ) );

        try {
            connector.connect();
            Object object = connector.write( msg ).getPayload();

            if ( object == null ) {
                throw new RuntimeException( "Response was not correctly received" );
            }
            connector.disconnect();
            //return (Boolean) ((ExecutionResults) object).getValue( commandId );
            return (Boolean) object;

        } catch ( Exception e ) {
            throw new RuntimeException( "Unable to execute message",
                                        e );
        }
        
        
        
    }

	public KnowledgeBase newKnowledgeBase() {
		// TODO Auto-generated method stub
		return null;
	}

}
