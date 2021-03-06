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

package org.drools.osworkflow.xml;

import java.util.HashSet;

import org.drools.osworkflow.core.OSWorkflowProcess;
import org.drools.xml.BaseAbstractHandler;
import org.drools.xml.ExtensibleXmlParser;
import org.drools.xml.Handler;
import org.drools.xml.ProcessBuildData;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ProcessHandler extends BaseAbstractHandler implements Handler {
    
    public ProcessHandler() {
        if ( (this.validParents == null) && (this.validPeers == null) ) {
            this.validParents = new HashSet();
            this.validParents.add( null );

            this.validPeers = new HashSet();
            this.validPeers.add( null );

            this.allowNesting = false;
        }
    }
    
    public Object start(final String uri,
                        final String localName,
                        final Attributes attrs,
                        final ExtensibleXmlParser parser) throws SAXException {
        parser.startElementBuilder( localName,
                                    attrs );
        
        final String id = attrs.getValue( "id" );
        final String name = attrs.getValue( "name" );
        final String version = attrs.getValue( "version" );
        final String type = attrs.getValue( "type" );
        final String packageName = attrs.getValue( "package-name" );
        final String routerLayout = attrs.getValue( "routerLayout" );
        
        OSWorkflowProcess process = new OSWorkflowProcess();
        process.setId( id );
        process.setName( name );
        process.setVersion( version );
        process.setType( type );
        process.setPackageName( packageName );
        if (routerLayout != null) {
            process.setMetaData("routerLayout", new Integer(routerLayout));
        }

        ((ProcessBuildData)parser.getData()).setProcess( process );
        
        return process;
    }    
    
    public Object end(final String uri,
                      final String localName,
                      final ExtensibleXmlParser parser) throws SAXException {
        final Element element = parser.endElementBuilder();        
        return parser.getCurrent();
    }

    public Class generateNodeFor() {
        return org.drools.process.core.Process.class;
    }    

}
