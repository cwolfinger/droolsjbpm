package org.drools.reteoo;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;


import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.spi.PropagationContext;

public class EvalRecord extends CompositeEvaluation implements Observer {
	
	
	public static final HashSet<ConstraintKey> 		blackList = new HashSet<ConstraintKey>();
	{
		blackList.add(new ConstraintKey("class","==","org.drools.InitialFact"));
	}
	
	public static final int INITIAL_ID = -99;

	//private Map<ConstraintKey, Evaluation> 		evalMap;
	private Map<Evaluation,Evaluation>				evalSet;
	//private ConstraintKey 						mainKey;
	
	// private IDegree 							overallDegree;
	
	
	
	
	private ImperfectFactHandle 				factHandle;
	private ImperfectLeftTuple					leftTuple;
	private ImperfectRightTuple					rightTuple;
    private PropagationContext					propagationContext;
    private InternalWorkingMemory 				workingMemory;
    //private IDegreeFactory						factory;
    
	
	
	
//    public EvalRecord() {			
//		mainKey = null;
//		evalMap = new HashMap<ConstraintKey, Evaluation>();
//	}
	
		
	public EvalRecord(int id,IDegreeCombiner operator,IMergeStrategy mergeStrat,INullHandlingStrategy nullStrat, IDegreeFactory factory, ArgList args) {
		super(id,new DynamicConstraintKey(operator.getName()),null,null,operator,mergeStrat,nullStrat,factory, args);
		
		//mainKey = null;
		//evalMap = new HashMap<ConstraintKey, Evaluation>();
		evalSet = new HashMap<Evaluation,Evaluation>();
	}
	
	public Collection<Evaluation> getEvaluations() {
		return evalSet.values();
	}
	
	
	
	protected Evaluation insert(Evaluation eval) {
				
		//pre-order visit!
		if (eval instanceof CompositeEvaluation) {
			CompositeEvaluation combo = (CompositeEvaluation) eval;
			Vector<Evaluation> operands = (Vector<Evaluation>) combo.getOperands();
			for (int j = 0; j < operands.size(); j++) {
				Evaluation newOp = insert(operands.get(j));
				combo.setOperand(j,newOp);
			}			
		}
		
		//Evaluation prevEval = evalMap.get(eval.getKey());
		Evaluation prevEval = evalSet.get(eval);
		if (prevEval == null) {
			System.out.println(this.getClass()+" insert "+eval.toString());
			//evalMap.put(eval.getKey(),eval);	
			evalSet.put(eval,eval);
			prevEval = eval;
			//eval.addObserver(this);
		} else {
			System.out.println(this.getClass()+" merge "+eval.toString());
			prevEval.merge(eval);
		}
		
		return prevEval;
	}
	
	
	
	
	
	
	
	public void addEvaluation(Evaluation eval) {
		
		if (eval == null || blackList.contains(eval.getKey()))
			return;
		
		//boolean newEval = ! this.evalMap.containsKey(eval.getKey());
		boolean newEval = ! this.evalSet.containsKey(eval);
		
		Evaluation addedEval = insert(eval);		
		
		if (newEval) {
			if (operands == null) {
				//operands = new Vector<Evaluation>(1);
				
				//operands.add(addedEval);
				setOperand(0, addedEval );
			} else {
				/*
				int N = operands.size();
				Vector<Evaluation> temp = new Vector<Evaluation>(N+1);
				temp.setSize(N+1);
				for (int j = 0; j < N; j++)
					temp.set(j,operands.get(j));
				
				operands = temp;
				
				operands.set(N,addedEval);
				*/
				//operands.add(addedEval);
				setOperand(operands.size(),addedEval);
			}
			//this.setArgCode(this.getArgCode()^eval.getArgCode());
		} else {
			
		}
		
			addedEval.deleteObserver(this);
			addedEval.addObserver(this);
		
		if (newEval)
			((DynamicConstraintKey) this.getKey()).addArg(eval.getKey());
		
		
		combine();
//		this.setChanged();
//		this.notifyObservers(null);
		
//		if (mainKey != null && mainKey.equals(addedEval.getKey()) /*&& ! prevEval.getDegree().equals(overallDegree)*/) {
//			mainKey = addedEval.getKey();
//			overallDegree = addedEval.getDegree();
//			this.setChanged();
//			this.notifyObservers(null);
//		} else {
//			mainKey = addedEval.getKey();
//			overallDegree = addedEval.getDegree();
//		}
				
	}
	
	
	public void addEvaluations(EvalRecord other) {				
		//for (Evaluation eval : other.getEvaluations())
		for (Evaluation eval : other.getOperands()) {
			this.addEvaluation(eval);
			
			
			eval.deleteObserver(other);
		}
	}
	
