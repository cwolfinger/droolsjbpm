/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.eclipse.flow.ruleflow.editor.editpart;
/*
 * Copyright 2005 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.drools.eclipse.DroolsEclipsePlugin;
import org.drools.eclipse.flow.common.editor.editpart.ElementEditPart;
import org.drools.eclipse.flow.common.editor.editpart.figure.AbstractElementFigure;
import org.drools.eclipse.flow.ruleflow.core.SubProcessWrapper;
import org.drools.eclipse.flow.ruleflow.skin.SkinManager;
import org.drools.eclipse.flow.ruleflow.skin.SkinProvider;
import org.drools.eclipse.preferences.IDroolsConstants;
import org.eclipse.core.resources.IResource;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jdt.internal.debug.ui.actions.OpenTypeAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * EditPart for a SubFlow node.
 * 
 * @author <a href="mailto:kris_verlaenen@hotmail.com">Kris Verlaenen</a>
 */
public class SubFlowEditPart extends ElementEditPart {

	private String SKIN =
		DroolsEclipsePlugin.getDefault().getPreferenceStore().getString(IDroolsConstants.SKIN);
	
    private static final Color color = new Color(Display.getCurrent(), 255, 250, 205);
    
    protected IFigure createFigure() {
    	SkinProvider skinProvider = SkinManager.getInstance().getSkinProvider(SKIN);
    	IFigure result = skinProvider.createSubFlowFigure();
    	Rectangle constraint = getElementWrapper().getConstraint();
    	if (constraint.width == -1) {
    		constraint.width = result.getSize().width;
    	}
    	if (constraint.height == -1) {
    		constraint.height = result.getSize().height;
    	}
    	getElementWrapper().setConstraint(constraint);
    	return result;
    }
    
    protected void doubleClicked() {
        super.doubleClicked();
        String processId = ((SubProcessWrapper) getElementWrapper()).getSubProcessNode().getProcessId();
    	IResource resource = DroolsEclipsePlugin.getDefault().findProcessResource(processId);
    	if (resource != null) {
    		try {
    			OpenTypeAction.findTypeInWorkspace(resource.getFullPath().toString());
    		} catch (Throwable t) {
    			DroolsEclipsePlugin.log(t);
    		}
    	}
    }
    
    public static class SubFlowNodeFigure extends AbstractElementFigure {
        
        private static final Image ICON = ImageDescriptor.createFromURL(
        		DroolsEclipsePlugin.getDefault().getBundle().getEntry("icons/process.gif")).createImage();
                
        private RoundedRectangle rectangle;
        
        protected void customizeFigure() {
            rectangle = new RoundedRectangle();
            rectangle.setCornerDimensions(new Dimension(25, 25));
            add(rectangle, 0);
            rectangle.setBackgroundColor(color);
            rectangle.setBounds(getBounds());
            setSelected(false);
            setIcon(ICON);
        }
        
        public void setBounds(Rectangle rectangle) {
            super.setBounds(rectangle);
            this.rectangle.setBounds(rectangle);
        }
        
        public void setSelected(boolean b) {
            super.setSelected(b);
            rectangle.setLineWidth(b ? 3 : 1);
            repaint();
        }
    }
}
