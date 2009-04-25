package org.drools.reteoo;

import java.util.Set;

import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public abstract class EvaluationTemplate {
	
	
	protected int 						id;
	protected ConstraintKey 				key;
	protected Set<String> 				deps;	
	
	protected IMergeStrategy 				mergeStrat;
	protected INullHandlingStrategy 		nullStrat;
	
	
	public EvaluationTemplate(int id, ConstraintKey key, Set<String> deps, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
		this.id = id;
		this.key = key;
		this.deps = deps;		
		this.mergeStrat = mergeStrat;
		this.nullStrat = nullStrat;
	}
	
	

	
	
	public Evaluation spawn(IDegree evalDegree, ArgList args) {		
		return new Evaluation(id,key,deps,evalDegree,mergeStrat,nullStrat,args);		
	}
	
	public Evaluation spawn(String source, IDegree evalDegree, ArgList args) {		
		return new Evaluation(id,key,deps,evalDegree,source,mergeStrat,nullStrat,args);		
	}
		
	public Evaluation spawn(ArgList args) {
		return new Evaluation(id,key,deps,null,mergeStrat,nullStrat,args);
	}
	
	
	public ConstraintKey getConstraintKey() {
		return this.key;
	}
	
	public abstract Evaluation spawn(Evaluation[] evalDegree);
	
	
	

}
