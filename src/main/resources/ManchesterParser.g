parser grammar ManchesterParser;
        
          
options {  
  language = Java;
  output = AST;
  ASTLabelType=CommonTree;
  tokenVocab=ManchesterLexer;
  k=2; 
}
   
@header { 
  package org.drools.lang.dl;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;
  
  import org.drools.lang.iri.iriParser;
  import org.drools.lang.iri.iriLexer;
  import java.io.ByteArrayInputStream;
  import java.io.IOException;
  import org.antlr.runtime.ANTLRInputStream;
  import org.antlr.runtime.CommonTokenStream;
  import org.antlr.runtime.RecognitionException;
  
}
    

    
@members {
    
    private Set prefixes = new HashSet();     
    public void setPrefixSet( Set ps )    { this.prefixes = ps; }    
          
    private boolean validateIRI(String iriS) {
            try { 
              iriLexer iri_lexer = new iriLexer( new ANTLRInputStream( new ByteArrayInputStream(iriS.getBytes()) ));     
              iriParser iri_parser = new iriParser(new CommonTokenStream( iri_lexer ));      
                                              
              iri_parser.iri();
              return (iri_parser.getNumberOfSyntaxErrors() == 0);
            } catch (IOException ioe) {
              return false;
            } catch (RecognitionException re) {
              return false;
            }
        
    }
    
}




//******************************************************************
//                        MANCHESTER SYNTAX
//******************************************************************  


manDL_ontology
options{
	k=5;
}
  :	
  	manDL_prefix*  
    ONTOLOGY_K COLON (nam=iri ver=iri?)?
    manDL_inport*
    manDL_annotations?
    manDL_type_declaration*    
    -> ^(VT_ONTOLOGY ^(VT_NAME $nam? $ver?) 
    		manDL_prefix* 
    		manDL_inport* 
    		manDL_annotations? 
    		manDL_type_declaration*    		
    		)    
  ; 


manDL_inport  // :)
  : IMPORT_K COLON iri   
  -> ^(VT_IMPORT iri)
  ;  


//prefixName := a finite sequence of characters matching the PNAME_NS production of [SPARQL] and not matching any of the keyword terminals of the syntax
   
manDL_prefix
  : (PREFIX_K | NAMESPACE_K) COLON
    ( 
        (pref=pn_Prefix { prefixes.add($pref.text); }) COLON? full_iri
        | full_iri    
    )    
  ->{pref==null}? ^(VT_PREFIX full_iri VT_DEF_NS)
  -> ^(VT_PREFIX full_iri pn_Prefix)  
  ; 
 


manDL_annotations
  : ANNOTATIONS_K COLON manDL_annotation_list
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
  : manDL_individual | manDL_literal 
  ;  

 

manDL_type_declaration
  : manDL_datatype_def
  | manDL_class     
  | manDL_objectProperty
  | manDL_dataProperty
  | manDL_annotationProperty
  | manDL_namedIndividual  
  | manDL_misc
  ;  




 



manDL_class
  :   	  	  	
    	typ=CLASS_K COLON      
      iri
      manDL_class_frame*         
  -> 
      ^(VT_TYPE_DECLARE 
         ^(VT_ENTITY_TYPE_CLASS) 
         ^(VT_TYPE_DECLARE_ID iri)                                                               
         manDL_class_frame* 
      )                           
  ;



  
  
  
  
   
  
manDL_class_frame
  : (ANNOTATIONS_K) => manDL_annotations
  | (DISJOINTUNIONOF_K) => manDL_disjointUnionOf
  | (DISJOINTWITH_K) => manDL_disjointWith
  | (EQUIVALENTTO_K) => manDL_equivalentTo
  | (SUBCLASSOF_K) => manDL_subClassOf
  | (HASKEY_K) => manDL_hasKey     
  ;  
  
   
  
manDL_disjointUnionOf
  : DISJOINTUNIONOF_K COLON manDL_disjointUnionOf_list
    -> ^(VT_DISJOINTUNIONOF manDL_disjointUnionOf_list)
  ;

manDL_disjointUnionOf_list
  : manDL_annotated_description (COMMA! manDL_annotated_description)+ 
  ;  
  
manDL_disjointWith
  : DISJOINTWITH_K COLON manDL_annotated_description_list
  -> ^(VT_DISJOINTWITH manDL_annotated_description_list)
  ;

manDL_equivalentTo
  : (EQUIVALENTTO_K COLON)  manDL_annotated_description_list
  -> ^(VT_EQUIVALENTTO manDL_annotated_description_list)  
  ;
  
manDL_subClassOf
  : SUBCLASSOF_K COLON manDL_annotated_description_list
  -> ^(VT_SUBCLASSOF manDL_annotated_description_list)
  ;  
  
