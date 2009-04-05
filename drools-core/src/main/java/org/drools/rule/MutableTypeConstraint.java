/*
 * Copyright 2008 JBoss Inc
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
 *
 * Created on Feb 12, 2008
 */

package org.drools.rule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import java.util.Set;

import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.SingleEvaluationTemplate;
import org.drools.spi.AlphaNodeFieldConstraint;
import org.drools.spi.BetaNodeFieldConstraint;
import org.drools.spi.Constraint;

/**
 * A base class for constraints
 *
 * @author etirelli
 */
public abstract class MutableTypeConstraint
    implements
    AlphaNodeFieldConstraint,
    BetaNodeFieldConstraint,
    Externalizable {

    private Constraint.ConstraintType type = Constraint.ConstraintType.UNKNOWN;
    
    private EvaluationTemplate template;

    public void setType( ConstraintType type ) {
        this.type = type;
    }

    public ConstraintType getType() {
        return this.type;
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        type    =  (Constraint.ConstraintType)in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(type);
    }
    public abstract Object clone();
    
    
    public EvaluationTemplate buildEvaluationTemplate(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
    	setTemplate(new SingleEvaluationTemplate(id,this.getConstraintKey(),dependencies.get(this.getConstraintKey()),factory.getMergeStrategy(),factory.getNullHandlingStrategy()));
    	return getTemplate();
    }
    
    public EvaluationTemplate getTemplate() {
    	return this.template;
    }
    
    public void setTemplate(EvaluationTemplate newTemplate) {
    	this.template = newTemplate;
    }
    
    
    public EvaluationTemplate getEvalTemplate(ConstraintKey key) {
		if (this.template.getConstraintKey().equals(key)) {
			return this.template;
		} else {
			return null;
		}	
	}
    
    
    
}
