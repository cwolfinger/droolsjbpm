grammar DRLv6Combined; 

    
options {  
  language = Java;
  output = AST;
  ASTLabelType=CommonTree;
  k=2; 
}
                  

  
tokens {


  VT_COMPILATION_UNIT;
  VT_PACKAGE_ID;
  VT_PACKAGE;
  VT_IMPORT_SECTION;
  VT_ONTOLOGY_SECTION;
  VT_DECLARATION_SECTION;
  VT_RULEBASE_SECTION;
  
  VT_GLOBAL_ID;
  VT_DATA_TYPE;
  VT_DIM_SIZE;
  
  VT_IMPORT;
  VT_FUNCTION_IMPORT;
  VT_STAR;  
  VT_FUNCTION;
  VT_FUNCTION_ID;
  VT_PARAM;
  VT_PARAM_LIST;
  VT_NAME;

  VT_TEMPLATE;
  VT_TEMPLATE_ID;
  VT_SLOT;
  VT_SLOT_ID;
  
  VT_TYPE_DECLARE;
  VT_TYPE_DECLARE_ID;
  VT_EXTENDS;
  VT_DL_DEFINITION;
  VT_DL_TYPE;
  VT_FIELD;
   
  VT_ENTITY_TYPE;
  
  VT_RULE_ID; 
  VT_ATTRIBUTES;
  VT_DIALECT;
  
  VT_LHS;
  VT_ARROW;
  
  VT_RHS;
  VT_THEN;
  VT_CLOSURE;
  
  VT_BRANCH;
  VT_BRANCH_DEFAULT;
  VT_BRANCH_LABEL;
  VT_NEG_BRANCH_LABEL;
  
  VT_RISING_EDGE;
  VT_FALLING_EDGE;
  
  VT_RHS_CHUNK;
  VT_CURLY_CHUNK;
  VT_SQUARE_CHUNK;
  VT_PAREN_CHUNK;
  
  VT_NEW_OBJ;
  VT_TYPE;
  VT_ARGS;
  VT_MSR;
  
  VT_AND_IMPLICIT;
  VT_IMPLIES; 
  VT_OR;
  VT_NEG;
  VT_XOR;
  VT_EQUIV;
  VT_AND;
  
  VT_HEDGE_VERY;
  VT_HEDGE_MOL;
  
  VT_EXISTS;
  VT_FORALL;
  VT_NEXISTS;
  VT_COUNT;
  VT_MIN;
  VT_MAX;
  VT_VALUE;
    
  VT_PATTERN;
  VT_NESTED_PATTERN;
  VT_ENABLED;
  VT_QUERY_PATTERN;  
  
  VT_POSITIONAL_VAR;
  VT_POSITIONAL_CONST;
  VT_POSITIONAL_INDEX;
  VT_POSITIONAL_SKIP;
  
  VT_BINDING;
  VT_ACCESSOR;
  VT_VERSION;
  VT_INDEXER;
  VT_INDEX_ALL;
  VT_METHOD;
  VT_EXPR;
  VT_DEBUG_LEFT_EXPR;
  VT_DEBUG_RIGHT_EXPR;
  VT_OTHERWISE;
  
  VT_FILTER;
  VT_SET;
  
  VT_SEQUENCE;
  VT_TRAIL;
  VT_TRAIL_NODE;
  
  VT_LIST;
  VT_RANGE;
  
  VT_BEHAVIOR;
  VT_ENTRYPOINT;
  VT_ENTRYPOINT_ID;
  VT_FROM_SOURCE;
  VT_EXPRESSION_CHAIN;
  
  VT_ACCUMULATE_LEFT;
  VT_ACCUMULATE_RIGHT;
  VT_ACCUMULATE_ITERATION;
  VT_ACCUMULATE_FUNCTION;
  VT_ACC_ITER_INIT;
  VT_ACC_ITER_ACT;
  VT_ACC_ITER_REV;
  VT_ACC_ITER_RES;
  
  VT_COLLECT_LIST;
  
  VT_IRI;
  
  /*
  VT_ONTOLOGY;  
  VT_PREFIX;
  VT_ANNOTATIONS;
  VT_ANNOTATION;
  VT_DL_DEFINITION;
  VT_FIELD;
  VT_KEYS;
  
  VT_DL_TYPE;    
  VT_DL_PROP;
  VT_DL_RESTRICTION;
  VT_DL_RESTRICTED_TYPE;
  
  VT_EQUIVALENTTO;
  VT_SUBCLASSOF;
  VT_DISJOINTWITH;
  VT_DISJOINTUNIONOF;
  VT_SUBPROPERTYOF; 
  VT_INVERSEOF;
  VT_SUBPROPERTYCHAIN;
  VT_DOMAIN;
  VT_RANGE; 
  
  VT_FACTS;
  VT_FACT;
  VT_TYPES;
  VT_SAMEAS;
  VT_DIFFERENTFROM;
  
  VT_EQV_CLASS;
  VT_DIF_CLASS;
  VT_EQV_PROP;
  VT_DIF_PROP;
  VT_EQV_INDV;
  VT_DIF_INDV;
  
  
  */
  
  
  
  
  
  
  VK_A_ACTGROUP;
  VK_A_AGENDAGROUP;
  VK_A_AUTOFOCUS;
  VK_A_CALENDAR;
  VK_A_DATE_EFFECTIVE;
  VK_A_DATE_EXPIRES;
  VK_A_DEDUCTION;
  VK_A_DIALECT;
  VK_A_DIRECTION_ABDUCTIVE;
  VK_A_DIRECTION_DEDUCTIVE;
  VK_A_DIRECTION_EQUIVALENCE;
  VK_A_DURATION;
  VK_A_ENABLED;
  VK_A_IMPLICATION;
  VK_A_LOCKONACTIVE;
  VK_A_NOLOOP;
  VK_A_RULEFLOWGROUP;
  VK_A_SALIENCE;
  VK_A_TIMER;
  VK_ACC;
  VK_ACCL;
  VK_ACCUMULATE;
  VK_ACCUMULATE_RIGHT;
  VK_ACTION;
  VK_ACTIVATION;
  VK_ACTIVE;
  VK_AGENDA;
  VK_ALL;
  VK_AND;
  VK_ANNOTATIONS;
  VK_ANOTHER;
  VK_AS;
  VK_ATTRIBUTES;
  VK_AUTO;
  VK_AVERAGE;
  VK_BOOL;
  VK_BOOLEAN;
  VK_BRANCH;
  VK_BYTE;
  VK_CALENDARS;
  VK_CHAR;
  VK_CHARACTERISTICS;
  VK_CLASS;
  VK_CLOSURE;
  VK_COLLECT;
  VK_COLLECT_LIST;
  VK_CONTAINS;
  VK_COUNT;
  VK_DATATYPE;
  VK_DATE;
  VK_DECLARE;
  VK_DEFEATS;
  VK_DIALECT;
  VK_DIFFERENT_INDIVIDUALS;
  VK_DIFFERENTFROM;
  VK_DISJOINT;
  VK_DISJOINT_CLASSES;
  VK_DISJOINT_PROPERTIES;
  VK_DISJOINT_UNION;
  VK_DISTINCT;
  VK_DO;
  VK_DOMAIN;
  VK_DOUBLE;
  VK_DURATION;
  VK_EFFECTIVE;
  VK_ENABLED;
  VK_END;
  VK_ENTITY;
  VK_ENTRY;
  VK_ENTRYPOINT;
  VK_EQUIV;
  VK_EQUIVALENT_CLASSES;
  VK_EQUIVALENT_PROPERTIES;
  VK_EQUIVALENTTO;
  VK_EVAL;
  VK_EVENT;
  VK_EXACTLY;
  VK_EXCLUDES;
  VK_EXISTS;
  VK_EXPIRES;
  VK_EXTEND;
  VK_EXTENDS;
  VK_FACTS;
  VK_FALLING;
  VK_FILTER;
  VK_FLOAT;
  VK_FOCUS;
  VK_FORALL;
  VK_FROM;
  VK_FUNCTION;
  VK_GLOBAL;
  VK_GROUP;
  VK_HASKEY;
  VK_IMPLIES;
  VK_IMPORT;
  VK_IN;
  VK_INDIVIDUAL;
  VK_INIT;
  VK_INSERT;
  VK_INSERT_LOG;
  VK_INSTANCEOF;
  VK_INT;
  VK_INVERSE;
  VK_INVERSEOF;
  VK_JAVA;
  VK_KEY;
  VK_LENGTH;
  VK_LENGTH_MAX;
  VK_LENGTH_MIN;
  VK_LIMIT;
  VK_LOCK;
  VK_LONG;
  VK_LOOP;
  VK_MATCHES;
  VK_MAX;
  VK_MDA_FUNCTIONAL;
  VK_MDA_FUNCTIONAL_INV;
  VK_MDA_REFLEXIVE;
  VK_MDA_REFLEXIVE_INV;
  VK_MDA_SYMMETRIC;
  VK_MDA_SYMMETRIC_INV;
  VK_MDA_TRANSITIVE;
  VK_MEMBEROF;
  VK_MIN;
  VK_MODIFY;
  VK_MODIFY_LOG;
  VK_MOL;
  VK_MVEL;
  VK_NAMESPACE;
  VK_NEG;
  VK_NEW;
  VK_NO;
  VK_NOT;
  VK_NULL;
  VK_OA_CRISP;
  VK_OA_DEFAULT;
  VK_OA_DEFEAT;
  VK_OA_DEGREE;
  VK_OA_ID;
  VK_OA_KIND;
  VK_OA_MERGE;
  VK_OA_MISSING;
  VK_OA_OTHERWISE;
  VK_OA_PARAMS;
  VK_ON;
  VK_ONCHANGE;
  VK_ONLY;
  VK_ONTOLOGY;
  VK_OR;
  VK_ORDERBY;
  VK_OTHERWISE;
  VK_OVER;
  VK_PACKAGE;
  VK_PATTERN;
  VK_PATTERN_LANG;
  VK_POINT;
  VK_PREFIX;
  VK_PROPERTY;
  VK_PROPERTY_ANNOTATION;
  VK_PROPERTY_DATA;
  VK_PROPERTY_OBJECT;
  VK_QUERY;
  VK_RANGE;
  VK_RESULT;
  VK_RETRACT;
  VK_RETRACT_LOG;
  VK_REVERSE;
  VK_RISING;
  VK_ROLE;
  VK_RULE;
  VK_RULEFLOW;
  VK_SALIENCE;
  VK_SAME_INDIVIDUAL;
  VK_SAMEAS;
  VK_SELF;
  VK_SEQ;
  VK_SHORT;
  VK_SOME;
  VK_SOUNDSLIKE;
  VK_START;
  VK_SUBCLASSOF;
  VK_SUBPROPERTYCHAIN;
  VK_SUBPROPERTYOF;
  VK_SUM;
  VK_SUPER;
  VK_TEMPLATE;
  VK_THAT;
  VK_THEN;
  VK_THIS;
  VK_THROTTLE;
  VK_TIME;
  VK_TIMER;
  VK_TYPE;
  VK_TYPE_BOOLEAN;
  VK_TYPE_DOUBLE;
  VK_TYPE_FLOAT;
  VK_TYPE_INTEGER;
  VK_TYPE_STRING;
  VK_TYPES;
  VK_UNIQUE;
  VK_UPDATE;
  VK_VALUE;
  VK_VERY;
  VK_VOID;
  VK_WHEN;
  VK_WINDOW;
  VK_XOR;
  VK_OPERATOR;
  VK_LOCK_ON_ACTIVE;
  VK_DATE_EFFECTIVE;
  VK_DATE_EXPIRES;
  VK_NO_LOOP;
  VK_AUTO_FOCUS;
  VK_ACTIVATION_GROUP;
  VK_AGENDA_GROUP;
  VK_RULEFLOW_GROUP;
  VK_ENTRY_POINT;
  VK_PRIMITIVE_TYPE;
   
}     
//import  General, Expression; 
//import DRLv6Keywords, Attributes, Manchester;

        

@lexer::header {
  package org.drools.lang;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;
  import org.drools.compiler.DroolsParserException;
}    

@parser::header {
  package org.drools.lang;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;
  import org.drools.compiler.DroolsParserException;
}
    
@members {

    private Tree curField;
    private Set prefixes = new HashSet();
    private ParserHelper helper = new ParserHelper( null,
                                                    tokenNames,
                                                    input,
                                                    state );
                                                      
    /**
     * The dummy parameter bellow is just to enable constructor overloading
     * so that we can initialise the parser helper on delegate grammars
     */
    public DRLv6CombinedParser(TokenStream input, boolean dummy ) {
        this(input);
//          gDRLv6Keywords.setParserHelper( helper );
//        gExpression.setParserHelper( helper );
//        gGeneral.setParserHelper( helper );          
//          gAttributes.setParserHelper( helper );
//          gManchester.setParserHelper( helper );
//          gManchester.setPrefixSet( prefixes );
    }  
   
    public ParserHelper getHelper()                           { return helper; }
    public boolean hasErrors()                                { return helper.hasErrors(); }
    public List<DroolsParserException> getErrors()            { return helper.getErrors(); }
    public List<String> getErrorMessages()                    { return helper.getErrorMessages(); }
    public void enableEditorInterface()                       {        helper.enableEditorInterface(); }
    public void disableEditorInterface()                      {        helper.disableEditorInterface(); }
    public LinkedList<DroolsSentence> getEditorInterface()    { return helper.getEditorInterface(); }
    public void reportError(RecognitionException ex)          {        helper.reportError( ex ); }


    
    

}
 


compilation_unit
  : package_statement?  
    import_section
    declaration_section
    ontology_section?
    rulebase_section?
    EOF
    -> ^(VT_COMPILATION_UNIT package_statement?
          ^(VT_IMPORT_SECTION import_section?) 
          ^(VT_DECLARATION_SECTION declaration_section?)
          ^(VT_ONTOLOGY_SECTION ontology_section?)
          ^(VT_RULEBASE_SECTION rulebase_section?)
        )        
  ;
  
  
  
   

package_statement 
  : package_key package_id SEMICOLON?
    -> ^(VT_PACKAGE package_id)
  ;
  
package_id
  : procedural_name
  ;




import_section
  : general_import_statement*
  ;


general_import_statement
options{
	k=3;
}
  : function_import_statement   
  | import_statement 
  ;
 
 
 
declaration_section
  : declaration_statement*
  ; 
 
declaration_statement
  : global  
  | function
  ;

ontology_section
  : //manDL_ontology 
  ontology_key
  ;

rulebase_section
  : rulebase_statement+
  ;

rulebase_statement
  : rule
  | query
  ;






global
  : global_key data_type global_id SEMICOLON?
    -> ^(global_key data_type global_id)
  ;

global_id
  : id=ID 
    -> VT_GLOBAL_ID[$id]
  ;


  
  



import_statement
  : import_key import_name SEMICOLON?
    -> ^(VT_IMPORT import_name)
  ;

function_import_statement
  : import_key function_key import_name SEMICOLON?
    -> ^(VT_FUNCTION_IMPORT import_name)
  ;

import_name 
  : procedural_name star=DOT_STAR?
    -> {star==null}? procedural_name 
    -> ^(VT_STAR procedural_name)
  ;




function
  : function_key data_type? function_id parameters curly_chunk
    -> ^(VT_FUNCTION data_type? function_id parameters curly_chunk)
  ;

function_id
  : id=ID
    -> VT_FUNCTION_ID[$id]
  ;


 


 
     
     

rule 
  : rule_key                {System.out.println("rule - check for rule key");} 
    rule_id parameters?     {System.out.println("rule - check for rule params");}
    (extends_key rule_id)?  {System.out.println("rule - check for rule ext");}  
    //rule_attributes?        {System.out.println("rule - check for rule atts");}
    rule_arrow?             {System.out.println("rule - check for rule arrow");}
    when_part               {System.out.println("rule - check for rule when");}
    then_part               {System.out.println("rule - check for rule then");}
    -> ^(rule_key rule_id 
              ^(VT_EXTENDS rule_id)?
              parameters? 
   //           rule_attributes? 
              rule_arrow?
              when_part? 
              then_part)
  ;
  


rule_id
  :   id=ID 
    -> VT_RULE_ID[$id]
  |   id=STRING
    -> VT_RULE_ID[$id]
  ;


