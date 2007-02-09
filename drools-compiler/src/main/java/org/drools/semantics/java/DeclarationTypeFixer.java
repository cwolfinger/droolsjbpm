/**
 * 
 */
package org.drools.semantics.java;

import org.drools.base.ClassObjectType;
import org.drools.rule.Declaration;

/**
 * @author fburlet
 * @author gdupriez
 *
 */
public class DeclarationTypeFixer {
    
    public String fix(Declaration declaration) {
        Class classType = ((ClassObjectType) declaration.getObjectType()).getClassType();
        if (classType.isArray()) {
            return classType.getComponentType().getName().concat("[]");
        } else {
            // Does this replacement usefull in the declaration type ??
            return classType.getName().replace('$', '.');
        }
    }
}
