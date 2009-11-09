package org.drools.common;

import org.drools.FactHandle;
import org.drools.spi.ReadAccessor;

public class TemporalFactHandle extends DefaultFactHandle {

    private static final long serialVersionUID = 5997141759543399455L;

    private ReadAccessor      startTimestamp;
    private ReadAccessor      endTimestamp;
    private ReadAccessor      duration;

    // ----------------------------------------------------------------------
    // Constructors
    // ----------------------------------------------------------------------

    public TemporalFactHandle() {
        this( 0,
              null,
              0 );
    }

    public TemporalFactHandle(final int id,
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
    public TemporalFactHandle(final int id,
                              final Object object,
                              final long recency) {
        super( id,
               object,
               recency );
    }

    /**
     * Creates a new event fact handle.
     *
     * @param id this event fact handle ID
     * @param object the event object encapsulated in this event fact handle
     * @param recency the recency of this event fact handle
     * @param startTimestamp the field accessor to the start timestamp of the occurrence of this event
     * @param endTimestamp the field accessor to the end timestamp of the occurrence of this event
     * @param duration the duration of this event. May be 0 (zero) in case this is a primitive event.
     */
    public TemporalFactHandle(final int id,
                              final Object object,
                              final long recency,
                              final ReadAccessor startTimestamp,
                              final ReadAccessor endTimestamp,
                              final ReadAccessor duration) {
        super( id,
               object,
               recency );
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.duration = duration;
    }

    /**
     * @see FactHandle
     */
    public String toExternalForm() {
        return "[temporal fid:" + getId() + ":" + getRecency() + ":" + getObject() + " start="+ getStartTimestamp()+" duration="+getDuration()+"]";
    }

    /**
     * @see Object
     */
    public String toString() {
        return toExternalForm();
    }

    /**
     * Always returns false, since the TemporalFactHandle is
     * not used for Events
     */
    public boolean isEvent() {
        return false;
    }

    /**
     * Returns the start timestamp of the occurrence of this temporal fact.
     * @return
     */
    @Override
    public long getStartTimestamp() {
        return startTimestamp != null ? startTimestamp.getLongValue( getObject() ) : Long.MIN_VALUE;
    }

    /**
     * Returns the duration of this temporal fact. 
     *
     * @return
     */
    public long getDuration() {
        return duration != null ? duration.getLongValue( getObject() ) : ( getEndTimestamp() - getStartTimestamp() );
    }

    /**
     * Returns the end timestamp for this temporal fact.
     *
     * startTimestamp + duration
     *
     * @return
     */
    @Override
    public long getEndTimestamp() {
        return endTimestamp != null ? endTimestamp.getLongValue( getObject() ) : 
               ((duration != null) ? getStartTimestamp() + getDuration() : Long.MAX_VALUE );
    }

    public TemporalFactHandle clone() {
        TemporalFactHandle clone = new TemporalFactHandle( getId(),
                                                           getObject(),
                                                           getRecency(),
                                                           startTimestamp,
                                                           endTimestamp,
                                                           duration );
        clone.setEntryPoint( getEntryPoint() );
        clone.setEqualityKey( getEqualityKey() );
        clone.setLeftTuple( getLeftTuple() );
        clone.setRightTuple( getRightTuple() );
        clone.setObjectHashCode( getObjectHashCode() );
        return clone;
    }
    
    @Override
    public boolean isTemporal() {
        return true;
    }
}
