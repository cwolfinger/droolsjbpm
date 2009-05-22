package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleXor implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {	
		return new SimpleDegree( Math.abs(
						args[0].getDegree().getValue() 
						- args[1].getDegree().getValue())
						);
	}

	
	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		
		if (args == null || args.size() < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		Iterator<? extends IDegree> iter = args.iterator();
		SimpleDegree a1 = (SimpleDegree) iter.next();
		SimpleDegree a2 = (SimpleDegree) iter.next();
		
		return new SimpleDegree( Math.abs(
				a1.getDegree().getValue() 
				- a2.getDegree().getValue())
				);			
	}


	public String getName() {
		return "distXor";
	}
	
	

}
