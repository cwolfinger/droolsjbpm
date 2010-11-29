// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g 2010-11-27 00:20:24


    package org.drools.lang.dl;
    
    import org.drools.lang.dl.descr.*;
    import java.util.List;
    import java.util.LinkedList;
       


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ManchesterTreeBuilder extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VT_IMPORT", "VT_NAME", "VT_TYPE_DECLARE", "VT_ENTITY_TYPE_CLASS", "VT_ENTITY_TYPE_DATATYPE", "VT_ENTITY_TYPE_OBJPROP", "VT_ENTITY_TYPE_DATAPROP", "VT_ENTITY_TYPE_ANNPROP", "VT_ENTITY_TYPE_INDIVIDUAL", "VT_TYPE_DECLARE_ID", "VT_DATA_TYPE", "VT_LIST", "VT_ATTRIBUTES", "VT_DIM_SIZE", "VT_PAREN_CHUNK", "VT_IMPLIES", "VT_NEG", "VT_AND", "VT_OR", "VT_EXISTS", "VT_FORALL", "VT_COUNT", "VT_MIN", "VT_MAX", "VT_VALUE", "VT_ONTOLOGY", "VT_PREFIX", "VT_ANNOTATIONS", "VT_ANNOTATION", "VT_DL_DEFINITION", "VT_FIELD", "VT_KEYS", "VT_FACTS", "VT_FACT", "VT_DL_TYPE", "VT_TYPES", "VT_TYPE", "VT_MSR", "VT_DL_PROP", "VT_DL_INV_PROP", "VT_DL_RESTRICTION", "VT_DL_RESTRICTED_TYPE", "VT_EQUIVALENTTO", "VT_SUBCLASSOF", "VT_DISJOINTWITH", "VT_DISJOINTUNIONOF", "VT_SUBPROPERTYOF", "VT_INVERSEOF", "VT_SUBPROPERTYCHAIN", "VT_DOMAIN", "VT_RANGE", "VT_SAMEAS", "VT_DIFFERENTFROM", "VT_EQV_CLASS", "VT_DIF_CLASS", "VT_EQV_PROP", "VT_DIF_PROP", "VT_EQV_INDV", "VT_DIF_INDV", "VT_IRI", "VT_BLANK", "VT_ANON", "VT_DEF_NS", "VT_DLA_FUN", "VT_DLA_IFUN", "VT_DLA_REF", "VT_DLA_IREF", "VT_DLA_SYM", "VT_DLA_ASYM", "VT_DLA_TRN", "VT_SELF", "VK_FACET", "AND_K", "ANNOTATIONS_K", "ANNOTATIONPROPERTY_K", "ASYMMETRIC_K", "CHARACTERISTICS_K", "CLASS_K", "DATAPROPERTY_K", "DATATYPE_K", "DECIMAL_K", "DIFFERENTINDIVIDUALS_K", "DISJOINTCLASSES_K", "DISJOINTPROPERTIES_K", "DIFFERENTFROM_K", "DISJOINTWITH_K", "DISJOINTUNIONOF_K", "DOMAIN_K", "EQUIVALENTCLASSES_K", "EQUIVALENTPROPERTIES_K", "EQUIVALENTTO_K", "EXACTLY_K", "FACTS_K", "FLOAT_K", "FUNCTIONAL_K", "HASKEY_K", "IMPORT_K", "INDIVIDUAL_K", "INVERSE_K", "INVERSEFUNCTIONAL_K", "INVERSEOF_K", "INTEGER_K", "IRREFLEXIVE_K", "LANGPATTERN_K", "LENGTH_K", "MAX_K", "MAXLENGTH_K", "MIN_K", "MINLENGTH_K", "NAMEDINDIVIDUAL_K", "NAMESPACE_K", "NOT_K", "OBJECTPROPERTY_K", "ONLY_K", "ONTOLOGY_K", "OR_K", "PATTERN_K", "PREFIX_K", "RANGE_K", "REFLEXIVE_K", "SAMEAS_K", "SAMEINDIVIDUAL_K", "SELF_K", "SOME_K", "STRING_K", "SUBCLASSOF_K", "SUBPROPERTYOF_K", "SUBPROPERTYCHAIN_K", "SYMMETRIC_K", "THAT_K", "TRANSITIVE_K", "TYPES_K", "VALUE_K", "GREATER", "GEQ", "LEQ", "LESS", "CHAIN", "DBL_CAP", "BLANK", "UNDERSCORE", "COLON", "COMMA", "SLASH", "LEFT_SQUARE", "RIGHT_SQUARE", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_CURLY", "RIGHT_CURLY", "Digits", "IntegerLiteral", "DecimalLiteral", "Exponent", "FloatingPointLiteral", "EscapeSequence", "QuotedString", "ALPHA", "LanguageTag", "PN_CHARS_BASE", "PN_INNER", "PN_ID", "DIGIT", "PN_NUMID", "PN_UNDSCID", "OTHER_CHARS", "EOL", "WS", "ZERO", "NONZERO", "HEXDIGIT", "UnicodeEscape", "OctalEscape", "PN_CHARS"
    };
    public static final int VT_DATA_TYPE=14;
    public static final int VT_NAME=5;
    public static final int VT_ENTITY_TYPE_INDIVIDUAL=12;
    public static final int VT_DOMAIN=53;
    public static final int VT_DIF_PROP=60;
    public static final int VT_DLA_ASYM=72;
    public static final int VT_TYPE=40;
    public static final int SUBCLASSOF_K=129;
    public static final int FLOAT_K=97;
    public static final int VT_NEG=20;
    public static final int VT_EXISTS=23;
    public static final int EOF=-1;
    public static final int NAMESPACE_K=114;
    public static final int VALUE_K=136;
    public static final int DOMAIN_K=91;
    public static final int SUBPROPERTYOF_K=130;
    public static final int OTHER_CHARS=169;
    public static final int AND_K=76;
    public static final int DIFFERENTFROM_K=88;
    public static final int GREATER=137;
    public static final int EOL=170;
    public static final int VT_SUBPROPERTYOF=50;
    public static final int VT_BLANK=64;
    public static final int VT_AND=21;
    public static final int Digits=154;
    public static final int VT_ANNOTATIONS=31;
    public static final int DIFFERENTINDIVIDUALS_K=85;
    public static final int NAMEDINDIVIDUAL_K=113;
    public static final int RANGE_K=122;
    public static final int DISJOINTPROPERTIES_K=87;
    public static final int INVERSEOF_K=104;
    public static final int LanguageTag=162;
    public static final int NOT_K=115;
    public static final int LESS=140;
    public static final int REFLEXIVE_K=123;
    public static final int VT_DL_RESTRICTED_TYPE=45;
    public static final int GEQ=138;
    public static final int VT_SUBCLASSOF=47;
    public static final int SAMEAS_K=124;
    public static final int VT_ENTITY_TYPE_DATATYPE=8;
    public static final int MINLENGTH_K=112;
    public static final int VT_OR=22;
    public static final int VT_EQV_INDV=61;
    public static final int OR_K=119;
    public static final int VT_DISJOINTUNIONOF=49;
    public static final int LENGTH_K=108;
    public static final int VT_ATTRIBUTES=16;
    public static final int PN_NUMID=167;
    public static final int VT_PREFIX=30;
    public static final int VT_TYPE_DECLARE=6;
    public static final int BLANK=143;
    public static final int UNDERSCORE=144;
    public static final int MAXLENGTH_K=110;
    public static final int VT_FORALL=24;
    public static final int ONTOLOGY_K=118;
    public static final int ALPHA=161;
    public static final int SELF_K=126;
    public static final int VT_EQUIVALENTTO=46;
    public static final int WS=171;
    public static final int VT_TYPES=39;
    public static final int OBJECTPROPERTY_K=116;
    public static final int VT_DL_RESTRICTION=44;
    public static final int FloatingPointLiteral=158;
    public static final int LEFT_CURLY=152;
    public static final int VT_FACT=37;
    public static final int SOME_K=127;
    public static final int PN_CHARS=177;
    public static final int LEFT_PAREN=150;
    public static final int VT_DL_DEFINITION=33;
    public static final int FUNCTIONAL_K=98;
    public static final int NONZERO=173;
    public static final int DECIMAL_K=84;
    public static final int PN_INNER=164;
    public static final int VT_LIST=15;
    public static final int EscapeSequence=159;
    public static final int VT_FACTS=36;
    public static final int CHAIN=141;
    public static final int IRREFLEXIVE_K=106;
    public static final int RIGHT_SQUARE=149;
    public static final int CLASS_K=81;
    public static final int ONLY_K=117;
    public static final int INVERSE_K=102;
    public static final int VT_ONTOLOGY=29;
    public static final int VT_MIN=26;
    public static final int RIGHT_CURLY=153;
    public static final int VT_ENTITY_TYPE_DATAPROP=10;
    public static final int VT_DLA_SYM=71;
    public static final int VT_IMPORT=4;
    public static final int VT_IRI=63;
    public static final int VT_FIELD=34;
    public static final int INDIVIDUAL_K=101;
    public static final int DATAPROPERTY_K=82;
    public static final int VT_DLA_IREF=70;
    public static final int Exponent=157;
    public static final int EQUIVALENTTO_K=94;
    public static final int MAX_K=109;
    public static final int DISJOINTUNIONOF_K=90;
    public static final int VT_DISJOINTWITH=48;
    public static final int QuotedString=160;
    public static final int ANNOTATIONS_K=77;
    public static final int ZERO=172;
    public static final int RIGHT_PAREN=151;
    public static final int VT_IMPLIES=19;
    public static final int TRANSITIVE_K=134;
    public static final int SLASH=147;
    public static final int ASYMMETRIC_K=79;
    public static final int COMMA=146;
    public static final int VT_DEF_NS=66;
    public static final int EQUIVALENTPROPERTIES_K=93;
    public static final int VT_SAMEAS=55;
    public static final int PREFIX_K=121;
    public static final int VT_ENTITY_TYPE_OBJPROP=9;
    public static final int VT_SELF=74;
    public static final int VT_DL_PROP=42;
    public static final int VT_VALUE=28;
    public static final int PN_ID=165;
    public static final int VT_ANON=65;
    public static final int VT_INVERSEOF=51;
    public static final int DIGIT=166;
    public static final int EXACTLY_K=95;
    public static final int TYPES_K=135;
    public static final int INTEGER_K=105;
    public static final int VT_KEYS=35;
    public static final int VT_ENTITY_TYPE_ANNPROP=11;
    public static final int VT_ANNOTATION=32;
    public static final int FACTS_K=96;
    public static final int DISJOINTWITH_K=89;
    public static final int ANNOTATIONPROPERTY_K=78;
    public static final int VT_PAREN_CHUNK=18;
    public static final int VT_DLA_FUN=67;
    public static final int VT_SUBPROPERTYCHAIN=52;
    public static final int VT_DIM_SIZE=17;
    public static final int INVERSEFUNCTIONAL_K=103;
    public static final int VT_DLA_IFUN=68;
    public static final int VT_DL_INV_PROP=43;
    public static final int DBL_CAP=142;
    public static final int VK_FACET=75;
    public static final int VT_TYPE_DECLARE_ID=13;
    public static final int VT_EQV_CLASS=57;
    public static final int VT_COUNT=25;
    public static final int SAMEINDIVIDUAL_K=125;
    public static final int PN_UNDSCID=168;
    public static final int SYMMETRIC_K=132;
    public static final int VT_DIF_INDV=62;
    public static final int VT_DIFFERENTFROM=56;
    public static final int VT_DL_TYPE=38;
    public static final int CHARACTERISTICS_K=80;
    public static final int PATTERN_K=120;
    public static final int DecimalLiteral=156;
    public static final int HASKEY_K=99;
    public static final int COLON=145;
    public static final int VT_MAX=27;
    public static final int STRING_K=128;
    public static final int EQUIVALENTCLASSES_K=92;
    public static final int PN_CHARS_BASE=163;
    public static final int SUBPROPERTYCHAIN_K=131;
    public static final int IMPORT_K=100;
    public static final int MIN_K=111;
    public static final int VT_DIF_CLASS=58;
    public static final int DATATYPE_K=83;
    public static final int UnicodeEscape=175;
    public static final int VT_RANGE=54;
    public static final int VT_MSR=41;
    public static final int LANGPATTERN_K=107;
    public static final int THAT_K=133;
    public static final int VT_EQV_PROP=59;
    public static final int IntegerLiteral=155;
    public static final int DISJOINTCLASSES_K=86;
    public static final int VT_DLA_TRN=73;
    public static final int LEFT_SQUARE=148;
    public static final int OctalEscape=176;
    public static final int VT_ENTITY_TYPE_CLASS=7;
    public static final int VT_DLA_REF=69;
    public static final int LEQ=139;
    public static final int HEXDIGIT=174;

    // delegates
    // delegators


        public ManchesterTreeBuilder(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterTreeBuilder(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ManchesterTreeBuilder.tokenNames; }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g"; }


      DLDescrFactory factory = DLDescrFactory.instance();
      DL_OntologyDescr ontoDescr = null;  



    // $ANTLR start "ontology"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:27:1: ontology returns [DL_OntologyDescr od] : ^( VT_ONTOLOGY ^( VT_NAME name= iri (version= iri )? ) ( ^( VT_PREFIX tgt= iri ns= ( VT_DEF_NS | VT_NAME ) ) )* (imp= inport )* (props= annotations )* (dec= declaration )* ( misc )* ) ;
    public final DL_OntologyDescr ontology() throws RecognitionException {
        DL_OntologyDescr od = null;

        CommonTree ns=null;
        DL_IriDescr name = null;

        DL_IriDescr version = null;

        DL_IriDescr tgt = null;

        String imp = null;

        LinkedList props = null;

        DL_aDeclarationDescr dec = null;


         od = factory.buildOntologyDescr(); this.ontoDescr = od; 
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:29:3: ( ^( VT_ONTOLOGY ^( VT_NAME name= iri (version= iri )? ) ( ^( VT_PREFIX tgt= iri ns= ( VT_DEF_NS | VT_NAME ) ) )* (imp= inport )* (props= annotations )* (dec= declaration )* ( misc )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:29:5: ^( VT_ONTOLOGY ^( VT_NAME name= iri (version= iri )? ) ( ^( VT_PREFIX tgt= iri ns= ( VT_DEF_NS | VT_NAME ) ) )* (imp= inport )* (props= annotations )* (dec= declaration )* ( misc )* )
            {
            match(input,VT_ONTOLOGY,FOLLOW_VT_ONTOLOGY_in_ontology76); 

            match(input, Token.DOWN, null); 
            match(input,VT_NAME,FOLLOW_VT_NAME_in_ontology102); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_iri_in_ontology119);
            name=iri();

            state._fsp--;

             this.ontoDescr.setName(name);
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:33:13: (version= iri )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==VT_IRI) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:33:14: version= iri
                    {
                    pushFollow(FOLLOW_iri_in_ontology148);
                    version=iri();

                    state._fsp--;

                     od.setVersion(version); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:36:11: ( ^( VT_PREFIX tgt= iri ns= ( VT_DEF_NS | VT_NAME ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==VT_PREFIX) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:36:12: ^( VT_PREFIX tgt= iri ns= ( VT_DEF_NS | VT_NAME ) )
            	    {
            	    match(input,VT_PREFIX,FOLLOW_VT_PREFIX_in_ontology211); 

            	    match(input, Token.DOWN, null); 
            	    pushFollow(FOLLOW_iri_in_ontology215);
            	    tgt=iri();

            	    state._fsp--;

            	    ns=(CommonTree)input.LT(1);
            	    if ( input.LA(1)==VT_NAME||input.LA(1)==VT_DEF_NS ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    match(input, Token.UP, null); 
            	     od.addNamespace((ns!=null?ns.getText():null),tgt.getIri()); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:40:11: (imp= inport )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==VT_IMPORT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:40:13: imp= inport
            	    {
            	    pushFollow(FOLLOW_inport_in_ontology284);
            	    imp=inport();

            	    state._fsp--;

            	    od.addImport(imp);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:42:11: (props= annotations )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==VT_ANNOTATIONS) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:42:13: props= annotations
            	    {
            	    pushFollow(FOLLOW_annotations_in_ontology317);
            	    props=annotations();

            	    state._fsp--;

            	    od.addAnnotations(props);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:44:11: (dec= declaration )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==VT_TYPE_DECLARE) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:44:13: dec= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_ontology350);
            	    dec=declaration();

            	    state._fsp--;

            	    od.addDeclaration(dec);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:46:11: ( misc )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=VT_EQV_CLASS && LA6_0<=VT_DIF_INDV)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:46:13: misc
            	    {
            	    pushFollow(FOLLOW_misc_in_ontology380);
            	    misc();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return od;
    }
    // $ANTLR end "ontology"


    // $ANTLR start "inport"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:59:1: inport returns [String ref] : ^( VT_IMPORT i= iri ) ;
    public final String inport() throws RecognitionException {
        String ref = null;

        DL_IriDescr i = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:60:3: ( ^( VT_IMPORT i= iri ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:60:5: ^( VT_IMPORT i= iri )
            {
            match(input,VT_IMPORT,FOLLOW_VT_IMPORT_in_inport441); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_iri_in_inport445);
            i=iri();

            state._fsp--;

             ref = i.getIri(); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ref;
    }
    // $ANTLR end "inport"


    // $ANTLR start "declaration"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:71:1: declaration returns [DL_aDeclarationDescr declDescr] : ( ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_CLASS ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | diu= disjointUnions | diw= disjointWiths | eqs= equivalentTos | sub= subClassOfs | key= hasKeys )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_DATATYPE ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | eqs= equivalentTos )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_OBJPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | ^( VT_ATTRIBUTES ( ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? ) )+ ) | diw= disjointWiths | eqs= equivalentTos | inv= inverseOfs | dom= domains | rng= ranges | sub= subPropertyOfs | chn= subPropertyChain )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_DATAPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | ^( VT_ATTRIBUTES ( ^( VT_DLA_FUN ) ( annotations )? ) ) | diw= disjointWiths | eqs= equivalentTos | dom= domains | rng= ranges | sub= subPropertyOfs )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_ANNPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | dom= domains | rng= ranges | sub= subPropertyOfs )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_INDIVIDUAL ^( VT_NAME i= iri ) (ann= annotations | typ= types | fac= facts | eqs= sames | dif= differs )* ) );
    public final DL_aDeclarationDescr declaration() throws RecognitionException {
        DL_aDeclarationDescr declDescr = null;

        DL_IriDescr i = null;

        LinkedList ann = null;

        LinkedList diu = null;

        LinkedList diw = null;

        LinkedList eqs = null;

        LinkedList sub = null;

        LinkedList key = null;

        LinkedList inv = null;

        LinkedList dom = null;

        LinkedList rng = null;

        LinkedList chn = null;

        LinkedList typ = null;

        LinkedList fac = null;

        LinkedList dif = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:73:3: ( ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_CLASS ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | diu= disjointUnions | diw= disjointWiths | eqs= equivalentTos | sub= subClassOfs | key= hasKeys )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_DATATYPE ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | eqs= equivalentTos )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_OBJPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | ^( VT_ATTRIBUTES ( ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? ) )+ ) | diw= disjointWiths | eqs= equivalentTos | inv= inverseOfs | dom= domains | rng= ranges | sub= subPropertyOfs | chn= subPropertyChain )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_DATAPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | ^( VT_ATTRIBUTES ( ^( VT_DLA_FUN ) ( annotations )? ) ) | diw= disjointWiths | eqs= equivalentTos | dom= domains | rng= ranges | sub= subPropertyOfs )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_ANNPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | dom= domains | rng= ranges | sub= subPropertyOfs )* ) | ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_INDIVIDUAL ^( VT_NAME i= iri ) (ann= annotations | typ= types | fac= facts | eqs= sames | dif= differs )* ) )
            int alt17=6;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==VT_TYPE_DECLARE) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case VT_ENTITY_TYPE_CLASS:
                        {
                        alt17=1;
                        }
                        break;
                    case VT_ENTITY_TYPE_DATATYPE:
                        {
                        alt17=2;
                        }
                        break;
                    case VT_ENTITY_TYPE_OBJPROP:
                        {
                        alt17=3;
                        }
                        break;
                    case VT_ENTITY_TYPE_DATAPROP:
                        {
                        alt17=4;
                        }
                        break;
                    case VT_ENTITY_TYPE_ANNPROP:
                        {
                        alt17=5;
                        }
                        break;
                    case VT_ENTITY_TYPE_INDIVIDUAL:
                        {
                        alt17=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:73:5: ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_CLASS ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | diu= disjointUnions | diw= disjointWiths | eqs= equivalentTos | sub= subClassOfs | key= hasKeys )* )
                    {
                    match(input,VT_TYPE_DECLARE,FOLLOW_VT_TYPE_DECLARE_in_declaration479); 

                    match(input, Token.DOWN, null); 
                    match(input,VT_ENTITY_TYPE_CLASS,FOLLOW_VT_ENTITY_TYPE_CLASS_in_declaration491); 
                     DL_ClassDescr descr = factory.buildClassDescr(); 
                    match(input,VT_TYPE_DECLARE_ID,FOLLOW_VT_TYPE_DECLARE_ID_in_declaration507); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_declaration511);
                    i=iri();

                    state._fsp--;

                     descr.setIri(i); 

                    match(input, Token.UP, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:77:10: (ann= annotations | diu= disjointUnions | diw= disjointWiths | eqs= equivalentTos | sub= subClassOfs | key= hasKeys )*
                    loop7:
                    do {
                        int alt7=7;
                        switch ( input.LA(1) ) {
                        case VT_ANNOTATIONS:
                            {
                            alt7=1;
                            }
                            break;
                        case VT_DISJOINTUNIONOF:
                            {
                            alt7=2;
                            }
                            break;
                        case VT_DISJOINTWITH:
                            {
                            alt7=3;
                            }
                            break;
                        case VT_EQUIVALENTTO:
                            {
                            alt7=4;
                            }
                            break;
                        case VT_SUBCLASSOF:
                            {
                            alt7=5;
                            }
                            break;
                        case VT_KEYS:
                            {
                            alt7=6;
                            }
                            break;

                        }

                        switch (alt7) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:77:12: ann= annotations
                    	    {
                    	    pushFollow(FOLLOW_annotations_in_declaration544);
                    	    ann=annotations();

                    	    state._fsp--;

                    	     descr.addAnnotations(ann); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:78:14: diu= disjointUnions
                    	    {
                    	    pushFollow(FOLLOW_disjointUnions_in_declaration563);
                    	    diu=disjointUnions();

                    	    state._fsp--;

                    	     descr.addAllDisjointUnion(diu); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:79:14: diw= disjointWiths
                    	    {
                    	    pushFollow(FOLLOW_disjointWiths_in_declaration582);
                    	    diw=disjointWiths();

                    	    state._fsp--;

                    	     descr.addAllDisjointWith(diw); 

                    	    }
                    	    break;
                    	case 4 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:80:14: eqs= equivalentTos
                    	    {
                    	    pushFollow(FOLLOW_equivalentTos_in_declaration601);
                    	    eqs=equivalentTos();

                    	    state._fsp--;

                    	     descr.addAllEquivalentTo(eqs); 

                    	    }
                    	    break;
                    	case 5 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:81:14: sub= subClassOfs
                    	    {
                    	    pushFollow(FOLLOW_subClassOfs_in_declaration620);
                    	    sub=subClassOfs();

                    	    state._fsp--;

                    	     descr.addAllSubClassOf(sub); 

                    	    }
                    	    break;
                    	case 6 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:82:14: key= hasKeys
                    	    {
                    	    pushFollow(FOLLOW_hasKeys_in_declaration639);
                    	    key=hasKeys();

                    	    state._fsp--;

                    	     descr.addAllHasKey(key); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    match(input, Token.UP, null); 
                     declDescr = descr; 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:87:5: ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_DATATYPE ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | eqs= equivalentTos )* )
                    {
                    match(input,VT_TYPE_DECLARE,FOLLOW_VT_TYPE_DECLARE_in_declaration750); 

                    match(input, Token.DOWN, null); 
                    match(input,VT_ENTITY_TYPE_DATATYPE,FOLLOW_VT_ENTITY_TYPE_DATATYPE_in_declaration762); 
                     DL_DatatypeDescr descr = factory.buildDatatypeDescr(); 
                    match(input,VT_TYPE_DECLARE_ID,FOLLOW_VT_TYPE_DECLARE_ID_in_declaration779); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_declaration783);
                    i=iri();

                    state._fsp--;

                     descr.setIri(i); 

                    match(input, Token.UP, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:91:10: (ann= annotations | eqs= equivalentTos )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==VT_ANNOTATIONS) ) {
                            alt8=1;
                        }
                        else if ( (LA8_0==VT_EQUIVALENTTO) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:91:12: ann= annotations
                    	    {
                    	    pushFollow(FOLLOW_annotations_in_declaration814);
                    	    ann=annotations();

                    	    state._fsp--;

                    	     descr.addAnnotations(ann); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:92:14: eqs= equivalentTos
                    	    {
                    	    pushFollow(FOLLOW_equivalentTos_in_declaration844);
                    	    eqs=equivalentTos();

                    	    state._fsp--;

                    	     descr.addAllEquivalentTo(eqs); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    match(input, Token.UP, null); 
                     declDescr = descr; 

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:97:5: ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_OBJPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | ^( VT_ATTRIBUTES ( ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? ) )+ ) | diw= disjointWiths | eqs= equivalentTos | inv= inverseOfs | dom= domains | rng= ranges | sub= subPropertyOfs | chn= subPropertyChain )* )
                    {
                    match(input,VT_TYPE_DECLARE,FOLLOW_VT_TYPE_DECLARE_in_declaration1037); 

                    match(input, Token.DOWN, null); 
                    match(input,VT_ENTITY_TYPE_OBJPROP,FOLLOW_VT_ENTITY_TYPE_OBJPROP_in_declaration1049); 
                     DL_ObjectPropertyDescr descr = factory.buildObjectPropertyDescr(); 
                    match(input,VT_TYPE_DECLARE_ID,FOLLOW_VT_TYPE_DECLARE_ID_in_declaration1066); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_declaration1070);
                    i=iri();

                    state._fsp--;

                     descr.setIri(i); 

                    match(input, Token.UP, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:101:10: (ann= annotations | ^( VT_ATTRIBUTES ( ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? ) )+ ) | diw= disjointWiths | eqs= equivalentTos | inv= inverseOfs | dom= domains | rng= ranges | sub= subPropertyOfs | chn= subPropertyChain )*
                    loop12:
                    do {
                        int alt12=10;
                        switch ( input.LA(1) ) {
                        case VT_ANNOTATIONS:
                            {
                            alt12=1;
                            }
                            break;
                        case VT_ATTRIBUTES:
                            {
                            alt12=2;
                            }
                            break;
                        case VT_DISJOINTWITH:
                            {
                            alt12=3;
                            }
                            break;
                        case VT_EQUIVALENTTO:
                            {
                            alt12=4;
                            }
                            break;
                        case VT_INVERSEOF:
                            {
                            alt12=5;
                            }
                            break;
                        case VT_DOMAIN:
                            {
                            alt12=6;
                            }
                            break;
                        case VT_RANGE:
                            {
                            alt12=7;
                            }
                            break;
                        case VT_SUBPROPERTYOF:
                            {
                            alt12=8;
                            }
                            break;
                        case VT_SUBPROPERTYCHAIN:
                            {
                            alt12=9;
                            }
                            break;

                        }

                        switch (alt12) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:101:12: ann= annotations
                    	    {
                    	    pushFollow(FOLLOW_annotations_in_declaration1102);
                    	    ann=annotations();

                    	    state._fsp--;

                    	     descr.addAnnotations(ann); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:103:14: ^( VT_ATTRIBUTES ( ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? ) )+ )
                    	    {
                    	    match(input,VT_ATTRIBUTES,FOLLOW_VT_ATTRIBUTES_in_declaration1130); 

                    	    match(input, Token.DOWN, null); 
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:104:17: ( ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? ) )+
                    	    int cnt11=0;
                    	    loop11:
                    	    do {
                    	        int alt11=2;
                    	        int LA11_0 = input.LA(1);

                    	        if ( ((LA11_0>=VT_DLA_FUN && LA11_0<=VT_DLA_TRN)) ) {
                    	            alt11=1;
                    	        }


                    	        switch (alt11) {
                    	    	case 1 :
                    	    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:104:18: ^( ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN ) ( annotations )? )
                    	    	    {
                    	    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:104:20: ( VT_DLA_FUN | VT_DLA_IFUN | VT_DLA_REF | VT_DLA_IREF | VT_DLA_SYM | VT_DLA_ASYM | VT_DLA_TRN )
                    	    	    int alt9=7;
                    	    	    switch ( input.LA(1) ) {
                    	    	    case VT_DLA_FUN:
                    	    	        {
                    	    	        alt9=1;
                    	    	        }
                    	    	        break;
                    	    	    case VT_DLA_IFUN:
                    	    	        {
                    	    	        alt9=2;
                    	    	        }
                    	    	        break;
                    	    	    case VT_DLA_REF:
                    	    	        {
                    	    	        alt9=3;
                    	    	        }
                    	    	        break;
                    	    	    case VT_DLA_IREF:
                    	    	        {
                    	    	        alt9=4;
                    	    	        }
                    	    	        break;
                    	    	    case VT_DLA_SYM:
                    	    	        {
                    	    	        alt9=5;
                    	    	        }
                    	    	        break;
                    	    	    case VT_DLA_ASYM:
                    	    	        {
                    	    	        alt9=6;
                    	    	        }
                    	    	        break;
                    	    	    case VT_DLA_TRN:
                    	    	        {
                    	    	        alt9=7;
                    	    	        }
                    	    	        break;
                    	    	    default:
                    	    	        NoViableAltException nvae =
                    	    	            new NoViableAltException("", 9, 0, input);

                    	    	        throw nvae;
                    	    	    }

                    	    	    switch (alt9) {
                    	    	        case 1 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:105:21: VT_DLA_FUN
                    	    	            {
                    	    	            match(input,VT_DLA_FUN,FOLLOW_VT_DLA_FUN_in_declaration1173); 
                    	    	             descr.setFunctional(true); 

                    	    	            }
                    	    	            break;
                    	    	        case 2 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:106:23: VT_DLA_IFUN
                    	    	            {
                    	    	            match(input,VT_DLA_IFUN,FOLLOW_VT_DLA_IFUN_in_declaration1199); 
                    	    	             descr.setInverseFunctional(true); 

                    	    	            }
                    	    	            break;
                    	    	        case 3 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:107:23: VT_DLA_REF
                    	    	            {
                    	    	            match(input,VT_DLA_REF,FOLLOW_VT_DLA_REF_in_declaration1229); 
                    	    	             descr.setReflexive(true); 

                    	    	            }
                    	    	            break;
                    	    	        case 4 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:108:23: VT_DLA_IREF
                    	    	            {
                    	    	            match(input,VT_DLA_IREF,FOLLOW_VT_DLA_IREF_in_declaration1255); 
                    	    	             descr.setIrreflexive(true); 

                    	    	            }
                    	    	            break;
                    	    	        case 5 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:109:23: VT_DLA_SYM
                    	    	            {
                    	    	            match(input,VT_DLA_SYM,FOLLOW_VT_DLA_SYM_in_declaration1281); 
                    	    	             descr.setSymmetric(true); 

                    	    	            }
                    	    	            break;
                    	    	        case 6 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:110:23: VT_DLA_ASYM
                    	    	            {
                    	    	            match(input,VT_DLA_ASYM,FOLLOW_VT_DLA_ASYM_in_declaration1307); 
                    	    	             descr.setAsymmetric(true); 

                    	    	            }
                    	    	            break;
                    	    	        case 7 :
                    	    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:111:23: VT_DLA_TRN
                    	    	            {
                    	    	            match(input,VT_DLA_TRN,FOLLOW_VT_DLA_TRN_in_declaration1333); 
                    	    	             descr.setTransitive(true); 

                    	    	            }
                    	    	            break;

                    	    	    }


                    	    	    if ( input.LA(1)==Token.DOWN ) {
                    	    	        match(input, Token.DOWN, null); 
                    	    	        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:113:18: ( annotations )?
                    	    	        int alt10=2;
                    	    	        int LA10_0 = input.LA(1);

                    	    	        if ( (LA10_0==VT_ANNOTATIONS) ) {
                    	    	            alt10=1;
                    	    	        }
                    	    	        switch (alt10) {
                    	    	            case 1 :
                    	    	                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:113:18: annotations
                    	    	                {
                    	    	                pushFollow(FOLLOW_annotations_in_declaration1397);
                    	    	                annotations();

                    	    	                state._fsp--;


                    	    	                }
                    	    	                break;

                    	    	        }


                    	    	        match(input, Token.UP, null); 
                    	    	    }

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt11 >= 1 ) break loop11;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(11, input);
                    	                throw eee;
                    	        }
                    	        cnt11++;
                    	    } while (true);


                    	    match(input, Token.UP, null); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:115:14: diw= disjointWiths
                    	    {
                    	    pushFollow(FOLLOW_disjointWiths_in_declaration1438);
                    	    diw=disjointWiths();

                    	    state._fsp--;

                    	     descr.addAllDisjointWith(diw); 

                    	    }
                    	    break;
                    	case 4 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:116:14: eqs= equivalentTos
                    	    {
                    	    pushFollow(FOLLOW_equivalentTos_in_declaration1457);
                    	    eqs=equivalentTos();

                    	    state._fsp--;

                    	     descr.addAllEquivalentTo(eqs); 

                    	    }
                    	    break;
                    	case 5 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:117:14: inv= inverseOfs
                    	    {
                    	    pushFollow(FOLLOW_inverseOfs_in_declaration1476);
                    	    inv=inverseOfs();

                    	    state._fsp--;

                    	     descr.addAllInverseOf(inv); 

                    	    }
                    	    break;
                    	case 6 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:118:14: dom= domains
                    	    {
                    	    pushFollow(FOLLOW_domains_in_declaration1495);
                    	    dom=domains();

                    	    state._fsp--;

                    	     descr.addAllDomain(dom); 

                    	    }
                    	    break;
                    	case 7 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:119:14: rng= ranges
                    	    {
                    	    pushFollow(FOLLOW_ranges_in_declaration1515);
                    	    rng=ranges();

                    	    state._fsp--;

                    	     descr.addAllRange(rng); 

                    	    }
                    	    break;
                    	case 8 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:120:14: sub= subPropertyOfs
                    	    {
                    	    pushFollow(FOLLOW_subPropertyOfs_in_declaration1534);
                    	    sub=subPropertyOfs();

                    	    state._fsp--;

                    	     descr.addAllSubPropertyOf(sub); 

                    	    }
                    	    break;
                    	case 9 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:121:14: chn= subPropertyChain
                    	    {
                    	    pushFollow(FOLLOW_subPropertyChain_in_declaration1553);
                    	    chn=subPropertyChain();

                    	    state._fsp--;

                    	     descr.addSubPropertyChain(chn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    match(input, Token.UP, null); 
                     declDescr = descr; 

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:126:5: ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_DATAPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | ^( VT_ATTRIBUTES ( ^( VT_DLA_FUN ) ( annotations )? ) ) | diw= disjointWiths | eqs= equivalentTos | dom= domains | rng= ranges | sub= subPropertyOfs )* )
                    {
                    match(input,VT_TYPE_DECLARE,FOLLOW_VT_TYPE_DECLARE_in_declaration1678); 

                    match(input, Token.DOWN, null); 
                    match(input,VT_ENTITY_TYPE_DATAPROP,FOLLOW_VT_ENTITY_TYPE_DATAPROP_in_declaration1690); 
                     DL_DataPropertyDescr descr = factory.buildDataPropertyDescr(); 
                    match(input,VT_TYPE_DECLARE_ID,FOLLOW_VT_TYPE_DECLARE_ID_in_declaration1707); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_declaration1711);
                    i=iri();

                    state._fsp--;

                     descr.setIri(i); 

                    match(input, Token.UP, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:130:11: (ann= annotations | ^( VT_ATTRIBUTES ( ^( VT_DLA_FUN ) ( annotations )? ) ) | diw= disjointWiths | eqs= equivalentTos | dom= domains | rng= ranges | sub= subPropertyOfs )*
                    loop14:
                    do {
                        int alt14=8;
                        switch ( input.LA(1) ) {
                        case VT_ANNOTATIONS:
                            {
                            alt14=1;
                            }
                            break;
                        case VT_ATTRIBUTES:
                            {
                            alt14=2;
                            }
                            break;
                        case VT_DISJOINTWITH:
                            {
                            alt14=3;
                            }
                            break;
                        case VT_EQUIVALENTTO:
                            {
                            alt14=4;
                            }
                            break;
                        case VT_DOMAIN:
                            {
                            alt14=5;
                            }
                            break;
                        case VT_RANGE:
                            {
                            alt14=6;
                            }
                            break;
                        case VT_SUBPROPERTYOF:
                            {
                            alt14=7;
                            }
                            break;

                        }

                        switch (alt14) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:130:13: ann= annotations
                    	    {
                    	    pushFollow(FOLLOW_annotations_in_declaration1753);
                    	    ann=annotations();

                    	    state._fsp--;

                    	     descr.addAnnotations(ann); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:131:14: ^( VT_ATTRIBUTES ( ^( VT_DLA_FUN ) ( annotations )? ) )
                    	    {
                    	    match(input,VT_ATTRIBUTES,FOLLOW_VT_ATTRIBUTES_in_declaration1771); 

                    	    match(input, Token.DOWN, null); 
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:132:17: ( ^( VT_DLA_FUN ) ( annotations )? )
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:132:18: ^( VT_DLA_FUN ) ( annotations )?
                    	    {
                    	    match(input,VT_DLA_FUN,FOLLOW_VT_DLA_FUN_in_declaration1792); 

                    	     descr.setFunctional(true); 

                    	    if ( input.LA(1)==Token.DOWN ) {
                    	        match(input, Token.DOWN, null); 
                    	        match(input, Token.UP, null); 
                    	    }
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:132:63: ( annotations )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( (LA13_0==VT_ANNOTATIONS) ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:132:63: annotations
                    	            {
                    	            pushFollow(FOLLOW_annotations_in_declaration1797);
                    	            annotations();

                    	            state._fsp--;


                    	            }
                    	            break;

                    	    }


                    	    }


                    	    match(input, Token.UP, null); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:134:14: diw= disjointWiths
                    	    {
                    	    pushFollow(FOLLOW_disjointWiths_in_declaration1834);
                    	    diw=disjointWiths();

                    	    state._fsp--;

                    	     descr.addAllDisjointWith(diw); 

                    	    }
                    	    break;
                    	case 4 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:135:14: eqs= equivalentTos
                    	    {
                    	    pushFollow(FOLLOW_equivalentTos_in_declaration1853);
                    	    eqs=equivalentTos();

                    	    state._fsp--;

                    	     descr.addAllEquivalentTo(eqs); 

                    	    }
                    	    break;
                    	case 5 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:136:14: dom= domains
                    	    {
                    	    pushFollow(FOLLOW_domains_in_declaration1883);
                    	    dom=domains();

                    	    state._fsp--;

                    	     descr.addAllDomain(dom); 

                    	    }
                    	    break;
                    	case 6 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:137:14: rng= ranges
                    	    {
                    	    pushFollow(FOLLOW_ranges_in_declaration1903);
                    	    rng=ranges();

                    	    state._fsp--;

                    	     descr.addAllRange(rng); 

                    	    }
                    	    break;
                    	case 7 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:138:14: sub= subPropertyOfs
                    	    {
                    	    pushFollow(FOLLOW_subPropertyOfs_in_declaration1922);
                    	    sub=subPropertyOfs();

                    	    state._fsp--;

                    	     descr.addAllSubPropertyOf(sub); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    match(input, Token.UP, null); 
                     declDescr = descr; 

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:143:5: ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_ANNPROP ^( VT_TYPE_DECLARE_ID i= iri ) (ann= annotations | dom= domains | rng= ranges | sub= subPropertyOfs )* )
                    {
                    match(input,VT_TYPE_DECLARE,FOLLOW_VT_TYPE_DECLARE_in_declaration2064); 

                    match(input, Token.DOWN, null); 
                    match(input,VT_ENTITY_TYPE_ANNPROP,FOLLOW_VT_ENTITY_TYPE_ANNPROP_in_declaration2076); 
                     DL_AnnotationPropertyDescr descr = factory.buildAnnotationPropertyDescr(); 
                    match(input,VT_TYPE_DECLARE_ID,FOLLOW_VT_TYPE_DECLARE_ID_in_declaration2093); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_declaration2097);
                    i=iri();

                    state._fsp--;

                     descr.setIri(i); 

                    match(input, Token.UP, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:147:10: (ann= annotations | dom= domains | rng= ranges | sub= subPropertyOfs )*
                    loop15:
                    do {
                        int alt15=5;
                        switch ( input.LA(1) ) {
                        case VT_ANNOTATIONS:
                            {
                            alt15=1;
                            }
                            break;
                        case VT_DOMAIN:
                            {
                            alt15=2;
                            }
                            break;
                        case VT_RANGE:
                            {
                            alt15=3;
                            }
                            break;
                        case VT_SUBPROPERTYOF:
                            {
                            alt15=4;
                            }
                            break;

                        }

                        switch (alt15) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:147:12: ann= annotations
                    	    {
                    	    pushFollow(FOLLOW_annotations_in_declaration2127);
                    	    ann=annotations();

                    	    state._fsp--;

                    	     descr.addAnnotations(ann); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:148:14: dom= domains
                    	    {
                    	    pushFollow(FOLLOW_domains_in_declaration2167);
                    	    dom=domains();

                    	    state._fsp--;

                    	     descr.addAllDomain(dom); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:149:14: rng= ranges
                    	    {
                    	    pushFollow(FOLLOW_ranges_in_declaration2187);
                    	    rng=ranges();

                    	    state._fsp--;

                    	     descr.addAllRange(rng); 

                    	    }
                    	    break;
                    	case 4 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:150:14: sub= subPropertyOfs
                    	    {
                    	    pushFollow(FOLLOW_subPropertyOfs_in_declaration2206);
                    	    sub=subPropertyOfs();

                    	    state._fsp--;

                    	     descr.addAllSubPropertyOf(sub); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    match(input, Token.UP, null); 
                     declDescr = descr; 

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:155:5: ^( VT_TYPE_DECLARE VT_ENTITY_TYPE_INDIVIDUAL ^( VT_NAME i= iri ) (ann= annotations | typ= types | fac= facts | eqs= sames | dif= differs )* )
                    {
                    match(input,VT_TYPE_DECLARE,FOLLOW_VT_TYPE_DECLARE_in_declaration2336); 

                    match(input, Token.DOWN, null); 
                    match(input,VT_ENTITY_TYPE_INDIVIDUAL,FOLLOW_VT_ENTITY_TYPE_INDIVIDUAL_in_declaration2348); 
                     DL_IndividualDescr descr = factory.buildIndividualDescr(); 
                    match(input,VT_NAME,FOLLOW_VT_NAME_in_declaration2365); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_declaration2369);
                    i=iri();

                    state._fsp--;

                     descr.setIri(i); 

                    match(input, Token.UP, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:159:10: (ann= annotations | typ= types | fac= facts | eqs= sames | dif= differs )*
                    loop16:
                    do {
                        int alt16=6;
                        switch ( input.LA(1) ) {
                        case VT_ANNOTATIONS:
                            {
                            alt16=1;
                            }
                            break;
                        case VT_TYPES:
                            {
                            alt16=2;
                            }
                            break;
                        case VT_FACTS:
                            {
                            alt16=3;
                            }
                            break;
                        case VT_SAMEAS:
                            {
                            alt16=4;
                            }
                            break;
                        case VT_DIFFERENTFROM:
                            {
                            alt16=5;
                            }
                            break;

                        }

                        switch (alt16) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:159:12: ann= annotations
                    	    {
                    	    pushFollow(FOLLOW_annotations_in_declaration2406);
                    	    ann=annotations();

                    	    state._fsp--;

                    	     descr.addAnnotations(ann); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:160:14: typ= types
                    	    {
                    	    pushFollow(FOLLOW_types_in_declaration2446);
                    	    typ=types();

                    	    state._fsp--;

                    	     descr.addAllType(typ); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:161:14: fac= facts
                    	    {
                    	    pushFollow(FOLLOW_facts_in_declaration2466);
                    	    fac=facts();

                    	    state._fsp--;

                    	     descr.addAllFact(fac); 

                    	    }
                    	    break;
                    	case 4 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:162:14: eqs= sames
                    	    {
                    	    pushFollow(FOLLOW_sames_in_declaration2485);
                    	    eqs=sames();

                    	    state._fsp--;

                    	     descr.addAllSameAs(eqs); 

                    	    }
                    	    break;
                    	case 5 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:163:14: dif= differs
                    	    {
                    	    pushFollow(FOLLOW_differs_in_declaration2504);
                    	    dif=differs();

                    	    state._fsp--;

                    	     descr.addAllDifferentFrom(dif); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    match(input, Token.UP, null); 
                     declDescr = descr; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return declDescr;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "disjointUnions"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:175:1: disjointUnions returns [LinkedList diuList] : ^( VT_DISJOINTUNIONOF ( annotations )? (d= definition )* ) ;
    public final LinkedList disjointUnions() throws RecognitionException {
        LinkedList diuList = null;

        DL_DefinitionDescr d = null;


        diuList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:177:3: ( ^( VT_DISJOINTUNIONOF ( annotations )? (d= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:177:5: ^( VT_DISJOINTUNIONOF ( annotations )? (d= definition )* )
            {
            match(input,VT_DISJOINTUNIONOF,FOLLOW_VT_DISJOINTUNIONOF_in_disjointUnions2822); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:177:28: ( annotations )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==VT_ANNOTATIONS) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:177:28: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_disjointUnions2824);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:178:9: (d= definition )*
                loop19:
                do {
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==VT_DL_DEFINITION) ) {
                        alt19=1;
                    }


                    switch (alt19) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:178:11: d= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_disjointUnions2846);
                	    d=definition();

                	    state._fsp--;

                	    diuList.add(d);

                	    }
                	    break;

                	default :
                	    break loop19;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return diuList;
    }
    // $ANTLR end "disjointUnions"


    // $ANTLR start "disjointWiths"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:183:1: disjointWiths returns [LinkedList diwList] : ^( VT_DISJOINTWITH ( annotations )? (d= definition )* ) ;
    public final LinkedList disjointWiths() throws RecognitionException {
        LinkedList diwList = null;

        DL_DefinitionDescr d = null;


        diwList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:185:3: ( ^( VT_DISJOINTWITH ( annotations )? (d= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:185:5: ^( VT_DISJOINTWITH ( annotations )? (d= definition )* )
            {
            match(input,VT_DISJOINTWITH,FOLLOW_VT_DISJOINTWITH_in_disjointWiths2887); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:185:25: ( annotations )?
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==VT_ANNOTATIONS) ) {
                    alt20=1;
                }
                switch (alt20) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:185:25: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_disjointWiths2889);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:186:9: (d= definition )*
                loop21:
                do {
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==VT_DL_DEFINITION) ) {
                        alt21=1;
                    }


                    switch (alt21) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:186:11: d= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_disjointWiths2910);
                	    d=definition();

                	    state._fsp--;

                	    diwList.add(d);

                	    }
                	    break;

                	default :
                	    break loop21;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return diwList;
    }
    // $ANTLR end "disjointWiths"


    // $ANTLR start "equivalentTos"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:190:1: equivalentTos returns [LinkedList eqsList] : ^( VT_EQUIVALENTTO ( annotations )? (e= definition )* ) ;
    public final LinkedList equivalentTos() throws RecognitionException {
        LinkedList eqsList = null;

        DL_DefinitionDescr e = null;


        eqsList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:192:3: ( ^( VT_EQUIVALENTTO ( annotations )? (e= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:192:5: ^( VT_EQUIVALENTTO ( annotations )? (e= definition )* )
            {
            match(input,VT_EQUIVALENTTO,FOLLOW_VT_EQUIVALENTTO_in_equivalentTos2950); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:192:25: ( annotations )?
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==VT_ANNOTATIONS) ) {
                    alt22=1;
                }
                switch (alt22) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:192:25: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_equivalentTos2952);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:193:9: (e= definition )*
                loop23:
                do {
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==VT_DL_DEFINITION) ) {
                        alt23=1;
                    }


                    switch (alt23) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:193:11: e= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_equivalentTos2973);
                	    e=definition();

                	    state._fsp--;

                	    eqsList.add(e);

                	    }
                	    break;

                	default :
                	    break loop23;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return eqsList;
    }
    // $ANTLR end "equivalentTos"


    // $ANTLR start "subClassOfs"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:197:1: subClassOfs returns [LinkedList subList] : ^( VT_SUBCLASSOF ( annotations )? (s= definition )* ) ;
    public final LinkedList subClassOfs() throws RecognitionException {
        LinkedList subList = null;

        DL_DefinitionDescr s = null;


        subList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:199:3: ( ^( VT_SUBCLASSOF ( annotations )? (s= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:199:5: ^( VT_SUBCLASSOF ( annotations )? (s= definition )* )
            {
            match(input,VT_SUBCLASSOF,FOLLOW_VT_SUBCLASSOF_in_subClassOfs3013); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:199:23: ( annotations )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==VT_ANNOTATIONS) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:199:23: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_subClassOfs3015);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:200:9: (s= definition )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==VT_DL_DEFINITION) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:200:11: s= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_subClassOfs3037);
                	    s=definition();

                	    state._fsp--;

                	    subList.add(s);

                	    }
                	    break;

                	default :
                	    break loop25;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subList;
    }
    // $ANTLR end "subClassOfs"


    // $ANTLR start "hasKeys"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:205:1: hasKeys returns [LinkedList keyList] : ^( VT_KEYS ( annotations )? (k= relation )* ) ;
    public final LinkedList hasKeys() throws RecognitionException {
        LinkedList keyList = null;

        DL_RelationDescr k = null;


        keyList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:207:3: ( ^( VT_KEYS ( annotations )? (k= relation )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:207:5: ^( VT_KEYS ( annotations )? (k= relation )* )
            {
            match(input,VT_KEYS,FOLLOW_VT_KEYS_in_hasKeys3078); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:207:17: ( annotations )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==VT_ANNOTATIONS) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:207:17: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_hasKeys3080);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:208:9: (k= relation )*
                loop27:
                do {
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( ((LA27_0>=VT_DL_PROP && LA27_0<=VT_DL_INV_PROP)) ) {
                        alt27=1;
                    }


                    switch (alt27) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:208:11: k= relation
                	    {
                	    pushFollow(FOLLOW_relation_in_hasKeys3095);
                	    k=relation();

                	    state._fsp--;

                	    keyList.add(k);

                	    }
                	    break;

                	default :
                	    break loop27;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return keyList;
    }
    // $ANTLR end "hasKeys"


    // $ANTLR start "domains"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:213:1: domains returns [LinkedList domList] : ^( VT_DOMAIN (d= definition )* ) ;
    public final LinkedList domains() throws RecognitionException {
        LinkedList domList = null;

        DL_DefinitionDescr d = null;


        domList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:215:3: ( ^( VT_DOMAIN (d= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:215:5: ^( VT_DOMAIN (d= definition )* )
            {
            match(input,VT_DOMAIN,FOLLOW_VT_DOMAIN_in_domains3136); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:216:9: (d= definition )*
                loop28:
                do {
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==VT_DL_DEFINITION) ) {
                        alt28=1;
                    }


                    switch (alt28) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:216:11: d= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_domains3157);
                	    d=definition();

                	    state._fsp--;

                	    domList.add(d);

                	    }
                	    break;

                	default :
                	    break loop28;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return domList;
    }
    // $ANTLR end "domains"


    // $ANTLR start "ranges"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:221:1: ranges returns [LinkedList rngList] : ^( VT_RANGE ( annotations )? (d= definition )* ) ;
    public final LinkedList ranges() throws RecognitionException {
        LinkedList rngList = null;

        DL_DefinitionDescr d = null;


        rngList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:223:3: ( ^( VT_RANGE ( annotations )? (d= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:223:5: ^( VT_RANGE ( annotations )? (d= definition )* )
            {
            match(input,VT_RANGE,FOLLOW_VT_RANGE_in_ranges3198); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:223:18: ( annotations )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==VT_ANNOTATIONS) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:223:18: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_ranges3200);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:224:9: (d= definition )*
                loop30:
                do {
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==VT_DL_DEFINITION) ) {
                        alt30=1;
                    }


                    switch (alt30) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:224:11: d= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_ranges3221);
                	    d=definition();

                	    state._fsp--;

                	    rngList.add(d);

                	    }
                	    break;

                	default :
                	    break loop30;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rngList;
    }
    // $ANTLR end "ranges"


    // $ANTLR start "subPropertyOfs"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:228:1: subPropertyOfs returns [LinkedList subList] : ^( VT_SUBPROPERTYOF ( annotations )? (r= relation )* ) ;
    public final LinkedList subPropertyOfs() throws RecognitionException {
        LinkedList subList = null;

        DL_RelationDescr r = null;


        subList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:230:3: ( ^( VT_SUBPROPERTYOF ( annotations )? (r= relation )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:230:5: ^( VT_SUBPROPERTYOF ( annotations )? (r= relation )* )
            {
            match(input,VT_SUBPROPERTYOF,FOLLOW_VT_SUBPROPERTYOF_in_subPropertyOfs3261); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:230:26: ( annotations )?
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==VT_ANNOTATIONS) ) {
                    alt31=1;
                }
                switch (alt31) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:230:26: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_subPropertyOfs3263);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:231:9: (r= relation )*
                loop32:
                do {
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=VT_DL_PROP && LA32_0<=VT_DL_INV_PROP)) ) {
                        alt32=1;
                    }


                    switch (alt32) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:231:11: r= relation
                	    {
                	    pushFollow(FOLLOW_relation_in_subPropertyOfs3284);
                	    r=relation();

                	    state._fsp--;

                	    subList.add(r);

                	    }
                	    break;

                	default :
                	    break loop32;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subList;
    }
    // $ANTLR end "subPropertyOfs"


    // $ANTLR start "inverseOfs"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:235:1: inverseOfs returns [LinkedList invList] : ^( VT_INVERSEOF ( annotations )? (r= relation )* ) ;
    public final LinkedList inverseOfs() throws RecognitionException {
        LinkedList invList = null;

        DL_RelationDescr r = null;


        invList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:237:3: ( ^( VT_INVERSEOF ( annotations )? (r= relation )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:237:5: ^( VT_INVERSEOF ( annotations )? (r= relation )* )
            {
            match(input,VT_INVERSEOF,FOLLOW_VT_INVERSEOF_in_inverseOfs3324); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:237:22: ( annotations )?
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==VT_ANNOTATIONS) ) {
                    alt33=1;
                }
                switch (alt33) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:237:22: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_inverseOfs3326);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:238:9: (r= relation )*
                loop34:
                do {
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=VT_DL_PROP && LA34_0<=VT_DL_INV_PROP)) ) {
                        alt34=1;
                    }


                    switch (alt34) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:238:11: r= relation
                	    {
                	    pushFollow(FOLLOW_relation_in_inverseOfs3347);
                	    r=relation();

                	    state._fsp--;

                	    invList.add(r);

                	    }
                	    break;

                	default :
                	    break loop34;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return invList;
    }
    // $ANTLR end "inverseOfs"


    // $ANTLR start "subPropertyChain"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:242:1: subPropertyChain returns [LinkedList chnList] : ^( VT_SUBPROPERTYCHAIN ( annotations )? (r= relation )* ) ;
    public final LinkedList subPropertyChain() throws RecognitionException {
        LinkedList chnList = null;

        DL_RelationDescr r = null;


        chnList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:244:3: ( ^( VT_SUBPROPERTYCHAIN ( annotations )? (r= relation )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:244:5: ^( VT_SUBPROPERTYCHAIN ( annotations )? (r= relation )* )
            {
            match(input,VT_SUBPROPERTYCHAIN,FOLLOW_VT_SUBPROPERTYCHAIN_in_subPropertyChain3387); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:244:29: ( annotations )?
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==VT_ANNOTATIONS) ) {
                    alt35=1;
                }
                switch (alt35) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:244:29: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_subPropertyChain3389);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:245:9: (r= relation )*
                loop36:
                do {
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=VT_DL_PROP && LA36_0<=VT_DL_INV_PROP)) ) {
                        alt36=1;
                    }


                    switch (alt36) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:245:11: r= relation
                	    {
                	    pushFollow(FOLLOW_relation_in_subPropertyChain3407);
                	    r=relation();

                	    state._fsp--;

                	    chnList.add(r);

                	    }
                	    break;

                	default :
                	    break loop36;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return chnList;
    }
    // $ANTLR end "subPropertyChain"


    // $ANTLR start "types"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:250:1: types returns [LinkedList typList] : ^( VT_TYPES ( annotations )? (d= definition )* ) ;
    public final LinkedList types() throws RecognitionException {
        LinkedList typList = null;

        DL_DefinitionDescr d = null;


        typList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:252:3: ( ^( VT_TYPES ( annotations )? (d= definition )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:252:5: ^( VT_TYPES ( annotations )? (d= definition )* )
            {
            match(input,VT_TYPES,FOLLOW_VT_TYPES_in_types3448); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:252:18: ( annotations )?
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==VT_ANNOTATIONS) ) {
                    alt37=1;
                }
                switch (alt37) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:252:18: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_types3450);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:253:9: (d= definition )*
                loop38:
                do {
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==VT_DL_DEFINITION) ) {
                        alt38=1;
                    }


                    switch (alt38) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:253:12: d= definition
                	    {
                	    pushFollow(FOLLOW_definition_in_types3469);
                	    d=definition();

                	    state._fsp--;

                	    typList.add(d);

                	    }
                	    break;

                	default :
                	    break loop38;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return typList;
    }
    // $ANTLR end "types"


    // $ANTLR start "facts"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:257:1: facts returns [LinkedList facList] : ^( VT_FACTS ( annotations )? ( ^( VT_FACT r= relation e= entity ) | ^( VT_NEG ^( VT_FACT relation entity ) ) )* ) ;
    public final LinkedList facts() throws RecognitionException {
        LinkedList facList = null;

        DL_RelationDescr r = null;

        Object e = null;


        facList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:259:3: ( ^( VT_FACTS ( annotations )? ( ^( VT_FACT r= relation e= entity ) | ^( VT_NEG ^( VT_FACT relation entity ) ) )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:259:5: ^( VT_FACTS ( annotations )? ( ^( VT_FACT r= relation e= entity ) | ^( VT_NEG ^( VT_FACT relation entity ) ) )* )
            {
            match(input,VT_FACTS,FOLLOW_VT_FACTS_in_facts3509); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:259:18: ( annotations )?
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==VT_ANNOTATIONS) ) {
                    alt39=1;
                }
                switch (alt39) {
                    case 1 :
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:259:18: annotations
                        {
                        pushFollow(FOLLOW_annotations_in_facts3511);
                        annotations();

                        state._fsp--;


                        }
                        break;

                }

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:260:9: ( ^( VT_FACT r= relation e= entity ) | ^( VT_NEG ^( VT_FACT relation entity ) ) )*
                loop40:
                do {
                    int alt40=3;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==VT_FACT) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==VT_NEG) ) {
                        alt40=2;
                    }


                    switch (alt40) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:261:11: ^( VT_FACT r= relation e= entity )
                	    {
                	    match(input,VT_FACT,FOLLOW_VT_FACT_in_facts3541); 

                	    match(input, Token.DOWN, null); 
                	    pushFollow(FOLLOW_relation_in_facts3545);
                	    r=relation();

                	    state._fsp--;

                	    pushFollow(FOLLOW_entity_in_facts3549);
                	    e=entity();

                	    state._fsp--;


                	    match(input, Token.UP, null); 
                	     facList.add(factory.buildFactDescr(r,e,false)); 

                	    }
                	    break;
                	case 2 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:263:13: ^( VT_NEG ^( VT_FACT relation entity ) )
                	    {
                	    match(input,VT_NEG,FOLLOW_VT_NEG_in_facts3579); 

                	    match(input, Token.DOWN, null); 
                	    match(input,VT_FACT,FOLLOW_VT_FACT_in_facts3582); 

                	    match(input, Token.DOWN, null); 
                	    pushFollow(FOLLOW_relation_in_facts3584);
                	    relation();

                	    state._fsp--;

                	    pushFollow(FOLLOW_entity_in_facts3586);
                	    entity();

                	    state._fsp--;


                	    match(input, Token.UP, null); 

                	    match(input, Token.UP, null); 
                	     facList.add(factory.buildFactDescr(r,e,true)); 

                	    }
                	    break;

                	default :
                	    break loop40;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return facList;
    }
    // $ANTLR end "facts"


    // $ANTLR start "sames"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:270:1: sames returns [LinkedList eqsList] : ^( VT_SAMEAS ( annotations )? ^( VT_LIST (x= individual )* ) ) ;
    public final LinkedList sames() throws RecognitionException {
        LinkedList eqsList = null;

        Object x = null;


        eqsList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:272:3: ( ^( VT_SAMEAS ( annotations )? ^( VT_LIST (x= individual )* ) ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:272:5: ^( VT_SAMEAS ( annotations )? ^( VT_LIST (x= individual )* ) )
            {
            match(input,VT_SAMEAS,FOLLOW_VT_SAMEAS_in_sames3650); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:272:19: ( annotations )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==VT_ANNOTATIONS) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:272:19: annotations
                    {
                    pushFollow(FOLLOW_annotations_in_sames3652);
                    annotations();

                    state._fsp--;


                    }
                    break;

            }

            match(input,VT_LIST,FOLLOW_VT_LIST_in_sames3665); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:274:11: (x= individual )*
                loop42:
                do {
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=VT_IRI && LA42_0<=VT_ANON)) ) {
                        alt42=1;
                    }


                    switch (alt42) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:274:13: x= individual
                	    {
                	    pushFollow(FOLLOW_individual_in_sames3681);
                	    x=individual();

                	    state._fsp--;

                	    eqsList.add(x);

                	    }
                	    break;

                	default :
                	    break loop42;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return eqsList;
    }
    // $ANTLR end "sames"


    // $ANTLR start "differs"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:279:1: differs returns [LinkedList difList] : ^( VT_DIFFERENTFROM ( annotations )? ^( VT_LIST (x= individual )* ) ) ;
    public final LinkedList differs() throws RecognitionException {
        LinkedList difList = null;

        Object x = null;


        difList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:281:3: ( ^( VT_DIFFERENTFROM ( annotations )? ^( VT_LIST (x= individual )* ) ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:281:5: ^( VT_DIFFERENTFROM ( annotations )? ^( VT_LIST (x= individual )* ) )
            {
            match(input,VT_DIFFERENTFROM,FOLLOW_VT_DIFFERENTFROM_in_differs3731); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:281:26: ( annotations )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==VT_ANNOTATIONS) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:281:26: annotations
                    {
                    pushFollow(FOLLOW_annotations_in_differs3733);
                    annotations();

                    state._fsp--;


                    }
                    break;

            }

            match(input,VT_LIST,FOLLOW_VT_LIST_in_differs3746); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:283:11: (x= individual )*
                loop44:
                do {
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=VT_IRI && LA44_0<=VT_ANON)) ) {
                        alt44=1;
                    }


                    switch (alt44) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:283:13: x= individual
                	    {
                	    pushFollow(FOLLOW_individual_in_differs3762);
                	    x=individual();

                	    state._fsp--;

                	    difList.add(x);

                	    }
                	    break;

                	default :
                	    break loop44;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return difList;
    }
    // $ANTLR end "differs"


    // $ANTLR start "relation"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:296:1: relation returns [DL_RelationDescr relDescr] : ( ^( VT_DL_PROP prop= iri ) | ^( VT_DL_INV_PROP prop= iri ) );
    public final DL_RelationDescr relation() throws RecognitionException {
        DL_RelationDescr relDescr = null;

        DL_IriDescr prop = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:297:3: ( ^( VT_DL_PROP prop= iri ) | ^( VT_DL_INV_PROP prop= iri ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==VT_DL_PROP) ) {
                alt45=1;
            }
            else if ( (LA45_0==VT_DL_INV_PROP) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:297:5: ^( VT_DL_PROP prop= iri )
                    {
                    match(input,VT_DL_PROP,FOLLOW_VT_DL_PROP_in_relation3813); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_relation3817);
                    prop=iri();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     relDescr = factory.buildGenericRelationDescr(prop,false); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:298:6: ^( VT_DL_INV_PROP prop= iri )
                    {
                    match(input,VT_DL_INV_PROP,FOLLOW_VT_DL_INV_PROP_in_relation3828); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_relation3832);
                    prop=iri();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     relDescr = factory.buildGenericRelationDescr(prop,true); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return relDescr;
    }
    // $ANTLR end "relation"


    // $ANTLR start "definition"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:309:1: definition returns [DL_DefinitionDescr defDescr] : ^( VT_DL_DEFINITION (ann= annotations )? root= dl_tree ) ;
    public final DL_DefinitionDescr definition() throws RecognitionException {
        DL_DefinitionDescr defDescr = null;

        LinkedList ann = null;

        DL_aBaseDescr root = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:310:3: ( ^( VT_DL_DEFINITION (ann= annotations )? root= dl_tree ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:310:5: ^( VT_DL_DEFINITION (ann= annotations )? root= dl_tree )
            {
            match(input,VT_DL_DEFINITION,FOLLOW_VT_DL_DEFINITION_in_definition3866); 

             defDescr = factory.buildDefinitionDescr(); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:312:9: (ann= annotations )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==VT_ANNOTATIONS) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:312:11: ann= annotations
                    {
                    pushFollow(FOLLOW_annotations_in_definition3893);
                    ann=annotations();

                    state._fsp--;

                     defDescr.addAnnotations(ann); 

                    }
                    break;

            }

            pushFollow(FOLLOW_dl_tree_in_definition3937);
            root=dl_tree();

            state._fsp--;

             defDescr.setRoot(root); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return defDescr;
    }
    // $ANTLR end "definition"


    // $ANTLR start "dl_tree"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:320:1: dl_tree returns [DL_aBaseDescr descr] : ( ^( VT_OR (child= dl_tree )+ ) | ^( VT_AND (child= dl_tree )+ ) | ^( VT_NEG child= dl_tree ) | ^( VT_EXISTS rel= relation tgt= dl_tree ) | ^( VT_FORALL rel= relation tgt= dl_tree ) | ^( VT_VALUE rel= relation val= entity ) | ^( VT_SELF rel= relation ) | ^( VT_COUNT rel= relation ( ^( VT_MIN min= IntegerLiteral ) )? ( ^( VT_MAX max= IntegerLiteral ) )? (typ= dl_tree )? ) | ^( VT_DL_TYPE klass= iri ) | ^( VT_LIST (val= individual )+ ) | ^( VT_LIST (val= literal )+ ) | ^( VT_DL_RESTRICTED_TYPE typ= dl_tree fac= dl_tree ) | ^( VT_DL_RESTRICTION fc= facet lit= literal ) );
    public final DL_aBaseDescr dl_tree() throws RecognitionException {
        DL_aBaseDescr descr = null;

        CommonTree min=null;
        CommonTree max=null;
        DL_aBaseDescr child = null;

        DL_RelationDescr rel = null;

        DL_aBaseDescr tgt = null;

        Object val = null;

        DL_aBaseDescr typ = null;

        DL_IriDescr klass = null;

        DL_aBaseDescr fac = null;

        String fc = null;

        Object lit = null;


         
          List<DL_aBaseDescr> descrList = new LinkedList<DL_aBaseDescr>();
          List<Object> valuesList = new LinkedList<Object>();

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:327:3: ( ^( VT_OR (child= dl_tree )+ ) | ^( VT_AND (child= dl_tree )+ ) | ^( VT_NEG child= dl_tree ) | ^( VT_EXISTS rel= relation tgt= dl_tree ) | ^( VT_FORALL rel= relation tgt= dl_tree ) | ^( VT_VALUE rel= relation val= entity ) | ^( VT_SELF rel= relation ) | ^( VT_COUNT rel= relation ( ^( VT_MIN min= IntegerLiteral ) )? ( ^( VT_MAX max= IntegerLiteral ) )? (typ= dl_tree )? ) | ^( VT_DL_TYPE klass= iri ) | ^( VT_LIST (val= individual )+ ) | ^( VT_LIST (val= literal )+ ) | ^( VT_DL_RESTRICTED_TYPE typ= dl_tree fac= dl_tree ) | ^( VT_DL_RESTRICTION fc= facet lit= literal ) )
            int alt54=13;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:327:7: ^( VT_OR (child= dl_tree )+ )
                    {
                    match(input,VT_OR,FOLLOW_VT_OR_in_dl_tree3975); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:328:11: (child= dl_tree )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==VT_LIST||(LA47_0>=VT_NEG && LA47_0<=VT_COUNT)||LA47_0==VT_VALUE||LA47_0==VT_DL_TYPE||(LA47_0>=VT_DL_RESTRICTION && LA47_0<=VT_DL_RESTRICTED_TYPE)||LA47_0==VT_SELF) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:328:12: child= dl_tree
                    	    {
                    	    pushFollow(FOLLOW_dl_tree_in_dl_tree3991);
                    	    child=dl_tree();

                    	    state._fsp--;

                    	     descrList.add(child); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt47 >= 1 ) break loop47;
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);


                    match(input, Token.UP, null); 
                     descr = factory.buildOr(descrList); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:331:7: ^( VT_AND (child= dl_tree )+ )
                    {
                    match(input,VT_AND,FOLLOW_VT_AND_in_dl_tree4021); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:332:11: (child= dl_tree )+
                    int cnt48=0;
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==VT_LIST||(LA48_0>=VT_NEG && LA48_0<=VT_COUNT)||LA48_0==VT_VALUE||LA48_0==VT_DL_TYPE||(LA48_0>=VT_DL_RESTRICTION && LA48_0<=VT_DL_RESTRICTED_TYPE)||LA48_0==VT_SELF) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:332:12: child= dl_tree
                    	    {
                    	    pushFollow(FOLLOW_dl_tree_in_dl_tree4038);
                    	    child=dl_tree();

                    	    state._fsp--;

                    	     descrList.add(child); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt48 >= 1 ) break loop48;
                                EarlyExitException eee =
                                    new EarlyExitException(48, input);
                                throw eee;
                        }
                        cnt48++;
                    } while (true);


                    match(input, Token.UP, null); 
                     descr = factory.buildAnd(descrList); 

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:335:7: ^( VT_NEG child= dl_tree )
                    {
                    match(input,VT_NEG,FOLLOW_VT_NEG_in_dl_tree4070); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_dl_tree_in_dl_tree4074);
                    child=dl_tree();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildNeg(child); 

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:342:7: ^( VT_EXISTS rel= relation tgt= dl_tree )
                    {
                    match(input,VT_EXISTS,FOLLOW_VT_EXISTS_in_dl_tree4102); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_relation_in_dl_tree4106);
                    rel=relation();

                    state._fsp--;

                    pushFollow(FOLLOW_dl_tree_in_dl_tree4110);
                    tgt=dl_tree();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildExists(
                                            rel, 
                                            tgt); 

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:346:7: ^( VT_FORALL rel= relation tgt= dl_tree )
                    {
                    match(input,VT_FORALL,FOLLOW_VT_FORALL_in_dl_tree4128); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_relation_in_dl_tree4132);
                    rel=relation();

                    state._fsp--;

                    pushFollow(FOLLOW_dl_tree_in_dl_tree4136);
                    tgt=dl_tree();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildForall(
                                            rel, 
                                            tgt); 

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:350:7: ^( VT_VALUE rel= relation val= entity )
                    {
                    match(input,VT_VALUE,FOLLOW_VT_VALUE_in_dl_tree4154); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_relation_in_dl_tree4158);
                    rel=relation();

                    state._fsp--;

                    pushFollow(FOLLOW_entity_in_dl_tree4162);
                    val=entity();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildValue(
                                            rel, 
                                            val); 

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:354:7: ^( VT_SELF rel= relation )
                    {
                    match(input,VT_SELF,FOLLOW_VT_SELF_in_dl_tree4180); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_relation_in_dl_tree4184);
                    rel=relation();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildValue(
                                            rel, 
                                            null); 

                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:358:7: ^( VT_COUNT rel= relation ( ^( VT_MIN min= IntegerLiteral ) )? ( ^( VT_MAX max= IntegerLiteral ) )? (typ= dl_tree )? )
                    {
                    match(input,VT_COUNT,FOLLOW_VT_COUNT_in_dl_tree4254); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_relation_in_dl_tree4258);
                    rel=relation();

                    state._fsp--;

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:359:11: ( ^( VT_MIN min= IntegerLiteral ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==VT_MIN) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:359:12: ^( VT_MIN min= IntegerLiteral )
                            {
                            match(input,VT_MIN,FOLLOW_VT_MIN_in_dl_tree4272); 

                            match(input, Token.DOWN, null); 
                            min=(CommonTree)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_dl_tree4276); 

                            match(input, Token.UP, null); 

                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:360:11: ( ^( VT_MAX max= IntegerLiteral ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==VT_MAX) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:360:12: ^( VT_MAX max= IntegerLiteral )
                            {
                            match(input,VT_MAX,FOLLOW_VT_MAX_in_dl_tree4293); 

                            match(input, Token.DOWN, null); 
                            max=(CommonTree)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_dl_tree4297); 

                            match(input, Token.UP, null); 

                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:361:14: (typ= dl_tree )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==VT_LIST||(LA51_0>=VT_NEG && LA51_0<=VT_COUNT)||LA51_0==VT_VALUE||LA51_0==VT_DL_TYPE||(LA51_0>=VT_DL_RESTRICTION && LA51_0<=VT_DL_RESTRICTED_TYPE)||LA51_0==VT_SELF) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:361:14: typ= dl_tree
                            {
                            pushFollow(FOLLOW_dl_tree_in_dl_tree4314);
                            typ=dl_tree();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                     descr = factory.buildCount(
                                            rel, 
                                            (min!=null?min.getText():null),
                                            (max!=null?max.getText():null),
                                            typ); 

                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:372:7: ^( VT_DL_TYPE klass= iri )
                    {
                    match(input,VT_DL_TYPE,FOLLOW_VT_DL_TYPE_in_dl_tree4358); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_iri_in_dl_tree4362);
                    klass=iri();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildType(klass.getIri()); 

                    }
                    break;
                case 10 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:374:7: ^( VT_LIST (val= individual )+ )
                    {
                    match(input,VT_LIST,FOLLOW_VT_LIST_in_dl_tree4389); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:374:17: (val= individual )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( ((LA52_0>=VT_IRI && LA52_0<=VT_ANON)) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:374:18: val= individual
                    	    {
                    	    pushFollow(FOLLOW_individual_in_dl_tree4394);
                    	    val=individual();

                    	    state._fsp--;

                    	     valuesList.add(val); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);


                    match(input, Token.UP, null); 
                     descr = factory.buildEnumTypeDescr(valuesList); 

                    }
                    break;
                case 11 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:376:7: ^( VT_LIST (val= literal )+ )
                    {
                    match(input,VT_LIST,FOLLOW_VT_LIST_in_dl_tree4419); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:376:17: (val= literal )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( ((LA53_0>=IntegerLiteral && LA53_0<=DecimalLiteral)||LA53_0==FloatingPointLiteral||LA53_0==QuotedString) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:376:18: val= literal
                    	    {
                    	    pushFollow(FOLLOW_literal_in_dl_tree4424);
                    	    val=literal();

                    	    state._fsp--;

                    	     valuesList.add(val); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt53 >= 1 ) break loop53;
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
                    } while (true);


                    match(input, Token.UP, null); 
                     descr = factory.buildEnumTypeDescr(valuesList); 

                    }
                    break;
                case 12 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:378:7: ^( VT_DL_RESTRICTED_TYPE typ= dl_tree fac= dl_tree )
                    {
                    match(input,VT_DL_RESTRICTED_TYPE,FOLLOW_VT_DL_RESTRICTED_TYPE_in_dl_tree4454); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_dl_tree_in_dl_tree4458);
                    typ=dl_tree();

                    state._fsp--;

                    pushFollow(FOLLOW_dl_tree_in_dl_tree4462);
                    fac=dl_tree();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildRestrictedTypeDescr(typ,fac); 

                    }
                    break;
                case 13 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:380:7: ^( VT_DL_RESTRICTION fc= facet lit= literal )
                    {
                    match(input,VT_DL_RESTRICTION,FOLLOW_VT_DL_RESTRICTION_in_dl_tree4480); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_facet_in_dl_tree4484);
                    fc=facet();

                    state._fsp--;

                    pushFollow(FOLLOW_literal_in_dl_tree4488);
                    lit=literal();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     descr = factory.buildFacetDescr(fc,lit); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return descr;
    }
    // $ANTLR end "dl_tree"


    // $ANTLR start "facet"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:385:1: facet returns [String txt] : ^(f= VK_FACET ) ;
    public final String facet() throws RecognitionException {
        String txt = null;

        CommonTree f=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:386:3: ( ^(f= VK_FACET ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:386:5: ^(f= VK_FACET )
            {
            f=(CommonTree)match(input,VK_FACET,FOLLOW_VK_FACET_in_facet4559); 

            txt = (f!=null?f.getText():null);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return txt;
    }
    // $ANTLR end "facet"


    // $ANTLR start "annotations"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:397:1: annotations returns [LinkedList annList] : ^( VT_ANNOTATIONS (a= annotation )* ) ;
    public final LinkedList annotations() throws RecognitionException {
        LinkedList annList = null;

        DL_AnnotationDescr a = null;


        annList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:399:3: ( ^( VT_ANNOTATIONS (a= annotation )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:399:5: ^( VT_ANNOTATIONS (a= annotation )* )
            {
            match(input,VT_ANNOTATIONS,FOLLOW_VT_ANNOTATIONS_in_annotations4596); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:400:9: (a= annotation )*
                loop55:
                do {
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==VT_ANNOTATION) ) {
                        alt55=1;
                    }


                    switch (alt55) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:400:11: a= annotation
                	    {
                	    pushFollow(FOLLOW_annotation_in_annotations4619);
                	    a=annotation();

                	    state._fsp--;

                	    annList.add(a);

                	    }
                	    break;

                	default :
                	    break loop55;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return annList;
    }
    // $ANTLR end "annotations"


    // $ANTLR start "annotation"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:404:1: annotation returns [DL_AnnotationDescr annDescr] : ^( VT_ANNOTATION (nestedAnn= annotations )? src= iri tgt= entity ) ;
    public final DL_AnnotationDescr annotation() throws RecognitionException {
        DL_AnnotationDescr annDescr = null;

        LinkedList nestedAnn = null;

        DL_IriDescr src = null;

        Object tgt = null;


        annDescr = factory.buildAnnotationDescr();
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:406:3: ( ^( VT_ANNOTATION (nestedAnn= annotations )? src= iri tgt= entity ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:406:5: ^( VT_ANNOTATION (nestedAnn= annotations )? src= iri tgt= entity )
            {
            match(input,VT_ANNOTATION,FOLLOW_VT_ANNOTATION_in_annotation4657); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:407:9: (nestedAnn= annotations )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==VT_ANNOTATIONS) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:407:11: nestedAnn= annotations
                    {
                    pushFollow(FOLLOW_annotations_in_annotation4674);
                    nestedAnn=annotations();

                    state._fsp--;

                     annDescr.addAnnotations(nestedAnn); 

                    }
                    break;

            }

            pushFollow(FOLLOW_iri_in_annotation4697);
            src=iri();

            state._fsp--;

             annDescr.setIriKey(src); 
            pushFollow(FOLLOW_entity_in_annotation4712);
            tgt=entity();

            state._fsp--;

             annDescr.setTargetValue(tgt); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return annDescr;
    }
    // $ANTLR end "annotation"


    // $ANTLR start "individual"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:414:1: individual returns [Object val] : (i= iri | ^( VT_ANON ) | ^( VT_BLANK ln= VT_NAME ) );
    public final Object individual() throws RecognitionException {
        Object val = null;

        CommonTree ln=null;
        DL_IriDescr i = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:415:2: (i= iri | ^( VT_ANON ) | ^( VT_BLANK ln= VT_NAME ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case VT_IRI:
                {
                alt57=1;
                }
                break;
            case VT_ANON:
                {
                alt57=2;
                }
                break;
            case VT_BLANK:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:415:4: i= iri
                    {
                    pushFollow(FOLLOW_iri_in_individual4743);
                    i=iri();

                    state._fsp--;

                     val =i.getIri(); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:416:5: ^( VT_ANON )
                    {
                    match(input,VT_ANON,FOLLOW_VT_ANON_in_individual4753); 

                     val =new Object(); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:417:5: ^( VT_BLANK ln= VT_NAME )
                    {
                    match(input,VT_BLANK,FOLLOW_VT_BLANK_in_individual4765); 

                    match(input, Token.DOWN, null); 
                    ln=(CommonTree)match(input,VT_NAME,FOLLOW_VT_NAME_in_individual4769); 
                     val =new Blank((ln!=null?ln.getText():null)); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return val;
    }
    // $ANTLR end "individual"


    // $ANTLR start "entity"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:421:1: entity returns [Object val] : (x= individual | lit= literal );
    public final Object entity() throws RecognitionException {
        Object val = null;

        Object x = null;

        Object lit = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:422:3: (x= individual | lit= literal )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=VT_IRI && LA58_0<=VT_ANON)) ) {
                alt58=1;
            }
            else if ( ((LA58_0>=IntegerLiteral && LA58_0<=DecimalLiteral)||LA58_0==FloatingPointLiteral||LA58_0==QuotedString) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:422:5: x= individual
                    {
                    pushFollow(FOLLOW_individual_in_entity4798);
                    x=individual();

                    state._fsp--;

                     val = x; 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:423:5: lit= literal
                    {
                    pushFollow(FOLLOW_literal_in_entity4808);
                    lit=literal();

                    state._fsp--;

                     val =lit; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return val;
    }
    // $ANTLR end "entity"


    // $ANTLR start "literal"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:431:1: literal returns [Object val] : (s= QuotedString i= iri | s= QuotedString (l= LanguageTag )? | j= IntegerLiteral | d= DecimalLiteral | f= FloatingPointLiteral );
    public final Object literal() throws RecognitionException {
        Object val = null;

        CommonTree s=null;
        CommonTree l=null;
        CommonTree j=null;
        CommonTree d=null;
        CommonTree f=null;
        DL_IriDescr i = null;


        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:432:3: (s= QuotedString i= iri | s= QuotedString (l= LanguageTag )? | j= IntegerLiteral | d= DecimalLiteral | f= FloatingPointLiteral )
            int alt60=5;
            switch ( input.LA(1) ) {
            case QuotedString:
                {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==VT_IRI) ) {
                    alt60=1;
                }
                else if ( (LA60_1==UP||(LA60_1>=IntegerLiteral && LA60_1<=DecimalLiteral)||LA60_1==FloatingPointLiteral||LA60_1==QuotedString||LA60_1==LanguageTag) ) {
                    alt60=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerLiteral:
                {
                alt60=3;
                }
                break;
            case DecimalLiteral:
                {
                alt60=4;
                }
                break;
            case FloatingPointLiteral:
                {
                alt60=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:432:5: s= QuotedString i= iri
                    {
                    s=(CommonTree)match(input,QuotedString,FOLLOW_QuotedString_in_literal4838); 
                    pushFollow(FOLLOW_iri_in_literal4842);
                    i=iri();

                    state._fsp--;

                     val = new TypedObject((s!=null?s.getText():null),i.getIri()); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:433:5: s= QuotedString (l= LanguageTag )?
                    {
                    s=(CommonTree)match(input,QuotedString,FOLLOW_QuotedString_in_literal4853); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:433:21: (l= LanguageTag )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==LanguageTag) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:433:21: l= LanguageTag
                            {
                            l=(CommonTree)match(input,LanguageTag,FOLLOW_LanguageTag_in_literal4857); 

                            }
                            break;

                    }

                     val = new String((s!=null?s.getText():null)); if (l != null) val = val+(l!=null?l.getText():null); 

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:434:5: j= IntegerLiteral
                    {
                    j=(CommonTree)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_literal4871); 
                     val = Integer.valueOf((j!=null?j.getText():null)); 

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:435:5: d= DecimalLiteral
                    {
                    d=(CommonTree)match(input,DecimalLiteral,FOLLOW_DecimalLiteral_in_literal4882); 
                     val = java.math.BigDecimal.valueOf(Double.parseDouble((d!=null?d.getText():null))); 

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:436:5: f= FloatingPointLiteral
                    {
                    f=(CommonTree)match(input,FloatingPointLiteral,FOLLOW_FloatingPointLiteral_in_literal4892); 
                     val = Double.valueOf((f!=null?f.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return val;
    }
    // $ANTLR end "literal"


    // $ANTLR start "iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:440:1: iri returns [DL_IriDescr iriDescr] : ( ^( VT_IRI ln= VT_NAME ns= VT_NAME ) | ^( VT_IRI ln= VT_NAME VT_DEF_NS ) | ^( VT_IRI full= VT_PAREN_CHUNK ) );
    public final DL_IriDescr iri() throws RecognitionException {
        DL_IriDescr iriDescr = null;

        CommonTree ln=null;
        CommonTree ns=null;
        CommonTree full=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:441:3: ( ^( VT_IRI ln= VT_NAME ns= VT_NAME ) | ^( VT_IRI ln= VT_NAME VT_DEF_NS ) | ^( VT_IRI full= VT_PAREN_CHUNK ) )
            int alt61=3;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==VT_IRI) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==DOWN) ) {
                    int LA61_2 = input.LA(3);

                    if ( (LA61_2==VT_NAME) ) {
                        int LA61_3 = input.LA(4);

                        if ( (LA61_3==VT_NAME) ) {
                            alt61=1;
                        }
                        else if ( (LA61_3==VT_DEF_NS) ) {
                            alt61=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 61, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA61_2==VT_PAREN_CHUNK) ) {
                        alt61=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:441:5: ^( VT_IRI ln= VT_NAME ns= VT_NAME )
                    {
                    match(input,VT_IRI,FOLLOW_VT_IRI_in_iri4915); 

                    match(input, Token.DOWN, null); 
                    ln=(CommonTree)match(input,VT_NAME,FOLLOW_VT_NAME_in_iri4919); 
                    ns=(CommonTree)match(input,VT_NAME,FOLLOW_VT_NAME_in_iri4923); 

                    match(input, Token.UP, null); 
                     
                          iriDescr = factory.buildIriDescr((ns!=null?ns.getText():null),(ln!=null?ln.getText():null),this.ontoDescr.getNamespaces()); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:444:7: ^( VT_IRI ln= VT_NAME VT_DEF_NS )
                    {
                    match(input,VT_IRI,FOLLOW_VT_IRI_in_iri4939); 

                    match(input, Token.DOWN, null); 
                    ln=(CommonTree)match(input,VT_NAME,FOLLOW_VT_NAME_in_iri4943); 
                    match(input,VT_DEF_NS,FOLLOW_VT_DEF_NS_in_iri4945); 

                    match(input, Token.UP, null); 
                     iriDescr = factory.buildIriDescr("",(ln!=null?ln.getText():null),this.ontoDescr.getNamespaces()); 

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:446:7: ^( VT_IRI full= VT_PAREN_CHUNK )
                    {
                    match(input,VT_IRI,FOLLOW_VT_IRI_in_iri4968); 

                    match(input, Token.DOWN, null); 
                    full=(CommonTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_iri4972); 

                    match(input, Token.UP, null); 
                     iriDescr = factory.buildIriDescr((full!=null?full.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return iriDescr;
    }
    // $ANTLR end "iri"


    // $ANTLR start "misc"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:460:1: misc : ( ^( VT_EQV_CLASS ( annotations )? ( definition )+ ) | ^( VT_DIF_CLASS ( annotations )? ( definition )+ ) | ^( VT_EQV_PROP ( annotations )? ( relation )+ ) | ^( VT_DIF_PROP ( annotations )? ( relation )+ ) | ^( VT_EQV_INDV ( annotations )? ( individual )+ ) | ^( VT_DIF_INDV ( annotations )? ( individual )+ ) );
    public final void misc() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:461:3: ( ^( VT_EQV_CLASS ( annotations )? ( definition )+ ) | ^( VT_DIF_CLASS ( annotations )? ( definition )+ ) | ^( VT_EQV_PROP ( annotations )? ( relation )+ ) | ^( VT_DIF_PROP ( annotations )? ( relation )+ ) | ^( VT_EQV_INDV ( annotations )? ( individual )+ ) | ^( VT_DIF_INDV ( annotations )? ( individual )+ ) )
            int alt74=6;
            switch ( input.LA(1) ) {
            case VT_EQV_CLASS:
                {
                alt74=1;
                }
                break;
            case VT_DIF_CLASS:
                {
                alt74=2;
                }
                break;
            case VT_EQV_PROP:
                {
                alt74=3;
                }
                break;
            case VT_DIF_PROP:
                {
                alt74=4;
                }
                break;
            case VT_EQV_INDV:
                {
                alt74=5;
                }
                break;
            case VT_DIF_INDV:
                {
                alt74=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:461:5: ^( VT_EQV_CLASS ( annotations )? ( definition )+ )
                    {
                    match(input,VT_EQV_CLASS,FOLLOW_VT_EQV_CLASS_in_misc5006); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:461:20: ( annotations )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==VT_ANNOTATIONS) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:461:20: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_misc5008);
                            annotations();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:461:33: ( definition )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==VT_DL_DEFINITION) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:461:33: definition
                    	    {
                    	    pushFollow(FOLLOW_definition_in_misc5011);
                    	    definition();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:462:5: ^( VT_DIF_CLASS ( annotations )? ( definition )+ )
                    {
                    match(input,VT_DIF_CLASS,FOLLOW_VT_DIF_CLASS_in_misc5020); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:462:20: ( annotations )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==VT_ANNOTATIONS) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:462:20: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_misc5022);
                            annotations();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:462:33: ( definition )+
                    int cnt65=0;
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==VT_DL_DEFINITION) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:462:33: definition
                    	    {
                    	    pushFollow(FOLLOW_definition_in_misc5025);
                    	    definition();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt65 >= 1 ) break loop65;
                                EarlyExitException eee =
                                    new EarlyExitException(65, input);
                                throw eee;
                        }
                        cnt65++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:463:5: ^( VT_EQV_PROP ( annotations )? ( relation )+ )
                    {
                    match(input,VT_EQV_PROP,FOLLOW_VT_EQV_PROP_in_misc5034); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:463:19: ( annotations )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==VT_ANNOTATIONS) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:463:19: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_misc5036);
                            annotations();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:463:32: ( relation )+
                    int cnt67=0;
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( ((LA67_0>=VT_DL_PROP && LA67_0<=VT_DL_INV_PROP)) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:463:32: relation
                    	    {
                    	    pushFollow(FOLLOW_relation_in_misc5039);
                    	    relation();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt67 >= 1 ) break loop67;
                                EarlyExitException eee =
                                    new EarlyExitException(67, input);
                                throw eee;
                        }
                        cnt67++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:464:5: ^( VT_DIF_PROP ( annotations )? ( relation )+ )
                    {
                    match(input,VT_DIF_PROP,FOLLOW_VT_DIF_PROP_in_misc5048); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:464:19: ( annotations )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==VT_ANNOTATIONS) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:464:19: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_misc5050);
                            annotations();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:464:32: ( relation )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( ((LA69_0>=VT_DL_PROP && LA69_0<=VT_DL_INV_PROP)) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:464:32: relation
                    	    {
                    	    pushFollow(FOLLOW_relation_in_misc5053);
                    	    relation();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt69 >= 1 ) break loop69;
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:465:5: ^( VT_EQV_INDV ( annotations )? ( individual )+ )
                    {
                    match(input,VT_EQV_INDV,FOLLOW_VT_EQV_INDV_in_misc5062); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:465:19: ( annotations )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==VT_ANNOTATIONS) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:465:19: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_misc5064);
                            annotations();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:465:32: ( individual )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( ((LA71_0>=VT_IRI && LA71_0<=VT_ANON)) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:465:32: individual
                    	    {
                    	    pushFollow(FOLLOW_individual_in_misc5067);
                    	    individual();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt71 >= 1 ) break loop71;
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:466:5: ^( VT_DIF_INDV ( annotations )? ( individual )+ )
                    {
                    match(input,VT_DIF_INDV,FOLLOW_VT_DIF_INDV_in_misc5076); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:466:19: ( annotations )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==VT_ANNOTATIONS) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:466:19: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_misc5078);
                            annotations();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:466:32: ( individual )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( ((LA73_0>=VT_IRI && LA73_0<=VT_ANON)) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterTreeBuilder.g:466:32: individual
                    	    {
                    	    pushFollow(FOLLOW_individual_in_misc5081);
                    	    individual();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "misc"

    // Delegated rules


    protected DFA54 dfa54 = new DFA54(this);
    static final String DFA54_eotS =
        "\20\uffff";
    static final String DFA54_eofS =
        "\20\uffff";
    static final String DFA54_minS =
        "\1\17\11\uffff\1\2\2\uffff\1\77\2\uffff";
    static final String DFA54_maxS =
        "\1\112\11\uffff\1\2\2\uffff\1\u00a0\2\uffff";
    static final String DFA54_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\14\1\15"+
        "\1\uffff\1\13\1\12";
    static final String DFA54_specialS =
        "\20\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\12\4\uffff\1\3\1\2\1\1\1\4\1\5\1\10\2\uffff\1\6\11\uffff"+
            "\1\11\5\uffff\1\14\1\13\34\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "\3\17\131\uffff\2\16\1\uffff\1\16\1\uffff\1\16",
            "",
            ""
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "320:1: dl_tree returns [DL_aBaseDescr descr] : ( ^( VT_OR (child= dl_tree )+ ) | ^( VT_AND (child= dl_tree )+ ) | ^( VT_NEG child= dl_tree ) | ^( VT_EXISTS rel= relation tgt= dl_tree ) | ^( VT_FORALL rel= relation tgt= dl_tree ) | ^( VT_VALUE rel= relation val= entity ) | ^( VT_SELF rel= relation ) | ^( VT_COUNT rel= relation ( ^( VT_MIN min= IntegerLiteral ) )? ( ^( VT_MAX max= IntegerLiteral ) )? (typ= dl_tree )? ) | ^( VT_DL_TYPE klass= iri ) | ^( VT_LIST (val= individual )+ ) | ^( VT_LIST (val= literal )+ ) | ^( VT_DL_RESTRICTED_TYPE typ= dl_tree fac= dl_tree ) | ^( VT_DL_RESTRICTION fc= facet lit= literal ) );";
        }
    }
 

    public static final BitSet FOLLOW_VT_ONTOLOGY_in_ontology76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_NAME_in_ontology102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_ontology119 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_iri_in_ontology148 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_PREFIX_in_ontology211 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_ontology215 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_ontology219 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_inport_in_ontology284 = new BitSet(new long[]{0x7E00000080000058L});
    public static final BitSet FOLLOW_annotations_in_ontology317 = new BitSet(new long[]{0x7E00000080000048L});
    public static final BitSet FOLLOW_declaration_in_ontology350 = new BitSet(new long[]{0x7E00000000000048L});
    public static final BitSet FOLLOW_misc_in_ontology380 = new BitSet(new long[]{0x7E00000000000008L});
    public static final BitSet FOLLOW_VT_IMPORT_in_inport441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_inport445 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_in_declaration479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTITY_TYPE_CLASS_in_declaration491 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_ID_in_declaration507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_declaration511 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_annotations_in_declaration544 = new BitSet(new long[]{0x0003C00880000008L});
    public static final BitSet FOLLOW_disjointUnions_in_declaration563 = new BitSet(new long[]{0x0003C00880000008L});
    public static final BitSet FOLLOW_disjointWiths_in_declaration582 = new BitSet(new long[]{0x0003C00880000008L});
    public static final BitSet FOLLOW_equivalentTos_in_declaration601 = new BitSet(new long[]{0x0003C00880000008L});
    public static final BitSet FOLLOW_subClassOfs_in_declaration620 = new BitSet(new long[]{0x0003C00880000008L});
    public static final BitSet FOLLOW_hasKeys_in_declaration639 = new BitSet(new long[]{0x0003C00880000008L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_in_declaration750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTITY_TYPE_DATATYPE_in_declaration762 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_ID_in_declaration779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_declaration783 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_annotations_in_declaration814 = new BitSet(new long[]{0x0000400080000008L});
    public static final BitSet FOLLOW_equivalentTos_in_declaration844 = new BitSet(new long[]{0x0000400080000008L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_in_declaration1037 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTITY_TYPE_OBJPROP_in_declaration1049 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_ID_in_declaration1066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_declaration1070 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_annotations_in_declaration1102 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_VT_ATTRIBUTES_in_declaration1130 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_FUN_in_declaration1173 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_IFUN_in_declaration1199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_REF_in_declaration1229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_IREF_in_declaration1255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_SYM_in_declaration1281 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_ASYM_in_declaration1307 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_TRN_in_declaration1333 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_declaration1397 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_disjointWiths_in_declaration1438 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_equivalentTos_in_declaration1457 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_inverseOfs_in_declaration1476 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_domains_in_declaration1495 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_ranges_in_declaration1515 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_subPropertyOfs_in_declaration1534 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_subPropertyChain_in_declaration1553 = new BitSet(new long[]{0x007D400080010008L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_in_declaration1678 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTITY_TYPE_DATAPROP_in_declaration1690 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_ID_in_declaration1707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_declaration1711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_annotations_in_declaration1753 = new BitSet(new long[]{0x0065400080010008L});
    public static final BitSet FOLLOW_VT_ATTRIBUTES_in_declaration1771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DLA_FUN_in_declaration1792 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_declaration1797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_disjointWiths_in_declaration1834 = new BitSet(new long[]{0x0065400080010008L});
    public static final BitSet FOLLOW_equivalentTos_in_declaration1853 = new BitSet(new long[]{0x0065400080010008L});
    public static final BitSet FOLLOW_domains_in_declaration1883 = new BitSet(new long[]{0x0065400080010008L});
    public static final BitSet FOLLOW_ranges_in_declaration1903 = new BitSet(new long[]{0x0065400080010008L});
    public static final BitSet FOLLOW_subPropertyOfs_in_declaration1922 = new BitSet(new long[]{0x0065400080010008L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_in_declaration2064 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTITY_TYPE_ANNPROP_in_declaration2076 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_ID_in_declaration2093 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_declaration2097 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_annotations_in_declaration2127 = new BitSet(new long[]{0x0064000080000008L});
    public static final BitSet FOLLOW_domains_in_declaration2167 = new BitSet(new long[]{0x0064000080000008L});
    public static final BitSet FOLLOW_ranges_in_declaration2187 = new BitSet(new long[]{0x0064000080000008L});
    public static final BitSet FOLLOW_subPropertyOfs_in_declaration2206 = new BitSet(new long[]{0x0064000080000008L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_in_declaration2336 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTITY_TYPE_INDIVIDUAL_in_declaration2348 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_VT_NAME_in_declaration2365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_declaration2369 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_annotations_in_declaration2406 = new BitSet(new long[]{0x0180009080000008L});
    public static final BitSet FOLLOW_types_in_declaration2446 = new BitSet(new long[]{0x0180009080000008L});
    public static final BitSet FOLLOW_facts_in_declaration2466 = new BitSet(new long[]{0x0180009080000008L});
    public static final BitSet FOLLOW_sames_in_declaration2485 = new BitSet(new long[]{0x0180009080000008L});
    public static final BitSet FOLLOW_differs_in_declaration2504 = new BitSet(new long[]{0x0180009080000008L});
    public static final BitSet FOLLOW_VT_DISJOINTUNIONOF_in_disjointUnions2822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_disjointUnions2824 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_definition_in_disjointUnions2846 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_DISJOINTWITH_in_disjointWiths2887 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_disjointWiths2889 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_definition_in_disjointWiths2910 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_EQUIVALENTTO_in_equivalentTos2950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_equivalentTos2952 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_definition_in_equivalentTos2973 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_SUBCLASSOF_in_subClassOfs3013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_subClassOfs3015 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_definition_in_subClassOfs3037 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_KEYS_in_hasKeys3078 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_hasKeys3080 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_relation_in_hasKeys3095 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_VT_DOMAIN_in_domains3136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_definition_in_domains3157 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_RANGE_in_ranges3198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_ranges3200 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_definition_in_ranges3221 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_SUBPROPERTYOF_in_subPropertyOfs3261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_subPropertyOfs3263 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_relation_in_subPropertyOfs3284 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_VT_INVERSEOF_in_inverseOfs3324 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_inverseOfs3326 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_relation_in_inverseOfs3347 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_VT_SUBPROPERTYCHAIN_in_subPropertyChain3387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_subPropertyChain3389 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_relation_in_subPropertyChain3407 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_VT_TYPES_in_types3448 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_types3450 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_definition_in_types3469 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_FACTS_in_facts3509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_facts3511 = new BitSet(new long[]{0x0000002000100008L});
    public static final BitSet FOLLOW_VT_FACT_in_facts3541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_facts3545 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L,0x0000000158000000L});
    public static final BitSet FOLLOW_entity_in_facts3549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_NEG_in_facts3579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_FACT_in_facts3582 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_facts3584 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L,0x0000000158000000L});
    public static final BitSet FOLLOW_entity_in_facts3586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_SAMEAS_in_sames3650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_sames3652 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VT_LIST_in_sames3665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_individual_in_sames3681 = new BitSet(new long[]{0x8000000000000008L,0x0000000000000003L});
    public static final BitSet FOLLOW_VT_DIFFERENTFROM_in_differs3731 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_differs3733 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VT_LIST_in_differs3746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_individual_in_differs3762 = new BitSet(new long[]{0x8000000000000008L,0x0000000000000003L});
    public static final BitSet FOLLOW_VT_DL_PROP_in_relation3813 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_relation3817 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_DL_INV_PROP_in_relation3828 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_relation3832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_DL_DEFINITION_in_definition3866 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_definition3893 = new BitSet(new long[]{0x0000304013F08000L,0x0000000000000400L});
    public static final BitSet FOLLOW_dl_tree_in_definition3937 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_OR_in_dl_tree3975 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree3991 = new BitSet(new long[]{0x0000304013F08008L,0x0000000000000400L});
    public static final BitSet FOLLOW_VT_AND_in_dl_tree4021 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4038 = new BitSet(new long[]{0x0000304013F08008L,0x0000000000000400L});
    public static final BitSet FOLLOW_VT_NEG_in_dl_tree4070 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4074 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_EXISTS_in_dl_tree4102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_dl_tree4106 = new BitSet(new long[]{0x0000304013F08000L,0x0000000000000400L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FORALL_in_dl_tree4128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_dl_tree4132 = new BitSet(new long[]{0x0000304013F08000L,0x0000000000000400L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_VALUE_in_dl_tree4154 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_dl_tree4158 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L,0x0000000158000000L});
    public static final BitSet FOLLOW_entity_in_dl_tree4162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_SELF_in_dl_tree4180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_dl_tree4184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_COUNT_in_dl_tree4254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_relation_in_dl_tree4258 = new BitSet(new long[]{0x000030401FF08008L,0x0000000000000400L});
    public static final BitSet FOLLOW_VT_MIN_in_dl_tree4272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IntegerLiteral_in_dl_tree4276 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_MAX_in_dl_tree4293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IntegerLiteral_in_dl_tree4297 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4314 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_DL_TYPE_in_dl_tree4358 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_iri_in_dl_tree4362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_LIST_in_dl_tree4389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_individual_in_dl_tree4394 = new BitSet(new long[]{0x8000000000000008L,0x0000000000000003L});
    public static final BitSet FOLLOW_VT_LIST_in_dl_tree4419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_dl_tree4424 = new BitSet(new long[]{0x8000000000000008L,0x0000000000000003L,0x0000000158000000L});
    public static final BitSet FOLLOW_VT_DL_RESTRICTED_TYPE_in_dl_tree4454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4458 = new BitSet(new long[]{0x0000304013F08000L,0x0000000000000400L});
    public static final BitSet FOLLOW_dl_tree_in_dl_tree4462 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_DL_RESTRICTION_in_dl_tree4480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_facet_in_dl_tree4484 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L,0x0000000158000000L});
    public static final BitSet FOLLOW_literal_in_dl_tree4488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_FACET_in_facet4559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ANNOTATIONS_in_annotations4596 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotation_in_annotations4619 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_VT_ANNOTATION_in_annotation4657 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_annotation4674 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_iri_in_annotation4697 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L,0x0000000158000000L});
    public static final BitSet FOLLOW_entity_in_annotation4712 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_iri_in_individual4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VT_ANON_in_individual4753 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_BLANK_in_individual4765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_NAME_in_individual4769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_individual_in_entity4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_entity4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotedString_in_literal4838 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_iri_in_literal4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotedString_in_literal4853 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_LanguageTag_in_literal4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerLiteral_in_literal4871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DecimalLiteral_in_literal4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointLiteral_in_literal4892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VT_IRI_in_iri4915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_NAME_in_iri4919 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_VT_NAME_in_iri4923 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_IRI_in_iri4939 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_NAME_in_iri4943 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_VT_DEF_NS_in_iri4945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_IRI_in_iri4968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_iri4972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_EQV_CLASS_in_misc5006 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_misc5008 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_definition_in_misc5011 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_DIF_CLASS_in_misc5020 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_misc5022 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_definition_in_misc5025 = new BitSet(new long[]{0x0000000200000008L});
    public static final BitSet FOLLOW_VT_EQV_PROP_in_misc5034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_misc5036 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_relation_in_misc5039 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_VT_DIF_PROP_in_misc5048 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_misc5050 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_relation_in_misc5053 = new BitSet(new long[]{0x00000C0000000008L});
    public static final BitSet FOLLOW_VT_EQV_INDV_in_misc5062 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_misc5064 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_individual_in_misc5067 = new BitSet(new long[]{0x8000000000000008L,0x0000000000000003L});
    public static final BitSet FOLLOW_VT_DIF_INDV_in_misc5076 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_annotations_in_misc5078 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_individual_in_misc5081 = new BitSet(new long[]{0x8000000000000008L,0x0000000000000003L});

}