package org.drools.chance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.drools.FactHandle;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.RuleBaseConfiguration;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.chance.fuzzyTest.FuzzyTest0;
import org.drools.chance.fuzzyTest.Room;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.type.FactType;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class BaseTest extends AbstractChanceTest {

	

	

	
	
	public static final void main(final String[] args) throws Exception {
		
		BaseTest test = new BaseTest();
			test.setRuleFileName("BaseTest.drl");
						
			test.run();
			
	}
	

	public void act() {
		try {
			FactType MessageType = getFactType("Message");
				Object msg = MessageType.newInstance();
				MessageType.set(msg, "status", 0);
			
			getSession().insert(msg);
			
			
			FactType PersonType = getFactType("Person");
				Object p = PersonType.newInstance();
				PersonType.set(p, "name", "davide");
				PersonType.set(p, "age", 27);
			
			FactType BookType = getFactType("Book");
				Object b = BookType.newInstance();
				BookType.set(b, "title", "Drools Manual");
				
			getSession().insert(p);
			getSession().insert(b);
			getSession().fireAllRules();
			
			
			FactType ExType = getFactType("Exercise");
				Object e1 = ExType.newInstance();
				ExType.set(e1, "topic", "Algebra");
							
				Object e2 = ExType.newInstance();
				ExType.set(e2, "topic", "Norse Grammar");
				
				Object e3 = ExType.newInstance();
				ExType.set(e3, "topic", "Rule Programming");
				
			getSession().insert(e1);
			getSession().insert(e2);
			getSession().insert(e3);
			getSession().fireAllRules();

				
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		getSession().fireAllRules();
	}

	


//		
//		//Start the session
//		// Will say something about next message
//		ksession.insert(new Trigger());
//		
//		// Message is empty, only has status
//		// Message content comes from previous rule
//		final Message message = new Message();		
//		message.setStatus(Message.HELLO);
//		
//		ksession.insert(message);							
//		ksession.fireAllRules();
//
//		// book has no a-priori known owner
//		// Info on BETA constraint comes from previous rule
//		Person pers = new Person("davide",27);
//		Book book = new Book("Drools Manual",null);
//					
//		ksession.insert(pers);
//		ksession.insert(book);				
//		ksession.fireAllRules();
////	
//		
//		//NO WAY to do these exercises
//		Exercise x1 = new Exercise("Maths");
//		ksession.insert(x1);
//		ksession.fireAllRules();
//		
//		Exercise x2 = new Exercise("Geometry");
//		ksession.insert(x2);
//		ksession.fireAllRules();
//		
//		// THIS one is an EXCEPTION
//		Exercise x3 = new Exercise("Rule Programming");
//		ksession.insert(x3);
//		ksession.fireAllRules();
//		
//		
//		writer.close();
//		
		
		
		
		
		
		
		
		
	
//		
//	
//
//	public static class Message {
//		public static final int HELLO = 0;
//		public static final int GOODBYE = 1;
//		public static final int IDK = 3;
//
//		public String message = "";
//
//		private int status;
//
//		public Message() {
//
//		}
//		
//		public Message(int status) {
//			this.status = status;
//		}
//
//		public String getMessage() {
//			return this.message;
//		}
//
//		public void setMessage(final String message) {
//			this.message = message;
//		}
//
//		public int getStatus() {
//			return this.status;
//		}
//
//		public void setStatus(final int status) {
//			this.status = status;
//		}
//
//		public static Message doSomething(Message message) {
//			return message;
//		}
//
//		public boolean isSomething(String msg, List<Object> list) {
//			list.add(this);
//			return this.message.equals(msg);
//		}
//		
//		public boolean equals(Object other) {
//			if (other == null) return false;
//			if (other instanceof Message) {
//				Message o = (Message) other;
//				//return o.message.equals(this.message) && o.status == this.status;
//				return o.status == this.status;
//			}
//			return false;
//		
//		}
//		
//		public int hashCode() {
//			//return this.message.hashCode()+this.status;
//			return this.status;
//		}
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public static class Person {
//
//		private String name;
//		private int age;
//		/**
//		 * @param name the name to set
//		 */
//		public void setName(String name) {
//			this.name = name;
//		}
//		/**
//		 * @return the name
//		 */
//		public String getName() {
//			return name;
//		}
//		/**
//		 * @param age the age to set
//		 */
//		public void setAge(int age) {
//			this.age = age;
//		}
//		/**
//		 * @return the age
//		 */
//		public int getAge() {
//			return age;
//		}
//		
//		public Person(String name, int age) {
//			this.name = name;
//			this.age = age;
//		}
//		
//		public boolean equals(Object other) {
//			if (other == null) return false;
//			if (! (other instanceof Person))
//				return false;
//			Person p = (Person) other;
//			if (p == null) return false;
//			return this.name.equals(p.name);
//		}
//		
//		public int hashCode() {
//			return name.hashCode();
//		}
//	
//	
//		
//	}
//	
//	
//	
//	public static class Book {
//		
//		private String title;
//		private Person owner;
//	
//		
//		public Book() {
//		}
//		
//		
//		public Book(String t, Person p) {
//			setTitle(t);
//			setOwner(p);
//		}
//
//		/**
//		 * @param title the title to set
//		 */
//		public void setTitle(String title) {
//			this.title = title;
//		}
//
//		/**
//		 * @return the title
//		 */
//		public String getTitle() {
//			return title;
//		}
//
//		/**
//		 * @param owner the owner to set
//		 */
//		public void setOwner(Person owner) {
//			this.owner = owner;
//		}
//
//		/**
//		 * @return the owner
//		 */
//		public Person getOwner() {
//			return owner;
//		}
//		
//		
//		public boolean equals(Object other) {
//			if (other == null) return false;
//			if (! (other instanceof Book)) return false;
//			Book b = (Book) other;
//			if (b == null) return false;
//			return this.title.equals(b.title);
//		}
//		
//		public int hashCode() {
//			return title.hashCode();
//		}
//
//		
//
//		
//		
//	}
//	
//	public static class Trigger {
//		
//	}
//	
//	
//	public static class Exercise {
//		
//		private String topic;
//		public String getTopic() {
//			return topic;
//		}
//		
//		public Exercise(String top) {
//			topic = top;
//		}
//		
//		public int hashCode() {
//			return topic.hashCode();
//			
//		}
//		
//		
//		
//		public boolean equals(Object other) {
//			if (other == null) return false;
//			if (other == this) return true;
//			
//			
//			if (other instanceof Exercise)
//				return getTopic().equals(((Exercise) other).getTopic()); 
//			else 
//				return false;
//		}
//		
//	}
	
}
