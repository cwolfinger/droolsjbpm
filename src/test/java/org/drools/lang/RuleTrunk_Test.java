package org.drools.lang;



/**
 * Test for future Drools Language Enhancements as of
 * 
 * 
 * Nested Objects	-- done
 * 		will require .# syntax even if no cast is required
 * Casting Nested Objects -- done
 * 		with #
 * Positional Constraints -- done
 * 		added positional restrictions and anonymous : X( 5, ?, ? == 12 )
 * POSL - Positional-Slotted Language -- done
 * Method Calls -- done
 * Maps and Arrays (Collections) -- done
 * Collections and XPath like filtering -- done
 * Free form Expressions -- done 
 * 		basic arithmetic expressions. require || when used on the left of a constraint
 * Queries and Unification -- done
 * Ontologies and Relations via Triples with Hybrid POJO Graph Notation 
 * 		IN PROGRESS
 * Escapes for Dialects -- done
 * Accumulate -- done
 * 		kept compatible,
 * SQL Group Operators -- done
 * Pipes - Pass through Filters -- done
 * Unit support -- done
 * Otherwise -- done
 * 		using evaluator metadata
 * Branch (Labelled Else) -- done
 * Rule Dependency Meta-Rule Language -- not a language problem
 * Parallel Meta-Rule Language -- future
 * MVCC -- future (not a language problem? - depends on Parallel Meta-Rule)
 * Slot-specific -- done
 * 		used metadata
 * Field Versioning -- done
 * 		no metadata, but field<<ver>> in accessor paths
 * Logical Modify -- done
 * 		part of structured RHS
 * Lambda Support with Analysis -- not a language problem?
 * Rising / Falling edges -- done
 * Single Pass Insertion / Single Match -- not a language problem?
 * Query Based Backward Chaining with POSL -- done
 * Federated Data Sources for Queries -- done 
 * 		using from
 * Event Sequencing -- done
 * 		used metadata to determine start/end node
 * Uncertainty / Vagueness -- done
 * 		old story
 * Ordered facts -- done
 * 		basic works
 */


import static org.junit.Assert.assertTrue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.tree.CommonTree;
import org.drools.util.DRLTreeFormatter;
import org.drools.util.DRLTreeMLFormatter;
import org.drools.util.ParsingResult;
import org.drools.util.ProTreeView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RuleTrunk_Test {

	private static Logger log;
	private static FileWriter writer;	
	
	private boolean visual = false;
	public boolean isVisual() {	return visual; }
	public void setVisual(boolean visual) {	this.visual = visual; }
		
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log = Logger.getAnonymousLogger();
		log.setLevel(Level.INFO);
		writer = new FileWriter("out/DRLv6Log.txt"); 	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		writer.flush();
		writer.close();		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	
	
	
	
	
	
	@Test
	public void test_declare() {
		String rule = "declare_bean";
		String[] testDRL = new String[] {							
				" declare Person " +
				"  @role(fact) " +	
				"  name : String @key" +
				"  age : int" +
				" end " +				
				"  ",						
				
		};
		check(rule,testDRL);											
	}	
	
	
	
	
	
	
	
	private void check(String key) {
		try {
			Method method = RuleTrunk_Test.class.getMethod(key);
			method.invoke(this);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	private void check(String rule, String[] drl) {
		System.err.println(isVisual());
		ParsingResult[] res = parseAndTest(rule, drl, isVisual());
			
		for (int j = 0; j < res.length; j++) {			
			assertTrue(res[j].isSuccess());
		}	
		
		 
	}
	
	
	
	
	
	public ParsingResult[] parseAndTest(String rulekey, String[] drl, boolean visual) {
		ParsingResult[] ans = new ParsingResult[drl.length];
		int j = 0;
		
		Method ruleM;
		try {
			ruleM = DRLParser.class.getMethod(rulekey);
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		}
				
				CommonTree fakeRoot = new CommonTree();
					
				
				for (String drlString : drl) {
					ParsingResult res = new ParsingResult();
										
					res.setSource(drlString);
						
					try {
						DRLLexer lexer = new DRLLexer( new ANTLRInputStream( new ByteArrayInputStream(drlString.getBytes()) ));			
						DRLParser parser = new DRLParser(new CommonTokenStream( lexer ));
						
						
					
						long start = new Date().getTime();
							ParserRuleReturnScope root;			
							root = (ParserRuleReturnScope) ruleM.invoke(parser);
							long after = new Date().getTime();
					
							final CommonTree resultTree = (CommonTree) root.getTree();
							fakeRoot.addChild(resultTree);
							
						int errors = parser.getHelper().errors.size() + parser.getNumberOfSyntaxErrors();
						
						
					
						final String tree = DRLTreeFormatter.toIndentedStringTree(resultTree);
						log.log(Level.INFO, tree);
						
						for (String emsg : parser.getErrorMessages())
							log.log(Level.SEVERE,emsg);
						
						res.setNumErrors(errors);
						res.setTree(resultTree);
						res.setParseTime(after-start);
													
					} catch (Exception e) {
						e.printStackTrace();
						res.setError(e);
					} finally {
						ans[j++] = res;
					}
				}
				
				
				
				if (visual) {							
					StringBuilder source = new StringBuilder();
						for (String s : drl) {
							source.append(s).append("\n");
						}
					
					JFrame view = ProTreeView.visualize_tree(DRLTreeMLFormatter.getAsStream(fakeRoot),
							DRLTreeMLFormatter.FIELD,
							source.toString(),	
							DRLTreeFormatter.toIndentedStringTree(fakeRoot,"  "),
							rulekey);
					view.setVisible(true);
				}
        
        return ans;
	}
	
	
	@SuppressWarnings("unused")
	private void log(String rule, String body) {
		try {
			writer.write("**************************************\n");
			writer.write(rule+"\n");
			writer.write("**************************************\n");
			writer.write(body+"\n");
		} catch (IOException e) {
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			RuleTrunk_Test tester = new RuleTrunk_Test();
				log = Logger.getAnonymousLogger();
				log.setLevel(Level.INFO);
				tester.setVisual(true);
				
								
				Vector<String> methods = new Vector<String>();
					Class<?> klass = RuleTrunk_Test.class;
					for (Method m : klass.getMethods())
						if (m.getAnnotation(Test.class) != null)
							methods.add(m.getName());
					Collections.sort(methods);
					
				JList list = new JList(methods);				
				ListSelectionModel lsm = list.getSelectionModel();
			    	lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    list.addMouseListener(new MouseListener() {										
					public void mouseReleased(MouseEvent e) {}					
					public void mousePressed(MouseEvent e) {}					
					public void mouseExited(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() > 1) {
							String methodName = ((JList)e.getSource()).getSelectedValue().toString();
							RuleTrunk_Test tester = new RuleTrunk_Test();
							tester.setVisual(true);
							tester.check(methodName);
						}
							 							
					}
				});			    
			    JScrollPane jsp = new JScrollPane(list);
				
				JFrame frame = new JFrame();
				frame.setSize(200, 600);
				frame.setLocation(200, 100);
				frame.add(jsp);
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				//tester.check("test_package_statement");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
	
	
}








