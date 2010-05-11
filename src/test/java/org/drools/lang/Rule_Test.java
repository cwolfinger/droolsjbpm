package org.drools.lang;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.tree.CommonTree;
import org.drools.util.ParsingResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Rule_Test {

	
	private static FileWriter writer;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		String testDRL = "" +
				"package org.pack.subpack;\n" +
				"import org.klass;\n" +
				"\n" +
				"declare Klass\n" +
				"end\n" +
				"\n" +
				"rule \"ruel\"\n" +
				"when\n" +
				"then\n" +
				"end\n";				
		;
		
		check(rule,testDRL);										
	}
	
	

	@Test	
	public void test_package_statement() {
		String rule = "package_statement";
		String testDRL[] = {
				"package this.isa.pack ;",
				"package semi.colon.is.optional ",
				"package simplePack",
		};
					
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_global() {
		String rule = "global";
		String testDRL[] = {
				"global int N ",
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
		String testDRL[] = {
				"import jav.lang.String",
				"import Test ; ",
				"import jav.pack.*"
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_function_import_statement() {
		String rule = "function_import_statement";
		String testDRL = "import function org.pack.square";
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_function() {
		String rule = "function";
		String[] testDRL = {
				"function float square( float x ) { ... x*x ... }",
				"function process( int x, org.String zz ) { ... ... }"
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_parameters() {
		String rule = "parameters";
		String[] testDRL = {
				"( int a, org.klass.AnType obj, String[][] argz )"
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_type_declaration() {
		String rule = "type_declaration";
		String[] testDRL = {
				"declare Student" + "\n" +
				" @role(entity) " + "\n" +
				" @namespace(myNS=\"http:\\\\www.stix.com\\domain\\subd#\") " + "\n" +
				" @subclass(Person)" + "\n" +
				" age  : int " + "\n" +
				" name : String " + "\n" +
				" end \n",
				
				"declare HasFriend " + "\n" +
				"@role(property) " + "\n" +
				"@namespace(myNS=\"http:\\\\www.somens.com\\arg\\test#\") " + "\n" +	
				"@subproperty(Knows) " + "\n" +
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
				"end \n"
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_type_declare_attribute() {
		String rule = "type_declare_attribute";
		String[] testDRL = {
				"@role(event)",
				"@role(type)",
				"@role(entity)",
				"@role(property)",
				"@namespace( alias = \"http:\\\\www.org.dom\\arg# \")",
				"@subclass(Type)",
				"@subproperty(SomeProperty)",
				"@disjoint(AnotherType)",
				"@symmetric",
				"@transitive",
				"@inverse(ReverseProperty)"
				
		};		
			
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_decl_field() {
		String rule = "decl_field";
		String[] testDRL = {
				"field = (...) : datatype[][] @[key]"
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test		
	public void test_rule() {
		String rule = "rule";
		String[] testDRL = {
				"rule \"ruleName\" extends \"anotherRule\" " + "\n" +
				" salience 100 " + "\n" +
				" no-loop " + "\n" +
				" calendar \"s1\" , \"s2\" " + "\n" +
				"when" + "\n" +
				"then" + "\n" +
				"end" + "\n" 	
		};
		
		
		String test2;
				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_rule_attributes() {
		String rule = "rule_attribute";
		String[] testDRL = {
				"salience 100",
				"no-loop true",
				"agenda-group \"test-group\"",
				"activation-group \"act-group\"",
				"auto-focus false",
				"effective \"2010-04-12\"",
				"expires \"2010-04-12\"",
				"enabled true",
				"ruleflow-group \"act-group\"",
				"agenda-group \"act-group\"",
				"duration 100",
				"timer 100",
//TODO: fails as stand-alone, but works in context..				
//				"calendar \"s1\" , \"s2\" ",
				"dialect \"java\" ",
				"lock-on-active true",
				"defeats \"anotherRule\" ",
				"deductive",
				"abductive",
				"equivalence",
				"deduction @[crisp]",
				"implication @[crisp]"
		};
				
		check(rule,testDRL);										
	}
	  
	@Test	
	public void test_operator_attributes() {
		String rule = "operator_attributes";
		String[] testDRL = {				
				"@[" + "\n" +
				"kind=\"lukasiewicz\", " + "\n" +
				"id=\"myID\", " + "\n" +
				"params=\"addit,args,2,more\", " + "\n" +
				"degree=\"[0.3,0.2]\", " + "\n" +
				"crisp," + "\n" +
				"default," + "\n" +
				"defeat," + "\n" +
				"merge=\"mStrat\", " + "\n" +
				//"filter=\"fStrat\", " + "\n" +		//TODO: removed "filter" from here
				"missing=\"sStrat\" " + "\n" +
				"]",				
		};
				
		check(rule,testDRL);
				
	}

	
	@Test
	public void test_lhs_root() {
		String rule = "rule";
		String[] testDRL = {
				"rule test when " +
				"Bus() Car() Taxi()" +
				"then end"
		};
				
		check(rule,testDRL);										
	}
	
	@Test
	public void test_lhs_implies() {
		String rule = "rule";
		String[] testDRL = {
				"rule test when " +
				"$p : Person() implies @[kind=\"anImpl\"] Dog()" +
				"then end"
		};
				
		check(rule,testDRL);										
	}	
	
	
	@Test
	public void test_lhs_or() {
		String rule = "rule";
		String[] testDRL = {
				"rule test when " +
				"Car() or @[kind=\"anOr\"] Taxi() or @[kind=\"anotherOr\"] Bus()" +
				"then end"
		};
				
		check(rule,testDRL);										
	}	
	
	
	@Test
	public void test_lhs_diff() {
		String rule = "rule";
		String[] testDRL = {
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
		String[] testDRL = {
				"rule test when " +
				"Car() and Taxi() and Bus()" +
				"then end"
		};
				
		check(rule,testDRL);										
	}	
	
	@Test
	public void test_lhs_root_complex() {
		String rule = "rule";
		String[] testDRL = {
				"rule test when " +
				"(P() implies Q()) implies ( (K() equiv K()) or Z() and X() )" +
				"then end"
		};
				
		check(rule,testDRL);										
	}	
	
	
	@Test	
	public void test_lhs_modified_unary() {
		String rule = "rule";
		String[] testDRL = {
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
		String[] testDRL = {
				"rule \"r\" when " +
				"exists @[crisp] ( $p : Person() and $d : Dog() ) " +
				"then end",
				
				"rule \"r\" when " +
				" $p : exists Person() " +
				"then end",							
				
		};
				
		check(rule,testDRL);										
	}
	
	@Test	
	public void test_lhs_not() {
		String rule = "rule";
		String[] testDRL = {
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
		String[] testDRL = {
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
		String[] testDRL = {
				"rule \"r\" when " +
				"$p : Person() " +
				"then end",
				
				"rule \"r\" when " +
				"Person() @[crisp]" +
				"then end",
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_constraints() {
		String rule = "rule";
		String[] testDRL = {
				"rule \"r\" when " +
				"Person( \"john\" , 18, height > 150) " +
				"then end",
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_positional_constraint() {
		String rule = "rule";
		String[] testDRL = {
				"rule \"r\" when " +
				"Person( \"john\" , 18, 2.0, true, null, new Dog(), {12, $x, \"test\" }, $var) " +
				"then end",
		};
				
		check(rule,testDRL);										
	}
	
	
	
	@Test	
	public void test_literal_object() {
		String rule = "literal_object";
		String[] testDRL = {
				"new Thing(13, $var, true)"
		};
				
		check(rule,testDRL);										
	}
	
	
	@Test	
	public void test_method_args() {
		String rule = "literal_object";
		String[] testDRL = {
				"new Obj(12 - 13*($var*2 + sqrt(4)))"
		};
				
		check(rule,testDRL);										
	}
	
	
	public void test_meta_annotation() {
		String rule = "rule";
		String[] testDRL = {
				"xx"	
		};
				
		check(rule,testDRL);										
	}
	
	//TODO : test filter & tree struct
	
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
	

/*	  		  
	
		  
	    
	


	// method expr roots can't start with () and have a slightly simpler structure than outer expressions
	


	constr_implies
	  : left=constr_or (imp=imply_connective operator_attributes? right=constr_or)? 
	    -> {imp != null}? ^($imp operator_attributes? $left $right)    
	    -> ^($left)
	  ;
	  
	constr_or
	@init{
	  Token orToken = null;
	  ParserRuleReturnScope seq = null;
	}
	  : ld=constr_diff 
	            {seq=ld;}
	        ( lios=constr_or_sequitur[seq.getTree()]
	      {seq=lios;}
	  )*
	          -> {lios==null}? ^($ld)
	          -> ^($lios)
	  ;
	  
	constr_or_sequitur[Object leftChild]
	  : or=or_connective^ (atts=operator_attributes!)? rightChild=constr_diff!
	             {
	               Tree t = ((Tree) or.getTree());               
	               if (atts != null)
	                 t.addChild((Tree) atts.getTree());
	              
	             t.addChild((Tree) leftChild);
	       t.addChild((Tree) rightChild.getTree());           
	           } 
	  ;
	  
	  


	constr_diff
	  : constr_and (( xor_connective^ | eq_connective^ ) operator_attributes? constr_and)?
	  ;
	    
	  
	  
	  
	      
	constr_and
	@init{
	  Token orToken = null;
	  ParserRuleReturnScope seq = null;
	}
	  : ld=constr_unary
	            {seq=ld;}
	        ( lias=constr_and_sequitur[seq.getTree()]
	      {seq=lias;}
	  )*
	          -> {lias==null}? ^($ld)
	          -> ^($lias)
	  ;
	  
	constr_and_sequitur[Object leftChild]
	  : and=and_connective^ (atts=operator_attributes!)? rightChild=constr_unary!
	             {
	               Tree t = ((Tree) and.getTree());                
	               if (atts != null)
	                 t.addChild((Tree) atts.getTree());
	              
	             t.addChild((Tree) leftChild);
	       t.addChild((Tree) rightChild.getTree());           
	           } 
	  ;
	  
	  

	constr_unary
	  : unary_operator operator_attributes? constr_unary
	  | constr_atom
	  | LEFT_PAREN! constr_implies RIGHT_PAREN! 
	  ;
	  
	constr_atom
	  : left_expression restriction_root^? 
	  ;
	  

	  
	restriction_root
	  : restr_implies
	  ; 


	restr_implies
	  : left=restr_or (imp=imply_symbol operator_attributes? right=restr_or)? 
	    -> {imp != null}? ^($imp operator_attributes? $left $right)    
	    -> ^($left)
	  ;
	  
	restr_or
	@init{
	  Token orToken = null;
	  ParserRuleReturnScope seq = null;
	}
	  : ld=restr_diff 
	            {seq=ld;}
	        ( lios=restr_or_sequitur[seq.getTree()]
	      {seq=lios;}
	  )*
	          -> {lios==null}? ^($ld)
	          -> ^($lios)
	  ;
	  
	restr_or_sequitur[Object leftChild]
	  : or=or_symbol^ (atts=operator_attributes!)? rightChild=restr_diff!
	             {
	               Tree t = ((Tree) or.getTree());               
	               if (atts != null)
	                 t.addChild((Tree) atts.getTree());
	              
	             t.addChild((Tree) leftChild);
	       t.addChild((Tree) rightChild.getTree());           
	           } 
	  ;
	  
	  


	restr_diff
	  : restr_and (( xor_symbol^ | eq_symbol^ ) operator_attributes? restr_and)?
	  ;
	    
	  
	  
	  
	      
	restr_and
	@init{
	  Token orToken = null;
	  ParserRuleReturnScope seq = null;
	}
	  : ld=restr_unary
	            {seq=ld;}
	        ( lias=restr_and_sequitur[seq.getTree()]
	      {seq=lias;}
	  )*
	          -> {lias==null}? ^($ld)
	          -> ^($lias)
	  ; 
	  
	restr_and_sequitur[Object leftChild]
	  : and=and_symbol^ (atts=operator_attributes!)? rightChild=restr_unary!
	             {
	               Tree t = ((Tree) and.getTree());                
	               if (atts != null)
	                 t.addChild((Tree) atts.getTree());
	              
	             t.addChild((Tree) leftChild);
	       t.addChild((Tree) rightChild.getTree());           
	           } 
	  ;



	restr_unary
	  : unary_operator operator_attributes? restr_unary
	  | LEFT_PAREN! restr_implies RIGHT_PAREN!
	  | restr_atom
	  ;


	restr_atom
	  : qnt=inner_quantifier? eval=evaluator operator_attributes? right_expression
	    -> {qnt==null}? ^(evaluator operator_attributes? right_expression)
	    -> ^(inner_quantifier ^(evaluator operator_attributes? right_expression))
	  ;





	  
	left_expression
	  : label
	    ( 
	      left_expr_atom 
	      -> ^(VT_BINDING VAR ^(VT_FIELD left_expr_atom))
	      | LEFT_PAREN left_expr_root RIGHT_PAREN 
	      -> ^(VT_BINDING VAR ^(VT_EXPR left_expr_root))
	    )
	  | left_expr_root
	    -> ^(VT_EXPR left_expr_root)
	  ;

	left_expr_atom
	  : expr_atom
	  ;


	expr_atom
	  : accessor_path 
	  |   VAR
	  | literal
	  ; 
	   

	left_expr_root
	  : accessor_path  ( (PLUS | MINUS) factor )*
	  ;

	factor
	  : term ( (TIMES | SLASH) term )*  
	  ; 
	      
	term
	  : MINUS? expr_unary 
	  ; 
	  
	expr_unary
	  : expr_atom  
	  | LEFT_PAREN! expr_root RIGHT_PAREN!
	  ; 
	  
	expr_root
	  : factor  ( (PLUS | MINUS) factor )*
	  ; 




	accessor_path
	  :   accessor (DOT! accessor)*
	  | VAR (DOT! accessor)+
	  ;


	accessor 
	options{
	  backtrack = true;
	}
	  : ID indexer?
	  | method
	  | nested_obj_pattern
	  ;


	nested_obj_pattern
	  : GATE!  (ID (DOT! ID)*)?  LEFT_PAREN! constraints RIGHT_PAREN!
	  ;


	indexer
	  : LEFT_SQUARE! 
	    (
	        INT
	      | STRING
	      | ID LEFT_PAREN! method_args RIGHT_PAREN!
	      | GATE! lhs_label_atom_pattern      
	    )?
	    RIGHT_SQUARE!
	  ;



	right_expression
	  : expr_root
	  ;


	over_clause
	  : OVER^ over_elements (COMMA! over_elements)*
	  ;

	over_elements
	  : id1=WINDOW COLON 
	    (  id2=TIME paren_chunk
	      -> ^(VT_BEHAVIOR $id1 $id2 paren_chunk)
	    |  id2=LENGTH LEFT_PAREN INT RIGHT_PAREN
	      -> ^(VT_BEHAVIOR $id1 $id2 INT) 
	    ) 
	  ;

	from
	  : FROM^
	            (  accumulate_statement
	              | collect_statement 
	              | entrypoint_statement
	              | from_source
	            )
	  ;




	collect_statement
	  : COLLECT 
	    LEFT_PAREN 
	      lhs_label_atom_pattern 
	    RIGHT_PAREN 
	  -> ^(COLLECT lhs_label_atom_pattern)
	  ;

	entrypoint_statement
	  : ENTRYPOINT
	    entrypoint_id
	  -> ^(VT_ENTRYPOINT entrypoint_id)
	  ;

	entrypoint_id
	  :   value=ID 
	    -> VT_ENTRYPOINT_ID[$value]
	  |   value=STRING 
	    -> VT_ENTRYPOINT_ID[$value]
	  ;

	from_source
	  : ID 
	    //args=paren_chunk?
	    //expression_chain?
	    //-> ^(VT_FROM_SOURCE ID paren_chunk? expression_chain?)
	  ;

	//TODO
	  
	//expression_chain
	//  : DOT ID ( paren_chunk | square_chunk )? expression_chain?
	//    -> ^(VT_EXPRESSION_CHAIN[$DOT] ID square_chunk? paren_chunk? expression_chain?)
	//  ;
	//



	accumulate_statement
	  : ACCUMULATE  
	    LEFT_PAREN 
	      lhs_implies 
	    COMMA? 
	    ( accumulate_init_clause
	    | accumulate_id_clause
	    )
	    RIGHT_PAREN 
	    -> ^( ACCUMULATE lhs_implies accumulate_init_clause? accumulate_id_clause? )
	  ;

	accumulate_init_clause
	  : INIT
	    pc1=accumulate_paren_chunk cm1=COMMA? 
	    ACTION pc2=accumulate_paren_chunk cm2=COMMA? 
	  ( REVERSE pc3=accumulate_paren_chunk cm3=COMMA? )?
	    res1=RESULT pc4=accumulate_paren_chunk
	    -> ^(VT_ACCUMULATE_INIT_CLAUSE ^(INIT $pc1) ^(ACTION $pc2) ^(REVERSE $pc3)? ^(RESULT $pc4))
	  ;


	accumulate_paren_chunk
	@init{
	  String text = "";
	} : pc=accumulate_paren_chunk_data[false] {text = $pc.text;} 
	  -> VT_PAREN_CHUNK[$pc.start,text]
	  ;

	accumulate_paren_chunk_data[boolean isRecursive]
	  : lp1=LEFT_PAREN    
	    (any=~ ( LEFT_PAREN | RIGHT_PAREN ) | accumulate_paren_chunk_data[true] )* 
	    rp1=RIGHT_PAREN
	  ;

	accumulate_id_clause
	  : ID paren_chunk
	  -> ^(VT_ACCUMULATE_ID_CLAUSE ID paren_chunk)
	  ;


	query   //TODO
	  : QUERY ID 
	    parameters? 
	    lhs_root
	    END
	    -> ^(QUERY ID parameters? lhs_root)   
	  ;


	lhs_query
	  : QUESTION_MARK ID LEFT_PAREN positional_constraints? RIGHT_PAREN
	    -> ^(VT_QUERY_PATTERN ID positional_constraints?)
	  ;





	label
	  : VAR COLON
	  ;


	inner_quantifier
	  : ALL^
	  | SOME^
	  | VALUE^
	  | COUNT^ (AT! LEFT_SQUARE! 
	        (
	          INT
	          | (MAX^ EQUALS! INT)? (MIN^ EQUALS! INT)?
	        )
	       RIGHT_SQUARE!)?
	  ;
	  


	evaluator
	  : (TILDE!)?
	    (
	      simple_evaluator
	    | complex_evaluator
	    | custom_evaluator
	    // TODO : | temporal_evaluator
	    )
	  
	  ;

	simple_evaluator
	  : EQUAL^ 
	  | GREATER^ 
	  | GREATER_EQUAL^ 
	  | LESS^ 
	  | LESS_EQUAL^ 
	  | NOT_EQUAL^ 
	  ;   
	  
	complex_evaluator
	  : IN
	  | CONTAINS
	  ; 
	  
	custom_evaluator
	  : ID square_chunk?  //TODO: [] is for backward compat.
	  ;







	imply_connective
	  : IMPLIES
	    -> ^(VT_IMPLIES)
	  ;

	or_connective
	  : OR
	    -> ^(VT_OR)
	  ;
	      
	and_connective
	  : AND
	    -> ^(VT_AND)
	  ;     
	  
	xor_connective
	  : XOR
	    -> ^(VT_XOR)
	  ;
	  
	eq_connective
	  : EQUIV
	    -> ^(VT_EQUIV)
	  ;
	  
	  
	imply_symbol
	  : ARROW
	    -> ^(VT_IMPLIES)
	  ;

	or_symbol
	  : DOUBLE_PIPE
	    -> ^(VT_OR)
	  ;
	      
	and_symbol
	  : DOUBLE_AMPER
	    -> ^(VT_AND)
	  ;     
	  
	xor_symbol
	  : DOUBLE_CAP
	    -> ^(VT_XOR)
	  ;
	  
	eq_symbol
	  : DOUBLE_ANG
	    -> ^(VT_EQUIV)
	  ; 
	  

	unary_operator
	    : NEG
	      -> ^(VT_NEG)    
	    |   hedge^
	    ;
	  
	    
	hedge
	    :     VERY
	      -> ^(VT_HEDGE_VERY)
	      | MOL
	        -> ^(VT_HEDGE_VERY)
	  ;
	      



	 
	then_part  
	  :     
	      rhs_structured
	    | rhs_chunk   
	  ; 


	rhs_structured
	  : DO LEFT_CURLY!
	    rhs_atom*
	    RIGHT_CURLY!
	  ;

	rhs_atom
	  :   rhs_insert
	    | rhs_insert_logical
	    | rhs_retract
	    | rhs_retract_logical
	    | rhs_update
	    | rhs_modify
	    | rhs_side_effect
	  ; 
	  
	rhs_insert
	  : INSERT^ literal_object
	    SEMICOLON!
	  ;

	rhs_insert_logical
	  : INSERT_LOG^ literal_object
	    SEMICOLON!
	  ;
	  
	rhs_retract
	  : RETRACT^ 
	    ( literal_object
	    | VAR
	    )
	    SEMICOLON!
	  ;

	rhs_retract_logical
	  : RETRACT_LOG^
	    ( literal_object
	    | VAR
	    )
	    SEMICOLON!
	  ;

	rhs_update
	  : UPDATE^
	      VAR
	    SEMICOLON!  
	  ;

	rhs_modify
	  : MODIFY^ LEFT_PAREN! VAR RIGHT_PAREN! 
	    LEFT_CURLY!
	      accessor_path
	      (COMMA! accessor_path)*
	    RIGHT_CURLY!
	    SEMICOLON?
	  ;
	  
	rhs_side_effect
	@init{
	  String text = "";
	}
	  : (DOUBLE_LESS | LESS dialect=(JAVA | MVEL) LESS)
	    rc=side_effect_chunk {text = $rc.text;}
	    DOUBLE_GREATER
	    -> {dialect==null}? VT_RHS_CHUNK[$rc.start,text]
	    -> ^(VT_DIALECT[dialect] VT_RHS_CHUNK[$rc.start,text])
	  ;
	  
	side_effect_chunk
	  : ~ ( END | DOUBLE_GREATER )*   
	  ;






	rhs_chunk
	@init{
	  String text = "";
	} : THEN
	    rc=rhs_chunk_data {text = $rc.text;}
	    END 
	    SEMICOLON?        
	  -> VT_RHS_CHUNK[$rc.start,text]
	  ;

	rhs_chunk_data
	  :     
	      ~END*     
	  ;
	  
	  */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void check(String rule, String testDRL) {
		check(rule, new String[] {testDRL});		
	}
	
	private void check(String rule, String[] testDRL) {
		ParsingResult[] res = parseAndTest(rule, testDRL);
			
		for (int j = 0; j < res.length; j++) {
			log(rule, res[j].toString(true));
			assertTrue(res[j].isSuccess());
			System.out.println("Check " + rule + " >> " + res[j].getParseTime());
		}	
	}
	
	
	
	public ParsingResult[] parseAndTest(String rule, String[] drl) {
		ParsingResult[] ans = new ParsingResult[drl.length];
		int j = 0;
		
		Method ruleM;
		try {
			ruleM = DRLv6Parser.class.getMethod(rule);
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		}
				
				
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
					
							CommonTree resultTree = (CommonTree) root.getTree();
									
						int errors = parser.getNumberOfSyntaxErrors();
					
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
	
	
	
	
	
	
	
}








