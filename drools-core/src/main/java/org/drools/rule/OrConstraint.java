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

package org.drools.rule;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.CompositeEvaluationTemplate;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.LeftTuple;
import org.drools.rule.AbstractCompositeConstraint.MultiFieldConstraintContextEntry;
import org.drools.spi.AlphaNodeFieldConstraint;
import org.drools.spi.BetaNodeFieldConstraint;
import org.drools.util.ArrayUtils;

/**
 * A class to implement Multi-Field OR constraints, so user can do:
 * 
 * Person( hair == 'blue' || eyes == 'blue' )
 * 
 * @author etirelli
 *
 */
public class OrConstraint extends AbstractCompositeConstraint {

    private static final long serialVersionUID = 400L;

    public OrConstraint() {
    }

    
    

    public EvaluationTemplate buildEvaluationTemplate(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
    	//BUILD A COMPOSITE TEMPLATE    	
    	int N = this.getAlphaConstraints().length + this.getBetaConstraints().length;
    	
    	int Na = this.alphaConstraints.length;
		int Nb = this.betaConstraints.length;		
	
		for (int j = 0; j < Na; j++)
			alphaConstraints[j].buildEvaluationTemplate(id, dependencies, factory);
    	
    	setOperator(factory.getOrOperator(this.getParams()));
    	CompositeEvaluationTemplate temp = new CompositeEvaluationTemplate(id,
    			this.getConstraintKey(),
    			dependencies.get(this.getConstraintKey()),
    			N,
    			getOperator(),
    			factory.getMergeStrategy(),
    			factory.getNullHandlingStrategy(),
    			factory);

    	
		for (int j = 0; j < Na; j++)
			temp.addChild(alphaConstraints[j].getEvalTemplate(alphaConstraints[j].getConstraintKey()));
		//for (int j = 0; j < Nb; j++)
		//	temp.addChild(betaConstraints[j].build);

    	
    	this.setTemplate(temp);
    	return temp;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isAllowed(InternalFactHandle handle,
                             InternalWorkingMemory workingMemory,
                             final ContextEntry ctx) {
        if ( this.alphaConstraints.length > 0 ) {
            for ( int i = 0; i < this.alphaConstraints.length; i++ ) {
                if ( this.alphaConstraints[i].isAllowed( handle,
                                                         workingMemory,
                                                         ((MultiFieldConstraintContextEntry) ctx).alphas[i] ) ) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAllowedCachedLeft(ContextEntry context,
                                       InternalFactHandle handle) {
        if( this.alphaConstraints.length == 0 && this.betaConstraints.length == 0 ) {
            return true;
        }
        for ( int i = 0; i < this.alphaConstraints.length; i++ ) {
            if ( this.alphaConstraints[i].isAllowed( handle,
                                                     ((MultiFieldConstraintContextEntry) context).workingMemory,
                                                     ((MultiFieldConstraintContextEntry) context).alphas[i] ) ) {
                return true;
            }
        }
        for ( int i = 0; i < this.betaConstraints.length; i++ ) {
            if ( this.betaConstraints[i].isAllowedCachedLeft( ((MultiFieldConstraintContextEntry) context).betas[i],
                                                              handle ) ) {
                return true;
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAllowedCachedRight(LeftTuple tuple,
                                        ContextEntry context) {
        if( this.alphaConstraints.length == 0 && this.betaConstraints.length == 0 ) {
            return true;
        }
        for ( int i = 0; i < this.alphaConstraints.length; i++ ) {
            if ( this.alphaConstraints[i].isAllowed( ((MultiFieldConstraintContextEntry) context).handle,
                                                     ((MultiFieldConstraintContextEntry) context).workingMemory,
                                                     ((MultiFieldConstraintContextEntry) context).alphas[i] ) ) {
                return true;
            }
        }
        if ( this.betaConstraints.length > 0 ) {
            for ( int i = 0; i < this.betaConstraints.length; i++ ) {
                if ( this.betaConstraints[i].isAllowedCachedRight( tuple,
                                                                   ((MultiFieldConstraintContextEntry) context).betas[i] ) ) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int PRIME = 31;
        int result = 3; // to differentiate from AND constraint
        result = PRIME * result + ArrayUtils.hashCode( this.alphaConstraints );
        result = PRIME * result + ArrayUtils.hashCode( this.betaConstraints );
        result = PRIME * result + ArrayUtils.hashCode( this.requiredDeclarations );
        return result;
    }

    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }
        if ( object == null || object.getClass() != OrConstraint.class ) {
            return false;
        }
        final OrConstraint other = (OrConstraint) object;

        return Arrays.equals( this.alphaConstraints,
                              other.alphaConstraints ) && Arrays.equals( this.betaConstraints,
                                                                         other.betaConstraints ) && Arrays.equals( this.requiredDeclarations,
                                                                                                                   other.requiredDeclarations );
    }

    public Object clone() {
        OrConstraint clone = new OrConstraint();

        // clone alpha constraints
        clone.alphaConstraints = new AlphaNodeFieldConstraint[this.alphaConstraints.length];
        for ( int i = 0; i < this.alphaConstraints.length; i++ ) {
            clone.alphaConstraints[i] = (AlphaNodeFieldConstraint) this.alphaConstraints[i].clone();
            clone.updateRequiredDeclarations( clone.alphaConstraints[i] );
        }

        // clone beta constraints
        clone.betaConstraints = new BetaNodeFieldConstraint[this.betaConstraints.length];
        for ( int i = 0; i < this.betaConstraints.length; i++ ) {
            clone.betaConstraints[i] = (BetaNodeFieldConstraint) this.betaConstraints[i].clone();
            clone.updateRequiredDeclarations( clone.betaConstraints[i] );
        }

        return clone;
    }

    
    
    public Evaluation isSatisfied(InternalFactHandle handle,
			InternalWorkingMemory workingMemory, ContextEntry context,
			IDegreeFactory factory) {
    	
    	int N = this.alphaConstraints.length;
    	Evaluation[] evals = new Evaluation[N];
    	
    	for ( int i = 0; i < N; i++ ) 
            evals[i] = this.alphaConstraints[i].isSatisfied( handle,
                                                      	workingMemory,
                                                      	((MultiFieldConstraintContextEntry) context).alphas[i],
                                                      	factory);
           
        return getTemplate().spawn(evals);
	}

	 public Evaluation isSatisfiedCachedLeft(ContextEntry context,
				InternalFactHandle handle, IDegreeFactory factory) {
	    	
	    	int N1 = this.alphaConstraints.length;
	    	int N2 = this.betaConstraints.length;
	    	int N = N1 + N2; 
	    	Evaluation[] evals = new Evaluation[N];
	    	
	    	for ( int i = 0; i < N1; i++ ) 
	            evals[i] = this.alphaConstraints[i].isSatisfied( handle,
	            											((MultiFieldConstraintContextEntry) context).workingMemory,
	                                                      	((MultiFieldConstraintContextEntry) context).alphas[i],
	                                                      	factory);
	    	for ( int i = 0; i < N2; i++ )
	    		//TODO : beta...
	    		evals[N1+i] =  
	    			this.betaConstraints[i].isSatisfiedCachedLeft(
	    				((MultiFieldConstraintContextEntry) context).betas[i],
	    				handle, 
	    				factory);
	    				

	    	return getTemplate().spawn(evals);
	    	
		}

	 public Evaluation isSatisfiedCachedRight(LeftTuple tuple,
				ContextEntry context, IDegreeFactory factory) {
			
	    	int N1 = this.alphaConstraints.length;
	    	int N2 = this.betaConstraints.length;
	    	int N = N1 + N2; 
	    	Evaluation[] evals = new Evaluation[N];
	    	
	    	for ( int i = 0; i < N1; i++ ) 
	            evals[i] = this.alphaConstraints[i].isSatisfied( ((MultiFieldConstraintContextEntry) context).handle,
	            											((MultiFieldConstraintContextEntry) context).workingMemory,
	                                                      	((MultiFieldConstraintContextEntry) context).alphas[i],
	                                                      	factory);
	    	for ( int i = 0; i < N2; i++ )
	    		//TODO: beta...
	    		evals[N1+i] =  
	    			this.betaConstraints[i].isSatisfiedCachedRight(
	    				tuple,
	    				((MultiFieldConstraintContextEntry) context).betas[i],    				
	    				factory);
	    				

	    	return getTemplate().spawn(evals);
	    	
		}
	 
	 
	 
	 
	 
	 
	 
	 	private ConstraintKey singletonKey = null;
		private String label;
	    
		public ConstraintKey getConstraintKey() {
			if (singletonKey == null) {
				int Na = this.alphaConstraints.length;
				int Nb = this.betaConstraints.length;
				ConstraintKey[] cks = new ConstraintKey[Na+Nb];
				for (int j = 0; j < Na; j++)
					cks[j] = this.alphaConstraints[j].getConstraintKey();
				for (int j = 0; j < Nb; j++)
					cks[Na+j] = this.betaConstraints[j].getConstraintKey();
				String opStr = this.getOperator().getName();
				singletonKey = new ConstraintKey( opStr , cks);
			}
			return singletonKey;
		}
	 
		public Collection<ConstraintKey> getAllConstraintKeys() {
			Collection<ConstraintKey> ans = new LinkedList<ConstraintKey>();
			
				int Na = this.alphaConstraints.length;
				int Nb = this.betaConstraints.length;		
			
				for (int j = 0; j < Na; j++)
					ans.add(alphaConstraints[j].getConstraintKey());
				for (int j = 0; j < Nb; j++)
					ans.add(betaConstraints[j].getConstraintKey());
						
			ans.add(this.getConstraintKey());
			return ans;
		}
		
		public String getLabel() {
			return this.label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
		
}
