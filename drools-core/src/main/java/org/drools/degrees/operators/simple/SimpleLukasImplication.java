package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleLukasImplication implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		float ans = 1 - args[0].getDegree().getValue() + args[1].getDegree().getValue();
		
		
		return new SimpleDegree(Math.min(1,ans));
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		Iterator<? extends IDegree> iter = args.iterator();
		float ans = 1 - iter.next().getDegree().getValue() + iter.next().getDegree().getValue();
		
		
		return new SimpleDegree(Math.min(1,ans));
		
	}

	public String getName() {
		return "lukImp";
	}

}