rule_arrow
  : (
      (implication) => implication deduction?
      | (deduction) => deduction implication?
    )
     -> ^(VT_ARROW implication? deduction?)
  ;
 
deduction  
    :   ra_deduction_key^ operator_attributes
    ; 
  
  
implication
    :   ra_implication_key^ operator_attributes
    ;




 
 

when_part
  : (
    when_key
    lhs_root?
    )
    -> ^(VT_LHS lhs_root?)
  ;

lhs_root
  : lhs_implies more=lhs_implies*
  ->  {more==null}? lhs_implies
  ->  ^(VT_AND_IMPLICIT lhs_implies+)  
  ;

lhs_base
  :   LEFT_PAREN! lhs_root RIGHT_PAREN!
  | lhs_atom_pattern  
  ;


lhs_implies
  : left=lhs_or (imp=imply_connective operator_attributes? right=lhs_or)? 
    -> {imp != null}? ^($imp operator_attributes? $left $right)    
    -> ^($left)
  ;
  
  
lhs_or
  : (lhs_diff -> lhs_diff)
    ( 
      or_connective ops=operator_attributes? right=lhs_diff
      -> ^(or_connective $ops? $lhs_or $right)
    )* 
  ;
  

 
  


lhs_diff
  : lhs_and (( xor_connective^ | eq_connective^ ) operator_attributes? lhs_and)?
  ;
    
  
  
   
  
lhs_and 
  : (lhs_unary -> lhs_unary)
    ( 
      and_connective ops=operator_attributes? right=lhs_unary
      -> ^(and_connective $ops? $lhs_and $right)
    )* 
  ;

  
  
lhs_unary
options{
	k=*;
}	
  : lhs_modified_unary filter_chain^?
  |   lhs_query
  ;

lhs_modified_unary
options{
	k=*;
	backtrack=true;
}	
  : 
    unary_operator^  operator_attributes? lhs_modified_unary
  | LEFT_PAREN! lhs_root RIGHT_PAREN!    
  | lhs_quantifiexpr
  | lhs_edge
  | lhs_branch
  | lhs_sequence
  | lhs_label_atom_pattern 
  | relation_join_pattern
  ;  
  
   
     
//TODO
relation_join_pattern
  : empty_prefix_name^ another_modifier?
  ;
  
another_modifier
  : another_key
  ;  



lhs_quantifiexpr
  : lhs_exists
  | lhs_not
  | lhs_forall
  ;


lhs_exists  
  : lab=label? exists_key operator_attributes?
    lhs_base
  -> {lab==null}? ^(VT_EXISTS operator_attributes? lhs_base)
  -> ^(VT_BINDING label ^(VT_EXISTS operator_attributes? lhs_base)) 
  ;
  


lhs_forall  
  : forall_key operator_attributes?
  (
        pat=lhs_atom_pattern
    |   LEFT_PAREN lhs_unary lhs_unary RIGHT_PAREN   
  )
  -> {pat!=null}? ^(VT_FORALL operator_attributes? lhs_atom_pattern)
  -> ^(VT_FORALL operator_attributes? lhs_unary lhs_unary)
  ; 
  
lhs_not   
  : not_key operator_attributes? lhs_base
  -> ^(VT_NEXISTS operator_attributes? lhs_base)
  ; 


lhs_label_atom_pattern
  : lab=label? ( lhs_atom_pattern | ordered_obj_pattern )
    -> {lab==null}? lhs_atom_pattern? ordered_obj_pattern? 
    -> ^(VT_BINDING label lhs_atom_pattern ordered_obj_pattern?)  
  ;  


lhs_atom_pattern
  : procedural_name LEFT_PAREN constraints? RIGHT_PAREN 
      pattern_attributes? from?  
  -> ^(VT_PATTERN
          ^(VT_AND pattern_attributes? 
              VT_ENABLED ^(VT_TYPE procedural_name) constraints? 
          ) from?
      )       
  ;






lhs_edge
  : rising_key lhs_base
    -> ^(VT_RISING_EDGE lhs_base)
   | falling_key lhs_base     
    -> ^(VT_FALLING_EDGE lhs_base)
  ;


lhs_branch
  : branch_key  
      LEFT_PAREN  
        lhs_base?
        branch_alternative+
      RIGHT_PAREN  
      -> ^(VT_BRANCH ^(VT_BRANCH_DEFAULT lhs_base)? branch_alternative+ )
  ;
  
branch_alternative
  :  branch_label^ lhs_base    
  ;  
  
branch_label
  : LESS neg=NEG_MARK? ID GREATER
  -> {neg!=null}? ^(VT_NEG_BRANCH_LABEL ID)
  -> ^(VT_BRANCH_LABEL ID)
  ;  



filter_chain
  :   PIPE filter (PIPE filter)*
  -> ^(VT_FILTER filter+ )
  ;
  
filter
  :   over_filter
  |   unique_filter
  |   throttle_filter
  |   filter_key ID  
  ;
  
  
   
  
lhs_sequence
  : 
   seq_key LEFT_PAREN
      trail+
  RIGHT_PAREN   
  -> ^(VT_SEQUENCE trail+)
  ;

trail
  : trail_path 
  -> ^(VT_TRAIL trail_path)          
  ;  
  
trail_path
  : trail_node
    (lhs_root DOUBLE_GREATER! trail_node)+       
    SEMICOLON!    
  ;  

trail_node
  : ID trail_attributes?
  -> ^(VT_TRAIL_NODE ID trail_attributes?)
  ;
  
  


constraints
scope {
  int j;
} 
  :    
  general_constraint {$constraints::j++;} 
  (COMMA general_constraint {$constraints::j++;})*
  -> ^(VT_AND general_constraint+)       
  ;

positional_constraints
scope {
  int k;
}
  :    
  positional_constraint {$positional_constraints::k++;} 
  (COMMA positional_constraint {$positional_constraints::k++;})*
  -> ^(VT_AND positional_constraint+)
  ;
  
  
general_constraint
 	: (slotted_constraint) => slotted_constraint
 	| positional_constraint 
	;  
  
  
positional_constraint
@init{

  String idx;
  if ( constraints_stack.isEmpty()) {
    idx = ""+$positional_constraints::k;
  } else {
    idx = ""+$constraints::j;
  }  
 
}
  : 
  ( 
  right_expression 
  -> ^(VT_POSITIONAL_CONST VT_POSITIONAL_INDEX[$start,idx] ^(EQUAL right_expression))
 
  | QUESTION_MARK rest=restriction_root? 
    ->{rest==null}? ^(VT_POSITIONAL_SKIP VT_POSITIONAL_INDEX[$start,idx])
    -> ^(VT_POSITIONAL_CONST VT_POSITIONAL_INDEX[$start,idx] restriction_root)
  )     
  ;
                
slotted_constraint
options{
	backtrack=true;
}
  : 
  nested_accessor_path
  | 
  constr_implies    
  ; 





constr_implies
  : left=constr_or 
  	(imp=imply_symbol operator_attributes? right=constr_or)? 
    -> {imp != null}? ^($imp operator_attributes? $left $right)    
    -> ^($left)
  ;
  
  
  
constr_or
  : (constr_diff -> constr_diff)
    ( 
      or_symbol ops=operator_attributes? right=constr_diff
      -> ^(or_symbol $ops? $constr_or $right)
    )* 
  ;  


constr_diff
  : constr_and (( xor_symbol^ | eq_symbol^ ) operator_attributes? constr_and)?
  ;
    
  
  
  
constr_and
  : (constr_unary -> constr_unary)
    ( 
      and_symbol ops=operator_attributes? right=constr_unary
      -> ^(and_symbol $ops? $constr_and $right)
    )* 
  ; 
  


constr_unary
options{
	backtrack=true;
}	// required!
  : unary_operator^ operator_attributes? constr_unary
  | constr_atom
  | LEFT_PAREN! constr_implies RIGHT_PAREN! 
  ;

 
constr_atom
options{ 
	backtrack=true;
}
  : bound_constrained_expr
  | constrained_expr
  | bound_expr
  ;
  
bound_constrained_expr
	:  
  bound_expr restr=restriction_root     
      -> ^(VT_AND_IMPLICIT
            bound_expr
            $restr 
         )   
  ;
  
constrained_expr
	:  
  expr_root restr=restriction_root
     -> ^(VT_AND_IMPLICIT
            ^(VT_EXPR expr_root) 
            $restr 
         )   
  ;

bound_expr
options{
	backtrack=true;
}
	:	label general_accessor_path
	-> ^(VT_BINDING label ^(VT_EXPR general_accessor_path))
	| label LEFT_PAREN expr_root RIGHT_PAREN
		-> ^(VT_BINDING label ^(VT_EXPR expr_root))
	;
   
  
  

  
  
  /*
  left_expression
  : (VAR COLON) => label
    ( 
      expr_root 
      -> ^(VT_BINDING label ^(VT_DEBUG_LEFT_EXPR expr_root))
    )
  | expr_root 
    -> ^(VT_DEBUG_LEFT_EXPR expr_root)
  ;
  */

  
restriction_root
  : restr_implies
  ; 




restr_implies
  : left=restr_or 
  	(
  		(imply_symbol operator_attributes? restr_unary) =>
  		imp=imply_symbol operator_attributes? 
  		right=restr_or
  	
  	)? 
    -> {imp != null}? ^($imp operator_attributes? $left $right)    
    -> ^($left)
  ;
  
  
  

restr_or
  : (restr_diff -> restr_diff)
    ( 
     	(or_symbol operator_attributes? restr_diff) => 
      or_symbol ops=operator_attributes? right=restr_diff
      -> ^(or_symbol $ops? $restr_or $right)
    )* 
  ;   
 


restr_diff
  : restr_and 
  	(
  		(( xor_symbol^ | eq_symbol^ ) operator_attributes? restr_and) =>
  		( xor_symbol^ | eq_symbol^ ) operator_attributes? restr_and
  	)?
  ;
    
  
  
restr_and
  : (restr_unary -> restr_unary)
    ( 
	    (and_symbol operator_attributes? restr_unary) => 
      and_symbol ops=operator_attributes? right=restr_unary
      -> ^(and_symbol $ops? $restr_and $right)
    )* 
  ;  
    


restr_unary
  : unary_operator operator_attributes? restr_unary
  | LEFT_PAREN! restr_implies RIGHT_PAREN!
  | restr_atom
  ;


restr_atom
options{
	backtrack=true;
}
  : qnt=inner_quantifier? eval=evaluator operator_attributes? right_expression
    -> {qnt==null}? ^(evaluator operator_attributes? right_expression)
    -> ^(inner_quantifier ^(evaluator operator_attributes? right_expression))
  ;

   


right_expression
  : expr_root
  -> ^(VT_DEBUG_RIGHT_EXPR expr_root)
  | otherwise_key
  -> ^(VT_OTHERWISE)
  ;


  

nested_accessor_path
  : general_accessor_path^ DOT! nested_obj_pattern
  | nested_obj_pattern
  ;


general_accessor_path
options{
	backtrack=true;
}
  : accessor_path
  | var
  ;

accessor_path
  : accessor (DOT accessor)*
    -> ^(VT_ACCESSOR accessor+)
  | var (DOT accessor)+
    -> ^(VT_ACCESSOR var accessor+)
  ;




accessor
options{
	backtrack=true;
	k=*;
}
  :
  m=method ix=indexer?
    { 
        if (ix != null ) {
              Tree t = ix.tree;     
              Tree temp = t.getChild(0);                                        
              t.setChild(0,m.tree);
              t.addChild(temp);
        }  
    }
    -> {ix==null}? ^($m)
    -> ^($ix)
  | id=versioned_accessor ix=indexer?
    { 
        if (ix != null ) {
              Tree t = ix.tree;     
              Tree temp = t.getChild(0);                                        
              t.setChild(0,id.tree);
              t.addChild(temp);
        }  
    }  
    -> {ix==null}? ^($id)
    -> ^($ix)  
  ;


versioned_accessor
  : ID v=version?
  -> {v!=null}? ^(VT_VERSION ID version)
  -> ID
  ;

  
version
options{
	k=3;
}
  : DOUBLE_LESS! DECIMAL DOUBLE_GREATER!
  | DOUBLE_LESS! integer_range DOUBLE_GREATER!
  ;  
  
  

nested_obj_pattern
  : GATE fqn=procedural_name?  LEFT_PAREN constraints RIGHT_PAREN
    -> {fqn==null}? ^(VT_NESTED_PATTERN constraints ) 
    -> ^(VT_NESTED_PATTERN 
          ^(VT_AND ^(VT_TYPE procedural_name) constraints )
        )
  ;


indexer
  : LEFT_SQUARE
    (
        DECIMAL
        -> ^(VT_INDEXER DECIMAL)
      | STRING
        -> ^(VT_INDEXER STRING)
      | method
        -> ^(VT_INDEXER method)
      | GATE lhs_label_atom_pattern
        -> ^(VT_INDEXER lhs_label_atom_pattern)      
    )
    RIGHT_SQUARE
   
   | LEFT_SQUARE RIGHT_SQUARE
   -> ^(VT_INDEXER VT_INDEX_ALL) 
    
  ;









over_filter
  : id1=window_key DOUBLE_COLON 
    (  id2=time_key paren_chunk
      -> ^(VT_BEHAVIOR $id1 $id2 paren_chunk)
    |  id3=length_key LEFT_PAREN DECIMAL RIGHT_PAREN
      -> ^(VT_BEHAVIOR $id1 $id3 DECIMAL) 
    ) 
  ;
  
unique_filter
  : unique_key
    -> ^(VT_BEHAVIOR unique_key) 
  ;  
  
throttle_filter
  : throttle_key LEFT_PAREN DECIMAL RIGHT_PAREN
    -> ^(VT_BEHAVIOR throttle_key DECIMAL)
  ;  




from
  : from_key^
            (  accumulate_statement
              | collect_statement 
              | entrypoint_statement
              | from_source
            )
  ;




collect_statement
  : collect_key 
    LEFT_PAREN 
      lhs_label_atom_pattern 
    RIGHT_PAREN 
  -> ^(collect_key lhs_label_atom_pattern)
  ;

entrypoint_statement
  : entry_point_key
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
options{ 
	k=*; 
}
  : var
    | accessor_path 
    | LEFT_SQUARE! literal_list RIGHT_SQUARE!
    | LEFT_SQUARE! var_list RIGHT_SQUARE!
    | LEFT_SQUARE! integer_range RIGHT_SQUARE!    
  ;




accumulate_statement
  : acc_left
  | acc_right
  ;
  
  
acc_left
  : (accumulate_key | accL_key | acc_key ) accumulate_body
  -> ^(VT_ACCUMULATE_LEFT accumulate_body)
  ;

acc_right
  : accR_key accumulate_body
  -> ^(VT_ACCUMULATE_RIGHT accumulate_body)
  ;    

accumulate_body
  : LEFT_PAREN 
      lhs_root 
    ( COMMA
      ( 
      	l=label? accumulate_functions
      	| accumulate_iteration
      )
    )?     
    RIGHT_PAREN
    -> {l==null}? lhs_root accumulate_iteration? accumulate_functions?
    -> lhs_root ^(VT_BINDING label accumulate_functions?)
  ;

 
accumulate_functions
  : acc_collect_list
  |  acc_avg
  | acc_min
  | acc_max
  | acc_sum
  | acc_count
  | acc_distinct
  | acc_orderby
  | acc_limit
  		
	;
	

	
   
 
acc_collect_list
  : collectList_key 
      LEFT_PAREN
        ( (constr_implies) => constr_implies
        | expr_root )        
      RIGHT_PAREN
    -> ^(VT_COLLECT_LIST constr_implies? expr_root? )
  ;

acc_avg
  : avg_key LEFT_PAREN expr_root RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION avg_key ^(VT_EXPR expr_root))
  ;
  
acc_min
  : min_key LEFT_PAREN expr_root RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION min_key ^(VT_EXPR expr_root))
  ;

acc_max
  : max_key LEFT_PAREN expr_root RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION max_key ^(VT_EXPR expr_root))
  ;

acc_sum
  : sum_key LEFT_PAREN expr_root RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION sum_key ^(VT_EXPR expr_root))
  ;
  
acc_count
  : count_key LEFT_PAREN RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION count_key)
  ;
  
