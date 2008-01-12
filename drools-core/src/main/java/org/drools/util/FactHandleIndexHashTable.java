/**
 * 
 */
package org.drools.util;

import org.drools.common.InternalFactHandle;
import org.drools.reteoo.RightTuple;
import org.drools.reteoo.RightTupleMemory;
import org.drools.reteoo.LeftTuple;

public class FactHandleIndexHashTable extends AbstractHashTable
    implements
    RightTupleMemory {

    private static final long           serialVersionUID = 400L;

    public static final int             PRIME            = 31;

    private int                         startResult;

    private int                         factSize;

    private Index                       index;

    public FactHandleIndexHashTable(final FieldIndex[] index) {
        this( 128,
              0.75f,
              index );
    }

    public FactHandleIndexHashTable(final int capacity,
                                    final float loadFactor,
                                    final FieldIndex[] index) {
        super( capacity,
               loadFactor );

        this.startResult = FactHandleIndexHashTable.PRIME;
        for ( int i = 0, length = index.length; i < length; i++ ) {
            this.startResult = FactHandleIndexHashTable.PRIME * this.startResult + index[i].getExtractor().getIndex();
        }

        switch ( index.length ) {
            case 0 :
                throw new IllegalArgumentException( "FieldIndexHashTable cannot use an index[] of length  0" );
            case 1 :
                this.index = new SingleIndex( index,
                                              this.startResult );
                break;
            case 2 :
                this.index = new DoubleCompositeIndex( index,
                                                       this.startResult );
                break;
            case 3 :
                this.index = new TripleCompositeIndex( index,
                                                       this.startResult );
                break;
            default :
                throw new IllegalArgumentException( "FieldIndexHashTable cannot use an index[] of length  great than 3" );
        }
    }
    
    public RightTuple getFirst(LeftTuple leftTuple) {
        FactHashTable bucket = get( leftTuple );
        if ( bucket != null ) {
            return bucket.first;
        } else {
            return null;
        }
    }
    
    public RightTuple getLast(LeftTuple leftTuple) {
        FactHashTable bucket = get( leftTuple );
        if ( bucket != null ) {
            return bucket.last;
        } else {
            return null;
        }        
    }

    public boolean isIndexed() {
        return true;
    }

    public Index getIndex() {
        return this.index;
    }

    public Entry getBucket(final Object object) {
        final int hashCode = this.index.hashCodeOf( object );
        final int index = indexOf( hashCode,
                                   this.table.length );

        return this.table[index];
    }

    /**
     * Fast re-usable iterator
     *
     */
    public static class FieldIndexHashTableIterator
        implements
        Iterator {
        private Entry entry;

        public FieldIndexHashTableIterator() {

        }

        /* (non-Javadoc)
         * @see org.drools.util.Iterator#next()
         */
        public Object next() {
            final Entry current = this.entry;
            this.entry = (this.entry != null) ? this.entry.getNext() : null;
            return current;
        }
        
        public void remove()  {
            
        }

        /* (non-Javadoc)
         * @see org.drools.util.Iterator#reset()
         */
        public void reset(final Entry entry) {
            this.entry = entry;
        }
    }

    public Entry[] toArray() {
        Entry[] result = new Entry[this.factSize];
        int index = 0;
        for ( int i = 0; i < this.table.length; i++ ) {
            FactHashTable bucket = (FactHashTable) this.table[i];
            while ( bucket != null ) {
                Entry entry = bucket.first;
                while ( entry != null ) {
                    result[index++] = entry;
                    entry = entry.getNext();
                }
                bucket = (FactHashTable) bucket.next;
            }
        }
        return result;
    }

    public void add(final RightTuple rightTuple) {
        final FactHashTable entry = getOrCreate( rightTuple.getHandle().getObject() );
        rightTuple.setMemory( entry );
        entry.add( rightTuple );
        this.factSize++;
    }

    /**
     * We assume that this rightTuple is contained in this hash table
     */
    public void remove(final RightTuple rightTuple) {
        if ( rightTuple.getMemory() != null ) {
            FactHashTable  memory =rightTuple.getMemory();
            memory.remove( rightTuple );
            if ( memory.first == null ) {
                final int index = indexOf( memory.hashCode(),
                                           this.table.length );                
                FactHashTable previous = null;
                FactHashTable current = (FactHashTable) this.table[index];
                while ( current != memory ) {
                    previous = current;
                    current = (FactHashTable) current.getNext();
                }
                
                if ( previous  != null ) {
                    previous.next = current.next;
                } else {
                    this.table[index] = current.next;
                }
                this.size--;                
            }
            return;
        }
        
        final Object object = rightTuple.getHandle().getObject();
        final int hashCode = this.index.hashCodeOf( object );
        final int index = indexOf( hashCode,
                                   this.table.length );

        // search the table for  the Entry, we need to track previous, so if the Entry
        // is empty we can remove it.
        FactHashTable previous = null;
        FactHashTable current = (FactHashTable) this.table[index];
        while ( current != null  ) {
            if ( current.matches( object,
                                  hashCode ) ) {
                current.remove( rightTuple );
                this.factSize--;
                
                if ( current.first == null ) {
                    if ( previous  != null ) {
                        previous.next = current.next;
                    } else {
                        this.table[index] = current.next;
                    }
                    this.size--;
                }
                break;
            }
            previous = current;
            current = (FactHashTable) current.next;
        }
        rightTuple.setNext(null);
        rightTuple.setPrevious(null);
    }

    public boolean contains(final RightTuple rightTuple) {
        final Object object = rightTuple.getHandle().getObject();

        final int hashCode = this.index.hashCodeOf( object );

        final int index = indexOf( hashCode,
                                   this.table.length );

        FactHashTable current = (FactHashTable) this.table[index];
        while ( current != null ) {
            if ( current.matches( object,
                                  hashCode ) ) {
                return true;
            }
            current = (FactHashTable) current.next;
        }
        return false;
    }

    public FactHashTable get(final LeftTuple tuple) {
        //this.index.setCachedValue( tuple );

        final int hashCode = this.index.hashCodeOf( tuple );

        final int index = indexOf( hashCode,
                                   this.table.length );
        FactHashTable entry = (FactHashTable) this.table[index];

        while ( entry != null ) {
            if ( entry.matches( tuple,
                                hashCode ) ) {
                return entry;
            }
            entry = (FactHashTable) entry.getNext();
        }

        return entry;
    }

    /**
     * We use this method to aviod to table lookups for the same hashcode; which is what we would have to do if we did
     * a get and then a create if the value is null.
     * 
     * @param value
     * @return
     */
    private FactHashTable getOrCreate(final Object object) {
        //this.index.setCachedValue( object );

        final int hashCode = this.index.hashCodeOf( object );

        final int index = indexOf( hashCode,
                                   this.table.length );
        FactHashTable entry = (FactHashTable) this.table[index];

        while ( entry != null ) {
            if ( entry.matches( object,
                                hashCode ) ) {
                return entry;
            }
            entry = (FactHashTable) entry.next;
        }

        if ( entry == null ) {
            entry = new FactHashTable( this.index,
                                         hashCode );
            entry.next = this.table[index];
            this.table[index] = entry;

            if ( this.size++ >= this.threshold ) {
                resize( 2 * this.table.length );
            }
        }
        return entry;
    }

    public int size() {
        return this.factSize;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for ( Entry entry : this.table) {
            while ( entry != null ) { 
                FactHashTable bucket = ( FactHashTable ) entry;
                for ( RightTuple  rightTuple = bucket.getFirst( null ); rightTuple != null; rightTuple = ( RightTuple ) rightTuple.getNext()  ) {
                    builder.append( rightTuple );
                }
                entry = entry.getNext();
            }
        }
        
        return builder.toString();
    }

//    public static class FactHashTable
//        implements
//        Entry {
//
//        private static final long serialVersionUID = 400L;
//              private Entry       previous;
//        private Entry             next;
//        private RightTuple        first;
//        private RightTuple        last;
//        private final int         hashCode;
//        private Index             index;
//
//        public FactHashTable(final Index index,
//                               final int hashCode) {
//            this.index = index;
//            this.hashCode = hashCode;
//        }
//
//        public Entry getNext() {
//            return this.next;
//        }
//
//        public void setNext(final Entry next) {
//            this.next = next;
//        }
//
//        public RightTuple getFirst() {
//            return this.first;
//        }
//        
//        public RightTuple getLast() {
//            return this.last;
//        }
//
//        public void add(final RightTuple rightTuple) {
//            if ( this.first != null ) {
//                this.first.setPrevious( rightTuple );
//                rightTuple.setNext( this.first );
//                this.first = rightTuple;       
//            } else {
//                this.first = rightTuple;
//                this.last = rightTuple;;
//            }
//        }
//
//        public RightTuple get(final RightTuple rightTuple) {
//            InternalFactHandle handle = rightTuple.getHandle();
//            RightTuple current = this.first;
//            while ( current != null ) {
//                if ( current.getHandle() == handle ) {
//                    return current;
//                }
//                current = (RightTuple) current.getNext();
//            }
//            return null;
//        }
//
//        public void remove(final RightTuple rightTuple) {
//            RightTuple previous = ( RightTuple ) rightTuple.getPrevious();
//            RightTuple next = ( RightTuple ) rightTuple.getNext();
//            
//            if ( previous  != null && next != null ) {
//                // remove from middle
//                previous.setNext( next );
//                next.setPrevious( previous );
//            } else if ( next != null ) {
//                // remove from first
//                this.first = next;
//                next.setPrevious( null );
//            } else if ( previous != null ) {
//                // remove from end
//                this.last = previous;
//                previous.setNext( null );
//            } else {
//                // remove everything
//                this.last = null;
//                this.first = null;
//            }
//        }
//
//        public boolean matches(final Object object,
//                               final int objectHashCode) {
//            return this.hashCode == objectHashCode && this.index.equal( this.first.getHandle().getObject(),
//                                                                        object );
//        }
//
//        public boolean matches(final LeftTuple tuple,
//                               final int tupleHashCode) {
//            return this.hashCode == tupleHashCode && this.index.equal( this.first.getHandle().getObject(),
//                                                                       tuple );
//        }
//
//        public int hashCode() {
//            return this.hashCode;
//        }
//
//        public boolean equals(final Object object) {
//            final FactHashTable other = (FactHashTable) object;
//            return this.hashCode == other.hashCode && this.index == other.index;
//        }
//
//        public String toString() {
//            return "FactHashTable( hashCode=" + this.hashCode + " first=" + this.first + " )";
//        }
//
//        public Entry getPrevious() {
//            return null;
//            //          return this.previous;            
//        }
//
//        public void setPrevious(Entry previous) {
//            //          this.previous = previous;
//        }
//    }
}