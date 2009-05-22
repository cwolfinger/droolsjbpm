package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleDotAnd implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		float ans = 1;
		for (IDegree deg : args) {
			SimpleDegree d = deg.getDegree();				
				ans *= d.getValue();
		}
		
		return new SimpleDegree(ans);
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return "dotAnd";
	}

}
