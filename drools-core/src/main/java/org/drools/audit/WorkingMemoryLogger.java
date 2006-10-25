package org.drools.audit;

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
import java.util.Iterator;
import java.util.List;

import org.drools.FactHandle;
import org.drools.WorkingMemory;
import org.drools.audit.event.ActivationLogEvent;
import org.drools.audit.event.ILogEventFilter;
import org.drools.audit.event.LogEvent;
import org.drools.audit.event.ObjectLogEvent;
import org.drools.common.InternalFactHandle;
import org.drools.event.ActivationCancelledEvent;
import org.drools.event.ActivationCreatedEvent;
import org.drools.event.AfterActivationFiredEvent;
import org.drools.event.AgendaEventListener;
import org.drools.event.BeforeActivationFiredEvent;
import org.drools.event.ObjectAssertedEvent;
import org.drools.event.ObjectModifiedEvent;
import org.drools.event.ObjectRetractedEvent;
import org.drools.event.WorkingMemoryEventListener;
import org.drools.rule.Declaration;
import org.drools.spi.Activation;
import org.drools.spi.Tuple;

/**
 * A logger of events generated by a working memory.
 * It listens to the events generated by the working memory and
 * creates associated log event (containing a snapshot of the
 * state of the working event at that time).
 * 
 * Filters can be used to filter out unwanted events.
 * 
 * Subclasses of this class should implement the logEventCreated(LogEvent)
 * method and store this information, like for example log to file
 * or database.
 * 
 * @author <a href="mailto:kris_verlaenen@hotmail.com">Kris Verlaenen </a>
 */
