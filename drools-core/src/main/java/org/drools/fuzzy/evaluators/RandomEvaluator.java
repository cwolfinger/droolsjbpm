package org.drools.fuzzy.evaluators;

import org.drools.base.BaseImperfectEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;

public class RandomEvaluator extends BaseImperfectEvaluator {

	
	public RandomEvaluator(ValueType type, boolean isNegated,
			String parameterText) {
		super(type, RandomEvaluatorDefinition.RANDOM, parameterText);
	}


	


	@Override
	public IDegree eval(Object left, Object right, IDegreeFactory factory) {
		return factory.buildDegree((float) Math.random());
	}
	
	
	
	
	
	
	

}
