package org.drools.lang.dl.descr;



public class DL_ValueDescr extends DL_aCompositeDescr {
	
	private Object val;
	
	
	@Override
	public String getType() {
		return (isNegated() ? "not" : "") +  "DL_VALUE";
	}


	public Object getVal() {
		return val;
	}


	public void setVal(Object val) {
		this.val = val;
	}

	
	
}