acc_distinct
  : distinct_key LEFT_PAREN gen_accessor_list RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION distinct_key gen_accessor_list)
  ;

acc_orderby
  : orderby_key LEFT_PAREN gen_accessor_list RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION orderby_key gen_accessor_list)
  ;
  
acc_limit
  : limit_key LEFT_PAREN DECIMAL RIGHT_PAREN
  -> ^(VT_ACCUMULATE_FUNCTION limit_key DECIMAL)
  ;



accumulate_iteration
  : init_key pc1=accumulate_paren_chunk COMMA?  
    action_key pc2=accumulate_paren_chunk COMMA?
    reverse_key pc3=accumulate_paren_chunk COMMA?
    result_key pc4=accumulate_paren_chunk COMMA?   
    -> ^(VT_ACCUMULATE_ITERATION ^(VT_ACC_ITER_INIT $pc1) ^(VT_ACC_ITER_ACT $pc2) ^(VT_ACC_ITER_REV $pc3)? ^(VT_ACC_ITER_RES $pc4))
  ;
  
  
accumulate_paren_chunk
@init{
  String text = "";
} 
  : pc=accumulate_paren_chunk_data[false] {text = $pc.text;} 
  -> VT_PAREN_CHUNK[$pc.start,text]
  ;

accumulate_paren_chunk_data[boolean isRecursive]
  : LEFT_PAREN
    (any=~ ( LEFT_PAREN | RIGHT_PAREN )   
    | accumulate_paren_chunk_data[true] )* 
    RIGHT_PAREN    
  ;






query   
  : query_key ID parameters? 
      query_body+
    end_key
    -> ^(query_key ID parameters? ^(VT_AND_IMPLICIT query_body+) )   
  ;

query_body
  : lhs_label_atom_pattern 
  | lhs_query 
  ;


lhs_query
  : QUESTION_MARK ID LEFT_PAREN 
        positional_constraints? 
    RIGHT_PAREN query_attributes? from?
    -> ^(VT_QUERY_PATTERN ID 
            query_attributes? 
            positional_constraints? 
            from?
       )
  ;









       
inner_quantifier
  : (only_key | all_key) -> VT_FORALL
  | some_key -> VT_EXISTS
  | value_key -> VT_VALUE
  | count_key (AT LEFT_SQUARE
        (
          val=DECIMAL
          | inner_attrs
        )
       RIGHT_SQUARE)
    -> {val!=null}? ^(VT_COUNT ^(VT_MIN $val) ^(VT_MAX $val))
    -> ^(VT_COUNT inner_attrs )   
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
  : in_key
  | contains_key
  ; 
  
custom_evaluator
  : ID 
  ;







imply_connective
  : implies_key
    -> ^(VT_IMPLIES)
  ;

or_connective
  : or_key
    -> ^(VT_OR)
  ;
      
and_connective
  : and_key
    -> ^(VT_AND)
  ;     
  
xor_connective
  : xor_key
    -> ^(VT_XOR)
  ;
  
eq_connective
  : equiv_key
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
  : DOUBLE_ANG
    -> ^(VT_XOR)
  ;
  
eq_symbol
  : DOUBLE_COLON
    -> ^(VT_EQUIV)
  ; 
  

unary_operator
    : neg_key
      -> ^(VT_NEG)    
    |   hedge^
    ;
  
    
hedge
    :     very_key
      -> ^(VT_HEDGE_VERY)
      | mol_key
        -> ^(VT_HEDGE_VERY)
  ;
      



 
 
then_part  
  :     
     (then_key) => rhs_then
  |  (do_key)   => rhs_do      
  ; 

 
rhs_then
  : then_key then? (closure_key closure)? end_key    
    -> ^(VT_RHS then? closure?)
  ;

rhs_do      
  : do_key LEFT_CURLY rhs_atom* RIGHT_CURLY
  -> ^(VT_RHS ^(VT_THEN rhs_atom+) )    
  ;
  
then
  : rhs_atom+
  -> ^(VT_THEN rhs_atom+)
  ;  

closure
  : rhs_atom+
  -> ^(VT_CLOSURE rhs_atom+)
  ;   
  

rhs_atom
  :   rhs_insert
    | rhs_insert_logical
    | rhs_retract
    | rhs_retract_logical
    | rhs_update
    | rhs_modify
    | rhs_modify_logical
    | rhs_side_effect
  ; 
  
rhs_insert
  : insert_key^ literal_object
    SEMICOLON!
  ;

rhs_insert_logical
  : insertLogical_key^ literal_object
    SEMICOLON!
  ;
  
rhs_retract
  : retract_key^ 
    ( literal_object
    | var
    )
    SEMICOLON!
  ;

rhs_retract_logical
  : retractLogical_key^
    ( literal_object
    | var
    )
    SEMICOLON!
  ;

rhs_update
  : update_key^
      var
    SEMICOLON!  
  ;

rhs_modify
  : modify_key^ LEFT_PAREN! var RIGHT_PAREN! 
    LEFT_CURLY!
      set_action+
    RIGHT_CURLY!
    SEMICOLON?
  ;
  
rhs_modify_logical
  : modifyLogical_key^ LEFT_PAREN! var RIGHT_PAREN! 
    LEFT_CURLY!
      set_action+
    RIGHT_CURLY!
    SEMICOLON?
  ;  
  
set_action
  : accessor_path EQUALS 
    right_expression 
  SEMICOLON   
  -> ^(VT_SET accessor_path 
          right_expression
      )
  ;  
  
  
rhs_side_effect
@init{
  String text = "";
}
  :     
    LESS_PERCENT rc=side_effect_chunk {text = $rc.text;} PERCENT_GREATER
    -> VT_RHS_CHUNK[$rc.start,text]
    | LESS dialect MOD
        rc=side_effect_chunk {text = $rc.text;}
      PERCENT_GREATER 
    -> ^(VT_DIALECT dialect VT_RHS_CHUNK[$rc.start,text])         
  ;
  
dialect
  : java_key 
  | mvel_key
  ;
  
side_effect_chunk
  : ~ ( PERCENT_GREATER )*   
  ;











/*
rhs_chunk
@init{
  String text = "";
} : then_key
    rc=rhs_chunk_data {text = $rc.text;}
    end_key
    SEMICOLON?        
  -> VT_RHS_CHUNK[$rc.start,text]
  ;

rhs_chunk_data
  :     
      ~'end'*     
  ;
*/  
  














curly_chunk
@init{
  String text = "";
} : cc=curly_chunk_data[false] {text = $cc.text;}
  -> VT_CURLY_CHUNK[$cc.start,text]
  ;

curly_chunk_data[boolean isRecursive]
  : lc1=LEFT_CURLY
      (any=~ ( LEFT_CURLY | RIGHT_CURLY ) | curly_chunk_data[true] )* 
    rc1=RIGHT_CURLY   
  ;

square_chunk
@init{
  String text = "";
} : sc=square_chunk_data[false] {text = $sc.text;}
  -> VT_SQUARE_CHUNK[$sc.start,text]
  ;

square_chunk_data[boolean isRecursive]
  : ls1=LEFT_SQUARE
      (any=~ ( LEFT_SQUARE | RIGHT_SQUARE ) | square_chunk_data[true] )* 
    rs1=RIGHT_SQUARE
  ;
 
 
paren_chunk
@init{
  String text = "";
} : cc=paren_chunk_data[false] {text = $cc.text;}
  -> VT_PAREN_CHUNK[$cc.start,text]
  ;

paren_chunk_data[boolean isRecursive]
  : lc1=LEFT_PAREN
      (any=~ ( LEFT_PAREN | RIGHT_PAREN ) | paren_chunk_data[true] )* 
    rc1=RIGHT_PAREN
  ;

 






























// --------------------------------------------------------
//                      GENERAL RULES
// --------------------------------------------------------

  

literal
    :   STRING m=msr_unit?
        -> {m==null}? STRING
        -> ^(VT_MSR STRING $m)
    |   DECIMAL m=msr_unit?
        -> {m==null}? DECIMAL
        -> ^(VT_MSR DECIMAL $m)   
    |   FLOAT m=msr_unit?
        -> {m==null}? FLOAT
        -> ^(VT_MSR FLOAT $m)
    |   HEX
    |   OCTAL
    |   BOOL 
    | null_key 
    | literal_object
    | list_literal 
    ;
      

typeList
  : data_type (COMMA data_type)*
  ;
  
//  //  helper.validateLT(2, "-")
//type
//options { backtrack=true; memoize=true; k=*; }
//  :   (primitiveType) => ( primitiveType (LEFT_SQUARE RIGHT_SQUARE)* )
//  | ( ID (typeArguments)? (DOT ID (typeArguments)? )* (LEFT_SQUARE RIGHT_SQUARE)* )
//  ;


typeArguments
  : LESS typeArgument (COMMA typeArgument)* GREATER
  ;
  
typeArgument
  : data_type
  | QUESTION_MARK ((extends_key | super_key) data_type)?
  ;

parameters
  : LEFT_PAREN {  helper.emit($LEFT_PAREN, DroolsEditorType.SYMBOL);  }
      ( param_definition (COMMA { helper.emit($COMMA, DroolsEditorType.SYMBOL); } param_definition)* )?
    RIGHT_PAREN { helper.emit($RIGHT_PAREN, DroolsEditorType.SYMBOL); }
    -> ^(VT_PARAM_LIST param_definition* )
  ;

param_definition
  : data_type argument
  -> ^(VT_PARAM data_type argument)
  ;

argument
  : ID {  helper.emit($ID, DroolsEditorType.IDENTIFIER);  }
    dimension_definition*
  ;

string_list
@init {
    StringBuilder buf = new StringBuilder();
}
  : first=STRING { buf.append( "[ "+ $first.text ); }
     (COMMA next=STRING { buf.append( ", " + $next.text ); } )* 
  -> STRING[$first,buf.toString()+" ]"]
  ;




primitiveType
    :   boolean_key
    | char_key
    | byte_key
    | short_key
    | int_key
    | long_key
    | float_key
    | double_key
    ;
  
data_type returns [int dim]
@init{  
 $dim=0;  
}
  : (procedural_name) (dimension_definition {$dim++;})*
    -> ^(VT_DATA_TYPE VT_DIM_SIZE[$start,""+$dim] procedural_name? )
  ;
dimension_definition
  : LEFT_SQUARE RIGHT_SQUARE 
  ;



  


iri 
  : (semantic_name) => semantic_name -> ^(VT_IRI semantic_name)
  | simple_name -> ^(VT_IRI simple_name)
  ;

  
nodeID
  : BLANK_ID
  ;  
  
full_iri
  : LESS!
      any_iri 
      //TODO : full iri syntax
    GREATER!    
  ;
  
  
any_iri
@init{
  String text = "";
} : cc=any_iri_content {text = $cc.text;}
  -> ^(VT_PAREN_CHUNK[$cc.start,text])  
  ;  
  
any_iri_content
  : (~ (GREATER | SLASH) | SLASH)*
  ; 


/********************************************* 
*         ATOMIC DATA DEFINITIONS 
************************************************/


  
procedural_name  
  : fully_qualified_name
  | simple_name
  ;  
  
semantic_name  
  : prefixed_name
  | empty_prefix_name
  | full_iri
  ;

 
/*
prefixed_name
  : {prefixes.contains(input.LT(1))}?=> pref=ID COLON nam=ID  
  -> ^(VT_IRI $pref? $nam)
  | COLON nam=ID
  -> ^(VT_IRI STRING["EMPTY_NS"] $nam)
  ;
*/

prefixed_name
  : pref=ID COLON nam=ID
  -> ^(VT_IRI $pref? $nam)
	;
	
empty_prefix_name 
	:		COLON nam=ID
  -> ^(VT_IRI $nam)
  ;

fully_qualified_name
/*
  : (ID DOT)+ primitiveType
    -> ^(VT_NAME ID* primitiveType)
    | ID ( DOT ID )+ 
    -> ^(VT_NAME ID+)   
  ;
  */
 	:	(ID DOT)+ 
 		(	(primitiveType) => primitiveType
 		  | ID
 		)
 	;
 		  
  
simple_name
  : primitiveType
  | ID
  ;   
    


gen_accessor_list
  : first=general_accessor_path (COMMA next=general_accessor_path)* 
  -> ^(VT_LIST general_accessor_path+)
  ;
 
literal_list
  : first=literal (COMMA next=literal)* 
  -> ^(VT_LIST literal+)
  ;  

var_list
  : first=VAR (COMMA next=VAR)* 
  -> ^(VT_LIST VAR+)
  ;
  
members_list
  : (literal|var_literal) (COMMA! (literal|var_literal))*
  ;  

integer_range
  : DECIMAL DOUBLE_DOT DECIMAL
  -> ^(VT_RANGE DECIMAL DECIMAL)
  ;

list_literal
  : LEFT_CURLY members_list? RIGHT_CURLY  
    ->^(VT_LIST members_list?)  
  ; 


    
var
    :   VAR
    ;    
    
    
var_literal
    :   VAR m=msr_unit?
        -> {m==null}? VAR
        -> ^(VT_MSR VAR $m)
    ;    
    
label
    :   var COLON!
    ;
    
msr_unit
    :   (GATE! (simple_name))+    
    |   (DOUBLE_CAP! (semantic_name))+
    ;
       
    



    
  
    
literal_object
  : new_object
    | ordered_object_literal
  ;    
  
new_object
  : (new_key) => new_key procedural_name LEFT_PAREN literal_object_args? RIGHT_PAREN
    -> ^(VT_NEW_OBJ ^(VT_TYPE procedural_name) ^(VT_ARGS literal_object_args)?)
  ;  
  
literal_object_args
  :  method_args
  ;
  
  
time_string
  : STRING m=msr_unit?
    -> {m==null}? STRING
    -> ^(VT_MSR STRING $m)
  ;  

/******************************************* QUICK OBJS **********************/


ordered_object_literal
  : DOUBLE_SQUARE_LEFT
      method_args
    DOUBLE_SQUARE_RIGHT
    -> ^(VT_NEW_OBJ ^(VT_ARGS method_args))
  ;

ordered_obj_pattern
  : DOUBLE_SQUARE_LEFT
      positional_constraints
    DOUBLE_SQUARE_RIGHT
    -> ^(VT_PATTERN ^(VT_AND ^(VT_AND positional_constraints)))   
  ;

method_args
  : method_arg (COMMA! method_arg)* 
  ; 


method_arg
  : expr_root
  ; 
  
method
  : core=method_core m=msr_unit?
    -> {m==null}? $core
    -> ^(VT_MSR $core $m)
  ;  
  
method_core
  : ID LEFT_PAREN args=method_args? RIGHT_PAREN
  -> {args==null}? ^(VT_METHOD ID )
  -> ^(VT_METHOD ID ^(VT_ARGS method_args?))
  ;









// --------------------------------------------------------
//                      EXPRESSIONS
// --------------------------------------------------------


  


/*
expr_root
  : additiveExpression
  ;
*/  
  

expr_root
  : factor  ( (PLUS | MINUS)^ factor )*
  ;

 

 
factor
  : term ( (TIMES | SLASH)^ term )*  
  ; 
      
term
  : (MINUS^)? expr_unary 
  ; 
       
expr_unary
  : expr_atom  
  | LEFT_PAREN! expr_root RIGHT_PAREN! 
  ;
  
  
expr_atom
  : var_literal
  | literal
  | accessor_path 
  ; 










