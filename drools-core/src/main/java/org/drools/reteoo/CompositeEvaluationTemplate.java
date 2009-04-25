package org.drools.reteoo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.drools.common.BetaConstraints;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.spi.PropagationContext;

public class CompositeEvaluationTemplate extends EvaluationTemplate {

	private int 						N				 = 0;
	private IDegreeCombiner		 		operator;
	
	
	protected Map<ConstraintKey,EvaluationTemplate> children;
	
	
	public CompositeEvaluationTemplate(int id, ConstraintKey key, Set<String> deps, int N, IDegreeCombiner operator, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
		super(id,key,deps,mergeStrat,nullStrat);
		
		children = new HashMap<ConstraintKey, EvaluationTemplate>();
		this.N = N;
		this.operator = operator;
		
	}
	
//	public CompositeEvaluationTemplate(EvaluationTemplate master) {
//		this.master = master;
//		this.children.put(master.getConstraintKey(),master);		
//	}


	public EvaluationTemplate getTemplate(ConstraintKey key) {		
		return this.children.get(key);
	}
	
	public void addChild(EvaluationTemplate temp) {
		this.children.put(temp.getConstraintKey(),temp);
	}


	
	public Evaluation spawn(Evaluation[] evalDegree) {
		return new CompositeEvaluation(id,key,deps,evalDegree,operator,mergeStrat,nullStrat,new ArgList());
	}
	
	public Evaluation spawn(ArgList args) {
		return new CompositeEvaluation(id,key,deps,children.values().toArray(new Evaluation[children.values().size()]),operator,mergeStrat,nullStrat,args);
	}
	
	public Evaluation spawn(int N) {
		return new CompositeEvaluation(id,key,deps,N,operator,mergeStrat,nullStrat,new ArgList());
	}
	
	public Evaluation spawn(OperandSet args, BetaConstraints joinConstraints) {
		return new SetCompositeEvaluation(id,key,deps,operator,args,mergeStrat,nullStrat,joinConstraints);
	}
	
	
	protected IDegreeCombiner getOperator() {
		return operator;
	}

	
	
	
	
	
	
	
	
	
}
