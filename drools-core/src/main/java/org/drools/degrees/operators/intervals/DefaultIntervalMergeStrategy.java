package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.reteoo.DiscountOperatorInstaller;

public class DefaultIntervalMergeStrategy extends AbstractOperator  implements IMergeStrategy {
	
	private IntervalIntersectionOperator op = new IntervalIntersectionOperator();

	public IDegree eval(IDegree[] degrees, boolean[] kFlags, INullHandlingStrategy nullStrat, IDegreeFactory factory) {
		IDegree[] args = new IDegree[degrees.length];
		
		
		for (int j = 0; j < degrees.length; j++) {
			args[j] = degrees[j] != null ? degrees[j] : nullStrat.convertNull(factory);							
		}
		
		if (kFlags != null) {
			IDiscountStrategy discountStrat = factory.getDiscountStrategy();
			return op.eval(discountStrat.discount(args, kFlags,factory), factory);
		} else {
			return op.eval(args, factory);
		}
	}

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		return eval(args, null, new DefaultIntervalNullHandlingStrategy(),factory);
	}

	public IDegree eval(Collection<? extends IDegree> degrees, IDegreeFactory factory) {
		IDegree[] args = new IDegree[degrees.size()];
		Iterator<? extends IDegree> iter = degrees.iterator();
		INullHandlingStrategy nullStrat = new DefaultIntervalNullHandlingStrategy();
		
		int j = 0;
		while (iter.hasNext()) {
			IDegree deg = iter.next();
			args[j++] = deg != null ? deg : nullStrat.convertNull(factory); 
		}
		return op.eval(args, factory);
	}

	public String getName() {
		return "i_intersect";
	}

}
