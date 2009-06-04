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
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.drools.FactException;
import org.drools.RuleBaseConfiguration;
import org.drools.common.BaseNode;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalRuleBase;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.NodeMemory;
import org.drools.common.PropagationContextImpl;
import org.drools.common.RuleBasePartitionId;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.reteoo.filters.IFilteringNode;
import org.drools.rule.ContextEntry;
import org.drools.spi.AlphaNodeFieldConstraint;
import org.drools.spi.PropagationContext;

/**
 * <code>AlphaNodes</code> are nodes in the <code>Rete</code> network used
 * to apply <code>FieldConstraint<.code>s on asserted fact
 * objects where the <code>FieldConstraint</code>s have no dependencies on any other of the facts in the current <code>Rule</code>.
 *
 *  @see AlphaNodeFieldConstraint
 *
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public class AlphaNode extends ObjectSource
    implements
    ObjectSinkNode,
    NodeMemory,
    IFilteringNode, 
    Observer,
    IGammaNode {


	
    /**
     *
     */
    private static final long        serialVersionUID = 500L;

    
    private IFilterStrategy filterStrat; 
    
    /** The <code>FieldConstraint</code> */
    private AlphaNodeFieldConstraint constraint;

    private ObjectSinkNode      previousRightTupleSinkNode;
    private ObjectSinkNode      nextRightTupleSinkNode;
    
    
    private GammaMemory 		gammaMemory;

    public AlphaNode() {

    }

    /**
     * Construct an <code>AlphaNode</code> with a unique id using the provided
     * <code>FieldConstraint</code> and the given <code>ObjectSource</code>.
     * Set the boolean flag to true if the node is supposed to have local
     * memory, or false otherwise. Memory is optional for <code>AlphaNode</code>s
     * and is only of benefic when adding additional <code>Rule</code>s at runtime.
     *
     * @param id Node's ID
     * @param constraint Node's constraints
     * @param objectSource Node's object source
     */
    public AlphaNode(final int id,
                     final AlphaNodeFieldConstraint constraint,
                     final ObjectSource objectSource,
                     final BuildContext context) {
        super( id,
               context.getPartitionId(),
               context.getRuleBase().getConfiguration().isMultithreadEvaluation(),
               objectSource,
               context.getRuleBase().getConfiguration().getAlphaNodeHashingThreshold() );
        this.constraint = constraint;
       
        
        this.gammaMemory = new GammaMemory();
        InternalRuleBase ruleBase = context.getRuleBase();
        if (ruleBase instanceof ImperfectRuleBase) {
        	IDegreeFactory factory = ((ImperfectRuleBase) ruleBase).getDegreeFactory();
        	this.filterStrat = factory.getDefaultStrategy();                	
        
        	
        	
        	this.constraint.buildEvaluationTemplate(this.id,context.getRule().getDependencies(), factory);
        	
        	Collection<ConstraintKey> keys = this.constraint.getAllConstraintKeys();
        	for (ConstraintKey key : keys)
        		context.getRuleBase().getRete().indexGammaNode(key,this);
        	
        	
		        
		        
        }        
        //TODO:
        //System.out.println(this.getClass().getName() + "(id "+id+") constructor hacked to add filter strategy");
        
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        super.readExternal( in );
        constraint = (AlphaNodeFieldConstraint) in.readObject();
        previousRightTupleSinkNode = (ObjectSinkNode) in.readObject();
        nextRightTupleSinkNode = (ObjectSinkNode) in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal( out );
        out.writeObject( constraint );
        out.writeObject( previousRightTupleSinkNode );
        out.writeObject( nextRightTupleSinkNode );
    }

    /**
     * Retruns the <code>FieldConstraint</code>
     *
     * @return <code>FieldConstraint</code>
     */
    public AlphaNodeFieldConstraint getConstraint() {
        return this.constraint;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.drools.reteoo.BaseNode#attach()
     */
    public void attach() {
        this.source.addObjectSink( this );
    }

    public void attach(final InternalWorkingMemory[] workingMemories) {
        attach();

        for ( int i = 0, length = workingMemories.length; i < length; i++ ) {
            final InternalWorkingMemory workingMemory = workingMemories[i];
            final PropagationContext propagationContext = new PropagationContextImpl( workingMemory.getNextPropagationIdCounter(),
                                                                                      PropagationContext.RULE_ADDITION, 
                                                                                      
                                                                                      null,
                                                                                      null,
                                                                                      null );
            this.source.updateSink( this,
                                    propagationContext,
                                    workingMemory );
        }
    }

    public void assertObject(final InternalFactHandle factHandle,
                             final PropagationContext context,
                             final InternalWorkingMemory workingMemory) throws FactException {
        final AlphaMemory memory = (AlphaMemory) workingMemory.getNodeMemory( this );
        if ( this.constraint.isAllowed( factHandle,
                                        workingMemory,
                                        memory.context ) ) {

            this.sink.propagateAssertObject( factHandle,
                                             context,
                                             workingMemory );
        }
    }
    
    
	public void assertObject(ImperfectFactHandle factHandle,
			PropagationContext propagationContext,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord record) {
		
		final AlphaMemory memory = (AlphaMemory) workingMemory.getNodeMemory( this );
		
		System.out.println("--------------     Passing by alpha" + id);

		//Collect any provided info
		Collection<Evaluation> storedEvals = this.gammaMemory.retrieve(new ArgList(factHandle.getObject()));
		if (storedEvals != null) {
			record.addEvaluations(storedEvals);
			factHandle.addPropertyDegrees(storedEvals);
		}
			
		boolean doCut = false;
		//Call internal evaluator, if not done before
		ConstraintKey key = this.constraint.getConstraintKey();
		Evaluation eval = factHandle.getPropertyDegree(key);
		if (eval == null) {
			eval = this.constraint.isSatisfied(factHandle,
					workingMemory,
					memory.context,
					factory
                	);	
			 if (eval.getDegree().equals(factory.False()) && constraint.isCutter())
				 doCut = true;
			
			for (Evaluation subEval : eval.getEvalTree()) {
				factHandle.addPropertyDegree(subEval);
			}
			record.addEvaluation(eval);	
			
			
		} else {
			if (eval.getDegreeBit(Evaluation.EVAL) == null) {
				Evaluation localEval = this.constraint.isSatisfied(factHandle,
						workingMemory,
						memory.context,
						factory
	                	);		
				
				if (localEval.getDegree().equals(factory.False()) && constraint.isCutter())
					 doCut = true;
				
				record.addEvaluation(localEval);
			}			
		}   
		 
		System.out.println("Alpha evaluation trial "+record.expand());
		
		IFilterStrategy.filterOptions verdict;
    	
    	//if (this.constraint.isCutter() && record.getDegree().equals(factory.False()))
		if (doCut)
    		verdict = IFilterStrategy.filterOptions.DROP;
    	else 
    		verdict = this.filterStrat.doTry(record); 
    	
    	
    	switch (verdict) {
			case DROP : 
				//time to die
				System.out.println("Alpha FAIL : DROP record");
				return;
			
			case HOLD : 
				System.out.println("WARNING::::::::::::::::::::::::::: OBJECT HELD AT ALPHA NODE "+this.constraint.getConstraintKey());
				System.out.println("Situation is "+record.expand());
					record.setFactHandle(factHandle);
					record.setFactory(factory);
					record.setPropagationContext(propagationContext);
					record.setWorkingMemory(workingMemory);
				record.addObserver(this);				
				//wait for more1
				return;
			
			case PASS :
				//go on
				System.out.println("Alpha PASS ");
				this.sink.propagateAssertObject(factHandle,
		            propagationContext,
		            workingMemory,
		            factory,
		            record);
				break;
			default : return;			
		}
		
	}  
 	
	
	public void update(Observable watcher, Object info) {
		EvalRecord record = (EvalRecord) watcher;
System.out.println("**************************************************************UPDATE @ALPHA NODE");
		
		IFilterStrategy.filterOptions verdict;

		if (this.constraint.isCutter() && record.getDegree().equals(record.getFactory().False()))
			verdict = IFilterStrategy.filterOptions.DROP;
		else 
			verdict = this.filterStrat.doTry(record); 


		switch (verdict) {
		case DROP : 
			record.deleteObserver(this);
			return;
		
		case HOLD : 
			//do nothing
			return;
		
		case PASS :
			//go on
			record.deleteObserver(this);
			//throw new RuntimeException("Awakened objeect");
			//TODO
			this.sink.propagateAssertObject(record.getFactHandle(),
	            record.getPropagationContext(),
	            record.getWorkingMemory(),
	            record.getFactory(),
	            record);
			//break;
		default : return;	
		
		}
		
		
		// propagate
	}


    public void updateSink(final ObjectSink sink,
                           final PropagationContext context,
                           final InternalWorkingMemory workingMemory) {
        final AlphaMemory memory = (AlphaMemory) workingMemory.getNodeMemory( this );
        
        // get the objects from the parent
        ObjectSinkUpdateAdapter adapter = new ObjectSinkUpdateAdapter( sink,
                                                                       this.constraint,
                                                                       memory.context );
        this.source.updateSink( adapter,
                                context,
                                workingMemory );
    }

    protected void doRemove(final RuleRemovalContext context,
                            final ReteooBuilder builder,
                            final BaseNode node,
                            final InternalWorkingMemory[] workingMemories) {
        if ( !node.isInUse() ) {
            removeObjectSink( (ObjectSink) node );
        }
        if ( !this.isInUse() ) {
            for ( int i = 0, length = workingMemories.length; i < length; i++ ) {
                workingMemories[i].clearNodeMemory( this );
            }
        }
        this.source.remove( context,
                            builder,
                            this,
                            workingMemories );
    }

    /**
     * Creates a HashSet for the AlphaNode's memory.
     */
    public Object createMemory(final RuleBaseConfiguration config) {
        AlphaMemory memory = new AlphaMemory();
        memory.context = this.constraint.createContextEntry();
        return memory;
    }

    /**
     * @inheritDoc
     */
    protected void addObjectSink(final ObjectSink objectSink) {
        super.addObjectSink( objectSink );
    }

    public String toString() {
        return "[AlphaNode(" + this.id + ") constraint=" + this.constraint + "]";
    }

    public int hashCode() {
        return this.source.hashCode() * 17 + ((this.constraint != null) ? this.constraint.hashCode() : 0);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }

        if ( object == null || !(object instanceof AlphaNode) ) {
            return false;
        }

        final AlphaNode other = (AlphaNode) object;

        return this.source.equals( other.source ) && this.constraint.equals( other.constraint );
    }

    /**
     * Returns the next node
     * @return
     *      The next ObjectSinkNode
     */
    public ObjectSinkNode getNextObjectSinkNode() {
        return this.nextRightTupleSinkNode;
    }

    /**
     * Sets the next node
     * @param next
     *      The next ObjectSinkNode
     */
    public void setNextObjectSinkNode(final ObjectSinkNode next) {
        this.nextRightTupleSinkNode = next;
    }

    /**
     * Returns the previous node
     * @return
     *      The previous ObjectSinkNode
     */
    public ObjectSinkNode getPreviousObjectSinkNode() {
        return this.previousRightTupleSinkNode;
    }

    /**
     * Sets the previous node
     * @param previous
     *      The previous ObjectSinkNode
     */
    public void setPreviousObjectSinkNode(final ObjectSinkNode previous) {
        this.previousRightTupleSinkNode = previous;
    }
    
    
    
    
    public void setStrategy(IFilterStrategy newStrat) {
		this.filterStrat = newStrat;
	}
    
    protected IFilterStrategy getStrategy() {
		return this.filterStrat;
	    
    }
    
    
    
    protected Evaluation fromTemplate() {
    	return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    

    public static class AlphaMemory
        implements
        Externalizable {
        private static final long serialVersionUID = -5852576405010023458L;

        public ContextEntry       context;

        public void readExternal(ObjectInput in) throws IOException,
                                                ClassNotFoundException {
            context = (ContextEntry) in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject( context );
        }
    }

    /**
     * Used with the updateSink method, so that the parent ObjectSource
     * can  update the  TupleSink
     * @author mproctor
     *
     */
    private static class ObjectSinkUpdateAdapter
        implements
        ObjectSink {
        private final ObjectSink               sink;
        private final AlphaNodeFieldConstraint constraint;
        private final ContextEntry contextEntry;

        public ObjectSinkUpdateAdapter(final ObjectSink sink,
                                       final AlphaNodeFieldConstraint constraint, 
                                       final ContextEntry contextEntry) {
            this.sink = sink;
            this.constraint = constraint;
            this.contextEntry = contextEntry;
        }

        public void assertObject(final InternalFactHandle handle,
                               final PropagationContext propagationContext,
                               final InternalWorkingMemory workingMemory ) {

            if ( this.constraint.isAllowed( handle,
                                            workingMemory,
                                            this.contextEntry ) ) {
                this.sink.assertObject( handle,
                                        propagationContext,
                                        workingMemory );
            }
        }

        public int getId() {
            return 0;
        }

        public RuleBasePartitionId getPartitionId() {
            return this.sink.getPartitionId();
        }

        public void writeExternal( ObjectOutput out ) throws IOException {
            // this is a short living adapter class, so no need for serialization
        }

        public void readExternal( ObjectInput in ) throws IOException, ClassNotFoundException {
            // this is a short living adapter class, so no need for serialization
        }

		public void assertObject(ImperfectFactHandle factHandle,
				PropagationContext propagationContext,
				InternalWorkingMemory workingMemory, IDegreeFactory factory,
				EvalRecord record) {
			
			
			Evaluation eval = this.constraint.isSatisfied( factHandle,
                    workingMemory,
                    this.contextEntry,
                    factory);
			
			
			record.addEvaluation(eval);
		
			
			
			
			this.sink.assertObject(factHandle,
                propagationContext,
                workingMemory,
                factory,
                record);
			
			
		}


    }

    
	public EvaluationTemplate getEvaluationTemplate(ConstraintKey key) {
		return this.constraint.getEvalTemplate(key);
	}
	
	
	
	
	
	

	public Collection<Evaluation> getStoredEvals(ArgList args) {
		return this.gammaMemory.retrieve(args);
	}

	public void storeEvaluation(ArgList args, Evaluation prepareEval) {
		this.gammaMemory.store(args, prepareEval);
	}

	
	public ConstraintKey getConstraintKey() {
		return this.getConstraint().getConstraintKey();
	}

	

	
}
