package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class SimpleMaxMergeStrategy implements IMergeStrategy {

	public IDegree eval(IDegree[] degrees, boolean[] kFlags, INullHandlingStrategy nullStrat, IDegreeFactory factory) {
		IDegree[] args = new IDegree[degrees.length];
		if (factory == null) {
			factory = new SimpleDegreeFactory();
			factory.setClosedWorldAssumption(true);
		}
		
		for (int j = 0; j < degrees.length; j++)
			args[j] = degrees[j] == null ? nullStrat.convertNull(factory) : degrees[j];
		
		if (kFlags != null) {
			IDiscountStrategy discountStrat = factory.getDiscountStrategy();
			args = discountStrat.discount(args, kFlags,factory);
		}
		
		
		double val = factory.Unknown().getValue();
		for (IDegree deg : args) {					
				val = Math.max(val,deg.getValue());		
		}
		
		
		
		return new SimpleDegree(val);
	}

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		return eval(args, null, factory.getNullHandlingStrategy(),factory);
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return "max";
	}

}
