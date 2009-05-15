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
import org.drools.lang.descr.ConditionalElementDescr;
import org.drools.lang.descr.EqvDescr;
import org.drools.lang.descr.ExistsDescr;
import org.drools.lang.descr.ForAnyDescr;
import org.drools.lang.descr.HedgeDescr;
import org.drools.lang.descr.NotDescr;
import org.drools.lang.descr.OrDescr;
import org.drools.lang.descr.XorDescr;
import org.drools.rule.GroupElement;
import org.drools.rule.GroupElementFactory;
import org.drools.rule.Pattern;
import org.drools.rule.RuleConditionElement;

/**
 * @author etirelli
 *
 */
public class GroupElementBuilder
    implements
    RuleConditionBuilder {

    public RuleConditionElement build(final RuleBuildContext context,
                                    final BaseDescr descr) {
        return build( context,
                      descr,
                      null );
    }

    public RuleConditionElement build(final RuleBuildContext context,
                                    final BaseDescr descr,
                                    final Pattern prefixPattern) {
        final ConditionalElementDescr cedescr = (ConditionalElementDescr) descr;

        final GroupElement ge;
        if (cedescr.getParams() == null)
        	ge = newGroupElementFor( cedescr.getClass() );
        else 
        	ge = newGroupElementFor(cedescr.getClass(),cedescr.getParams());
        
        if (descr.getLabel() != null)
        	ge.setLabel(descr.getLabel());
        
        context.getBuildStack().push( ge );

        if ( prefixPattern != null ) {
            ge.addChild( prefixPattern );
        }

        // iterate over child descriptors
        for ( final Iterator it = cedescr.getDescrs().iterator(); it.hasNext(); ) {
            // gets child to build
            final BaseDescr child = (BaseDescr) it.next();

            // gets corresponding builder
            final RuleConditionBuilder builder = (RuleConditionBuilder) context.getDialect().getBuilder( child.getClass() );

            if ( builder != null ) {
                final RuleConditionElement element = builder.build( context,
                                                                    child );
                // in case there is a problem with the building,
                // builder will return null. Ex: ClassNotFound for the pattern type
                if ( element != null ) {
                    ge.addChild( element );
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
        } else if ( XorDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newXorInstance();
        } else if ( EqvDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newEqvInstance();    
        } else if ( HedgeDescr.class.isAssignableFrom( descr)) {
        	return GroupElementFactory.newHedgeInstance();
        }
        else {
            throw new RuntimeDroolsException( "BUG: Not able to create a group element for descriptor: " + descr.getName() );
        }
    }
    
    
    private GroupElement newGroupElementFor(final Class descr, String params) {
        if ( AndDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newAndInstance(params);
        } else if ( OrDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newOrInstance(params);
        } else if ( NotDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newNotInstance(params);
        } else if ( ExistsDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newExistsInstance(params);
        } else if ( XorDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newXorInstance(params);
        } else if ( EqvDescr.class.isAssignableFrom( descr ) ) {
            return GroupElementFactory.newEqvInstance(params);    
        } else if ( HedgeDescr.class.isAssignableFrom( descr)) {
        	return GroupElementFactory.newHedgeInstance( params );
        }
        else {
            throw new RuntimeDroolsException( "BUG: Not able to create a group element for descriptor: " + descr.getName() );
        }
    }

}
