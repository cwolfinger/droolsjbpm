package org.drools.reteoo;

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

    public void propagateAssertRightTuple(final RightTuple rightTuple,
                                          final PropagationContext context,
                                          final InternalWorkingMemory workingMemory) {
        this.sink.assertRightTuple( new RightTuple( rightTuple ),
                                    context,
                                    workingMemory );

    }

    public void propagateRetractRightTuple(final RightTuple rightTuple,
                                           final PropagationContext context,
                                           final InternalWorkingMemory workingMemory,
                                           final boolean useHash) {
        //rightTuple.unlinkFromRightParent();
        this.sink.retractRightTuple( rightTuple.getAlphaChildren(),
                                     context,
                                     workingMemory );              
        rightTuple.setAlphaChildren( null );        
    }

    public RightTupleSink[] getSinks() {
        return new RightTupleSink[]{this.sink};
    }

    public int size() {
        return 1;
    }

}
