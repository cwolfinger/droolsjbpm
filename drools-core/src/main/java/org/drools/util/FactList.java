/**
 * 
 */
package org.drools.util;

import java.io.Serializable;

import org.drools.common.InternalFactHandle;
import org.drools.reteoo.RightTuple;
import org.drools.reteoo.RightTupleMemory;
import org.drools.reteoo.LeftTuple;

public class FactList
    implements
    RightTupleMemory {
    private static final long serialVersionUID = 400L;

    private final LinkedList list;
    
    public FactList() {
        this.list = new LinkedList();
    }

    public Iterator iterator(final LeftTuple tuple) {
        return iterator();
    }

    public boolean add(final RightTuple rightTuple) {
        return add( rightTuple,
                    true );
    }

    public boolean add(final RightTuple rightTuple,
                       final boolean checkExists) {
        this.list.add( rightTuple );
        return true;
    }

    public boolean contains(final RightTuple rightTuple) {
        InternalFactHandle handle = rightTuple.getHandle();
        Iterator it = this.list.iterator();
        for ( Object object = it.next(); object != null; object = it.next() ) {
            if ( handle.equals( ((LinkedListEntry)object).getObject() ) ) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(final RightTuple rightTuple) {
        InternalFactHandle handle = rightTuple.getHandle();
        Iterator it = this.list.iterator();        
        for ( Object object = it.next(); object != null; object = it.next() ) {
            if ( handle.equals( ((LinkedListEntry)object).getObject() ) ) {
                this.list.remove( rightTuple );
                return true;
            }
        }
        return false;
    }
    
    public Iterator iterator() {
        return this.list.iterator();
    }

    public int size() {
        return  this.list.size();
    }

    public boolean isIndexed() {
        return false;
    }
}