/*

expression
  : conditionalExpression ((assignmentOperator) => assignmentOperator expression)?
  ;

conditionalExpression
        :       conditionalOrExpression ( QUESTION_MARK expression COLON expression )?
  ;
conditionalOrExpression
    :   conditionalAndExpression ( DOUBLE_PIPE conditionalAndExpression )*
  ;

conditionalAndExpression
    :   inclusiveOrExpression ( DOUBLE_AMPER inclusiveOrExpression )*
  ;

inclusiveOrExpression
    :   exclusiveOrExpression ( PIPE exclusiveOrExpression )*
  ;

exclusiveOrExpression
    :   andExpression ( XOR andExpression )*
  ;

andExpression
    :   equalityExpression ( AMPER equalityExpression )*
  ;

equalityExpression
    :   instanceOfExpression ( ( EQUALS | NOT_EQUAL ) instanceOfExpression )*
  ;

instanceOfExpression
    :   relationalExpression (instanceof_key data_type)?
  ;

relationalExpression
    :   shiftExpression ( relationalOp shiftExpression )*
  ;
  
relationalOp
  : (LESS_EQUAL| GREATER_EQUAL | LESS | GREATER)
  ;

shiftExpression
    :   additiveExpression ( shiftOp additiveExpression )*
  ;

shiftOp
  : (DOUBLE_LESS | TRIPLE_GREATER | DOUBLE_GREATER )
  ;

additiveExpression
    :   multiplicativeExpression ( (PLUS | MINUS) multiplicativeExpression )*
  ;

multiplicativeExpression
    :   unaryExpression ( ( TIMES | SLASH | MOD ) unaryExpression )*
  ;
  
unaryExpression
    :   PLUS unaryExpression
    | MINUS unaryExpression
    |   DOUBLE_PLUS primary
    |   DOUBLE_MINUS primary
    |   unaryExpressionNotPlusMinus
    ;

unaryExpressionNotPlusMinus
    :   TILDE unaryExpression
    |   QUESTION_MARK unaryExpression
    |   castExpression
    |   primary selector* (DOUBLE_PLUS|DOUBLE_MINUS)?
    ;
    
castExpression
    :  (LEFT_PAREN primitiveType) => LEFT_PAREN primitiveType RIGHT_PAREN unaryExpression
    |  (LEFT_PAREN data_type) => LEFT_PAREN data_type RIGHT_PAREN unaryExpressionNotPlusMinus
    |  LEFT_PAREN expression RIGHT_PAREN unaryExpressionNotPlusMinus
    ;
    


primary
    :  // accessor_path
    |   parExpression
    |   nonWildcardTypeArguments (explicitGenericInvocationSuffix | this_key arguments)
    |   literal
    |   var_literal
   |   this_key ({!helper.validateSpecialID(2)}?=> DOT ID)* ({helper.validateIdentifierSufix()}?=> identifierSuffix)?
   |   super_key superSuffix
  |   new_key creator
   |   primitiveType (LEFT_SQUARE RIGHT_SQUARE)* DOT class_key
   |   void_key DOT class_key
|   ID ({!helper.validateSpecialID(2)}?=> DOT ID)* ({helper.validateIdentifierSufix()}?=> identifierSuffix)?      
    ;   
  

parExpression
  : LEFT_PAREN expression RIGHT_PAREN
  ;
  
identifierSuffix
options { backtrack=true; memoize=true; }
    : (LEFT_SQUARE RIGHT_SQUARE)+ DOT class_key
    | ((LEFT_SQUARE) => LEFT_SQUARE expression RIGHT_SQUARE)+ // can also be matched by selector, but do here
    |   arguments 
    |   DOT class_key
    |   DOT explicitGenericInvocation
    |   DOT this_key
    |   DOT super_key arguments
    |   DOT new_key (nonWildcardTypeArguments)? innerCreator
  ;
  
creator
  : nonWildcardTypeArguments? createdName
        (arrayCreatorRest | classCreatorRest)
  ;

createdName
  : ID typeArguments?
        ( DOT ID typeArguments?)*
        | primitiveType
  ;
  
innerCreator
  : {!(helper.validateIdentifierKey(DroolsSoftKeywords.INSTANCEOF))}?=> ID classCreatorRest
  ;

arrayCreatorRest
  :   LEFT_SQUARE 
  (   RIGHT_SQUARE (LEFT_SQUARE RIGHT_SQUARE)* arrayInitializer
        |   expression RIGHT_SQUARE ({!helper.validateLT(2,"]")}?=>LEFT_SQUARE expression RIGHT_SQUARE)* ((LEFT_SQUARE RIGHT_SQUARE)=> LEFT_SQUARE RIGHT_SQUARE)*
        )
  ;

variableInitializer
options{ backtrack=true; memoize=true; }
  : arrayInitializer
      |   expression
  ;
  
arrayInitializer
  : LEFT_CURLY (variableInitializer (COMMA variableInitializer)* (COMMA)? )? RIGHT_CURLY
  ;

classCreatorRest
  : arguments
  ;
  
explicitGenericInvocation
  : nonWildcardTypeArguments arguments
  ;
  
nonWildcardTypeArguments
  : LESS typeList GREATER
  ;
  
explicitGenericInvocationSuffix
  : super_key superSuffix
  |     ID arguments
  ;

selector
options { backtrack=true; memoize=true; }
  :   DOT ID ((LEFT_PAREN) => arguments)?
  |   DOT this_key
  |   DOT super_key superSuffix
  |   DOT new_key (nonWildcardTypeArguments)? innerCreator
  |   LEFT_SQUARE expression RIGHT_SQUARE
  ;
  
superSuffix
  : arguments
  |     DOT ID ((LEFT_PAREN) => arguments)?
        ;

arguments
  : LEFT_PAREN expressionList? RIGHT_PAREN
  ;

expressionList
    :   expression (COMMA expression)*
    ;

assignmentOperator
options { k=1; }
  :   EQUAL
        |   PLUS_ASSIGN
        |   MINUS_ASSIGN
        |   MULT_ASSIGN
        |   DIV_ASSIGN
        |   AND_ASSIGN
        |   OR_ASSIGN
        |   XOR_ASSIGN
        |   MOD_ASSIGN
        |   DOUBLE_LESS EQUAL
        |   DOUBLE_GREATER EQUAL
        |   TRIPLE_GREATER EQUAL
  ;

*/



//******************************************************************
//                        MANCHESTER SYNTAX
//******************************************************************  

/*
manDL_ontology
options{
	k=5;
}
  :	
  	manDL_prefix*
    ontology_key COLON (nam=iri ver=iri?)?
    manDL_inport*
    ((AT? annotations_key) => manDL_annotations)?
    manDL_type_declaration*
    -> ^(VT_ONTOLOGY ^(VT_NAME $nam? $ver?) 
    		manDL_prefix* 
    		manDL_inport* 
    		manDL_annotations? 
    		manDL_type_declaration*
    		)    
  ; 


manDL_inport  // :)
  : import_key COLON iri   
  -> ^(VT_IMPORT iri)
  ;  


  
manDL_prefix
  : (prefix_key | namespace_key) COLON pref=ID COLON? full_iri 
    { prefixes.add($pref.text); }
  -> ^(VT_PREFIX ID full_iri)
  ; 



manDL_annotations
  : annotations_key COLON manDL_annotation_list
  ->  ^(VT_ANNOTATIONS manDL_annotation_list)  
  ;   
  
manDL_annotation_list
  : manDL_annotation (COMMA! manDL_annotation)* 
  ;  

manDL_annotation
  : manDL_annotations? manDL_annotationPropertyIRI manDL_annotation_target
  -> ^(VT_ANNOTATION manDL_annotations? manDL_annotationPropertyIRI manDL_annotation_target )
  ;
  
manDL_annotation_target  
  : manDL_individual | literal 
  ;  

 

manDL_type_declaration
options{
  backtrack=true;
}
  : manDL_datatype_def
  | manDL_class     
  | manDL_objectProperty
  | manDL_dataProperty
  | manDL_annotationProperty
  | manDL_namedIndividual  
      //| manDL_misc
  ;  








manDL_class
scope{
  CommonTree keys; 
} 
@init{
  ((manDL_class_scope) manDL_class_stack.peek()).keys = new CommonTree(new CommonToken(DRLv6CombinedLexer.VT_KEYS,"VT_KEYS"));
}
@after{
  retval.tree.addChild(((manDL_class_scope) manDL_class_stack.peek()).keys);
}
  :   	  	
  	
    ( (AT typ=classevent_key)? declare_key
    	| typ=classevent_key COLON )
      
      iri
      manDL_class_frame*
      manDL_decl_fields?         
    end_key?
  -> {typ!=null}? ^(VT_TYPE_DECLARE 
                      ^(VT_ENTITY_TYPE[$typ.text]) 
                      ^(VT_TYPE_DECLARE_ID iri)                                                               
                      manDL_class_frame* manDL_decl_fields?)                        
  -> ^(VT_TYPE_DECLARE 
          ^(VT_ENTITY_TYPE["Class"]) 
          ^(VT_TYPE_DECLARE_ID iri) 
          manDL_class_frame* 
          manDL_decl_fields?)
   
  ;

classevent_key
	:	class_key 
	| event_key
	;


manDL_decl_fields
  : manDL_decl_field more=manDL_decl_field*
  -> ^(VT_EQUIVALENTTO ^(VT_DL_DEFINITION ^(VT_AND manDL_decl_field+)))
  ;

                          
manDL_decl_field
  : manDL_field^ manDL_decl_field_attributes? COLON!    	 
  ;

manDL_field
  : (manDL_property_expression COLON) => manDL_property_expression COLON manDL_data_type_restriction
      -> ^(VT_COUNT manDL_property_expression ^(VT_MIN DECIMAL["1"]) ^(VT_MAX DECIMAL["1"]) manDL_data_type_restriction)
  | manDL_quantified_restriction_core  
      -> manDL_quantified_restriction_core  
  ;  

 
manDL_decl_field_attributes
  :
      AT LEFT_SQUARE
          manDL_decl_field_attribute (COMMA manDL_decl_field_attribute)*         
      RIGHT_SQUARE
      -> ^(VT_ATTRIBUTES manDL_decl_field_attribute+)   
      | ( AT manDL_decl_field_attribute )+
      -> ^(VT_ATTRIBUTES manDL_decl_field_attribute+)   
  ;

manDL_decl_field_attribute
  :
    key_key 
    {
      if ($manDL_class::keys != null)              
        $manDL_class::keys.addChild(curField);
    }    
  ;
  


  
  
  
  
  
  
manDL_class_frame
  : (annotations_key) => manDL_annotations
  | (disjointUnionOf_key) => manDL_disjointUnionOf
  | (disjointWith_key) => manDL_disjointWith
  | (as_key | equivalentTo_key) => manDL_equivalentTo
  | (subClassOf_key) => manDL_subClassOf
  | (hasKey_key) => manDL_hasKey ->     
  ;  
  
  
  
manDL_disjointUnionOf
  : disjointUnionOf_key COLON manDL_disjointUnionOf_list
    -> ^(VT_DISJOINTUNIONOF manDL_disjointUnionOf_list)
  ;

manDL_disjointUnionOf_list
  : manDL_annotated_description (COMMA! manDL_annotated_description)+ 
  ;  
  
manDL_disjointWith
  : disjointWith_key COLON manDL_annotated_description_list
  -> ^(VT_DISJOINTWITH manDL_annotated_description_list)
  ;

manDL_equivalentTo
  : ( as_key | equivalentTo_key COLON)  manDL_annotated_description_list
  -> ^(VT_EQUIVALENTTO manDL_annotated_description_list)  
  ;
  
manDL_subClassOf
  : subClassOf_key COLON manDL_annotated_description_list
  -> ^(VT_SUBCLASSOF manDL_annotated_description_list)
  ;  
  
manDL_hasKey
@after{
  ((manDL_class_scope) manDL_class_stack.peek()).keys.addChildren(retval.tree.getChildren());
}
  : hasKey_key^ COLON! manDL_annotations? manDL_property_expression (COMMA! manDL_property_expression)*

  ;  
  
  
  
 
 

manDL_annotated_description_list
  : manDL_annotated_description (COMMA! manDL_annotated_description)*
  ;


manDL_annotated_description
  : manDL_annotations? manDL_description
  -> ^(VT_DL_DEFINITION manDL_annotations? manDL_description)
  ;
  


manDL_description 
  : manDL_conjunction ( (or_key manDL_primary) => or=or_key manDL_conjunction)*
  -> {or==null}? manDL_conjunction
  -> ^(VT_OR manDL_conjunction+)
  ;
  
manDL_conjunction
  : (manDL_classIRI that_key) => manDL_classIRI that_key manDL_restriction (and_key manDL_restriction)*
  -> ^(VT_AND ^(VT_DL_TYPE manDL_classIRI) manDL_restriction+)     
  
  | manDL_primary ( (and_key manDL_primary) => and=and_key manDL_primary)*
  -> {and==null}? manDL_primary
  -> ^(VT_AND manDL_primary+)
  ;  


manDL_primary 
options{
	backtrack=true;
}
  : manDL_restriction 
  | manDL_atomic   
  ;
  
manDL_atomic
  : not=not_key? manDL_atomic_core
  -> {not!=null}? ^(VT_NEG manDL_atomic_core)
  -> manDL_atomic_core
  ;

manDL_atomic_core
  : LEFT_CURLY! literal_list RIGHT_CURLY!
  | manDL_data_type_restriction
  -> manDL_data_type_restriction
  | LEFT_PAREN! manDL_description RIGHT_PAREN!
  ;  

manDL_restriction
  : not=not_key? manDL_quantified_restriction_core
  -> {not!=null}? ^(VT_NEG manDL_quantified_restriction_core)
  -> manDL_quantified_restriction_core
  ;
 

manDL_quantified_restriction_core
  : p=manDL_property_expression {curField  = $p.tree;}  
    (   (some_key) => some_key manDL_primary
      -> ^(VT_EXISTS manDL_property_expression manDL_primary)
      | (only_key) => only_key  manDL_primary
      -> ^(VT_FORALL manDL_property_expression manDL_primary)
      | (all_key) => all_key  manDL_primary
      -> ^(VT_FORALL manDL_property_expression manDL_primary)
      | (value_key) => value_key (manDL_individual | literal)
      -> ^(VT_VALUE manDL_property_expression manDL_individual? literal?)
      | (self_key) => self_key
      -> ^(self_key manDL_property_expression)
      | (min_key) => min_key DECIMAL 
              ((and_key) => 
              | (or_key) =>
              | (manDL_primary) => manDL_primary)?
      -> ^(VT_COUNT manDL_property_expression ^(VT_MIN DECIMAL) manDL_primary?)
      | (max_key) => max_key DECIMAL 
              ((and_key) => 
              | (or_key) =>
              | (manDL_primary) => manDL_primary)?
      -> ^(VT_COUNT manDL_property_expression ^(VT_MAX DECIMAL) manDL_primary?)
      
      | (exactly_key) => exactly_key DECIMAL 
              ((and_key) => 
              | (or_key) =>
              | (manDL_primary) => manDL_primary)?
      -> ^(VT_COUNT manDL_property_expression ^(VT_MIN DECIMAL) ^(VT_MAX DECIMAL) manDL_primary?)
      
      
      | (manDL_data_type_restriction) => manDL_data_type_restriction
      -> ^(VT_COUNT manDL_property_expression ^(VT_MIN DECIMAL["1"]) ^(VT_MAX DECIMAL["1"]) manDL_data_type_restriction)       
   ) 
  ; 
  
manDL_data_type_restriction
  : manDL_data_type (LEFT_SQUARE fac=manDL_facets RIGHT_SQUARE)?	
  -> {fac!=null}? ^(VT_DL_RESTRICTED_TYPE manDL_data_type manDL_facets) 
  -> ^(VT_DL_TYPE manDL_data_type)
  ;
 

manDL_facets
  : manDL_facet manDL_restriction_value more=(COMMA manDL_facet manDL_restriction_value)*
  -> {more==null}? ^(VT_DL_RESTRICTION manDL_facet manDL_restriction_value*)
  -> ^(VT_AND ^(VT_DL_RESTRICTION manDL_facet manDL_restriction_value)+)
  ;  

manDL_restriction_value
  : literal
  ; 

manDL_facet
  : facet_length_key
  | facet_minLength_key
  | facet_maxLength_key
  | facet_pattern_key
  | facet_langPattern_key
  | GREATER_EQUAL
  | GREATER
  | LESS_EQUAL
  | LESS
  ;   
 
 
 
 
 
 





manDL_datatype_def
  : (AT typ=datatype_key declare_key
    | typ=datatype_key COLON )
      iri
      manDL_datatype_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_TYPE_DECLARE_ID iri) manDL_datatype_frame*)
  ;
 
manDL_datatype_frame
  : manDL_annotations
  | manDL_equivalentTo  
  ;  
  
  
  
 

manDL_objectProperty
  : ( AT typ=objectProperty_key declare_key
    | typ=objectProperty_key COLON)
      iri
      manDL_quick_attributes 
      manDL_objProp_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_TYPE_DECLARE_ID iri) manDL_quick_attributes? manDL_objProp_frame*)
  ;
  
manDL_objProp_frame
  : manDL_annotations
  | manDL_attributes
  | manDL_disjointWith
  | manDL_equivalentTo
  | manDL_inverseOf
  | manDL_domain  
  | manDL_range
  | manDL_subPropertyOf
  | manDL_subPropChain
  ;
  
  
    
manDL_dataProperty
  : 				
		(AT typ=dataProperty_key declare_key
    | typ=dataProperty_key COLON) 
      iri
      manDL_quick_attributes
      manDL_dataProp_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_TYPE_DECLARE_ID iri) manDL_quick_attributes? manDL_dataProp_frame*)
  ; 
  

manDL_dataProp_frame
  : manDL_annotations
  | manDL_domain  
  | manDL_range  
  | manDL_attributes    
  | manDL_disjointWith
  | manDL_equivalentTo
  | manDL_subPropertyOf   
  ;    


manDL_domain
  : domain_key COLON manDL_annotated_description_list
  -> ^(VT_DOMAIN manDL_annotated_description_list)
  ;
  
manDL_range
  : range_key COLON manDL_annotated_description_list  
  -> ^(VT_RANGE manDL_annotated_description_list)
  ;

     
 
 
 
manDL_subPropertyOf
  : subPropertyOf_key COLON manDL_property_list
  -> ^(VT_SUBPROPERTYOF manDL_property_list)
  ;  
  
manDL_inverseOf
  : inverseOf_key COLON manDL_property_list
  -> ^(VT_INVERSEOF manDL_property_list)
  ;  

manDL_subPropChain
  : subPropertyChain_key COLON manDL_annotations? manDL_property_expression ( CHAIN_SEP manDL_property_expression )*
  -> ^(VT_SUBPROPERTYCHAIN manDL_annotations? manDL_property_expression+)
  ;
     
 





  
manDL_annotationProperty
  : ( AT typ=annotationProperty_key declare_key
    | typ=annotationProperty_key COLON)
     iri
      manDL_annProp_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_TYPE_DECLARE_ID iri) manDL_annProp_frame*)
  ;  
  
  
manDL_annProp_frame
  : manDL_annotations
  | manDL_domain  
  | manDL_range
  | manDL_subPropertyOf
  ; 
  
  
  
  
  
  
  
manDL_namedIndividual
  : (AT typ=individual_key declare_key
    | typ=individual_key COLON)  
      iri
      manDL_indiv_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_NAME iri) manDL_indiv_frame*)
  ;  
  
manDL_indiv_frame 
  : manDL_annotations
  | manDL_types
  | manDL_facts
  | manDL_sameAs
  | manDL_differentFrom
  ;  
  
manDL_types
  : types_key COLON manDL_annotated_description_list
  -> ^(VT_TYPES manDL_annotated_description_list)
  ;

manDL_individual_list
  : manDL_annotated_individual (COMMA! manDL_annotated_individual)*
  ;
  
manDL_annotated_individual
  : ^(manDL_individual manDL_annotations?) 
  ;   
  
manDL_facts
  : facts_key COLON manDL_fact_annotated_list
  -> ^(VT_FACTS manDL_fact_annotated_list)
  ;
  
manDL_fact_annotated_list
  : manDL_annotated_fact (COMMA! manDL_annotated_fact)*
  ;

manDL_annotated_fact
  : ^(manDL_fact manDL_annotations?)   
  ;   

manDL_fact
  : neg=not_key? manDL_property_expression (manDL_individual | literal)
  -> {neg==null}? ^(VT_FACT manDL_property_expression manDL_individual? literal?)
  -> ^(VT_NEG ^(VT_FACT manDL_property_expression manDL_individual? literal?))
  ;    


  
manDL_sameAs
  : sameAs_key COLON manDL_individual_list
  -> ^(VT_SAMEAS manDL_individual_list)
  ;
  
manDL_differentFrom
  : differentFrom_key COLON manDL_individual_list
  -> ^(VT_DIFFERENTFROM manDL_individual_list)
  ;  

  

  
  
  
  
  




  
  



manDL_misc
  : (eq=equivalentClasses_key | df=disjointClasses_key) COLON
      manDL_annotations? manDL_description (COMMA manDL_description)+
      -> {eq!=null}? ^(VT_EQV_CLASS manDL_annotations? manDL_description+)
      -> ^(VT_DIF_CLASS manDL_annotations? manDL_description+)
      
  | (eq2=equivalentProperties_key | df2=disjointProperties_key) COLON
      manDL_annotations? manDL_property_expression (COMMA manDL_property_expression)+
      -> {eq2!=null}? ^(VT_EQV_PROP manDL_annotations? manDL_property_expression+)
      -> ^(VT_DIF_PROP manDL_annotations? manDL_property_expression+)
      
  | (eq3=sameIndividual_key | df3=differentIndividuals_key) COLON
      manDL_annotations? manDL_individual (COMMA manDL_individual)+
      -> {eq3!=null}? ^(VT_EQV_INDV manDL_annotations? manDL_individual+)
      -> ^(VT_DIF_INDV manDL_annotations? manDL_individual+)
  ;
   







  
  





  



  
  

          


  


  
  
  
  
 
  
  
 



manDL_attributes
  : characteristics_key COLON (manDL_annotations? manDL_attribute) (COMMA  manDL_annotations? manDL_attribute)*
  -> ^(VT_ATTRIBUTES ^(manDL_attribute manDL_annotations?)+)   
  ; 
 
 
manDL_quick_attributes
	: (AT manDL_att_functional) => AT! manDL_attribute manDL_quick_attributes^
	| (AT manDL_att_inverseFunctional) => AT! manDL_attribute manDL_quick_attributes^
	| (AT manDL_att_reflexive) => AT! manDL_attribute manDL_quick_attributes^
	| (AT manDL_att_irreflexive) => AT! manDL_attribute manDL_quick_attributes^
	| (AT manDL_att_symmetric) => AT! manDL_attribute manDL_quick_attributes^
	| (AT manDL_att_asymmetric) => AT! manDL_attribute manDL_quick_attributes^
	| (AT manDL_att_transitive) => AT! manDL_attribute manDL_quick_attributes^
	;
	 
manDL_attribute
  : 
   manDL_att_functional
  | manDL_att_inverseFunctional
  | manDL_att_reflexive
  | manDL_att_irreflexive
  | manDL_att_symmetric
  | manDL_att_asymmetric
  | manDL_att_transitive
  ;
  
  

manDL_att_functional
  : mda_functional_key
  ;
  
manDL_att_inverseFunctional
  : mda_inverseFunctional_key
  ;
  
manDL_att_reflexive
  : mda_reflexive_key
  ;
  
manDL_att_irreflexive
  : mda_irreflexive_key
  ;
  
manDL_att_symmetric
  : mda_symmetric_key
  ;
  
manDL_att_asymmetric
  : mda_asymmetric_key
  ;

manDL_att_transitive
  : mda_transitive_key
  ; 
 
 
 
 
 
 
 
 
 
 
 
  
  
manDL_property_list
  : manDL_annotatedProperty (COMMA! manDL_annotatedProperty)?
  ; 
  
manDL_annotatedProperty
  : manDL_annotations? manDL_property_expression
  ;
       
manDL_property_expression  
  : inv=inverse_key? manDL_propertyIRI
  -> ^(VT_DL_PROP manDL_propertyIRI $inv?)     
  ;  
  
  
  
manDL_classIRI 
  : iri
  ;

manDL_data_type returns [int dim]
@init{
 $dim=0;  
}
  : iri (dimension_definition {$dim++;})*
    -> ^(VT_DATA_TYPE VT_DIM_SIZE[$start,""+$dim] iri)
  ;
 
manDL_objectPropertyIRI 
  : iri
  ;
  
manDL_dataPropertyIRI 
  : iri
  ;
  
manDL_annotationPropertyIRI 
  : iri
  ;
  
manDL_propertyIRI
  : iri
  ;  
  
manDL_individual 
  : manDL_individualIRI 
  | nodeID
  ;
  
manDL_individualIRI 
  : iri  
  ;

 
 */

