package org.drools.reteoo.filters;

import org.drools.reteoo.Evaluation;

public class SimpleFilterStrategy extends ImperfectFilterStrategy {

	
	private static SimpleFilterStrategy singleton = null;
	
	public static SimpleFilterStrategy getInstance() {
		if (singleton == null)
			singleton = new SimpleFilterStrategy();
		return singleton;
	}
	
	
	public SimpleFilterStrategy() { }
	
	@Override
	public int doTry(Evaluation eval) {
		//return eval.getDegree().toBoolean() ? PASS : DROP;
		System.out.println(""+eval.getInfoRate());
		if (eval.getDegree().toBoolean() && eval.getInfoRate() == 1.0f) 
			return PASS;
		else if (eval.getDegree().toBoolean() && eval.getInfoRate() < 1.0f)
			return HOLD;
		else 
			return DROP;
		
	}

	@Override
	public boolean isAllowed(Evaluation eval) {
		return doTry(eval) == PASS;
	}

}
