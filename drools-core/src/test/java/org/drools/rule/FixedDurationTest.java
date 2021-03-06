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

package org.drools.rule;

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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FixedDurationTest {
    @Test
    public void testConstruct() throws Exception {
        FixedDuration dur = new FixedDuration();

        assertEquals( 0,
                      dur.getDuration( null ) );

        dur = new FixedDuration( 42000 );

        assertEquals( 42000,
                      dur.getDuration( null ) );
    }

    @Test
    public void testAdd() throws Exception {
        final FixedDuration dur = new FixedDuration();

        assertEquals( 0,
                      dur.getDuration( null ) );

        dur.addSeconds( 42 );

        assertEquals( 42000,
                      dur.getDuration( null ) );

        dur.addMinutes( 2 );

        assertEquals( 162000,
                      dur.getDuration( null ) );

        dur.addHours( 2 );

        assertEquals( 7362000,
                      dur.getDuration( null ) );

        dur.addDays( 2 );

        assertEquals( 180162000,
                      dur.getDuration( null ) );

        dur.addWeeks( 2 );

        assertEquals( 1389762000,
                      dur.getDuration( null ) );
    }
}
