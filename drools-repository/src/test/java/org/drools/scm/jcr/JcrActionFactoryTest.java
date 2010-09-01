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

package org.drools.scm.jcr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.drools.repository.AssetItem;
import org.drools.repository.PackageItem;
import org.drools.repository.RepositoryTestCase;
import org.drools.repository.RulesRepository;
import org.drools.scm.CompositeScmAction;
import org.drools.scm.ScmAction;
import org.drools.scm.ScmActionFactory;
import org.drools.scm.ScmEntry;
import org.drools.scm.jcr.JcrActionFactory.AddDirectory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JcrActionFactoryTest extends RepositoryTestCase {

	@Test
    public void testMapPathNameToPackage() {
        JcrActionFactory fact = new JcrActionFactory( null );
        assertEquals( "org.foo.bar",
                      fact.toPackageName( "org/foo/bar" ) );
        assertEquals( "foo",
                      fact.toPackageName( "foo" ) );
        assertEquals( "FooBar",
                      fact.toPackageName( "FooBar" ) );

        assertEquals( "org/foo/bar",
                      fact.toDirectoryName( "org.foo.bar" ) );
        assertEquals( "foo",
                      fact.toDirectoryName( "foo" ) );
    }

	@Test
    public void testAddDirectories() throws Exception {
        ScmActionFactory svn = new JcrActionFactory( getRepo() );

        CompositeScmAction actions = new CompositeScmAction();

        // Correctly add a new Directory at root
        actions = new CompositeScmAction();
        ScmAction addDirectory = new AddDirectory( "",
                                                   "folder1" );
        actions.addScmAction( addDirectory );

        svn.execute( actions,
                     "test message" );

        // Now check various flat and deep Directory creations
        actions = new CompositeScmAction();

        addDirectory = new AddDirectory( "folder1",
                                         "folder1_1" );
        actions.addScmAction( addDirectory );

        addDirectory = new AddDirectory( "folder1/folder1_1",
                                         "folder1_1_1" );
        actions.addScmAction( addDirectory );

        addDirectory = new AddDirectory( "folder1",
                                         "folder1_2" );
        actions.addScmAction( addDirectory );

        addDirectory = new AddDirectory( "",
                                         "folder2/folder2_1" );
        actions.addScmAction( addDirectory );

        addDirectory = new AddDirectory( "",
                                         "folder3/folder3_1/folder3_1_1/folder3_1_1_1" );
        actions.addScmAction( addDirectory );

        svn.execute( actions,
                     "test message" );
        //------
        // Now test results
        //-------                
        List list = convertToStringList( svn.listEntries( "" ) );

        assertTrue( list.contains( "folder1" ) );
        assertTrue( list.contains( "folder1/folder1_1" ) );
        assertTrue( list.contains( "folder1/folder1_2" ) );
        assertTrue( list.contains( "folder2/folder2_1" ) );
        assertTrue( list.contains( "folder3/folder3_1/folder3_1_1/folder3_1_1_1" ) );
    }

	@Test
    public void testAddFiles() throws Exception {
        RulesRepository repo = getRepo();

        repo.createPackage( "testAddFiles.package",
                            "just for testing" );

        JcrActionFactory fact = new JcrActionFactory( repo );

        byte[] data = "this is content".getBytes();
        ScmAction action = fact.addFile( "testAddFiles/package",
                                         "someFile.drl",
                                         data );

        fact.execute( action,
                      "some message" );

        PackageItem pk = repo.loadPackage( "testAddFiles.package" );
        AssetItem asset = pk.loadAsset( "someFile" );

        assertEquals( "drl",
                      asset.getFormat() );
        assertEquals( "this is content",
                      asset.getContent() );
        assertEquals( "some message",
                      asset.getDescription() );
        assertEquals( "Draft",
                      asset.getStateDescription() );
    }

	@Test
    public void testUpdateFiles() throws Exception {
        RulesRepository repo = getRepo();
        PackageItem pkg = repo.loadDefaultPackage();
        AssetItem asset = pkg.addAsset( "testUpdateFilesSVN",
                                        "something" );

        asset.updateContent( "lala" );
        asset.checkin( "yeah" );
        long oldVersion = asset.getVersionNumber();

        JcrActionFactory fact = new JcrActionFactory( repo );
        ScmAction action = fact.updateFile( RulesRepository.DEFAULT_PACKAGE,
                                            "testUpdateFilesSVN.drl",
                                            "lala".getBytes(),
                                            "lala2".getBytes() );

        fact.execute( action,
                      "goo" );

        AssetItem asset2 = pkg.loadAsset( "testUpdateFilesSVN" );
        assertFalse( oldVersion == asset2.getVersionNumber() );
        assertEquals( "lala2",
                      asset2.getContent() );
        assertEquals( "goo",
                      asset2.getCheckinComment() );
    }

    public static List convertToStringList(List list) {
        List files = new ArrayList( list.size() );

        for ( Iterator it = list.iterator(); it.hasNext(); ) {
            ScmEntry entry = (ScmEntry) it.next();
            files.add( entry.getPath().equals( "" ) ? entry.getName() : entry.getPath() + "/" + entry.getName() );
        }
        return files;
    }

}
