package org.drools.reteoo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


import org.drools.RuntimeDroolsException;
import org.drools.common.BaseNode;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.common.RuleBasePartitionId;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.AccumulateNode.AccumulateMemory;
import org.drools.reteoo.CollectNode.CollectMemory;
import org.drools.spi.PropagationContext;
import org.drools.spi.Tuple;
import org.drools.util.Iterator;

public class OrOperatorInstaller 
	extends OperatorInstaller 
	implements LeftTupleSink {
	
	protected LeftTupleSource source;

	
	public OrOperatorInstaller(LeftTupleSource source, int arity, int id, RuleBasePartitionId partitionId, boolean isPartitionEnabled) {
		super(source, arity, id, partitionId, isPartitionEnabled);		
	}
	
	
	
//
//	public void assertLeftTuple(ImperfectLeftTuple leftTuple,
//			PropagationContext context, InternalWorkingMemory workingMemory,
//			IDegreeFactory factory) {
//		EvalRecord record = leftTuple.getRecord();
//			record.setOperator(factory.getOrOperator());
//			record.setNodeId(this.getId());
//		
//		this.getSinkPropagator().propagateAssertLeftTuple(
//				leftTuple, 
//				context, 
//				workingMemory, 
//				factory,
//				record,
//				false);
//	}

	
	
	

	

	
	
	
	
	

	
	
}
