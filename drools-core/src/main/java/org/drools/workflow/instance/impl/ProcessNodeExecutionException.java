package org.drools.workflow.instance.impl;

/**
 * Exception thrown when an unexpected Exception occurs while executing
 * a node inside a process.
 * @author esteban
 */
public class ProcessNodeExecutionException extends RuntimeException{

    public ProcessNodeExecutionException(Throwable cause) {
        super(cause);
    }

}
