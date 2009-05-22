package org.drools.fuzzy.evaluators;


import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;


import org.drools.RuntimeDroolsException;
import org.drools.base.BaseImperfectEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.fuzzy.evaluators.membership.INumericSetMembershipFunction;
import org.drools.fuzzy.evaluators.membership.SkepticNumericMembershipFunction;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.FieldValue;

import org.drools.spi.InternalReadAccessor;




public class FuzzyNumericEvaluator extends BaseImperfectEvaluator {
	

	private INumericSetMembershipFunction mu;
	
	private boolean isNegated;


	public FuzzyNumericEvaluator(Operator op, final ValueType type,
            				final boolean isNegated,
            				final String parameters) {
			super( type , op, parameters );
			this.isNegated = isNegated;
	}
	
	
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);   
        mu = (INumericSetMembershipFunction) in.readObject();
        isNegated = in.readBoolean();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeObject(mu);
        out.writeBoolean(isNegated);
    }
	
	
   
    protected IDegree eval(Object left, Object right, IDegreeFactory factory) {
    			
		if (left == null) return factory.Unknown();
		if (! (left instanceof Number))
			throw new RuntimeDroolsException("Numbers only");
		
		return mu.eval((Number) left, factory);
    }
    
    
    public String toString() {
    	return "FuzzyNumericEvaluator - " + getOperator().getOperatorString(); 
    }
    
       
	public Number getCenter() {
		return mu.getCenter();
	}
	
			
	@Override
    public int hashCode() {
        final int PRIME = 37;
        int result = PRIME * super.hashCode() * mu.hashCode();                    
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
        return this.mu.equals(((FuzzyNumericEvaluator) obj).mu);              
    }

    /**
     * This methods tries to parse the string of parameters to customize
     * the evaluator.
     *
     * @param parameters
     */
    public void parseParameters(String parameters) {
    	    	    	    	
        StringTokenizer tok = new StringTokenizer(parameters," ,");   
        if (tok.countTokens() == 0) 
        	setMu(new SkepticNumericMembershipFunction());
        	
        String className = tok.nextToken();
                
        int numParm = tok.countTokens();
        String[] params = new String[numParm];
        
        for (int j = 0; j < numParm; j++) {
        	params[j] = tok.nextToken();
        }
        
        
        	try {        						
        		Class clazz = Class.forName(className);
				Object obj = clazz.getConstructor().newInstance();					
				
				if (obj instanceof INumericSetMembershipFunction) {
					
					INumericSetMembershipFunction mu = (INumericSetMembershipFunction) obj;
					mu.init(params);
					setMu(mu);
					return;
				}
			} catch (ClassNotFoundException e) {	
				System.out.println(e.toString());
//				e.printStackTrace();				
			} catch (SecurityException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			} catch (InstantiationException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			}
        
			throw new RuntimeDroolsException( "[Fuzzy Numeric Evaluator]: Unable to parse parameters: '" + parameters + "'" );
			
        
    }


	public INumericSetMembershipFunction getMu() {
		return mu;
	}



	public void setMu(INumericSetMembershipFunction mu) {
		this.mu = mu;
	}

}
	
	