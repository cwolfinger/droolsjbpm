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

package org.drools.ide.common.client.modeldriven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.drools.ide.common.client.modeldriven.FieldAccessorsAndMutators;
import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine;
import org.drools.ide.common.server.rules.SuggestionCompletionLoader;
import org.drools.lang.dsl.DSLTokenizedMappingFile;

public class SuggestionCompletionEngine2Test {

    @Test
    public void testAccessorsAndMutatorsDeclaredModel() throws Exception {
        String pkg = "package org.test\n";
        pkg += "declare Test\n";
        pkg += "number: Integer\n";
        pkg += "end\n";

        SuggestionCompletionLoader loader = new SuggestionCompletionLoader();

        SuggestionCompletionEngine engine = loader.getSuggestionEngine( pkg,
                                                                        new ArrayList<JarInputStream>(),
                                                                        new ArrayList<DSLTokenizedMappingFile>(),
                                                                        new ArrayList<String>() );

        String[] accessors = engine.getFieldCompletions( FieldAccessorsAndMutators.ACCESSOR,
                                                         "Test" );
        assertEquals( 2,
                      accessors.length );

        String[] mutators = engine.getFieldCompletions( FieldAccessorsAndMutators.MUTATOR,
                                                        "Test" );
        assertEquals( 2,
                      mutators.length );

    }
    
    @Test
    public void testAccessorsAndMutatorsJavaClass() throws Exception {
        String pkg = "package org.test\n import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine2Test.Person\n";
        
        SuggestionCompletionLoader loader = new SuggestionCompletionLoader();
        
        SuggestionCompletionEngine engine = loader.getSuggestionEngine( pkg,
                                                                        new ArrayList<JarInputStream>(),
                                                                        new ArrayList<DSLTokenizedMappingFile>(),
                                                                        new ArrayList<String>() );
        
        String[] accessors = engine.getFieldCompletions( FieldAccessorsAndMutators.ACCESSOR,
        "SuggestionCompletionEngine2Test$Person" );
        assertEquals( 3,
                      accessors.length );
        
        String[] mutators = engine.getFieldCompletions( FieldAccessorsAndMutators.MUTATOR,
        "SuggestionCompletionEngine2Test$Person" );
        assertEquals( 3,
                      mutators.length );
        
    }

    @Test
    public void testArrayList() {

        String pkg = "package org.test\n global java.util.ArrayList testList";
        SuggestionCompletionLoader loader = new SuggestionCompletionLoader();

        SuggestionCompletionEngine engine = loader.getSuggestionEngine( pkg,
                                                                        new ArrayList<JarInputStream>(),
                                                                        new ArrayList<DSLTokenizedMappingFile>(),
                                                                        new ArrayList<String>() );

        List<String> methodNames = engine.getMethodNames( "ArrayList" );

        //        for ( String name : methodNames ) {
        //            System.out.println( name );
        //        }

        assertNotNull( methodNames );
        assertFalse( methodNames.isEmpty() );
        for ( String s : methodNames ) {
            assertFalse( "Method " + s + " is not allowed.",
                         allowedMethod( s ) );
        }

    }

    @Test
    public void testJarFileWithSourceFiles() {
        SuggestionCompletionLoader loader = new SuggestionCompletionLoader();

        // Add jar file
        String header = "package foo \n import org.test.Person \n import org.test.Banana \n ";
        List<JarInputStream> jars = new ArrayList<JarInputStream>();
        JarInputStream jis = null;
        SuggestionCompletionEngine suggestionCompletionEngine = null;

        try {
            jis = new JarInputStream( this.getClass().getResourceAsStream( "/JarWithSourceFiles.jar" ) );
            jars.add( jis );
        } catch ( IOException e ) {
            fail( "Could not load jar" );
        }

        try {
            suggestionCompletionEngine = loader.getSuggestionEngine( header,
                                                                     jars,
                                                                     new ArrayList<DSLTokenizedMappingFile>() );
        } catch ( ClassFormatError e ) {
            fail( "Can not load suggestions " + e );
        }

        // Check that it throws no error and has class files inside.
        assertNotNull( jis );
        assertNotNull( suggestionCompletionEngine );
        assertEquals( 2,
                      suggestionCompletionEngine.getFactTypes().length );

        List<String> list = Arrays.asList( suggestionCompletionEngine.getFactTypes() );

        assertTrue( list.contains( "Person" ) );
        assertTrue( list.contains( "Banana" ) );

        assertEquals( "java.util.Collection",
                      suggestionCompletionEngine.getFieldClassName( "Person",
                                                                    "bananas" ) );
        assertEquals( SuggestionCompletionEngine.TYPE_COLLECTION,
                      suggestionCompletionEngine.getFieldType( "Person",
                                                               "bananas" ) );
        assertEquals( "Banana",
                      suggestionCompletionEngine.getParametricFieldType( "Person",
                                                                         "bananas" ) );

    }

    private boolean allowedMethod(String methodName) {
        return ("hashCode".equals( methodName ) || "equals".equals( methodName ) || "listIterator".equals( methodName ) || "lastIndexOf".equals( methodName ) || "indexOf".equals( methodName ) || "subList".equals( methodName )
                || "get".equals( methodName ) || "isEmpty".equals( methodName ) || "containsKey".equals( methodName ) || "values".equals( methodName ) || "entrySet".equals( methodName ) || "containsValue".equals( methodName )
                || "keySet".equals( methodName ) || "size".equals( methodName ) || "toArray".equals( methodName ) || "iterator".equals( methodName ) || "contains".equals( methodName ) || "isEmpty".equals( methodName )
                || "containsAll".equals( methodName ) || "size".equals( methodName ));
    }

    public static class Person {

        private String name;
        private int    age;
        private String something;

        public String getSomething() {
            return something;
        }

        public void setSomething(String something) {
            this.something = something;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addPet(String petName) {

        }
    }
}
