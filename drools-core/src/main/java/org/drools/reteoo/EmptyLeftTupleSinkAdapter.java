package org.drools.reteoo;

import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public class EmptyLeftTupleSinkAdapter
    implements
    LeftTupleSinkPropagator {

    private static final EmptyLeftTupleSinkAdapter instance = new EmptyLeftTupleSinkAdapter();

    public static final EmptyLeftTupleSinkAdapter getInstance() {
        return instance;
    }

    private EmptyLeftTupleSinkAdapter() {
    }

    public void propagateAssertTuple(final LeftTuple leftTuple,
                                     final RightTuple rightTuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
    }

    public void propagateAssertTuple(final LeftTuple tuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
    }

    public void propagateRetractTuple(final LeftTuple tuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
    }

    public void createAndPropagateAssertTuple(final RightTuple rightTuple,
                                              final PropagationContext context,
                                              final InternalWorkingMemory workingMemory) {
    }

    public void createAndPropagateRetractTuple(final RightTuple rightTuple,
                                               final PropagationContext context,
                                               final InternalWorkingMemory workingMemory) {
    }

    public LeftTupleSink[] getSinks() {
        return new LeftTupleSink[]{};
    }

    public int size() {
        return 0;
    }

    public void propagateRetractLeftTuple(LeftTuple tuple,
                                          PropagationContext context,
                                          InternalWorkingMemory workingMemory) {
        // TODO Auto-generated method stub
        
    }

    public void propagateRetractRightTuple(RightTuple tuple,
                                           PropagationContext context,
                                           InternalWorkingMemory workingMemory) {
        // TODO Auto-generated method stub
        
    }
}
