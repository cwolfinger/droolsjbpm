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

package org.drools.verifier;

import java.util.Map;

import org.drools.PropertiesConfiguration;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;

public interface VerifierConfiguration
    extends
    PropertiesConfiguration {

    /**
     * Add external analyzing rules to verifier.
     * 
     * @param resource
     *            the Resource to add
     * @param type
     *            the resource type
     */
    Map<Resource, ResourceType> getVerifyingResources();

}
