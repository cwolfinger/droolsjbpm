package org.drools.fuzzy.evaluators;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.drools.base.ValueType;
import org.drools.base.evaluators.EvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.base.evaluators.EvaluatorDefinition.Target;
import org.drools.spi.Evaluator;

public class HotEvaluatorDefinition implements EvaluatorDefinition {
	
	public static final Operator   HOT         = Operator.addOperatorToRegistry( "hot",
			false );

	private static final String[]  SUPPORTED_IDS = {HOT.getOperatorString()};
	
	private Map<String, Evaluator> cache         = Collections.emptyMap();
	

	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText) {
		
		
		if ( this.cache == Collections.EMPTY_MAP ) {
            this.cache = new HashMap<String, Evaluator>();
        }
        String key = isNegated + ":" + parameterText;
        Evaluator eval = this.cache.get( key );
        if ( eval == null ) {
//            eval = new HotEvaluator( type,
//                                       isNegated,
//                                       parameterText );
        		eval = new FuzzyNumericEvaluator(HOT,
        										type,
        										isNegated,
        										parameterText);
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
	
	public String[] getEvaluatorIds() {
		return SUPPORTED_IDS;
	}

	public Target getTarget() {
		return Target.FACT;
	}

	public boolean isNegatable() {
		return true;
	}

	public boolean supportsType(ValueType type) {
		return true;
	}

	public void readExternal(ObjectInput arg0) throws IOException,
			ClassNotFoundException {
				
	}

	public void writeExternal(ObjectOutput arg0) throws IOException {
				
	}

}
