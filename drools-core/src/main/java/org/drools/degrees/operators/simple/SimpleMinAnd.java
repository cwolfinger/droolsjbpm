package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleMinAnd extends AbstractOperator  implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		double ans = 1;
		for (IDegree deg : args) {
			SimpleDegree d = deg.asSimpleDegree();	
				ans = Math.min(ans,d.getValue());
		}
		
		return new SimpleDegree(ans);
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return "minAnd";		
	}

}
