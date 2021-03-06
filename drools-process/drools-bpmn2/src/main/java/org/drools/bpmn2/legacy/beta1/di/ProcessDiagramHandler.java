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

package org.drools.bpmn2.legacy.beta1.di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.drools.bpmn2.core.Definitions;
import org.drools.bpmn2.legacy.beta1.XmlBPMNProcessDumper;
import org.drools.bpmn2.legacy.beta1.di.SequenceFlowConnectorHandler.ConnectionInfo;
import org.drools.bpmn2.legacy.beta1.di.ShapeHandler.NodeInfo;
import org.drools.compiler.xml.ProcessBuildData;
import org.drools.definition.process.Connection;
import org.drools.definition.process.Node;
import org.drools.ruleflow.core.RuleFlowProcess;
import org.drools.workflow.core.impl.ConnectionImpl;
import org.drools.xml.BaseAbstractHandler;
import org.drools.xml.ExtensibleXmlParser;
import org.drools.xml.Handler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ProcessDiagramHandler extends BaseAbstractHandler implements Handler {

    public ProcessDiagramHandler() {
        initValidParents();
        initValidPeers();
        this.allowNesting = false;
    }
    
    protected void initValidParents() {
        this.validParents = new HashSet<Class<?>>();
        this.validParents.add(Definitions.class);
    }
    
    protected void initValidPeers() {
        this.validPeers = new HashSet<Class<?>>();
        this.validPeers.add(org.drools.definition.process.Process.class);
    }
    
    public Object start(final String uri, final String localName,
                        final Attributes attrs, final ExtensibleXmlParser parser)
            throws SAXException {
        parser.startElementBuilder(localName, attrs);

        final String processRef = attrs.getValue("processRef");
        ProcessInfo info = new ProcessInfo(processRef);
        return info;
    }

    public Object end(final String uri, final String localName,
                      final ExtensibleXmlParser parser) throws SAXException {
        parser.endElementBuilder();
        ProcessInfo processInfo = (ProcessInfo) parser.getCurrent();
        RuleFlowProcess process = (RuleFlowProcess)
            ((ProcessBuildData) parser.getData()).getProcess();
        for (NodeInfo nodeInfo: processInfo.getNodeInfos().values()) {
            boolean found = false;
            for (Node node: process.getNodes()) {
                String id = XmlBPMNProcessDumper.getUniqueNodeId(node);
                if (nodeInfo.getNodeRef().equals(id)) {
                    found = true;
                    ((org.drools.workflow.core.Node) node).setMetaData("x", nodeInfo.getX());
                    ((org.drools.workflow.core.Node) node).setMetaData("y", nodeInfo.getY());
                    ((org.drools.workflow.core.Node) node).setMetaData("width", nodeInfo.getWidth());
                    ((org.drools.workflow.core.Node) node).setMetaData("height", nodeInfo.getHeight());
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException(
                    "Could not find node " + nodeInfo.getNodeRef());
            }
        }
        for (ConnectionInfo connectionInfo: processInfo.getConnectionInfos()) {
            if (connectionInfo.getBendpoints() != null) {
                NodeInfo sourceNodeInfo = processInfo.getNodeInfo(connectionInfo.getSourceRef());
                if (sourceNodeInfo == null) {
                    throw new IllegalArgumentException(
                        "Could not find sourceRef for connection info: " + connectionInfo.getSourceRef());
                }
                NodeInfo targetNodeInfo = processInfo.getNodeInfo(connectionInfo.getTargetRef());
                if (targetNodeInfo == null) {
                    throw new IllegalArgumentException(
                        "Could not find sourceRef for connection info: " + connectionInfo.getTargetRef());
                }
                Node sourceNode = null;
                for (Node node: process.getNodes()) {
                    String id = (String) XmlBPMNProcessDumper.getUniqueNodeId(node);
                    if (sourceNodeInfo.getNodeRef().equals(id)) {
                        sourceNode = node;
                        break;
                    }
                }
                if (sourceNode == null) {
                    throw new IllegalArgumentException(
                        "Could not find node for nodeRef: " + sourceNodeInfo.getNodeRef());
                }
                boolean found = false;
                for (List<Connection> outgoingConnections: sourceNode.getOutgoingConnections().values()) {
                    for (Connection connection: outgoingConnections) {
                        if (targetNodeInfo.getNodeRef().equals(XmlBPMNProcessDumper.getUniqueNodeId(connection.getTo()))) {
                            ((ConnectionImpl) connection).setMetaData(
                                "bendpoints", connectionInfo.getBendpoints());
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException(
                        "Could not find connection from  " + sourceNodeInfo.getNodeRef() + 
                        " to " + targetNodeInfo.getNodeRef());
                }
            }
        }
        return processInfo;
    }

    public Class<?> generateNodeFor() {
        return ProcessInfo.class;
    }
    
    public static class ProcessInfo {
        
        private String processRef;
        private Map<String, NodeInfo> nodeInfos = new HashMap<String, NodeInfo>();
        private List<ConnectionInfo> connectionInfos = new ArrayList<ConnectionInfo>();

        public ProcessInfo(String processRef) {
            this.processRef = processRef;
        }
        
        public String getProcessRef() {
            return processRef;
        }
        
        public void addNodeInfo(NodeInfo nodeInfo) {
            this.nodeInfos.put(nodeInfo.getId(), nodeInfo);
        }
        
        public Map<String, NodeInfo> getNodeInfos() {
            return nodeInfos;
        }
        
        public NodeInfo getNodeInfo(String nodeRef) {
            return nodeInfos.get(nodeRef);
        }
        
        public void addConnectionInfo(ConnectionInfo connectionInfo) {
            connectionInfos.add(connectionInfo);
        }
        
        public List<ConnectionInfo> getConnectionInfos() {
            return connectionInfos;
        }
        
    }

}