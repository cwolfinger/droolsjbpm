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
import org.drools.base.evaluators.ImperfectAbstractEvaluatorDefinition;
import org.drools.base.evaluators.ImperfectEvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.base.evaluators.EvaluatorDefinition.Target;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
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
public class EqualsEvaluatorDefinition 
	extends ImperfectAbstractEvaluatorDefinition {
	
	
	
	
	
	
		
	
	
	
	public static final Operator   EQUALS         = Operator.addOperatorToRegistry( "equals",
            										false );

	private static final String[]  SUPPORTED_IDS = {EQUALS.getOperatorString()};

	
	public Evaluator getEvaluator(ValueType type, String operatorId,
			boolean isNegated, String parameterText, Target left, Target right) {
		
		if ( this.cache == Collections.EMPTY_MAP ) {
            this.cache = new HashMap<String, Evaluator>();
        }
        String key = isNegated + ":" + parameterText;
        Evaluator eval = this.cache.get( key );
        if ( eval == null ) {
            eval = new EqualsEvaluator( type,
                                       isNegated,
                                       parameterText );
            this.cache.put( key,
                            eval );
        }
        return eval;
                        
	}

	
	
	/**
	 * Operator is known as "equals"
	 */
	public String[] getEvaluatorIds() {
		return SUPPORTED_IDS;
	}

	
	
	
	
	
	
	
	
	
	public class EqualsEvaluator extends BaseImperfectEvaluator {

		
		public EqualsEvaluator(ValueType type, boolean isNegated,
				String parameterText) {
			super(type, EqualsEvaluatorDefinition.EQUALS, parameterText);
		}

		@Override
		protected IDegree eval(Object left, Object right, IDegreeFactory factory) {
			if (left == null || right == null)
				return factory.Unknown();
			return factory.fromBoolean(left.equals(right));
		}
				

	}

	
	
	
	
	
	
	
}
