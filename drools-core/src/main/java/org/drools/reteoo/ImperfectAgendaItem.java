package org.drools.reteoo;

import org.drools.common.AgendaItem;
import org.drools.degrees.IDegree;
import org.drools.rule.GroupElement;
import org.drools.rule.Rule;
import org.drools.spi.PropagationContext;

public class ImperfectAgendaItem extends AgendaItem {

	private IDegree degree;
	
	public ImperfectAgendaItem(long propagationNumber, LeftTuple cloned,
			int value, PropagationContext context, Rule rule,
			GroupElement subrule, IDegree degree) {
		super(propagationNumber,cloned,value,context,rule,subrule);
		this.degree = degree;
	}
	
	
	public IDegree getDegree() {
		return degree;
	}

}
