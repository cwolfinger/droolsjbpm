package org.drools.workflow.instance.impl;

/**
 * Wrapper of a RuntimeException. This exception means that the original
 * RuntieException was already managed.
 * @author esteban
 */
public class ManagedRuntimeException extends RuntimeException{

    public ManagedRuntimeException(Throwable cause) {
        super(cause);
    }

}
