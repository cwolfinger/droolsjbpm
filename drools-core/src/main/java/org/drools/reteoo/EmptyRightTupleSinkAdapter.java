package org.drools.reteoo;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public class EmptyRightTupleSinkAdapter
    implements
    RightTupletSinkPropagator {

    private static final long                       serialVersionUID = -631743913176779720L;

    private static final EmptyRightTupleSinkAdapter instance         = new EmptyRightTupleSinkAdapter();

    private static final RightTupleSink[]           SINK_LIST        = new RightTupleSink[0];

    public static EmptyRightTupleSinkAdapter getInstance() {
        return instance;
    }

    private EmptyRightTupleSinkAdapter() {
    }

    public void propagateAssertRightTuple(final InternalFactHandle handle,
                                          final PropagationContext context,
                                          final InternalWorkingMemory workingMemory) {

    }

    public RightTupleSink[] getSinks() {
        return SINK_LIST;
    }

    public int size() {
        return 0;
    }

}
