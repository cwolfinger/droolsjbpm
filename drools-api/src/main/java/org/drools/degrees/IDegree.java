package org.drools.degrees;

public interface IDegree {
		
	
	public boolean toBoolean();
	
	public SimpleDegree getDegree();
	
	public float getConfidence(boolean cwa);
	
}
