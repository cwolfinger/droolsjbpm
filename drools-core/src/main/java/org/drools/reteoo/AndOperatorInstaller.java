package org.drools.reteoo;

import org.drools.common.RuleBasePartitionId;

public class AndOperatorInstaller 
	extends OperatorInstaller 
	implements LeftTupleSink {
	
	protected LeftTupleSource source;

	
	public AndOperatorInstaller(LeftTupleSource source, int arity, int id, RuleBasePartitionId partitionId, boolean isPartitionEnabled) {
		super(source, arity, id, partitionId, isPartitionEnabled);	

	}


	

}
