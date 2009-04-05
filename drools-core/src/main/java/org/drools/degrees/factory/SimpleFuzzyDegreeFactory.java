package org.drools.degrees.factory;

import org.drools.reteoo.filters.FuzzyFilterStrategy;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.reteoo.filters.SimpleFilterStrategy;

public class SimpleFuzzyDegreeFactory extends SimpleDegreeFactory {
	
	public IFilterStrategy getDefaultStrategy() {
		return FuzzyFilterStrategy.getInstance();
	}

}
