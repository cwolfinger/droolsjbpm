package org.drools.reteoo;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;


import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.spi.PropagationContext;

public class EvalRecord extends Observable implements Observer {
	
	
	private Map<ConstraintKey, Evaluation> 		evalMap;
	private ConstraintKey 						mainKey;
	
	private IDegree 							overallDegree;
	
	
	
	
	private ImperfectFactHandle 				factHandle;
    private PropagationContext					propagationContext;
    private InternalWorkingMemory 				workingMemory;
    private IDegreeFactory						factory;
    
	
	
	
	
	
		
	public EvalRecord() {
		mainKey = null;
		evalMap = new HashMap<ConstraintKey, Evaluation>();
	}
	
	public Collection<Evaluation> getEvaluations() {
		return evalMap.values();
	}
	
	
	
	protected Evaluation insert(Evaluation eval) {
				
		//pre-order visit!
		if (eval instanceof CompositeEvaluation) {
			CompositeEvaluation combo = (CompositeEvaluation) eval;
			Evaluation[] operands = combo.getOperands();
			for (int j = 0; j < operands.length; j++) {
				Evaluation newOp = insert(operands[j]);
				combo.setOperand(j,newOp);
			}			
		}
		
		Evaluation prevEval = evalMap.get(eval.getKey());
		if (prevEval == null) {
			System.out.println(this.getClass()+" insert "+eval.toString());
			evalMap.put(eval.getKey(),eval);	
			prevEval = eval;
			eval.addObserver(this);
		} else {
			System.out.println(this.getClass()+" merge "+eval.toString());
			prevEval.merge(eval);
		}
		
		return prevEval;
	}
	
	public void addEvaluation(Evaluation eval) {
		
		
		Evaluation addedEval = insert(eval);							
		
		
		if (mainKey != null && mainKey.equals(addedEval.getKey()) /*&& ! prevEval.getDegree().equals(overallDegree)*/) {
			mainKey = addedEval.getKey();
			overallDegree = addedEval.getDegree();
			this.setChanged();
			this.notifyObservers(null);
		} else {
			mainKey = addedEval.getKey();
			overallDegree = addedEval.getDegree();
		}
				
	}
	
	
	public void addEvaluations(EvalRecord other) {				
		for (Evaluation eval : other.getEvaluations())
			this.addEvaluation(eval);
	}
	
	public void addEvaluations(Collection<Evaluation> evals) {
		for (Evaluation eval : evals)
			this.addEvaluation(eval);		
	}
	
	
	public IDegree getOverallDegree() {
		//return getMainEval().getDegree();
		return overallDegree;
	}
	
	public EvalRecord clone() {
		
		EvalRecord ans = new EvalRecord();
		ans.addEvaluations(this.getEvaluations());
		
		return ans;
	}
	
	
	public Evaluation getMainEval() {
		return evalMap.get(mainKey);
	}

	
	
	public void update(Observable obsEval, Object newDeg) {
		Evaluation eval = (Evaluation) obsEval;
		if (eval.getKey().equals(mainKey)) {
			overallDegree = eval.getDegree();
			this.setChanged();
			this.notifyObservers(null);
		}		
	}
	
	
	
	
	
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Eval Record: \n");
		for (Evaluation ev : getEvaluations())
			sb.append(ev.toString()+"\n");
		sb.append("\n");
		return sb.toString();
	}

	
	
	
	
	/**
	 * @param factHandle the factHandle to set
	 */
	public void setFactHandle(ImperfectFactHandle factHandle) {
		this.factHandle = factHandle;
	}

	/**
	 * @return the factHandle
	 */
	public ImperfectFactHandle getFactHandle() {
		return factHandle;
	}

	/**
	 * @param propagationContext the propagationContext to set
	 */
	public void setPropagationContext(PropagationContext propagationContext) {
		this.propagationContext = propagationContext;
	}

	/**
	 * @return the propagationContext
	 */
	public PropagationContext getPropagationContext() {
		return propagationContext;
	}

	/**
	 * @param workingMemory the workingMemory to set
	 */
	public void setWorkingMemory(InternalWorkingMemory workingMemory) {
		this.workingMemory = workingMemory;
	}

	/**
	 * @return the workingMemory
	 */
	public InternalWorkingMemory getWorkingMemory() {
		return workingMemory;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(IDegreeFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public IDegreeFactory getFactory() {
		return factory;
	}

	
}
