parser grammar DRLv6Keywords;
 
       
 
@parser::members {
    private ParserHelper helper = null;
    public void setParserHelper( ParserHelper helper )        { this.helper = helper; }
    public void reportError(RecognitionException ex)          {      helper.reportError( ex ); }
}


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
  : {(helper.validateIdentifierKey(DroolsSoftKeywords.COLLECT_LIST))}?  id=ID 
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