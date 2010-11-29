// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g 2010-11-27 00:20:38

  package org.drools.lang.dl;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ManchesterLexer extends Lexer {
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
    public static final int EOL=170;
    public static final int GREATER=137;
    public static final int DIFFERENTFROM_K=88;
    public static final int VT_SUBPROPERTYOF=50;
    public static final int VT_AND=21;
    public static final int VT_BLANK=64;
    public static final int Digits=154;
    public static final int VT_ANNOTATIONS=31;
    public static final int RANGE_K=122;
    public static final int NAMEDINDIVIDUAL_K=113;
    public static final int DIFFERENTINDIVIDUALS_K=85;
    public static final int LanguageTag=162;
    public static final int INVERSEOF_K=104;
    public static final int DISJOINTPROPERTIES_K=87;
    public static final int LESS=140;
    public static final int NOT_K=115;
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
    public static final int VT_FIELD=34;
    public static final int VT_IRI=63;
    public static final int INDIVIDUAL_K=101;
    public static final int VT_DLA_IREF=70;
    public static final int DATAPROPERTY_K=82;
    public static final int Exponent=157;
    public static final int MAX_K=109;
    public static final int EQUIVALENTTO_K=94;
    public static final int QuotedString=160;
    public static final int VT_DISJOINTWITH=48;
    public static final int DISJOINTUNIONOF_K=90;
    public static final int ANNOTATIONS_K=77;
    public static final int ZERO=172;
    public static final int RIGHT_PAREN=151;
    public static final int VT_IMPLIES=19;
    public static final int SLASH=147;
    public static final int TRANSITIVE_K=134;
    public static final int ASYMMETRIC_K=79;
    public static final int COMMA=146;
    public static final int VT_DEF_NS=66;
    public static final int EQUIVALENTPROPERTIES_K=93;
    public static final int PREFIX_K=121;
    public static final int VT_SAMEAS=55;
    public static final int VT_ENTITY_TYPE_OBJPROP=9;
    public static final int VT_SELF=74;
    public static final int VT_DL_PROP=42;
    public static final int PN_ID=165;
    public static final int VT_VALUE=28;
    public static final int DIGIT=166;
    public static final int VT_INVERSEOF=51;
    public static final int VT_ANON=65;
    public static final int TYPES_K=135;
    public static final int EXACTLY_K=95;
    public static final int INTEGER_K=105;
    public static final int VT_KEYS=35;
    public static final int FACTS_K=96;
    public static final int VT_ANNOTATION=32;
    public static final int VT_ENTITY_TYPE_ANNPROP=11;
    public static final int ANNOTATIONPROPERTY_K=78;
    public static final int DISJOINTWITH_K=89;
    public static final int VT_PAREN_CHUNK=18;
    public static final int VT_SUBPROPERTYCHAIN=52;
    public static final int VT_DLA_FUN=67;
    public static final int INVERSEFUNCTIONAL_K=103;
    public static final int VT_DIM_SIZE=17;
    public static final int VT_DLA_IFUN=68;
    public static final int DBL_CAP=142;
    public static final int VT_DL_INV_PROP=43;
    public static final int VT_TYPE_DECLARE_ID=13;
    public static final int VK_FACET=75;
    public static final int VT_COUNT=25;
    public static final int VT_EQV_CLASS=57;
    public static final int SAMEINDIVIDUAL_K=125;
    public static final int PN_UNDSCID=168;
    public static final int SYMMETRIC_K=132;
    public static final int VT_DIFFERENTFROM=56;
    public static final int VT_DIF_INDV=62;
    public static final int VT_DL_TYPE=38;
    public static final int CHARACTERISTICS_K=80;
    public static final int DecimalLiteral=156;
    public static final int PATTERN_K=120;
    public static final int HASKEY_K=99;
    public static final int COLON=145;
    public static final int VT_MAX=27;
    public static final int STRING_K=128;
    public static final int PN_CHARS_BASE=163;
    public static final int EQUIVALENTCLASSES_K=92;
    public static final int SUBPROPERTYCHAIN_K=131;
    public static final int MIN_K=111;
    public static final int IMPORT_K=100;
    public static final int VT_DIF_CLASS=58;
    public static final int UnicodeEscape=175;
    public static final int DATATYPE_K=83;
    public static final int VT_MSR=41;
    public static final int VT_RANGE=54;
    public static final int LANGPATTERN_K=107;
    public static final int THAT_K=133;
    public static final int IntegerLiteral=155;
    public static final int VT_EQV_PROP=59;
    public static final int DISJOINTCLASSES_K=86;
    public static final int VT_DLA_TRN=73;
    public static final int LEFT_SQUARE=148;
    public static final int OctalEscape=176;
    public static final int VT_ENTITY_TYPE_CLASS=7;
    public static final int VT_DLA_REF=69;
    public static final int HEXDIGIT=174;
    public static final int LEQ=139;

    // delegates
    // delegators

    public ManchesterLexer() {;} 
    public ManchesterLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ManchesterLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g"; }

    // $ANTLR start "AND_K"
    public final void mAND_K() throws RecognitionException {
        try {
            int _type = AND_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:115:7: ( 'and' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:115:9: 'and'
            {
            match("and"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND_K"

    // $ANTLR start "ANNOTATIONS_K"
    public final void mANNOTATIONS_K() throws RecognitionException {
        try {
            int _type = ANNOTATIONS_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:117:15: ( 'Annotations' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:117:17: 'Annotations'
            {
            match("Annotations"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANNOTATIONS_K"

    // $ANTLR start "ANNOTATIONPROPERTY_K"
    public final void mANNOTATIONPROPERTY_K() throws RecognitionException {
        try {
            int _type = ANNOTATIONPROPERTY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:119:22: ( 'AnnotationProperty' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:119:24: 'AnnotationProperty'
            {
            match("AnnotationProperty"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANNOTATIONPROPERTY_K"

    // $ANTLR start "ASYMMETRIC_K"
    public final void mASYMMETRIC_K() throws RecognitionException {
        try {
            int _type = ASYMMETRIC_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:121:14: ( 'Asymmetric' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:121:16: 'Asymmetric'
            {
            match("Asymmetric"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASYMMETRIC_K"

    // $ANTLR start "CHARACTERISTICS_K"
    public final void mCHARACTERISTICS_K() throws RecognitionException {
        try {
            int _type = CHARACTERISTICS_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:123:19: ( 'Characteristics' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:123:21: 'Characteristics'
            {
            match("Characteristics"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARACTERISTICS_K"

    // $ANTLR start "CLASS_K"
    public final void mCLASS_K() throws RecognitionException {
        try {
            int _type = CLASS_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:125:9: ( 'Class' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:125:11: 'Class'
            {
            match("Class"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLASS_K"

    // $ANTLR start "DATAPROPERTY_K"
    public final void mDATAPROPERTY_K() throws RecognitionException {
        try {
            int _type = DATAPROPERTY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:127:16: ( 'DataProperty' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:127:18: 'DataProperty'
            {
            match("DataProperty"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATAPROPERTY_K"

    // $ANTLR start "DATATYPE_K"
    public final void mDATATYPE_K() throws RecognitionException {
        try {
            int _type = DATATYPE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:129:12: ( 'Datatype' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:129:14: 'Datatype'
            {
            match("Datatype"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATATYPE_K"

    // $ANTLR start "DECIMAL_K"
    public final void mDECIMAL_K() throws RecognitionException {
        try {
            int _type = DECIMAL_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:131:11: ( 'decimal' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:131:13: 'decimal'
            {
            match("decimal"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL_K"

    // $ANTLR start "DIFFERENTINDIVIDUALS_K"
    public final void mDIFFERENTINDIVIDUALS_K() throws RecognitionException {
        try {
            int _type = DIFFERENTINDIVIDUALS_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:133:24: ( 'DifferentIndividuals' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:133:26: 'DifferentIndividuals'
            {
            match("DifferentIndividuals"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIFFERENTINDIVIDUALS_K"

    // $ANTLR start "DISJOINTCLASSES_K"
    public final void mDISJOINTCLASSES_K() throws RecognitionException {
        try {
            int _type = DISJOINTCLASSES_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:135:19: ( 'DisjointClasses' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:135:21: 'DisjointClasses'
            {
            match("DisjointClasses"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISJOINTCLASSES_K"

    // $ANTLR start "DISJOINTPROPERTIES_K"
    public final void mDISJOINTPROPERTIES_K() throws RecognitionException {
        try {
            int _type = DISJOINTPROPERTIES_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:137:22: ( 'DisjointProperties' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:137:24: 'DisjointProperties'
            {
            match("DisjointProperties"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISJOINTPROPERTIES_K"

    // $ANTLR start "DIFFERENTFROM_K"
    public final void mDIFFERENTFROM_K() throws RecognitionException {
        try {
            int _type = DIFFERENTFROM_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:139:17: ( 'DifferentFrom' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:139:19: 'DifferentFrom'
            {
            match("DifferentFrom"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIFFERENTFROM_K"

    // $ANTLR start "DISJOINTWITH_K"
    public final void mDISJOINTWITH_K() throws RecognitionException {
        try {
            int _type = DISJOINTWITH_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:141:16: ( 'DisjointWith' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:141:18: 'DisjointWith'
            {
            match("DisjointWith"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISJOINTWITH_K"

    // $ANTLR start "DISJOINTUNIONOF_K"
    public final void mDISJOINTUNIONOF_K() throws RecognitionException {
        try {
            int _type = DISJOINTUNIONOF_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:143:19: ( 'DisjointUnionOf' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:143:21: 'DisjointUnionOf'
            {
            match("DisjointUnionOf"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISJOINTUNIONOF_K"

    // $ANTLR start "DOMAIN_K"
    public final void mDOMAIN_K() throws RecognitionException {
        try {
            int _type = DOMAIN_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:145:10: ( 'Domain' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:145:12: 'Domain'
            {
            match("Domain"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOMAIN_K"

    // $ANTLR start "EQUIVALENTCLASSES_K"
    public final void mEQUIVALENTCLASSES_K() throws RecognitionException {
        try {
            int _type = EQUIVALENTCLASSES_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:147:21: ( 'EquivalentClasses' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:147:23: 'EquivalentClasses'
            {
            match("EquivalentClasses"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUIVALENTCLASSES_K"

    // $ANTLR start "EQUIVALENTPROPERTIES_K"
    public final void mEQUIVALENTPROPERTIES_K() throws RecognitionException {
        try {
            int _type = EQUIVALENTPROPERTIES_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:149:24: ( 'EquivalentProperties' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:149:26: 'EquivalentProperties'
            {
            match("EquivalentProperties"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUIVALENTPROPERTIES_K"

    // $ANTLR start "EQUIVALENTTO_K"
    public final void mEQUIVALENTTO_K() throws RecognitionException {
        try {
            int _type = EQUIVALENTTO_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:151:16: ( 'EquivalentTo' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:151:18: 'EquivalentTo'
            {
            match("EquivalentTo"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUIVALENTTO_K"

    // $ANTLR start "EXACTLY_K"
    public final void mEXACTLY_K() throws RecognitionException {
        try {
            int _type = EXACTLY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:153:11: ( 'exactly' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:153:13: 'exactly'
            {
            match("exactly"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXACTLY_K"

    // $ANTLR start "FACTS_K"
    public final void mFACTS_K() throws RecognitionException {
        try {
            int _type = FACTS_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:155:9: ( 'Facts' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:155:11: 'Facts'
            {
            match("Facts"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FACTS_K"

    // $ANTLR start "FLOAT_K"
    public final void mFLOAT_K() throws RecognitionException {
        try {
            int _type = FLOAT_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:157:9: ( 'float' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:157:11: 'float'
            {
            match("float"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT_K"

    // $ANTLR start "FUNCTIONAL_K"
    public final void mFUNCTIONAL_K() throws RecognitionException {
        try {
            int _type = FUNCTIONAL_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:159:14: ( 'Functional' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:159:16: 'Functional'
            {
            match("Functional"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTIONAL_K"

    // $ANTLR start "HASKEY_K"
    public final void mHASKEY_K() throws RecognitionException {
        try {
            int _type = HASKEY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:161:10: ( 'HasKey' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:161:12: 'HasKey'
            {
            match("HasKey"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HASKEY_K"

    // $ANTLR start "IMPORT_K"
    public final void mIMPORT_K() throws RecognitionException {
        try {
            int _type = IMPORT_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:163:10: ( 'Import' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:163:12: 'Import'
            {
            match("Import"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPORT_K"

    // $ANTLR start "INDIVIDUAL_K"
    public final void mINDIVIDUAL_K() throws RecognitionException {
        try {
            int _type = INDIVIDUAL_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:165:14: ( 'Individual' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:165:16: 'Individual'
            {
            match("Individual"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INDIVIDUAL_K"

    // $ANTLR start "INVERSE_K"
    public final void mINVERSE_K() throws RecognitionException {
        try {
            int _type = INVERSE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:167:11: ( 'inverse' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:167:13: 'inverse'
            {
            match("inverse"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INVERSE_K"

    // $ANTLR start "INVERSEFUNCTIONAL_K"
    public final void mINVERSEFUNCTIONAL_K() throws RecognitionException {
        try {
            int _type = INVERSEFUNCTIONAL_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:169:21: ( 'InverseFunctional' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:169:23: 'InverseFunctional'
            {
            match("InverseFunctional"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INVERSEFUNCTIONAL_K"

    // $ANTLR start "INVERSEOF_K"
    public final void mINVERSEOF_K() throws RecognitionException {
        try {
            int _type = INVERSEOF_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:171:13: ( 'InverseOf' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:171:15: 'InverseOf'
            {
            match("InverseOf"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INVERSEOF_K"

    // $ANTLR start "INTEGER_K"
    public final void mINTEGER_K() throws RecognitionException {
        try {
            int _type = INTEGER_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:173:11: ( 'integer' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:173:13: 'integer'
            {
            match("integer"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_K"

    // $ANTLR start "IRREFLEXIVE_K"
    public final void mIRREFLEXIVE_K() throws RecognitionException {
        try {
            int _type = IRREFLEXIVE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:175:15: ( 'Irreflexive' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:175:17: 'Irreflexive'
            {
            match("Irreflexive"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IRREFLEXIVE_K"

    // $ANTLR start "LANGPATTERN_K"
    public final void mLANGPATTERN_K() throws RecognitionException {
        try {
            int _type = LANGPATTERN_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:177:15: ( 'langPattern' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:177:17: 'langPattern'
            {
            match("langPattern"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LANGPATTERN_K"

    // $ANTLR start "LENGTH_K"
    public final void mLENGTH_K() throws RecognitionException {
        try {
            int _type = LENGTH_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:179:10: ( 'length' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:179:12: 'length'
            {
            match("length"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LENGTH_K"

    // $ANTLR start "MAX_K"
    public final void mMAX_K() throws RecognitionException {
        try {
            int _type = MAX_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:181:7: ( 'max' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:181:9: 'max'
            {
            match("max"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAX_K"

    // $ANTLR start "MAXLENGTH_K"
    public final void mMAXLENGTH_K() throws RecognitionException {
        try {
            int _type = MAXLENGTH_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:183:13: ( 'maxLength' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:183:15: 'maxLength'
            {
            match("maxLength"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAXLENGTH_K"

    // $ANTLR start "MIN_K"
    public final void mMIN_K() throws RecognitionException {
        try {
            int _type = MIN_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:185:7: ( 'min' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:185:9: 'min'
            {
            match("min"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIN_K"

    // $ANTLR start "MINLENGTH_K"
    public final void mMINLENGTH_K() throws RecognitionException {
        try {
            int _type = MINLENGTH_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:187:13: ( 'minLength' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:187:15: 'minLength'
            {
            match("minLength"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINLENGTH_K"

    // $ANTLR start "NAMEDINDIVIDUAL_K"
    public final void mNAMEDINDIVIDUAL_K() throws RecognitionException {
        try {
            int _type = NAMEDINDIVIDUAL_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:189:19: ( 'NamedIndividual' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:189:21: 'NamedIndividual'
            {
            match("NamedIndividual"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAMEDINDIVIDUAL_K"

    // $ANTLR start "NAMESPACE_K"
    public final void mNAMESPACE_K() throws RecognitionException {
        try {
            int _type = NAMESPACE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:192:13: ( 'Namespace' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:192:15: 'Namespace'
            {
            match("Namespace"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAMESPACE_K"

    // $ANTLR start "NOT_K"
    public final void mNOT_K() throws RecognitionException {
        try {
            int _type = NOT_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:194:7: ( 'not' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:194:9: 'not'
            {
            match("not"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_K"

    // $ANTLR start "OBJECTPROPERTY_K"
    public final void mOBJECTPROPERTY_K() throws RecognitionException {
        try {
            int _type = OBJECTPROPERTY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:196:18: ( 'ObjectProperty' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:196:20: 'ObjectProperty'
            {
            match("ObjectProperty"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OBJECTPROPERTY_K"

    // $ANTLR start "ONLY_K"
    public final void mONLY_K() throws RecognitionException {
        try {
            int _type = ONLY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:198:8: ( 'only' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:198:10: 'only'
            {
            match("only"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ONLY_K"

    // $ANTLR start "ONTOLOGY_K"
    public final void mONTOLOGY_K() throws RecognitionException {
        try {
            int _type = ONTOLOGY_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:200:12: ( 'Ontology' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:200:14: 'Ontology'
            {
            match("Ontology"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ONTOLOGY_K"

    // $ANTLR start "OR_K"
    public final void mOR_K() throws RecognitionException {
        try {
            int _type = OR_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:202:6: ( 'or' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:202:8: 'or'
            {
            match("or"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR_K"

    // $ANTLR start "PATTERN_K"
    public final void mPATTERN_K() throws RecognitionException {
        try {
            int _type = PATTERN_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:204:11: ( 'pattern' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:204:13: 'pattern'
            {
            match("pattern"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATTERN_K"

    // $ANTLR start "PREFIX_K"
    public final void mPREFIX_K() throws RecognitionException {
        try {
            int _type = PREFIX_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:206:10: ( 'Prefix' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:206:12: 'Prefix'
            {
            match("Prefix"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PREFIX_K"

    // $ANTLR start "RANGE_K"
    public final void mRANGE_K() throws RecognitionException {
        try {
            int _type = RANGE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:208:9: ( 'Range' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:208:11: 'Range'
            {
            match("Range"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE_K"

    // $ANTLR start "REFLEXIVE_K"
    public final void mREFLEXIVE_K() throws RecognitionException {
        try {
            int _type = REFLEXIVE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:210:13: ( 'Reflexive' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:210:15: 'Reflexive'
            {
            match("Reflexive"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REFLEXIVE_K"

    // $ANTLR start "SAMEAS_K"
    public final void mSAMEAS_K() throws RecognitionException {
        try {
            int _type = SAMEAS_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:212:10: ( 'SameAs' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:212:12: 'SameAs'
            {
            match("SameAs"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SAMEAS_K"

    // $ANTLR start "SAMEINDIVIDUAL_K"
    public final void mSAMEINDIVIDUAL_K() throws RecognitionException {
        try {
            int _type = SAMEINDIVIDUAL_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:214:18: ( 'SameIndividual' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:214:20: 'SameIndividual'
            {
            match("SameIndividual"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SAMEINDIVIDUAL_K"

    // $ANTLR start "SELF_K"
    public final void mSELF_K() throws RecognitionException {
        try {
            int _type = SELF_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:216:8: ( 'Self' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:216:10: 'Self'
            {
            match("Self"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELF_K"

    // $ANTLR start "SOME_K"
    public final void mSOME_K() throws RecognitionException {
        try {
            int _type = SOME_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:218:8: ( 'some' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:218:10: 'some'
            {
            match("some"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOME_K"

    // $ANTLR start "STRING_K"
    public final void mSTRING_K() throws RecognitionException {
        try {
            int _type = STRING_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:220:10: ( 'string' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:220:12: 'string'
            {
            match("string"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_K"

    // $ANTLR start "SUBCLASSOF_K"
    public final void mSUBCLASSOF_K() throws RecognitionException {
        try {
            int _type = SUBCLASSOF_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:222:14: ( 'SubClassOf' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:222:16: 'SubClassOf'
            {
            match("SubClassOf"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBCLASSOF_K"

    // $ANTLR start "SUBPROPERTYOF_K"
    public final void mSUBPROPERTYOF_K() throws RecognitionException {
        try {
            int _type = SUBPROPERTYOF_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:224:17: ( 'SubPropertyOf' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:224:19: 'SubPropertyOf'
            {
            match("SubPropertyOf"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBPROPERTYOF_K"

    // $ANTLR start "SUBPROPERTYCHAIN_K"
    public final void mSUBPROPERTYCHAIN_K() throws RecognitionException {
        try {
            int _type = SUBPROPERTYCHAIN_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:226:20: ( 'SubPropertyChain' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:226:22: 'SubPropertyChain'
            {
            match("SubPropertyChain"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBPROPERTYCHAIN_K"

    // $ANTLR start "SYMMETRIC_K"
    public final void mSYMMETRIC_K() throws RecognitionException {
        try {
            int _type = SYMMETRIC_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:228:13: ( 'Symmetric' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:228:15: 'Symmetric'
            {
            match("Symmetric"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYMMETRIC_K"

    // $ANTLR start "THAT_K"
    public final void mTHAT_K() throws RecognitionException {
        try {
            int _type = THAT_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:230:8: ( 'that' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:230:10: 'that'
            {
            match("that"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THAT_K"

    // $ANTLR start "TRANSITIVE_K"
    public final void mTRANSITIVE_K() throws RecognitionException {
        try {
            int _type = TRANSITIVE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:232:14: ( 'Transitive' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:232:16: 'Transitive'
            {
            match("Transitive"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRANSITIVE_K"

    // $ANTLR start "TYPES_K"
    public final void mTYPES_K() throws RecognitionException {
        try {
            int _type = TYPES_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:234:9: ( 'Types' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:234:11: 'Types'
            {
            match("Types"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPES_K"

    // $ANTLR start "VALUE_K"
    public final void mVALUE_K() throws RecognitionException {
        try {
            int _type = VALUE_K;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:236:9: ( 'value' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:236:11: 'value'
            {
            match("value"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUE_K"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:242:9: ( '>' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:242:11: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "GEQ"
    public final void mGEQ() throws RecognitionException {
        try {
            int _type = GEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:244:5: ( '>=' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:244:7: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GEQ"

    // $ANTLR start "LEQ"
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:246:5: ( '<=' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:246:7: '<='
            {
            match("<="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEQ"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:248:6: ( '<' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:248:8: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "CHAIN"
    public final void mCHAIN() throws RecognitionException {
        try {
            int _type = CHAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:250:7: ( 'o' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:250:9: 'o'
            {
            match('o'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAIN"

    // $ANTLR start "DBL_CAP"
    public final void mDBL_CAP() throws RecognitionException {
        try {
            int _type = DBL_CAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:252:9: ( '^^' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:252:11: '^^'
            {
            match("^^"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DBL_CAP"

    // $ANTLR start "BLANK"
    public final void mBLANK() throws RecognitionException {
        try {
            int _type = BLANK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:254:7: ( '_:' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:254:9: '_:'
            {
            match("_:"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BLANK"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:256:12: ( '_' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:256:14: '_'
            {
            match('_'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:258:7: ( ':' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:258:9: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:260:7: ( ',' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:260:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:262:7: ( '/' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:262:9: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "LEFT_SQUARE"
    public final void mLEFT_SQUARE() throws RecognitionException {
        try {
            int _type = LEFT_SQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:267:13: ( '[' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:267:15: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_SQUARE"

    // $ANTLR start "RIGHT_SQUARE"
    public final void mRIGHT_SQUARE() throws RecognitionException {
        try {
            int _type = RIGHT_SQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:269:14: ( ']' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:269:16: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_SQUARE"

    // $ANTLR start "LEFT_PAREN"
    public final void mLEFT_PAREN() throws RecognitionException {
        try {
            int _type = LEFT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:271:12: ( '(' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:271:14: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_PAREN"

    // $ANTLR start "RIGHT_PAREN"
    public final void mRIGHT_PAREN() throws RecognitionException {
        try {
            int _type = RIGHT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:273:13: ( ')' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:273:15: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_PAREN"

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:275:12: ( '{' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:275:14: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_CURLY"

    // $ANTLR start "RIGHT_CURLY"
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:277:13: ( '}' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:277:15: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_CURLY"

    // $ANTLR start "IntegerLiteral"
    public final void mIntegerLiteral() throws RecognitionException {
        try {
            int _type = IntegerLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:283:16: ( ( '+' | '-' )? Digits )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:283:18: ( '+' | '-' )? Digits
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:283:18: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mDigits(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IntegerLiteral"

    // $ANTLR start "DecimalLiteral"
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:284:16: ( ( '+' | '-' )? Digits '.' Digits )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:284:18: ( '+' | '-' )? Digits '.' Digits
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:284:18: ( '+' | '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mDigits(); if (state.failed) return ;
            match('.'); if (state.failed) return ;
            mDigits(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DecimalLiteral"

    // $ANTLR start "FloatingPointLiteral"
    public final void mFloatingPointLiteral() throws RecognitionException {
        try {
            int _type = FloatingPointLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:285:22: ( ( '+' | '-' )? ( Digits ( '.' Digits )? Exponent | '.' Digits Exponent ) ( 'f' | 'F' ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:286:3: ( '+' | '-' )? ( Digits ( '.' Digits )? Exponent | '.' Digits Exponent ) ( 'f' | 'F' )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:286:3: ( '+' | '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+'||LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:287:3: ( Digits ( '.' Digits )? Exponent | '.' Digits Exponent )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='.') ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:287:7: Digits ( '.' Digits )? Exponent
                    {
                    mDigits(); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:287:14: ( '.' Digits )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='.') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:287:15: '.' Digits
                            {
                            match('.'); if (state.failed) return ;
                            mDigits(); if (state.failed) return ;

                            }
                            break;

                    }

                    mExponent(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:288:9: '.' Digits Exponent
                    {
                    match('.'); if (state.failed) return ;
                    mDigits(); if (state.failed) return ;
                    mExponent(); if (state.failed) return ;

                    }
                    break;

            }

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointLiteral"

    // $ANTLR start "QuotedString"
    public final void mQuotedString() throws RecognitionException {
        try {
            int _type = QuotedString;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:3: ( ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )+ '\"' ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:7: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )+ '\"' )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:7: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )+ '\"' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )+ '\"'
            {
            match('\"'); if (state.failed) return ;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:14: EscapeSequence
            	    {
            	    mEscapeSequence(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:293:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            match('\"'); if (state.failed) return ;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuotedString"

    // $ANTLR start "LanguageTag"
    public final void mLanguageTag() throws RecognitionException {
        try {
            int _type = LanguageTag;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:295:13: ( '@' ( ALPHA ALPHA ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:295:15: '@' ( ALPHA ALPHA )
            {
            match('@'); if (state.failed) return ;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:295:19: ( ALPHA ALPHA )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:295:20: ALPHA ALPHA
            {
            mALPHA(); if (state.failed) return ;
            mALPHA(); if (state.failed) return ;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LanguageTag"

    // $ANTLR start "PN_ID"
    public final void mPN_ID() throws RecognitionException {
        try {
            int _type = PN_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:302:2: ( PN_CHARS_BASE ( PN_INNER )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:302:4: PN_CHARS_BASE ( PN_INNER )?
            {
            mPN_CHARS_BASE(); if (state.failed) return ;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:302:18: ( PN_INNER )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='-' && LA7_0<='.')||(LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||LA7_0=='\u00B7'||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u037D')||(LA7_0>='\u037F' && LA7_0<='\u1FFF')||(LA7_0>='\u200C' && LA7_0<='\u200D')||(LA7_0>='\u203F' && LA7_0<='\u2040')||(LA7_0>='\u2070' && LA7_0<='\u218F')||(LA7_0>='\u2C00' && LA7_0<='\u2FEF')||(LA7_0>='\u3001' && LA7_0<='\uD7FF')||(LA7_0>='\uF900' && LA7_0<='\uFDCF')||(LA7_0>='\uFDF0' && LA7_0<='\uFFFD')) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:302:18: PN_INNER
                    {
                    mPN_INNER(); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PN_ID"

    // $ANTLR start "PN_NUMID"
    public final void mPN_NUMID() throws RecognitionException {
        try {
            int _type = PN_NUMID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:306:2: ( DIGIT ( PN_INNER )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:306:4: DIGIT ( PN_INNER )?
            {
            mDIGIT(); if (state.failed) return ;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:306:10: ( PN_INNER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>='-' && LA8_0<='.')||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')||LA8_0=='\u00B7'||(LA8_0>='\u00C0' && LA8_0<='\u00D6')||(LA8_0>='\u00D8' && LA8_0<='\u00F6')||(LA8_0>='\u00F8' && LA8_0<='\u037D')||(LA8_0>='\u037F' && LA8_0<='\u1FFF')||(LA8_0>='\u200C' && LA8_0<='\u200D')||(LA8_0>='\u203F' && LA8_0<='\u2040')||(LA8_0>='\u2070' && LA8_0<='\u218F')||(LA8_0>='\u2C00' && LA8_0<='\u2FEF')||(LA8_0>='\u3001' && LA8_0<='\uD7FF')||(LA8_0>='\uF900' && LA8_0<='\uFDCF')||(LA8_0>='\uFDF0' && LA8_0<='\uFFFD')) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:306:10: PN_INNER
                    {
                    mPN_INNER(); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PN_NUMID"

    // $ANTLR start "PN_UNDSCID"
    public final void mPN_UNDSCID() throws RecognitionException {
        try {
            int _type = PN_UNDSCID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:310:2: ( '_' ( PN_INNER )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:310:4: '_' ( PN_INNER )?
            {
            match('_'); if (state.failed) return ;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:310:8: ( PN_INNER )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='-' && LA9_0<='.')||(LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')||LA9_0=='\u00B7'||(LA9_0>='\u00C0' && LA9_0<='\u00D6')||(LA9_0>='\u00D8' && LA9_0<='\u00F6')||(LA9_0>='\u00F8' && LA9_0<='\u037D')||(LA9_0>='\u037F' && LA9_0<='\u1FFF')||(LA9_0>='\u200C' && LA9_0<='\u200D')||(LA9_0>='\u203F' && LA9_0<='\u2040')||(LA9_0>='\u2070' && LA9_0<='\u218F')||(LA9_0>='\u2C00' && LA9_0<='\u2FEF')||(LA9_0>='\u3001' && LA9_0<='\uD7FF')||(LA9_0>='\uF900' && LA9_0<='\uFDCF')||(LA9_0>='\uFDF0' && LA9_0<='\uFFFD')) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:310:8: PN_INNER
                    {
                    mPN_INNER(); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PN_UNDSCID"

    // $ANTLR start "OTHER_CHARS"
    public final void mOTHER_CHARS() throws RecognitionException {
        try {
            int _type = OTHER_CHARS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:314:5: ( '#' | '+' | '-' | '?' | '^' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
            {
            if ( input.LA(1)=='#'||input.LA(1)=='+'||input.LA(1)=='-'||input.LA(1)=='?'||input.LA(1)=='^' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OTHER_CHARS"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:318:3: ( ( ' ' | '\\t' | '\\f' | EOL )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:319:3: ( ' ' | '\\t' | '\\f' | EOL )+
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:319:3: ( ' ' | '\\t' | '\\f' | EOL )+
            int cnt10=0;
            loop10:
            do {
                int alt10=5;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt10=1;
                    }
                    break;
                case '\t':
                    {
                    alt10=2;
                    }
                    break;
                case '\f':
                    {
                    alt10=3;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt10=4;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:319:5: ' '
            	    {
            	    match(' '); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:320:5: '\\t'
            	    {
            	    match('\t'); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:321:5: '\\f'
            	    {
            	    match('\f'); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:322:5: EOL
            	    {
            	    mEOL(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            if ( state.backtracking==0 ) {
               _channel=HIDDEN; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:7: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='a' && LA11_0<='z')) ) {
                alt11=1;
            }
            else if ( ((LA11_0>='A' && LA11_0<='Z')) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:9: ( 'a' .. 'z' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:9: ( 'a' .. 'z' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:10: 'a' .. 'z'
                    {
                    matchRange('a','z'); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:22: ( 'A' .. 'Z' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:22: ( 'A' .. 'Z' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:343:23: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:346:7: ( ZERO | NONZERO )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "NONZERO"
    public final void mNONZERO() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:349:9: ( '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
            {
            if ( (input.LA(1)>='1' && input.LA(1)<='9') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NONZERO"

    // $ANTLR start "HEXDIGIT"
    public final void mHEXDIGIT() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:10: ( DIGIT | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt12=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                {
                alt12=2;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:12: DIGIT
                    {
                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:20: ( 'a' .. 'f' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:20: ( 'a' .. 'f' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:21: 'a' .. 'f'
                    {
                    matchRange('a','f'); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:33: ( 'A' .. 'F' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:33: ( 'A' .. 'F' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:352:34: 'A' .. 'F'
                    {
                    matchRange('A','F'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "HEXDIGIT"

    // $ANTLR start "ZERO"
    public final void mZERO() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:355:6: ( '0' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:355:8: '0'
            {
            match('0'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "ZERO"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:358:10: ( ( 'e' | 'E' ) ( '+' | '-' )? Digits )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:358:12: ( 'e' | 'E' ) ( '+' | '-' )? Digits
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:358:24: ( '+' | '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='+'||LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mDigits(); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "Digits"
    public final void mDigits() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:361:8: ( ( DIGIT )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:361:10: ( DIGIT )+
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:361:10: ( DIGIT )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:361:10: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Digits"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:365:5: ( '\\\\' ( 'b' | 'B' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '.' | 'o' | 'x' | 'a' | 'e' | 'c' | 'd' | 'D' | 's' | 'S' | 'w' | 'W' | 'p' | 'A' | 'G' | 'Z' | 'z' | 'Q' | 'E' | '*' | '[' | ']' | '(' | ')' | '$' | '^' | '{' | '}' | '?' | '+' | '-' | '&' | '|' ) | UnicodeEscape | OctalEscape )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '$':
                case '&':
                case '\'':
                case '(':
                case ')':
                case '*':
                case '+':
                case '-':
                case '.':
                case '?':
                case 'A':
                case 'B':
                case 'D':
                case 'E':
                case 'G':
                case 'Q':
                case 'S':
                case 'W':
                case 'Z':
                case '[':
                case '\\':
                case ']':
                case '^':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'n':
                case 'o':
                case 'p':
                case 'r':
                case 's':
                case 't':
                case 'w':
                case 'x':
                case 'z':
                case '{':
                case '|':
                case '}':
                    {
                    alt15=1;
                    }
                    break;
                case 'u':
                    {
                    alt15=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt15=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:365:9: '\\\\' ( 'b' | 'B' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '.' | 'o' | 'x' | 'a' | 'e' | 'c' | 'd' | 'D' | 's' | 'S' | 'w' | 'W' | 'p' | 'A' | 'G' | 'Z' | 'z' | 'Q' | 'E' | '*' | '[' | ']' | '(' | ')' | '$' | '^' | '{' | '}' | '?' | '+' | '-' | '&' | '|' )
                    {
                    match('\\'); if (state.failed) return ;
                    if ( input.LA(1)=='\"'||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='.')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='B')||(input.LA(1)>='D' && input.LA(1)<='E')||input.LA(1)=='G'||input.LA(1)=='Q'||input.LA(1)=='S'||input.LA(1)=='W'||(input.LA(1)>='Z' && input.LA(1)<='^')||(input.LA(1)>='a' && input.LA(1)<='f')||(input.LA(1)>='n' && input.LA(1)<='p')||(input.LA(1)>='r' && input.LA(1)<='t')||(input.LA(1)>='w' && input.LA(1)<='x')||(input.LA(1)>='z' && input.LA(1)<='}') ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:369:9: UnicodeEscape
                    {
                    mUnicodeEscape(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:370:9: OctalEscape
                    {
                    mOctalEscape(); if (state.failed) return ;

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                int LA16_1 = input.LA(2);

                if ( ((LA16_1>='0' && LA16_1<='3')) ) {
                    int LA16_2 = input.LA(3);

                    if ( ((LA16_2>='0' && LA16_2<='7')) ) {
                        int LA16_5 = input.LA(4);

                        if ( ((LA16_5>='0' && LA16_5<='7')) ) {
                            alt16=1;
                        }
                        else {
                            alt16=2;}
                    }
                    else {
                        alt16=3;}
                }
                else if ( ((LA16_1>='4' && LA16_1<='7')) ) {
                    int LA16_3 = input.LA(3);

                    if ( ((LA16_3>='0' && LA16_3<='7')) ) {
                        alt16=2;
                    }
                    else {
                        alt16=3;}
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:14: ( '0' .. '3' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:15: '0' .. '3'
                    {
                    matchRange('0','3'); if (state.failed) return ;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:25: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:26: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:36: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:375:37: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:376:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:376:14: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:376:15: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:376:25: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:376:26: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:377:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:377:14: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:377:15: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:382:5: ( '\\\\' 'u' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:382:9: '\\\\' 'u' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT
            {
            match('\\'); if (state.failed) return ;
            match('u'); if (state.failed) return ;
            mHEXDIGIT(); if (state.failed) return ;
            mHEXDIGIT(); if (state.failed) return ;
            mHEXDIGIT(); if (state.failed) return ;
            mHEXDIGIT(); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:387:3: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:388:3: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:388:3: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\r') ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1=='\n') && (synpred1_ManchesterLexer())) {
                    alt17=1;
                }
                else {
                    alt17=2;}
            }
            else if ( (LA17_0=='\n') ) {
                alt17=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:388:5: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:389:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:390:5: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "EOL"

    // $ANTLR start "PN_INNER"
    public final void mPN_INNER() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:397:3: ( ( PN_CHARS | '.' )* PN_CHARS )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:397:5: ( PN_CHARS | '.' )* PN_CHARS
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:397:5: ( PN_CHARS | '.' )*
            loop18:
            do {
                int alt18=3;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:397:6: PN_CHARS
            	    {
            	    mPN_CHARS(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:397:17: '.'
            	    {
            	    match('.'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            mPN_CHARS(); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "PN_INNER"

    // $ANTLR start "PN_CHARS"
    public final void mPN_CHARS() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:403:5: ( PN_CHARS_BASE | '_' | '-' | DIGIT | '\\u00B7' | ( '\\u0300' .. '\\u036F' ) | ( '\\u203F' .. '\\u2040' ) )
            int alt19=7;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>='A' && LA19_0<='Z')||(LA19_0>='a' && LA19_0<='z')||(LA19_0>='\u00C0' && LA19_0<='\u00D6')||(LA19_0>='\u00D8' && LA19_0<='\u00F6')||(LA19_0>='\u00F8' && LA19_0<='\u02FF')||(LA19_0>='\u0370' && LA19_0<='\u037D')||(LA19_0>='\u037F' && LA19_0<='\u1FFF')||(LA19_0>='\u200C' && LA19_0<='\u200D')||(LA19_0>='\u2070' && LA19_0<='\u218F')||(LA19_0>='\u2C00' && LA19_0<='\u2FEF')||(LA19_0>='\u3001' && LA19_0<='\uD7FF')||(LA19_0>='\uF900' && LA19_0<='\uFDCF')||(LA19_0>='\uFDF0' && LA19_0<='\uFFFD')) ) {
                alt19=1;
            }
            else if ( (LA19_0=='_') ) {
                alt19=2;
            }
            else if ( (LA19_0=='-') ) {
                alt19=3;
            }
            else if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                alt19=4;
            }
            else if ( (LA19_0=='\u00B7') ) {
                alt19=5;
            }
            else if ( ((LA19_0>='\u0300' && LA19_0<='\u036F')) ) {
                alt19=6;
            }
            else if ( ((LA19_0>='\u203F' && LA19_0<='\u2040')) ) {
                alt19=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:403:7: PN_CHARS_BASE
                    {
                    mPN_CHARS_BASE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:404:7: '_'
                    {
                    match('_'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:405:7: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:406:7: DIGIT
                    {
                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:407:7: '\\u00B7'
                    {
                    match('\u00B7'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:408:7: ( '\\u0300' .. '\\u036F' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:408:7: ( '\\u0300' .. '\\u036F' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:408:8: '\\u0300' .. '\\u036F'
                    {
                    matchRange('\u0300','\u036F'); if (state.failed) return ;

                    }


                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:409:7: ( '\\u203F' .. '\\u2040' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:409:7: ( '\\u203F' .. '\\u2040' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:409:8: '\\u203F' .. '\\u2040'
                    {
                    matchRange('\u203F','\u2040'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PN_CHARS"

    // $ANTLR start "PN_CHARS_BASE"
    public final void mPN_CHARS_BASE() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:414:5: ( ALPHA | ( '\\u00C0' .. '\\u00D6' ) | ( '\\u00D8' .. '\\u00F6' ) | ( '\\u00F8' .. '\\u02FF' ) | ( '\\u0370' .. '\\u037D' ) | ( '\\u037F' .. '\\u1FFF' ) | ( '\\u200C' .. '\\u200D' ) | ( '\\u2070' .. '\\u218F' ) | ( '\\u2C00' .. '\\u2FEF' ) | ( '\\u3001' .. '\\uD7FF' ) | ( '\\uF900' .. '\\uFDCF' ) | ( '\\uFDF0' .. '\\uFFFD' ) )
            int alt20=12;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>='A' && LA20_0<='Z')||(LA20_0>='a' && LA20_0<='z')) ) {
                alt20=1;
            }
            else if ( ((LA20_0>='\u00C0' && LA20_0<='\u00D6')) ) {
                alt20=2;
            }
            else if ( ((LA20_0>='\u00D8' && LA20_0<='\u00F6')) ) {
                alt20=3;
            }
            else if ( ((LA20_0>='\u00F8' && LA20_0<='\u02FF')) ) {
                alt20=4;
            }
            else if ( ((LA20_0>='\u0370' && LA20_0<='\u037D')) ) {
                alt20=5;
            }
            else if ( ((LA20_0>='\u037F' && LA20_0<='\u1FFF')) ) {
                alt20=6;
            }
            else if ( ((LA20_0>='\u200C' && LA20_0<='\u200D')) ) {
                alt20=7;
            }
            else if ( ((LA20_0>='\u2070' && LA20_0<='\u218F')) ) {
                alt20=8;
            }
            else if ( ((LA20_0>='\u2C00' && LA20_0<='\u2FEF')) ) {
                alt20=9;
            }
            else if ( ((LA20_0>='\u3001' && LA20_0<='\uD7FF')) ) {
                alt20=10;
            }
            else if ( ((LA20_0>='\uF900' && LA20_0<='\uFDCF')) ) {
                alt20=11;
            }
            else if ( ((LA20_0>='\uFDF0' && LA20_0<='\uFFFD')) ) {
                alt20=12;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:414:7: ALPHA
                    {
                    mALPHA(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:415:7: ( '\\u00C0' .. '\\u00D6' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:415:7: ( '\\u00C0' .. '\\u00D6' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:415:8: '\\u00C0' .. '\\u00D6'
                    {
                    matchRange('\u00C0','\u00D6'); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:416:7: ( '\\u00D8' .. '\\u00F6' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:416:7: ( '\\u00D8' .. '\\u00F6' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:416:8: '\\u00D8' .. '\\u00F6'
                    {
                    matchRange('\u00D8','\u00F6'); if (state.failed) return ;

                    }


                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:417:7: ( '\\u00F8' .. '\\u02FF' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:417:7: ( '\\u00F8' .. '\\u02FF' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:417:8: '\\u00F8' .. '\\u02FF'
                    {
                    matchRange('\u00F8','\u02FF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:418:7: ( '\\u0370' .. '\\u037D' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:418:7: ( '\\u0370' .. '\\u037D' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:418:8: '\\u0370' .. '\\u037D'
                    {
                    matchRange('\u0370','\u037D'); if (state.failed) return ;

                    }


                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:419:7: ( '\\u037F' .. '\\u1FFF' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:419:7: ( '\\u037F' .. '\\u1FFF' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:419:8: '\\u037F' .. '\\u1FFF'
                    {
                    matchRange('\u037F','\u1FFF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:420:7: ( '\\u200C' .. '\\u200D' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:420:7: ( '\\u200C' .. '\\u200D' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:420:8: '\\u200C' .. '\\u200D'
                    {
                    matchRange('\u200C','\u200D'); if (state.failed) return ;

                    }


                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:421:7: ( '\\u2070' .. '\\u218F' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:421:7: ( '\\u2070' .. '\\u218F' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:421:8: '\\u2070' .. '\\u218F'
                    {
                    matchRange('\u2070','\u218F'); if (state.failed) return ;

                    }


                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:422:7: ( '\\u2C00' .. '\\u2FEF' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:422:7: ( '\\u2C00' .. '\\u2FEF' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:422:8: '\\u2C00' .. '\\u2FEF'
                    {
                    matchRange('\u2C00','\u2FEF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 10 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:423:7: ( '\\u3001' .. '\\uD7FF' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:423:7: ( '\\u3001' .. '\\uD7FF' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:423:8: '\\u3001' .. '\\uD7FF'
                    {
                    matchRange('\u3001','\uD7FF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 11 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:424:7: ( '\\uF900' .. '\\uFDCF' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:424:7: ( '\\uF900' .. '\\uFDCF' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:424:8: '\\uF900' .. '\\uFDCF'
                    {
                    matchRange('\uF900','\uFDCF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 12 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:425:7: ( '\\uFDF0' .. '\\uFFFD' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:425:7: ( '\\uFDF0' .. '\\uFFFD' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:425:8: '\\uFDF0' .. '\\uFFFD'
                    {
                    matchRange('\uFDF0','\uFFFD'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "PN_CHARS_BASE"

    public void mTokens() throws RecognitionException {
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:8: ( AND_K | ANNOTATIONS_K | ANNOTATIONPROPERTY_K | ASYMMETRIC_K | CHARACTERISTICS_K | CLASS_K | DATAPROPERTY_K | DATATYPE_K | DECIMAL_K | DIFFERENTINDIVIDUALS_K | DISJOINTCLASSES_K | DISJOINTPROPERTIES_K | DIFFERENTFROM_K | DISJOINTWITH_K | DISJOINTUNIONOF_K | DOMAIN_K | EQUIVALENTCLASSES_K | EQUIVALENTPROPERTIES_K | EQUIVALENTTO_K | EXACTLY_K | FACTS_K | FLOAT_K | FUNCTIONAL_K | HASKEY_K | IMPORT_K | INDIVIDUAL_K | INVERSE_K | INVERSEFUNCTIONAL_K | INVERSEOF_K | INTEGER_K | IRREFLEXIVE_K | LANGPATTERN_K | LENGTH_K | MAX_K | MAXLENGTH_K | MIN_K | MINLENGTH_K | NAMEDINDIVIDUAL_K | NAMESPACE_K | NOT_K | OBJECTPROPERTY_K | ONLY_K | ONTOLOGY_K | OR_K | PATTERN_K | PREFIX_K | RANGE_K | REFLEXIVE_K | SAMEAS_K | SAMEINDIVIDUAL_K | SELF_K | SOME_K | STRING_K | SUBCLASSOF_K | SUBPROPERTYOF_K | SUBPROPERTYCHAIN_K | SYMMETRIC_K | THAT_K | TRANSITIVE_K | TYPES_K | VALUE_K | GREATER | GEQ | LEQ | LESS | CHAIN | DBL_CAP | BLANK | UNDERSCORE | COLON | COMMA | SLASH | LEFT_SQUARE | RIGHT_SQUARE | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | IntegerLiteral | DecimalLiteral | FloatingPointLiteral | QuotedString | LanguageTag | PN_ID | PN_NUMID | PN_UNDSCID | OTHER_CHARS | WS )
        int alt21=88;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:10: AND_K
                {
                mAND_K(); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:16: ANNOTATIONS_K
                {
                mANNOTATIONS_K(); if (state.failed) return ;

                }
                break;
            case 3 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:30: ANNOTATIONPROPERTY_K
                {
                mANNOTATIONPROPERTY_K(); if (state.failed) return ;

                }
                break;
            case 4 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:51: ASYMMETRIC_K
                {
                mASYMMETRIC_K(); if (state.failed) return ;

                }
                break;
            case 5 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:64: CHARACTERISTICS_K
                {
                mCHARACTERISTICS_K(); if (state.failed) return ;

                }
                break;
            case 6 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:82: CLASS_K
                {
                mCLASS_K(); if (state.failed) return ;

                }
                break;
            case 7 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:90: DATAPROPERTY_K
                {
                mDATAPROPERTY_K(); if (state.failed) return ;

                }
                break;
            case 8 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:105: DATATYPE_K
                {
                mDATATYPE_K(); if (state.failed) return ;

                }
                break;
            case 9 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:116: DECIMAL_K
                {
                mDECIMAL_K(); if (state.failed) return ;

                }
                break;
            case 10 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:126: DIFFERENTINDIVIDUALS_K
                {
                mDIFFERENTINDIVIDUALS_K(); if (state.failed) return ;

                }
                break;
            case 11 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:149: DISJOINTCLASSES_K
                {
                mDISJOINTCLASSES_K(); if (state.failed) return ;

                }
                break;
            case 12 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:167: DISJOINTPROPERTIES_K
                {
                mDISJOINTPROPERTIES_K(); if (state.failed) return ;

                }
                break;
            case 13 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:188: DIFFERENTFROM_K
                {
                mDIFFERENTFROM_K(); if (state.failed) return ;

                }
                break;
            case 14 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:204: DISJOINTWITH_K
                {
                mDISJOINTWITH_K(); if (state.failed) return ;

                }
                break;
            case 15 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:219: DISJOINTUNIONOF_K
                {
                mDISJOINTUNIONOF_K(); if (state.failed) return ;

                }
                break;
            case 16 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:237: DOMAIN_K
                {
                mDOMAIN_K(); if (state.failed) return ;

                }
                break;
            case 17 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:246: EQUIVALENTCLASSES_K
                {
                mEQUIVALENTCLASSES_K(); if (state.failed) return ;

                }
                break;
            case 18 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:266: EQUIVALENTPROPERTIES_K
                {
                mEQUIVALENTPROPERTIES_K(); if (state.failed) return ;

                }
                break;
            case 19 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:289: EQUIVALENTTO_K
                {
                mEQUIVALENTTO_K(); if (state.failed) return ;

                }
                break;
            case 20 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:304: EXACTLY_K
                {
                mEXACTLY_K(); if (state.failed) return ;

                }
                break;
            case 21 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:314: FACTS_K
                {
                mFACTS_K(); if (state.failed) return ;

                }
                break;
            case 22 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:322: FLOAT_K
                {
                mFLOAT_K(); if (state.failed) return ;

                }
                break;
            case 23 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:330: FUNCTIONAL_K
                {
                mFUNCTIONAL_K(); if (state.failed) return ;

                }
                break;
            case 24 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:343: HASKEY_K
                {
                mHASKEY_K(); if (state.failed) return ;

                }
                break;
            case 25 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:352: IMPORT_K
                {
                mIMPORT_K(); if (state.failed) return ;

                }
                break;
            case 26 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:361: INDIVIDUAL_K
                {
                mINDIVIDUAL_K(); if (state.failed) return ;

                }
                break;
            case 27 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:374: INVERSE_K
                {
                mINVERSE_K(); if (state.failed) return ;

                }
                break;
            case 28 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:384: INVERSEFUNCTIONAL_K
                {
                mINVERSEFUNCTIONAL_K(); if (state.failed) return ;

                }
                break;
            case 29 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:404: INVERSEOF_K
                {
                mINVERSEOF_K(); if (state.failed) return ;

                }
                break;
            case 30 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:416: INTEGER_K
                {
                mINTEGER_K(); if (state.failed) return ;

                }
                break;
            case 31 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:426: IRREFLEXIVE_K
                {
                mIRREFLEXIVE_K(); if (state.failed) return ;

                }
                break;
            case 32 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:440: LANGPATTERN_K
                {
                mLANGPATTERN_K(); if (state.failed) return ;

                }
                break;
            case 33 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:454: LENGTH_K
                {
                mLENGTH_K(); if (state.failed) return ;

                }
                break;
            case 34 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:463: MAX_K
                {
                mMAX_K(); if (state.failed) return ;

                }
                break;
            case 35 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:469: MAXLENGTH_K
                {
                mMAXLENGTH_K(); if (state.failed) return ;

                }
                break;
            case 36 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:481: MIN_K
                {
                mMIN_K(); if (state.failed) return ;

                }
                break;
            case 37 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:487: MINLENGTH_K
                {
                mMINLENGTH_K(); if (state.failed) return ;

                }
                break;
            case 38 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:499: NAMEDINDIVIDUAL_K
                {
                mNAMEDINDIVIDUAL_K(); if (state.failed) return ;

                }
                break;
            case 39 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:517: NAMESPACE_K
                {
                mNAMESPACE_K(); if (state.failed) return ;

                }
                break;
            case 40 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:529: NOT_K
                {
                mNOT_K(); if (state.failed) return ;

                }
                break;
            case 41 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:535: OBJECTPROPERTY_K
                {
                mOBJECTPROPERTY_K(); if (state.failed) return ;

                }
                break;
            case 42 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:552: ONLY_K
                {
                mONLY_K(); if (state.failed) return ;

                }
                break;
            case 43 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:559: ONTOLOGY_K
                {
                mONTOLOGY_K(); if (state.failed) return ;

                }
                break;
            case 44 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:570: OR_K
                {
                mOR_K(); if (state.failed) return ;

                }
                break;
            case 45 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:575: PATTERN_K
                {
                mPATTERN_K(); if (state.failed) return ;

                }
                break;
            case 46 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:585: PREFIX_K
                {
                mPREFIX_K(); if (state.failed) return ;

                }
                break;
            case 47 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:594: RANGE_K
                {
                mRANGE_K(); if (state.failed) return ;

                }
                break;
            case 48 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:602: REFLEXIVE_K
                {
                mREFLEXIVE_K(); if (state.failed) return ;

                }
                break;
            case 49 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:614: SAMEAS_K
                {
                mSAMEAS_K(); if (state.failed) return ;

                }
                break;
            case 50 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:623: SAMEINDIVIDUAL_K
                {
                mSAMEINDIVIDUAL_K(); if (state.failed) return ;

                }
                break;
            case 51 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:640: SELF_K
                {
                mSELF_K(); if (state.failed) return ;

                }
                break;
            case 52 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:647: SOME_K
                {
                mSOME_K(); if (state.failed) return ;

                }
                break;
            case 53 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:654: STRING_K
                {
                mSTRING_K(); if (state.failed) return ;

                }
                break;
            case 54 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:663: SUBCLASSOF_K
                {
                mSUBCLASSOF_K(); if (state.failed) return ;

                }
                break;
            case 55 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:676: SUBPROPERTYOF_K
                {
                mSUBPROPERTYOF_K(); if (state.failed) return ;

                }
                break;
            case 56 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:692: SUBPROPERTYCHAIN_K
                {
                mSUBPROPERTYCHAIN_K(); if (state.failed) return ;

                }
                break;
            case 57 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:711: SYMMETRIC_K
                {
                mSYMMETRIC_K(); if (state.failed) return ;

                }
                break;
            case 58 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:723: THAT_K
                {
                mTHAT_K(); if (state.failed) return ;

                }
                break;
            case 59 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:730: TRANSITIVE_K
                {
                mTRANSITIVE_K(); if (state.failed) return ;

                }
                break;
            case 60 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:743: TYPES_K
                {
                mTYPES_K(); if (state.failed) return ;

                }
                break;
            case 61 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:751: VALUE_K
                {
                mVALUE_K(); if (state.failed) return ;

                }
                break;
            case 62 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:759: GREATER
                {
                mGREATER(); if (state.failed) return ;

                }
                break;
            case 63 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:767: GEQ
                {
                mGEQ(); if (state.failed) return ;

                }
                break;
            case 64 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:771: LEQ
                {
                mLEQ(); if (state.failed) return ;

                }
                break;
            case 65 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:775: LESS
                {
                mLESS(); if (state.failed) return ;

                }
                break;
            case 66 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:780: CHAIN
                {
                mCHAIN(); if (state.failed) return ;

                }
                break;
            case 67 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:786: DBL_CAP
                {
                mDBL_CAP(); if (state.failed) return ;

                }
                break;
            case 68 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:794: BLANK
                {
                mBLANK(); if (state.failed) return ;

                }
                break;
            case 69 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:800: UNDERSCORE
                {
                mUNDERSCORE(); if (state.failed) return ;

                }
                break;
            case 70 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:811: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 71 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:817: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 72 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:823: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 73 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:829: LEFT_SQUARE
                {
                mLEFT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 74 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:841: RIGHT_SQUARE
                {
                mRIGHT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 75 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:854: LEFT_PAREN
                {
                mLEFT_PAREN(); if (state.failed) return ;

                }
                break;
            case 76 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:865: RIGHT_PAREN
                {
                mRIGHT_PAREN(); if (state.failed) return ;

                }
                break;
            case 77 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:877: LEFT_CURLY
                {
                mLEFT_CURLY(); if (state.failed) return ;

                }
                break;
            case 78 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:888: RIGHT_CURLY
                {
                mRIGHT_CURLY(); if (state.failed) return ;

                }
                break;
            case 79 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:900: IntegerLiteral
                {
                mIntegerLiteral(); if (state.failed) return ;

                }
                break;
            case 80 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:915: DecimalLiteral
                {
                mDecimalLiteral(); if (state.failed) return ;

                }
                break;
            case 81 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:930: FloatingPointLiteral
                {
                mFloatingPointLiteral(); if (state.failed) return ;

                }
                break;
            case 82 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:951: QuotedString
                {
                mQuotedString(); if (state.failed) return ;

                }
                break;
            case 83 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:964: LanguageTag
                {
                mLanguageTag(); if (state.failed) return ;

                }
                break;
            case 84 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:976: PN_ID
                {
                mPN_ID(); if (state.failed) return ;

                }
                break;
            case 85 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:982: PN_NUMID
                {
                mPN_NUMID(); if (state.failed) return ;

                }
                break;
            case 86 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:991: PN_UNDSCID
                {
                mPN_UNDSCID(); if (state.failed) return ;

                }
                break;
            case 87 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:1002: OTHER_CHARS
                {
                mOTHER_CHARS(); if (state.failed) return ;

                }
                break;
            case 88 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:1:1014: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_ManchesterLexer
    public final void synpred1_ManchesterLexer_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:388:5: ( '\\r\\n' )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/ManchesterLexer.g:388:7: '\\r\\n'
        {
        match("\r\n"); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_ManchesterLexer

    public final boolean synpred1_ManchesterLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ManchesterLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA18_eotS =
        "\1\uffff\23\25\3\uffff";
    static final String DFA18_eofS =
        "\27\uffff";
    static final String DFA18_minS =
        "\24\55\3\uffff";
    static final String DFA18_maxS =
        "\24\ufffd\3\uffff";
    static final String DFA18_acceptS =
        "\24\uffff\1\2\1\3\1\1";
    static final String DFA18_specialS =
        "\27\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\17\1\24\1\uffff\12\20\7\uffff\32\2\4\uffff\1\16\1\uffff\32"+
            "\1\74\uffff\1\21\10\uffff\27\3\1\uffff\37\4\1\uffff\u0208\5"+
            "\160\22\16\6\1\uffff\u1c81\7\14\uffff\2\10\61\uffff\2\23\57"+
            "\uffff\u0120\11\u0a70\uffff\u03f0\12\21\uffff\ua7ff\13\u2100"+
            "\uffff\u04d0\14\40\uffff\u020e\15",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
            "\2\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26"+
            "\74\uffff\1\26\10\uffff\27\26\1\uffff\37\26\1\uffff\u0286\26"+
            "\1\uffff\u1c81\26\14\uffff\2\26\61\uffff\2\26\57\uffff\u0120"+
            "\26\u0a70\uffff\u03f0\26\21\uffff\ua7ff\26\u2100\uffff\u04d0"+
            "\26\40\uffff\u020e\26",
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
            return "()* loopback of 397:5: ( PN_CHARS | '.' )*";
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\21\55\1\115\10\55\1\135\1\137\1\56\1\143\11\uffff\1\56"+
        "\1\145\6\uffff\34\55\1\u008a\1\uffff\16\55\10\uffff\1\145\1\uffff"+
        "\2\150\1\uffff\1\145\1\uffff\1\u009d\27\55\1\u00b6\1\u00b8\1\55"+
        "\1\u00ba\3\55\1\uffff\16\55\1\uffff\2\150\1\u00d0\1\uffff\30\55"+
        "\1\uffff\1\55\1\uffff\1\55\1\uffff\2\55\1\u00ef\5\55\1\u00f6\3\55"+
        "\1\u00fa\1\55\1\u00fc\3\55\1\u00d0\2\52\1\uffff\3\55\1\u0103\10"+
        "\55\1\u010c\1\55\1\u010e\17\55\1\uffff\2\55\1\u0120\3\55\1\uffff"+
        "\3\55\1\uffff\1\55\1\uffff\1\55\1\u0129\1\u012a\3\55\1\uffff\4\55"+
        "\1\u0132\3\55\1\uffff\1\55\1\uffff\1\u0137\1\u0138\6\55\1\u013f"+
        "\7\55\1\u0147\1\uffff\1\55\1\u0149\4\55\1\u014e\1\55\2\uffff\7\55"+
        "\1\uffff\1\u0157\1\55\1\u0159\1\55\2\uffff\3\55\1\u015f\1\u0160"+
        "\1\55\1\uffff\6\55\1\u0168\1\uffff\1\55\1\uffff\4\55\1\uffff\5\55"+
        "\1\u0173\2\55\1\uffff\1\55\1\uffff\5\55\2\uffff\6\55\1\u0185\1\uffff"+
        "\12\55\1\uffff\11\55\1\u019a\2\55\1\u019d\1\u019e\1\55\1\u01a0\1"+
        "\55\1\uffff\1\u01a2\3\55\1\u01a6\2\55\1\u01aa\11\55\1\u01b6\1\u01b7"+
        "\1\55\1\uffff\2\55\2\uffff\1\55\1\uffff\1\55\1\uffff\1\55\1\u01be"+
        "\1\55\1\uffff\1\u01c0\1\u01c1\1\55\1\uffff\13\55\2\uffff\1\55\1"+
        "\u01cf\1\u01d0\3\55\1\uffff\1\55\2\uffff\2\55\1\u01d8\4\55\1\u01dd"+
        "\3\55\1\u01e1\1\55\2\uffff\7\55\1\uffff\1\55\1\u01eb\2\55\1\uffff"+
        "\3\55\1\uffff\4\55\1\u01f5\4\55\1\uffff\7\55\1\u0201\1\u0202\1\uffff"+
        "\2\55\1\u0205\1\55\1\u0207\1\55\1\u0209\3\55\1\u020d\2\uffff\2\55"+
        "\1\uffff\1\55\1\uffff\1\55\1\uffff\3\55\1\uffff\1\u0215\3\55\1\u0219"+
        "\1\55\1\u021b\1\uffff\1\u021c\1\55\1\u021e\1\uffff\1\55\2\uffff"+
        "\1\55\1\uffff\1\55\1\u0222\1\u0223\2\uffff";
    static final String DFA21_eofS =
        "\u0224\uffff";
    static final String DFA21_minS =
        "\1\11\2\156\1\150\1\141\1\145\1\161\1\170\1\141\1\154\1\141\1\155"+
        "\1\156\3\141\1\157\1\142\1\55\1\141\1\162\2\141\1\157\1\150\1\162"+
        "\1\141\2\75\1\136\1\55\11\uffff\1\56\1\55\6\uffff\1\144\1\156\1"+
        "\171\2\141\1\164\1\146\1\155\1\143\1\165\1\141\1\143\1\156\1\157"+
        "\1\163\1\160\1\144\1\162\1\164\2\156\1\170\1\156\1\155\1\164\1\152"+
        "\1\164\1\154\1\55\1\uffff\1\164\1\145\1\156\1\146\1\155\1\154\1"+
        "\142\2\155\1\162\2\141\1\160\1\154\10\uffff\1\56\1\uffff\2\53\1"+
        "\uffff\3\55\1\157\1\155\1\162\1\163\1\141\1\146\1\152\1\141\2\151"+
        "\1\143\1\164\1\143\1\141\1\113\1\157\1\151\4\145\2\147\2\55\1\145"+
        "\1\55\1\145\1\157\1\171\1\uffff\1\164\1\146\1\147\1\154\1\145\1"+
        "\146\1\103\1\155\1\145\1\151\1\164\1\156\1\145\1\165\3\60\1\55\1"+
        "\uffff\1\164\1\155\1\141\1\163\1\120\1\145\1\157\1\151\1\155\1\166"+
        "\1\164\1\163\2\164\1\145\1\162\1\166\1\162\1\146\1\162\1\147\1\120"+
        "\1\164\1\145\1\uffff\1\145\1\uffff\1\144\1\uffff\1\143\1\154\1\55"+
        "\1\145\1\151\2\145\1\101\1\55\1\154\1\162\1\145\1\55\1\156\1\55"+
        "\2\163\1\145\1\60\2\55\1\uffff\1\141\1\145\1\143\1\55\1\162\1\171"+
        "\1\162\1\151\1\156\2\141\1\154\1\55\1\151\1\55\1\171\1\164\1\151"+
        "\1\163\1\154\1\163\1\145\1\141\1\150\2\156\1\111\1\160\1\164\1\157"+
        "\1\uffff\1\162\1\170\1\55\1\170\1\163\1\156\1\uffff\1\141\1\157"+
        "\1\164\1\uffff\1\147\1\uffff\1\151\2\55\3\164\1\uffff\1\157\1\160"+
        "\1\145\1\156\1\55\2\154\1\171\1\uffff\1\157\1\uffff\2\55\1\144\3"+
        "\145\1\162\1\164\1\55\2\147\1\156\1\141\1\120\1\147\1\156\1\55\1"+
        "\uffff\1\151\1\55\1\144\1\163\1\160\1\162\1\55\1\164\2\uffff\1\151"+
        "\1\162\1\145\1\160\1\145\1\156\1\164\1\uffff\1\55\1\145\1\55\1\156"+
        "\2\uffff\1\165\1\106\1\170\2\55\1\164\1\uffff\2\164\1\144\1\143"+
        "\1\162\1\171\1\55\1\uffff\1\166\1\uffff\1\151\1\163\1\145\1\151"+
        "\1\uffff\1\151\1\157\1\151\1\162\1\145\1\55\1\164\1\103\1\uffff"+
        "\1\156\1\uffff\2\141\1\165\1\146\1\151\2\uffff\1\145\2\150\1\151"+
        "\1\145\1\157\1\55\1\uffff\1\145\1\166\1\117\1\162\1\143\1\166\1"+
        "\156\1\143\1\151\1\162\1\uffff\1\106\1\154\1\162\1\151\1\156\1\164"+
        "\2\154\1\156\1\55\1\166\1\162\2\55\1\166\1\55\1\160\1\uffff\1\55"+
        "\1\151\1\146\1\164\1\55\1\145\1\120\1\55\1\163\1\164\1\156\1\162"+
        "\1\141\1\157\1\164\1\151\1\103\2\55\1\143\1\uffff\1\145\1\156\2"+
        "\uffff\1\151\1\uffff\1\145\1\uffff\1\144\1\55\1\171\1\uffff\2\55"+
        "\1\162\1\uffff\1\164\1\171\1\144\1\157\1\163\1\160\1\150\1\157\1"+
        "\154\1\162\1\157\2\uffff\1\164\2\55\1\144\1\162\1\165\1\uffff\1"+
        "\103\2\uffff\1\157\1\151\1\55\1\151\1\155\1\163\1\145\1\55\1\156"+
        "\1\141\1\157\1\55\1\151\2\uffff\1\165\1\164\1\141\1\146\1\150\1"+
        "\160\1\143\1\uffff\1\166\1\55\1\145\1\162\1\uffff\1\117\1\163\1"+
        "\160\1\uffff\1\157\1\141\1\171\1\154\1\55\1\141\1\145\1\163\1\151"+
        "\1\uffff\1\163\1\164\1\146\1\163\1\145\1\156\1\154\2\55\1\uffff"+
        "\1\151\1\162\1\55\1\144\1\55\1\151\1\55\1\145\1\162\1\141\1\55\2"+
        "\uffff\1\156\1\164\1\uffff\1\165\1\uffff\1\145\1\uffff\1\163\1\164"+
        "\1\154\1\uffff\1\55\1\171\1\141\1\163\1\55\1\151\1\55\1\uffff\1"+
        "\55\1\154\1\55\1\uffff\1\145\2\uffff\1\163\1\uffff\1\163\2\55\2"+
        "\uffff";
    static final String DFA21_maxS =
        "\1\ufffd\1\156\1\163\1\154\1\157\1\145\1\161\1\170\1\165\1\154\1"+
        "\141\1\162\1\156\1\145\1\151\1\141\1\157\1\156\1\ufffd\1\141\1\162"+
        "\1\145\1\171\1\164\1\150\1\171\1\141\2\75\1\136\1\ufffd\11\uffff"+
        "\1\71\1\ufffd\6\uffff\1\144\1\156\1\171\2\141\1\164\1\163\1\155"+
        "\1\143\1\165\1\141\1\143\1\156\1\157\1\163\1\160\1\166\1\162\1\166"+
        "\2\156\1\170\1\156\1\155\1\164\1\152\1\164\1\154\1\ufffd\1\uffff"+
        "\1\164\1\145\1\156\1\146\1\155\1\154\1\142\2\155\1\162\2\141\1\160"+
        "\1\154\10\uffff\1\145\1\uffff\2\71\1\uffff\3\ufffd\1\157\1\155\1"+
        "\162\1\163\1\141\1\146\1\152\1\141\2\151\1\143\1\164\1\143\1\141"+
        "\1\113\1\157\1\151\4\145\2\147\2\ufffd\1\145\1\ufffd\1\145\1\157"+
        "\1\171\1\uffff\1\164\1\146\1\147\1\154\1\145\1\146\1\120\1\155\1"+
        "\145\1\151\1\164\1\156\1\145\1\165\2\71\1\146\1\ufffd\1\uffff\1"+
        "\164\1\155\1\141\1\163\1\164\1\145\1\157\1\151\1\155\1\166\1\164"+
        "\1\163\2\164\1\145\1\162\1\166\1\162\1\146\1\162\1\147\1\120\1\164"+
        "\1\145\1\uffff\1\145\1\uffff\1\163\1\uffff\1\143\1\154\1\ufffd\1"+
        "\145\1\151\2\145\1\111\1\ufffd\1\154\1\162\1\145\1\ufffd\1\156\1"+
        "\ufffd\2\163\2\145\2\ufffd\1\uffff\1\141\1\145\1\143\1\ufffd\1\162"+
        "\1\171\1\162\1\151\1\156\2\141\1\154\1\ufffd\1\151\1\ufffd\1\171"+
        "\1\164\1\151\1\163\1\154\1\163\1\145\1\141\1\150\2\156\1\111\1\160"+
        "\1\164\1\157\1\uffff\1\162\1\170\1\ufffd\1\170\1\163\1\156\1\uffff"+
        "\1\141\1\157\1\164\1\uffff\1\147\1\uffff\1\151\2\ufffd\3\164\1\uffff"+
        "\1\157\1\160\1\145\1\156\1\ufffd\2\154\1\171\1\uffff\1\157\1\uffff"+
        "\2\ufffd\1\144\3\145\1\162\1\164\1\ufffd\2\147\1\156\1\141\1\120"+
        "\1\147\1\156\1\ufffd\1\uffff\1\151\1\ufffd\1\144\1\163\1\160\1\162"+
        "\1\ufffd\1\164\2\uffff\1\151\1\162\1\145\1\160\1\145\1\156\1\164"+
        "\1\uffff\1\ufffd\1\145\1\ufffd\1\156\2\uffff\1\165\1\117\1\170\2"+
        "\ufffd\1\164\1\uffff\2\164\1\144\1\143\1\162\1\171\1\ufffd\1\uffff"+
        "\1\166\1\uffff\1\151\1\163\1\145\1\151\1\uffff\1\151\1\157\1\151"+
        "\1\162\1\145\1\ufffd\1\164\1\127\1\uffff\1\156\1\uffff\2\141\1\165"+
        "\1\146\1\151\2\uffff\1\145\2\150\1\151\1\145\1\157\1\ufffd\1\uffff"+
        "\1\145\1\166\1\117\1\162\1\143\1\166\1\156\1\143\1\151\1\162\1\uffff"+
        "\1\111\1\154\1\162\1\151\1\156\1\164\2\154\1\156\1\ufffd\1\166\1"+
        "\162\2\ufffd\1\166\1\ufffd\1\160\1\uffff\1\ufffd\1\151\1\146\1\164"+
        "\1\ufffd\1\145\1\163\1\ufffd\1\163\1\164\1\156\1\162\1\141\1\157"+
        "\1\164\1\151\1\124\2\ufffd\1\143\1\uffff\1\145\1\156\2\uffff\1\151"+
        "\1\uffff\1\145\1\uffff\1\144\1\ufffd\1\171\1\uffff\2\ufffd\1\162"+
        "\1\uffff\1\164\1\171\1\144\1\157\1\163\1\160\1\150\1\157\1\154\1"+
        "\162\1\157\2\uffff\1\164\2\ufffd\1\144\1\162\1\165\1\uffff\1\117"+
        "\2\uffff\1\157\1\151\1\ufffd\1\151\1\155\1\163\1\145\1\ufffd\1\156"+
        "\1\141\1\157\1\ufffd\1\151\2\uffff\1\165\1\164\1\141\1\146\1\150"+
        "\1\160\1\143\1\uffff\1\166\1\ufffd\1\145\1\162\1\uffff\1\117\1\163"+
        "\1\160\1\uffff\1\157\1\141\1\171\1\154\1\ufffd\1\141\1\145\1\163"+
        "\1\151\1\uffff\1\163\1\164\1\146\1\163\1\145\1\156\1\154\2\ufffd"+
        "\1\uffff\1\151\1\162\1\ufffd\1\144\1\ufffd\1\151\1\ufffd\1\145\1"+
        "\162\1\141\1\ufffd\2\uffff\1\156\1\164\1\uffff\1\165\1\uffff\1\145"+
        "\1\uffff\1\163\1\164\1\154\1\uffff\1\ufffd\1\171\1\141\1\163\1\ufffd"+
        "\1\151\1\ufffd\1\uffff\1\ufffd\1\154\1\ufffd\1\uffff\1\145\2\uffff"+
        "\1\163\1\uffff\1\163\2\ufffd\2\uffff";
    static final String DFA21_acceptS =
        "\37\uffff\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116"+
        "\2\uffff\1\121\1\122\1\123\1\124\1\127\1\130\35\uffff\1\102\16\uffff"+
        "\1\77\1\76\1\100\1\101\1\103\1\104\1\126\1\105\1\uffff\1\117\2\uffff"+
        "\1\125\41\uffff\1\54\22\uffff\1\1\30\uffff\1\42\1\uffff\1\44\1\uffff"+
        "\1\50\25\uffff\1\120\36\uffff\1\52\6\uffff\1\63\3\uffff\1\64\1\uffff"+
        "\1\72\6\uffff\1\6\10\uffff\1\25\1\uffff\1\26\21\uffff\1\57\10\uffff"+
        "\1\74\1\75\7\uffff\1\20\4\uffff\1\30\1\31\6\uffff\1\41\7\uffff\1"+
        "\56\1\uffff\1\61\4\uffff\1\65\10\uffff\1\11\1\uffff\1\24\5\uffff"+
        "\1\33\1\36\7\uffff\1\55\12\uffff\1\10\21\uffff\1\53\24\uffff\1\35"+
        "\2\uffff\1\43\1\45\1\uffff\1\47\1\uffff\1\60\3\uffff\1\71\3\uffff"+
        "\1\4\13\uffff\1\27\1\32\6\uffff\1\66\1\uffff\1\73\1\2\15\uffff\1"+
        "\37\1\40\7\uffff\1\7\4\uffff\1\16\3\uffff\1\23\11\uffff\1\15\11"+
        "\uffff\1\67\13\uffff\1\51\1\62\2\uffff\1\5\1\uffff\1\13\1\uffff"+
        "\1\17\3\uffff\1\46\7\uffff\1\70\3\uffff\1\21\1\uffff\1\34\1\3\1"+
        "\uffff\1\14\3\uffff\1\12\1\22";
    static final String DFA21_specialS =
        "\u0224\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\57\1\uffff\2\57\22\uffff\1\57\1\uffff\1\53\1\56\4\uffff\1"+
            "\44\1\45\1\uffff\1\50\1\40\1\50\1\52\1\41\12\51\1\37\1\uffff"+
            "\1\34\1\uffff\1\33\1\56\1\54\1\2\1\55\1\3\1\4\1\6\1\10\1\55"+
            "\1\12\1\13\4\55\1\17\1\21\1\24\1\55\1\25\1\26\1\31\6\55\1\42"+
            "\1\uffff\1\43\1\35\1\36\1\uffff\1\1\2\55\1\5\1\7\1\11\2\55\1"+
            "\14\2\55\1\15\1\16\1\20\1\22\1\23\2\55\1\27\1\30\1\55\1\32\4"+
            "\55\1\46\1\uffff\1\47\102\uffff\27\55\1\uffff\37\55\1\uffff"+
            "\u0208\55\160\uffff\16\55\1\uffff\u1c81\55\14\uffff\2\55\142"+
            "\uffff\u0120\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100"+
            "\uffff\u04d0\55\40\uffff\u020e\55",
            "\1\60",
            "\1\61\4\uffff\1\62",
            "\1\63\3\uffff\1\64",
            "\1\65\7\uffff\1\66\5\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73\23\uffff\1\74",
            "\1\75",
            "\1\76",
            "\1\77\1\100\3\uffff\1\101",
            "\1\102",
            "\1\103\3\uffff\1\104",
            "\1\105\7\uffff\1\106",
            "\1\107",
            "\1\110",
            "\1\111\13\uffff\1\112",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\15\55"+
            "\1\113\3\55\1\114\10\55\74\uffff\1\55\10\uffff\27\55\1\uffff"+
            "\37\55\1\uffff\u0286\55\1\uffff\u1c81\55\14\uffff\2\55\61\uffff"+
            "\2\55\57\uffff\u0120\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff"+
            "\55\u2100\uffff\u04d0\55\40\uffff\u020e\55",
            "\1\116",
            "\1\117",
            "\1\120\3\uffff\1\121",
            "\1\122\3\uffff\1\123\17\uffff\1\124\3\uffff\1\125",
            "\1\126\4\uffff\1\127",
            "\1\130",
            "\1\131\6\uffff\1\132",
            "\1\133",
            "\1\134",
            "\1\136",
            "\1\140",
            "\2\142\1\uffff\12\142\1\141\6\uffff\32\142\4\uffff\1\142\1"+
            "\uffff\32\142\74\uffff\1\142\10\uffff\27\142\1\uffff\37\142"+
            "\1\uffff\u0286\142\1\uffff\u1c81\142\14\uffff\2\142\61\uffff"+
            "\2\142\57\uffff\u0120\142\u0a70\uffff\u03f0\142\21\uffff\ua7ff"+
            "\142\u2100\uffff\u04d0\142\40\uffff\u020e\142",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52\1\uffff\12\144",
            "\1\150\1\152\1\uffff\12\151\7\uffff\4\150\1\147\25\150\4\uffff"+
            "\1\150\1\uffff\4\150\1\146\25\150\74\uffff\1\150\10\uffff\27"+
            "\150\1\uffff\37\150\1\uffff\u0286\150\1\uffff\u1c81\150\14\uffff"+
            "\2\150\61\uffff\2\150\57\uffff\u0120\150\u0a70\uffff\u03f0\150"+
            "\21\uffff\ua7ff\150\u2100\uffff\u04d0\150\40\uffff\u020e\150",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161\14\uffff\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174\21\uffff\1\175",
            "\1\176",
            "\1\u0080\1\uffff\1\177",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0099\1\uffff\12\144\13\uffff\1\52\37\uffff\1\52",
            "",
            "\1\52\1\uffff\1\u009a\2\uffff\12\u009b",
            "\1\52\1\uffff\1\u009a\2\uffff\12\u009b",
            "",
            "\1\150\1\152\1\uffff\12\151\7\uffff\4\150\1\147\25\150\4\uffff"+
            "\1\150\1\uffff\4\150\1\146\25\150\74\uffff\1\150\10\uffff\27"+
            "\150\1\uffff\37\150\1\uffff\u0286\150\1\uffff\u1c81\150\14\uffff"+
            "\2\150\61\uffff\2\150\57\uffff\u0120\150\u0a70\uffff\u03f0\150"+
            "\21\uffff\ua7ff\150\u2100\uffff\u04d0\150\40\uffff\u020e\150",
            "\2\150\1\uffff\12\u009c\7\uffff\32\150\4\uffff\1\150\1\uffff"+
            "\32\150\74\uffff\1\150\10\uffff\27\150\1\uffff\37\150\1\uffff"+
            "\u0286\150\1\uffff\u1c81\150\14\uffff\2\150\61\uffff\2\150\57"+
            "\uffff\u0120\150\u0a70\uffff\u03f0\150\21\uffff\ua7ff\150\u2100"+
            "\uffff\u04d0\150\40\uffff\u020e\150",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\2\55\1\uffff\12\55\7\uffff\13\55\1\u00b5\16\55\4\uffff\1\55"+
            "\1\uffff\32\55\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1"+
            "\uffff\u0286\55\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55"+
            "\57\uffff\u0120\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100"+
            "\uffff\u04d0\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\13\55\1\u00b7\16\55\4\uffff\1\55"+
            "\1\uffff\32\55\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1"+
            "\uffff\u0286\55\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55"+
            "\57\uffff\u0120\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100"+
            "\uffff\u04d0\55\40\uffff\u020e\55",
            "\1\u00b9",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4\14\uffff\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\12\u00cd",
            "\12\u009b",
            "\12\u009b\14\uffff\1\u00cf\37\uffff\1\u00ce",
            "\2\150\1\uffff\12\u009c\7\uffff\4\150\1\147\25\150\4\uffff"+
            "\1\150\1\uffff\4\150\1\146\25\150\74\uffff\1\150\10\uffff\27"+
            "\150\1\uffff\37\150\1\uffff\u0286\150\1\uffff\u1c81\150\14\uffff"+
            "\2\150\61\uffff\2\150\57\uffff\u0120\150\u0a70\uffff\u03f0\150"+
            "\21\uffff\ua7ff\150\u2100\uffff\u04d0\150\40\uffff\u020e\150",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5\43\uffff\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "\1\u00ea",
            "",
            "\1\u00eb\16\uffff\1\u00ec",
            "",
            "\1\u00ed",
            "\1\u00ee",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4\7\uffff\1\u00f5",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u00fb",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\12\u00cd\13\uffff\1\52\37\uffff\1\52",
            "\2\150\1\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff"+
            "\32\150\74\uffff\1\150\10\uffff\27\150\1\uffff\37\150\1\uffff"+
            "\u0286\150\1\uffff\u1c81\150\14\uffff\2\150\61\uffff\2\150\57"+
            "\uffff\u0120\150\u0a70\uffff\u03f0\150\21\uffff\ua7ff\150\u2100"+
            "\uffff\u04d0\150\40\uffff\u020e\150",
            "\2\150\1\uffff\12\150\7\uffff\32\150\4\uffff\1\150\1\uffff"+
            "\32\150\74\uffff\1\150\10\uffff\27\150\1\uffff\37\150\1\uffff"+
            "\u0286\150\1\uffff\u1c81\150\14\uffff\2\150\61\uffff\2\150\57"+
            "\uffff\u0120\150\u0a70\uffff\u03f0\150\21\uffff\ua7ff\150\u2100"+
            "\uffff\u04d0\150\40\uffff\u020e\150",
            "",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u010d",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "",
            "\1\u011e",
            "\1\u011f",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "\1\u0127",
            "",
            "\1\u0128",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "",
            "\1\u0136",
            "",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\1\u0148",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u014f",
            "",
            "",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0158",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u015a",
            "",
            "",
            "\1\u015b",
            "\1\u015c\10\uffff\1\u015d",
            "\1\u015e",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0161",
            "",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\1\u0169",
            "",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0174",
            "\1\u0175\14\uffff\1\u0176\4\uffff\1\u0178\1\uffff\1\u0177",
            "",
            "\1\u0179",
            "",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "",
            "",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "",
            "\1\u0191\2\uffff\1\u0190",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u019b",
            "\1\u019c",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u019f",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01a1",
            "",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01a7",
            "\1\u01a9\42\uffff\1\u01a8",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3\14\uffff\1\u01b4\3\uffff\1\u01b5",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01b8",
            "",
            "\1\u01b9",
            "\1\u01ba",
            "",
            "",
            "\1\u01bb",
            "",
            "\1\u01bc",
            "",
            "\1\u01bd",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01bf",
            "",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01c2",
            "",
            "\1\u01c3",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "",
            "",
            "\1\u01ce",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "",
            "\1\u01d5\13\uffff\1\u01d4",
            "",
            "",
            "\1\u01d6",
            "\1\u01d7",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01d9",
            "\1\u01da",
            "\1\u01db",
            "\1\u01dc",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01e2",
            "",
            "",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\1\u01e8",
            "\1\u01e9",
            "",
            "\1\u01ea",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01ec",
            "\1\u01ed",
            "",
            "\1\u01ee",
            "\1\u01ef",
            "\1\u01f0",
            "",
            "\1\u01f1",
            "\1\u01f2",
            "\1\u01f3",
            "\1\u01f4",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u01f6",
            "\1\u01f7",
            "\1\u01f8",
            "\1\u01f9",
            "",
            "\1\u01fa",
            "\1\u01fb",
            "\1\u01fc",
            "\1\u01fd",
            "\1\u01fe",
            "\1\u01ff",
            "\1\u0200",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\1\u0203",
            "\1\u0204",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0206",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0208",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u020a",
            "\1\u020b",
            "\1\u020c",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "",
            "\1\u020e",
            "\1\u020f",
            "",
            "\1\u0210",
            "",
            "\1\u0211",
            "",
            "\1\u0212",
            "\1\u0213",
            "\1\u0214",
            "",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u0216",
            "\1\u0217",
            "\1\u0218",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u021a",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\1\u021d",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "",
            "\1\u021f",
            "",
            "",
            "\1\u0220",
            "",
            "\1\u0221",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
            "\2\55\1\uffff\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55"+
            "\74\uffff\1\55\10\uffff\27\55\1\uffff\37\55\1\uffff\u0286\55"+
            "\1\uffff\u1c81\55\14\uffff\2\55\61\uffff\2\55\57\uffff\u0120"+
            "\55\u0a70\uffff\u03f0\55\21\uffff\ua7ff\55\u2100\uffff\u04d0"+
            "\55\40\uffff\u020e\55",
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
            return "1:1: Tokens : ( AND_K | ANNOTATIONS_K | ANNOTATIONPROPERTY_K | ASYMMETRIC_K | CHARACTERISTICS_K | CLASS_K | DATAPROPERTY_K | DATATYPE_K | DECIMAL_K | DIFFERENTINDIVIDUALS_K | DISJOINTCLASSES_K | DISJOINTPROPERTIES_K | DIFFERENTFROM_K | DISJOINTWITH_K | DISJOINTUNIONOF_K | DOMAIN_K | EQUIVALENTCLASSES_K | EQUIVALENTPROPERTIES_K | EQUIVALENTTO_K | EXACTLY_K | FACTS_K | FLOAT_K | FUNCTIONAL_K | HASKEY_K | IMPORT_K | INDIVIDUAL_K | INVERSE_K | INVERSEFUNCTIONAL_K | INVERSEOF_K | INTEGER_K | IRREFLEXIVE_K | LANGPATTERN_K | LENGTH_K | MAX_K | MAXLENGTH_K | MIN_K | MINLENGTH_K | NAMEDINDIVIDUAL_K | NAMESPACE_K | NOT_K | OBJECTPROPERTY_K | ONLY_K | ONTOLOGY_K | OR_K | PATTERN_K | PREFIX_K | RANGE_K | REFLEXIVE_K | SAMEAS_K | SAMEINDIVIDUAL_K | SELF_K | SOME_K | STRING_K | SUBCLASSOF_K | SUBPROPERTYOF_K | SUBPROPERTYCHAIN_K | SYMMETRIC_K | THAT_K | TRANSITIVE_K | TYPES_K | VALUE_K | GREATER | GEQ | LEQ | LESS | CHAIN | DBL_CAP | BLANK | UNDERSCORE | COLON | COMMA | SLASH | LEFT_SQUARE | RIGHT_SQUARE | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | IntegerLiteral | DecimalLiteral | FloatingPointLiteral | QuotedString | LanguageTag | PN_ID | PN_NUMID | PN_UNDSCID | OTHER_CHARS | WS );";
        }
    }
 

}