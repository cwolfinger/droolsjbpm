package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalEquivOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();		
		IntervalDegree a1 = (IntervalDegree) args[0];
		IntervalDegree a2 = (IntervalDegree) args[1];
		
		if (a1.getUpp() < a2.getLow() || a2.getUpp() < a1.getLow())
			return IntervalDegreeFactory.FALSE;
		
		float maxDist = Math.max(a2.getUpp()-a1.getLow(),a1.getUpp()-a2.getLow());
		return new IntervalDegree(1-maxDist,1);
		
	}		

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();		
		Iterator<? extends IDegree> iter = args.iterator();
		IntervalDegree a1 = (IntervalDegree) iter.next();
		IntervalDegree a2 = (IntervalDegree) iter.next();
		
		if (a1.getUpp() < a2.getLow() || a2.getUpp() < a1.getLow())
			return IntervalDegreeFactory.FALSE;
		
		float maxDist = Math.max(a2.getUpp()-a1.getLow(),a1.getUpp()-a2.getLow());
		return new IntervalDegree(1-maxDist,1);
	}

	public String getName() {
		return "i_equiv";
	}

}
