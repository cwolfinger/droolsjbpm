package org.drools.reteoo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


import org.drools.RuntimeDroolsException;
import org.drools.common.BaseNode;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.common.RuleBasePartitionId;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.reteoo.AccumulateNode.AccumulateMemory;
import org.drools.reteoo.CollectNode.CollectMemory;
import org.drools.spi.PropagationContext;
import org.drools.spi.Tuple;
import org.drools.util.Iterator;

public abstract class OperatorInstaller 
	extends LeftTupleSource 
	implements LeftTupleSink {
	
	protected LeftTupleSource source;
	
	protected int arity;
	
	private CompositeEvaluationTemplate template;

	public OperatorInstaller(LeftTupleSource source, int arity, int id, RuleBasePartitionId partitionId, boolean isPartitionEnabled) {
		super(id, partitionId, isPartitionEnabled);
		this.arity = arity;
		this.source = source;
		
	}
	
	public EvaluationTemplate buildEvaluationTemplate(IDegreeCombiner operator, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
						
		template = new CompositeEvaluationTemplate( this.getId(),
													new DynamicConstraintKey(operator.getName()),													
													null,
													getArity(),
													operator,
													mergeStrat,
													nullStrat
													);
					
		return template;
	}
	
	public CompositeEvaluationTemplate getTemplate() {
		return template;
	}
	
	
	public void updateSink(LeftTupleSink sink, PropagationContext context,
			InternalWorkingMemory workingMemory) {
		//DO nothing as this is only a transit node?
	}
	
	
	protected int getArity() {
		return arity;
	}

	public void attach() {
		this.source.addTupleSink(this);
	}

	public void networkUpdated() {
		this.source.networkUpdated();
	}

		
	public void attach(InternalWorkingMemory[] workingMemories) {
		for ( int i = 0, length = workingMemories.length; i < length; i++ ) {
            final InternalWorkingMemory workingMemory = workingMemories[i];
            final PropagationContext propagationContext = new PropagationContextImpl( 
            		workingMemory.getNextPropagationIdCounter(),
            		PropagationContext.RULE_ADDITION,
            		null,
            		null,
            		null );
                                   
            this.source.updateSink( this,
                                    propagationContext,
                                    workingMemory );
        }
	}

	
	protected void doRemove(RuleRemovalContext context, ReteooBuilder builder,
			BaseNode node, InternalWorkingMemory[] workingMemories) {
		
		context.visitTupleSource( this );
        if ( !node.isInUse() ) {
            removeTupleSink( (LeftTupleSink) node );
        }
                        
        if ( !context.alreadyVisited( this.source ) ) {
            this.source.remove( context,
            		builder,
            		this,
            		workingMemories );
        }
		
	}

	
	
	
	
	
	
	
	public void assertLeftTuple(LeftTuple leftTuple,
			PropagationContext context, InternalWorkingMemory workingMemory) {
		throw new RuntimeDroolsException("Operator nodes are supported only with imperfect reasoning");
	}
	
	
	public short getType() {
		return NodeTypeEnums.Imperfect_OperatorNode;
	}

	

	

		

	public void assertLeftTuple(ImperfectLeftTuple leftTuple,
			PropagationContext context, InternalWorkingMemory workingMemory,
			IDegreeFactory factory) {
		EvalRecord record = leftTuple.getRecord();
		int M = record.getOperands().size();
		int N = getArity();
						
		record.replace((CompositeEvaluation) getTemplate().spawn(N),N);
		
				
		
		this.getSinkPropagator().propagateAssertLeftTuple(
				leftTuple, 
				context, 
				workingMemory, 
				factory,
				record,
				false);
	}

	
	
	
	
	
	
	
	
	
	
	public boolean isLeftTupleMemoryEnabled() {	
		return false;
	}
			
	public void retractLeftTuple(LeftTuple leftTuple,
			PropagationContext context, InternalWorkingMemory workingMemory) {
		//TODO
		//Nothing to do yet
	}

	public void setLeftTupleMemoryEnabled(boolean tupleMemoryEnabled) {
		//TODO
		//Nothing to do, no memory here. YET		
	}

	
	public ConstraintKey[] getConstraintKeys() {
		return new ConstraintKey[] {template.getConstraintKey()};
	}
	
	public LeftTupleSource getParentSource() {
    	return this.source;
    }
	
}
