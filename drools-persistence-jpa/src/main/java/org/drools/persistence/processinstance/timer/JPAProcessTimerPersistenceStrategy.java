package org.drools.persistence.processinstance.timer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.drools.process.instance.timer.TimerManager.ProcessJobContext;
import org.drools.time.ProcessTimerPersistenceStrategy;
import org.drools.time.impl.IntervalTrigger;
import org.drools.time.impl.ProcessJobHandle;

public class JPAProcessTimerPersistenceStrategy implements
		ProcessTimerPersistenceStrategy {

	private EntityManagerFactory entityManagerFactory;

	public JPAProcessTimerPersistenceStrategy(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}

	public void save(ProcessJobContext processContext, IntervalTrigger intervalTrigger) {
		ProcessTimerJob timerJob = new ProcessTimerJob();
		timerJob.setProcessId(processContext.getProcessInstanceId());
		timerJob.setInitialTime(intervalTrigger.getStartTime().getTime());
		timerJob.setPeriod(intervalTrigger.getPeriod());
		timerJob.setDelay(intervalTrigger.getDelay());
		timerJob.setTimerInstance(processContext.getTimer());

		getEntityManager().persist(timerJob);
	}

	public boolean remove(ProcessJobHandle jobHandle) {
		return getEntityManager().createQuery("delete ProcessTimerJob where processId=:processId")
		.setParameter("processId", jobHandle.getProcessId())
		.executeUpdate() == 1;
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
