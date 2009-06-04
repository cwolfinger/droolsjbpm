package org.drools.degrees.operators.intervals;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IDiscountOperator;

public class IntervalDiscountOperator implements IDiscountOperator {

	
	public IDegree discount(IDegree arg, double strength) {
		double alfa = strength;
		IntervalDegree ival = (IntervalDegree) arg;
		return new IntervalDegree(ival.getTau()*alfa, 1 - ival.getPhi()*alfa);	
	}
	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();
		
		IntervalDegree ival = (IntervalDegree) args[0];
		SimpleDegree disc = args[1].asSimpleDegree();
		double alfa = disc.getValue();	
		
		return new IntervalDegree(ival.getTau()*alfa, 1 - ival.getPhi()*alfa);
		
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() < 2)
			return factory == null ? IntervalDegreeFactory.UNKNOWN : factory.Unknown();
		Iterator<? extends IDegree> iter= args.iterator();
		
		IntervalDegree ival = (IntervalDegree) iter.next();
		SimpleDegree disc = iter.next().asSimpleDegree();
		double alfa = disc.getValue();	
		
		
		return new IntervalDegree(ival.getTau()*alfa, 1 - ival.getPhi()*alfa);
	}

	public String getName() {
		return "i_discount";
	}

	

}
