package org.drools.bayesian;

import org.drools.base.ValueType;
import org.drools.bayesian.IDomain;
import org.drools.degrees.IDegree;



public class RealDomain implements IDomain {
	
	private Double value;
	
	public Double getSize() {
		return Double.POSITIVE_INFINITY;
	}
	
	public boolean includes(Object o) {
		return o instanceof Number;
	}
	
	public boolean isFinite() {
		return false;
	}
	
	public int getN() {
		return -1;
	}

	public int getFocus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setFocus(int j) {
		// TODO Auto-generated method stub
		
	}

	public void setFocus(Object o) {
		// TODO Auto-generated method stub
		
	}
}
