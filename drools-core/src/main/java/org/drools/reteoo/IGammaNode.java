package org.drools.reteoo;

import java.util.Collection;

public interface IGammaNode {

	EvaluationTemplate getEvaluationTemplate(ConstraintKey key);

	void storeEvaluation(Object object, Evaluation prepareEval);
	
	
	public Collection<Evaluation> getStoredEvals(Object o);

}
