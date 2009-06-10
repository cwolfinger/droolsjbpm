package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalLukasImplicationOperator extends AbstractOperator  implements IDegreeCombiner {

	
	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {		
		if (args == null || args.length < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();		
		double low = 0;
		double upp = 0;
		
		IntervalDegree prem = (IntervalDegree) args[0];
		IntervalDegree conc = (IntervalDegree) args[1];
		
		
		low = Math.min(1, 1 - prem.getUpp() + conc.getLow());
		upp = Math.min(1, 1 - prem.getLow() + conc.getUpp());
		return new IntervalDegree(low, upp);
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() == 0)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();		
		double low = 0;
		double upp = 0;
		
		Iterator<? extends IDegree> iter = args.iterator();
		IntervalDegree prem = (IntervalDegree) iter.next();
		IntervalDegree conc = (IntervalDegree) iter.next();
		
		
		low = Math.min(1, 1 - prem.getUpp() + conc.getLow());
		upp = Math.min(1, 1 - prem.getLow() + conc.getUpp());
		return new IntervalDegree(low, upp);
	}

	public String getName() {
		return "i_ximp";
	}

}
