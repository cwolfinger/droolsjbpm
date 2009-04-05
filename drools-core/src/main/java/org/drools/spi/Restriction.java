package org.drools.spi;

import java.io.Externalizable;
import java.util.Collection;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.LeftTuple;
import org.drools.rule.ContextEntry;
import org.drools.rule.Declaration;

public interface Restriction
    extends
    Externalizable,
    Cloneable {
    Declaration[] getRequiredDeclarations();

    public boolean isAllowed(InternalReadAccessor extractor,
                             InternalFactHandle handle,
                             InternalWorkingMemory workingMemory,
                             ContextEntry context );

    public boolean isAllowedCachedLeft(ContextEntry context,
                                       InternalFactHandle handle);

    public boolean isAllowedCachedRight(LeftTuple tuple,
                                        ContextEntry context);
    
    
    public IDegree isSatisfied(InternalReadAccessor extractor,
            InternalFactHandle handle,
            InternalWorkingMemory workingMemory,
            ContextEntry context,
            IDegreeFactory factory);

    public IDegree isSatisfiedCachedLeft(ContextEntry context,
                      InternalFactHandle handle,
                      IDegreeFactory factory);

    public IDegree isSatisfiedCachedRight(LeftTuple tuple,
                       ContextEntry context,
                       IDegreeFactory factory);

    public ContextEntry createContextEntry();

    /**
     * A restriction may be required to replace an old
     * declaration object by a new updated one
     *
     * @param oldDecl
     * @param newDecl
     */
    void replaceDeclaration(Declaration oldDecl,
                            Declaration newDecl);

    /**
     * Returns true if this is a temporal restriction
     * 
     * @return
     */
    public boolean isTemporal();

    public Object clone();

    
    public ConstraintKey getConstraintKey();
    
    public Collection<ConstraintKey> getAllConstraintKeys();

}
