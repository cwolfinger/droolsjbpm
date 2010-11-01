tree grammar ManchesterTreeBuilder;

options {
  language = Java;
  tokenVocab = ManchesterLexer;
  ASTLabelType = CommonTree;
} 


@header {

    package org.drools.lang.dl;
    
    import org.drools.lang.dl.descr.*;
    import java.util.List;
    import java.util.LinkedList;
       
}
 
  
@members {
  DLDescrFactory factory = new DLDescrFactory();
  DL_OntologyDescr ontoDescr = null;  
}


ontology returns [DL_OntologyDescr od]  
@init{ $od = factory.buildOntologyDescr(); this.ontoDescr = $od; }
  : ^(VT_ONTOLOGY  
          
          ^(VT_NAME 
            name=iri { this.ontoDescr.setName($name.iriDescr);}          
            (version=iri { $od.setVersion($version.iriDescr); })?         
            )
                     
          (^(VT_PREFIX tgt=iri ns=(VT_DEF_NS | VT_NAME) )
            { $od.addNamespace($ns.text,$tgt.iriDescr.getIri()); }
          )*   
          
          ( imp=inport {$od.addImport($imp.ref);} )*
           
          ( props=annotations {$od.addAnnotations($props.annList);} )*
           
          ( dec=declaration {$od.addDeclaration($dec.declDescr);} )*
          
          ( misc )*
          
        )        
  ;

 

//******************************************************************//
//    Preamble 
//******************************************************************//
  


inport returns [String ref]
  : ^(VT_IMPORT i=iri { $ref = $i.iriDescr.getIri(); })
  ;

 

//******************************************************************//
//    Class Types 
//******************************************************************//



