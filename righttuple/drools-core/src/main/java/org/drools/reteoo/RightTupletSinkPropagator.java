package org.drools.reteoo;

import java.io.Serializable;

import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public interface RightTupletSinkPropagator
    extends
    Serializable {
    public void propagateAssertRightTuple(RightTuple rightTuple,
                                          PropagationContext context,
                                          InternalWorkingMemory workingMemory);

    public void propagateRetractRightTuple(RightTuple rightTuple,
                                           PropagationContext context,
                                           InternalWorkingMemory workingMemory,
                                           boolean useHash);

    public RightTupleSink[] getSinks();

    public int size();
}
