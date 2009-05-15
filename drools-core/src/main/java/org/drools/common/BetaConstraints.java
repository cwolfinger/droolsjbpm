package org.drools.common;

import java.io.Externalizable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.drools.RuleBaseConfiguration;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.BetaMemory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.SingleEvaluationTemplate;
import org.drools.rule.ContextEntry;
import org.drools.util.LinkedList;

public interface BetaConstraints
    extends
    Externalizable {

    public ContextEntry[] createContext();

    public void updateFromTuple(ContextEntry[] context,
                                InternalWorkingMemory workingMemory,
                                LeftTuple tuple);

    public void updateFromFactHandle(ContextEntry[] context,
                                     InternalWorkingMemory workingMemory,
                                     InternalFactHandle handle);

    public boolean isAllowedCachedLeft(ContextEntry[] context,
                                       InternalFactHandle handle);

    public boolean isAllowedCachedRight(ContextEntry[] context,
                                        LeftTuple tuple);
    
    public Evaluation[] isSatisfiedCachedLeft(ContextEntry[] context,
            InternalFactHandle handle, IDegreeFactory factory);

    public Evaluation[] isSatisfiedCachedRight(ContextEntry[] context,
             LeftTuple tuple, IDegreeFactory factory);

    public LinkedList getConstraints();

    public boolean isIndexed();

    public int getIndexCount();

    public boolean isEmpty();

    public BetaMemory createBetaMemory(final RuleBaseConfiguration config);

    public void resetTuple(final ContextEntry[] context);

    public void resetFactHandle(final ContextEntry[] context);
    
    public ConstraintKey[] getConstraintKeys();
    
    public EvaluationTemplate[] buildEvaluationTemplates(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory);

	public Collection<ConstraintKey> getAllConstraintKeys();

	public EvaluationTemplate getEvalTemplate(ConstraintKey key);
	
	public boolean isCutter();

}