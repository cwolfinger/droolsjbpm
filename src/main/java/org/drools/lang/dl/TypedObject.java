package org.drools.lang.dl;

public class TypedObject {
	
	private Object obj;
	
	private String type;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public TypedObject(Object obj, String type) {
		super();
		this.obj = obj;
		this.type = type;
	}

	@Override
	public String toString() {
		return obj.toString()+ ((type != null) ? ("^^"+type) : "");
	}
	
	

}
