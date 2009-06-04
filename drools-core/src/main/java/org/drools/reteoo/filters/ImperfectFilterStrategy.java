package org.drools.reteoo.filters;


import org.drools.reteoo.Evaluation;

public abstract class ImperfectFilterStrategy implements IFilterStrategy {

	
	
	
	public abstract boolean isAllowed(final Evaluation eval);
	
	
	public abstract IFilterStrategy.filterOptions doTry(final Evaluation eval);
	
	
	public boolean drop(final Evaluation eval) {
		return doTry(eval) == IFilterStrategy.filterOptions.DROP;
	}
	
	public boolean pass(final Evaluation eval) {
		return doTry(eval) == IFilterStrategy.filterOptions.PASS;
	}
	
	public boolean hold(final Evaluation eval) {
		return doTry(eval) == IFilterStrategy.filterOptions.HOLD;
	}
	
	
	

}
