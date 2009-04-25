package org.drools.reteoo;

import org.drools.RuntimeDroolsException;
import org.drools.common.BaseNode;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.NegationOperator;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.AlphaNodeFieldConstraint;
import org.drools.spi.PropagationContext;

public class PatternNegator extends ObjectSource 
	implements ObjectSinkNode {
	
	private ObjectSinkNode      previousRightTupleSinkNode;
    private ObjectSinkNode      nextRightTupleSinkNode;
	

	
    public PatternNegator(final int id,            
            final ObjectSource objectSource,
            final BuildContext context) {
    	super( id,
                context.getPartitionId(),
                context.getRuleBase().getConfiguration().isMultithreadEvaluation(),
                objectSource,
                context.getRuleBase().getConfiguration().getAlphaNodeHashingThreshold() );
    }
    
	public ConstraintKey getConstraintKey() {
		throw new RuntimeDroolsException("Wrapper does not have a key");
	}

	
	public void updateSink(ObjectSink sink, PropagationContext context,
			InternalWorkingMemory workingMemory) {		
		this.source.updateSink(sink, context, workingMemory);
	}

	
	public void attach() {
        this.source.addObjectSink( this );
    }

    public void attach(final InternalWorkingMemory[] workingMemories) {
        attach();

        for ( int i = 0, length = workingMemories.length; i < length; i++ ) {
            final InternalWorkingMemory workingMemory = workingMemories[i];
            final PropagationContext propagationContext = new PropagationContextImpl( workingMemory.getNextPropagationIdCounter(),
                                                                                      PropagationContext.RULE_ADDITION, 
                                                                                      
                                                                                      null,
                                                                                      null,
                                                                                      null );
            this.source.updateSink( this,
                                    propagationContext,
                                    workingMemory );
        }
    }


    protected void doRemove(final RuleRemovalContext context,
            final ReteooBuilder builder,
            final BaseNode node,
            final InternalWorkingMemory[] workingMemories) {
    	if ( !node.isInUse() ) {
    		removeObjectSink( (ObjectSink) node );
    	}
    	
    	this.source.remove( context,
    			builder,
    			this,
    			workingMemories );
    }


	/**
     * Returns the next node
     * @return
     *      The next ObjectSinkNode
     */
    public ObjectSinkNode getNextObjectSinkNode() {
        return this.nextRightTupleSinkNode;
    }

    /**
     * Sets the next node
     * @param next
     *      The next ObjectSinkNode
     */
    public void setNextObjectSinkNode(final ObjectSinkNode next) {
        this.nextRightTupleSinkNode = next;
    }

    /**
     * Returns the previous node
     * @return
     *      The previous ObjectSinkNode
     */
    public ObjectSinkNode getPreviousObjectSinkNode() {
        return this.previousRightTupleSinkNode;
    }

    /**
     * Sets the previous node
     * @param previous
     *      The previous ObjectSinkNode
     */
    public void setPreviousObjectSinkNode(final ObjectSinkNode previous) {
        this.previousRightTupleSinkNode = previous;
    }


	
	
	public void assertObject(InternalFactHandle factHandle,
			PropagationContext propagationContext,
			InternalWorkingMemory workingMemory) {
		//throw new RuntimeDroolsException("Patterns can be negated only using imperfection");
		this.sink.propagateAssertObject(factHandle, propagationContext, workingMemory);
	}


	public void assertObject(ImperfectFactHandle factHandle,
			PropagationContext propagationContext,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord record) {
		
		IDegreeCombiner oldOp = record.getOperator();
		NegationOperator negOp = (NegationOperator) factory.getNegationOperator();
			negOp.setOperator(oldOp); 
		record.setOperator( negOp );
		record.setKey(record.getKey().cloneReplace(oldOp.getName(),negOp.getName()));
		record.combine();
		
		this.sink.propagateAssertObject(factHandle, propagationContext, workingMemory, factory, record);
		
	}
	
	

}
