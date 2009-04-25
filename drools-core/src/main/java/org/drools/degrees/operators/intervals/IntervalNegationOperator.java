package org.drools.degrees.operators.intervals;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.factory.IntervalDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.NegationOperator;

public class IntervalNegationOperator extends NegationOperator {

	
	protected IDegree negate(IDegree arg) {
		IntervalDegree iDeg = (IntervalDegree) arg;
		return new IntervalDegree(iDeg.getPhi(),1-iDeg.getTau());
	}
	
	
	
}
