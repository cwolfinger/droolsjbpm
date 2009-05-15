package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;

public final class SimpleIdentityOperator implements IDegreeCombiner {


		
	public IDegree eval(IDegree[] args) {					
		if (args == null || args.length == 0)
			return SimpleDegree.UNKNOWN();
		
		return args[0];
	}

	
	
	
	/*
	public IDegree eval(IDegree[] args) {
		float acc = 0;
		float wgts = 0;
//		SimpleDotAnd op = new SimpleDotAnd();

				
		// So the number of elements is actually twice		
		for (int j = 0; j < args.length; j = j+3) {
			SimpleDegree integrand = (SimpleDegree) args[j];
//			SimpleDegree constraint = (SimpleDegree) args[j+1];
			SimpleDegree weight = (SimpleDegree) args[j+2];
    		
			float w = weight.getValue();
			
			if (w > wgts) {
				wgts = weight.getValue();
				acc = integrand.getValue();
			}
			
								
    	}
										
		return new SimpleDegree(acc);
	}
*/

	public IDegree eval(Collection<? extends IDegree> args) {
		if (args == null || args.size() == 0)
			return SimpleDegree.UNKNOWN();
		
		return args.iterator().next();
	}

	public String getName() {
		return "identity";
	}
	
	
	
}
