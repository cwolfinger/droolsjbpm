package org.drools.persistence.processinstance.timer;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

import junit.framework.TestCase;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.Message;
import org.drools.base.MapGlobalResolver;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.impl.EnvironmentFactory;
import org.drools.io.ResourceFactory;
import org.drools.io.impl.ClassPathResource;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.persistence.session.TestWorkItemHandler;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.junit.Assert;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;

public class JPAPersistentTimerServiceTest extends TestCase{

	private EntityManagerFactory emf;
    private PoolingDataSource ds1;
	
	protected void setUp() {
		startDataSource();
		emf = Persistence.createEntityManagerFactory("org.drools.persistence.jpa");
	}

	private void startDataSource() {
		ds1 = new PoolingDataSource();
        ds1.setUniqueName("jdbc/testDS1");
        ds1.setClassName( "org.h2.jdbcx.JdbcDataSource" );
        ds1.setMaxPoolSize( 3 );
        ds1.setAllowLocalTransactions( true );
        ds1.getDriverProperties().put( "user",
                                       "sa" );
        ds1.getDriverProperties().put( "password",
                                       "sasa" );
        ds1.getDriverProperties().put( "URL",
                                       "jdbc:h2:mem:mydb" );
        ds1.init();
	}

	protected void tearDown() {
		emf.close();
		ds1.close();
	}
	
	public void testProcessTimerPersisted() throws Exception{
		EntityManager entityManager = emf.createEntityManager();
        KnowledgeBase kbase = getKnowledgeBase();
		StatefulKnowledgeSession ksession = createKnowledgeSession(kbase);

        assertTrue("timers queued at begin", entityManager.createQuery("from ProcessTimerJob").getResultList().isEmpty());
        ksession.setGlobal("myList", new ArrayList<Message>());
        ksession.startProcess("com.plugtree.timer");
        ProcessTimerJob uniquePersistedTimer = null;
        try{
        	uniquePersistedTimer = (ProcessTimerJob) entityManager.createQuery("from ProcessTimerJob").getSingleResult();
        } catch (NoResultException nre){
        	fail("no timer persisted");
        }
        
        assertNotNull("timer id not persisted", uniquePersistedTimer.getTimerInstance());

        ksession.dispose();
	}
	
	public void testTimerTriggered() throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.drools.persistence.jpa");

		EntityManager entityManager = emf.createEntityManager();
        KnowledgeBase kbase = getKnowledgeBase();
		StatefulKnowledgeSession ksession = createKnowledgeSession(kbase);

		JPACheckerProcessTimerJobService jpaTimerChecker = new JPACheckerProcessTimerJobService(ksession.getId(), kbase);
        jpaTimerChecker.start();

        List<Message> myList = new ArrayList<Message>();
        ksession.setGlobal("myList", myList);
        ProcessInstance processInstance = ksession.startProcess("com.plugtree.timer");
        Assert.assertEquals(0, myList.size());
        Assert.assertEquals(ProcessInstance.STATE_ACTIVE, processInstance.getState());

        ProcessTimerJob uniquePersistedTimer = null;
        try{
        	uniquePersistedTimer = (ProcessTimerJob) entityManager.createQuery("from ProcessTimerJob").getSingleResult();
        } catch (NoResultException nre){
        	fail("no timer persisted");
        }
        Thread.sleep(6000);

        Assert.assertEquals(5, myList.size());
        ksession.dispose();
        jpaTimerChecker.stop();
	}
	
	

	private StatefulKnowledgeSession createKnowledgeSession(KnowledgeBase kbase) {
		Environment environment = EnvironmentFactory.newEnvironment();
		environment.set(EnvironmentName.ENTITY_MANAGER_FACTORY, Persistence.createEntityManagerFactory("org.drools.persistence.jpa"));
		environment.set(EnvironmentName.TRANSACTION_MANAGER, TransactionManagerServices.getTransactionManager());
		environment.set(EnvironmentName.PROCESS_TIMER_STRATEGY, new JPAProcessTimerPersistenceStrategy(emf));

        StatefulKnowledgeSession ksession = JPAKnowledgeService.newStatefulKnowledgeSession(kbase, null, environment);
        //StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession(null, environment);
		return ksession;
	}

	private KnowledgeBase getKnowledgeBase() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add(ResourceFactory.newClassPathResource("simpleTimer.rf"), ResourceType.DRF);
        if (kbuilder.hasErrors()) {
        	StringBuilder builder = new StringBuilder();
        	for (KnowledgeBuilderError error : kbuilder.getErrors()) {
				builder.append(error.getMessage()+"\n");
			}
            fail(builder.toString());
        }
        
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
	
    public void testPersistenceTimer() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( new ClassPathResource( "TimerProcess.rf" ),
                      ResourceType.DRF );
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "org.drools.persistence.jpa" );
        
        Environment env = KnowledgeBaseFactory.newEnvironment();
        env.set( EnvironmentName.ENTITY_MANAGER_FACTORY, emf );
        env.set( EnvironmentName.GLOBALS, new MapGlobalResolver() );
        env.set(EnvironmentName.PROCESS_TIMER_STRATEGY, new JPAProcessTimerPersistenceStrategy(emf));
        env.set(EnvironmentName.TRANSACTION_MANAGER, TransactionManagerServices.getTransactionManager());


        StatefulKnowledgeSession ksession = JPAKnowledgeService.newStatefulKnowledgeSession( kbase, null, env );
        int id = ksession.getId();
        ksession.dispose();
        
		JPACheckerProcessTimerJobService jpaTimerChecker = new JPACheckerProcessTimerJobService(id, kbase);
        jpaTimerChecker.start();
        
        ksession = JPAKnowledgeService.loadStatefulKnowledgeSession( id, kbase, null, env );
        ProcessInstance processInstance = ksession.startProcess( "org.drools.test.TestProcess" );
        ksession.dispose();

        assertNotNull(TestWorkItemHandler.getInstance().getWorkItem());
        
        Thread.sleep(5000);
        
        ksession = JPAKnowledgeService.loadStatefulKnowledgeSession( id, kbase, null, env );
        processInstance = ksession.getProcessInstance( processInstance.getId() );
        assertNull( processInstance );
        jpaTimerChecker.stop();
    }

}
