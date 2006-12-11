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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.drools.DroolsTestCase;

public class LogicTransformerTest extends DroolsTestCase {
    /**
     * (a||b)&&c
     * 
     * <pre>
     *               and
     *               / \
     *              or  c 
     *             /  \
     *            a    b
     * </pre>
     * 
     * Should become (a&&c)||(b&&c)
     * 
     * <pre>
     *                 
     *               or
     *              /  \  
     *             /    \ 
     *            /      \ 
     *             and      and     
     *          / \      / \
     *         a   c    b   c
     * </pre>
     */
    public void testSingleOrAndOrTransformation() throws InvalidPatternException {
        final String a = "a";
        final String b = "b";
        final String c = "c";

        final GroupElement parent = GroupElementFactory.newAndInstance();
        parent.addChild( c );
        final GroupElement or = GroupElementFactory.newOrInstance();
        or.addChild( a );
        or.addChild( b );
        parent.addChild( or );

        LogicTransformer.getInstance().applyOrTransformation( parent );

        assertLength( 2,
                      parent.getChildren() );
        assertEquals( GroupElement.class,
                      parent.getChildren().get( 0 ).getClass() );
        assertEquals( GroupElement.class,
                      parent.getChildren().get( 1 ).getClass() );

        final GroupElement and1 = (GroupElement) parent.getChildren().get( 0 );
        assertContains( c,
                        and1.getChildren() );
        assertContains( a,
                        and1.getChildren() );

        final GroupElement and2 = (GroupElement) parent.getChildren().get( 1 );
        assertContains( c,
                        and2.getChildren() );
        assertContains( b,
                        and2.getChildren() );

    }

    /**
     * (a||b)&&c
     * 
     * <pre>
     *                   And
     *                  /|\ \__
     *                _/ | \_  \_
     *               /   |   \   \  
     *              or   |   or   not
     *             /   \ |  / \    |
     *            a    b c d   e   f
     * </pre>
     * 
     * Should become (a&&c)||(b&&c)
     * 
     * <pre>
     *                           /\
     *                         _/  \_
     *                        /      \
     *                      _/|       |\_
     *                   __/  |       |  \__
     *                __/     |       |     \__
     *               /        |       |        \
     *              and      and     and      and
     *             /||\     /||\     /||\     /||\
     *            a cd Not a ce Not b cd Not b ce Not
     *                  |        |        |        |
     *                  f        f        f        f
     * </pre>
     */
    public void testMultipleOrAndOrTransformation() throws InvalidPatternException {
        final String a = "a";
        final String b = "b";
        final String c = "c";
        final String d = "d";
        final String e = "e";
        final String f = "f";

        final GroupElement parent = GroupElementFactory.newAndInstance();
        final GroupElement or = GroupElementFactory.newOrInstance();
        or.addChild( a );
        or.addChild( b );
        parent.addChild( or );
        parent.addChild( c );

        final GroupElement or2 = GroupElementFactory.newOrInstance();

        or2.addChild( d );
        or2.addChild( e );
        parent.addChild( or2 );

        final GroupElement not = GroupElementFactory.newNotInstance();
        not.addChild( f );
        parent.addChild( not );

        LogicTransformer.getInstance().applyOrTransformation( parent );

        assertEquals( GroupElement.OR,
                      parent.getType() );

        assertLength( 4,
                      parent.getChildren() );
        assertEquals( GroupElement.class,
                      parent.getChildren().get( 0 ).getClass() );
        assertEquals( GroupElement.class,
                      parent.getChildren().get( 1 ).getClass() );
        assertEquals( GroupElement.class,
                      parent.getChildren().get( 2 ).getClass() );
        assertEquals( GroupElement.class,
                      parent.getChildren().get( 3 ).getClass() );

        GroupElement and1 = (GroupElement) parent.getChildren().get( 0 );
        assertEquals( GroupElement.AND,
                      and1.getType() );
        assertLength( 4,
                      and1.getChildren() );
        assertContains( a,
                        and1.getChildren() );
        assertContains( c,
                        and1.getChildren() );
        assertContains( d,
                        and1.getChildren() );
        assertContains( not,
                        and1.getChildren() );

        and1 = (GroupElement) parent.getChildren().get( 1 );
        assertEquals( GroupElement.AND,
                      and1.getType() );
        assertLength( 4,
                      and1.getChildren() );
        assertContains( a,
                        and1.getChildren() );
        assertContains( c,
                        and1.getChildren() );
        assertContains( e,
                        and1.getChildren() );
        assertContains( not,
                        and1.getChildren() );

        and1 = (GroupElement) parent.getChildren().get( 2 );
        assertEquals( GroupElement.AND,
                      and1.getType() );
        assertLength( 4,
                      and1.getChildren() );
        assertContains( b,
                        and1.getChildren() );
        assertContains( c,
                        and1.getChildren() );
        assertContains( d,
                        and1.getChildren() );
        assertContains( not,
                        and1.getChildren() );

        and1 = (GroupElement) parent.getChildren().get( 3 );
        assertEquals( GroupElement.AND,
                      and1.getType() );
        assertLength( 4,
                      and1.getChildren() );
        assertContains( b,
                        and1.getChildren() );
        assertContains( c,
                        and1.getChildren() );
        assertContains( e,
                        and1.getChildren() );
        assertContains( not,
                        and1.getChildren() );
    }

