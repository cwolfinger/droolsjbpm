package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalDiscountOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args) {
		if (args == null || args.length < 2)
			return SimpleDegreeFactory.UNKNOWN;
		
		IntervalDegree ival = (IntervalDegree) args[0];
		SimpleDegree disc = args[1].getDegree();
		float alfa = disc.getValue();	
		
		
		return new IntervalDegree(ival.getTau()*alfa, 1 - ival.getPhi()*alfa);
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() < 2)
			return SimpleDegreeFactory.UNKNOWN;
		Iterator<? extends IDegree> iter= args.iterator();
		
		IntervalDegree ival = (IntervalDegree) iter.next();
		SimpleDegree disc = iter.next().getDegree();
		float alfa = disc.getValue();	
		
		
		return new IntervalDegree(ival.getTau()*alfa, 1 - ival.getPhi()*alfa);
	}

	public String getName() {
		return "i_discount";
	}

}
