package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class DefaultIntervalMergeStrategy implements IMergeStrategy {
	
	private IntervalIntersectionOperator op = new IntervalIntersectionOperator();

	public IDegree eval(IDegree[] degrees, INullHandlingStrategy nullStrat) {
		IDegree[] args = new IDegree[degrees.length];
		for (int j = 0; j < degrees.length; j++) {
			args[j] = degrees[j] != null ? degrees[j] : nullStrat.convertNull(); 
		}
		return op.eval(args);
	}

	public IDegree eval(IDegree[] args) {
		return eval(args, new DefaultIntervalNullHandlingStrategy());
	}

	public IDegree eval(Collection<? extends IDegree> degrees) {
		IDegree[] args = new IDegree[degrees.size()];
		Iterator<? extends IDegree> iter = degrees.iterator();
		INullHandlingStrategy nullStrat = new DefaultIntervalNullHandlingStrategy();
		
		int j = 0;
		while (iter.hasNext()) {
			IDegree deg = iter.next();
			args[j++] = deg != null ? deg : nullStrat.convertNull(); 
		}
		return op.eval(args);
	}

	public String getName() {
		return "i_intersect";
	}

}