//****************************************************+
//              rule attributes
//******************************************************

/*
rule_attributes
  : AT {System.out.println("Look for rule attr");} 
  rule_attribute ( COMMA? AT rule_attribute)*
    -> ^(VT_ATTRIBUTES rule_attribute+)
  ;

rule_attribute
  : ra_salience   
  | ra_agenda_group  
  | ra_timer  
  | ra_activation_group 
  | ra_auto_focus 
  | ra_date_effective 
  | ra_date_expires 
  | ra_enabled 
  | ra_ruleflow_group 
  | ra_lock_on_active
  | ra_dialect 
  | ra_calendars
  | ra_defeats
  | ra_deductive
  | ra_abductive
  | ra_equivalence
  | ra_no_loop
  ;

ra_date_effective
  : ra_date_effective_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;

ra_date_expires
  : ra_date_expires_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;
  
ra_enabled
  : ra_enabled_key^ 
    LEFT_PAREN! BOOL RIGHT_PAREN!
  ; 

ra_salience
  : ra_salience_key^
    LEFT_PAREN! DECIMAL RIGHT_PAREN!
  ;
 
ra_no_loop
  : ra_no_loop_key^ LEFT_PAREN! BOOL RIGHT_PAREN!
  ;

ra_auto_focus
  : ra_auto_focus_key^ LEFT_PAREN! BOOL RIGHT_PAREN!
  ; 
  
ra_activation_group
  : ra_activation_group_key^ (LEFT_PAREN! STRING RIGHT_PAREN!)
  ;

ra_ruleflow_group
  : ra_ruleflow_group_key^ (LEFT_PAREN! STRING RIGHT_PAREN!)
  ;

ra_agenda_group
  : ra_agenda_group_key^ (LEFT_PAREN! STRING RIGHT_PAREN!)
  ;

ra_timer
  : (ra_duration_key^| ra_timer_key^) 
    LEFT_PAREN! DECIMAL RIGHT_PAREN!
  ; 
  
ra_calendars
  : ra_calendar_key^ LEFT_PAREN! literal_list RIGHT_PAREN!
  ;


ra_dialect
  : ra_dialect_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;     
  
ra_lock_on_active
  : ra_lock_on_active_key^ LEFT_PAREN! BOOL RIGHT_PAREN!
  ;
  
ra_deductive
  : ra_deductive_key
  ;
  
ra_abductive
  : ra_abductive_key
  ;
  
ra_equivalence
  : ra_equivalence_key
  ; 

ra_defeats
  : ra_defeats_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;


*/

//****************************************************+
//             operator attributes
//******************************************************






operator_attributes
    : (AT single_operator_attribute)+
      -> ^(VT_ATTRIBUTES single_operator_attribute+)
      | AT LEFT_SQUARE single_operator_attribute (COMMA single_operator_attribute)* RIGHT_SQUARE
      -> ^(VT_ATTRIBUTES single_operator_attribute+)
    ;
  

single_operator_attribute
  : oa_kind
  | oa_id
  | oa_params
  | oa_degree
  | oa_merge
  | oa_missing
  | oa_defeat
  | oa_default
  | oa_crisp
  | oa_otherwise
  ;

oa_kind
  :   oa_kind_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;
  
oa_id
  : oa_id_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;

oa_params
  : oa_params_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;

oa_degree
  : oa_degree_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;
  
oa_crisp
  : oa_crisp_key^
  ;   

oa_merge
  : oa_merge_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;   

oa_missing
  : oa_missing_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;
        
oa_defeat
  : oa_defeat_key^ 
  ; 

oa_default
  : oa_default_key^
  ;

oa_otherwise
  : oa_otherwise_key^ LEFT_PAREN! STRING RIGHT_PAREN!
  ;





//****************************************************+
//             pattern attributes
//******************************************************




pattern_attributes
  : (AT single_pattern_attribute)+
    -> ^(VT_ATTRIBUTES single_pattern_attribute+)
    | AT LEFT_SQUARE single_pattern_attribute (COMMA single_pattern_attribute)* RIGHT_SQUARE
    -> ^(VT_ATTRIBUTES single_pattern_attribute+)
  ;
    
single_pattern_attribute
  : single_operator_attribute
  | pa_onChange
  ;
  
pa_onChange
  : onChange_key^ LEFT_PAREN!
    (
      TIMES (COMMA! NEG_MARK! ID)*
      | ID (COMMA! ID)*
    )
    RIGHT_PAREN!
  ;     




//****************************************************+
//              query attributes
//******************************************************




query_attributes
    : (AT single_query_attribute)+
      -> ^(VT_ATTRIBUTES single_query_attribute+)
      | AT LEFT_SQUARE single_query_attribute (COMMA single_query_attribute)* RIGHT_SQUARE
      -> ^(VT_ATTRIBUTES single_query_attribute+)
    ;

single_query_attribute
  :
  ;
  
  
  
  
//****************************************************+
//              event sequence attributes
//******************************************************
  
  
  
  
trail_attributes
  :  (AT single_trail_attribute)+
      -> ^(VT_ATTRIBUTES single_trail_attribute+)
      | AT LEFT_SQUARE single_trail_attribute (COMMA single_trail_attribute)* RIGHT_SQUARE
      -> ^(VT_ATTRIBUTES single_trail_attribute+)
    ;

single_trail_attribute
  : ta_trail_start
  | ta_trail_end
  ;

ta_trail_start  
  : start_key
  ;

ta_trail_end
  : end_key
  ;  
  
  
  
  
  
//****************************************************+
//             inner quantifier attributes
//******************************************************
  
  
  
  
attr_min
  : (min_key EQUALS DECIMAL)
  -> ^(VT_MIN DECIMAL)
  ;

attr_max
  : (max_key EQUALS DECIMAL)
  -> ^(VT_MAX DECIMAL)
  ;
  
inner_attrs
  : attr_min (COMMA! attr_max)?
  | attr_max (COMMA! attr_min)?  
  ;  
  
  
  
  
  
  
  
// --------------------------------------------------------
//                      KEYWORDS
// --------------------------------------------------------
operator_key
  :      {(helper.isPluggableEvaluator(false))}? id=ID
         { helper.emit($id, DroolsEditorType.IDENTIFIER); }
         -> VK_OPERATOR[$id]
  ;

neg_operator_key
  :      {(helper.isPluggableEvaluator(true))}? id=ID 
         { helper.emit($id, DroolsEditorType.IDENTIFIER); } 
         -> VK_OPERATOR[$id]
  ;
 
ra_lock_on_active_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.LOCK) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.ON) && helper.validateLT(4, "-") && helper.validateLT(5, DroolsSoftKeywords.ACTIVE))}?  id1=ID mis1=MINUS id2=ID mis2=MINUS id3=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);
    helper.emit($mis2, DroolsEditorType.KEYWORD);
    helper.emit($id3, DroolsEditorType.KEYWORD);  }
    ->  VK_LOCK_ON_ACTIVE[$start, text]
  ;

ra_date_effective_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.DATE) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.EFFECTIVE))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_DATE_EFFECTIVE[$start, text]
  ;

ra_date_expires_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.DATE) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.EXPIRES))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_DATE_EXPIRES[$start, text]
  ;

ra_no_loop_key
@init{
  String text = "";
} : 
  {(helper.validateIdentifierKey(DroolsSoftKeywords.NO) 
    && helper.validateLT(2, "-") 
    && helper.validateLT(3, DroolsSoftKeywords.LOOP))}?
      
    id1=ID mis1=MINUS id2=ID {text = $text;}
    
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_AUTO_FOCUS[$start, text]
  ;



ra_auto_focus_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.AUTO) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.FOCUS))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_AUTO_FOCUS[$start, text]
  ;

ra_activation_group_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACTIVATION) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.GROUP))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_ACTIVATION_GROUP[$start, text]
  ;

ra_agenda_group_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.AGENDA) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.GROUP))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_AGENDA_GROUP[$start, text]
  ;

ra_ruleflow_group_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.RULEFLOW) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.GROUP))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_RULEFLOW_GROUP[$start, text]
  ;

entry_point_key
@init{
  String text = "";
} : {(helper.validateIdentifierKey(DroolsSoftKeywords.ENTRY) && helper.validateLT(2, "-") && helper.validateLT(3, DroolsSoftKeywords.POINT))}?  id1=ID mis1=MINUS id2=ID {text = $text;}
  { helper.emit($id1, DroolsEditorType.KEYWORD);
    helper.emit($mis1, DroolsEditorType.KEYWORD);
    helper.emit($id2, DroolsEditorType.KEYWORD);  }
    ->  VK_ENTRY_POINT[$start, text]
  ;

