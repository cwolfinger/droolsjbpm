package org.drools.spring.core.aspects;

import org.drools.WorkingMemory;
import org.springframework.transaction.support.ResourceHolderSupport;

public class WorkingMemoryHolder extends ResourceHolderSupport {
	
	private final WorkingMemory workingMemory;
	
	public WorkingMemoryHolder(WorkingMemory workingMemory) {
		this.workingMemory = workingMemory;
	}
	
	public WorkingMemory getWorkingMemory() {
		return workingMemory;
	}

}
