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


public class TemperatureDomain extends RealDomain {
	
	
	public static final String COLD = "cold";
	public static final String COOL = "cool";
	public static final String WARM = "warm";
	public static final String HOT = "hot";
		
	
			
	public static final Operator   coldOp         = Operator.addOperatorToRegistry( TemperatureDomain.COLD,false );
	public static final Operator   notColdOp      = Operator.addOperatorToRegistry( TemperatureDomain.COLD,true );
	
	public static final Operator   coolOp         = Operator.addOperatorToRegistry( TemperatureDomain.COOL,false );
	public static final Operator   notCoolOp      = Operator.addOperatorToRegistry( TemperatureDomain.COOL,true );
	
	public static final Operator   warmOp         = Operator.addOperatorToRegistry( TemperatureDomain.WARM,false );
	public static final Operator   notWarmOp      = Operator.addOperatorToRegistry( TemperatureDomain.WARM,true );
	
	public static final Operator   hotOp         = Operator.addOperatorToRegistry( TemperatureDomain.HOT,false );
	public static final Operator   notHotOp      = Operator.addOperatorToRegistry( TemperatureDomain.HOT,true );

	protected static String[]  SUPPORTED_IDS	= { coldOp.getOperatorString(),
													 coolOp.getOperatorString(),
													 warmOp.getOperatorString(),
													 hotOp.getOperatorString(),
		};

	
	public TemperatureDomain() {		
		this.addGranule(new NumericDomainFuzzySet(COLD,
				new FuzzyNumericEvaluator(
						coldOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 0, 10"
						)
			));
		this.addGranule(new NumericDomainFuzzySet(COOL,
				new FuzzyNumericEvaluator(
						coolOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 10, 10"
						)
			));
		this.addGranule(new NumericDomainFuzzySet(WARM,
				new FuzzyNumericEvaluator(
						warmOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 20, 10"
						)
			));
		this.addGranule(new NumericDomainFuzzySet(HOT,
				new FuzzyNumericEvaluator(
						hotOp,
						ValueType.DOUBLE_TYPE,
						false,
						"org.drools.fuzzy.evaluators.membership.TriangleMembership, 30, 10"
						)
			));
		
	}
	
	
	public String[] getEvaluatorIds() {
		return SUPPORTED_IDS;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
