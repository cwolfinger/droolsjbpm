package org.drools.degrees.operators.intervals;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalNegationOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args) {
		if (args == null || args.length == 0)
			return IntervalDegreeFactory.UNKNOWN;
			
		IntervalDegree arg = (IntervalDegree) args[0];
		return new IntervalDegree(arg.getUpp(),arg.getLow());
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() == 0)
			return IntervalDegreeFactory.UNKNOWN;
			
		IntervalDegree arg = (IntervalDegree) args.iterator().next();
		return new IntervalDegree(arg.getUpp(),arg.getLow());
	}

	public String getName() {
		return "i_not";
	}

}
