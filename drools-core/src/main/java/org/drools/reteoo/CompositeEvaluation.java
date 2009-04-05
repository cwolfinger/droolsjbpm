package org.drools.reteoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class CompositeEvaluation extends Evaluation implements Observer {

	private IDegreeCombiner operator;
	private Evaluation[] operands;
	private float opRate;
	
	public CompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			Evaluation[] evalDegrees, IDegreeCombiner operator, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {		
		super(id,key,deps,mergeStrat,nullStrat);
		
		this.operands = new Evaluation[evalDegrees.length];
			for (int j = 0; j < evalDegrees.length; j++) {
				setOperand(j,evalDegrees[j]);
			}
	
		this.operator = operator;
		
		this.combine();
	}
	


	public CompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			Map<ConstraintKey, EvaluationTemplate> children,
			IDegreeCombiner operator, IMergeStrategy mergeStrat,
			INullHandlingStrategy nullStrat) {
		
		super(id,key,deps,mergeStrat,nullStrat);
		
		this.operands = new Evaluation[children.size()];
			int j = 0;
			for (EvaluationTemplate temp : children.values()) {
				setOperand(j++,temp.spawn());
			}
	
		this.operator = operator;
		
		this.combine();
		
	}

	protected void combine() {
		int N = operands.length;
		IDegree[] args = new IDegree[N];
		
		
		for (int j=0; j < N; j++) {
			args[j] = operands[j].getDegree();
		
		}
				
		IDegree opDeg = this.operator.eval(args);
		updateOpRate();
		this.addDegree(Evaluation.EVAL, opDeg, getOpRate());
		
	}
	
	
	public Evaluation[] getOperands() {
		return operands;
	}
	
	public void setOperand(int position, Evaluation operand) {
				
		if (operands[position] != null && operands[position] != operand) {
			System.out.println("SET OPERAND "+operand.getKey()+ "with " + operand.getBitS());
			operands[position].deleteObserver(this);
			operand.addObserver(this);
			operands[position] = operand;
			combine();
		} else {
			operand.addObserver(this);
			operands[position] = operand;
		}
													
	}
	
	public Collection<Evaluation> getEvalTree() {
		Collection<Evaluation> ans = new ArrayList<Evaluation>(2*operands.length);
			for (Evaluation eval : operands)
				ans.addAll(eval.getEvalTree());
		ans.add(this);
			
		return ans;
	}
	
//	
//	protected void incInfo(String source, float wgt) {
//		if (source.equals(EVAL)) {
//			float delta = 0;
//			for (Evaluation child : this.operands) {
//				delta += child.getInfoRate();
//			}			
//			opRate = delta / (1.0f*this.operands.length);			
//			incInfo(source,opRate);			
//		} else super.incInfo(source, wgt);
//	}

	
	public float getOpRate() {
		return opRate;
	}
	
	protected void updateOpRate() {
		float delta = 0;
		for (Evaluation child : this.operands) {
			delta += child.getInfoRate();
		}			
		opRate = delta / (1.0f*this.operands.length);			
	}	
	
	
	public void update(Observable o, Object arg) {
		System.out.println("UPDATE HAS BEEN CALLED ON COMBOVAL");
		incInfo("EVAL",-opRate);
		combine();		
	}
	
	
	
	
	

}
