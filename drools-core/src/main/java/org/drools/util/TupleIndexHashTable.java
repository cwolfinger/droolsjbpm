/**
 * 
 */
package org.drools.util;

import org.drools.common.InternalFactHandle;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.LeftTupleMemory;
import org.drools.reteoo.RightTuple;

public class TupleIndexHashTable extends AbstractHashTable
    implements
    LeftTupleMemory {

    private static final long               serialVersionUID = 400L;

    public static final int                 PRIME            = 31;

    private int                             startResult;

    private FieldIndexHashTableFullIterator tupleValueFullIterator;

    private int                             factSize;

    private Index                           index;

    public TupleIndexHashTable(final FieldIndex[] index) {
        this( 128,
              0.75f,
              index );
    }

    public TupleIndexHashTable(final int capacity,
                               final float loadFactor,
                               final FieldIndex[] index) {
        super( capacity,
               loadFactor );

        this.startResult = TupleIndexHashTable.PRIME;
        for ( int i = 0, length = index.length; i < length; i++ ) {
            this.startResult += TupleIndexHashTable.PRIME * this.startResult + index[i].getExtractor().getIndex();
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

    public Iterator iterator() {
        if ( this.tupleValueFullIterator == null ) {
            this.tupleValueFullIterator = new FieldIndexHashTableFullIterator( this );
        }
        this.tupleValueFullIterator.reset();
        return this.tupleValueFullIterator;
    }
    
    public LeftTuple getFirst(final RightTuple rightTuple) {
        TupleHashTable bucket = get( rightTuple );
        if ( bucket != null ) {
            return bucket.getFirst( null );
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

    public static class FieldIndexHashTableFullIterator
        implements
        Iterator {
        private AbstractHashTable hashTable;
        private Entry[]           table;
        private int               row;
        private int               length;
        private Entry             entry;

        public FieldIndexHashTableFullIterator(final AbstractHashTable hashTable) {
            this.hashTable = hashTable;
        }

        /* (non-Javadoc)
         * @see org.drools.util.Iterator#next()
         */
        public Object next() {
            if ( this.entry == null ) {
                // keep skipping rows until we come to the end, or find one that is populated
                while ( this.entry == null ) {
                    this.row++;
                    if ( this.row == this.length ) {
                        return null;
                    }
                    this.entry = (this.table[this.row] != null) ? ((TupleHashTable) this.table[this.row]).first : null;
                }
            } else {
                this.entry = this.entry.getNext();
                if ( this.entry == null ) {
                    this.entry = (Entry) next();
                }
            }

            return this.entry;
        }
        public void remove() {
            throw  new UnsupportedOperationException("FieldIndexHashTableFullIterator does not support remove().");
        }

        /* (non-Javadoc)
         * @see org.drools.util.Iterator#reset()
         */
        public void reset() {
            this.table = this.hashTable.getTable();
            this.length = this.table.length;
            this.row = -1;
            this.entry = null;
        }
    }
    
    public LeftTuple[] toArray() {
        LeftTuple[] result = new LeftTuple[this.factSize];
        int index = 0;
        for ( int i = 0; i < this.table.length; i++ ) {
            TupleHashTable bucket = (TupleHashTable)this.table[i];
            while ( bucket != null ) {
                LeftTuple entry = ( LeftTuple ) bucket.getFirst( null );
                while ( entry != null ) {
                    result[index++] = entry;
                    entry = ( LeftTuple ) entry.getNext();
                }       
                bucket  = ( TupleHashTable ) bucket.getNext();
            }
        }
        return result;
    }       

    public void add(final LeftTuple tuple) {
        final TupleHashTable entry = getOrCreate( tuple );
        tuple.setMemory( entry );
        entry.add( tuple );
        this.factSize++;
    }
    
    public void remove(final LeftTuple leftTuple) {
        if ( leftTuple.getMemory() != null ) {
            TupleHashTable  memory =leftTuple.getMemory();
            memory.remove( leftTuple );
            if ( memory.first == null ) {
                final int index = indexOf( memory.hashCode(),
                                           this.table.length );                
                TupleHashTable previous = null;
                TupleHashTable current = (TupleHashTable) this.table[index];
                while ( current != memory ) {
                    previous = current;
                    current = (TupleHashTable) current.getNext();
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
        
        final int hashCode = this.index.hashCodeOf( leftTuple );
        final int index = indexOf( hashCode,
                                   this.table.length );

        // search the table for  the Entry, we need to track previous, so if the Entry
        // is empty we can remove it.
        TupleHashTable previous = null;
        TupleHashTable current = (TupleHashTable) this.table[index];
        while ( current != null  ) {
            if ( current.matches( leftTuple,
                                  hashCode ) ) {
                current.remove( leftTuple );
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
            current = (TupleHashTable) current.next;
        }
        leftTuple.setNext(null);
        leftTuple.setPrevious(null);
    }

    public boolean contains(final LeftTuple tuple) {
        final int hashCode = this.index.hashCodeOf( tuple );

        final int index = indexOf( hashCode,
                                   this.table.length );

        TupleHashTable current = (TupleHashTable) this.table[index];
        while ( current != null ) {
            if ( current.matches( tuple,
                                  hashCode ) ) {
                return true;
            }
            current = (TupleHashTable) current.next;
        }
        return false;
    }

    public TupleHashTable get(final RightTuple rightTuple) {
        final Object object = rightTuple.getHandle().getObject();
        final int hashCode = this.index.hashCodeOf( object );

        final int index = indexOf( hashCode,
                                   this.table.length );
        TupleHashTable entry = (TupleHashTable) this.table[index];

        while ( entry != null ) {
            if ( entry.matches( object,
                                hashCode ) ) {
                return entry;
            }
            entry = (TupleHashTable) entry.getNext();
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
    private TupleHashTable getOrCreate(final LeftTuple tuple) {
        final int hashCode = this.index.hashCodeOf( tuple );

        final int index = indexOf( hashCode,
                                   this.table.length );
        TupleHashTable entry = (TupleHashTable) this.table[index];

        // search to find an existing entry
        while ( entry != null ) {
            if ( entry.matches( tuple,
                                hashCode ) ) {
                return entry;
            }
            entry = (TupleHashTable) entry.next;
        }

        // entry does not exist, so create
        if ( entry == null ) {
            entry = new TupleHashTable( this.index,
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
        Iterator it = iterator();
        for ( LeftTuple leftTuple = ( LeftTuple ) it.next(); leftTuple  != null; leftTuple = ( LeftTuple ) it.next() ) {
            builder.append( leftTuple + "\n" );
        }
                
        return builder.toString();
    }    

//    public static class TupleHashTable
//        implements
//        Entry {
//
//        private static final long serialVersionUID = 400L;
////      private Entry             previous;
//        private Entry             next;
//        private LeftTuple         first;
//        private final int         hashCode;
//        private Index             index;
//
//        public TupleHashTable(final Index index,
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
//        public LeftTuple getFirst() {
//            return this.first;
//        }
//
//        public void add(final LeftTuple tuple) {
//            tuple.setNext( this.first );
//            this.first = tuple;
//        }
//
//        public LeftTuple get(final LeftTuple tuple) {
//            LeftTuple current = this.first;
//            while ( current != null ) {
//                if ( tuple.equals( current ) ) {
//                    return current;
//                }
//                current = (LeftTuple) current.getNext();
//            }
//            return null;
//        }
//
//        public void remove(final LeftTuple leftTuple) {
//            LeftTuple previous = ( LeftTuple ) leftTuple.getPrevious();
//            LeftTuple next = ( LeftTuple ) leftTuple.getNext();
//            
//            if ( previous  != null && next != null ) {
//                //remove  from middle
//                previous.setNext( next );
//                next.setPrevious( previous );
//            } else if ( next != null ) {
//                //remove from first
//                this.first = next;
//                next.setPrevious( null );
//            } else if ( previous != null ){
//                //remove from end
//                previous.setNext( null );
//            }  else {
//                this.first = null;
//            }
//        }
//
//        public boolean matches(final Object object,
//                               final int objectHashCode) {
//            return this.hashCode == objectHashCode && this.index.equal( object,
//                                                                        this.first );
//        }
//
//        public boolean matches(final LeftTuple tuple,
//                               final int tupleHashCode) {
//            return this.hashCode == tupleHashCode && this.index.equal( this.first,
//                                                                       tuple );
//        }
//
//        public int hashCode() {
//            return this.hashCode;
//        }
//
//        public boolean equals(final Object object) {
//            final TupleHashTable other = (TupleHashTable) object;
//            return this.hashCode == other.hashCode && this.index == other.index;
//        }
//
//        public Entry getPrevious() {
//            return null;
//        }
//
//        public void setPrevious(Entry previous) {
////          this.previous = previous;           
//        }
//    }

}