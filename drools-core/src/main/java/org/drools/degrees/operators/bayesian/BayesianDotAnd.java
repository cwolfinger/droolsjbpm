package org.drools.degrees.operators.bayesian;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;


import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.util.ArrayUtils;

import Jama.Matrix;

public class BayesianDotAnd extends AbstractOperator  implements IDegreeCombiner {

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args.length == 0)
			return factory.Unknown();
	
				
		ProbabilityDistributionDegree p0 = ((ProbabilityDistributionDegree) args[0]).copy(); 
		//Matrix core = p0.getDistribution().copy();
		
		
		for (int j = 1 ; j < args.length; j++) {
			//Matrix more = ((ProbabilityDistributionDegree) args[j]).getDistribution();
			//core.arrayTimesEquals(more);
			p0.arrayTimesEquals(((ProbabilityDistributionDegree) args[j]));
		}
		
		//return new ProbabilityDistributionDegree(p0.getDomain(),core);
		return p0;
	}

	public IDegree eval(Collection<? extends IDegree> args,
			IDegreeFactory factory) {
		if (args.size() == 0)
			return factory.Unknown();
		
		Iterator<? extends IDegree> iter = args.iterator();
		ProbabilityDistributionDegree p0 = ((ProbabilityDistributionDegree) iter.next()).copy(); 
		//Matrix core = p0.getDistribution().copy();
		
		
		while (iter.hasNext()) {
			//Matrix more = ((ProbabilityDistributionDegree) args[j]).getDistribution();
			//core.arrayTimesEquals(more);
			p0.arrayTimesEquals(((ProbabilityDistributionDegree) iter.next()));
		}
		
		//return new ProbabilityDistributionDegree(p0.getDomain(),core);
		return p0;
	}

	public String getName() {
		return "B_.*";
	}

}
