package org.drools.reteoo.filters;


import org.drools.reteoo.Evaluation;

public abstract class ImperfectFilterStrategy implements IFilterStrategy {

	
	
	
	public abstract boolean isAllowed(final Evaluation eval);
	
	
	public abstract int doTry(final Evaluation eval);
	
	
	public boolean drop(final Evaluation eval) {
		return doTry(eval) == DROP;
	}
	
	public boolean pass(final Evaluation eval) {
		return doTry(eval) == PASS;
	}
	
	public boolean hold(final Evaluation eval) {
		return doTry(eval) == HOLD;
	}
	
	
	

}
