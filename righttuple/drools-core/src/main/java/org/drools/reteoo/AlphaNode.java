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
import org.drools.FactException;
import org.drools.RuleBaseConfiguration;
import org.drools.common.BaseNode;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.NodeMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.reteoo.builder.BuildContext;
import org.drools.spi.AlphaNodeFieldConstraint;
import org.drools.spi.PropagationContext;
import org.drools.util.FactHashTable;
import org.drools.util.Iterator;

/**
 * <code>AlphaNodes</code> are nodes in the <code>Rete</code> network used
 * to apply <code>FieldConstraint<.code>s on asserted fact 
 * objects where the <code>FieldConstraint</code>s have no dependencies on any other of the facts in the current <code>Rule</code>.
 * 
 *  @see AlphaNodeFieldConstraint
 * 
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public class AlphaNode extends RightTupleSource
    implements
    RightTupleSinkNode,
    NodeMemory {

    /**
     * 
     */
    private static final long              serialVersionUID = 400L;

    /** The <code>FieldConstraint</code> */
    private final AlphaNodeFieldConstraint constraint;

    private RightTupleSinkNode                 previousRightTupleSinkNode;
    private RightTupleSinkNode                 nextRightTupleNode;

    private boolean                        rightTupleMemoryEnabled;

    private boolean                        rightTupleMemoryAllowed;

    /**
     * Construct an <code>AlphaNode</code> with a unique id using the provided
     * <code>FieldConstraint</code> and the given <code>ObjectSource</code>.
     * Set the boolean flag to true if the node is supposed to have local 
     * memory, or false otherwise. Memory is optional for <code>AlphaNode</code>s 
     * and is only of benefic when adding additional <code>Rule</code>s at runtime. 
     * 
     * @param id Node's ID
     * @param constraint Node's constraints
     * @param objectSource Node's object source
     * @param hasMemory true if node shall be configured with local memory. False otherwise.
     */
    public AlphaNode(final int id,
                     final AlphaNodeFieldConstraint constraint,
                     final RightTupleSource objectSource,
                     final BuildContext context) {
        super( id,
               objectSource,
               context.getRuleBase().getConfiguration().getAlphaNodeHashingThreshold() );
        this.constraint = constraint;
        this.rightTupleMemoryAllowed = context.isAlphaMemoryAllowed();
        if ( this.rightTupleMemoryAllowed ) {
            this.rightTupleMemoryEnabled = context.getRuleBase().getConfiguration().isAlphaMemory();
        } else {
            this.rightTupleMemoryEnabled = false;
        }
    }

    /**
     * Retruns the <code>FieldConstraint</code>
     * 
     * @return <code>FieldConstraint</code>
     */
    public AlphaNodeFieldConstraint getConstraint() {
        return this.constraint;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.drools.reteoo.BaseNode#attach()
     */
    public void attach() {
        this.objectSource.addObjectSink( this );
    }

    public void attach(final InternalWorkingMemory[] workingMemories) {
        attach();

        // we are attaching this node with existing working memories
        // indicating that we are in a dynamic environment, that might benefit from alpha node memory, if allowed
        if ( this.rightTupleMemoryAllowed ) {
            setRightTupleMemoryEnabled( true );
        }
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

    public void assertRightTuple(final RightTuple rightTuple,
                             final PropagationContext context,
                             final InternalWorkingMemory workingMemory) throws FactException {
        if ( this.constraint.isAllowed( rightTuple.getHandle(),
                                        workingMemory ) ) {
            if ( isRightTupleMemoryEnabled() ) {
                final FactHashTable memory = (FactHashTable) workingMemory.getNodeMemory( this );
                memory.add( rightTuple,
                            false );
            }

            this.sink.propagateAssertRightTuple( rightTuple,
                                             context,
                                             workingMemory );
        }
    }

    public void retractRightTuple(final RightTuple rightTuple,
                              final PropagationContext context,
                              final InternalWorkingMemory workingMemory) {
        boolean propagate = true;
        if ( isRightTupleMemoryEnabled() ) {
            final FactHashTable memory = (FactHashTable) workingMemory.getNodeMemory( this );
            propagate = memory.remove( rightTuple );
        } else {
            propagate = this.constraint.isAllowed( rightTuple.getHandle(),
                                                   workingMemory );
        }
        if ( propagate ) {
            this.sink.propagateRetractRightTuple( rightTuple,
                                              context,
                                              workingMemory,
                                              true );
        }
    }

    public void updateSink(final RightTupleSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {
        FactHashTable memory = null;

        if ( !isRightTupleMemoryEnabled() ) {
            // get the objects from the parent
            RightTupleSinkUpdateAdapter adapter = new RightTupleSinkUpdateAdapter( sink, this.constraint );
            this.objectSource.updateSink( adapter,
                                          context,
                                          workingMemory );
        } else {
            // if already has memory, just iterate and propagate
            memory = (FactHashTable) workingMemory.getNodeMemory( this );
            final Iterator it = memory.iterator();
            for ( RightTuple entry = (RightTuple) it.next(); entry != null; entry = (RightTuple) it.next() ) {
                sink.assertRightTuple( entry,
                                   context,
                                   workingMemory );
            }
        }
    }

    public void remove(final BaseNode node,
                       final InternalWorkingMemory[] workingMemories) {

        if ( !node.isInUse() ) {
            removeObjectSink( (RightTupleSink) node );
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

    public void setRightTupleMemoryAllowed(boolean objectMemoryAllowed) {
        this.rightTupleMemoryAllowed = objectMemoryAllowed;
    }

    public boolean isRightTupleMemoryEnabled() {
        return this.rightTupleMemoryEnabled;
    }

    public void setRightTupleMemoryEnabled(boolean objectMemoryEnabled) {
        this.rightTupleMemoryEnabled = objectMemoryEnabled;
    }

    /**
     * Creates a HashSet for the AlphaNode's memory.
     */
    public Object createMemory(final RuleBaseConfiguration config) {
        return new FactHashTable();
    }

    /** 
     * @inheritDoc
     */
    protected void addObjectSink(final RightTupleSink objectSink) {
        super.addObjectSink( objectSink );
    }

    public String toString() {
        return "[AlphaNode(" + this.id + ") constraint=" + this.constraint + "]";
    }

    public int hashCode() {
        return this.objectSource.hashCode() * 17 + ((this.constraint != null) ? this.constraint.hashCode() : 0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }

        if ( object == null || !(object instanceof AlphaNode) ) {
            return false;
        }

        final AlphaNode other = (AlphaNode) object;

        return this.objectSource.equals( other.objectSource ) && this.constraint.equals( other.constraint );
    }

    /**
     * Returns the next node
     * @return
     *      The next ObjectSinkNode
     */
    public RightTupleSinkNode getNextRightTupleSinkNode() {
        return this.nextRightTupleNode;
    }

    /**
     * Sets the next node 
     * @param next
     *      The next ObjectSinkNode
     */
    public void setNextRightTupleSinkNode(final RightTupleSinkNode next) {
        this.nextRightTupleNode = next;
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

    /**
     * Used with the updateSink method, so that the parent ObjectSource
     * can  update the  TupleSink
     * @author mproctor
     *
     */
    private static class RightTupleSinkUpdateAdapter
        implements
        RightTupleSink {
        private final RightTupleSink sink;
        private final AlphaNodeFieldConstraint constraint;

        public RightTupleSinkUpdateAdapter(final RightTupleSink sink, 
                                       final AlphaNodeFieldConstraint constraint ) {
            this.sink = sink;
            this.constraint = constraint;
        }

        public void assertRightTuple(final RightTuple rightTuple,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {
            if ( this.constraint.isAllowed( rightTuple.getHandle(),
                                            workingMemory ) ) {
                this.sink.assertRightTuple( rightTuple,
                                        context,
                                        workingMemory );
            }
        }

        public void modifyObject(final InternalFactHandle handle,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {
            throw new UnsupportedOperationException( "ObjectSinkUpdateAdapter onlys supports assertObject method calls" );
        }

        public void retractRightTuple(final RightTuple rightTuple,
                                  final PropagationContext context,
                                  final InternalWorkingMemory workingMemory) {
            throw new UnsupportedOperationException( "ObjectSinkUpdateAdapter onlys supports assertObject method calls" );
        }

        public boolean isRightTupleMemoryEnabled() {
            throw new UnsupportedOperationException( "ObjectSinkUpdateAdapter have no Object memory" );
        }

        public void setRightTupleMemoryEnabled(boolean objectMemoryEnabled) {
            throw new UnsupportedOperationException( "ObjectSinkUpdateAdapter have no Object memory" );
        }
    }
}
