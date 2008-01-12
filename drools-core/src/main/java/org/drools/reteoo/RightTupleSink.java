package org.drools.reteoo;

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

import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.spi.PropagationContext;

/**
 * Receiver of propagated <code>FactHandleImpl</code>s from a
 * <code>ObjectSource</code>.
 * 
 * @see ObectSource
 * 
 * @author <a href="mailto:mark.proctor@jboss.com">Mark Proctor</a>
 * @author <a href="mailto:bob@werken.com">Bob McWhirter</a>
 *
 */
public interface RightTupleSink
    extends
    Sink {

    /**
     * Assert a new <code>FactHandleImpl</code>.
     * 
     * @param rightTuple
     *            The asserted <code>FactHandle/code>.
     * @param context
     *             The <code>PropagationContext</code> of the <code>WorkingMemory<code> action.           
     * @param workingMemory
     *            the <code>WorkingMemory</code> session.
     */
    void assertRightTuple(InternalFactHandle handle,
                          PropagationContext context,
                          InternalWorkingMemory workingMemory);

    /**
     * Retract an existing <code>FactHandleImpl</code>.
     * 
     * @param rightTuple
     *            The <code>FactHandle/code> to retract.
     * @param context
     *             The <code>PropagationContext</code> of the <code>WorkingMemory<code> action.           
     * @param workingMemory
     *            the <code>WorkingMemory</code> session.
     */
    void retractRightTuple(RightTuple rightTuple,
                           PropagationContext context,
                           InternalWorkingMemory workingMemory);

}
