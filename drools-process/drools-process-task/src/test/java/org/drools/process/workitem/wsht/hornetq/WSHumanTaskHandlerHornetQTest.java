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

package org.drools.process.workitem.wsht.hornetq;

import org.drools.SystemEventListenerFactory;
import org.drools.process.workitem.wsht.WSHumanTaskHandler;
import org.drools.process.workitem.wsht.WSHumanTaskHandlerBaseTest;
import org.drools.task.service.TaskClient;
import org.drools.task.service.TaskServer;
import org.drools.task.service.hornetq.HornetQTaskClientConnector;
import org.drools.task.service.hornetq.HornetQTaskClientHandler;
import org.drools.task.service.hornetq.HornetQTaskServer;

public class WSHumanTaskHandlerHornetQTest extends WSHumanTaskHandlerBaseTest {

	private TaskServer server;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		server = new HornetQTaskServer(taskService, 5446);
		Thread thread = new Thread(server);
		thread.start();
		System.out.println("Waiting for the HornetQTask Server to come up");
		while (!server.isRunning()) {
        	System.out.print(".");
        	Thread.sleep( 50 );
        }
		setClient(new TaskClient(new HornetQTaskClientConnector("client 1",
								new HornetQTaskClientHandler(SystemEventListenerFactory.getSystemEventListener()))));
		getClient().connect("127.0.0.1", 5446);
		WSHumanTaskHandler handler = new WSHumanTaskHandler();
		handler.setClient(getClient());
		setHandler(handler);
	}

	protected void tearDown() throws Exception {
		getHandler().dispose();
		getClient().disconnect();
		server.stop();
		super.tearDown();
	}

}
