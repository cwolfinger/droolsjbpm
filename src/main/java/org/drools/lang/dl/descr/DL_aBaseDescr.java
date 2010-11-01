package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public abstract class DL_aBaseDescr  {

    private static final long serialVersionUID = 600L;
    
    private boolean negated = false;
    
    private int id;
    
    private DL_aCompositeDescr father;
    
 
    
    private Map<String,DL_AnnotationDescr> annotations = new HashMap<String, DL_AnnotationDescr>();
    
                  
    public String toUpwardString() {
    	StringBuilder sb = new StringBuilder();
    		sb.append(this.toString());
    		sb.append(" | son-of " + 
    						((father == null) ? "null" : father.toUpwardString()) 
    						);    		
    	return sb.toString();
    }
    
    public String toDownwardString() {
    	return toString();
    }
    
    public String toFullDownwardString(int n) {
    	return toString() + formatAnnotations(1);
    }

    public String toString() {
    	return "DL["+id+"]: " + this.getType() + "\n";
    }
    
    
    
	protected String formatAnnotations(int lev) {
		String meta = "\n";
		String tab = "";
		for (int j = 0; j < lev; j++) tab += "\t";		
		for (String key : annotations.keySet()) {			
			meta += tab + "@" + key + " | " + annotations.get(key).getTargetValue().toString();
			if (annotations.get(key).getAnnotationMap().size() > 0)
				meta += annotations.get(key).formatAnnotations(lev+1);
			else meta += " ,\n";
		}
		return meta;		
	}

	public void setFather(DL_aCompositeDescr father) {
		this.father = father;
	}

	public DL_aCompositeDescr getFather() {
		return father;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DL_aBaseDescr other = (DL_aBaseDescr) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	public abstract String getType();

	
	
	
	
//	private void setLevel(int level) {
//		//this.level = level;
//	}

	public int getLevel() {
		return (father == null) ? 0 : (1+father.getLevel());
	}

	
	
	
	
	
	
	
	
	public Map<String,DL_AnnotationDescr> getAnnotationMap() {
		return annotations;
	}
    
	public Collection<DL_AnnotationDescr> getAnnotations() {
		return annotations.values();
	}
	
	public void addAnnotations(Collection<DL_AnnotationDescr> moreAnnotations) {
		for (DL_AnnotationDescr descr : moreAnnotations)
			annotations.put(descr.getIriKey().getIri(), descr);
	}
	
	public void addAnnotation(DL_AnnotationDescr annotation) {
		annotations.put(annotation.getIriKey().getIri(), annotation);
	}
	
	public DL_AnnotationDescr getAnnotation(String key) {
		return annotations.get(key);
	}
	
	
	
	

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public boolean isNegated() {
		return negated;
	}
	
	
}