declaration returns [DL_aDeclarationDescr declDescr]
  //class
  : ^( VT_TYPE_DECLARE 
         VT_ENTITY_TYPE_CLASS  { DL_ClassDescr descr = factory.buildClassDescr(); }
         ^( VT_TYPE_DECLARE_ID i=iri { descr.setIri($i.iriDescr); } )    
         
         ( ann=annotations { descr.addAnnotations($ann.annList); }
           | diu=disjointUnions { descr.addAllDisjointUnion($diu.diuList); }
           | diw=disjointWiths { descr.addAllDisjointWith($diw.diwList); }
           | eqs=equivalentTos { descr.addAllEquivalentTo($eqs.eqsList); }
           | sub=subClassOfs { descr.addAllSubClassOf($sub.subList); }
           | key=hasKeys { descr.addAllHasKey($key.keyList); }                                                                     
         )*
     ) 
     { $declDescr = descr; }  
  //datatype
  | ^( VT_TYPE_DECLARE 
         VT_ENTITY_TYPE_DATATYPE { DL_DatatypeDescr descr = factory.buildDatatypeDescr(); }  
         ^( VT_TYPE_DECLARE_ID i=iri { descr.setIri($i.iriDescr); } )  
         
         ( ann=annotations { descr.addAnnotations($ann.annList); }           
           | eqs=equivalentTos { descr.addAllEquivalentTo($eqs.eqsList); }                                                                               
         )*                                                                       
      )
      { $declDescr = descr; }  
  //object property    
  | ^( VT_TYPE_DECLARE 
         VT_ENTITY_TYPE_OBJPROP { DL_ObjectPropertyDescr descr = factory.buildObjectPropertyDescr(); }  
         ^( VT_TYPE_DECLARE_ID i=iri { descr.setIri($i.iriDescr); } )   
         
         ( ann=annotations { descr.addAnnotations($ann.annList); }
         
           | ^(VT_ATTRIBUTES 
                (^((
                    VT_DLA_FUN { descr.setFunctional(true); }
                    | VT_DLA_IFUN { descr.setInverseFunctional(true); }    
                    | VT_DLA_REF { descr.setReflexive(true); }
                    | VT_DLA_IREF { descr.setIrreflexive(true); }
                    | VT_DLA_SYM { descr.setSymmetric(true); }
                    | VT_DLA_ASYM { descr.setAsymmetric(true); }
                    | VT_DLA_TRN { descr.setTransitive(true); }
                   )                      
                 annotations? ))+
              )   
           | diw=disjointWiths { descr.addAllDisjointWith($diw.diwList); }
           | eqs=equivalentTos { descr.addAllEquivalentTo($eqs.eqsList); }
           | inv=inverseOfs { descr.addAllInverseOf($inv.invList); }
           | dom=domains { descr.addAllDomain($dom.domList); } 
           | rng=ranges { descr.addAllRange($rng.rngList); }
           | sub=subPropertyOfs { descr.addAllSubPropertyOf($sub.subList); }
           | chn=subPropertyChain { descr.addSubPropertyChain($chn.chnList); }
         )*                                                                      
      )            
      { $declDescr = descr; }  
  //data property             
  | ^( VT_TYPE_DECLARE 
         VT_ENTITY_TYPE_DATAPROP { DL_DataPropertyDescr descr = factory.buildDataPropertyDescr(); }  
         ^( VT_TYPE_DECLARE_ID i=iri { descr.setIri($i.iriDescr); } )            
         
          ( ann=annotations { descr.addAnnotations($ann.annList); }
           | ^(VT_ATTRIBUTES 
                (^(VT_DLA_FUN { descr.setFunctional(true); }) annotations? )
              ) 
           | diw=disjointWiths { descr.addAllDisjointWith($diw.diwList); }
           | eqs=equivalentTos { descr.addAllEquivalentTo($eqs.eqsList); }           
           | dom=domains { descr.addAllDomain($dom.domList); } 
           | rng=ranges { descr.addAllRange($rng.rngList); }
           | sub=subPropertyOfs { descr.addAllSubPropertyOf($sub.subList); }           
         )*                                                                                    
      )    
      { $declDescr = descr; }  
  //annotation property    
  | ^( VT_TYPE_DECLARE 
         VT_ENTITY_TYPE_ANNPROP { DL_AnnotationPropertyDescr descr = factory.buildAnnotationPropertyDescr(); }  
         ^( VT_TYPE_DECLARE_ID i=iri { descr.setIri($i.iriDescr); } ) 
         
         ( ann=annotations { descr.addAnnotations($ann.annList); }                     
           | dom=domains { descr.addAllDomain($dom.domList); } 
           | rng=ranges { descr.addAllRange($rng.rngList); }
           | sub=subPropertyOfs { descr.addAllSubPropertyOf($sub.subList); }           
         )*                                                                        
      )    
      { $declDescr = descr; }  
  //individual    
  | ^( VT_TYPE_DECLARE 
         VT_ENTITY_TYPE_INDIVIDUAL { DL_IndividualDescr descr = factory.buildIndividualDescr(); }  
         ^( VT_NAME i=iri { descr.setIri($i.iriDescr); } )        
         
         ( ann=annotations { descr.addAnnotations($ann.annList); }                     
           | typ=types { descr.addAllType($typ.typList); } 
           | fac=facts { descr.addAllFact($fac.facList); }
           | eqs=sames { descr.addAllSameAs($eqs.eqsList); }
           | dif=differs { descr.addAllDifferentFrom($dif.difList); }
         )*                                                                  
                                                                                           
      )    
      { $declDescr = descr; }  
  ;



        
           
                                                                           
disjointUnions returns [LinkedList diuList]
@init {$diuList = new LinkedList();}
  : ^(  VT_DISJOINTUNIONOF       
        ( d=definition {$diuList.add($d.defDescr);} )*  
     ) 
  ;


disjointWiths returns [LinkedList diwList]
@init {$diwList = new LinkedList();}
  : ^(  VT_DISJOINTWITH       
        ( d=definition {$diwList.add($d.defDescr);} )*  
     ) 
  ;

equivalentTos returns [LinkedList eqsList]
@init {$eqsList = new LinkedList();}
  : ^(  VT_EQUIVALENTTO       
        ( e=definition {$eqsList.add($e.defDescr);} )*  
     ) 
  ;

subClassOfs returns [LinkedList subList]
@init {$subList = new LinkedList();}
  : ^(  VT_SUBCLASSOF       
        ( s=definition {$subList.add($s.defDescr);} )*  
     ) 
  ;


hasKeys returns [LinkedList keyList]
@init {$keyList = new LinkedList();}
  : ^(  VT_KEYS
        ( k=relation {$keyList.add($k.relDescr);} )*  
     ) 
  ;


