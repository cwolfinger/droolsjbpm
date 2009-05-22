package org.drools.fuzzy;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.Map;

import org.drools.base.ValueType;
import org.drools.base.evaluators.EvaluatorDefinition;
import org.drools.base.evaluators.ImperfectEvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.base.evaluators.EvaluatorDefinition.Target;
import org.drools.spi.Evaluator;

public abstract class FuzzyDomain implements ImperfectEvaluatorDefinition {
	
	
	private Map<String, FuzzySet> granules;
	
	private FuzzySet possibility;
	
	
	public FuzzyDomain() {
		granules = new HashMap<String, FuzzySet>();
	}
	
	
	public void addGranule(FuzzySet set) {
		granules.put(set.getName(),set);
	}
	
	protected FuzzySet getGranule(String id) {
		return granules.get(id);
	}
	
	
	public FuzzySet getReferenceSet(String name) {
		return granules.get(name);
	}
	
	public FuzzySet getPossibilityDistribution() {
		return possibility;
	}
	
	public void setPossibilityDistribution(FuzzySet distro) {
		possibility = distro;
	}
	
	
	public abstract String[] getEvaluatorIds();
	
	
	
	
	

	
	
	
	
	
	
	
	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText, Target leftTarget,
			Target rightTarget) {
		return getEvaluator(operatorId);
	}


	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText) {
		return getEvaluator(operatorId);
	}


	public Evaluator getEvaluator(ValueType type, Operator operator,
			String parameterText) {
		return getEvaluator(operator.getOperatorString());
	}


	public Evaluator getEvaluator(ValueType type, Operator operator) {
		return getEvaluator(operator.getOperatorString());
	}


	public Evaluator getEvaluator(String operatorString) {
		return getGranule(operatorString).getEvaluator();
	}


	public Target getTarget() {
		return Target.FACT;
	}


	public boolean isNegatable() {
		return true;
	}


	

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		//TODO
		throw new UnsupportedOperationException(this.getClass()+"Serialization not supported yet");
	}


	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO 
		throw new UnsupportedOperationException(this.getClass()+"Serialization not supported yet");
	}

	
	
}
