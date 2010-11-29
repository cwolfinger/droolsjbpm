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



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.drools.lang.dl.ManchesterLexer;
import org.drools.lang.dl.ManchesterParser;
import org.drools.lang.dl.ManchesterTreeBuilder;
import org.drools.lang.dl.descr.DL_OntologyDescr;
import org.drools.util.DRLTreeFormatter;
import org.drools.util.DRLTreeMLFormatter;
import org.drools.util.ParsingResult;
import org.drools.util.ProTreeView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class Manchester_Test {

	private static Logger log;	
	
	private boolean visual = false;
	public boolean isVisual() {	return visual; }
	public void setVisual(boolean visual) {	this.visual = visual; }
		
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log = Logger.getAnonymousLogger();
		log.setLevel(Level.INFO);		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	
	 
	
	
		
	
	@Test
	public void test_manDL_iri() {
		
		String rule = "iri";
		String[] testDRL = {				
				
				"foo ",	
				
				"SomeEvent",
				
				":defNS",
				
				"with:namespace",
				
				"<http://xmlns.com/foaf/0.1/#>",
				
				
				
		};
				
		check(rule,testDRL);
		
	}
	
	
	
	@Test	
	public void test_manDL_declaration_root() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {				
				
				"Class : foo ",
				
				"Class : SomeEvent",
		};
				
		check(rule,testDRL);										
	}
	   
	
	
	@Test	
	public void test_manDL_annotations() {
		String rule = "manDL_annotations";
		String[] testDRL = {				
				
				"Annotations : creator sotty",
				
				"Annotations : creator sotty, " +
				"	Annotations: rdfsComment year creationYear 2008, " +
				"mainClass Person," +
				"	Annotations: meta target annotationProp annotationTgt",
				
				
				" Annotations:" + "\n" + 
				" rdfs:seeAlsso \"http://xmlns.com/foaf/0.1/\"^^xsd:anyURI, " + "\n" +
				" dc:description \"The Friend of a Friend (FOAF) RDF vocabulary, described using W3C RDF Schema and the Web Ontology Language.\", " + "\n" + 
				" dc:title \"Friend of a Friend (FOAF) vocabulary\", " + "\n" + 
				" dc:date \"$Date: 2006/01/29 22:38:45 $\" ",
				
				
				"Annotations: " + "\n" + 
				    "dc:publisher \"Dumontier Lab\"^^xsd:string"+ "\n " +
				    "dc:publisher \"Dumontier Lab\"^^xsd:string"+ "\n " +
				    "dc:title \"Organic Functional Group Ontology (complex)\"^^xsd:string"+ "\n " +
				    "dc:creator \"Michel Dumontier\"^^xsd:string"+ "\n " +
				    "dc:language \"en\"^^xsd:string"+ "\n " +
				    "owl:versionInfo \"2.0\"^^xsd:string"+ "\n " +
				    "dc:date \"2007-10-01\"^^xsd:date"+ "\n " +
				    "dc:description \"Complex class descriptions for the realization of organic functional groups.\"^^xsd:string"+ "\n " +
				    "dc:format \"application/rdf+xml\"^^xsd:string"
				    
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_manDL_class() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"Class : Foo " + "\n" +				
				" Annotations: creatory sotty " + "\n" +
				" DisjointUnionOf: Annotations: guess what Child, Adult" + "\n" +
				" SubClassOf: Person and Worker" + "\n" +
				" EquivalentTo: Annotations: guess again Person" + "\n" +
				" DisjointWith: Person" + "\n" +
				" HasKey: Annotations: annkey targt hasSSN" + "\n"
		};
				
		check(rule,testDRL);										
	}
	
	
	
	
	
	
	@Test	
	public void test_manDL_datatype_declaration() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"Datatype: NegInt " + "\n" +								
				" EquivalentTo: Annotations: creator sotty Integer[ < 0 ], NegativeInteger" + "\n",												
		};
				
		check(rule,testDRL);										
	}

	
	
	@Test	
	public void test_manDL_annotated_description() {
		String rule = "manDL_annotated_description";
		String[] testDRL = {
				
				"Person and " +
				"	hasChildren exactly 3 Male ",
				
				"Person and (" +
				"	hasChildren exactly 3 Male or hasChildren min 2 Female ) ",
				
				"hasAge exactly 1 and hasAge only not NegInt",
				
				"Annotations: tell me Human or Animal or Robot and not Alien",
				
				
				
				"hasChild Male",
				
				"Person and hasChildren some Male ",
								
				"Person and hasChildren only Male ",
				
				"Person and hasChildren value john ",
				
				"Person and hasChildren min 3 ",
				
				"Person and hasChildren max 5 ",
				
				"Person and hasChildren exactly 10 (Male or Female and hasFriend only Cat)",
				
				"Thing that hasFirstName exactly 1 and hasFirstName only String[minLength 1]",
											
				"hasGender exactly 1 and hasGender only {\"female\", \"male\"}",
				
				"hasFirstName value \"John\" or hasFirstName value \"Joe\" ",
				
				"Person or hasChildren only Male ",
				
				
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test
	public void test_manDL_quantified_restriction_core() {
		String rule = "manDL_quantified_restriction_core";
		String[] testDRL = {
								
				
				
				"hasChildren some Male ",
								
				"hasChildren only Male ",
				
				"hasChildren value john ",
				
				"hasChildren min 3 ",
				
				"hasChildren max 5 ",
				
				"hasChildren exactly 10",
				
				"hasChildren Male",
				
					
				
		};
				
		check(rule,testDRL);										
	}
	
	

	
	
	
	@Test	
	public void test_manDL_objectprop() {
		String rule = "manDL_objectProperty";
		String[] testDRL = {
				"ObjectProperty: hasWife" + "\n" +				
				" Annotations: creator sotty " + "\n" +
				" Characteristics: Functional, InverseFunctional, Reflexive, Irreflexive, Asymmetric, Transitive " + "\n" +
				" Domain: Annotations: rdfsComment \"General dom\", creator sotty Person," + "\n" +
				"         Annotations: rdfsCcomment \"More specific dom\" Man" + "\n" +
				" Range: Person, Woman " + "\n" +
				" SubPropertyOf: hasSpouse, loves" + "\n" +
				" EquivalentTo: isMarriedTo " + "\n" +
				" DisjointWith: hates " + "\n" +
				" InverseOf: hasSpouse, inverse hasSpouse" + "\n" +
				" SubPropertyChain: hasChild o hasParent " + "\n",												
			
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test
	public void test_manDL_dataprop() {
		String rule = "manDL_dataProperty";
		String[] testDRL = {
				"DataProperty: hasAge" + "\n" +				
				" Annotations: creator sotty " + "\n" +
				" Characteristics: Functional " + "\n" +
				" Domain: Person " + "\n" +
				" Range: integer " + "\n" +
				" SubPropertyOf: hasVerifiedAge" + "\n" +
				" EquivalentTo: hasAgeInYears " + "\n" +
				" DisjointWith: hasSSN " + "\n",

		};
		check(rule,testDRL);										
	}

	@Test
	public void test_manDL_annotation_prop() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"AnnotationProperty: creator" + "\n" +				
				" Annotations: price 100 " + "\n" +					
				" Domain: Person " + "\n" +
				" Range: String " + "\n" +
				" SubPropertyOf: initialCreator" + "\n",

		};	
		check(rule,testDRL);										
	}
	
	@Test
	public void test_manDL_individuals() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"Individual: John" + "\n" +				
				" Annotations: creator sotty " + "\n" +					
				" Types: Person, hasFirstName value \"John\" or hasFirstName value \"Joe\" " + "\n" +
				" Facts: hasWife Mary, not hasChild Susan, hasAge 33 " + "\n" +
				" SameAs: Joe" + "\n" +
				" DifferentFrom: Susan" + "\n",
			
		};	
		check(rule,testDRL);										
	}
	
	@Test
	public void test_manDL_individual_list() {
		String rule = "manDL_individual_list";
		String[] testDRL = {
				"John, Susan, Mark " 											
		};	
		check(rule,testDRL);
	}
	
	@Test
	public void test_manDL_individual_list_core() {
		String rule = "manDL_atomic_core";
		String[] testDRL = {
				"{John, Susan, Mark}" 											
		};	
		check(rule,testDRL);
	}
	
	
	@Test
	public void test_manDL_literal_list_core() {
		String rule = "manDL_atomic_core";
		String[] testDRL = {
				"{\"John\", \"Susan\", \"Mark\"}" 											
		};	
		check(rule,testDRL);
	}
	
	
	
	@Test
	public void test_manDL_misc() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"EquivalentClasses: Annotations: creator sotty Rock, Scissors, Paper ",
				 
				"DisjointClasses: Annotations: creator sotty q:Rock, q:Scissors, Paper ",
				
				"EquivalentProperties: Annotations: creator sotty h:loves, h:hates ",
				
				"DisjointProperties: Annotations: creator sotty loves, hates ",
				
				"SameIndividual: Annotations: creator sotty John, Joe, Jack ",
				
				"DifferentIndividuals: Annotations: creator sotty John, Joe, Jack ",
			
		};	
		check(rule,testDRL);										
	}
	
		
	
	
	@Test	
	public void test_manDL_data_type_restriction() {
		String rule = "manDL_data_type_restriction";
		String[] testDRL = new String[] {
				
				"Integer",
				
				"Custom",
				
				
				"Integer[ length 3, > 342 ]",
		};
		check(rule,testDRL);	
	}
	
	
	
	@Test
	public void test_manDL_ontology() {
		String rule = "manDL_ontology";
		String[] testDRL = {
				" Prefix: g: <sk:someIRI#> " +"\n" +								
				" Ontology : owl:myOnto g:v1 " +"\n" +
				" Import: anotherOnto " + "\n" +
				" Annotations: g:creator g:sotty, Annotations: many ways mark sman," + "\n"+
				"              year 2008, sometype string" + "\n" + 
				"  " +"\n" + 
				" Class : g:klass " +"\n" + 
				" Datatype : g:dtype2 " +"\n" +
				" DataProperty : g:dprop " +"\n" +
				" AnnotationProperty : g:aprop " +"\n" +				
				" ObjectProperty : g:oprop" + "\n" +
				" Individual : g:indiv ",
				
				
				
				
				"Namespace: dc <http://purl.org/dc/elements/1.1/>"+ "\n " +
				" Ontology : pass" + "\n " +
				" Import: <http://ontology.dumontierlab.com/atom-common> " + "\n " +
				" " + "\n " +
				"Annotations: " + "\n" + 
			    "dc:publisher \"Dumontier Lab\"^^string,"+ "\n " +
			    "dc:publisher \"Dumontier Lab\"^^xsd:string,"+ "\n " +
			    "dc:title \"Organic Functional Group Ontology (complex)\"^^xsd:string,"+ "\n " +
			    "dc:creator \"Michel Dumontier\"^^xsd:string,"+ "\n " +
			    "dc:language \"en\"^^xsd:string,"+ "\n " +
			    "owl:versionInfo \"2.0\"^^xsd:string,"+ "\n " +
			    "dc:date \"2007-10-01\"^^xsd:date,"+ "\n " +
			    "dc:description \"Complex class descriptions for the realization of organic functional groups.\"^^xsd:string,"+ "\n " +
			    "dc:format \"application/rdf+xml\"^^xsd:string",
				
				
				
				
				" Prefix: g: <sk:someIRI#> " +"\n" +								
				" Ontology : owl:myOnto g:v1 " +"\n" +
				" " + "\n" +
				" Class : Foo " + "\n" +				
				"  Annotations: creatory sotty " + "\n" + 
				"  DisjointUnionOf: Annotations: guess what Child, Adult" + "\n" +
				"  SubClassOf: Person and Worker" + "\n" +
				"  EquivalentTo: Annotations: guess again Person, Slave" + "\n" +
				"  DisjointWith: Person" + "\n" +
				"  HasKey: Annotations: annkey targt hasSSN" + "\n" +
				"\n",
											
		};	
		check(rule,testDRL);
		
		
	}
	
	
	@Test
	public void test_manDL_prefix() {
		String rule = "manDL_prefix";
		String[] testDRL = {
				" Prefix: g: <sk:someIRI> " +"\n",
				" Namespace: g <sk:someIRI> " +"\n",
				" Namespace: <sk:someIRI> " +"\n",
				" Namespace: dc <http://purl.org/dc/elements/1.1/>",
				" Namespace:  <http://www.co-ode.org/ontologies/pizza/pizza.owl#>",
				
											
		};	
		check(rule,testDRL);										
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test_foaf_ontology() {
		test_ontology("foaf.manchester");			
	}
	
	
	
	@Test
	public void test_pizza_ontology() {
		test_ontology("pizza.manchester");
	}
	
	@Test
	public void test_amminoacids_ontology() {
		test_ontology("amminoacids.manchester");
	}
    
	@Test
	public void test_bhakti_ontology() {
		test_ontology("bhakti.manchester");
	}
	
	@Test
	public void test_organic_ontology() {
		test_ontology("organic_fun_group.manchester");
	}
	
	@Test
	public void tourism_ontology() {
		test_ontology("tourism.manchester");
	}
	

	
    
    
               
            
    
    
    
	public void test_ontology(String ontoName) {
		String rule = "manDL_ontology";
		InputStream stream = Manchester_Test.class.getClassLoader().getResourceAsStream(ontoName);
		assertNotNull(stream);

		try {
			byte[] buf = new byte[stream.available()];
			stream.read(buf);
			String source = new String(buf);

			check(rule,new String[] {source});
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail();
		}
		
		

	}
	
	    
    
    

	
	
	
	
	private void check(String key) {
		try {
			Method method = Manchester_Test.class.getMethod(key);
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
			ruleM = ManchesterParser.class.getMethod(rulekey);
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
						ManchesterLexer lexer = new ManchesterLexer( new ANTLRInputStream( new ByteArrayInputStream(drlString.getBytes()) ));			
						ManchesterParser parser = new ManchesterParser(new CommonTokenStream( lexer ));
						
						
					
						long start = new Date().getTime();
							ParserRuleReturnScope root;			
							root = (ParserRuleReturnScope) ruleM.invoke(parser);
							long after = new Date().getTime();
					
							final CommonTree resultTree = (CommonTree) root.getTree();
							fakeRoot.addChild(resultTree);
																	
					
						final String tree = DRLTreeFormatter.toIndentedStringTree(resultTree);
						log.log(Level.INFO, tree);
						
						
						res.setNumErrors(parser.getNumberOfSyntaxErrors());
						res.setTree(resultTree);
						res.setParseTime(after-start);
						
						if (rulekey.equals("manDL_ontology")) {
							ManchesterTreeBuilder builder = new ManchesterTreeBuilder(new CommonTreeNodeStream(resultTree));
							DL_OntologyDescr od = builder.ontology();
							
							System.out.println(od.toFullDownwardString(2));
							
							res.setNumErrors(res.getNumErrors()+builder.getNumberOfSyntaxErrors());
							
						}
					
						
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
	
		
	
	
	
	public static void main(String[] args) {
		try {
			Manchester_Test tester = new Manchester_Test();
				log = Logger.getAnonymousLogger();
				log.setLevel(Level.INFO);
				tester.setVisual(true);
				
								
				Vector<String> methods = new Vector<String>();
					Class<?> klass = Manchester_Test.class;
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
							Manchester_Test tester = new Manchester_Test();
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