timer_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TIMER))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_TIMER[$id]
  ;



calendars_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.CALENDARS))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_CALENDARS[$id]
  ;

package_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PACKAGE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PACKAGE[$id]
  ;

import_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.IMPORT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_IMPORT[$id]
  ;


salience_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SALIENCE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_SALIENCE[$id]
  ;

enabled_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ENABLED))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_ENABLED[$id]
  ;

attributes_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ATTRIBUTES))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_ATTRIBUTES[$id]
  ;

rule_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RULE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_RULE[$id]
  ;

extend_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EXTEND))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_EXTEND[$id]
  ;

template_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TEMPLATE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_TEMPLATE[$id]
  ;

query_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.QUERY))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_QUERY[$id]
  ;

declare_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DECLARE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_DECLARE[$id]
  ;

function_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FUNCTION))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_FUNCTION[$id]
  ;




not_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.NOT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_NOT[$id]
  ;

in_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.IN))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_IN[$id]
  ;

or_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OR))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_OR[$id]
  ;

and_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.AND))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_AND[$id]
  ;

exists_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EXISTS))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_EXISTS[$id]
  ;

forall_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FORALL))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_FORALL[$id]
  ;

action_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACTION))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_ACTION[$id]
  ;

reverse_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.REVERSE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_REVERSE[$id]
  ;

result_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RESULT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_RESULT[$id]
  ;

end_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.END))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_END[$id]
  ;

//not_end_key
//  : {!(helper.validateIdentifierKey(DroolsSoftKeywords.END))}?  any=.
//  { helper.emit($any, DroolsEditorType.CODE_CHUNK); }
//  ;

init_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INIT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_INIT[$id]
  ;

instanceof_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INSTANCEOF))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_INSTANCEOF[$id]
  ;

extends_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EXTENDS))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_EXTENDS[$id]
  ;

super_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SUPER))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_SUPER[$id] 
  ;

boolean_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.BOOLEAN))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;

char_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.CHAR))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;

byte_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.BYTE))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;

short_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SHORT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;

int_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;

long_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LONG))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;

float_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FLOAT))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_PRIMITIVE_TYPE[$id] 
  ;



this_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.THIS))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_THIS[$id] 
  ;

void_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.VOID))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_VOID[$id] 
  ;

class_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.CLASS))}?  id=ID
  { helper.emit($id, DroolsEditorType.KEYWORD); }
    ->  VK_CLASS[$id] 
  ;


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
ra_calendar_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_CALENDAR))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_CALENDAR[$id]
  ; 

ra_effective_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DATE_EFFECTIVE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DATE_EFFECTIVE[$id]
  ; 

ra_expires_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DATE_EXPIRES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DATE_EXPIRES[$id]
  ; 

ra_deduction_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DEDUCTION))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DEDUCTION[$id]
  ; 

ra_dialect_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DIALECT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DIALECT[$id]
  ; 

ra_abductive_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DIRECTION_ABDUCTIVE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DIRECTION_ABDUCTIVE[$id]
  ; 

ra_deductive_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DIRECTION_DEDUCTIVE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DIRECTION_DEDUCTIVE[$id]
  ; 

ra_equivalence_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DIRECTION_EQUIVALENCE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DIRECTION_EQUIVALENCE[$id]
  ; 

ra_duration_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_DURATION))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_DURATION[$id]
  ; 

ra_enabled_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_ENABLED))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_ENABLED[$id]
  ; 

ra_implication_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_IMPLICATION))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_IMPLICATION[$id]
  ; 



ra_salience_key
  : {System.out.println("Called salience key");}   
    {(helper.validateIdentifierKey(DroolsSoftKeywords.A_SALIENCE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_SALIENCE[$id]
  ; 

ra_timer_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.A_TIMER))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_A_TIMER[$id]
  ; 

acc_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACC))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ACC[$id]
  ; 

accL_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACCL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ACCL[$id]
  ; 

accumulate_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACCUMULATE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ACCUMULATE[$id]
  ; 

accR_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACCUMULATE_RIGHT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ACCUMULATE_RIGHT[$id]
  ; 


activation_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACTIVATION))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ACTIVATION[$id]
  ; 

active_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ACTIVE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ACTIVE[$id]
  ; 

agenda_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.AGENDA))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_AGENDA[$id]
  ; 

all_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ALL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ALL[$id]
  ; 



annotations_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ANNOTATIONS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ANNOTATIONS[$id]
  ;
  

another_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ANOTHER))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ANOTHER[$id]
  ;
   

as_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.AS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_AS[$id]
  ; 





avg_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.AVERAGE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_AVERAGE[$id]
  ; 

true_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.BOOL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_BOOL[$id]
  ; 



branch_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.BRANCH))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_BRANCH[$id]
  ; 
 



characteristics_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.CHARACTERISTICS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_CHARACTERISTICS[$id]
  ; 

closure_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.CLOSURE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_CLOSURE[$id]
  ; 

collect_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.COLLECT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_COLLECT[$id]
  ; 

collectList_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.COLLECT_LIST))}?=>  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_COLLECT_LIST[$id]
  ; 

contains_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.CONTAINS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_CONTAINS[$id]
  ; 

count_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.COUNT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_COUNT[$id]
  ; 

datatype_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DATATYPE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DATATYPE[$id]
  ; 

date_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DATE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DATE[$id]
  ; 



ra_defeats_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DEFEATS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DEFEATS[$id]
  ; 


differentIndividuals_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DIFFERENT_INDIVIDUALS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DIFFERENT_INDIVIDUALS[$id]
  ; 

differentFrom_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DIFFERENTFROM))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DIFFERENTFROM[$id]
  ; 

disjointWith_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DISJOINT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DISJOINT[$id]
  ; 

disjointClasses_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DISJOINT_CLASSES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DISJOINT_CLASSES[$id]
  ; 

disjointProperties_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DISJOINT_PROPERTIES))}? id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DISJOINT_PROPERTIES[$id]
  ; 

disjointUnionOf_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DISJOINT_UNION))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DISJOINT_UNION[$id]
  ; 

distinct_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DISTINCT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DISTINCT[$id]
  ; 

do_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DO))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DO[$id]
  ; 

domain_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DOMAIN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DOMAIN[$id]
  ; 

double_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.DOUBLE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_DOUBLE[$id]
  ; 


 


entry_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ENTRY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ENTRY[$id]
  ; 



equiv_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EQUIV))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EQUIV[$id]
  ; 

equivalentClasses_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EQUIVALENT_CLASSES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EQUIVALENT_CLASSES[$id]
  ; 

equivalentProperties_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EQUIVALENT_PROPERTIES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EQUIVALENT_PROPERTIES[$id]
  ; 

equivalentTo_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EQUIVALENTTO))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EQUIVALENTTO[$id]
  ; 



event_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EVENT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EVENT[$id]
  ; 

exactly_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EXACTLY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EXACTLY[$id]
  ; 

excludes_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EXCLUDES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EXCLUDES[$id]
  ; 



expires_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.EXPIRES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_EXPIRES[$id]
  ; 





facts_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FACTS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_FACTS[$id]
  ; 

falling_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FALLING))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_FALLING[$id]
  ; 

filter_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FILTER))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_FILTER[$id]
  ; 







from_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.FROM))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_FROM[$id]
  ; 

global_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.GLOBAL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_GLOBAL[$id]
  ; 

group_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.GROUP))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_GROUP[$id]
  ; 

hasKey_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.HASKEY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_HASKEY[$id]
  ; 

implies_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.IMPLIES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_IMPLIES[$id]
  ; 




individual_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INDIVIDUAL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_INDIVIDUAL[$id]
  ; 



insert_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INSERT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_INSERT[$id]
  ; 

insertLogical_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INSERT_LOG))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_INSERT_LOG[$id]
  ; 



inverse_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INVERSE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_INVERSE[$id]
  ; 

inverseOf_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.INVERSEOF))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_INVERSEOF[$id]
  ; 

java_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.JAVA))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_JAVA[$id]
  ; 

key_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.KEY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_KEY[$id]
  ; 

facet_length_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LENGTH))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_LENGTH[$id]
  ; 

length_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LENGTH))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_LENGTH[$id]
  ; 


facet_maxLength_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LENGTH_MAX))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_LENGTH_MAX[$id]
  ; 

facet_minLength_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LENGTH_MIN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_LENGTH_MIN[$id]
  ; 

limit_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LIMIT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_LIMIT[$id]
  ; 

lock_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.LOCK))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_LOCK[$id]
  ; 


matches_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MATCHES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MATCHES[$id]
  ; 

max_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MAX))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MAX[$id]
  ; 

mda_functional_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_FUNCTIONAL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_FUNCTIONAL[$id]
  ; 

mda_inverseFunctional_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_FUNCTIONAL_INV))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_FUNCTIONAL_INV[$id]
  ; 

mda_reflexive_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_REFLEXIVE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_REFLEXIVE[$id]
  ; 

mda_irreflexive_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_REFLEXIVE_INV))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_REFLEXIVE_INV[$id]
  ; 

mda_symmetric_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_SYMMETRIC))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_SYMMETRIC[$id]
  ; 
 
mda_asymmetric_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_SYMMETRIC_INV))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_SYMMETRIC_INV[$id]
  ; 

mda_transitive_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MDA_TRANSITIVE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MDA_TRANSITIVE[$id]
  ; 

memberof_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MEMBEROF))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MEMBEROF[$id]
  ; 

min_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MIN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MIN[$id]
  ; 

modify_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MODIFY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MODIFY[$id]
  ; 

modifyLogical_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MODIFY_LOG))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MODIFY_LOG[$id]
  ; 

mol_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MOL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MOL[$id]
  ; 

mvel_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.MVEL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_MVEL[$id]
  ; 

namespace_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.NAMESPACE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_NAMESPACE[$id]
  ; 

neg_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.NEG))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_NEG[$id]
  ; 

new_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.NEW))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_NEW[$id]
  ; 



null_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.NULL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_NULL[$id]
  ; 

oa_crisp_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_CRISP))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_CRISP[$id]
  ; 

oa_default_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_DEFAULT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_DEFAULT[$id]
  ; 

oa_defeat_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_DEFEAT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_DEFEAT[$id]
  ; 

oa_degree_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_DEGREE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_DEGREE[$id]
  ; 

oa_id_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_ID))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_ID[$id]
  ; 

oa_kind_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_KIND))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_KIND[$id]
  ; 

oa_merge_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_MERGE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_MERGE[$id]
  ; 

oa_missing_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_MISSING))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_MISSING[$id]
  ; 

oa_otherwise_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_OTHERWISE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_OTHERWISE[$id]
  ; 

oa_params_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OA_PARAMS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OA_PARAMS[$id]
  ; 

on_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ON))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ON[$id]
  ; 

onChange_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ONCHANGE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ONCHANGE[$id]
  ; 

only_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ONLY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ONLY[$id]
  ; 

ontology_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ONTOLOGY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ONTOLOGY[$id]
  ; 

orderby_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ORDERBY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ORDERBY[$id]
  ; 

otherwise_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OTHERWISE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OTHERWISE[$id]
  ; 

over_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.OVER))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_OVER[$id]
  ; 

facet_pattern_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PATTERN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PATTERN[$id]
  ; 

facet_langPattern_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PATTERN_LANG))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PATTERN_LANG[$id]
  ; 

point_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.POINT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_POINT[$id]
  ; 

prefix_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PREFIX))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PREFIX[$id]
  ; 

property_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PROPERTY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PROPERTY[$id]
  ; 

annotationProperty_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PROPERTY_ANNOTATION))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PROPERTY_ANNOTATION[$id]
  ; 

dataProperty_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PROPERTY_DATA))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PROPERTY_DATA[$id]
  ; 

objectProperty_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.PROPERTY_OBJECT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_PROPERTY_OBJECT[$id]
  ; 



range_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RANGE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_RANGE[$id]
  ; 


retract_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RETRACT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_RETRACT[$id]
  ; 

retractLogical_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RETRACT_LOG))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_RETRACT_LOG[$id]
  ; 



rising_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RISING))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_RISING[$id]
  ; 

role_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.ROLE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_ROLE[$id]
  ; 



ruleflow_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.RULEFLOW))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_RULEFLOW[$id]
  ; 


sameIndividual_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SAME_INDIVIDUAL))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SAME_INDIVIDUAL[$id]
  ; 

sameAs_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SAMEAS))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SAMEAS[$id]
  ; 

self_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SELF))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SELF[$id]
  ; 

seq_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SEQ))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SEQ[$id]
  ; 

some_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SOME))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SOME[$id]
  ; 

soundslike_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SOUNDSLIKE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SOUNDSLIKE[$id]
  ; 

start_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.START))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_START[$id]
  ; 

subClassOf_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SUBCLASSOF))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SUBCLASSOF[$id]
  ; 

subPropertyChain_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SUBPROPERTYCHAIN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SUBPROPERTYCHAIN[$id]
  ; 

subPropertyOf_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SUBPROPERTYOF))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SUBPROPERTYOF[$id]
  ; 

sum_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.SUM))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_SUM[$id]
  ; 



that_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.THAT))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_THAT[$id]
  ; 

then_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.THEN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_THEN[$id]
  ; 



throttle_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.THROTTLE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_THROTTLE[$id]
  ; 

time_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TIME))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_TIME[$id]
  ; 



type_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TYPE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_TYPE[$id]
  ; 




integer_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TYPE_INTEGER))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_TYPE_INTEGER[$id]
  ; 

string_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TYPE_STRING))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_TYPE_STRING[$id]
  ; 

types_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.TYPES))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_TYPES[$id]
  ; 

unique_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.UNIQUE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_UNIQUE[$id]
  ; 

update_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.UPDATE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_UPDATE[$id]
  ; 

value_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.VALUE))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_VALUE[$id]
  ; 

very_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.VERY))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_VERY[$id]
  ; 



when_key
  :  
  {(helper.validateIdentifierKey(DroolsSoftKeywords.WHEN))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_WHEN[$id]
  ; 

window_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.WINDOW))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_WINDOW[$id]
  ; 

xor_key
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.XOR))}?  id=ID 
     { helper.emit($id, DroolsEditorType.KEYWORD);  } 
   ->  VK_XOR[$id]
  ; 
 
 
 
 
 
 
 
   
 
AMPER 
  : '&' 
  ;
  

AT  
  : '@'
  ;

ARROW
  : '->'
  ;

CHAIN_SEP
  : 'o'
  ;

COLON
  : ':'
  ;

COMMA 
  : ','
  ;

      
DOT : '.'
  ; 

DOT_STAR
  : '.*'
  ;

DOUBLE_AMPER
  : '&&'
  ;
  
DOUBLE_PLUS
  : '++'
  ;  


  
DOUBLE_ANG
  : '<>'  
  ;

DOUBLE_CAP
  : '^^'
  ; 

DOUBLE_COLON
  : '::'
  ;

DOUBLE_MINUS 
  : '--'
  ;

DOUBLE_DOT 
  : '..'
  ;

DOUBLE_GREATER
  : '>>'
  ;
  
DOUBLE_LESS
  : '<<'
  ; 
  
DOUBLE_PIPE
  : '||'
  ;
    
DOUBLE_SLASH
  : '//'
  ;
    
DOUBLE_SQUARE_LEFT
  : '[['
  ;

DOUBLE_SQUARE_RIGHT
  : ']]'
  ;

EQUAL
  : '=='
  ;

EQUALS
  : '='
  ;
  
GATE
  : '#'
  ; 

GREATER
  : '>'
  ;

GREATER_EQUAL
  : '>='
  ;   

LESS
  : '<'
  ;

LESS_PERCENT
  : '<%'
  ;  

LESS_EQUAL
  : '<='
  ;

MINUS
  : '-'
  ; 
  
MOD 
  : '%'
  ;

NEG_MARK
  : '!'
  ;

NOT_EQUAL
  : '!='
  ;
    
  
PERCENT_GREATER
  : '%>'
  ;  

PIPE
  : '|'
  ;

PLUS
  : '+'
  ;

QUESTION_MARK
  : '?'
  ;

