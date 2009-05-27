package org.drools.fuzzy.evaluators;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.RuntimeDroolsException;
import org.drools.WorkingMemory;
import org.drools.base.BaseImperfectEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.Operator;
import org.drools.base.field.LongFieldImpl;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ImperfectRuleBase;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.Evaluator;
import org.drools.spi.FieldValue;

import org.drools.spi.InternalReadAccessor;




public class EvalEvaluator 
	extends BaseImperfectEvaluator  {
	
	


	
	
	public EvalEvaluator() {		
		this(ValueType.OBJECT_TYPE,false,"");
	}
		
	public EvalEvaluator(final ValueType type,
            				final boolean isNegated,
            				final String parameters) {
			super( type,
                   EvalEvaluatorDefinition.EVAL,
                   parameters);            
	}
	
	

    
    public IDegree evaluate(InternalWorkingMemory workingMemory,
    		IDegreeFactory factory,
			InternalReadAccessor extractor, 			
			Object object1, 
			FieldValue value) {

    	Object o = extractor.getValue(object1);
    	if (o instanceof BaseImperfectEvaluator) {
			BaseImperfectEvaluator evaluator = (BaseImperfectEvaluator) o;
			
			Object arg = value.getValue();
			
			return evaluator.eval(arg, arg, factory);
		}	
		return factory.Unknown();
    	    	    		
	}
    
	

	
	public IDegree evaluate(InternalWorkingMemory workingMemory,
			IDegreeFactory factory,
			InternalReadAccessor leftExtractor, Object left,
			InternalReadAccessor rightExtractor, Object right) {

		Object o = leftExtractor.getValue(left);
    	if (o instanceof BaseImperfectEvaluator) {
			BaseImperfectEvaluator evaluator = (BaseImperfectEvaluator) o;
			
			Object arg = rightExtractor.getValue(right);
			
			return evaluator.eval(arg, arg, factory);
		}	
		return factory.Unknown();
		
								
	}

	

	@Override
	public IDegree eval(Object left, Object right, IDegreeFactory factory) {
		//shouldn't get here
		return factory.Unknown();
	}
	
	
	

 

	

}
	
	