	public void addEvaluations(Collection<Evaluation> evals) {
		for (Evaluation eval : evals)
			this.addEvaluation(eval);		
	}
	
	
	
	
	public EvalRecord clone() {
		
		EvalRecord ans = new EvalRecord(this.getNodeId(),this.getOperator(),this.getMergeStrat(),this.getNullHandlingStrat(), this.getFactory(), (ArgList) this.getArgs().clone());
		ans.addEvaluations(this);
		
		return ans;
	}
	
	
	
//	public Evaluation getMainEval() {
//		//return evalMap.get(mainKey);
//		return this;
//	}

	
	
//	public void update(Observable obsEval, Object newDeg) {
//		Evaluation eval = (Evaluation) obsEval;
//		if (eval.getKey().equals(mainKey)) {
//			overallDegree = eval.getDegree();
//			this.setChanged();
//			this.notifyObservers(null);
//		}		
//	}
	
	
	
	
	
	
	
	
	public String expand() {
		StringBuilder sb = new StringBuilder("Eval Record info("+this.getInfoRate()+") for args " + getArgs().toString() + " \n");
//		
		
		sb.append("AND{\n");
		if (getOperands() != null)
			for (Evaluation ev : getOperands()) {
				
				sb.append(ev.toString()+"\n");
			}
		sb.append("}\n\n");
		
		sb.append(toString()+"\n");
		sb.append(toStringTree(0));
		
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

//	/**
//	 * @param factory the factory to set
//	 */
//	public void setFactory(IDegreeFactory factory) {
//		this.factory = factory;
//	}
//
//	/**
//	 * @return the factory
//	 */
//	public IDegreeFactory getFactory() {
//		return factory;
//	}

	/**
	 * @param leftTuple the leftTuple to set
	 */
	public void setLeftTuple(ImperfectLeftTuple leftTuple) {
		this.leftTuple = leftTuple;
	}

	/**
	 * @return the leftTuple
	 */
	public ImperfectLeftTuple getLeftTuple() {
		return leftTuple;
	}

	/**
	 * @param rightTuple the rightTuple to set
	 */
	public void setRightTuple(ImperfectRightTuple rightTuple) {
		this.rightTuple = rightTuple;
	}

	/**
	 * @return the rightTuple
	 */
	public ImperfectRightTuple getRightTuple() {
		return rightTuple;
	}

	public void replace(CompositeEvaluation operator, int N) {
		
		
		int M = this.getOperands().size();
		for (int j = M-N; j < M; j++) {
			Evaluation operand = ((Vector<Evaluation>) getOperands()).get(j);
			
			operand.deleteObserver(this);
			operator.setOperand(j+N-M, operand);
			((DynamicConstraintKey) operator.getKey()).addArg(operand.getKey());
		}
		
		
		/*
		Evaluation[] locOperands = new Evaluation[M-N+1];
		((DynamicConstraintKey) this.getKey()).reset();
		for (int j = 0; j < M-N; j++) {
			locOperands[j] = operands[j];
			((DynamicConstraintKey) this.getKey()).addArg(operands[j].getKey());
		}
		locOperands[M-N] = operator;
		((DynamicConstraintKey) this.getKey()).addArg(operator.getKey());
			
		operands = locOperands;
		*/
		
		
		Vector<Evaluation> locOperands = (Vector<Evaluation>) getOperands();
		
		
		((DynamicConstraintKey) this.getKey()).reset();
		for (int j = 0; j < M-N; j++) {			
			((DynamicConstraintKey) this.getKey()).addArg(locOperands.get(j).getKey());
		}				
		((DynamicConstraintKey) this.getKey()).addArg(operator.getKey());
		
		for (int j = 0; j < N; j++) {			
			locOperands.remove(locOperands.size()-1);
		}
		locOperands.add(operator);
		
				
			operator.combine();				
			//evalMap.put(operator.getKey(),operator);
			evalSet.put(operator,operator);
			operator.addObserver(this);
		
		this.combine();
//		this.setChanged();
//		this.notifyObservers(null);
		
		
	}

	
	
	
	
	
}
