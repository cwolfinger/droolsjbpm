package org.drools.common;

import org.drools.FactHandle;
import org.drools.spi.ReadAccessor;

/**
 * An effective dated fact handle wraps a fact that is valid only
 * during a given period of time defined by it's own attributes.
 * 
 * @author etirelli
 */
public class EffDatedFactHandle extends DefaultFactHandle {

    private static final long serialVersionUID = 5997141759543399455L;

    private ReadAccessor      effTimestamp;
    private ReadAccessor      expTimestamp;

    // ----------------------------------------------------------------------
    // Constructors
    // ----------------------------------------------------------------------

    public EffDatedFactHandle() {
        this( 0,
              null,
              0 );
    }

    public EffDatedFactHandle(final int id,
                              final Object object) {
        this( id,
              object,
              id );
    }

    /**
     * Construct.
     *
     * @param id
     *            Handle id.
     */
    public EffDatedFactHandle(final int id,
                              final Object object,
                              final long recency) {
        super( id,
               object,
               recency );
    }

    /**
     * Creates a new event fact handle.
     *
     * @param id this fact handle's ID
     * @param object the fact object encapsulated in this fact handle
     * @param recency the recency of this event fact handle
     * @param effTimestamp the field accessor to the effective date for this fact
     * @param expTimestamp the field accessor to the expiration date for this fact
     * @param duration the duration of this event. May be 0 (zero) in case this is a primitive event.
     */
    public EffDatedFactHandle(final int id,
                              final Object object,
                              final long recency,
                              final ReadAccessor effTimestamp,
                              final ReadAccessor expTimestamp ) {
        super( id,
               object,
               recency );
        this.effTimestamp = effTimestamp;
        this.expTimestamp = expTimestamp;
    }

    /**
     * @see FactHandle
     */
    public String toExternalForm() {
        return "[effDated fid:" + getId() + ":" + getRecency() + ":" + getObject() + " effDate="+ getEffectiveTimestamp()+" expDate="+getExpirationTimestamp()+"]";
    }

    /**
     * @see Object
     */
    public String toString() {
        return toExternalForm();
    }

    /**
     * Always returns false, since the EffectiveDatedFactHandle is
     * not used for Events
     */
    public boolean isEvent() {
        return false;
    }

    /**
     * Returns the effective timestamp for this fact.
     * @return
     */
    @Override
    public long getEffectiveTimestamp() {
        return ( effTimestamp != null && !effTimestamp.isNullValue( getObject() ) ) ? effTimestamp.getLongValue( getObject() ) : Long.MIN_VALUE;
    }

    /**
     * Returns the expiration timestamp for this fact.
     *
     * @return
     */
    @Override
    public long getExpirationTimestamp() {
        return ( expTimestamp != null && !expTimestamp.isNullValue( getObject() ) ) ? expTimestamp.getLongValue( getObject() ) : Long.MAX_VALUE;
    }

    public EffDatedFactHandle clone() {
        EffDatedFactHandle clone = new EffDatedFactHandle( getId(),
                                                           getObject(),
                                                           getRecency(),
                                                           effTimestamp,
                                                           expTimestamp );
        clone.setEntryPoint( getEntryPoint() );
        clone.setEqualityKey( getEqualityKey() );
        clone.setLeftTuple( getLeftTuple() );
        clone.setRightTuple( getRightTuple() );
        clone.setObjectHashCode( getObjectHashCode() );
        return clone;
    }
    
    @Override
    public boolean isEffectiveDated() {
        return true;
    }
}
