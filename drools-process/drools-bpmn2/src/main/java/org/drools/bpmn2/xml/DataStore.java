/**
 * Copyright 2010 Intalio Inc
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
package org.drools.bpmn2.xml;

import org.drools.process.core.datatype.DataType;

/**
 * @author <a href="mailto:atoulme@intalio.com">Antoine Toulme</a>
 *
 */
public class DataStore {

	private String id;
	private String name;
	private DataType type;
	private String itemSubjectRef;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(DataType dataType) {
		this.type = dataType;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public DataType getType() {
		return this.type;
	}
	
	public void setItemSubjectRef(String itemSubjectRef) {
		this.itemSubjectRef = itemSubjectRef;
	}

	public String getItemSubjectRef() {
		return this.itemSubjectRef;
	}

}
