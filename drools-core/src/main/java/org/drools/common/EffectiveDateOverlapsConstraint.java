/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.common;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.reteoo.LeftTuple;
import org.drools.rule.ContextEntry;
import org.drools.rule.Declaration;
import org.drools.spi.BetaNodeFieldConstraint;

/**
 * This constraint checks for overlaps in the effective/expiration dates
 * for the handle and the tuple.
 * 
 * This constraint is used in conjunction with effective dated facts.
 *
 * @author <a href="mailto:tirelli@post.com">Edson Tirelli</a>
 *
 * @version $Id$
 */

public class EffectiveDateOverlapsConstraint
    implements
    BetaNodeFieldConstraint {

    private static final long                            serialVersionUID  = 510L;

    private static final Declaration[]                   EMPTY_DECLARATION = new Declaration[0];

    // this is a fly-weight
    public static final EffectiveDateOverlapsConstraint POSITIVE_INSTANCE = new EffectiveDateOverlapsConstraint( false );
    public static final EffectiveDateOverlapsConstraint NEGATIVE_INSTANCE = new EffectiveDateOverlapsConstraint( true );
    
    private boolean negative;

    private EffectiveDateOverlapsConstraint( final boolean negative ) {
        this.negative = negative;
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        negative = in.readBoolean();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean( negative );
    }

    public Declaration[] getRequiredDeclarations() {
        return EMPTY_DECLARATION;
    }

    public void replaceDeclaration(Declaration oldDecl,
                                   Declaration newDecl) {
    }

    public boolean isTemporal() {
        return false;
    }

    public ContextEntry createContextEntry() {
        return new EffectiveDateOverlapsContextEntry();
    }

    public boolean isAllowedCachedLeft(final ContextEntry context,
                                       final InternalFactHandle handle) {
        LeftTuple leftTuple = ((EffectiveDateOverlapsContextEntry) context).left;
        return isThereEffDateOverlap( handle,
                                      leftTuple );
    }

    public boolean isAllowedCachedRight(final LeftTuple leftTuple,
                                        final ContextEntry context) {
        final InternalFactHandle handle = ((EffectiveDateOverlapsContextEntry) context).right;
        return isThereEffDateOverlap( handle,
                                      leftTuple );
    }

    private boolean isThereEffDateOverlap(final InternalFactHandle handle,
                                          LeftTuple leftTuple) {
        if ( leftTuple.isEffectiveDated() || handle.isEffectiveDated() ) {
            return negative ^ (leftTuple.getEffectiveTimestamp() >= handle.getEffectiveTimestamp() && leftTuple.getEffectiveTimestamp() <= handle.getExpirationTimestamp())
                   || (leftTuple.getExpirationTimestamp() >= handle.getEffectiveTimestamp() && leftTuple.getExpirationTimestamp() <= handle.getExpirationTimestamp());
        }
        return negative ^ true;
    }

    public String toString() {
        return "[EffectiveDateOverlapsConstraint ]";
    }

    public ConstraintType getType() {
        return ConstraintType.BETA;
    }

    public Object clone() {
        // this is a fly-weight
        return negative ? NEGATIVE_INSTANCE : POSITIVE_INSTANCE;
    }

    public int hashCode() {
        // this is a fly-weight
        return negative ? 31 : 17;
    }

    public boolean equals(final Object object) {
        if ( object == null || !(object instanceof EffectiveDateOverlapsConstraint) ) {
            return false;
        }
        return negative == ((EffectiveDateOverlapsConstraint)object).negative;
    }

    public static class EffectiveDateOverlapsContextEntry
        implements
        ContextEntry {

        private static final long serialVersionUID = 510L;

        public LeftTuple          left;
        public InternalFactHandle right;

        // this is s linked list
        private ContextEntry      entry;

        public EffectiveDateOverlapsContextEntry() {
        }

        public void readExternal(ObjectInput in) throws IOException,
                                                ClassNotFoundException {
            left = (LeftTuple) in.readObject();
            right = (InternalFactHandle) in.readObject();
            entry = (ContextEntry) in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject( left );
            out.writeObject( right );
            out.writeObject( entry );
        }

        public ContextEntry getNext() {
            return this.entry;
        }

        public void setNext(final ContextEntry entry) {
            this.entry = entry;
        }

        public void updateFromTuple(final InternalWorkingMemory workingMemory,
                                    final LeftTuple tuple) {
            this.left = tuple;
        }

        public void updateFromFactHandle(final InternalWorkingMemory workingMemory,
                                         final InternalFactHandle handle) {
            this.right = handle;
        }

        public void resetTuple() {
            this.left = null;
        }

        public void resetFactHandle() {
            this.right = null;
        }
    }

}