    /**
     * This data structure is now valid
     * 
     * (Not (OR (A B) ) )
     * 
     * <pre>
     *             Not
     *              | 
     *             or   
     *            /  \
     *           a    b
     * </pre>
     * 
     * Should become:
     * 
     * <pre>
     *             And
     *             / \ 
     *           Not Not   
     *            |   |
     *            a   b
     * </pre>
     * 
     * 
     */
    public void testNotOrTransformation() throws InvalidPatternException {
        final String a = "a";
        final String b = "b";

        final GroupElement parent = GroupElementFactory.newNotInstance();
        final GroupElement or = GroupElementFactory.newOrInstance();
        parent.addChild( or );

        or.addChild( a );
        or.addChild( b );

        LogicTransformer.getInstance().applyOrTransformation( parent );

        assertTrue( parent.isAnd() );
        assertEquals( 2,
                      parent.getChildren().size() );

        GroupElement b1 = (GroupElement) parent.getChildren().get( 0 );
        GroupElement b2 = (GroupElement) parent.getChildren().get( 1 );
        assertTrue( b1.isNot() );
        assertTrue( b2.isNot() );

        assertEquals( 1,
                      b1.getChildren().size() );
        assertEquals( a,
                      b1.getChildren().get( 0 ) );

        assertEquals( 1,
                      b2.getChildren().size() );
        assertEquals( b,
                      b2.getChildren().get( 0 ) );
    }

    /**
     * This data structure is now valid (Exists (OR (A B) ) )
     * 
     * <pre>
     *             Exists
     *              | 
     *             or   
     *            /  \
     *           a    b
     * </pre>
     * 
     * Should become:
     * 
     * <pre>
     *              Or
     *             /  \ 
     *        Exists  Exists   
     *            |    |
     *            a    b
     * </pre>
     */
    public void testExistOrTransformation() throws InvalidPatternException {
        final String a = "a";
        final String b = "b";

        final GroupElement parent = GroupElementFactory.newExistsInstance();
        final GroupElement or = GroupElementFactory.newOrInstance();
        parent.addChild( or );

        or.addChild( a );
        or.addChild( b );

        LogicTransformer.getInstance().applyOrTransformation( parent );

        assertTrue( parent.isOr() );
        assertEquals( 2,
                      parent.getChildren().size() );

        GroupElement b1 = (GroupElement) parent.getChildren().get( 0 );
        GroupElement b2 = (GroupElement) parent.getChildren().get( 1 );
        assertTrue( b1.isExists() );
        assertTrue( b2.isExists() );

        assertEquals( 1,
                      b1.getChildren().size() );
        assertEquals( a,
                      b1.getChildren().get( 0 ) );

        assertEquals( 1,
                      b2.getChildren().size() );
        assertEquals( b,
                      b2.getChildren().get( 0 ) );

    }

