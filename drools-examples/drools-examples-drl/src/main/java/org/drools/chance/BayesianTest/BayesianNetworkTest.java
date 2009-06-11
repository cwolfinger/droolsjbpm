package org.drools.chance.BayesianTest;

import org.drools.chance.AbstractChanceTest;
import org.drools.chance.fuzzyTest.FuzzyTest1;
import org.drools.definition.type.FactType;

public class BayesianNetworkTest extends AbstractChanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BayesianNetworkTest test = new BayesianNetworkTest();
		test.setRuleFileName("BayesianNetworkTest.drl");
		test.setFactoryName("org.drools.degrees.factory.BayesianDegreeFactory");
		test.setDumpable(false);
		test.setSilent(false);
		
		test.run();

	}

	
	public void act() {
		
		FactType quakeType = getFactType("Quake");
		FactType burglarType = getFactType("Burglar");
		FactType johnType = getFactType("John");
		
		try {
			Object quake = quakeType.newInstance();			
			Object burglar = burglarType.newInstance();
			Object john = johnType.newInstance();
			
			getSession().insert(quake);
//			getSession().insert(burglar);			
			getSession().insert(john);
						
			getSession().fireAllRules();
			
			
		}  catch (Exception e) {
			e.printStackTrace();		
		}
		

	}

}
