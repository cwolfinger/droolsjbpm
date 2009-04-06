package org.drools.fuzzy.evaluators.membership;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;


public class SkepticNumericMembershipFunction implements
		INumericSetMembershipFunction {

	
	public IDegree eval(Number number, IDegreeFactory factory) {
		return factory.Unknown();
	}

	
	public Number getCenter() {
		return 0;
	}

	
	public void init(String[] args) {

	}

	
	public IDegree eval(Object object, IDegreeFactory factory) {
		return factory.Unknown();
	}

}
