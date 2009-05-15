package org.drools.reteoo;

import org.drools.common.AgendaItem;
import org.drools.common.ImperfectAgendaGroup;
import org.drools.degrees.IDegree;
import org.drools.rule.GroupElement;
import org.drools.rule.Rule;
import org.drools.spi.PropagationContext;

public class ImperfectAgendaItem extends AgendaItem {

	private IDegree degree;
	private Evaluation eval;
	
	public ImperfectAgendaItem(long propagationNumber, LeftTuple cloned,
			int value, PropagationContext context, Rule rule,
			GroupElement subrule, IDegree degree, Evaluation eval) {
		super(propagationNumber,cloned,value,context,rule,subrule);
		this.degree = degree;
		this.eval = eval;
	}
	
	
	public IDegree getDegree() {
		return degree;
	}

	public Evaluation getEvaluation() {
		
		return eval;
	}
	
	
	public int hashCode() {	
		return eval.hashCode()^this.getRule().hashCode();		
	}
	
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (other instanceof ImperfectAgendaItem) {		
			Evaluation ev1 = this.eval;
			Evaluation ev2 = ((ImperfectAgendaItem) other).eval;
			boolean ans = ev1.equals(ev2); 
			return ans && this.getRule().equals(((ImperfectAgendaItem) other).getRule());
		} else
			return false;
		
	}
	
	public String toString() {
        return "[Activation rule=" + this.getRule().getName() + ", code =" + this.eval.hashCode() + " degree = " +this.degree + "]";
    }
	
	public void remove() {
        ((ImperfectAgendaGroup) this.getAgendaGroup()).remove(this);
    }

	
	
}
