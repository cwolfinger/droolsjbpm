/**
 * 
 */
package org.drools.reteoo;

import org.drools.spi.FieldConstraint;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * Wraps {@link LeftInputAdapterNode} and adds visual extras like color information
 *
 */
public class LeftInputAdapterNodeVertex extends BaseVertex {
    private final LeftInputAdapterNode node;

    /**
     * Constructor
     * 
     * @param node node to be wrapped
     */
    public LeftInputAdapterNodeVertex(final LeftInputAdapterNode node) {
        super();
        this.node = node;
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNodeVertex#getHtml()
     */
    public String getHtml() {
        return "LeftInputAdapterNode<br>" + dumpConstraints( this.node.getConstraints() );
    }

    /* (non-Javadoc)
     * @see org.drools.ide.editors.rete.model.BaseVertex#toString()
     */
    public String toString() {
        return this.node.toString();
    }

    /* (non-Javadoc)
     * @see org.drools.reteoo.BaseNodeVertex#getFillColor()
     */
    public Color getFillColor() {
        return ColorConstants.yellow;
    }

    /**
     * Node constraints
     * 
     * @return array of node constraints
     */
    public FieldConstraint[] getConstraints() {
        return node.getConstraints();
    }
}