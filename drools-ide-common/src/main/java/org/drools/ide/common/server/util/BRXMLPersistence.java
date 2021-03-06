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

package org.drools.ide.common.server.util;

import org.drools.ide.common.client.modeldriven.brl.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class persists the rule model to XML and back.
 *
 * This is the 'brl' xml format (Business Rule Language).
 *
 * @author Michael Neale
 */
public class BRXMLPersistence
    implements
    BRLPersistence {

    private XStream                     xt;
    private static final BRLPersistence INSTANCE = new BRXMLPersistence();

    protected BRXMLPersistence() {
        this.xt = new XStream( new DomDriver() );

        this.xt.alias( "rule",
                       RuleModel.class );
        this.xt.alias( "fact",
                       FactPattern.class );
        this.xt.alias( "retract",
                       ActionRetractFact.class );
        this.xt.alias( "assert",
                       ActionInsertFact.class );
        this.xt.alias( "modify",
                       ActionUpdateField.class );
        this.xt.alias( "setField",
                       ActionSetField.class );
        this.xt.alias( "dslSentence",
                       DSLSentence.class );
        this.xt.alias( "compositePattern",
                       CompositeFactPattern.class );
        this.xt.alias( "fromCompositePattern",
                       FromCompositeFactPattern.class );
        this.xt.alias( "fromCollectCompositePattern",
                       FromCollectCompositeFactPattern.class );
        this.xt.alias( "fromAccumulateCompositePattern",
                       FromAccumulateCompositeFactPattern.class );
        this.xt.alias( "metadata",
                       RuleMetadata.class );
        this.xt.alias( "attribute",
                       RuleAttribute.class );

        this.xt.alias( "fieldValue",
                       ActionFieldValue.class );
        this.xt.alias( "connectiveConstraint",
                       ConnectiveConstraint.class );
        this.xt.alias( "fieldConstraint",
                       SingleFieldConstraint.class );

        this.xt.alias( "compositeConstraint",
                       CompositeFieldConstraint.class );

        this.xt.alias( "assertLogical",
                       ActionInsertLogicalFact.class );
        this.xt.alias( "freeForm",
                       FreeFormLine.class );

        this.xt.alias( "addToGlobal",
                       ActionGlobalCollectionAdd.class );
        //Begin ExpressionFormLine
        this.xt.alias( "expression",
                ExpressionFormLine.class );
        
        this.xt.alias( "field",
                ExpressionField.class );
        
        this.xt.alias( "method",
                ExpressionMethod.class );
        
        this.xt.alias( "collection",
                ExpressionCollection.class );
        
        this.xt.alias( "collectionIndex",
                ExpressionCollectionIndex.class );
        
        this.xt.alias( "text",
                ExpressionText.class );

        this.xt.alias( "global",
                ExpressionGlobalVariable.class );
        
        this.xt.alias( "variable",
                ExpressionVariable.class );
        //end ExpressionFormLine
    }

    public static BRLPersistence getInstance() {
        return INSTANCE;
    }

    /* (non-Javadoc)
     * @see org.drools.ide.common.server.util.BRLPersistence#toXML(org.drools.guvnor.client.modeldriven.brl.RuleModel)
     */
    public String marshal(final RuleModel model) {
        return this.xt.toXML( model );
    }

    /* (non-Javadoc)
     * @see org.drools.ide.common.server.util.BRLPersistence#toModel(java.lang.String)
     */
    public RuleModel unmarshal(final String xml) {
        if ( xml == null || xml.trim().length() == 0) {
            return createEmptyModel();
        }
        RuleModel rm = (RuleModel) this.xt.fromXML( xml );
        //Fixme , hack for a upgrade to add Metadata
        if ( rm.metadataList == null ) {
            rm.metadataList = new RuleMetadata[0];
        }
        
        updateMethodCall( rm );
        
        return rm;
    }

	protected RuleModel createEmptyModel() {
		return new RuleModel();
	}

    /**
     * 
     * The way method calls are done changed after 5.0.0.CR1 so every rule done before that needs to be updated.
     * 
     * @param model
     * @return Updated model
     */
    private RuleModel updateMethodCall(RuleModel model) {

        for ( int i = 0; i < model.rhs.length; i++ ) {
            if ( model.rhs[i] instanceof ActionCallMethod ) {
                ActionCallMethod action = (ActionCallMethod) model.rhs[i];
                // Check if method name is filled, if not this was made with an older Guvnor version
                if ( action.methodName == null || "".equals( action.methodName ) ) {
                    if ( action.fieldValues != null && action.fieldValues.length >= 1 ) {
                        action.methodName = action.fieldValues[0].field;
                        
                        action.fieldValues = new ActionFieldValue[0];
                        action.state = ActionCallMethod.TYPE_DEFINED;
                    }
                }
            }
        }

        return model;
    }

}
