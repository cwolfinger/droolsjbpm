package org.drools.base;

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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.RuntimeDroolsException;
import org.drools.rule.TypeDeclaration;
import org.drools.spi.ObjectType;

/**
 * Java class semantics <code>ObjectType</code>.
 *
 * @author <a href="mailto:bob@werken.com">bob@werken.com </a>
 *
 * @version $Id: ClassObjectType.java,v 1.5 2005/02/04 02:13:36 mproctor Exp $
 */
public class ClassObjectType
    implements
    ObjectType,
    Externalizable {

    private static final long    serialVersionUID = 400L;

    protected Class< ? >         cls;

    protected String             clsName;

    protected ValueType          valueType;

    private TypeDeclaration.Role role;

    // ------------------------------------------------------------
    // Constructors
    // ------------------------------------------------------------

    public ClassObjectType() {
    }

    /**
     * Creates a new class object type with shadow disabled.
     *
     * @param objectTypeClass
     *            Java object class.
     */
    public ClassObjectType(final Class< ? > objectTypeClass) {
        this( objectTypeClass,
              TypeDeclaration.Role.FACT );
    }

    /**
     * Creates a new class object type
     *
     * @param objectTypeClass the class represented by this class object type
     * @param isEvent true if it is an event class, false otherwise
     */
    public ClassObjectType(final Class< ? > objectTypeClass,
                           final TypeDeclaration.Role role) {
        this.cls = objectTypeClass;
        this.role = role;
        this.clsName = this.cls.getName();
        this.valueType = ValueType.determineValueType( objectTypeClass );
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        this.clsName = in.readUTF();
        if ( clsName.equals( "org.drools.InitialFact" ) || clsName.equals( "org.drools.base.DroolsQuery" ) ) {
            // we handle this one especially as it never gets written to the packagestore for rewiring
            try {
                setClassType( getClass().getClassLoader().loadClass( clsName ) );
            } catch ( ClassNotFoundException e ) {
                throw new RuntimeDroolsException( "Unable to resolve class '" + clsName + "'" );
            }
        }
        this.role = (TypeDeclaration.Role) in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF( clsName );
        out.writeObject( role );
    }

    /**
     * Return the Java object class.
     *
     * @return The Java object class.
     */
    public Class< ? > getClassType() {
        return this.cls;
    }

    public String getClassName() {
        return this.clsName;
    }

    public void setClassType(Class< ? > cls) {
        this.cls = cls;
        this.valueType = ValueType.determineValueType( cls );
    }

    public boolean isAssignableFrom(ObjectType objectType) {
        if ( !(objectType instanceof ClassObjectType) ) {
            return false;
        } else {
            return this.cls.isAssignableFrom( ((ClassObjectType) objectType).getClassType() );
        }
    }

    public ValueType getValueType() {
        return this.valueType;
    }

    public boolean isEvent() {
        return role.equals( TypeDeclaration.Role.EVENT );
    }

    public boolean isEffectiveDated() {
        return role.equals( TypeDeclaration.Role.EFFDATED );
    }

    public String toString() {
        return "[ClassObjectType class=" + getClassType().getName() + " role="+ role +"]";
    }

    /**
     * Determine if another object is equal to this.
     *
     * @param object
     *            The object to test.
     *
     * @return <code>true</code> if <code>object</code> is equal to this,
     *         otherwise <code>false</code>.
     */
    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }

        if ( object == null || object.getClass() != ClassObjectType.class ) {
            return false;
        }

        return this.role.equals( ((ClassObjectType)object).role ) && this.clsName.equals( ((ClassObjectType) object).clsName );
    }

    public int hashCode() {
        return this.clsName.hashCode() | (this.role.hashCode() * 31);
    }

}