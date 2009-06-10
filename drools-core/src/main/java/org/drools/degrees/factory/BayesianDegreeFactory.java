package org.drools.degrees.factory;

import java.util.StringTokenizer;

import org.drools.bayesian.BooleanDomain;
import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IDiscountOperator;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.degrees.operators.bayesian.BayesianAlternativeOr;
import org.drools.degrees.operators.bayesian.BayesianAnd;
import org.drools.degrees.operators.bayesian.BayesianDiscounter;
import org.drools.degrees.operators.bayesian.BayesianMergeStrategy;
import org.drools.degrees.operators.bayesian.BayesianModusPonensOperator;
import org.drools.degrees.operators.bayesian.BayesianNullHandlingStragy;

import org.drools.reteoo.filters.AlwaysPassFilterStrategy;
import org.drools.reteoo.filters.IFilterStrategy;

import Jama.Matrix;

public class BayesianDegreeFactory implements IDegreeFactory {
	
	boolean cwa = false;

	public IDegree False() {		
		return new ProbabilityDistributionDegree(new double[] {1,0});
	}

	public IDegree Random() {
		double r = Math.random();
//		return new ProbabilityDistributionDegree(new double[] {r,1-r});
		return new ProbabilityDistributionDegree(new double[] {0.3,0.7});
	}

	public IDegree True() {
		return new ProbabilityDistributionDegree(new double[] {0,1});
	}

	public IDegree Unknown() {
		return new ProbabilityDistributionDegree(new double[] {0.5,0.5});		
	}

	
	
	
	
	
	
	public IDegree buildDegree(double val) {
		return new ProbabilityDistributionDegree(new double[] {val,1-val}); 
	}

	
	
	public IDegree buildDegree(String priorStr) {
		String valueS = priorStr.trim();
		valueS = valueS.substring(1,valueS.length()-1);
		
		StringTokenizer tok = new StringTokenizer(valueS,";");
		int rows = tok.countTokens();
		
		String row = tok.nextToken();
		StringTokenizer tokRow = new StringTokenizer(row,", ");
		int cols = tokRow.countTokens();
		
		double[][] core = new double[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int k = 0; k < cols; k++) {
				core[r][k] = Double.parseDouble(tokRow.nextToken()); 
			}
			if (r != rows-1) {
				row = tok.nextToken();
				tokRow = new StringTokenizer(row,", ");
			}
		}

		return new ProbabilityDistributionDegree(new BooleanDomain(),new Matrix(core)); 
	}

	
	
	public IDegree fromBoolean(boolean b) {
		return b ? True() : False();
	}

	
	
	public IDegreeCombiner getAggregator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getAndOperator() {
		return new BayesianAnd();
	}

	public IDegreeCombiner getAndOperator(String params) {
		return new BayesianAnd();
	}

	public IFilterStrategy getDefaultStrategy() {
		return new AlwaysPassFilterStrategy();
	}

	public IDiscountOperator getDiscountOperator() {
		return new BayesianDiscounter();
	}

	public IDegreeCombiner getDiscountOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDiscountStrategy getDiscountStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getDoubleMPOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getDoubleMPOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getEquivOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getEquivOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getExistsOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getForAnyOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getForallOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getHedgeOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getHedgeOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getImplicationOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getImplicationOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getMaxOrOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IMergeStrategy getMergeStrategy() {
		return new BayesianMergeStrategy();
	}

	public IDegreeCombiner getMinAndOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getModusPonensOp() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getModusPonensOperator(String params) {
		return new BayesianModusPonensOperator();
	}

	public IDegreeCombiner getNegationOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public INullHandlingStrategy getNullHandlingStrategy() {
		return new BayesianNullHandlingStragy();
	}

	public IDegreeCombiner getOrOperator() {
		return new BayesianAlternativeOr();
	}

	public IDegreeCombiner getOrOperator(String params) {
		return new BayesianAlternativeOr(params);
	}

	public IDegreeCombiner getXorOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getXorOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public boolean isClosedWorldAssumption() {		
		return false;
	}

	public void setClosedWorldAssumption(boolean cwa) {
		// do nothing
		this.cwa = false; 
	}

}
