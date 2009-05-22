package org.drools.degrees.factory;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.simple.SimpleMaxMergeStrategy;
import org.drools.reteoo.filters.FuzzyFilterStrategy;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.reteoo.filters.SimpleFilterStrategy;

public class SimpleFuzzyDegreeFactory extends SimpleDegreeFactory {
	
	public IDegree Unknown() {
		return SimpleDegree.FALSE();
	}
	
	public IFilterStrategy getDefaultStrategy() {
		return FuzzyFilterStrategy.getInstance();
	}

	public IMergeStrategy getMergeStrategy() {
		return new SimpleMaxMergeStrategy();
	}
	
}
