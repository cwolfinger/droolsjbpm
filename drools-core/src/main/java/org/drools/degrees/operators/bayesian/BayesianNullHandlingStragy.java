package org.drools.degrees.operators.bayesian;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.INullHandlingStrategy;

public class BayesianNullHandlingStragy implements INullHandlingStrategy {

	public IDegree convertNull(IDegreeFactory factory) {
		return factory.Unknown();
	}

}
