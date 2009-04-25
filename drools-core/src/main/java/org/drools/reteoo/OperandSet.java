package org.drools.reteoo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import org.drools.FactHandle;
import org.drools.common.BetaConstraints;
import org.drools.common.EmptyBetaConstraints;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.TupleStartEqualsConstraint;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.rule.ContextEntry;
import org.drools.runtime.rule.WorkingMemory;


public class OperandSet extends Observable implements Observer {
	
	private ObservableRightTupleMemoryWrapper memory;
	private ContextEntry[] context;
	private IDegreeFactory factory;
	private LeftTuple tuple;
	private InternalWorkingMemory workMem;
	
	private BetaConstraints joinConstraints;
	
	
	public OperandSet(LeftTuple lTuple, ObservableRightTupleMemoryWrapper mem, BetaConstraints constraints, ContextEntry[] context, InternalWorkingMemory wmem, IDegreeFactory factory) {
		this.tuple = lTuple;
		this.memory = mem;
			this.memory.addObserver(this);
		this.factory = factory;
		this.context = context;
		this.joinConstraints = constraints;
		this.workMem = wmem;
	}
	
	public LinkedList<Evaluation> getEvaluations() {
		return memory.getEvaluations();
	}
	
	public LinkedList<FactHandle> getHandles() {
		return memory.getHandles();
	}
	

	public int size() {
		return memory.size();
	}
	
	
	

	public IDegreeFactory getFactory() {
		return factory;
	}

	public ContextEntry[] getContext() {
		return context;
	}

	
	
	public void update(Observable arg0, Object newArg) {
		
		
		if (newArg instanceof ImperfectRightTuple) {
			ImperfectRightTuple impRT = (ImperfectRightTuple) newArg;
			EvalRecord record = impRT.getRecord().clone();
			
			joinConstraints.updateFromTuple(getContext(), workMem, tuple);
			if (! (joinConstraints instanceof EmptyBetaConstraints)) {			
				Evaluation[] newEvals = joinConstraints.isSatisfiedCachedRight(context, tuple, factory);
				for (Evaluation newEv : newEvals) {
					if (! newEv.getKey().toString().equals("starts(tuple,...)"))
						record.addEvaluation(newEv);
				}
			}
			joinConstraints.resetTuple(getContext());
			
			this.setChanged();
			this.notifyObservers(record);
			
					
		} else {
			
					
		}						
		
	}
	
	

}
