package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleLukasOr implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args) {
		if (args == null || args.length == 0)
			return SimpleDegree.UNKNOWN();
		
		float ans = 0;
		for (IDegree deg : args) {
			SimpleDegree d = deg.getDegree();				
				ans += d.getValue();
		}
		
		return new SimpleDegree(Math.min(1,ans));
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() == 0)
			return SimpleDegree.UNKNOWN();
		

		float ans = 0;
		for (IDegree deg : args) {
			SimpleDegree d = deg.getDegree();				
				ans += d.getValue();
		}
		
		return new SimpleDegree(Math.min(1,ans));
	}

	public String getName() {
		return "lukasOr";
	}

}
