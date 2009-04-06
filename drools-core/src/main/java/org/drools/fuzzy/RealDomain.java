package org.drools.fuzzy;

import org.drools.base.ValueType;
import org.drools.degrees.IDegree;



public abstract class RealDomain extends FuzzyDomain {
	
	private Double value;
	
	
	public Double getValue() {
		if (value != null)
			return value;
		else if (getPossibilityDistribution() == null)
			return null;
		else return ((NumericDomainFuzzySet) getPossibilityDistribution()).defuzzify().doubleValue(); 
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	protected void setValueBit(Double value) {
		if (this.value == null)
			this.value = value;
		else this.value += value;
	}
	
	
	public void setValue(String op, IDegree deg) {
		System.out.println(this.getClass()+" WARNING : NEED TO IMPLEMENT Alpha-Cuts AND SET UNION");
		double refVal = ((NumericDomainFuzzySet) this.getGranule(op)).defuzzify().doubleValue(); 
		double wgt = deg.getDegree().getValue();
		
		setValueBit(refVal*wgt); 
	}
	
	
	public boolean supportsType(ValueType type) {
		
		return type.isNumber();
	}


}
