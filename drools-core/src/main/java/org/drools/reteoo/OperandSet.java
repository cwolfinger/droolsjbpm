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
import org.drools.spi.PropagationContext;


public class OperandSet extends Droobservable implements Observer {
	
	private ObservableRightTupleMemoryWrapper memory;
	private ContextEntry context[];
	private IDegreeFactory factory;
	private ImperfectLeftTuple tuple;
	private InternalWorkingMemory workMem;
	private LeftTupleSinkPropagator sink;
	private PropagationContext propContext;
	
	private ImperfectExistsNode node;
	
	private BetaConstraints joinConstraints;
	
	
	private boolean adding;
	private boolean removing;
	
	
	public boolean isAdding() {
		return adding;
	}
	
	public boolean isRemoving() {
		return removing;
	}
	
	
	
	public OperandSet(ImperfectLeftTuple lTuple, ObservableRightTupleMemoryWrapper mem, BetaConstraints constraints, ContextEntry[] context, InternalWorkingMemory wmem, IDegreeFactory factory, LeftTupleSinkPropagator sink, ImperfectExistsNode node, PropagationContext pCtx) {
		this.tuple = lTuple;
		this.memory = mem;
			this.memory.addObserver(this);
		this.factory = factory;
		this.context = context;
		this.joinConstraints = constraints;
		this.workMem = wmem;
		this.sink = sink;
		
		this.node = node;
		this.propContext = pCtx;
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

	
	
	public void update(Observable sender, Object newArg) {
		
		ImperfectRightTuple impRT;
		
		if (sender instanceof ObservableRightTupleMemoryWrapper) {
			
			ObservableRightTupleMemoryWrapper wrapper = (ObservableRightTupleMemoryWrapper) sender;			
			if (newArg instanceof ImperfectRightTuple) {				
				impRT = (ImperfectRightTuple) newArg;
				
				if (wrapper.isAdding()) {
					this.adding = true;
					
															
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
										
					
					this.adding = false;
					
				} else if (wrapper.isRemoving()) {
		
					this.removing = true;
					
					impRT = ((ImperfectRightTuple) newArg); 
					
															
					if (wrapper.size() == 0) {
						
						
						this.setChanged();
						this.notifyObservers(impRT.getRecord());
						
						this.deleteObservers();
						
						
						
						if ( tuple.getBetaChildren() != null ) {
				            this.sink.propagateRetractLeftTuple( tuple,
				                                                 wrapper.getPropContext(),
				                                                 workMem );
				            //System.out.println("Killed children");			
				        }
						
						
						
						
						
						
						this.removing = false;
						
						
						
						// Now regenerate the tuple for a new prop...
						EvalRecord mainRecord = ((ImperfectLeftTuple) tuple).getRecord();
						EvalRecord propRecord = mainRecord.clone();
																		
						SetCompositeEvaluation newEval = (SetCompositeEvaluation) node.template.spawn(this,node.constraints);
						propRecord.addEvaluation(newEval);
						this.addObserver(newEval);			
						
							propRecord.setLeftTuple(tuple);    				
							propRecord.setFactory(factory);
							propRecord.setPropagationContext(propContext);
							propRecord.setWorkingMemory(workMem);
						
						node.update(this,propRecord);
						
						//System.out.println();																																				
						
						
						
					} else {
						
						this.setChanged();
						this.notifyObservers(impRT.getRecord());
					
						this.removing = false;
					}
					
																						
					
					
					
				}
						
			} else {
				
						
			}						
		}
	}
	
	
	public String toString() {
		return "OpSet " + size();
	}
	
	

}
