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

package org.drools.testframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.drools.Cheese;
import org.drools.CheeseType;
import org.drools.Cheesery;
import org.drools.Cheesery.Maturity;
import org.drools.OuterFact;
import org.drools.Person;
import org.drools.WorkingMemory;
import org.drools.base.ClassTypeResolver;
import org.drools.base.TypeResolver;
import org.drools.base.mvel.DroolsMVELFactory;
import org.drools.common.InternalRuleBase;
import org.drools.common.InternalWorkingMemory;
import org.drools.ide.common.client.modeldriven.testing.ActivateRuleFlowGroup;
import org.drools.ide.common.client.modeldriven.testing.CallFieldValue;
import org.drools.ide.common.client.modeldriven.testing.CallMethod;
import org.drools.ide.common.client.modeldriven.testing.ExecutionTrace;
import org.drools.ide.common.client.modeldriven.testing.Expectation;
import org.drools.ide.common.client.modeldriven.testing.FactData;
import org.drools.ide.common.client.modeldriven.testing.FieldData;
import org.drools.ide.common.client.modeldriven.testing.Fixture;
import org.drools.ide.common.client.modeldriven.testing.RetractFact;
import org.drools.ide.common.client.modeldriven.testing.Scenario;
import org.drools.ide.common.client.modeldriven.testing.VerifyFact;
import org.drools.ide.common.client.modeldriven.testing.VerifyField;
import org.drools.ide.common.client.modeldriven.testing.VerifyRuleFired;
import org.drools.ide.common.server.util.ScenarioXMLPersistence;
import org.drools.time.impl.PseudoClockScheduler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScenarioRunnerTest extends RuleUnit {

    static {
        try {
            Class.forName( "org.drools.base.mvel.MVELCompilationUnit" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        //needed when running stand alone to make sure the converters get loaded.
        DroolsMVELFactory d = new DroolsMVELFactory();
    }

    @Test
    public void testPopulateFactsWithInterfaces() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "List",
                                       "ls",
                                       new ArrayList(),
                                       false ) );

        List globals = ls( new FactData( "List",
                                         "ls",
                                         new ArrayList(),
                                         false ) );
        sc.fixtures.addAll( facts );
        sc.globals.addAll( globals );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "java.util.List" );

        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

    }

    @Test
    public void testPopulateFacts() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "type",
                                                          "cheddar" ),
                                           new FieldData( "price",
                                                          "42" ) ),
                                       false ),
                         new FactData( "Person",
                                       "p1",
                                       ls( new FieldData( "name",
                                                          "mic" ),
                                           new FieldData( "age",
                                                          "=30 + 3" ) ),
                                       false ) );

        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.Person" );
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        assertTrue( runner.populatedData.containsKey( "p1" ) );

        Cheese c = (Cheese) runner.populatedData.get( "c1" );
        assertEquals( "cheddar",
                      c.getType() );
        assertEquals( 42,
                      c.getPrice() );

        Person p = (Person) runner.populatedData.get( "p1" );
        assertEquals( "mic",
                      p.getName() );
        assertEquals( 33,
                      p.getAge() );

    }
    
    @Test
    public void testPopulateEnum() throws Exception {
        Scenario sc = new Scenario();
        FieldData fd = new FieldData( "cheeseType", "CheeseType.CHEDDAR");
        fd.setNature(FieldData.TYPE_ENUM, null);
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       ls(fd),
                                       false ));

        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.CheeseType" );
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );

        Cheese c = (Cheese) runner.populatedData.get( "c1" );
        assertEquals( CheeseType.CHEDDAR,
                      c.getCheeseType() );
    }
    
    @Test
    public void testPopulateNested() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "type",
                                                          "cheddar" ),
                                           new FieldData( "price",
                                                          "42" ) ),
                                       false ),
                         new FactData( "OuterFact",
                                       "p1",
                                       ls( new FieldData( "name",
                                                          "mic" ),
                                           new FieldData( "innerFact",
                                                          "=c1" ) ),
                                       false ) );

        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.OuterFact" );
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        assertTrue( runner.populatedData.containsKey( "p1" ) );

        OuterFact o = (OuterFact) runner.populatedData.get( "p1" );
        assertNotNull( o.getInnerFact() );

    }

    /**
     * to check for re-ordering..
     * @throws Exception
     */
    @Test
    public void testPopulateNestedWrongOrder() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "OuterFact",
                                       "p1",
                                       ls( new FieldData( "name",
                                                          "mic" ),
                                           new FieldData( "innerFact",
                                                          "=c1" ) ),
                                       false ),
                         new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "type",
                                                          "cheddar" ),
                                           new FieldData( "price",
                                                          "42" ) ),
                                       false ) );

        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.OuterFact" );
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        assertTrue( runner.populatedData.containsKey( "p1" ) );

        OuterFact o = (OuterFact) runner.populatedData.get( "p1" );
        assertNotNull( o.getInnerFact() );

    }

    @Test
    public void testPopulateEmpty() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       new ArrayList(),
                                       false ) );
        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        sc.fixtures.addAll( facts );
        resolver.addImport( "org.drools.Cheese" );
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        assertTrue( runner.populatedData.get( "c1" ) instanceof Cheese );
    }

    @Test
    public void testDateField() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "type",
                                                          "cheddar" ),
                                           new FieldData( "usedBy",
                                                          "10-Jul-2008" ) ),
                                       false ),
                         new FactData( "OuterFact",
                                       "p1",
                                       ls( new FieldData( "name",
                                                          "mic" ),
                                           new FieldData( "innerFact",
                                                          "=c1" ) ),
                                       false ) );

        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.OuterFact" );
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        assertTrue( runner.populatedData.containsKey( "p1" ) );

        Cheese c = (Cheese) runner.populatedData.get( "c1" );
        assertNotNull( c.getUsedBy() );

    }

    @Test
    public void testPopulateFactsWithExpressions() throws Exception {
        Scenario sc = new Scenario();
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "type",
                                                          "cheddar" ),
                                           new FieldData( "price",
                                                          "42" ) ),
                                       false ),
                         new FactData( "Cheese",
                                       "c2",
                                       ls( new FieldData( "type",
                                                          "= c1.type" ) ),
                                       false ) );

        sc.fixtures.addAll( facts );
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );

        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    new MockWorkingMemory() );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        assertTrue( runner.populatedData.containsKey( "c2" ) );

        Cheese c = (Cheese) runner.populatedData.get( "c1" );
        assertEquals( "cheddar",
                      c.getType() );
        assertEquals( 42,
                      c.getPrice() );

        Cheese c2 = (Cheese) runner.populatedData.get( "c2" );
        assertEquals( c.getType(),
                      c2.getType() );

    }

    @Test
    public void testPopulateNoData() throws Exception {
        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        ScenarioRunner run = new ScenarioRunner( new Scenario(),
                                                 resolver,
                                                 new MockWorkingMemory() );
        run.populatedData.clear();
        Cheese c = new Cheese();
        c.setType( "whee" );
        c.setPrice( 1 );
        run.populatedData.put( "x",
                               c );

        assertEquals( 1,
                      c.getPrice() );

        FactData fd = new FactData( "Cheese",
                                    "x",
                                    ls( new FieldData( "type",
                                                       "" ),
                                        new FieldData( "price",
                                                       "42" ) ),
                                    false );

        run.populateFields( fd,
                            run.populatedData,
                            c,
                            resolver);
        assertEquals( "whee",
                      c.getType() );
        assertEquals( 42,
                      c.getPrice() );
    }

    @Test
    public void testVerifyFacts() throws Exception {

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheese f1 = new Cheese( "cheddar",
                                42 );
        runner.populatedData.put( "f1",
                                  f1 );

        Person f2 = new Person( "michael",
                                33 );
        runner.populatedData.put( "f2",
                                  f2 );

        // test all true
        VerifyFact vf = new VerifyFact();
        vf.name = "f1";
        vf.fieldValues = ls( new VerifyField( "type",
                                              "cheddar",
                                              "==" ),
                             new VerifyField( "price",
                                              "42",
                                              "==" ) );

        runner.verify( vf );
        for ( int i = 0; i < vf.fieldValues.size(); i++ ) {
            assertTrue( ((VerifyField) vf.fieldValues.get( i )).successResult );
        }

        vf = new VerifyFact();
        vf.name = "f2";
        vf.fieldValues = ls( new VerifyField( "name",
                                              "michael",
                                              "==" ),
                             new VerifyField( "age",
                                              "33",
                                              "==" ) );

        runner.verify( vf );
        for ( int i = 0; i < vf.fieldValues.size(); i++ ) {
            assertTrue( ((VerifyField) vf.fieldValues.get( i )).successResult );
        }

        // test one false
        vf = new VerifyFact();
        vf.name = "f2";
        vf.fieldValues = ls( new VerifyField( "name",
                                              "mark",
                                              "==" ),
                             new VerifyField( "age",
                                              "33",
                                              "==" ) );

        runner.verify( vf );
        assertFalse( ((VerifyField) vf.fieldValues.get( 0 )).successResult );
        assertTrue( ((VerifyField) vf.fieldValues.get( 1 )).successResult );

        assertEquals( "michael",
                      ((VerifyField) vf.fieldValues.get( 0 )).actualResult );
        assertEquals( "mark",
                      ((VerifyField) vf.fieldValues.get( 0 )).expected );

        // test 2 false
        vf = new VerifyFact();
        vf.name = "f2";
        vf.fieldValues = ls( new VerifyField( "name",
                                              "mark",
                                              "==" ),
                             new VerifyField( "age",
                                              "32",
                                              "==" ) );

        runner.verify( vf );
        assertFalse( ((VerifyField) vf.fieldValues.get( 0 )).successResult );
        assertFalse( ((VerifyField) vf.fieldValues.get( 1 )).successResult );

        assertEquals( "michael",
                      ((VerifyField) vf.fieldValues.get( 0 )).actualResult );
        assertEquals( "mark",
                      ((VerifyField) vf.fieldValues.get( 0 )).expected );

        assertEquals( "33",
                      ((VerifyField) vf.fieldValues.get( 1 )).actualResult );
        assertEquals( "32",
                      ((VerifyField) vf.fieldValues.get( 1 )).expected );

    }

    @Test
    public void testVerifyFactsWithEnum() throws Exception {
        FieldData fd = new FieldData( "cheeseType", "CheeseType.CHEDDAR");
        fd.setNature(FieldData.TYPE_ENUM, null);
        List facts = ls( new FactData( "Cheese",
                                       "c1",
                                       ls(fd),
                                       false ));

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.CheeseType" );
        
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
        		                                    resolver,
                                                    new MockWorkingMemory() );
        Cheese f1 = new Cheese( "othertype",
                                42 );
        f1.setCheeseType(CheeseType.CHEDDAR);
        runner.populatedData.put( "f1",
                                  f1 );


        VerifyFact vf = new VerifyFact();
        vf.name = "f1";
        VerifyField verifyField = new VerifyField( "cheeseType",
                "CheeseType.CHEDDAR",
                "==" );
        verifyField.setNature(VerifyField.TYPE_ENUM);
        vf.fieldValues = ls( verifyField );
        runner.verify( vf );
        for ( int i = 0; i < vf.fieldValues.size(); i++ ) {
            assertTrue( ((VerifyField) vf.fieldValues.get( i )).successResult );
        }
    }

    @Test
    public void testVerifyAnonymousFacts() throws Exception {
        MockWorkingMemory wm = new MockWorkingMemory();
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    wm );

        Cheese c = new Cheese();
        c.setPrice( 42 );
        c.setType( "stilton" );

        wm.facts.add( c );

        VerifyFact vf = new VerifyFact( "Cheese",
                                        new ArrayList(),
                                        true );
        vf.fieldValues.add( new VerifyField( "price",
                                             "42",
                                             "==" ) );
        vf.fieldValues.add( new VerifyField( "type",
                                             "stilton",
                                             "==" ) );

        runner.verify( vf );

        assertTrue( vf.wasSuccessful() );

        vf = new VerifyFact( "Person",
                             new ArrayList(),
                             true );
        vf.fieldValues.add( new VerifyField( "age",
                                             "42",
                                             "==" ) );

        runner.verify( vf );

        assertFalse( vf.wasSuccessful() );

        vf = new VerifyFact( "Cheese",
                             new ArrayList(),
                             true );
        vf.fieldValues.add( new VerifyField( "price",
                                             "43",
                                             "==" ) );
        vf.fieldValues.add( new VerifyField( "type",
                                             "stilton",
                                             "==" ) );

        runner.verify( vf );
        assertFalse( vf.wasSuccessful() );
        assertEquals( Boolean.FALSE,
                      ((VerifyField) vf.fieldValues.get( 0 )).successResult );

        vf = new VerifyFact( "Cell",
                             new ArrayList(),
                             true );
        vf.fieldValues.add( new VerifyField( "value",
                                             "43",
                                             "==" ) );

        runner.verify( vf );
        assertFalse( vf.wasSuccessful() );
        assertEquals( Boolean.FALSE,
                      ((VerifyField) vf.fieldValues.get( 0 )).successResult );

    }

    @Test
    public void testVerifyFactsWithOperator() throws Exception {
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheese f1 = new Cheese( "cheddar",
                                42 );
        runner.populatedData.put( "f1",
                                  f1 );

        // test all true
        VerifyFact vf = new VerifyFact();
        vf.name = "f1";
        vf.fieldValues = ls( new VerifyField( "type",
                                              "cheddar",
                                              "==" ),
                             new VerifyField( "price",
                                              "4777",
                                              "!=" ) );
        runner.verify( vf );
        for ( int i = 0; i < vf.fieldValues.size(); i++ ) {
            assertTrue( ((VerifyField) vf.fieldValues.get( i )).successResult );
        }

        vf = new VerifyFact();
        vf.name = "f1";
        vf.fieldValues = ls( new VerifyField( "type",
                                              "cheddar",
                                              "!=" ) );
        runner.verify( vf );
        assertFalse( ((VerifyField) vf.fieldValues.get( 0 )).successResult );

    }

    @Test
    public void testVerifyFactsWithExpression() throws Exception {
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheese f1 = new Cheese( "cheddar",
                                42 );
        runner.populatedData.put( "f1",
                                  f1 );
        f1.setPrice( 42 );
        // test all true
        VerifyFact vf = new VerifyFact();
        vf.name = "f1";
        vf.fieldValues = ls( new VerifyField( "price",
                                              "= 40 + 2",
                                              "==" ) );
        runner.verify( vf );

        assertTrue( ((VerifyField) vf.fieldValues.get( 0 )).successResult );
    }

    @Test
    public void testVerifyFactExplanation() throws Exception {
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheese f1 = new Cheese();
        f1.setType( null );
        runner.populatedData.put( "f1",
                                  f1 );

        VerifyFact vf = new VerifyFact();
        vf.name = "f1";
        vf.fieldValues.add( new VerifyField( "type",
                                             "boo",
                                             "!=" ) );

        runner.verify( vf );
        VerifyField vfl = (VerifyField) vf.fieldValues.get( 0 );
        assertEquals( "[f1] field [type] was not [boo].",
                      vfl.explanation );

    }

    @Test
    public void testVerifyFieldAndActualIsNull() throws Exception {
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheese f1 = new Cheese();
        f1.setType( null );
        runner.populatedData.put( "f1",
                                  f1 );

        VerifyFact vf = new VerifyFact();
        vf.name = "f1";
        vf.fieldValues.add( new VerifyField( "type",
                                             "boo",
                                             "==" ) );

        runner.verify( vf );
        VerifyField vfl = (VerifyField) vf.fieldValues.get( 0 );

        assertEquals( "[f1] field [type] was [] expected [boo].",
                      vfl.explanation );
        assertEquals( "boo",
                      vfl.expected );
        assertEquals( "",
                      vfl.actualResult );

    }

    @Test
    public void testDummyRunNoRules() throws Exception {
        Scenario sc = new Scenario();
        FactData[] facts = new FactData[]{new FactData( "Cheese",
                                                        "c1",
                                                        ls( new FieldData( "type",
                                                                           "cheddar" ),
                                                            new FieldData( "price",
                                                                           "42" ) ),
                                                        false )};

        VerifyFact[] assertions = new VerifyFact[]{new VerifyFact( "c1",
                                                                   ls( new VerifyField( "type",
                                                                                        "cheddar",
                                                                                        "==" ),
                                                                       new VerifyField( "price",
                                                                                        "42",
                                                                                        "==" ) ) )};

        sc.fixtures.addAll( Arrays.asList( facts ) );
        sc.fixtures.addAll( Arrays.asList( assertions ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );

        MockWorkingMemory wm = new MockWorkingMemory();
        ScenarioRunner runner = new ScenarioRunner( sc,
                                                    resolver,
                                                    wm );
        assertEquals( 1,
                      wm.facts.size() );
        assertEquals( runner.populatedData.get( "c1" ),
                      wm.facts.get( 0 ) );

        assertTrue( runner.populatedData.containsKey( "c1" ) );
        VerifyFact vf = (VerifyFact) assertions[0];
        for ( int i = 0; i < vf.fieldValues.size(); i++ ) {
            assertTrue( ((VerifyField) vf.fieldValues.get( i )).successResult );
        }

    }

    @Test
    public void testCountVerification() throws Exception {

        Map<String, Integer> firingCounts = new HashMap<String, Integer>();
        firingCounts.put( "foo",
                          2 );
        firingCounts.put( "bar",
                          1 );
        // and baz, we leave out

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        VerifyRuleFired v = new VerifyRuleFired();
        v.ruleName = "foo";
        v.expectedFire = true;
        runner.verify( v,
                       firingCounts );
        assertTrue( v.successResult );
        assertEquals( 2,
                      v.actualResult.intValue() );

        v = new VerifyRuleFired();
        v.ruleName = "foo";
        v.expectedFire = false;
        runner.verify( v,
                       firingCounts );
        assertFalse( v.successResult );
        assertEquals( 2,
                      v.actualResult.intValue() );
        assertNotNull( v.explanation );

        v = new VerifyRuleFired();
        v.ruleName = "foo";
        v.expectedCount = 2;

        runner.verify( v,
                       firingCounts );
        assertTrue( v.successResult );
        assertEquals( 2,
                      v.actualResult.intValue() );

    }

    @Test
    public void testRuleFiredWithEnum() throws Exception {
        Map<String, Integer> firingCounts = new HashMap<String, Integer>();
        firingCounts.put( "foo",
                          2 );
        firingCounts.put( "bar",
                          1 );
        // and baz, we leave out

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        VerifyRuleFired v = new VerifyRuleFired();
        v.ruleName = "foo";
        v.expectedFire = true;
        runner.verify( v,
                       firingCounts );
        assertTrue( v.successResult );
        assertEquals( 2,
                      v.actualResult.intValue() );
    }
    
    @Test
    public void testTestingEventListener() throws Exception {
        Scenario sc = new Scenario();
        sc.rules.add( "foo" );
        sc.rules.add( "bar" );
        ExecutionTrace ext = new ExecutionTrace();

        sc.fixtures.add( ext );

        MockWorkingMemory wm = new MockWorkingMemory();
        PseudoClockScheduler clock = new PseudoClockScheduler();
        long time = new Date().getTime();
        clock.setStartupTime( time );
        clock.setSession( wm );
        wm.setSessionClock( clock ); 
        
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 null,
                                                 wm );
        assertEquals( wm,
                      run.workingMemory );
        assertNotNull( wm.agendaEventListener );
        assertTrue( wm.agendaEventListener instanceof TestingEventListener );
        TestingEventListener lnr = (TestingEventListener) wm.agendaEventListener;
        assertEquals( 2,
                      sc.rules.size() );
        assertTrue( sc.rules.contains( "foo" ) );
        assertTrue( sc.rules.contains( "bar" ) );
    }

    @Test
    public void testWithGlobals() throws Exception {
        Scenario sc = new Scenario();
        FactData[] facts = new FactData[]{new FactData( "Cheese",
                                                        "c2",
                                                        ls( new FieldData( "type",
                                                                           "stilton" ) ),
                                                        false )};
        sc.globals.add( new FactData( "Cheese",
                                      "c",
                                      ls( new FieldData( "type",
                                                         "cheddar" ) ),
                                      false ) );
        sc.fixtures.addAll( Arrays.asList( facts ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );

        MockWorkingMemory wm = new MockWorkingMemory();
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 wm );
        assertEquals( 1,
                      wm.globals.size() );
        assertEquals( 1,
                      run.globalData.size() );
        assertEquals( 1,
                      run.populatedData.size() );
        assertEquals( 1,
                      wm.facts.size() );

        Cheese c = (Cheese) wm.globals.get( "c" );
        assertEquals( "cheddar",
                      c.getType() );
        Cheese c2 = (Cheese) wm.facts.get( 0 );
        assertEquals( "stilton",
                      c2.getType() );

    }

    /**
     * Check if global list is empty.
     */
    @Test
    public void testWithGlobalList() throws Exception {
        Scenario sc = new Scenario();
        sc.globals.add( new FactData( "List",
                                      "testList",
                                      new ArrayList(),
                                      false ) );

        Expectation[] assertions = new Expectation[2];

        assertions[0] = new VerifyFact( "testList",
                                        ls( new VerifyField( "empty",
                                                             "true",
                                                             "==" ) ) );
        assertions[1] = new VerifyFact( "testList",
                                        ls( new VerifyField( "size",
                                                             "0",
                                                             "==" ) ) );

        sc.fixtures.addAll( Arrays.asList( assertions ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "java.util.List" );

        MockWorkingMemory wm = new MockWorkingMemory();
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 wm );

        List testList = (List) wm.globals.get( "testList" );
        assertTrue( testList.isEmpty() );
        assertEquals( 0,
                      testList.size() );
    }

    @SuppressWarnings("deprecation")
    // F**** dates in java. What a mess. Someone should die.
    @Test
    public void testSimulatedDate() throws Exception {
        Scenario sc = new Scenario();
        MockWorkingMemory wm = new MockWorkingMemory();
        PseudoClockScheduler clock = new PseudoClockScheduler();
        long time = new Date().getTime();
        clock.setStartupTime( time );
        clock.setSession( wm );
        wm.setSessionClock( clock );        
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 null,
                                                 wm );

        assertEquals( time, wm.getSessionClock().getCurrentTime() );
        
        ExecutionTrace ext = new ExecutionTrace();
        ext.setScenarioSimulatedDate( new Date( "10-Jul-1974" ) );
        sc.fixtures.add( ext );
        run = new ScenarioRunner( sc,
                                  null,
                                  wm );

        long expected = ext.getScenarioSimulatedDate().getTime();
        assertEquals( expected,
                      wm.getSessionClock().getCurrentTime() );
