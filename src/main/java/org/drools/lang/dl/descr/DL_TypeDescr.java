package org.drools.lang.dl.descr;



public class DL_TypeDescr extends DL_LeafDescr {
	
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return  type;
	}
	
	
	public String toString() {
    	StringBuilder sb = new StringBuilder();
    		sb.append("DL["+getId()+"]: Type >> " + (isNegated() ? "not " : "") + getType() +"\n");    	
    	return sb.toString();
    }
	
		
}
