package org.drools.fuzzy.evaluators.membership;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;


public interface INumericSetMembershipFunction extends IMembershipFunction {

	public void init(String[] args);
	
	public IDegree eval(Number number, IDegreeFactory factory);
	
	
	
	public Number getCenter();
	
}
