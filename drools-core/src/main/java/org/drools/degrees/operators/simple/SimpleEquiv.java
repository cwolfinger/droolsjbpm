package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleEquiv extends AbstractOperator  implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {	
		return new SimpleDegree( 1 - Math.abs(
						args[0].getValue() 
						- args[1].getValue())
						);
	}

	
	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		
		if (args == null || args.size() < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();
		
		Iterator<? extends IDegree> iter = args.iterator();
		SimpleDegree a1 = (SimpleDegree) iter.next();
		SimpleDegree a2 = (SimpleDegree) iter.next();
		
		return new SimpleDegree( 1 - Math.abs(
				a1.getValue() 
				- a2.getValue())
				);			
	}


	public String getName() {
		return "distEquiv";
	}
	
	

}
