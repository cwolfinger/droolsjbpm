package org.drools.fuzzy.evaluators;



import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.drools.RuntimeDroolsException;
import org.drools.WorkingMemory;
import org.drools.base.BaseEvaluator;
import org.drools.base.BaseImperfectEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.ImperfectBinaryEvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.rule.VariableRestriction.ObjectVariableContextEntry;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.Evaluator;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;







/**
 * 
 * @author sotty

 *
 */
public class RandomEvaluatorDefinition 
	implements ImperfectBinaryEvaluatorDefinition {
	
	
	
	
	
	
		
	
	
	
	public static final Operator   RANDOM         = Operator.addOperatorToRegistry( "random",
            										false );

	private static final String[]  SUPPORTED_IDS = {RANDOM.getOperatorString()};

	private Map<String, Evaluator> cache         = Collections.emptyMap();

	
	
	
	
	
	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText) {
		
		
		if ( this.cache == Collections.EMPTY_MAP ) {
            this.cache = new HashMap<String, Evaluator>();
        }
        String key = isNegated + ":" + parameterText;
        Evaluator eval = this.cache.get( key );
        if ( eval == null ) {
            eval = new RandomEvaluator( type,
                                       isNegated,
                                       parameterText );
            this.cache.put( key,
                            eval );
        }
        return eval;
        
        
        
	}

	public Evaluator getEvaluator(ValueType type, Operator operator,
			String parameterText) {
		return getEvaluator(type,operator.getOperatorString(),false,parameterText);
	}

	public Evaluator getEvaluator(ValueType type, Operator operator) {
		return getEvaluator(type,operator.getOperatorString(),false,"");
	}

	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText, Target leftTarget,
			Target rightTarget) {
		return getEvaluator(type, operatorId, isNegated, parameterText);
	}
	
	
	
	/**
	 * Operator is known as "far"
	 */
	public String[] getEvaluatorIds() {
		return SUPPORTED_IDS;
	}

	
	
	
	
	
	
	/** 
	 * 
	 * 
	 */
	public boolean isNegatable() {
		return true;
	}

	
	
	/**
	 * This evaluator operates on fact properties (i.e. age) 
	 * and not on factHandles. 
	 * So this returns false
	 */
	public boolean operatesOnFactHandles() {
		return false;
	}

	
	
	
	
	/**
	 * 
	 */
	public boolean supportsType(ValueType type) {
		return type.isNumber();
	}

	
	
	
	
	
	
	/*
	 * TODO: Try and understand what this means. Copied from AfterEvalDef.
	 */
	
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		cache = (Map<String, Evaluator>) in.readObject();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(cache);
	}

	
	
	
	
	
	
	

	public Target getTarget() {
		return Target.FACT;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
