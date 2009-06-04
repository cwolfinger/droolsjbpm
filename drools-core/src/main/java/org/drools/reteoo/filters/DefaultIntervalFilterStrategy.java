package org.drools.reteoo.filters;

import org.drools.degrees.IntervalDegree;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.filters.IFilterStrategy;


public class DefaultIntervalFilterStrategy implements IFilterStrategy {

	private static DefaultIntervalFilterStrategy singleton = null;
	
	public static DefaultIntervalFilterStrategy getInstance() {
		if (singleton == null)
			singleton = new DefaultIntervalFilterStrategy();
		return singleton;
	}
	
	
	public DefaultIntervalFilterStrategy() { }
	
	/**
	 * @deprecated
	 * Testing purposes
	 */
	public IFilterStrategy.filterOptions doTry(Evaluation eval) {
		/*
		System.out.println(""+eval.getInfoRate());
		
		if (eval.getDegree().toBoolean() && eval.getInfoRate() == 1.0f) 
			return PASS;
		else if (eval.getDegree().toBoolean() && eval.getInfoRate() < 1.0f)
			return HOLD;
		else 
			return DROP;
			*/
		
		return (eval.getInfoRate() == 1) ? IFilterStrategy.filterOptions.PASS : IFilterStrategy.filterOptions.HOLD;
		
	}

	
	public boolean isAllowed(Evaluation eval) {
		return doTry(eval) == IFilterStrategy.filterOptions.PASS;
	}

}
