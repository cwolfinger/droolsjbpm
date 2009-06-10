package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleLukasImplication extends AbstractOperator  implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		double ans = 1 - args[0].getValue() + args[1].getValue();
		
		
		return new SimpleDegree(Math.min(1,ans));
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		Iterator<? extends IDegree> iter = args.iterator();
		double ans = 1 - iter.next().getValue() + iter.next().getValue();
		
		
		return new SimpleDegree(Math.min(1,ans));
		
	}

	public String getName() {
		return "lukImp";
	}

}
