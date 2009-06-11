package org.drools.degrees.operators.bayesian;

import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.drools.bayesian.BooleanDomain;
import org.drools.degrees.IDegree;
import org.drools.degrees.ProbabilityDistributionDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.CompositeEvaluation;
import org.drools.reteoo.EvalRecord;
import org.drools.reteoo.Evaluation;

import Jama.Matrix;

public class BayesianModusPonensOperator extends AbstractOperator  implements IDegreeCombiner {

	private boolean isFullLambda = false;
	
	
	public BayesianModusPonensOperator() {
		setFullLambda(false);
	}
	
	public BayesianModusPonensOperator(String params) {
		StringTokenizer tok = new StringTokenizer(params,",");
		while (tok.hasMoreTokens()) {
			String param = tok.nextToken();
			if (param.startsWith("kind:")) {
				String val = param.substring(5);
					setFullLambda(val.equals("complex"));
			}
		}
	}






	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
//		if (args.length < 2)
//			return factory.Unknown();
//		
//		ProbabilityDistributionDegree prem = (ProbabilityDistributionDegree) args[0];
//		ProbabilityDistributionDegree impl = (ProbabilityDistributionDegree) args[1];
//		
//		Matrix conclDistr = impl.getDistribution().times(prem.getDistribution());
//		
//		return new ProbabilityDistributionDegree(impl.getDomain(),conclDistr);
		throw new UnsupportedOperationException("Should not be here...., Bayes MP is not t-functional");
	}

	
	
	
	
	
	public IDegree eval(Evaluation evaluation, IDegreeFactory factory) {
		
		if (isFullLambda)
			return evalComplex(evaluation, factory);
		else 
			return evalSimple(evaluation, factory);
	}

		
	
	public IDegree evalComplex(Evaluation evaluation, IDegreeFactory factory) {
		EvalRecord record = (EvalRecord) evaluation;
		if (record.getOperands().size() < 2)
			return factory.Unknown();
		
		Iterator<Evaluation> iter = record.getOperands().iterator();
				
		CompositeEvaluation andRoot = (CompositeEvaluation) iter.next();		//remove the outermost rule-And wrapper
		andRoot = (CompositeEvaluation) andRoot.getOperands().iterator().next();
				
		ProbabilityDistributionDegree cleanEt = (ProbabilityDistributionDegree) andRoot.getDegree();
			if (cleanEt.getDistribution().getColumnDimension() == 1 && cleanEt.getDistribution().getRowDimension() == 1)
				return cleanEt;
		
		Iterator<Evaluation> iter2 = andRoot.getOperands().iterator();
		iter2.next();		// ignore dirty first premise
		ProbabilityDistributionDegree cleanVel = (ProbabilityDistributionDegree) iter2.next().getDegree();
		
		
		ProbabilityDistributionDegree implDegree = (ProbabilityDistributionDegree) iter.next().getDegree();

		
		Matrix l = cleanEt.getDistribution();
		Matrix cond = implDegree.getDistribution();
		Matrix m = cleanVel.getDistribution(); 
		
		
		Matrix mat = (l.transpose().times(cond)).times(m).transpose();
		ProbabilityDistributionDegree ans = new ProbabilityDistributionDegree(new BooleanDomain(),mat);
		return ans;
	}
	
	
	
	public IDegree evalSimple(Evaluation evaluation, IDegreeFactory factory) {
		
		EvalRecord record = (EvalRecord) evaluation;
		if (record.getOperands().size() < 2 )
			return factory.Unknown();
		
		Iterator<Evaluation> iter = record.getOperands().iterator();
		
		String ruleId = record.getRuleId();

		Evaluation premise = iter.next();
		ProbabilityDistributionDegree premDistr = (ProbabilityDistributionDegree) premise.getDegree(); 
		Matrix belief = premDistr.getDistribution();
		
		ProbabilityDistributionDegree condTable = (ProbabilityDistributionDegree) iter.next().getDegree();
		if (belief.getRowDimension() == 1 && belief.getColumnDimension() == 1)
			return new ProbabilityDistributionDegree(premDistr.getDomain(), belief );
		
		Matrix conclDistr = null;
		if (isLambda(ruleId)) {
			conclDistr = (belief.transpose().times(condTable.getDistribution())).transpose();
		} else {
			conclDistr = condTable.getDistribution().times(belief);
		}
		
		return new ProbabilityDistributionDegree(premDistr.getDomain(), conclDistr );
	}
	
	
	
	
	/*
	public IDegree eval(Evaluation evaluation, IDegreeFactory factory) {
		boolean exclude = false;
		
				
		EvalRecord record = (EvalRecord) evaluation;
		if (record.getOperands().size() < 2)
			return factory.Unknown();
		
		Iterator<Evaluation> iter = record.getOperands().iterator();
		
		String ruleId = record.getRuleId();
		
		
		
			String target = revertLinkId(ruleId);
			
		Evaluation premise = iter.next();
		ProbabilityDistributionDegree premDistr = (ProbabilityDistributionDegree) premise.getDegree(); 
		Matrix belief = premDistr.getDistribution();
		
		Evaluation combo = (ruleId.indexOf("->") > -1) ? lookForBit(premise,target) : null;
			if (combo != null) {
				exclude = true;
				premise = combo;
				
				IDegree[] args = new IDegree[premise.getDegreeBitSources().size()-1];
				int j = 0;
				for (String source : premise.getDegreeBitSources()) {
					if (! source.equals(target))
						args[j++] = premise.getDegreeBit(source);
				}
				
				ProbabilityDistributionDegree msg = (ProbabilityDistributionDegree) factory.getMergeStrategy().eval(args, factory);
				belief = msg.getDistribution();
			
			}
					
		
		ProbabilityDistributionDegree condTable = (ProbabilityDistributionDegree) iter.next().getDegree();
		
		Matrix conclDistr = null;
		if (isLambda(ruleId)) {
			conclDistr = (belief.transpose().times(condTable.getDistribution())).transpose();
		} else {
			conclDistr = condTable.getDistribution().times(belief);
		}
		
		return new ProbabilityDistributionDegree(premDistr.getDomain(), conclDistr );
	}
	
	*/
	
	
//	private String revertLinkId(String ruleId) {
//		if (isLambda(ruleId))
//			return ruleId.substring(4);
//		else 
//			return "Inv:"+ruleId;
//	}
	
	private boolean isLambda(String ruleId) {
		return ruleId.startsWith("lambda");
	}





	public boolean isTruthFunctional() {
		return false;
	}

	public String getName() {
		return "B_m|p";
	}






	public void setFullLambda(boolean isFullLambda) {
		this.isFullLambda = isFullLambda;
	}






	public boolean isFullLambda() {
		return isFullLambda;
	}

		
}
