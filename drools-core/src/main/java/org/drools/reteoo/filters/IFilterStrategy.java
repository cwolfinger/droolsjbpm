package org.drools.reteoo.filters;


import org.drools.reteoo.Evaluation;

public interface IFilterStrategy {
	
	public static final int DROP = 0;
	public static final int PASS = 1;
	public static final int HOLD = -1;
	
	public boolean isAllowed(final Evaluation eval);
	
	public int doTry(final Evaluation eval);

}
