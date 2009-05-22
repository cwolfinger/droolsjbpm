/**
 * 
 */
package org.drools.base;

import org.drools.RuntimeDroolsException;
import org.drools.WorkingMemory;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ImperfectRuleBase;
import org.drools.rule.VariableRestriction.ObjectVariableContextEntry;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;


/**
 * BaseImperfectEvaluator implements the imperfect evaluators
 * by calling the crisp ones and then converting the boolean
 * result into the used truth degree
 * 
 * @author sotty
 *
 */
public abstract class BaseImperfectEvaluator extends BaseEvaluator  {

	
	public BaseImperfectEvaluator(final ValueType type, final Operator operator, String parameters) {
		super(type,operator);
		this.parseParameters( parameters );	
	}
	
	
	protected IDegreeFactory getFactory(WorkingMemory workingMemory) {
		ImperfectRuleBase irb = (ImperfectRuleBase) workingMemory.getRuleBase();
		if (irb == null) 
			throw new RuntimeDroolsException(this.getClass()+ " Abstract BaseUncertainEvaluator : trying to use uncertain evaluators with crisp rule base");
		return irb.getDegreeFactory();
	}
	
	
	
	public boolean evaluate(InternalWorkingMemory workingMemory,
            final InternalReadAccessor leftExtractor,
            final Object left,
            final InternalReadAccessor rightExtractor,
            final Object right) {
		return evaluate(workingMemory,
				getFactory(workingMemory),
				leftExtractor,
				left,
				rightExtractor,
				right).toBoolean();
	}
    
    public boolean evaluateCachedRight(InternalWorkingMemory workingMemory,
            final VariableContextEntry context,
            final Object left) {
    	return evaluateCachedRight(workingMemory,    					
    					context,
    					getFactory(workingMemory),
    					left).toBoolean();
    }
    
    public boolean evaluateCachedLeft(InternalWorkingMemory workingMemory,
            final VariableContextEntry context,
            final Object right) {
    	return evaluateCachedLeft(workingMemory, 
    					context, 
    					getFactory(workingMemory),
    					right).toBoolean();
    }
    
    public boolean evaluate(InternalWorkingMemory workingMemory,
            final InternalReadAccessor extractor,
            final Object object,
            final FieldValue value) {
    	return evaluate(workingMemory,
    					getFactory(workingMemory),
    					extractor, 
    					object, 
    					value).toBoolean();
    }
    
    
    
    
    
    
    
    public IDegree evaluate(InternalWorkingMemory workingMemory,
    		IDegreeFactory factory, InternalReadAccessor extractor, 
    		Object object1, FieldValue value) {
		        					
		Object field = extractor.getValue(object1);
		    		    								
		return eval(field, value, factory);											
	}
    
	public IDegree evaluate(InternalWorkingMemory workingMemory,
			IDegreeFactory factory, InternalReadAccessor leftExtractor,
			Object left, InternalReadAccessor rightExtractor, Object right) {
		
		Object leftArg = leftExtractor.getValue(workingMemory,left);
		Object rightArg = rightExtractor.getValue(workingMemory,right);
					
		return eval(leftArg, rightArg, factory);
	}
	
	public IDegree evaluateCachedLeft(InternalWorkingMemory workingMemory,
			VariableContextEntry context, IDegreeFactory factory, Object object1) {
					
		Object v1 = ((ObjectVariableContextEntry) context).left;
		Object v2 = object1;
		
		return eval(v1,v2,factory);
	}
	
	public IDegree evaluateCachedRight(InternalWorkingMemory workingMemory,
			VariableContextEntry context, IDegreeFactory factory, Object object) {
			
		Object o1 =  object;
		Object o2 =  ((ObjectVariableContextEntry) context).right;			
		
		return eval(o1,o2,factory);
		
	}

	
	
	
	protected abstract IDegree eval(Object left, Object right, IDegreeFactory factory);
	
	
	public String toString() {
		return getOperator().getOperatorString() ;
	}
	
	
	
	protected void parseParameters(String s) {
		
	}
	

}
