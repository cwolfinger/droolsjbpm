package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleVeryModifier  extends AbstractOperator  implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		double arg = args[0].getValue();
		
		
		return new SimpleDegree(arg*arg);
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		double arg = args.iterator().next().getValue();
		
		
		return new SimpleDegree(arg*arg);
	}

	public String getName() {
		return "very";
	}

}