SEMICOLON
  : ';'
  ;

SLASH
  : '/'
  ; 
  
TILDE 
  : '~'
  ;
  
TIMES
  : '*'
  ;
  
TRIPLE_GREATER
  : '>>>'
  ;  
  
XOR
  : '^'
  ; 
  
    

PLUS_ASSIGN
  : '+='
  ;
  
MINUS_ASSIGN
  : '-='
  ;
  
  
MULT_ASSIGN
  : '*='
  ;
  
DIV_ASSIGN
  : '/='
  ;
  
AND_ASSIGN
  : '&='
  ;
  
OR_ASSIGN
  : '|='
  ;
  
XOR_ASSIGN
  : '^='
  ;

MOD_ASSIGN
  : '%='
  ;



LEFT_PAREN
        : '('
        ;

RIGHT_PAREN
        : ')'
        ;
        
LEFT_SQUARE
        : '['
        ;

RIGHT_SQUARE
        : ']'
        ;        

LEFT_CURLY
        : '{'
        ;

RIGHT_CURLY
        : '}'
        ;
        






HEX   : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DECIMAL : MINUS? ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OCTAL   : '0' ('0'..'7')+ IntegerTypeSuffix? ;



FLOAT
    :   MINUS? ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   MINUS? '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   MINUS? ('0'..'9')+ Exponent FloatTypeSuffix?
    |   MINUS? ('0'..'9')+ FloatTypeSuffix
  ;


BOOL
    : 'true'
    |   'false'
    ;







STRING
      :   ('"' ( EscapeSequence | ~('\\'|'"') )+ '"')
      |   ('\'' ( EscapeSequence | ~('\\'|'\'') )+ '\'')
      ;



        
C_STYLE_SINGLE_LINE_COMMENT 
  : '/*' (~('\r'|'\n'))* EOL?
                { $channel=HIDDEN; }
    ;

MULTI_LINE_COMMENT
  : '/*' (options{greedy=false;} : .)* '*/'
                { $channel=HIDDEN; }
  ;

ID  
  : IdentifierStart IdentifierPart*
  | '`' IdentifierStart IdentifierPart* '`'
  { state.text = $text.substring(1, $text.length() - 1);  }
  ;
  
//TODO Deprecated  
//PREFIXED_ID 
//  : ':' IdentifierStart IdentifierPart*  
//  { state.text = $text.substring(1, $text.length() );  }
//  ;  
  
BLANK_ID
  : '_' IdentifierStart IdentifierPart*  
  { state.text = $text.substring(1, $text.length() );  }
  ; 
  
  
  
VAR 
  : '$' IdentifierPart+ 
  ;
  
  
  
   
  














MISC  :
    '\'' | '\\'  
  ;
 


WS      :       ( ' '
                | '\t'
                | '\f'
                | EOL
                )+
                { $channel=HIDDEN; }
        ;
  
fragment
EOL   :      
      (       ( '\r\n' )=> '\r\n'  // Evil DOS
                |       '\r'    // Macintosh
                |       '\n'    // Unix (the right way)
                )
        ;
        

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
EscapeSequence
    :   '\\' ('b'|'B'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\'|'.'|'o'|
              'x'|'a'|'e'|'c'|'d'|'D'|'s'|'S'|'w'|'W'|'p'|'A'|
              'G'|'Z'|'z'|'Q'|'E'|'*'|'['|']'|'('|')'|'$'|'^'|
              '{'|'}'|'?'|'+'|'-'|'&'|'|')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
IntegerTypeSuffix : ('l'|'L') ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;
  
  

  

    


fragment
IdentifierStart
    :   //'\u0024'
        '\u0041'..'\u005a'
//    |   '\u005f'
    |   '\u0061'..'\u007a'
    |   '\u00a2'..'\u00a5'
    |   '\u00aa'
    |   '\u00b5'
    |   '\u00ba'
    |   '\u00c0'..'\u00d6'
    |   '\u00d8'..'\u00f6'
    |   '\u00f8'..'\u0236'
    |   '\u0250'..'\u02c1'
    |   '\u02c6'..'\u02d1'
    |   '\u02e0'..'\u02e4'
    |   '\u02ee'
    |   '\u037a'
    |   '\u0386'
    |   '\u0388'..'\u038a'
    |   '\u038c'
    |   '\u038e'..'\u03a1'
    |   '\u03a3'..'\u03ce'
    |   '\u03d0'..'\u03f5'
    |   '\u03f7'..'\u03fb'
    |   '\u0400'..'\u0481'
    |   '\u048a'..'\u04ce'
    |   '\u04d0'..'\u04f5'
    |   '\u04f8'..'\u04f9'
    |   '\u0500'..'\u050f'
    |   '\u0531'..'\u0556'
    |   '\u0559'
    |   '\u0561'..'\u0587'
    |   '\u05d0'..'\u05ea'
    |   '\u05f0'..'\u05f2'
    |   '\u0621'..'\u063a'
    |   '\u0640'..'\u064a'
    |   '\u066e'..'\u066f'
    |   '\u0671'..'\u06d3'
    |   '\u06d5'
    |   '\u06e5'..'\u06e6'
    |   '\u06ee'..'\u06ef'
    |   '\u06fa'..'\u06fc'
    |   '\u06ff'
    |   '\u0710'
    |   '\u0712'..'\u072f'
    |   '\u074d'..'\u074f'
    |   '\u0780'..'\u07a5'
    |   '\u07b1'
    |   '\u0904'..'\u0939'
    |   '\u093d'
    |   '\u0950'
    |   '\u0958'..'\u0961'
    |   '\u0985'..'\u098c'
    |   '\u098f'..'\u0990'
    |   '\u0993'..'\u09a8'
    |   '\u09aa'..'\u09b0'
    |   '\u09b2'
    |   '\u09b6'..'\u09b9'
    |   '\u09bd'
    |   '\u09dc'..'\u09dd'
    |   '\u09df'..'\u09e1'
    |   '\u09f0'..'\u09f3'
    |   '\u0a05'..'\u0a0a'
    |   '\u0a0f'..'\u0a10'
    |   '\u0a13'..'\u0a28'
    |   '\u0a2a'..'\u0a30'
    |   '\u0a32'..'\u0a33'
    |   '\u0a35'..'\u0a36'
    |   '\u0a38'..'\u0a39'
    |   '\u0a59'..'\u0a5c'
    |   '\u0a5e'
    |   '\u0a72'..'\u0a74'
    |   '\u0a85'..'\u0a8d'
    |   '\u0a8f'..'\u0a91'
    |   '\u0a93'..'\u0aa8'
    |   '\u0aaa'..'\u0ab0'
    |   '\u0ab2'..'\u0ab3'
    |   '\u0ab5'..'\u0ab9'
    |   '\u0abd'
    |   '\u0ad0'
    |   '\u0ae0'..'\u0ae1'
    |   '\u0af1'
    |   '\u0b05'..'\u0b0c'
    |   '\u0b0f'..'\u0b10'
    |   '\u0b13'..'\u0b28'
    |   '\u0b2a'..'\u0b30'
    |   '\u0b32'..'\u0b33'
    |   '\u0b35'..'\u0b39'
    |   '\u0b3d'
    |   '\u0b5c'..'\u0b5d'
    |   '\u0b5f'..'\u0b61'
    |   '\u0b71'
    |   '\u0b83'
    |   '\u0b85'..'\u0b8a'
    |   '\u0b8e'..'\u0b90'
    |   '\u0b92'..'\u0b95'
    |   '\u0b99'..'\u0b9a'
    |   '\u0b9c'
    |   '\u0b9e'..'\u0b9f'
    |   '\u0ba3'..'\u0ba4'
    |   '\u0ba8'..'\u0baa'
    |   '\u0bae'..'\u0bb5'
    |   '\u0bb7'..'\u0bb9'
    |   '\u0bf9'
    |   '\u0c05'..'\u0c0c'
    |   '\u0c0e'..'\u0c10'
    |   '\u0c12'..'\u0c28'
    |   '\u0c2a'..'\u0c33'
    |   '\u0c35'..'\u0c39'
    |   '\u0c60'..'\u0c61'
    |   '\u0c85'..'\u0c8c'
    |   '\u0c8e'..'\u0c90'
    |   '\u0c92'..'\u0ca8'
    |   '\u0caa'..'\u0cb3'
    |   '\u0cb5'..'\u0cb9'
    |   '\u0cbd'
    |   '\u0cde'
    |   '\u0ce0'..'\u0ce1'
    |   '\u0d05'..'\u0d0c'
    |   '\u0d0e'..'\u0d10'
    |   '\u0d12'..'\u0d28'
    |   '\u0d2a'..'\u0d39'
    |   '\u0d60'..'\u0d61'
    |   '\u0d85'..'\u0d96'
    |   '\u0d9a'..'\u0db1'
    |   '\u0db3'..'\u0dbb'
    |   '\u0dbd'
    |   '\u0dc0'..'\u0dc6'
    |   '\u0e01'..'\u0e30'
    |   '\u0e32'..'\u0e33'
    |   '\u0e3f'..'\u0e46'
    |   '\u0e81'..'\u0e82'
    |   '\u0e84'
    |   '\u0e87'..'\u0e88'
    |   '\u0e8a'
    |   '\u0e8d'
    |   '\u0e94'..'\u0e97'
    |   '\u0e99'..'\u0e9f'
    |   '\u0ea1'..'\u0ea3'
    |   '\u0ea5'
    |   '\u0ea7'
    |   '\u0eaa'..'\u0eab'
    |   '\u0ead'..'\u0eb0'
    |   '\u0eb2'..'\u0eb3'
    |   '\u0ebd'
    |   '\u0ec0'..'\u0ec4'
    |   '\u0ec6'
    |   '\u0edc'..'\u0edd'
    |   '\u0f00'
    |   '\u0f40'..'\u0f47'
    |   '\u0f49'..'\u0f6a'
    |   '\u0f88'..'\u0f8b'
    |   '\u1000'..'\u1021'
    |   '\u1023'..'\u1027'
    |   '\u1029'..'\u102a'
    |   '\u1050'..'\u1055'
    |   '\u10a0'..'\u10c5'
    |   '\u10d0'..'\u10f8'
    |   '\u1100'..'\u1159'
    |   '\u115f'..'\u11a2'
    |   '\u11a8'..'\u11f9'
    |   '\u1200'..'\u1206'
    |   '\u1208'..'\u1246'
    |   '\u1248'
    |   '\u124a'..'\u124d'
    |   '\u1250'..'\u1256'
    |   '\u1258'
    |   '\u125a'..'\u125d'
    |   '\u1260'..'\u1286'
    |   '\u1288'
    |   '\u128a'..'\u128d'
    |   '\u1290'..'\u12ae'
    |   '\u12b0'
    |   '\u12b2'..'\u12b5'
    |   '\u12b8'..'\u12be'
    |   '\u12c0'
    |   '\u12c2'..'\u12c5'
    |   '\u12c8'..'\u12ce'
    |   '\u12d0'..'\u12d6'
    |   '\u12d8'..'\u12ee'
    |   '\u12f0'..'\u130e'
    |   '\u1310'
    |   '\u1312'..'\u1315'
    |   '\u1318'..'\u131e'
    |   '\u1320'..'\u1346'
    |   '\u1348'..'\u135a'
    |   '\u13a0'..'\u13f4'
    |   '\u1401'..'\u166c'
    |   '\u166f'..'\u1676'
    |   '\u1681'..'\u169a'
    |   '\u16a0'..'\u16ea'
    |   '\u16ee'..'\u16f0'
    |   '\u1700'..'\u170c'
    |   '\u170e'..'\u1711'
    |   '\u1720'..'\u1731'
    |   '\u1740'..'\u1751'
    |   '\u1760'..'\u176c'
    |   '\u176e'..'\u1770'
    |   '\u1780'..'\u17b3'
    |   '\u17d7' 
    |   '\u17db'..'\u17dc'
    |   '\u1820'..'\u1877'
    |   '\u1880'..'\u18a8'
    |   '\u1900'..'\u191c'
    |   '\u1950'..'\u196d'
    |   '\u1970'..'\u1974'
    |   '\u1d00'..'\u1d6b'
    |   '\u1e00'..'\u1e9b'
    |   '\u1ea0'..'\u1ef9'
    |   '\u1f00'..'\u1f15'
    |   '\u1f18'..'\u1f1d'
    |   '\u1f20'..'\u1f45'
    |   '\u1f48'..'\u1f4d'
    |   '\u1f50'..'\u1f57'
    |   '\u1f59'
    |   '\u1f5b'
    |   '\u1f5d'
    |   '\u1f5f'..'\u1f7d'
    |   '\u1f80'..'\u1fb4'
    |   '\u1fb6'..'\u1fbc'
    |   '\u1fbe'
    |   '\u1fc2'..'\u1fc4'
    |   '\u1fc6'..'\u1fcc'
    |   '\u1fd0'..'\u1fd3'
    |   '\u1fd6'..'\u1fdb'
    |   '\u1fe0'..'\u1fec'
    |   '\u1ff2'..'\u1ff4'
    |   '\u1ff6'..'\u1ffc'
    |   '\u203f'..'\u2040'
    |   '\u2054'
    |   '\u2071'
    |   '\u207f'
    |   '\u20a0'..'\u20b1'
    |   '\u2102'
    |   '\u2107'
    |   '\u210a'..'\u2113'
    |   '\u2115'
    |   '\u2119'..'\u211d'
    |   '\u2124'
    |   '\u2126'
    |   '\u2128'
    |   '\u212a'..'\u212d'
    |   '\u212f'..'\u2131'
    |   '\u2133'..'\u2139'
    |   '\u213d'..'\u213f'
    |   '\u2145'..'\u2149'
    |   '\u2160'..'\u2183'
    |   '\u3005'..'\u3007'
    |   '\u3021'..'\u3029'
    |   '\u3031'..'\u3035'
    |   '\u3038'..'\u303c'
    |   '\u3041'..'\u3096'
    |   '\u309d'..'\u309f'
    |   '\u30a1'..'\u30ff'
    |   '\u3105'..'\u312c'
    |   '\u3131'..'\u318e'
    |   '\u31a0'..'\u31b7'
    |   '\u31f0'..'\u31ff'
    |   '\u3400'..'\u4db5'
    |   '\u4e00'..'\u9fa5'
    |   '\ua000'..'\ua48c'
    |   '\uac00'..'\ud7a3'
    |   '\uf900'..'\ufa2d'
    |   '\ufa30'..'\ufa6a'
    |   '\ufb00'..'\ufb06'
    |   '\ufb13'..'\ufb17'
    |   '\ufb1d'
    |   '\ufb1f'..'\ufb28'
    |   '\ufb2a'..'\ufb36'
    |   '\ufb38'..'\ufb3c'
    |   '\ufb3e'
    |   '\ufb40'..'\ufb41'
    |   '\ufb43'..'\ufb44'
    |   '\ufb46'..'\ufbb1'
    |   '\ufbd3'..'\ufd3d'
    |   '\ufd50'..'\ufd8f'
    |   '\ufd92'..'\ufdc7'
    |   '\ufdf0'..'\ufdfc'
    |   '\ufe33'..'\ufe34'
    |   '\ufe4d'..'\ufe4f'
    |   '\ufe69'
    |   '\ufe70'..'\ufe74'
    |   '\ufe76'..'\ufefc'
    |   '\uff04'
    |   '\uff21'..'\uff3a'
    |   '\uff3f'
    |   '\uff41'..'\uff5a'
    |   '\uff65'..'\uffbe'
    |   '\uffc2'..'\uffc7'
    |   '\uffca'..'\uffcf'
    |   '\uffd2'..'\uffd7'
    |   '\uffda'..'\uffdc'
    |   '\uffe0'..'\uffe1'
    |   '\uffe5'..'\uffe6'
// UTF-16:    |   ('\ud800'..'\udbff') ('\udc00'..'\udfff') 
    ;                
                       
