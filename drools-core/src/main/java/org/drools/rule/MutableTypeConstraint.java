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
import java.util.Collections;
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
    
    private String params;
    


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

	/**
	 * @param params the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param label the label to set
	 */
	public abstract void setLabel(String label);
	/**
	 * @return the label
	 */
	public abstract String getLabel();
    
	
	public EvaluationTemplate buildEvaluationTemplate(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
		 Set<String> deps;
		 
		 String label = this.getLabel();		 
		 Set<String> aliasedDeps = null;
		 	if (dependencies != null && label != null) {
		 		ConstraintKey tester = new ConstraintKey();
		 			tester.setAlias(label);
		 		aliasedDeps = dependencies.remove(tester);
		 		
		 		if (aliasedDeps != null) {
		 			ConstraintKey properKey = this.getConstraintKey();		 						 				
		 			Set<String> previousDeps = dependencies.remove(properKey);
		 			
		 			if (previousDeps != null)
		 				aliasedDeps.addAll(previousDeps);
		 			
		 			properKey.setAlias(label);
		 			
		 			dependencies.put(properKey, aliasedDeps);		 		
		 		}
		 	}
		 	
		 
		 if (dependencies == null)
			 deps = Collections.emptySet();
		 else 
			 deps = dependencies.get(this.getConstraintKey());
		 
		
		 
	   	this.template = new SingleEvaluationTemplate(id,this.getConstraintKey(),deps,factory.getMergeStrategy(),factory.getNullHandlingStrategy());
	   	return template;
	}
    
    
    
    
}
