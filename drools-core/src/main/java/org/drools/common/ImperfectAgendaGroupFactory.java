package org.drools.common;


public class ImperfectAgendaGroupFactory implements AgendaGroupFactory {

	private static ImperfectAgendaGroupFactory INSTANCE = new ImperfectAgendaGroupFactory();
	
	public InternalAgendaGroup createAgendaGroup(String name,
			InternalRuleBase ruleBase) {
		return new ImperfectAgendaGroup(name, ruleBase);
	}

	public static AgendaGroupFactory getInstance() {
		return INSTANCE;
	}

}
