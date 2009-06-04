package org.drools.degrees;

public interface IDegree {
		
	
	public boolean toBoolean();
	
	public SimpleDegree asSimpleDegree();
	
	public double getValue();
	
	public double getConfidence(boolean cwa);
	
}
