package org.drools.reteoo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import org.drools.RuntimeDroolsException;
import org.drools.common.BetaConstraints;
import org.drools.common.EmptyBetaConstraints;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.ImplicationBetaConstraint;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.rule.Behavior;
import org.drools.rule.ContextEntry;
import org.drools.rule.Rule;
import org.drools.spi.PropagationContext;

public class ModusPonensNode extends JoinNode {

		
	
	private IDegreeCombiner mPOperator;



	public ModusPonensNode(final int id,
            final LeftTupleSource leftInput,                
            final Behavior[] behaviors,
            IDegreeFactory factory,            
            final BuildContext context) {				
		super(id,
			  leftInput,
			  //new ImplicationObjectSource(),
			  null,
			  new ImplicationBetaConstraint(factory, factory.True(), context),
			  behaviors,
			  context);
		
//		Map<String,String> ruleDetails = context.getRule().getMetaAttributes();
		
		Rule rule = context.getRule();
		
		String priorStr = rule.getPriorDescription();		
			if (priorStr != null)
				((ImplicationBetaConstraint) this.constraints).setPriorDegree(factory.buildDegree(priorStr));
																		
		String fstr = rule.getFilterStrategy();
		try {
			if (fstr != null) {
				IFilterStrategy overrideStrat = (IFilterStrategy) Class.forName(fstr).newInstance();
				if (overrideStrat != null)
					filterStrat = overrideStrat;
			}
		} catch (Exception e) {
			throw new RuntimeDroolsException(e);
		}
		
		String mode = rule.getEntailMode();
		String kind = rule.getModusPonensKind();
		IDegreeCombiner mpOperator = null;
		if (mode == null || mode.equals("implication")) {
			mpOperator = (kind == null) ?
					factory.getModusPonensOp() : factory.getModusPonensOperator(kind);
		} else if (mode.equals("equivalence")) {
			mpOperator = (kind == null) ?
					factory.getDoubleMPOperator() : factory.getDoubleMPOperator(kind);
		}
			
		setMPOperator(mpOperator);
		
	}
	
	public void attach() {        
        this.leftInput.addTupleSink( this );
    }
	
	
	
	
	
	
	
	
	public void assertLeftTuple(ImperfectLeftTuple leftTuple,
			PropagationContext context, InternalWorkingMemory workingMemory,
			IDegreeFactory factory) {
    	
    	final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        if ( this.tupleMemoryEnabled ) {
            memory.getLeftTupleMemory().add( leftTuple );
        }

        
        	    
        
            EvalRecord premiseRecord = leftTuple.getRecord();
        	            
            ContextEntry adHocCtx = new MPContextEntry(leftTuple);
//            Evaluation implEval = this.constraints.isSatisfiedCachedRight( new ContextEntry[] {adHocCtx},
//					  leftTuple, 
//					  factory )[0];

            ImperfectFactHandle handle = new ImperfectFactHandle();
            ImperfectRightTuple dummyRT = new ImperfectRightTuple(handle,this,null);
            
            Evaluation implEval = this.constraints.isSatisfiedCachedLeft( new ContextEntry[] {adHocCtx}, handle, factory)[0];
            	// For future injections...
            	((ImperfectFactHandle) leftTuple.getLastHandle()).addPropertyDegree(implEval);

        	
            ArgList args = leftTuple.getArgList();
        	Collection<Evaluation> storedEvals = this.getGammaMemory().retrieve(args);
        	    		    		      
    		if (storedEvals != null) {
    			for (Evaluation e : storedEvals)
    				implEval.merge(e);    			
    		}
    		
    		
    		
        	EvalRecord mpRecord = new EvalRecord(this.id,getMPOperator(),factory.getMergeStrategy(),factory.getNullHandlingStrategy(),factory,new ArgList());
        	
        	Iterator ruleIter = this.getRules().iterator();
        	String rule = (String) ruleIter.next();
        	mpRecord.setRuleId(rule);
        	
        		Evaluation core = premiseRecord.getOperands().iterator().next();
        		core.deleteObserver(premiseRecord);
        	mpRecord.addEvaluation(core);        		
        	mpRecord.addEvaluation(implEval);
        	
        	
        	        		        		        	        		        		        		        	
        		
        	switch (this.filterStrat.doTry(mpRecord)) {
        		case DROP : return;
			
        		case HOLD : //TODO: HOLD
        			//System.out.println("HOLD RULES @MP NODE"+this.getId());
        			//System.out.println("Situation is "+mpRecord.expand());
        			
        			if (mpRecord.getLeftTuple() == null || ! mpRecord.getLeftTuple().equals(leftTuple))
        				mpRecord.addObserver(this);
        			
        				mpRecord.setLeftTuple(leftTuple);        				
        				mpRecord.setFactory(factory);
        				mpRecord.setPropagationContext(context);
        				mpRecord.setWorkingMemory(workingMemory);
						
        			
        			break;
			
        		case PASS : 
        			//IN CASE, RULES ARE RECALLED ANYWAY!!!
        			if (mpRecord.getLeftTuple() == null || ! mpRecord.getLeftTuple().equals(leftTuple))
        				mpRecord.addObserver(this);
        			
        				mpRecord.setLeftTuple(leftTuple);        				
        				mpRecord.setFactory(factory);
        				mpRecord.setPropagationContext(context);
        				mpRecord.setWorkingMemory(workingMemory);
        			
        			        			
        			this.sink.propagateAssertLeftTuple( leftTuple,  
        					dummyRT,
                            context,
                            workingMemory,
                            factory,
                            mpRecord,
                            this.tupleMemoryEnabled  );

        			break;
        		default : return;			
        	}
        	
        			                                                                         

        this.constraints.resetTuple( memory.getContext() );
	}
	
	
	
	
	
	
	
	
	protected IDegreeCombiner getMPOperator() {
		return mPOperator;
	}
	
