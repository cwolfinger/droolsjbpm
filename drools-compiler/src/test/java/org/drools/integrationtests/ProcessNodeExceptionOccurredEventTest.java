package org.drools.integrationtests;

import org.drools.runtime.process.ProcessInstance;
import org.drools.impl.StatefulKnowledgeSessionImpl.ProcessEventListenerWrapper;
import org.drools.Person;
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
import org.junit.Assert;
import org.junit.Test;


import org.drools.RuleBaseFactory;
import org.drools.common.AbstractRuleBase;
import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.ReteooWorkingMemory;
import org.drools.ruleflow.core.RuleFlowProcess;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;
import org.drools.WorkingMemory;
import org.drools.spi.Action;
import org.drools.spi.KnowledgeHelper;
import org.drools.spi.ProcessContext;
import org.drools.workflow.core.DroolsAction;
import org.drools.workflow.core.Node;
import org.drools.workflow.core.impl.ConnectionImpl;
import org.drools.workflow.core.impl.DroolsConsequenceAction;
import org.drools.workflow.core.node.ActionNode;
import org.drools.workflow.core.node.EndNode;
import org.drools.workflow.core.node.StartNode;
import org.drools.workflow.core.node.SubProcessNode;
import org.drools.workflow.instance.impl.ProcessNodeExecutionException;


import static org.junit.Assert.*;

public class ProcessNodeExceptionOccurredEventTest {

    /**
     * Internal class to express an expected result of a process exception.
     */
    private static class ExpectedResult {

        /**
         * The expected process name where the exception occurred.
         */
        private String processName;
        /**
         * The expected node name where the exception occurred.
         */
        private String nodeName;
        /**
         * The expected exception name.
         */
        private String expectedException;

        /**
         * Creates a new ExpectedResult instance
         * @param processName The expected process name where the exception occurred.
         * @param nodeName The expected node name where the exception occurred.
         * @param expectedException The expected exception name.
         */
        public ExpectedResult(String processName ,String nodeName, String expectedException) {
            this.processName = processName;
            this.nodeName = nodeName;
            this.expectedException = expectedException;
        }

        /**
         * Validates this ExpectedResult instance against a ProcessNodeExceptionOccurredEvent
         * @param event the ProcessNodeExceptionOccurredEvent triggered by the process
         */
        public void validate(ProcessNodeExceptionOccurredEvent event) {

            //Process name validation
            if (this.processName != null) {
                assertEquals(this.processName, event.getProcessInstance().getProcessName());
            }

            //Node name validation
            if (this.nodeName != null) {
                assertEquals(this.nodeName, event.getNodeInstance().getNodeName());
            }

            //Exception name validation. The real exception could not be the
            //top-level exception of ProcessNodeExceptionOccurredEvent. That is
            //why we need to navigate through the original exception.
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

    /**
     * A custom WorkItemHandler that will throw an exception when invoked.
     */
    private static class FailWorkItemHandler implements WorkItemHandler {

        public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        }
    }

    /**
     * An internal counter to keep track on the total number of exception thrown
     * during a process execution.
     */
    private int exceptionCount = 0;

    /**
     * A expected result used to validate any  exception thrown
     * during a process execution.
     */
    private ExpectedResult expectedResult;


    /**
     * Custom listener that will process incoming ProcessNodeExceptionOccurredEvent
     * events. These events are thrown when a RuntimeException occurred inside
     * a node.
     */
    private class CustomListener extends DefaultProcessEventListener {

        /**
         * Increments the exception counter and validates the generated event
         * against some expected result.
         * @param event
         */
        @Override
        public void onNodeException(ProcessNodeExceptionOccurredEvent event) {
            exceptionCount++;
            expectedResult.validate(event);
        }
    }

    private class MyBusinessException extends RuntimeException{
        private ProcessNodeExceptionOccurredEvent source;

        public MyBusinessException(ProcessNodeExceptionOccurredEvent source){
            this.source = source;
        }

        public String getProcessName(){
            return this.source.getProcessInstance().getProcessName();
        }

