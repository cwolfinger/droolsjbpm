package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleLukasAnd implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		float ans = 1;
		for (IDegree deg : args) {
			SimpleDegree d = deg.asSimpleDegree();
				ans += d.getValue() - 1;
		}
		
		return new SimpleDegree(Math.max(0,ans));
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		float ans = 1;
		for (IDegree deg : args) {
			SimpleDegree d = deg.asSimpleDegree();			
				ans += d.getValue() - 1;
		}
		
		return new SimpleDegree(Math.max(0,ans));
	}

	public String getName() {
		return "lukAnd";
	}

}
