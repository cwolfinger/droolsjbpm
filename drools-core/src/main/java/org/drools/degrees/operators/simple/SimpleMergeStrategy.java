package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class SimpleMergeStrategy implements IMergeStrategy {

	public IDegree eval(IDegree[] degrees, INullHandlingStrategy nullStrat) {
				
		float val = 0;
		for (IDegree deg : degrees) {			
			if (deg == null)
				val = Math.max(val,nullStrat.convertNull().getDegree().getValue());
			else 
				val = Math.max(val,deg.getDegree().getValue());		
		}
		
		return new SimpleDegree(val);
	}

	public IDegree eval(IDegree[] args) {
		return eval(args, new SimpleNullHandlingStrategy());
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		// TODO Auto-generated method stub
		return null;
	}

}
