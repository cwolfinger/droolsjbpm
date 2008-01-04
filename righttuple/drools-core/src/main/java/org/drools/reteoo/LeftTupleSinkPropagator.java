package org.drools.reteoo;

import java.io.Serializable;

import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public interface LeftTupleSinkPropagator
    extends
    Serializable {
    public void propagateAssertTuple(LeftTuple leftTuple,
                                     RightTuple rightTuple,
                                     PropagationContext context,
                                     InternalWorkingMemory workingMemory);

    public void propagateAssertTuple(LeftTuple tuple,
                                     PropagationContext context,
                                     InternalWorkingMemory workingMemory);

    public void propagateRetractTuple(LeftTuple leftTuple,
                                      RightTuple rightTuple,
                                      PropagationContext context,
                                      InternalWorkingMemory workingMemory);

    public void propagateRetractTuple(LeftTuple tuple,
                                      PropagationContext context,
                                      InternalWorkingMemory workingMemory);

    public void createAndPropagateAssertTuple(RightTuple rightTuple,
                                              PropagationContext context,
                                              InternalWorkingMemory workingMemory);

    public void createAndPropagateRetractTuple(RightTuple rightTuple,
                                               PropagationContext context,
                                               InternalWorkingMemory workingMemory);

    public LeftTupleSink[] getSinks();

    //    public void propagateNewTupleSink(TupleMatch tupleMatch,
    //                                      PropagationContext context,
    //                                      InternalWorkingMemory workingMemory);
    //
    //    public void propagateNewTupleSink(InternalFactHandle handle,
    //                                      LinkedList list,
    //                                      PropagationContext context,
    //                                      InternalWorkingMemory workingMemory);
    //
    //    public void propagateNewTupleSink(ReteTuple tuple,
    //                                      PropagationContext context,
    //                                      InternalWorkingMemory workingMemory);
    //
    //    public List getPropagatedTuples(final Map memory,
    //                                    final InternalWorkingMemory workingMemory,
    //                                    final TupleSink sink);

    public int size();

}
