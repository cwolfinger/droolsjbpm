package org.drools.reteoo;

import java.util.Collection;
import java.util.LinkedList;

import org.drools.InitialFact;

public class ArgList {
	
	private LinkedList<Object> args;
	
	private boolean isPersistent = false;
	
	public ArgList() {
		args = new LinkedList<Object>();
	}
	
	public ArgList(Object[] args) {
		this();
		merge(args);
	}
	
	public ArgList(Object arg) {
		this();
		merge(arg);
	}
	
	public ArgList(Object[] args, Object arg) {
		this();
		merge(args);
		merge(arg);
	}
	
	
	protected ArgList(Collection<Object> args) {
		this();
		 
		merge(args);
		
	}
	
	
	
	
	public Object getObject() {
		return args.getLast();
	}
	
	public Object clone() {
		ArgList ans = new ArgList(this.args);
		return ans;
	}
	
	
	public int merge(Object[] more) {
		int j = 0;
		for (Object o : more) {
			if (o != null && ! this.args.contains(o) && ! (o instanceof InitialFact)) {
				this.args.add(o);
				j++;
			}			
		}
		return j;
	}
	
	public int merge(ArgList more) {
		int j = 0;
		for (Object o : more.args) {
			if (o != null && ! this.args.contains(o) && ! (o instanceof InitialFact)) {
				this.args.add(o);
				j++;
			}			
		}
		return j;
	}
	
	public int merge(Object o) {
		if (o != null && ! this.args.contains(o) && ! (o instanceof InitialFact)) { 
			this.args.add(o);
			return 1;
		}
		return 0;
	}
	
	
	
	public int merge(Collection< ? extends Object> args) {
		int j = 0;
		for (Object o : args) {
			if (o != null && ! this.args.contains(o) && ! (o instanceof InitialFact)) {  
				this.args.add(o);
				j++;
			}
		}
		return j;
	}
	
	
	
	
	
	
	
	
	public int hashCode() {
		int ans = 0;
		for (int j = 0; j < args.size(); j++)
			ans ^= args.get(j).hashCode();
		return ans;
	}
	
	
	
	
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
		
		ArgList otherArgs = (ArgList) other;
		
		if (otherArgs != null) {
			if (this.args.size() != otherArgs.args.size())
				return false;
			
			boolean ans = true;
				for (int j = 0; j < this.args.size(); j++) {
					if (this.args.get(j) instanceof Jolly || otherArgs.args.get(j) instanceof Jolly) {
						ans = ans && true;
					} else {
						ans = ans && this.args.get(j).equals(otherArgs.args.get(j));
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder("L : ");
		for (Object o : args) {
			sb.append(o.getClass().getSimpleName()).append(" ").append(o.hashCode()).append("\t");
		}
		return sb.toString();
	}
	
	
	public static class Jolly {
		
		public Jolly() {
			
		}
	}


	
	
}