manDL_hasKey
  : HASKEY_K COLON manDL_annotations? manDL_property_expression (COMMA manDL_property_expression)*
  -> ^(VT_KEYS manDL_annotations? manDL_property_expression+)
  ;  
  
  
  
 
 
manDL_annotated_description_list
  : manDL_annotated_description (COMMA! manDL_annotated_description)*
  ;


manDL_annotated_description
  : manDL_annotations? manDL_description
  -> ^(VT_DL_DEFINITION manDL_annotations? manDL_description)
  ;
  


manDL_description 
  : manDL_conjunction ( or=OR_K manDL_conjunction )*
  -> {or==null}? manDL_conjunction
  -> ^(VT_OR manDL_conjunction+)
  ;
  
manDL_conjunction
  : (manDL_classIRI THAT_K) => 
     manDL_classIRI THAT_K 
        manDL_restr 
     (AND_K manDL_restr)*
  -> ^(VT_AND ^(VT_DL_TYPE manDL_classIRI) manDL_restr+)     
  
  | manDL_primary ( and=AND_K manDL_primary)*
  -> {and==null}? manDL_primary
  -> ^(VT_AND manDL_primary+)
  ;  





manDL_primary 
options{
	backtrack=true;
}
  :      
  manDL_restr
  | manDL_atom 
  ;


manDL_atom
  : not=NOT_K? manDL_atomic_core
  -> {not!=null}? ^(VT_NEG manDL_atomic_core)
  -> manDL_atomic_core
  ;

manDL_restr
  : not=NOT_K? manDL_quantified_restriction_core
  -> {not!=null}? ^(VT_NEG manDL_quantified_restriction_core)
  -> manDL_quantified_restriction_core
  ;









  
manDL_atomic_core
  : LEFT_CURLY! manDL_item_list  RIGHT_CURLY!
  
  | manDL_data_type_restriction
  -> manDL_data_type_restriction
  
  | LEFT_PAREN! manDL_description RIGHT_PAREN!
  ; 
  


 

 
 manDL_quantified_restriction_core
  : p=manDL_property_expression   
    (   (SOME_K) => SOME_K manDL_primary
      -> ^(VT_EXISTS manDL_property_expression manDL_primary)
      | (ONLY_K) => ONLY_K  manDL_primary
      -> ^(VT_FORALL manDL_property_expression manDL_primary)
//      | (ALL_K) => ALL_K  manDL_primary
//      -> ^(VT_FORALL manDL_property_expression manDL_primary)
      | (VALUE_K) => VALUE_K (manDL_individual | manDL_literal)
      -> ^(VT_VALUE manDL_property_expression manDL_individual? manDL_literal?)
      | (SELF_K) => SELF_K
      -> ^(VT_SELF manDL_property_expression)
      | (MIN_K) => manDL_min_restr      
      -> ^(VT_COUNT manDL_property_expression manDL_min_restr)
      | (MAX_K) => manDL_max_restr      
      -> ^(VT_COUNT manDL_property_expression manDL_max_restr)                                
      | (EXACTLY_K) => manDL_exactly_restr
      -> ^(VT_COUNT manDL_property_expression manDL_exactly_restr)
      
      
      | (manDL_data_type_restriction) => manDL_data_type_restriction
      -> ^(VT_COUNT manDL_property_expression ^(VT_MIN IntegerLiteral["1"]) ^(VT_MAX IntegerLiteral["1"]) manDL_data_type_restriction)       
   ) 
  ;  
  
  
manDL_exactly_restr
options{
 backtrack=true;
}
  : 
   (EXACTLY_K IntegerLiteral manDL_primary?) 
   -> ^(VT_MIN IntegerLiteral) ^(VT_MAX IntegerLiteral) manDL_primary?
  ;  
  
  
manDL_max_restr
options{
 backtrack=true;
}
  : 
  (MAX_K IntegerLiteral manDL_primary?) 
   -> ^(VT_MAX IntegerLiteral) manDL_primary?  
  ;  

manDL_min_restr
options{
 backtrack=true;
}
  : 
  (MIN_K IntegerLiteral manDL_primary?) 
   -> ^(VT_MIN IntegerLiteral) manDL_primary?
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
  : manDL_literal
  ; 

manDL_facet
  : f=(LENGTH_K
  | MINLENGTH_K
  | MAXLENGTH_K
  | PATTERN_K
  | LANGPATTERN_K
  | GEQ
  | GREATER
  | LEQ
  | LESS)
  -> ^(VK_FACET[$f.text])
  ;   
 
 
 
 
 
 





manDL_datatype_def
  : 
    typ=DATATYPE_K COLON
      iri
      manDL_datatype_frame*
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE_DATATYPE) ^(VT_TYPE_DECLARE_ID iri) manDL_datatype_frame*)
  ;
 
manDL_datatype_frame
  : manDL_annotations
  | manDL_equivalentTo  
  ;  
  
  
  
 

