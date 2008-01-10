package org.drools.reteoo;

/*
 * Copyright 2005 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.drools.common.BetaConstraints;
import org.drools.common.EmptyBetaConstraints;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.PropagationContext;
import org.drools.util.Iterator;

/**
 * <code>NotNode</code> extends <code>BetaNode</code> to perform tests for
 * the non existence of a Fact plus one or more conditions. Where none existence
 * is found the left ReteTuple is copied and propgated. Further to this it
 * maintains the "truth" by cancelling any
 * <code>Activation<code>s that are nolonger 
 * considered true by the assertion of ReteTuple's or FactHandleImpl.  Tuples are considered to be asserted from the left input and facts from the right input.
 * The <code>BetaNode</code> provides the BetaMemory to store assserted ReteTuples and <code>FactHandleImpl<code>s. Each fact handle is stored in the right 
 * memory as a key in a <code>HashMap</code>, the value is an <code>ObjectMatches</code> instance which maintains a <code>LinkedList of <code>TuplesMatches - 
 * The tuples that are matched with the handle. the left memory is a <code>LinkedList</code> of <code>ReteTuples</code> which maintains a <code>HashMa</code>, 
 * where the keys are the matching <code>FactHandleImpl</code>s and the value is populated <code>TupleMatche</code>es, the keys are matched fact handles. 
 * <code>TupleMatch</code> maintains a <code>List</code> of resulting joins, where there is joined <code>ReteTuple</code> per <code>TupleSink</code>.
 * 
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public class NotNode extends BetaNode {

    private static final long serialVersionUID = 400L;
    static int                notAssertObject  = 0;
    static int                notAssertTuple   = 0;

    // ------------------------------------------------------------
    // Instance methods
    // ------------------------------------------------------------

    /**
     * Construct.
     * 
     * @param leftInput
     *            The left input <code>TupleSource</code>.
     * @param rightInput
     *            The right input <code>TupleSource</code>.
     */
    public NotNode(final int id,
                   final LeftTupleSource leftInput,
                   final RightTupleSource rightInput,
                   final BetaConstraints joinNodeBinder,
                   final BuildContext context) {
        super( id,
               leftInput,
               rightInput,
               joinNodeBinder );
        this.tupleMemoryEnabled = context.isTupleMemoryEnabled();
    }

    /**
     * Assert a new <code>ReteTuple</code> from the left input. It iterates
     * over the right <code>FactHandleImpl</code>'s if no matches are found
     * the a copy of the <code>ReteTuple</code> is made and propagated.
     * 
     * @param tuple
     *            The <code>Tuple</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void assertTuple(final LeftTuple leftTuple,
                            final PropagationContext context,
                            final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        this.constraints.updateFromTuple( workingMemory,
                                          leftTuple );

        for ( RightTuple rightTuple = memory.getRightTupleMemory().getLast( leftTuple ); rightTuple != null; rightTuple = (RightTuple) rightTuple.getPrevious() ) {
            if ( this.constraints.isAllowedCachedLeft( rightTuple.getHandle() ) ) {

                leftTuple.setBlocker( rightTuple );

                LeftTuple blockedPrevious = rightTuple.getBlocked();
                if ( blockedPrevious != null ) {
                    leftTuple.setBlockedNext( blockedPrevious );
                    blockedPrevious.setBlockedPrevious( leftTuple );
                }
                rightTuple.setBlocked( leftTuple );

                break;
            }
        }
        
        this.constraints.resetTuple();     

        if ( leftTuple.getBlocker() == null ) {
            // only add it to node memory if still need Objects to attempt to match
            if ( this.tupleMemoryEnabled ) {
                memory.getLeftTupleMemory().add( leftTuple );
            }

            this.sink.propagateAssertTuple( leftTuple,
                                            context,
                                            workingMemory );
        }
    }

    /**
     * Assert a new <code>FactHandleImpl</code> from the right input. If it
     * matches any left ReteTuple's that already has propagations then those
     * propagations are retracted.
     * 
     * @param rightTuple
     *            The <code>FactHandleImpl</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void assertRightTuple(final RightTuple rightTuple,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        memory.getRightTupleMemory().add( rightTuple );

        if ( !this.tupleMemoryEnabled ) {
            // do nothing here, as we know there are no left tuples at this stage in sequential mode.
            return;
        }

        this.constraints.updateFromRightTuple( workingMemory,
                                               rightTuple );

        for ( LeftTuple leftTuple = memory.getLeftTupleMemory().getFirst( rightTuple ); leftTuple != null; leftTuple = (LeftTuple) leftTuple.getNext() ) {
            // we know that only unblocked LeftTuples are  still in the memory
            if ( this.constraints.isAllowedCachedRight( leftTuple ) ) {
                leftTuple.setBlocker( rightTuple );

                LeftTuple blockedPrevious = rightTuple.getBlocked();
                if ( blockedPrevious != null ) {
                    leftTuple.setBlockedNext( blockedPrevious );
                    blockedPrevious.setBlockedPrevious( leftTuple );
                }
                rightTuple.setBlocked( leftTuple );

                LeftTuple temp = (LeftTuple) leftTuple.getPrevious();
                // this is now blocked so remove from memory
                memory.getLeftTupleMemory().remove( leftTuple );

                if ( leftTuple.getBetaChildren() != null ) {
                    this.sink.propagateRetractLeftTuple( leftTuple,
                                                         context,
                                                         workingMemory );
                }
            }
        }
        
        this.constraints.resetFactHandle();       
    }

    /**
     * Retract the <code>FactHandleImpl</code>. If the handle has any
     * <code>ReteTuple</code> matches then those matches copied are propagated
     * as new joins.
     * 
     * @param rightTuple
     *            the <codeFactHandleImpl</code> being retracted
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     * @throws AssertionException
     */
    public void retractRightTuple(final RightTuple rightTuple,
                                  final PropagationContext context,
                                  final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

               
        if ( rightTuple.getBlocked() == null ) {
            memory.getRightTupleMemory().remove( rightTuple );
            return;
        }
        
        // assign now, so we can remove from memory before doing any possible propagations
        final RightTuple rootBlocker = (RightTuple) rightTuple.getPrevious();        

        for ( LeftTuple leftTuple = (LeftTuple) rightTuple.getBlocked(); leftTuple != null; leftTuple = (LeftTuple) leftTuple.getBlockedNext() ) {
            leftTuple.setBlocker( null );
            LeftTuple previousBlocked = leftTuple.getBlockedPrevious();
            if ( previousBlocked != null ) {
                previousBlocked.setBlockedNext( null );
            }
            leftTuple.setBlockedPrevious ( null );
            
            this.constraints.updateFromTuple( workingMemory,
                                              leftTuple );

            // we know that older tuples have been checked so continue previously
            for ( RightTuple newBlocker = rootBlocker; newBlocker != null; newBlocker = (RightTuple) newBlocker.getPrevious() ) {
                if ( this.constraints.isAllowedCachedLeft( newBlocker.getHandle() ) ) {
                    leftTuple.setBlocker( newBlocker );

                    LeftTuple blockedPrevious = newBlocker.getBlocked();
                    if ( blockedPrevious != null ) {
                        leftTuple.setBlockedNext( blockedPrevious );
                        blockedPrevious.setBlockedPrevious( leftTuple );
                    }
                    newBlocker.setBlocked( leftTuple );

                    break;
                }
            }
            
            if ( leftTuple.getBlocker() == null ) {
                // was previous blocked and not in memory, so add
                memory.getLeftTupleMemory().add( leftTuple );

                this.sink.propagateAssertTuple( leftTuple,
                                                context,
                                                workingMemory );
            }            
        }
    }

    /**
     * Retract the
     * <code>ReteTuple<code>, any resulting proppagated joins are also retracted. 
     * 
     * @param key
     *            The tuple key.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void retractTuple(final LeftTuple leftTuple,
                             final PropagationContext context,
                             final InternalWorkingMemory workingMemory) {
        RightTuple blocker = leftTuple.getBlocker();
        if ( blocker == null ) {
            final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
            memory.getLeftTupleMemory().remove( leftTuple );            
            
            this.sink.propagateRetractLeftTuple( leftTuple,
                                                 context,
                                                 workingMemory );
        } else {
            LeftTuple previous = (LeftTuple) leftTuple.getBlockedPrevious();
            LeftTuple next = (LeftTuple) leftTuple.getBlockedNext();
            if ( previous != null && next != null ) {
                //remove  from middle
                previous.setBlockedNext( next );
                next.setBlockedPrevious( previous );
            } else if ( next != null ) {
                //remove from first
                blocker.setBlocked( next );
                next.setBlockedPrevious( null );
            } else if ( previous != null ) {
                //remove from end
                previous.setBlockedNext( null );
            } else {
                blocker.setBlocked( null );
            }
        }
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNode#updateNewNode(org.drools.reteoo.WorkingMemoryImpl, org.drools.spi.PropagationContext)
     */
    public void updateSink(final LeftTupleSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        final Iterator tupleIter = memory.getLeftTupleMemory().iterator();
        //        for ( LeftTuple tuple = (LeftTuple) tupleIter.next(); tuple != null; tuple = (LeftTuple) tupleIter.next() ) {
        //            if ( tuple.getBlockers() == null ) {
        //                sink.assertTuple( new LeftTuple( tuple ),
        //                                  context,
        //                                  workingMemory );
        //            }
        //        }
    }

    public String toString() {
        RightTupleSource source = this.rightInput;
        while ( !(source instanceof ObjectTypeNode) ) {
            source = source.objectSource;
        }

        return "[NotNode - " + ((ObjectTypeNode) source).getObjectType() + "]";
    }
}
