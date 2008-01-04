/*
 * Copyright 2006 JBoss Inc
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

package org.drools.reteoo;

import org.drools.common.BetaConstraints;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.PropagationContext;
import org.drools.util.FactEntry;
import org.drools.util.Iterator;

/**
 * <code>ExistsNode</code> extends <code>BetaNode</code> to perform tests for
 * the existence of a Fact plus one or more conditions. Where existence
 * is found the left ReteTuple is copied and propagated. Further to this it
 * maintains the "truth" by canceling any
 * <code>Activation<code>s that are no longer 
 * considered true by the retraction of ReteTuple's or FactHandleImpl.  
 * Tuples are considered to be asserted from the left input and facts from the right input.
 * The <code>BetaNode</code> provides the BetaMemory to store asserted ReteTuples and 
 * <code>FactHandleImpl<code>s. Each fact handle is stored in the right 
 * memory.
 * 
 * @author <a href="mailto:etirelli@redhat.com">Edson Tirelli</a>
 *
 */
public class ExistsNode extends BetaNode {

    private static final long serialVersionUID = 400L;

    static int                notAssertObject  = 0;
    static int                notAssertTuple   = 0;

    // ------------------------------------------------------------
    // Instance methods
    // ------------------------------------------------------------

    /**
     * Construct.
     * 
     * @param id
     *            The unique id for this node.
     * @param leftInput
     *            The left input <code>TupleSource</code>.
     * @param rightInput
     *            The right input <code>ObjectSource</code>.
     * @param joinNodeBinder
     *            The constraints to be applied to the right objects
     */
    public ExistsNode(final int id,
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
     * over the right <code>FactHandleImpl</code>'s and if any match is found,
     * a copy of the <code>ReteTuple</code> is made and propagated.
     * 
     * @param tuple
     *            The <code>Tuple</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory session.
     */
    public void assertTuple(final LeftTuple leftTuple,
                            final PropagationContext context,
                            final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        
        if ( this.tupleMemoryEnabled ) {
            memory.getLeftTupleMemory().add( leftTuple );
        }

        final Iterator it = memory.getRightTupleMemory().iterator( leftTuple );
        this.constraints.updateFromTuple( workingMemory,
                                          leftTuple );
        for ( FactEntry entry = (FactEntry) it.next(); entry != null; entry = (FactEntry) it.next() ) {            
            final InternalFactHandle handle = entry.getFactHandle();
            if ( this.constraints.isAllowedCachedLeft( handle ) ) {
                leftTuple.setMatch( handle );
                break;
            }            
        }

        if ( leftTuple.getMatch() != null ) {
            this.sink.propagateAssertTuple( leftTuple,
                                            context,
                                            workingMemory );
        }
    }

    /**
     * Assert a new <code>FactHandleImpl</code> from the right input. If it
     * matches any left ReteTuple's that had no matches before, propagate 
     * tuple as an assertion.
     * 
     * @param rightTuple
     *            The <code>FactHandleImpl</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory session.
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

        final Iterator it = memory.getLeftTupleMemory().iterator( rightTuple );
        this.constraints.updateFromRightTuple( workingMemory,
                                               rightTuple );
        for ( LeftTuple tuple = (LeftTuple) it.next(); tuple != null; tuple = (LeftTuple) it.next() ) {
            if ( this.constraints.isAllowedCachedRight( tuple ) && tuple.getMatch() == null) {
                    tuple.setMatch( rightTuple );
                    this.sink.propagateAssertTuple( tuple,
                                                     context,
                                                     workingMemory );                                 
            }
        }
    }

    /**
     * Retract the <code>FactHandleImpl</code>. If the handle has any
     * <code>ReteTuple</code> matches and those tuples now have no
     * other match, retract tuple
     * 
     * @param rightTuple
     *            the <codeFactHandleImpl</code> being retracted
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory session.
     */
    public void retractRightTuple(final RightTuple rightTuple,
                              final PropagationContext context,
                              final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        if ( !memory.getRightTupleMemory().remove( rightTuple ) ) {
            return;
        }

        final Iterator it = memory.getLeftTupleMemory().iterator( rightTuple );
        this.constraints.updateFromRightTuple( workingMemory,
                                               rightTuple );
        for ( LeftTuple tuple = (LeftTuple) it.next(); tuple != null; tuple = (LeftTuple) it.next() ) {
            if ( this.constraints.isAllowedCachedRight( tuple ) ) {
                if ( tuple.getMatch() == rightTuple ) {
                    // reset the match                    
                    tuple.setMatch( null );
                    
                    // find next match, remember it and break.
                    final Iterator tupleIt = memory.getRightTupleMemory().iterator( tuple );
                    this.constraints.updateFromTuple( workingMemory, tuple );
                    
                    for ( FactEntry entry = (FactEntry) tupleIt.next(); entry != null; entry = (FactEntry) tupleIt.next() ) {
                        final InternalFactHandle rightHandle = entry.getFactHandle();
                        if ( this.constraints.isAllowedCachedLeft( rightHandle ) ) {
                            tuple.setMatch( rightHandle );
                            break;
                        }
                    }
                    
                    // if there is now no new tuple match then propagate assert.
                    if ( tuple.getMatch() == null ) {
                        this.sink.propagateRetractTuple( tuple,
                                                        context,
                                                        workingMemory );
                    }                    
                }
                
            }
        }
    }

    /**
     * Retract the
     * <code>ReteTuple<code>, any resulting propagated joins are also retracted. 
     * 
     * @param leftTuple
     *            The tuple being retracted
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory session.
     */
    public void retractTuple(final LeftTuple leftTuple,
                             final PropagationContext context,
                             final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        // Must use the tuple in memory as it has the tuple matches count
        final LeftTuple tuple = memory.getLeftTupleMemory().remove( leftTuple );
        if ( tuple == null ) {
            return;
        }

        if ( tuple.getMatch() !=  null) {
            this.sink.propagateRetractTuple( tuple,
                                             context,
                                             workingMemory );
        }
    }

    /**
     * Updates the given sink propagating all previously propagated tuples to it
     * 
     */
    public void updateSink(final LeftTupleSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        final Iterator tupleIter = memory.getLeftTupleMemory().iterator();
        for ( LeftTuple tuple = (LeftTuple) tupleIter.next(); tuple != null; tuple = (LeftTuple) tupleIter.next() ) {
            if ( tuple.getMatch() != null ) {
                sink.assertTuple( new LeftTuple( tuple ),
                                  context,
                                  workingMemory );
            }
        }
    }

    public String toString() {
        RightTupleSource source = this.rightInput;
        while ( source.getClass() != ObjectTypeNode.class ) {
            source = source.objectSource;
        }

        return "[ExistsNode - " + ((ObjectTypeNode) source).getObjectType() + "]";
    }

}
