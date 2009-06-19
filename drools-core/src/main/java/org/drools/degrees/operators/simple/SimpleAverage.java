package org.drools.degrees.operators.simple;

import java.util.Collection;
import java.util.Iterator;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.operators.AbstractOperator;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.CompositeEvaluation;
import org.drools.reteoo.Evaluation;

public final class SimpleAverage extends AbstractOperator  implements IDegreeCombiner {


		
	public IDegree eval(IDegree[] args, IDegreeFactory factory) {					
		if (args == null || args.length == 0)
			return factory == null ? SimpleDegree.UNKNOWN(true) : factory.Unknown();
		
		float ans = 0;
		int n = 0;
		for (IDegree deg : args) {
			SimpleDegree d = deg.asSimpleDegree();				
				ans += d.getValue();
				n++;
		}
		
		return new SimpleDegree(ans / n);
	}

	
	
	public IDegree eval(Evaluation evaluation, IDegreeFactory factory) {
		double num = 0;
		double wgt = 0;
		if (evaluation instanceof CompositeEvaluation) {
			CompositeEvaluation combo = (CompositeEvaluation) evaluation;

			
			if (combo.getOperands() != null && combo.getOperands().size() > 0) {				
				
				
				for (Evaluation eval : combo.getOperands()) {
					if (eval != null) {
						num += eval.getDegree().getValue();
						
							Iterator<Evaluation> iter = ((CompositeEvaluation) eval).getOperands().iterator();
							Evaluation discounter = iter.next();
							iter = ((CompositeEvaluation) discounter).getOperands().iterator();
								iter.next(); //discounted
						wgt += iter.next().getDegree().getValue();	//weight
					}
							
				}
			}
			
			return wgt == 0 ? factory.Unknown() : factory.buildDegree(num/wgt); 
		} else {
			return evaluation.getDegree();
		}
		
		
	}

	
	
	/*
	public IDegree eval(IDegree[] args) {
		float acc = 0;
		float wgts = 0;
//		SimpleDotAnd op = new SimpleDotAnd();

				
		// So the number of elements is actually twice		
		for (int j = 0; j < args.length; j = j+3) {
			SimpleDegree integrand = (SimpleDegree) args[j];
//			SimpleDegree constraint = (SimpleDegree) args[j+1];
			SimpleDegree weight = (SimpleDegree) args[j+2];
    		
			float w = weight.getValue();
			
			if (w > wgts) {
				wgts = weight.getValue();
				acc = integrand.getValue();
			}
			
								
    	}
										
		return new SimpleDegree(acc);
	}
*/

	

	public String getName() {
		return "avg";
	}
	
	
	
	
	public boolean isTruthFunctional() {
		return false;
	}
	
	
}
