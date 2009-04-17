/**
 * 
 */
package org.drools.base;

import org.drools.RuntimeDroolsException;
import org.drools.WorkingMemory;
import org.drools.base.evaluators.Operator;
import org.drools.common.InternalWorkingMemory;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ImperfectRuleBase;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;


/**
 * BaseUncertainEvaluator implements the uncertain evaluators
 * by calling the crisp ones and then converting the boolean
 * result into the used truth degree
 * 
 * @author sotty
 *
 */
public abstract class BaseImperfectEvaluator extends BaseEvaluator  {

	
	public BaseImperfectEvaluator(final ValueType type, final Operator operator) {
		super(type,operator);
	}
	
	
	protected IDegreeFactory getFactory(WorkingMemory workingMemory) {
		ImperfectRuleBase irb = (ImperfectRuleBase) workingMemory.getRuleBase();
		if (irb == null) 
			throw new RuntimeDroolsException(this.getClass()+ " Abstract BaseUncertainEvaluator : trying to use uncertain evaluators with crisp rule base");
		return irb.getDegreeFactory();
	}
	
	
	
	

	

}
