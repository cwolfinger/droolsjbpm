package org.drools.degrees;

import javax.management.RuntimeErrorException;

import org.drools.bayesian.BooleanDomain;
import org.drools.bayesian.IDomain;

import Jama.Matrix;



public class ProbabilityDistributionDegree implements IDegree {

	private static final double tHold = 1e-10;

	private int N;
	
	private Matrix distribution;
	
	private IDomain domain;
	
	
	public ProbabilityDistributionDegree() {
		this(new BooleanDomain());
	}
	
	
	public ProbabilityDistributionDegree(IDomain domain) {
		setDomain(domain);
		setN(domain.getN());
		setDistribution(new Matrix(getN(), 1, 1.0/getN()));
	}
	
	public ProbabilityDistributionDegree(double[] distrib, boolean check) {
		setN(distrib.length);
		
		if (check) {
			double acc = 0;
			for (int j = 0; j < getN(); j++)
				acc += distrib[j];
			if (acc - 1 > tHold) {
				throw new RuntimeException("Invalid Probability Distribution");
			}
		}
		
		setDistribution(new Matrix(distrib,1));
	}
	
		
	public void setN(int n) {
		N = n;
	}

	public int getN() {
		return N;
	}

	
	public double getConfidence(boolean cwa) {
		return 1;
	}

	
	
	public SimpleDegree asSimpleDegree() {
		return new SimpleDegree(distribution.get(domain.getFocus(),0));
	}

	public double getValue() {
		return distribution.get(domain.getFocus(),0);
	}

	public boolean toBoolean() {
		return getValue() > 0.5;
	}


	
	
	
	
	public void setDistribution(Matrix distribution) {
		this.distribution = distribution;
	}


	public Matrix getDistribution() {
		return distribution;
	}


	public void setDomain(IDomain domain) {
		this.domain = domain;
	}


	public IDomain getDomain() {
		return domain;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("<");
			 for (int j = 0; j < getN(); j++) {
				 sb.append(""+distribution.get(j,0));
				 if (j != getN() - 1)
					 sb.append(",");
			 }
		sb.append(">");
		return sb.toString();
	}
	
}
