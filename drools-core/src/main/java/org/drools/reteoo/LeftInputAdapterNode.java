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

import org.drools.RuleBaseConfiguration;
import org.drools.common.BaseNode;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.NodeMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.PropagationContext;
import org.drools.util.FactHashTable;
import org.drools.util.Iterator;

/**
 * All asserting Facts must propagated into the right <code>ObjectSink</code> side of a BetaNode, if this is the first Pattern
 * then there are no BetaNodes to propagate to. <code>LeftInputAdapter</code> is used to adapt an ObjectSink propagation into a 
 * <code>TupleSource</code> which propagates a <code>ReteTuple</code> suitable fot the right <code>ReteTuple</code> side 
 * of a <code>BetaNode</code>.
 * 
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public class LeftInputAdapterNode extends LeftTupleSource
    implements
    RightTupleSinkNode,
    NodeMemory {

    /**
     * 
     */
    private static final long      serialVersionUID = 400L;
    private final RightTupleSource objectSource;

    private RightTupleSinkNode     previousRightTupleSinkNode;
    private RightTupleSinkNode     nextRightTupleSinkNode;

    /**
     * Constructus a LeftInputAdapterNode with a unique id that receives <code>FactHandle</code> from a 
     * parent <code>ObjectSource</code> and adds it to a given pattern in the resulting Tuples.
     * 
     * @param id
     *      The unique id of this node in the current Rete network
     * @param source
     *      The parent node, where Facts are propagated from
     * @param binder
     *      An optional binder to filter out propagations. This binder will exist when
     *      a predicate is used in the first pattern, for instance
     */
    public LeftInputAdapterNode(final int id,
                                final RightTupleSource source,
                                final BuildContext context) {
        super( id );
        this.objectSource = source;
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNode#attach()
     */
    public void attach() {
        this.objectSource.addObjectSink( this );
    }

    public void attach(final InternalWorkingMemory[] workingMemories) {
        attach();

        for ( int i = 0, length = workingMemories.length; i < length; i++ ) {
            final InternalWorkingMemory workingMemory = workingMemories[i];
            final PropagationContext propagationContext = new PropagationContextImpl( workingMemory.getNextPropagationIdCounter(),
                                                                                      PropagationContext.RULE_ADDITION,
                                                                                      null,
                                                                                      null );
            this.objectSource.updateSink( this,
                                          propagationContext,
                                          workingMemory );
        }
    }

    /**
     * Takes the asserted <code>FactHandleImpl</code> received from the <code>ObjectSource</code> and puts it
     * in a new <code>ReteTuple</code> before propagating to the <code>TupleSinks</code>
     * 
     * @param rightTuple
     *            The asserted <code>FactHandle/code>.
     * @param context
     *             The <code>PropagationContext</code> of the <code>WorkingMemory<code> action.           
     * @param workingMemory
     *            the <code>WorkingMemory</code> session.
     */
    public void assertRightTuple(final InternalFactHandle factHandle,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {

        if ( !workingMemory.isSequential() ) {
            this.sink.createAndPropagateAssertTuple( factHandle,
                                                     context,
                                                     workingMemory );
        } else {
            //workingMemory.addLIANodePropagation( new LIANodePropagation(this, rightTuple, context) );
        }
    }
    
    public void retractRightTuple(final RightTuple rightTuple,
                                  final PropagationContext context,
                                  final InternalWorkingMemory workingMemory) {
        throw new UnsupportedOperationException( "LeftInputAdapterNode.retractRightTuple is not supported." );
    }     

    public void updateSink(final LeftTupleSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {
        final RightTupleSinkAdapter adapter = new RightTupleSinkAdapter( sink );
        this.objectSource.updateSink( adapter,
                                      context,
                                      workingMemory );
    }

    public void remove(final BaseNode node,
                       final InternalWorkingMemory[] workingMemories) {
        if ( !node.isInUse() ) {
            removeTupleSink( (LeftTupleSink) node );
        }
        removeShare();
        if ( !this.isInUse() ) {
            for ( int i = 0, length = workingMemories.length; i < length; i++ ) {
                workingMemories[i].clearNodeMemory( this );
            }
        }
        this.objectSource.remove( this,
                                  workingMemories );
    }

    /**
     * Returns the next node
     * @return
     *      The next ObjectSinkNode
     */
    public RightTupleSinkNode getNextRightTupleSinkNode() {
        return this.nextRightTupleSinkNode;
    }

    /**
     * Sets the next node 
     * @param next
     *      The next ObjectSinkNode
     */
    public void setNextRightTupleSinkNode(final RightTupleSinkNode next) {
        this.nextRightTupleSinkNode = next;
    }

    /**
     * Returns the previous node
     * @return
     *      The previous ObjectSinkNode
     */
    public RightTupleSinkNode getPreviousRightTupleSinkNode() {
        return this.previousRightTupleSinkNode;
    }

    /**
     * Sets the previous node 
     * @param previous
     *      The previous ObjectSinkNode
     */
    public void setPreviousRightTupleSinkNode(final RightTupleSinkNode previous) {
        this.previousRightTupleSinkNode = previous;
    }

    public int hashCode() {
        return this.objectSource.hashCode();
    }

    public boolean equals(final Object object) {
        if ( object == this ) {
            return true;
        }

        if ( object == null || !(object instanceof LeftInputAdapterNode) ) {
            return false;
        }

        final LeftInputAdapterNode other = (LeftInputAdapterNode) object;

        return this.objectSource.equals( other.objectSource );
    }

    public Object createMemory(final RuleBaseConfiguration config) {
        return new FactHashTable();
    }

    /**
     * Used with the updateSink method, so that the parent ObjectSource
     * can  update the  TupleSink
     * @author mproctor
     *
     */
    private static class RightTupleSinkAdapter
        implements
        RightTupleSink {
        private LeftTupleSink sink;

        public RightTupleSinkAdapter(final LeftTupleSink sink) {
            this.sink = sink;
        }

        public void assertRightTuple(final InternalFactHandle factHandle,
                                     final PropagationContext context,
                                     final InternalWorkingMemory workingMemory) {
            this.sink.assertTuple( new LeftTuple( factHandle, this.sink ),
                                   context,
                                   workingMemory );
        }

        public void modifyObject(final InternalFactHandle handle,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {
            throw new UnsupportedOperationException( "ObjectSinkAdapter onlys supports assertObject method calls" );
        }

        public void retractRightTuple(final RightTuple rightTuple,
                                      final PropagationContext context,
                                      final InternalWorkingMemory workingMemory) {
            throw new UnsupportedOperationException( "ObjectSinkAdapter onlys supports assertObject method calls" );
        }

        public boolean isRightTupleMemoryEnabled() {
            throw new UnsupportedOperationException( "ObjectSinkAdapters have no Object memory" );
        }

        public void setRightTupleMemoryEnabled(boolean objectMemoryEnabled) {
            throw new UnsupportedOperationException( "ObjectSinkAdapters have no Object memory" );
        }
    }

}
