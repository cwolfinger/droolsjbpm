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

import java.util.List;

import org.drools.bpmn2.xml.DataStore;

public class Definitions {
	
	private String targetNamespace;
	private List<DataStore> dataStores;

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public void setDataStores(List<DataStore> dataStores) {
		this.dataStores = dataStores;
	}
	
	public List<DataStore> getDataStores() {
		return this.dataStores;
	}

}
