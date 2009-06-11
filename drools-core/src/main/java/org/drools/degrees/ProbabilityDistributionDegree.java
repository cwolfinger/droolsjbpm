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
		
//		if (getDistribution().getRowDimension() != N && getDistribution().getColumnDimension() != 1)
//			throw new RuntimeException("X-ED ");
	}
	
	public ProbabilityDistributionDegree(IDomain domain, Matrix distribution) {
		setDomain(domain);
		setN(domain.getN());
		
	
		double[][] data = distribution.getArray();
		Matrix mat = new Matrix(data);
		normalize(mat);
		
		
		setDistribution(mat);
		
//		if (getDistribution().getRowDimension() != N && getDistribution().getColumnDimension() != 1)
//			throw new RuntimeException("X-ED 2");
	}
	
	
	
	public ProbabilityDistributionDegree(double[] distrib) {
		setDomain(new BooleanDomain());
		setN(distrib.length);
		
		
			double acc = 0;
			for (int j = 0; j < getN(); j++)
				acc += distrib[j];
			if (Math.abs(acc - 1) > tHold) {
				for (int j = 0; j < getN(); j++)
					distrib[j] = acc == 0 ? 1.0/getN() : (distrib[j] / acc);						
			}		
		
		setDistribution(new Matrix(distrib,getN()));
		
		if (getDistribution().getRowDimension() != N && getDistribution().getColumnDimension() != 1)
			throw new RuntimeException("X-ED 3");
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
		if (distribution.getColumnDimension() == 1) {
			StringBuilder sb = new StringBuilder("<");
				 for (int j = 0; j < distribution.getRowDimension(); j++) {
					 sb.append(" "+distribution.get(j,0));
					 if (j != getN() - 1)
						 sb.append(",");
				 }
			sb.append(">");
			return sb.toString();
		} else {
			StringBuilder sb = new StringBuilder("[");
			
			 
			for (int j = 0; j < distribution.getRowDimension(); j++) {
				for (int k = 0; k < distribution.getColumnDimension(); k++) {
				 sb.append(" "+distribution.get(j,k));
				 if (j != getN() - 1)
					 sb.append(" ");
				}
				sb.append(" ; ");
			}
			
		sb.append("]");
		return sb.toString();
		}
	}


	public ProbabilityDistributionDegree copy() {
		ProbabilityDistributionDegree ans = new ProbabilityDistributionDegree(this.domain, this.distribution.copy());
		return ans;
	}


	public void arrayTimesEquals(
			ProbabilityDistributionDegree probabilityDistributionDegree) {
		Matrix m1 = this.distribution;
		Matrix m2 = probabilityDistributionDegree.getDistribution();
		Matrix ans = null;
		
		if (m1.getColumnDimension() == m2.getColumnDimension()
			&& m2.getRowDimension() == m1.getRowDimension()) {
			ans = m1.arrayTimes(m2);
			
		} else if (isUnity(m1)) {
			ans = m2;
		} else if (isUnity(m2)) {
			ans = m1;
		} else if (m2.getRowDimension() == m1.getRowDimension()
				   && m2.getColumnDimension() != m1.getColumnDimension()) {
				
			if (m1.getColumnDimension() < m2.getColumnDimension()) {
				this.distribution = expand(m1,m2.getColumnDimension());
			} else {
				m2 = expand(m2,m1.getColumnDimension());
			}
			ans = this.distribution.arrayTimes(m2);
				
		} else if (m2.getRowDimension() != m1.getRowDimension()
				   && m2.getColumnDimension() == m1.getColumnDimension()) {
				
			if (m1.getRowDimension() < m2.getRowDimension()) {
				this.distribution = expandRow(m1,m2.getRowDimension());
			} else {
				m2 = expandRow(m2,m1.getRowDimension());
			}
			ans = this.distribution.arrayTimes(m2);
			
			
		} else {
			throw new RuntimeException("Mismatched matrix size, no way to convert");
		}
		
		
		normalize(ans);
		setDistribution(ans);
		
	}
	
	
	private boolean isUnity(Matrix m1) {
		return m1.getColumnDimension() == 1 && m1.getRowDimension() == 1;
	}


	private void normalize(Matrix mat) {
		double[][] data = mat.getArray();
		int C = mat.getColumnDimension();
		int R = mat.getRowDimension();
		
		double acc = 0;
		for (int j = 0; j < R; j++) 
			for (int k = 0; k < C; k++) 
				acc += data[j][k];
		
		if (acc != 0 && Math.abs(acc - 1) > tHold) {
			for (int j = 0; j < R; j++) 
				for (int k = 0; k < C; k++) 
					data[j][k] /= acc;
		}
		
	}


	private Matrix expand(Matrix m, int cols) {
		// m should be 1-col
		// need to be cols-col
		Matrix k = new Matrix(1,cols,1.0);
		Matrix ans = m.times(k).times(1.0/cols);
		return ans;
	}
	
	
	private Matrix expandRow(Matrix m, int row) {
		// m should be k-row
		// need to be row-col
		int numBlocks = row / m.getRowDimension();
		double[][] core = m.getArray();
		double[][] ans = new double[row][1];
		
		for (int j = 0; j < numBlocks; j++)
			for (int k = 0; k < m.getRowDimension(); k++)
				ans[j*m.getRowDimension()+k][0] = (1.0/numBlocks)*core[k][0];
		
		return new Matrix(ans);
	}
	
	public int hashCode() {
		return distribution.hashCode();
	}
	
	public boolean equals(Object object) {
		if (object == null)
			return false;
		else if (object == this)
			return true;
		else if (object instanceof ProbabilityDistributionDegree) {
			ProbabilityDistributionDegree other = (ProbabilityDistributionDegree) object;
			
			Matrix m1 = this.distribution;
			Matrix m2 = other.distribution;
			
			if (m1.getRowDimension() != m2.getRowDimension() || m1.getColumnDimension() != m2.getColumnDimension())
				return false;
			
			for (int j = 0; j < m1.getRowDimension(); j++)
				for (int k = 0; k < m2.getColumnDimension(); k++)
					if (Math.abs(m1.get(j,k)-m2.get(j, k)) > tHold)
						return false;
			
			return true;
		} else
			return false;
	}
	
}
