package org.drools.degrees.operators;

import java.util.Collection;

import org.drools.degrees.IDegree;

public abstract  class NegationOperator implements IDegreeCombiner {
	
	
	
	
	protected IDegreeCombiner operator;
	
	public void setOperator(IDegreeCombiner op) {
		this.operator = op;
	}

	public IDegree eval(IDegree[] args) {
		return negate(operator.eval(args));
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		return negate(operator.eval(args));
	}

	public String getName() {
		return "-"+operator.getName();
	}
	
	
	protected abstract IDegree negate(IDegree arg);
	

}
