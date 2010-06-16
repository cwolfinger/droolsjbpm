tree grammar DLTreeBuilder;

options {
  language = Java;
  tokenVocab = DRLv6Parser;
  ASTLabelType = CommonTree;
}


@header {

    package org.drools.lang.dl;
    
    import org.drools.lang.dl.descr.DLDescrFactory;
    import org.drools.lang.dl.descr.DL_BaseDescr;
    import java.util.List;
    import java.util.LinkedList;
       
}


@members {
  DLDescrFactory factory = new DLDescrFactory();  
}


drl_source returns [List<DL_BaseDescr> types]
@init{
  List<DL_BaseDescr> typeList = new LinkedList<DL_BaseDescr>();
}  
  : ^(VT_COMPILATION_UNIT package_header?
          ( klass=declaration { typeList.add($klass.typeDescr); } )*  
    )
    {types = typeList;}
  ;

package_header
  : ^(VT_PACKAGE ^(VT_PACKAGE_ID ID+) )
  ;

declaration returns [DL_BaseDescr typeDescr]
   : ^(VT_TYPE_DECLARE klass=VT_TYPE_DECLARE_ID type=dl_root) 
     { typeDescr=factory.buildRootType($klass.getText(),$type.dlDescr); }
   ;
  


dl_root returns [DL_BaseDescr dlDescr]
  :   ^(VT_DL_DEFINITION ans=dl_tree)
      { $dlDescr = $ans.dlDescr; }      
  ;
  
dl_tree returns [DL_BaseDescr dlDescr]
@init{ 
  List<DL_BaseDescr> descrList = new LinkedList<DL_BaseDescr>();
}
  :   ^(VT_IMPLIES left=dl_tree right=dl_tree)
      { descrList.add($left.dlDescr);
        descrList.add($right.dlDescr);
        $dlDescr = factory.createImplies(descrList);  
      }
  |   ^(VT_OR 
          (child=dl_tree { descrList.add($child.dlDescr); })+
       )
      { $dlDescr = factory.createOr(descrList); }
  |   ^(VT_AND  
          (child=dl_tree { descrList.add($child.dlDescr); })+
       )
      { $dlDescr = factory.createAnd(descrList); }  
  |   ^(VT_NEG child=dl_tree)
      { $dlDescr = factory.createNeg($child.dlDescr); }
  |   ^(VT_DL_TYPE klass=ID)  
      { $dlDescr = factory.createType($klass.getText()); } 
  |   ^(SOME rel=ID tgt=dl_tree)
      { $dlDescr = factory.createExists(
                        factory.createProperty($rel.getText()), 
                        $tgt.dlDescr); }
  |   ^(ALL rel=ID tgt=dl_tree)
      { $dlDescr = factory.createForall(
                        factory.createProperty($rel.getText()), 
                        $tgt.dlDescr); }              
  ;  
