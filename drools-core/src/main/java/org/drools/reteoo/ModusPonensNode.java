package org.drools.reteoo;

import java.util.Collection;
import java.util.Map;

import org.drools.RuntimeDroolsException;
import org.drools.common.BetaConstraints;
import org.drools.common.EmptyBetaConstraints;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.ImplicationBetaConstraint;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.rule.Behavior;
import org.drools.spi.PropagationContext;

public class ModusPonensNode extends JoinNode {

		
	
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
		
		Map<String,String> ruleDetails = context.getRule().getMetaAttributes();
		
		String dstr = ruleDetails.get("degree");
			if (dstr != null)
				((ImplicationBetaConstraint) this.constraints).setPriorDegree(factory.buildDegree(Float.parseFloat(dstr)));
																		
		String fstr = ruleDetails.get("filterStrat");
		try {
			if (fstr != null) {
				IFilterStrategy overrideStrat = (IFilterStrategy) Class.forName(fstr).newInstance();
				if (overrideStrat != null)
					filterStrat = overrideStrat;
			}
		} catch (Exception e) {
			throw new RuntimeDroolsException(e);
		}
				
		
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

        
        	    
        
            EvalRecord premiseRecord = leftTuple.getRecord().clone();
        	            
            Evaluation implEval = this.constraints.isSatisfiedCachedRight( memory.getContext(),
					  leftTuple, 
					  factory )[0];
        	
            ArgList args = new ArgList(leftTuple.toObjectArray());
        	Collection<Evaluation> storedEvals = this.getGammaMemory().retrieve(args);
        	    		    		      
    		if (storedEvals != null) {
    			for (Evaluation e : storedEvals)
    				implEval.merge(e);    			
    		}
    		
    		
    		
        	EvalRecord mpRecord = new EvalRecord(this.id,factory.getModusPonensOp(),factory.getMergeStrategy(),factory.getNullHandlingStrategy());
        	mpRecord.addEvaluation(premiseRecord.getOperands()[0]);
        	mpRecord.addEvaluation(implEval);
        	
        	
        	        		        		        	        		        		        		        	
        		
        	switch (this.filterStrat.doTry(mpRecord)) {
        		case IFilterStrategy.DROP : return;
			
        		case IFilterStrategy.HOLD : //TODO: HOLD
        			System.out.println("HOLD RULES @MP NODE"+this.getId());
        			System.out.println("Situation is "+mpRecord.expand());
        			
        				mpRecord.setLeftTuple(leftTuple);        				
        				mpRecord.setFactory(factory);
        				mpRecord.setPropagationContext(context);
        				mpRecord.setWorkingMemory(workingMemory);
					mpRecord.addObserver(this);	
        			
        			break;
			
        		case IFilterStrategy.PASS : 
        			this.sink.propagateAssertLeftTuple( leftTuple,                            
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
	
	
	
	
	
	
	
	
	public void networkUpdated() {
        //this.rightInput.networkUpdated();
        this.leftInput.networkUpdated();
    }
	
	
	
	
	

}
