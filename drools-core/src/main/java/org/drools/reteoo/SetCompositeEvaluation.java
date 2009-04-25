package org.drools.reteoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;

import org.drools.FactHandle;
import org.drools.RuntimeDroolsException;
import org.drools.common.BetaConstraints;
import org.drools.common.EmptyBetaConstraints;
import org.drools.common.InternalFactHandle;
import org.drools.common.TupleStartEqualsConstraint;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.spi.PropagationContext;

public class SetCompositeEvaluation extends CompositeEvaluation {

	//IOperandSet args;
	
	public SetCompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			IDegreeCombiner operator, OperandSet opSet,
			IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat,
			BetaConstraints joinConstraints) {
		super(id,key,deps,mergeStrat,nullStrat, new ArgList());
		
		setOperator(operator);
		
		if (opSet != null && opSet.size() > 0) {
			this.operands = new Vector<Evaluation>(Math.max(1,opSet.size()),1);
			
			LinkedList<Evaluation> evals = opSet.getEvaluations();
			LinkedList<FactHandle> handles = opSet.getHandles();
			for (int j = 0; j < opSet.size(); j++) {
				
								
				EvalRecord record = ((EvalRecord) evals.get(j)).clone();
				
				
				if (! (joinConstraints instanceof EmptyBetaConstraints)) {			
					Evaluation[] newEvals = joinConstraints.isSatisfiedCachedLeft(opSet.getContext(), (InternalFactHandle) handles.get(j), opSet.getFactory());
					for (Evaluation newEv : newEvals) {
						if (! newEv.getKey().toString().equals("starts(tuple,...)"))
							record.addEvaluation(newEv);
					}
				}
				
				
				setOperand(j,record);
			}
			
			combine();			
			
		} else {
			/*
			if (! (joinConstraints instanceof EmptyBetaConstraints)) {			
				Evaluation[] newEvals = joinConstraints.isSatisfiedCachedLeft(opSet.getContext(), (InternalFactHandle) handles.get(j), opSet.getFactory());
				for (Evaluation newEv : newEvals) {
					if (! newEv.getKey().toString().equals("starts(tuple,...)"))
						record.addEvaluation(newEv);
				}
			}
			*/
			this.operands = new Vector<Evaluation>(0);
			combine();
		}
									
		
		
		System.out.println("Created setCE \n "+this.toString());
	}
	
	
	


	public void update(Observable o, Object arg) {
		System.out.println("UPDATE HAS BEEN CALLED ON SETVAL by "+ o.toString());
		
		if (arg instanceof EvalRecord) {
			Evaluation eval = (Evaluation) arg;
			
			System.out.println(eval.expand());
			
			
			if (! this.operands.contains(eval)) {
				//this.operands.add(impRT.getRecord());
					
				setOperand(this.operands.size(), eval);
				System.out.println(eval.expand());
				
				//Just to notify the new arg...
				setChanged();
				this.notifyObservers(eval.getArgs());
			}
			
			//
			
			
			System.out.println(eval.expand());
			combine();
//			setChanged();
//			this.notifyObservers();			
		} else if (arg instanceof ArgList) {
			this.getArgs().merge((ArgList) arg);
		} else {
			throw new RuntimeDroolsException("Only Records & Args accepted by quantifiers, so far. received "+arg.getClass());
					
		}
		
		
	}
	
	
	
	
	
	
		
	
	

}
