package org.drools.reteoo;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public class SingleRightTupletSinkAdapter
    implements
    RightTupletSinkPropagator {

    private static final long serialVersionUID = 873985743021L;

    private RightTupleSink    sink;

    public SingleRightTupletSinkAdapter(final RightTupleSink sink) {
        this.sink = sink;
    }

    public void propagateAssertRightTuple(final InternalFactHandle factHandle,
                                          final PropagationContext context,
                                          final InternalWorkingMemory workingMemory) {
        this.sink.assertRightTuple( factHandle,
                                    context,
                                    workingMemory );

    }

    public RightTupleSink[] getSinks() {
        return new RightTupleSink[]{this.sink};
    }

    public int size() {
        return 1;
    }

}
