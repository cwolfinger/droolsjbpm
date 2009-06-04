package org.drools.degrees;

public class IntervalDegree implements IDegree {
	
	
	private double tau;
	private double phi;

	
	public IntervalDegree(double low, double upp) {
		this.setTau(low);
		this.setPhi(1.0f-upp);
	}

	
	
	public SimpleDegree asSimpleDegree() {
		return new SimpleDegree(getTau());
	}

	
	public double getValue() {
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
	protected void setPhi(double phi) {
		this.phi = phi;
	}



	/**
	 * @return the phi
	 */
	public double getPhi() {
		return phi;
	}



	/**
	 * @param tau the tau to set
	 */
	protected void setTau(double tau) {
		this.tau = tau;
	}



	/**
	 * @return the tau
	 */
	public double getTau() {
		return tau;
	}
	
	
	public double getLow() {
		return getTau();
	}
	
	public double getUpp() {
		return 1.0f - getPhi();
	}

	
	public int hashCode() {
		return new Double(getLow()).hashCode()^new Double(getUpp()).hashCode();
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



	public double getConfidence(boolean cwa) {
		return phi+tau;
	}
	
}
