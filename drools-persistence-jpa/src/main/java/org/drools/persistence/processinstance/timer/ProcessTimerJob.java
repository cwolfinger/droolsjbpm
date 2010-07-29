package org.drools.persistence.processinstance.timer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.drools.process.instance.timer.TimerInstance;

@Entity
public class ProcessTimerJob {

	private long id;
	private int sessionId;
	private long processId;
	private long initialTime;
	private long period;
	private long delay;
	private TimerInstance timerInstance;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public TimerInstance getTimerInstance() {
		return timerInstance;
	}

	public void setTimerInstance(TimerInstance timerInstance) {
		this.timerInstance = timerInstance;
	}

}
