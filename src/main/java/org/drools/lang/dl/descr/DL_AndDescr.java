package org.drools.lang.dl.descr;


public class DL_AndDescr extends DL_aCompositeDescr {

	@Override	
	public String getType() {
		return (isNegated() ? "not" : "") +  "DL_AND";
	}
	
	
	
}