        public String getNodeName(){
            return this.source.getNodeInstance().getNodeName();
        }

        public Throwable getOriginalException(){
            return this.source.getError();
        }

        @Override
        public String toString() {
            return "MyBusinessException{" + "Original Exception= '" + this.getOriginalException().toString() + "', Process= '"+this.getProcessName()+"', Process= '"+this.getProcessName()+"}";
        }

    }

    /**
     * Test of ProcessNodeExceptionOccurredEvent inside an action node and inside
     * a WorkItemHandler too.
     * @throws InterruptedException
     */
    @Test
    public void actionAndWorkItemExceptionTest() throws InterruptedException {

        //Create a new kbase with the given flow.
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("org/drools/integrationtests/ProcessNodeExceptionOccurredEventTest.rf"), ResourceType.DRF);
        if (kbuilder.hasErrors()) {
            Assert.fail(kbuilder.getErrors().toString());
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        //Create a ksession and add a custom ProcessEventListener
        final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        ksession.addEventListener(new CustomListener());

        //We are expecting a NPE inside "Some Script" (an action node).
        this.expectedResult = new ExpectedResult("flow","Some Script", "java.lang.NullPointerException");
        try {
            ksession.startProcess("org.drools.test.process1");
            fail("An exception should occurr!");
        } catch (RuntimeException ex) {
            //ok
        }
        assertEquals(1, this.exceptionCount);
        this.exceptionCount = 0;

        //Insert all the needed globals. Inserting a person will make that the
        //Action node works fine.
        List<String> list = new ArrayList<String>();
        Person person = new Person();
        person.setName("John");
        ksession.setGlobal("person", person);
        ksession.setGlobal("list", list);

        //Register a WorkItemHandler. This handler will throw an exception when
        //invoked.
        ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new FailWorkItemHandler());

        //We are expecting an UnsupportedOperationException thrown by the
        //WorkItemHandler ("HumanTask" is its name).
        this.expectedResult = new ExpectedResult("flow","HumanTask", "java.lang.UnsupportedOperationException");
        try {
            ksession.startProcess("org.drools.test.process1");
            fail("An exception should occurr!");
        } catch (RuntimeException ex) {
        }
        assertEquals(1, this.exceptionCount);
        this.exceptionCount = 0;

        ksession.dispose();
    }

    @Test
    public void testListenerException(){
        //Create a new kbase with the given flow.
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("org/drools/integrationtests/ProcessNodeExceptionOccurredEventTest.rf"), ResourceType.DRF);
        if (kbuilder.hasErrors()) {
            Assert.fail(kbuilder.getErrors().toString());
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        //Create a ksession and add a custom ProcessEventListener
        final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        ksession.addEventListener(new DefaultProcessEventListener(){

            @Override
            public void onNodeException(ProcessNodeExceptionOccurredEvent event) {
                if (event.getError() instanceof MyBusinessException){
                    return;
                }
                System.out.println("\t"+event.getNodeInstance().getNodeName());
                exceptionCount++;
                throw new MyBusinessException(event);
            }

        });

        //Insert all the needed globals. Inserting a person will make that the
        //Action node works fine.
        List<String> list = new ArrayList<String>();
        Person person = new Person();
        person.setName("John");
        ksession.setGlobal("person", person);
        ksession.setGlobal("list", list);

        //Register a WorkItemHandler. This handler will throw an exception when
        //invoked.
        ksession.getWorkItemManager().registerWorkItemHandler("Human Task", new FailWorkItemHandler());

        
        this.expectedResult = new ExpectedResult("flow","HumanTask", "MyBusinessException");
        try {
            ksession.startProcess("org.drools.test.process1");
            fail("An exception should occurr!");
        } catch (ProcessNodeExecutionException ex) {
            System.out.println("\tProcessNodeExecutionException: "+ex.getCause());
            assertTrue(ex.getCause() instanceof MyBusinessException);
            assertEquals("flow", ((MyBusinessException)ex.getCause()).getProcessName());
            assertEquals("HumanTask", ((MyBusinessException)ex.getCause()).getNodeName());
        }
        assertEquals(1, this.exceptionCount);
        this.exceptionCount = 0;

        ksession.dispose();
    }

