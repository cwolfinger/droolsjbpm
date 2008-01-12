package org.drools.reteoo;

import org.drools.common.InternalFactHandle;
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
                                              rightTuple,
                                              this.sink ),
                               context,
                               workingMemory );
    }

    public void propagateAssertTuple(final LeftTuple tuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
        this.sink.assertTuple( new LeftTuple( tuple,
                                              this.sink ),
                               context,
                               workingMemory );
    }
    
//    public void propagateNotRetractLeftTuple(final LeftTuple leftTuple,
//                                          final PropagationContext context,
//                                          final InternalWorkingMemory workingMemory) {
//            LeftTuple child = leftTuple.getBetaChildren();
//            while ( child != null ) {
//                //LeftTuple temp = leftTuple.getRightParentNext();
//                //child.unlinkFromParents();
//                //child.unlinkFromLeftParent();
//                child.getSink().retractTuple( child,
//                                              context,
//                                              workingMemory );
//                child = child.getLeftParentNext();
//                //child = temp;
//            }
//            leftTuple.setBetaChildren( null );
//        }    

    public void propagateRetractLeftTuple(final LeftTuple leftTuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
        LeftTuple child = leftTuple.getBetaChildren();
        while ( child != null ) {
            LeftTuple temp = child.getLeftParentNext();
            //child.unlinkFromParents();
            child.getSink().retractTuple( child,
                                          context,
                                          workingMemory );
            child.unlinkFromRightParent();            
            //child = child.getLeftParentNext();
            child = temp;
        }
        leftTuple.setBetaChildren( null );
    }
    
    public void propagateRetractRightTuple(final RightTuple rightTuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
        LeftTuple child = rightTuple.getBetaChildren();
        while ( child != null ) {
            LeftTuple temp = child.getRightParentNext();
            //child.unlinkFromParents();
            child.getSink().retractTuple( child,
                                          context,
                                          workingMemory );
            child.unlinkFromLeftParent();            
            //child = child.getRightParentNext();
            child = temp;
        }
        rightTuple.setBetaChildren( null );
    }    

    public void createAndPropagateAssertTuple(final InternalFactHandle factHandle,
                                              final PropagationContext context,
                                              final InternalWorkingMemory workingMemory) {
        this.sink.assertTuple( new LeftTuple( factHandle,
                                              this.sink ),
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
