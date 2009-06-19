package org.drools.degrees.operators;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.CompositeEvaluation;
import org.drools.reteoo.Evaluation;

public abstract class AbstractOperator implements IDegreeCombiner {

	

	public IDegree eval(Collection<? extends IDegree> args,
			IDegreeFactory factory) {
		IDegree[] argz = new IDegree[args.size()];
		Iterator<? extends IDegree> iter = args.iterator();
		for (int j = 0; j < args.size(); j++)
			argz[j] = iter.next();
		return eval(argz,factory);
	}
	

	public IDegree eval(Evaluation evaluation, IDegreeFactory factory) {
		IDegree[] args;
		if (evaluation instanceof CompositeEvaluation) {
			CompositeEvaluation combo = (CompositeEvaluation) evaluation;
			args = null;
			
			if (combo.getOperands() != null) {				
				int N = combo.getOperands().size();
				args = new IDegree[N];
			
				int j = 0;
				for (Evaluation eval : combo.getOperands()) {
					args[j++] = eval.getDegree() == null ? factory.getNullHandlingStrategy().convertNull(factory) : eval.getDegree();		
				}
			}
			
		
		} else {
			args = new IDegree[] {evaluation.getDegree()};
		}
		
		return eval(args,factory);
	}

	public boolean isTruthFunctional() {
		return true;
	}

}
