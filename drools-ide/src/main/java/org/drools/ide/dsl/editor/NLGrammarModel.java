package org.drools.ide.dsl.editor;

import java.util.HashSet;
import java.util.Set;

import org.drools.lang.dsl.DefaultDSLMapping;

/**
 * This extends the compilers DSL grammar implementation to provide
 * change listener support.
 * 
 * @author Michael Neale
 *
 */
public class NLGrammarModel extends DefaultDSLMapping {
    
    private static final long serialVersionUID = 5449029738300794120L;
    
    private Set changeListeners = new HashSet();

    /**
     * @param viewer
     */
    public void removeChangeListener(IMappingListViewer viewer) {
        changeListeners.remove(viewer);
    }

    /**
     * @param viewer
     */
    public void addChangeListener(IMappingListViewer viewer) {
        changeListeners.add(viewer);
    }
    
}
