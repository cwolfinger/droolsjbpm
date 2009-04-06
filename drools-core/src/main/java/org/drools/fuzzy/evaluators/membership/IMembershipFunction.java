package org.drools.fuzzy.evaluators.membership;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;



public interface IMembershipFunction {

	public IDegree eval(Object object, IDegreeFactory factory);
	
}
