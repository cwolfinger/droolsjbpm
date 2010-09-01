parser grammar DRLv6Parser; 

   
options {  
  language = Java;
  output = AST;
  ASTLabelType=CommonTree;
  tokenVocab=DRLv6Lexer;
  k=2; 
}
                     
   
  
//import  General, Expression; 
import DRLv6Keywords, Manchester;

        
 

@header {
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
    private ParserHelper helper = new ParserHelper( this,
                                                    tokenNames,
                                                    input,
                                                    state );
                                                      
    /**
     * The dummy parameter bellow is just to enable constructor overloading
     * so that we can initialise the parser helper on delegate grammars
     */
    public DRLv6Parser(TokenStream input, boolean dummy ) {
        this(input);
          gDRLv6Keywords.setParserHelper( helper );
//        gExpression.setParserHelper( helper );
//        gGeneral.setParserHelper( helper );          
//          gAttributes.setParserHelper( helper );
          gManchester.setParserHelper( helper );
          gManchester.setPrefixSet( prefixes );
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
  : manDL_ontology 
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
    rule_attributes?        {System.out.println("rule - check for rule atts");}
    rule_arrow?             {System.out.println("rule - check for rule arrow");}
    when_part               {System.out.println("rule - check for rule when");}
    then_part               {System.out.println("rule - check for rule then");}
    -> ^(rule_key rule_id 
              ^(VT_EXTENDS rule_id)?
              parameters? 
              rule_attributes? 
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
  memoize=true;
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
  memoize=true;
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
  memoize=true;
} // required!
  : unary_operator^ operator_attributes? constr_unary
  | constr_atom
  | LEFT_PAREN! constr_implies RIGHT_PAREN! 
  ;

 
constr_atom
options{ 
  backtrack=true;
  memoize=true;
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
  memoize=true;
}
  : label general_accessor_path
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
  memoize=true;
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
  memoize=true;
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
  memoize=true;
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
    {$prefixed_name.text.equals($pref.text+":"+$nam.text)}?
  -> ^(VT_IRI $pref? $nam)
  ;
  
empty_prefix_name 
  :   COLON nam=ID
  -> ^(VT_IRI $nam)
  ;

fully_qualified_name
  : (ID DOT)+ 
    ( (primitiveType) => primitiveType
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



 

//****************************************************+
//              rule attributes
//******************************************************


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
  
  
  
  
  
  
  

 
 
 
 
 
 
 
   
 








  
  
















  