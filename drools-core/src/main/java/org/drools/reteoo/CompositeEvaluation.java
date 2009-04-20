package org.drools.reteoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;

import org.drools.RuntimeDroolsException;
import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public class CompositeEvaluation extends Evaluation implements Observer {

	private IDegreeCombiner operator;
	protected Vector<Evaluation> operands;
	private float opRate;
	
	public CompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			Evaluation[] evalDegrees, IDegreeCombiner operator, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {		
		super(id,key,deps,mergeStrat,nullStrat);
		
		if (evalDegrees != null) {
			this.operands = new Vector<Evaluation>(evalDegrees.length);
				for (int j = 0; j < evalDegrees.length; j++) {
					setOperand(j,evalDegrees[j]);
				}
		} else {
			this.operands = new Vector<Evaluation>(0);
		}
	
		this.operator = operator;
		
		this.combine();
	}
	
	
	
	protected CompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {		
		super(id,key,deps,mergeStrat,nullStrat);
				
		this.operands = new Vector<Evaluation>(0);			
		this.operator = null;
				
	}
	
	
	
	
	
	public CompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
			int arity, IDegreeCombiner operator, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {		
		super(id,key,deps,mergeStrat,nullStrat);
				
		this.operands = new Vector<Evaluation>(arity);
		
	
		this.operator = operator;
		//Don't do combine as operands are not set!
		//this.combine();
	}
	


//	public CompositeEvaluation(int id, ConstraintKey key, Set<String> deps,
//			Map<ConstraintKey, EvaluationTemplate> children,
//			IDegreeCombiner operator, IMergeStrategy mergeStrat,
//			INullHandlingStrategy nullStrat) {
//		
//		super(id,key,deps,mergeStrat,nullStrat);
//		
//		this.operands = new Evaluation[children.size()];
//			int j = 0;
//			for (EvaluationTemplate temp : children.values()) {
//				setOperand(j++,temp.spawn());
//			}
//	
//		this.operator = operator;
//		
//		this.combine();
//		
//	}

	protected boolean combine() {
		
		
		IDegree[] args = null;
		
		if (getOperands() != null) {				
			int N = getOperands().size();
			args = new IDegree[N];
		
			int j = 0;
			for (Evaluation eval : getOperands()) {
				args[j++] = eval.getDegree();		
			}
		}		
		
		IDegree opDeg = this.operator.eval(args);
		updateOpRate();
		boolean newContrib = this.addDegree(Evaluation.EVAL, opDeg, getOpRate(),true);
						
		return newContrib;
		
	}
	
	
	public Collection<Evaluation> getOperands() {
		return operands;
	}
	
	public void setOperand(int position, Evaluation operand) {
				
		if (operands.size() <= position) {
			// Surely a new operand!
			operands.setSize(position+1);
			
			operand.addObserver(this);
			//operands.set(position,operand);
		} else {
			if (operands.get(position) != null && operands.get(position) != operand) {
				System.out.println("SET OPERAND "+operand.getKey()+ "with " + operand.getBitS());
				operands.get(position).deleteObserver(this);
				operand.addObserver(this);
				//operands.set(position,operand);
				//combine();
			} else {
				// merging with old op
//				if (operands.get(position) != null)
//					throw new RuntimeDroolsException("DD");														
				//operands.set(position,operand);
			}
		}		
		
		operands.set(position,operand);
	}
	
	public Collection<Evaluation> getEvalTree() {
		Collection<Evaluation> ans = new ArrayList<Evaluation>(2*operands.size());
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
		if (this.operands.size() == 0) {
			setOpRate(1);
		} else {
			float delta = 0;
			for (Evaluation child : this.getOperands()) {
				delta += child.getInfoRate();
			}			
			setOpRate(delta / (1.0f*this.operands.size()));
		}
	}	
	
	
	public void update(Observable o, Object arg) {
		System.out.println("\nUPDATE HAS BEEN CALLED ON COMBOVAL by" + o.toString());
		incInfo("EVAL",-getOpRate());
		combine();	
		
		this.notifyObservers(this);
	}
	
	protected IDegreeCombiner getOperator() {
		return operator;
	}
	
	protected void setOperator(IDegreeCombiner newOp) {
		this.operator = newOp;
		//combine();
	}
	
	
	

	
	public String toStringTree(int depth) {
		StringBuilder sb = new StringBuilder();
		
//		if (depth > 0)
//			sb.append(this.toString());
		if (getOperands() != null) {
			for (Evaluation eval : getOperands()) {
				for (int j = 0; j <= depth; j++)
					sb.append("\t");
				sb.append(eval.toString()+"\n");
				if (eval instanceof CompositeEvaluation)
					sb.append(((CompositeEvaluation) eval).toStringTree(depth+1));			
			}
		}
		return sb.toString();
	}

	/**
	 * @param opRate the opRate to set
	 */
	public void setOpRate(float opRate) {
		this.opRate = opRate;
	}
	
}