manDL_objectProperty
  : typ=OBJECTPROPERTY_K COLON
      iri
      manDL_objProp_frame*
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE_OBJPROP) ^(VT_TYPE_DECLARE_ID iri) 
        //$qa? 
        manDL_objProp_frame*)
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
		typ=DATAPROPERTY_K COLON 
      iri
     // qa=(manDL_quick_attributes -> ^(VT_ATTRIBUTES manDL_quick_attributes?))
      manDL_dataProp_frame*
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE_DATAPROP) ^(VT_TYPE_DECLARE_ID iri) 
        //$qa?  
        manDL_dataProp_frame*)
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
  : DOMAIN_K COLON manDL_annotated_description_list
  -> ^(VT_DOMAIN manDL_annotated_description_list)
  ;
  
manDL_range
  : RANGE_K COLON manDL_annotated_description_list  
  -> ^(VT_RANGE manDL_annotated_description_list)
  ;

     
 
 
 
manDL_subPropertyOf
  : SUBPROPERTYOF_K COLON manDL_property_list
  -> ^(VT_SUBPROPERTYOF manDL_property_list)
  ;  
  
manDL_inverseOf
  : INVERSEOF_K COLON manDL_property_list
  -> ^(VT_INVERSEOF manDL_property_list)
  ;  

manDL_subPropChain
  : SUBPROPERTYCHAIN_K COLON manDL_annotations? manDL_property_expression ( CHAIN manDL_property_expression )*
  -> ^(VT_SUBPROPERTYCHAIN manDL_annotations? manDL_property_expression+)
  ;
     
 





  
manDL_annotationProperty
  : typ=ANNOTATIONPROPERTY_K COLON
      iri
      manDL_annProp_frame*
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE_ANNPROP) ^(VT_TYPE_DECLARE_ID iri) manDL_annProp_frame*)
  ;  
  
  
manDL_annProp_frame
  : manDL_annotations
  | manDL_domain  
  | manDL_range
  | manDL_subPropertyOf
  ; 
  
  
  
  
  
  
  
manDL_namedIndividual
  : typ=INDIVIDUAL_K COLON
      iri
      manDL_indiv_frame*
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE_INDIVIDUAL) ^(VT_NAME iri) manDL_indiv_frame*)
  ;  
  
manDL_indiv_frame 
  : manDL_annotations
  | manDL_types
  | manDL_facts
  | manDL_sameAs
  | manDL_differentFrom
  ;  
  
manDL_types
  : TYPES_K COLON manDL_annotated_description_list
  -> ^(VT_TYPES manDL_annotated_description_list)
  ;

manDL_individual_list
  : manDL_annotated_individual (COMMA manDL_annotated_individual)*
    -> ^(VT_LIST manDL_annotated_individual+)
  ;
  
manDL_annotated_individual
  : manDL_annotations? manDL_individual 
  -> ^(manDL_individual manDL_annotations?) 
  ;   
  
manDL_facts
  : FACTS_K COLON manDL_fact_annotated_list
  -> ^(VT_FACTS manDL_fact_annotated_list)
  ;
  
manDL_fact_annotated_list
  : manDL_annotated_fact (COMMA! manDL_annotated_fact)*
  ;

manDL_annotated_fact
  : manDL_annotations? manDL_fact
  -> ^(manDL_fact manDL_annotations?)   
  ;   

manDL_fact
  : neg=NOT_K? manDL_property_expression (manDL_individual | manDL_literal)
  -> {neg==null}? ^(VT_FACT manDL_property_expression manDL_individual? manDL_literal?)
  -> ^(VT_NEG ^(VT_FACT manDL_property_expression manDL_individual? manDL_literal?))
  ;    


  
manDL_sameAs
  : SAMEAS_K COLON manDL_individual_list
  -> ^(VT_SAMEAS manDL_individual_list)
  ;
  
manDL_differentFrom
  : DIFFERENTFROM_K COLON manDL_individual_list
  -> ^(VT_DIFFERENTFROM manDL_individual_list)
  ;  

  

  
  
  
  
  




  
  



manDL_misc
  : (eq=EQUIVALENTCLASSES_K | df=DISJOINTCLASSES_K) COLON
      manDL_annotations? manDL_description (COMMA manDL_description)+
      -> {eq!=null}? ^(VT_EQV_CLASS manDL_annotations? manDL_description+)
      -> ^(VT_DIF_CLASS manDL_annotations? manDL_description+)
      
  | (eq2=EQUIVALENTPROPERTIES_K | df2=DISJOINTPROPERTIES_K) COLON
      manDL_annotations? manDL_property_expression (COMMA manDL_property_expression)+
      -> {eq2!=null}? ^(VT_EQV_PROP manDL_annotations? manDL_property_expression+)
      -> ^(VT_DIF_PROP manDL_annotations? manDL_property_expression+)
      
  | (eq3=SAMEINDIVIDUAL_K | df3=DIFFERENTINDIVIDUALS_K) COLON
      manDL_annotations? manDL_individual (COMMA manDL_individual)+
      -> {eq3!=null}? ^(VT_EQV_INDV manDL_annotations? manDL_individual+)
      -> ^(VT_DIF_INDV manDL_annotations? manDL_individual+)
  ;
   







  
  





  



  
  

          


  


  
  
  
  
    
  
  
 



