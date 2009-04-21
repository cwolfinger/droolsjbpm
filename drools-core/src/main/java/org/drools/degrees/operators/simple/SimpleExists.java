package org.drools.degrees.operators.simple;

import java.util.Collection;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;


public class SimpleExists extends SimpleMaxOr implements IDegreeCombiner {

	

	public String getName() {
		return "exists";
	}

}
