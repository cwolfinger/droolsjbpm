package org.drools.reteoo;

import java.io.Externalizable;

import org.drools.common.BaseNode;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.RuleBasePartitionId;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.spi.PropagationContext;

public interface ObjectSinkPropagator
    extends
    Externalizable {

    public RuleBasePartitionId getPartitionId();
    
    public void propagateAssertObject(InternalFactHandle factHandle,
                                      PropagationContext context,
                                      InternalWorkingMemory workingMemory);
    
    public void propagateAssertObject(ImperfectFactHandle factHandle,
            PropagationContext context,
            InternalWorkingMemory workingMemory,
            IDegreeFactory factory,
            EvalRecord record);

    public BaseNode getMatchingNode(BaseNode candidate);

    public ObjectSink[] getSinks();

    public int size();
}
