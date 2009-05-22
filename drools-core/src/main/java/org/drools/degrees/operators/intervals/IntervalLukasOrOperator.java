package org.drools.degrees.operators.intervals;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalLukasOrOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {		
		if (args == null || args.length == 0)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();		
		float tau = 0;
		float phi = 0;
		for (IDegree deg : args) {
			IntervalDegree ival = (IntervalDegree) deg;
			
			tau += ival.getTau();
			phi += ival.getPhi();
		}		
		tau = Math.min(tau, 1);
		phi = Math.min(args.length - phi,1);
		return new IntervalDegree(tau,phi);
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() == 0)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();		
		float tau = 0;
		float phi = 0;
		for (IDegree deg : args) {
			IntervalDegree ival = (IntervalDegree) deg;
			
			tau += ival.getTau();
			phi += ival.getPhi();
		}
		phi = args.size() - phi;
		return new IntervalDegree(tau,phi);
	}

	public String getName() {
		return "i_+or";
	}

}
