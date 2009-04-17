package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleEquiv implements IDegreeCombiner {

	
	public IDegree eval(IDegree[] args) {	
		return new SimpleDegree( 1 - Math.abs(
						args[0].getDegree().getValue() 
						- args[1].getDegree().getValue())
						);
	}

	
	public IDegree eval(Collection<? extends IDegree> args) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getName() {
		return "distEquiv";
	}
	
	

}
