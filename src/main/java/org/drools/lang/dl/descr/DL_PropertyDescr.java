package org.drools.lang.dl.descr;



public class DL_PropertyDescr extends DL_LeafDescr {
	
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public String toString() {
		return "Property >>> " + (isNegated() ? "not" : "") +  type;
	}
	
	
	
}
