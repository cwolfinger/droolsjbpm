package org.drools.reteoo;

import org.drools.common.InternalFactHandle;
import org.drools.util.Entry;
import org.drools.util.Iterator;

public interface RightTupleMemory {
    public Iterator iterator();

    public Iterator iterator(LeftTuple leftTuple);

    public boolean add(RightTuple rightTuple,
                       boolean checkExists);

    public boolean add(RightTuple rightTuple);

    public boolean remove(RightTuple rightTuple);

    public boolean contains(RightTuple rightTuple);

    public boolean isIndexed();

    public int size();

}
