package org.drools.reteoo;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.drools.RuleBaseConfiguration;
import org.drools.RuntimeDroolsException;
import org.drools.common.BetaConstraints;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.TupleStartEqualsConstraint;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.rule.Behavior;
import org.drools.rule.ContextEntry;
import org.drools.rule.VariableConstraint;
import org.drools.spi.PropagationContext;
import org.drools.util.LeftTupleIndexHashTable;
import org.drools.util.LeftTupleList;
import org.drools.util.RightTupleIndexHashTable;
import org.drools.util.RightTupleList;
import org.drools.util.AbstractHashTable.FieldIndex;

public class ImperfectExistsNode extends ExistsNode implements Observer {
	
	
	
	protected CompositeEvaluationTemplate	template;

	public ImperfectExistsNode(int nextId, LeftTupleSource tupleSource,
			ObjectSource objectSource, BetaConstraints betaConstraints,
			Behavior[] behaviors, BuildContext context) {
		super(nextId,tupleSource,objectSource,betaConstraints,behaviors,context);
				
		IDegreeFactory factory = ((ImperfectRuleBase) context.getRuleBase()).getDegreeFactory();    	
			this.filterStrat = factory.getDefaultStrategy();
			
		this.constraints.buildEvaluationTemplates(this.id,context.getRule().getDependencies(), factory);
			
//		ConstraintKey argKey = null;
//		if (this.rightInput instanceof RightInputAdapterNode)
//			argKey = ((RightInputAdapterNode) this.rightInput).getConstraintKeys()[0];
//		else if (this.rightInput instanceof ObjectSource)
//			argKey = ((ObjectSource) this.rightInput).getConstraintKey();
//		else
//			throw new RuntimeDroolsException("Source of type"+rightInput.getClass()+ " temporarily not supported");
		
		//ConstraintKey key = new ConstraintKey(factory.getExistsOperator().getName(),argKey.toString());
		
								        
	}
	
	
	public EvaluationTemplate buildEvaluationTemplate(IDegreeCombiner operator, Map<ConstraintKey,Set<String>> deps, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat, IDegreeFactory factory) {
		
		
		
		ConstraintKey key = new DynamicConstraintKey(operator.getName());
		template = new CompositeEvaluationTemplate(this.getId(),
				key,
				deps.get(key),
				1,
				operator,
				mergeStrat,
				nullStrat,
				factory);
		
		return template;
	
	} 
		
	
	
	
	public Object createMemory(final RuleBaseConfiguration config) {
		BetaMemory memory = (BetaMemory) super.createMemory(config);
		
		memory.setRightTupleMemory(
					new ObservableRightTupleMemoryWrapper(memory.getRightTupleMemory()));
				
        return memory;
    }
	
	
	
    
	public void assertObject(ImperfectFactHandle factHandle,
			PropagationContext propagationContext,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord record) {
							
			
		
		
		 final RightTuple rightTuple = new ImperfectRightTuple( factHandle,
                 this, record );

		 final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
		 	if ( !behavior.assertRightTuple( memory.getBehaviorContext(),
		 			rightTuple,
		 			workingMemory ) ) {
		 		// 	destroy right tuple
		 		rightTuple.unlinkFromRightParent();
		 		return;
		 	}

		 	
		 	this.constraints.updateFromFactHandle( memory.getContext(),
                    workingMemory,
                    factHandle );
		 	
		 		memory.getRightTupleMemory().add( rightTuple );
		 	
		 	this.constraints.resetFactHandle( memory.getContext() );
		 	
		 	
		 	//will call notify on observers!
		 			 			 			 			 
		 	if ( !this.tupleMemoryEnabled ) {
		 		// 	do nothing here, as we know there are no left tuples at this stage in sequential mode.
		 		return;
		 	}

		 	
		 	
		 	
		 	
		 	
		 /*	
		 	this.constraints.updateFromFactHandle( memory.getContext(),
		 			workingMemory,
		 			factHandle );
		 	for ( LeftTuple leftTuple = memory.getLeftTupleMemory().getFirst( rightTuple ); leftTuple != null; ) {
		 		// preserve next now, in case we remove this leftTuple 
		 		LeftTuple temp = (LeftTuple) leftTuple.getNext();

		 		// 		we know that only unblocked LeftTuples are  still in the memory
		 		if ( this.constraints.isAllowedCachedRight( memory.getContext(),
		 				leftTuple ) ) {
		 			leftTuple.setBlocker( rightTuple );
		 			rightTuple.setBlocked( leftTuple );

		 			if ( this.tupleMemoryEnabled ) {
		 				// 	this is now blocked so remove it from memory
		 				memory.getLeftTupleMemory().remove( leftTuple );
		 			}
		 			this.sink.propagateAssertLeftTuple( leftTuple,
		 					propagationContext,
		 					workingMemory,
		 					this.tupleMemoryEnabled );
		 		}

		 		leftTuple = temp;
		 	}

		 	this.constraints.resetFactHandle( memory.getContext() );
		*/
	}

	
	public void assertLeftTuple(ImperfectLeftTuple leftTuple,
			PropagationContext context, InternalWorkingMemory workingMemory,
			IDegreeFactory factory) {
		
		final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
		
		
		RightTupleMemory rtMem = memory.getRightTupleMemory();		
		ObservableRightTupleMemoryWrapper wrappedMemory = (ObservableRightTupleMemoryWrapper) rtMem; 

		OperandSet opSet = new OperandSet(leftTuple,wrappedMemory,this.constraints,memory.getContext(),workingMemory,factory, sink, this, context);
		
		
		EvalRecord mainRecord = leftTuple.getRecord().clone();
		
				
		 this.constraints.updateFromTuple( memory.getContext(),
                 workingMemory,
                 leftTuple );

		 SetCompositeEvaluation eval = (SetCompositeEvaluation) template.spawn(opSet,this.constraints);

		 this.constraints.resetTuple( memory.getContext() );

		
										
		opSet.addObserver( eval);
	
			
		mainRecord.addEvaluation(eval);
		
			
		
			
		        				
		System.out.println("Situation at EXISTS eval"+mainRecord.expand());        		        		        		        	
    	
		
    	switch (this.filterStrat.doTry(mainRecord)) {
    		case IFilterStrategy.DROP : 
//    			System.out.println("Exist FAIL at assertTuple: DROP record");
//    			return;
    			    					  
    			
		
    		case IFilterStrategy.HOLD : //TODO: HOLD
    			System.out.println("HOLD RULES @EXIST NODE"+this.getId());
    			System.out.println("Situation is "+mainRecord.expand());
    			
    				mainRecord.setLeftTuple(leftTuple);    				
    				mainRecord.setFactory(factory);
    				mainRecord.setPropagationContext(context);
    				mainRecord.setWorkingMemory(workingMemory);
				mainRecord.addObserver(this);	
    			
    			break;
		
    		case IFilterStrategy.PASS : 
    			System.out.println("Exist PASS at assertTuple: propagate record");
    			mainRecord.setLeftTuple(leftTuple);
    			mainRecord.setFactory(factory);
				mainRecord.setPropagationContext(context);
				mainRecord.setWorkingMemory(workingMemory);
				
				mainRecord.deleteObserver(this);	

    			
    			this.sink.propagateAssertLeftTuple( leftTuple,                        
                        context,
                        workingMemory,
                        factory,
                        mainRecord,
                        this.tupleMemoryEnabled  );

    			break;
    		default : return;	
		
    	}
		
    } 
	
