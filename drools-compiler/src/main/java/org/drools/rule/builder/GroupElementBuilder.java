/*
 * Copyright 2006 JBoss Inc
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

package org.drools.rule.builder;

import java.util.Iterator;

import org.drools.RuntimeDroolsException;
import org.drools.lang.descr.AndDescr;
import org.drools.lang.descr.BaseDescr;
import org.drools.lang.descr.PatternDescr;
import org.drools.lang.descr.ConditionalElementDescr;
import org.drools.lang.descr.ExistsDescr;
import org.drools.lang.descr.NotDescr;
import org.drools.lang.descr.OrDescr;
import org.drools.lang.descr.QueryDescr;
import org.drools.rule.Pattern;
import org.drools.rule.ConditionalElement;
import org.drools.rule.GroupElement;
import org.drools.rule.GroupElementFactory;

/**
 * @author etirelli
 *
 */
public class GroupElementBuilder
    implements
    ConditionalElementBuilder {
    
    public ConditionalElement build(final RuleBuildContext context,
                                    final BaseDescr descr) {
        return build(context, descr, null);
    }
    
    public ConditionalElement build(final RuleBuildContext context,
                                    final BaseDescr descr,
                                    final Pattern prefixPattern) {
        final ConditionalElementDescr cedescr = (ConditionalElementDescr) descr;

        final GroupElement ge = newGroupElementFor( cedescr.getClass() );
        context.getBuildStack().push( ge );        
        
        if ( prefixPattern != null ) {
            ge.addChild( prefixPattern );
        }

        // iterate over child descriptors
        for ( final Iterator it = cedescr.getDescrs().iterator(); it.hasNext(); ) {
            // gets child to build
            final BaseDescr child = (BaseDescr) it.next();

            // gets corresponding builder
            //final ConditionalElementBuilder cebuilder = ( ConditionalElementBuilder ) utils.getBuilder( child.getClass() );
            final Object builder = context.getDialect().getBuilder( child.getClass() );

            if ( builder instanceof ConditionalElementBuilder ) {
                ConditionalElementBuilder ceBuilder = (ConditionalElementBuilder) builder;
                final ConditionalElement ce = ceBuilder.build( context,
                                                               child );
                if ( ce != null ) {
                    ge.addChild( ce );
                }
            } else if ( builder instanceof PatternBuilder ) {
                final PatternBuilder patternBuilder = (PatternBuilder) context.getDialect().getBuilder( child.getClass() );

                final Pattern pattern = patternBuilder.build( context,
                                                              (PatternDescr) child );
                // in case there is a problem with the pattern building,
                // builder will return null. Ex: ClassNotFound for the pattern type
                if ( pattern != null ) {
                    ge.addChild( pattern );
                }

            } else {
                throw new RuntimeDroolsException( "BUG: no builder found for descriptor class " + child.getClass() );
            }

        }

        context.getBuildStack().pop();

        return ge;
    }

    private GroupElement newGroupElementFor(final Class descr) {
        if ( AndDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newAndInstance();
        } else if ( OrDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newOrInstance();
        } else if ( NotDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newNotInstance();
        } else if ( ExistsDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newExistsInstance();
        } else {
            throw new RuntimeDroolsException( "BUG: Not able to create a group element for descriptor: " + descr.getName() );
        }
    }

}
