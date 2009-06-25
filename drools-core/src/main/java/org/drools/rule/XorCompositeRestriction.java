package org.drools.rule;

import java.util.Collection;
import java.util.LinkedList;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.LeftTuple;
import org.drools.rule.AbstractCompositeRestriction.CompositeContextEntry;
import org.drools.spi.InternalReadAccessor;
import org.drools.spi.Restriction;

public class XorCompositeRestriction extends AbstractCompositeRestriction {

    private static final long serialVersionUID = 400L;

    public XorCompositeRestriction() {
    }

    public XorCompositeRestriction(final Restriction[] restriction) {
        super( restriction );
    }

    public boolean isAllowed(final InternalReadAccessor extractor,
                             final InternalFactHandle handle,
                             final InternalWorkingMemory workingMemory,
                             final ContextEntry context ) {
        boolean op1 = this.restrictions[0].isAllowed(extractor, handle, workingMemory, context);
        boolean op2 = this.restrictions[1].isAllowed(extractor, handle, workingMemory, context);
        
    	return op1 ^ op2;
    }
    
    public IDegree isSatisfied(InternalReadAccessor extractor,
			InternalFactHandle handle, InternalWorkingMemory workingMemory,
			ContextEntry context, IDegreeFactory factory) {
    	
    	int N = this.restrictions.length;
    	IDegree[] degs = new IDegree[N];
    	    	
    	for ( int i = 0; i < N; i++ ) 
            degs[i] = this.restrictions[i].isSatisfied( extractor,
                                                  handle,
                                                  workingMemory,
                                                  context, factory );
    	return factory.getXorOperator().eval(degs,factory);
        
	}

    public boolean isAllowedCachedLeft(final ContextEntry context,
                                       final InternalFactHandle handle) {
        CompositeContextEntry contextEntry = (CompositeContextEntry) context;
        boolean op1 = this.restrictions[0].isAllowedCachedLeft(contextEntry.contextEntries[0], handle);
        boolean op2 = this.restrictions[1].isAllowedCachedLeft(contextEntry.contextEntries[1], handle);
        return op1 ^ op2;
    }
    
    public IDegree isSatisfiedCachedLeft(ContextEntry context,
			InternalFactHandle handle, IDegreeFactory factory) {
    	
    	int N = this.restrictions.length;
    	IDegree[] degs = new IDegree[N];
    	CompositeContextEntry contextEntry = (CompositeContextEntry) context;
        for ( int i = 0; i < N; i++ ) 
        	degs[i] = this.restrictions[i].isSatisfiedCachedLeft( contextEntry.contextEntries[i],
                                                            handle, factory );
            
        
        return factory.getXorOperator().eval(degs,factory);
	}

    public boolean isAllowedCachedRight(final LeftTuple tuple,
                                        final ContextEntry context) {
        CompositeContextEntry contextEntry = (CompositeContextEntry) context;
        boolean op1 =  this.restrictions[0].isAllowedCachedRight( tuple,
                contextEntry.contextEntries[0]);
        
        boolean op2 =  this.restrictions[1].isAllowedCachedRight( tuple,
                contextEntry.contextEntries[1]);
        
        return op1 ^ op2;
    }
    
    public IDegree isSatisfiedCachedRight(LeftTuple tuple,
			ContextEntry context, IDegreeFactory factory) {
		
    	int N = this.restrictions.length;
    	IDegree[] degs = new IDegree[N];
    	CompositeContextEntry contextEntry = (CompositeContextEntry) context;
        for ( int i = 0; i < N; i++ ) 
        	degs[i] = this.restrictions[i].isSatisfiedCachedRight( tuple, 
        													contextEntry.contextEntries[i],
        													factory );
                   
        return factory.getXorOperator().eval(degs,factory);
	}

    public Object clone() {
        Restriction[] clone = new Restriction[ this.restrictions.length ];
        for( int i = 0; i < clone.length; i++ ) {
            clone[i] = (Restriction) this.restrictions[i].clone();
        }
        return new XorCompositeRestriction( clone );
    }
    
    
    
    
    private ConstraintKey singletonKey = null;
    
	public ConstraintKey getConstraintKey() {
		if (singletonKey == null) {
			int N = this.restrictions.length;			
			ConstraintKey[] cks = new ConstraintKey[N];
			for (int j = 0; j < N; j++)
				cks[j] = this.restrictions[j].getConstraintKey();			
			singletonKey = new ConstraintKey("xor",cks);
		}
		return singletonKey;
	}
	
	public Collection<ConstraintKey> getAllConstraintKeys() {
		Collection<ConstraintKey> ans = new LinkedList<ConstraintKey>();
		
		int N = this.restrictions.length;			
			
		for (int j = 0; j < N; j++)
			ans.add(this.restrictions[j].getConstraintKey());
			
					
		ans.add(this.getConstraintKey());
		return ans;
	}
    
    
}
