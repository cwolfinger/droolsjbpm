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

import java.io.Serializable;

import org.drools.common.BaseNode;
import org.drools.common.DefaultFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

/**
 * A source of <code>FactHandle</code>s for an <code>ObjectSink</code>.
 * 
 * <p>
 * Nodes that propagate <code>FactHandleImpl</code> extend this class.
 * </p>
 * 
 * @see RightTupleSource
 * @see DefaultFactHandle
 * 
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 */
public abstract class RightTupleSource extends BaseNode
    implements
    Serializable {
    // ------------------------------------------------------------
    // Instance members
    // ------------------------------------------------------------

    /** The destination for <code>FactHandleImpl</code>. */
    protected RightTupletSinkPropagator sink;

    protected RightTupleSource         objectSource;

    private int                    alphaNodeHashingThreshold;

    // ------------------------------------------------------------
    // Constructors
    // ------------------------------------------------------------

    /**
     * Single parameter constructor that specifies the unique id of the node.
     * 
     * @param id
     */
    RightTupleSource(final int id) {
        this( id,
              null,
              3 );
    }

    /**
     * Single parameter constructor that specifies the unique id of the node.
     * 
     * @param id
     */
    RightTupleSource(final int id,
                 final RightTupleSource objectSource,
                 final int alphaNodeHashingThreshold) {
        super( id );
        this.objectSource = objectSource;
        this.alphaNodeHashingThreshold = alphaNodeHashingThreshold;
        this.sink = EmptyRightTupleSinkAdapter.getInstance();
    }

    // ------------------------------------------------------------
    // Instance methods
    // ------------------------------------------------------------

    /**
     * Adds the <code>ObjectSink</code> so that it may receive
     * <code>FactHandleImpl</code> propagated from this
     * <code>ObjectSource</code>.
     * 
     * @param objectSink
     *            The <code>ObjectSink</code> to receive propagated
     *            <code>FactHandleImpl</code>.
     */
    protected void addObjectSink(final RightTupleSink objectSink) {
        if ( this.sink == EmptyRightTupleSinkAdapter.getInstance() ) {
            this.sink = new SingleRightTupletSinkAdapter( objectSink );
        } else if ( this.sink instanceof SingleRightTupletSinkAdapter ) {
            final CompositeRightTupleSinkAdapter sinkAdapter = new CompositeRightTupleSinkAdapter( this.alphaNodeHashingThreshold );
            sinkAdapter.addObjectSink( this.sink.getSinks()[0] );
            sinkAdapter.addObjectSink( objectSink );
            this.sink = sinkAdapter;
        } else {
            ((CompositeRightTupleSinkAdapter) this.sink).addObjectSink( objectSink );
        }
    }

    /**
     * Removes the <code>ObjectSink</code>
     * 
     * @param objectSink
     *            The <code>ObjectSink</code> to remove
     */
    protected void removeObjectSink(final RightTupleSink objectSink) {
        if ( this.sink == EmptyRightTupleSinkAdapter.getInstance() ) {
            throw new IllegalArgumentException( "Cannot remove a sink, when the list of sinks is null" );
        }

        if ( this.sink instanceof SingleRightTupletSinkAdapter ) {
            this.sink = EmptyRightTupleSinkAdapter.getInstance();
        } else {
            final CompositeRightTupleSinkAdapter sinkAdapter = (CompositeRightTupleSinkAdapter) this.sink;
            sinkAdapter.removeObjectSink( objectSink );
            if ( sinkAdapter.size() == 1 ) {
                this.sink = new SingleRightTupletSinkAdapter( sinkAdapter.getSinks()[0] );
            }
        }
    }

    public abstract void updateSink(RightTupleSink sink,
                                    PropagationContext context,
                                    InternalWorkingMemory workingMemory);

    public RightTupletSinkPropagator getSinkPropagator() {
        return this.sink;
    }
}
