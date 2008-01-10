package org.drools.common;

import java.io.Serializable;

import org.drools.RuleBaseConfiguration;
import org.drools.reteoo.BetaMemory;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.RightTuple;
import org.drools.util.LinkedList;

public interface BetaConstraints
    extends
    Serializable {

    public void updateFromTuple(InternalWorkingMemory workingMemory,
                                LeftTuple tuple);

    public void updateFromRightTuple(InternalWorkingMemory workingMemory,
                                     RightTuple rightTuple);

    public boolean isAllowedCachedLeft(InternalFactHandle handle);

    public boolean isAllowedCachedRight(LeftTuple tuple);

    public LinkedList getConstraints();

    public boolean isIndexed();
    
    public int getIndexCount();

    public boolean isEmpty();

    public BetaMemory createBetaMemory(final RuleBaseConfiguration config);
    
    public void resetTuple();
    
    public void resetFactHandle();    
}