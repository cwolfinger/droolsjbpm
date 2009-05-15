package org.drools.common;

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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ArgList;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.ImperfectLeftTuple;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.SingleEvaluationTemplate;
import org.drools.rule.ContextEntry;
import org.drools.rule.Declaration;
import org.drools.rule.Pattern;
import org.drools.spi.BetaNodeFieldConstraint;
import org.drools.util.LinkedListEntry;

public class InstanceNotEqualsConstraint
    implements
    BetaNodeFieldConstraint {

    private static final long          serialVersionUID = 400L;

    private static Declaration[] declarations     = new Declaration[0];

    private Pattern                     otherPattern;

    public InstanceNotEqualsConstraint() {

    }

    public InstanceNotEqualsConstraint(final Pattern otherPattern) {
        this.otherPattern = otherPattern;

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        declarations    = (Declaration[])in.readObject();
        otherPattern    = (Pattern)in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(declarations);
        out.writeObject(otherPattern);
    }

    public Declaration[] getRequiredDeclarations() {
        return InstanceNotEqualsConstraint.declarations;
    }

    public void replaceDeclaration(Declaration oldDecl,
                                   Declaration newDecl) {
    }

    public Pattern getOtherPattern() {
        return this.otherPattern;
    }

    public boolean isTemporal() {
        return false;
    }

    public ContextEntry createContextEntry() {
        return new InstanceNotEqualsConstraintContextEntry( this.otherPattern );
    }

    public boolean isAllowed(final ContextEntry entry) {
        final InstanceNotEqualsConstraintContextEntry context = (InstanceNotEqualsConstraintContextEntry) entry;
        return context.left != context.right;
    }

    public boolean isAllowedCachedLeft(final ContextEntry context,
                                       final InternalFactHandle handle) {
        return ((InstanceNotEqualsConstraintContextEntry) context).left != handle.getObject();
    }
    
    public Evaluation isSatisfiedCachedLeft(ContextEntry context,
			InternalFactHandle handle, IDegreeFactory factory) {
		return getTemplate().spawn(factory.fromBoolean(isAllowedCachedLeft(context, handle)),new ArgList(handle.getObject()));
	}

	

    public boolean isAllowedCachedRight(final LeftTuple tuple,
                                        final ContextEntry context) {
        return tuple.get( this.otherPattern.getOffset() ).getObject() != ((InstanceNotEqualsConstraintContextEntry) context).right;
    }
    
    public Evaluation isSatisfiedCachedRight(LeftTuple tuple,
			ContextEntry context, IDegreeFactory factory) {
		return getTemplate().spawn(factory.fromBoolean(isAllowedCachedRight(tuple, context)),((ImperfectLeftTuple) tuple).getArgList());
	}

    public String toString() {
        return "[InstanceEqualsConstraint otherPattern=" + this.otherPattern + " ]";
    }

    public int hashCode() {
        return this.otherPattern.hashCode();
    }

    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }

        if ( object == null || !(object instanceof InstanceNotEqualsConstraint) ) {
            return false;
        }

        final InstanceNotEqualsConstraint other = (InstanceNotEqualsConstraint) object;
        return this.otherPattern.equals( other.otherPattern ) && (this.isCutter() == other.isCutter());
    }

    public Object clone() {
        return new InstanceNotEqualsConstraint( this.otherPattern );
    }

    public ConstraintType getType() {
        return ConstraintType.BETA;
    }

    public static class InstanceNotEqualsConstraintContextEntry
        implements
        ContextEntry {

        private static final long serialVersionUID = 400L;
        public Object             left;
        public Object             right;

        private Pattern            pattern;
        private ContextEntry      entry;

        public InstanceNotEqualsConstraintContextEntry() {
        }

        public InstanceNotEqualsConstraintContextEntry(final Pattern pattern) {
            this.pattern = pattern;
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            left    = in.readObject();
            right   = in.readObject();
            pattern = (Pattern)in.readObject();
            entry   = (ContextEntry)in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(left);
            out.writeObject(right);
            out.writeObject(pattern);
            out.writeObject(entry);
        }

        public ContextEntry getNext() {
            return this.entry;
        }

        public void setNext(final ContextEntry entry) {
            this.entry = entry;
        }

        public void updateFromTuple(final InternalWorkingMemory workingMemory,
                                    final LeftTuple tuple) {
            this.left = tuple.get( this.pattern.getOffset() ).getObject();
        }

        public void updateFromFactHandle(final InternalWorkingMemory workingMemory,
                                         final InternalFactHandle handle) {
            this.right = handle.getObject();
        }

        public void resetTuple() {
            this.left = null;
        }

        public void resetFactHandle() {
            this.right = null;
        }
    }

    

    private ConstraintKey singletonKey = null;

	private EvaluationTemplate template;

	private boolean cutter;
    
	public ConstraintKey getConstraintKey() {
		if (singletonKey == null) {			
			singletonKey = new ConstraintKey("this","!=","other");
		}
		return singletonKey;
	}
	
	public Collection<ConstraintKey> getAllConstraintKeys() {
		Collection<ConstraintKey> ans = new LinkedList<ConstraintKey>();
			ans.add(getConstraintKey());
	return ans;
	}

	
	public EvaluationTemplate getTemplate() {
		return null;
	}
	
	public EvaluationTemplate getEvalTemplate(ConstraintKey key) {
		if (this.template.getConstraintKey().equals(key))
			return template;
		return null;
	}

	public EvaluationTemplate buildEvaluationTemplate(int id,
			Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
		template = new SingleEvaluationTemplate(id,
												this.getConstraintKey(),
												dependencies.get(this.getConstraintKey()),
												factory.getMergeStrategy(),
												factory.getNullHandlingStrategy());
		return template;
	}
	
	public boolean isCutter() {
		return cutter;
	}
	
	public void setCutter(boolean cut) {
		cutter = cut;
	}

	

}