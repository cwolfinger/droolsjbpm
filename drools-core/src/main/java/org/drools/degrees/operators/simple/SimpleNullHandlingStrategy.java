package org.drools.degrees.operators.simple;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.INullHandlingStrategy;

public class SimpleNullHandlingStrategy implements INullHandlingStrategy {

	public IDegree convertNull() {
		return new SimpleDegree(0);
	}

}
