package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleEquiv implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args) {	
		return new SimpleDegree( 1 - Math.abs(
						args[0].getDegree().getValue() 
						- args[1].getDegree().getValue())
						);
	}

	
	public IDegree eval(Collection<? extends IDegree> args) {
		
		if (args == null || args.size() < 2)
			return SimpleDegreeFactory.UNKNOWN;
		
		Iterator<? extends IDegree> iter = args.iterator();
		SimpleDegree a1 = (SimpleDegree) iter.next();
		SimpleDegree a2 = (SimpleDegree) iter.next();
		
		return new SimpleDegree( 1 - Math.abs(
				a1.getDegree().getValue() 
				- a2.getDegree().getValue())
				);			
	}


	public String getName() {
		return "distEquiv";
	}
	
	

}
