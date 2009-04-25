package org.drools.examples.chance;

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
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.definition.KnowledgePackage;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class FuzzyTest0 {

	
	public static final void main(final String[] args) throws Exception {
		
		
		Properties props = new Properties();
		props.load(new FileInputStream("src/fuzzyTest.packagebuilder.conf"));
			KnowledgeBuilderConfiguration conf = new PackageBuilderConfiguration(props);
				conf.setProperty("drools.assertBehaviour","equality");
				
		
		
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder(conf);

		
		

		//EXAMPLE 1
		kbuilder.add(ResourceFactory.newClassPathResource("FuzzyTest0.drl",
				FuzzyTest0.class), ResourceType.DRL );
		
	
		// Check the builder for errors
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			throw new RuntimeException("Unable to compile \"Fyzzytest.drl\".");
		}

		// get the compiled packages (which are serializable)
		final Collection<KnowledgePackage> pkgs = kbuilder
				.getKnowledgePackages();

		
		
		RuleBaseConfiguration rbconf = new RuleBaseConfiguration(props);
				rbconf.setProperty("drools.assertBehaviour","equality");
				//rbconf.setProperty("drools.imperfect.factory", "org.drools.degrees.factory.SimpleDegreeFactory");
		
		// add the packages to a knowledgebase (deploy the knowledge packages).
		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(rbconf);
		kbase.addKnowledgePackages(pkgs);

		
		
		final StatefulKnowledgeSession ksession = kbase
				.newStatefulKnowledgeSession();
		
		FileWriter writer = new FileWriter("fuzzyTest0.log");
		ksession.setGlobal("writer", writer);
		
		Room r = new Room(27.5f);
		
		ksession.insert(r);				
		ksession.fireAllRules();
		
		writer.close();

//		ksession.addEventListener(new DebugAgendaEventListener());
//		ksession.addEventListener(new DebugWorkingMemoryEventListener());

		// setup the audit logging
//	KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
//				.newFileLogger(ksession, "log/helloworld");

//		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		

//		logger.close();

		ksession.dispose();
	}

	public static class Message {
		public static final int HELLO = 0;
		public static final int GOODBYE = 1;
		public static final int FUFF = 3;

		public String message = "";

		private int status;

		public Message() {

		}

		public String getMessage() {
			return this.message;
		}

		public void setMessage(final String message) {
			this.message = message;
		}

		public int getStatus() {
			return this.status;
		}

		public void setStatus(final int status) {
			this.status = status;
		} 

		public static Message doSomething(Message message) {
			return message;
		}

		public boolean isSomething(String msg, List<Object> list) {
			list.add(this);
			return this.message.equals(msg);
		}
		
		public boolean equals(Object other) {
			if (other == null) return false;
			if (other instanceof Message) {
				Message o = (Message) other;
				return o.message.equals(this.message) && o.status == this.status;
			}
			return false;
		
		}
		
		public int hashCode() {
			return 10+this.message.hashCode()+this.status;
		}
	}

	
	
	
	
	
		
		
			
			
		

	
	
}
