package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.time.Interval;

public class IntervalDoubleMPOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();
		
		IntervalDegree prem = (IntervalDegree) args[0];
		IntervalDegree impl = (IntervalDegree) args[1];
		
		double tau = Math.min(prem.getTau(),impl.getTau());
		double phi = Math.min(prem.getPhi(),impl.getTau());
			
		return new IntervalDegree(tau, 1-phi);
		                    
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();
		Iterator<? extends IDegree> iter= args.iterator();
		
		IntervalDegree prem = (IntervalDegree) iter.next();
		IntervalDegree impl = (IntervalDegree) iter.next();
		
		double tau = Math.min(prem.getTau(),impl.getTau());
		double phi = Math.min(prem.getPhi(),impl.getTau());
			
		return new IntervalDegree(tau, 1-phi);
	}
	
	public String getName() {
		return "i_dblMP";
	}

}