fragment 
IdentifierPart
    :   '\u0000'..'\u0008'
    |   '\u000e'..'\u001b'
    |   '\u0024'
    |   '\u0030'..'\u0039'
    |   '\u0041'..'\u005a'
    |   '\u005f'
    |   '\u0061'..'\u007a'
    |   '\u007f'..'\u009f'
    |   '\u00a2'..'\u00a5'
    |   '\u00aa'
    |   '\u00ad'
    |   '\u00b5'
    |   '\u00ba'
    |   '\u00c0'..'\u00d6'
    |   '\u00d8'..'\u00f6'
    |   '\u00f8'..'\u0236'
    |   '\u0250'..'\u02c1'
    |   '\u02c6'..'\u02d1'
    |   '\u02e0'..'\u02e4'
    |   '\u02ee'
    |   '\u0300'..'\u0357'
    |   '\u035d'..'\u036f'
    |   '\u037a'
    |   '\u0386'
    |   '\u0388'..'\u038a'
    |   '\u038c'
    |   '\u038e'..'\u03a1'
    |   '\u03a3'..'\u03ce'
    |   '\u03d0'..'\u03f5'
    |   '\u03f7'..'\u03fb'
    |   '\u0400'..'\u0481'
    |   '\u0483'..'\u0486'
    |   '\u048a'..'\u04ce'
    |   '\u04d0'..'\u04f5'
    |   '\u04f8'..'\u04f9'
    |   '\u0500'..'\u050f'
    |   '\u0531'..'\u0556'
    |   '\u0559'
    |   '\u0561'..'\u0587'
    |   '\u0591'..'\u05a1'
    |   '\u05a3'..'\u05b9'
    |   '\u05bb'..'\u05bd'
    |   '\u05bf'
    |   '\u05c1'..'\u05c2'
    |   '\u05c4'
    |   '\u05d0'..'\u05ea'
    |   '\u05f0'..'\u05f2'
    |   '\u0600'..'\u0603'
    |   '\u0610'..'\u0615'
    |   '\u0621'..'\u063a'
    |   '\u0640'..'\u0658'
    |   '\u0660'..'\u0669'
    |   '\u066e'..'\u06d3'
    |   '\u06d5'..'\u06dd'
    |   '\u06df'..'\u06e8'
    |   '\u06ea'..'\u06fc'
    |   '\u06ff'
    |   '\u070f'..'\u074a'
    |   '\u074d'..'\u074f'
    |   '\u0780'..'\u07b1'
    |   '\u0901'..'\u0939'
    |   '\u093c'..'\u094d'
    |   '\u0950'..'\u0954'
    |   '\u0958'..'\u0963'
    |   '\u0966'..'\u096f'
    |   '\u0981'..'\u0983'
    |   '\u0985'..'\u098c'
    |   '\u098f'..'\u0990'
    |   '\u0993'..'\u09a8'
    |   '\u09aa'..'\u09b0'
    |   '\u09b2'
    |   '\u09b6'..'\u09b9'
    |   '\u09bc'..'\u09c4'
    |   '\u09c7'..'\u09c8'
    |   '\u09cb'..'\u09cd'
    |   '\u09d7'
    |   '\u09dc'..'\u09dd'
    |   '\u09df'..'\u09e3'
    |   '\u09e6'..'\u09f3'
    |   '\u0a01'..'\u0a03'
    |   '\u0a05'..'\u0a0a'
    |   '\u0a0f'..'\u0a10'
    |   '\u0a13'..'\u0a28'
    |   '\u0a2a'..'\u0a30'
    |   '\u0a32'..'\u0a33'
    |   '\u0a35'..'\u0a36'
    |   '\u0a38'..'\u0a39'
    |   '\u0a3c'
    |   '\u0a3e'..'\u0a42'
    |   '\u0a47'..'\u0a48'
    |   '\u0a4b'..'\u0a4d'
    |   '\u0a59'..'\u0a5c'
    |   '\u0a5e'
    |   '\u0a66'..'\u0a74'
    |   '\u0a81'..'\u0a83'
    |   '\u0a85'..'\u0a8d'
    |   '\u0a8f'..'\u0a91'
    |   '\u0a93'..'\u0aa8'
    |   '\u0aaa'..'\u0ab0'
    |   '\u0ab2'..'\u0ab3'
    |   '\u0ab5'..'\u0ab9'
    |   '\u0abc'..'\u0ac5'
    |   '\u0ac7'..'\u0ac9'
    |   '\u0acb'..'\u0acd'
    |   '\u0ad0'
    |   '\u0ae0'..'\u0ae3'
    |   '\u0ae6'..'\u0aef'
    |   '\u0af1'
    |   '\u0b01'..'\u0b03'
    |   '\u0b05'..'\u0b0c'        
    |   '\u0b0f'..'\u0b10'
    |   '\u0b13'..'\u0b28'
    |   '\u0b2a'..'\u0b30'
    |   '\u0b32'..'\u0b33'
    |   '\u0b35'..'\u0b39'
    |   '\u0b3c'..'\u0b43'
    |   '\u0b47'..'\u0b48'
    |   '\u0b4b'..'\u0b4d'
    |   '\u0b56'..'\u0b57'
    |   '\u0b5c'..'\u0b5d'
    |   '\u0b5f'..'\u0b61'
    |   '\u0b66'..'\u0b6f'
    |   '\u0b71'
    |   '\u0b82'..'\u0b83'
    |   '\u0b85'..'\u0b8a'
    |   '\u0b8e'..'\u0b90'
    |   '\u0b92'..'\u0b95'
    |   '\u0b99'..'\u0b9a'
    |   '\u0b9c'
    |   '\u0b9e'..'\u0b9f'
    |   '\u0ba3'..'\u0ba4'
    |   '\u0ba8'..'\u0baa'
    |   '\u0bae'..'\u0bb5'
    |   '\u0bb7'..'\u0bb9'
    |   '\u0bbe'..'\u0bc2'
    |   '\u0bc6'..'\u0bc8'
    |   '\u0bca'..'\u0bcd'
    |   '\u0bd7'
    |   '\u0be7'..'\u0bef'
    |   '\u0bf9'
    |   '\u0c01'..'\u0c03'
    |   '\u0c05'..'\u0c0c'
    |   '\u0c0e'..'\u0c10'
    |   '\u0c12'..'\u0c28'
    |   '\u0c2a'..'\u0c33'
    |   '\u0c35'..'\u0c39'
    |   '\u0c3e'..'\u0c44'
    |   '\u0c46'..'\u0c48'
    |   '\u0c4a'..'\u0c4d'
    |   '\u0c55'..'\u0c56'
    |   '\u0c60'..'\u0c61'
    |   '\u0c66'..'\u0c6f'        
    |   '\u0c82'..'\u0c83'
    |   '\u0c85'..'\u0c8c'
    |   '\u0c8e'..'\u0c90'
    |   '\u0c92'..'\u0ca8'
    |   '\u0caa'..'\u0cb3'
    |   '\u0cb5'..'\u0cb9'
    |   '\u0cbc'..'\u0cc4'
    |   '\u0cc6'..'\u0cc8'
    |   '\u0cca'..'\u0ccd'
    |   '\u0cd5'..'\u0cd6'
    |   '\u0cde'
    |   '\u0ce0'..'\u0ce1'
    |   '\u0ce6'..'\u0cef'
    |   '\u0d02'..'\u0d03'
    |   '\u0d05'..'\u0d0c'
    |   '\u0d0e'..'\u0d10'
    |   '\u0d12'..'\u0d28'
    |   '\u0d2a'..'\u0d39'
    |   '\u0d3e'..'\u0d43'
    |   '\u0d46'..'\u0d48'
    |   '\u0d4a'..'\u0d4d'
    |   '\u0d57'
    |   '\u0d60'..'\u0d61'
    |   '\u0d66'..'\u0d6f'
    |   '\u0d82'..'\u0d83'
    |   '\u0d85'..'\u0d96'
    |   '\u0d9a'..'\u0db1'
    |   '\u0db3'..'\u0dbb'
    |   '\u0dbd'
    |   '\u0dc0'..'\u0dc6'
    |   '\u0dca'
    |   '\u0dcf'..'\u0dd4'
    |   '\u0dd6'
    |   '\u0dd8'..'\u0ddf'
    |   '\u0df2'..'\u0df3'
    |   '\u0e01'..'\u0e3a'
    |   '\u0e3f'..'\u0e4e'
    |   '\u0e50'..'\u0e59'
    |   '\u0e81'..'\u0e82'
    |   '\u0e84'
    |   '\u0e87'..'\u0e88'        
    |   '\u0e8a'
    |   '\u0e8d'
    |   '\u0e94'..'\u0e97'
    |   '\u0e99'..'\u0e9f'
    |   '\u0ea1'..'\u0ea3'
    |   '\u0ea5'
    |   '\u0ea7'
    |   '\u0eaa'..'\u0eab'
    |   '\u0ead'..'\u0eb9'
    |   '\u0ebb'..'\u0ebd'
    |   '\u0ec0'..'\u0ec4'
    |   '\u0ec6'
    |   '\u0ec8'..'\u0ecd'
    |   '\u0ed0'..'\u0ed9'
    |   '\u0edc'..'\u0edd'
    |   '\u0f00'
    |   '\u0f18'..'\u0f19'
    |   '\u0f20'..'\u0f29'
    |   '\u0f35'
    |   '\u0f37'
    |   '\u0f39'
    |   '\u0f3e'..'\u0f47'
    |   '\u0f49'..'\u0f6a'
    |   '\u0f71'..'\u0f84'
    |   '\u0f86'..'\u0f8b'
    |   '\u0f90'..'\u0f97'
    |   '\u0f99'..'\u0fbc'
    |   '\u0fc6'
    |   '\u1000'..'\u1021'
    |   '\u1023'..'\u1027'
    |   '\u1029'..'\u102a'
    |   '\u102c'..'\u1032'
    |   '\u1036'..'\u1039'
    |   '\u1040'..'\u1049'
    |   '\u1050'..'\u1059'
    |   '\u10a0'..'\u10c5'
    |   '\u10d0'..'\u10f8'
    |   '\u1100'..'\u1159'
    |   '\u115f'..'\u11a2'
    |   '\u11a8'..'\u11f9'
    |   '\u1200'..'\u1206'        
    |   '\u1208'..'\u1246'
    |   '\u1248'
    |   '\u124a'..'\u124d'
    |   '\u1250'..'\u1256'
    |   '\u1258'
    |   '\u125a'..'\u125d'
    |   '\u1260'..'\u1286'
    |   '\u1288'        
    |   '\u128a'..'\u128d'
    |   '\u1290'..'\u12ae'
    |   '\u12b0'
    |   '\u12b2'..'\u12b5'
    |   '\u12b8'..'\u12be'
    |   '\u12c0'
    |   '\u12c2'..'\u12c5'
    |   '\u12c8'..'\u12ce'
    |   '\u12d0'..'\u12d6'
    |   '\u12d8'..'\u12ee'
    |   '\u12f0'..'\u130e'
    |   '\u1310'
    |   '\u1312'..'\u1315'
    |   '\u1318'..'\u131e'
    |   '\u1320'..'\u1346'
    |   '\u1348'..'\u135a'
    |   '\u1369'..'\u1371'
    |   '\u13a0'..'\u13f4'
    |   '\u1401'..'\u166c'
    |   '\u166f'..'\u1676'
    |   '\u1681'..'\u169a'
    |   '\u16a0'..'\u16ea'
    |   '\u16ee'..'\u16f0'
    |   '\u1700'..'\u170c'
    |   '\u170e'..'\u1714'
    |   '\u1720'..'\u1734'
    |   '\u1740'..'\u1753'
    |   '\u1760'..'\u176c'
    |   '\u176e'..'\u1770'
    |   '\u1772'..'\u1773'
    |   '\u1780'..'\u17d3'
    |   '\u17d7'
    |   '\u17db'..'\u17dd'
    |   '\u17e0'..'\u17e9'
    |   '\u180b'..'\u180d'
    |   '\u1810'..'\u1819'
    |   '\u1820'..'\u1877'
    |   '\u1880'..'\u18a9'
    |   '\u1900'..'\u191c'
    |   '\u1920'..'\u192b'
    |   '\u1930'..'\u193b'
    |   '\u1946'..'\u196d'
    |   '\u1970'..'\u1974'
    |   '\u1d00'..'\u1d6b'
    |   '\u1e00'..'\u1e9b'
    |   '\u1ea0'..'\u1ef9'
    |   '\u1f00'..'\u1f15'
    |   '\u1f18'..'\u1f1d'
    |   '\u1f20'..'\u1f45'
    |   '\u1f48'..'\u1f4d'
    |   '\u1f50'..'\u1f57'
    |   '\u1f59'
    |   '\u1f5b'
    |   '\u1f5d'
    |   '\u1f5f'..'\u1f7d'
    |   '\u1f80'..'\u1fb4'
    |   '\u1fb6'..'\u1fbc'        
    |   '\u1fbe'
    |   '\u1fc2'..'\u1fc4'
    |   '\u1fc6'..'\u1fcc'
    |   '\u1fd0'..'\u1fd3'
    |   '\u1fd6'..'\u1fdb'
    |   '\u1fe0'..'\u1fec'
    |   '\u1ff2'..'\u1ff4'
    |   '\u1ff6'..'\u1ffc'
    |   '\u200c'..'\u200f'
    |   '\u202a'..'\u202e'
    |   '\u203f'..'\u2040'
    |   '\u2054'
    |   '\u2060'..'\u2063'
    |   '\u206a'..'\u206f'
    |   '\u2071'
    |   '\u207f'
    |   '\u20a0'..'\u20b1'
    |   '\u20d0'..'\u20dc'
    |   '\u20e1'
    |   '\u20e5'..'\u20ea'
    |   '\u2102'
    |   '\u2107'
    |   '\u210a'..'\u2113'
    |   '\u2115'
    |   '\u2119'..'\u211d'
    |   '\u2124'
    |   '\u2126'
    |   '\u2128'
    |   '\u212a'..'\u212d'
    |   '\u212f'..'\u2131'
    |   '\u2133'..'\u2139'
    |   '\u213d'..'\u213f'
    |   '\u2145'..'\u2149'
    |   '\u2160'..'\u2183'
    |   '\u3005'..'\u3007'
    |   '\u3021'..'\u302f'        
    |   '\u3031'..'\u3035'
    |   '\u3038'..'\u303c'
    |   '\u3041'..'\u3096'
    |   '\u3099'..'\u309a'
    |   '\u309d'..'\u309f'
    |   '\u30a1'..'\u30ff'
    |   '\u3105'..'\u312c'
    |   '\u3131'..'\u318e'
    |   '\u31a0'..'\u31b7'
    |   '\u31f0'..'\u31ff'
    |   '\u3400'..'\u4db5'
    |   '\u4e00'..'\u9fa5'
    |   '\ua000'..'\ua48c'
    |   '\uac00'..'\ud7a3'
    |   '\uf900'..'\ufa2d'
    |   '\ufa30'..'\ufa6a'
    |   '\ufb00'..'\ufb06'
    |   '\ufb13'..'\ufb17'
    |   '\ufb1d'..'\ufb28'
    |   '\ufb2a'..'\ufb36'
    |   '\ufb38'..'\ufb3c'
    |   '\ufb3e'
    |   '\ufb40'..'\ufb41'
    |   '\ufb43'..'\ufb44'
    |   '\ufb46'..'\ufbb1'
    |   '\ufbd3'..'\ufd3d'
    |   '\ufd50'..'\ufd8f'
    |   '\ufd92'..'\ufdc7'
    |   '\ufdf0'..'\ufdfc'
    |   '\ufe00'..'\ufe0f'
    |   '\ufe20'..'\ufe23'
    |   '\ufe33'..'\ufe34'
    |   '\ufe4d'..'\ufe4f'
    |   '\ufe69'
    |   '\ufe70'..'\ufe74'
    |   '\ufe76'..'\ufefc'
    |   '\ufeff'
    |   '\uff04'
    |   '\uff10'..'\uff19'
    |   '\uff21'..'\uff3a'
    |   '\uff3f'
    |   '\uff41'..'\uff5a'
    |   '\uff65'..'\uffbe'
    |   '\uffc2'..'\uffc7'
    |   '\uffca'..'\uffcf'
    |   '\uffd2'..'\uffd7'
    |   '\uffda'..'\uffdc'
    |   '\uffe0'..'\uffe1'
    |   '\uffe5'..'\uffe6'
    |   '\ufff9'..'\ufffb' 
// UTF-16    |   ('\ud800'..'\udbff') ('\udc00'..'\udfff')
    ; 
 









  
  
















  