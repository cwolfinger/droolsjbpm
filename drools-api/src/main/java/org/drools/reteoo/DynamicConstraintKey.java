package org.drools.reteoo;

public class DynamicConstraintKey extends ConstraintKey {

	public DynamicConstraintKey(String op) {
		super(op, "");
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
