package org.drools.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.CompositeEvaluationTemplate;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.SingleEvaluationTemplate;
import org.drools.spi.AcceptsReadAccessor;
import org.drools.spi.InternalReadAccessor;
import org.drools.spi.ReadAccessor;
import org.drools.spi.Restriction;

public class MultiRestrictionFieldConstraint extends MutableTypeConstraint
    implements
    AcceptsReadAccessor {

    private static final long    serialVersionUID = 400L;

    private InternalReadAccessor readAccessor;

    private Restriction          restrictions;

    public MultiRestrictionFieldConstraint() {

    }

    public MultiRestrictionFieldConstraint(final InternalReadAccessor extractor,
                                           final Restriction restrictions) {
        this.readAccessor = extractor;
        this.restrictions = restrictions;
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        super.readExternal( in );
        readAccessor = (InternalReadAccessor) in.readObject();
        restrictions = (Restriction) in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal( out );
        out.writeObject( readAccessor );
        out.writeObject( restrictions );
    }
    
    public void setReadAccessor(InternalReadAccessor readAccessor) {
        this.readAccessor = readAccessor;
    }        

    public ReadAccessor getFieldExtractor() {
        return this.readAccessor;
    }

    public Declaration[] getRequiredDeclarations() {
        return this.restrictions.getRequiredDeclarations();
    }

    public void replaceDeclaration(Declaration oldDecl,
                                   Declaration newDecl) {
        this.restrictions.replaceDeclaration( oldDecl,
                                              newDecl );
    }
    
    public boolean isTemporal() {
        return restrictions.isTemporal();
    }

    public String toString() {
        return "[MultiRestrictionConstraint fieldExtractor=" + this.readAccessor + " restrictions =" + this.restrictions + "]";
    }

    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * this.readAccessor.hashCode();
        result = PRIME * this.restrictions.hashCode();
        return result;
    }

    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }
        if ( object == null || object.getClass() != MultiRestrictionFieldConstraint.class ) {
            return false;
        }
        final MultiRestrictionFieldConstraint other = (MultiRestrictionFieldConstraint) object;

        return this.readAccessor.equals( other.readAccessor ) && this.restrictions.equals( other.restrictions );
    }

    public boolean isAllowed(final InternalFactHandle handle,
                             final InternalWorkingMemory workingMemory,
                             final ContextEntry context) {
        return this.restrictions.isAllowed( this.readAccessor,
                                            handle,
                                            workingMemory,
                                            context );
    }
    
    public Evaluation isSatisfied(InternalFactHandle handle,
			InternalWorkingMemory workingMemory, ContextEntry context,
			IDegreeFactory factory) {
		IDegree deg = this.restrictions.isSatisfied(this.readAccessor,
											 handle, 
											 workingMemory, 
											 context, 
											 factory);			
		return getTemplate().spawn(deg);
	}

    public ContextEntry createContextEntry() {
        return this.restrictions.createContextEntry();
    }

    public boolean isAllowedCachedLeft(final ContextEntry context,
                                       final InternalFactHandle handle) {
        return this.restrictions.isAllowedCachedLeft( context,
                                                      handle );
    }

    public IDegree isSatisfiedCachedLeft(ContextEntry context,
			InternalFactHandle handle, IDegreeFactory factory) {
    	return this.restrictions.isSatisfiedCachedLeft( context,
                handle, factory );
	}
    
    public boolean isAllowedCachedRight(final LeftTuple tuple,
                                        final ContextEntry context) {
        return this.restrictions.isAllowedCachedRight( tuple,
                                                       context );
    }
    
    public IDegree isSatisfiedCachedRight(LeftTuple tuple,
			ContextEntry context, IDegreeFactory factory) {
    	return this.restrictions.isSatisfiedCachedRight( tuple,
                context, factory );
	}

    public Object clone() {
        return new MultiRestrictionFieldConstraint( this.readAccessor,
                                                    (Restriction) this.restrictions.clone() );
    }

    
    
      
	public ConstraintKey getConstraintKey() {
		
		return this.restrictions.getConstraintKey();
	}

	public Collection<ConstraintKey> getAllConstraintKeys() {
		Collection<ConstraintKey> ans = new LinkedList<ConstraintKey>();
							
		//ans.addAll(this.restrictions.getAllConstraintKeys());
		ans.add(this.getConstraintKey());
		return ans;
	}

	
	public EvaluationTemplate buildEvaluationTemplate(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
		//BUILD A COMPOSITE TEMPLATE
    	
				
		//EvaluationTemplate temp = buildTemplateForRestriction(this.restrictions, null, id, dependencies, factory);
		EvaluationTemplate temp = new SingleEvaluationTemplate(id,this.restrictions.getConstraintKey(),dependencies.get(restrictions.getConstraintKey()),factory.getMergeStrategy(),factory.getNullHandlingStrategy());
    			    	    		
		this.setTemplate(temp);
    	return getTemplate();
    }
	
	 public EvaluationTemplate getEvalTemplate(ConstraintKey key) {
			if (this.getTemplate().getConstraintKey().equals(key))
				return this.getTemplate();
			else return null;
	}
	
	 
	 
	 
	 /*
	 private EvaluationTemplate buildTemplateForRestriction(Restriction restr, CompositeEvaluationTemplate master, int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory) {
		 EvaluationTemplate temp = null;
		 	if (restr instanceof AbstractCompositeRestriction) {
		 		AbstractCompositeRestriction compRestr = (AbstractCompositeRestriction) restr;
		 		
		 		IDegreeCombiner operator = null;
		 			if (restr instanceof AndCompositeRestriction) {
		 				operator = factory.getAndOperator();
		 			} else if (restr instanceof OrCompositeRestriction) {
		 				operator = factory.getOrOperator();
		 			} else {
		 				throw new UnsupportedOperationException("Unknown composite restriction...");
		 			}
		 			
		 		temp = new CompositeEvaluationTemplate(id,
		 				getConstraintKey(),
		 				dependencies.get(getConstraintKey()),
		 				compRestr.getRestrictions().length,
		 				operator,
		 				factory.getMergeStrategy(),
		 				factory.getNullHandlingStrategy()		 				
		 				);
		 		
		 		for (Restriction r : compRestr.getRestrictions())
		 			buildTemplateForRestriction(r, (CompositeEvaluationTemplate) temp, id, dependencies, factory); 
		 		
		 	} else {
		 		temp = new SingleEvaluationTemplate(id,
		 				restr.getConstraintKey(),
		 				dependencies.get(restr.getConstraintKey()),
		 				factory.getMergeStrategy(),
		 				factory.getNullHandlingStrategy());
		 	}
		 if (master != null)
			 master.addChild(temp);
		 return temp;
	 }
*/
	

}