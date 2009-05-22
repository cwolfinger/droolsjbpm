package org.drools.degrees.operators;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;

public interface IMergeStrategy extends IDegreeCombiner {

	public IDegree eval(IDegree[] degrees, boolean[] killerFlags, INullHandlingStrategy nullStrat, IDegreeFactory factory);

}