domains returns [LinkedList domList]
@init {$domList = new LinkedList();}
  : ^(  VT_DOMAIN       
        ( d=definition {$domList.add($d.defDescr);} )*  
     ) 
  ;


ranges returns [LinkedList rngList]
@init {$rngList = new LinkedList();}
  : ^(  VT_RANGE       
        ( d=definition {$rngList.add($d.defDescr);} )*  
     ) 
  ;

subPropertyOfs returns [LinkedList subList]
@init {$subList = new LinkedList();}
  : ^(  VT_SUBPROPERTYOF       
        ( r=relation {$subList.add($r.relDescr);} )*  
     ) 
  ;

inverseOfs returns [LinkedList invList]
@init {$invList = new LinkedList();}
  : ^(  VT_INVERSEOF       
        ( r=relation {$invList.add($r.relDescr);} )*  
     ) 
  ;

subPropertyChain returns [LinkedList chnList]
@init {$chnList = new LinkedList();}
  : ^(  VT_SUBPROPERTYCHAIN    
        ( r=relation {$chnList.add($r.relDescr);} )*  
     ) 
  ;


types returns [LinkedList typList]
@init {$typList = new LinkedList();}
  : ^(  VT_TYPES    
        (  d=definition {$typList.add($d.defDescr);} )*  
     ) 
  ;

facts returns [LinkedList facList]
@init {$facList = new LinkedList();}
  : ^(  VT_FACTS    
        (  
          ^(VT_FACT r=relation e=entity ) 
          { $facList.add(factory.buildFactDescr($r.relDescr,$e.val,false)); }
          | ^(VT_NEG ^(VT_FACT relation entity )) 
          { $facList.add(factory.buildFactDescr($r.relDescr,$e.val,true)); } 
        )*  
     ) 
  ;


sames returns [LinkedList eqsList]
@init {$eqsList = new LinkedList();}
  : ^(  VT_SAMEAS    
        (  annotations? x=individual {$eqsList.add($x.val);} )*  
     ) 
  ;

differs returns [LinkedList difList]
@init {$difList = new LinkedList();}
  : ^(  VT_DIFFERENTFROM    
        (  annotations? x=individual {$difList.add($x.val);} )*  
     ) 
  ;



//relation returns [DL_RelationDescr relDescr]
//  : (ann=annotations? rel=relation) { $relDescr = $rel.relDescr; $relDescr.addAnnotations($ann.annList); }
//  | ^(VT_DL_PROP prop=iri) { $relDescr = factory.buildGenericRelationDescr($prop.iriDescr,false); }
//  | ^(VT_DL_INV_PROP prop=iri) { $relDescr = factory.buildGenericRelationDescr($prop.iriDescr,true); }
//  ;

relation returns [DL_RelationDescr relDescr]
  :	^(VT_DL_PROP prop=iri) { $relDescr = factory.buildGenericRelationDescr($prop.iriDescr,false); }
  	| ^(VT_DL_INV_PROP prop=iri) { $relDescr = factory.buildGenericRelationDescr($prop.iriDescr,true); }  	  
  ;




//******************************************************************//
//    Definitions 
//******************************************************************//


definition returns [DL_DefinitionDescr defDescr]
  : root=dl_tree { $defDescr = factory.buildDefinitionDescr($root.descr); }
  ;

 
