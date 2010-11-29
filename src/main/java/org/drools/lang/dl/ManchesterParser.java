// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g 2010-11-27 00:20:10
 
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
  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ManchesterParser extends Parser {
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


        public ManchesterParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ManchesterParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[113+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ManchesterParser.tokenNames; }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g"; }


        
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
        


    public static class manDL_ontology_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_ontology"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:62:1: manDL_ontology options {k=5; } : ( manDL_prefix )* ONTOLOGY_K COLON (nam= iri (ver= iri )? )? ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )* -> ^( VT_ONTOLOGY ^( VT_NAME ( $nam)? ( $ver)? ) ( manDL_prefix )* ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )* ) ;
    public final ManchesterParser.manDL_ontology_return manDL_ontology() throws RecognitionException {
        ManchesterParser.manDL_ontology_return retval = new ManchesterParser.manDL_ontology_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ONTOLOGY_K2=null;
        Token COLON3=null;
        ManchesterParser.iri_return nam = null;

        ManchesterParser.iri_return ver = null;

        ManchesterParser.manDL_prefix_return manDL_prefix1 = null;

        ManchesterParser.manDL_inport_return manDL_inport4 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations5 = null;

        ManchesterParser.manDL_type_declaration_return manDL_type_declaration6 = null;


        CommonTree ONTOLOGY_K2_tree=null;
        CommonTree COLON3_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_ONTOLOGY_K=new RewriteRuleTokenStream(adaptor,"token ONTOLOGY_K");
        RewriteRuleSubtreeStream stream_manDL_type_declaration=new RewriteRuleSubtreeStream(adaptor,"rule manDL_type_declaration");
        RewriteRuleSubtreeStream stream_manDL_prefix=new RewriteRuleSubtreeStream(adaptor,"rule manDL_prefix");
        RewriteRuleSubtreeStream stream_manDL_inport=new RewriteRuleSubtreeStream(adaptor,"rule manDL_inport");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:66:3: ( ( manDL_prefix )* ONTOLOGY_K COLON (nam= iri (ver= iri )? )? ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )* -> ^( VT_ONTOLOGY ^( VT_NAME ( $nam)? ( $ver)? ) ( manDL_prefix )* ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:67:4: ( manDL_prefix )* ONTOLOGY_K COLON (nam= iri (ver= iri )? )? ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )*
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:67:4: ( manDL_prefix )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NAMESPACE_K||LA1_0==PREFIX_K) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:67:4: manDL_prefix
            	    {
            	    pushFollow(FOLLOW_manDL_prefix_in_manDL_ontology127);
            	    manDL_prefix1=manDL_prefix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_prefix.add(manDL_prefix1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            ONTOLOGY_K2=(Token)match(input,ONTOLOGY_K,FOLLOW_ONTOLOGY_K_in_manDL_ontology136); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ONTOLOGY_K.add(ONTOLOGY_K2);

            COLON3=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_ontology138); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON3);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:68:22: (nam= iri (ver= iri )? )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:68:23: nam= iri (ver= iri )?
                    {
                    pushFollow(FOLLOW_iri_in_manDL_ontology143);
                    nam=iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_iri.add(nam.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:68:34: (ver= iri )?
                    int alt2=2;
                    alt2 = dfa2.predict(input);
                    switch (alt2) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:68:34: ver= iri
                            {
                            pushFollow(FOLLOW_iri_in_manDL_ontology147);
                            ver=iri();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_iri.add(ver.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:69:5: ( manDL_inport )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:69:5: manDL_inport
            	    {
            	    pushFollow(FOLLOW_manDL_inport_in_manDL_ontology156);
            	    manDL_inport4=manDL_inport();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_inport.add(manDL_inport4.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:70:5: ( manDL_annotations )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:70:5: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_ontology163);
                    manDL_annotations5=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations5.getTree());

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:71:5: ( manDL_type_declaration )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:71:5: manDL_type_declaration
            	    {
            	    pushFollow(FOLLOW_manDL_type_declaration_in_manDL_ontology170);
            	    manDL_type_declaration6=manDL_type_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_type_declaration.add(manDL_type_declaration6.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_inport, ver, manDL_prefix, manDL_annotations, nam, manDL_type_declaration
            // token labels: 
            // rule labels: retval, nam, ver
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_nam=new RewriteRuleSubtreeStream(adaptor,"rule nam",nam!=null?nam.tree:null);
            RewriteRuleSubtreeStream stream_ver=new RewriteRuleSubtreeStream(adaptor,"rule ver",ver!=null?ver.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 72:5: -> ^( VT_ONTOLOGY ^( VT_NAME ( $nam)? ( $ver)? ) ( manDL_prefix )* ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:72:8: ^( VT_ONTOLOGY ^( VT_NAME ( $nam)? ( $ver)? ) ( manDL_prefix )* ( manDL_inport )* ( manDL_annotations )? ( manDL_type_declaration )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ONTOLOGY, "VT_ONTOLOGY"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:72:22: ^( VT_NAME ( $nam)? ( $ver)? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NAME, "VT_NAME"), root_2);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:72:32: ( $nam)?
                if ( stream_nam.hasNext() ) {
                    adaptor.addChild(root_2, stream_nam.nextTree());

                }
                stream_nam.reset();
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:72:38: ( $ver)?
                if ( stream_ver.hasNext() ) {
                    adaptor.addChild(root_2, stream_ver.nextTree());

                }
                stream_ver.reset();

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:73:7: ( manDL_prefix )*
                while ( stream_manDL_prefix.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_prefix.nextTree());

                }
                stream_manDL_prefix.reset();
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:74:7: ( manDL_inport )*
                while ( stream_manDL_inport.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_inport.nextTree());

                }
                stream_manDL_inport.reset();
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:75:7: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:76:7: ( manDL_type_declaration )*
                while ( stream_manDL_type_declaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_type_declaration.nextTree());

                }
                stream_manDL_type_declaration.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_ontology"

    public static class manDL_inport_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_inport"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:81:1: manDL_inport : IMPORT_K COLON iri -> ^( VT_IMPORT iri ) ;
    public final ManchesterParser.manDL_inport_return manDL_inport() throws RecognitionException {
        ManchesterParser.manDL_inport_return retval = new ManchesterParser.manDL_inport_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IMPORT_K7=null;
        Token COLON8=null;
        ManchesterParser.iri_return iri9 = null;


        CommonTree IMPORT_K7_tree=null;
        CommonTree COLON8_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_IMPORT_K=new RewriteRuleTokenStream(adaptor,"token IMPORT_K");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:82:3: ( IMPORT_K COLON iri -> ^( VT_IMPORT iri ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:82:5: IMPORT_K COLON iri
            {
            IMPORT_K7=(Token)match(input,IMPORT_K,FOLLOW_IMPORT_K_in_manDL_inport271); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IMPORT_K.add(IMPORT_K7);

            COLON8=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_inport273); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON8);

            pushFollow(FOLLOW_iri_in_manDL_inport275);
            iri9=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri9.getTree());


            // AST REWRITE
            // elements: iri
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 83:3: -> ^( VT_IMPORT iri )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:83:6: ^( VT_IMPORT iri )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_IMPORT, "VT_IMPORT"), root_1);

                adaptor.addChild(root_1, stream_iri.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_inport"

    public static class manDL_prefix_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_prefix"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:89:1: manDL_prefix : ( PREFIX_K | NAMESPACE_K ) COLON ( (pref= pn_Prefix ) ( COLON )? full_iri | full_iri ) -> {pref==null}? ^( VT_PREFIX full_iri VT_DEF_NS ) -> ^( VT_PREFIX full_iri pn_Prefix ) ;
    public final ManchesterParser.manDL_prefix_return manDL_prefix() throws RecognitionException {
        ManchesterParser.manDL_prefix_return retval = new ManchesterParser.manDL_prefix_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PREFIX_K10=null;
        Token NAMESPACE_K11=null;
        Token COLON12=null;
        Token COLON13=null;
        ManchesterParser.pn_Prefix_return pref = null;

        ManchesterParser.full_iri_return full_iri14 = null;

        ManchesterParser.full_iri_return full_iri15 = null;


        CommonTree PREFIX_K10_tree=null;
        CommonTree NAMESPACE_K11_tree=null;
        CommonTree COLON12_tree=null;
        CommonTree COLON13_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_NAMESPACE_K=new RewriteRuleTokenStream(adaptor,"token NAMESPACE_K");
        RewriteRuleTokenStream stream_PREFIX_K=new RewriteRuleTokenStream(adaptor,"token PREFIX_K");
        RewriteRuleSubtreeStream stream_pn_Prefix=new RewriteRuleSubtreeStream(adaptor,"rule pn_Prefix");
        RewriteRuleSubtreeStream stream_full_iri=new RewriteRuleSubtreeStream(adaptor,"rule full_iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:90:3: ( ( PREFIX_K | NAMESPACE_K ) COLON ( (pref= pn_Prefix ) ( COLON )? full_iri | full_iri ) -> {pref==null}? ^( VT_PREFIX full_iri VT_DEF_NS ) -> ^( VT_PREFIX full_iri pn_Prefix ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:90:5: ( PREFIX_K | NAMESPACE_K ) COLON ( (pref= pn_Prefix ) ( COLON )? full_iri | full_iri )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:90:5: ( PREFIX_K | NAMESPACE_K )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==PREFIX_K) ) {
                alt7=1;
            }
            else if ( (LA7_0==NAMESPACE_K) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:90:6: PREFIX_K
                    {
                    PREFIX_K10=(Token)match(input,PREFIX_K,FOLLOW_PREFIX_K_in_manDL_prefix310); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PREFIX_K.add(PREFIX_K10);


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:90:17: NAMESPACE_K
                    {
                    NAMESPACE_K11=(Token)match(input,NAMESPACE_K,FOLLOW_NAMESPACE_K_in_manDL_prefix314); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAMESPACE_K.add(NAMESPACE_K11);


                    }
                    break;

            }

            COLON12=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_prefix317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON12);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:91:5: ( (pref= pn_Prefix ) ( COLON )? full_iri | full_iri )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==PN_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==LESS) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:92:9: (pref= pn_Prefix ) ( COLON )? full_iri
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:92:9: (pref= pn_Prefix )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:92:10: pref= pn_Prefix
                    {
                    pushFollow(FOLLOW_pn_Prefix_in_manDL_prefix337);
                    pref=pn_Prefix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_pn_Prefix.add(pref.getTree());
                    if ( state.backtracking==0 ) {
                       prefixes.add((pref!=null?input.toString(pref.start,pref.stop):null)); 
                    }

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:92:56: ( COLON )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==COLON) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:92:56: COLON
                            {
                            COLON13=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_prefix342); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON13);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_full_iri_in_manDL_prefix345);
                    full_iri14=full_iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_full_iri.add(full_iri14.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:93:11: full_iri
                    {
                    pushFollow(FOLLOW_full_iri_in_manDL_prefix357);
                    full_iri15=full_iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_full_iri.add(full_iri15.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: full_iri, pn_Prefix, full_iri
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 95:3: -> {pref==null}? ^( VT_PREFIX full_iri VT_DEF_NS )
            if (pref==null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:95:19: ^( VT_PREFIX full_iri VT_DEF_NS )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_PREFIX, "VT_PREFIX"), root_1);

                adaptor.addChild(root_1, stream_full_iri.nextTree());
                adaptor.addChild(root_1, (CommonTree)adaptor.create(VT_DEF_NS, "VT_DEF_NS"));

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 96:3: -> ^( VT_PREFIX full_iri pn_Prefix )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:96:6: ^( VT_PREFIX full_iri pn_Prefix )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_PREFIX, "VT_PREFIX"), root_1);

                adaptor.addChild(root_1, stream_full_iri.nextTree());
                adaptor.addChild(root_1, stream_pn_Prefix.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_prefix"

    public static class manDL_annotations_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotations"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:101:1: manDL_annotations : ANNOTATIONS_K COLON manDL_annotation_list -> ^( VT_ANNOTATIONS manDL_annotation_list ) ;
    public final ManchesterParser.manDL_annotations_return manDL_annotations() throws RecognitionException {
        ManchesterParser.manDL_annotations_return retval = new ManchesterParser.manDL_annotations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ANNOTATIONS_K16=null;
        Token COLON17=null;
        ManchesterParser.manDL_annotation_list_return manDL_annotation_list18 = null;


        CommonTree ANNOTATIONS_K16_tree=null;
        CommonTree COLON17_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_ANNOTATIONS_K=new RewriteRuleTokenStream(adaptor,"token ANNOTATIONS_K");
        RewriteRuleSubtreeStream stream_manDL_annotation_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotation_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:102:3: ( ANNOTATIONS_K COLON manDL_annotation_list -> ^( VT_ANNOTATIONS manDL_annotation_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:102:5: ANNOTATIONS_K COLON manDL_annotation_list
            {
            ANNOTATIONS_K16=(Token)match(input,ANNOTATIONS_K,FOLLOW_ANNOTATIONS_K_in_manDL_annotations415); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ANNOTATIONS_K.add(ANNOTATIONS_K16);

            COLON17=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_annotations417); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON17);

            pushFollow(FOLLOW_manDL_annotation_list_in_manDL_annotations419);
            manDL_annotation_list18=manDL_annotation_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotation_list.add(manDL_annotation_list18.getTree());


            // AST REWRITE
            // elements: manDL_annotation_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 103:3: -> ^( VT_ANNOTATIONS manDL_annotation_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:103:7: ^( VT_ANNOTATIONS manDL_annotation_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ANNOTATIONS, "VT_ANNOTATIONS"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotation_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotations"

    public static class manDL_annotation_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotation_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:106:1: manDL_annotation_list : manDL_annotation ( COMMA manDL_annotation )* ;
    public final ManchesterParser.manDL_annotation_list_return manDL_annotation_list() throws RecognitionException {
        ManchesterParser.manDL_annotation_list_return retval = new ManchesterParser.manDL_annotation_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA20=null;
        ManchesterParser.manDL_annotation_return manDL_annotation19 = null;

        ManchesterParser.manDL_annotation_return manDL_annotation21 = null;


        CommonTree COMMA20_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:107:3: ( manDL_annotation ( COMMA manDL_annotation )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:107:5: manDL_annotation ( COMMA manDL_annotation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_annotation_in_manDL_annotation_list450);
            manDL_annotation19=manDL_annotation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotation19.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:107:22: ( COMMA manDL_annotation )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:107:23: COMMA manDL_annotation
            	    {
            	    COMMA20=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_annotation_list453); if (state.failed) return retval;
            	    pushFollow(FOLLOW_manDL_annotation_in_manDL_annotation_list456);
            	    manDL_annotation21=manDL_annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotation21.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotation_list"

    public static class manDL_annotation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotation"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:110:1: manDL_annotation : ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target -> ^( VT_ANNOTATION ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target ) ;
    public final ManchesterParser.manDL_annotation_return manDL_annotation() throws RecognitionException {
        ManchesterParser.manDL_annotation_return retval = new ManchesterParser.manDL_annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations22 = null;

        ManchesterParser.manDL_annotationPropertyIRI_return manDL_annotationPropertyIRI23 = null;

        ManchesterParser.manDL_annotation_target_return manDL_annotation_target24 = null;


        RewriteRuleSubtreeStream stream_manDL_annotationPropertyIRI=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotationPropertyIRI");
        RewriteRuleSubtreeStream stream_manDL_annotation_target=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotation_target");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:111:3: ( ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target -> ^( VT_ANNOTATION ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:111:5: ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:111:5: ( manDL_annotations )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ANNOTATIONS_K) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:111:5: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_annotation474);
                    manDL_annotations22=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations22.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_annotationPropertyIRI_in_manDL_annotation477);
            manDL_annotationPropertyIRI23=manDL_annotationPropertyIRI();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotationPropertyIRI.add(manDL_annotationPropertyIRI23.getTree());
            pushFollow(FOLLOW_manDL_annotation_target_in_manDL_annotation479);
            manDL_annotation_target24=manDL_annotation_target();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotation_target.add(manDL_annotation_target24.getTree());


            // AST REWRITE
            // elements: manDL_annotationPropertyIRI, manDL_annotations, manDL_annotation_target
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 112:3: -> ^( VT_ANNOTATION ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:112:6: ^( VT_ANNOTATION ( manDL_annotations )? manDL_annotationPropertyIRI manDL_annotation_target )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ANNOTATION, "VT_ANNOTATION"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:112:22: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();
                adaptor.addChild(root_1, stream_manDL_annotationPropertyIRI.nextTree());
                adaptor.addChild(root_1, stream_manDL_annotation_target.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotation"

    public static class manDL_annotation_target_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotation_target"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:115:1: manDL_annotation_target : ( manDL_individual | manDL_literal );
    public final ManchesterParser.manDL_annotation_target_return manDL_annotation_target() throws RecognitionException {
        ManchesterParser.manDL_annotation_target_return retval = new ManchesterParser.manDL_annotation_target_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_individual_return manDL_individual25 = null;

        ManchesterParser.manDL_literal_return manDL_literal26 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:116:3: ( manDL_individual | manDL_literal )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:116:5: manDL_individual
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_individual_in_manDL_annotation_target512);
                    manDL_individual25=manDL_individual();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_individual25.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:116:24: manDL_literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_literal_in_manDL_annotation_target516);
                    manDL_literal26=manDL_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_literal26.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotation_target"

    public static class manDL_type_declaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_type_declaration"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:121:1: manDL_type_declaration : ( manDL_datatype_def | manDL_class | manDL_objectProperty | manDL_dataProperty | manDL_annotationProperty | manDL_namedIndividual | manDL_misc );
    public final ManchesterParser.manDL_type_declaration_return manDL_type_declaration() throws RecognitionException {
        ManchesterParser.manDL_type_declaration_return retval = new ManchesterParser.manDL_type_declaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_datatype_def_return manDL_datatype_def27 = null;

        ManchesterParser.manDL_class_return manDL_class28 = null;

        ManchesterParser.manDL_objectProperty_return manDL_objectProperty29 = null;

        ManchesterParser.manDL_dataProperty_return manDL_dataProperty30 = null;

        ManchesterParser.manDL_annotationProperty_return manDL_annotationProperty31 = null;

        ManchesterParser.manDL_namedIndividual_return manDL_namedIndividual32 = null;

        ManchesterParser.manDL_misc_return manDL_misc33 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:122:3: ( manDL_datatype_def | manDL_class | manDL_objectProperty | manDL_dataProperty | manDL_annotationProperty | manDL_namedIndividual | manDL_misc )
            int alt13=7;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:122:5: manDL_datatype_def
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_datatype_def_in_manDL_type_declaration535);
                    manDL_datatype_def27=manDL_datatype_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_datatype_def27.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:123:5: manDL_class
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_class_in_manDL_type_declaration541);
                    manDL_class28=manDL_class();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_class28.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:124:5: manDL_objectProperty
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_objectProperty_in_manDL_type_declaration552);
                    manDL_objectProperty29=manDL_objectProperty();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_objectProperty29.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:125:5: manDL_dataProperty
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_dataProperty_in_manDL_type_declaration558);
                    manDL_dataProperty30=manDL_dataProperty();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_dataProperty30.getTree());

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:126:5: manDL_annotationProperty
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotationProperty_in_manDL_type_declaration564);
                    manDL_annotationProperty31=manDL_annotationProperty();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotationProperty31.getTree());

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:127:5: manDL_namedIndividual
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_namedIndividual_in_manDL_type_declaration570);
                    manDL_namedIndividual32=manDL_namedIndividual();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_namedIndividual32.getTree());

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:128:5: manDL_misc
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_misc_in_manDL_type_declaration578);
                    manDL_misc33=manDL_misc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_misc33.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_type_declaration"

    public static class manDL_class_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_class"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:138:1: manDL_class : typ= CLASS_K COLON iri ( manDL_class_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_CLASS ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_class_frame )* ) ;
    public final ManchesterParser.manDL_class_return manDL_class() throws RecognitionException {
        ManchesterParser.manDL_class_return retval = new ManchesterParser.manDL_class_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token typ=null;
        Token COLON34=null;
        ManchesterParser.iri_return iri35 = null;

        ManchesterParser.manDL_class_frame_return manDL_class_frame36 = null;


        CommonTree typ_tree=null;
        CommonTree COLON34_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_CLASS_K=new RewriteRuleTokenStream(adaptor,"token CLASS_K");
        RewriteRuleSubtreeStream stream_manDL_class_frame=new RewriteRuleSubtreeStream(adaptor,"rule manDL_class_frame");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:139:3: (typ= CLASS_K COLON iri ( manDL_class_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_CLASS ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_class_frame )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:140:6: typ= CLASS_K COLON iri ( manDL_class_frame )*
            {
            typ=(Token)match(input,CLASS_K,FOLLOW_CLASS_K_in_manDL_class618); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLASS_K.add(typ);

            COLON34=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_class620); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON34);

            pushFollow(FOLLOW_iri_in_manDL_class634);
            iri35=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri35.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:142:7: ( manDL_class_frame )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:142:7: manDL_class_frame
            	    {
            	    pushFollow(FOLLOW_manDL_class_frame_in_manDL_class642);
            	    manDL_class_frame36=manDL_class_frame();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_class_frame.add(manDL_class_frame36.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_class_frame, iri
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 143:3: -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_CLASS ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_class_frame )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:144:7: ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_CLASS ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_class_frame )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE, "VT_TYPE_DECLARE"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:145:10: ^( VT_ENTITY_TYPE_CLASS )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ENTITY_TYPE_CLASS, "VT_ENTITY_TYPE_CLASS"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:146:10: ^( VT_TYPE_DECLARE_ID iri )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE_ID, "VT_TYPE_DECLARE_ID"), root_2);

                adaptor.addChild(root_2, stream_iri.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:147:10: ( manDL_class_frame )*
                while ( stream_manDL_class_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_class_frame.nextTree());

                }
                stream_manDL_class_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_class"

    public static class manDL_class_frame_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_class_frame"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:159:1: manDL_class_frame : ( ( ANNOTATIONS_K )=> manDL_annotations | ( DISJOINTUNIONOF_K )=> manDL_disjointUnionOf | ( DISJOINTWITH_K )=> manDL_disjointWith | ( EQUIVALENTTO_K )=> manDL_equivalentTo | ( SUBCLASSOF_K )=> manDL_subClassOf | ( HASKEY_K )=> manDL_hasKey );
    public final ManchesterParser.manDL_class_frame_return manDL_class_frame() throws RecognitionException {
        ManchesterParser.manDL_class_frame_return retval = new ManchesterParser.manDL_class_frame_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations37 = null;

        ManchesterParser.manDL_disjointUnionOf_return manDL_disjointUnionOf38 = null;

        ManchesterParser.manDL_disjointWith_return manDL_disjointWith39 = null;

        ManchesterParser.manDL_equivalentTo_return manDL_equivalentTo40 = null;

        ManchesterParser.manDL_subClassOf_return manDL_subClassOf41 = null;

        ManchesterParser.manDL_hasKey_return manDL_hasKey42 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:160:3: ( ( ANNOTATIONS_K )=> manDL_annotations | ( DISJOINTUNIONOF_K )=> manDL_disjointUnionOf | ( DISJOINTWITH_K )=> manDL_disjointWith | ( EQUIVALENTTO_K )=> manDL_equivalentTo | ( SUBCLASSOF_K )=> manDL_subClassOf | ( HASKEY_K )=> manDL_hasKey )
            int alt15=6;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ANNOTATIONS_K) && (synpred1_ManchesterParser())) {
                alt15=1;
            }
            else if ( (LA15_0==DISJOINTUNIONOF_K) && (synpred2_ManchesterParser())) {
                alt15=2;
            }
            else if ( (LA15_0==DISJOINTWITH_K) && (synpred3_ManchesterParser())) {
                alt15=3;
            }
            else if ( (LA15_0==EQUIVALENTTO_K) && (synpred4_ManchesterParser())) {
                alt15=4;
            }
            else if ( (LA15_0==SUBCLASSOF_K) && (synpred5_ManchesterParser())) {
                alt15=5;
            }
            else if ( (LA15_0==HASKEY_K) && (synpred6_ManchesterParser())) {
                alt15=6;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:160:5: ( ANNOTATIONS_K )=> manDL_annotations
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotations_in_manDL_class_frame847);
                    manDL_annotations37=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations37.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:161:5: ( DISJOINTUNIONOF_K )=> manDL_disjointUnionOf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_disjointUnionOf_in_manDL_class_frame859);
                    manDL_disjointUnionOf38=manDL_disjointUnionOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_disjointUnionOf38.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:162:5: ( DISJOINTWITH_K )=> manDL_disjointWith
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_disjointWith_in_manDL_class_frame871);
                    manDL_disjointWith39=manDL_disjointWith();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_disjointWith39.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:163:5: ( EQUIVALENTTO_K )=> manDL_equivalentTo
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_equivalentTo_in_manDL_class_frame883);
                    manDL_equivalentTo40=manDL_equivalentTo();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_equivalentTo40.getTree());

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:164:5: ( SUBCLASSOF_K )=> manDL_subClassOf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_subClassOf_in_manDL_class_frame895);
                    manDL_subClassOf41=manDL_subClassOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_subClassOf41.getTree());

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:165:5: ( HASKEY_K )=> manDL_hasKey
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_hasKey_in_manDL_class_frame907);
                    manDL_hasKey42=manDL_hasKey();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_hasKey42.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_class_frame"

    public static class manDL_disjointUnionOf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_disjointUnionOf"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:170:1: manDL_disjointUnionOf : DISJOINTUNIONOF_K COLON manDL_disjointUnionOf_list -> ^( VT_DISJOINTUNIONOF manDL_disjointUnionOf_list ) ;
    public final ManchesterParser.manDL_disjointUnionOf_return manDL_disjointUnionOf() throws RecognitionException {
        ManchesterParser.manDL_disjointUnionOf_return retval = new ManchesterParser.manDL_disjointUnionOf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DISJOINTUNIONOF_K43=null;
        Token COLON44=null;
        ManchesterParser.manDL_disjointUnionOf_list_return manDL_disjointUnionOf_list45 = null;


        CommonTree DISJOINTUNIONOF_K43_tree=null;
        CommonTree COLON44_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_DISJOINTUNIONOF_K=new RewriteRuleTokenStream(adaptor,"token DISJOINTUNIONOF_K");
        RewriteRuleSubtreeStream stream_manDL_disjointUnionOf_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_disjointUnionOf_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:171:3: ( DISJOINTUNIONOF_K COLON manDL_disjointUnionOf_list -> ^( VT_DISJOINTUNIONOF manDL_disjointUnionOf_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:171:5: DISJOINTUNIONOF_K COLON manDL_disjointUnionOf_list
            {
            DISJOINTUNIONOF_K43=(Token)match(input,DISJOINTUNIONOF_K,FOLLOW_DISJOINTUNIONOF_K_in_manDL_disjointUnionOf936); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DISJOINTUNIONOF_K.add(DISJOINTUNIONOF_K43);

            COLON44=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_disjointUnionOf938); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON44);

            pushFollow(FOLLOW_manDL_disjointUnionOf_list_in_manDL_disjointUnionOf940);
            manDL_disjointUnionOf_list45=manDL_disjointUnionOf_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_disjointUnionOf_list.add(manDL_disjointUnionOf_list45.getTree());


            // AST REWRITE
            // elements: manDL_disjointUnionOf_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 172:5: -> ^( VT_DISJOINTUNIONOF manDL_disjointUnionOf_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:172:8: ^( VT_DISJOINTUNIONOF manDL_disjointUnionOf_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DISJOINTUNIONOF, "VT_DISJOINTUNIONOF"), root_1);

                adaptor.addChild(root_1, stream_manDL_disjointUnionOf_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_disjointUnionOf"

    public static class manDL_disjointUnionOf_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_disjointUnionOf_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:175:1: manDL_disjointUnionOf_list : manDL_annotated_description ( COMMA manDL_annotated_description )+ ;
    public final ManchesterParser.manDL_disjointUnionOf_list_return manDL_disjointUnionOf_list() throws RecognitionException {
        ManchesterParser.manDL_disjointUnionOf_list_return retval = new ManchesterParser.manDL_disjointUnionOf_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA47=null;
        ManchesterParser.manDL_annotated_description_return manDL_annotated_description46 = null;

        ManchesterParser.manDL_annotated_description_return manDL_annotated_description48 = null;


        CommonTree COMMA47_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:176:3: ( manDL_annotated_description ( COMMA manDL_annotated_description )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:176:5: manDL_annotated_description ( COMMA manDL_annotated_description )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_annotated_description_in_manDL_disjointUnionOf_list965);
            manDL_annotated_description46=manDL_annotated_description();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotated_description46.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:176:33: ( COMMA manDL_annotated_description )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:176:34: COMMA manDL_annotated_description
            	    {
            	    COMMA47=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_disjointUnionOf_list968); if (state.failed) return retval;
            	    pushFollow(FOLLOW_manDL_annotated_description_in_manDL_disjointUnionOf_list971);
            	    manDL_annotated_description48=manDL_annotated_description();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotated_description48.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_disjointUnionOf_list"

    public static class manDL_disjointWith_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_disjointWith"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:179:1: manDL_disjointWith : DISJOINTWITH_K COLON manDL_annotated_description_list -> ^( VT_DISJOINTWITH manDL_annotated_description_list ) ;
    public final ManchesterParser.manDL_disjointWith_return manDL_disjointWith() throws RecognitionException {
        ManchesterParser.manDL_disjointWith_return retval = new ManchesterParser.manDL_disjointWith_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DISJOINTWITH_K49=null;
        Token COLON50=null;
        ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list51 = null;


        CommonTree DISJOINTWITH_K49_tree=null;
        CommonTree COLON50_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_DISJOINTWITH_K=new RewriteRuleTokenStream(adaptor,"token DISJOINTWITH_K");
        RewriteRuleSubtreeStream stream_manDL_annotated_description_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_description_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:180:3: ( DISJOINTWITH_K COLON manDL_annotated_description_list -> ^( VT_DISJOINTWITH manDL_annotated_description_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:180:5: DISJOINTWITH_K COLON manDL_annotated_description_list
            {
            DISJOINTWITH_K49=(Token)match(input,DISJOINTWITH_K,FOLLOW_DISJOINTWITH_K_in_manDL_disjointWith991); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DISJOINTWITH_K.add(DISJOINTWITH_K49);

            COLON50=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_disjointWith993); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON50);

            pushFollow(FOLLOW_manDL_annotated_description_list_in_manDL_disjointWith995);
            manDL_annotated_description_list51=manDL_annotated_description_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_description_list.add(manDL_annotated_description_list51.getTree());


            // AST REWRITE
            // elements: manDL_annotated_description_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 181:3: -> ^( VT_DISJOINTWITH manDL_annotated_description_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:181:6: ^( VT_DISJOINTWITH manDL_annotated_description_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DISJOINTWITH, "VT_DISJOINTWITH"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotated_description_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_disjointWith"

    public static class manDL_equivalentTo_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_equivalentTo"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:184:1: manDL_equivalentTo : ( EQUIVALENTTO_K COLON ) manDL_annotated_description_list -> ^( VT_EQUIVALENTTO manDL_annotated_description_list ) ;
    public final ManchesterParser.manDL_equivalentTo_return manDL_equivalentTo() throws RecognitionException {
        ManchesterParser.manDL_equivalentTo_return retval = new ManchesterParser.manDL_equivalentTo_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUIVALENTTO_K52=null;
        Token COLON53=null;
        ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list54 = null;


        CommonTree EQUIVALENTTO_K52_tree=null;
        CommonTree COLON53_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EQUIVALENTTO_K=new RewriteRuleTokenStream(adaptor,"token EQUIVALENTTO_K");
        RewriteRuleSubtreeStream stream_manDL_annotated_description_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_description_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:185:3: ( ( EQUIVALENTTO_K COLON ) manDL_annotated_description_list -> ^( VT_EQUIVALENTTO manDL_annotated_description_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:185:5: ( EQUIVALENTTO_K COLON ) manDL_annotated_description_list
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:185:5: ( EQUIVALENTTO_K COLON )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:185:6: EQUIVALENTTO_K COLON
            {
            EQUIVALENTTO_K52=(Token)match(input,EQUIVALENTTO_K,FOLLOW_EQUIVALENTTO_K_in_manDL_equivalentTo1019); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQUIVALENTTO_K.add(EQUIVALENTTO_K52);

            COLON53=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_equivalentTo1021); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON53);


            }

            pushFollow(FOLLOW_manDL_annotated_description_list_in_manDL_equivalentTo1025);
            manDL_annotated_description_list54=manDL_annotated_description_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_description_list.add(manDL_annotated_description_list54.getTree());


            // AST REWRITE
            // elements: manDL_annotated_description_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 186:3: -> ^( VT_EQUIVALENTTO manDL_annotated_description_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:186:6: ^( VT_EQUIVALENTTO manDL_annotated_description_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_EQUIVALENTTO, "VT_EQUIVALENTTO"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotated_description_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_equivalentTo"

    public static class manDL_subClassOf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_subClassOf"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:189:1: manDL_subClassOf : SUBCLASSOF_K COLON manDL_annotated_description_list -> ^( VT_SUBCLASSOF manDL_annotated_description_list ) ;
    public final ManchesterParser.manDL_subClassOf_return manDL_subClassOf() throws RecognitionException {
        ManchesterParser.manDL_subClassOf_return retval = new ManchesterParser.manDL_subClassOf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUBCLASSOF_K55=null;
        Token COLON56=null;
        ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list57 = null;


        CommonTree SUBCLASSOF_K55_tree=null;
        CommonTree COLON56_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SUBCLASSOF_K=new RewriteRuleTokenStream(adaptor,"token SUBCLASSOF_K");
        RewriteRuleSubtreeStream stream_manDL_annotated_description_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_description_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:190:3: ( SUBCLASSOF_K COLON manDL_annotated_description_list -> ^( VT_SUBCLASSOF manDL_annotated_description_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:190:5: SUBCLASSOF_K COLON manDL_annotated_description_list
            {
            SUBCLASSOF_K55=(Token)match(input,SUBCLASSOF_K,FOLLOW_SUBCLASSOF_K_in_manDL_subClassOf1052); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SUBCLASSOF_K.add(SUBCLASSOF_K55);

            COLON56=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_subClassOf1054); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON56);

            pushFollow(FOLLOW_manDL_annotated_description_list_in_manDL_subClassOf1056);
            manDL_annotated_description_list57=manDL_annotated_description_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_description_list.add(manDL_annotated_description_list57.getTree());


            // AST REWRITE
            // elements: manDL_annotated_description_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 191:3: -> ^( VT_SUBCLASSOF manDL_annotated_description_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:191:6: ^( VT_SUBCLASSOF manDL_annotated_description_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_SUBCLASSOF, "VT_SUBCLASSOF"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotated_description_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_subClassOf"

    public static class manDL_hasKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_hasKey"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:194:1: manDL_hasKey : HASKEY_K COLON ( manDL_annotations )? manDL_property_expression ( COMMA manDL_property_expression )* -> ^( VT_KEYS ( manDL_annotations )? ( manDL_property_expression )+ ) ;
    public final ManchesterParser.manDL_hasKey_return manDL_hasKey() throws RecognitionException {
        ManchesterParser.manDL_hasKey_return retval = new ManchesterParser.manDL_hasKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token HASKEY_K58=null;
        Token COLON59=null;
        Token COMMA62=null;
        ManchesterParser.manDL_annotations_return manDL_annotations60 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression61 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression63 = null;


        CommonTree HASKEY_K58_tree=null;
        CommonTree COLON59_tree=null;
        CommonTree COMMA62_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_HASKEY_K=new RewriteRuleTokenStream(adaptor,"token HASKEY_K");
        RewriteRuleSubtreeStream stream_manDL_property_expression=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_expression");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:195:3: ( HASKEY_K COLON ( manDL_annotations )? manDL_property_expression ( COMMA manDL_property_expression )* -> ^( VT_KEYS ( manDL_annotations )? ( manDL_property_expression )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:195:5: HASKEY_K COLON ( manDL_annotations )? manDL_property_expression ( COMMA manDL_property_expression )*
            {
            HASKEY_K58=(Token)match(input,HASKEY_K,FOLLOW_HASKEY_K_in_manDL_hasKey1083); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_HASKEY_K.add(HASKEY_K58);

            COLON59=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_hasKey1085); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON59);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:195:20: ( manDL_annotations )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ANNOTATIONS_K) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:195:20: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_hasKey1087);
                    manDL_annotations60=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations60.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_property_expression_in_manDL_hasKey1090);
            manDL_property_expression61=manDL_property_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression61.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:195:65: ( COMMA manDL_property_expression )*
            loop18:
            do {
                int alt18=2;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:195:66: COMMA manDL_property_expression
            	    {
            	    COMMA62=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_hasKey1093); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA62);

            	    pushFollow(FOLLOW_manDL_property_expression_in_manDL_hasKey1095);
            	    manDL_property_expression63=manDL_property_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression63.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_property_expression, manDL_annotations
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 196:3: -> ^( VT_KEYS ( manDL_annotations )? ( manDL_property_expression )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:196:6: ^( VT_KEYS ( manDL_annotations )? ( manDL_property_expression )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_KEYS, "VT_KEYS"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:196:16: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();
                if ( !(stream_manDL_property_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_property_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());

                }
                stream_manDL_property_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_hasKey"

    public static class manDL_annotated_description_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotated_description_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:203:1: manDL_annotated_description_list : manDL_annotated_description ( COMMA manDL_annotated_description )* ;
    public final ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list() throws RecognitionException {
        ManchesterParser.manDL_annotated_description_list_return retval = new ManchesterParser.manDL_annotated_description_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA65=null;
        ManchesterParser.manDL_annotated_description_return manDL_annotated_description64 = null;

        ManchesterParser.manDL_annotated_description_return manDL_annotated_description66 = null;


        CommonTree COMMA65_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:204:3: ( manDL_annotated_description ( COMMA manDL_annotated_description )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:204:5: manDL_annotated_description ( COMMA manDL_annotated_description )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_annotated_description_in_manDL_annotated_description_list1138);
            manDL_annotated_description64=manDL_annotated_description();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotated_description64.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:204:33: ( COMMA manDL_annotated_description )*
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:204:34: COMMA manDL_annotated_description
            	    {
            	    COMMA65=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_annotated_description_list1141); if (state.failed) return retval;
            	    pushFollow(FOLLOW_manDL_annotated_description_in_manDL_annotated_description_list1144);
            	    manDL_annotated_description66=manDL_annotated_description();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotated_description66.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotated_description_list"

    public static class manDL_annotated_description_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotated_description"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:208:1: manDL_annotated_description : ( manDL_annotations )? manDL_description -> ^( VT_DL_DEFINITION ( manDL_annotations )? manDL_description ) ;
    public final ManchesterParser.manDL_annotated_description_return manDL_annotated_description() throws RecognitionException {
        ManchesterParser.manDL_annotated_description_return retval = new ManchesterParser.manDL_annotated_description_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations67 = null;

        ManchesterParser.manDL_description_return manDL_description68 = null;


        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        RewriteRuleSubtreeStream stream_manDL_description=new RewriteRuleSubtreeStream(adaptor,"rule manDL_description");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:209:3: ( ( manDL_annotations )? manDL_description -> ^( VT_DL_DEFINITION ( manDL_annotations )? manDL_description ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:209:5: ( manDL_annotations )? manDL_description
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:209:5: ( manDL_annotations )?
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:209:5: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_annotated_description1160);
                    manDL_annotations67=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations67.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_description_in_manDL_annotated_description1163);
            manDL_description68=manDL_description();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_description.add(manDL_description68.getTree());


            // AST REWRITE
            // elements: manDL_description, manDL_annotations
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 210:3: -> ^( VT_DL_DEFINITION ( manDL_annotations )? manDL_description )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:210:6: ^( VT_DL_DEFINITION ( manDL_annotations )? manDL_description )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_DEFINITION, "VT_DL_DEFINITION"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:210:25: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();
                adaptor.addChild(root_1, stream_manDL_description.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotated_description"

    public static class manDL_description_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_description"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:215:1: manDL_description : manDL_conjunction (or= OR_K manDL_conjunction )* -> {or==null}? manDL_conjunction -> ^( VT_OR ( manDL_conjunction )+ ) ;
    public final ManchesterParser.manDL_description_return manDL_description() throws RecognitionException {
        ManchesterParser.manDL_description_return retval = new ManchesterParser.manDL_description_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token or=null;
        ManchesterParser.manDL_conjunction_return manDL_conjunction69 = null;

        ManchesterParser.manDL_conjunction_return manDL_conjunction70 = null;


        CommonTree or_tree=null;
        RewriteRuleTokenStream stream_OR_K=new RewriteRuleTokenStream(adaptor,"token OR_K");
        RewriteRuleSubtreeStream stream_manDL_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule manDL_conjunction");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:216:3: ( manDL_conjunction (or= OR_K manDL_conjunction )* -> {or==null}? manDL_conjunction -> ^( VT_OR ( manDL_conjunction )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:216:5: manDL_conjunction (or= OR_K manDL_conjunction )*
            {
            pushFollow(FOLLOW_manDL_conjunction_in_manDL_description1194);
            manDL_conjunction69=manDL_conjunction();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_conjunction.add(manDL_conjunction69.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:216:23: (or= OR_K manDL_conjunction )*
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:216:25: or= OR_K manDL_conjunction
            	    {
            	    or=(Token)match(input,OR_K,FOLLOW_OR_K_in_manDL_description1200); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OR_K.add(or);

            	    pushFollow(FOLLOW_manDL_conjunction_in_manDL_description1202);
            	    manDL_conjunction70=manDL_conjunction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_conjunction.add(manDL_conjunction70.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_conjunction, manDL_conjunction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 217:3: -> {or==null}? manDL_conjunction
            if (or==null) {
                adaptor.addChild(root_0, stream_manDL_conjunction.nextTree());

            }
            else // 218:3: -> ^( VT_OR ( manDL_conjunction )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:218:6: ^( VT_OR ( manDL_conjunction )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_OR, "VT_OR"), root_1);

                if ( !(stream_manDL_conjunction.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_conjunction.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_conjunction.nextTree());

                }
                stream_manDL_conjunction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_description"

    public static class manDL_conjunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_conjunction"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:221:1: manDL_conjunction : ( ( manDL_classIRI THAT_K )=> manDL_classIRI THAT_K manDL_restr ( AND_K manDL_restr )* -> ^( VT_AND ^( VT_DL_TYPE manDL_classIRI ) ( manDL_restr )+ ) | manDL_primary (and= AND_K manDL_primary )* -> {and==null}? manDL_primary -> ^( VT_AND ( manDL_primary )+ ) );
    public final ManchesterParser.manDL_conjunction_return manDL_conjunction() throws RecognitionException {
        ManchesterParser.manDL_conjunction_return retval = new ManchesterParser.manDL_conjunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token and=null;
        Token THAT_K72=null;
        Token AND_K74=null;
        ManchesterParser.manDL_classIRI_return manDL_classIRI71 = null;

        ManchesterParser.manDL_restr_return manDL_restr73 = null;

        ManchesterParser.manDL_restr_return manDL_restr75 = null;

        ManchesterParser.manDL_primary_return manDL_primary76 = null;

        ManchesterParser.manDL_primary_return manDL_primary77 = null;


        CommonTree and_tree=null;
        CommonTree THAT_K72_tree=null;
        CommonTree AND_K74_tree=null;
        RewriteRuleTokenStream stream_AND_K=new RewriteRuleTokenStream(adaptor,"token AND_K");
        RewriteRuleTokenStream stream_THAT_K=new RewriteRuleTokenStream(adaptor,"token THAT_K");
        RewriteRuleSubtreeStream stream_manDL_classIRI=new RewriteRuleSubtreeStream(adaptor,"rule manDL_classIRI");
        RewriteRuleSubtreeStream stream_manDL_primary=new RewriteRuleSubtreeStream(adaptor,"rule manDL_primary");
        RewriteRuleSubtreeStream stream_manDL_restr=new RewriteRuleSubtreeStream(adaptor,"rule manDL_restr");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:222:3: ( ( manDL_classIRI THAT_K )=> manDL_classIRI THAT_K manDL_restr ( AND_K manDL_restr )* -> ^( VT_AND ^( VT_DL_TYPE manDL_classIRI ) ( manDL_restr )+ ) | manDL_primary (and= AND_K manDL_primary )* -> {and==null}? manDL_primary -> ^( VT_AND ( manDL_primary )+ ) )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:222:5: ( manDL_classIRI THAT_K )=> manDL_classIRI THAT_K manDL_restr ( AND_K manDL_restr )*
                    {
                    pushFollow(FOLLOW_manDL_classIRI_in_manDL_conjunction1253);
                    manDL_classIRI71=manDL_classIRI();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_classIRI.add(manDL_classIRI71.getTree());
                    THAT_K72=(Token)match(input,THAT_K,FOLLOW_THAT_K_in_manDL_conjunction1255); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_THAT_K.add(THAT_K72);

                    pushFollow(FOLLOW_manDL_restr_in_manDL_conjunction1266);
                    manDL_restr73=manDL_restr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_restr.add(manDL_restr73.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:225:6: ( AND_K manDL_restr )*
                    loop22:
                    do {
                        int alt22=2;
                        alt22 = dfa22.predict(input);
                        switch (alt22) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:225:7: AND_K manDL_restr
                    	    {
                    	    AND_K74=(Token)match(input,AND_K,FOLLOW_AND_K_in_manDL_conjunction1275); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AND_K.add(AND_K74);

                    	    pushFollow(FOLLOW_manDL_restr_in_manDL_conjunction1277);
                    	    manDL_restr75=manDL_restr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_manDL_restr.add(manDL_restr75.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: manDL_restr, manDL_classIRI
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 226:3: -> ^( VT_AND ^( VT_DL_TYPE manDL_classIRI ) ( manDL_restr )+ )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:226:6: ^( VT_AND ^( VT_DL_TYPE manDL_classIRI ) ( manDL_restr )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_AND, "VT_AND"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:226:15: ^( VT_DL_TYPE manDL_classIRI )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_TYPE, "VT_DL_TYPE"), root_2);

                        adaptor.addChild(root_2, stream_manDL_classIRI.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        if ( !(stream_manDL_restr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_restr.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_restr.nextTree());

                        }
                        stream_manDL_restr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:228:5: manDL_primary (and= AND_K manDL_primary )*
                    {
                    pushFollow(FOLLOW_manDL_primary_in_manDL_conjunction1310);
                    manDL_primary76=manDL_primary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary76.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:228:19: (and= AND_K manDL_primary )*
                    loop23:
                    do {
                        int alt23=2;
                        alt23 = dfa23.predict(input);
                        switch (alt23) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:228:21: and= AND_K manDL_primary
                    	    {
                    	    and=(Token)match(input,AND_K,FOLLOW_AND_K_in_manDL_conjunction1316); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AND_K.add(and);

                    	    pushFollow(FOLLOW_manDL_primary_in_manDL_conjunction1318);
                    	    manDL_primary77=manDL_primary();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary77.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: manDL_primary, manDL_primary
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 229:3: -> {and==null}? manDL_primary
                    if (and==null) {
                        adaptor.addChild(root_0, stream_manDL_primary.nextTree());

                    }
                    else // 230:3: -> ^( VT_AND ( manDL_primary )+ )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:230:6: ^( VT_AND ( manDL_primary )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_AND, "VT_AND"), root_1);

                        if ( !(stream_manDL_primary.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_primary.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_primary.nextTree());

                        }
                        stream_manDL_primary.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_conjunction"

    public static class manDL_primary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_primary"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:237:1: manDL_primary options {backtrack=true; } : ( manDL_restr | manDL_atom );
    public final ManchesterParser.manDL_primary_return manDL_primary() throws RecognitionException {
        ManchesterParser.manDL_primary_return retval = new ManchesterParser.manDL_primary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_restr_return manDL_restr78 = null;

        ManchesterParser.manDL_atom_return manDL_atom79 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:241:3: ( manDL_restr | manDL_atom )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:242:3: manDL_restr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_restr_in_manDL_primary1377);
                    manDL_restr78=manDL_restr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_restr78.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:243:5: manDL_atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_atom_in_manDL_primary1383);
                    manDL_atom79=manDL_atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_atom79.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_primary"

    public static class manDL_atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_atom"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:247:1: manDL_atom : (not= NOT_K )? manDL_atomic_core -> {not!=null}? ^( VT_NEG manDL_atomic_core ) -> manDL_atomic_core ;
    public final ManchesterParser.manDL_atom_return manDL_atom() throws RecognitionException {
        ManchesterParser.manDL_atom_return retval = new ManchesterParser.manDL_atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token not=null;
        ManchesterParser.manDL_atomic_core_return manDL_atomic_core80 = null;


        CommonTree not_tree=null;
        RewriteRuleTokenStream stream_NOT_K=new RewriteRuleTokenStream(adaptor,"token NOT_K");
        RewriteRuleSubtreeStream stream_manDL_atomic_core=new RewriteRuleSubtreeStream(adaptor,"rule manDL_atomic_core");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:248:3: ( (not= NOT_K )? manDL_atomic_core -> {not!=null}? ^( VT_NEG manDL_atomic_core ) -> manDL_atomic_core )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:248:5: (not= NOT_K )? manDL_atomic_core
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:248:8: (not= NOT_K )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==NOT_K) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:248:8: not= NOT_K
                    {
                    not=(Token)match(input,NOT_K,FOLLOW_NOT_K_in_manDL_atom1400); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT_K.add(not);


                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_atomic_core_in_manDL_atom1403);
            manDL_atomic_core80=manDL_atomic_core();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_atomic_core.add(manDL_atomic_core80.getTree());


            // AST REWRITE
            // elements: manDL_atomic_core, manDL_atomic_core
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 249:3: -> {not!=null}? ^( VT_NEG manDL_atomic_core )
            if (not!=null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:249:19: ^( VT_NEG manDL_atomic_core )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NEG, "VT_NEG"), root_1);

                adaptor.addChild(root_1, stream_manDL_atomic_core.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 250:3: -> manDL_atomic_core
            {
                adaptor.addChild(root_0, stream_manDL_atomic_core.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_atom"

    public static class manDL_restr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_restr"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:253:1: manDL_restr : (not= NOT_K )? manDL_quantified_restriction_core -> {not!=null}? ^( VT_NEG manDL_quantified_restriction_core ) -> manDL_quantified_restriction_core ;
    public final ManchesterParser.manDL_restr_return manDL_restr() throws RecognitionException {
        ManchesterParser.manDL_restr_return retval = new ManchesterParser.manDL_restr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token not=null;
        ManchesterParser.manDL_quantified_restriction_core_return manDL_quantified_restriction_core81 = null;


        CommonTree not_tree=null;
        RewriteRuleTokenStream stream_NOT_K=new RewriteRuleTokenStream(adaptor,"token NOT_K");
        RewriteRuleSubtreeStream stream_manDL_quantified_restriction_core=new RewriteRuleSubtreeStream(adaptor,"rule manDL_quantified_restriction_core");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:254:3: ( (not= NOT_K )? manDL_quantified_restriction_core -> {not!=null}? ^( VT_NEG manDL_quantified_restriction_core ) -> manDL_quantified_restriction_core )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:254:5: (not= NOT_K )? manDL_quantified_restriction_core
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:254:8: (not= NOT_K )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NOT_K) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:254:8: not= NOT_K
                    {
                    not=(Token)match(input,NOT_K,FOLLOW_NOT_K_in_manDL_restr1436); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT_K.add(not);


                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_quantified_restriction_core_in_manDL_restr1439);
            manDL_quantified_restriction_core81=manDL_quantified_restriction_core();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_quantified_restriction_core.add(manDL_quantified_restriction_core81.getTree());


            // AST REWRITE
            // elements: manDL_quantified_restriction_core, manDL_quantified_restriction_core
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 255:3: -> {not!=null}? ^( VT_NEG manDL_quantified_restriction_core )
            if (not!=null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:255:19: ^( VT_NEG manDL_quantified_restriction_core )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NEG, "VT_NEG"), root_1);

                adaptor.addChild(root_1, stream_manDL_quantified_restriction_core.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 256:3: -> manDL_quantified_restriction_core
            {
                adaptor.addChild(root_0, stream_manDL_quantified_restriction_core.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_restr"

    public static class manDL_atomic_core_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_atomic_core"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:268:1: manDL_atomic_core : ( LEFT_CURLY manDL_item_list RIGHT_CURLY | manDL_data_type_restriction -> manDL_data_type_restriction | LEFT_PAREN manDL_description RIGHT_PAREN );
    public final ManchesterParser.manDL_atomic_core_return manDL_atomic_core() throws RecognitionException {
        ManchesterParser.manDL_atomic_core_return retval = new ManchesterParser.manDL_atomic_core_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFT_CURLY82=null;
        Token RIGHT_CURLY84=null;
        Token LEFT_PAREN86=null;
        Token RIGHT_PAREN88=null;
        ManchesterParser.manDL_item_list_return manDL_item_list83 = null;

        ManchesterParser.manDL_data_type_restriction_return manDL_data_type_restriction85 = null;

        ManchesterParser.manDL_description_return manDL_description87 = null;


        CommonTree LEFT_CURLY82_tree=null;
        CommonTree RIGHT_CURLY84_tree=null;
        CommonTree LEFT_PAREN86_tree=null;
        CommonTree RIGHT_PAREN88_tree=null;
        RewriteRuleSubtreeStream stream_manDL_data_type_restriction=new RewriteRuleSubtreeStream(adaptor,"rule manDL_data_type_restriction");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:269:3: ( LEFT_CURLY manDL_item_list RIGHT_CURLY | manDL_data_type_restriction -> manDL_data_type_restriction | LEFT_PAREN manDL_description RIGHT_PAREN )
            int alt28=3;
            switch ( input.LA(1) ) {
            case LEFT_CURLY:
                {
                alt28=1;
                }
                break;
            case DECIMAL_K:
            case FLOAT_K:
            case INTEGER_K:
            case STRING_K:
            case LESS:
            case UNDERSCORE:
            case COLON:
            case PN_ID:
            case DIGIT:
                {
                alt28=2;
                }
                break;
            case LEFT_PAREN:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:269:5: LEFT_CURLY manDL_item_list RIGHT_CURLY
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFT_CURLY82=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_manDL_atomic_core1481); if (state.failed) return retval;
                    pushFollow(FOLLOW_manDL_item_list_in_manDL_atomic_core1484);
                    manDL_item_list83=manDL_item_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_item_list83.getTree());
                    RIGHT_CURLY84=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_manDL_atomic_core1487); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:271:5: manDL_data_type_restriction
                    {
                    pushFollow(FOLLOW_manDL_data_type_restriction_in_manDL_atomic_core1497);
                    manDL_data_type_restriction85=manDL_data_type_restriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_data_type_restriction.add(manDL_data_type_restriction85.getTree());


                    // AST REWRITE
                    // elements: manDL_data_type_restriction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 272:3: -> manDL_data_type_restriction
                    {
                        adaptor.addChild(root_0, stream_manDL_data_type_restriction.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:274:5: LEFT_PAREN manDL_description RIGHT_PAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFT_PAREN86=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_manDL_atomic_core1512); if (state.failed) return retval;
                    pushFollow(FOLLOW_manDL_description_in_manDL_atomic_core1515);
                    manDL_description87=manDL_description();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_description87.getTree());
                    RIGHT_PAREN88=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_manDL_atomic_core1517); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_atomic_core"

    public static class manDL_quantified_restriction_core_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_quantified_restriction_core"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:282:2: manDL_quantified_restriction_core : p= manDL_property_expression ( ( SOME_K )=> SOME_K manDL_primary -> ^( VT_EXISTS manDL_property_expression manDL_primary ) | ( ONLY_K )=> ONLY_K manDL_primary -> ^( VT_FORALL manDL_property_expression manDL_primary ) | ( VALUE_K )=> VALUE_K ( manDL_individual | manDL_literal ) -> ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) | ( SELF_K )=> SELF_K -> ^( VT_SELF manDL_property_expression ) | ( MIN_K )=> manDL_min_restr -> ^( VT_COUNT manDL_property_expression manDL_min_restr ) | ( MAX_K )=> manDL_max_restr -> ^( VT_COUNT manDL_property_expression manDL_max_restr ) | ( EXACTLY_K )=> manDL_exactly_restr -> ^( VT_COUNT manDL_property_expression manDL_exactly_restr ) | ( manDL_data_type_restriction )=> manDL_data_type_restriction -> ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction ) ) ;
    public final ManchesterParser.manDL_quantified_restriction_core_return manDL_quantified_restriction_core() throws RecognitionException {
        ManchesterParser.manDL_quantified_restriction_core_return retval = new ManchesterParser.manDL_quantified_restriction_core_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SOME_K89=null;
        Token ONLY_K91=null;
        Token VALUE_K93=null;
        Token SELF_K96=null;
        ManchesterParser.manDL_property_expression_return p = null;

        ManchesterParser.manDL_primary_return manDL_primary90 = null;

        ManchesterParser.manDL_primary_return manDL_primary92 = null;

        ManchesterParser.manDL_individual_return manDL_individual94 = null;

        ManchesterParser.manDL_literal_return manDL_literal95 = null;

        ManchesterParser.manDL_min_restr_return manDL_min_restr97 = null;

        ManchesterParser.manDL_max_restr_return manDL_max_restr98 = null;

        ManchesterParser.manDL_exactly_restr_return manDL_exactly_restr99 = null;

        ManchesterParser.manDL_data_type_restriction_return manDL_data_type_restriction100 = null;


        CommonTree SOME_K89_tree=null;
        CommonTree ONLY_K91_tree=null;
        CommonTree VALUE_K93_tree=null;
        CommonTree SELF_K96_tree=null;
        RewriteRuleTokenStream stream_SELF_K=new RewriteRuleTokenStream(adaptor,"token SELF_K");
        RewriteRuleTokenStream stream_ONLY_K=new RewriteRuleTokenStream(adaptor,"token ONLY_K");
        RewriteRuleTokenStream stream_VALUE_K=new RewriteRuleTokenStream(adaptor,"token VALUE_K");
        RewriteRuleTokenStream stream_SOME_K=new RewriteRuleTokenStream(adaptor,"token SOME_K");
        RewriteRuleSubtreeStream stream_manDL_min_restr=new RewriteRuleSubtreeStream(adaptor,"rule manDL_min_restr");
        RewriteRuleSubtreeStream stream_manDL_individual=new RewriteRuleSubtreeStream(adaptor,"rule manDL_individual");
        RewriteRuleSubtreeStream stream_manDL_max_restr=new RewriteRuleSubtreeStream(adaptor,"rule manDL_max_restr");
        RewriteRuleSubtreeStream stream_manDL_literal=new RewriteRuleSubtreeStream(adaptor,"rule manDL_literal");
        RewriteRuleSubtreeStream stream_manDL_property_expression=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_expression");
        RewriteRuleSubtreeStream stream_manDL_primary=new RewriteRuleSubtreeStream(adaptor,"rule manDL_primary");
        RewriteRuleSubtreeStream stream_manDL_data_type_restriction=new RewriteRuleSubtreeStream(adaptor,"rule manDL_data_type_restriction");
        RewriteRuleSubtreeStream stream_manDL_exactly_restr=new RewriteRuleSubtreeStream(adaptor,"rule manDL_exactly_restr");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:283:3: (p= manDL_property_expression ( ( SOME_K )=> SOME_K manDL_primary -> ^( VT_EXISTS manDL_property_expression manDL_primary ) | ( ONLY_K )=> ONLY_K manDL_primary -> ^( VT_FORALL manDL_property_expression manDL_primary ) | ( VALUE_K )=> VALUE_K ( manDL_individual | manDL_literal ) -> ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) | ( SELF_K )=> SELF_K -> ^( VT_SELF manDL_property_expression ) | ( MIN_K )=> manDL_min_restr -> ^( VT_COUNT manDL_property_expression manDL_min_restr ) | ( MAX_K )=> manDL_max_restr -> ^( VT_COUNT manDL_property_expression manDL_max_restr ) | ( EXACTLY_K )=> manDL_exactly_restr -> ^( VT_COUNT manDL_property_expression manDL_exactly_restr ) | ( manDL_data_type_restriction )=> manDL_data_type_restriction -> ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction ) ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:283:5: p= manDL_property_expression ( ( SOME_K )=> SOME_K manDL_primary -> ^( VT_EXISTS manDL_property_expression manDL_primary ) | ( ONLY_K )=> ONLY_K manDL_primary -> ^( VT_FORALL manDL_property_expression manDL_primary ) | ( VALUE_K )=> VALUE_K ( manDL_individual | manDL_literal ) -> ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) | ( SELF_K )=> SELF_K -> ^( VT_SELF manDL_property_expression ) | ( MIN_K )=> manDL_min_restr -> ^( VT_COUNT manDL_property_expression manDL_min_restr ) | ( MAX_K )=> manDL_max_restr -> ^( VT_COUNT manDL_property_expression manDL_max_restr ) | ( EXACTLY_K )=> manDL_exactly_restr -> ^( VT_COUNT manDL_property_expression manDL_exactly_restr ) | ( manDL_data_type_restriction )=> manDL_data_type_restriction -> ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction ) )
            {
            pushFollow(FOLLOW_manDL_property_expression_in_manDL_quantified_restriction_core1544);
            p=manDL_property_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_property_expression.add(p.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:284:5: ( ( SOME_K )=> SOME_K manDL_primary -> ^( VT_EXISTS manDL_property_expression manDL_primary ) | ( ONLY_K )=> ONLY_K manDL_primary -> ^( VT_FORALL manDL_property_expression manDL_primary ) | ( VALUE_K )=> VALUE_K ( manDL_individual | manDL_literal ) -> ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) | ( SELF_K )=> SELF_K -> ^( VT_SELF manDL_property_expression ) | ( MIN_K )=> manDL_min_restr -> ^( VT_COUNT manDL_property_expression manDL_min_restr ) | ( MAX_K )=> manDL_max_restr -> ^( VT_COUNT manDL_property_expression manDL_max_restr ) | ( EXACTLY_K )=> manDL_exactly_restr -> ^( VT_COUNT manDL_property_expression manDL_exactly_restr ) | ( manDL_data_type_restriction )=> manDL_data_type_restriction -> ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction ) )
            int alt30=8;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:284:9: ( SOME_K )=> SOME_K manDL_primary
                    {
                    SOME_K89=(Token)match(input,SOME_K,FOLLOW_SOME_K_in_manDL_quantified_restriction_core1563); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SOME_K.add(SOME_K89);

                    pushFollow(FOLLOW_manDL_primary_in_manDL_quantified_restriction_core1565);
                    manDL_primary90=manDL_primary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary90.getTree());


                    // AST REWRITE
                    // elements: manDL_property_expression, manDL_primary
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 285:7: -> ^( VT_EXISTS manDL_property_expression manDL_primary )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:285:10: ^( VT_EXISTS manDL_property_expression manDL_primary )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_EXISTS, "VT_EXISTS"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        adaptor.addChild(root_1, stream_manDL_primary.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:286:9: ( ONLY_K )=> ONLY_K manDL_primary
                    {
                    ONLY_K91=(Token)match(input,ONLY_K,FOLLOW_ONLY_K_in_manDL_quantified_restriction_core1597); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ONLY_K.add(ONLY_K91);

                    pushFollow(FOLLOW_manDL_primary_in_manDL_quantified_restriction_core1600);
                    manDL_primary92=manDL_primary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary92.getTree());


                    // AST REWRITE
                    // elements: manDL_property_expression, manDL_primary
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 287:7: -> ^( VT_FORALL manDL_property_expression manDL_primary )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:287:10: ^( VT_FORALL manDL_property_expression manDL_primary )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_FORALL, "VT_FORALL"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        adaptor.addChild(root_1, stream_manDL_primary.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:290:9: ( VALUE_K )=> VALUE_K ( manDL_individual | manDL_literal )
                    {
                    VALUE_K93=(Token)match(input,VALUE_K,FOLLOW_VALUE_K_in_manDL_quantified_restriction_core1634); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VALUE_K.add(VALUE_K93);

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:290:30: ( manDL_individual | manDL_literal )
                    int alt29=2;
                    alt29 = dfa29.predict(input);
                    switch (alt29) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:290:31: manDL_individual
                            {
                            pushFollow(FOLLOW_manDL_individual_in_manDL_quantified_restriction_core1637);
                            manDL_individual94=manDL_individual();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_manDL_individual.add(manDL_individual94.getTree());

                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:290:50: manDL_literal
                            {
                            pushFollow(FOLLOW_manDL_literal_in_manDL_quantified_restriction_core1641);
                            manDL_literal95=manDL_literal();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_manDL_literal.add(manDL_literal95.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: manDL_property_expression, manDL_literal, manDL_individual
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 291:7: -> ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:291:10: ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_VALUE, "VT_VALUE"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:291:47: ( manDL_individual )?
                        if ( stream_manDL_individual.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_individual.nextTree());

                        }
                        stream_manDL_individual.reset();
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:291:65: ( manDL_literal )?
                        if ( stream_manDL_literal.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_literal.nextTree());

                        }
                        stream_manDL_literal.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:292:9: ( SELF_K )=> SELF_K
                    {
                    SELF_K96=(Token)match(input,SELF_K,FOLLOW_SELF_K_in_manDL_quantified_restriction_core1678); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SELF_K.add(SELF_K96);



                    // AST REWRITE
                    // elements: manDL_property_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 293:7: -> ^( VT_SELF manDL_property_expression )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:293:10: ^( VT_SELF manDL_property_expression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_SELF, "VT_SELF"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:294:9: ( MIN_K )=> manDL_min_restr
                    {
                    pushFollow(FOLLOW_manDL_min_restr_in_manDL_quantified_restriction_core1708);
                    manDL_min_restr97=manDL_min_restr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_min_restr.add(manDL_min_restr97.getTree());


                    // AST REWRITE
                    // elements: manDL_property_expression, manDL_min_restr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 295:7: -> ^( VT_COUNT manDL_property_expression manDL_min_restr )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:295:10: ^( VT_COUNT manDL_property_expression manDL_min_restr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_COUNT, "VT_COUNT"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        adaptor.addChild(root_1, stream_manDL_min_restr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:296:9: ( MAX_K )=> manDL_max_restr
                    {
                    pushFollow(FOLLOW_manDL_max_restr_in_manDL_quantified_restriction_core1746);
                    manDL_max_restr98=manDL_max_restr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_max_restr.add(manDL_max_restr98.getTree());


                    // AST REWRITE
                    // elements: manDL_max_restr, manDL_property_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 297:7: -> ^( VT_COUNT manDL_property_expression manDL_max_restr )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:297:10: ^( VT_COUNT manDL_property_expression manDL_max_restr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_COUNT, "VT_COUNT"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        adaptor.addChild(root_1, stream_manDL_max_restr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:298:9: ( EXACTLY_K )=> manDL_exactly_restr
                    {
                    pushFollow(FOLLOW_manDL_exactly_restr_in_manDL_quantified_restriction_core1816);
                    manDL_exactly_restr99=manDL_exactly_restr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_exactly_restr.add(manDL_exactly_restr99.getTree());


                    // AST REWRITE
                    // elements: manDL_property_expression, manDL_exactly_restr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 299:7: -> ^( VT_COUNT manDL_property_expression manDL_exactly_restr )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:299:10: ^( VT_COUNT manDL_property_expression manDL_exactly_restr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_COUNT, "VT_COUNT"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        adaptor.addChild(root_1, stream_manDL_exactly_restr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:302:9: ( manDL_data_type_restriction )=> manDL_data_type_restriction
                    {
                    pushFollow(FOLLOW_manDL_data_type_restriction_in_manDL_quantified_restriction_core1862);
                    manDL_data_type_restriction100=manDL_data_type_restriction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_data_type_restriction.add(manDL_data_type_restriction100.getTree());


                    // AST REWRITE
                    // elements: manDL_data_type_restriction, manDL_property_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 303:7: -> ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:303:10: ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_COUNT, "VT_COUNT"), root_1);

                        adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:303:47: ^( VT_MIN IntegerLiteral[\"1\"] )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_MIN, "VT_MIN"), root_2);

                        adaptor.addChild(root_2, (CommonTree)adaptor.create(IntegerLiteral, "1"));

                        adaptor.addChild(root_1, root_2);
                        }
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:303:77: ^( VT_MAX IntegerLiteral[\"1\"] )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_MAX, "VT_MAX"), root_2);

                        adaptor.addChild(root_2, (CommonTree)adaptor.create(IntegerLiteral, "1"));

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_manDL_data_type_restriction.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_quantified_restriction_core"

    public static class manDL_exactly_restr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_exactly_restr"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:308:1: manDL_exactly_restr options {backtrack=true; } : ( EXACTLY_K IntegerLiteral ( manDL_primary )? ) -> ^( VT_MIN IntegerLiteral ) ^( VT_MAX IntegerLiteral ) ( manDL_primary )? ;
    public final ManchesterParser.manDL_exactly_restr_return manDL_exactly_restr() throws RecognitionException {
        ManchesterParser.manDL_exactly_restr_return retval = new ManchesterParser.manDL_exactly_restr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EXACTLY_K101=null;
        Token IntegerLiteral102=null;
        ManchesterParser.manDL_primary_return manDL_primary103 = null;


        CommonTree EXACTLY_K101_tree=null;
        CommonTree IntegerLiteral102_tree=null;
        RewriteRuleTokenStream stream_IntegerLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerLiteral");
        RewriteRuleTokenStream stream_EXACTLY_K=new RewriteRuleTokenStream(adaptor,"token EXACTLY_K");
        RewriteRuleSubtreeStream stream_manDL_primary=new RewriteRuleSubtreeStream(adaptor,"rule manDL_primary");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:312:3: ( ( EXACTLY_K IntegerLiteral ( manDL_primary )? ) -> ^( VT_MIN IntegerLiteral ) ^( VT_MAX IntegerLiteral ) ( manDL_primary )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:313:4: ( EXACTLY_K IntegerLiteral ( manDL_primary )? )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:313:4: ( EXACTLY_K IntegerLiteral ( manDL_primary )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:313:5: EXACTLY_K IntegerLiteral ( manDL_primary )?
            {
            EXACTLY_K101=(Token)match(input,EXACTLY_K,FOLLOW_EXACTLY_K_in_manDL_exactly_restr1940); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EXACTLY_K.add(EXACTLY_K101);

            IntegerLiteral102=(Token)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_manDL_exactly_restr1942); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IntegerLiteral.add(IntegerLiteral102);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:313:30: ( manDL_primary )?
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:313:30: manDL_primary
                    {
                    pushFollow(FOLLOW_manDL_primary_in_manDL_exactly_restr1944);
                    manDL_primary103=manDL_primary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary103.getTree());

                    }
                    break;

            }


            }



            // AST REWRITE
            // elements: IntegerLiteral, manDL_primary, IntegerLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 314:4: -> ^( VT_MIN IntegerLiteral ) ^( VT_MAX IntegerLiteral ) ( manDL_primary )?
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:314:7: ^( VT_MIN IntegerLiteral )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_MIN, "VT_MIN"), root_1);

                adaptor.addChild(root_1, stream_IntegerLiteral.nextNode());

                adaptor.addChild(root_0, root_1);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:314:32: ^( VT_MAX IntegerLiteral )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_MAX, "VT_MAX"), root_1);

                adaptor.addChild(root_1, stream_IntegerLiteral.nextNode());

                adaptor.addChild(root_0, root_1);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:314:57: ( manDL_primary )?
                if ( stream_manDL_primary.hasNext() ) {
                    adaptor.addChild(root_0, stream_manDL_primary.nextTree());

                }
                stream_manDL_primary.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_exactly_restr"

    public static class manDL_max_restr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_max_restr"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:318:1: manDL_max_restr options {backtrack=true; } : ( MAX_K IntegerLiteral ( manDL_primary )? ) -> ^( VT_MAX IntegerLiteral ) ( manDL_primary )? ;
    public final ManchesterParser.manDL_max_restr_return manDL_max_restr() throws RecognitionException {
        ManchesterParser.manDL_max_restr_return retval = new ManchesterParser.manDL_max_restr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MAX_K104=null;
        Token IntegerLiteral105=null;
        ManchesterParser.manDL_primary_return manDL_primary106 = null;


        CommonTree MAX_K104_tree=null;
        CommonTree IntegerLiteral105_tree=null;
        RewriteRuleTokenStream stream_IntegerLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerLiteral");
        RewriteRuleTokenStream stream_MAX_K=new RewriteRuleTokenStream(adaptor,"token MAX_K");
        RewriteRuleSubtreeStream stream_manDL_primary=new RewriteRuleSubtreeStream(adaptor,"rule manDL_primary");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:322:3: ( ( MAX_K IntegerLiteral ( manDL_primary )? ) -> ^( VT_MAX IntegerLiteral ) ( manDL_primary )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:323:3: ( MAX_K IntegerLiteral ( manDL_primary )? )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:323:3: ( MAX_K IntegerLiteral ( manDL_primary )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:323:4: MAX_K IntegerLiteral ( manDL_primary )?
            {
            MAX_K104=(Token)match(input,MAX_K,FOLLOW_MAX_K_in_manDL_max_restr2001); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_MAX_K.add(MAX_K104);

            IntegerLiteral105=(Token)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_manDL_max_restr2003); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IntegerLiteral.add(IntegerLiteral105);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:323:25: ( manDL_primary )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:323:25: manDL_primary
                    {
                    pushFollow(FOLLOW_manDL_primary_in_manDL_max_restr2005);
                    manDL_primary106=manDL_primary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary106.getTree());

                    }
                    break;

            }


            }



            // AST REWRITE
            // elements: manDL_primary, IntegerLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 324:4: -> ^( VT_MAX IntegerLiteral ) ( manDL_primary )?
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:324:7: ^( VT_MAX IntegerLiteral )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_MAX, "VT_MAX"), root_1);

                adaptor.addChild(root_1, stream_IntegerLiteral.nextNode());

                adaptor.addChild(root_0, root_1);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:324:32: ( manDL_primary )?
                if ( stream_manDL_primary.hasNext() ) {
                    adaptor.addChild(root_0, stream_manDL_primary.nextTree());

                }
                stream_manDL_primary.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_max_restr"

    public static class manDL_min_restr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_min_restr"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:327:1: manDL_min_restr options {backtrack=true; } : ( MIN_K IntegerLiteral ( manDL_primary )? ) -> ^( VT_MIN IntegerLiteral ) ( manDL_primary )? ;
    public final ManchesterParser.manDL_min_restr_return manDL_min_restr() throws RecognitionException {
        ManchesterParser.manDL_min_restr_return retval = new ManchesterParser.manDL_min_restr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MIN_K107=null;
        Token IntegerLiteral108=null;
        ManchesterParser.manDL_primary_return manDL_primary109 = null;


        CommonTree MIN_K107_tree=null;
        CommonTree IntegerLiteral108_tree=null;
        RewriteRuleTokenStream stream_IntegerLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerLiteral");
        RewriteRuleTokenStream stream_MIN_K=new RewriteRuleTokenStream(adaptor,"token MIN_K");
        RewriteRuleSubtreeStream stream_manDL_primary=new RewriteRuleSubtreeStream(adaptor,"rule manDL_primary");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:331:3: ( ( MIN_K IntegerLiteral ( manDL_primary )? ) -> ^( VT_MIN IntegerLiteral ) ( manDL_primary )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:332:3: ( MIN_K IntegerLiteral ( manDL_primary )? )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:332:3: ( MIN_K IntegerLiteral ( manDL_primary )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:332:4: MIN_K IntegerLiteral ( manDL_primary )?
            {
            MIN_K107=(Token)match(input,MIN_K,FOLLOW_MIN_K_in_manDL_min_restr2053); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_MIN_K.add(MIN_K107);

            IntegerLiteral108=(Token)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_manDL_min_restr2055); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IntegerLiteral.add(IntegerLiteral108);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:332:25: ( manDL_primary )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:332:25: manDL_primary
                    {
                    pushFollow(FOLLOW_manDL_primary_in_manDL_min_restr2057);
                    manDL_primary109=manDL_primary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primary.add(manDL_primary109.getTree());

                    }
                    break;

            }


            }



            // AST REWRITE
            // elements: manDL_primary, IntegerLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 333:4: -> ^( VT_MIN IntegerLiteral ) ( manDL_primary )?
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:333:7: ^( VT_MIN IntegerLiteral )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_MIN, "VT_MIN"), root_1);

                adaptor.addChild(root_1, stream_IntegerLiteral.nextNode());

                adaptor.addChild(root_0, root_1);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:333:32: ( manDL_primary )?
                if ( stream_manDL_primary.hasNext() ) {
                    adaptor.addChild(root_0, stream_manDL_primary.nextTree());

                }
                stream_manDL_primary.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_min_restr"

    public static class manDL_data_type_restriction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_data_type_restriction"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:341:1: manDL_data_type_restriction : manDL_data_type ( LEFT_SQUARE fac= manDL_facets RIGHT_SQUARE )? -> {fac!=null}? ^( VT_DL_RESTRICTED_TYPE manDL_data_type manDL_facets ) -> ^( VT_DL_TYPE manDL_data_type ) ;
    public final ManchesterParser.manDL_data_type_restriction_return manDL_data_type_restriction() throws RecognitionException {
        ManchesterParser.manDL_data_type_restriction_return retval = new ManchesterParser.manDL_data_type_restriction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFT_SQUARE111=null;
        Token RIGHT_SQUARE112=null;
        ManchesterParser.manDL_facets_return fac = null;

        ManchesterParser.manDL_data_type_return manDL_data_type110 = null;


        CommonTree LEFT_SQUARE111_tree=null;
        CommonTree RIGHT_SQUARE112_tree=null;
        RewriteRuleTokenStream stream_RIGHT_SQUARE=new RewriteRuleTokenStream(adaptor,"token RIGHT_SQUARE");
        RewriteRuleTokenStream stream_LEFT_SQUARE=new RewriteRuleTokenStream(adaptor,"token LEFT_SQUARE");
        RewriteRuleSubtreeStream stream_manDL_facets=new RewriteRuleSubtreeStream(adaptor,"rule manDL_facets");
        RewriteRuleSubtreeStream stream_manDL_data_type=new RewriteRuleSubtreeStream(adaptor,"rule manDL_data_type");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:342:3: ( manDL_data_type ( LEFT_SQUARE fac= manDL_facets RIGHT_SQUARE )? -> {fac!=null}? ^( VT_DL_RESTRICTED_TYPE manDL_data_type manDL_facets ) -> ^( VT_DL_TYPE manDL_data_type ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:342:5: manDL_data_type ( LEFT_SQUARE fac= manDL_facets RIGHT_SQUARE )?
            {
            pushFollow(FOLLOW_manDL_data_type_in_manDL_data_type_restriction2110);
            manDL_data_type110=manDL_data_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_data_type.add(manDL_data_type110.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:342:21: ( LEFT_SQUARE fac= manDL_facets RIGHT_SQUARE )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:342:22: LEFT_SQUARE fac= manDL_facets RIGHT_SQUARE
                    {
                    LEFT_SQUARE111=(Token)match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_manDL_data_type_restriction2113); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LEFT_SQUARE.add(LEFT_SQUARE111);

                    pushFollow(FOLLOW_manDL_facets_in_manDL_data_type_restriction2117);
                    fac=manDL_facets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_facets.add(fac.getTree());
                    RIGHT_SQUARE112=(Token)match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_manDL_data_type_restriction2119); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RIGHT_SQUARE.add(RIGHT_SQUARE112);


                    }
                    break;

            }



            // AST REWRITE
            // elements: manDL_data_type, manDL_facets, manDL_data_type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 343:3: -> {fac!=null}? ^( VT_DL_RESTRICTED_TYPE manDL_data_type manDL_facets )
            if (fac!=null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:343:19: ^( VT_DL_RESTRICTED_TYPE manDL_data_type manDL_facets )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_RESTRICTED_TYPE, "VT_DL_RESTRICTED_TYPE"), root_1);

                adaptor.addChild(root_1, stream_manDL_data_type.nextTree());
                adaptor.addChild(root_1, stream_manDL_facets.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 344:3: -> ^( VT_DL_TYPE manDL_data_type )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:344:6: ^( VT_DL_TYPE manDL_data_type )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_TYPE, "VT_DL_TYPE"), root_1);

                adaptor.addChild(root_1, stream_manDL_data_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_data_type_restriction"

    public static class manDL_facets_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_facets"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:348:1: manDL_facets : manDL_facet manDL_restriction_value (more= ( COMMA manDL_facet manDL_restriction_value ) )* -> {more==null}? ^( VT_DL_RESTRICTION manDL_facet ( manDL_restriction_value )* ) -> ^( VT_AND ( ^( VT_DL_RESTRICTION manDL_facet manDL_restriction_value ) )+ ) ;
    public final ManchesterParser.manDL_facets_return manDL_facets() throws RecognitionException {
        ManchesterParser.manDL_facets_return retval = new ManchesterParser.manDL_facets_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token more=null;
        Token COMMA115=null;
        ManchesterParser.manDL_facet_return manDL_facet113 = null;

        ManchesterParser.manDL_restriction_value_return manDL_restriction_value114 = null;

        ManchesterParser.manDL_facet_return manDL_facet116 = null;

        ManchesterParser.manDL_restriction_value_return manDL_restriction_value117 = null;


        CommonTree more_tree=null;
        CommonTree COMMA115_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_manDL_facet=new RewriteRuleSubtreeStream(adaptor,"rule manDL_facet");
        RewriteRuleSubtreeStream stream_manDL_restriction_value=new RewriteRuleSubtreeStream(adaptor,"rule manDL_restriction_value");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:349:3: ( manDL_facet manDL_restriction_value (more= ( COMMA manDL_facet manDL_restriction_value ) )* -> {more==null}? ^( VT_DL_RESTRICTION manDL_facet ( manDL_restriction_value )* ) -> ^( VT_AND ( ^( VT_DL_RESTRICTION manDL_facet manDL_restriction_value ) )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:349:5: manDL_facet manDL_restriction_value (more= ( COMMA manDL_facet manDL_restriction_value ) )*
            {
            pushFollow(FOLLOW_manDL_facet_in_manDL_facets2162);
            manDL_facet113=manDL_facet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_facet.add(manDL_facet113.getTree());
            pushFollow(FOLLOW_manDL_restriction_value_in_manDL_facets2164);
            manDL_restriction_value114=manDL_restriction_value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_restriction_value.add(manDL_restriction_value114.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:349:45: (more= ( COMMA manDL_facet manDL_restriction_value ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==COMMA) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:349:45: more= ( COMMA manDL_facet manDL_restriction_value )
            	    {
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:349:46: ( COMMA manDL_facet manDL_restriction_value )
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:349:47: COMMA manDL_facet manDL_restriction_value
            	    {
            	    COMMA115=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_facets2169); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA115);

            	    pushFollow(FOLLOW_manDL_facet_in_manDL_facets2171);
            	    manDL_facet116=manDL_facet();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_facet.add(manDL_facet116.getTree());
            	    pushFollow(FOLLOW_manDL_restriction_value_in_manDL_facets2173);
            	    manDL_restriction_value117=manDL_restriction_value();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_restriction_value.add(manDL_restriction_value117.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_facet, manDL_restriction_value, manDL_restriction_value, manDL_facet
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 350:3: -> {more==null}? ^( VT_DL_RESTRICTION manDL_facet ( manDL_restriction_value )* )
            if (more==null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:350:20: ^( VT_DL_RESTRICTION manDL_facet ( manDL_restriction_value )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_RESTRICTION, "VT_DL_RESTRICTION"), root_1);

                adaptor.addChild(root_1, stream_manDL_facet.nextTree());
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:350:52: ( manDL_restriction_value )*
                while ( stream_manDL_restriction_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_restriction_value.nextTree());

                }
                stream_manDL_restriction_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 351:3: -> ^( VT_AND ( ^( VT_DL_RESTRICTION manDL_facet manDL_restriction_value ) )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:351:6: ^( VT_AND ( ^( VT_DL_RESTRICTION manDL_facet manDL_restriction_value ) )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_AND, "VT_AND"), root_1);

                if ( !(stream_manDL_facet.hasNext()||stream_manDL_restriction_value.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_facet.hasNext()||stream_manDL_restriction_value.hasNext() ) {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:351:15: ^( VT_DL_RESTRICTION manDL_facet manDL_restriction_value )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_RESTRICTION, "VT_DL_RESTRICTION"), root_2);

                    adaptor.addChild(root_2, stream_manDL_facet.nextTree());
                    adaptor.addChild(root_2, stream_manDL_restriction_value.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_manDL_facet.reset();
                stream_manDL_restriction_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_facets"

    public static class manDL_restriction_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_restriction_value"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:354:1: manDL_restriction_value : manDL_literal ;
    public final ManchesterParser.manDL_restriction_value_return manDL_restriction_value() throws RecognitionException {
        ManchesterParser.manDL_restriction_value_return retval = new ManchesterParser.manDL_restriction_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_literal_return manDL_literal118 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:355:3: ( manDL_literal )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:355:5: manDL_literal
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_literal_in_manDL_restriction_value2222);
            manDL_literal118=manDL_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_literal118.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_restriction_value"

    public static class manDL_facet_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_facet"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:358:1: manDL_facet : f= ( LENGTH_K | MINLENGTH_K | MAXLENGTH_K | PATTERN_K | LANGPATTERN_K | GEQ | GREATER | LEQ | LESS ) -> ^( VK_FACET[$f.text] ) ;
    public final ManchesterParser.manDL_facet_return manDL_facet() throws RecognitionException {
        ManchesterParser.manDL_facet_return retval = new ManchesterParser.manDL_facet_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token f=null;
        Token LENGTH_K119=null;
        Token MINLENGTH_K120=null;
        Token MAXLENGTH_K121=null;
        Token PATTERN_K122=null;
        Token LANGPATTERN_K123=null;
        Token GEQ124=null;
        Token GREATER125=null;
        Token LEQ126=null;
        Token LESS127=null;

        CommonTree f_tree=null;
        CommonTree LENGTH_K119_tree=null;
        CommonTree MINLENGTH_K120_tree=null;
        CommonTree MAXLENGTH_K121_tree=null;
        CommonTree PATTERN_K122_tree=null;
        CommonTree LANGPATTERN_K123_tree=null;
        CommonTree GEQ124_tree=null;
        CommonTree GREATER125_tree=null;
        CommonTree LEQ126_tree=null;
        CommonTree LESS127_tree=null;
        RewriteRuleTokenStream stream_LANGPATTERN_K=new RewriteRuleTokenStream(adaptor,"token LANGPATTERN_K");
        RewriteRuleTokenStream stream_MAXLENGTH_K=new RewriteRuleTokenStream(adaptor,"token MAXLENGTH_K");
        RewriteRuleTokenStream stream_GREATER=new RewriteRuleTokenStream(adaptor,"token GREATER");
        RewriteRuleTokenStream stream_LENGTH_K=new RewriteRuleTokenStream(adaptor,"token LENGTH_K");
        RewriteRuleTokenStream stream_GEQ=new RewriteRuleTokenStream(adaptor,"token GEQ");
        RewriteRuleTokenStream stream_PATTERN_K=new RewriteRuleTokenStream(adaptor,"token PATTERN_K");
        RewriteRuleTokenStream stream_MINLENGTH_K=new RewriteRuleTokenStream(adaptor,"token MINLENGTH_K");
        RewriteRuleTokenStream stream_LEQ=new RewriteRuleTokenStream(adaptor,"token LEQ");
        RewriteRuleTokenStream stream_LESS=new RewriteRuleTokenStream(adaptor,"token LESS");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:359:3: (f= ( LENGTH_K | MINLENGTH_K | MAXLENGTH_K | PATTERN_K | LANGPATTERN_K | GEQ | GREATER | LEQ | LESS ) -> ^( VK_FACET[$f.text] ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:359:5: f= ( LENGTH_K | MINLENGTH_K | MAXLENGTH_K | PATTERN_K | LANGPATTERN_K | GEQ | GREATER | LEQ | LESS )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:359:7: ( LENGTH_K | MINLENGTH_K | MAXLENGTH_K | PATTERN_K | LANGPATTERN_K | GEQ | GREATER | LEQ | LESS )
            int alt36=9;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:359:8: LENGTH_K
                    {
                    LENGTH_K119=(Token)match(input,LENGTH_K,FOLLOW_LENGTH_K_in_manDL_facet2239); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LENGTH_K.add(LENGTH_K119);


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:360:5: MINLENGTH_K
                    {
                    MINLENGTH_K120=(Token)match(input,MINLENGTH_K,FOLLOW_MINLENGTH_K_in_manDL_facet2245); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINLENGTH_K.add(MINLENGTH_K120);


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:361:5: MAXLENGTH_K
                    {
                    MAXLENGTH_K121=(Token)match(input,MAXLENGTH_K,FOLLOW_MAXLENGTH_K_in_manDL_facet2251); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MAXLENGTH_K.add(MAXLENGTH_K121);


                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:362:5: PATTERN_K
                    {
                    PATTERN_K122=(Token)match(input,PATTERN_K,FOLLOW_PATTERN_K_in_manDL_facet2257); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PATTERN_K.add(PATTERN_K122);


                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:363:5: LANGPATTERN_K
                    {
                    LANGPATTERN_K123=(Token)match(input,LANGPATTERN_K,FOLLOW_LANGPATTERN_K_in_manDL_facet2263); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LANGPATTERN_K.add(LANGPATTERN_K123);


                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:364:5: GEQ
                    {
                    GEQ124=(Token)match(input,GEQ,FOLLOW_GEQ_in_manDL_facet2269); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GEQ.add(GEQ124);


                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:365:5: GREATER
                    {
                    GREATER125=(Token)match(input,GREATER,FOLLOW_GREATER_in_manDL_facet2275); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GREATER.add(GREATER125);


                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:366:5: LEQ
                    {
                    LEQ126=(Token)match(input,LEQ,FOLLOW_LEQ_in_manDL_facet2281); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LEQ.add(LEQ126);


                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:367:5: LESS
                    {
                    LESS127=(Token)match(input,LESS,FOLLOW_LESS_in_manDL_facet2287); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LESS.add(LESS127);


                    }
                    break;

            }



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 368:3: -> ^( VK_FACET[$f.text] )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:368:6: ^( VK_FACET[$f.text] )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VK_FACET, (f!=null?f.getText():null)), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_facet"

    public static class manDL_datatype_def_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_datatype_def"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:381:1: manDL_datatype_def : typ= DATATYPE_K COLON iri ( manDL_datatype_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATATYPE ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_datatype_frame )* ) ;
    public final ManchesterParser.manDL_datatype_def_return manDL_datatype_def() throws RecognitionException {
        ManchesterParser.manDL_datatype_def_return retval = new ManchesterParser.manDL_datatype_def_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token typ=null;
        Token COLON128=null;
        ManchesterParser.iri_return iri129 = null;

        ManchesterParser.manDL_datatype_frame_return manDL_datatype_frame130 = null;


        CommonTree typ_tree=null;
        CommonTree COLON128_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_DATATYPE_K=new RewriteRuleTokenStream(adaptor,"token DATATYPE_K");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        RewriteRuleSubtreeStream stream_manDL_datatype_frame=new RewriteRuleSubtreeStream(adaptor,"rule manDL_datatype_frame");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:382:3: (typ= DATATYPE_K COLON iri ( manDL_datatype_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATATYPE ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_datatype_frame )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:383:5: typ= DATATYPE_K COLON iri ( manDL_datatype_frame )*
            {
            typ=(Token)match(input,DATATYPE_K,FOLLOW_DATATYPE_K_in_manDL_datatype_def2336); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DATATYPE_K.add(typ);

            COLON128=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_datatype_def2338); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON128);

            pushFollow(FOLLOW_iri_in_manDL_datatype_def2346);
            iri129=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri129.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:385:7: ( manDL_datatype_frame )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:385:7: manDL_datatype_frame
            	    {
            	    pushFollow(FOLLOW_manDL_datatype_frame_in_manDL_datatype_def2354);
            	    manDL_datatype_frame130=manDL_datatype_frame();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_datatype_frame.add(manDL_datatype_frame130.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);



            // AST REWRITE
            // elements: iri, manDL_datatype_frame
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 386:3: -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATATYPE ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_datatype_frame )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:386:6: ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATATYPE ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_datatype_frame )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE, "VT_TYPE_DECLARE"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:386:24: ^( VT_ENTITY_TYPE_DATATYPE )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ENTITY_TYPE_DATATYPE, "VT_ENTITY_TYPE_DATATYPE"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:386:51: ^( VT_TYPE_DECLARE_ID iri )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE_ID, "VT_TYPE_DECLARE_ID"), root_2);

                adaptor.addChild(root_2, stream_iri.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:386:77: ( manDL_datatype_frame )*
                while ( stream_manDL_datatype_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_datatype_frame.nextTree());

                }
                stream_manDL_datatype_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_datatype_def"

    public static class manDL_datatype_frame_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_datatype_frame"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:389:1: manDL_datatype_frame : ( manDL_annotations | manDL_equivalentTo );
    public final ManchesterParser.manDL_datatype_frame_return manDL_datatype_frame() throws RecognitionException {
        ManchesterParser.manDL_datatype_frame_return retval = new ManchesterParser.manDL_datatype_frame_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations131 = null;

        ManchesterParser.manDL_equivalentTo_return manDL_equivalentTo132 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:390:3: ( manDL_annotations | manDL_equivalentTo )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==ANNOTATIONS_K) ) {
                alt38=1;
            }
            else if ( (LA38_0==EQUIVALENTTO_K) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:390:5: manDL_annotations
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotations_in_manDL_datatype_frame2390);
                    manDL_annotations131=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations131.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:391:5: manDL_equivalentTo
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_equivalentTo_in_manDL_datatype_frame2396);
                    manDL_equivalentTo132=manDL_equivalentTo();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_equivalentTo132.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_datatype_frame"

    public static class manDL_objectProperty_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_objectProperty"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:398:1: manDL_objectProperty : typ= OBJECTPROPERTY_K COLON iri ( manDL_objProp_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_OBJPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_objProp_frame )* ) ;
    public final ManchesterParser.manDL_objectProperty_return manDL_objectProperty() throws RecognitionException {
        ManchesterParser.manDL_objectProperty_return retval = new ManchesterParser.manDL_objectProperty_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token typ=null;
        Token COLON133=null;
        ManchesterParser.iri_return iri134 = null;

        ManchesterParser.manDL_objProp_frame_return manDL_objProp_frame135 = null;


        CommonTree typ_tree=null;
        CommonTree COLON133_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_OBJECTPROPERTY_K=new RewriteRuleTokenStream(adaptor,"token OBJECTPROPERTY_K");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        RewriteRuleSubtreeStream stream_manDL_objProp_frame=new RewriteRuleSubtreeStream(adaptor,"rule manDL_objProp_frame");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:399:3: (typ= OBJECTPROPERTY_K COLON iri ( manDL_objProp_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_OBJPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_objProp_frame )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:399:5: typ= OBJECTPROPERTY_K COLON iri ( manDL_objProp_frame )*
            {
            typ=(Token)match(input,OBJECTPROPERTY_K,FOLLOW_OBJECTPROPERTY_K_in_manDL_objectProperty2426); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OBJECTPROPERTY_K.add(typ);

            COLON133=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_objectProperty2428); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON133);

            pushFollow(FOLLOW_iri_in_manDL_objectProperty2436);
            iri134=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri134.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:401:7: ( manDL_objProp_frame )*
            loop39:
            do {
                int alt39=2;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:401:7: manDL_objProp_frame
            	    {
            	    pushFollow(FOLLOW_manDL_objProp_frame_in_manDL_objectProperty2444);
            	    manDL_objProp_frame135=manDL_objProp_frame();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_objProp_frame.add(manDL_objProp_frame135.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);



            // AST REWRITE
            // elements: iri, manDL_objProp_frame
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 402:3: -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_OBJPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_objProp_frame )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:402:6: ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_OBJPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_objProp_frame )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE, "VT_TYPE_DECLARE"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:402:24: ^( VT_ENTITY_TYPE_OBJPROP )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ENTITY_TYPE_OBJPROP, "VT_ENTITY_TYPE_OBJPROP"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:402:50: ^( VT_TYPE_DECLARE_ID iri )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE_ID, "VT_TYPE_DECLARE_ID"), root_2);

                adaptor.addChild(root_2, stream_iri.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:404:9: ( manDL_objProp_frame )*
                while ( stream_manDL_objProp_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_objProp_frame.nextTree());

                }
                stream_manDL_objProp_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_objectProperty"

    public static class manDL_objProp_frame_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_objProp_frame"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:407:1: manDL_objProp_frame : ( manDL_annotations | manDL_attributes | manDL_disjointWith | manDL_equivalentTo | manDL_inverseOf | manDL_domain | manDL_range | manDL_subPropertyOf | manDL_subPropChain );
    public final ManchesterParser.manDL_objProp_frame_return manDL_objProp_frame() throws RecognitionException {
        ManchesterParser.manDL_objProp_frame_return retval = new ManchesterParser.manDL_objProp_frame_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations136 = null;

        ManchesterParser.manDL_attributes_return manDL_attributes137 = null;

        ManchesterParser.manDL_disjointWith_return manDL_disjointWith138 = null;

        ManchesterParser.manDL_equivalentTo_return manDL_equivalentTo139 = null;

        ManchesterParser.manDL_inverseOf_return manDL_inverseOf140 = null;

        ManchesterParser.manDL_domain_return manDL_domain141 = null;

        ManchesterParser.manDL_range_return manDL_range142 = null;

        ManchesterParser.manDL_subPropertyOf_return manDL_subPropertyOf143 = null;

        ManchesterParser.manDL_subPropChain_return manDL_subPropChain144 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:408:3: ( manDL_annotations | manDL_attributes | manDL_disjointWith | manDL_equivalentTo | manDL_inverseOf | manDL_domain | manDL_range | manDL_subPropertyOf | manDL_subPropChain )
            int alt40=9;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:408:5: manDL_annotations
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotations_in_manDL_objProp_frame2499);
                    manDL_annotations136=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations136.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:409:5: manDL_attributes
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_attributes_in_manDL_objProp_frame2505);
                    manDL_attributes137=manDL_attributes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_attributes137.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:410:5: manDL_disjointWith
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_disjointWith_in_manDL_objProp_frame2511);
                    manDL_disjointWith138=manDL_disjointWith();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_disjointWith138.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:411:5: manDL_equivalentTo
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_equivalentTo_in_manDL_objProp_frame2517);
                    manDL_equivalentTo139=manDL_equivalentTo();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_equivalentTo139.getTree());

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:412:5: manDL_inverseOf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_inverseOf_in_manDL_objProp_frame2523);
                    manDL_inverseOf140=manDL_inverseOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_inverseOf140.getTree());

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:413:5: manDL_domain
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_domain_in_manDL_objProp_frame2529);
                    manDL_domain141=manDL_domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_domain141.getTree());

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:414:5: manDL_range
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_range_in_manDL_objProp_frame2537);
                    manDL_range142=manDL_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_range142.getTree());

                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:415:5: manDL_subPropertyOf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_subPropertyOf_in_manDL_objProp_frame2543);
                    manDL_subPropertyOf143=manDL_subPropertyOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_subPropertyOf143.getTree());

                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:416:5: manDL_subPropChain
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_subPropChain_in_manDL_objProp_frame2549);
                    manDL_subPropChain144=manDL_subPropChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_subPropChain144.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_objProp_frame"

    public static class manDL_dataProperty_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_dataProperty"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:421:1: manDL_dataProperty : typ= DATAPROPERTY_K COLON iri ( manDL_dataProp_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATAPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_dataProp_frame )* ) ;
    public final ManchesterParser.manDL_dataProperty_return manDL_dataProperty() throws RecognitionException {
        ManchesterParser.manDL_dataProperty_return retval = new ManchesterParser.manDL_dataProperty_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token typ=null;
        Token COLON145=null;
        ManchesterParser.iri_return iri146 = null;

        ManchesterParser.manDL_dataProp_frame_return manDL_dataProp_frame147 = null;


        CommonTree typ_tree=null;
        CommonTree COLON145_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_DATAPROPERTY_K=new RewriteRuleTokenStream(adaptor,"token DATAPROPERTY_K");
        RewriteRuleSubtreeStream stream_manDL_dataProp_frame=new RewriteRuleSubtreeStream(adaptor,"rule manDL_dataProp_frame");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:422:3: (typ= DATAPROPERTY_K COLON iri ( manDL_dataProp_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATAPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_dataProp_frame )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:423:3: typ= DATAPROPERTY_K COLON iri ( manDL_dataProp_frame )*
            {
            typ=(Token)match(input,DATAPROPERTY_K,FOLLOW_DATAPROPERTY_K_in_manDL_dataProperty2581); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DATAPROPERTY_K.add(typ);

            COLON145=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_dataProperty2583); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON145);

            pushFollow(FOLLOW_iri_in_manDL_dataProperty2592);
            iri146=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri146.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:426:7: ( manDL_dataProp_frame )*
            loop41:
            do {
                int alt41=2;
                alt41 = dfa41.predict(input);
                switch (alt41) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:426:7: manDL_dataProp_frame
            	    {
            	    pushFollow(FOLLOW_manDL_dataProp_frame_in_manDL_dataProperty2606);
            	    manDL_dataProp_frame147=manDL_dataProp_frame();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_dataProp_frame.add(manDL_dataProp_frame147.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);



            // AST REWRITE
            // elements: iri, manDL_dataProp_frame
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 427:3: -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATAPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_dataProp_frame )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:427:6: ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_DATAPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_dataProp_frame )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE, "VT_TYPE_DECLARE"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:427:24: ^( VT_ENTITY_TYPE_DATAPROP )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ENTITY_TYPE_DATAPROP, "VT_ENTITY_TYPE_DATAPROP"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:427:51: ^( VT_TYPE_DECLARE_ID iri )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE_ID, "VT_TYPE_DECLARE_ID"), root_2);

                adaptor.addChild(root_2, stream_iri.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:429:9: ( manDL_dataProp_frame )*
                while ( stream_manDL_dataProp_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_dataProp_frame.nextTree());

                }
                stream_manDL_dataProp_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_dataProperty"

    public static class manDL_dataProp_frame_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_dataProp_frame"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:433:1: manDL_dataProp_frame : ( manDL_annotations | manDL_domain | manDL_range | manDL_attributes | manDL_disjointWith | manDL_equivalentTo | manDL_subPropertyOf );
    public final ManchesterParser.manDL_dataProp_frame_return manDL_dataProp_frame() throws RecognitionException {
        ManchesterParser.manDL_dataProp_frame_return retval = new ManchesterParser.manDL_dataProp_frame_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations148 = null;

        ManchesterParser.manDL_domain_return manDL_domain149 = null;

        ManchesterParser.manDL_range_return manDL_range150 = null;

        ManchesterParser.manDL_attributes_return manDL_attributes151 = null;

        ManchesterParser.manDL_disjointWith_return manDL_disjointWith152 = null;

        ManchesterParser.manDL_equivalentTo_return manDL_equivalentTo153 = null;

        ManchesterParser.manDL_subPropertyOf_return manDL_subPropertyOf154 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:434:3: ( manDL_annotations | manDL_domain | manDL_range | manDL_attributes | manDL_disjointWith | manDL_equivalentTo | manDL_subPropertyOf )
            int alt42=7;
            switch ( input.LA(1) ) {
            case ANNOTATIONS_K:
                {
                alt42=1;
                }
                break;
            case DOMAIN_K:
                {
                alt42=2;
                }
                break;
            case RANGE_K:
                {
                alt42=3;
                }
                break;
            case CHARACTERISTICS_K:
                {
                alt42=4;
                }
                break;
            case DISJOINTWITH_K:
                {
                alt42=5;
                }
                break;
            case EQUIVALENTTO_K:
                {
                alt42=6;
                }
                break;
            case SUBPROPERTYOF_K:
                {
                alt42=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:434:5: manDL_annotations
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotations_in_manDL_dataProp_frame2663);
                    manDL_annotations148=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations148.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:435:5: manDL_domain
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_domain_in_manDL_dataProp_frame2669);
                    manDL_domain149=manDL_domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_domain149.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:436:5: manDL_range
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_range_in_manDL_dataProp_frame2677);
                    manDL_range150=manDL_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_range150.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:437:5: manDL_attributes
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_attributes_in_manDL_dataProp_frame2685);
                    manDL_attributes151=manDL_attributes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_attributes151.getTree());

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:438:5: manDL_disjointWith
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_disjointWith_in_manDL_dataProp_frame2695);
                    manDL_disjointWith152=manDL_disjointWith();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_disjointWith152.getTree());

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:439:5: manDL_equivalentTo
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_equivalentTo_in_manDL_dataProp_frame2701);
                    manDL_equivalentTo153=manDL_equivalentTo();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_equivalentTo153.getTree());

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:440:5: manDL_subPropertyOf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_subPropertyOf_in_manDL_dataProp_frame2707);
                    manDL_subPropertyOf154=manDL_subPropertyOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_subPropertyOf154.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_dataProp_frame"

    public static class manDL_domain_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_domain"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:444:1: manDL_domain : DOMAIN_K COLON manDL_annotated_description_list -> ^( VT_DOMAIN manDL_annotated_description_list ) ;
    public final ManchesterParser.manDL_domain_return manDL_domain() throws RecognitionException {
        ManchesterParser.manDL_domain_return retval = new ManchesterParser.manDL_domain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOMAIN_K155=null;
        Token COLON156=null;
        ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list157 = null;


        CommonTree DOMAIN_K155_tree=null;
        CommonTree COLON156_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_DOMAIN_K=new RewriteRuleTokenStream(adaptor,"token DOMAIN_K");
        RewriteRuleSubtreeStream stream_manDL_annotated_description_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_description_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:445:3: ( DOMAIN_K COLON manDL_annotated_description_list -> ^( VT_DOMAIN manDL_annotated_description_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:445:5: DOMAIN_K COLON manDL_annotated_description_list
            {
            DOMAIN_K155=(Token)match(input,DOMAIN_K,FOLLOW_DOMAIN_K_in_manDL_domain2728); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DOMAIN_K.add(DOMAIN_K155);

            COLON156=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_domain2730); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON156);

            pushFollow(FOLLOW_manDL_annotated_description_list_in_manDL_domain2732);
            manDL_annotated_description_list157=manDL_annotated_description_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_description_list.add(manDL_annotated_description_list157.getTree());


            // AST REWRITE
            // elements: manDL_annotated_description_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 446:3: -> ^( VT_DOMAIN manDL_annotated_description_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:446:6: ^( VT_DOMAIN manDL_annotated_description_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DOMAIN, "VT_DOMAIN"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotated_description_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_domain"

    public static class manDL_range_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_range"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:449:1: manDL_range : RANGE_K COLON manDL_annotated_description_list -> ^( VT_RANGE manDL_annotated_description_list ) ;
    public final ManchesterParser.manDL_range_return manDL_range() throws RecognitionException {
        ManchesterParser.manDL_range_return retval = new ManchesterParser.manDL_range_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RANGE_K158=null;
        Token COLON159=null;
        ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list160 = null;


        CommonTree RANGE_K158_tree=null;
        CommonTree COLON159_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RANGE_K=new RewriteRuleTokenStream(adaptor,"token RANGE_K");
        RewriteRuleSubtreeStream stream_manDL_annotated_description_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_description_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:450:3: ( RANGE_K COLON manDL_annotated_description_list -> ^( VT_RANGE manDL_annotated_description_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:450:5: RANGE_K COLON manDL_annotated_description_list
            {
            RANGE_K158=(Token)match(input,RANGE_K,FOLLOW_RANGE_K_in_manDL_range2757); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE_K.add(RANGE_K158);

            COLON159=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_range2759); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON159);

            pushFollow(FOLLOW_manDL_annotated_description_list_in_manDL_range2761);
            manDL_annotated_description_list160=manDL_annotated_description_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_description_list.add(manDL_annotated_description_list160.getTree());


            // AST REWRITE
            // elements: manDL_annotated_description_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 451:3: -> ^( VT_RANGE manDL_annotated_description_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:451:6: ^( VT_RANGE manDL_annotated_description_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_RANGE, "VT_RANGE"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotated_description_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_range"

    public static class manDL_subPropertyOf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_subPropertyOf"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:458:1: manDL_subPropertyOf : SUBPROPERTYOF_K COLON manDL_property_list -> ^( VT_SUBPROPERTYOF manDL_property_list ) ;
    public final ManchesterParser.manDL_subPropertyOf_return manDL_subPropertyOf() throws RecognitionException {
        ManchesterParser.manDL_subPropertyOf_return retval = new ManchesterParser.manDL_subPropertyOf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUBPROPERTYOF_K161=null;
        Token COLON162=null;
        ManchesterParser.manDL_property_list_return manDL_property_list163 = null;


        CommonTree SUBPROPERTYOF_K161_tree=null;
        CommonTree COLON162_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SUBPROPERTYOF_K=new RewriteRuleTokenStream(adaptor,"token SUBPROPERTYOF_K");
        RewriteRuleSubtreeStream stream_manDL_property_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:459:3: ( SUBPROPERTYOF_K COLON manDL_property_list -> ^( VT_SUBPROPERTYOF manDL_property_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:459:5: SUBPROPERTYOF_K COLON manDL_property_list
            {
            SUBPROPERTYOF_K161=(Token)match(input,SUBPROPERTYOF_K,FOLLOW_SUBPROPERTYOF_K_in_manDL_subPropertyOf2798); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SUBPROPERTYOF_K.add(SUBPROPERTYOF_K161);

            COLON162=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_subPropertyOf2800); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON162);

            pushFollow(FOLLOW_manDL_property_list_in_manDL_subPropertyOf2802);
            manDL_property_list163=manDL_property_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_property_list.add(manDL_property_list163.getTree());


            // AST REWRITE
            // elements: manDL_property_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 460:3: -> ^( VT_SUBPROPERTYOF manDL_property_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:460:6: ^( VT_SUBPROPERTYOF manDL_property_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_SUBPROPERTYOF, "VT_SUBPROPERTYOF"), root_1);

                adaptor.addChild(root_1, stream_manDL_property_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_subPropertyOf"

    public static class manDL_inverseOf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_inverseOf"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:463:1: manDL_inverseOf : INVERSEOF_K COLON manDL_property_list -> ^( VT_INVERSEOF manDL_property_list ) ;
    public final ManchesterParser.manDL_inverseOf_return manDL_inverseOf() throws RecognitionException {
        ManchesterParser.manDL_inverseOf_return retval = new ManchesterParser.manDL_inverseOf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INVERSEOF_K164=null;
        Token COLON165=null;
        ManchesterParser.manDL_property_list_return manDL_property_list166 = null;


        CommonTree INVERSEOF_K164_tree=null;
        CommonTree COLON165_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INVERSEOF_K=new RewriteRuleTokenStream(adaptor,"token INVERSEOF_K");
        RewriteRuleSubtreeStream stream_manDL_property_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:464:3: ( INVERSEOF_K COLON manDL_property_list -> ^( VT_INVERSEOF manDL_property_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:464:5: INVERSEOF_K COLON manDL_property_list
            {
            INVERSEOF_K164=(Token)match(input,INVERSEOF_K,FOLLOW_INVERSEOF_K_in_manDL_inverseOf2829); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INVERSEOF_K.add(INVERSEOF_K164);

            COLON165=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_inverseOf2831); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON165);

            pushFollow(FOLLOW_manDL_property_list_in_manDL_inverseOf2833);
            manDL_property_list166=manDL_property_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_property_list.add(manDL_property_list166.getTree());


            // AST REWRITE
            // elements: manDL_property_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 465:3: -> ^( VT_INVERSEOF manDL_property_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:465:6: ^( VT_INVERSEOF manDL_property_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_INVERSEOF, "VT_INVERSEOF"), root_1);

                adaptor.addChild(root_1, stream_manDL_property_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_inverseOf"

    public static class manDL_subPropChain_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_subPropChain"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:468:1: manDL_subPropChain : SUBPROPERTYCHAIN_K COLON ( manDL_annotations )? manDL_property_expression ( CHAIN manDL_property_expression )* -> ^( VT_SUBPROPERTYCHAIN ( manDL_annotations )? ( manDL_property_expression )+ ) ;
    public final ManchesterParser.manDL_subPropChain_return manDL_subPropChain() throws RecognitionException {
        ManchesterParser.manDL_subPropChain_return retval = new ManchesterParser.manDL_subPropChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUBPROPERTYCHAIN_K167=null;
        Token COLON168=null;
        Token CHAIN171=null;
        ManchesterParser.manDL_annotations_return manDL_annotations169 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression170 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression172 = null;


        CommonTree SUBPROPERTYCHAIN_K167_tree=null;
        CommonTree COLON168_tree=null;
        CommonTree CHAIN171_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SUBPROPERTYCHAIN_K=new RewriteRuleTokenStream(adaptor,"token SUBPROPERTYCHAIN_K");
        RewriteRuleTokenStream stream_CHAIN=new RewriteRuleTokenStream(adaptor,"token CHAIN");
        RewriteRuleSubtreeStream stream_manDL_property_expression=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_expression");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:469:3: ( SUBPROPERTYCHAIN_K COLON ( manDL_annotations )? manDL_property_expression ( CHAIN manDL_property_expression )* -> ^( VT_SUBPROPERTYCHAIN ( manDL_annotations )? ( manDL_property_expression )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:469:5: SUBPROPERTYCHAIN_K COLON ( manDL_annotations )? manDL_property_expression ( CHAIN manDL_property_expression )*
            {
            SUBPROPERTYCHAIN_K167=(Token)match(input,SUBPROPERTYCHAIN_K,FOLLOW_SUBPROPERTYCHAIN_K_in_manDL_subPropChain2858); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SUBPROPERTYCHAIN_K.add(SUBPROPERTYCHAIN_K167);

            COLON168=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_subPropChain2860); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON168);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:469:30: ( manDL_annotations )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==ANNOTATIONS_K) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:469:30: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_subPropChain2862);
                    manDL_annotations169=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations169.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_property_expression_in_manDL_subPropChain2865);
            manDL_property_expression170=manDL_property_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression170.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:469:75: ( CHAIN manDL_property_expression )*
            loop44:
            do {
                int alt44=2;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:469:77: CHAIN manDL_property_expression
            	    {
            	    CHAIN171=(Token)match(input,CHAIN,FOLLOW_CHAIN_in_manDL_subPropChain2869); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CHAIN.add(CHAIN171);

            	    pushFollow(FOLLOW_manDL_property_expression_in_manDL_subPropChain2871);
            	    manDL_property_expression172=manDL_property_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression172.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_property_expression, manDL_annotations
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 470:3: -> ^( VT_SUBPROPERTYCHAIN ( manDL_annotations )? ( manDL_property_expression )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:470:6: ^( VT_SUBPROPERTYCHAIN ( manDL_annotations )? ( manDL_property_expression )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_SUBPROPERTYCHAIN, "VT_SUBPROPERTYCHAIN"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:470:28: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();
                if ( !(stream_manDL_property_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_property_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());

                }
                stream_manDL_property_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_subPropChain"

    public static class manDL_annotationProperty_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotationProperty"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:480:1: manDL_annotationProperty : typ= ANNOTATIONPROPERTY_K COLON iri ( manDL_annProp_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_ANNPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_annProp_frame )* ) ;
    public final ManchesterParser.manDL_annotationProperty_return manDL_annotationProperty() throws RecognitionException {
        ManchesterParser.manDL_annotationProperty_return retval = new ManchesterParser.manDL_annotationProperty_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token typ=null;
        Token COLON173=null;
        ManchesterParser.iri_return iri174 = null;

        ManchesterParser.manDL_annProp_frame_return manDL_annProp_frame175 = null;


        CommonTree typ_tree=null;
        CommonTree COLON173_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_ANNOTATIONPROPERTY_K=new RewriteRuleTokenStream(adaptor,"token ANNOTATIONPROPERTY_K");
        RewriteRuleSubtreeStream stream_manDL_annProp_frame=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annProp_frame");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:481:3: (typ= ANNOTATIONPROPERTY_K COLON iri ( manDL_annProp_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_ANNPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_annProp_frame )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:481:5: typ= ANNOTATIONPROPERTY_K COLON iri ( manDL_annProp_frame )*
            {
            typ=(Token)match(input,ANNOTATIONPROPERTY_K,FOLLOW_ANNOTATIONPROPERTY_K_in_manDL_annotationProperty2918); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ANNOTATIONPROPERTY_K.add(typ);

            COLON173=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_annotationProperty2920); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON173);

            pushFollow(FOLLOW_iri_in_manDL_annotationProperty2928);
            iri174=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri174.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:483:7: ( manDL_annProp_frame )*
            loop45:
            do {
                int alt45=2;
                alt45 = dfa45.predict(input);
                switch (alt45) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:483:7: manDL_annProp_frame
            	    {
            	    pushFollow(FOLLOW_manDL_annProp_frame_in_manDL_annotationProperty2936);
            	    manDL_annProp_frame175=manDL_annProp_frame();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_annProp_frame.add(manDL_annProp_frame175.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);



            // AST REWRITE
            // elements: iri, manDL_annProp_frame
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 484:3: -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_ANNPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_annProp_frame )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:484:6: ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_ANNPROP ) ^( VT_TYPE_DECLARE_ID iri ) ( manDL_annProp_frame )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE, "VT_TYPE_DECLARE"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:484:24: ^( VT_ENTITY_TYPE_ANNPROP )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ENTITY_TYPE_ANNPROP, "VT_ENTITY_TYPE_ANNPROP"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:484:50: ^( VT_TYPE_DECLARE_ID iri )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE_ID, "VT_TYPE_DECLARE_ID"), root_2);

                adaptor.addChild(root_2, stream_iri.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:484:76: ( manDL_annProp_frame )*
                while ( stream_manDL_annProp_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annProp_frame.nextTree());

                }
                stream_manDL_annProp_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotationProperty"

    public static class manDL_annProp_frame_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annProp_frame"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:488:1: manDL_annProp_frame : ( manDL_annotations | manDL_domain | manDL_range | manDL_subPropertyOf );
    public final ManchesterParser.manDL_annProp_frame_return manDL_annProp_frame() throws RecognitionException {
        ManchesterParser.manDL_annProp_frame_return retval = new ManchesterParser.manDL_annProp_frame_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations176 = null;

        ManchesterParser.manDL_domain_return manDL_domain177 = null;

        ManchesterParser.manDL_range_return manDL_range178 = null;

        ManchesterParser.manDL_subPropertyOf_return manDL_subPropertyOf179 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:489:3: ( manDL_annotations | manDL_domain | manDL_range | manDL_subPropertyOf )
            int alt46=4;
            switch ( input.LA(1) ) {
            case ANNOTATIONS_K:
                {
                alt46=1;
                }
                break;
            case DOMAIN_K:
                {
                alt46=2;
                }
                break;
            case RANGE_K:
                {
                alt46=3;
                }
                break;
            case SUBPROPERTYOF_K:
                {
                alt46=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:489:5: manDL_annotations
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotations_in_manDL_annProp_frame2978);
                    manDL_annotations176=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations176.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:490:5: manDL_domain
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_domain_in_manDL_annProp_frame2984);
                    manDL_domain177=manDL_domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_domain177.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:491:5: manDL_range
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_range_in_manDL_annProp_frame2992);
                    manDL_range178=manDL_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_range178.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:492:5: manDL_subPropertyOf
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_subPropertyOf_in_manDL_annProp_frame2998);
                    manDL_subPropertyOf179=manDL_subPropertyOf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_subPropertyOf179.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annProp_frame"

    public static class manDL_namedIndividual_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_namedIndividual"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:501:1: manDL_namedIndividual : typ= INDIVIDUAL_K COLON iri ( manDL_indiv_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_INDIVIDUAL ) ^( VT_NAME iri ) ( manDL_indiv_frame )* ) ;
    public final ManchesterParser.manDL_namedIndividual_return manDL_namedIndividual() throws RecognitionException {
        ManchesterParser.manDL_namedIndividual_return retval = new ManchesterParser.manDL_namedIndividual_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token typ=null;
        Token COLON180=null;
        ManchesterParser.iri_return iri181 = null;

        ManchesterParser.manDL_indiv_frame_return manDL_indiv_frame182 = null;


        CommonTree typ_tree=null;
        CommonTree COLON180_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INDIVIDUAL_K=new RewriteRuleTokenStream(adaptor,"token INDIVIDUAL_K");
        RewriteRuleSubtreeStream stream_manDL_indiv_frame=new RewriteRuleSubtreeStream(adaptor,"rule manDL_indiv_frame");
        RewriteRuleSubtreeStream stream_iri=new RewriteRuleSubtreeStream(adaptor,"rule iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:502:3: (typ= INDIVIDUAL_K COLON iri ( manDL_indiv_frame )* -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_INDIVIDUAL ) ^( VT_NAME iri ) ( manDL_indiv_frame )* ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:502:5: typ= INDIVIDUAL_K COLON iri ( manDL_indiv_frame )*
            {
            typ=(Token)match(input,INDIVIDUAL_K,FOLLOW_INDIVIDUAL_K_in_manDL_namedIndividual3034); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INDIVIDUAL_K.add(typ);

            COLON180=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_namedIndividual3036); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON180);

            pushFollow(FOLLOW_iri_in_manDL_namedIndividual3044);
            iri181=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_iri.add(iri181.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:504:7: ( manDL_indiv_frame )*
            loop47:
            do {
                int alt47=2;
                alt47 = dfa47.predict(input);
                switch (alt47) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:504:7: manDL_indiv_frame
            	    {
            	    pushFollow(FOLLOW_manDL_indiv_frame_in_manDL_namedIndividual3052);
            	    manDL_indiv_frame182=manDL_indiv_frame();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_indiv_frame.add(manDL_indiv_frame182.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_indiv_frame, iri
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 505:3: -> ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_INDIVIDUAL ) ^( VT_NAME iri ) ( manDL_indiv_frame )* )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:505:6: ^( VT_TYPE_DECLARE ^( VT_ENTITY_TYPE_INDIVIDUAL ) ^( VT_NAME iri ) ( manDL_indiv_frame )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPE_DECLARE, "VT_TYPE_DECLARE"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:505:24: ^( VT_ENTITY_TYPE_INDIVIDUAL )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ENTITY_TYPE_INDIVIDUAL, "VT_ENTITY_TYPE_INDIVIDUAL"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:505:53: ^( VT_NAME iri )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NAME, "VT_NAME"), root_2);

                adaptor.addChild(root_2, stream_iri.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:505:68: ( manDL_indiv_frame )*
                while ( stream_manDL_indiv_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_indiv_frame.nextTree());

                }
                stream_manDL_indiv_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_namedIndividual"

    public static class manDL_indiv_frame_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_indiv_frame"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:508:1: manDL_indiv_frame : ( manDL_annotations | manDL_types | manDL_facts | manDL_sameAs | manDL_differentFrom );
    public final ManchesterParser.manDL_indiv_frame_return manDL_indiv_frame() throws RecognitionException {
        ManchesterParser.manDL_indiv_frame_return retval = new ManchesterParser.manDL_indiv_frame_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations183 = null;

        ManchesterParser.manDL_types_return manDL_types184 = null;

        ManchesterParser.manDL_facts_return manDL_facts185 = null;

        ManchesterParser.manDL_sameAs_return manDL_sameAs186 = null;

        ManchesterParser.manDL_differentFrom_return manDL_differentFrom187 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:509:3: ( manDL_annotations | manDL_types | manDL_facts | manDL_sameAs | manDL_differentFrom )
            int alt48=5;
            switch ( input.LA(1) ) {
            case ANNOTATIONS_K:
                {
                alt48=1;
                }
                break;
            case TYPES_K:
                {
                alt48=2;
                }
                break;
            case FACTS_K:
                {
                alt48=3;
                }
                break;
            case SAMEAS_K:
                {
                alt48=4;
                }
                break;
            case DIFFERENTFROM_K:
                {
                alt48=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:509:5: manDL_annotations
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_annotations_in_manDL_indiv_frame3092);
                    manDL_annotations183=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations183.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:510:5: manDL_types
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_types_in_manDL_indiv_frame3098);
                    manDL_types184=manDL_types();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_types184.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:511:5: manDL_facts
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_facts_in_manDL_indiv_frame3104);
                    manDL_facts185=manDL_facts();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_facts185.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:512:5: manDL_sameAs
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_sameAs_in_manDL_indiv_frame3110);
                    manDL_sameAs186=manDL_sameAs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_sameAs186.getTree());

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:513:5: manDL_differentFrom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_differentFrom_in_manDL_indiv_frame3116);
                    manDL_differentFrom187=manDL_differentFrom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_differentFrom187.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_indiv_frame"

    public static class manDL_types_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_types"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:516:1: manDL_types : TYPES_K COLON manDL_annotated_description_list -> ^( VT_TYPES manDL_annotated_description_list ) ;
    public final ManchesterParser.manDL_types_return manDL_types() throws RecognitionException {
        ManchesterParser.manDL_types_return retval = new ManchesterParser.manDL_types_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TYPES_K188=null;
        Token COLON189=null;
        ManchesterParser.manDL_annotated_description_list_return manDL_annotated_description_list190 = null;


        CommonTree TYPES_K188_tree=null;
        CommonTree COLON189_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_TYPES_K=new RewriteRuleTokenStream(adaptor,"token TYPES_K");
        RewriteRuleSubtreeStream stream_manDL_annotated_description_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_description_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:517:3: ( TYPES_K COLON manDL_annotated_description_list -> ^( VT_TYPES manDL_annotated_description_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:517:5: TYPES_K COLON manDL_annotated_description_list
            {
            TYPES_K188=(Token)match(input,TYPES_K,FOLLOW_TYPES_K_in_manDL_types3133); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TYPES_K.add(TYPES_K188);

            COLON189=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_types3135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON189);

            pushFollow(FOLLOW_manDL_annotated_description_list_in_manDL_types3137);
            manDL_annotated_description_list190=manDL_annotated_description_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_description_list.add(manDL_annotated_description_list190.getTree());


            // AST REWRITE
            // elements: manDL_annotated_description_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 518:3: -> ^( VT_TYPES manDL_annotated_description_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:518:6: ^( VT_TYPES manDL_annotated_description_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_TYPES, "VT_TYPES"), root_1);

                adaptor.addChild(root_1, stream_manDL_annotated_description_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_types"

    public static class manDL_individual_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_individual_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:521:1: manDL_individual_list : manDL_annotated_individual ( COMMA manDL_annotated_individual )* -> ^( VT_LIST ( manDL_annotated_individual )+ ) ;
    public final ManchesterParser.manDL_individual_list_return manDL_individual_list() throws RecognitionException {
        ManchesterParser.manDL_individual_list_return retval = new ManchesterParser.manDL_individual_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA192=null;
        ManchesterParser.manDL_annotated_individual_return manDL_annotated_individual191 = null;

        ManchesterParser.manDL_annotated_individual_return manDL_annotated_individual193 = null;


        CommonTree COMMA192_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_manDL_annotated_individual=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotated_individual");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:522:3: ( manDL_annotated_individual ( COMMA manDL_annotated_individual )* -> ^( VT_LIST ( manDL_annotated_individual )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:522:5: manDL_annotated_individual ( COMMA manDL_annotated_individual )*
            {
            pushFollow(FOLLOW_manDL_annotated_individual_in_manDL_individual_list3160);
            manDL_annotated_individual191=manDL_annotated_individual();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_annotated_individual.add(manDL_annotated_individual191.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:522:32: ( COMMA manDL_annotated_individual )*
            loop49:
            do {
                int alt49=2;
                alt49 = dfa49.predict(input);
                switch (alt49) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:522:33: COMMA manDL_annotated_individual
            	    {
            	    COMMA192=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_individual_list3163); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA192);

            	    pushFollow(FOLLOW_manDL_annotated_individual_in_manDL_individual_list3165);
            	    manDL_annotated_individual193=manDL_annotated_individual();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_annotated_individual.add(manDL_annotated_individual193.getTree());

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_annotated_individual
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 523:5: -> ^( VT_LIST ( manDL_annotated_individual )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:523:8: ^( VT_LIST ( manDL_annotated_individual )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_LIST, "VT_LIST"), root_1);

                if ( !(stream_manDL_annotated_individual.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_annotated_individual.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotated_individual.nextTree());

                }
                stream_manDL_annotated_individual.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_individual_list"

    public static class manDL_annotated_individual_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotated_individual"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:526:1: manDL_annotated_individual : ( manDL_annotations )? manDL_individual -> ^( manDL_individual ( manDL_annotations )? ) ;
    public final ManchesterParser.manDL_annotated_individual_return manDL_annotated_individual() throws RecognitionException {
        ManchesterParser.manDL_annotated_individual_return retval = new ManchesterParser.manDL_annotated_individual_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations194 = null;

        ManchesterParser.manDL_individual_return manDL_individual195 = null;


        RewriteRuleSubtreeStream stream_manDL_individual=new RewriteRuleSubtreeStream(adaptor,"rule manDL_individual");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:527:3: ( ( manDL_annotations )? manDL_individual -> ^( manDL_individual ( manDL_annotations )? ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:527:5: ( manDL_annotations )? manDL_individual
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:527:5: ( manDL_annotations )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==ANNOTATIONS_K) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:527:5: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_annotated_individual3195);
                    manDL_annotations194=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations194.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_individual_in_manDL_annotated_individual3198);
            manDL_individual195=manDL_individual();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_individual.add(manDL_individual195.getTree());


            // AST REWRITE
            // elements: manDL_annotations, manDL_individual
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 528:3: -> ^( manDL_individual ( manDL_annotations )? )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:528:6: ^( manDL_individual ( manDL_annotations )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_manDL_individual.nextNode(), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:528:25: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotated_individual"

    public static class manDL_facts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_facts"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:531:1: manDL_facts : FACTS_K COLON manDL_fact_annotated_list -> ^( VT_FACTS manDL_fact_annotated_list ) ;
    public final ManchesterParser.manDL_facts_return manDL_facts() throws RecognitionException {
        ManchesterParser.manDL_facts_return retval = new ManchesterParser.manDL_facts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FACTS_K196=null;
        Token COLON197=null;
        ManchesterParser.manDL_fact_annotated_list_return manDL_fact_annotated_list198 = null;


        CommonTree FACTS_K196_tree=null;
        CommonTree COLON197_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_FACTS_K=new RewriteRuleTokenStream(adaptor,"token FACTS_K");
        RewriteRuleSubtreeStream stream_manDL_fact_annotated_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_fact_annotated_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:532:3: ( FACTS_K COLON manDL_fact_annotated_list -> ^( VT_FACTS manDL_fact_annotated_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:532:5: FACTS_K COLON manDL_fact_annotated_list
            {
            FACTS_K196=(Token)match(input,FACTS_K,FOLLOW_FACTS_K_in_manDL_facts3229); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FACTS_K.add(FACTS_K196);

            COLON197=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_facts3231); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON197);

            pushFollow(FOLLOW_manDL_fact_annotated_list_in_manDL_facts3233);
            manDL_fact_annotated_list198=manDL_fact_annotated_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_fact_annotated_list.add(manDL_fact_annotated_list198.getTree());


            // AST REWRITE
            // elements: manDL_fact_annotated_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 533:3: -> ^( VT_FACTS manDL_fact_annotated_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:533:6: ^( VT_FACTS manDL_fact_annotated_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_FACTS, "VT_FACTS"), root_1);

                adaptor.addChild(root_1, stream_manDL_fact_annotated_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_facts"

    public static class manDL_fact_annotated_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_fact_annotated_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:536:1: manDL_fact_annotated_list : manDL_annotated_fact ( COMMA manDL_annotated_fact )* ;
    public final ManchesterParser.manDL_fact_annotated_list_return manDL_fact_annotated_list() throws RecognitionException {
        ManchesterParser.manDL_fact_annotated_list_return retval = new ManchesterParser.manDL_fact_annotated_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA200=null;
        ManchesterParser.manDL_annotated_fact_return manDL_annotated_fact199 = null;

        ManchesterParser.manDL_annotated_fact_return manDL_annotated_fact201 = null;


        CommonTree COMMA200_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:537:3: ( manDL_annotated_fact ( COMMA manDL_annotated_fact )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:537:5: manDL_annotated_fact ( COMMA manDL_annotated_fact )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_annotated_fact_in_manDL_fact_annotated_list3258);
            manDL_annotated_fact199=manDL_annotated_fact();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotated_fact199.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:537:26: ( COMMA manDL_annotated_fact )*
            loop51:
            do {
                int alt51=2;
                alt51 = dfa51.predict(input);
                switch (alt51) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:537:27: COMMA manDL_annotated_fact
            	    {
            	    COMMA200=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_fact_annotated_list3261); if (state.failed) return retval;
            	    pushFollow(FOLLOW_manDL_annotated_fact_in_manDL_fact_annotated_list3264);
            	    manDL_annotated_fact201=manDL_annotated_fact();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotated_fact201.getTree());

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_fact_annotated_list"

    public static class manDL_annotated_fact_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotated_fact"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:540:1: manDL_annotated_fact : ( manDL_annotations )? manDL_fact -> ^( manDL_fact ( manDL_annotations )? ) ;
    public final ManchesterParser.manDL_annotated_fact_return manDL_annotated_fact() throws RecognitionException {
        ManchesterParser.manDL_annotated_fact_return retval = new ManchesterParser.manDL_annotated_fact_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations202 = null;

        ManchesterParser.manDL_fact_return manDL_fact203 = null;


        RewriteRuleSubtreeStream stream_manDL_fact=new RewriteRuleSubtreeStream(adaptor,"rule manDL_fact");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:541:3: ( ( manDL_annotations )? manDL_fact -> ^( manDL_fact ( manDL_annotations )? ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:541:5: ( manDL_annotations )? manDL_fact
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:541:5: ( manDL_annotations )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==ANNOTATIONS_K) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:541:5: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_annotated_fact3279);
                    manDL_annotations202=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations202.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_fact_in_manDL_annotated_fact3282);
            manDL_fact203=manDL_fact();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_fact.add(manDL_fact203.getTree());


            // AST REWRITE
            // elements: manDL_fact, manDL_annotations
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 542:3: -> ^( manDL_fact ( manDL_annotations )? )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:542:6: ^( manDL_fact ( manDL_annotations )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_manDL_fact.nextNode(), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:542:19: ( manDL_annotations )?
                if ( stream_manDL_annotations.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                }
                stream_manDL_annotations.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotated_fact"

    public static class manDL_fact_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_fact"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:545:1: manDL_fact : (neg= NOT_K )? manDL_property_expression ( manDL_individual | manDL_literal ) -> {neg==null}? ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) -> ^( VT_NEG ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) ) ;
    public final ManchesterParser.manDL_fact_return manDL_fact() throws RecognitionException {
        ManchesterParser.manDL_fact_return retval = new ManchesterParser.manDL_fact_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token neg=null;
        ManchesterParser.manDL_property_expression_return manDL_property_expression204 = null;

        ManchesterParser.manDL_individual_return manDL_individual205 = null;

        ManchesterParser.manDL_literal_return manDL_literal206 = null;


        CommonTree neg_tree=null;
        RewriteRuleTokenStream stream_NOT_K=new RewriteRuleTokenStream(adaptor,"token NOT_K");
        RewriteRuleSubtreeStream stream_manDL_individual=new RewriteRuleSubtreeStream(adaptor,"rule manDL_individual");
        RewriteRuleSubtreeStream stream_manDL_literal=new RewriteRuleSubtreeStream(adaptor,"rule manDL_literal");
        RewriteRuleSubtreeStream stream_manDL_property_expression=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_expression");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:3: ( (neg= NOT_K )? manDL_property_expression ( manDL_individual | manDL_literal ) -> {neg==null}? ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) -> ^( VT_NEG ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:5: (neg= NOT_K )? manDL_property_expression ( manDL_individual | manDL_literal )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:8: (neg= NOT_K )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==NOT_K) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:8: neg= NOT_K
                    {
                    neg=(Token)match(input,NOT_K,FOLLOW_NOT_K_in_manDL_fact3314); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT_K.add(neg);


                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_property_expression_in_manDL_fact3317);
            manDL_property_expression204=manDL_property_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression204.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:42: ( manDL_individual | manDL_literal )
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:43: manDL_individual
                    {
                    pushFollow(FOLLOW_manDL_individual_in_manDL_fact3320);
                    manDL_individual205=manDL_individual();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_individual.add(manDL_individual205.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:546:62: manDL_literal
                    {
                    pushFollow(FOLLOW_manDL_literal_in_manDL_fact3324);
                    manDL_literal206=manDL_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_literal.add(manDL_literal206.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: manDL_property_expression, manDL_property_expression, manDL_literal, manDL_individual, manDL_literal, manDL_individual
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 547:3: -> {neg==null}? ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? )
            if (neg==null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:547:19: ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_FACT, "VT_FACT"), root_1);

                adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:547:55: ( manDL_individual )?
                if ( stream_manDL_individual.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_individual.nextTree());

                }
                stream_manDL_individual.reset();
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:547:73: ( manDL_literal )?
                if ( stream_manDL_literal.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_literal.nextTree());

                }
                stream_manDL_literal.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 548:3: -> ^( VT_NEG ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:548:6: ^( VT_NEG ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NEG, "VT_NEG"), root_1);

                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:548:15: ^( VT_FACT manDL_property_expression ( manDL_individual )? ( manDL_literal )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_FACT, "VT_FACT"), root_2);

                adaptor.addChild(root_2, stream_manDL_property_expression.nextTree());
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:548:51: ( manDL_individual )?
                if ( stream_manDL_individual.hasNext() ) {
                    adaptor.addChild(root_2, stream_manDL_individual.nextTree());

                }
                stream_manDL_individual.reset();
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:548:69: ( manDL_literal )?
                if ( stream_manDL_literal.hasNext() ) {
                    adaptor.addChild(root_2, stream_manDL_literal.nextTree());

                }
                stream_manDL_literal.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_fact"

    public static class manDL_sameAs_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_sameAs"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:553:1: manDL_sameAs : SAMEAS_K COLON manDL_individual_list -> ^( VT_SAMEAS manDL_individual_list ) ;
    public final ManchesterParser.manDL_sameAs_return manDL_sameAs() throws RecognitionException {
        ManchesterParser.manDL_sameAs_return retval = new ManchesterParser.manDL_sameAs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SAMEAS_K207=null;
        Token COLON208=null;
        ManchesterParser.manDL_individual_list_return manDL_individual_list209 = null;


        CommonTree SAMEAS_K207_tree=null;
        CommonTree COLON208_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SAMEAS_K=new RewriteRuleTokenStream(adaptor,"token SAMEAS_K");
        RewriteRuleSubtreeStream stream_manDL_individual_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_individual_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:554:3: ( SAMEAS_K COLON manDL_individual_list -> ^( VT_SAMEAS manDL_individual_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:554:5: SAMEAS_K COLON manDL_individual_list
            {
            SAMEAS_K207=(Token)match(input,SAMEAS_K,FOLLOW_SAMEAS_K_in_manDL_sameAs3384); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SAMEAS_K.add(SAMEAS_K207);

            COLON208=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_sameAs3386); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON208);

            pushFollow(FOLLOW_manDL_individual_list_in_manDL_sameAs3388);
            manDL_individual_list209=manDL_individual_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_individual_list.add(manDL_individual_list209.getTree());


            // AST REWRITE
            // elements: manDL_individual_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 555:3: -> ^( VT_SAMEAS manDL_individual_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:555:6: ^( VT_SAMEAS manDL_individual_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_SAMEAS, "VT_SAMEAS"), root_1);

                adaptor.addChild(root_1, stream_manDL_individual_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_sameAs"

    public static class manDL_differentFrom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_differentFrom"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:558:1: manDL_differentFrom : DIFFERENTFROM_K COLON manDL_individual_list -> ^( VT_DIFFERENTFROM manDL_individual_list ) ;
    public final ManchesterParser.manDL_differentFrom_return manDL_differentFrom() throws RecognitionException {
        ManchesterParser.manDL_differentFrom_return retval = new ManchesterParser.manDL_differentFrom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DIFFERENTFROM_K210=null;
        Token COLON211=null;
        ManchesterParser.manDL_individual_list_return manDL_individual_list212 = null;


        CommonTree DIFFERENTFROM_K210_tree=null;
        CommonTree COLON211_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_DIFFERENTFROM_K=new RewriteRuleTokenStream(adaptor,"token DIFFERENTFROM_K");
        RewriteRuleSubtreeStream stream_manDL_individual_list=new RewriteRuleSubtreeStream(adaptor,"rule manDL_individual_list");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:559:3: ( DIFFERENTFROM_K COLON manDL_individual_list -> ^( VT_DIFFERENTFROM manDL_individual_list ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:559:5: DIFFERENTFROM_K COLON manDL_individual_list
            {
            DIFFERENTFROM_K210=(Token)match(input,DIFFERENTFROM_K,FOLLOW_DIFFERENTFROM_K_in_manDL_differentFrom3413); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DIFFERENTFROM_K.add(DIFFERENTFROM_K210);

            COLON211=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_differentFrom3415); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON211);

            pushFollow(FOLLOW_manDL_individual_list_in_manDL_differentFrom3417);
            manDL_individual_list212=manDL_individual_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_individual_list.add(manDL_individual_list212.getTree());


            // AST REWRITE
            // elements: manDL_individual_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 560:3: -> ^( VT_DIFFERENTFROM manDL_individual_list )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:560:6: ^( VT_DIFFERENTFROM manDL_individual_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DIFFERENTFROM, "VT_DIFFERENTFROM"), root_1);

                adaptor.addChild(root_1, stream_manDL_individual_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_differentFrom"

    public static class manDL_misc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_misc"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:579:1: manDL_misc : ( (eq= EQUIVALENTCLASSES_K | df= DISJOINTCLASSES_K ) COLON ( manDL_annotations )? manDL_description ( COMMA manDL_description )+ -> {eq!=null}? ^( VT_EQV_CLASS ( manDL_annotations )? ( manDL_description )+ ) -> ^( VT_DIF_CLASS ( manDL_annotations )? ( manDL_description )+ ) | (eq2= EQUIVALENTPROPERTIES_K | df2= DISJOINTPROPERTIES_K ) COLON ( manDL_annotations )? manDL_property_expression ( COMMA manDL_property_expression )+ -> {eq2!=null}? ^( VT_EQV_PROP ( manDL_annotations )? ( manDL_property_expression )+ ) -> ^( VT_DIF_PROP ( manDL_annotations )? ( manDL_property_expression )+ ) | (eq3= SAMEINDIVIDUAL_K | df3= DIFFERENTINDIVIDUALS_K ) COLON ( manDL_annotations )? manDL_individual ( COMMA manDL_individual )+ -> {eq3!=null}? ^( VT_EQV_INDV ( manDL_annotations )? ( manDL_individual )+ ) -> ^( VT_DIF_INDV ( manDL_annotations )? ( manDL_individual )+ ) );
    public final ManchesterParser.manDL_misc_return manDL_misc() throws RecognitionException {
        ManchesterParser.manDL_misc_return retval = new ManchesterParser.manDL_misc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token eq=null;
        Token df=null;
        Token eq2=null;
        Token df2=null;
        Token eq3=null;
        Token df3=null;
        Token COLON213=null;
        Token COMMA216=null;
        Token COLON218=null;
        Token COMMA221=null;
        Token COLON223=null;
        Token COMMA226=null;
        ManchesterParser.manDL_annotations_return manDL_annotations214 = null;

        ManchesterParser.manDL_description_return manDL_description215 = null;

        ManchesterParser.manDL_description_return manDL_description217 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations219 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression220 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression222 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations224 = null;

        ManchesterParser.manDL_individual_return manDL_individual225 = null;

        ManchesterParser.manDL_individual_return manDL_individual227 = null;


        CommonTree eq_tree=null;
        CommonTree df_tree=null;
        CommonTree eq2_tree=null;
        CommonTree df2_tree=null;
        CommonTree eq3_tree=null;
        CommonTree df3_tree=null;
        CommonTree COLON213_tree=null;
        CommonTree COMMA216_tree=null;
        CommonTree COLON218_tree=null;
        CommonTree COMMA221_tree=null;
        CommonTree COLON223_tree=null;
        CommonTree COMMA226_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EQUIVALENTCLASSES_K=new RewriteRuleTokenStream(adaptor,"token EQUIVALENTCLASSES_K");
        RewriteRuleTokenStream stream_DISJOINTCLASSES_K=new RewriteRuleTokenStream(adaptor,"token DISJOINTCLASSES_K");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SAMEINDIVIDUAL_K=new RewriteRuleTokenStream(adaptor,"token SAMEINDIVIDUAL_K");
        RewriteRuleTokenStream stream_DIFFERENTINDIVIDUALS_K=new RewriteRuleTokenStream(adaptor,"token DIFFERENTINDIVIDUALS_K");
        RewriteRuleTokenStream stream_EQUIVALENTPROPERTIES_K=new RewriteRuleTokenStream(adaptor,"token EQUIVALENTPROPERTIES_K");
        RewriteRuleTokenStream stream_DISJOINTPROPERTIES_K=new RewriteRuleTokenStream(adaptor,"token DISJOINTPROPERTIES_K");
        RewriteRuleSubtreeStream stream_manDL_individual=new RewriteRuleSubtreeStream(adaptor,"rule manDL_individual");
        RewriteRuleSubtreeStream stream_manDL_property_expression=new RewriteRuleSubtreeStream(adaptor,"rule manDL_property_expression");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        RewriteRuleSubtreeStream stream_manDL_description=new RewriteRuleSubtreeStream(adaptor,"rule manDL_description");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:580:3: ( (eq= EQUIVALENTCLASSES_K | df= DISJOINTCLASSES_K ) COLON ( manDL_annotations )? manDL_description ( COMMA manDL_description )+ -> {eq!=null}? ^( VT_EQV_CLASS ( manDL_annotations )? ( manDL_description )+ ) -> ^( VT_DIF_CLASS ( manDL_annotations )? ( manDL_description )+ ) | (eq2= EQUIVALENTPROPERTIES_K | df2= DISJOINTPROPERTIES_K ) COLON ( manDL_annotations )? manDL_property_expression ( COMMA manDL_property_expression )+ -> {eq2!=null}? ^( VT_EQV_PROP ( manDL_annotations )? ( manDL_property_expression )+ ) -> ^( VT_DIF_PROP ( manDL_annotations )? ( manDL_property_expression )+ ) | (eq3= SAMEINDIVIDUAL_K | df3= DIFFERENTINDIVIDUALS_K ) COLON ( manDL_annotations )? manDL_individual ( COMMA manDL_individual )+ -> {eq3!=null}? ^( VT_EQV_INDV ( manDL_annotations )? ( manDL_individual )+ ) -> ^( VT_DIF_INDV ( manDL_annotations )? ( manDL_individual )+ ) )
            int alt64=3;
            switch ( input.LA(1) ) {
            case DISJOINTCLASSES_K:
            case EQUIVALENTCLASSES_K:
                {
                alt64=1;
                }
                break;
            case DISJOINTPROPERTIES_K:
            case EQUIVALENTPROPERTIES_K:
                {
                alt64=2;
                }
                break;
            case DIFFERENTINDIVIDUALS_K:
            case SAMEINDIVIDUAL_K:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:580:5: (eq= EQUIVALENTCLASSES_K | df= DISJOINTCLASSES_K ) COLON ( manDL_annotations )? manDL_description ( COMMA manDL_description )+
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:580:5: (eq= EQUIVALENTCLASSES_K | df= DISJOINTCLASSES_K )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==EQUIVALENTCLASSES_K) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==DISJOINTCLASSES_K) ) {
                        alt55=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 0, input);

                        throw nvae;
                    }
                    switch (alt55) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:580:6: eq= EQUIVALENTCLASSES_K
                            {
                            eq=(Token)match(input,EQUIVALENTCLASSES_K,FOLLOW_EQUIVALENTCLASSES_K_in_manDL_misc3477); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUIVALENTCLASSES_K.add(eq);


                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:580:31: df= DISJOINTCLASSES_K
                            {
                            df=(Token)match(input,DISJOINTCLASSES_K,FOLLOW_DISJOINTCLASSES_K_in_manDL_misc3483); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DISJOINTCLASSES_K.add(df);


                            }
                            break;

                    }

                    COLON213=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_misc3486); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON213);

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:581:7: ( manDL_annotations )?
                    int alt56=2;
                    alt56 = dfa56.predict(input);
                    switch (alt56) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:581:7: manDL_annotations
                            {
                            pushFollow(FOLLOW_manDL_annotations_in_manDL_misc3494);
                            manDL_annotations214=manDL_annotations();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations214.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_manDL_description_in_manDL_misc3497);
                    manDL_description215=manDL_description();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_description.add(manDL_description215.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:581:44: ( COMMA manDL_description )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        alt57 = dfa57.predict(input);
                        switch (alt57) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:581:45: COMMA manDL_description
                    	    {
                    	    COMMA216=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_misc3500); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA216);

                    	    pushFollow(FOLLOW_manDL_description_in_manDL_misc3502);
                    	    manDL_description217=manDL_description();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_manDL_description.add(manDL_description217.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt57 >= 1 ) break loop57;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
                    } while (true);



                    // AST REWRITE
                    // elements: manDL_annotations, manDL_description, manDL_annotations, manDL_description
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 582:7: -> {eq!=null}? ^( VT_EQV_CLASS ( manDL_annotations )? ( manDL_description )+ )
                    if (eq!=null) {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:582:22: ^( VT_EQV_CLASS ( manDL_annotations )? ( manDL_description )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_EQV_CLASS, "VT_EQV_CLASS"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:582:37: ( manDL_annotations )?
                        if ( stream_manDL_annotations.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                        }
                        stream_manDL_annotations.reset();
                        if ( !(stream_manDL_description.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_description.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_description.nextTree());

                        }
                        stream_manDL_description.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 583:7: -> ^( VT_DIF_CLASS ( manDL_annotations )? ( manDL_description )+ )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:583:10: ^( VT_DIF_CLASS ( manDL_annotations )? ( manDL_description )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DIF_CLASS, "VT_DIF_CLASS"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:583:25: ( manDL_annotations )?
                        if ( stream_manDL_annotations.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                        }
                        stream_manDL_annotations.reset();
                        if ( !(stream_manDL_description.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_description.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_description.nextTree());

                        }
                        stream_manDL_description.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:585:5: (eq2= EQUIVALENTPROPERTIES_K | df2= DISJOINTPROPERTIES_K ) COLON ( manDL_annotations )? manDL_property_expression ( COMMA manDL_property_expression )+
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:585:5: (eq2= EQUIVALENTPROPERTIES_K | df2= DISJOINTPROPERTIES_K )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==EQUIVALENTPROPERTIES_K) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==DISJOINTPROPERTIES_K) ) {
                        alt58=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:585:6: eq2= EQUIVALENTPROPERTIES_K
                            {
                            eq2=(Token)match(input,EQUIVALENTPROPERTIES_K,FOLLOW_EQUIVALENTPROPERTIES_K_in_manDL_misc3558); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUIVALENTPROPERTIES_K.add(eq2);


                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:585:35: df2= DISJOINTPROPERTIES_K
                            {
                            df2=(Token)match(input,DISJOINTPROPERTIES_K,FOLLOW_DISJOINTPROPERTIES_K_in_manDL_misc3564); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DISJOINTPROPERTIES_K.add(df2);


                            }
                            break;

                    }

                    COLON218=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_misc3567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON218);

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:586:7: ( manDL_annotations )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==ANNOTATIONS_K) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:586:7: manDL_annotations
                            {
                            pushFollow(FOLLOW_manDL_annotations_in_manDL_misc3575);
                            manDL_annotations219=manDL_annotations();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations219.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_manDL_property_expression_in_manDL_misc3578);
                    manDL_property_expression220=manDL_property_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression220.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:586:52: ( COMMA manDL_property_expression )+
                    int cnt60=0;
                    loop60:
                    do {
                        int alt60=2;
                        alt60 = dfa60.predict(input);
                        switch (alt60) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:586:53: COMMA manDL_property_expression
                    	    {
                    	    COMMA221=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_misc3581); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA221);

                    	    pushFollow(FOLLOW_manDL_property_expression_in_manDL_misc3583);
                    	    manDL_property_expression222=manDL_property_expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_manDL_property_expression.add(manDL_property_expression222.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt60 >= 1 ) break loop60;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(60, input);
                                throw eee;
                        }
                        cnt60++;
                    } while (true);



                    // AST REWRITE
                    // elements: manDL_property_expression, manDL_annotations, manDL_annotations, manDL_property_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 587:7: -> {eq2!=null}? ^( VT_EQV_PROP ( manDL_annotations )? ( manDL_property_expression )+ )
                    if (eq2!=null) {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:587:23: ^( VT_EQV_PROP ( manDL_annotations )? ( manDL_property_expression )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_EQV_PROP, "VT_EQV_PROP"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:587:37: ( manDL_annotations )?
                        if ( stream_manDL_annotations.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                        }
                        stream_manDL_annotations.reset();
                        if ( !(stream_manDL_property_expression.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_property_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());

                        }
                        stream_manDL_property_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 588:7: -> ^( VT_DIF_PROP ( manDL_annotations )? ( manDL_property_expression )+ )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:588:10: ^( VT_DIF_PROP ( manDL_annotations )? ( manDL_property_expression )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DIF_PROP, "VT_DIF_PROP"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:588:24: ( manDL_annotations )?
                        if ( stream_manDL_annotations.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                        }
                        stream_manDL_annotations.reset();
                        if ( !(stream_manDL_property_expression.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_property_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_property_expression.nextTree());

                        }
                        stream_manDL_property_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:590:5: (eq3= SAMEINDIVIDUAL_K | df3= DIFFERENTINDIVIDUALS_K ) COLON ( manDL_annotations )? manDL_individual ( COMMA manDL_individual )+
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:590:5: (eq3= SAMEINDIVIDUAL_K | df3= DIFFERENTINDIVIDUALS_K )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==SAMEINDIVIDUAL_K) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==DIFFERENTINDIVIDUALS_K) ) {
                        alt61=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:590:6: eq3= SAMEINDIVIDUAL_K
                            {
                            eq3=(Token)match(input,SAMEINDIVIDUAL_K,FOLLOW_SAMEINDIVIDUAL_K_in_manDL_misc3639); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SAMEINDIVIDUAL_K.add(eq3);


                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:590:29: df3= DIFFERENTINDIVIDUALS_K
                            {
                            df3=(Token)match(input,DIFFERENTINDIVIDUALS_K,FOLLOW_DIFFERENTINDIVIDUALS_K_in_manDL_misc3645); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DIFFERENTINDIVIDUALS_K.add(df3);


                            }
                            break;

                    }

                    COLON223=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_misc3648); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON223);

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:591:7: ( manDL_annotations )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==ANNOTATIONS_K) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:591:7: manDL_annotations
                            {
                            pushFollow(FOLLOW_manDL_annotations_in_manDL_misc3656);
                            manDL_annotations224=manDL_annotations();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations224.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_manDL_individual_in_manDL_misc3659);
                    manDL_individual225=manDL_individual();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_individual.add(manDL_individual225.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:591:43: ( COMMA manDL_individual )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        alt63 = dfa63.predict(input);
                        switch (alt63) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:591:44: COMMA manDL_individual
                    	    {
                    	    COMMA226=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_misc3662); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA226);

                    	    pushFollow(FOLLOW_manDL_individual_in_manDL_misc3664);
                    	    manDL_individual227=manDL_individual();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_manDL_individual.add(manDL_individual227.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);



                    // AST REWRITE
                    // elements: manDL_individual, manDL_individual, manDL_annotations, manDL_annotations
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 592:7: -> {eq3!=null}? ^( VT_EQV_INDV ( manDL_annotations )? ( manDL_individual )+ )
                    if (eq3!=null) {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:592:23: ^( VT_EQV_INDV ( manDL_annotations )? ( manDL_individual )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_EQV_INDV, "VT_EQV_INDV"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:592:37: ( manDL_annotations )?
                        if ( stream_manDL_annotations.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                        }
                        stream_manDL_annotations.reset();
                        if ( !(stream_manDL_individual.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_individual.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_individual.nextTree());

                        }
                        stream_manDL_individual.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 593:7: -> ^( VT_DIF_INDV ( manDL_annotations )? ( manDL_individual )+ )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:593:10: ^( VT_DIF_INDV ( manDL_annotations )? ( manDL_individual )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DIF_INDV, "VT_DIF_INDV"), root_1);

                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:593:24: ( manDL_annotations )?
                        if ( stream_manDL_annotations.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_annotations.nextTree());

                        }
                        stream_manDL_annotations.reset();
                        if ( !(stream_manDL_individual.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_manDL_individual.hasNext() ) {
                            adaptor.addChild(root_1, stream_manDL_individual.nextTree());

                        }
                        stream_manDL_individual.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_misc"

    public static class manDL_attributes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_attributes"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:634:1: manDL_attributes : CHARACTERISTICS_K COLON ( ( manDL_annotations )? manDL_attribute ) ( COMMA ( manDL_annotations )? manDL_attribute )* -> ^( VT_ATTRIBUTES ( ^( manDL_attribute ( manDL_annotations )? ) )+ ) ;
    public final ManchesterParser.manDL_attributes_return manDL_attributes() throws RecognitionException {
        ManchesterParser.manDL_attributes_return retval = new ManchesterParser.manDL_attributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CHARACTERISTICS_K228=null;
        Token COLON229=null;
        Token COMMA232=null;
        ManchesterParser.manDL_annotations_return manDL_annotations230 = null;

        ManchesterParser.manDL_attribute_return manDL_attribute231 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations233 = null;

        ManchesterParser.manDL_attribute_return manDL_attribute234 = null;


        CommonTree CHARACTERISTICS_K228_tree=null;
        CommonTree COLON229_tree=null;
        CommonTree COMMA232_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_CHARACTERISTICS_K=new RewriteRuleTokenStream(adaptor,"token CHARACTERISTICS_K");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_manDL_annotations=new RewriteRuleSubtreeStream(adaptor,"rule manDL_annotations");
        RewriteRuleSubtreeStream stream_manDL_attribute=new RewriteRuleSubtreeStream(adaptor,"rule manDL_attribute");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:3: ( CHARACTERISTICS_K COLON ( ( manDL_annotations )? manDL_attribute ) ( COMMA ( manDL_annotations )? manDL_attribute )* -> ^( VT_ATTRIBUTES ( ^( manDL_attribute ( manDL_annotations )? ) )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:5: CHARACTERISTICS_K COLON ( ( manDL_annotations )? manDL_attribute ) ( COMMA ( manDL_annotations )? manDL_attribute )*
            {
            CHARACTERISTICS_K228=(Token)match(input,CHARACTERISTICS_K,FOLLOW_CHARACTERISTICS_K_in_manDL_attributes3797); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CHARACTERISTICS_K.add(CHARACTERISTICS_K228);

            COLON229=(Token)match(input,COLON,FOLLOW_COLON_in_manDL_attributes3799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON229);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:29: ( ( manDL_annotations )? manDL_attribute )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:30: ( manDL_annotations )? manDL_attribute
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:30: ( manDL_annotations )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==ANNOTATIONS_K) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:30: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_attributes3802);
                    manDL_annotations230=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations230.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_attribute_in_manDL_attributes3805);
            manDL_attribute231=manDL_attribute();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_attribute.add(manDL_attribute231.getTree());

            }

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:66: ( COMMA ( manDL_annotations )? manDL_attribute )*
            loop67:
            do {
                int alt67=2;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:67: COMMA ( manDL_annotations )? manDL_attribute
            	    {
            	    COMMA232=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_attributes3809); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA232);

            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:74: ( manDL_annotations )?
            	    int alt66=2;
            	    int LA66_0 = input.LA(1);

            	    if ( (LA66_0==ANNOTATIONS_K) ) {
            	        alt66=1;
            	    }
            	    switch (alt66) {
            	        case 1 :
            	            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:635:74: manDL_annotations
            	            {
            	            pushFollow(FOLLOW_manDL_annotations_in_manDL_attributes3812);
            	            manDL_annotations233=manDL_annotations();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_manDL_annotations.add(manDL_annotations233.getTree());

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_manDL_attribute_in_manDL_attributes3815);
            	    manDL_attribute234=manDL_attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_attribute.add(manDL_attribute234.getTree());

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_attribute, manDL_annotations
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 636:3: -> ^( VT_ATTRIBUTES ( ^( manDL_attribute ( manDL_annotations )? ) )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:636:6: ^( VT_ATTRIBUTES ( ^( manDL_attribute ( manDL_annotations )? ) )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ATTRIBUTES, "VT_ATTRIBUTES"), root_1);

                if ( !(stream_manDL_attribute.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_attribute.hasNext() ) {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:636:22: ^( manDL_attribute ( manDL_annotations )? )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(stream_manDL_attribute.nextNode(), root_2);

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:636:40: ( manDL_annotations )?
                    if ( stream_manDL_annotations.hasNext() ) {
                        adaptor.addChild(root_2, stream_manDL_annotations.nextTree());

                    }
                    stream_manDL_annotations.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_manDL_attribute.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_attributes"

    public static class manDL_attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_attribute"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:639:1: manDL_attribute : ( manDL_att_functional | manDL_att_inverseFunctional | manDL_att_reflexive | manDL_att_irreflexive | manDL_att_symmetric | manDL_att_asymmetric | manDL_att_transitive );
    public final ManchesterParser.manDL_attribute_return manDL_attribute() throws RecognitionException {
        ManchesterParser.manDL_attribute_return retval = new ManchesterParser.manDL_attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_att_functional_return manDL_att_functional235 = null;

        ManchesterParser.manDL_att_inverseFunctional_return manDL_att_inverseFunctional236 = null;

        ManchesterParser.manDL_att_reflexive_return manDL_att_reflexive237 = null;

        ManchesterParser.manDL_att_irreflexive_return manDL_att_irreflexive238 = null;

        ManchesterParser.manDL_att_symmetric_return manDL_att_symmetric239 = null;

        ManchesterParser.manDL_att_asymmetric_return manDL_att_asymmetric240 = null;

        ManchesterParser.manDL_att_transitive_return manDL_att_transitive241 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:640:3: ( manDL_att_functional | manDL_att_inverseFunctional | manDL_att_reflexive | manDL_att_irreflexive | manDL_att_symmetric | manDL_att_asymmetric | manDL_att_transitive )
            int alt68=7;
            switch ( input.LA(1) ) {
            case FUNCTIONAL_K:
                {
                alt68=1;
                }
                break;
            case INVERSEFUNCTIONAL_K:
                {
                alt68=2;
                }
                break;
            case REFLEXIVE_K:
                {
                alt68=3;
                }
                break;
            case IRREFLEXIVE_K:
                {
                alt68=4;
                }
                break;
            case SYMMETRIC_K:
                {
                alt68=5;
                }
                break;
            case ASYMMETRIC_K:
                {
                alt68=6;
                }
                break;
            case TRANSITIVE_K:
                {
                alt68=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:641:4: manDL_att_functional
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_functional_in_manDL_attribute3856);
                    manDL_att_functional235=manDL_att_functional();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_functional235.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:642:5: manDL_att_inverseFunctional
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_inverseFunctional_in_manDL_attribute3862);
                    manDL_att_inverseFunctional236=manDL_att_inverseFunctional();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_inverseFunctional236.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:643:5: manDL_att_reflexive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_reflexive_in_manDL_attribute3868);
                    manDL_att_reflexive237=manDL_att_reflexive();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_reflexive237.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:644:5: manDL_att_irreflexive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_irreflexive_in_manDL_attribute3874);
                    manDL_att_irreflexive238=manDL_att_irreflexive();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_irreflexive238.getTree());

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:645:5: manDL_att_symmetric
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_symmetric_in_manDL_attribute3880);
                    manDL_att_symmetric239=manDL_att_symmetric();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_symmetric239.getTree());

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:646:5: manDL_att_asymmetric
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_asymmetric_in_manDL_attribute3886);
                    manDL_att_asymmetric240=manDL_att_asymmetric();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_asymmetric240.getTree());

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:647:5: manDL_att_transitive
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_att_transitive_in_manDL_attribute3892);
                    manDL_att_transitive241=manDL_att_transitive();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_att_transitive241.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_attribute"

    public static class manDL_att_functional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_functional"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:651:1: manDL_att_functional : FUNCTIONAL_K -> VT_DLA_FUN ;
    public final ManchesterParser.manDL_att_functional_return manDL_att_functional() throws RecognitionException {
        ManchesterParser.manDL_att_functional_return retval = new ManchesterParser.manDL_att_functional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNCTIONAL_K242=null;

        CommonTree FUNCTIONAL_K242_tree=null;
        RewriteRuleTokenStream stream_FUNCTIONAL_K=new RewriteRuleTokenStream(adaptor,"token FUNCTIONAL_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:652:3: ( FUNCTIONAL_K -> VT_DLA_FUN )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:652:5: FUNCTIONAL_K
            {
            FUNCTIONAL_K242=(Token)match(input,FUNCTIONAL_K,FOLLOW_FUNCTIONAL_K_in_manDL_att_functional3908); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTIONAL_K.add(FUNCTIONAL_K242);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 652:18: -> VT_DLA_FUN
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_FUN, "VT_DLA_FUN"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_functional"

    public static class manDL_att_inverseFunctional_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_inverseFunctional"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:655:1: manDL_att_inverseFunctional : INVERSEFUNCTIONAL_K -> VT_DLA_IFUN ;
    public final ManchesterParser.manDL_att_inverseFunctional_return manDL_att_inverseFunctional() throws RecognitionException {
        ManchesterParser.manDL_att_inverseFunctional_return retval = new ManchesterParser.manDL_att_inverseFunctional_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INVERSEFUNCTIONAL_K243=null;

        CommonTree INVERSEFUNCTIONAL_K243_tree=null;
        RewriteRuleTokenStream stream_INVERSEFUNCTIONAL_K=new RewriteRuleTokenStream(adaptor,"token INVERSEFUNCTIONAL_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:656:3: ( INVERSEFUNCTIONAL_K -> VT_DLA_IFUN )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:656:5: INVERSEFUNCTIONAL_K
            {
            INVERSEFUNCTIONAL_K243=(Token)match(input,INVERSEFUNCTIONAL_K,FOLLOW_INVERSEFUNCTIONAL_K_in_manDL_att_inverseFunctional3929); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INVERSEFUNCTIONAL_K.add(INVERSEFUNCTIONAL_K243);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 656:25: -> VT_DLA_IFUN
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_IFUN, "VT_DLA_IFUN"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_inverseFunctional"

    public static class manDL_att_reflexive_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_reflexive"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:659:1: manDL_att_reflexive : REFLEXIVE_K -> VT_DLA_REF ;
    public final ManchesterParser.manDL_att_reflexive_return manDL_att_reflexive() throws RecognitionException {
        ManchesterParser.manDL_att_reflexive_return retval = new ManchesterParser.manDL_att_reflexive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REFLEXIVE_K244=null;

        CommonTree REFLEXIVE_K244_tree=null;
        RewriteRuleTokenStream stream_REFLEXIVE_K=new RewriteRuleTokenStream(adaptor,"token REFLEXIVE_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:660:3: ( REFLEXIVE_K -> VT_DLA_REF )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:660:5: REFLEXIVE_K
            {
            REFLEXIVE_K244=(Token)match(input,REFLEXIVE_K,FOLLOW_REFLEXIVE_K_in_manDL_att_reflexive3950); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_REFLEXIVE_K.add(REFLEXIVE_K244);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 660:17: -> VT_DLA_REF
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_REF, "VT_DLA_REF"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_reflexive"

    public static class manDL_att_irreflexive_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_irreflexive"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:663:1: manDL_att_irreflexive : IRREFLEXIVE_K -> VT_DLA_IREF ;
    public final ManchesterParser.manDL_att_irreflexive_return manDL_att_irreflexive() throws RecognitionException {
        ManchesterParser.manDL_att_irreflexive_return retval = new ManchesterParser.manDL_att_irreflexive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IRREFLEXIVE_K245=null;

        CommonTree IRREFLEXIVE_K245_tree=null;
        RewriteRuleTokenStream stream_IRREFLEXIVE_K=new RewriteRuleTokenStream(adaptor,"token IRREFLEXIVE_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:664:3: ( IRREFLEXIVE_K -> VT_DLA_IREF )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:664:5: IRREFLEXIVE_K
            {
            IRREFLEXIVE_K245=(Token)match(input,IRREFLEXIVE_K,FOLLOW_IRREFLEXIVE_K_in_manDL_att_irreflexive3971); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IRREFLEXIVE_K.add(IRREFLEXIVE_K245);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 664:19: -> VT_DLA_IREF
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_IREF, "VT_DLA_IREF"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_irreflexive"

    public static class manDL_att_symmetric_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_symmetric"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:667:1: manDL_att_symmetric : SYMMETRIC_K -> VT_DLA_SYM ;
    public final ManchesterParser.manDL_att_symmetric_return manDL_att_symmetric() throws RecognitionException {
        ManchesterParser.manDL_att_symmetric_return retval = new ManchesterParser.manDL_att_symmetric_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SYMMETRIC_K246=null;

        CommonTree SYMMETRIC_K246_tree=null;
        RewriteRuleTokenStream stream_SYMMETRIC_K=new RewriteRuleTokenStream(adaptor,"token SYMMETRIC_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:668:3: ( SYMMETRIC_K -> VT_DLA_SYM )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:668:5: SYMMETRIC_K
            {
            SYMMETRIC_K246=(Token)match(input,SYMMETRIC_K,FOLLOW_SYMMETRIC_K_in_manDL_att_symmetric3992); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SYMMETRIC_K.add(SYMMETRIC_K246);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 668:17: -> VT_DLA_SYM
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_SYM, "VT_DLA_SYM"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_symmetric"

    public static class manDL_att_asymmetric_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_asymmetric"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:671:1: manDL_att_asymmetric : ASYMMETRIC_K -> VT_DLA_ASYM ;
    public final ManchesterParser.manDL_att_asymmetric_return manDL_att_asymmetric() throws RecognitionException {
        ManchesterParser.manDL_att_asymmetric_return retval = new ManchesterParser.manDL_att_asymmetric_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ASYMMETRIC_K247=null;

        CommonTree ASYMMETRIC_K247_tree=null;
        RewriteRuleTokenStream stream_ASYMMETRIC_K=new RewriteRuleTokenStream(adaptor,"token ASYMMETRIC_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:672:3: ( ASYMMETRIC_K -> VT_DLA_ASYM )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:672:5: ASYMMETRIC_K
            {
            ASYMMETRIC_K247=(Token)match(input,ASYMMETRIC_K,FOLLOW_ASYMMETRIC_K_in_manDL_att_asymmetric4013); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASYMMETRIC_K.add(ASYMMETRIC_K247);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 672:18: -> VT_DLA_ASYM
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_ASYM, "VT_DLA_ASYM"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_asymmetric"

    public static class manDL_att_transitive_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_att_transitive"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:675:1: manDL_att_transitive : TRANSITIVE_K -> VT_DLA_TRN ;
    public final ManchesterParser.manDL_att_transitive_return manDL_att_transitive() throws RecognitionException {
        ManchesterParser.manDL_att_transitive_return retval = new ManchesterParser.manDL_att_transitive_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRANSITIVE_K248=null;

        CommonTree TRANSITIVE_K248_tree=null;
        RewriteRuleTokenStream stream_TRANSITIVE_K=new RewriteRuleTokenStream(adaptor,"token TRANSITIVE_K");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:676:3: ( TRANSITIVE_K -> VT_DLA_TRN )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:676:5: TRANSITIVE_K
            {
            TRANSITIVE_K248=(Token)match(input,TRANSITIVE_K,FOLLOW_TRANSITIVE_K_in_manDL_att_transitive4030); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TRANSITIVE_K.add(TRANSITIVE_K248);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 676:18: -> VT_DLA_TRN
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(VT_DLA_TRN, "VT_DLA_TRN"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_att_transitive"

    public static class manDL_property_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_property_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:692:1: manDL_property_list : manDL_annotatedProperty ( COMMA manDL_annotatedProperty )? ;
    public final ManchesterParser.manDL_property_list_return manDL_property_list() throws RecognitionException {
        ManchesterParser.manDL_property_list_return retval = new ManchesterParser.manDL_property_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA250=null;
        ManchesterParser.manDL_annotatedProperty_return manDL_annotatedProperty249 = null;

        ManchesterParser.manDL_annotatedProperty_return manDL_annotatedProperty251 = null;


        CommonTree COMMA250_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:693:3: ( manDL_annotatedProperty ( COMMA manDL_annotatedProperty )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:693:5: manDL_annotatedProperty ( COMMA manDL_annotatedProperty )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_annotatedProperty_in_manDL_property_list4075);
            manDL_annotatedProperty249=manDL_annotatedProperty();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotatedProperty249.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:693:29: ( COMMA manDL_annotatedProperty )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:693:30: COMMA manDL_annotatedProperty
                    {
                    COMMA250=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_property_list4078); if (state.failed) return retval;
                    pushFollow(FOLLOW_manDL_annotatedProperty_in_manDL_property_list4081);
                    manDL_annotatedProperty251=manDL_annotatedProperty();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotatedProperty251.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_property_list"

    public static class manDL_annotatedProperty_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotatedProperty"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:696:1: manDL_annotatedProperty : ( manDL_annotations )? manDL_property_expression ;
    public final ManchesterParser.manDL_annotatedProperty_return manDL_annotatedProperty() throws RecognitionException {
        ManchesterParser.manDL_annotatedProperty_return retval = new ManchesterParser.manDL_annotatedProperty_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_annotations_return manDL_annotations252 = null;

        ManchesterParser.manDL_property_expression_return manDL_property_expression253 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:697:3: ( ( manDL_annotations )? manDL_property_expression )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:697:5: ( manDL_annotations )? manDL_property_expression
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:697:5: ( manDL_annotations )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==ANNOTATIONS_K) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:697:5: manDL_annotations
                    {
                    pushFollow(FOLLOW_manDL_annotations_in_manDL_annotatedProperty4099);
                    manDL_annotations252=manDL_annotations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_annotations252.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_property_expression_in_manDL_annotatedProperty4102);
            manDL_property_expression253=manDL_property_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_property_expression253.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotatedProperty"

    public static class manDL_property_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_property_expression"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:700:1: manDL_property_expression : (inv= INVERSE_K )? manDL_propertyIRI -> {inv==null}? ^( VT_DL_PROP manDL_propertyIRI ) -> ^( VT_DL_INV_PROP manDL_propertyIRI ) ;
    public final ManchesterParser.manDL_property_expression_return manDL_property_expression() throws RecognitionException {
        ManchesterParser.manDL_property_expression_return retval = new ManchesterParser.manDL_property_expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token inv=null;
        ManchesterParser.manDL_propertyIRI_return manDL_propertyIRI254 = null;


        CommonTree inv_tree=null;
        RewriteRuleTokenStream stream_INVERSE_K=new RewriteRuleTokenStream(adaptor,"token INVERSE_K");
        RewriteRuleSubtreeStream stream_manDL_propertyIRI=new RewriteRuleSubtreeStream(adaptor,"rule manDL_propertyIRI");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:701:3: ( (inv= INVERSE_K )? manDL_propertyIRI -> {inv==null}? ^( VT_DL_PROP manDL_propertyIRI ) -> ^( VT_DL_INV_PROP manDL_propertyIRI ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:701:5: (inv= INVERSE_K )? manDL_propertyIRI
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:701:8: (inv= INVERSE_K )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==INVERSE_K) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:701:8: inv= INVERSE_K
                    {
                    inv=(Token)match(input,INVERSE_K,FOLLOW_INVERSE_K_in_manDL_property_expression4126); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INVERSE_K.add(inv);


                    }
                    break;

            }

            pushFollow(FOLLOW_manDL_propertyIRI_in_manDL_property_expression4129);
            manDL_propertyIRI254=manDL_propertyIRI();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_propertyIRI.add(manDL_propertyIRI254.getTree());


            // AST REWRITE
            // elements: manDL_propertyIRI, manDL_propertyIRI
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 702:3: -> {inv==null}? ^( VT_DL_PROP manDL_propertyIRI )
            if (inv==null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:702:19: ^( VT_DL_PROP manDL_propertyIRI )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_PROP, "VT_DL_PROP"), root_1);

                adaptor.addChild(root_1, stream_manDL_propertyIRI.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 703:3: -> ^( VT_DL_INV_PROP manDL_propertyIRI )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:703:6: ^( VT_DL_INV_PROP manDL_propertyIRI )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DL_INV_PROP, "VT_DL_INV_PROP"), root_1);

                adaptor.addChild(root_1, stream_manDL_propertyIRI.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_property_expression"

    public static class manDL_item_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_item_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:707:1: manDL_item_list : ( manDL_literal_list | manDL_individual_list );
    public final ManchesterParser.manDL_item_list_return manDL_item_list() throws RecognitionException {
        ManchesterParser.manDL_item_list_return retval = new ManchesterParser.manDL_item_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_literal_list_return manDL_literal_list255 = null;

        ManchesterParser.manDL_individual_list_return manDL_individual_list256 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:708:3: ( manDL_literal_list | manDL_individual_list )
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:708:5: manDL_literal_list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_literal_list_in_manDL_item_list4174);
                    manDL_literal_list255=manDL_literal_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_literal_list255.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:709:5: manDL_individual_list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_individual_list_in_manDL_item_list4180);
                    manDL_individual_list256=manDL_individual_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_individual_list256.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_item_list"

    public static class manDL_literal_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_literal_list"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:712:1: manDL_literal_list : manDL_literal ( COMMA manDL_literal )* -> ^( VT_LIST ( manDL_literal )+ ) ;
    public final ManchesterParser.manDL_literal_list_return manDL_literal_list() throws RecognitionException {
        ManchesterParser.manDL_literal_list_return retval = new ManchesterParser.manDL_literal_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA258=null;
        ManchesterParser.manDL_literal_return manDL_literal257 = null;

        ManchesterParser.manDL_literal_return manDL_literal259 = null;


        CommonTree COMMA258_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_manDL_literal=new RewriteRuleSubtreeStream(adaptor,"rule manDL_literal");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:713:3: ( manDL_literal ( COMMA manDL_literal )* -> ^( VT_LIST ( manDL_literal )+ ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:713:5: manDL_literal ( COMMA manDL_literal )*
            {
            pushFollow(FOLLOW_manDL_literal_in_manDL_literal_list4195);
            manDL_literal257=manDL_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_manDL_literal.add(manDL_literal257.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:713:19: ( COMMA manDL_literal )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==COMMA) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:713:20: COMMA manDL_literal
            	    {
            	    COMMA258=(Token)match(input,COMMA,FOLLOW_COMMA_in_manDL_literal_list4198); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA258);

            	    pushFollow(FOLLOW_manDL_literal_in_manDL_literal_list4200);
            	    manDL_literal259=manDL_literal();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_manDL_literal.add(manDL_literal259.getTree());

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);



            // AST REWRITE
            // elements: manDL_literal
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 714:5: -> ^( VT_LIST ( manDL_literal )+ )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:714:8: ^( VT_LIST ( manDL_literal )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_LIST, "VT_LIST"), root_1);

                if ( !(stream_manDL_literal.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_manDL_literal.hasNext() ) {
                    adaptor.addChild(root_1, stream_manDL_literal.nextTree());

                }
                stream_manDL_literal.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_literal_list"

    public static class manDL_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_literal"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:730:1: manDL_literal : ( manDL_typedLiteral | QuotedString ( LanguageTag )? | IntegerLiteral | DecimalLiteral | FloatingPointLiteral );
    public final ManchesterParser.manDL_literal_return manDL_literal() throws RecognitionException {
        ManchesterParser.manDL_literal_return retval = new ManchesterParser.manDL_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QuotedString261=null;
        Token LanguageTag262=null;
        Token IntegerLiteral263=null;
        Token DecimalLiteral264=null;
        Token FloatingPointLiteral265=null;
        ManchesterParser.manDL_typedLiteral_return manDL_typedLiteral260 = null;


        CommonTree QuotedString261_tree=null;
        CommonTree LanguageTag262_tree=null;
        CommonTree IntegerLiteral263_tree=null;
        CommonTree DecimalLiteral264_tree=null;
        CommonTree FloatingPointLiteral265_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:730:15: ( manDL_typedLiteral | QuotedString ( LanguageTag )? | IntegerLiteral | DecimalLiteral | FloatingPointLiteral )
            int alt75=5;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:731:3: manDL_typedLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_typedLiteral_in_manDL_literal4245);
                    manDL_typedLiteral260=manDL_typedLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_typedLiteral260.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:732:5: QuotedString ( LanguageTag )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    QuotedString261=(Token)match(input,QuotedString,FOLLOW_QuotedString_in_manDL_literal4252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QuotedString261_tree = (CommonTree)adaptor.create(QuotedString261);
                    adaptor.addChild(root_0, QuotedString261_tree);
                    }
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:732:18: ( LanguageTag )?
                    int alt74=2;
                    alt74 = dfa74.predict(input);
                    switch (alt74) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:732:18: LanguageTag
                            {
                            LanguageTag262=(Token)match(input,LanguageTag,FOLLOW_LanguageTag_in_manDL_literal4254); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LanguageTag262_tree = (CommonTree)adaptor.create(LanguageTag262);
                            adaptor.addChild(root_0, LanguageTag262_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:733:5: IntegerLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IntegerLiteral263=(Token)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_manDL_literal4265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerLiteral263_tree = (CommonTree)adaptor.create(IntegerLiteral263);
                    adaptor.addChild(root_0, IntegerLiteral263_tree);
                    }

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:734:5: DecimalLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DecimalLiteral264=(Token)match(input,DecimalLiteral,FOLLOW_DecimalLiteral_in_manDL_literal4272); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DecimalLiteral264_tree = (CommonTree)adaptor.create(DecimalLiteral264);
                    adaptor.addChild(root_0, DecimalLiteral264_tree);
                    }

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:735:5: FloatingPointLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FloatingPointLiteral265=(Token)match(input,FloatingPointLiteral,FOLLOW_FloatingPointLiteral_in_manDL_literal4279); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FloatingPointLiteral265_tree = (CommonTree)adaptor.create(FloatingPointLiteral265);
                    adaptor.addChild(root_0, FloatingPointLiteral265_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_literal"

    public static class manDL_data_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_data_type"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:740:1: manDL_data_type : manDL_classIRI ;
    public final ManchesterParser.manDL_data_type_return manDL_data_type() throws RecognitionException {
        ManchesterParser.manDL_data_type_return retval = new ManchesterParser.manDL_data_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_classIRI_return manDL_classIRI266 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:741:3: ( manDL_classIRI )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:741:5: manDL_classIRI
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_manDL_classIRI_in_manDL_data_type4294);
            manDL_classIRI266=manDL_classIRI();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_classIRI266.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_data_type"

    public static class manDL_primitive_data_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_primitive_data_type"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:744:1: manDL_primitive_data_type : ( INTEGER_K | DECIMAL_K | FLOAT_K | STRING_K );
    public final ManchesterParser.manDL_primitive_data_type_return manDL_primitive_data_type() throws RecognitionException {
        ManchesterParser.manDL_primitive_data_type_return retval = new ManchesterParser.manDL_primitive_data_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set267=null;

        CommonTree set267_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:745:3: ( INTEGER_K | DECIMAL_K | FLOAT_K | STRING_K )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set267=(Token)input.LT(1);
            if ( input.LA(1)==DECIMAL_K||input.LA(1)==FLOAT_K||input.LA(1)==INTEGER_K||input.LA(1)==STRING_K ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set267));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_primitive_data_type"

    public static class manDL_typedLiteral_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_typedLiteral"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:751:1: manDL_typedLiteral : QuotedString DBL_CAP manDL_data_type ;
    public final ManchesterParser.manDL_typedLiteral_return manDL_typedLiteral() throws RecognitionException {
        ManchesterParser.manDL_typedLiteral_return retval = new ManchesterParser.manDL_typedLiteral_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QuotedString268=null;
        Token DBL_CAP269=null;
        ManchesterParser.manDL_data_type_return manDL_data_type270 = null;


        CommonTree QuotedString268_tree=null;
        CommonTree DBL_CAP269_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:752:3: ( QuotedString DBL_CAP manDL_data_type )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:752:5: QuotedString DBL_CAP manDL_data_type
            {
            root_0 = (CommonTree)adaptor.nil();

            QuotedString268=(Token)match(input,QuotedString,FOLLOW_QuotedString_in_manDL_typedLiteral4350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QuotedString268_tree = (CommonTree)adaptor.create(QuotedString268);
            adaptor.addChild(root_0, QuotedString268_tree);
            }
            DBL_CAP269=(Token)match(input,DBL_CAP,FOLLOW_DBL_CAP_in_manDL_typedLiteral4352); if (state.failed) return retval;
            pushFollow(FOLLOW_manDL_data_type_in_manDL_typedLiteral4355);
            manDL_data_type270=manDL_data_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_data_type270.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_typedLiteral"

    public static class manDL_classIRI_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_classIRI"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:755:1: manDL_classIRI : iri ;
    public final ManchesterParser.manDL_classIRI_return manDL_classIRI() throws RecognitionException {
        ManchesterParser.manDL_classIRI_return retval = new ManchesterParser.manDL_classIRI_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.iri_return iri271 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:756:3: ( iri )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:756:5: iri
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_iri_in_manDL_classIRI4373);
            iri271=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, iri271.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_classIRI"

    public static class manDL_objectPropertyIRI_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_objectPropertyIRI"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:759:1: manDL_objectPropertyIRI : iri ;
    public final ManchesterParser.manDL_objectPropertyIRI_return manDL_objectPropertyIRI() throws RecognitionException {
        ManchesterParser.manDL_objectPropertyIRI_return retval = new ManchesterParser.manDL_objectPropertyIRI_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.iri_return iri272 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:760:3: ( iri )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:760:5: iri
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_iri_in_manDL_objectPropertyIRI4388);
            iri272=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, iri272.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_objectPropertyIRI"

    public static class manDL_dataPropertyIRI_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_dataPropertyIRI"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:763:1: manDL_dataPropertyIRI : iri ;
    public final ManchesterParser.manDL_dataPropertyIRI_return manDL_dataPropertyIRI() throws RecognitionException {
        ManchesterParser.manDL_dataPropertyIRI_return retval = new ManchesterParser.manDL_dataPropertyIRI_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.iri_return iri273 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:764:3: ( iri )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:764:5: iri
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_iri_in_manDL_dataPropertyIRI4404);
            iri273=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, iri273.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_dataPropertyIRI"

    public static class manDL_annotationPropertyIRI_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_annotationPropertyIRI"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:767:1: manDL_annotationPropertyIRI : iri ;
    public final ManchesterParser.manDL_annotationPropertyIRI_return manDL_annotationPropertyIRI() throws RecognitionException {
        ManchesterParser.manDL_annotationPropertyIRI_return retval = new ManchesterParser.manDL_annotationPropertyIRI_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.iri_return iri274 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:768:3: ( iri )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:768:5: iri
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_iri_in_manDL_annotationPropertyIRI4420);
            iri274=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, iri274.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_annotationPropertyIRI"

    public static class manDL_propertyIRI_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_propertyIRI"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:771:1: manDL_propertyIRI : iri ;
    public final ManchesterParser.manDL_propertyIRI_return manDL_propertyIRI() throws RecognitionException {
        ManchesterParser.manDL_propertyIRI_return retval = new ManchesterParser.manDL_propertyIRI_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.iri_return iri275 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:772:3: ( iri )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:772:5: iri
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_iri_in_manDL_propertyIRI4435);
            iri275=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, iri275.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_propertyIRI"

    public static class manDL_individual_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_individual"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:775:1: manDL_individual : ( manDL_individualIRI | nodeID );
    public final ManchesterParser.manDL_individual_return manDL_individual() throws RecognitionException {
        ManchesterParser.manDL_individual_return retval = new ManchesterParser.manDL_individual_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.manDL_individualIRI_return manDL_individualIRI276 = null;

        ManchesterParser.nodeID_return nodeID277 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:776:3: ( manDL_individualIRI | nodeID )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==DECIMAL_K||LA76_0==FLOAT_K||LA76_0==INTEGER_K||LA76_0==STRING_K||LA76_0==LESS||(LA76_0>=UNDERSCORE && LA76_0<=COLON)||(LA76_0>=PN_ID && LA76_0<=DIGIT)) ) {
                alt76=1;
            }
            else if ( (LA76_0==BLANK||LA76_0==LEFT_SQUARE) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:776:5: manDL_individualIRI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_manDL_individualIRI_in_manDL_individual4453);
                    manDL_individualIRI276=manDL_individualIRI();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, manDL_individualIRI276.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:777:5: nodeID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_nodeID_in_manDL_individual4460);
                    nodeID277=nodeID();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nodeID277.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_individual"

    public static class manDL_individualIRI_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "manDL_individualIRI"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:780:1: manDL_individualIRI : iri ;
    public final ManchesterParser.manDL_individualIRI_return manDL_individualIRI() throws RecognitionException {
        ManchesterParser.manDL_individualIRI_return retval = new ManchesterParser.manDL_individualIRI_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.iri_return iri278 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:781:3: ( iri )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:781:5: iri
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_iri_in_manDL_individualIRI4476);
            iri278=iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, iri278.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "manDL_individualIRI"

    public static class iri_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:791:1: iri options {backtrack=true; memoize=true; } : ( full_iri | abbreviated_iri | simple_iri );
    public final ManchesterParser.iri_return iri() throws RecognitionException {
        ManchesterParser.iri_return retval = new ManchesterParser.iri_return();
        retval.start = input.LT(1);
        int iri_StartIndex = input.index();
        CommonTree root_0 = null;

        ManchesterParser.full_iri_return full_iri279 = null;

        ManchesterParser.abbreviated_iri_return abbreviated_iri280 = null;

        ManchesterParser.simple_iri_return simple_iri281 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return retval; }
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:796:3: ( full_iri | abbreviated_iri | simple_iri )
            int alt77=3;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:797:3: full_iri
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_full_iri_in_iri4519);
                    full_iri279=full_iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, full_iri279.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:798:5: abbreviated_iri
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_abbreviated_iri_in_iri4526);
                    abbreviated_iri280=abbreviated_iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abbreviated_iri280.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:799:5: simple_iri
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_iri_in_iri4533);
                    simple_iri281=simple_iri();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_iri281.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, iri_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "iri"

    public static class nodeID_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nodeID"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:806:1: nodeID : ( blank_node | anon );
    public final ManchesterParser.nodeID_return nodeID() throws RecognitionException {
        ManchesterParser.nodeID_return retval = new ManchesterParser.nodeID_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.blank_node_return blank_node282 = null;

        ManchesterParser.anon_return anon283 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:807:3: ( blank_node | anon )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==BLANK) ) {
                alt78=1;
            }
            else if ( (LA78_0==LEFT_SQUARE) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:807:5: blank_node
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_blank_node_in_nodeID4550);
                    blank_node282=blank_node();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, blank_node282.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:808:5: anon
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_anon_in_nodeID4556);
                    anon283=anon();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, anon283.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nodeID"

    public static class blank_node_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blank_node"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:811:1: blank_node : BLANK pn_Local -> ^( VT_BLANK pn_Local ) ;
    public final ManchesterParser.blank_node_return blank_node() throws RecognitionException {
        ManchesterParser.blank_node_return retval = new ManchesterParser.blank_node_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BLANK284=null;
        ManchesterParser.pn_Local_return pn_Local285 = null;


        CommonTree BLANK284_tree=null;
        RewriteRuleTokenStream stream_BLANK=new RewriteRuleTokenStream(adaptor,"token BLANK");
        RewriteRuleSubtreeStream stream_pn_Local=new RewriteRuleSubtreeStream(adaptor,"rule pn_Local");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:812:3: ( BLANK pn_Local -> ^( VT_BLANK pn_Local ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:812:5: BLANK pn_Local
            {
            BLANK284=(Token)match(input,BLANK,FOLLOW_BLANK_in_blank_node4571); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BLANK.add(BLANK284);

            pushFollow(FOLLOW_pn_Local_in_blank_node4573);
            pn_Local285=pn_Local();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pn_Local.add(pn_Local285.getTree());


            // AST REWRITE
            // elements: pn_Local
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 813:3: -> ^( VT_BLANK pn_Local )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:813:6: ^( VT_BLANK pn_Local )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_BLANK, "VT_BLANK"), root_1);

                adaptor.addChild(root_1, stream_pn_Local.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "blank_node"

    public static class anon_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "anon"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:816:1: anon : LEFT_SQUARE RIGHT_SQUARE -> ^( VT_ANON ) ;
    public final ManchesterParser.anon_return anon() throws RecognitionException {
        ManchesterParser.anon_return retval = new ManchesterParser.anon_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFT_SQUARE286=null;
        Token RIGHT_SQUARE287=null;

        CommonTree LEFT_SQUARE286_tree=null;
        CommonTree RIGHT_SQUARE287_tree=null;
        RewriteRuleTokenStream stream_RIGHT_SQUARE=new RewriteRuleTokenStream(adaptor,"token RIGHT_SQUARE");
        RewriteRuleTokenStream stream_LEFT_SQUARE=new RewriteRuleTokenStream(adaptor,"token LEFT_SQUARE");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:817:3: ( LEFT_SQUARE RIGHT_SQUARE -> ^( VT_ANON ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:817:5: LEFT_SQUARE RIGHT_SQUARE
            {
            LEFT_SQUARE286=(Token)match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_anon4603); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LEFT_SQUARE.add(LEFT_SQUARE286);

            RIGHT_SQUARE287=(Token)match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_anon4605); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RIGHT_SQUARE.add(RIGHT_SQUARE287);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 818:3: -> ^( VT_ANON )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:818:6: ^( VT_ANON )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_ANON, "VT_ANON"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "anon"

    public static class abbreviated_iri_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "abbreviated_iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:823:1: abbreviated_iri : pname_ns ln= pn_Local -> ^( VT_IRI pn_Local pname_ns ) ;
    public final ManchesterParser.abbreviated_iri_return abbreviated_iri() throws RecognitionException {
        ManchesterParser.abbreviated_iri_return retval = new ManchesterParser.abbreviated_iri_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.pn_Local_return ln = null;

        ManchesterParser.pname_ns_return pname_ns288 = null;


        RewriteRuleSubtreeStream stream_pname_ns=new RewriteRuleSubtreeStream(adaptor,"rule pname_ns");
        RewriteRuleSubtreeStream stream_pn_Local=new RewriteRuleSubtreeStream(adaptor,"rule pn_Local");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:824:3: ( pname_ns ln= pn_Local -> ^( VT_IRI pn_Local pname_ns ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:824:5: pname_ns ln= pn_Local
            {
            pushFollow(FOLLOW_pname_ns_in_abbreviated_iri4630);
            pname_ns288=pname_ns();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pname_ns.add(pname_ns288.getTree());
            pushFollow(FOLLOW_pn_Local_in_abbreviated_iri4634);
            ln=pn_Local();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pn_Local.add(ln.getTree());


            // AST REWRITE
            // elements: pname_ns, pn_Local
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 825:3: -> ^( VT_IRI pn_Local pname_ns )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:825:6: ^( VT_IRI pn_Local pname_ns )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_IRI, "VT_IRI"), root_1);

                adaptor.addChild(root_1, stream_pn_Local.nextTree());
                adaptor.addChild(root_1, stream_pname_ns.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "abbreviated_iri"

    public static class pname_ns_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pname_ns"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:828:1: pname_ns : (pref= pn_Prefix )? COLON -> {pref==null}? ^( VT_DEF_NS ) -> pn_Prefix ;
    public final ManchesterParser.pname_ns_return pname_ns() throws RecognitionException {
        ManchesterParser.pname_ns_return retval = new ManchesterParser.pname_ns_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON289=null;
        ManchesterParser.pn_Prefix_return pref = null;


        CommonTree COLON289_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_pn_Prefix=new RewriteRuleSubtreeStream(adaptor,"rule pn_Prefix");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:829:3: ( (pref= pn_Prefix )? COLON -> {pref==null}? ^( VT_DEF_NS ) -> pn_Prefix )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:829:5: (pref= pn_Prefix )? COLON
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:829:9: (pref= pn_Prefix )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==PN_ID) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:829:9: pref= pn_Prefix
                    {
                    pushFollow(FOLLOW_pn_Prefix_in_pname_ns4664);
                    pref=pn_Prefix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_pn_Prefix.add(pref.getTree());

                    }
                    break;

            }

            COLON289=(Token)match(input,COLON,FOLLOW_COLON_in_pname_ns4667); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON289);



            // AST REWRITE
            // elements: pn_Prefix
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 830:3: -> {pref==null}? ^( VT_DEF_NS )
            if (pref==null) {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:830:20: ^( VT_DEF_NS )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DEF_NS, "VT_DEF_NS"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 831:3: -> pn_Prefix
            {
                adaptor.addChild(root_0, stream_pn_Prefix.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pname_ns"

    public static class simple_iri_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:835:1: simple_iri : pn_Local -> ^( VT_IRI pn_Local ^( VT_DEF_NS ) ) ;
    public final ManchesterParser.simple_iri_return simple_iri() throws RecognitionException {
        ManchesterParser.simple_iri_return retval = new ManchesterParser.simple_iri_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.pn_Local_return pn_Local290 = null;


        RewriteRuleSubtreeStream stream_pn_Local=new RewriteRuleSubtreeStream(adaptor,"rule pn_Local");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:836:3: ( pn_Local -> ^( VT_IRI pn_Local ^( VT_DEF_NS ) ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:836:5: pn_Local
            {
            pushFollow(FOLLOW_pn_Local_in_simple_iri4700);
            pn_Local290=pn_Local();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_pn_Local.add(pn_Local290.getTree());


            // AST REWRITE
            // elements: pn_Local
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 837:3: -> ^( VT_IRI pn_Local ^( VT_DEF_NS ) )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:837:6: ^( VT_IRI pn_Local ^( VT_DEF_NS ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_IRI, "VT_IRI"), root_1);

                adaptor.addChild(root_1, stream_pn_Local.nextTree());
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:837:24: ^( VT_DEF_NS )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_DEF_NS, "VT_DEF_NS"), root_2);

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simple_iri"

    public static class pn_Local_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pn_Local"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:843:1: pn_Local : (pid= PN_ID -> ^( VT_NAME[$pid.text] ) | ( UNDERSCORE | DIGIT ) ( PN_INNER )? | typ= manDL_primitive_data_type -> ^( VT_NAME[$typ.text] ) );
    public final ManchesterParser.pn_Local_return pn_Local() throws RecognitionException {
        ManchesterParser.pn_Local_return retval = new ManchesterParser.pn_Local_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token pid=null;
        Token set291=null;
        Token PN_INNER292=null;
        ManchesterParser.manDL_primitive_data_type_return typ = null;


        CommonTree pid_tree=null;
        CommonTree set291_tree=null;
        CommonTree PN_INNER292_tree=null;
        RewriteRuleTokenStream stream_PN_ID=new RewriteRuleTokenStream(adaptor,"token PN_ID");
        RewriteRuleSubtreeStream stream_manDL_primitive_data_type=new RewriteRuleSubtreeStream(adaptor,"rule manDL_primitive_data_type");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:844:3: (pid= PN_ID -> ^( VT_NAME[$pid.text] ) | ( UNDERSCORE | DIGIT ) ( PN_INNER )? | typ= manDL_primitive_data_type -> ^( VT_NAME[$typ.text] ) )
            int alt81=3;
            switch ( input.LA(1) ) {
            case PN_ID:
                {
                alt81=1;
                }
                break;
            case UNDERSCORE:
            case DIGIT:
                {
                alt81=2;
                }
                break;
            case DECIMAL_K:
            case FLOAT_K:
            case INTEGER_K:
            case STRING_K:
                {
                alt81=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:844:6: pid= PN_ID
                    {
                    pid=(Token)match(input,PN_ID,FOLLOW_PN_ID_in_pn_Local4737); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PN_ID.add(pid);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 844:16: -> ^( VT_NAME[$pid.text] )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:844:19: ^( VT_NAME[$pid.text] )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NAME, (pid!=null?pid.getText():null)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:845:5: ( UNDERSCORE | DIGIT ) ( PN_INNER )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    set291=(Token)input.LT(1);
                    if ( input.LA(1)==UNDERSCORE||input.LA(1)==DIGIT ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set291));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:845:28: ( PN_INNER )?
                    int alt80=2;
                    alt80 = dfa80.predict(input);
                    switch (alt80) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:845:28: PN_INNER
                            {
                            PN_INNER292=(Token)match(input,PN_INNER,FOLLOW_PN_INNER_in_pn_Local4760); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PN_INNER292_tree = (CommonTree)adaptor.create(PN_INNER292);
                            adaptor.addChild(root_0, PN_INNER292_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:846:5: typ= manDL_primitive_data_type
                    {
                    pushFollow(FOLLOW_manDL_primitive_data_type_in_pn_Local4769);
                    typ=manDL_primitive_data_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_manDL_primitive_data_type.add(typ.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 846:35: -> ^( VT_NAME[$typ.text] )
                    {
                        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:846:38: ^( VT_NAME[$typ.text] )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NAME, (typ!=null?input.toString(typ.start,typ.stop):null)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pn_Local"

    public static class pn_Prefix_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pn_Prefix"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:849:1: pn_Prefix : pref= PN_ID -> ^( VT_NAME[$pref.text] ) ;
    public final ManchesterParser.pn_Prefix_return pn_Prefix() throws RecognitionException {
        ManchesterParser.pn_Prefix_return retval = new ManchesterParser.pn_Prefix_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token pref=null;

        CommonTree pref_tree=null;
        RewriteRuleTokenStream stream_PN_ID=new RewriteRuleTokenStream(adaptor,"token PN_ID");

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:850:3: (pref= PN_ID -> ^( VT_NAME[$pref.text] ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:850:5: pref= PN_ID
            {
            pref=(Token)match(input,PN_ID,FOLLOW_PN_ID_in_pn_Prefix4792); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PN_ID.add(pref);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 850:16: -> ^( VT_NAME[$pref.text] )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:850:19: ^( VT_NAME[$pref.text] )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_NAME, (pref!=null?pref.getText():null)), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pn_Prefix"

    public static class full_iri_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "full_iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:857:1: full_iri : LESS checked_iri GREATER ;
    public final ManchesterParser.full_iri_return full_iri() throws RecognitionException {
        ManchesterParser.full_iri_return retval = new ManchesterParser.full_iri_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LESS293=null;
        Token GREATER295=null;
        ManchesterParser.checked_iri_return checked_iri294 = null;


        CommonTree LESS293_tree=null;
        CommonTree GREATER295_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:858:3: ( LESS checked_iri GREATER )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:858:5: LESS checked_iri GREATER
            {
            root_0 = (CommonTree)adaptor.nil();

            LESS293=(Token)match(input,LESS,FOLLOW_LESS_in_full_iri4816); if (state.failed) return retval;
            pushFollow(FOLLOW_checked_iri_in_full_iri4825);
            checked_iri294=checked_iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, checked_iri294.getTree());
            GREATER295=(Token)match(input,GREATER,FOLLOW_GREATER_in_full_iri4831); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "full_iri"

    public static class checked_iri_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "checked_iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:864:1: checked_iri : i= any_iri {...}? => -> ^( VT_IRI any_iri ) ;
    public final ManchesterParser.checked_iri_return checked_iri() throws RecognitionException {
        ManchesterParser.checked_iri_return retval = new ManchesterParser.checked_iri_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.any_iri_return i = null;


        RewriteRuleSubtreeStream stream_any_iri=new RewriteRuleSubtreeStream(adaptor,"rule any_iri");
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:865:3: (i= any_iri {...}? => -> ^( VT_IRI any_iri ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:865:5: i= any_iri {...}? =>
            {
            pushFollow(FOLLOW_any_iri_in_checked_iri4861);
            i=any_iri();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_any_iri.add(i.getTree());
            if ( !((validateIRI((i!=null?input.toString(i.start,i.stop):null)))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "checked_iri", "validateIRI($i.text)");
            }


            // AST REWRITE
            // elements: any_iri
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 866:3: -> ^( VT_IRI any_iri )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:866:6: ^( VT_IRI any_iri )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_IRI, "VT_IRI"), root_1);

                adaptor.addChild(root_1, stream_any_iri.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "checked_iri"

    public static class any_iri_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "any_iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:869:1: any_iri : cc= any_iri_content -> ^( VT_PAREN_CHUNK[$cc.start,text] ) ;
    public final ManchesterParser.any_iri_return any_iri() throws RecognitionException {
        ManchesterParser.any_iri_return retval = new ManchesterParser.any_iri_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ManchesterParser.any_iri_content_return cc = null;


        RewriteRuleSubtreeStream stream_any_iri_content=new RewriteRuleSubtreeStream(adaptor,"rule any_iri_content");

          String text = "";

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:872:3: (cc= any_iri_content -> ^( VT_PAREN_CHUNK[$cc.start,text] ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:872:5: cc= any_iri_content
            {
            pushFollow(FOLLOW_any_iri_content_in_any_iri4898);
            cc=any_iri_content();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_any_iri_content.add(cc.getTree());
            if ( state.backtracking==0 ) {
              text = (cc!=null?input.toString(cc.start,cc.stop):null);
            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 873:3: -> ^( VT_PAREN_CHUNK[$cc.start,text] )
            {
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:873:6: ^( VT_PAREN_CHUNK[$cc.start,text] )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VT_PAREN_CHUNK, (cc!=null?((Token)cc.start):null), text), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "any_iri"

    public static class any_iri_content_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "any_iri_content"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:876:1: any_iri_content : (~ ( GREATER | SLASH ) | SLASH )* ;
    public final ManchesterParser.any_iri_content_return any_iri_content() throws RecognitionException {
        ManchesterParser.any_iri_content_return retval = new ManchesterParser.any_iri_content_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set296=null;

        CommonTree set296_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:877:3: ( (~ ( GREATER | SLASH ) | SLASH )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:877:5: (~ ( GREATER | SLASH ) | SLASH )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:877:5: (~ ( GREATER | SLASH ) | SLASH )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( ((LA82_0>=VT_IMPORT && LA82_0<=VALUE_K)||(LA82_0>=GEQ && LA82_0<=PN_CHARS)) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:
            	    {
            	    set296=(Token)input.LT(1);
            	    if ( (input.LA(1)>=VT_IMPORT && input.LA(1)<=VALUE_K)||(input.LA(1)>=GEQ && input.LA(1)<=PN_CHARS) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set296));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "any_iri_content"

    // $ANTLR start synpred1_ManchesterParser
    public final void synpred1_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:160:5: ( ANNOTATIONS_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:160:6: ANNOTATIONS_K
        {
        match(input,ANNOTATIONS_K,FOLLOW_ANNOTATIONS_K_in_synpred1_ManchesterParser842); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_ManchesterParser

    // $ANTLR start synpred2_ManchesterParser
    public final void synpred2_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:161:5: ( DISJOINTUNIONOF_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:161:6: DISJOINTUNIONOF_K
        {
        match(input,DISJOINTUNIONOF_K,FOLLOW_DISJOINTUNIONOF_K_in_synpred2_ManchesterParser854); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_ManchesterParser

    // $ANTLR start synpred3_ManchesterParser
    public final void synpred3_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:162:5: ( DISJOINTWITH_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:162:6: DISJOINTWITH_K
        {
        match(input,DISJOINTWITH_K,FOLLOW_DISJOINTWITH_K_in_synpred3_ManchesterParser866); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_ManchesterParser

    // $ANTLR start synpred4_ManchesterParser
    public final void synpred4_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:163:5: ( EQUIVALENTTO_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:163:6: EQUIVALENTTO_K
        {
        match(input,EQUIVALENTTO_K,FOLLOW_EQUIVALENTTO_K_in_synpred4_ManchesterParser878); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_ManchesterParser

    // $ANTLR start synpred5_ManchesterParser
    public final void synpred5_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:164:5: ( SUBCLASSOF_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:164:6: SUBCLASSOF_K
        {
        match(input,SUBCLASSOF_K,FOLLOW_SUBCLASSOF_K_in_synpred5_ManchesterParser890); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_ManchesterParser

    // $ANTLR start synpred6_ManchesterParser
    public final void synpred6_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:165:5: ( HASKEY_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:165:6: HASKEY_K
        {
        match(input,HASKEY_K,FOLLOW_HASKEY_K_in_synpred6_ManchesterParser902); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ManchesterParser

    // $ANTLR start synpred7_ManchesterParser
    public final void synpred7_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:222:5: ( manDL_classIRI THAT_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:222:6: manDL_classIRI THAT_K
        {
        pushFollow(FOLLOW_manDL_classIRI_in_synpred7_ManchesterParser1240);
        manDL_classIRI();

        state._fsp--;
        if (state.failed) return ;
        match(input,THAT_K,FOLLOW_THAT_K_in_synpred7_ManchesterParser1242); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_ManchesterParser

    // $ANTLR start synpred8_ManchesterParser
    public final void synpred8_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:242:3: ( manDL_restr )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:242:3: manDL_restr
        {
        pushFollow(FOLLOW_manDL_restr_in_synpred8_ManchesterParser1377);
        manDL_restr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ManchesterParser

    // $ANTLR start synpred9_ManchesterParser
    public final void synpred9_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:284:9: ( SOME_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:284:10: SOME_K
        {
        match(input,SOME_K,FOLLOW_SOME_K_in_synpred9_ManchesterParser1558); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_ManchesterParser

    // $ANTLR start synpred10_ManchesterParser
    public final void synpred10_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:286:9: ( ONLY_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:286:10: ONLY_K
        {
        match(input,ONLY_K,FOLLOW_ONLY_K_in_synpred10_ManchesterParser1592); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_ManchesterParser

    // $ANTLR start synpred11_ManchesterParser
    public final void synpred11_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:290:9: ( VALUE_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:290:10: VALUE_K
        {
        match(input,VALUE_K,FOLLOW_VALUE_K_in_synpred11_ManchesterParser1629); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_ManchesterParser

    // $ANTLR start synpred12_ManchesterParser
    public final void synpred12_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:292:9: ( SELF_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:292:10: SELF_K
        {
        match(input,SELF_K,FOLLOW_SELF_K_in_synpred12_ManchesterParser1673); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_ManchesterParser

    // $ANTLR start synpred13_ManchesterParser
    public final void synpred13_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:294:9: ( MIN_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:294:10: MIN_K
        {
        match(input,MIN_K,FOLLOW_MIN_K_in_synpred13_ManchesterParser1703); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_ManchesterParser

    // $ANTLR start synpred14_ManchesterParser
    public final void synpred14_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:296:9: ( MAX_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:296:10: MAX_K
        {
        match(input,MAX_K,FOLLOW_MAX_K_in_synpred14_ManchesterParser1741); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_ManchesterParser

    // $ANTLR start synpred15_ManchesterParser
    public final void synpred15_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:298:9: ( EXACTLY_K )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:298:10: EXACTLY_K
        {
        match(input,EXACTLY_K,FOLLOW_EXACTLY_K_in_synpred15_ManchesterParser1811); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_ManchesterParser

    // $ANTLR start synpred16_ManchesterParser
    public final void synpred16_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:302:9: ( manDL_data_type_restriction )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:302:10: manDL_data_type_restriction
        {
        pushFollow(FOLLOW_manDL_data_type_restriction_in_synpred16_ManchesterParser1857);
        manDL_data_type_restriction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_ManchesterParser

    // $ANTLR start synpred18_ManchesterParser
    public final void synpred18_ManchesterParser_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:798:5: ( abbreviated_iri )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterParser.g:798:5: abbreviated_iri
        {
        pushFollow(FOLLOW_abbreviated_iri_in_synpred18_ManchesterParser4526);
        abbreviated_iri();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_ManchesterParser

    // Delegated rules

    public final boolean synpred13_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_ManchesterParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_ManchesterParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA80 dfa80 = new DFA80(this);
    static final String DFA3_eotS =
        "\25\uffff";
    static final String DFA3_eofS =
        "\1\6\24\uffff";
    static final String DFA3_minS =
        "\1\115\24\uffff";
    static final String DFA3_maxS =
        "\1\u00a6\24\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\16\uffff";
    static final String DFA3_specialS =
        "\25\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\6\2\uffff\3\6\1\1\3\6\4\uffff\2\6\3\uffff\1\1\2\uffff\2\6"+
            "\3\uffff\1\1\12\uffff\1\6\10\uffff\1\6\2\uffff\1\1\13\uffff"+
            "\1\1\3\uffff\2\1\23\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "68:22: (nam= iri (ver= iri )? )?";
        }
    }
    static final String DFA2_eotS =
        "\25\uffff";
    static final String DFA2_eofS =
        "\1\6\24\uffff";
    static final String DFA2_minS =
        "\1\115\24\uffff";
    static final String DFA2_maxS =
        "\1\u00a6\24\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\16\uffff";
    static final String DFA2_specialS =
        "\25\uffff}>";
    static final String[] DFA2_transitionS = {
            "\2\6\2\uffff\3\6\1\1\3\6\4\uffff\2\6\3\uffff\1\1\2\uffff\2\6"+
            "\3\uffff\1\1\12\uffff\1\6\10\uffff\1\6\2\uffff\1\1\13\uffff"+
            "\1\1\3\uffff\2\1\23\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "68:34: (ver= iri )?";
        }
    }
    static final String DFA4_eotS =
        "\20\uffff";
    static final String DFA4_eofS =
        "\1\1\17\uffff";
    static final String DFA4_minS =
        "\1\115\17\uffff";
    static final String DFA4_maxS =
        "\1\175\17\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\15\uffff\1\1";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\1\2\uffff\3\1\1\uffff\3\1\4\uffff\2\1\6\uffff\1\17\1\1\16"+
            "\uffff\1\1\10\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 69:5: ( manDL_inport )*";
        }
    }
    static final String DFA5_eotS =
        "\17\uffff";
    static final String DFA5_eofS =
        "\1\2\16\uffff";
    static final String DFA5_minS =
        "\1\115\16\uffff";
    static final String DFA5_maxS =
        "\1\175\16\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA5_specialS =
        "\17\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2\2\uffff\3\2\1\uffff\3\2\4\uffff\2\2\7\uffff\1\2\16"+
            "\uffff\1\2\10\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "70:5: ( manDL_annotations )?";
        }
    }
    static final String DFA6_eotS =
        "\16\uffff";
    static final String DFA6_eofS =
        "\1\1\15\uffff";
    static final String DFA6_minS =
        "\1\116\15\uffff";
    static final String DFA6_maxS =
        "\1\175\15\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\2\1\1\13\uffff";
    static final String DFA6_specialS =
        "\16\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\2\uffff\3\2\1\uffff\3\2\4\uffff\2\2\7\uffff\1\2\16\uffff"+
            "\1\2\10\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 71:5: ( manDL_type_declaration )*";
        }
    }
    static final String DFA10_eotS =
        "\61\uffff";
    static final String DFA10_eofS =
        "\1\1\60\uffff";
    static final String DFA10_minS =
        "\1\115\60\uffff";
    static final String DFA10_maxS =
        "\1\u00a6\60\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\2\56\uffff\1\1";
    static final String DFA10_specialS =
        "\61\uffff}>";
    static final String[] DFA10_transitionS = {
            "\22\1\1\uffff\4\1\1\uffff\6\1\10\uffff\2\1\5\uffff\4\1\2\uffff"+
            "\5\1\1\uffff\2\1\4\uffff\1\1\2\uffff\3\1\1\60\1\uffff\1\1\1"+
            "\uffff\1\1\1\uffff\1\1\14\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 107:22: ( COMMA manDL_annotation )*";
        }
    }
    static final String DFA12_eotS =
        "\14\uffff";
    static final String DFA12_eofS =
        "\14\uffff";
    static final String DFA12_minS =
        "\1\124\13\uffff";
    static final String DFA12_maxS =
        "\1\u00a6\13\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\3\uffff";
    static final String DFA12_specialS =
        "\14\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\14\uffff\1\1\7\uffff\1\1\26\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\3\1\2\uffff\1\1\6\uffff\2\10\1\uffff\1\10\1\uffff\1\10\4\uffff"+
            "\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "115:1: manDL_annotation_target : ( manDL_individual | manDL_literal );";
        }
    }
    static final String DFA13_eotS =
        "\15\uffff";
    static final String DFA13_eofS =
        "\15\uffff";
    static final String DFA13_minS =
        "\1\116\14\uffff";
    static final String DFA13_maxS =
        "\1\175\14\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\5\uffff";
    static final String DFA13_specialS =
        "\15\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\5\2\uffff\1\2\1\4\1\1\1\uffff\3\7\4\uffff\2\7\7\uffff\1\6"+
            "\16\uffff\1\3\10\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "121:1: manDL_type_declaration : ( manDL_datatype_def | manDL_class | manDL_objectProperty | manDL_dataProperty | manDL_annotationProperty | manDL_namedIndividual | manDL_misc );";
        }
    }
    static final String DFA14_eotS =
        "\24\uffff";
    static final String DFA14_eofS =
        "\1\1\23\uffff";
    static final String DFA14_minS =
        "\1\115\23\uffff";
    static final String DFA14_maxS =
        "\1\u0081\23\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\5\uffff";
    static final String DFA14_specialS =
        "\24\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\16\1\1\2\uffff\3\1\1\uffff\3\1\1\uffff\2\16\1\uffff\2\1\1"+
            "\16\4\uffff\1\16\1\uffff\1\1\16\uffff\1\1\10\uffff\1\1\3\uffff"+
            "\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()* loopback of 142:7: ( manDL_class_frame )*";
        }
    }
    static final String DFA16_eotS =
        "\25\uffff";
    static final String DFA16_eofS =
        "\1\1\24\uffff";
    static final String DFA16_minS =
        "\1\115\24\uffff";
    static final String DFA16_maxS =
        "\1\u0092\24\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\2\22\uffff\1\1";
    static final String DFA16_specialS =
        "\25\uffff}>";
    static final String[] DFA16_transitionS = {
            "\2\1\2\uffff\3\1\1\uffff\3\1\1\uffff\2\1\1\uffff\3\1\4\uffff"+
            "\1\1\1\uffff\1\1\16\uffff\1\1\10\uffff\1\1\3\uffff\1\1\20\uffff"+
            "\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()+ loopback of 176:33: ( COMMA manDL_annotated_description )+";
        }
    }
    static final String DFA18_eotS =
        "\25\uffff";
    static final String DFA18_eofS =
        "\1\1\24\uffff";
    static final String DFA18_minS =
        "\1\115\24\uffff";
    static final String DFA18_maxS =
        "\1\u0092\24\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\2\22\uffff\1\1";
    static final String DFA18_specialS =
        "\25\uffff}>";
    static final String[] DFA18_transitionS = {
            "\2\1\2\uffff\3\1\1\uffff\3\1\1\uffff\2\1\1\uffff\3\1\4\uffff"+
            "\1\1\1\uffff\1\1\16\uffff\1\1\10\uffff\1\1\3\uffff\1\1\20\uffff"+
            "\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()* loopback of 195:65: ( COMMA manDL_property_expression )*";
        }
    }
    static final String DFA19_eotS =
        "\37\uffff";
    static final String DFA19_eofS =
        "\1\1\36\uffff";
    static final String DFA19_minS =
        "\1\115\36\uffff";
    static final String DFA19_maxS =
        "\1\u0092\36\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\2\34\uffff\1\1";
    static final String DFA19_specialS =
        "\37\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\1\1\uffff\4\1\1\uffff\12\1\1\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\1\1\2\uffff\1\1\13\uffff\1\1\5\uffff\1\1\1\uffff\2\1\3\uffff"+
            "\3\1\3\uffff\1\1\12\uffff\1\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()* loopback of 204:33: ( COMMA manDL_annotated_description )*";
        }
    }
    static final String DFA20_eotS =
        "\13\uffff";
    static final String DFA20_eofS =
        "\13\uffff";
    static final String DFA20_minS =
        "\1\115\12\uffff";
    static final String DFA20_maxS =
        "\1\u00a6\12\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\6\uffff\1\2\14\uffff\1\2\4\uffff\1\2\2\uffff\1\2\11\uffff"+
            "\1\2\14\uffff\1\2\13\uffff\1\2\3\uffff\2\2\4\uffff\1\2\1\uffff"+
            "\1\2\14\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "209:5: ( manDL_annotations )?";
        }
    }
    static final String DFA21_eotS =
        "\41\uffff";
    static final String DFA21_eofS =
        "\1\1\40\uffff";
    static final String DFA21_minS =
        "\1\115\40\uffff";
    static final String DFA21_maxS =
        "\1\u0097\40\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\2\36\uffff\1\1";
    static final String DFA21_specialS =
        "\41\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\1\1\uffff\4\1\1\uffff\12\1\1\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\1\1\2\uffff\1\1\13\uffff\1\1\2\uffff\1\40\2\uffff\1\1\1\uffff"+
            "\2\1\3\uffff\3\1\3\uffff\1\1\12\uffff\1\1\4\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 216:23: (or= OR_K manDL_conjunction )*";
        }
    }
    static final String DFA24_eotS =
        "\u009d\uffff";
    static final String DFA24_eofS =
        "\2\uffff\1\6\1\uffff\2\6\u0097\uffff";
    static final String DFA24_minS =
        "\1\124\1\4\1\114\1\124\2\114\4\uffff\3\0\56\uffff\4\0\136\uffff";
    static final String DFA24_maxS =
        "\1\u00a6\1\u00b1\4\u00a6\4\uffff\3\0\56\uffff\4\0\136\uffff";
    static final String DFA24_acceptS =
        "\6\uffff\1\2\6\uffff\1\1\61\uffff\1\1\56\uffff\1\1\56\uffff";
    static final String DFA24_specialS =
        "\2\uffff\1\0\1\uffff\1\1\1\2\4\uffff\1\3\1\4\1\5\56\uffff\1\6\1"+
        "\7\1\10\1\11\136\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\5\14\uffff\1\5\4\uffff\1\6\2\uffff\1\5\11\uffff\1\6\14\uffff"+
            "\1\5\13\uffff\1\1\3\uffff\1\4\1\3\4\uffff\1\6\1\uffff\1\6\14"+
            "\uffff\1\2\1\4",
            "\u0085\12\1\13\50\12",
            "\3\6\1\uffff\22\6\1\uffff\1\6\1\uffff\1\6\2\uffff\2\6\3\uffff"+
            "\1\6\1\uffff\1\6\4\uffff\2\6\1\uffff\1\6\2\uffff\1\6\1\uffff"+
            "\10\6\1\uffff\1\15\1\uffff\2\6\3\uffff\1\6\3\uffff\1\6\1\14"+
            "\1\6\1\uffff\1\6\2\uffff\1\6\15\uffff\2\6",
            "\1\75\14\uffff\1\75\7\uffff\1\75\26\uffff\1\75\17\uffff\1\74"+
            "\24\uffff\1\73\1\74",
            "\3\6\1\uffff\22\6\1\uffff\1\6\1\uffff\1\6\2\uffff\2\6\3\uffff"+
            "\1\6\1\uffff\1\6\4\uffff\2\6\1\uffff\1\6\2\uffff\1\6\1\uffff"+
            "\10\6\1\uffff\1\77\1\uffff\2\6\3\uffff\1\6\3\uffff\3\6\1\uffff"+
            "\1\6\2\uffff\1\6\14\uffff\1\76\2\6",
            "\3\6\1\uffff\22\6\1\uffff\1\6\1\uffff\1\6\2\uffff\2\6\3\uffff"+
            "\1\6\1\uffff\1\6\4\uffff\2\6\1\uffff\1\6\2\uffff\1\6\1\uffff"+
            "\10\6\1\uffff\1\156\1\uffff\2\6\3\uffff\1\6\3\uffff\3\6\1\uffff"+
            "\1\6\2\uffff\1\6\15\uffff\2\6",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "221:1: manDL_conjunction : ( ( manDL_classIRI THAT_K )=> manDL_classIRI THAT_K manDL_restr ( AND_K manDL_restr )* -> ^( VT_AND ^( VT_DL_TYPE manDL_classIRI ) ( manDL_restr )+ ) | manDL_primary (and= AND_K manDL_primary )* -> {and==null}? manDL_primary -> ^( VT_AND ( manDL_primary )+ ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_2==COLON) ) {s = 12;}

                        else if ( (LA24_2==THAT_K) && (synpred7_ManchesterParser())) {s = 13;}

                        else if ( (LA24_2==EOF||(LA24_2>=AND_K && LA24_2<=ANNOTATIONPROPERTY_K)||(LA24_2>=CHARACTERISTICS_K && LA24_2<=FLOAT_K)||LA24_2==HASKEY_K||LA24_2==INDIVIDUAL_K||(LA24_2>=INVERSEOF_K && LA24_2<=INTEGER_K)||LA24_2==MAX_K||LA24_2==MIN_K||(LA24_2>=OBJECTPROPERTY_K && LA24_2<=ONLY_K)||LA24_2==OR_K||LA24_2==RANGE_K||(LA24_2>=SAMEAS_K && LA24_2<=SUBPROPERTYCHAIN_K)||(LA24_2>=TYPES_K && LA24_2<=VALUE_K)||LA24_2==LESS||LA24_2==UNDERSCORE||LA24_2==COMMA||LA24_2==LEFT_SQUARE||LA24_2==RIGHT_PAREN||(LA24_2>=PN_ID && LA24_2<=DIGIT)) ) {s = 6;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_4==PN_INNER) ) {s = 62;}

                        else if ( (LA24_4==THAT_K) && (synpred7_ManchesterParser())) {s = 63;}

                        else if ( (LA24_4==EOF||(LA24_4>=AND_K && LA24_4<=ANNOTATIONPROPERTY_K)||(LA24_4>=CHARACTERISTICS_K && LA24_4<=FLOAT_K)||LA24_4==HASKEY_K||LA24_4==INDIVIDUAL_K||(LA24_4>=INVERSEOF_K && LA24_4<=INTEGER_K)||LA24_4==MAX_K||LA24_4==MIN_K||(LA24_4>=OBJECTPROPERTY_K && LA24_4<=ONLY_K)||LA24_4==OR_K||LA24_4==RANGE_K||(LA24_4>=SAMEAS_K && LA24_4<=SUBPROPERTYCHAIN_K)||(LA24_4>=TYPES_K && LA24_4<=VALUE_K)||LA24_4==LESS||(LA24_4>=UNDERSCORE && LA24_4<=COMMA)||LA24_4==LEFT_SQUARE||LA24_4==RIGHT_PAREN||(LA24_4>=PN_ID && LA24_4<=DIGIT)) ) {s = 6;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_5==THAT_K) && (synpred7_ManchesterParser())) {s = 110;}

                        else if ( (LA24_5==EOF||(LA24_5>=AND_K && LA24_5<=ANNOTATIONPROPERTY_K)||(LA24_5>=CHARACTERISTICS_K && LA24_5<=FLOAT_K)||LA24_5==HASKEY_K||LA24_5==INDIVIDUAL_K||(LA24_5>=INVERSEOF_K && LA24_5<=INTEGER_K)||LA24_5==MAX_K||LA24_5==MIN_K||(LA24_5>=OBJECTPROPERTY_K && LA24_5<=ONLY_K)||LA24_5==OR_K||LA24_5==RANGE_K||(LA24_5>=SAMEAS_K && LA24_5<=SUBPROPERTYCHAIN_K)||(LA24_5>=TYPES_K && LA24_5<=VALUE_K)||LA24_5==LESS||(LA24_5>=UNDERSCORE && LA24_5<=COMMA)||LA24_5==LEFT_SQUARE||LA24_5==RIGHT_PAREN||(LA24_5>=PN_ID && LA24_5<=DIGIT)) ) {s = 6;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_10 = input.LA(1);

                         
                        int index24_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_10);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_11 = input.LA(1);

                         
                        int index24_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_12 = input.LA(1);

                         
                        int index24_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA24_59 = input.LA(1);

                         
                        int index24_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_59);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA24_60 = input.LA(1);

                         
                        int index24_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_60);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA24_61 = input.LA(1);

                         
                        int index24_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_61);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA24_62 = input.LA(1);

                         
                        int index24_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_ManchesterParser()) ) {s = 110;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index24_62);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\42\uffff";
    static final String DFA22_eofS =
        "\1\1\41\uffff";
    static final String DFA22_minS =
        "\1\114\41\uffff";
    static final String DFA22_maxS =
        "\1\u0097\41\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\2\37\uffff\1\1";
    static final String DFA22_specialS =
        "\42\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\41\2\1\1\uffff\4\1\1\uffff\12\1\1\uffff\1\1\2\uffff\1\1\1"+
            "\uffff\1\1\2\uffff\1\1\13\uffff\1\1\2\uffff\1\1\2\uffff\1\1"+
            "\1\uffff\2\1\3\uffff\3\1\3\uffff\1\1\12\uffff\1\1\4\uffff\1"+
            "\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "()* loopback of 225:6: ( AND_K manDL_restr )*";
        }
    }
    static final String DFA23_eotS =
        "\42\uffff";
    static final String DFA23_eofS =
        "\1\1\41\uffff";
    static final String DFA23_minS =
        "\1\114\41\uffff";
    static final String DFA23_maxS =
        "\1\u0097\41\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\2\37\uffff\1\1";
    static final String DFA23_specialS =
        "\42\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\41\2\1\1\uffff\4\1\1\uffff\12\1\1\uffff\1\1\2\uffff\1\1\1"+
            "\uffff\1\1\2\uffff\1\1\13\uffff\1\1\2\uffff\1\1\2\uffff\1\1"+
            "\1\uffff\2\1\3\uffff\3\1\3\uffff\1\1\12\uffff\1\1\4\uffff\1"+
            "\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 228:19: (and= AND_K manDL_primary )*";
        }
    }
    static final String DFA25_eotS =
        "\u00a2\uffff";
    static final String DFA25_eofS =
        "\4\uffff\1\10\1\uffff\2\10\u009a\uffff";
    static final String DFA25_minS =
        "\2\124\1\uffff\1\4\1\114\1\124\2\114\3\uffff\5\0\2\uffff\3\0\55"+
        "\uffff\4\0\134\uffff";
    static final String DFA25_maxS =
        "\2\u00a6\1\uffff\1\u00b1\4\u00a6\3\uffff\5\0\2\uffff\3\0\55\uffff"+
        "\4\0\134\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\1\5\uffff\1\2\u0099\uffff";
    static final String DFA25_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\2\uffff\1\5\1\6\1\7\55\uffff\1\10"+
        "\1\11\1\12\1\13\134\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\7\14\uffff\1\7\4\uffff\1\2\2\uffff\1\7\11\uffff\1\1\14\uffff"+
            "\1\7\13\uffff\1\3\3\uffff\1\6\1\5\4\uffff\1\10\1\uffff\1\10"+
            "\14\uffff\1\4\1\6",
            "\1\17\14\uffff\1\17\4\uffff\1\2\2\uffff\1\17\26\uffff\1\17"+
            "\13\uffff\1\13\3\uffff\1\16\1\15\4\uffff\1\10\1\uffff\1\10\14"+
            "\uffff\1\14\1\16",
            "",
            "\u0085\22\1\23\50\22",
            "\3\10\1\uffff\4\10\1\2\12\10\1\2\1\10\1\2\1\uffff\1\10\1\uffff"+
            "\1\10\2\uffff\1\10\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\10"+
            "\1\2\1\uffff\1\10\2\uffff\1\10\1\uffff\2\10\3\2\3\10\3\uffff"+
            "\1\10\1\2\3\uffff\1\2\3\uffff\1\2\1\24\1\10\1\uffff\1\10\2\uffff"+
            "\1\10\15\uffff\2\2",
            "\1\104\14\uffff\1\104\7\uffff\1\104\26\uffff\1\104\17\uffff"+
            "\1\103\24\uffff\1\102\1\103",
            "\3\10\1\uffff\4\10\1\2\12\10\1\2\1\10\1\2\1\uffff\1\10\1\uffff"+
            "\1\10\2\uffff\1\10\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\10"+
            "\1\2\1\uffff\1\10\2\uffff\1\10\1\uffff\2\10\3\2\3\10\3\uffff"+
            "\1\10\1\2\3\uffff\1\2\3\uffff\2\2\1\10\1\uffff\1\10\2\uffff"+
            "\1\10\14\uffff\1\105\2\2",
            "\3\10\1\uffff\4\10\1\2\12\10\1\2\1\10\1\2\1\uffff\1\10\1\uffff"+
            "\1\10\2\uffff\1\10\1\2\3\uffff\1\2\1\uffff\1\2\4\uffff\1\10"+
            "\1\2\1\uffff\1\10\2\uffff\1\10\1\uffff\2\10\3\2\3\10\3\uffff"+
            "\1\10\1\2\3\uffff\1\2\3\uffff\2\2\1\10\1\uffff\1\10\2\uffff"+
            "\1\10\15\uffff\2\2",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "237:1: manDL_primary options {backtrack=true; } : ( manDL_restr | manDL_atom );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_11 = input.LA(1);

                         
                        int index25_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_12 = input.LA(1);

                         
                        int index25_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_14 = input.LA(1);

                         
                        int index25_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_15 = input.LA(1);

                         
                        int index25_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_18 = input.LA(1);

                         
                        int index25_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_18);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_19 = input.LA(1);

                         
                        int index25_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_19);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_20 = input.LA(1);

                         
                        int index25_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_20);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_66 = input.LA(1);

                         
                        int index25_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_66);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_67 = input.LA(1);

                         
                        int index25_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_67);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_68 = input.LA(1);

                         
                        int index25_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_68);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_69 = input.LA(1);

                         
                        int index25_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ManchesterParser()) ) {s = 2;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index25_69);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\15\uffff";
    static final String DFA30_eofS =
        "\15\uffff";
    static final String DFA30_minS =
        "\1\124\14\uffff";
    static final String DFA30_maxS =
        "\1\u00a6\14\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\5\10";
    static final String DFA30_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\14\12\uffff\1\7\1\uffff\1\14\7\uffff\1\14\3\uffff\1\6\1\uffff"+
            "\1\5\5\uffff\1\2\10\uffff\1\4\1\1\1\14\7\uffff\1\3\3\uffff\1"+
            "\10\3\uffff\1\13\1\12\23\uffff\1\11\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "284:5: ( ( SOME_K )=> SOME_K manDL_primary -> ^( VT_EXISTS manDL_property_expression manDL_primary ) | ( ONLY_K )=> ONLY_K manDL_primary -> ^( VT_FORALL manDL_property_expression manDL_primary ) | ( VALUE_K )=> VALUE_K ( manDL_individual | manDL_literal ) -> ^( VT_VALUE manDL_property_expression ( manDL_individual )? ( manDL_literal )? ) | ( SELF_K )=> SELF_K -> ^( VT_SELF manDL_property_expression ) | ( MIN_K )=> manDL_min_restr -> ^( VT_COUNT manDL_property_expression manDL_min_restr ) | ( MAX_K )=> manDL_max_restr -> ^( VT_COUNT manDL_property_expression manDL_max_restr ) | ( EXACTLY_K )=> manDL_exactly_restr -> ^( VT_COUNT manDL_property_expression manDL_exactly_restr ) | ( manDL_data_type_restriction )=> manDL_data_type_restriction -> ^( VT_COUNT manDL_property_expression ^( VT_MIN IntegerLiteral[\"1\"] ) ^( VT_MAX IntegerLiteral[\"1\"] ) manDL_data_type_restriction ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_0 = input.LA(1);

                         
                        int index30_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA30_0==SOME_K) && (synpred9_ManchesterParser())) {s = 1;}

                        else if ( (LA30_0==ONLY_K) && (synpred10_ManchesterParser())) {s = 2;}

                        else if ( (LA30_0==VALUE_K) && (synpred11_ManchesterParser())) {s = 3;}

                        else if ( (LA30_0==SELF_K) && (synpred12_ManchesterParser())) {s = 4;}

                        else if ( (LA30_0==MIN_K) && (synpred13_ManchesterParser())) {s = 5;}

                        else if ( (LA30_0==MAX_K) && (synpred14_ManchesterParser())) {s = 6;}

                        else if ( (LA30_0==EXACTLY_K) && (synpred15_ManchesterParser())) {s = 7;}

                        else if ( (LA30_0==LESS) && (synpred16_ManchesterParser())) {s = 8;}

                        else if ( (LA30_0==PN_ID) && (synpred16_ManchesterParser())) {s = 9;}

                        else if ( (LA30_0==COLON) && (synpred16_ManchesterParser())) {s = 10;}

                        else if ( (LA30_0==UNDERSCORE||LA30_0==DIGIT) && (synpred16_ManchesterParser())) {s = 11;}

                        else if ( (LA30_0==DECIMAL_K||LA30_0==FLOAT_K||LA30_0==INTEGER_K||LA30_0==STRING_K) && (synpred16_ManchesterParser())) {s = 12;}

                         
                        input.seek(index30_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\14\uffff";
    static final String DFA29_eofS =
        "\14\uffff";
    static final String DFA29_minS =
        "\1\124\13\uffff";
    static final String DFA29_maxS =
        "\1\u00a6\13\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\3\uffff";
    static final String DFA29_specialS =
        "\14\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\14\uffff\1\1\7\uffff\1\1\26\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\3\1\2\uffff\1\1\6\uffff\2\10\1\uffff\1\10\1\uffff\1\10\4\uffff"+
            "\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "290:30: ( manDL_individual | manDL_literal )";
        }
    }
    static final String DFA31_eotS =
        "\53\uffff";
    static final String DFA31_eofS =
        "\1\12\52\uffff";
    static final String DFA31_minS =
        "\1\114\52\uffff";
    static final String DFA31_maxS =
        "\1\u00a6\52\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\40\uffff";
    static final String DFA31_specialS =
        "\53\uffff}>";
    static final String[] DFA31_transitionS = {
            "\3\12\1\uffff\4\12\1\1\12\12\1\uffff\1\12\1\1\1\uffff\1\12\1"+
            "\uffff\1\12\1\1\1\uffff\1\12\1\1\11\uffff\1\1\1\12\2\uffff\1"+
            "\12\2\uffff\1\12\1\uffff\2\12\2\uffff\1\1\3\12\3\uffff\1\12"+
            "\4\uffff\1\1\3\uffff\2\1\1\12\3\uffff\1\1\1\12\1\1\14\uffff"+
            "\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "313:30: ( manDL_primary )?";
        }
    }
    static final String DFA32_eotS =
        "\53\uffff";
    static final String DFA32_eofS =
        "\1\12\52\uffff";
    static final String DFA32_minS =
        "\1\114\52\uffff";
    static final String DFA32_maxS =
        "\1\u00a6\52\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\40\uffff";
    static final String DFA32_specialS =
        "\53\uffff}>";
    static final String[] DFA32_transitionS = {
            "\3\12\1\uffff\4\12\1\1\12\12\1\uffff\1\12\1\1\1\uffff\1\12\1"+
            "\uffff\1\12\1\1\1\uffff\1\12\1\1\11\uffff\1\1\1\12\2\uffff\1"+
            "\12\2\uffff\1\12\1\uffff\2\12\2\uffff\1\1\3\12\3\uffff\1\12"+
            "\4\uffff\1\1\3\uffff\2\1\1\12\3\uffff\1\1\1\12\1\1\14\uffff"+
            "\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "323:25: ( manDL_primary )?";
        }
    }
    static final String DFA33_eotS =
        "\53\uffff";
    static final String DFA33_eofS =
        "\1\12\52\uffff";
    static final String DFA33_minS =
        "\1\114\52\uffff";
    static final String DFA33_maxS =
        "\1\u00a6\52\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\40\uffff";
    static final String DFA33_specialS =
        "\53\uffff}>";
    static final String[] DFA33_transitionS = {
            "\3\12\1\uffff\4\12\1\1\12\12\1\uffff\1\12\1\1\1\uffff\1\12\1"+
            "\uffff\1\12\1\1\1\uffff\1\12\1\1\11\uffff\1\1\1\12\2\uffff\1"+
            "\12\2\uffff\1\12\1\uffff\2\12\2\uffff\1\1\3\12\3\uffff\1\12"+
            "\4\uffff\1\1\3\uffff\2\1\1\12\3\uffff\1\1\1\12\1\1\14\uffff"+
            "\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "332:25: ( manDL_primary )?";
        }
    }
    static final String DFA34_eotS =
        "\43\uffff";
    static final String DFA34_eofS =
        "\1\2\42\uffff";
    static final String DFA34_minS =
        "\1\114\42\uffff";
    static final String DFA34_maxS =
        "\1\u0097\42\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\1\1\2\40\uffff";
    static final String DFA34_specialS =
        "\43\uffff}>";
    static final String[] DFA34_transitionS = {
            "\3\2\1\uffff\4\2\1\uffff\12\2\1\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\1\2\2\uffff\1\2\13\uffff\1\2\2\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\2\2\3\uffff\3\2\3\uffff\1\2\12\uffff\1\2\1\uffff\1\1\2\uffff"+
            "\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "342:21: ( LEFT_SQUARE fac= manDL_facets RIGHT_SQUARE )?";
        }
    }
    static final String DFA36_eotS =
        "\12\uffff";
    static final String DFA36_eofS =
        "\12\uffff";
    static final String DFA36_minS =
        "\1\153\11\uffff";
    static final String DFA36_maxS =
        "\1\u008c\11\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA36_specialS =
        "\12\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\5\1\1\1\uffff\1\3\1\uffff\1\2\7\uffff\1\4\20\uffff\1\7\1"+
            "\6\1\10\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "359:7: ( LENGTH_K | MINLENGTH_K | MAXLENGTH_K | PATTERN_K | LANGPATTERN_K | GEQ | GREATER | LEQ | LESS )";
        }
    }
    static final String DFA37_eotS =
        "\20\uffff";
    static final String DFA37_eofS =
        "\1\1\17\uffff";
    static final String DFA37_minS =
        "\1\115\17\uffff";
    static final String DFA37_maxS =
        "\1\175\17\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA37_specialS =
        "\20\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\16\1\1\2\uffff\3\1\1\uffff\3\1\4\uffff\2\1\1\16\6\uffff\1"+
            "\1\16\uffff\1\1\10\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 385:7: ( manDL_datatype_frame )*";
        }
    }
    static final String DFA39_eotS =
        "\27\uffff";
    static final String DFA39_eofS =
        "\1\1\26\uffff";
    static final String DFA39_minS =
        "\1\115\26\uffff";
    static final String DFA39_maxS =
        "\1\u0083\26\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\10\uffff";
    static final String DFA39_specialS =
        "\27\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\16\1\1\1\uffff\1\16\3\1\1\uffff\3\1\1\uffff\1\16\1\uffff"+
            "\1\16\2\1\1\16\6\uffff\1\1\2\uffff\1\16\13\uffff\1\1\5\uffff"+
            "\1\16\2\uffff\1\1\4\uffff\2\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "()* loopback of 401:7: ( manDL_objProp_frame )*";
        }
    }
    static final String DFA40_eotS =
        "\12\uffff";
    static final String DFA40_eofS =
        "\12\uffff";
    static final String DFA40_minS =
        "\1\115\11\uffff";
    static final String DFA40_maxS =
        "\1\u0083\11\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA40_specialS =
        "\12\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\2\uffff\1\2\10\uffff\1\3\1\uffff\1\6\2\uffff\1\4\11\uffff"+
            "\1\5\21\uffff\1\7\7\uffff\1\10\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "407:1: manDL_objProp_frame : ( manDL_annotations | manDL_attributes | manDL_disjointWith | manDL_equivalentTo | manDL_inverseOf | manDL_domain | manDL_range | manDL_subPropertyOf | manDL_subPropChain );";
        }
    }
    static final String DFA41_eotS =
        "\25\uffff";
    static final String DFA41_eofS =
        "\1\1\24\uffff";
    static final String DFA41_minS =
        "\1\115\24\uffff";
    static final String DFA41_maxS =
        "\1\u0082\24\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\6\uffff";
    static final String DFA41_specialS =
        "\25\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\16\1\1\1\uffff\1\16\3\1\1\uffff\3\1\1\uffff\1\16\1\uffff"+
            "\1\16\2\1\1\16\6\uffff\1\1\16\uffff\1\1\5\uffff\1\16\2\uffff"+
            "\1\1\4\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "()* loopback of 426:7: ( manDL_dataProp_frame )*";
        }
    }
    static final String DFA44_eotS =
        "\30\uffff";
    static final String DFA44_eofS =
        "\1\1\27\uffff";
    static final String DFA44_minS =
        "\1\115\27\uffff";
    static final String DFA44_maxS =
        "\1\u008d\27\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\2\25\uffff\1\1";
    static final String DFA44_specialS =
        "\30\uffff}>";
    static final String[] DFA44_transitionS = {
            "\2\1\1\uffff\4\1\1\uffff\3\1\1\uffff\1\1\1\uffff\4\1\6\uffff"+
            "\1\1\2\uffff\1\1\13\uffff\1\1\5\uffff\1\1\2\uffff\1\1\4\uffff"+
            "\2\1\11\uffff\1\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()* loopback of 469:75: ( CHAIN manDL_property_expression )*";
        }
    }
    static final String DFA45_eotS =
        "\22\uffff";
    static final String DFA45_eofS =
        "\1\1\21\uffff";
    static final String DFA45_minS =
        "\1\115\21\uffff";
    static final String DFA45_maxS =
        "\1\u0082\21\uffff";
    static final String DFA45_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\3\uffff";
    static final String DFA45_specialS =
        "\22\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\16\1\1\2\uffff\3\1\1\uffff\3\1\3\uffff\1\16\2\1\7\uffff\1"+
            "\1\16\uffff\1\1\5\uffff\1\16\2\uffff\1\1\4\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "()* loopback of 483:7: ( manDL_annProp_frame )*";
        }
    }
    static final String DFA47_eotS =
        "\23\uffff";
    static final String DFA47_eofS =
        "\1\1\22\uffff";
    static final String DFA47_minS =
        "\1\115\22\uffff";
    static final String DFA47_maxS =
        "\1\u0087\22\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\4\uffff";
    static final String DFA47_specialS =
        "\23\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\16\1\1\2\uffff\3\1\1\uffff\3\1\1\16\3\uffff\2\1\2\uffff\1"+
            "\16\4\uffff\1\1\16\uffff\1\1\7\uffff\1\16\1\1\11\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "()* loopback of 504:7: ( manDL_indiv_frame )*";
        }
    }
    static final String DFA49_eotS =
        "\25\uffff";
    static final String DFA49_eofS =
        "\1\1\24\uffff";
    static final String DFA49_minS =
        "\1\115\24\uffff";
    static final String DFA49_maxS =
        "\1\u0099\24\uffff";
    static final String DFA49_acceptS =
        "\1\uffff\1\2\22\uffff\1\1";
    static final String DFA49_specialS =
        "\25\uffff}>";
    static final String[] DFA49_transitionS = {
            "\2\1\2\uffff\3\1\1\uffff\4\1\3\uffff\2\1\2\uffff\1\1\4\uffff"+
            "\1\1\16\uffff\1\1\7\uffff\2\1\11\uffff\1\1\12\uffff\1\24\6\uffff"+
            "\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "()* loopback of 522:32: ( COMMA manDL_annotated_individual )*";
        }
    }
    static final String DFA51_eotS =
        "\24\uffff";
    static final String DFA51_eofS =
        "\1\1\23\uffff";
    static final String DFA51_minS =
        "\1\115\23\uffff";
    static final String DFA51_maxS =
        "\1\u0092\23\uffff";
    static final String DFA51_acceptS =
        "\1\uffff\1\2\21\uffff\1\1";
    static final String DFA51_specialS =
        "\24\uffff}>";
    static final String[] DFA51_transitionS = {
            "\2\1\2\uffff\3\1\1\uffff\4\1\3\uffff\2\1\2\uffff\1\1\4\uffff"+
            "\1\1\16\uffff\1\1\7\uffff\2\1\11\uffff\1\1\12\uffff\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "()* loopback of 537:26: ( COMMA manDL_annotated_fact )*";
        }
    }
    static final String DFA54_eotS =
        "\14\uffff";
    static final String DFA54_eofS =
        "\14\uffff";
    static final String DFA54_minS =
        "\1\124\13\uffff";
    static final String DFA54_maxS =
        "\1\u00a6\13\uffff";
    static final String DFA54_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\3\uffff";
    static final String DFA54_specialS =
        "\14\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\1\14\uffff\1\1\7\uffff\1\1\26\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\3\1\2\uffff\1\1\6\uffff\2\10\1\uffff\1\10\1\uffff\1\10\4\uffff"+
            "\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "546:42: ( manDL_individual | manDL_literal )";
        }
    }
    static final String DFA56_eotS =
        "\13\uffff";
    static final String DFA56_eofS =
        "\13\uffff";
    static final String DFA56_minS =
        "\1\115\12\uffff";
    static final String DFA56_maxS =
        "\1\u00a6\12\uffff";
    static final String DFA56_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA56_specialS =
        "\13\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\1\6\uffff\1\2\14\uffff\1\2\4\uffff\1\2\2\uffff\1\2\11\uffff"+
            "\1\2\14\uffff\1\2\13\uffff\1\2\3\uffff\2\2\4\uffff\1\2\1\uffff"+
            "\1\2\14\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "581:7: ( manDL_annotations )?";
        }
    }
    static final String DFA57_eotS =
        "\17\uffff";
    static final String DFA57_eofS =
        "\1\1\16\uffff";
    static final String DFA57_minS =
        "\1\116\16\uffff";
    static final String DFA57_maxS =
        "\1\u0092\16\uffff";
    static final String DFA57_acceptS =
        "\1\uffff\1\2\14\uffff\1\1";
    static final String DFA57_specialS =
        "\17\uffff}>";
    static final String[] DFA57_transitionS = {
            "\1\1\2\uffff\3\1\1\uffff\3\1\4\uffff\2\1\7\uffff\1\1\16\uffff"+
            "\1\1\10\uffff\1\1\24\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "()+ loopback of 581:44: ( COMMA manDL_description )+";
        }
    }
    static final String DFA60_eotS =
        "\17\uffff";
    static final String DFA60_eofS =
        "\1\1\16\uffff";
    static final String DFA60_minS =
        "\1\116\16\uffff";
    static final String DFA60_maxS =
        "\1\u0092\16\uffff";
    static final String DFA60_acceptS =
        "\1\uffff\1\2\14\uffff\1\1";
    static final String DFA60_specialS =
        "\17\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\1\2\uffff\3\1\1\uffff\3\1\4\uffff\2\1\7\uffff\1\1\16\uffff"+
            "\1\1\10\uffff\1\1\24\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "()+ loopback of 586:52: ( COMMA manDL_property_expression )+";
        }
    }
    static final String DFA63_eotS =
        "\17\uffff";
    static final String DFA63_eofS =
        "\1\1\16\uffff";
    static final String DFA63_minS =
        "\1\116\16\uffff";
    static final String DFA63_maxS =
        "\1\u0092\16\uffff";
    static final String DFA63_acceptS =
        "\1\uffff\1\2\14\uffff\1\1";
    static final String DFA63_specialS =
        "\17\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\1\2\uffff\3\1\1\uffff\3\1\4\uffff\2\1\7\uffff\1\1\16\uffff"+
            "\1\1\10\uffff\1\1\24\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "()+ loopback of 591:43: ( COMMA manDL_individual )+";
        }
    }
    static final String DFA67_eotS =
        "\30\uffff";
    static final String DFA67_eofS =
        "\1\1\27\uffff";
    static final String DFA67_minS =
        "\1\115\27\uffff";
    static final String DFA67_maxS =
        "\1\u0092\27\uffff";
    static final String DFA67_acceptS =
        "\1\uffff\1\2\25\uffff\1\1";
    static final String DFA67_specialS =
        "\30\uffff}>";
    static final String[] DFA67_transitionS = {
            "\2\1\1\uffff\4\1\1\uffff\3\1\1\uffff\1\1\1\uffff\4\1\6\uffff"+
            "\1\1\2\uffff\1\1\13\uffff\1\1\5\uffff\1\1\2\uffff\1\1\4\uffff"+
            "\2\1\16\uffff\1\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "()* loopback of 635:66: ( COMMA ( manDL_annotations )? manDL_attribute )*";
        }
    }
    static final String DFA69_eotS =
        "\30\uffff";
    static final String DFA69_eofS =
        "\1\2\27\uffff";
    static final String DFA69_minS =
        "\1\115\27\uffff";
    static final String DFA69_maxS =
        "\1\u0092\27\uffff";
    static final String DFA69_acceptS =
        "\1\uffff\1\1\1\2\25\uffff";
    static final String DFA69_specialS =
        "\30\uffff}>";
    static final String[] DFA69_transitionS = {
            "\2\2\1\uffff\4\2\1\uffff\3\2\1\uffff\1\2\1\uffff\4\2\6\uffff"+
            "\1\2\2\uffff\1\2\13\uffff\1\2\5\uffff\1\2\2\uffff\1\2\4\uffff"+
            "\2\2\16\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "693:29: ( COMMA manDL_annotatedProperty )?";
        }
    }
    static final String DFA72_eotS =
        "\15\uffff";
    static final String DFA72_eofS =
        "\15\uffff";
    static final String DFA72_minS =
        "\1\115\14\uffff";
    static final String DFA72_maxS =
        "\1\u00a6\14\uffff";
    static final String DFA72_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\7\uffff";
    static final String DFA72_specialS =
        "\15\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\5\6\uffff\1\5\14\uffff\1\5\7\uffff\1\5\26\uffff\1\5\13\uffff"+
            "\1\5\2\uffff\3\5\2\uffff\1\5\6\uffff\2\1\1\uffff\1\1\1\uffff"+
            "\1\1\4\uffff\2\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "707:1: manDL_item_list : ( manDL_literal_list | manDL_individual_list );";
        }
    }
    static final String DFA75_eotS =
        "\74\uffff";
    static final String DFA75_eofS =
        "\1\uffff\1\6\72\uffff";
    static final String DFA75_minS =
        "\1\u009b\1\114\72\uffff";
    static final String DFA75_maxS =
        "\1\u00a0\1\u00a6\72\uffff";
    static final String DFA75_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\1\1\2\65\uffff";
    static final String DFA75_specialS =
        "\74\uffff}>";
    static final String[] DFA75_transitionS = {
            "\1\2\1\3\1\uffff\1\4\1\uffff\1\1",
            "\23\6\1\uffff\4\6\1\uffff\6\6\10\uffff\2\6\2\uffff\1\6\2\uffff"+
            "\4\6\2\uffff\5\6\1\uffff\2\6\4\uffff\1\6\1\uffff\1\5\4\6\1\uffff"+
            "\6\6\10\uffff\1\6\2\uffff\2\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA75_eot = DFA.unpackEncodedString(DFA75_eotS);
    static final short[] DFA75_eof = DFA.unpackEncodedString(DFA75_eofS);
    static final char[] DFA75_min = DFA.unpackEncodedStringToUnsignedChars(DFA75_minS);
    static final char[] DFA75_max = DFA.unpackEncodedStringToUnsignedChars(DFA75_maxS);
    static final short[] DFA75_accept = DFA.unpackEncodedString(DFA75_acceptS);
    static final short[] DFA75_special = DFA.unpackEncodedString(DFA75_specialS);
    static final short[][] DFA75_transition;

    static {
        int numStates = DFA75_transitionS.length;
        DFA75_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA75_transition[i] = DFA.unpackEncodedString(DFA75_transitionS[i]);
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = DFA75_eot;
            this.eof = DFA75_eof;
            this.min = DFA75_min;
            this.max = DFA75_max;
            this.accept = DFA75_accept;
            this.special = DFA75_special;
            this.transition = DFA75_transition;
        }
        public String getDescription() {
            return "730:1: manDL_literal : ( manDL_typedLiteral | QuotedString ( LanguageTag )? | IntegerLiteral | DecimalLiteral | FloatingPointLiteral );";
        }
    }
    static final String DFA74_eotS =
        "\67\uffff";
    static final String DFA74_eofS =
        "\1\2\66\uffff";
    static final String DFA74_minS =
        "\1\114\66\uffff";
    static final String DFA74_maxS =
        "\1\u00a6\66\uffff";
    static final String DFA74_acceptS =
        "\1\uffff\1\1\1\2\64\uffff";
    static final String DFA74_specialS =
        "\67\uffff}>";
    static final String[] DFA74_transitionS = {
            "\23\2\1\uffff\4\2\1\uffff\6\2\10\uffff\2\2\2\uffff\1\2\2\uffff"+
            "\4\2\2\uffff\5\2\1\uffff\2\2\4\uffff\1\2\2\uffff\4\2\1\uffff"+
            "\6\2\10\uffff\1\1\2\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "732:18: ( LanguageTag )?";
        }
    }
    static final String DFA77_eotS =
        "\111\uffff";
    static final String DFA77_eofS =
        "\111\uffff";
    static final String DFA77_minS =
        "\1\124\1\uffff\1\0\106\uffff";
    static final String DFA77_maxS =
        "\1\u00a6\1\uffff\1\0\106\uffff";
    static final String DFA77_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\104\uffff";
    static final String DFA77_specialS =
        "\2\uffff\1\0\106\uffff}>";
    static final String[] DFA77_transitionS = {
            "\1\4\14\uffff\1\4\7\uffff\1\4\26\uffff\1\4\13\uffff\1\1\3\uffff"+
            "\1\4\1\3\23\uffff\1\2\1\4",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA77_eot = DFA.unpackEncodedString(DFA77_eotS);
    static final short[] DFA77_eof = DFA.unpackEncodedString(DFA77_eofS);
    static final char[] DFA77_min = DFA.unpackEncodedStringToUnsignedChars(DFA77_minS);
    static final char[] DFA77_max = DFA.unpackEncodedStringToUnsignedChars(DFA77_maxS);
    static final short[] DFA77_accept = DFA.unpackEncodedString(DFA77_acceptS);
    static final short[] DFA77_special = DFA.unpackEncodedString(DFA77_specialS);
    static final short[][] DFA77_transition;

    static {
        int numStates = DFA77_transitionS.length;
        DFA77_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA77_transition[i] = DFA.unpackEncodedString(DFA77_transitionS[i]);
        }
    }

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = DFA77_eot;
            this.eof = DFA77_eof;
            this.min = DFA77_min;
            this.max = DFA77_max;
            this.accept = DFA77_accept;
            this.special = DFA77_special;
            this.transition = DFA77_transition;
        }
        public String getDescription() {
            return "791:1: iri options {backtrack=true; memoize=true; } : ( full_iri | abbreviated_iri | simple_iri );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_2 = input.LA(1);

                         
                        int index77_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_ManchesterParser()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index77_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA80_eotS =
        "\105\uffff";
    static final String DFA80_eofS =
        "\1\2\104\uffff";
    static final String DFA80_minS =
        "\1\114\104\uffff";
    static final String DFA80_maxS =
        "\1\u00a6\104\uffff";
    static final String DFA80_acceptS =
        "\1\uffff\1\1\1\2\102\uffff";
    static final String DFA80_specialS =
        "\105\uffff}>";
    static final String[] DFA80_transitionS = {
            "\37\2\2\uffff\1\2\1\uffff\1\2\3\uffff\3\2\1\uffff\1\2\2\uffff"+
            "\17\2\3\uffff\2\2\1\uffff\4\2\1\uffff\6\2\1\uffff\2\2\1\uffff"+
            "\1\2\1\uffff\1\2\3\uffff\1\1\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA80_eot = DFA.unpackEncodedString(DFA80_eotS);
    static final short[] DFA80_eof = DFA.unpackEncodedString(DFA80_eofS);
    static final char[] DFA80_min = DFA.unpackEncodedStringToUnsignedChars(DFA80_minS);
    static final char[] DFA80_max = DFA.unpackEncodedStringToUnsignedChars(DFA80_maxS);
    static final short[] DFA80_accept = DFA.unpackEncodedString(DFA80_acceptS);
    static final short[] DFA80_special = DFA.unpackEncodedString(DFA80_specialS);
    static final short[][] DFA80_transition;

    static {
        int numStates = DFA80_transitionS.length;
        DFA80_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA80_transition[i] = DFA.unpackEncodedString(DFA80_transitionS[i]);
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = DFA80_eot;
            this.eof = DFA80_eof;
            this.min = DFA80_min;
            this.max = DFA80_max;
            this.accept = DFA80_accept;
            this.special = DFA80_special;
            this.transition = DFA80_transition;
        }
        public String getDescription() {
            return "845:28: ( PN_INNER )?";
        }
    }
 

    public static final BitSet FOLLOW_manDL_prefix_in_manDL_ontology127 = new BitSet(new long[]{0x0000000000000000L,0x0244000000000000L});
    public static final BitSet FOLLOW_ONTOLOGY_K_in_manDL_ontology136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_ontology138 = new BitSet(new long[]{0x0000000000000002L,0x2010023230FE6000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_ontology143 = new BitSet(new long[]{0x0000000000000002L,0x2010023230FE6000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_ontology147 = new BitSet(new long[]{0x0000000000000002L,0x2010003030EE6000L});
    public static final BitSet FOLLOW_manDL_inport_in_manDL_ontology156 = new BitSet(new long[]{0x0000000000000002L,0x2010003030EE6000L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_ontology163 = new BitSet(new long[]{0x0000000000000002L,0x2010002030EE4000L});
    public static final BitSet FOLLOW_manDL_type_declaration_in_manDL_ontology170 = new BitSet(new long[]{0x0000000000000002L,0x2010002030EE4000L});
    public static final BitSet FOLLOW_IMPORT_K_in_manDL_inport271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_inport273 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_inport275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PREFIX_K_in_manDL_prefix310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_NAMESPACE_K_in_manDL_prefix314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_prefix317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000001000L});
    public static final BitSet FOLLOW_pn_Prefix_in_manDL_prefix337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000021000L});
    public static final BitSet FOLLOW_COLON_in_manDL_prefix342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_full_iri_in_manDL_prefix345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_full_iri_in_manDL_prefix357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANNOTATIONS_K_in_manDL_annotations415 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_annotations417 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotation_list_in_manDL_annotations419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotation_in_manDL_annotation_list450 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_annotation_list453 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotation_in_manDL_annotation_list456 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_annotation474 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotationPropertyIRI_in_manDL_annotation477 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_annotation_target_in_manDL_annotation479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_individual_in_manDL_annotation_target512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_literal_in_manDL_annotation_target516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_datatype_def_in_manDL_type_declaration535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_class_in_manDL_type_declaration541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_objectProperty_in_manDL_type_declaration552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_dataProperty_in_manDL_type_declaration558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotationProperty_in_manDL_type_declaration564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_namedIndividual_in_manDL_type_declaration570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_misc_in_manDL_type_declaration578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_K_in_manDL_class618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_class620 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_class634 = new BitSet(new long[]{0x0000000000000002L,0x0000000846002000L,0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_class_frame_in_manDL_class642 = new BitSet(new long[]{0x0000000000000002L,0x0000000846002000L,0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_class_frame847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_disjointUnionOf_in_manDL_class_frame859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_disjointWith_in_manDL_class_frame871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_equivalentTo_in_manDL_class_frame883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_subClassOf_in_manDL_class_frame895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_hasKey_in_manDL_class_frame907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJOINTUNIONOF_K_in_manDL_disjointUnionOf936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_disjointUnionOf938 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_disjointUnionOf_list_in_manDL_disjointUnionOf940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotated_description_in_manDL_disjointUnionOf_list965 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_disjointUnionOf_list968 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_in_manDL_disjointUnionOf_list971 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_DISJOINTWITH_K_in_manDL_disjointWith991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_disjointWith993 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_list_in_manDL_disjointWith995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUIVALENTTO_K_in_manDL_equivalentTo1019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_equivalentTo1021 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_list_in_manDL_equivalentTo1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBCLASSOF_K_in_manDL_subClassOf1052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_subClassOf1054 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_list_in_manDL_subClassOf1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASKEY_K_in_manDL_hasKey1083 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_hasKey1085 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_hasKey1087 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_hasKey1090 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_hasKey1093 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_hasKey1095 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_annotated_description_in_manDL_annotated_description_list1138 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_annotated_description_list1141 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_in_manDL_annotated_description_list1144 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_annotated_description1160 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_description_in_manDL_annotated_description1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_conjunction_in_manDL_description1194 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_OR_K_in_manDL_description1200 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_conjunction_in_manDL_description1202 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_manDL_classIRI_in_manDL_conjunction1253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_THAT_K_in_manDL_conjunction1255 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_restr_in_manDL_conjunction1266 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_AND_K_in_manDL_conjunction1275 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_restr_in_manDL_conjunction1277 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_conjunction1310 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_AND_K_in_manDL_conjunction1316 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_conjunction1318 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_manDL_restr_in_manDL_primary1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_atom_in_manDL_primary1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_K_in_manDL_atom1400 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_atomic_core_in_manDL_atom1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_K_in_manDL_restr1436 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_quantified_restriction_core_in_manDL_restr1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_manDL_atomic_core1481 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_item_list_in_manDL_atomic_core1484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_manDL_atomic_core1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_data_type_restriction_in_manDL_atomic_core1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_manDL_atomic_core1512 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_description_in_manDL_atomic_core1515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_manDL_atomic_core1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_quantified_restriction_core1544 = new BitSet(new long[]{0x0000000000000000L,0xC020A20280100000L,0x0000006000031101L});
    public static final BitSet FOLLOW_SOME_K_in_manDL_quantified_restriction_core1563 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_quantified_restriction_core1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ONLY_K_in_manDL_quantified_restriction_core1597 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_quantified_restriction_core1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_K_in_manDL_quantified_restriction_core1634 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_individual_in_manDL_quantified_restriction_core1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_literal_in_manDL_quantified_restriction_core1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELF_K_in_manDL_quantified_restriction_core1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_min_restr_in_manDL_quantified_restriction_core1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_max_restr_in_manDL_quantified_restriction_core1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_exactly_restr_in_manDL_quantified_restriction_core1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_data_type_restriction_in_manDL_quantified_restriction_core1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_K_in_manDL_exactly_restr1940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_IntegerLiteral_in_manDL_exactly_restr1942 = new BitSet(new long[]{0x0000000000000002L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_exactly_restr1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_K_in_manDL_max_restr2001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_IntegerLiteral_in_manDL_max_restr2003 = new BitSet(new long[]{0x0000000000000002L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_max_restr2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_K_in_manDL_min_restr2053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_IntegerLiteral_in_manDL_min_restr2055 = new BitSet(new long[]{0x0000000000000002L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_primary_in_manDL_min_restr2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_data_type_in_manDL_data_type_restriction2110 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_manDL_data_type_restriction2113 = new BitSet(new long[]{0x0000000000000000L,0x0101580000000000L,0x0000000000001E00L});
    public static final BitSet FOLLOW_manDL_facets_in_manDL_data_type_restriction2117 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_manDL_data_type_restriction2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_facet_in_manDL_facets2162 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_restriction_value_in_manDL_facets2164 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_facets2169 = new BitSet(new long[]{0x0000000000000000L,0x0101580000000000L,0x0000000000001E00L});
    public static final BitSet FOLLOW_manDL_facet_in_manDL_facets2171 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_restriction_value_in_manDL_facets2173 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_literal_in_manDL_restriction_value2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_K_in_manDL_facet2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINLENGTH_K_in_manDL_facet2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAXLENGTH_K_in_manDL_facet2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATTERN_K_in_manDL_facet2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGPATTERN_K_in_manDL_facet2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GEQ_in_manDL_facet2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_in_manDL_facet2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEQ_in_manDL_facet2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_manDL_facet2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATATYPE_K_in_manDL_datatype_def2336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_datatype_def2338 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_datatype_def2346 = new BitSet(new long[]{0x0000000000000002L,0x0000000040002000L});
    public static final BitSet FOLLOW_manDL_datatype_frame_in_manDL_datatype_def2354 = new BitSet(new long[]{0x0000000000000002L,0x0000000040002000L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_datatype_frame2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_equivalentTo_in_manDL_datatype_frame2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OBJECTPROPERTY_K_in_manDL_objectProperty2426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_objectProperty2428 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_objectProperty2436 = new BitSet(new long[]{0x0000000000000002L,0x040001004A012000L,0x000000000000000CL});
    public static final BitSet FOLLOW_manDL_objProp_frame_in_manDL_objectProperty2444 = new BitSet(new long[]{0x0000000000000002L,0x040001004A012000L,0x000000000000000CL});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_objProp_frame2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_attributes_in_manDL_objProp_frame2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_disjointWith_in_manDL_objProp_frame2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_equivalentTo_in_manDL_objProp_frame2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_inverseOf_in_manDL_objProp_frame2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_domain_in_manDL_objProp_frame2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_range_in_manDL_objProp_frame2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_subPropertyOf_in_manDL_objProp_frame2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_subPropChain_in_manDL_objProp_frame2549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATAPROPERTY_K_in_manDL_dataProperty2581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_dataProperty2583 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_dataProperty2592 = new BitSet(new long[]{0x0000000000000002L,0x040000004A012000L,0x0000000000000004L});
    public static final BitSet FOLLOW_manDL_dataProp_frame_in_manDL_dataProperty2606 = new BitSet(new long[]{0x0000000000000002L,0x040000004A012000L,0x0000000000000004L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_dataProp_frame2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_domain_in_manDL_dataProp_frame2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_range_in_manDL_dataProp_frame2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_attributes_in_manDL_dataProp_frame2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_disjointWith_in_manDL_dataProp_frame2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_equivalentTo_in_manDL_dataProp_frame2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_subPropertyOf_in_manDL_dataProp_frame2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOMAIN_K_in_manDL_domain2728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_domain2730 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_list_in_manDL_domain2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_K_in_manDL_range2757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_range2759 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_list_in_manDL_range2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBPROPERTYOF_K_in_manDL_subPropertyOf2798 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_subPropertyOf2800 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_list_in_manDL_subPropertyOf2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSEOF_K_in_manDL_inverseOf2829 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_inverseOf2831 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_list_in_manDL_inverseOf2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBPROPERTYCHAIN_K_in_manDL_subPropChain2858 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_subPropChain2860 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_subPropChain2862 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_subPropChain2865 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_CHAIN_in_manDL_subPropChain2869 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_subPropChain2871 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_ANNOTATIONPROPERTY_K_in_manDL_annotationProperty2918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_annotationProperty2920 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_annotationProperty2928 = new BitSet(new long[]{0x0000000000000002L,0x0400000008002000L,0x0000000000000004L});
    public static final BitSet FOLLOW_manDL_annProp_frame_in_manDL_annotationProperty2936 = new BitSet(new long[]{0x0000000000000002L,0x0400000008002000L,0x0000000000000004L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_annProp_frame2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_domain_in_manDL_annProp_frame2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_range_in_manDL_annProp_frame2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_subPropertyOf_in_manDL_annProp_frame2998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDIVIDUAL_K_in_manDL_namedIndividual3034 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_namedIndividual3036 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_iri_in_manDL_namedIndividual3044 = new BitSet(new long[]{0x0000000000000002L,0x1000000101002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_manDL_indiv_frame_in_manDL_namedIndividual3052 = new BitSet(new long[]{0x0000000000000002L,0x1000000101002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_indiv_frame3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_types_in_manDL_indiv_frame3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_facts_in_manDL_indiv_frame3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_sameAs_in_manDL_indiv_frame3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_differentFrom_in_manDL_indiv_frame3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPES_K_in_manDL_types3133 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_types3135 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotated_description_list_in_manDL_types3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotated_individual_in_manDL_individual_list3160 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_individual_list3163 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_annotated_individual_in_manDL_individual_list3165 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_annotated_individual3195 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000139001L});
    public static final BitSet FOLLOW_manDL_individual_in_manDL_annotated_individual3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FACTS_K_in_manDL_facts3229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_facts3231 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_fact_annotated_list_in_manDL_facts3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotated_fact_in_manDL_fact_annotated_list3258 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_fact_annotated_list3261 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotated_fact_in_manDL_fact_annotated_list3264 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_annotated_fact3279 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_fact_in_manDL_annotated_fact3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_K_in_manDL_fact3314 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_fact3317 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_individual_in_manDL_fact3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_literal_in_manDL_fact3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMEAS_K_in_manDL_sameAs3384 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_sameAs3386 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_individual_list_in_manDL_sameAs3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIFFERENTFROM_K_in_manDL_differentFrom3413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_differentFrom3415 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_individual_list_in_manDL_differentFrom3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUIVALENTCLASSES_K_in_manDL_misc3477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_DISJOINTCLASSES_K_in_manDL_misc3483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_misc3486 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_misc3494 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_description_in_manDL_misc3497 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_misc3500 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006001431001L});
    public static final BitSet FOLLOW_manDL_description_in_manDL_misc3502 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_EQUIVALENTPROPERTIES_K_in_manDL_misc3558 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_DISJOINTPROPERTIES_K_in_manDL_misc3564 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_misc3567 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_misc3575 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_misc3578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_misc3581 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_misc3583 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_SAMEINDIVIDUAL_K_in_manDL_misc3639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_DIFFERENTINDIVIDUALS_K_in_manDL_misc3645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_misc3648 = new BitSet(new long[]{0x0000000000000000L,0x0000020200102000L,0x0000006000139001L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_misc3656 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000139001L});
    public static final BitSet FOLLOW_manDL_individual_in_manDL_misc3659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_misc3662 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000139001L});
    public static final BitSet FOLLOW_manDL_individual_in_manDL_misc3664 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_CHARACTERISTICS_K_in_manDL_attributes3797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_manDL_attributes3799 = new BitSet(new long[]{0x0000000000000000L,0x080004840000A000L,0x0000000000000050L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_attributes3802 = new BitSet(new long[]{0x0000000000000000L,0x080004840000A000L,0x0000000000000050L});
    public static final BitSet FOLLOW_manDL_attribute_in_manDL_attributes3805 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_attributes3809 = new BitSet(new long[]{0x0000000000000000L,0x080004840000A000L,0x0000000000000050L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_attributes3812 = new BitSet(new long[]{0x0000000000000000L,0x080004840000A000L,0x0000000000000050L});
    public static final BitSet FOLLOW_manDL_attribute_in_manDL_attributes3815 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_att_functional_in_manDL_attribute3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_att_inverseFunctional_in_manDL_attribute3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_att_reflexive_in_manDL_attribute3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_att_irreflexive_in_manDL_attribute3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_att_symmetric_in_manDL_attribute3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_att_asymmetric_in_manDL_attribute3886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_att_transitive_in_manDL_attribute3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTIONAL_K_in_manDL_att_functional3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSEFUNCTIONAL_K_in_manDL_att_inverseFunctional3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFLEXIVE_K_in_manDL_att_reflexive3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IRREFLEXIVE_K_in_manDL_att_irreflexive3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMMETRIC_K_in_manDL_att_symmetric3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASYMMETRIC_K_in_manDL_att_asymmetric4013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITIVE_K_in_manDL_att_transitive4030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotatedProperty_in_manDL_property_list4075 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_property_list4078 = new BitSet(new long[]{0x0000000000000000L,0x0008024200102000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_annotatedProperty_in_manDL_property_list4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_annotations_in_manDL_annotatedProperty4099 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_property_expression_in_manDL_annotatedProperty4102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVERSE_K_in_manDL_property_expression4126 = new BitSet(new long[]{0x0000000000000000L,0x0008024200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_propertyIRI_in_manDL_property_expression4129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_literal_list_in_manDL_item_list4174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_individual_list_in_manDL_item_list4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_literal_in_manDL_literal_list4195 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_manDL_literal_list4198 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006158139001L});
    public static final BitSet FOLLOW_manDL_literal_in_manDL_literal_list4200 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_manDL_typedLiteral_in_manDL_literal4245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotedString_in_manDL_literal4252 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_LanguageTag_in_manDL_literal4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerLiteral_in_manDL_literal4265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DecimalLiteral_in_manDL_literal4272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointLiteral_in_manDL_literal4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_classIRI_in_manDL_data_type4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_manDL_primitive_data_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotedString_in_manDL_typedLiteral4350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_DBL_CAP_in_manDL_typedLiteral4352 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_manDL_data_type_in_manDL_typedLiteral4355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_manDL_classIRI4373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_manDL_objectPropertyIRI4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_manDL_dataPropertyIRI4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_manDL_annotationPropertyIRI4420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_manDL_propertyIRI4435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_individualIRI_in_manDL_individual4453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nodeID_in_manDL_individual4460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iri_in_manDL_individualIRI4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_full_iri_in_iri4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abbreviated_iri_in_iri4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_iri_in_iri4533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blank_node_in_nodeID4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anon_in_nodeID4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLANK_in_blank_node4571 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_pn_Local_in_blank_node4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_anon4603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_anon4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pname_ns_in_abbreviated_iri4630 = new BitSet(new long[]{0x0000000000000000L,0x0000020200100000L,0x0000006000031001L});
    public static final BitSet FOLLOW_pn_Local_in_abbreviated_iri4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pn_Prefix_in_pname_ns4664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_pname_ns4667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pn_Local_in_simple_iri4700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PN_ID_in_pn_Local4737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pn_Local4750 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_PN_INNER_in_pn_Local4760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_primitive_data_type_in_pn_Local4769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PN_ID_in_pn_Prefix4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_full_iri4816 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x0003FFFFFFFFFDFFL});
    public static final BitSet FOLLOW_checked_iri_in_full_iri4825 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_GREATER_in_full_iri4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_any_iri_in_checked_iri4861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_any_iri_content_in_any_iri4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_any_iri_content4929 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0xFFFFFFFFFFFFFFFFL,0x0003FFFFFFFFFDFFL});
    public static final BitSet FOLLOW_ANNOTATIONS_K_in_synpred1_ManchesterParser842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJOINTUNIONOF_K_in_synpred2_ManchesterParser854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISJOINTWITH_K_in_synpred3_ManchesterParser866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUIVALENTTO_K_in_synpred4_ManchesterParser878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBCLASSOF_K_in_synpred5_ManchesterParser890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASKEY_K_in_synpred6_ManchesterParser902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_classIRI_in_synpred7_ManchesterParser1240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_THAT_K_in_synpred7_ManchesterParser1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_restr_in_synpred8_ManchesterParser1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOME_K_in_synpred9_ManchesterParser1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ONLY_K_in_synpred10_ManchesterParser1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_K_in_synpred11_ManchesterParser1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELF_K_in_synpred12_ManchesterParser1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_K_in_synpred13_ManchesterParser1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_K_in_synpred14_ManchesterParser1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXACTLY_K_in_synpred15_ManchesterParser1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manDL_data_type_restriction_in_synpred16_ManchesterParser1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abbreviated_iri_in_synpred18_ManchesterParser4526 = new BitSet(new long[]{0x0000000000000002L});

}