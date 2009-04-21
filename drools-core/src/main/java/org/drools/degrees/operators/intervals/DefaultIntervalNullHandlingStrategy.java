package org.drools.degrees.operators.intervals;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.INullHandlingStrategy;

public class DefaultIntervalNullHandlingStrategy implements
		INullHandlingStrategy {

	public IDegree convertNull() {
		return IntervalDegreeFactory.UNKNOWN;
	}

}
