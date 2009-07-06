package org.drools.reteoo;



public class ConstraintKey {
	
	protected String key;
	
	protected String alias = "";

	
	public ConstraintKey() {
		key = "";
	}
	
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
	
	public ConstraintKey clone() {
		return new ConstraintKey(new String(key));
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
			return this.key.equals(otherK.key) || (this.alias.length() > 0 && this.alias.equals(otherK.alias));
		}
		else 
			return false;		
	}
	
	public int hashCode() {
		if (key != null && ! key.equals(""))
			return key.hashCode();
		if (alias != null)
			return alias.hashCode();
		return key.hashCode();
	}

//	/**
//	 * @param constr the constr to set
//	 */
//	public void setConstr(Constraint constr) {
//		this.constr = constr;
//	}

	
	public void setAlias(String aka) {
		this.alias = aka;
	}
	
	public String getAlias() {
		if (alias != null)
			return alias;
		else 
			return key;
	}

	


}
