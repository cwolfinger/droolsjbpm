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

package org.drools.bpmn2.legacy.beta1;

import java.util.List;

import org.drools.bpmn2.core.Interface;
import org.drools.bpmn2.core.Interface.Operation;
import org.drools.compiler.xml.ProcessBuildData;
import org.drools.workflow.core.Node;
import org.drools.workflow.core.node.WorkItemNode;
import org.drools.xml.ExtensibleXmlParser;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ServiceTaskHandler extends TaskHandler {
    
    protected Node createNode(Attributes attrs) {
        return new WorkItemNode();
    }
    
    @SuppressWarnings("unchecked")
	public Class generateNodeFor() {
        return Node.class;
    }
    
    @SuppressWarnings("unchecked")
    protected void handleNode(final Node node, final Element element, final String uri, 
            final String localName, final ExtensibleXmlParser parser) throws SAXException {
        super.handleNode(node, element, uri, localName, parser);
        WorkItemNode workItemNode = (WorkItemNode) node;
        String operationRef = element.getAttribute("operationRef");
        List<Interface> interfaces = (List<Interface>)
            ((ProcessBuildData) parser.getData()).getMetaData("Interfaces");
        if (interfaces == null) {
            throw new IllegalArgumentException("No interfaces found");
        }
        Operation operation = null;
        for (Interface i: interfaces) {
            operation = i.getOperation(operationRef);
            if (operation != null) {
                break;
            }
        }
        if (operation == null) {
            throw new IllegalArgumentException("Could not find operation " + operationRef);
        }
        workItemNode.getWork().setParameter("Interface", operation.getInterface().getName());
        workItemNode.getWork().setParameter("Operation", operation.getName());
        workItemNode.getWork().setParameter("ParameterType", operation.getMessage().getType());
    }
    
    protected String getTaskName(final Element element) {
        return "Service Task";
    }
    
    public void writeNode(Node node, StringBuilder xmlDump, boolean includeMeta) {
        throw new IllegalArgumentException("Writing out should be handled by TaskHandler");
    }
    
}
