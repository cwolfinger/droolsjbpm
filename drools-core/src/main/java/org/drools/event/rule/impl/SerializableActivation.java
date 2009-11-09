package org.drools.event.rule.impl;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;

import org.drools.definition.rule.Rule;
import org.drools.runtime.rule.Activation;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.PropagationContext;

public class SerializableActivation
    implements
    Activation,
    Externalizable {
    private Rule                              rule;
    private Collection< ? extends FactHandle> factHandles;
    private PropagationContext                propgationContext;
    private boolean                           temporal;
    private long                              startTimestamp;
    private long                              endTimestamp;

    public SerializableActivation() {

    }

    public SerializableActivation(Activation activation) {
        this.rule = activation.getRule();
        this.factHandles = activation.getFactHandles();
        this.propgationContext = activation.getPropagationContext();
        this.temporal = activation.isTemporal();
        this.startTimestamp = activation.getStartTimestamp();
        this.endTimestamp = activation.getEndTimestamp();
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
    }

    public void writeExternal(ObjectOutput out) throws IOException {
    }

    public Rule getRule() {
        return this.rule;
    }

    public Collection< ? extends FactHandle> getFactHandles() {
        return this.factHandles;
    }

    public PropagationContext getPropagationContext() {
        return this.propgationContext;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public boolean isTemporal() {
        return temporal;
    }
}
