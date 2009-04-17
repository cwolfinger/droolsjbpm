package org.drools.spi;

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

import java.util.Map;
import java.util.Set;

import org.drools.common.InternalFactHandle;
import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.EvaluationTemplate;
import org.drools.reteoo.LeftTuple;
import org.drools.rule.ContextEntry;

public interface BetaNodeFieldConstraint
    extends
    Constraint {

    public boolean isAllowedCachedLeft(ContextEntry context,
                                       InternalFactHandle handle);
    
    public Evaluation isSatisfiedCachedLeft(ContextEntry context,
            							  InternalFactHandle handle,
            							  IDegreeFactory factory);

    public boolean isAllowedCachedRight(LeftTuple tuple,
             							ContextEntry context);

    public Evaluation isSatisfiedCachedRight(LeftTuple tuple,
                                        ContextEntry context,
                                        IDegreeFactory factory);

    public ContextEntry createContextEntry();
    
    public EvaluationTemplate buildEvaluationTemplate(int id, Map<ConstraintKey, Set<String>> dependencies, IDegreeFactory factory);

}