package org.drools.reteoo;

import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public class SingleLeftTupleSinkAdapter
    implements
    LeftTupleSinkPropagator {
    private LeftTupleSink sink;

    public SingleLeftTupleSinkAdapter(final LeftTupleSink sink) {
        this.sink = sink;
    }

    public void propagateAssertTuple(final LeftTuple leftTuple,
                                     final RightTuple rightTuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
        this.sink.assertTuple( new LeftTuple( leftTuple,
                                              rightTuple ),
                               context,
                               workingMemory );
    }

    public void propagateAssertTuple(final LeftTuple tuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
        this.sink.assertTuple( new LeftTuple( tuple ),
                               context,
                               workingMemory );
    }

    public void propagateRetractTuple(final LeftTuple leftTuple,
                                      final RightTuple rightTuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
        this.sink.retractTuple( new LeftTuple( leftTuple,
                                               rightTuple ),
                                context,
                                workingMemory );
    }

    public void propagateRetractTuple(final LeftTuple tuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
        this.sink.retractTuple( new LeftTuple( tuple ),
                                context,
                                workingMemory );
    }

    public void createAndPropagateAssertTuple(final RightTuple rightTuple,
                                              final PropagationContext context,
                                              final InternalWorkingMemory workingMemory) {
        this.sink.assertTuple( new LeftTuple( rightTuple ),
                               context,
                               workingMemory );
    }

    public void createAndPropagateRetractTuple(final RightTuple rightTuple,
                                               final PropagationContext context,
                                               final InternalWorkingMemory workingMemory) {
        this.sink.retractTuple( new LeftTuple( rightTuple ),
                                context,
                                workingMemory );
    }

    public LeftTupleSink[] getSinks() {
        return new LeftTupleSink[]{this.sink};
    }

    public int size() {
        return (this.sink != null) ? 1 : 0;
    }
}
