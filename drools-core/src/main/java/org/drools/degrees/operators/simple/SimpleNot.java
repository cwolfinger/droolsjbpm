package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.NegationOperator;

public class SimpleNot extends NegationOperator {

	public IDegree negate(IDegree arg) {
		return new SimpleDegree(1-arg.getValue());
	}

	

}
