package org.drools.common;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.drools.RuleBaseConfiguration;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.BetaMemory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.SingleEvaluationTemplate;
import org.drools.reteoo.builder.BuildContext;
import org.drools.rule.ContextEntry;
import org.drools.util.LeftTupleList;
import org.drools.util.LinkedList;
import org.drools.util.RightTupleList;

public class ImplicationBetaConstraint implements BetaConstraints {

	
    /**
     *
     */
    private static final long serialVersionUID = 400L;
    
    
    private IDegree priorDegree;

    public ImplicationBetaConstraint(IDegreeFactory factory,
    								 IDegree priorDegree, 
    								 BuildContext context) {
    	
    	this.priorDegree = priorDegree;
//    	singletonKeys = new ConstraintKey[] {new ConstraintKey(
//    											factory.getModusPonensOp().getName(),
//    											context.getRule().getName())};
    	
    	singletonKeys = new ConstraintKey[] {new ConstraintKey(context.getRule().getName())};
//				factory.getModusPonensOp().getName(),
//				context.getRule().getName())};
    	
    }

    
    
    
    
    
    
    
    
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    	//TODO: Implement...
    }

    public void writeExternal(ObjectOutput out) throws IOException {
    	//TODO: Implement...
    	
    }
    
    
    /* (non-Javadoc)
     * @see org.drools.common.BetaNodeConstraints#updateFromTuple(org.drools.reteoo.ReteTuple)
     */
    public void updateFromTuple(final ContextEntry[] context,
                                final InternalWorkingMemory workingMemory,
                                final LeftTuple tuple) {
    }

    /* (non-Javadoc)
     * @see org.drools.common.BetaNodeConstraints#updateFromFactHandle(org.drools.common.InternalFactHandle)
     */
    public void updateFromFactHandle(final ContextEntry[] context,
                                     final InternalWorkingMemory workingMemory,
                                     final InternalFactHandle handle) {
    }

    
    public void resetTuple(final ContextEntry[] context) {
    	
    }

    public void resetFactHandle(final ContextEntry[] context) {
    	
    }

    
    
    /* (non-Javadoc)
     * @see org.drools.common.BetaNodeConstraints#isAllowedCachedLeft(java.lang.Object)
     */
    public boolean isAllowedCachedLeft(final ContextEntry[] context,
                                       final InternalFactHandle handle) {
        return priorDegree.toBoolean();
    }

    
    
    /* (non-Javadoc)
     * @see org.drools.common.BetaNodeConstraints#isAllowedCachedRight(org.drools.reteoo.ReteTuple)
     */
    public boolean isAllowedCachedRight(final ContextEntry[] context,
                                        final LeftTuple tuple) {
        return priorDegree.toBoolean();
    }

    public boolean isIndexed() {
        return false;
    }

    public int getIndexCount() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public BetaMemory createBetaMemory(final RuleBaseConfiguration config) {
        final BetaMemory memory = new BetaMemory( config.isSequential() ? null : new LeftTupleList(),
                                                  new RightTupleList(),
                                                  this.createContext() );

        return memory;
    }

    public int hashCode() {
        return singletonKeys[0].hashCode() ^ priorDegree.hashCode();
    }

    /* (non-Javadoc)
     * @see org.drools.common.BetaNodeConstraints#getConstraints()
     */
    public LinkedList getConstraints() {
        final LinkedList list = new LinkedList();
        return list;
    }

    
    
    /**
     * Determine if another object is equal to this.
     *
     * @param object
     *            The object to test.
     *
     * @return <code>true</code> if <code>object</code> is equal to this,
     *         otherwise <code>false</code>.
     */
    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }

        if (object == null) 
        	return false;
        if (! (object instanceof ImplicationBetaConstraint))
        	return false;
        
        ImplicationBetaConstraint otherIBC = (ImplicationBetaConstraint) object;
        return this.singletonKeys[0].equals(otherIBC.singletonKeys[0])
        		&& this.priorDegree.equals(otherIBC.priorDegree);
    }

    
    
    
    public ContextEntry[] createContext() {
        return new ContextEntry[0];
    }

    
    
    
    
    
    
    
    
    
	public Evaluation[] isSatisfiedCachedLeft(ContextEntry[] context,
			InternalFactHandle handle, IDegreeFactory factory) {
		Evaluation eval = template[0].spawn(factory.Unknown());
			eval.addDegree(Evaluation.PRIOR, this.priorDegree, 1,true);
		return new Evaluation[] {eval};
	}

	public Evaluation[] isSatisfiedCachedRight(ContextEntry[] context,
			LeftTuple tuple, IDegreeFactory factory) { 
		Evaluation eval = template[0].spawn(factory.Unknown());
			eval.addDegree(Evaluation.PRIOR, this.priorDegree, 1,true);
		return new Evaluation[] {eval};
	}
	
	
	
	
	
	
	private EvaluationTemplate[] template ;
	
	private ConstraintKey[] singletonKeys = null;
    
	public ConstraintKey[] getConstraintKeys() {		 
		return singletonKeys;
	}

	public EvaluationTemplate[] buildEvaluationTemplates(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
		template = new EvaluationTemplate[1];
			template[0] = new SingleEvaluationTemplate(id,singletonKeys[0],dependencies.get(singletonKeys[0]),factory.getMergeStrategy(),factory.getNullHandlingStrategy());			
		return template;
	}

	
	public Collection<ConstraintKey> getAllConstraintKeys() {
		Vector<ConstraintKey> ans = new Vector<ConstraintKey>(1);
			ans.add(singletonKeys[0]);
		return ans;		  		
	}

	public EvaluationTemplate getEvalTemplate(ConstraintKey key) {
		if (template[0].getConstraintKey().equals(key))
			return template[0];
		return null;
	}



	public void setPriorDegree(IDegree buildDegree) {
		priorDegree = buildDegree;		
	}







	
}