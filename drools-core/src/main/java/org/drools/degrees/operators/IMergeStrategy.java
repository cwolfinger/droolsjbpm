package org.drools.degrees.operators;

import org.drools.degrees.IDegree;

public interface IMergeStrategy extends IDegreeCombiner {

	public IDegree eval(IDegree[] degrees, INullHandlingStrategy nullStrat);

}
