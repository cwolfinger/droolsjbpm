package org.drools.degrees.operators.bayesian;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.degrees.operators.intervals.IntervalIntersectionOperator;

import Jama.Matrix;

public class BayesianMergeStrategy extends AbstractOperator  implements IMergeStrategy {
	
	private BayesianDotAnd op = new BayesianDotAnd();


	public IDegree eval(IDegree[] degrees, boolean[] killerFlags,
			INullHandlingStrategy nullStrat, IDegreeFactory factory) {
		
		IDegree[] args = new IDegree[degrees.length];
				
		for (int j = 0; j < degrees.length; j++) {
			args[j] = degrees[j] != null ? degrees[j] : nullStrat.convertNull(factory);							
		}
		
		if (killerFlags != null) {
			IDiscountStrategy discountStrat = factory.getDiscountStrategy();
			return op.eval(discountStrat.discount(args, killerFlags,factory), factory);
		} else {
			return op.eval(args, factory);
		}
					
	}

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		return eval(args, null, factory.getNullHandlingStrategy(),factory);
	}

	public IDegree eval(Collection<? extends IDegree> args,
			IDegreeFactory factory) {
		Iterator<? extends IDegree> iter = args.iterator();
		IDegree[] argArray = new IDegree[args.size()];
			for (int j = 0; j < argArray.length; j++)
				argArray[j] = iter.next();
		return eval(argArray, null, factory.getNullHandlingStrategy(),factory);
	}

	public String getName() {
		return "B_merge";
	}

}
