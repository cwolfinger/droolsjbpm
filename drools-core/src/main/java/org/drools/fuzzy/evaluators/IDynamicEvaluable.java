package org.drools.fuzzy.evaluators;

import org.drools.spi.Evaluator;

public interface IDynamicEvaluable {
	
	public Evaluator getPred(String opId);

}