//        Thread.sleep( 50 );
//        assertEquals( expected,
//                      tm.getNow().getTimeInMillis() );

    }

    @Test
    public void testVerifyRuleFired() throws Exception {
        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );

        VerifyRuleFired vr = new VerifyRuleFired( "qqq",
                                                  42,
                                                  null );
        Map<String, Integer> f = new HashMap<String, Integer>();
        f.put( "qqq",
               42 );
        f.put( "qaz",
               1 );

        runner.verify( vr,
                       f );
        assertTrue( vr.wasSuccessful() );
        assertEquals( 42,
                      vr.actualResult.intValue() );

        vr = new VerifyRuleFired( "qqq",
                                  41,
                                  null );
        runner.verify( vr,
                       f );
        assertFalse( vr.wasSuccessful() );
        assertEquals( 42,
                      vr.actualResult.intValue() );

        vr = new VerifyRuleFired( "qaz",
                                  1,
                                  null );
        runner.verify( vr,
                       f );
        assertTrue( vr.wasSuccessful() );
        assertEquals( 1,
                      vr.actualResult.intValue() );

        vr = new VerifyRuleFired( "XXX",
                                  null,
                                  false );
        runner.verify( vr,
                       f );
        assertTrue( vr.wasSuccessful() );
        assertEquals( 0,
                      vr.actualResult.intValue() );

        vr = new VerifyRuleFired( "qqq",
                                  null,
                                  true );
        runner.verify( vr,
                       f );
        assertTrue( vr.wasSuccessful() );
        assertEquals( 42,
                      vr.actualResult.intValue() );

        vr = new VerifyRuleFired( "qqq",
                                  null,
                                  false );
        runner.verify( vr,
                       f );
        assertFalse( vr.wasSuccessful() );
        assertEquals( 42,
                      vr.actualResult.intValue() );

    }

    /**
     * Do a kind of end to end test with some real rules.
     */
    @Test
    public void testIntegrationWithSuccess() throws Exception {

        Scenario sc = new Scenario();
        FactData[] facts = new FactData[]{new FactData( "Cheese",
                                                        "c1",
                                                        ls( new FieldData( "type",
                                                                           "cheddar" ),
                                                            new FieldData( "price",
                                                                           "42" ) ),
                                                        false )

        };
        sc.globals.add( new FactData( "Person",
                                      "p",
                                      new ArrayList(),
                                      false ) );
        sc.fixtures.addAll( Arrays.asList( facts ) );

        ExecutionTrace executionTrace = new ExecutionTrace();

        sc.rules.add( "rule1" );
        sc.rules.add( "rule2" );
        sc.inclusive = true;
        sc.fixtures.add( executionTrace );

        Expectation[] assertions = new Expectation[5];

        assertions[0] = new VerifyFact( "c1",
                                        ls( new VerifyField( "type",
                                                             "cheddar",
                                                             "==" )

                                        ) );

        assertions[1] = new VerifyFact( "p",
                                        ls( new VerifyField( "name",
                                                             "rule1",
                                                             "==" ),
                                            new VerifyField( "status",
                                                             "rule2",
                                                             "==" ) )

        );

        assertions[2] = new VerifyRuleFired( "rule1",
                                             1,
                                             null );
        assertions[3] = new VerifyRuleFired( "rule2",
                                             1,
                                             null );
        assertions[4] = new VerifyRuleFired( "rule3",
                                             0,
                                             null );

        sc.fixtures.addAll( Arrays.asList( assertions ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.Person" );

        WorkingMemory wm = getWorkingMemory( "test_rules2.drl" );

        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        assertEquals( 2,
                      executionTrace.getNumberOfRulesFired().intValue() );

        assertSame( run.scenario,
                    sc );

        assertTrue( sc.wasSuccessful() );

        Person p = (Person) run.globalData.get( "p" );
        assertEquals( "rule1",
                      p.getName() );
        assertEquals( "rule2",
                      p.getStatus() );
        assertEquals( 0,
                      p.getAge() );

        Thread.sleep( 50 );

        assertTrue( (new Date()).after( sc.lastRunResult ) );
        assertTrue( executionTrace.getExecutionTimeResult() != null );

        assertTrue( executionTrace.getRulesFired().length > 0 );

    }

    @Test
    public void testIntegrationInfiniteLoop() throws Exception {

        Scenario sc = new Scenario();
        FactData[] facts = new FactData[]{new FactData( "Cheese",
                                                        "c1",
                                                        ls( new FieldData( "type",
                                                                           "cheddar" ),
                                                            new FieldData( "price",
                                                                           "42" ) ),
                                                        false )

        };
        sc.globals.add( new FactData( "Person",
                                      "p",
                                      new ArrayList(),
                                      false ) );
        sc.fixtures.addAll( Arrays.asList( facts ) );

        ExecutionTrace executionTrace = new ExecutionTrace();

        sc.rules.add( "rule1" );
        sc.rules.add( "rule2" );
        sc.inclusive = true;
        sc.fixtures.add( executionTrace );

        Expectation[] assertions = new Expectation[5];

        assertions[0] = new VerifyFact( "c1",
                                        ls( new VerifyField( "type",
                                                             "cheddar",
                                                             "==" )

                                        ) );

        assertions[1] = new VerifyFact( "p",
                                        ls( new VerifyField( "name",
                                                             "rule1",
                                                             "==" ),
                                            new VerifyField( "status",
                                                             "rule2",
                                                             "==" ) )

        );

        assertions[2] = new VerifyRuleFired( "rule1",
                                             1,
                                             null );
        assertions[3] = new VerifyRuleFired( "rule2",
                                             1,
                                             null );
        assertions[4] = new VerifyRuleFired( "rule3",
                                             0,
                                             null );

        sc.fixtures.addAll( Arrays.asList( assertions ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.Person" );

        WorkingMemory wm = getWorkingMemory( "test_rules_infinite_loop.drl" );

        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        assertEquals( sc.maxRuleFirings,
                      executionTrace.getNumberOfRulesFired().intValue() );

    }

    @Test
    public void testIntegrationWithDeclaredTypes() throws Exception {
        Scenario sc = new Scenario();
        FactData[] facts = new FactData[]{new FactData( "Coolness",
                                                        "c",
                                                        ls( new FieldData( "num",
                                                                           "42" ),
                                                            new FieldData( "name",
                                                                           "mic" ) ),
                                                        false )

        };
        sc.fixtures.addAll( Arrays.asList( facts ) );

        ExecutionTrace executionTrace = new ExecutionTrace();

        sc.rules.add( "rule1" );
        sc.inclusive = true;
        sc.fixtures.add( executionTrace );

        Expectation[] assertions = new Expectation[2];

        assertions[0] = new VerifyFact( "c",
                                        ls( new VerifyField( "num",
                                                             "42",
                                                             "==" )

                                        ) );

        assertions[1] = new VerifyRuleFired( "rule1",
                                             1,
                                             null );

        sc.fixtures.addAll( Arrays.asList( assertions ) );

        WorkingMemory wm = getWorkingMemory( "test_rules3.drl" );
        ClassLoader cl = ((InternalRuleBase) wm.getRuleBase()).getRootClassLoader();

        HashSet<String> imports = new HashSet<String>();
        imports.add( "foo.bar.*" );

        TypeResolver resolver = new ClassTypeResolver( imports,
                                                       cl );

        Class cls = cl.loadClass( "foo.bar.Coolness" );
        assertNotNull( cls );

        ClassLoader cl_ = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader( cl );

        //resolver will need to have generated beans in it - possibly using a composite classloader from the package,
        //including whatever CL has the generated beans...
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        assertEquals( 1,
                      executionTrace.getNumberOfRulesFired().intValue() );

        assertSame( run.scenario,
                    sc );

        assertTrue( sc.wasSuccessful() );

        Thread.currentThread().setContextClassLoader( cl_ );

    }

    @Test
    public void testRuleFlowGroupActivation() throws Exception {
        Scenario sc = new Scenario();
        Fixture[] given = new Fixture[]{new FactData( "Coolness",
                                                      "c",
                                                      ls( new FieldData( "num",
                                                                         "42" ),
                                                          new FieldData( "name",
                                                                         "mic" ) ),
                                                      false )

        };
        sc.fixtures.addAll( Arrays.asList( given ) );

        ExecutionTrace executionTrace = new ExecutionTrace();

        sc.rules.add( "rule1" );
        sc.inclusive = true;
        sc.fixtures.add( executionTrace );

        Expectation[] assertions = new Expectation[2];

        assertions[0] = new VerifyFact( "c",
                                        ls( new VerifyField( "num",
                                                             "42",
                                                             "==" ) ) );

        assertions[1] = new VerifyRuleFired( "rule1",
                                             1,
                                             null );

        sc.fixtures.addAll( Arrays.asList( assertions ) );

        WorkingMemory wm = getWorkingMemory( "rule_flow_actication.drl" );
        ClassLoader cl = ((InternalRuleBase) wm.getRuleBase()).getRootClassLoader();

        HashSet<String> imports = new HashSet<String>();
        imports.add( "foo.bar.*" );

        TypeResolver resolver = new ClassTypeResolver( imports,
                                                       cl );

        Class cls = cl.loadClass( "foo.bar.Coolness" );
        assertNotNull( cls );

        ClassLoader cl_ = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader( cl );

        //resolver will need to have generated beans in it - possibly using a composite classloader from the package,
        //including whatever CL has the generated beans...
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        assertEquals( 0,
                      executionTrace.getNumberOfRulesFired().intValue() );

        assertSame( run.scenario,
                    sc );

        assertFalse( sc.wasSuccessful() );


        // Activate rule flow
        sc.fixtures.clear();
        given = new Fixture[]{new FactData( "Coolness",
                                            "c",
                                            ls( new FieldData( "num",
                                                               "42" ),
                                                new FieldData( "name",
                                                               "mic" ) ),
                                            false ), new ActivateRuleFlowGroup( "asdf" )

        };
        wm.clearAgenda();
        sc.fixtures.addAll( Arrays.asList( given ) );
        sc.fixtures.add( executionTrace );
        wm.getAgenda().getRuleFlowGroup( "asdf" ).setAutoDeactivate( false );
        run = new ScenarioRunner( sc,
                                  resolver,
                                  (InternalWorkingMemory) wm );

        assertEquals( 1,
                      executionTrace.getNumberOfRulesFired().intValue() );

        assertSame( run.scenario,
                    sc );

        assertTrue( sc.wasSuccessful() );
        
        Thread.currentThread().setContextClassLoader( cl_ );
    }

    @Test
    public void testIntgerationStateful() throws Exception {
        Scenario sc = new Scenario();
        sc.fixtures.add( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "price",
                                                          "1" ) ),
                                       false ) );
        ExecutionTrace ex = new ExecutionTrace();
        sc.fixtures.add( ex );
        sc.fixtures.add( new FactData( "Cheese",
                                       "c2",
                                       ls( new FieldData( "price",
                                                          "2" ) ),
                                       false ) );
        sc.fixtures.add( new VerifyFact( "c1",
                                         ls( new VerifyField( "type",
                                                              "rule1",
                                                              "==" ) ) ) );
        ex = new ExecutionTrace();
        sc.fixtures.add( ex );
        sc.fixtures.add( new VerifyFact( "c1",
                                         ls( new VerifyField( "type",
                                                              "rule2",
                                                              "==" ) ) ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );

        WorkingMemory wm = getWorkingMemory( "test_stateful.drl" );
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        Cheese c1 = (Cheese) run.populatedData.get( "c1" );
        Cheese c2 = (Cheese) run.populatedData.get( "c2" );

        assertEquals( "rule2",
                      c1.getType() );
        assertEquals( "rule2",
                      c2.getType() );

        assertTrue( sc.wasSuccessful() );

    }

    @Test
    public void testIntegrationWithModify() throws Exception {
        Scenario sc = new Scenario();
        sc.fixtures.add( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "price",
                                                          "1" ) ),
                                       false ) );

        sc.fixtures.add( new ExecutionTrace() );

        sc.fixtures.add( new VerifyFact( "c1",
                                         ls( new VerifyField( "type",
                                                              "rule1",
                                                              "==" ) ) ) );

        sc.fixtures.add( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "price",
                                                          "42" ) ),
                                       true ) );
        sc.fixtures.add( new ExecutionTrace() );

        sc.fixtures.add( new VerifyFact( "c1",
                                         ls( new VerifyField( "type",
                                                              "rule3",
                                                              "==" ) ) ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );

        WorkingMemory wm = getWorkingMemory( "test_stateful.drl" );
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        Cheese c1 = (Cheese) run.populatedData.get( "c1" );

        assertEquals( "rule3",
                      c1.getType() );

        assertTrue( sc.wasSuccessful() );
    }

    @Test
    public void testIntegrationWithRetract() throws Exception {
        Scenario sc = new Scenario();
        sc.fixtures.add( new FactData( "Cheese",
                                       "c1",
                                       ls( new FieldData( "price",
                                                          "46" ),
                                           new FieldData( "type",
                                                          "XXX" ) ),
                                       false ) );
        sc.fixtures.add( new FactData( "Cheese",
                                       "c2",
                                       ls( new FieldData( "price",
                                                          "42" ) ),
                                       false ) );
        sc.fixtures.add( new ExecutionTrace() );

        sc.fixtures.add( new VerifyFact( "c1",
                                         ls( new VerifyField( "type",
                                                              "XXX",
                                                              "==" ) ) ) );

        sc.fixtures.add( new RetractFact( "c2" ) );
        sc.fixtures.add( new ExecutionTrace() );

        sc.fixtures.add( new VerifyFact( "c1",
                                         ls( new VerifyField( "type",
                                                              "rule4",
                                                              "==" ) ) ) );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );

        WorkingMemory wm = getWorkingMemory( "test_stateful.drl" );
        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        Cheese c1 = (Cheese) run.populatedData.get( "c1" );

        assertEquals( "rule4",
                      c1.getType() );
        assertFalse( run.populatedData.containsKey( "c2" ) );

        assertTrue( sc.wasSuccessful() );
    }

    @Test
    public void testIntegrationWithFailure() throws Exception {
        Scenario sc = new Scenario();
        Expectation[] assertions = populateScenarioForFailure( sc );

        TypeResolver resolver = new ClassTypeResolver( new HashSet<String>(),
                                                       Thread.currentThread().getContextClassLoader() );
        resolver.addImport( "org.drools.Cheese" );
        resolver.addImport( "org.drools.Person" );

        WorkingMemory wm = getWorkingMemory( "test_rules2.drl" );

        ScenarioRunner run = new ScenarioRunner( sc,
                                                 resolver,
                                                 (InternalWorkingMemory) wm );

        assertSame( run.scenario,
                    sc );

        assertFalse( sc.wasSuccessful() );

        VerifyFact vf = (VerifyFact) assertions[1];
        assertFalse( ((VerifyField) vf.fieldValues.get( 0 )).successResult );
        assertEquals( "XXX",
                      ((VerifyField) vf.fieldValues.get( 0 )).expected );
        assertEquals( "rule1",
                      ((VerifyField) vf.fieldValues.get( 0 )).actualResult );
        assertNotNull( ((VerifyField) vf.fieldValues.get( 0 )).explanation );

        VerifyRuleFired vr = (VerifyRuleFired) assertions[4];
        assertFalse( vr.successResult );

        assertEquals( 2,
                      vr.expectedCount.intValue() );
        assertEquals( 0,
                      vr.actualResult.intValue() );

    }

    @Test
    public void testRunAsString() throws Exception {
        Scenario sc = new Scenario();
        populateScenarioForFailure( sc );
        String xml = ScenarioXMLPersistence.getInstance().marshal( sc );
        WorkingMemory wm = getWorkingMemory( "test_rules2.drl" );
        ScenarioRunner runner = new ScenarioRunner( xml,
                                                    wm.getRuleBase() );
        assertFalse( runner.wasSuccess() );

        String failures = runner.getReport();
        assertFalse( "".equals( failures ) );
        System.err.println( failures );
    }

    private Expectation[] populateScenarioForFailure(Scenario sc) {
        FactData[] facts = new FactData[]{new FactData( "Cheese",
                                                        "c1",
                                                        ls( new FieldData( "type",
                                                                           "cheddar" ),
                                                            new FieldData( "price",
                                                                           "42" ) ),
                                                        false )

        };
        sc.fixtures.addAll( Arrays.asList( facts ) );
        sc.globals.add( new FactData( "Person",
                                      "p",
                                      new ArrayList(),
                                      false ) );

        ExecutionTrace executionTrace = new ExecutionTrace();
        sc.rules.add( "rule1" );
        sc.rules.add( "rule2" );
        sc.inclusive = true;
        sc.fixtures.add( executionTrace );

        Expectation[] assertions = new Expectation[5];

        assertions[0] = new VerifyFact( "c1",
                                        ls( new VerifyField( "type",
                                                             "cheddar",
                                                             "==" )

                                        ) );

        assertions[1] = new VerifyFact( "p",
                                        ls( new VerifyField( "name",
                                                             "XXX",
                                                             "==" ),
                                            new VerifyField( "status",
                                                             "rule2",
                                                             "==" )

                                        ) );

        assertions[2] = new VerifyRuleFired( "rule1",
                                             1,
                                             null );
        assertions[3] = new VerifyRuleFired( "rule2",
                                             1,
                                             null );
        assertions[4] = new VerifyRuleFired( "rule3",
                                             2,
                                             null );

        sc.fixtures.addAll( Arrays.asList( assertions ) );
        return assertions;
    }

    private <T> List<T> ls(T... objects) {
        return Arrays.asList( objects );
    }
    @Test
    public void testCollectionFieldInFacts() throws Exception {

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheesery listChesse = new Cheesery();
        Cheese f1 = new Cheese( "cheddar",
                                42 );
        Cheese f2 = new Cheese( "Camembert",
                                43 );
        Cheese f3 = new Cheese( "Emmental",
                                45 );
        runner.populatedData.put( "f1",
                                  f1 );
        runner.populatedData.put( "f2",
                                  f2 );
        runner.populatedData.put( "f3",
                                  f3 );
        FactData fd1 = new FactData( "Cheese",
                                    "f1",
                                    ls( new FieldData( "type",
                                                       "" ),
                                        new FieldData( "price",
                                                       "42" ) ),
                                    false );
         FactData fd2 = new FactData( "Cheese",
                                    "f2",
                                    ls( new FieldData( "type",
                                                       "" ),
                                        new FieldData( "price",
                                                       "43" ) ),
                                    false );
         FactData fd3 = new FactData( "Cheese",
                                    "f3",
                                    ls( new FieldData( "type",
                                                       "" ),
                                        new FieldData( "price",
                                                       "45" ) ),
                                    false );
         runner.populatedData.put("ACheesery",listChesse);
         FieldData field = new FieldData();
         field.name="cheeses";
         field.collectionType="Cheese";
         field.nature = FieldData.TYPE_COLLECTION;
          field.value="=[f1,f2,f3]";
         List<FieldData> lstField = new ArrayList<FieldData>();
         lstField.add(field);
          FactData lst = new FactData( "Cheesery",
                                    "listChesse",
                                    lstField,
                                    false );
        runner.populateFields(lst,runner.populatedData,listChesse, null);
        assertTrue(listChesse.getCheeses().size()==3);
        assertTrue(listChesse.getCheeses().contains(f1));
        assertTrue(listChesse.getCheeses().contains(f3));
        assertTrue(listChesse.getCheeses().contains(f3));
  
    }
    @Test
    public void testCallMethodNoArgumentOnFact() throws Exception {

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheesery listChesse = new Cheesery();
        listChesse.setTotalAmount(1000);
		runner.populatedData.put("cheese", listChesse);
        CallMethod mCall = new CallMethod();
        mCall.variable="cheese";
        mCall.methodName="setTotalAmountToZero";
        runner.executeMethodOnObject(mCall, listChesse);
        assertTrue(listChesse.getTotalAmount()==0);
    }
    
    @Test
    public void testCallMethodOnStandardArgumentOnFact() throws Exception {

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheesery listChesse = new Cheesery();
        listChesse.setTotalAmount(1000);
		runner.populatedData.put("cheese", listChesse);
        CallMethod mCall = new CallMethod();
        mCall.variable="cheese";
        mCall.methodName="addToTotalAmount";
        CallFieldValue field = new CallFieldValue();
        field.value="5";
        mCall.addFieldValue(field);
        runner.executeMethodOnObject(mCall, listChesse);
        assertTrue(listChesse.getTotalAmount()==1005);
    }
    
    @Test
    public void testCallMethodOnClassArgumentOnFact() throws Exception {

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheesery listChesse = new Cheesery();
        listChesse.setTotalAmount(1000);
		runner.populatedData.put("cheese", listChesse);
        Maturity m = new Maturity();
        runner.populatedData.put( "m",
                                  m );
        CallMethod mCall = new CallMethod();
        mCall.variable="cheese";
        mCall.methodName="setGoodMaturity";
        CallFieldValue field = new CallFieldValue();
        field.value="=m";
        mCall.addFieldValue(field);
        runner.executeMethodOnObject(mCall, listChesse);
        assertTrue(listChesse.getMaturity().equals(m));
        assertTrue(listChesse.getMaturity()==m);
    }
    @Test
    public void testCallMethodOnClassArgumentAndOnArgumentStandardOnFact() throws Exception {

        ScenarioRunner runner = new ScenarioRunner( new Scenario(),
                                                    null,
                                                    new MockWorkingMemory() );
        Cheesery listChesse = new Cheesery();
        listChesse.setTotalAmount(1000);
		runner.populatedData.put("cheese", listChesse);
        Maturity m = new Maturity("veryYoung");
        runner.populatedData.put( "m",
                                  m );
        CallMethod mCall = new CallMethod();
        mCall.variable="cheese";
        mCall.methodName="setAgeToMaturity";
        CallFieldValue field = new CallFieldValue();
        field.value="=m";
        mCall.addFieldValue(field);
        CallFieldValue field2 = new CallFieldValue();
        field2.value="veryold";
        mCall.addFieldValue(field2);
        runner.executeMethodOnObject(mCall, listChesse);
        assertTrue(m.getAge().equals("veryold"));
    }
    
}
