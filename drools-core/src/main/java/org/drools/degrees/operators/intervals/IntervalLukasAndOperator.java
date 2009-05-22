package org.drools.degrees.operators.intervals;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class IntervalLukasAndOperator implements IDegreeCombiner {

	
	
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
		tau = Math.max(0,tau - args.length + 1);
		phi = Math.max(0,1.0f - phi);
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
		tau = tau - args.size() + 1;
		phi = 1.0f - phi;
		return new IntervalDegree(tau,phi);
	}

	public String getName() {
		return "i_xand";
	}

}
