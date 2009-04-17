/*
 * Created on 11/giu/07
 *
 */
package org.drools.degrees.operators;

import java.util.Collection;

import org.drools.degrees.IDegree;


/**
 * Strategy interface
 * 
 * Generically combines generic truth values
 * 
 * @author Sotty
 *
 */
public interface IDegreeCombiner {
    
    /**
     * Combination
     * 
     * @param args  The truth values to be combined
     * @return      The output combination
     */
    public IDegree eval(IDegree[] args);
    
 
    public IDegree eval(Collection<? extends IDegree> args);
    
    public String getName();
    
}
