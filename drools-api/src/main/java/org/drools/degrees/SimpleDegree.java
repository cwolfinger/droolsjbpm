package org.drools.degrees;

public class SimpleDegree extends Degree {
	
	private double value;

	/**
	 * @param degree the degree to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the degree
	 */
	public double getValue() {
		return value;
	}

	
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (! (other instanceof SimpleDegree)) return false;
		return this.value == ((SimpleDegree) other).value;
	}
	
	
	
	public static IDegree TRUE() {
		return new SimpleDegree(1);
	}
	
	public static IDegree FALSE() {
		return new SimpleDegree(0);
	}
	
	public static IDegree UNKNOWN(boolean cwa) {
		return cwa ? FALSE() : TRUE();
	}
	
	
	
	public SimpleDegree(double degree) {
		this.value = degree;
	}
	
	
	
	
	public boolean toBoolean() {		
		return value > 0;
	}

	public SimpleDegree asSimpleDegree() {
		return this;
	}

	
	public String toString() {
		return ""+value;
	}

	public double getConfidence(boolean cwa) {
		return Math.abs(this.value - UNKNOWN(cwa).getValue());
	}
	
}
