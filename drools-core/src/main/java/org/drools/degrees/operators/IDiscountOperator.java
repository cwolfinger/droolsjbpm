package org.drools.degrees.operators;

import org.drools.degrees.IDegree;

public interface IDiscountOperator extends IDegreeCombiner {
	
	public IDegree discount(IDegree arg, float strength);

}
