package org.drools.chance.fuzzyTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.drools.FactHandle;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.RuleBaseConfiguration;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceConfiguration;
import org.drools.builder.ResourceType;
import org.drools.chance.AbstractChanceTest;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.definition.KnowledgePackage;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class FuzzyTest1 extends AbstractChanceTest {

	
	public void act() {
		
		Room r = new Room(22.5f);
		Fan f = new Fan();
		
		getSession().insert(f);
		getSession().insert(r);				
		getSession().fireAllRules();
				
		//log("\n\n\n\nULTIMATE ANSWER : FAN speed is "+f.getSpeed()+"\n\n");

	}
	
	public static final void main(final String[] args) throws Exception {
		
		FuzzyTest1 test = new FuzzyTest1();
		test.setRuleFileName("FuzzyTest1.drl");
		test.setFactoryName(FUZZY_FACTORY);
		test.setDumpable(true);
		test.setSilent(false);
		
		test.run();

	}
	
	
	
	
	
		
		
			
			
		

	
	
}
