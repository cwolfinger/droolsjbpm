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
	

	public MockEvaluator(ValueType type, Operator operator, String parameters) {
		super(type, operator, parameters);		
	}

	
	@Override
	protected IDegree eval(Object left, Object right, IDegreeFactory factory) {
		return factory.Unknown();
	}




	
	
}
	
	