    /**
     * Test for ProcessNodeExceptionOccurredEvent events thrown inside a subprocess.
     * This test will define the main process and subprocess using apis instead
     * of makes use of external .rf files. The result using external flow files
     * would be the same.
     */
    @Test
    public void testSubProcess() {

        //Create a new Process (with name= "Process") with the following structure:
        //Start -> SubProcess -> End
        RuleFlowProcess process = new RuleFlowProcess();
        process.setId("org.drools.process.process");
        process.setName("Process");

        StartNode startNode = new StartNode();
        startNode.setName("Start");
        startNode.setId(1);
        process.addNode(startNode);
        EndNode endNode = new EndNode();
        endNode.setName("EndNode");
        endNode.setId(2);
        process.addNode(endNode);
        SubProcessNode subProcessNode = new SubProcessNode();
        subProcessNode.setName("SubProcessNode");
        subProcessNode.setId(3);
        subProcessNode.setProcessId("org.drools.process.subprocess");
        process.addNode(subProcessNode);
        new ConnectionImpl(
            startNode, Node.CONNECTION_DEFAULT_TYPE,
            subProcessNode, Node.CONNECTION_DEFAULT_TYPE
        );
        new ConnectionImpl(
            subProcessNode, Node.CONNECTION_DEFAULT_TYPE,
            endNode, Node.CONNECTION_DEFAULT_TYPE
        );

        //Add the process to a ruleBase.
        AbstractRuleBase ruleBase = (AbstractRuleBase) RuleBaseFactory.newRuleBase();
        ruleBase.addProcess(process);

        //Create a new Process (with name= "SubProcess") with the following structure:
        //Start -> Action -> End
        //This process is used as subprocess for the later process. The action
        //node (with name="ActionX") will throw an exception when invoked.
        process = new RuleFlowProcess();
        process.setId("org.drools.process.subprocess");
        process.setName("SubProcess");

        startNode = new StartNode();
        startNode.setName("Start");
        startNode.setId(1);
        process.addNode(startNode);
        endNode = new EndNode();
        endNode.setName("EndNode");
        endNode.setId(2);
        process.addNode(endNode);
        ActionNode actionNode = new ActionNode();
        actionNode.setName("ActionX");
        DroolsAction action = new DroolsConsequenceAction("java", null);
        action.setMetaData("Action", new Action() {
            public void execute(KnowledgeHelper knowledgeHelper, WorkingMemory workingMemory, ProcessContext context) throws Exception {
            	throw new IllegalStateException("Something illegal just happened!");
            }
        });
        actionNode.setAction(action);
        process.addNode(actionNode);
        new ConnectionImpl(
            startNode, Node.CONNECTION_DEFAULT_TYPE,
            actionNode, Node.CONNECTION_DEFAULT_TYPE
        );
        new ConnectionImpl(
    		actionNode, Node.CONNECTION_DEFAULT_TYPE,
            endNode, Node.CONNECTION_DEFAULT_TYPE
        );

        //Add the subprocess to ruleBase.
        ruleBase.addProcess(process);

        //The following 3 steps is the same as creating a new ksession and add
        //a new instance of CustomListener as process listener.
        InternalWorkingMemory workingMemory = new ReteooWorkingMemory(1, ruleBase);
        ProcessEventListenerWrapper wrapper = new ProcessEventListenerWrapper( new CustomListener() );
        workingMemory.addEventListener(wrapper);

        //We spect the suprocess ("SubProcess") to fail inside action node ("ActionX")
        //because of a IllegalStateException.
        this.expectedResult = new ExpectedResult("SubProcess","ActionX", "java.lang.IllegalStateException");
        try {
            workingMemory.startProcess("org.drools.process.process");
            fail("An exception should occurr!");
        } catch (RuntimeException ex) {
            //ok
        }

        assertEquals(1,this.exceptionCount);
        this.exceptionCount=0;
    }
}
