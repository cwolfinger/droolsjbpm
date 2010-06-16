package org.drools.lang.dl.descr;



public class DL_ForallDescr extends DL_CompositeDescr {
	
	private boolean negated = false;

	
	@Override
	public String getType() {
		return (isNegated() ? "not" : "") +  "DL_FORALL";
	}


	
	
}
