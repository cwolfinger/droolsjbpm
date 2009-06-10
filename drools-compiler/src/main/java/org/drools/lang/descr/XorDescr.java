package org.drools.lang.descr;

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

import java.util.ArrayList;
import java.util.List;

import org.drools.RuntimeDroolsException;

public class XorDescr extends BaseDescr
    implements
    ConditionalElementDescr {
    /**
     * 
     */
    private static final long serialVersionUID = 400L;
    private List              descrs           = new ArrayList();

    public XorDescr() {
    }

    public void addDescr(final BaseDescr baseDescr) {
        this.descrs.add( baseDescr );
        if( baseDescr instanceof FieldBindingDescr ) {
            FieldBindingDescr fbd = (FieldBindingDescr) baseDescr;
            if( fbd.getFieldConstraint() != null ) {
                this.descrs.add( fbd.getFieldConstraint() );
                fbd.setFieldConstraint( null );
            }
        }
    }

    public void insertDescr(int index,
                            final BaseDescr baseDescr) {
        if( baseDescr instanceof FieldBindingDescr ) {
            FieldBindingDescr fbd = (FieldBindingDescr) baseDescr;
            if( fbd.getFieldConstraint() != null ) {
                this.descrs.add(index, fbd.getFieldConstraint() );
                fbd.setFieldConstraint( null );
            }
        }
        this.descrs.add( index,
                         baseDescr );
    }

   

    public void addDescrFirst(final BaseDescr baseDescr) {
//        if (this.descrs.size() >= 2)
//        	throw new RuntimeDroolsException("Xor is Binary");
        
        this.descrs.add( 0 , baseDescr );
    }

   
    public void insertBeforeLast(final Class clazz,
                             final BaseDescr baseDescr) {
        if ( this.descrs.isEmpty() ) {
            addDescr( baseDescr );
            return;
        }

        for ( int i = this.descrs.size() - 1; i >= 0; i-- ) {
            if ( clazz.isInstance( this.descrs.get( i ) ) ) {
                insertDescr( i,
                             baseDescr );
                return;
            }
        }
        
        addDescr( baseDescr );
    }

    public List getDescrs() {
        return this.descrs;
    }

    public void addOrMerge(final BaseDescr baseDescr) {
        if ( baseDescr instanceof XorDescr && ! overrides(this,baseDescr)) {
//        	this.descrs.addAll( ((XorDescr) baseDescr).getDescrs() );
        	for( BaseDescr descr : (List<BaseDescr>)((XorDescr) baseDescr).getDescrs() ) {
                addDescr( descr );
            }            
        } else {
            addDescr( baseDescr );
        }
    }
}