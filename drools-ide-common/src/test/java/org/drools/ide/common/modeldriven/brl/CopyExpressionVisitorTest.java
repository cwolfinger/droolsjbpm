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

package org.drools.ide.common.modeldriven.brl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine;
import org.drools.ide.common.client.modeldriven.brl.ExpressionCollectionIndex;
import org.drools.ide.common.client.modeldriven.brl.ExpressionFormLine;
import org.drools.ide.common.client.modeldriven.brl.ExpressionMethod;
import org.drools.ide.common.client.modeldriven.brl.ExpressionPart;
import org.drools.ide.common.client.modeldriven.brl.ExpressionText;
import org.drools.ide.common.client.modeldriven.brl.ExpressionVariable;
import org.drools.ide.common.client.modeldriven.brl.FactPattern;
import org.junit.Test;

public class CopyExpressionVisitorTest {

    @Test
    public void testCopy() {
		ExpressionFormLine efl = new ExpressionFormLine();
		FactPattern fp = new FactPattern(SuggestionCompletionEngine.TYPE_OBJECT);
		fp.boundName = "$o";
		efl.appendPart(new ExpressionVariable(fp));
		ExpressionMethod em = new ExpressionMethod("aMethod", "aClass", "aType");
		
		ExpressionFormLine param = new ExpressionFormLine();
		param.appendPart(new ExpressionText("\"hello world\""));
		em.putParam("hi", param);
		
		efl.appendPart(em);
		
		
		ExpressionCollectionIndex index = new ExpressionCollectionIndex("get", "aRetType", "aGeneric");
		efl.appendPart(index);
		
		index = new ExpressionCollectionIndex("get2", "aRetType", "aGeneric");
		efl.appendPart(index);
		
		System.out.println(efl.getText());
		ExpressionFormLine copy = new ExpressionFormLine(efl);
		assertNotSame(efl, copy);
		assertEquals(efl.getText(), copy.getText());
		for (ExpressionPart e1 = efl.getRootExpression(), e2 = copy.getRootExpression(); e1 != null; e1 = e1.getNext(), e2 = e2.getNext()) {
			assertNotSame(e1, e2);
			assertEquals(e1.getClass(), e2.getClass());
		}
	}

}
