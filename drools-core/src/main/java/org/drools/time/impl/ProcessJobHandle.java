package org.drools.time.impl;

import org.drools.time.JobHandle;

public class ProcessJobHandle implements JobHandle {

	private long processId;
	
	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

}
