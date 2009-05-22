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




public class SeemsEvaluator 
	extends BaseImperfectEvaluator  {
	
	


	
	
	public SeemsEvaluator() {		
		this(ValueType.OBJECT_TYPE,false,"");
	}
		
	public SeemsEvaluator(final ValueType type,
            				final boolean isNegated,
            				final String parameters) {
			super( type,
                   SeemsEvaluatorDefinition.SEEMS,
                   parameters);            
	}
	
	

    
    public IDegree evaluate(InternalWorkingMemory workingMemory,
    		IDegreeFactory factory,
			InternalReadAccessor extractor, 			
			Object object1, 
			FieldValue value) {
		
    	Evaluator set = ((IDynamicEvaluable) object1).getPred(value.toString());    	
    	return set.evaluate(workingMemory, factory, extractor, object1, new LongFieldImpl(1));		
	}
    
	

	
	public IDegree evaluate(InternalWorkingMemory workingMemory,
			IDegreeFactory factory,
			InternalReadAccessor leftExtractor, Object left,
			InternalReadAccessor rightExtractor, Object right) {
		

		Object set = rightExtractor.getValue(right);
			if (set == null) {
				return factory.Unknown();
			}
		return ((Evaluator) set).evaluate(workingMemory, factory, leftExtractor, left, new LongFieldImpl(1));
								
	}

	

	@Override
	protected IDegree eval(Object left, Object right, IDegreeFactory factory) {
		return factory.Unknown();
	}
	
	
	

 

	

}
	
	