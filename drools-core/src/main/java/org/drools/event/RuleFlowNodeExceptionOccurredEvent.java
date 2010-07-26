/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package org.drools.event;

import org.drools.runtime.process.NodeInstance;
import org.drools.runtime.process.ProcessInstance;

/**
 * @author esteban
 */
public class RuleFlowNodeExceptionOccurredEvent extends RuleFlowNodeTriggeredEvent {

    private static final long serialVersionUID = 501L;
    private final Throwable error;
    
    public RuleFlowNodeExceptionOccurredEvent(NodeInstance nodeInstance, Throwable error) {
        super(nodeInstance);
        this.error = error;
    }

    public Throwable getError() {
        return error;
    }

    @Override
    public String toString() {
        return "==>[RuleFlowExceptionOccurredEvent(error=" + error +  "; processName=" + getProcessInstance().getProcessName() + "; processId=" + getProcessInstance().getProcessId() + ")]";
    }

}
