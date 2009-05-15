package org.drools.reteoo;

import org.drools.common.RuleBasePartitionId;

public class DiscountOperatorInstaller 
	extends OperatorInstaller 
	implements LeftTupleSink {
	
	protected LeftTupleSource source;

	
	public DiscountOperatorInstaller(LeftTupleSource source, int arity, int id, RuleBasePartitionId partitionId, boolean isPartitionEnabled) {
		super(source, arity, id, partitionId, isPartitionEnabled);	

	}


	

}
