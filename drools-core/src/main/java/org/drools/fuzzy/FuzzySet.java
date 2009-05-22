package org.drools.fuzzy;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.fuzzy.evaluators.membership.IMembershipFunction;
import org.drools.spi.Evaluator;

public abstract class FuzzySet implements IDegree {

	protected Evaluator membershipEvaluator;
	protected String name;
	
	public FuzzySet(String name, Evaluator mu) {
		this.name = name;
		this.membershipEvaluator = mu;
	}
	
	public Evaluator getEvaluator() {
		return membershipEvaluator;
	}
	
	public String getName() {
		return name;
	}
	
	public float getConfidence(boolean cwa) {		
		return 1;
	}
	
	
	
	public SimpleDegree getDegree() {
		// TODO Defuzzify here
		return null;
	}

	public boolean toBoolean() {
		return getDegree().toBoolean();
	}

}
