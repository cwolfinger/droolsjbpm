package org.drools.time.impl;

import org.drools.time.JobHandle;

public class ProcessJobHandle implements JobHandle {

	private long processId;
	private boolean longTermJob;
	
	public ProcessJobHandle(boolean longTermJob, long processId){
		this.processId = processId;
		this.longTermJob = longTermJob;
	}
	
	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public boolean isLongTermJob() {
		return this.longTermJob;
	}

	public void setLongTermJob(boolean longTermJob) {
		this.longTermJob = longTermJob;
	}

}
