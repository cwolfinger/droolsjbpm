package org.drools.lang.dl.descr;

public class DL_FactDescr extends DL_aBaseDescr {

	private DL_RelationDescr rel;
	
	private Object object;
	
		
	@Override
	public String getType() {
		return rel.getType();
	}


	public DL_RelationDescr getRel() {
		return rel;
	}


	public void setRel(DL_RelationDescr rel) {
		this.rel = rel;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}

	
	
	public String toFullDownwardString(int n) {
		String s = "";
		for (int j = 0; j < n; j++)
			s += "\t";
		s += getRel().toString() + getObject().toString();
		return s;
	}
}
