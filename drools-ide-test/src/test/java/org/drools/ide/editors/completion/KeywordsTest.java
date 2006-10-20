package org.drools.ide.editors.completion;

import junit.framework.TestCase;

import org.drools.ide.editors.Keywords;

public class KeywordsTest extends TestCase {

    public void testAll() {
        Keywords keys = Keywords.getInstance();
        String[] all = keys.getAllDroolsKeywords();
        assertTrue( all.length > 0 );
        assertEquals( "when",
                      all[0] );

    }

}
