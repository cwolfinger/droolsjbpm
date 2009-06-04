package org.drools.reteoo.filters;

import org.drools.reteoo.Evaluation;

public interface IFilterStrategy {

	public enum filterOptions {
		DROP, PASS, HOLD
	};

	// public static final int DROP = 0;
	// public static final int PASS = 1;
	// public static final int HOLD = -1;

	public boolean isAllowed(final Evaluation eval);

	public filterOptions doTry(final Evaluation eval);

}
