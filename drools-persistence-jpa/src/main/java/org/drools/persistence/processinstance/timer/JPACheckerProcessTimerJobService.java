package org.drools.persistence.processinstance.timer;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.drools.KnowledgeBase;
import org.drools.command.impl.CommandBasedStatefulKnowledgeSession;
import org.drools.command.impl.KnowledgeCommandContext;
import org.drools.impl.EnvironmentFactory;
import org.drools.impl.StatefulKnowledgeSessionImpl;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.process.instance.event.SignalManager;
import org.drools.process.instance.timer.TimerInstance;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.time.ProcessJobTriggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bitronix.tm.TransactionManagerServices;

public class JPACheckerProcessTimerJobService implements
		ProcessJobTriggerService{

	private final class CheckExternalTimers implements Runnable {
		public void run() {
			while(isRunning()){
				logger.debug("checking queued jobs");
				try {
					for (ProcessTimerJob processJob : getProcessTimerJobs()) {
						if(shouldExecuteJob(processJob)){
							logger.debug("executing job");
							executeJob(processJob);
						}
					}
					Thread.sleep(getPoolingTime());
				} catch (InterruptedException e) {
					setRunning(false);
				}
			}
			logger.info("external timer checker stopped");
		}
	}

	private static Logger logger = LoggerFactory.getLogger(JPACheckerProcessTimerJobService.class);
	private static final long DEFAULT_POOLING_TIME = 1000;
	
	private EntityManagerFactory entityManagerFactory;
	private KnowledgeBase kbase;
	private int sessionId;
	private AtomicBoolean running = new AtomicBoolean(false);
	private long poolingTime = DEFAULT_POOLING_TIME;
	
	public JPACheckerProcessTimerJobService(int sessionId, KnowledgeBase kbase) {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("org.drools.persistence.jpa");
		this.sessionId = sessionId;
		this.kbase = kbase;
	}

	public void start() {
		logger.info("Starting external timer checker");
		if(!isRunning()){
			setRunning(true);
			new Thread(new CheckExternalTimers(), "checker").start();
		}
	}
	
	public void startSynchronously(){
		setRunning(true);
		new CheckExternalTimers().run();
	}

	private void executeJob(ProcessTimerJob processJob) {
		//StatefulKnowledgeSessionImpl sessionImpl = (StatefulKnowledgeSessionImpl) this.ksession;
		Environment environment = EnvironmentFactory.newEnvironment();
		environment.set(EnvironmentName.ENTITY_MANAGER_FACTORY, Persistence.createEntityManagerFactory("org.drools.persistence.jpa"));
		environment.set(EnvironmentName.TRANSACTION_MANAGER, TransactionManagerServices.getTransactionManager());

		StatefulKnowledgeSession ksession = JPAKnowledgeService.loadStatefulKnowledgeSession(sessionId, kbase, null, environment);
		StatefulKnowledgeSessionImpl sessionImpl = (StatefulKnowledgeSessionImpl) ((KnowledgeCommandContext) ((CommandBasedStatefulKnowledgeSession)ksession).getCommandService().getContext()).getStatefulKnowledgesession();
        SignalManager signalManager = sessionImpl.getInternalWorkingMemory().getSignalManager();
		TimerInstance timerInstance = processJob.getTimerInstance();
		signalManager.signalEvent( processJob.getProcessId(), "timerTriggered",  timerInstance );
		ksession.dispose();
	}

	private boolean shouldExecuteJob(ProcessTimerJob processJob) {
		return true;
	}

	public void stop() {
		logger.info("stoping external timer checker");
		setRunning(false);
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public long getPoolingTime() {
		return poolingTime;
	}

	public void setPoolingTime(long poolingTime) {
		this.poolingTime = poolingTime;
	}

	private boolean isRunning() {
		return running.get();
	}

	private void setRunning(boolean running) {
		this.running.set(running);
	}
	
	@SuppressWarnings("unchecked")
	private List<ProcessTimerJob> getProcessTimerJobs(){
		return getEntityManager().createQuery("from ProcessTimerJob").getResultList();
	}
}
