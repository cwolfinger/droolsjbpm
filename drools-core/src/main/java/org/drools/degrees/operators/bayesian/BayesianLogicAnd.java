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

public class BayesianLogicAnd extends AbstractOperator implements IDegreeCombiner {

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args.length == 0)
			return factory.Unknown();
	
				
		ProbabilityDistributionDegree p0 = (ProbabilityDistributionDegree) args[0]; 
		double[][] core = p0.getDistribution().getArrayCopy();
		
		for (int j = 1 ; j < args.length; j++) {
			double[][] more = ((ProbabilityDistributionDegree) args[j]).getDistribution().getArray();
			core[1][0] = core[1][0]*more[1][0];
			core[0][0] = 1-core[1][0];
		}
		
		return new ProbabilityDistributionDegree(p0.getDomain(),new Matrix(core));
	
	}

	public IDegree eval(Collection<? extends IDegree> args,
			IDegreeFactory factory) {
		if (args.size() == 0)
			return factory.Unknown();
		
		Iterator<? extends IDegree> iter = args.iterator();
		ProbabilityDistributionDegree p0 = (ProbabilityDistributionDegree) iter.next(); 
		double[][] core = p0.getDistribution().getArrayCopy();
		
		while (iter.hasNext()) {			
				double[][] more = ((ProbabilityDistributionDegree) iter.next()).getDistribution().getArray();
				core[1][0] = core[1][0]*more[1][0];
				core[0][0] = 1-core[1][0];
			}
			
		return new ProbabilityDistributionDegree(p0.getDomain(),new Matrix(core));		
	}

	public String getName() {
		return "B_and";
	}

}
