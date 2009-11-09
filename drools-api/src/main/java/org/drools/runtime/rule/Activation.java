package org.drools.runtime.rule;

import java.util.Collection;

import org.drools.definition.rule.Rule;

public interface Activation {
    /**
     * 
     * @return
     *     The Rule that was activated.
     */
    Rule getRule();

    /**
     * 
     * @return 
     *     The PropagationContext that created this Activation
     */
    PropagationContext getPropagationContext();

    /**
     * 
     * @return
     *     The matched FactHandles for this activation
     */
    Collection< ? extends FactHandle> getFactHandles();
 
    /**
     * Returns true if this activation was created by a temporal
     * tuple
     * 
     * @return
     */
    boolean isTemporal();
    
    /**
     * Returns the effective timestamp for this activation if it
     * is a temporal activation.
     * 
     * @return
     */
    long getStartTimestamp();

    /**
     * Returns the end timestamp for this activation if it
     * is a temporal activation.
     * 
     * @return
     */
    long getEndTimestamp();
}
