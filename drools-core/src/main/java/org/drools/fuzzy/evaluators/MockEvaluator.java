package org.drools.fuzzy.evaluators;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.RuntimeDroolsException;
import org.drools.WorkingMemory;
import org.drools.base.BaseImperfectEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ImperfectRuleBase;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;




public class MockEvaluator extends BaseImperfectEvaluator {
	

	private final static Operator MOP = Operator.addOperatorToRegistry("NOPERATOR", false) ;


	public MockEvaluator(final ValueType type,
            				final boolean isNegated,
            				final String parameters) {
			super( type,
                   MOP);
            this.parseParameters( parameters );	        
	}
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        

    }

    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);


    }
	
	
   
    protected IDegree eval(WorkingMemory workingMemory) {
    	if (! (workingMemory.getRuleBase() instanceof ImperfectRuleBase)) {
			throw new RuntimeDroolsException("Mock Evaluator : Uncertainty has not been enabled in the current Rule Base");
		}
		IDegreeFactory factory = ((ImperfectRuleBase) workingMemory.getRuleBase()).getDegreeFactory();
		
		return factory.Unknown();
    }
    
  
	public boolean evaluate(InternalWorkingMemory workingMemory,
			InternalReadAccessor extractor, Object object1, FieldValue value) {			
		return eval(workingMemory).toBoolean();
	}

	
	
	public boolean evaluate(InternalWorkingMemory workingMemory,
			InternalReadAccessor leftExtractor, Object left,
			InternalReadAccessor rightExtractor, Object right) {
		return eval(workingMemory).toBoolean();
	}

	
	public boolean evaluateCachedLeft(InternalWorkingMemory workingMemory,
			VariableContextEntry context, Object object1) {
		return eval(workingMemory).toBoolean();
	}


	public boolean evaluateCachedRight(InternalWorkingMemory workingMemory,
			VariableContextEntry context, Object object2) {
		return eval(workingMemory).toBoolean();
	}
	
	
	
	
	@Override
    public int hashCode() {
        final int PRIME = 37;
        int result = PRIME * super.hashCode();                    
        return result;
    }
	
	
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( !super.equals( obj ) ) return false;
        if ( getClass() != obj.getClass() ) return false;     
        return true;
    }

    /**
     * This methods tries to parse the string of parameters to customize
     * the evaluator.
     *
     * @param parameters
     */
    private void parseParameters(String parameters) {
        
    }

	
}
	
	