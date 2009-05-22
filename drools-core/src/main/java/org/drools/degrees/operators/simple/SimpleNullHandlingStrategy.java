package org.drools.degrees.operators.simple;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.INullHandlingStrategy;

public class SimpleNullHandlingStrategy implements INullHandlingStrategy {

	public IDegree convertNull(IDegreeFactory factory) {
		return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();	
	}

}