	public ConstraintKey[] getConstraintKeys() {
		return new ConstraintKey[] {this.template.getConstraintKey()};		
	}







	public void update(Observable o, Object arg) {
		
		System.out.println(this.getClass().toString() + " NOTIFIED OF CHANGE");
		
		EvalRecord mainRecord = null;
		
		if (arg instanceof EvalRecord)
			mainRecord = (EvalRecord) arg;
		
		if (mainRecord == null) 
			return;
		
		
		System.out.println("Situation changed at EXISTS eval"+mainRecord.expand());        		        		        		        	
    	
		
    	switch (this.filterStrat.doTry(mainRecord)) {
    		case IFilterStrategy.DROP : 
//    			System.out.println("Exist FAIL at assertTuple: DROP record");
//    			return;
    			
    			
//		
    		case IFilterStrategy.HOLD : //TODO: HOLD
    			System.out.println("HOLD RULES @EXIST NODE"+this.getId());
    			System.out.println("Situation is "+mainRecord.expand());    	
    			
    			
    			mainRecord.addObserver(this);
    			
    			break;
		
    		case IFilterStrategy.PASS : 
    			System.out.println("Exist PASS at assertTuple: propagate record");
    			
    			mainRecord.deleteObserver(this);
    			
    			this.sink.propagateAssertLeftTuple( mainRecord.getLeftTuple(),                        
                        mainRecord.getPropagationContext(),
                        mainRecord.getWorkingMemory(),
                        mainRecord.getFactory(),
                        mainRecord,
                        this.tupleMemoryEnabled  );

    			break;
    		default : return;	
		
    	}		
	}
	
	
	
	
	
	public void retractRightTuple(final RightTuple rightTuple,
            final PropagationContext context,
            final InternalWorkingMemory workingMemory) {


		final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
//		behavior.retractRightTuple( memory.getBehaviorContext(),
//				rightTuple,
//				workingMemory );
		ObservableRightTupleMemoryWrapper wrapper = ((ObservableRightTupleMemoryWrapper) memory.getRightTupleMemory());		
			wrapper.remove( rightTuple, context);
		       
	}
	
	
	
	
	
	public String toString() {
        
        return "[Imp_ExistsNode - " +this.constraints.toString() + "]";
    }

}
