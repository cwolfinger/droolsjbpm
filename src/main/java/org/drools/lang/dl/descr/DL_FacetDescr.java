package org.drools.lang.dl.descr;

public class DL_FacetDescr extends DL_aLeafDescr {

	private String op;
	
	private Object val;
	
	public String getType() {
		return "facet";
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

}
