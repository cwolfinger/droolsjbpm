package org.drools.degrees;

public class IntervalDegree implements IDegree {
	
	
	private float tau;
	private float phi;

	
	public IntervalDegree(float low, float upp) {
		this.setTau(low);
		this.setPhi(1.0f-upp);
	}

	
	
	public SimpleDegree getDegree() {
		return new SimpleDegree(getTau());
	}

	
	public float getValue() {
		return getTau();
	}
	
	//TODO : Consider... beware...
	public boolean toBoolean() {
		return getUpp() > 0.5;
	}


	public String toString() {		
		return new StringBuilder("[").append(getLow()).append(',').append(getUpp()).append(']').toString();
	}
	

	/**
	 * @param phi the phi to set
	 */
	protected void setPhi(float phi) {
		this.phi = phi;
	}



	/**
	 * @return the phi
	 */
	public float getPhi() {
		return phi;
	}



	/**
	 * @param tau the tau to set
	 */
	protected void setTau(float tau) {
		this.tau = tau;
	}



	/**
	 * @return the tau
	 */
	public float getTau() {
		return tau;
	}
	
	
	public float getLow() {
		return getTau();
	}
	
	public float getUpp() {
		return 1.0f - getPhi();
	}

	
	public int hashCode() {
		return new Float(getLow()).hashCode()^new Float(getUpp()).hashCode();
	}
	
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (other.getClass().equals(this.getClass()) ) {
			IntervalDegree o = (IntervalDegree) other;
			return (this.phi == o.phi) && (this.tau == o.tau);
		} else {
			return false;
		}		
	}



	public float getConfidence(boolean cwa) {
		return phi+tau;
	}
	
}
