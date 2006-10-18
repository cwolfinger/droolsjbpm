/**
 * 
 */
package org.drools.reteoo;

import org.drools.spi.FieldConstraint;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * Wraps {@link JoinNode} and adds visual extras like color information
 *
 */
public class JoinNodeVertex extends BaseVertex {
    private final JoinNode node;

    /**
     * Constructor
     * 
     * @param node node to be wrapped
     */
    public JoinNodeVertex(final JoinNode node) {
        super();
        this.node = node;
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNodeVertex#getHtml()
     */
    public String getHtml() {
        return "JoinNode<br> " + dumpConstraints( this.node.getConstraints() );
    }

    /* (non-Javadoc)
     * @see org.drools.ide.editors.rete.model.BaseVertex#toString()
     */
    public String toString() {
        return "JoinNode";
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNodeVertex#getFillColor()
     */
    public Color getFillColor() {
        return ColorConstants.green;
    }

    /**
     * Node constraints
     * 
     * @return array of constraints
     */
    public FieldConstraint[] getConstraints() {
        return node.getConstraints();
    }

    /**
     * Node ID
     * 
     * @return node id
     */
    public int getId() {
        return node.getId();
    }

}