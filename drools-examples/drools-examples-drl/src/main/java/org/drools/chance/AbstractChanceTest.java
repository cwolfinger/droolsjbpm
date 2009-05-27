package org.drools.chance;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.RuleBaseConfiguration;
import org.drools.RuleBaseConfiguration.AssertBehaviour;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.compiler.DrlParser;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.lang.descr.PackageDescr;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.xml.RuleMLDumper;


public abstract class AbstractChanceTest {
	
	
	
	public static final String SIMPLE_FACTORY = "org.drools.degrees.factory.SimpleDegreeFactory"; 
	public static final String FUZZY_FACTORY = "org.drools.degrees.factory.SimpleFuzzyDegreeFactory";
	public static final String INTERVAL_FACTORY = "org.drools.degrees.factory.IntervalDegreeFactory";

	private String ruleFileName = null;
	
	private String factoryName = SIMPLE_FACTORY;
	
	private KnowledgeBuilderConfiguration kBuilderConf = new PackageBuilderConfiguration();
	
	private RuleBaseConfiguration ruleBaseConf = new RuleBaseConfiguration();
			
	private FileWriter logger;
	
	private StatefulKnowledgeSession session;
	
	private boolean isDumpable = true;
	
	private RuleMLDumper dumper = new RuleMLDumper();
	
	private boolean isSilent = false;
	
	private boolean cwa = true;
	
		
	public AbstractChanceTest() {
				
		try {
			logger = new FileWriter("log/"+this.getClass().getSimpleName()+".log");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unable to log");
		}
	}
	
	
	
		
	
