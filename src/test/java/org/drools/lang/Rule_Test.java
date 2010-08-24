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


public class Rule_Test {

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
	public void test_compilation_unit() {	
		String rule = "compilation_unit";
		String[] testDRL = new String[] {
				"package org.pack.subpack;\n" +
				"import org.klass;" + "\n" +
				" " + "\n" +	
				"global int N; \n" +				
				" " + "\n" +
				"Ontology : test" + "\n" +
				" @Class declare Test end " + "\n" +
				" " + "\n" +
				"rule \"ruel\"\n" +
				"when\n" +
				"then\n" +
				"end\n"
				};	
		check(rule,testDRL);	 									
	}	
	
	
	
	@Test	
	public void test_package_statement() {		
		String rule = "package_statement";
		String[] testDRL = new String[] {
				"package this.isa.pack ;",
				"package semi.colon.is.optional ",
				"package simplePack",
		};
		check(rule,testDRL);											
	}	
	
	
	@Test	
	public void test_global() {	
		String rule = "global";
		String[] testDRL = new String[]  {
				"global int N ",
				"global String[][] tab ",
				"global org.it.pack.String strix ;"
				
		};
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_data_type() {	
		String rule = "data_type"; 
		String[] testDRL = new String[] {
				"String",
				"int",
				"float[]",
				"org.pack.data.Claxx[]",
				"int[][][]"
			};
		check(rule,testDRL);											
	}	
	
	
	@Test	
	public void test_import_statement() {	
		String rule = "import_statement";
		String[] testDRL = new String[] {
				"import jav.lang.String",
				"import Test ; ",
				"import jav.pack.*"
		};
		check(rule,testDRL);									
	}
	
	@Test	
	public void test_function_import_statement() {
		String rule = "function_import_statement";
		String[] testDRL = new String[] {
				"import function org.pack.square"
		};
		check(rule,testDRL);										
	}		
	
	@Test	
	public void test_function() {
		String rule = "function";
		String[] testDRL = new String[] {
				"function float square( float x ) { ... x*x ... }",
				"function process( int x, org.String zz ) { ... ... }"
		};
		check(rule,testDRL);	
		
	}
	
	
	@Test	
	public void test_parameters() {
		String rule = "parameters";
		String[] testDRL = new String[] {
				"( int a, org.klass.AnType obj, String[][] argz )"
		};
		check(rule,testDRL);		
	}	
	
	
	@Test
	public void test_fqn() {
		String rule = "fully_qualified_name";
		String[] testDRL = new String[] {
				"Student",
				"org.Student",
				"org.other.Student"
		};
		check(rule,testDRL);
	}
			
	
	@Test	
	public void test_decl_field() {
		String rule = "decl_field";
		String[] testDRL = new String[] {
				"field : datatype[][] @[key]"
		};
		check(rule,testDRL);	
	}
	
	
	
	@Test		
	public void test_rule() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"ruleName\" extends \"anotherRule\" " + "\n" +
				" @salience(100) " + "\n" +
				" @no-loop " + "\n" +
				" @calendar( \"s1\" , \"s2\" )" + "\n" +
				"deduction @crisp" + "\n" +
				"implication @[crisp]" + "\n" +
				"when" + "\n" +
				"then" + "\n" +
				"end" + "\n" 	
		};
		check(rule,testDRL);									
	}	
	
	
	@Test		
	public void test_rule_arrow() {
		String rule = "rule";
		String[] testDRL = new String[] {				
				"rule test deduction @crisp when then end \n", 
				"rule test implication @crisp when then end \n",
				"rule test deduction @crisp implication @crisp when then end \n",
				"rule test implication @crisp deduction @crisp when then end \n",
				
		};
		check(rule,testDRL);									
	}	
	
	
	@Test	
	public void test_rule_attributes() {	
		String rule = "rule_attributes";
		String[] testDRL = new String[] {
				"@salience(100)",
				"@no-loop(true)",
				"@agenda-group(\"test-group\")",
				"@activation-group(\"act-group\")",
				"@auto-focus(false)",
				"@effective(\"2010-04-12\")",
				"@expires(\"2010-04-12\")",
				"@enabled(true)",
				"@ruleflow-group(\"act-group\")",
				"@agenda-group(\"act-group\")",
				"@duration(100)",
				"@timer(100)",
//TODO: fails as stand-alone, but works in context..				
//				"calendar \"s1\" , \"s2\" ",
				"@dialect( \"java\" )",
				"@lock-on-active(true)",
				"@defeats(\"anotherRule\")",
				"@deductive",
				"@abductive",
				"@equivalence",				
		};
		check(rule,testDRL);										
	}	  
	
	
	@Test	
	public void test_operator_attributes() {
		String rule = "operator_attributes";
		String[] testDRL = new String[] {				
				"@[" + "\n" +
				"kind(\"lukasiewicz\"), " + "\n" +
				"id(\"myID\"), " + "\n" +
				"params(\"addit,args,2,more\"), " + "\n" +
				"degree(\"[0.3,0.2]\"), " + "\n" +
				"crisp," + "\n" +
				"default," + "\n" +
				"defeat," + "\n" +
				"merge(\"mStrat\"), " + "\n" +
				//"filter=\"fStrat\", " + "\n" +		//TODO: removed "filter" from here
				"missing(\"sStrat\") " + "\n" +
				"]",									
		};
		check(rule,testDRL);	
	}
	
	
	@Test
	public void test_lhs_root() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " +
				"Bus() Car() Taxi()" +
				"then end"
		};
		check(rule,testDRL);									
	}	
	
	
	
	@Test
	public void test_lhs_implies() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " +
				"$p : Person() implies @kind(\"anImpl\") @crisp Dog()" +
				"then end"
		};
		check(rule,testDRL);								
	}	
	
	
	@Test
	public void test_lhs_or() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " +
				"Car() or @kind(\"anOr\") Taxi() or @[kind(\"anotherOr\")] Bus()" +
				"then end"
		};
		check(rule,testDRL);									
	}	
	
	
	@Test
	public void test_lhs_diff() {
		
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " +
				"$p : Person() xor Dog()" +
				"then end",
				
				"rule test when " +
				"(Person() xor Dog()) equiv Cat()" +
				"then end"
		};
		check(rule,testDRL);
	}	
	
	
	@Test
	public void test_lhs_and() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " +
				"Car() and Taxi() and Bus()" +
				"then end",
				
				"rule test when " +
				"Car() Taxi() Bus()" +
				"then end"
		};
		check(rule,testDRL);											
	}		
	
	
	@Test
	public void test_lhs_root_complex() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " +
				"(P() implies Q()) implies ( (K() equiv K()) or Z() and X() )" +
				"then end"
		};
		check(rule,testDRL);		
	}	
	
	
	@Test	
	public void test_lhs_modified_unary() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"neg @[crisp] very @[crisp] Person() " +
				"then end",
				
				"rule \"r\" when " +
				"$lab : Person()" +
				"then end",
				
				"rule \"r\" when " +
				"(Person() implies Dog())" +
				"then end"			
		};
		check(rule,testDRL);	
	}
	
	
	@Test	
	public void test_lhs_exists() {		
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"exists @[crisp] ( $p : Person() and $d : Dog() ) " +
				"then end",
				
				"rule \"r2\" when " +
				" $p : exists Person() " +
				"then end",
				
				"rule \"r3\" when " +
				" $tup : exists ( Person() Car() )" +
				"then end",			
		};
		check(rule,testDRL);								
	}	
	
	
	@Test	
	public void test_lhs_not() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"not @[crisp] ( $p : Person() and $d : Dog() ) " +
				"then end",
				
				"rule \"r\" when " +
				" not Person() " +
				"then end",										
		};
		check(rule,testDRL);										
	}	
	
	
	
	@Test	
	public void test_lhs_forall() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"forall @[crisp] Person() " +
				"then end",
				
				"rule \"r\" when " +
				"forall  ( $p : Person() " +
				"               Person() ) " +
				"then end",
				
				"rule \"r\" when " +
				"forall  ( $p : Person() " +
				"               (Person() Dog()) ) " +
				"then end",
				
				"rule \"r\" when " +
				"forall  ( ($p : Person() $d : Dog() )" +
				"          (     Person()      Dog() ) " +
				"        ) " +
				"then end",											
		};
		check(rule,testDRL);	
		
	}	
	
	
	
	
	@Test	
	public void test_lhs_label_atom_pattern() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"$p : Person() " +
				"then end",
				
				"rule \"r\" when " +
				"Person() @[crisp]" +
				"then end",
				
				"rule \"r\" when " +
				"org.lang.String() @[crisp]" +
				"then end",
		};
		check(rule,testDRL);											
	}
	
	
	
	@Test
	public void test_constraints() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"Person( \"john\" , 18, height > 150) " +
				"then end",
		};
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_positional_constraint() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"r\" when " +
				"Person( \"john\" , 18, 2.0, ?, ?, true, null, new Dog(), {12, $x, \"test\" }, $var, ? == 3) " +
				"then end",
		};
		check(rule,testDRL);	
	}
	
	
	@Test	
	public void test_nested() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule \"inNest\" when " + "\n" +
				"Person( name.firstPart == \"john\" ) " + "\n" +
				"then end",
				
				"rule \"inNest2\" when " + "\n" +
				"Person( name== \"mark\", address.#Address( city == \"london\", country == \"uk\") ) " + "\n" +
				"then end",
					
				"rule \"inNest2\" when " + "\n" +
				" $p : Person( $a : getAddresses()[ #LongAddress( location == \"london\") ] ) " + "\n" +
				"then end",
				
				"rule \"inNest2\" when " + "\n" +
				" Person( $p : | pets[ #Dog(color == \"red\") ].age * $v1 | == $v2 - 3 ) " +
				"then end",
		};
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_literal_object() {
		String rule = "literal_object";
		String[] testDRL = new String[] {
				"new Thing(13, $var, true, new Obj(2))",				
		};
		check(rule,testDRL);	
	}		
	
	
	@Test	
	public void test_method() {
		String rule = "method";
		String[] testDRL = new String[] {
				"method(2.0, 3.0#km, \"xx\")",
				"method()#km",
				"method( new Obj(), [[ 3, 4 ]] )",
		};
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_method_args() {
		String rule = "literal_object";
		String[] testDRL = new String[] {
				"new Obj(12 - 13*($var*2 + sqrt(4)))"
		};
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_decl_dl() {
		String rule = "manDL_type_declaration";
		String[] testDRL = new String[] {
				"declare Student " + "\n" +
				" as Male and Human and (Slave or worksAt some (School or Prison))" + "\n" +				
				" age  : int " + "\n" +
				" name : String " + "\n" +
				" end \n"
		};
		check(rule,testDRL);											
	}
	
	
	
	@Test	
	public void test_constr_implies() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" implies age < 18)" + "\n" +
				"then end"
		};
		check(rule,testDRL);	
	}
	
	
	@Test	
	public void test_constr_or() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" implies age < 18 or age > 25)" + "\n" +
				"then end"
		};
		check(rule,testDRL);											
	}
	
	
	
	@Test	
	public void test_constr_diff() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 xor age > 25)" + "\n" +
				"then end",
				
				"rule test when " + "\n" +
				" Person( age < 18 equiv age > 25)" + "\n" +
				"then end",			
		};
		check(rule,testDRL);											
	}	
	
	
	
	@Test	
	public void test_constr_and() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" and @crisp age < 18 and @kind(\"xx\") age > @id(\"..\") 25)" + "\n" +
				"then end"
		};
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_constr_unary() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( neg very (name == \"john\" implies age < 18) )" + "\n" +
				"then end",							
		};
		check(rule,testDRL);									
	}
	
	
	
	@Test	
	public void test_restr_implies() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" -> == \"mark\")" + "\n" +
				"then end"
		};
		check(rule,testDRL);											
	}
	
	
	@Test	
	public void test_restr_or() {		
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 || > 25)" + "\n" +
				"then end"
		};
		check(rule,testDRL);							
	}
	
	
	
	@Test	
	public void test_restr_diff() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 ^^ > 25)" + "\n" +
				"then end",
				
				"rule test when " + "\n" +
				" Person( age < 18 <> > 25)" + "\n" +
				"then end",
				
		};
		check(rule,testDRL);										
	}	
	
	
	
	@Test	
	public void test_restr_and() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 && @kind(\"xx\") > @id(\"..\") 25)" + "\n" +
				"then end"
		};
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_restriction_root() {
		String rule = "restriction_root";
		String[] testDRL = new String[] {				
				" all == @crisp 18 + 2#ms*$x#km " ,
				// TODO
				//" all == @crisp 18 + 2*$var "
				// again, works only within a rule and not parsed standalone
				// problem is var_literal, without measure unit
		};
		check(rule,testDRL);										
	}	
	
	@Test
	public void test_lhs_query() {
		String rule = "lhs_query";
		String[] testDRL = {							
				" ?queryName( \"literal\", $p, $unificationVar ) from federatedDataTable"  
				
		};
		check(rule,testDRL);										
	}
	
	
	@Test
	public void test_query() {
		String rule = "query";
		String[] testDRL = {							
				" query queryName(int arg1, String arg2, Obj arg3)" + "\n" +
				"  $o1 : Object1( field1 == arg1 ) " + "\n" +
				"  Object2( field1 == $o1, field2 == $arg3) " + "\n" +
				" end "				
		};
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_msr_unit() {
		String rule = "msr_unit";
		String[] testDRL = new String[] {				
				" #m#km#cm" ,				
		};
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_literal_msr_unit() {
		String rule = "literal";
		String[] testDRL = new String[] {				
				" 2#km ",
				" 2.0#cm#m " ,				
		};
		check(rule,testDRL);										
	}	
	
	/*
	lhs_branch
	  : BRANCH 
	      LEFT_PAREN  
	        lhs_base?
	        branch_alternative+
	      RIGHT_PAREN  
	      -> ^(VT_BRANCH ^(VT_BRANCH_DEFAULT lhs_base)? branch_alternative+ )
	  ;	  
	
	*/
	
	@Test	
	public void test_branch() {
		String rule = "rule";
		String[] testDRL = new String[] {
				" rule test when " + "\n" +
				"  branch (" + "\n" +
				"	Person( ) " + "\n" +
				"	[b1] Person( ) " + "\n" +
				"	[b2] ( neg @crisp exists Person( ) ) " + "\n" +
				" ) " + "\n" +
				" then end ",
		};
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_branch_alternative() {
		String rule = "branch_alternative";
		String[] testDRL = new String[] {				
				" [label] Person() ",				
				" [! label] Person() ",
				" [label] ( rising Person() ) ",	
				" [label] ( ( Person() or Person() ) | unique )",
		};
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_branch_label() {
		String rule = "branch_label";
		String[] testDRL = new String[] {				
				" [label] ",				
				" [! label] ",
		};
		check(rule,testDRL);										
	}
	
	
	
	
	
	@Test	
	public void test_expression() {
		String rule = "right_expression";
		String[] testDRL = new String[] {				
				" 2*($x#km+1000) + 500*size.len ",
				//" 2 * $p "
				// as above
		};
		check(rule,testDRL);										
	}	
	
	
	
	@Test	
	public void test_expression_in_rule() {
		String rule = "rule";
		String[] testDRL = new String[] {				
				" rule test when " + "\n" +
				"  Person( age all == @crisp 18 + 2*$var ) " + "\n" +
				" then end ",
		};
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_var_literal() {
		String rule = "var_literal";
		String[] testDRL = new String[] {				
				" $x ",
				" $x#km ",
				" $x#km#m ",
		};
		check(rule,testDRL);										
	}
		
	
	
	
	@Test	
	public void test_left_expression() {
		String rule = "left_expression";
		String[] testDRL = new String[] {				
				" $a : age " + "\n",
				
				"| (age + 2) * $x + 4 * weight.subField |", 
				
				"$x : | $z + 4 * weight |",
				
				"$a : | (age * 2 + 4 * weight + height) |",								
		};
		check(rule,testDRL);								
	}
	
	
	
	@Test	
	public void test_left_expression_in_rule() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( $a : age )" + "\n" +
				"then end",
							
				"rule test when " + "\n" +
				" Person( ($a : | age * 2 + 4 * weight |  == 18) implies (age < 25 and age > 4)  )" + "\n" +
				"then end",								
		};
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_accessor_path() {
		String rule = "accessor_path";
		String[] testDRL = new String[] {				
				" age ",
				
				" $var.field ",
				
				"address.city.street(2).number", 
				
				"$addr.city.#pack.Street( number == 2).subfield[4].subsubfield",												
		};
		check(rule,testDRL);											
	}
	
	
	
	@Test	
	public void test_accessor() {
		String rule = "accessor";
		String[] testDRL = new String[] {				
				" age ",
				
				" someMethod(\"p1\",2) ", 
								
				" #nested( age == 18 ) ",
				
				" pets[3] ",
				
				" age<<1>> ",
				
				" age<<0 .. -5>> ",
		};
		check(rule,testDRL);										
	}		
	
	
	
	@Test	
	public void test_indexer() {
		String rule = "indexer";
		String[] testDRL = new String[] {												
				" [3] ",
				" [\"rover\"] ",
				" [ getId(2734) ]",
				" [ #Pattern( age == 18) ]"
				
		};
		check(rule,testDRL);								
	}
	
	
	
	@Test	
	public void test_right_expression() {
		String rule = "rule";
		String[] testDRL = new String[] {												
				" rule test when " + "\n" +
				" Person( age > 2*$height + $z * weight * comput($k) )" + "\n" +
				" then end ",
				
				" rule test when " + "\n" +
				" Person( |2*age()| == 3*height*method(weight + 2 *$k*sqrt(x)) )" + "\n" +
				" then end ",								
		};
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_from() {
		String rule = "from";
		String[] testDRL = new String[] {												
				" from entry-point byId ",
				" from entry-point \"byStr\" ",
				
				" from $var.access ",
				
				" from collect ( Person() )",
				" from collect ( $p : Person() from $source )",
				
				" from collect ( Person() )",														
				
				" from [\"str1\", \"str2\"]",
				
				" from [ 1,2,3,4,5 ]",
				" from [ $v1, $v2, $v3 ]",
				
				" from accumulate ( Person() ) ",
				" from acc ( Person() ) ",
				" from accL ( Person() ) ",
				" from accR ( Person() ) ",
		};
		check(rule,testDRL);									
	}
	
	
	
	
	
	
	
	@Test	
	public void test_from_rule() {
		String rule = "rule";
		String[] testDRL = new String[] {																				
				" rule test when " + " \n" +
				" Person() from collect ( $p: Person() from list )" + "\n" +
				" then end",				
		};
		check(rule,testDRL);
	}	
	
	
	@Test	
	public void test_accumulate() {
		String rule = "rule";
		String[] testDRL = {
				"rule other1 when " + "\n" +	
				" List( ) from acc ( Person() ) " + "\n" +
				"then end ",
				
				"rule other1 when " + "\n" +	
				" List( ) from acc ( " + "\n" +
				"	Person(), " + "\n" +
				"	init( int j = 0; ) " + "\n" +
				"	action( j++; ) " + "\n" +
				"	reverse( j--; ) " + "\n" +
				"	result( j; ) " + "\n" +
				") " + "\n" +
				"then end ",
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_label() {
		String rule = "label";
		String[] testDRL = new String[] {
				" $var : "
		};
		check(rule,testDRL);
	}
	
	
	
	@Test	
	public void test_binding() {
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when" + "\n" +
				" Person( $a : age ) " + "\n" +
				"then end",	
				
				"rule test when" + "\n" +
				" Person( $a : | age + 4 | ) " + "\n" +
				"then end",
		};
		check(rule,testDRL);
	}
	
	
	
	@Test	
	public void test_inner_quantifier() {
		String rule = "inner_quantifier";
		String[] testDRL = new String[] {
				"all",
				"some",
				"value",
				"count @[5]",
				"count @[min=1, max=10]",						
		};
		check(rule,testDRL);
	}		
	
	
	
	@Test	
	public void test_inner_quantifier_in_rule() {	
		String rule = "rule";
		String[] testDRL = new String[] {
				"rule test when" + "\n" +
				" Person( age count @[5] == @crisp 18 ) " + "\n" +
				"then end",						
		};
		check(rule,testDRL);		
	}
	
	
	
	@Test	
	public void test_evaluator() {
		String rule = "evaluator";
		String[] testDRL = new String[] {
				"==",
				"!=",
				">",
				">=",
				"<",
				"<=",
				"~==",
				"~!=",
				"~>",
				"~>=",
				"~<",
				"~<=",
				"in",
				"contains",
				"custom"
		};
		check(rule,testDRL);
	}
	
	
	
	@Test	
	public void test_filter_chains() {
		String rule = "rule";
		String[] testDRL = new String[] {
				" rule test when " + "\n" +
				" Person( age > 18) | window::length( 10 ) | window::time(2h)" + "\n" +
				" then end ",
				
				" rule test when " + "\n" +
				" 	( " + "\n" +
				"		Person( age > 18)" + "\n" +
				"		Person( ) " + "\n" +
				"	) | window::length( 10 ) | window::time(2h)" + "\n" +
				" then end ",							
				
				" rule test when " + "\n" +
				" 	( " + "\n" +
				"		Person( )" + "\n" +
				"		Person( ) " + "\n" +
				"	) | unique | throttle(30)" + "\n" +
				" then end ",
		};
		check(rule,testDRL);
	}
		
	
	@Test	
	public void test_rhs_side_effect() {
		String rule = "then_part";
		String[] testDRL = new String[] {
				" then <% ... %> end ",
				 
				" then " + "\n" +
				"   < java % " + "\n" +
				"		System.out.println(); " + "\n" +
				"		Math.abs(12); " + "\n" +
				"	%> " + "\n" +
				"  <% System.out.println(); %> " + "\n" +
				" end ",
				
				" then < mvel % ... %> end",
		};
		check(rule,testDRL);
	}
	
	
	@Test	
	public void test_rhs() {
		String rule = "then_part";
		String[] testDRL = new String[] {				
				 
				" then " + "\n" +
				"  insert new Object(); " + "\n" +
				"  insert [[ \"st\", 22, getit(), new Obj() ]]; " + "\n" +
				"  insertLogical new String(\"test\");" + "\n" +				
				"  retract new Object(); " + "\n" +
				"  retract $x; " + "\n" +				
				"  retractLogical new Object(); " + "\n" +
				"  retractLogical $x; " + "\n" +
				"  update $x; " + "\n" +
				" end ",
				
				" then " + "\n" +
				"  modify ($x) { " + "\n" +
				"    age = 18; " + "\n" +
				"    name = \"john\"; " + "\n" +
				"    address.city = ask(); " + "\n" +
				"  } " + "\n" +
				" end ",
				
		};
		check(rule,testDRL);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test	
	public void test_dle_nested_objects() {
		String rule = "lhs_atom_pattern";
		String[] testDRL = {
				"Person( name==  \"mark\", address.#( city == \"london\", country ==  \"uk\") )"
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_dle_nested_objects_cast() {
		String rule = "lhs_atom_pattern";
		String[] testDRL = {
				"Person( name==  \"mark\", address.#org.dom.LongAddress( city == \"london\", country ==  \"uk\").subfield )"
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_dle_positional() {
		String rule = "lhs_atom_pattern";
		String[] testDRL = {
				"Person( \"mark\", 34, address.#(\"london\",  \"uk\") )"
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_dle_mixed() {
		String rule = "lhs_atom_pattern";
		String[] testDRL = {
				"Person( \"mark\", age == 34, address.#(\"london\",  \"uk\") )"
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_dle_methods() {
		String rule = "lhs_atom_pattern";
		String[] testDRL = {
				"Person(  m1() == $x, address.m2() == $y, $z : m3() )"
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_dle_mapsarrays() {
		String rule = "lhs_atom_pattern";
		String[] testDRL = {
				"Person(  pets[0].age == 15 )",
				"Person( pets[\"rover\"].age == 15 )"
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_dle_xpath_filters() {
		String rule = "lhs_label_atom_pattern";
		String[] testDRL = {
				"$per : Person( $pet: pets[ #Dog( age == 15 ) ] )",
				"$per : Person( $a : mAddr()[ #LongAddress( loc == \"london\") ] )",
				"$per : Person( $pet : pets[]  )",
				"$per : Person( $pet : pets[ last() ]  )"
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_dle_free_expr() {
		String rule = "lhs_label_atom_pattern";
		String[] testDRL = {			
				"Person( |pets[\"rover\"].age| ==  ($otherAge.someMethod( $x ) + 3 ) / 2 )"
		};
		check(rule,testDRL);										
	}

	@Test
	public void test_dle_rule_query() {
		String rule = "rule";
		String[] testDRL = {			
				"rule test when " + "\n" +
				" $p : Person() " + "\n" +
				" ?queryName( \"literal\", $p, $unificationVar ) " + "\n" +
				" then end"
		};
		check(rule,testDRL);										
	}
	
	
	@Test
	public void test_dle_slot_specific() {
		String rule = "rule";
		String[] testDRL = {			
				"rule test when " + "\n" +
				" $p : Person() @onChange(*,!name)" + "\n" +
				" $p2 : Person() @onChange(name, age)" + "\n" +
				" then end"
		};
		check(rule,testDRL);										
	}
	
	
	@Test
	public void test_dle_edges() {
		String rule = "rule";
		String[] testDRL = {			
				"rule test when " + "\n" +
				" rising Person() " + "\n" +
				" falling ($p : Person() ) " + "\n" +
				" then end"
		};
		check(rule,testDRL);										
	}
	
	
	@Test
	public void test_dle_version() {
		String rule = "rule";
		String[] testDRL = {			
				"rule test when " + "\n" +
				" Person( age<<-1>> == field.val<<-2>>.someother ) " + "\n" +
				" then end"
		};
		check(rule,testDRL);										
	}
	
	@Test
	public void test_dle_closure() {
		String rule = "rule";
		String[] testDRL = {			
				"rule test when " + "\n" +	
				" then " + "\n" +
				"   <% System.out.println(\"true\"); %>" + "\n" +
				" closure" + "\n" +
				"   <% System.out.println(\"no more\"); %> " + "\n" +
				" end" 
		};
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_dle_otherwise() {
		String rule = "rule";
		String[] testDRL = {
				"rule other1 when " + "\n" +	
				" Person( name == @otherwise(\"og1\") \"john\" )" + "\n" +
				"then end ",			
				
				"rule other2 when " + "\n" +	
				" Person( name == @otherwise(\"og1\") \"mark\" )" + "\n" +
				"then end",
				
				"rule otherDef when " + "\n" +	
				" Person( name == @otherwise(\"og1\") OTHERWISE )" + "\n" +
				"then end",
		};
				
		check(rule,testDRL);										
	}
	


	
	@Test	
	public void test_dle_accumulate() {
		String rule = "accumulate_statement";
		String[] testDRL = {
				"acc ( " + "\n" +
				"  $n : Number() from [-9 .. -5] " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $n : Number() from [1 .. 5], " + "\n" +
				"  collectList( | $n + 1 | ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $user : User() from users, " + "\n" +
				"  $parentNames : collectList( $user.parent.name ) " + "\n" +
				") ",	
				
				"acc ( " + "\n" +
				"  ( $user : User() from users" + "\n" +
				"    $parent : Parent( age > 30 ) from $user.parent ), " + "\n" +
				"  $parentNames : collectList( $parent.name ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $s : String() from [\"foo\" , \"bar\"], " + "\n" +
				"  collectList( $s.toUpperCase() ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $n : Number() from [2,4,8,16,32], " + "\n" +
				"  collectList( | $n | < 10  ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $n : Number( | intValue / 2 | == 0 ) " + "\n" +
				"     from acc( $n2 : Number() from [0 .. 10], " + "\n" +
				"               collectList( |$n2*$n2| )" + "\n" +
				"             ), " + "\n" +
				"  collectList( $n ) " + "\n" +
				") ",
																
				
		};				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_dle_accumulate_functions() {
		String rule = "accumulate_statement";
		String[] testDRL = {
				"acc ( " + "\n" +
				"  $p : Person(), " + "\n" +
				"  $num : count( ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  avg( $h * $w / 100 ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  sum( $w ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  min( $w ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  max( $w ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  limit( 100 ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  orderby( $h.val[3].fld , $w ) " + "\n" +
				") ",
				
				"acc ( " + "\n" +
				"  $p : Person( $h : height, $w : weight ), " + "\n" +
				"  distinct( $p ) " + "\n" +
				") ",
				
																				
		};				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_dle_ordered_patterns() {
		String rule = "rule";
		String[] testDRL = {
				"rule test when " + "\n" +
				" Person( age != 18)" +
				" [[ 23, ?, \"mark\", ? , ? != 18 ]]" + "\n" +
				"then end",
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_dle_sequence() {
		String rule = "lhs_sequence";
		String[] testDRL = {
				"seq (" + "\n" +
				" begin @start C() >> finish @end; "  + "\n" +
				"  "  + "\n" +
				" mynode @start $d : D() >> finish @end; "  + "\n" +
				"  "  + "\n" +
				" begin @start $e : E() >> midstate $f : F( this after $e) >> name; "  + "\n" +
				"  "  + "\n" +
				" name (C() or B()) >> finish @end;  "  + "\n" +
				"  "  + "\n" +
				")",						
		};
				
		check(rule,testDRL);										
	}
	
	
	
	
		
	
	@Test	
	public void test_manDL_declaration_root() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"@Class " + "\n" +
				"declare foo " + "\n" +
				"end",
				
				"Class : foo ",
				
				"@Event declare SomeEvent end",
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_manDL_annotations() {
		String rule = "manDL_annotations";
		String[] testDRL = {
				"@annotations( creator sotty, author davide )",
				
				"Annotations : creator sotty",
				
				"Annotations : creator sotty, " +
				"	Annotations: rdfsComment year creationYear 2008, " +
				"mainClass Person," +
				"	@annotations(meta target) annotationProp annotationTgt",
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_manDL_class() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"@Class " + "\n" +
				"declare org.com.Foo " + "\n" +
				" Annotations: creatory sotty " + "\n" +
				" DisjointUnionOf: @annotations(guess what) Child, Adult" + "\n" +
				" SubClassOf: Person and Worker" + "\n" +
				" EquivalentTo: @annotations(guess again) Person" + "\n" +
				" DisjointWith: Person" + "\n" +
				" HasKey: Annotations: annkey targt hasSSN" + "\n" + 
				"end",
				
				
				"@Class " + "\n" +
				"declare org.com.Foo2 " + "\n" +				
				" as Person or Worker and hasAge Integer[ < 33 ]" + "\n" +								
				"end",
				
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_manDL_datatype_declaration() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"Datatype: NegInt " + "\n" +				
				" EquivalentTo: Annotations: creator sotty Integer[ < 0 ], NegativeInteger" + "\n",
				
				"@Datatype declare NegInt " + "\n" +				
				" as Integer[ < 0 ]" + "\n",
				
		};
				
		check(rule,testDRL);										
	}

	
	
	@Test	
	public void test_manDL_annotated_description() {
		String rule = "manDL_annotated_description";
		String[] testDRL = {
				"@annotations(tell me) Human or Animal or Robot and not Alien",
				
				"Person and (" +
				"	hasChildren exactly 3 Male or hasChildren min 2 Female ) ",
				
				"hasChildren Male",
				
				"Person and hasChildren some Male ",
				
				"Person and hasChildren only Male ",
				
				//TODO individual "Person and hasChildren value john ",
				
				"Person and hasChildren min 3 ",
				
				"Person and hasChildren max 5 ",
				
				"Person and hasChildren exactly 10 (Male or Female and hasFriend only Cat)",
				
				"Thing that hasFirstName exactly 1 and hasFirstName only String[minLength 1]",
				
				"hasAge exactly 1 and hasAge only not NegInt",
				
				"hasGender exactly 1 and hasGender only {\"female\", \"male\"}",
				
				"hasFirstName value \"John\" or hasFirstName value \"Joe\" ",
				
				
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_manDL_objectprop() {
		String rule = "manDL_type_declaration";
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
				
				
				"@ObjectProperty declare hasWife" + "\n" +				
				" @Functional" +
				" @InverseFunctional" +
				" @Reflexive " +
				" @Irreflexive " +
				" @Asymmetric " +
				" @Transitive " + "\n" +
				" domain : Person" + "\n" +         
				" range : Woman " + "\n" +
				"end ",
			
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test
	public void test_manDL_dataprop() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"DataProperty: hasAge" + "\n" +				
				" Annotations: creator sotty " + "\n" +
				" Characteristics: Functional " + "\n" +
				" Domain: Person " + "\n" +
				" Range: integer " + "\n" +
				" SubPropertyOf: hasVerifiedAge" + "\n" +
				" EquivalentTo: hasAgeInYears " + "\n" +
				" DisjointWith: hasSSN " + "\n",



				"@DataProperty declare hasAge" + "\n" +				
				" @Functional" +				
				" domain : Person" + "\n" +         
				" range : Integer " + "\n" +
				"end ",

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

				"@AnnotationProperty declare creator" + "\n" +				
				" domain : Person" + "\n" +         
				" range : Integer " + "\n" +
				"end ",

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
	public void test_manDL_misc() {
		String rule = "manDL_type_declaration";
		String[] testDRL = {
				"EquivalentClasses: Annotations: creator sotty q:Rock, q:Scissors, q:Paper ",
				"DisjointClasses: Annotations: creator sotty Rock, Scissors, Paper ",
				"EquivalentProperties: Annotations: creator sotty h:loves, h:hates ",
				"DisjointProperties: Annotations: creator sotty loves, hates ",
				"SameIndividual: Annotations: creator sotty John, Joe, Jack ",
				"DifferentIndividuals: Annotations: creator sotty John, Joe, Jack ",
			
		};	
		check(rule,testDRL);										
	}
	
	
	@Test
	public void test_manDL_ontology() {
		String rule = "manDL_ontology";
		String[] testDRL = {
				" Prefix: g: <someIRI> " +"\n" +								
				" Ontology : myOnto v1 " +"\n" +
				" Import: anotherOnto " + "\n" +
				" Annotations: creator sotty" + "\n" +
				"  " +"\n" +
				" declare g:Test end " +"\n",
											
		};	
		check(rule,testDRL);										
	}
	
	
	/*
	public void test_() {
		String rule = "";
		String[] testDRL = {
				"  " +"\n" +
				"  " +"\n" +
				"  " +"\n" +
				"  " +"\n",
											
		};	
		check(rule,testDRL);										
	}
	*/
	
    
    
    
               
            
    
    
    
    
    
    

	
	
	
	
	private void check(String key) {
		try {
			Method method = Rule_Test.class.getMethod(key);
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
			ruleM = DRLv6Parser.class.getMethod(rulekey);
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
						DRLv6Lexer lexer = new DRLv6Lexer( new ANTLRInputStream( new ByteArrayInputStream(drlString.getBytes()) ));			
						DRLv6Parser parser = new DRLv6Parser(new CommonTokenStream( lexer ));	
						
					
						long start = new Date().getTime();
							ParserRuleReturnScope root;			
							root = (ParserRuleReturnScope) ruleM.invoke(parser);
							long after = new Date().getTime();
					
							final CommonTree resultTree = (CommonTree) root.getTree();
							fakeRoot.addChild(resultTree);
							
						int errors = parser.getNumberOfSyntaxErrors();
					
						final String tree = DRLTreeFormatter.toIndentedStringTree(resultTree);
						log.log(Level.INFO, tree);
																																											
						
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
			Rule_Test tester = new Rule_Test();
				log = Logger.getAnonymousLogger();
				log.setLevel(Level.INFO);
				tester.setVisual(true);
				
								
				Vector<String> methods = new Vector<String>();
					Class<?> klass = Rule_Test.class;
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
							Rule_Test tester = new Rule_Test();
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








