package org.drools.degrees.operators.bayesian;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.CompositeEvaluation;
import org.drools.reteoo.Evaluation;

public class BayesianAlternativeAnd extends AbstractOperator implements
		IDegreeCombiner {

	
	private String linkSource;

	public BayesianAlternativeAnd(String params) {
		StringTokenizer tok = new StringTokenizer(params,",");
		while (tok.hasMoreTokens()) {			
			String param = tok.nextToken().trim();
			if (param.startsWith("args:")) {
				
				param = param.substring(5);
				
				StringTokenizer subTok = new StringTokenizer(param,";");
				while (subTok.hasMoreElements()) {
					String subP = subTok.nextToken().trim();
					
					if (subP.startsWith("lambda")) {
						setLinkSource(revert(param));
					}
					
				}
			}
			
			
		}
	}

	
	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return "B_et";
	}

	
	public IDegree eval(Evaluation evaluation, IDegreeFactory factory) {
		CompositeEvaluation combo = (CompositeEvaluation) evaluation;
		
		Iterator<Evaluation> iter = combo.getOperands().iterator();
		Evaluation left = iter.next();	//this is the "child"
		Evaluation right = iter.next();	//this is the all-but-one "parents"
		
		Evaluation sub = lookForBit(left,getLinkSource());
		if (sub != null) {
			left = sub;
		
		
			IDegree[] bits = new IDegree[left.getDegreeBitSources().size()-1];
			int k = 0;
			for (String source : left.getDegreeBitSources()) {
				if (! matches(source,(getLinkSource())))
					bits[k++] = left.getDegreeBit(source);
			}
			ProbabilityDistributionDegree msg = (ProbabilityDistributionDegree) factory.getMergeStrategy().eval(bits, factory);
			
			return msg;
			
		} else {
			
			return left.getDegree();
		}
				
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
	
	
	private boolean matches(String bit, String key) {
		int ix1 = bit.lastIndexOf('_');
		int ix2 = key.lastIndexOf('_');
		
		String test1 = (ix1 >= 0 && bit.startsWith("lambda")) ? bit.substring(0,ix1) : bit;
		String test2 = (ix2 >= 0 && key.startsWith("lambda")) ? key.substring(0,ix2) : key;
		return (test1.equals(test2)); 					
	}

	
	
	public boolean isTruthFunctional() {
		return false;
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

	
	public void setLinkSource(String linkSource) {
		this.linkSource = linkSource;
	}

	public String getLinkSource() {
		return linkSource;
	}

}
