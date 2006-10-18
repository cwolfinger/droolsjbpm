/**
 * 
 */
package org.drools.reteoo;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * Wraps {@link EvalConditionNode} and adds visual extras like color information
 *
 */
public class EvalConditionNodeVertex extends BaseVertex {
    private final EvalConditionNode node;

    /**
     * Constructor
     * 
     * @param node node to be wrapped
     */
    public EvalConditionNodeVertex(final EvalConditionNode node) {
        super();
        this.node = node;
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNodeVertex#getHtml()
     */
    public String getHtml() {
        return "EvalConditionNode : " + this.node.getId();
    }

    /* (non-Javadoc)
     * @see org.drools.ide.editors.rete.model.BaseVertex#toString()
     */
    public String toString() {
        return "EvalConditionNode";
    }

    /**
     * Node ID
     * 
     * @return node id
     */
    public int getId() {
        return node.getId();
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNodeVertex#getFillColor()
     */
    public Color getFillColor() {
        return ColorConstants.white;
    }
}