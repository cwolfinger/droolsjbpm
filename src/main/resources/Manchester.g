parser grammar Manchester;


    
@members {
    
    private Set prefixes = null;     
    public void setPrefixSet( Set ps )    { this.prefixes = ps; }    
    
    private ParserHelper helper = null;
    public void setParserHelper( ParserHelper helper )        { this.helper = helper; }
    public void reportError(RecognitionException ex)          {      helper.reportError( ex ); }  
    
    private Tree curField;
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
  | manDL_misc
  ;  








manDL_class
scope{
  CommonTree keys; 
} 
@init{
  ((manDL_class_scope) manDL_class_stack.peek()).keys = new CommonTree(new CommonToken(DRLv6Lexer.VT_KEYS,"VT_KEYS"));
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
  : manDL_field^ manDL_decl_field_attributes? SEMICOLON!    	 
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
      qa=(manDL_quick_attributes -> ^(VT_ATTRIBUTES manDL_quick_attributes?))
      manDL_objProp_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_TYPE_DECLARE_ID iri) $qa? manDL_objProp_frame*)
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
      qa=(manDL_quick_attributes -> ^(VT_ATTRIBUTES manDL_quick_attributes?))
      manDL_dataProp_frame*
    end_key?
  -> ^(VT_TYPE_DECLARE ^(VT_ENTITY_TYPE[$typ.text]) ^(VT_TYPE_DECLARE_ID iri) $qa? manDL_dataProp_frame*)
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
	: (AT manDL_att_functional) => AT! manDL_att_functional manDL_quick_attributes
	| (AT manDL_att_inverseFunctional) => AT! manDL_att_inverseFunctional manDL_quick_attributes
	| (AT manDL_att_reflexive) => AT! manDL_att_reflexive manDL_quick_attributes
	| (AT manDL_att_irreflexive) => AT! manDL_att_irreflexive manDL_quick_attributes
	| (AT manDL_att_symmetric) => AT! manDL_att_symmetric manDL_quick_attributes
	| (AT manDL_att_asymmetric) => AT! manDL_att_asymmetric manDL_quick_attributes
	| (AT manDL_att_transitive) => AT! manDL_att_transitive manDL_quick_attributes
	| 
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

 