    public void testEliminateEmptyBranchesAndDuplications() throws InvalidRuleException {
        final String a = "a";
        final String b = "b";
        final String c = "c";
        final String d = "d";

        final GroupElement and1 = GroupElementFactory.newAndInstance();
        and1.addChild( a );
        and1.addChild( b );

        final GroupElement and2 = GroupElementFactory.newAndInstance();
        and2.addChild( c );
        and2.addChild( d );

        and1.addChild( and2 );

        final GroupElement or = GroupElementFactory.newOrInstance();
        and1.addChild( or );

        GroupElement[] result = LogicTransformer.getInstance().transform( and1 );

        assertLength( 1,
                      result );
        assertLength( 4,
                      result[0].getChildren() );
        assertContains( a,
                        result[0].getChildren() );
        assertContains( b,
                        result[0].getChildren() );
        assertContains( c,
                        result[0].getChildren() );
        assertContains( d,
                        result[0].getChildren() );

    }

    /**
     * <pre>
     *                         _/|\_
     *                      __/  |  \__
     *                     /     |     \ 
     *                  __/      |      \__
     *                 /         |         \
     *                And       and        Not
     *               / | \      / \         |
     *             a  And d    e  Or        i
     *                / \        /  \      
     *               b  Not     h  Exists    
     *                   |           |      
     *                  Not          g   
     *                   |           
     *                   c         
     * </pre>
     * <pre>
     *                            Or 
     *                           _/ \__
     *                        __/      \___
     *                       /             \__
     *                    __/                 \__
     *                   /                       \__
     *                  /                           \__
     *                 |                               \
     *                And                             And
     *            /|||| \  \                       /||| |   \    \
     *            abdeh Not Not                    abde Not Not Exists
     *                   |   |                           |   |    |
     *                  Not  i                          Not  i    g
     *                   |                               |
     *                   c                               c
     * </pre>
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     * 
     * 
     * 
     */
    public void testProcessTree() throws IOException,
                                 ClassNotFoundException,
                                 InvalidPatternException {
        final String a = "a";
        final String b = "b";
        final String c = "c";
        final String d = "d";
        final String e = "e";
        //final String f = "f";
        final String g = "g";
        final String h = "h";
        final String i = "i";
        //final String j = "j";
        //final String k = "notAssertObject";

        final GroupElement and1 = GroupElementFactory.newAndInstance();
        final GroupElement and2 = GroupElementFactory.newAndInstance();
        and1.addChild( a );
        and1.addChild( and2 );
        and2.addChild( b );
        final GroupElement not1 = GroupElementFactory.newNotInstance();
        final GroupElement not2 = GroupElementFactory.newNotInstance();
        not1.addChild( not2 );
        not2.addChild( c );
        and2.addChild( not1 );
        and1.addChild( d );

        final GroupElement and3 = GroupElementFactory.newAndInstance();
        and3.addChild( e );
        final GroupElement or1 = GroupElementFactory.newOrInstance();
        and3.addChild( or1 );
        final GroupElement exist1 = GroupElementFactory.newExistsInstance();
        exist1.addChild( g );
        or1.addChild( exist1 );
        or1.addChild( h );

        final GroupElement not3 = GroupElementFactory.newNotInstance();
        not3.addChild( i );

        final GroupElement root = GroupElementFactory.newAndInstance();
        root.addChild( and1 );
        root.addChild( and3 );
        root.addChild( not3 );

        GroupElement[] result = LogicTransformer.getInstance().transform( root );

        // ----------------------------------------------------------------------------------
        // Now construct the result tree so we can test root against what it
        // should look like
        // ----------------------------------------------------------------------------------

        // Get known correct tree
        // The binary stream was created from a handchecked correct output

        // Uncomment this when you need to output a new known correct tree
        // result
        //writeTree(result, "correct_processTree1.dat");
        final ObjectInputStream ois = new ObjectInputStream( this.getClass().getResourceAsStream( "/correct_processTree1.dat" ) );

        final GroupElement[] correctResultRoot = (GroupElement[]) ois.readObject();

        // Make sure they are equal
        for ( int j = 0; j < correctResultRoot.length; j++ ) {
            assertEquals( correctResultRoot[j],
                          result[j] );
        }
    }

