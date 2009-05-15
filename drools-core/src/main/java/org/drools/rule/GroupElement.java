package org.drools.rule;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.drools.RuntimeDroolsException;

public class GroupElement extends ConditionalElement
    implements
    Externalizable {

    private static final long serialVersionUID = 400L;

    public static final Type AND = Type.AND;
    public static final Type OR = Type.OR;
    public static final Type NOT = Type.NOT;
    public static final Type XOR = Type.XOR;
    public static final Type EQV = Type.EQV;
    public static final Type EXISTS = Type.EXISTS;
//    public static final Type FORANY = Type.FORANY;
    public static final Type DISC = Type.DISC;
    public static final Type AVG = Type.AVG;
    public static final Type DMP = Type.DMP;
    
    public static final Type HEDGE = Type.HEDGE;
    
    
    

    private Type              type             = null;
    private List              children         = new ArrayList();
    private String			  param			   = null;
    private String			  label			   = null;

    public GroupElement() {
        this( Type.AND );
    }

    public GroupElement(final Type type) {
        this.type = type;
    }
    
    public GroupElement(final Type type, String spec) {
        this.type = type;
        this.setParam(spec);
    }

    public void readExternal(ObjectInput in) throws IOException,
                                            ClassNotFoundException {
        this.type = (Type) in.readObject();
        children = (List) in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject( type );
        out.writeObject( children );
    }

    public boolean isCutter() {
    	return false;
    }
    
    
    /**
     * Adds a child to the current GroupElement.
     *
     * Restrictions are:
     * NOT/EXISTS: can have only one child, either a single Pattern or another CE
     *
     * @param child
     */
    public void addChild(final RuleConditionElement child) {
        if ( (this.isNot() || this.isExists()) && (this.children.size() > 0) ) {
            throw new RuntimeDroolsException( this.type.toString() + " can have only a single child element. Either a single Pattern or another CE." );
        }
        this.children.add( child );
    }

    /**
     * Adds the given child as the (index)th child of the this GroupElement
     * @param index
     * @param rce
     */
    public void addChild(final int index,
                         final RuleConditionElement rce) {
        this.children.add( index,
                           rce );
    }

    public List getChildren() {
        return this.children;
    }

    /**
     * @inheritDoc
     */
    public Map getInnerDeclarations() {
        return this.type.getInnerDeclarations( this.children );
    }

    /**
     * @inheritDoc
     */
    public Map getOuterDeclarations() {
        return this.type.getOuterDeclarations( this.children );
    }

    /**
     * @inheritDoc
     */
    public Declaration resolveDeclaration(final String identifier) {
        return (Declaration) this.type.getInnerDeclarations( this.children ).get( identifier );
    }

    /**
     * Optimize the group element subtree by removing redundancies
     * like an AND inside another AND, OR inside OR, single branches
     * AND/OR, etc.
     *
     * LogicTransformer does further, more complicated, transformations
     */
    public void pack() {
        // we must clone, since we want to iterate only over the original list
        final Object[] clone = this.children.toArray();
        for ( int i = 0; i < clone.length; i++ ) {
            // if child is also a group element, there may be
            // some possible clean up / optimizations to be done
            if ( clone[i] instanceof GroupElement ) {
                final GroupElement childGroup = (GroupElement) clone[i];
                childGroup.pack( this );
            }
        }

        // if after packing, this is an AND or OR GE with a single
        // child GE, then clone child into current node eliminating child
        if ( (this.isAnd() || this.isOr()) && (this.children.size() == 1) ) {
            final Object child = this.getChildren().get( 0 );
            if ( child instanceof GroupElement ) {
                final GroupElement group = (GroupElement) child;
                this.type = group.getType();
                this.children.clear();
                this.children.addAll( group.getChildren() );
            }
        }

    }

    /**
     * @param parent
     */
    public void pack(final GroupElement parent) {
        if ( this.children.size() == 0 ) {
            // if there is no child, just remove this node
            parent.children.remove( this );
            return;
        }

        // If this is  an AND or OR or EXISTS, there are some possible merges
        if ( this.isAnd() || this.isOr() || this.isExists() ) {

            // if parent is of the same type as current node,
            // then merge this childs with parent childs
            if ( parent.getType() == this.getType() ) {

                // we must keep the order so, save index
                int index = parent.getChildren().indexOf( this );
                parent.getChildren().remove( this );
                // for each child, pack it and add it to parent
                for ( final Iterator childIt = this.children.iterator(); childIt.hasNext(); ) {
                    final Object child = childIt.next();
                    // we must keep the order, so add in the same place were parent was before
                    parent.getChildren().add( index++,
                                              child );
                    if ( child instanceof GroupElement ) {
                        final int previousSize = parent.getChildren().size();
                        ((GroupElement) child).pack( parent );
                        // in case the child also added elements to the parent,
                        // we need to compensate
                        index += (parent.getChildren().size() - previousSize);
                    }
                }

                // if current node has a single child, then move it to parent and pack it
            } else if ( (!this.isExists()) && (this.children.size() == 1) ) {
                // we must keep the order so, save index
                final int index = parent.getChildren().indexOf( this );
                parent.getChildren().remove( this );

                final Object child = this.children.get( 0 );
                parent.getChildren().add( index,
                                          child );

                if ( child instanceof GroupElement ) {
                    ((GroupElement) child).pack( parent );
                }

                // otherwise pack itself
            } else {
                this.pack();
            }

            // also pack itself if it is a NOT
        } else {
            this.pack();
        }
    }

    /**
     * Traverses two trees and checks that they are structurally equal at all
     * levels
     *
     * @param e1
     * @param e2
     * @return
     */
    public boolean equals(final Object object) {
        // Return false if its null or not an instance of ConditionalElement
        if ( object == null || !(object instanceof GroupElement) ) {
            return false;
        }

        // Return true if they are the same reference
        if ( this == object ) {
            return true;
        }

        // Now try a recurse manual check
        final GroupElement e2 = (GroupElement) object;
        if ( !this.type.equals( e2.type ) ) {
            return false;
        }

        final List e1Children = this.getChildren();
        final List e2Children = e2.getChildren();
        if ( e1Children.size() != e2Children.size() ) {
            return false;
        }

        for ( int i = 0; i < e1Children.size(); i++ ) {
            final Object e1Object1 = e1Children.get( i );
            final Object e2Object1 = e2Children.get( i );
            if ( !e1Object1.equals( e2Object1 ) ) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return this.type.hashCode() + this.children.hashCode();
    }

    /**
     * Clones all Conditional Elements but references the non ConditionalElement
     * children
     *
     * @param e1
     * @param e2
     * @return
     */
    public Object clone() {
        GroupElement cloned = null;

        try {
            cloned = (GroupElement) this.getClass().newInstance();
        } catch ( final InstantiationException e ) {
            throw new RuntimeException( "Could not clone '" + this.getClass().getName() + "'" );
        } catch ( final IllegalAccessException e ) {
            throw new RuntimeException( "Could not clone '" + this.getClass().getName() + "'" );
        }

        cloned.setType( this.getType() );

        for ( final Iterator it = this.children.iterator(); it.hasNext(); ) {
            RuleConditionElement re = (RuleConditionElement) it.next();
            if ( re instanceof GroupElement ) {
                re = (RuleConditionElement) ((GroupElement) re).clone();
            }
            cloned.addChild( re );
        }

        return cloned;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public boolean isAnd() {
        return AND.equals( this.type );
    }
    
    public boolean isXor() {
        return XOR.equals( this.type );
    }
    
    public boolean isEqv() {
        return EQV.equals( this.type );
    }

    public boolean isOr() {
        return OR.equals( this.type );
    }

    public boolean isNot() {
        return NOT.equals( this.type );
    }

    public boolean isExists() {
        return EXISTS.equals( this.type );
    }
    
    public boolean isDiscount() {
        return DISC.equals( this.type );
    }
    
    public boolean isAverage() {
        return AVG.equals( this.type );
    }
    
    public boolean isDoubleMP() {
        return DMP.equals( this.type );
    }
    
    public boolean isHedge() {
        return HEDGE.equals( this.type );
    }
    
//    public boolean isForAny() {
//        return FORANY.equals( this.type );
//    }

    public String toString() {
        return this.type.toString() + this.children.toString();
    }

    public List getNestedElements() {
        return this.children;
    }

    public boolean isPatternScopeDelimiter() {
        return this.type.isPatternScopeDelimiter();
    }

    /**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
     * A public enum for CE types
     */
    public static enum Type {

        AND(false), 
        OR(false), 
        NOT(true),
        XOR(false),
        EQV(false),
        EXISTS(true),
        AVG(false),
        DISC(false),
        DMP(false),
        HEDGE(false);
//        FORANY(true);

        private final boolean scopeDelimiter;

        Type(final boolean scopeDelimiter) {
            this.scopeDelimiter = scopeDelimiter;
        }

        /**
         * Returns a map of declarations that are
         * visible inside of an element of this type
         */
        public Map getInnerDeclarations(List children) {
            Map declarations = null;

            if ( children.isEmpty() ) {
                declarations = Collections.EMPTY_MAP;
            } else if ( children.size() == 1 ) {
                final RuleConditionElement re = (RuleConditionElement) children.get( 0 );
                declarations = re.getOuterDeclarations();
            } else {
                declarations = new HashMap();
                for ( final Iterator it = children.iterator(); it.hasNext(); ) {
                    declarations.putAll( ((RuleConditionElement) it.next()).getOuterDeclarations() );
                }
            }
            return declarations;
        }

        /**
         * Returns a map of declarations that are
         * visible outside of an element of this type
         */
        public Map getOuterDeclarations(List children) {
            Map declarations = null;

            if ( this.scopeDelimiter || children.isEmpty() ) {
                declarations = Collections.EMPTY_MAP;
            } else if ( children.size() == 1 ) {
                final RuleConditionElement re = (RuleConditionElement) children.get( 0 );
                declarations = re.getOuterDeclarations();
            } else {
                declarations = new HashMap();
                for ( final Iterator it = children.iterator(); it.hasNext(); ) {
                    declarations.putAll( ((RuleConditionElement) it.next()).getOuterDeclarations() );
                }
            }
            return declarations;
        }

        /**
         * Returns true in case this RuleConditionElement delimits
         * a pattern visibility scope.
         *
         * For instance, AND CE is not a scope delimiter, while
         * NOT CE is a scope delimiter
         * @return
         */
        public boolean isPatternScopeDelimiter() {
            return this.scopeDelimiter;
        }

    }
}