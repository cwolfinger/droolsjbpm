package org.drools.bayesian;

public class BooleanDomain implements IDomain {

	private int focus;
	
	public Double getSize() {
		return new Double(2);
	}
	
	public int getN() {
		return 2;
	}

	public boolean includes(Object o) {
		return (o instanceof Boolean);
	}

	public boolean isFinite() {
		return true;
	}

	
	public int getFocus() {
		return focus <= 0 ? 0 : 1;
	}

	public void setFocus(int j) {
		focus = j <= 0 ? 0 : 1;		
	}

	public void setFocus(Object o) {
		if (o instanceof Boolean) {
			focus = ((Boolean) o) ? 1 : 0; 
		}
		
	}

	
	public boolean equals(Object object) {
		if (object == null)
			return false;
		return object instanceof BooleanDomain;
	}
	
	public int hashCode() {
		return -52643423; 
	}
}
