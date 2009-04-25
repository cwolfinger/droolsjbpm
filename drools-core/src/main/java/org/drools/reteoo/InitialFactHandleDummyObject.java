/**
 * 
 */
package org.drools.reteoo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class InitialFactHandleDummyObject
    implements
    Externalizable {
    private static final long serialVersionUID = 400L;

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
    }

    public void writeExternal(ObjectOutput out) throws IOException {
    }
    
    public int hashCode() {
    	return -1;
    }
    
    public boolean equals(Object other) {
    	return other instanceof InitialFactHandleDummyObject;
    }
}