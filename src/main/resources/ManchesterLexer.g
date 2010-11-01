lexer grammar ManchesterLexer;
     
options {
  language = Java; 
}  
             
 
tokens {
  
  VT_IMPORT;
  VT_NAME;
  
  VT_TYPE_DECLARE;
  VT_ENTITY_TYPE_CLASS;
  VT_ENTITY_TYPE_DATATYPE;
  VT_ENTITY_TYPE_OBJPROP;
  VT_ENTITY_TYPE_DATAPROP;
  VT_ENTITY_TYPE_ANNPROP;
  VT_ENTITY_TYPE_INDIVIDUAL;
  
  VT_TYPE_DECLARE_ID;
  VT_DATA_TYPE;
  VT_LIST;
  
  VT_ATTRIBUTES;
  VT_DIM_SIZE;
   
  VT_PAREN_CHUNK;
    
  VT_IMPLIES; 
  VT_NEG;
  VT_AND;
  VT_OR;
    
  VT_EXISTS;
  VT_FORALL;  
  VT_COUNT;
  VT_MIN;
  VT_MAX;
  VT_VALUE;
    
  
  
  VT_ONTOLOGY; 
  VT_PREFIX;
  VT_ANNOTATIONS;
  VT_ANNOTATION;
  VT_DL_DEFINITION;
  VT_FIELD;
  VT_KEYS;
    
  VT_FACTS;
  VT_FACT;
  VT_DL_TYPE;
  VT_TYPES;
  VT_TYPE;  
  VT_MSR;
        
  VT_DL_PROP;
  VT_DL_INV_PROP;
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
  
  VT_SAMEAS;
  VT_DIFFERENTFROM;
  
  VT_EQV_CLASS;
  VT_DIF_CLASS;
  VT_EQV_PROP;
  VT_DIF_PROP;
  VT_EQV_INDV;
  VT_DIF_INDV;

  VT_IRI;
  VT_BLANK;
  VT_ANON; 
  VT_DEF_NS;
  
  
  VT_DLA_FUN;
  VT_DLA_IFUN;
  VT_DLA_REF;
  VT_DLA_IREF;
  VT_DLA_SYM;
  VT_DLA_ASYM;
  VT_DLA_TRN;
  
  VT_SELF;
  
  VK_FACET;
}     
     


@lexer::header {
  package org.drools.lang.dl;

}

 
// --------------------------------------------------------
//                      KEYWORDS
// --------------------------------------------------------

AND_K : 'and' ;

ANNOTATIONS_K : 'Annotations' ;

ANNOTATIONPROPERTY_K : 'AnnotationProperty' ;

ASYMMETRIC_K : 'Asymmetric' ;

CHARACTERISTICS_K : 'Characteristics' ;

CLASS_K : 'Class' ;

DATAPROPERTY_K : 'DataProperty' ;

DATATYPE_K : 'Datatype' ;

DECIMAL_K : 'decimal' ;

DIFFERENTINDIVIDUALS_K : 'DifferentIndividuals' ;

DISJOINTCLASSES_K : 'DisjointClasses' ;

DISJOINTPROPERTIES_K : 'DisjointProperties' ;

DIFFERENTFROM_K : 'DifferentFrom' ;

DISJOINTWITH_K : 'DisjointWith' ;

DISJOINTUNIONOF_K : 'DisjointUnionOf' ;

DOMAIN_K : 'Domain' ;

EQUIVALENTCLASSES_K : 'EquivalentClasses' ;

EQUIVALENTPROPERTIES_K : 'EquivalentProperties' ;

EQUIVALENTTO_K : 'EquivalentTo' ; 
 
EXACTLY_K : 'exactly' ;

FACTS_K : 'Facts' ;

FLOAT_K : 'float' ;

FUNCTIONAL_K : 'Functional' ;

HASKEY_K : 'HasKey' ;

IMPORT_K : 'Import' ;

INDIVIDUAL_K : 'Individual' ;
 
INVERSE_K : 'inverse' ;

INVERSEFUNCTIONAL_K : 'InverseFunctional' ;

INVERSEOF_K : 'InverseOf' ;

INTEGER_K : 'integer' ;

IRREFLEXIVE_K : 'Irreflexive' ;

LANGPATTERN_K : 'langPattern' ;

LENGTH_K : 'length' ;

MAX_K : 'max' ;

MAXLENGTH_K : 'maxLength' ;

MIN_K : 'min' ;

MINLENGTH_K : 'minLength' ;

