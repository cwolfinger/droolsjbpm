package org.drools.lang.dl.descr;


public class DL_AndDescr extends DL_CompositeDescr {

	@Override	
	public String getType() {
		return (isNegated() ? "not" : "") +  "DL_AND";
	}
	
	
	
}
