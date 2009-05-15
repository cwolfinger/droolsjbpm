package org.drools.rule;

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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.LinkedList;

import org.drools.base.ClassFieldReader;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.LeftTuple;
import org.drools.spi.AcceptsReadAccessor;
import org.drools.spi.Evaluator;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;
import org.drools.spi.Restriction;

public class LiteralRestriction
    implements
    Restriction,
    AcceptsReadAccessor,    
    Externalizable {

    private static final long          serialVersionUID     = 400L;

    private FieldValue                 field;

    private Evaluator                  evaluator;

    private InternalReadAccessor       readAccessor;

    private static final Declaration[] requiredDeclarations = new Declaration[0];
    
    private boolean					   isCutter;
    
    private String					   label;

    public LiteralRestriction() {
        this( null,
              null,
              null );
    }

    public LiteralRestriction(final FieldValue field,
                              final Evaluator evaluator,
                              final InternalReadAccessor fieldExtractor) {
        this.field = field;
        this.evaluator = evaluator;
        this.readAccessor = fieldExtractor;
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        field = (FieldValue) in.readObject();
        evaluator = (Evaluator) in.readObject();
        readAccessor = (InternalReadAccessor) in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject( field );
        out.writeObject( evaluator );
        out.writeObject( readAccessor );
    }

    public void setReadAccessor(InternalReadAccessor readAccessor) {
        this.readAccessor = readAccessor;
    }    
    
    public Evaluator getEvaluator() {
        return this.evaluator;
    }

    public FieldValue getField() {
        return this.field;
    }

    public boolean isAllowed(final InternalReadAccessor readAccessor,
                             final InternalFactHandle handle,
                             final InternalWorkingMemory workingMemoiry,
                             final ContextEntry context) {
        return this.evaluator.evaluate( null,
                                        this.readAccessor,
                                        handle.getObject(),
                                        this.field );
    }
    
    public IDegree isSatisfied(InternalReadAccessor extractor,
			InternalFactHandle handle, InternalWorkingMemory workingMemory,
			ContextEntry context, IDegreeFactory factory) {
    	return this.evaluator.evaluate( workingMemory,
    			factory,
                this.readAccessor,
                handle.getObject(),
                this.field );
	}

    public boolean isAllowedCachedLeft(final ContextEntry context,
                                       final InternalFactHandle handle) {
        return this.evaluator.evaluate( null,
                                        ((LiteralContextEntry) context).getFieldExtractor(),
                                        handle.getObject(),
                                        this.field );
    }
    
    public IDegree isSatisfiedCachedLeft(ContextEntry context,
			InternalFactHandle handle, IDegreeFactory factory) {
    	return this.evaluator.evaluate( null,
    			factory,
                ((LiteralContextEntry) context).getFieldExtractor(),
                handle.getObject(),
                this.field );
	}

    public boolean isAllowedCachedRight(final LeftTuple tuple,
                                        final ContextEntry context) {
        return this.evaluator.evaluate( null,
                                        ((LiteralContextEntry) context).getFieldExtractor(),
                                        ((LiteralContextEntry) context).getObject(),
                                        this.field );
    }

    
	public IDegree isSatisfiedCachedRight(LeftTuple tuple,
			ContextEntry context, IDegreeFactory factory) {
	    return this.evaluator.evaluate( null,
	    		factory,
                ((LiteralContextEntry) context).getFieldExtractor(),
                ((LiteralContextEntry) context).getObject(),
                this.field );	}

    /**
     * Literal constraints cannot have required declarations, so always return an empty array.
     * @return
     *      Return an empty <code>Declaration[]</code>
     */
    public Declaration[] getRequiredDeclarations() {
        return LiteralRestriction.requiredDeclarations;
    }

    public void replaceDeclaration(Declaration oldDecl,
                                   Declaration newDecl) {
    }

    public boolean isTemporal() {
        return evaluator.isTemporal();
    }

    public String toString() {
        return "[LiteralRestriction evaluator=" + this.evaluator + " value=" + this.field + "]";
    }

    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.evaluator.hashCode();
        result = PRIME * result + ((this.field.getValue() != null) ? this.field.getValue().hashCode() : 0);
        return result;
    }

    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }
        if ( object == null || object.getClass() != LiteralRestriction.class ) {
            return false;
        }
        final LiteralRestriction other = (LiteralRestriction) object;

        return this.field.equals( other.field ) && this.evaluator.equals( other.evaluator );
    }

    public ContextEntry createContextEntry() {
        return new LiteralContextEntry( this.readAccessor );
    }

    public Object clone() {
        return new LiteralRestriction( this.field,
                                       this.evaluator,
                                       this.readAccessor );
    }

    private static class LiteralContextEntry
        implements
        ContextEntry {

        private static final long   serialVersionUID = 2621864784428098347L;
        public InternalReadAccessor extractor;
        public Object               object;
        public ContextEntry         next;

        public LiteralContextEntry() {
        }

        public LiteralContextEntry(final InternalReadAccessor extractor) {
            this.extractor = extractor;
        }

        public void readExternal(ObjectInput in) throws IOException,
                                                ClassNotFoundException {
            extractor = (InternalReadAccessor) in.readObject();
            object = in.readObject();
            next = (ContextEntry) in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject( extractor );
            out.writeObject( object );
            out.writeObject( next );
        }

        public InternalReadAccessor getFieldExtractor() {
            return this.extractor;
        }

        public Object getObject() {
            return this.object;
        }

        public ContextEntry getNext() {
            return this.next;
        }

        public void setNext(final ContextEntry entry) {
            this.next = entry;
        }

        public void updateFromFactHandle(final InternalWorkingMemory workingMemory,
                                         final InternalFactHandle handle) {
            this.object = handle.getObject();
        }

        public void updateFromTuple(final InternalWorkingMemory workingMemory,
                                    final LeftTuple tuple) {
            // nothing to do
        }

        public void resetTuple() {
        }

        public void resetFactHandle() {
            this.object = null;
        }

    }

	
    private ConstraintKey singletonKey = null;
    
	public ConstraintKey getConstraintKey() {
		if (singletonKey == null) {			
			String cName = ((ClassFieldReader) this.readAccessor).getClassName();			
			singletonKey = new ConstraintKey(cName + "."+((ClassFieldReader) this.readAccessor).getFieldName(),this.getEvaluator().toString(),this.getField().toString());
		}
		return singletonKey;
	}
	
	public Collection<ConstraintKey> getAllConstraintKeys() {
		Collection<ConstraintKey> ans = new LinkedList<ConstraintKey>();
					
		ans.add(this.getConstraintKey());
		return ans;
	}

	/**
	 * @param isCutter the isCutter to set
	 */
	public void setCutter(boolean isCutter) {
		this.isCutter = isCutter;
	}

	/**
	 * @return the isCutter
	 */
	public boolean isCutter() {
		return isCutter;
	}
	
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	

}