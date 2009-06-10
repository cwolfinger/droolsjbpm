package org.drools.degrees.operators;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;

public abstract  class NegationOperator extends AbstractOperator  implements IDegreeCombiner {
	
	
	
	
	protected IDegreeCombiner operator;
	
	public void setOperator(IDegreeCombiner op) {
		this.operator = op;
	}

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		return negate(operator.eval(args,factory));
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		return negate(operator.eval(args,factory));
	}

	public String getName() {
		return "-"+operator.getName();
	}
	
	
	public abstract IDegree negate(IDegree arg);
	

}
