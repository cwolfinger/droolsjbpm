package org.drools.time;

import org.drools.ClockType;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.time.impl.JDKTimerService;
import org.drools.time.impl.PseudoClockScheduler;

public class TimerServiceFactory {
	
	public static TimerService getTimerService(ClockType type, Environment environment){
        switch( type ) {
        case REALTIME_CLOCK:
        	ProcessTimerPersistenceStrategy processTimerPersistenceStrategy = null;
        	if(environment != null)
        		processTimerPersistenceStrategy = (ProcessTimerPersistenceStrategy) environment.get(EnvironmentName.PROCESS_TIMER_STRATEGY);
			return new JDKTimerService(processTimerPersistenceStrategy);
        case PSEUDO_CLOCK:
            return new PseudoClockScheduler();
    }
    throw new IllegalArgumentException("Unknown clock type: " + type.name());
}
    
    public static TimerService getTimerService( ClockType type ) {
    	return getTimerService(type, null);
    }
}
