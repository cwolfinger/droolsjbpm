package org.drools.reteoo;

import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

public class CompositeTupleSinkAdapter
    implements
    LeftTupleSinkPropagator {
    private LeftTupleSinkNodeList sinks;

    public CompositeTupleSinkAdapter() {
        this.sinks = new LeftTupleSinkNodeList();
    }

    public void addTupleSink(final LeftTupleSink sink) {
        this.sinks.add( (LeftTupleSinkNode) sink );
    }

    public void removeTupleSink(final LeftTupleSink sink) {
        this.sinks.remove( (LeftTupleSinkNode) sink );
    }

    public void propagateAssertTuple(final LeftTuple leftTuple,
                                     final RightTuple rightTuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {

        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sink.assertTuple( new LeftTuple( leftTuple,
                                             rightTuple ),
                              context,
                              workingMemory );
        }
    }

    public void propagateAssertTuple(final LeftTuple tuple,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sink.assertTuple( new LeftTuple( tuple ),
                              context,
                              workingMemory );
        }
    }

    public void propagateRetractTuple(final LeftTuple leftTuple,
                                      final RightTuple rightTuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sink.retractTuple( new LeftTuple( leftTuple,
                                              rightTuple ),
                               context,
                               workingMemory );
        }
    }

    public void propagateRetractTuple(final LeftTuple tuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sink.retractTuple( new LeftTuple( tuple ),
                               context,
                               workingMemory );
        }
    }

    public void createAndPropagateAssertTuple(final RightTuple rightTuple,
                                              final PropagationContext context,
                                              final InternalWorkingMemory workingMemory) {
        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sink.assertTuple( new LeftTuple( rightTuple ),
                              context,
                              workingMemory );
        }
    }

    public void createAndPropagateRetractTuple(final RightTuple rightTuple,
                                               final PropagationContext context,
                                               final InternalWorkingMemory workingMemory) {
        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sink.retractTuple( new LeftTuple( rightTuple ),
                               context,
                               workingMemory );
        }
    }

    public LeftTupleSink[] getSinks() {
        final LeftTupleSink[] sinkArray = new LeftTupleSink[this.sinks.size()];

        int i = 0;
        for ( LeftTupleSinkNode sink = this.sinks.getFirst(); sink != null; sink = sink.getNextLeftTupleSinkNode() ) {
            sinkArray[i++] = sink;
        }

        return sinkArray;
    }

    //    public void propagateNewTupleSink(TupleMatch tupleMatch,
    //                                      PropagationContext context,
    //                                      InternalWorkingMemory workingMemory) {
    //
    //        final TupleSink sink = sinks.getLast();
    //        final ReteTuple tuple = new ReteTuple( tupleMatch.getTuple(),
    //                                               tupleMatch.getObjectMatches().getFactHandle(),
    //                                               sink );
    //        tupleMatch.addJoinedTuple( tuple );
    //        tuple.assertTuple( context,
    //                           workingMemory );
    //    }
    //
    //    public void propagateNewTupleSink(ReteTuple tuple,
    //                                      PropagationContext context,
    //                                      InternalWorkingMemory workingMemory) {
    //
    //        final TupleSink sink = sinks.getLast();
    //        ReteTuple child = new ReteTuple( tuple,
    //                                         sink );
    //        tuple.addChildEntry( child );
    //        child.assertTuple( context,
    //                           workingMemory );
    //    }
    //
    //    public void propagateNewTupleSink(InternalFactHandle handle,
    //                                      LinkedList list,
    //                                      PropagationContext context,
    //                                      InternalWorkingMemory workingMemory) {
    //        TupleSink sink = this.sinks.getLast();
    //        ReteTuple tuple = new ReteTuple( handle,
    //                                         sink );
    //        list.add( new LinkedListEntry( tuple ) );
    //        tuple.assertTuple( context,
    //                           workingMemory );
    //    }
    //
    //    /**
    //     * @inheritDoc
    //     */
    //    public List getPropagatedTuples(final Map memory,
    //                                    final InternalWorkingMemory workingMemory,
    //                                    final TupleSink sink) {
    //        int index = 0;
    //        for ( TupleSinkNode node = this.sinks.getFirst(); node != null; node = node.getNextTupleSinkNode() ) {
    //            if ( node.equals( sink ) ) {
    //                break;
    //            }
    //            index++;
    //        }
    //
    //        final List propagatedTuples = new ArrayList( memory.size() );
    //
    //        for ( final Iterator it = memory.values().iterator(); it.hasNext(); ) {
    //            final LinkedList tuples = (LinkedList) it.next();
    //            LinkedListEntry wrapper = (LinkedListEntry) tuples.getFirst();
    //            for ( int i = 0; i < index; i++ ) {
    //                wrapper = (LinkedListEntry) wrapper.getNext();
    //            }
    //            propagatedTuples.add( wrapper.getObject() );
    //        }
    //
    //        return propagatedTuples;
    //    }

    public int size() {
        return this.sinks.size();
    }
}
