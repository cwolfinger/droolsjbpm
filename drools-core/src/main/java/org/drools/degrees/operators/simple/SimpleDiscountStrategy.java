package org.drools.degrees.operators.simple;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IDiscountOperator;
import org.drools.degrees.operators.IDiscountStrategy;

public class SimpleDiscountStrategy implements IDiscountStrategy {
	
	private IDiscountOperator discOp;

	public SimpleDiscountStrategy(IDiscountOperator discountOperator) {
		discOp = discountOperator;
	}

	public IDegree[] discount(IDegree[] args, boolean[] flags, IDegreeFactory factory) {
		float confMax = 0;
		
		IDegree[] ans = new IDegree[args.length];
		
		for (int j = 0; j < args.length; j++) {
			if (flags[j])
				confMax = Math.max(confMax, args[j].getConfidence(factory.isClosedWorldAssumption()));
		}
		
		for (int j = 0; j < args.length; j++) {
			//float weak = Math.max(0 , confMax - args[j].getConfidence());
			
			float strength;
			float c0 = args[j].getConfidence(factory.isClosedWorldAssumption());
			if (flags[j]) {
				//weaken weaker defeaters
				strength = 1 - (confMax - c0);
			} else {
				//weaken the non-killers
				strength = 1 - confMax;
			}
			
			ans[j] = discOp.discount(args[j], strength);
		}
		return ans;
	}

}