dl_tree returns [DL_aBaseDescr descr]
@init{ 
  List<DL_aBaseDescr> descrList = new LinkedList<DL_aBaseDescr>();
  List<Object> valuesList = new LinkedList<Object>();
}


  :   ^(VT_OR 
          (child=dl_tree { descrList.add($child.descr); })+
       )
      { $descr = factory.buildOr(descrList); }
  |   ^(VT_AND  
          (child=dl_tree { descrList.add($child.descr); })+
       )
      { $descr = factory.buildAnd(descrList); }  
  |   ^(VT_NEG child=dl_tree)
      { $descr = factory.buildNeg($child.descr); }
 
 
 
 
 
  |   ^(VT_EXISTS rel=relation tgt=dl_tree)
      { $descr = factory.buildExists(
                        $rel.relDescr, 
                        $tgt.descr); }
  |   ^(VT_FORALL rel=relation tgt=dl_tree)
      { $descr = factory.buildForall(
                        $rel.relDescr, 
                        $tgt.descr); }
  |   ^(VT_VALUE rel=relation val=entity)
      { $descr = factory.buildValue(
                        $rel.relDescr, 
                        $val.val); }
  |   ^(VT_SELF rel=relation)
      { $descr = factory.buildValue(
                        $rel.relDescr, 
                        null); }                                                    
  |   ^(VT_COUNT rel=relation
          (^(VT_MIN min=IntegerLiteral))?
          (^(VT_MAX max=IntegerLiteral))?
          typ=dl_tree?   
       )
      { $descr = factory.buildCount(
                        $rel.relDescr, 
                        $min.text,
                        $max.text,
                        $typ.descr); }  
  
  
  
  
  |   ^(VT_DL_TYPE klass=iri)  
      { $descr = factory.buildType($klass.iriDescr.getIri()); }       
  |   ^(VT_LIST (val=individual { valuesList.add($val.val); } )+  )
      { $descr = factory.buildEnumTypeDescr(valuesList); }
  |   ^(VT_LIST (val=literal { valuesList.add($val.val); } )+  )
      { $descr = factory.buildEnumTypeDescr(valuesList); }     
  |   ^(VT_DL_RESTRICTED_TYPE typ=dl_tree fac=dl_tree)
      { $descr = factory.buildRestrictedTypeDescr(typ,fac); }
  |   ^(VT_DL_RESTRICTION fc=facet lit=literal)     
      { descr = factory.buildFacetDescr(fc,$lit.val); }                                
  ;  


facet returns [String txt] 
  : ^( f=VK_FACET {$txt = $f.text;} )
  ;



//******************************************************************//
//    "Terminals" 
//******************************************************************//



annotations returns [LinkedList annList]
@init {$annList = new LinkedList();}
  : ^(  VT_ANNOTATIONS         
        ( a=annotation {$annList.add($a.annDescr);} )*  
     ) 
  ;

annotation returns [DL_AnnotationDescr annDescr]
@init {$annDescr = factory.buildAnnotationDescr();}
  : ^(VT_ANNOTATION   
        ( nestedAnn=annotations { $annDescr.addAnnotations($nestedAnn.annList); } )?      
        src=iri { $annDescr.setIriKey($src.iriDescr); } 
        tgt=entity { $annDescr.setTargetValue($tgt.val); } 
     )
  ;


individual returns [Object val]  
	: i=iri { $val=$i.iriDescr.getIri(); }
  | ^( VT_ANON { $val=new Object(); } )
  | ^( VT_BLANK ln=VT_NAME { $val=new Blank($ln.text); } )
	;
  
  
entity returns [Object val]  
  : x=individual { $val = $x.val; }
  | lit=literal { $val=$lit.val; }
  ;  




 
 
literal returns [Object val]
  : s=QuotedString i=iri { $val = new TypedObject($s.text,$i.iriDescr.getIri()); } 
  | s=QuotedString l=LanguageTag? { $val = new String($s.text); if ($l != null) $val = $val+$l.text; }   
  | j=IntegerLiteral { $val = Integer.valueOf($j.text); } 
  | d=DecimalLiteral { $val = java.math.BigDecimal.valueOf(Double.parseDouble($d.text)); }
  | f=FloatingPointLiteral { $val = Double.valueOf($f.text); }
  ; 

 
iri returns [DL_IriDescr iriDescr]
  : ^(VT_IRI ln=VT_NAME ns=VT_NAME)
    { 
      $iriDescr = factory.buildIriDescr($ns.text,$ln.text,this.ontoDescr.getNamespaces()); }
    | ^(VT_IRI ln=VT_NAME VT_DEF_NS) 
    { $iriDescr = factory.buildIriDescr("",$ln.text,this.ontoDescr.getNamespaces()); }      
    | ^(VT_IRI full=VT_PAREN_CHUNK )
    { $iriDescr = factory.buildIriDescr($full.text); }
  ;  






//******************************************************************//
//    Misc 
//******************************************************************//


misc
  : ^(VT_EQV_CLASS annotations? definition+)
  | ^(VT_DIF_CLASS annotations? definition+)
  | ^(VT_EQV_PROP annotations? relation+)
  | ^(VT_DIF_PROP annotations? relation+)
  | ^(VT_EQV_INDV annotations? individual+)
  | ^(VT_DIF_INDV annotations? individual+)
  ;


 