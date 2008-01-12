package org.drools.reteoo;

import java.io.Serializable;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public interface RightTupletSinkPropagator
    extends
    Serializable {
    public void propagateAssertRightTuple(InternalFactHandle handle,
                                          PropagationContext context,
                                          InternalWorkingMemory workingMemory);

    public RightTupleSink[] getSinks();

    public int size();
}
