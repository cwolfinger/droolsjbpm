/**
 * 
 */
package org.drools.integrationtests;

import java.util.Calendar;

import junit.framework.TestCase;

import org.drools.Coverage;
import org.drools.EmployeeStatus;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.base.EffectiveRangeAgendaFilter;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.common.TemporalFactHandle;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

/**
 * @author etirelli
 *
 */
public class TemporalFactsTest extends TestCase {

    public void testTemporalFactCreation() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newInputStreamResource( getClass().getResourceAsStream( "test_TemporalFacts.drl" ) ),
                      ResourceType.DRL );

        assertFalse( kbuilder.getErrors().toString(),
                     kbuilder.hasErrors() );

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

        Calendar start = Calendar.getInstance();
        start.set( 2009,
                   07,
                   10 );
        Calendar end = Calendar.getInstance();
        end.set( 2009,
                 10,
                 25 );

        EmployeeStatus es1 = new EmployeeStatus( "e1",
                                                 "full time",
                                                 start.getTime(),
                                                 end.getTime() );

        FactHandle handle = ksession.insert( es1 );

        assertNotNull( handle );
        assertTrue( handle instanceof TemporalFactHandle );
        TemporalFactHandle thandle = (TemporalFactHandle) handle;
        assertEquals( start.getTimeInMillis(),
                      thandle.getStartTimestamp() );
        assertEquals( end.getTimeInMillis(),
                      thandle.getEndTimestamp() );
        assertEquals( end.getTimeInMillis() - start.getTimeInMillis(),
                      thandle.getDuration() );
        
        ksession.fireAllRules();

    }
    
    public void testTemporalMatching() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newInputStreamResource( getClass().getResourceAsStream( "test_TemporalFacts.drl" ) ),
                      ResourceType.DRL );

        assertFalse( kbuilder.getErrors().toString(),
                     kbuilder.hasErrors() );

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

        Calendar t1 = Calendar.getInstance();
        t1.set( 2009,
                   9,
                   1 );
        Calendar t2 = Calendar.getInstance();
        t2.set( 2009,
                 9,
                 15 );
        Calendar t3 = Calendar.getInstance();
        t3.set( 2009,
                 10,
                 7 );
        Calendar t4 = Calendar.getInstance();
        t4.set( 2009,
                 10,
                 25 );
        Calendar t5 = Calendar.getInstance();
        t5.set( 2009,
                 10,
                 30 );
        Calendar t6 = Calendar.getInstance();
        t6.set( 2009,
                 11,
                 12 );
        Calendar t7 = Calendar.getInstance();
        t7.set( 2009,
                 11,
                 20 );

        EmployeeStatus es1 = new EmployeeStatus( "e1",
                                                 "full time",
                                                 t1.getTime(),
                                                 t3.getTime() );
        EmployeeStatus es2 = new EmployeeStatus( "e1",
                                                 "full time",
                                                 t5.getTime(),
                                                 t7.getTime() );
        Coverage c1 = new Coverage("e1",
                                   "A",
                                   t2.getTime(),
                                   t4.getTime() );
        Coverage c2 = new Coverage("e1",
                                   "A",
                                   t5.getTime(),
                                   t6.getTime() );

        ksession.insert( es1 );
        ksession.insert( es2 );
        ksession.insert( c1 );
        ksession.insert( c2 );
        
        ksession.fireAllRules();
    }

    public void testTemporalAgendaFilter() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newInputStreamResource( getClass().getResourceAsStream( "test_TemporalFacts.drl" ) ),
                      ResourceType.DRL );

        assertFalse( kbuilder.getErrors().toString(),
                     kbuilder.hasErrors() );

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

        Calendar t1 = Calendar.getInstance();
        t1.set( 2009,
                   9,
                   1 );
        Calendar t2 = Calendar.getInstance();
        t2.set( 2009,
                 9,
                 15 );
        Calendar t3 = Calendar.getInstance();
        t3.set( 2009,
                 10,
                 7 );
        Calendar t4 = Calendar.getInstance();
        t4.set( 2009,
                 10,
                 25 );
        Calendar t5 = Calendar.getInstance();
        t5.set( 2009,
                 10,
                 30 );
        Calendar t6 = Calendar.getInstance();
        t6.set( 2009,
                 11,
                 12 );
        Calendar t7 = Calendar.getInstance();
        t7.set( 2009,
                 11,
                 20 );

        EmployeeStatus es1 = new EmployeeStatus( "e1",
                                                 "full time",
                                                 t1.getTime(),
                                                 t3.getTime() );
        EmployeeStatus es2 = new EmployeeStatus( "e1",
                                                 "full time",
                                                 t5.getTime(),
                                                 t7.getTime() );
        Coverage c1 = new Coverage("e1",
                                   "A",
                                   t2.getTime(),
                                   t4.getTime() );
        Coverage c2 = new Coverage("e1",
                                   "A",
                                   t5.getTime(),
                                   t6.getTime() );

        ksession.insert( es1 );
        ksession.insert( es2 );
        ksession.insert( c1 );
        ksession.insert( c2 );
        
        ksession.fireAllRules(new EffectiveRangeAgendaFilter( t1.getTime(), t4.getTime() ));
    }
}
