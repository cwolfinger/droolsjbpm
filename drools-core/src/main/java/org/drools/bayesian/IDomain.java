package org.drools.bayesian;

public interface IDomain {

	public Double getSize();
	
	public int getN();
	
	public boolean isFinite();
	
	public boolean includes(Object o);
	
	public int getFocus();
	
	public void setFocus(int j);
	
	public void setFocus(Object o);
	
}
