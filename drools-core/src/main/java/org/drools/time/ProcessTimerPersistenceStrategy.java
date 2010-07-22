package org.drools.time;

import org.drools.process.instance.timer.TimerManager.ProcessJobContext;
import org.drools.time.impl.IntervalTrigger;
import org.drools.time.impl.ProcessJobHandle;

public interface ProcessTimerPersistenceStrategy {

	void save(ProcessJobContext processContext, IntervalTrigger intervalTrigger);

	boolean remove(ProcessJobHandle jobHandle);

}
