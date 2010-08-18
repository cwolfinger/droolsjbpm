package org.drools.lang;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

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
	
	private static Map<String,String> rules;
	private static Map<String,String[]> data;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log = Logger.getAnonymousLogger();
		log.setLevel(Level.INFO);
		writer = new FileWriter("out/DRLv6Log.txt"); 
		
		rules = new HashMap<String, String>();
		data = new HashMap<String, String[]>();
		
		loadCaseData();
	}
	
	
	
	private static void loadCaseData() {
		String rule;
		String[] testDRL;
		String key;
				
		key =  "test_compilation_unit";
		rule = "compilation_unit";
		testDRL = new String[] {
				"package org.pack.subpack;\n" +
				"import org.klass;\n" +
				"\n" +
				"declare Klass\n" +
				"end\n" +
				"\n" +
				"rule \"ruel\"\n" +
				"when\n" +
				"then\n" +
				"end\n"
				};	
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		
		
		key = "test_package_statement";
		rule = "package_statement";
		testDRL = new String[] {
				"package this.isa.pack ;",
				"package semi.colon.is.optional ",
				"package simplePack",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		
		
		key = "test_global";
		rule = "global";
		testDRL = new String[]  {
				"global int N ",
				"global org.it.pack.String strix ;"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_data_type";
		rule = "data_type"; 
		testDRL = new String[] {
				"String",
				"int",
				"float[]",
				"org.pack.data.Claxx[]",
				"int[][][]"
			};
		rules.put(key,rule);
		data.put(key,testDRL);
	
		key =  "test_import_statement";
		rule = "import_statement";
		testDRL = new String[] {
				"import jav.lang.String",
				"import Test ; ",
				"import jav.pack.*"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_function_import_statement";
		rule = "function_import_statement";
		testDRL = new String[] {
				"import function org.pack.square"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_function";
		rule = "function";
		testDRL = new String[] {
				"function float square( float x ) { ... x*x ... }",
				"function process( int x, org.String zz ) { ... ... }"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		key = "test_parameters";
		rule = "parameters";
		testDRL = new String[] {
				"( int a, org.klass.AnType obj, String[][] argz )"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
				
		
		key = "test_type_declaration";
		rule = "type_declaration";
		testDRL = new String[] {
				"declare Student extends Person" + "\n" +
				" @role(entity) " + "\n" +
				" @namespace(myNS=\"http:\\\\www.stix.com\\domain\\subd#\") " + "\n" +				
				" age  : int " + "\n" +
				" name : String " + "\n" +
				" end \n",
				
				"declare HasFriend extends Knows" + "\n" +
				"@role(property) " + "\n" +
				"@namespace(myNS=\"http:\\\\www.somens.com\\arg\\test#\") " + "\n" +					
				"@disjoint(HasEnemy) " + "\n" +
				"@symmetric " + "\n" +
				"subject	: Person " + "\n" +
				"object  : Person " + "\n" +
				"end " + "\n", 
			
				"declare HasSpouse " + "\n" +
				"@role(property) " + "\n" +
				"@namespace(myNS=\"http:\\\\www.somens.com\\arg\\test#\") " + "\n" +		
				"@symmetric " + "\n" +
				"@transitive " + "\n" +
				"@inverse(HasSpouse) " + "\n" +
				"subject	= (\"john\") : Person 	@[key] " + "\n" +
				"object  : Person	@[key] " + "\n" +
				"end \n",
				
				"declare AnotherWayForAttributes" + "\n" +
				" @[ symmetric, inverse(SomeOther), transitive ] " + "\n" +
				" name : String " + "\n" +
				" end \n",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
				
		
		key = "test_type_declare_attribute"; 
		rule = "type_declare_attributes";
		testDRL = new String[] {
				"@role(event)",
				"@role(type)",
				"@role(entity)",
				"@role(property)",
				"@namespace( alias = \"http:\\\\www.org.dom\\arg# \")",				
				"@disjoint(AnotherType)",
				"@symmetric",
				"@transitive",
				"@inverse(ReverseProperty)"
				
		};	
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_decl_field";
		rule = "decl_field";
		testDRL = new String[] {
				"field = (...) : datatype[][] @[key]"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_rule";
		rule = "rule";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
		key = "test_rule_attributes";
		rule = "rule_attributes";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_operator_attributes";
		rule = "operator_attributes";
		testDRL = new String[] {				
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
		key = "test_lhs_root";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " +
				"Bus() Car() Taxi()" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		key = "test_lhs_implies";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " +
				"$p : Person() implies @kind(\"anImpl\") @crisp Dog()" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
			
		key = "test_lhs_or";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " +
				"Car() or @kind(\"anOr\") Taxi() or @[kind(\"anotherOr\")] Bus()" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
				
		
		key = "test_lhs_diff";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " +
				"$p : Person() xor Dog()" +
				"then end",
				
				"rule test when " +
				"(Person() xor Dog()) equiv Cat()" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		key = "test_lhs_and";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " +
				"Car() and Taxi() and Bus()" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		key = "test_lhs_root_complex";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " +
				"(P() implies Q()) implies ( (K() equiv K()) or Z() and X() )" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		key = "test_lhs_modified_unary";
		rule = "rule";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		key = "test_lhs_exists";
		rule = "rule";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
			
		key = "test_lhs_not";
		rule = "rule";
		testDRL = new String[] {
				"rule \"r\" when " +
				"not @[crisp] ( $p : Person() and $d : Dog() ) " +
				"then end",
				
				"rule \"r\" when " +
				" not Person() " +
				"then end",										
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_lhs_forall";
		rule = "rule";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_lhs_label_atom_pattern";
		rule = "rule";
		testDRL = new String[] {
				"rule \"r\" when " +
				"$p : Person() " +
				"then end",
				
				"rule \"r\" when " +
				"Person() @[crisp]" +
				"then end",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_constraints";
		rule = "rule";
		testDRL = new String[] {
				"rule \"r\" when " +
				"Person( \"john\" , 18, height > 150) " +
				"then end",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_positional_constraint";
		rule = "rule";
		testDRL = new String[] {
				"rule \"r\" when " +
				"Person( \"john\" , 18, 2.0, true, null, new Dog(), {12, $x, \"test\" }, $var) " +
				"then end",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_nested";
		rule = "rule";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
	
		key = "test_literal_object";
		rule = "literal_object";
		testDRL = new String[] {
				"new Thing(13, $var, true)"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_method_args";
		rule = "literal_object";
		testDRL = new String[] {
				"new Obj(12 - 13*($var*2 + sqrt(4)))"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_decl_dl";
		rule = "type_declaration";
		testDRL = new String[] {
				"declare Student " + "\n" +
				" as Male() and Human() and (Slave() or worksAt some (School() or Prison()))" + "\n" +				
				" age  : int " + "\n" +
				" name : String " + "\n" +
				" end \n"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_constr_implies";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" implies age < 18)" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_constr_or";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" implies age < 18 or age > 25)" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
				
		
		key = "test_constr_diff";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 xor age > 25)" + "\n" +
				"then end",
				
				"rule test when " + "\n" +
				" Person( age < 18 equiv age > 25)" + "\n" +
				"then end",			
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		key = "test_constr_and";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" and @crisp age < 18 and @kind(\"xx\") age > @id(\"..\") 25)" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_constr_unary";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( neg very (name == \"john\" implies age < 18) )" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_restr_implies";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( name == \"john\" -> == \"mark\")" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_restr_or";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 || > 25)" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_restr_diff";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 ^^ > 25)" + "\n" +
				"then end",
				
				"rule test when " + "\n" +
				" Person( age < 18 <> > 25)" + "\n" +
				"then end",
				
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_restr_and";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age < 18 && @kind(\"xx\") > @id(\"..\") 25)" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_restriction_root";
		rule = "restriction_root";
		testDRL = new String[] {				
				" all == @crisp 18 + 2*$x#km " ,
				// TODO
				//" all == @crisp 18 + 2*$var "
				// again, works only within a rule and not parsed standalone
				// problem is var_literal, without measure unit
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_expression";
		rule = "right_expression";
		testDRL = new String[] {				
				" 2*($x#km+1000) + 500*size.len ",
				//" 2 * $p "
				// as above
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		key = "test_expression_in_rule";
		rule = "rule";
		testDRL = new String[] {				
				" rule test when " + "\n" +
				"  Person( age all == @crisp 18 + 2*$var ) " + "\n" +
				" then end ",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_var_literal";
		rule = "var_literal";
		testDRL = new String[] {				
				" $x ",
				" $x#km ",
				" $x#km#m ",
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_restriction_root_in_rule";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( age all == @crisp 18+2*$x )" + "\n" +
				"then end"
		};
		rules.put(key,rule);
		data.put(key,testDRL);
	
		key = "test_left_expression";
		rule = "left_expression";
		testDRL = new String[] {				
				" $a : age " + "\n",
				
				"| (age + 2) * $x + 4 * weight.subField |", 
				
				"$x : | $z + 4 * weight |",
				
				"$a : | (age * 2 + 4 * weight + height) |",								
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_left_expression_in_rule";
		rule = "rule";
		testDRL = new String[] {
				"rule test when " + "\n" +
				" Person( $a : age )" + "\n" +
				"then end",
							
				"rule test when " + "\n" +
				" Person( ($a : | age * 2 + 4 * weight |  == 18) implies (age < 25 and age > 4)  )" + "\n" +
				"then end",								
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_accessor_path";
		rule = "accessor_path";
		testDRL = new String[] {				
				" age ",
				
				" $var.field ",
				
				"address.city.street(2).number", 
				
				"$addr.city.#pack.Street( number == 2).subfield[4].subsubfield",												
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_accessor";
		rule = "accessor";
		testDRL = new String[] {				
				" age ",
				
				" someMethod(\"p1\",2) ", 
								
				" #nested( age == 18 ) ",
				
				" pets[3] "
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_indexer";
		rule = "indexer";
		testDRL = new String[] {												
				" [3] ",
				" [\"rover\"] ",
				" [ getId(2734) ]",
				" [ #Pattern( age == 18) ]"
				
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_from";
		rule = "from";
		testDRL = new String[] {												
				" from entrypoint byId ",
				" from entrypoint \"byStr\" ",
				
				" from $var.access ",
				
				" from collect ( Person() )",
				" from collect ( $p : Person() from $source )",
				
				" from collect ( Person() )",														
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_from_rule";
		rule = "rule";
		testDRL = new String[] {																				
				" rule test when " + " \n" +
				" Person() from collect ( $p: Person() from list )" + "\n" +
				" then end",				
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_label";
		rule = "label";
		testDRL = new String[] {
				" $var : "
		};
		rules.put(key,rule);
		data.put(key,testDRL);
			
		
		key = "test_inner_quantifier";
		rule = "inner_quantifier";
		testDRL = new String[] {
				"all",
				"some",
				"value",
				"count @[5]",
				"count @[min=1, max=10]",						
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_inner_quantifier_in_rule";
		rule = "rule";
		testDRL = new String[] {
				"rule test when" + "\n" +
				" Person( age count @[5] == @crisp 18 ) " + "\n" +
				"then end",						
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		key = "test_evaluator";
		rule = "evaluator";
		testDRL = new String[] {
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
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		key = "test_filter_chains";
		rule = "rule";
		testDRL = new String[] {
				" rule test when " + "\n" +
				" Person( age > 18) | window:length( 10 ) | window:time(2h)" + "\n" +
				" then end ",
				
				" rule test when " + "\n" +
				" 	( " + "\n" +
				"		Person( age > 18)" + "\n" +
				"		Person( ) " + "\n" +
				"	) | window:length( 10 ) | window:time(2h)" + "\n" +
				" then end ",							
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
		
		
		
		key = "test_right_expression";
		rule = "rule";
		testDRL = new String[] {												
				" rule test when " + "\n" +
				" Person( age > 2*$height + $z * weight * comput($k) )" + "\n" +
				" then end ",
				
				" rule test when " + "\n" +
				" Person( |2*age()| == 3*height*method(weight + 2 *$k*sqrt(x)) )" + "\n" +
				" then end ",								
		};
		rules.put(key,rule);
		data.put(key,testDRL);
		
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
		check("test_compilation_unit");	 									
	}	
	@Test	
	public void test_package_statement() {							
		check("test_package_statement");										
	}	
	@Test	
	public void test_global() {					
		check("test_global");										
	}
	@Test	
	public void test_data_type() {		
		check("test_data_type");										
	}	
	@Test	
	public void test_import_statement() {						
		check("test_import_statement");										
	}
	@Test	
	public void test_function_import_statement() {						
		check("test_function_import_statement");										
	}		
	@Test	
	public void test_function() {						
		check("test_function");										
	}
	@Test	
	public void test_parameters() {
		check("test_parameters");		
	}	
	@Test	
	public void test_type_declaration() {
		check("test_type_declaration");										
	}		
	@Test	
	public void test_type_declare_attribute() {		
		check("test_type_declare_attribute");										
	}		
	@Test	
	public void test_decl_field() {					
		check("test_decl_field");										
	}
	@Test		
	public void test_rule() {
		check("test_rule");										
	}	
	@Test	
	public void test_rule_attributes() {			
		check("test_rule_attributes");										
	}	  
	@Test	
	public void test_operator_attributes() {
		check("test_operator_attributes");
	}
	@Test
	public void test_lhs_root() {
		check("test_lhs_root");									
	}	
	@Test
	public void test_lhs_implies() {		
		check("test_lhs_implies");								
	}	
	@Test
	public void test_lhs_or() {
		check("test_lhs_or");										
	}	
	@Test
	public void test_lhs_diff() {
		check("test_lhs_diff");
	}	
	@Test
	public void test_lhs_and() {
		check("test_lhs_and");										
	}		
	@Test
	public void test_lhs_root_complex() {
		check("test_lhs_root_complex");	
	}	
	@Test	
	public void test_lhs_modified_unary() {
		check("test_lhs_modified_unary");
	}
	@Test	
	public void test_lhs_exists() {			
		check("test_lhs_exists");								
	}	
	@Test	
	public void test_lhs_not() {
		check("test_lhs_not");										
	}	
	@Test	
	public void test_lhs_forall() {
		check("test_lhs_forall");										
	}			
	@Test	
	public void test_lhs_label_atom_pattern() {
		check("test_lhs_label_atom_pattern");										
	}
	@Test
	public void test_constraints() {
		check("test_constraints");										
	}
	@Test	
	public void test_positional_constraint() {
		check("test_positional_constraint");										
	}
	@Test	
	public void test_nested() {
		check("test_nested");										
	}
	@Test	
	public void test_literal_object() {
		check("test_literal_object");
	}		
	@Test	
	public void test_method_args() {
		check("test_method_args");										
	}
	@Test	
	public void test_decl_dl() {
		check("test_decl_dl");										
	}
	@Test	
	public void test_constr_implies() {
		check("test_constr_implies");								
	}
	@Test	
	public void test_constr_or() {
		check("test_constr_or");										
	}
	@Test	
	public void test_constr_diff() {
		check("test_constr_diff");										
	}	
	@Test	
	public void test_constr_and() {
		check("test_constr_and");										
	}
	@Test	
	public void test_constr_unary() {
		check("test_constr_unary");										
	}
	@Test	
	public void test_restr_implies() {
		check("test_restr_implies");										
	}
	@Test	
	public void test_restr_or() {		
		check("test_restr_or");									
	}
	@Test	
	public void test_restr_diff() {
		check("test_restr_diff");										
	}	
	@Test	
	public void test_restr_and() {
		check("test_restr_and");										
	}
	@Test	
	public void test_restriction_root() {
		check("test_restriction_root");										
	}	
	@Test	
	public void test_expression() {
		check("test_expression");										
	}	
	@Test	
	public void test_expression_in_rule() {
		check("test_expression_in_rule");										
	}
	@Test	
	public void test_var_literal() {
		check("test_var_literal");										
	}
	@Test	
	public void test_restriction_root_in_rule() {
		check("test_restriction_root_in_rule");										
	}
	@Test	
	public void test_left_expression() {
		check("test_left_expression");										
	}
	@Test	
	public void test_left_expression_in_rule() {
		check("test_left_expression_in_rule");										
	}
	@Test	
	public void test_accessor_path() {
		check("test_accessor_path");										
	}
	@Test	
	public void test_accessor() {
		check("test_accessor");										
	}		
	@Test	
	public void test_indexer() {
		check("test_indexer");									
	}
	@Test	
	public void test_right_expression() {
		check("test_right_expression");										
	}
	@Test	
	public void test_from() {
		check("test_from");										
	}
	@Test	
	public void test_from_rule() {
		check("test_from_rule");
	}	
	@Test	
	public void test_label() {
		check("test_label");	
	}
	@Test	
	public void test_inner_quantifier() {
		check("test_inner_quantifier");
	}		
	@Test	
	public void test_inner_quantifier_in_rule() {	
		check("test_inner_quantifier_in_rule");
	}
	@Test	
	public void test_evaluator() {
		check("test_evaluator");
	}
	@Test	
	public void test_filter_chains() {
		check("test_filter_chains");
	}
		
	
	
	
	
	
	
	/*
	@Test	
	public void test_ {
		String rule = "";
		String[] testDRL = {
				""
		};
				
		check(rule,testDRL);										
	}
	*/
	

	
	
	
	
	
	
	
	
	
	
	
	
	private void check(String key) {
		check(key,false);
	}
	
	private void check(String key, boolean visual) {
		ParsingResult[] res = parseAndTest(rules.get(key), data.get(key), visual);
			
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
			setUpBeforeClass();
				new Rule_Test().check("test_lhs_diff",true);
			tearDownAfterClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}








