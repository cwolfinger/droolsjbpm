package org.drools.chance;

import org.drools.definition.type.FactType;



public class ComplexFormulaTest extends AbstractChanceTest {
	
	
	

	public static final void main(final String[] args) throws Exception {
		
		ComplexFormulaTest test = new ComplexFormulaTest();
			test.setRuleFileName("ComplexFormulaTest.drl");
			
			test.setFactoryName(FUZZY_FACTORY);
				
		test.run();

	}

	@Override
	public void act() throws InstantiationException, IllegalAccessException {
		
		FactType msgType = getFactType("Message");
			Object msg = msgType.newInstance();
			msgType.set(msg,"status",0);
			
		getSession().insert(msg);
		
		getSession().fireAllRules();
	}

	
}
