package org.drools.chance.fuzzyTest;

import org.drools.chance.AbstractChanceTest;


public class FuzzyTest0 extends AbstractChanceTest {

	 
	
	
	public void act() {
		Room r = new Room(27.5f);

		getSession().insert(r);				
		getSession().fireAllRules();
	}

	
	
	public static final void main(final String[] args) throws Exception {
		
		FuzzyTest0 test = new FuzzyTest0();
			test.setRuleFileName("FuzzyTest0.drl");
			test.setFactoryName(FUZZY_FACTORY);
			test.setDumpable(true);
			test.setSilent(false);
			
			test.run();
			

	}



	
	
}
