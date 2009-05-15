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

	public RandomEvaluator(ValueType type, Operator operator) {
		super(type, operator);		
	}

	
	public RandomEvaluator(ValueType type, boolean isNegated,
			String parameterText) {
		super(type, RandomEvaluatorDefinition.RANDOM);
	}


	public boolean evaluate(InternalWorkingMemory workingMemory,
			InternalReadAccessor leftExtractor, Object left,
			InternalReadAccessor rightExtractor, Object right) {
		return getFactory(workingMemory).Random().toBoolean();
	}

	
	public boolean evaluate(InternalWorkingMemory workingMemory,
			InternalReadAccessor extractor, Object object, FieldValue value) {
		return getFactory(workingMemory).Random().toBoolean();
	}

	
	public boolean evaluateCachedLeft(InternalWorkingMemory workingMemory,
			VariableContextEntry context, Object right) {
		return getFactory(workingMemory).Random().toBoolean();
	}

	
	public boolean evaluateCachedRight(InternalWorkingMemory workingMemory,
			VariableContextEntry context, Object left) {
		return getFactory(workingMemory).Random().toBoolean();
	}
	
	
	public String toString() {
		return "random";
	}
	
	
	
	
	
	
	
	public IDegree evaluate(InternalWorkingMemory workingMemory,
			IDegreeFactory factory, InternalReadAccessor extractor,
			Object object, FieldValue value) {
		return factory.Random();
	}

	public IDegree evaluate(InternalWorkingMemory workingMemory,
			IDegreeFactory factory, InternalReadAccessor leftExtractor,
			Object left, InternalReadAccessor rightExtractor, Object right) {
		return factory.Random();
	}

	public IDegree evaluateCachedLeft(InternalWorkingMemory workingMemory,
			VariableContextEntry context, IDegreeFactory factory,
			Object right) {
		return factory.Random();
	}

	public IDegree evaluateCachedRight(InternalWorkingMemory workingMemory,
			VariableContextEntry context, IDegreeFactory factory,
			Object left) {
		return factory.Random();
	}
	
	
	

}
