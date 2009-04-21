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

}
