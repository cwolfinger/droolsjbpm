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

package org.drools.ide.common.assistant;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.drools.ide.common.assistant.option.AssistantOption;
import org.drools.ide.common.assistant.option.ReplaceAssistantOption;
import org.drools.ide.common.assistant.processor.AbstractRuleAssistantProcessor;
import org.drools.ide.common.assistant.processor.DRLRefactorProcessor;

public class FixImportTest {

	private AbstractRuleAssistantProcessor ruleAssistant;
	private String rule;

    @Before
    public void setUp() throws Exception {
		ruleAssistant = new DRLRefactorProcessor();
		rule = "package com.sample\n\n" +
		"import com.sample.DroolsTest.Message;\n" +
		"rule \"Hello World\"\n" +
		"\twhen\n" +
		"\t\tm : Message( status == Message.HELLO, myMessage : message )\n" +
		"\t\tPrueba()\n" +
		"\tthen\n" +
		"\t\tSystem.out.println( myMessage );\n" +
		"\t\tm.setMessage( \"Goodbye cruel world\" );\n" +
		"\t\tm.setStatus( Message.GOODBYE );\n" +
		"\t\tupdate( m );\n" +
		"end";
	}

    @Test
    public void testFirstTest() {
		List<AssistantOption> options = ruleAssistant.getRuleAssistant(rule, 150);
		assertEquals(1, options.size());
		ReplaceAssistantOption assistantOption = (ReplaceAssistantOption) options.get(0);
	    assertEquals("\t\t$prueba : Prueba()", assistantOption.getContent());
	}

}
