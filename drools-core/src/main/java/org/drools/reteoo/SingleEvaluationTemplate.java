package org.drools.reteoo;

import java.util.Set;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class SingleEvaluationTemplate extends EvaluationTemplate {

		
	public SingleEvaluationTemplate(int id, ConstraintKey key, Set<String> deps, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat, IDegreeFactory factory) {
		super(id,key,deps,mergeStrat,nullStrat,factory);
	}

	@Override
	public Evaluation spawn(Evaluation[] evalDegree) {
		throw new UnsupportedOperationException(this.getClass().getName()+"Try to define unary operator??");
	}
	
	
}
