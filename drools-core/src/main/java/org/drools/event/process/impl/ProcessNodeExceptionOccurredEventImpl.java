package org.drools.event.process.impl;

import org.drools.WorkingMemory;
import org.drools.event.RuleFlowNodeExceptionOccurredEvent;
import org.drools.event.process.ProcessNodeExceptionOccurredEvent;

public class ProcessNodeExceptionOccurredEventImpl extends ProcessNodeEventImpl implements ProcessNodeExceptionOccurredEvent {

    private Throwable error;

    public ProcessNodeExceptionOccurredEventImpl(RuleFlowNodeExceptionOccurredEvent event, WorkingMemory workingMemory) {
        super(event, workingMemory);
        this.error = event.getError();
    }

    public Throwable getError() {
        return this.error;
    }

    @Override
    public String toString() {
            return "==>[ProcessNodeExceptionOccurredEventImpl: getNodeInstance()=" + getNodeInstance() + ", getProcessInstance()="
                            + getProcessInstance() + ", getKnowledgeRuntime()=" + getKnowledgeRuntime() + ", getError()= "+ getError() +"]";
    }
}
