package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDiscountOperator;

public class SimpleDiscountOperator implements IDiscountOperator {

		
	private SimpleDegree unk;
	
	public SimpleDiscountOperator(SimpleDegree unk) {
		this.unk = unk;
	}
	
	public IDegree discount(IDegree source, float strength) {
		float val = (1-strength)*unk.getValue() + strength*source.getDegree().getValue();
		return new SimpleDegree(val);
	}

	public IDegree eval(IDegree[] args, IDegreeFactory factory) {
		return discount(args[0], args[1].getDegree().getValue());
	}

	public IDegree eval(Collection<? extends IDegree> args,
			IDegreeFactory factory) {
		Iterator<? extends IDegree> iter = args.iterator();
		IDegree arg = iter.next();
		IDegree wgt = iter.next();
		return discount(arg, wgt.getDegree().getValue());
	}

	public String getName() {
		return "disc";
	}
	
}