	protected void setMPOperator(IDegreeCombiner op) {
		mPOperator = op;
	}
	
	

	public void update(Observable watcher, Object info) {
		
		EvalRecord record = null;
		if (info instanceof EvalRecord)
			record = (EvalRecord) info;
		
		if (record == null) 
			return;
		
		//System.out.println("**************************************************************UPDATE @MP NODE");
		switch (this.filterStrat.doTry(record)) {
		case DROP : 
			//record.deleteObserver(this);
			return;
		
		case HOLD : 
			//do nothing
			return;
		
		case PASS :
			//go on
			//record.deleteObserver(this);
			//throw new RuntimeException("Awakened objeect");
			//TODO
			if (record.getRightTuple() != null)
				this.sink.propagateAssertLeftTuple( record.getLeftTuple(),
						record.getRightTuple(),
						record.getPropagationContext(),
						record.getWorkingMemory(),
						record.getFactory(),
						record,
						this.tupleMemoryEnabled  );
			else
				this.sink.propagateAssertLeftTuple( record.getLeftTuple(),			
						new ImperfectRightTuple(new ImperfectFactHandle(),this,null),
						record.getPropagationContext(),
						record.getWorkingMemory(),
						record.getFactory(),
						record,
						this.tupleMemoryEnabled  );
			//break;
		default : return;	
		
		}
	
	}
	
	
	
	public void retractLeftTuple(final LeftTuple leftTuple,
            final PropagationContext context,
            final InternalWorkingMemory workingMemory) {
		
		
/* The child of leftTuple is observed by MP */		
//		if (leftTuple instanceof ImperfectLeftTuple) {
//        	System.out.println(this.getClass() + "HACKED TO DETACH RECORD OBSERVER");
//        	((ImperfectLeftTuple) leftTuple).getRecord().deleteObserver(this);
//        }
		
		final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
		memory.getLeftTupleMemory().remove( leftTuple );
		if ( leftTuple.getBetaChildren() != null ) {
			this.sink.propagateRetractLeftTuple( leftTuple,
					context,
					workingMemory );
		}
	}
	
	
	public String toString() {
		Iterator ruleIter = this.getRules().iterator();
    	String rule = (String) ruleIter.next();
		return "MP Node for rule "+rule;
	}
	
	
	
	
	
	
	
	
	
	public void networkUpdated() {
        //this.rightInput.networkUpdated();
        this.leftInput.networkUpdated();
    }
	
	
	
	public static class MPContextEntry implements ContextEntry {
		
		
		private ImperfectLeftTuple leftTuple;
		
		public MPContextEntry(ImperfectLeftTuple lt) {
			this.leftTuple = lt;
		}
		
		public ImperfectLeftTuple getLeftTuple() {
			return leftTuple;
		}

		public ContextEntry getNext() {
			// TODO Auto-generated method stub
			return null;
		}

		public void resetFactHandle() {
			// TODO Auto-generated method stub
			
		}

		public void resetTuple() {
			// TODO Auto-generated method stub
			
		}

		public void setNext(ContextEntry entry) {
			// TODO Auto-generated method stub
			
		}

		public void updateFromFactHandle(InternalWorkingMemory workingMemory,
				InternalFactHandle handle) {
			// TODO Auto-generated method stub
			
		}

		public void updateFromTuple(InternalWorkingMemory workingMemory,
				LeftTuple tuple) {
			// TODO Auto-generated method stub
			
		}

		public void readExternal(ObjectInput arg0) throws IOException,
				ClassNotFoundException {
			// TODO Auto-generated method stub
			
		}

		public void writeExternal(ObjectOutput arg0) throws IOException {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	

}