NAMEDINDIVIDUAL_K : 'NamedIndividual' ;

//Not standard??
NAMESPACE_K : 'Namespace' ;

NOT_K : 'not' ;

OBJECTPROPERTY_K : 'ObjectProperty' ;

ONLY_K : 'only' ;

ONTOLOGY_K : 'Ontology' ;

OR_K : 'or' ;

PATTERN_K : 'pattern' ;

PREFIX_K : 'Prefix' ;

RANGE_K : 'Range' ;

REFLEXIVE_K : 'Reflexive' ;

SAMEAS_K : 'SameAs' ;

SAMEINDIVIDUAL_K : 'SameIndividual' ;
 
SELF_K : 'Self' ;

SOME_K : 'some' ;

STRING_K : 'string' ;

SUBCLASSOF_K : 'SubClassOf' ;

SUBPROPERTYOF_K : 'SubPropertyOf' ;

SUBPROPERTYCHAIN_K : 'SubPropertyChain' ;

SYMMETRIC_K : 'Symmetric' ;

THAT_K : 'that' ;

TRANSITIVE_K : 'Transitive' ;

TYPES_K : 'Types' ;

VALUE_K : 'value' ;





GREATER : '>' ;
 
GEQ : '>=' ;

LEQ : '<=' ;

LESS : '<' ;

CHAIN : 'o' ; 

DBL_CAP : '^^' ;

BLANK : '_:' ;

UNDERSCORE : '_' ;

COLON : ':' ;

COMMA : ',' ;

SLASH : '/' ;




LEFT_SQUARE : '[' ;

RIGHT_SQUARE : ']' ;

LEFT_PAREN : '(' ;

RIGHT_PAREN : ')' ;

LEFT_CURLY : '{' ;

RIGHT_CURLY : '}' ;


  


IntegerLiteral : ('+' | '-')? Digits ;
DecimalLiteral : ('+' | '-')? Digits '.' Digits ;
FloatingPointLiteral : 
  ( '+' | '-' )? 
  (   Digits ('.' Digits)? Exponent 
      | '.' Digits Exponent
  ) 
  ( 'f' | 'F' )
  ;
QuotedString
  :   ('"' ( EscapeSequence | ~('\\'|'"') )+ '"')      
  ;
LanguageTag : '@' (ALPHA ALPHA) ;


//PN_CHARS_BASE | '_'


PN_ID
	: PN_CHARS_BASE PN_INNER?
	;
	
PN_NUMID
	: DIGIT PN_INNER?
	;
	
PN_UNDSCID
	: '_' PN_INNER?
	;	

OTHER_CHARS
    : '#' | '+' | '-' | '?' | '^' 
    ;    

WS      
  :       
  ( ' '
  | '\t'
  | '\f'
  | EOL
  )+
  { $channel=HIDDEN; }
  ;
















fragment
ALPHA : ('a'..'z') | ('A'..'Z') ;

fragment
DIGIT : ZERO | NONZERO ;

fragment
NONZERO : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;

fragment
HEXDIGIT : DIGIT | ('a'..'f') | ('A'..'F') ;

fragment
ZERO : '0' ;

fragment  
Exponent : ('e' | 'E') ('+' | '-')? Digits ;

fragment
Digits : DIGIT+ ;

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
    :   '\\' 'u' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT
    ;

fragment
EOL   
  :      
  ( ( '\r\n' )=> '\r\n' 
  | '\r'    
  | '\n'    
  )
  ;
  

fragment
PN_INNER
  : (PN_CHARS | '.')* PN_CHARS 
  ;


fragment
PN_CHARS
    : PN_CHARS_BASE
    | '_'
    | '-' 
    | DIGIT 
    | '\u00B7' 
    | ('\u0300'..'\u036F') 
    | ('\u203F'..'\u2040') 
    ;
    
fragment
PN_CHARS_BASE
    : ALPHA 
    | ('\u00C0'..'\u00D6') 
    | ('\u00D8'..'\u00F6') 
    | ('\u00F8'..'\u02FF') 
    | ('\u0370'..'\u037D') 
    | ('\u037F'..'\u1FFF') 
    | ('\u200C'..'\u200D') 
    | ('\u2070'..'\u218F') 
    | ('\u2C00'..'\u2FEF') 
    | ('\u3001'..'\uD7FF') 
    | ('\uF900'..'\uFDCF') 
    | ('\uFDF0'..'\uFFFD') 
   // | ('\u10000'..'\uEFFFF')  //not supported... yet?
    ;    
    



  




