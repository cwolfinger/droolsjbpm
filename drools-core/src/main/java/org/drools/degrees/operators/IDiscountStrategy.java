package org.drools.degrees.operators;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;

public interface IDiscountStrategy {
	
	public IDegree[] discount(IDegree[] args, boolean[] flags, IDegreeFactory factory);

}
