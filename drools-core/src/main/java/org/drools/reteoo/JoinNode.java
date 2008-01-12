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
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.PropagationContext;
import org.drools.util.Iterator;

/**
 * <code>JoinNode</code> extends <code>BetaNode</code> to perform
 * <code>ReteTuple</code> and <code>FactHandle</code> joins. Tuples are
 * considered to be asserted from the left input and facts from the right input.
 * The <code>BetaNode</code> provides the BetaMemory to store assserted
 * ReteTuples and
 * <code>FactHandleImpl<code>s. Each fact handle is stored in the right memory as a key in a <code>HashMap</code>, the value is an <code>ObjectMatches</code> 
 * instance which maintains a <code>LinkedList of <code>TuplesMatches - The tuples that are matched with the handle. the left memory is a <code>LinkedList</code> 
 * of <code>ReteTuples</code> which maintains a <code>HashMa</code>, where the keys are the matching <code>FactHandleImpl</code>s and the value is 
 * populated <code>TupleMatche</code>es, the keys are matched fact handles. <code>TupleMatch</code> maintains a <code>List</code> of resulting joins, 
 * where there is joined <code>ReteTuple</code> per <code>TupleSink</code>.
 *  
 * 
 * The BetaNode provides
 * the BetaMemory which stores the 
 * 
 * @see BetaNode
 * @see ObjectMatches
 * @see TupleMatch
 * @see LeftTupleSink
 * 
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public class JoinNode extends BetaNode {
    // ------------------------------------------------------------
    // Instance methods
    // ------------------------------------------------------------

    /**
     * 
     */
    private static final long serialVersionUID = 400L;

    public JoinNode(final int id,
                    final LeftTupleSource leftInput,
                    final RightTupleSource rightInput,
                    final BetaConstraints binder,
                    final BuildContext context) {
        super( id,
               leftInput,
               rightInput,
               binder );
        tupleMemoryEnabled = context.isTupleMemoryEnabled();
    }

    /**
     * Assert a new <code>ReteTuple</code>. The right input of
     * <code>FactHandleInput</code>'s is iterated and joins attemped, via the
     * binder, any successful bindings results in joined tuples being created
     * and propaged. there is a joined tuple per TupleSink.
     * 
     * @see LeftTuple
     * @see ObjectMatches
     * @see LeftTupleSink
     * @see TupleMatch
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

        if ( this.tupleMemoryEnabled ) {
            memory.getLeftTupleMemory().add( leftTuple );
        }

        this.constraints.updateFromTuple( workingMemory,
                                          leftTuple );

        for ( RightTuple rightTuple = memory.getRightTupleMemory().getFirst( leftTuple ); rightTuple != null; rightTuple = (RightTuple) rightTuple.getNext() ) {
            if ( this.constraints.isAllowedCachedLeft( rightTuple.getHandle() ) ) {
                this.sink.propagateAssertTuple( leftTuple,
                                                rightTuple,
                                                context,
                                                workingMemory );
            }
        }

        this.constraints.resetTuple();
    }

    /**
     * Assert a new <code>FactHandleImpl</code>. The left input of
     * <code>ReteTuple</code>s is iterated and joins attemped, via the
     * binder, any successful bindings results in joined tuples being created
     * and propaged. there is a joined tuple per TupleSink.
     * 
     * @see LeftTuple
     * @see ObjectMatches
     * @see LeftTupleSink
     * @see TupleMatch
     * 
     * @param rightTuple
     *            The <code>FactHandleImpl</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void assertRightTuple(final InternalFactHandle factHandle,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        RightTuple rightTuple = new RightTuple( factHandle,
                                                this );

        //new RightTuple()

        memory.getRightTupleMemory().add( rightTuple );
        if ( !this.tupleMemoryEnabled ) {
            // do nothing here, as we know there are no left tuples at this stage in sequential mode.
            return;
        }

        this.constraints.updateFromRightTuple( workingMemory,
                                               rightTuple );
        for ( LeftTuple leftTuple = memory.getLeftTupleMemory().getFirst( rightTuple ); leftTuple != null; leftTuple = (LeftTuple) leftTuple.getNext() ) {
            if ( this.constraints.isAllowedCachedRight( leftTuple ) ) {
                this.sink.propagateAssertTuple( leftTuple,
                                                rightTuple,
                                                context,
                                                workingMemory );
            }
        }
        this.constraints.resetFactHandle();
    }

    /**
     * Retract a FactHandleImpl. Iterates the referenced TupleMatches stored in
     * the handle's ObjectMatches retracting joined tuples.
     * 
     * @param rightTuple
     *            the <codeFactHandleImpl</code> being retracted
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void retractRightTuple(final RightTuple rightTuple,
                                  final PropagationContext context,
                                  final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        memory.getRightTupleMemory().remove( rightTuple );
        
        if ( rightTuple.getBetaChildren() != null ) {
            this.sink.propagateRetractRightTuple( rightTuple,
                                                  context,
                                                  workingMemory );
        }
    }

    /**
     * Retract a <code>ReteTuple</code>. Iterates the referenced
     * <code>TupleMatche</code>'s stored in the tuples <code>Map</code>
     * retracting all joined tuples.
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
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        memory.getLeftTupleMemory().remove( leftTuple );
        if ( leftTuple.getBetaChildren() != null ) {
            this.sink.propagateRetractLeftTuple( leftTuple,
                                                 context,
                                                 workingMemory );
        }

        //        final Iterator it = memory.getRightTupleMemory().iterator( leftTuple );
        //        this.constraints.updateFromTuple( workingMemory,
        //                                          leftTuple );
        //        for ( RightTuple rightTuple = (RightTuple) it.next(); rightTuple != null; rightTuple = (RightTuple) it.next() ) {
        //            if ( this.constraints.isAllowedCachedLeft( rightTuple.getHandle() ) ) {
        //                this.sink.propagateRetractTuple( leftTuple,
        //                                                 rightTuple,
        //                                                 context,
        //                                                 workingMemory );
        //            }
        //        }
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNode#updateNewNode(org.drools.reteoo.WorkingMemoryImpl, org.drools.spi.PropagationContext)
     */
    public void updateSink(final LeftTupleSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {

        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        final Iterator tupleIter = memory.getLeftTupleMemory().iterator();
        for ( LeftTuple tuple = (LeftTuple) tupleIter.next(); tuple != null; tuple = (LeftTuple) tupleIter.next() ) {
            this.constraints.updateFromTuple( workingMemory,
                                              tuple );
            for ( RightTuple rightTuple = memory.getRightTupleMemory().getFirst( tuple ); rightTuple != null; rightTuple = (RightTuple) rightTuple.getNext() ) {
                if ( this.constraints.isAllowedCachedLeft( rightTuple.getHandle() ) ) {
                    sink.assertTuple( new LeftTuple( tuple,
                                                     rightTuple,
                                                     this ),
                                      context,
                                      workingMemory );
                }
            }
        }
        this.constraints.updateFromTuple( workingMemory,
                                          null );
    }

    public String toString() {
        RightTupleSource source = this.rightInput;
        while ( !(source instanceof ObjectTypeNode) ) {
            source = source.objectSource;
        }

        return "[JoinNode - " + ((ObjectTypeNode) source).getObjectType() + "]";
    }
}
