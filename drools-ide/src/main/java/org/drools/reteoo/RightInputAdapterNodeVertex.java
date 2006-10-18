/**
 * 
 */
package org.drools.reteoo;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * Wraps {@link RightInputAdapterNode} and adds visual extras like color information
 *
 */
public class RightInputAdapterNodeVertex extends BaseVertex {
    
    private final RightInputAdapterNode node;

    /**
     * Constructor
     * 
     * @param node node to be wrapped
     */
    public RightInputAdapterNodeVertex(final RightInputAdapterNode node) {
        super();
        this.node = node;
    }

    public String getHtml() {
        return "RightInputAdapterNode";
    }

    public String toString() {
        return "RightInputAdapterNode";
    }

    public Color getFillColor() {
        return ColorConstants.orange;
    }

}