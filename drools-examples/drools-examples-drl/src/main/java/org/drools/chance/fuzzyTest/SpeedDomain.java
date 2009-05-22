package org.drools.chance.fuzzyTest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.base.ValueType;
import org.drools.base.evaluators.EvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.fuzzy.FuzzySet;
import org.drools.fuzzy.NumericDomainFuzzySet;
import org.drools.fuzzy.RealDomain;
import org.drools.fuzzy.evaluators.FuzzyNumericEvaluator;
import org.drools.fuzzy.evaluators.membership.TriangleMembership;
import org.drools.spi.Evaluator;


public class SpeedDomain extends RealDomain {
	
	
	public static final String STOP = "stop";
	public static final String SLOW = "slow";
	public static final String FAST = "fast";
	
		
	
			
	public static final Operator   stopOp         = Operator.addOperatorToRegistry( SpeedDomain.STOP,false );
	public static final Operator   notStopOp      = Operator.addOperatorToRegistry( SpeedDomain.STOP,true );
	
	public static final Operator   slowOp         = Operator.addOperatorToRegistry( SpeedDomain.SLOW,false );
	public static final Operator   notSlowOp      = Operator.addOperatorToRegistry( SpeedDomain.SLOW,true );
	
	public static final Operator   fastOp         = Operator.addOperatorToRegistry( SpeedDomain.FAST,false );
	public static final Operator   notFastOp      = Operator.addOperatorToRegistry( SpeedDomain.FAST,true );
	
	protected static String[]  SUPPORTED_IDS	= { stopOp.getOperatorString(),
													 slowOp.getOperatorString(),
													 fastOp.getOperatorString(),

		};

	
	public SpeedDomain() {		
		this.addGranule(new NumericDomainFuzzySet(STOP,
				new FuzzyNumericEvaluator(
						stopOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 0, 50"
						)
			));
		this.addGranule(new NumericDomainFuzzySet(SLOW,
				new FuzzyNumericEvaluator(
						slowOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 50, 50"
						)
			));
		this.addGranule(new NumericDomainFuzzySet(FAST,
				new FuzzyNumericEvaluator(
						fastOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 100, 50"
						)
			));	
	}
	
	
	public String[] getEvaluatorIds() {
		return SUPPORTED_IDS;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
