package org.drools.reteoo;

public class ArgList {
	
	private Object[] args;
	
	private boolean isPersistent = false;
	
	public ArgList(Object[] args) {
		this.args = args;
		for (int j = 0; j < args.length; j++)
			if (args[j] instanceof Jolly)
				isPersistent = true;
	}
	
	public ArgList(Object arg) {
		this.args = new Object[] {arg};
		if (arg instanceof Jolly)
			isPersistent = true;
	}
	
	public ArgList(Object[] args, Object arg) {
		this.args = new Object[args.length+1];
		for (int j = 0; j < args.length; j++) {
			if (args[j] instanceof Jolly)
				isPersistent = true;
			this.args[j] = args[j];
		}
		this.args[args.length] = arg;
		if (arg instanceof Jolly)
			isPersistent = true;
	}
	
	
	
	
	public Object getObject() {
		return args[args.length-1];
	}
	

	
	
	
	
	
	public int hashCode() {
		int ans = 2131;
		for (int j = 0; j < args.length; j++)
			ans ^= args[j].hashCode();
		return ans;
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
		
		ArgList otherArgs = (ArgList) other;
		
		if (otherArgs != null) {
			if (this.args.length != otherArgs.args.length)
				return false;
			
			boolean ans = true;
				for (int j = 0; j < this.args.length; j++) {
					if (this.args[j] instanceof Jolly || otherArgs.args[j] instanceof Jolly) {
						ans = ans && true;
					} else {
						ans = ans && this.args[j].equals(otherArgs.args[j]);
					}
				}
								
			return ans;
		} else {
			return false;
		}
			
		
	}

	public boolean isPersistent() {
		return isPersistent;
	}
	
	
	
	
	public static class Jolly {
		
		public Jolly() {
			
		}
	}
	
}
