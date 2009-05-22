package org.drools.chance.impliesTest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.RuntimeDroolsException;
import org.drools.base.BaseImperfectEvaluator;
import org.drools.base.ValueType;
import org.drools.base.evaluators.EvaluatorDefinition;
import org.drools.base.evaluators.ImperfectAbstractEvaluatorDefinition;
import org.drools.base.evaluators.ImperfectEvaluatorDefinition;
import org.drools.base.evaluators.Operator;
import org.drools.chance.AbstractChanceTest;
import org.drools.chance.fuzzyTest.FuzzyTest1;
import org.drools.common.InternalWorkingMemory;
import org.drools.definition.type.FactType;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.rule.VariableRestriction.VariableContextEntry;
import org.drools.spi.Evaluator;
import org.drools.spi.FieldValue;
import org.drools.spi.InternalReadAccessor;

public class ImpliesTest1 
	extends AbstractChanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImpliesTest1 test = new ImpliesTest1();
		
		test.setRuleFileName("ImpliesTest1.drl");
		
		test.setFactoryName("org.drools.degrees.factory.IntervalDegreeFactory");
		test.setOpenWorldAssumption();
		
		test.setDumpable(false);
		test.setSilent(false);
		
		test.run();

	}
	
	
	public void configKnowledgeBuilder() {
		super.configKnowledgeBuilder();
		getKBuilderConf().setProperty("drools.evaluator.flies", "org.drools.chance.impliesTest.ImpliesTest1$FliesEvaluatorDefinition");		
	}

	
	public void act() {
		
		try {
	
			Bird b1 = new Bird();
				b1.setId(1);
				b1.setIsFlier(true);
				b1.setIsPenguin(false);
			
			Bird b2 = new Bird();
				b2.setId(2);
				b2.setIsFlier(true);
				b2.setIsPenguin(false);
				
			Bird b3 = new Bird();
				b3.setId(3);
				b3.setIsFlier(false);
				b3.setIsPenguin(true);
				
			Bird b4 = new Bird();
				b4.setId(4);
				b4.setIsFlier(true);
				b4.setIsPenguin(false);
				
			Bird bird = new Bird();
				bird.setId(99);
				bird.setIsFlier(null);
				bird.setIsPenguin(false);	
	
			Bird penguin = new Bird();
				penguin.setId(-10);
				penguin.setIsFlier(null);
				penguin.setIsPenguin(true);			
			
			Bird flyBird = new Bird();
				flyBird.setId(1000);
				flyBird.setIsFlier(true);
				flyBird.setIsPenguin(false);
			
			Bird bird2 = new Bird();
				bird2.setId(100);
				bird2.setIsFlier(null);
				bird2.setIsPenguin(false);	
			
			getSession().insert(b1);
			getSession().insert(b2);
			getSession().insert(b3);
			getSession().insert(b4);
			
									
			getSession().fireAllRules();
			
			getLogger().write("\n*************************************************************************************\n");
			
			getSession().insert(bird);						
			getSession().fireAllRules();
			
			getLogger().write("\n*************************************************************************************\n");
			
			getSession().insert(penguin);
			getSession().fireAllRules();

			getLogger().write("\n*************************************************************************************\n");
			
			getSession().insert(flyBird);
			getSession().fireAllRules();

			getLogger().write("\n*************************************************************************************\n");
			
			getSession().insert(bird2);						
			getSession().fireAllRules();
			
			getLogger().write("\n*************************************************************************************\n");
			
		}  catch (Exception e) {
			e.printStackTrace();		
		}
		
		
	}


	
	public static class FliesEvaluatorDefinition extends ImperfectAbstractEvaluatorDefinition {
		

		public static final Operator FLIES = Operator.addOperatorToRegistry( "flies", false );
		
		private static final String[]  SUPPORTED_IDS = {FLIES.getOperatorString()};
		
		private Evaluator flyEvaluator = new BaseImperfectEvaluator(ValueType.BOOLEAN_TYPE, FLIES, "") {

			@Override
			protected IDegree eval(Object left, Object right, IDegreeFactory factory) {
				if (left instanceof Bird) {
					Boolean b = ((Bird) left).getIsFlier();
					if (b == null)
						return factory.Unknown();
					return factory.fromBoolean(b);
				}
				
				throw new RuntimeDroolsException("Birds only!!");
				
			}						
		};
		
		
		public Evaluator getEvaluator(ValueType type, String operatorId,
				boolean isNegated, String parameterText, Target leftTarget,
				Target rightTarget) {
			return flyEvaluator;
		}


		public String[] getEvaluatorIds() {
			return SUPPORTED_IDS;
		}								
		
	}
	
	
	
	
	
	public static class Bird {
		public Bird() {
			
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Boolean getIsFlier() {
			return isFlier;
		}
		public void setIsFlier(Boolean isFlier) {
			this.isFlier = isFlier;
		}
		public Boolean getIsPenguin() {
			return isPenguin;
		}
		public void setIsPenguin(Boolean isPenguin) {
			this.isPenguin = isPenguin;
		}

		private Integer id;
		private Boolean isFlier;
		private Boolean isPenguin;
		
		public int hashCode() {
			return 31+id;
		}
		
		public boolean equals(Object other) {
			if (other == null)
				return false;
			if (this == other)
				return true;
			if (other instanceof Bird) {
				return this.id == ((Bird) other).getId();
			} else 
				return false;
		}
	}
	
	
	
}
