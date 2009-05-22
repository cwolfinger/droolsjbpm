package org.drools.degrees.operators;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;

public interface INullHandlingStrategy {

	public IDegree convertNull(IDegreeFactory factory);
	
}
