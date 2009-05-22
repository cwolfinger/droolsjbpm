package org.drools.chance;

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
import org.drools.builder.ResourceType;
import org.drools.chance.fuzzyTest.FuzzyTest0;
import org.drools.chance.fuzzyTest.Room;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.type.FactType;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class RuleMLTest extends AbstractChanceTest {

	

	public void initDrools() {
		
		configKnowledgeBuilder();				
		
	}

	
	
	public static final void main(final String[] args) throws Exception {
		
		RuleMLTest test = new RuleMLTest();
			test.setRuleFileName("RuleMLTest.drl");
			test.setSilent(true);			
			test.run();
			
	}
	

	public void act() {
		
	}

	

	
}
