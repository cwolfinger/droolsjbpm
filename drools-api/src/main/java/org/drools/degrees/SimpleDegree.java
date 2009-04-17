package org.drools.degrees;

public class SimpleDegree extends Degree {
	
	private float value;

	/**
	 * @param degree the degree to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the degree
	 */
	public float getValue() {
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
	
	public static IDegree UNKNOWN() {
		return null;
	}
	
	
	
	public SimpleDegree(float degree) {
		this.value = degree;
	}
	
	
	
	
	public boolean toBoolean() {		
		return value > 0.5;
	}

	public SimpleDegree getDegree() {
		return this;
	}

	
	public String toString() {
		return ""+value;
	}
	
}
