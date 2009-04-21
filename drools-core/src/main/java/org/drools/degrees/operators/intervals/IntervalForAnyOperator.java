package org.drools.degrees.operators.intervals;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalForAnyOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args) {		
		if (args == null || args.length == 0)
			return IntervalDegreeFactory.UNKNOWN;
		
		float low = 0;
		float upp = 0;
		for (IDegree deg : args) {
			IntervalDegree ival = (IntervalDegree) deg;
			
			low += ival.getLow();
			upp += ival.getUpp();
		}		
		low /= args.length;
		upp /= args.length;
		return new IntervalDegree(low,upp);
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() == 0)
			return IntervalDegreeFactory.UNKNOWN;
		
		float low = 0;
		float upp = 0;
		for (IDegree deg : args) {
			IntervalDegree ival = (IntervalDegree) deg;
			
			low += ival.getLow();
			upp += ival.getUpp();
		}		
		low /= args.size();
		upp /= args.size();
		return new IntervalDegree(low,upp);
	}

	public String getName() {
		return "i_forAny";
	}

}
