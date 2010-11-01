package org.drools.lang.dl.descr;



public class DL_CountDescr extends DL_aCompositeDescr {
	
	private int min = 0;
	private int max = Integer.MAX_VALUE;
	
	@Override
	public String getType() {
		return (isNegated() ? "not" : "") +  "DL_COUNT[" + min + ".." + max + "]";
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	
	
	
	
}
