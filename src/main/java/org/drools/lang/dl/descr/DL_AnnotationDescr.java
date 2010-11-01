package org.drools.lang.dl.descr;


public class DL_AnnotationDescr extends DL_aBaseDescr {

	
	private DL_IriDescr iriKey;
	
	private Object targetValue;
	
				
	public DL_AnnotationDescr() {
		
	}
	
	
	public DL_AnnotationDescr(DL_IriDescr key, String value) {
		this.iriKey = key;
		this.targetValue = value;
	}
	
	
	
	@Override
	public String getType() {
		return "Annotations";
	}
	
	

	public DL_IriDescr getIriKey() {
		return iriKey;
	}

	public void setIriKey(DL_IriDescr iriKey) {
		this.iriKey = iriKey;
	}

	public Object getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(Object targetValue) {
		this.targetValue = targetValue;
	}
	
	
	
		
	
	


}