	public void initDrools() {
					
		configKnowledgeBuilder();
		
		Collection<KnowledgePackage> pks = compilePackages();
		
		configRuleBase();
		
		initSession(pks);
		
		getSession().setGlobal("writer",getLogger());
		
	}
	
	
	public void run() {
		try {
		if (isSilent) 
			System.setOut(new NullPrintStream("out.txt"));
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		
		initDrools();
		
		if (isDumpable) {
			try {
				InputStream drl = ResourceFactory.newClassPathResource(getRuleFileName(),
						this.getClass()).getInputStream();	    		
				DrlParser parser = new DrlParser();
	    		PackageDescr pkD = parser.parse(drl);
				
				System.out.println(getDumper().dump(pkD,this.getKBuilderConf(),"xml/"+this.getClass().getSimpleName()+".ruleml.xml"));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("XML Dumping failed");
			}
		}
		
		try {
			act();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		terminate();
	}
	
	
	
	public void configKnowledgeBuilder() {
		
		getKBuilderConf().setProperty("drools.evaluator.hot", "org.drools.chance.fuzzyTest.TemperatureDomain");
		getKBuilderConf().setProperty("drools.evaluator.warm", "org.drools.chance.fuzzyTest.TemperatureDomain");
		getKBuilderConf().setProperty("drools.evaluator.cool", "org.drools.chance.fuzzyTest.TemperatureDomain");
		getKBuilderConf().setProperty("drools.evaluator.cold", "org.drools.chance.fuzzyTest.TemperatureDomain");
		
		getKBuilderConf().setProperty("drools.evaluator.fast", "org.drools.chance.fuzzyTest.SpeedDomain");
		getKBuilderConf().setProperty("drools.evaluator.slow", "org.drools.chance.fuzzyTest.SpeedDomain");
		getKBuilderConf().setProperty("drools.evaluator.stop", "org.drools.chance.fuzzyTest.SpeedDomain");
		
		getKBuilderConf().setProperty("drools.evaluator.seems", "org.drools.fuzzy.evaluators.SeemsEvaluatorDefinition");
		
		getKBuilderConf().setProperty("drools.evaluator.random", "org.drools.fuzzy.evaluators.RandomEvaluatorDefinition");
		
		getKBuilderConf().setProperty("drools.evaluator.equals", "org.drools.fuzzy.evaluators.EqualsEvaluatorDefinition");
		
	}
	
	
	public Collection<KnowledgePackage> compilePackages() {	
	
		String fileName = getRuleFileName();
										
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder(getKBuilderConf());
			
		kbuilder.add(ResourceFactory.newClassPathResource(fileName,
				this.getClass()), ResourceType.DRL );
			
		// Check the builder for errors
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			throw new RuntimeException("Unable to compile " + fileName);
		}
							
		// get the compiled packages (which are serializable)
		return kbuilder.getKnowledgePackages();
	}
	
	
	
	public void configRuleBase() {
		getRuleBaseConf().setProperty("org.drools.chance.enable" , "true");
		

		
		getRuleBaseConf().setProperty("org.drools.chance.factory", getFactoryName());
			getRuleBaseConf().setAssertBehaviour(AssertBehaviour.EQUALITY);
			getRuleBaseConf().setIndexLeftBetaMemory(false);
			getRuleBaseConf().setIndexRightBetaMemory(false);
			getRuleBaseConf().setAlphaNodeHashingThreshold(0);
			
		getRuleBaseConf().setProperty("org.drools.chance.cwa" , cwa ? "true" : "false");	
		
	}
	
	
	public void initSession(Collection<KnowledgePackage> pkgs) {
		
		
		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(getRuleBaseConf());
		kbase.addKnowledgePackages(pkgs);
						 		
		setSession(kbase.newStatefulKnowledgeSession());
		
		

	}
	
	
	
	public void terminate() {
		try {
			getLogger().flush();
			getLogger().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (getSession() != null)
			getSession().dispose();			
	}
	
	
	public abstract void act() throws InstantiationException, IllegalAccessException;

	public boolean log(String s) {
		try {
			getLogger().write(s);
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}

	}
	
	/**
	 * @param ruleFileName the ruleFileName to set
	 */
	public void setRuleFileName(String ruleFileName) {
		this.ruleFileName = ruleFileName;
	}


	/**
	 * @return the ruleFileName
	 */
	public String getRuleFileName() {
		return ruleFileName;
	}


	/**
	 * @param kBuilderConf the kBuilderConf to set
	 */
	public void setKBuilderConf(KnowledgeBuilderConfiguration kBuilderConf) {
		this.kBuilderConf = kBuilderConf;
	}


	/**
	 * @return the kBuilderConf
	 */
	public KnowledgeBuilderConfiguration getKBuilderConf() {
		return kBuilderConf;
	}


	/**
	 * @param ruleBaseConf the ruleBaseConf to set
	 */
	public void setRuleBaseConf(RuleBaseConfiguration ruleBaseConf) {
		this.ruleBaseConf = ruleBaseConf;
	}


	/**
	 * @return the ruleBaseConf
	 */
	public RuleBaseConfiguration getRuleBaseConf() {
		return ruleBaseConf;
	}




	/**
	 * @param factoryName the factoryName to set
	 */
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}




	/**
	 * @return the factoryName
	 */
	public String getFactoryName() {
		return factoryName;
	}





	/**
	 * @param logger the logger to set
	 */
	public void setLogger(FileWriter logger) {
		this.logger = logger;
	}

	public void setFileLogger(String logName) {
		try {
			setLogger(new FileWriter("log/"+logName+".log"));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unable to log");
		}
	}



	/**
	 * @return the logger
	 */
	public FileWriter getLogger() {
		return logger;
	}





	/**
	 * @param session the session to set
	 */
	public void setSession(StatefulKnowledgeSession session) {
		this.session = session;
	}





	/**
	 * @return the session
	 */
	public StatefulKnowledgeSession getSession() {
		return session;
	}





	/**
	 * @param isDumpable the isDumpable to set
	 */
	public void setDumpable(boolean isDumpable) {
		this.isDumpable = isDumpable;
	}





	/**
	 * @return the isDumpable
	 */
	public boolean isDumpable() {
		return isDumpable;
	}





	/**
	 * @param dumper the dumper to set
	 */
	public void setDumper(RuleMLDumper dumper) {
		this.dumper = dumper;
	}





	/**
	 * @return the dumper
	 */
	public RuleMLDumper getDumper() {
		return dumper;
	}





	/**
	 * @param isSilent the isSilent to set
	 */
	public void setSilent(boolean isSilent) {
		this.isSilent = isSilent;
	}





	/**
	 * @return the isSilent
	 */
	public boolean isSilent() {
		return isSilent;
	}


	
	

	public FactType getFactType(String typeName) {
		return getSession().getKnowledgeBase().getFactType(this.getClass().getPackage().getName(), typeName);
	}
	
	
	
	public void setClosedWorldAssumption() {
		cwa = true;
	}
	
	public void setOpenWorldAssumption() {
		cwa = false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
