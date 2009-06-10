package org.drools.degrees.operators.bayesian;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDiscountOperator;

import Jama.Matrix;

public class BayesianDiscounter extends AbstractOperator  implements IDiscountOperator {

	public IDegree discount(IDegree arg, double strength) {
		ProbabilityDistributionDegree p = (ProbabilityDistributionDegree) arg;
		Matrix m = p.getDistribution();
		int N = m.getRowDimension();
		double[] distr = new double[N];
			for (int j = 0; j < N; j++)
				distr[j] = m.get(j,1)*strength + (1.0-strength)/N;
		Matrix discountedDistr = new Matrix(distr,1);
		return new ProbabilityDistributionDegree(p.getDomain(),discountedDistr);
	}

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		return args[0];
	}

	public IDegree eval(Collection<? extends IDegree> args,
			IDegreeFactory factory) {
		return args.iterator().next();
	}

	public String getName() {
		return "B_disc";
	}

}
