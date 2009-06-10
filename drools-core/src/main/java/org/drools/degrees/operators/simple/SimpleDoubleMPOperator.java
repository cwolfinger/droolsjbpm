package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;

public class SimpleDoubleMPOperator extends AbstractOperator  implements IDegreeCombiner {

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		if (args == null || args.length < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();		
		IDegree prem = args[0];
		IDegree impl = args[1];
		
		//double mp1 = Math.min(prem.getValue(),impl.getValue());
		//double mp2 = 1 - Math.min(1 - prem.getValue(),impl.getValue());
	
		double mp1 = prem.getValue()*impl.getValue();
		double mp2 = 1 - (1 - prem.getValue())*(impl.getValue());
		
		return new SimpleDegree(Math.min(mp1, mp2));
		                    
	}

	public IDegree eval(Collection<? extends IDegree> args, IDegreeFactory factory) {
		if (args == null || args.size() < 2)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();
		Iterator<? extends IDegree> iter= args.iterator();
		
		IDegree prem = iter.next();
		IDegree impl = iter.next();
		
		//double mp1 = Math.min(prem.getValue(),impl.getValue());
		//double mp2 = 1 - Math.min(1 - prem.getValue(),impl.getValue());
	
		double mp1 = prem.getValue()*impl.getValue();
		double mp2 = 1 - (1 - prem.getValue())*(impl.getValue());
		
		return new SimpleDegree(Math.min(mp1, mp2));
	}

	public String getName() {
		return "dblMP";
	}

}
