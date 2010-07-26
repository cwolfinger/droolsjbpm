package org.drools.integrationtests;

import org.drools.Person;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import java.util.List;
import java.util.ArrayList;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.event.process.DefaultProcessEventListener;
import org.drools.event.process.ProcessNodeExceptionOccurredEvent;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItemManager;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessNodeExceptionOccurredEventTest {

    private static class ExpectedResult {

        private String nodeName;
        private String expectedException;

        public ExpectedResult(String nodeName, String expectedException) {
            this.nodeName = nodeName;
            this.expectedException = expectedException;
        }

        public void validate(ProcessNodeExceptionOccurredEvent event) {

            if (this.nodeName != null) {
                assertEquals(this.nodeName, event.getNodeInstance().getNodeName());
            }

            if (this.expectedException != null) {
                boolean found = false;
                Throwable t = event.getError();
                while (t != null) {
                    if (t.toString().contains(this.expectedException)) {
                        found = true;
                        break;
                    }
                    t = t.getCause();
                }

                if (!found) {
                    fail(this.expectedException + " wasn't found!");
                }
            }
        }
    }

    private static class FailWorkItemHandler implements WorkItemHandler {

        public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        }
    }

    
    private int exceptionCount = 0;
    private ExpectedResult expectedResult;

    private class CustomListener extends DefaultProcessEventListener {

        @Override
        public void onNodeException(ProcessNodeExceptionOccurredEvent event) {
            exceptionCount++;
            expectedResult.validate(event);
        }
    }

    @Test
    public void actionAndWorkItemExceptionTest() throws InterruptedException {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("org/drools/integrationtests/ProcessNodeExceptionOccurredEventTest.rf"), ResourceType.DRF);
        if (kbuilder.hasErrors()) {
            Assert.fail(kbuilder.getErrors().toString());
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

        ksession.addEventListener(new CustomListener());


        this.expectedResult = new ExpectedResult("Some Script", "java.lang.NullPointerException");
        try {
            ksession.startProcess("org.drools.test.process1");
            fail("An exception should occurr!");
        } catch (RuntimeException ex) {
            //ok
        }
        assertEquals(1, this.exceptionCount);
        this.exceptionCount = 0;

        List<String> list = new ArrayList<String>();

        Person person = new Person();
        person.setName("John");

        ksession.setGlobal("person", person);
        ksession.setGlobal("list", list);

        ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new FailWorkItemHandler());


        this.expectedResult = new ExpectedResult("HumanTask", "java.lang.UnsupportedOperationException");

        try {
            ksession.startProcess("org.drools.test.process1");
            fail("An exception should occurr!");
        } catch (RuntimeException ex) {
            //ok
        }
        assertEquals(1, this.exceptionCount);
        this.exceptionCount = 0;

        ksession.dispose();
    }
}
