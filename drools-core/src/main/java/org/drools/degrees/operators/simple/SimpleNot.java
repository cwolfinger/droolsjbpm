package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleNot implements IDegreeCombiner {

	public IDegree eval(IDegree[] args) {
		return new SimpleDegree(1-args[0].getDegree().getValue());
	}

	public IDegree eval(Collection<? extends IDegree> args) {
		return new SimpleDegree(1-args.iterator().next().getDegree().getValue());

	}

	public String getName() {
		return "not";
	}

}
