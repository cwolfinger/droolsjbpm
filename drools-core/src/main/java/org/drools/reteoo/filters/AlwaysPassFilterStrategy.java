package org.drools.reteoo.filters;

import org.drools.reteoo.Evaluation;

public class AlwaysPassFilterStrategy extends ImperfectFilterStrategy {

	
	private static AlwaysPassFilterStrategy singleton = null;
	
	public static AlwaysPassFilterStrategy getInstance() {
		if (singleton == null)
			singleton = new AlwaysPassFilterStrategy();
		return singleton;
	}
	
	
	public AlwaysPassFilterStrategy() { }
	
	@Override
	public IFilterStrategy.filterOptions doTry(Evaluation eval) {
		return filterOptions.PASS;
		
	}

	@Override
	public boolean isAllowed(Evaluation eval) {
		return doTry(eval) == filterOptions.PASS;
	}

}
