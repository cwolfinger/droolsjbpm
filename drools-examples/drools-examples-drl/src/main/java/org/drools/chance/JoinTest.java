package org.drools.chance;

import org.drools.definition.type.FactType;

public class JoinTest extends AbstractChanceTest {


	public static final void main(final String[] args) throws Exception {
		
		JoinTest test = new JoinTest();
			test.setRuleFileName("JoinTest.drl");
						
			test.run();
			
	}
	

		
	@Override
	public void act() throws InstantiationException, IllegalAccessException {
		
		//All possible combinations will appear, but just one will be true...
		
		getSession().fireAllRules();
		
		System.out.println("\n\n\n\n\n\n no msg in ********************************************************\n\n\n\n\n\n\n");
	
		FactType msgType = getFactType("Message");
		
		Object message = msgType.newInstance();
			msgType.set(message,"status",0);
			msgType.set(message,"message","M0");		
			getSession().insert(message);
			
		//getSession().fireAllRules();
		
						
		Object message1 = msgType.newInstance();
			msgType.set(message1,"status",1);
			msgType.set(message1,"message","M1");		
			getSession().insert(message1);
				
		System.out.println("\n\n\n\n\n\n msg 1 in**********************************************************\n\n\n\n\n\n\n");

		getSession().fireAllRules();

			
		Object message2 = msgType.newInstance();
			msgType.set(message2,"status",2);
			msgType.set(message2,"message","M2");		
			getSession().insert(message2);			
		
			
		getSession().fireAllRules();
		
		System.out.println("\n\n\n\n\n\n msg 2 in**********************************************************\n\n\n\n\n\n\n");
		
		


	}
	
	

}
