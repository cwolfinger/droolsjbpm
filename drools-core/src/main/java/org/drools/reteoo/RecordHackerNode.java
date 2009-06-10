package org.drools.reteoo;

import org.drools.common.BaseNode;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.PropagationContext;

public class RecordHackerNode extends ObjectSource 
	implements ObjectSinkNode {


	private String priorStr;
	private String operatorStr;
	
	private boolean isCutter = false;
	
	private IDegree prior = null;
	private IDegreeCombiner operator = null;
	
	private ObjectSinkNode previousRightTupleSinkNode;
	private ObjectSinkNode nextRightTupleSinkNode; 
	
	
	
	public RecordHackerNode(BuildContext context, String priorStr, String operatorStr, boolean isCutter ) {
		
		super( context.getNextId(),
	               context.getPartitionId(),
	               context.getRuleBase().getConfiguration().isMultithreadEvaluation(),
	               context.getObjectSource(),
	               context.getRuleBase().getConfiguration().getAlphaNodeHashingThreshold() );
		
		
		this.priorStr = priorStr;
		this.operatorStr = operatorStr;
		this.isCutter = isCutter;
	}
	
	public ConstraintKey getConstraintKey() {	
		return null;
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
	 
	 public void updateSink(final ObjectSink sink,
             final PropagationContext context,
             final InternalWorkingMemory workingMemory) {
		 
		 this.source.updateSink( sink,
                  context,
                  workingMemory );
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
		this.sink.propagateAssertObject(factHandle, propagationContext, workingMemory);
	}

	
	
	public void assertObject(ImperfectFactHandle factHandle,
			PropagationContext propagationContext,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord record) {
		
		if (prior == null && priorStr != null)
			prior = factory.buildDegree(this.priorStr);
		if (operator == null && operatorStr != null)
			operator = factory.getAndOperator(operatorStr);
		
		if (operator != null) 
			record.setOperator(operator);
		if (prior != null)
			record.addDegree(Evaluation.PRIOR, prior, 1, true);
		
		if (isCutter && record.getDegree().equals(factory.False()) ) {
			// DROP...
		} else {			
			this.sink.propagateAssertObject(factHandle, propagationContext,workingMemory,factory,record);
		}
	}

	
	
	
	
	 public int hashCode() {
	        return this.source.hashCode() * 17 
	        		+ ((this.priorStr != null) ? this.priorStr.hashCode() : 0)
	        		+ ((this.operatorStr != null) ? this.operatorStr.hashCode() : 0) 
	        		+ (isCutter ? 1 : -1);
	 }

	    /*
	     * (non-Javadoc)
	     *
	     * @see java.lang.Object#equals(java.lang.Object)
	     */
	    public boolean equals(final Object object) {
	        if ( this == object ) {
	            return true;
	        }

	        if ( object == null || !(object instanceof RecordHackerNode) ) {
	            return false;
	        }

	        final RecordHackerNode other = (RecordHackerNode) object;

	        return this.source.equals( other.source ) && 
	        	compareConfig(this.operatorStr, other.operatorStr) &&
	        	compareConfig(this.priorStr, other.priorStr) &&
	        	this.isCutter == other.isCutter;
	    }
	
	
	
	    boolean compareConfig(String a, String b) {
	    	if (a == null && b == null) return true;
	    	if (a != null)
	    		return a.equals(b);
	    	return false;
	    }
	
	
	
	
}
