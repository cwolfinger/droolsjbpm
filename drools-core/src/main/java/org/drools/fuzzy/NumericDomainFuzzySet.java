package org.drools.fuzzy;

import org.drools.fuzzy.evaluators.FuzzyNumericEvaluator;
import org.drools.fuzzy.evaluators.membership.IMembershipFunction;
import org.drools.fuzzy.evaluators.membership.INumericSetMembershipFunction;

public class NumericDomainFuzzySet extends FuzzySet {

	public NumericDomainFuzzySet(String name, FuzzyNumericEvaluator mu) {
		super(name, mu);
	}
	
	
	public Number defuzzify() {
		return ((FuzzyNumericEvaluator) this.membershipEvaluator).getCenter();
	}
	
	
}
