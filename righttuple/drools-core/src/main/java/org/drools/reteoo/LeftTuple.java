package org.drools.reteoo;

import java.util.ArrayList;
import java.util.List;

import org.drools.base.ShadowProxy;
import org.drools.common.InternalFactHandle;
import org.drools.rule.Declaration;
import org.drools.spi.Activation;
import org.drools.spi.Tuple;
import org.drools.util.Entry;

public class LeftTuple
    implements
    Tuple,
    Entry {
    private static final long        serialVersionUID = 400L;

    private int                      index;

    private final InternalFactHandle handle;

    private LeftTuple                parent;       

    private Activation               activation;

    private long                     recency;

    private int                      hashCode;
    
    private RightTuple               match;

    
    // left and right tuples in parent
    private LeftTuple               leftParent;  
    private LeftTuple               leftParentLeft;
    private LeftTuple               leftParentright;
    
    private RightTuple              rightParent;    
    private RightTuple              rightParentLeft;
    private RightTuple              rightParentright;
    
    // node memory
    private Entry                    next;    
    private Entry                    previous;
    
    // children
    private LeftTuple                children;    

    // ------------------------------------------------------------
    // Constructors
    // ------------------------------------------------------------
    public LeftTuple(final RightTuple rightTuple) {
        this.handle = rightTuple.getHandle();
        this.recency = this.handle.getRecency();
        int h = handle.hashCode();
        h += ~(h << 9);
        h ^= (h >>> 14);
        h += (h << 4);
        h ^= (h >>> 10);
        this.hashCode = h;
    }

    public LeftTuple(final LeftTuple tuple) {
        this.index = tuple.index;
        this.parent = tuple.parent;
        this.recency = tuple.recency;
        this.handle = tuple.handle;
        this.hashCode = tuple.hashCode();
    }

    public LeftTuple(final LeftTuple parentTuple,
                     final RightTuple rightTuple) {
        this.handle = rightTuple.getHandle();
        this.index = parentTuple.index + 1;
        this.parent = parentTuple;
        this.recency = parentTuple.recency + this.handle.getRecency();
        this.hashCode = parentTuple.hashCode ^ (handle.hashCode() * 31);
    }        

    public LeftTuple getLeftParent() {
		return leftParent;
	}

	public void setLeftParent(LeftTuple leftParent) {
		this.leftParent = leftParent;
	}

	public LeftTuple getLeftParentLeft() {
		return leftParentLeft;
	}

	public void setLeftParentLeft(LeftTuple leftParentLeft) {
		this.leftParentLeft = leftParentLeft;
	}

	public LeftTuple getLeftParentright() {
		return leftParentright;
	}

	public void setLeftParentright(LeftTuple leftParentright) {
		this.leftParentright = leftParentright;
	}

	public RightTuple getRightParent() {
		return rightParent;
	}

	public void setRightParent(RightTuple rightParent) {
		this.rightParent = rightParent;
	}

	public RightTuple getRightParentLeft() {
		return rightParentLeft;
	}

	public void setRightParentLeft(RightTuple rightParentLeft) {
		this.rightParentLeft = rightParentLeft;
	}

	public RightTuple getRightParentright() {
		return rightParentright;
	}

	public void setRightParentright(RightTuple rightParentright) {
		this.rightParentright = rightParentright;
	}

	public InternalFactHandle get(final int index) {
        LeftTuple entry = this;
        while ( entry.index != index ) {
            entry = entry.parent;
        }
        return entry.handle;
    }        

    public Entry getPrevious() {
		return previous;
	}

	public void setPrevious(Entry previous) {
		this.previous = previous;
	}

	public void setNext(final Entry next) {
        this.next = next;
    }

    public Entry getNext() {
        return this.next;
    }

    public InternalFactHandle getLastHandle() {
        return this.handle;
    }

    public InternalFactHandle get(final Declaration declaration) {
        return get( declaration.getPattern().getOffset() );
    }

    public Activation getActivation() {
        return this.activation;
    }

    /**
     * Returns the fact handles in reverse order
     */
    public InternalFactHandle[] getFactHandles() {
        final List list = new ArrayList();
        LeftTuple entry = this;
        while ( entry != null ) {
            list.add( entry.handle );
            entry = entry.parent;
        }

        return (InternalFactHandle[]) list.toArray( new InternalFactHandle[list.size()] );
    }

    public long getRecency() {
        return this.recency;
    }
        

    public RightTuple getMatch() {
        return match;
    }

    public void setMatch(RightTuple match) {
        this.match = match;
    }

    public void setActivation(final Activation activation) {
        this.activation = activation;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        final StringBuffer buffer = new StringBuffer();

        LeftTuple entry = this;
        while ( entry != null ) {
            //buffer.append( entry.handle );
            buffer.append( entry.handle + "\n" );
            entry = entry.parent;
        }
        return buffer.toString();
    }

    /**
     * We use this equals method to avoid the cast
     * @param tuple
     * @return
     */
    public boolean equals(final LeftTuple other) {
        // we know the object is never null and always of the  type ReteTuple
        if ( other == this ) {
            return true;
        }

        // A ReteTuple is  only the same if it has the same hashCode, factId and parent
        if ( (other == null) || (this.hashCode != other.hashCode) ) {
            return false;
        }

        if ( this.handle != other.handle ) {
            return false;
        }

        if ( this.parent == null ) {
            return (other.parent == null);
        } else {
            return this.parent.equals( other.parent );
        }
    }

    public boolean equals(final Object object) {
        // we know the object is never null and always of the  type ReteTuple    
        return equals( (LeftTuple) object );
    }

    public int size() {
        return this.index + 1;
    }

    /**
     * Returns the ReteTuple that contains the "elements"
     * first elements in this tuple.
     * 
     * Use carefully as no cloning is made during this process.
     * 
     * This method is used by TupleStartEqualsConstraint when
     * joining a subnetwork tuple into the main network tuple;
     * 
     * @param elements the number of elements to return, starting from
     * the begining of the tuple
     * 
     * @return a ReteTuple containing the "elements" first elements
     * of this tuple or null if "elements" is greater than size; 
     */
    public LeftTuple getSubTuple(final int elements) {
        LeftTuple entry = this;
        if ( elements < this.size() ) {
            final int lastindex = elements - 1;

            while ( entry.index != lastindex ) {
                entry = entry.parent;
            }
        }
        return entry;
    }
    
    public Object[] toObjectArray() {        
        Object[] objects = new Object[ this.index + 1 ];
        LeftTuple entry = this;       
        while ( entry != null ) {
            Object object = entry.getLastHandle().getObject();
            if ( object instanceof ShadowProxy ) {
                object = ((ShadowProxy)object).getShadowedObject();
            }
            objects[entry.index] = object;
            entry = entry.parent;
        }   
        return objects;
    }
}
