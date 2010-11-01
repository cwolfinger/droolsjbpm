grammar iri;
  
options {
  language = Java;
  output = AST;
}

@lexer::header {
  package org.drools.lang.iri;
}

@parser::header {
  package org.drools.lang.iri;
}

iri_reference
  : iri 
  | irelative_ref
  ;

absolute_iri 
  : scheme COLON ihier_part 
    (QUESTION_MARK iquery)?  
  ;


iri 
  : scheme COLON ihier_part 
    (QUESTION_MARK iquery)?  
    (GATE ifragment)?
  ;


irelative_ref 
  : irelative_part 
    (QUESTION_MARK iquery)?
    (GATE ifragment)?    
  ;


 
ihier_part     
  : DBL_SLASH iauthority ipath_abempty
  | ipath_absolute
  | ipath_rootless
  | //ipath_empty
  ;  

irelative_part 
  : DBL_SLASH iauthority ipath_abempty
  | ipath_absolute
  | ipath_noscheme
  | //ipath_empty
  ;




scheme 
	:	 ALPHA ( ALPHA | DIGIT | PLUS | MINUS | DOT )*
	;
  
  





iauthority     
  : (iuserinfo AT)? ihost (COLON port)?
  ;

iuserinfo      
  : ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS | COLON )*
  ;
  
ihost          
  : ip_literal 
  | ip_v4address 
  | ireg_name
  ;

port 
	: DIGIT*
	;  
  
ireg_name 
  : ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS )*
  ;





ipath_abempty 
  : ( SLASH isegment )*
  ;
    
ipath_absolute 
  : SLASH (isegment_nz ( SLASH isegment )* )?
  ;

ipath_noscheme 
  : isegment_nz_nc ( SLASH isegment )*
  ;
  
ipath_rootless
  : isegment_nz ( SLASH isegment )*
  ;


  
  
  
  
  



isegment
  : ipchar*
  ;

isegment_nz
  : ipchar+
  ;
  
isegment_nz_nc 
  : ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | AT )+
  ;

iquery
  : ( ipchar | IPRIVATE | SLASH | QUESTION_MARK )*  
  ;

ifragment
  : ( ipchar | SLASH | QUESTION_MARK )*
  ;

ipchar
  : ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | COLON | AT 
  ; 









ip_literal 
	:	 LEFT_SQUARE  ip_vFuture  RIGHT_SQUARE
	;

ip_vFuture
	: ALPHA HEXDIG DOT ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | SUB_DELIMS )+
	;

ip_v4address
	: DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET 
	;
















QUESTION_MARK
	:	'?'
	;

GATE
	:	'#'
	;

PLUS
	:	'+'
	;

MINUS
	:	'-'
	;

DOT
	:	'.'
	;

COLON
	:	':'
	;

AT
	:	'@'
	;

DBL_SLASH
	:	'//'
	;

SLASH
	:	'/'
	;

LEFT_SQUARE
	:	'['
	;

RIGHT_SQUARE
	:	']'
	;


ALPHA : ('a'..'z') | ('A'..'Z') ;

DIGIT : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;

SUB_DELIMS : '!' | '$' | '&' | '\'' | '(' | ')' | '*' | '+' | ',' | ';' | '=' ;

PCT_ENCODED :	'%' HEXDIG HEXDIG ;

IUNRESERVED
  : '_' | '~' | UCSCHAR
  ;

fragment
HEXDIG
	:	 DIGIT | ('a'..'f') | ('A'..'F') ;


fragment
UCSCHAR
  : ('\u00a0'..'\ud7ff') | ('\uf900'..'\ufdcf') | ('\ufdf0'..'\uffef')  
  ;

fragment
IPRIVATE
  : ('\ue000'..'\uf8ff')
  ;    
  
//
//   ucschar        = %xA0-D7FF / %xF900-FDCF / %xFDF0-FFEF
//                  / %x10000-1FFFD / %x20000-2FFFD / %x30000-3FFFD
//                  / %x40000-4FFFD / %x50000-5FFFD / %x60000-6FFFD
//                  / %x70000-7FFFD / %x80000-8FFFD / %x90000-9FFFD
//                  / %xA0000-AFFFD / %xB0000-BFFFD / %xC0000-CFFFD
//                  / %xD0000-DFFFD / %xE1000-EFFFD
//
//   iprivate       = %xE000-F8FF / %xF0000-FFFFD / %x100000-10FFFD
//





   


//fragment
//UNRESERVED : ALPHA | DIGIT | MINUS | DOT | '_' | '~' ;
	
//fragment	
//RESERVED : GEN_DELIMS | SUB_DELIMS ;

//fragment
//GEN_DELIMS 	:	 ':' | '/' | '?' | '#' | '[' | ']' | '@' ;







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
EOL   
  :      
  ( ( '\r\n' )=> '\r\n' 
  | '\r'    
  | '\n'    
  )
  ;











fragment
DEC_OCTET 
	:	('1'..'9') DIGIT
	| '1' DIGIT DIGIT
	| '2' ('0'..'4') DIGIT
	| '25' ('0'..'5')
	;



  

