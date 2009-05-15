package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleVeryModifier implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args) {
		if (args == null || args.length == 0)
			return SimpleDegree.UNKNOWN();
		
		float arg = args[0].getDegree().getValue();
		
		
		return new SimpleDegree(arg*arg);
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() == 0)
			return SimpleDegree.UNKNOWN();
		
		float arg = args.iterator().next().getDegree().getValue();
		
		
		return new SimpleDegree(arg*arg);
	}

	public String getName() {
		return "very";
	}

}
