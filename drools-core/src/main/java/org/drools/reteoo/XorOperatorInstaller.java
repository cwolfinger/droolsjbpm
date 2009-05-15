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

public class XorOperatorInstaller 
	extends OperatorInstaller 
	implements LeftTupleSink {
	
	protected LeftTupleSource source;

	
	public XorOperatorInstaller(LeftTupleSource source, int arity, int id, RuleBasePartitionId partitionId, boolean isPartitionEnabled) {
		super(source, arity, id, partitionId, isPartitionEnabled);		
	}


}
	