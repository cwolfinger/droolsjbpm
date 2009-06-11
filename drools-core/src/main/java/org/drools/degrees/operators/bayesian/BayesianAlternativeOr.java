package org.drools.degrees.operators.bayesian;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.reteoo.CompositeEvaluation;
import org.drools.reteoo.EvalRecord;
import org.drools.reteoo.Evaluation;

import Jama.Matrix;

public class BayesianAlternativeOr extends AbstractOperator {

	private boolean isLambda = false;
	
	private String linkSource = null;
	
	private int skip = -1;
	
	public BayesianAlternativeOr() { 
		
	}
	
	public BayesianAlternativeOr(String params) {
		StringTokenizer tok = new StringTokenizer(params,",");
		while (tok.hasMoreTokens()) {			
			String param = tok.nextToken().trim();
			if (param.startsWith("args:")) {
				
				param = param.substring(5);
				
				StringTokenizer subTok = new StringTokenizer(param,";");
				while (subTok.hasMoreElements()) {
					String subP = subTok.nextToken().trim();
					if (subP.startsWith("lambda"))
						setLambda(true);
					
					if (subP.startsWith("lambda") || subP.startsWith("pi")) {
						setLinkSource(revert(param));
					}
					
					if (subP.startsWith("index:")) {					
						if (isLambda())
							setSkip(Integer.parseInt(subP.substring(6).trim()));		
					}
				}
			}
			
			
		}
	}





	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		
		if (args.length == 0)
			return factory.Unknown();
		if (args.length == 1) {
			ProbabilityDistributionDegree p = (ProbabilityDistributionDegree) args[0];
			if (p.getDistribution().getColumnDimension() == 1 && p.getDistribution().getRowDimension() == 1)
				return p;
		}
		
		
		if (getSkip() >= 0)
			System.out.println();
		
		int n = getSkip() >= 0 ? args.length+1 : args.length;
		int nargs = args.length; 
		int N = (int) Math.pow(2,n);
		int M = getSkip() >= 0 ? 2 : 1;
		double[][] core = new double[N][M];
		
		
		
		for (int j = 0; j < N; j++) {
			double x = 1;
			
			for (int k = 0; k < nargs; k++) {
				int pow = (int) Math.pow(2,k);
				int bit = (j & pow) > 0 ? 1 : 0;
				
				Matrix m = ((ProbabilityDistributionDegree) args[k]).getDistribution();
				
				if (m.getRowDimension()+m.getColumnDimension() > 2)
					x *= ((ProbabilityDistributionDegree) args[k]).getDistribution().get(bit,0);
			}
			
			if (getSkip() >= 0) {
				int pow = (int) Math.pow(2,getSkip()-1);
				int col = (j & pow) > 0 ? 1 : 0;
				core[j][col] = x;
			} else {
				core[j][0] = x;
			}
			
			
		}
		
		System.out.println();
		
		
		return new ProbabilityDistributionDegree(((ProbabilityDistributionDegree) args[0]).getDomain(),new Matrix(core));
	}

	
	
	
	
	public IDegree eval(Evaluation evaluation, IDegreeFactory factory) {
		CompositeEvaluation combo = (CompositeEvaluation) evaluation;
		
		IDegree[] args = new IDegree[combo.getOperands().size()];
		// Need to clean the operands from the lambda inv contribution
		
		Iterator<Evaluation> iter = combo.getOperands().iterator();
			int j = 0;
			while (iter.hasNext()) {
				
				Evaluation operand = iter.next();
				
				Evaluation sub = lookForBit(operand,getLinkSource());
				if (sub != null) {
					operand = sub;
				
				
					IDegree[] bits = new IDegree[operand.getDegreeBitSources().size()-1];
					int k = 0;
					for (String source : operand.getDegreeBitSources()) {
						if (! matches(source,(getLinkSource())))
							bits[k++] = operand.getDegreeBit(source);
					}
					ProbabilityDistributionDegree msg = (ProbabilityDistributionDegree) factory.getMergeStrategy().eval(bits, factory);
					
					args[j++] = msg;
					
				} else {
					
					args[j++] = operand.getDegree();
				}
//				ProbabilityDistributionDegree msg = (ProbabilityDistributionDegree) factory.getMergeStrategy().eval(args, factory);
				
				//ProbabilityDistributionDegree distr = (ProbabilityDistributionDegree) operand.getDegree(); 
				//Matrix belief = distr.getDistribution();
//				
//				Evaluation combo = (ruleId.indexOf("->") > -1) ? lookForBit(premise,target) : null;
//					if (combo != null) {
//						exclude = true;
//						premise = combo;
//						
//						IDegree[] args = new IDegree[premise.getDegreeBitSources().size()-1];
//						int j = 0;
//						for (String source : premise.getDegreeBitSources()) {
//							if (! source.equals(target))
//								args[j++] = premise.getDegreeBit(source);
//						}
//						
//						ProbabilityDistributionDegree msg = (ProbabilityDistributionDegree) factory.getMergeStrategy().eval(args, factory);
//						belief = msg.getDistribution();
//					
//					}
				
				
			}
				
				
					
		return eval(args,factory);
	}
	

	
	private Evaluation lookForBit(Evaluation operand, String key) {
		for (String bit : operand.getDegreeBitSources())
			if (matches(bit,key))
				return operand;
		if (operand instanceof CompositeEvaluation) {
			CompositeEvaluation combo = (CompositeEvaluation) operand;
			for (Evaluation eval : combo.getOperands()) {
				Evaluation ans = lookForBit(eval,key);
				if (ans != null) 
					return ans;
			}				
		}
		return null;
	}

	private boolean matches(String bit, String key) {
		int ix1 = bit.lastIndexOf('_');
		int ix2 = key.lastIndexOf('_');
		
		String test1 = (ix1 >= 0 && bit.startsWith("lambda")) ? bit.substring(0,ix1) : bit;
		String test2 = (ix2 >= 0 && key.startsWith("lambda")) ? key.substring(0,ix2) : key;
		return (test1.equals(test2)); 					
	}

	private String revert(String ruleId) {
		int idx = ruleId.indexOf(':');
		String type = ruleId.substring(0,idx);
		
		String rule = ruleId.substring(idx+1);
			int idx2 = rule.lastIndexOf('_');
			if (type.equals("lambda") && idx2 >= 0)
				rule = rule.substring(0,idx2);
		
		String ntype = type.equals("lambda") ? "pi" : "lambda"; 
		
		return ntype + ":" + rule; 
		 
	}


	public boolean isTruthFunctional() {
		return false;
	}
	
	
	public String getName() {
		return "B_vel";
	}

	public void setLinkSource(String linkSource) {
		this.linkSource = linkSource;
	}

	public String getLinkSource() {
		return linkSource;
	}

	public void setLambda(boolean isLambda) {
		this.isLambda = isLambda;
	}

	public boolean isLambda() {
		return isLambda;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getSkip() {
		return skip;
	}

}
