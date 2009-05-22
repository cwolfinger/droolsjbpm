package org.drools.chance.impliesTest;

import org.drools.chance.AbstractChanceTest;
import org.drools.chance.fuzzyTest.FuzzyTest1;
import org.drools.definition.type.FactType;

public class ImpliesTest0 extends AbstractChanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImpliesTest0 test = new ImpliesTest0();
		test.setRuleFileName("ImpliesTest0.drl");
		test.setFactoryName("org.drools.degrees.factory.SimpleFuzzyDegreeFactory");
		test.setDumpable(true);
		test.setSilent(false);
		
		test.run();

	}

	
	public void act() {
		String packS = this.getClass().getPackage().getName();
		FactType foo1Type = getSession().getKnowledgeBase().getFactType(packS,"Foo1");
		FactType foo2Type = getSession().getKnowledgeBase().getFactType(packS,"Foo2");
		
		try {
			Object foo1 = foo1Type.newInstance();
			Object foo2 = foo2Type.newInstance();
			
			getSession().insert(foo1);
			getSession().insert(foo2);
			
			getSession().fireAllRules();
		}  catch (Exception e) {
			e.printStackTrace();		
		}
		
	}

}
