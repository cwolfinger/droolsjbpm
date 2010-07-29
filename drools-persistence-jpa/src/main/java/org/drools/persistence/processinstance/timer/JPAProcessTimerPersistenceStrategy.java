package org.drools.persistence.processinstance.timer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.drools.common.AbstractWorkingMemory;
import org.drools.process.instance.timer.TimerInstance;
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
		EntityManager entityManager = getEntityManager();
		TimerInstance timerInstance = processContext.getTimer();
		long processInstanceId = processContext.getProcessInstanceId();

		try{
			entityManager
				.createQuery("from ProcessTimerJob as ptj where ptj.processId = :processId and ptj.timerInstance.id = :timerInstanceId")
				.setParameter("processId", processInstanceId)
				.setParameter("timerInstanceId", timerInstance.getId())
			.getSingleResult();
		}catch(NoResultException nre){
			ProcessTimerJob timerJob = new ProcessTimerJob();
			int sessionId = ((AbstractWorkingMemory)processContext.getWorkingMemory()).getId();
			timerJob.setSessionId(sessionId);
			timerJob.setProcessId(processInstanceId);
			timerJob.setInitialTime(intervalTrigger.getStartTime().getTime());
			timerJob.setPeriod(intervalTrigger.getPeriod());
			timerJob.setDelay(intervalTrigger.getDelay());
			timerJob.setTimerInstance(timerInstance);
	
			entityManager.persist(timerJob);
		}
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