    public void xxxtestCloneable() {
        final String a = "a";
        final String b = "b";
        final String c = "c";
        final String d = "d";
        final String e = "e";
        final String f = "f";
        final String g = "g";
        final String h = "h";

        // Test against a known false tree
        final GroupElement and = GroupElementFactory.newAndInstance();
        and.addChild( a );
        and.addChild( b );

        final GroupElement or = GroupElementFactory.newOrInstance();
        or.addChild( c );
        or.addChild( d );
        and.addChild( or );
        final GroupElement and2 = GroupElementFactory.newAndInstance();
        and2.addChild( e );
        and2.addChild( f );
        or.addChild( and2 );

        final GroupElement not = GroupElementFactory.newNotInstance();
        and.addChild( not );
        final GroupElement or2 = GroupElementFactory.newOrInstance();
        not.addChild( or2 );
        or2.addChild( g );
        or2.addChild( h );

        final GroupElement cloned = (GroupElement) and.clone();

        assertEquals( and,
                      cloned );

    }

    /**
     * 
     * 
     * /**
     * 
     * <pre>
     *                         _/|\_
     *                      __/  |  \__
     *                     /     |     \ 
     *                  __/      |      \__
     *                 /         |         \
     *                And       or         And
     *               /  \       / \        /  \
     *             a    Or     d   e      Not OR
     *                 / \                |  / | 
     *               b    c               f g Not
     *                                         |
     *                                         h
     *                  
     *                   
     *                  
     * </pre>
     * 
     * Each And is a Rete sub rule
     * 
     * <pre>
     *     
     *    
     *       And___     And___      And___      And___        And__    And___       And___    And___     
     *      ||| |  \   ||| |  \     ||| |  \   ||| |  \     ||| |  \  ||| |  \     ||| |  \  ||| |  \ 
     *      dab Not g  dab Not Not  dac Not g  dac Not Not  eab Not g eab Not Not  eac Not g eac Not Not
     *           |          |   |        |          |   |   |    |        |    |       |          |   |   
     *           f          f   h        f          f   h        f        f    h       f          f   h
     *                        
     *                        
     * </pre>
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     * 
     * 
     * 
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     * 
     */
    public void xxxtestTransform() throws IOException,
                               ClassNotFoundException,
                               InvalidPatternException {
        final String a = "a";
        final String b = "b";
        final String c = "c";
        final String d = "d";
        final String e = "e";
        final String f = "f";
        final String g = "g";
        final String h = "h";

        final GroupElement and = GroupElementFactory.newAndInstance();

        final GroupElement and1 = GroupElementFactory.newAndInstance();
        and1.addChild( a );
        final GroupElement or1 = GroupElementFactory.newOrInstance();
        or1.addChild( b );
        or1.addChild( c );
        and1.addChild( or1 );
        and.addChild( and1 );

        final GroupElement or2 = GroupElementFactory.newOrInstance();
        or2.addChild( d );
        or2.addChild( e );
        and.addChild( or2 );

        final GroupElement and2 = GroupElementFactory.newAndInstance();
        final GroupElement not1 = GroupElementFactory.newNotInstance();
        not1.addChild( f );
        final GroupElement or3 = GroupElementFactory.newOrInstance();
        or3.addChild( g );

        final GroupElement not2 = GroupElementFactory.newNotInstance();
        not2.addChild( h );
        or3.addChild( not2 );

        and2.addChild( not1 );
        and2.addChild( or3 );
        and.addChild( and2 );

        GroupElement[] ands = LogicTransformer.getInstance().transform( and );

        // Uncomment this when you need to output a new known correct tree
        // result
        //writeTree(ands, "correct_transform1.dat");

        // Now check the main tree

        // Get known correct tree
        // The binary stream was created from a handchecked correct output
        final ObjectInputStream ois = new ObjectInputStream( this.getClass().getResourceAsStream( "/correct_transform1.dat" ) );
        final GroupElement[] correctResultAnds = (GroupElement[]) ois.readObject();

        for ( int j = 0; j < ands.length; j++ ) {
            assertEquals( correctResultAnds[j],
                          ands[j] );
        }
    }

    private void writeTree(final Object object,
                           final String fileName) throws IOException {
        final String className = this.getClass().getName();

        File file = new File( this.getClass().getResource( className.substring( className.lastIndexOf( '.' ) + 1 ) + ".class" ).getFile() );

        file = new File( file.getParent(),
                         fileName );

        new ObjectOutputStream( new FileOutputStream( file ) ).writeObject( object );
    }

}