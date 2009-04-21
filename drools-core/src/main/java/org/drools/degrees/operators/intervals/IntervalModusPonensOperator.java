package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalModusPonensOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args) {
		if (args == null || args.length < 2)
			return IntervalDegreeFactory.UNKNOWN;
		
		IntervalDegree a1 = (IntervalDegree) args[0];
		IntervalDegree a2 = (IntervalDegree) args[1];
		
		
		return new IntervalDegree(Math.min(a1.getLow(),a2.getLow()),1);
	}		

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() < 2)
			return IntervalDegreeFactory.UNKNOWN;
		
		Iterator<? extends IDegree> iter = args.iterator();
		IntervalDegree a1 = (IntervalDegree) iter.next();
		IntervalDegree a2 = (IntervalDegree) iter.next();
		
		
		return new IntervalDegree(Math.min(a1.getLow(),a2.getLow()),1);
	}

	public String getName() {
		return "i_modPon";
	}

}
