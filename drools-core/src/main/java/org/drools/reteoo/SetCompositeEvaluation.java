package org.drools.reteoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;

import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class SetCompositeEvaluation extends CompositeEvaluation {

	//IOperandSet args;
	
	public SetCompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			IDegreeCombiner operator, IOperandSet args,
			IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
		super(id,key,deps,mergeStrat,nullStrat);
		
		setOperator(operator);
		
		if (args != null) {
			this.operands = new Vector<Evaluation>(args.size());
			
			int j = 0;
			for (Evaluation eval : args.getArgs())
				setOperand(j++,eval);
			
		} else {
			this.operands = new Vector<Evaluation>(0);
		}
									
		combine();			
		
		System.out.println("Created setCE \n "+this.toString());
	}
	
	
	public void update(Observable o, Object arg) {
		System.out.println("UPDATE HAS BEEN CALLED ON SETVAL by "+ o.toString());
		
		if (arg instanceof ImperfectRightTuple) {
			ImperfectRightTuple impRT = (ImperfectRightTuple) arg;
			if (! this.operands.contains(impRT.getRecord()))
				this.operands.add(impRT.getRecord());
			combine();
//			setChanged();
//			this.notifyObservers();			
		} else {
			
					
		}
		
		
	}
	
	
	
	
	
	
		
	
	

}
