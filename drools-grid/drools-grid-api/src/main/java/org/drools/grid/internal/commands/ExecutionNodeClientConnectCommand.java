package org.drools.grid.internal.commands;

import org.drools.command.Context;
import org.drools.command.impl.GenericCommand;
import org.drools.command.impl.KnowledgeCommandContext;
import org.drools.grid.internal.NodeData;
import org.drools.runtime.impl.ExecutionResultImpl;

public class ExecutionNodeClientConnectCommand
    implements
    GenericCommand<Integer> {

    private String outIdentifier;

    public ExecutionNodeClientConnectCommand(String outIdentifier) {
        this.outIdentifier = outIdentifier;
    }

    public Integer execute(Context context) {
        NodeData data = (NodeData) context.get( NodeData.NODE_DATA );

        Integer sessionId = data.getSessionIdCounter().getAndIncrement();
        if ( this.outIdentifier != null ) {
            ((ExecutionResultImpl) ((KnowledgeCommandContext) context).getExecutionResults()).getResults().put( this.outIdentifier,
                                                                                                                sessionId );
        }

        return sessionId;
    }

}
