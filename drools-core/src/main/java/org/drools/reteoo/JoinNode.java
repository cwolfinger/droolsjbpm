package org.drools.reteoo;

/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import org.drools.RuntimeDroolsException;
import org.drools.common.BetaConstraints;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalRuleBase;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.rule.Behavior;
import org.drools.spi.PropagationContext;
import org.drools.util.Iterator;

/**
 * <code>JoinNode</code> extends <code>BetaNode</code> to perform
 * <code>ReteTuple</code> and <code>FactHandle</code> joins. Tuples are
 * considered to be asserted from the left input and facts from the right input.
 * The <code>BetaNode</code> provides the BetaMemory to store assserted
 * ReteTuples and
 * <code>FactHandleImpl<code>s. Each fact handle is stored in the right memory as a key in a <code>HashMap</code>, the value is an <code>ObjectMatches</code>
 * instance which maintains a <code>LinkedList of <code>TuplesMatches - The tuples that are matched with the handle. the left memory is a <code>LinkedList</code>
 * of <code>ReteTuples</code> which maintains a <code>HashMa</code>, where the keys are the matching <code>FactHandleImpl</code>s and the value is
 * populated <code>TupleMatche</code>es, the keys are matched fact handles. <code>TupleMatch</code> maintains a <code>List</code> of resulting joins,
 * where there is joined <code>ReteTuple</code> per <code>TupleSink</code>.
 *
 *
 * The BetaNode provides
 * the BetaMemory which stores the
 *
 * @see BetaNode
 * @see ObjectMatches
 * @see TupleMatch
 * @see LeftTupleSink
 *
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public class JoinNode extends BetaNode implements IGammaNode, Observer {
    // ------------------------------------------------------------
    // Instance methods
    // ------------------------------------------------------------    

    /**
     *
     */
    private static final long serialVersionUID = 400L;    

    
    private GammaMemory 		gammaMemory;
    
    private boolean				isCutter;
    
    
    
    
    public JoinNode() {

    }

    public JoinNode(final int id,
                    final LeftTupleSource leftInput,
                    final ObjectSource rightInput,
                    final BetaConstraints binder,
                    final Behavior[] behaviors,
                    final BuildContext context) {
        super( id,
               context.getPartitionId(),
               context.getRuleBase().getConfiguration().isMultithreadEvaluation(),
               leftInput,
               rightInput,
               binder,
               behaviors );
        tupleMemoryEnabled = context.isTupleMemoryEnabled();
        
        this.gammaMemory = new GammaMemory();
        
        InternalRuleBase ruleBase = context.getRuleBase();
        if (ruleBase instanceof ImperfectRuleBase) {
        	IDegreeFactory factory = ((ImperfectRuleBase) ruleBase).getDegreeFactory();
        	this.filterStrat = factory.getDefaultStrategy();
        	
        	this.constraints.buildEvaluationTemplates(this.id,context.getRule().getDependencies(), factory);
        	
        	Collection<ConstraintKey> keys = this.constraints.getAllConstraintKeys();
        	for (ConstraintKey key : keys)
        		context.getRuleBase().getRete().indexGammaNode(key,this);
        	
        	if (context.isCutter()) {
        		this.isCutter = true;
        		context.setCutter(false);
        	}
        	this.isCutter = this.isCutter || this.constraints.isCutter();
        }
        System.out.println(this.getClass().getName() + "(id "+id+") constructor hacked to add filter strategy");
        
             
        

    }

    
    public boolean equals(final Object object) {
        return super.equals(object) &&
        	(this.isCutter == ((JoinNode) object).isCutter);
    }
    
    /**
     * Assert a new <code>ReteTuple</code>. The right input of
     * <code>FactHandleInput</code>'s is iterated and joins attemped, via the
     * binder, any successful bindings results in joined tuples being created
     * and propaged. there is a joined tuple per TupleSink.
     *
     * @see LeftTuple
     * @see ObjectMatches
     * @see LeftTupleSink
     * @see TupleMatch
     *
     * @param tuple
     *            The <code>Tuple</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void assertLeftTuple(final LeftTuple leftTuple,
                                final PropagationContext context,
                                final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        if ( this.tupleMemoryEnabled ) {
            memory.getLeftTupleMemory().add( leftTuple );
        }

        this.constraints.updateFromTuple( memory.getContext(),
                                          workingMemory,
                                          leftTuple );
        for ( RightTuple rightTuple = memory.getRightTupleMemory().getFirst( leftTuple ); rightTuple != null; rightTuple = (RightTuple) rightTuple.getNext() ) {
            final InternalFactHandle handle = rightTuple.getFactHandle();
            if ( this.constraints.isAllowedCachedLeft( memory.getContext(),
                                                       handle ) ) {
                this.sink.propagateAssertLeftTuple( leftTuple,
                                                    rightTuple,
                                                    context,
                                                    workingMemory,
                                                    this.tupleMemoryEnabled );
            }
        }

        this.constraints.resetTuple( memory.getContext() );
    }
    
    
    public void assertLeftTuple(ImperfectLeftTuple leftTuple,
			PropagationContext context, InternalWorkingMemory workingMemory,
			IDegreeFactory factory) {
    	
    	final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        if ( this.tupleMemoryEnabled ) {
            memory.getLeftTupleMemory().add( leftTuple );
        }

        this.constraints.updateFromTuple( memory.getContext(),
                                          workingMemory,
                                          leftTuple );
        for ( ImperfectRightTuple rightTuple = (ImperfectRightTuple) memory.getRightTupleMemory().getFirst( leftTuple ); rightTuple != null; rightTuple = (ImperfectRightTuple) rightTuple.getNext() ) {
            
        	final ImperfectFactHandle factHandle = (ImperfectFactHandle) rightTuple.getFactHandle();
        	EvalRecord record = rightTuple.getRecord().clone();
                       
            EvalRecord mainRecord = leftTuple.getRecord().clone();
        	
        	
        	Collection<Evaluation> storedEvals = this.gammaMemory.retrieve(new ArgList(leftTuple.toObjectArray(),factHandle.getObject()));
    		if (storedEvals != null) {
    			record.addEvaluations(storedEvals);
    			factHandle.addPropertyDegrees(storedEvals);
    		}
    		
    		
        	
        	
        	//Call internal evaluator, if not done before
    		ConstraintKey[] keys = this.constraints.getConstraintKeys();
    		if (keys != null) {
//		    		Evaluation evalTest = factHandle.getPropertyDegree(keys[0]);
//		    		if (evalTest == null) {
//		    			Evaluation[] evals = this.constraints.isSatisfiedCachedRight( memory.getContext(),
//		                        													  leftTuple, 
//		                        													  factory );
		    			
		    			Evaluation[] evals = this.constraints.isSatisfiedCachedLeft(memory.getContext(), factHandle, factory);
		    			
		    			//B-constraints are 0 to N
		    			//Each is evaluated and, if it is the first time, added to the object's handle
		    			if (evals != null) {
		    				for (Evaluation eval : evals) {
		    					for (Evaluation subEval : eval.getEvalTree()) {
		    						factHandle.addPropertyDegree(subEval);
		    					}
		    					record.addEvaluation(eval);
		    				}
//		    			}
//		    				    			    			
//		    		} else {
//		    			
////		    			if (evalTest.getDegreeBit(Evaluation.EVAL) == null) {
//		    			
//		    				//B-constraints are 0 to N
//		        			//As above, in case EVAL hasn't been called yet, but no need to add to the handle
//		    				Evaluation[] evals = this.constraints.isSatisfiedCachedRight( memory.getContext(),
//									  leftTuple, 
//									  factory );
//		
//		    				if (evals != null) {
//		    					for (Evaluation eval : evals) {
//		    						record.addEvaluation(eval);
//		    					}
//		    				}
//		    				
////		    			}			
		    		}   
    		} else {
    			//EMPTY BETA CONSTRAINT!
    		}
 
        	//KEY MOVE, AND-ING THE PATTERN EVALS
    		mainRecord.addEvaluation(record);
    		
    		ImperfectRightTuple propRightTuple = new ImperfectRightTuple(factHandle,this,record);
        	
        	
        	System.out.println("Situation at join eval"+mainRecord.expand());        		        		        		        	
	        		        	        		        		        		        	
        	
        	int verdict;
        	
        	if (this.isCutter && mainRecord.getDegree().equals(factory.False()))
        		verdict = IFilterStrategy.DROP;
        	else 
        		verdict = this.filterStrat.doTry(mainRecord); 
        	
        	
        	switch (verdict) {
        		case IFilterStrategy.DROP : 
        			System.out.println("Beta FAIL at assertTuple: DROP record");
        			continue;
			
        		case IFilterStrategy.HOLD : //TODO: HOLD
        			System.out.println("HOLD RULES @JOIN NODE"+this.getId());
        			System.out.println("Situation is "+mainRecord.expand());
        			
        				mainRecord.setLeftTuple(leftTuple);
        				mainRecord.setRightTuple(propRightTuple);
        				mainRecord.setFactory(factory);
        				mainRecord.setPropagationContext(context);
        				mainRecord.setWorkingMemory(workingMemory);
					mainRecord.addObserver(this);	
        			continue;
        			//break;
			
        		case IFilterStrategy.PASS : 
        			System.out.println("Beta PASS at assertTuple: propagate record");
        			this.sink.propagateAssertLeftTuple( leftTuple,
                            propRightTuple,
                            context,
                            workingMemory,
                            factory,
                            mainRecord,
                            this.tupleMemoryEnabled  );

        			//break;
        		default : continue;			
        	}
        	
        			
        
                                                          
        }

        this.constraints.resetTuple( memory.getContext() );
	}

    /**
     * Assert a new <code>FactHandleImpl</code>. The left input of
     * <code>ReteTuple</code>s is iterated and joins attemped, via the
     * binder, any successful bindings results in joined tuples being created
     * and propaged. there is a joined tuple per TupleSink.
     *
     * @see LeftTuple
     * @see ObjectMatches
     * @see LeftTupleSink
     * @see TupleMatch
     *
     * @param factHandle
     *            The <code>FactHandleImpl</code> being asserted.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void assertObject(final InternalFactHandle factHandle,
                             final PropagationContext context,
                             final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        RightTuple rightTuple = new RightTuple( factHandle,
                                                this );

        if ( !behavior.assertRightTuple( memory.getBehaviorContext(),
                                         rightTuple,
                                         workingMemory ) ) {
            // destroy right tuple
            rightTuple.unlinkFromRightParent();
            return;
        }

        memory.getRightTupleMemory().add( rightTuple );
        if ( !this.tupleMemoryEnabled ) {
            // do nothing here, as we know there are no left tuples at this stage in sequential mode.
            return;
        }

        this.constraints.updateFromFactHandle( memory.getContext(),
                                               workingMemory,
                                               factHandle );
        int i = 0;
        for ( LeftTuple leftTuple = memory.getLeftTupleMemory().getFirst( rightTuple ); leftTuple != null; leftTuple = (LeftTuple) leftTuple.getNext() ) {
            if ( this.constraints.isAllowedCachedRight( memory.getContext(),
                                                        leftTuple ) ) {
                // wm.marshaller.write( i, leftTuple )
                this.sink.propagateAssertLeftTuple( leftTuple,
                                                    rightTuple,
                                                    context,
                                                    workingMemory,
                                                    this.tupleMemoryEnabled  );
            }
            i++;
        }
        this.constraints.resetFactHandle( memory.getContext() );
    }

    
    
    
    public void assertObject(ImperfectFactHandle factHandle,
			PropagationContext context,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord initialRecord) {
    	
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        
        ImperfectRightTuple rightTuple = new ImperfectRightTuple( factHandle,
                                                this, initialRecord );

        if ( !behavior.assertRightTuple( memory.getBehaviorContext(),
                                         rightTuple,
                                         workingMemory ) ) {
            // destroy right tuple
            rightTuple.unlinkFromRightParent();
            return;
        }

        memory.getRightTupleMemory().add( rightTuple );
        if ( !this.tupleMemoryEnabled ) {
            // do nothing here, as we know there are no left tuples at this stage in sequential mode.
            return;
        }

        this.constraints.updateFromFactHandle( memory.getContext(),
                                               workingMemory,
                                               factHandle );
        int i = 0;
        for ( ImperfectLeftTuple leftTuple = (ImperfectLeftTuple) memory.getLeftTupleMemory().getFirst( rightTuple ); leftTuple != null; leftTuple = (ImperfectLeftTuple) leftTuple.getNext() ) {
        	
        	
        	
        	EvalRecord mainRecord = leftTuple.getRecord().clone();
        	EvalRecord record = initialRecord.clone();
        	
        	
        	
        	Collection<Evaluation> storedEvals = this.getGammaMemory().retrieve(new ArgList(leftTuple.toObjectArray(),factHandle.getObject()));
    		if (storedEvals != null) {
    			record.addEvaluations(storedEvals);
    			factHandle.addPropertyDegrees(storedEvals);
    		}
    		
    		
        	
        	
        	//Call internal evaluator, if not done before
    		ConstraintKey[] keys = this.constraints.getConstraintKeys();
    		Evaluation[] evals = null;
    		if (keys != null) {
//		    		Evaluation evalTest = factHandle.getPropertyDegree(keys[0]);
//		    		if (evalTest == null) {
		    			evals = this.constraints.isSatisfiedCachedRight( memory.getContext(),
		                        													  leftTuple, 
		                        													  factory );
		    			//B-constraints are 0 to N
		    			//Each is evaluated and, if it is the first time, added to the object's handle
		    			if (evals != null) {
		    				for (Evaluation eval : evals) {
		    					for (Evaluation subEval : eval.getEvalTree()) {
		    						factHandle.addPropertyDegree(subEval);
		    					}
		    					record.addEvaluation(eval);
		    				}
		    			}
		    				    			    			
////		    		} else {
//		    			
//		    			//if (evalTest.getDegreeBit(Evaluation.EVAL) == null) {
//		    			
//		    				//B-constraints are 0 to N
//		        			//As above, in case EVAL hasn't been called yet, but no need to add to the handle
//		    				Evaluation[] evals = this.constraints.isSatisfiedCachedRight( memory.getContext(),
//									  leftTuple, 
//									  factory );
//		
//		    				if (evals != null) {
//		    					for (Evaluation eval : evals) {
//		    						record.addEvaluation(eval);
//		    					}
//		    				}
//		    				
//		    			//} 
//		    			
//		    			
//		    		}   
    		} else {
    			//EMPTY BETA CONSTRAINT!
    		}
 
        	//KEY MOVE, AND-ING THE PATTERN EVALS
    		mainRecord.addEvaluation(record);
    		
    		ImperfectRightTuple propRightTuple = new ImperfectRightTuple(factHandle,this,record);
        	
        	
        	System.out.println("Situation at join eval"+mainRecord.expand());        		        		        		        	
        		
        	int verdict;
        	
        	if (this.isCutter && mainRecord.getDegree().equals(factory.False()))
        		verdict = IFilterStrategy.DROP;
        	else 
        		verdict = this.filterStrat.doTry(mainRecord); 
        	
        	
        	switch (verdict) {
        		case IFilterStrategy.DROP :
        			System.out.println("Beta DROP at assertobject");
        			return;
			
        		case IFilterStrategy.HOLD : //TODO: HOLD
        			System.out.println("HOLD RULES @JOIN NODE"+this.getId());
        			System.out.println("Situation is "+mainRecord.expand());
        			
        				mainRecord.setLeftTuple(leftTuple);
        				mainRecord.setRightTuple(propRightTuple);
        				mainRecord.setFactory(factory);
        				mainRecord.setPropagationContext(context);
        				mainRecord.setWorkingMemory(workingMemory);
        			mainRecord.addObserver(this);	
        			
        			break;
			
        		case IFilterStrategy.PASS : 
        			System.out.println("Beta PASS at assertObjecf: propagate record");
        			this.sink.propagateAssertLeftTuple( leftTuple,
                            propRightTuple,
                            context,
                            workingMemory,
                            factory,
                            mainRecord,
                            this.tupleMemoryEnabled  );

        			break;
        		default : return;			
        	}
        	
        			
            i++;
        }
        this.constraints.resetFactHandle( memory.getContext() );
		
	}
    
    
    
    
    
    
    
    
	public void update(Observable watcher, Object info) {
		
		EvalRecord record = null;
		if (info instanceof EvalRecord)
			record = (EvalRecord) info;
		
		if (record == null) 
			return;
		
		System.out.println("**************************************************************UPDATE @JOIN NODE");
		
		int verdict;
    	
    	if (this.isCutter && record.getDegree().equals(record.getFactory().False()))
    		verdict = IFilterStrategy.DROP;
    	else 
    		verdict = this.filterStrat.doTry(record); 
    	
    	
    	switch (verdict) {
		case IFilterStrategy.DROP : 
			record.deleteObserver(this);
			return;
		
		case IFilterStrategy.HOLD : 
			//do nothing
			return;
		
		case IFilterStrategy.PASS :
			//go on
			record.deleteObserver(this);
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
						record.getPropagationContext(),
						record.getWorkingMemory(),
						record.getFactory(),
						record,
						this.tupleMemoryEnabled  );
			//break;
		default : return;	
		
		}
		
		
		// propagate
	}
    
    
	protected GammaMemory getGammaMemory() {
		return this.gammaMemory;
	}

    
    
    /**
     * Retract a FactHandleImpl. Iterates the referenced TupleMatches stored in
     * the handle's ObjectMatches retracting joined tuples.
     *
     * @param handle
     *            the <codeFactHandleImpl</code> being retracted
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void retractRightTuple(final RightTuple rightTuple,
                                  final PropagationContext context,
                                  final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        behavior.retractRightTuple( memory.getBehaviorContext(),
                                    rightTuple,
                                    workingMemory );
        RightTupleMemory rtMem = memory.getRightTupleMemory();
        	if (! rtMem.contains(rightTuple))
        		return;
        		
        rtMem.remove( rightTuple );

        if (rightTuple instanceof ImperfectRightTuple) {
        	((ImperfectRightTuple) rightTuple).getRecord().deleteObserver(this);
        }
        if ( rightTuple.getBetaChildren() != null ) {
            this.sink.propagateRetractRightTuple( rightTuple,
                                                  context,
                                                  workingMemory );
        }
    }

    /**
     * Retract a <code>ReteTuple</code>. Iterates the referenced
     * <code>TupleMatche</code>'s stored in the tuples <code>Map</code>
     * retracting all joined tuples.
     *
     * @param key
     *            The tuple key.
     * @param context
     *            The <code>PropagationContext</code>
     * @param workingMemory
     *            The working memory seesion.
     */
    public void retractLeftTuple(final LeftTuple leftTuple,
                                 final PropagationContext context,
                                 final InternalWorkingMemory workingMemory) {
        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );
        memory.getLeftTupleMemory().remove( leftTuple );
        
        if (leftTuple instanceof ImperfectLeftTuple) {
        	((ImperfectLeftTuple) leftTuple).getRecord().deleteObserver(this);
        }
        
        if ( leftTuple.getBetaChildren() != null ) {
            this.sink.propagateRetractLeftTuple( leftTuple,
                                                 context,
                                                 workingMemory );
        }
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNode#updateNewNode(org.drools.reteoo.WorkingMemoryImpl, org.drools.spi.PropagationContext)
     */
    public void updateSink(final LeftTupleSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {

        final BetaMemory memory = (BetaMemory) workingMemory.getNodeMemory( this );

        final Iterator tupleIter = memory.getLeftTupleMemory().iterator();
        for ( LeftTuple leftTuple = (LeftTuple) tupleIter.next(); leftTuple != null; leftTuple = (LeftTuple) tupleIter.next() ) {
            this.constraints.updateFromTuple( memory.getContext(),
                                              workingMemory,
                                              leftTuple );
            for ( RightTuple rightTuple = memory.getRightTupleMemory().getFirst( leftTuple ); rightTuple != null; rightTuple = (RightTuple) rightTuple.getNext() ) {
                if ( this.constraints.isAllowedCachedLeft( memory.getContext(),
                                                           rightTuple.getFactHandle() ) ) {
                    sink.assertLeftTuple( new LeftTuple( leftTuple,
                                                         rightTuple,
                                                         sink,
                                                         this.tupleMemoryEnabled  ),
                                          context,
                                          workingMemory );
                }
            }

            this.constraints.resetTuple( memory.getContext() );
        }
    }
    
    public short getType() {
        return NodeTypeEnums.JoinNode;
    }

    public String toString() {
        ObjectSource source = this.rightInput;
        while ( !(source instanceof ObjectTypeNode) ) {
            source = source.source;
        }

        return "[JoinNode(" + this.getId() + ") - " + ((ObjectTypeNode) source).getObjectType() + "]";
    }

    
    
    
    public EvaluationTemplate getEvaluationTemplate(ConstraintKey key) {
		return this.constraints.getEvalTemplate(key);
	}


	public Collection<Evaluation> getStoredEvals(ArgList args) {
		return getGammaMemory().retrieve(args);
	}

	public void storeEvaluation(ArgList args, Evaluation prepareEval) {
		getGammaMemory().store(args, prepareEval);
	}

	

	public ConstraintKey[] getConstraintKeys() {
		return this.constraints.getConstraintKeys();
		
	}

	
}
