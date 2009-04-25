package org.drools.reteoo;

import com.sun.tools.xjc.model.CNonElement;


public class ConstraintKey {
	
	protected String key;

	
	public ConstraintKey(String field, String op, String value) {
		this.key = op+"("+field+","+value+")";	
	}
	
	public ConstraintKey(String op,ConstraintKey[] args) {
		this.key = op+"(";
			for (int j = 0; j < args.length; j++) {
				this.key += args[j].toString();
				if (j != args.length -1)
					this.key += ",";
			}
				
		this.key += ")";	
	}
	
	
	
	protected String buildKey(String op, String arg) {
		return op+"("+arg+")";
	}

	public ConstraintKey(String op, String arg) {
		this.key = buildKey(op, arg); 
	}

	public ConstraintKey(String key) {
		this.key = key;
	}
	
	
	public ConstraintKey cloneReplace(String oldK, String newK) {
		return new ConstraintKey(key.replaceFirst(oldK, newK));
	}

	/**
	 * @return the key
	 */
	public String toString() {
		return key;
	}

	
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other instanceof ConstraintKey) {
			ConstraintKey otherK = (ConstraintKey) other;
			return this.key.equals(otherK.key);
		}
		else 
			return false;		
	}
	
	public int hashCode() {
		return key.hashCode();
	}

//	/**
//	 * @param constr the constr to set
//	 */
//	public void setConstr(Constraint constr) {
//		this.constr = constr;
//	}



}
