package org.drools.reteoo;

import org.drools.common.InternalFactHandle;
import org.drools.util.Entry;

public class RightTuple
    implements
    Entry {
    private final InternalFactHandle handle;

    private final RightTuple         parent;
    private RightTuple               parentPrevious;
    private RightTuple               parentNext;

    private Entry                    previous;
    private Entry                    next;

    private RightTuple               alphaChildren;
    private LeftTuple                betaChildren;

    private LeftTuple                blocked;

    private RightTupleSink           sink;

    private int                      hashCode;

    public RightTuple(InternalFactHandle handle) {
        this.handle = handle;
        this.hashCode = this.handle.hashCode();
        this.parent = null;
    }
    
    public RightTuple(InternalFactHandle handle,
                      RightTupleSink sink) {
        this.handle = handle;
        this.hashCode = this.handle.hashCode();
        this.parent = null;
        this.sink = sink;
    }    

    public RightTuple(RightTuple parent) {
        this.handle = parent.getHandle();
        this.hashCode = this.handle.hashCode();
        this.parent = parent;

        this.parentNext = parent.getAlphaChildren();
        if  (parentNext != null ) {
            this.parentNext.parentPrevious = this;
        }
        parent.setAlphaChildren( this );
    }

    public RightTuple(RightTuple parent,
                      RightTupleSink sink) {
        this.handle = parent.getHandle();
        this.hashCode = this.handle.hashCode();
        this.parent = parent;

        this.parentNext = parent.getAlphaChildren();
        if  (parentNext != null ) {
            this.parentNext.parentPrevious = this;
        }
        parent.setAlphaChildren( this );
        
        this.sink = sink;


    }

    public RightTupleSink getRightTupleSink() {
        return this.sink;
    }

    public void unlinkFromRightParent() {
        if ( this.parent != null ) {            
            if ( this.parentPrevious != null ) {
                this.parentPrevious.parentNext = this.parentNext;                
            } else {
                // first one in the chain, so treat differently                
                this.parent.setAlphaChildren( this.parentNext );                
            }
            
            if (  this.parentNext != null ) {
                this.parentNext.parentPrevious = this.parentPrevious;
            }
        }
    }

    public InternalFactHandle getHandle() {
        return this.handle;
    }

    public RightTuple getParent() {
        return parent;
    }

    public RightTuple getParentPrevious() {
        return parentPrevious;
    }

    public void setParentPrevious(RightTuple parentPrevious) {
        this.parentPrevious = parentPrevious;
    }       

    public RightTuple getParentNext() {
        return parentNext;
    }
    
    public void setParentNext(RightTuple parentNext) {
        this.parentNext = parentNext;
    }    

    public LeftTuple getBlocked() {
        return blocked;
    }

    public void setBlocked(LeftTuple blocked) {
        this.blocked = blocked;
    }

    public Entry getPrevious() {
        return previous;
    }

    public void setPrevious(Entry previous) {
        this.previous = previous;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public RightTuple getAlphaChildren() {
        return alphaChildren;
    }

    public void setAlphaChildren(RightTuple alphaChildren) {
        this.alphaChildren = alphaChildren;
    }

    public LeftTuple getBetaChildren() {
        return betaChildren;
    }

    public void setBetaChildren(LeftTuple betachildren) {
        this.betaChildren = betachildren;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public int hashCode() {
        return this.hashCode;
    }
    
    public String toString() {
        return this.handle.toString() + "\n";
    }    

    public boolean equals(RightTuple other) {
        // we know the object is never null and always of the  type ReteTuple
        if ( other == this ) {
            return true;
        }

        // A ReteTuple is  only the same if it has the same hashCode, factId and parent
        if ( (other == null) || (this.hashCode != other.hashCode) ) {
            return false;
        }

        return this.handle == other.handle;
    }

    public boolean equals(Object object) {
        return equals( (RightTuple) object );
    }

}
