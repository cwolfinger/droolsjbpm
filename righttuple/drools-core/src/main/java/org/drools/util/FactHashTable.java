/**
 * 
 */
package org.drools.util;

import org.drools.common.InternalFactHandle;
import org.drools.reteoo.RightTupleMemory;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.RightTuple;

public class FactHashTable extends AbstractHashTable
    implements
    RightTupleMemory {
    private static final long serialVersionUID = 400L;

    public FactHashTable() {
        this( 16,
              0.75f );
    }

    public FactHashTable(final int capacity,
                         final float loadFactor) {
        super( capacity,
               loadFactor );
    }

    public Iterator iterator(final LeftTuple tuple) {
        return iterator();
    }

    public boolean add(final RightTuple tuple) {
        return add( tuple,
                    true );
    }

    public boolean add(final RightTuple tuple,
                       final boolean checkExists) {
        final int hashCode = this.comparator.hashCodeOf( tuple.getHandle() );
        tuple.setHashCode(hashCode);
        
        final int index = indexOf( hashCode,
                                   this.table.length );
        
        InternalFactHandle handle = tuple.getHandle();
        // scan the linked entries to see if it exists
        if ( checkExists ) {
        	RightTuple current = (RightTuple) this.table[index];        	
            while ( current != null ) {
                if ( hashCode == current.hashCode() && handle == current.getHandle() ) {
                    return false;
                }
                current = (RightTuple) current.getNext();
            }
        }
        
        tuple.setNext( this.table[index]);
        this.table[index] = tuple;

        if ( this.size++ >= this.threshold ) {
            resize( 2 * this.table.length );
        }
        return true;
    }

    public boolean contains(final RightTuple tuple) {
    	final int hashCode = this.comparator.hashCodeOf( tuple.getHandle() );
    	
        final int index = indexOf( hashCode,
                                   this.table.length );

        InternalFactHandle handle = tuple.getHandle();
    	RightTuple current = (RightTuple) this.table[index];        	
        while ( current != null ) {
            if ( hashCode == current.hashCode() && handle == current.getHandle() ) {
                return true;
            }
            current = (RightTuple) current.getNext();
        }
        return false;
    }

    public boolean remove(final RightTuple tuple) {
    	final int hashCode = this.comparator.hashCodeOf( tuple.getHandle() );
    	
        final int index = indexOf( hashCode,
                                   this.table.length );

        InternalFactHandle handle = tuple.getHandle();
        
        RightTuple previous = (RightTuple) this.table[index];
        RightTuple current = previous;
        while ( current != null ) {
            final RightTuple next = (RightTuple) current.getNext();
            if ( hashCode == current.hashCode() && handle == current.getHandle() ) {
                if ( previous == current ) {
                    this.table[index] = next;
                } else {
                    previous.setNext( next );
                }
                current.setNext( null );
                this.size--;
                return true;
            }
            previous = current;
            current = next;
        }
        return false;
    }

    public Entry getBucket(final Object object) {
        final int hashCode = this.comparator.hashCodeOf( object );
        final int index = indexOf( hashCode,
                                   this.table.length );

        return this.table[index];
    }

    public boolean isIndexed() {
        return false;
    }
}