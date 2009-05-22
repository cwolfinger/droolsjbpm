package org.drools.base.evaluators;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.drools.base.ValueType;
import org.drools.base.evaluators.EvaluatorDefinition.Target;
import org.drools.spi.Evaluator;


public abstract class ImperfectAbstractEvaluatorDefinition implements
		ImperfectEvaluatorDefinition {


	protected Map<String, Evaluator> cache         = Collections.emptyMap();

		
	
	
	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText) {
		return getEvaluator(type, operatorId, isNegated, parameterText, Target.BOTH, Target.BOTH);
	}
	
	
	public abstract Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText, Target leftTarget,
			Target rightTarget);
	
	
	public Evaluator getEvaluator(ValueType type, Operator operator,
			String parameterText) {
		return getEvaluator(type,operator.getOperatorString(),false,parameterText);
	}

	public Evaluator getEvaluator(ValueType type, Operator operator) {
		return getEvaluator(type,operator.getOperatorString(),false,"");
	}
	
	/** 
	 * 
	 * 
	 */
	public boolean isNegatable() {
		return true;
	}

	
	public boolean operatesOnFactHandles() {
		return true;
	}

	public boolean supportsType(ValueType type) {
		return true;
	}

		
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		cache = (Map<String, Evaluator>) in.readObject();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(cache);
	}
		
	public Target getTarget() {
		return Target.BOTH;
	}



	
	

	
	
	
	
	
	
	
	
	

}