manDL_attributes
  : CHARACTERISTICS_K COLON (manDL_annotations? manDL_attribute) (COMMA  manDL_annotations? manDL_attribute)*
  -> ^(VT_ATTRIBUTES ^(manDL_attribute manDL_annotations?)+)   
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
  : FUNCTIONAL_K -> VT_DLA_FUN  
  ;
  
manDL_att_inverseFunctional
  : INVERSEFUNCTIONAL_K -> VT_DLA_IFUN  
  ;
  
manDL_att_reflexive
  : REFLEXIVE_K -> VT_DLA_REF  
  ;
  
manDL_att_irreflexive
  : IRREFLEXIVE_K -> VT_DLA_IREF  
  ;
  
manDL_att_symmetric
  : SYMMETRIC_K -> VT_DLA_SYM  
  ;
  
manDL_att_asymmetric
  : ASYMMETRIC_K -> VT_DLA_ASYM
  ;

manDL_att_transitive
  : TRANSITIVE_K -> VT_DLA_TRN
  ; 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
manDL_property_list
  : manDL_annotatedProperty (COMMA! manDL_annotatedProperty)?
  ; 
  
manDL_annotatedProperty
  : manDL_annotations? manDL_property_expression
  ;
       
manDL_property_expression  
  : inv=INVERSE_K? manDL_propertyIRI
  -> {inv==null}? ^(VT_DL_PROP manDL_propertyIRI)
  -> ^(VT_DL_INV_PROP manDL_propertyIRI)     
  ;  
  

manDL_item_list
  : manDL_literal_list
  | manDL_individual_list
  ;
  
manDL_literal_list
  : manDL_literal (COMMA manDL_literal)*
    -> ^(VT_LIST manDL_literal+)
  ;









  


  

manDL_literal :
  manDL_typedLiteral 
  | QuotedString LanguageTag?    
  | IntegerLiteral 
  | DecimalLiteral 
  | FloatingPointLiteral
  ;


//primitives are obtained via iri
manDL_data_type
  : manDL_classIRI 
  ;  
  
manDL_primitive_data_type  
  : INTEGER_K 
  | DECIMAL_K 
  | FLOAT_K 
  | STRING_K
  ;
  
manDL_typedLiteral
  : QuotedString DBL_CAP! manDL_data_type
  ;  
  
manDL_classIRI 
  : iri
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








iri
options{
  backtrack=true;
  memoize=true;
} 
  :
  full_iri 
  | abbreviated_iri 
  | simple_iri
  ;




//nodeID := a finite sequence of characters matching the BLANK_NODE_LABEL production of [SPARQL]
nodeID
  : blank_node
  | anon
  ;
  
blank_node
  : BLANK pn_Local
  -> ^( VT_BLANK pn_Local )  
  ;  
 
anon
  : LEFT_SQUARE RIGHT_SQUARE
  -> ^( VT_ANON )
  ;


//abbreviatedIRI := a finite sequence of characters matching the PNAME_LN production of [SPARQL]
abbreviated_iri
  : pname_ns ln=pn_Local
  -> ^(VT_IRI pn_Local pname_ns) 
  ;

pname_ns  
  : pref=pn_Prefix? COLON
  -> {pref==null}? ^(VT_DEF_NS)
  -> pn_Prefix  
  ; 

//simpleIRI := a finite sequence of characters matching the PN_LOCAL production of [SPARQL] and not matching any of the keyword terminals of the syntax
simple_iri
  : pn_Local
  -> ^(VT_IRI pn_Local ^(VT_DEF_NS) )
  ;
  



pn_Local 
  :  pid=PN_ID -> ^(VT_NAME[$pid.text])
  | ( UNDERSCORE | DIGIT ) PN_INNER?
  | typ=manDL_primitive_data_type -> ^(VT_NAME[$typ.text]) 
  ;

pn_Prefix
  : pref=PN_ID -> ^(VT_NAME[$pref.text])
  ;




//fullIRI := an IRI as defined in [RFC 3987], enclosed in a pair of < (U+3C) and > (U+3E) characters 
full_iri
  : LESS!
      checked_iri
    GREATER!    
  ; 
    
    
checked_iri
  : i=any_iri {validateIRI($i.text)}?=>
  -> ^(VT_IRI any_iri)
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































 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 