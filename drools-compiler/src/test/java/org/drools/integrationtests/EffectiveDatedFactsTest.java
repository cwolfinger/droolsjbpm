/**
 * 
 */
package org.drools.integrationtests;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.drools.Coverage;
import org.drools.EmployeeStatus;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.base.EffectiveRangeAgendaFilter;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.common.EffDatedFactHandle;
import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.mockito.ArgumentCaptor;

/**
 * @author etirelli
 *
 */
public class EffectiveDatedFactsTest extends TestCase {

    private StatefulKnowledgeSession createSession(final String rulesFile) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newInputStreamResource( getClass().getResourceAsStream( rulesFile ) ),
                      ResourceType.DRL );

        assertFalse( kbuilder.getErrors().toString(),
                     kbuilder.hasErrors() );

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        return ksession;
    }

    public void testEffectiveDatedFactCreation() {
        StatefulKnowledgeSession ksession = createSession( "test_EffectiveDatedFacts.drl" );

        // creating mock objects to check successful execution
        final AgendaEventListener agendaListener = mock( AgendaEventListener.class );
        final WorkingMemoryEventListener wmListener = mock( WorkingMemoryEventListener.class );

        ksession.addEventListener( agendaListener );
        ksession.addEventListener( wmListener );

        // input data
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

        // checking results
        assertNotNull( handle );
        assertTrue( handle instanceof EffDatedFactHandle );
        EffDatedFactHandle thandle = (EffDatedFactHandle) handle;
        assertEquals( start.getTimeInMillis(),
                      thandle.getEffectiveTimestamp() );
        assertEquals( end.getTimeInMillis(),
                      thandle.getExpirationTimestamp() );

        ksession.fireAllRules();

        // checking compliance
        verify( agendaListener,
                never() ).activationCreated( any( ActivationCreatedEvent.class ) );
        verify( wmListener ).objectInserted( any( ObjectInsertedEvent.class ) );

    }

    public void testEffectiveDatedMatching() {
        StatefulKnowledgeSession ksession = createSession( "test_EffectiveDatedFacts.drl" );

        // creating mock objects to check successful execution
        final AgendaEventListener agendaListener = mock( AgendaEventListener.class );
        final WorkingMemoryEventListener wmListener = mock( WorkingMemoryEventListener.class );

        ksession.addEventListener( agendaListener );
        ksession.addEventListener( wmListener );

        // input data
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
        Coverage c1 = new Coverage( "e1",
                                    "A",
                                    t2.getTime(),
                                    t4.getTime() );
        Coverage c2 = new Coverage( "e1",
                                    "A",
                                    t5.getTime(),
                                    t6.getTime() );

        ksession.insert( es1 );
        ksession.insert( es2 );
        ksession.insert( c1 );
        ksession.insert( c2 );

        // checking compliance
        verify( wmListener,
                times( 4 ) ).objectInserted( any( ObjectInsertedEvent.class ) );
        verify( agendaListener,
                times( 2 ) ).activationCreated( any( ActivationCreatedEvent.class ) );

        ksession.fireAllRules();

        ArgumentCaptor<AfterActivationFiredEvent> argument = ArgumentCaptor.forClass( AfterActivationFiredEvent.class );
        verify( agendaListener,
                times( 2 ) ).afterActivationFired( argument.capture() );

        List<AfterActivationFiredEvent> events = argument.getAllValues();
        AfterActivationFiredEvent evt1 = events.get( 0 );
        AfterActivationFiredEvent evt2 = events.get( 1 );

        assertEquals( t5.getTimeInMillis(),
                      evt1.getActivation().getStartTimestamp() );
        assertEquals( t6.getTimeInMillis(),
                      evt1.getActivation().getEndTimestamp() );

        assertEquals( t2.getTimeInMillis(),
                      evt2.getActivation().getStartTimestamp() );
        assertEquals( t3.getTimeInMillis(),
                      evt2.getActivation().getEndTimestamp() );

    }

    public void testEffectiveDatedAgendaFilter() {
        StatefulKnowledgeSession ksession = createSession( "test_EffectiveDatedFacts.drl" );

        // creating mock objects to check successful execution
        final AgendaEventListener agendaListener = mock( AgendaEventListener.class );
        final WorkingMemoryEventListener wmListener = mock( WorkingMemoryEventListener.class );

        ksession.addEventListener( agendaListener );
        ksession.addEventListener( wmListener );

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
        Coverage c1 = new Coverage( "e1",
                                    "A",
                                    t2.getTime(),
                                    t4.getTime() );
        Coverage c2 = new Coverage( "e1",
                                    "A",
                                    t5.getTime(),
                                    t6.getTime() );

        ksession.insert( es1 );
        ksession.insert( es2 );
        ksession.insert( c1 );
        ksession.insert( c2 );

        // checking compliance
        verify( wmListener,
                times( 4 ) ).objectInserted( any( ObjectInsertedEvent.class ) );
        verify( agendaListener,
                times( 2 ) ).activationCreated( any( ActivationCreatedEvent.class ) );

        ksession.fireAllRules( new EffectiveRangeAgendaFilter( t1.getTime(),
                                                               t4.getTime() ) );

        ArgumentCaptor<AfterActivationFiredEvent> argument = ArgumentCaptor.forClass( AfterActivationFiredEvent.class );
        verify( agendaListener,
                times( 1 ) ).afterActivationFired( argument.capture() );
        verify( agendaListener,
                times( 1 ) ).activationCancelled( any( ActivationCancelledEvent.class ) );

        AfterActivationFiredEvent evt1 = argument.getValue();

        assertEquals( t2.getTimeInMillis(),
                      evt1.getActivation().getStartTimestamp() );
        assertEquals( t3.getTimeInMillis(),
                      evt1.getActivation().getEndTimestamp() );

    }
}
