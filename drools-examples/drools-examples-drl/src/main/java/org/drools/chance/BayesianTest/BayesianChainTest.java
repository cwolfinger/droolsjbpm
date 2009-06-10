package org.drools.chance.BayesianTest;

import org.drools.chance.AbstractChanceTest;
import org.drools.chance.fuzzyTest.FuzzyTest1;
import org.drools.definition.type.FactType;

public class BayesianChainTest extends AbstractChanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BayesianChainTest test = new BayesianChainTest();
		test.setRuleFileName("BayesianChainTest.drl");
		test.setFactoryName("org.drools.degrees.factory.BayesianDegreeFactory");
		test.setDumpable(false);
		test.setSilent(false);
		
		test.run();

	}

	
	public void act() {
		
		FactType quakeType = getFactType("Quake");
		
		try {
			Object quake = quakeType.newInstance();			
			
			getSession().insert(quake);
			
						
			getSession().fireAllRules();
		
		}  catch (Exception e) {
			e.printStackTrace();		
		}
		
	
	}

}
