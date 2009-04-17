package org.drools.reteoo;

import java.util.Collection;

public interface IGammaNode {

	EvaluationTemplate getEvaluationTemplate(ConstraintKey key);

	void storeEvaluation(ArgList args, Evaluation prepareEval);
	
	
	public Collection<Evaluation> getStoredEvals(ArgList args);

}
