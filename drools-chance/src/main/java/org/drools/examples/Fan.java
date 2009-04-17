package org.drools.examples;

import org.drools.degrees.IDegree;
import org.drools.fuzzy.evaluators.IDynamicEvaluable;
import org.drools.spi.Evaluator;


public class Fan implements IDynamicEvaluable {
	
	private SpeedDomain speed = new SpeedDomain();
	
	private float price = 100.0f;
	
	public float getPrice() {
		return price;
	}
	
	
	
	
	
	
	
	
	
	
	public boolean equals(Object other) {
		return (other != null && other instanceof Fan);
	}
		
	public int hashCode() {
		return 37;
	}
	
	
	public Fan() {
		
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(Double speed) {
		this.speed.setValue(speed);
	}
	
	public void setSpeed(String set, IDegree deg) {
		this.speed.setValue(set,deg);
	}
	
	
	/**
	 * @return the speed
	 */
	public Double getSpeed() {
		return speed.getValue();
	}

	
	public Evaluator getPred(String opId) {
		return speed.getEvaluator(opId);
	}
	
	
}