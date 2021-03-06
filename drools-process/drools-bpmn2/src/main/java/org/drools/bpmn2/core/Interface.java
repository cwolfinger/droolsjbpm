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

package org.drools.bpmn2.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Interface implements Serializable {
    
	private static final long serialVersionUID = 510l;
	
    private String id;
    private String name;
    private Map<String, Operation> operations = new HashMap<String, Operation>();
    
    public Interface(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Operation addOperation(String id, String name) {
        Operation operation = new Operation(id, name);
        operations.put(id, operation);
        return operation;
    }
    
    public Operation getOperation(String name) {
        return operations.get(name);
    }
    
    public class Operation {
        private String id;
        private String name;
        private Message message;
        public Operation(String id, String name) {
            this.id = id;
            this.name = name;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Message getMessage() {
            return message;
        }
        public void setMessage(Message message) {
            this.message = message;
        }
        public Interface getInterface() {
            return Interface.this;
        }
    }

}
