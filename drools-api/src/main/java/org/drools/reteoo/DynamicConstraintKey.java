package org.drools.reteoo;

public class DynamicConstraintKey extends ConstraintKey {

	private String op;
	
	
	private DynamicConstraintKey() {		
		op = "";
	}
	
	public DynamicConstraintKey(String op) {
		super(op, "");
		this.op = op;
	}
	
	public ConstraintKey cloneReplace(String oldK, String newK) {
		return new DynamicConstraintKey(key.replaceFirst(oldK, newK));
	}

	
	public void reset() {
		this.key = buildKey(op, "");
	}
	
	public ConstraintKey clone() {
		DynamicConstraintKey ans = new DynamicConstraintKey();
		ans.op = new String(this.op);
		ans.key = new String(this.key);
		return ans;
	}
	
	public void addArg(ConstraintKey arg) {
		
		
		StringBuilder sb = new StringBuilder(this.key.substring(0,this.key.length()-1));
		if (key.indexOf("()") == -1)
			sb.append(',');
		sb.append(arg.key);
		sb.append(')');
		
		this.key = sb.toString();
		
		System.out.println("KEY EXPANDED "+arg+" into "+key);
	}

}