public abstract class WorkingMemoryLogger
    implements
    WorkingMemoryEventListener,
    AgendaEventListener {

    private final List    filters = new ArrayList();
    private WorkingMemory workingMemory;

    /**
     * Creates a new working memory logger for the given working memory.
     * 
     * @param workingMemory
     */
    public WorkingMemoryLogger(final WorkingMemory workingMemory) {
        this.workingMemory = workingMemory;
        workingMemory.addEventListener( (WorkingMemoryEventListener) this );
        workingMemory.addEventListener( (AgendaEventListener) this );
    }

    /**
     * This method is invoked every time a new log event is created.
     * Subclasses should implement this method and store the event,
     * like for example log to a file or database.
     * 
     * @param logEvent
     */
    public abstract void logEventCreated(LogEvent logEvent);

    /**
     * This method is invoked every time a new log event is created.
     * It filters out unwanted events.
     * 
     * @param logEvent
     */
    private void filterLogEvent(final LogEvent logEvent) {
        final Iterator iterator = this.filters.iterator();
        while ( iterator.hasNext() ) {
            final ILogEventFilter filter = (ILogEventFilter) iterator.next();
            // do nothing if one of the filters doesn't accept the event
            if ( !filter.acceptEvent( logEvent ) ) {
                return;
            }
        }
        // if all the filters accepted the event, signal the creation
        // of the event
        logEventCreated( logEvent );
    }

    /**
     * Adds the given filter to the list of filters for this event log.
     * A log event must be accepted by all the filters to be entered in
     * the event log.
     *
     * @param filter The filter that should be added.
     */
    public void addFilter(final ILogEventFilter filter) {
        if ( filter == null ) {
            throw new NullPointerException();
        }
        this.filters.add( filter );
    }

    /**
     * Removes the given filter from the list of filters for this event log.
     * If the given filter was not a filter of this event log, nothing
     * happens.
     *
     * @param filter The filter that should be removed.
     */
    public void removeFilter(final ILogEventFilter filter) {
        this.filters.remove( filter );
    }

    /**
     * Clears all filters of this event log.
     */
    public void clearFilters() {
        this.filters.clear();
    }

    /**
     * @see org.drools.event.WorkingMemoryEventListener
     */
    public void objectAsserted(final ObjectAssertedEvent event) {
        filterLogEvent( new ObjectLogEvent( LogEvent.OBJECT_ASSERTED,
                                            ((InternalFactHandle) event.getFactHandle()).getId(),
                                            event.getObject().toString() ) );
    }

    /**
     * @see org.drools.event.WorkingMemoryEventListener
     */
    public void objectModified(final ObjectModifiedEvent event) {
        filterLogEvent( new ObjectLogEvent( LogEvent.OBJECT_MODIFIED,
                                            ((InternalFactHandle) event.getFactHandle()).getId(),
                                            event.getObject().toString() ) );
    }

    /**
     * @see org.drools.event.WorkingMemoryEventListener
     */
    public void objectRetracted(final ObjectRetractedEvent event) {
        filterLogEvent( new ObjectLogEvent( LogEvent.OBJECT_RETRACTED,
                                            ((InternalFactHandle) event.getFactHandle()).getId(),
                                            event.getOldObject().toString() ) );
    }

    /**
     * @see org.drools.event.AgendaEventListener
     */
    public void activationCreated(final ActivationCreatedEvent event, WorkingMemory workingMemory) {
        filterLogEvent( new ActivationLogEvent( LogEvent.ACTIVATION_CREATED,
                                                getActivationId( event.getActivation() ),
                                                event.getActivation().getRule().getName(),
                                                extractDeclarations( event.getActivation() ) ) );
    }

    /**
     * @see org.drools.event.AgendaEventListener
     */
    public void activationCancelled(final ActivationCancelledEvent event, WorkingMemory workingMemory) {
        filterLogEvent( new ActivationLogEvent( LogEvent.ACTIVATION_CANCELLED,
                                                getActivationId( event.getActivation() ),
                                                event.getActivation().getRule().getName(),
                                                extractDeclarations( event.getActivation() ) ) );
    }

    /**
     * @see org.drools.event.AgendaEventListener
     */
    public void beforeActivationFired(final BeforeActivationFiredEvent event, WorkingMemory workingMemory) {
        filterLogEvent( new ActivationLogEvent( LogEvent.BEFORE_ACTIVATION_FIRE,
                                                getActivationId( event.getActivation() ),
                                                event.getActivation().getRule().getName(),
                                                extractDeclarations( event.getActivation() ) ) );
    }

    /**
     * @see org.drools.event.AgendaEventListener
     */
    public void afterActivationFired(final AfterActivationFiredEvent event, WorkingMemory workingMemory) {
        filterLogEvent( new ActivationLogEvent( LogEvent.AFTER_ACTIVATION_FIRE,
                                                getActivationId( event.getActivation() ),
                                                event.getActivation().getRule().getName(),
                                                extractDeclarations( event.getActivation() ) ) );
    }

    /**
     * Creates a string representation of the declarations of an activation.
     * This is a list of name-value-pairs for each of the declarations in the
     * tuple of the activation.  The name is the identifier (=name) of the
     * declaration, and the value is a toString of the value of the
     * parameter, followed by the id of the fact between parentheses.
     * 
     * @param activation The activation from which the declarations should be extracted
     * @return A String represetation of the declarations of the activation.
     */
    private String extractDeclarations(final Activation activation) {
        final StringBuffer result = new StringBuffer();
        final Tuple tuple = activation.getTuple();
        final Declaration[] declarations = activation.getRule().getDeclarations();
        for ( int i = 0, length = declarations.length; i < length; i++ ) {
            final Declaration declaration = declarations[i];
            final FactHandle handle = tuple.get( declaration );
            if ( handle instanceof InternalFactHandle ) {
                final InternalFactHandle handleImpl = (InternalFactHandle) handle;
                if ( handleImpl.getId() == -1 ) {
                    // This handle is now invalid, probably due to an fact retraction
                    continue;
                }
                final Object value = declaration.getValue( this.workingMemory.getObject( handle ) );

                result.append( declaration.getIdentifier() );
                result.append( "=" );
                if ( value == null ) {
                    // this should never occur
                    result.append( "null" );
                } else {
                    result.append( value );
                    result.append( "(" );
                    result.append( handleImpl.getId() );
                    result.append( ")" );
                }
            }
            if ( i < declarations.length - 1 ) {
                result.append( "; " );
            }
        }
        return result.toString();
    }

    /**
     * Returns a String that can be used as unique identifier for an
     * activation.  Since the activationId is the same for all assertions
     * that are created during a single assert, modify or retract, the
     * key of the tuple of the activation is added too (which is a set
     * of fact handle ids). 
     * 
     * @param activation The activation for which a unique id should be generated
     * @return A unique id for the activation
     */
    private static String getActivationId(final Activation activation) {
        final StringBuffer result = new StringBuffer( activation.getRule().getName() );
        result.append( " [" );
        final Tuple tuple = activation.getTuple();
        final FactHandle[] handles = tuple.getFactHandles();
        for ( int i = 0; i < handles.length; i++ ) {
            result.append( ((InternalFactHandle) handles[i]).getId() );
            if ( i < handles.length - 1 ) {
                result.append( ", " );
            }
        }
        return result.append( "]" ).toString();
    }
}
