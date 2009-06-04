package org.drools.chance.BayesianTest;

import org.drools.chance.AbstractChanceTest;
import org.drools.chance.fuzzyTest.FuzzyTest1;
import org.drools.definition.type.FactType;

public class BayesianTest extends AbstractChanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BayesianTest test = new BayesianTest();
		test.setRuleFileName("BayesianTest.drl");
		test.setFactoryName("org.drools.degrees.factory.BayesianDegreeFactory");
		test.setDumpable(false);
		test.setSilent(false);
		
		test.run();

	}

	
	public void act() {
//		String packS = this.getClass().getPackage().getName();
//		FactType foo1Type = getSession().getKnowledgeBase().getFactType(packS,"Foo1");
//		FactType foo2Type = getSession().getKnowledgeBase().getFactType(packS,"Foo2");
//		
//		try {
//			Object foo1 = foo1Type.newInstance();
//			Object foo2 = foo2Type.newInstance();
//			
//			getSession().insert(foo1);
//			getSession().insert(foo2);
//			
//			getSession().fireAllRules();
//		}  catch (Exception e) {
//			e.printStackTrace();		
//		}
//		
	}

}
