// $ANTLR 3.1.1 /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g 2009-05-14 14:06:23

	package org.drools.lang;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.LinkedList;
	import org.drools.lang.descr.AccessorDescr;
	import org.drools.lang.descr.AccumulateDescr;
	import org.drools.lang.descr.AndDescr;
	import org.drools.lang.descr.AttributeDescr;
	import org.drools.lang.descr.BaseDescr;
	import org.drools.lang.descr.BehaviorDescr;
	import org.drools.lang.descr.DeclarativeInvokerDescr;
	import org.drools.lang.descr.DescrFactory;
	import org.drools.lang.descr.FactTemplateDescr;
	import org.drools.lang.descr.FieldConstraintDescr;
	import org.drools.lang.descr.FieldTemplateDescr;
	import org.drools.lang.descr.FromDescr;
	import org.drools.lang.descr.FunctionDescr;
	import org.drools.lang.descr.FunctionImportDescr;
	import org.drools.lang.descr.GlobalDescr;
	import org.drools.lang.descr.ImportDescr;
	import org.drools.lang.descr.PackageDescr;
	import org.drools.lang.descr.PatternSourceDescr;
	import org.drools.lang.descr.QueryDescr;
	import org.drools.lang.descr.RuleDescr;
	import org.drools.lang.descr.TypeDeclarationDescr;
	import org.drools.lang.descr.TypeFieldDescr;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DescrBuilderTree extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VT_COMPILATION_UNIT", "VT_FUNCTION_IMPORT", "VT_FACT", "VT_CONSTRAINTS", "VT_LABEL", "VT_QUERY_ID", "VT_TEMPLATE_ID", "VT_TYPE_DECLARE_ID", "VT_RULE_ID", "VT_ENTRYPOINT_ID", "VT_SLOT_ID", "VT_SLOT", "VT_RULE_ATTRIBUTES", "VT_RHS_CHUNK", "VT_CURLY_CHUNK", "VT_SQUARE_CHUNK", "VT_PAREN_CHUNK", "VT_BEHAVIOR", "VT_AND_IMPLICIT", "VT_AND_PREFIX", "VT_OR_PREFIX", "VT_AND_INFIX", "VT_OR_INFIX", "VT_EQUIV", "VT_XOR", "VT_ACCUMULATE_INIT_CLAUSE", "VT_ACCUMULATE_ID_CLAUSE", "VT_FROM_SOURCE", "VT_EXPRESSION_CHAIN", "VT_PATTERN", "VT_FACT_BINDING", "VT_FACT_OR", "VT_BIND_FIELD", "VT_FIELD", "VT_ACCESSOR_PATH", "VT_ACCESSOR_ELEMENT", "VT_DATA_TYPE", "VT_PATTERN_TYPE", "VT_PACKAGE_ID", "VT_IMPORT_ID", "VT_GLOBAL_ID", "VT_FUNCTION_ID", "VT_PARAM_LIST", "VT_CONSTRID", "VT_HEDGE", "VT_CONSTR_ATTRIBUTES", "VT_CUT", "VT_PRIOR", "VT_ARGS", "VT_TYPE", "VK_DATE_EFFECTIVE", "VK_DATE_EXPIRES", "VK_LOCK_ON_ACTIVE", "VK_NO_LOOP", "VK_AUTO_FOCUS", "VK_ACTIVATION_GROUP", "VK_AGENDA_GROUP", "VK_RULEFLOW_GROUP", "VK_DURATION", "VK_DIALECT", "VK_SALIENCE", "VK_ENABLED", "VK_ATTRIBUTES", "VK_RULE", "VK_EXTEND", "VK_IMPORT", "VK_PACKAGE", "VK_TEMPLATE", "VK_QUERY", "VK_DECLARE", "VK_FUNCTION", "VK_GLOBAL", "VK_EVAL", "VK_ENTRY_POINT", "VK_NOT", "VK_IN", "VK_OR", "VK_AND", "VK_EQUIV", "VK_XOR", "VK_EXISTS", "VK_FORALL", "VK_FORANY", "VK_ACTION", "VK_REVERSE", "VK_RESULT", "VK_OPERATOR", "VK_END", "VK_INIT", "VK_SUBJECT", "VK_WEIGHT", "VK_CUT", "VK_APPROX", "VK_ENTAIL", "VK_PRIOR", "VK_FILTER", "VK_AT", "VK_CONSTRID", "VK_ARGS", "VK_TYPE", "SEMICOLON", "ID", "DOT", "DOT_STAR", "STRING", "LEFT_PAREN", "COMMA", "RIGHT_PAREN", "AT", "COLON", "EQUALS", "WHEN", "BOOL", "INT", "DOUBLE_PIPE", "DOUBLE_AMPER", "FROM", "OVER", "ACCUMULATE", "COLLECT", "SINGLE_PIPE", "SINGLE_AMPER", "ARROW", "EQUAL", "GREATER", "GREATER_EQUAL", "LESS", "LESS_EQUAL", "NOT_EQUAL", "FLOAT", "NULL", "LEFT_SQUARE", "RIGHT_SQUARE", "THEN", "LEFT_CURLY", "RIGHT_CURLY", "MISC", "APPROX", "EOL", "WS", "EscapeSequence", "HexDigit", "UnicodeEscape", "OctalEscape", "CUT", "SH_STYLE_SINGLE_LINE_COMMENT", "C_STYLE_SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
    };
    public static final int VT_ACCESSOR_ELEMENT=39;
    public static final int ACCUMULATE=122;
    public static final int VT_DATA_TYPE=40;
    public static final int VK_TYPE=103;
    public static final int DOT_STAR=107;
    public static final int VK_APPROX=96;
    public static final int VT_CONSTRID=47;
    public static final int VK_OPERATOR=90;
    public static final int VK_FUNCTION=74;
    public static final int VK_GLOBAL=75;
    public static final int VK_AND=81;
    public static final int VT_TYPE=53;
    public static final int EQUALS=114;
    public static final int SH_STYLE_SINGLE_LINE_COMMENT=149;
    public static final int VK_AUTO_FOCUS=58;
    public static final int VK_SALIENCE=64;
    public static final int EOF=-1;
    public static final int VT_CUT=50;
    public static final int VT_CONSTR_ATTRIBUTES=49;
    public static final int VT_PATTERN_TYPE=41;
    public static final int VT_FUNCTION_IMPORT=5;
    public static final int VT_OR_INFIX=26;
    public static final int DOUBLE_AMPER=119;
    public static final int GREATER=128;
    public static final int EOL=142;
    public static final int VK_EQUIV=82;
    public static final int VK_IMPORT=69;
    public static final int NOT_EQUAL=132;
    public static final int VK_ACTION=87;
    public static final int VT_EQUIV=27;
    public static final int VK_RULE=67;
    public static final int LESS=130;
    public static final int VT_SLOT=15;
    public static final int VK_OR=80;
    public static final int VK_ARGS=102;
    public static final int VT_HEDGE=48;
    public static final int VK_CUT=95;
    public static final int VT_AND_PREFIX=23;
    public static final int VK_AT=100;
    public static final int VK_FILTER=99;
    public static final int NULL=134;
    public static final int BOOL=116;
    public static final int VK_ENTAIL=97;
    public static final int VK_QUERY=72;
    public static final int VK_SUBJECT=93;
    public static final int INT=117;
    public static final int SEMICOLON=104;
    public static final int VK_PRIOR=98;
    public static final int VT_FUNCTION_ID=45;
    public static final int VT_RHS_CHUNK=17;
    public static final int VT_FACT_BINDING=34;
    public static final int CUT=148;
    public static final int VK_RULEFLOW_GROUP=61;
    public static final int VK_ENTRY_POINT=77;
    public static final int SINGLE_AMPER=125;
    public static final int VT_PACKAGE_ID=42;
    public static final int VK_RESULT=89;
    public static final int VT_LABEL=8;
    public static final int WS=143;
    public static final int VK_NO_LOOP=57;
    public static final int LEFT_CURLY=138;
    public static final int VT_FACT=6;
    public static final int VT_PATTERN=33;
    public static final int VK_IN=79;
    public static final int LEFT_PAREN=109;
    public static final int LESS_EQUAL=131;
    public static final int VT_IMPORT_ID=43;
    public static final int VT_RULE_ID=12;
    public static final int MISC=140;
    public static final int FROM=120;
    public static final int VT_XOR=28;
    public static final int COLLECT=123;
    public static final int EscapeSequence=144;
    public static final int VK_ACTIVATION_GROUP=59;
    public static final int VK_ENABLED=65;
    public static final int C_STYLE_SINGLE_LINE_COMMENT=150;
    public static final int VK_PACKAGE=70;
    public static final int VK_END=91;
    public static final int OVER=121;
    public static final int VK_EXTEND=68;
    public static final int RIGHT_SQUARE=136;
    public static final int RIGHT_CURLY=139;
    public static final int SINGLE_PIPE=124;
    public static final int VT_FACT_OR=35;
    public static final int VT_FIELD=37;
    public static final int FLOAT=133;
    public static final int VT_ACCUMULATE_ID_CLAUSE=30;
    public static final int VK_EXISTS=84;
    public static final int VK_FORANY=86;
    public static final int VK_DATE_EXPIRES=55;
    public static final int ID=105;
    public static final int HexDigit=145;
    public static final int VK_EVAL=76;
    public static final int VT_OR_PREFIX=24;
    public static final int VK_WEIGHT=94;
    public static final int APPROX=141;
    public static final int AT=112;
    public static final int DOUBLE_PIPE=118;
    public static final int VT_ARGS=52;
    public static final int RIGHT_PAREN=111;
    public static final int VK_XOR=83;
    public static final int VT_COMPILATION_UNIT=4;
    public static final int THEN=137;
    public static final int VT_EXPRESSION_CHAIN=32;
    public static final int COMMA=110;
    public static final int EQUAL=127;
    public static final int VT_BEHAVIOR=21;
    public static final int VK_CONSTRID=101;
    public static final int VK_DIALECT=63;
    public static final int VT_QUERY_ID=9;
    public static final int DOT=106;
    public static final int VT_PRIOR=51;
    public static final int VT_GLOBAL_ID=44;
    public static final int VK_NOT=78;
    public static final int VT_FROM_SOURCE=31;
    public static final int VK_DECLARE=73;
    public static final int VT_ENTRYPOINT_ID=13;
    public static final int VT_PAREN_CHUNK=20;
    public static final int VT_TYPE_DECLARE_ID=11;
    public static final int VK_REVERSE=88;
    public static final int VK_LOCK_ON_ACTIVE=56;
    public static final int VK_TEMPLATE=71;
    public static final int VK_DURATION=62;
    public static final int VT_RULE_ATTRIBUTES=16;
    public static final int VT_AND_INFIX=25;
    public static final int VT_ACCESSOR_PATH=38;
    public static final int MULTI_LINE_COMMENT=151;
    public static final int VK_FORALL=85;
    public static final int COLON=113;
    public static final int VT_AND_IMPLICIT=22;
    public static final int VT_ACCUMULATE_INIT_CLAUSE=29;
    public static final int VT_CURLY_CHUNK=18;
    public static final int VT_SLOT_ID=14;
    public static final int VK_ATTRIBUTES=66;
    public static final int WHEN=115;
    public static final int UnicodeEscape=146;
    public static final int VT_SQUARE_CHUNK=19;
    public static final int VK_DATE_EFFECTIVE=54;
    public static final int VT_TEMPLATE_ID=10;
    public static final int VT_PARAM_LIST=46;
    public static final int ARROW=126;
    public static final int VT_BIND_FIELD=36;
    public static final int VK_AGENDA_GROUP=60;
    public static final int VT_CONSTRAINTS=7;
    public static final int LEFT_SQUARE=135;
    public static final int GREATER_EQUAL=129;
    public static final int OctalEscape=147;
    public static final int VK_INIT=92;
    public static final int STRING=108;

    // delegates
    // delegators


        public DescrBuilderTree(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public DescrBuilderTree(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return DescrBuilderTree.tokenNames; }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g"; }


    	DescrFactory factory = new DescrFactory();
    	PackageDescr packageDescr = null;
    	
    	public PackageDescr getPackageDescr() {
    		return packageDescr;
    	}



    // $ANTLR start "compilation_unit"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:48:1: compilation_unit : ^( VT_COMPILATION_UNIT package_statement ( statement )* ) ;
    public final void compilation_unit() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:49:2: ( ^( VT_COMPILATION_UNIT package_statement ( statement )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:49:4: ^( VT_COMPILATION_UNIT package_statement ( statement )* )
            {
            match(input,VT_COMPILATION_UNIT,FOLLOW_VT_COMPILATION_UNIT_in_compilation_unit49); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                pushFollow(FOLLOW_package_statement_in_compilation_unit51);
                package_statement();

                state._fsp--;

                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:49:44: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==VT_FUNCTION_IMPORT||(LA1_0>=VK_DATE_EFFECTIVE && LA1_0<=VK_ENABLED)||LA1_0==VK_RULE||LA1_0==VK_IMPORT||(LA1_0>=VK_TEMPLATE && LA1_0<=VK_GLOBAL)||(LA1_0>=VK_ENTAIL && LA1_0<=VK_FILTER)) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:49:44: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_compilation_unit53);
                	    statement();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop1;
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
        return ;
    }
    // $ANTLR end "compilation_unit"


    // $ANTLR start "package_statement"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:52:1: package_statement returns [String packageName] : ( ^( VK_PACKAGE packageId= package_id ) | );
    public final String package_statement() throws RecognitionException {
        String packageName = null;

        List packageId = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:53:2: ( ^( VK_PACKAGE packageId= package_id ) | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==VK_PACKAGE) ) {
                alt2=1;
            }
            else if ( (LA2_0==UP||LA2_0==VT_FUNCTION_IMPORT||(LA2_0>=VK_DATE_EFFECTIVE && LA2_0<=VK_ENABLED)||LA2_0==VK_RULE||LA2_0==VK_IMPORT||(LA2_0>=VK_TEMPLATE && LA2_0<=VK_GLOBAL)||(LA2_0>=VK_ENTAIL && LA2_0<=VK_FILTER)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:53:4: ^( VK_PACKAGE packageId= package_id )
                    {
                    match(input,VK_PACKAGE,FOLLOW_VK_PACKAGE_in_package_statement72); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_package_id_in_package_statement76);
                    packageId=package_id();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	this.packageDescr = factory.createPackage(packageId);	
                    		packageName = packageDescr.getName();	

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:57:2: 
                    {
                    	this.packageDescr = factory.createPackage(null);	
                    		packageName = "";	

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
        return packageName;
    }
    // $ANTLR end "package_statement"


    // $ANTLR start "package_id"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:61:1: package_id returns [List idList] : ^( VT_PACKAGE_ID (tempList+= ID )+ ) ;
    public final List package_id() throws RecognitionException {
        List idList = null;

        DroolsTree tempList=null;
        List list_tempList=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:62:2: ( ^( VT_PACKAGE_ID (tempList+= ID )+ ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:62:4: ^( VT_PACKAGE_ID (tempList+= ID )+ )
            {
            match(input,VT_PACKAGE_ID,FOLLOW_VT_PACKAGE_ID_in_package_id103); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:62:28: (tempList+= ID )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:62:28: tempList+= ID
            	    {
            	    tempList=(DroolsTree)match(input,ID,FOLLOW_ID_in_package_id107); 
            	    if (list_tempList==null) list_tempList=new ArrayList();
            	    list_tempList.add(tempList);


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match(input, Token.UP, null); 
            	idList = list_tempList;	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return idList;
    }
    // $ANTLR end "package_id"


    // $ANTLR start "statement"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:66:1: statement : (a= rule_attribute | fi= function_import_statement | is= import_statement | gl= global | fn= function | tp= template | rl= rule | qr= query | td= type_declaration );
    public final void statement() throws RecognitionException {
        AttributeDescr a = null;

        FunctionImportDescr fi = null;

        ImportDescr is = null;

        DescrBuilderTree.global_return gl = null;

        DescrBuilderTree.function_return fn = null;

        DescrBuilderTree.template_return tp = null;

        DescrBuilderTree.rule_return rl = null;

        DescrBuilderTree.query_return qr = null;

        TypeDeclarationDescr td = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:67:2: (a= rule_attribute | fi= function_import_statement | is= import_statement | gl= global | fn= function | tp= template | rl= rule | qr= query | td= type_declaration )
            int alt4=9;
            switch ( input.LA(1) ) {
            case VK_DATE_EFFECTIVE:
            case VK_DATE_EXPIRES:
            case VK_LOCK_ON_ACTIVE:
            case VK_NO_LOOP:
            case VK_AUTO_FOCUS:
            case VK_ACTIVATION_GROUP:
            case VK_AGENDA_GROUP:
            case VK_RULEFLOW_GROUP:
            case VK_DURATION:
            case VK_DIALECT:
            case VK_SALIENCE:
            case VK_ENABLED:
            case VK_ENTAIL:
            case VK_PRIOR:
            case VK_FILTER:
                {
                alt4=1;
                }
                break;
            case VT_FUNCTION_IMPORT:
                {
                alt4=2;
                }
                break;
            case VK_IMPORT:
                {
                alt4=3;
                }
                break;
            case VK_GLOBAL:
                {
                alt4=4;
                }
                break;
            case VK_FUNCTION:
                {
                alt4=5;
                }
                break;
            case VK_TEMPLATE:
                {
                alt4=6;
                }
                break;
            case VK_RULE:
                {
                alt4=7;
                }
                break;
            case VK_QUERY:
                {
                alt4=8;
                }
                break;
            case VK_DECLARE:
                {
                alt4=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:67:4: a= rule_attribute
                    {
                    pushFollow(FOLLOW_rule_attribute_in_statement125);
                    a=rule_attribute();

                    state._fsp--;

                    	this.packageDescr.addAttribute(a);	

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:69:4: fi= function_import_statement
                    {
                    pushFollow(FOLLOW_function_import_statement_in_statement135);
                    fi=function_import_statement();

                    state._fsp--;

                    	this.packageDescr.addFunctionImport(fi);	

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:71:4: is= import_statement
                    {
                    pushFollow(FOLLOW_import_statement_in_statement145);
                    is=import_statement();

                    state._fsp--;

                    	this.packageDescr.addImport(is);	

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:73:4: gl= global
                    {
                    pushFollow(FOLLOW_global_in_statement156);
                    gl=global();

                    state._fsp--;

                    	this.packageDescr.addGlobal((gl!=null?gl.globalDescr:null));	

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:75:4: fn= function
                    {
                    pushFollow(FOLLOW_function_in_statement166);
                    fn=function();

                    state._fsp--;

                    	this.packageDescr.addFunction((fn!=null?fn.functionDescr:null));	

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:77:4: tp= template
                    {
                    pushFollow(FOLLOW_template_in_statement176);
                    tp=template();

                    state._fsp--;

                    	this.packageDescr.addFactTemplate((tp!=null?tp.factTemplateDescr:null));	

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:79:4: rl= rule
                    {
                    pushFollow(FOLLOW_rule_in_statement186);
                    rl=rule();

                    state._fsp--;

                    	this.packageDescr.addRule((rl!=null?rl.ruleDescr:null));	

                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:81:4: qr= query
                    {
                    pushFollow(FOLLOW_query_in_statement196);
                    qr=query();

                    state._fsp--;

                    	this.packageDescr.addRule((qr!=null?qr.queryDescr:null));	

                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:83:4: td= type_declaration
                    {
                    pushFollow(FOLLOW_type_declaration_in_statement206);
                    td=type_declaration();

                    state._fsp--;

                    	this.packageDescr.addTypeDeclaration(td);	

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
    // $ANTLR end "statement"


    // $ANTLR start "import_statement"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:87:1: import_statement returns [ImportDescr importDescr] : ^(importStart= VK_IMPORT importId= import_name ) ;
    public final ImportDescr import_statement() throws RecognitionException {
        ImportDescr importDescr = null;

        DroolsTree importStart=null;
        DescrBuilderTree.import_name_return importId = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:88:2: ( ^(importStart= VK_IMPORT importId= import_name ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:88:4: ^(importStart= VK_IMPORT importId= import_name )
            {
            importStart=(DroolsTree)match(input,VK_IMPORT,FOLLOW_VK_IMPORT_in_import_statement227); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_import_name_in_import_statement231);
            importId=import_name();

            state._fsp--;


            match(input, Token.UP, null); 
            	importDescr = factory.createImport(importStart, (importId!=null?importId.idList:null), (importId!=null?importId.dotStar:null));	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return importDescr;
    }
    // $ANTLR end "import_statement"


    // $ANTLR start "function_import_statement"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:92:1: function_import_statement returns [FunctionImportDescr functionImportDescr] : ^(importStart= VT_FUNCTION_IMPORT VK_FUNCTION importId= import_name ) ;
    public final FunctionImportDescr function_import_statement() throws RecognitionException {
        FunctionImportDescr functionImportDescr = null;

        DroolsTree importStart=null;
        DescrBuilderTree.import_name_return importId = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:93:2: ( ^(importStart= VT_FUNCTION_IMPORT VK_FUNCTION importId= import_name ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:93:4: ^(importStart= VT_FUNCTION_IMPORT VK_FUNCTION importId= import_name )
            {
            importStart=(DroolsTree)match(input,VT_FUNCTION_IMPORT,FOLLOW_VT_FUNCTION_IMPORT_in_function_import_statement253); 

            match(input, Token.DOWN, null); 
            match(input,VK_FUNCTION,FOLLOW_VK_FUNCTION_in_function_import_statement255); 
            pushFollow(FOLLOW_import_name_in_function_import_statement259);
            importId=import_name();

            state._fsp--;


            match(input, Token.UP, null); 
            	functionImportDescr = factory.createFunctionImport(importStart, (importId!=null?importId.idList:null), (importId!=null?importId.dotStar:null));	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return functionImportDescr;
    }
    // $ANTLR end "function_import_statement"

    public static class import_name_return extends TreeRuleReturnScope {
        public List idList;
        public DroolsTree dotStar;
    };

    // $ANTLR start "import_name"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:97:1: import_name returns [List idList, DroolsTree dotStar] : ^( VT_IMPORT_ID (tempList+= ID )+ (tempDotStar= DOT_STAR )? ) ;
    public final DescrBuilderTree.import_name_return import_name() throws RecognitionException {
        DescrBuilderTree.import_name_return retval = new DescrBuilderTree.import_name_return();
        retval.start = input.LT(1);

        DroolsTree tempDotStar=null;
        DroolsTree tempList=null;
        List list_tempList=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:98:2: ( ^( VT_IMPORT_ID (tempList+= ID )+ (tempDotStar= DOT_STAR )? ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:98:4: ^( VT_IMPORT_ID (tempList+= ID )+ (tempDotStar= DOT_STAR )? )
            {
            match(input,VT_IMPORT_ID,FOLLOW_VT_IMPORT_ID_in_import_name278); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:98:27: (tempList+= ID )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:98:27: tempList+= ID
            	    {
            	    tempList=(DroolsTree)match(input,ID,FOLLOW_ID_in_import_name282); 
            	    if (list_tempList==null) list_tempList=new ArrayList();
            	    list_tempList.add(tempList);


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:98:44: (tempDotStar= DOT_STAR )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DOT_STAR) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:98:44: tempDotStar= DOT_STAR
                    {
                    tempDotStar=(DroolsTree)match(input,DOT_STAR,FOLLOW_DOT_STAR_in_import_name287); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	retval.idList = list_tempList;
            		retval.dotStar = tempDotStar;	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "import_name"

    public static class global_return extends TreeRuleReturnScope {
        public GlobalDescr globalDescr;
    };

    // $ANTLR start "global"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:103:1: global returns [GlobalDescr globalDescr] : ^(start= VK_GLOBAL dt= data_type globalId= VT_GLOBAL_ID ) ;
    public final DescrBuilderTree.global_return global() throws RecognitionException {
        DescrBuilderTree.global_return retval = new DescrBuilderTree.global_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree globalId=null;
        BaseDescr dt = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:104:2: ( ^(start= VK_GLOBAL dt= data_type globalId= VT_GLOBAL_ID ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:104:4: ^(start= VK_GLOBAL dt= data_type globalId= VT_GLOBAL_ID )
            {
            start=(DroolsTree)match(input,VK_GLOBAL,FOLLOW_VK_GLOBAL_in_global310); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_data_type_in_global314);
            dt=data_type();

            state._fsp--;

            globalId=(DroolsTree)match(input,VT_GLOBAL_ID,FOLLOW_VT_GLOBAL_ID_in_global318); 

            match(input, Token.UP, null); 
            	retval.globalDescr = factory.createGlobal(start,dt, globalId);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "global"

    public static class function_return extends TreeRuleReturnScope {
        public FunctionDescr functionDescr;
    };

    // $ANTLR start "function"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:108:1: function returns [FunctionDescr functionDescr] : ^(start= VK_FUNCTION (dt= data_type )? functionId= VT_FUNCTION_ID params= parameters content= VT_CURLY_CHUNK ) ;
    public final DescrBuilderTree.function_return function() throws RecognitionException {
        DescrBuilderTree.function_return retval = new DescrBuilderTree.function_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree functionId=null;
        DroolsTree content=null;
        BaseDescr dt = null;

        List params = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:109:2: ( ^(start= VK_FUNCTION (dt= data_type )? functionId= VT_FUNCTION_ID params= parameters content= VT_CURLY_CHUNK ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:109:4: ^(start= VK_FUNCTION (dt= data_type )? functionId= VT_FUNCTION_ID params= parameters content= VT_CURLY_CHUNK )
            {
            start=(DroolsTree)match(input,VK_FUNCTION,FOLLOW_VK_FUNCTION_in_function340); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:109:26: (dt= data_type )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==VT_DATA_TYPE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:109:26: dt= data_type
                    {
                    pushFollow(FOLLOW_data_type_in_function344);
                    dt=data_type();

                    state._fsp--;


                    }
                    break;

            }

            functionId=(DroolsTree)match(input,VT_FUNCTION_ID,FOLLOW_VT_FUNCTION_ID_in_function349); 
            pushFollow(FOLLOW_parameters_in_function353);
            params=parameters();

            state._fsp--;

            content=(DroolsTree)match(input,VT_CURLY_CHUNK,FOLLOW_VT_CURLY_CHUNK_in_function357); 

            match(input, Token.UP, null); 
            	retval.functionDescr = factory.createFunction(start, dt, functionId, params, content);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class template_return extends TreeRuleReturnScope {
        public FactTemplateDescr factTemplateDescr;
    };

    // $ANTLR start "template"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:113:1: template returns [FactTemplateDescr factTemplateDescr] : ^(start= VK_TEMPLATE id= VT_TEMPLATE_ID (ts= template_slot )+ end= VK_END ) ;
    public final DescrBuilderTree.template_return template() throws RecognitionException {
        DescrBuilderTree.template_return retval = new DescrBuilderTree.template_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree id=null;
        DroolsTree end=null;
        FieldTemplateDescr ts = null;



        	List slotList = new LinkedList<FieldTemplateDescr>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:116:3: ( ^(start= VK_TEMPLATE id= VT_TEMPLATE_ID (ts= template_slot )+ end= VK_END ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:116:5: ^(start= VK_TEMPLATE id= VT_TEMPLATE_ID (ts= template_slot )+ end= VK_END )
            {
            start=(DroolsTree)match(input,VK_TEMPLATE,FOLLOW_VK_TEMPLATE_in_template382); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,VT_TEMPLATE_ID,FOLLOW_VT_TEMPLATE_ID_in_template386); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:117:4: (ts= template_slot )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==VT_SLOT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:117:6: ts= template_slot
            	    {
            	    pushFollow(FOLLOW_template_slot_in_template395);
            	    ts=template_slot();

            	    state._fsp--;

            	    slotList.add(ts);

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            end=(DroolsTree)match(input,VK_END,FOLLOW_VK_END_in_template403); 

            match(input, Token.UP, null); 
            	retval.factTemplateDescr = factory.createFactTemplate(start, id, slotList, end);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "template"


    // $ANTLR start "template_slot"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:121:1: template_slot returns [FieldTemplateDescr fieldTemplateDescr] : ^( VT_SLOT dt= data_type id= VT_SLOT_ID ) ;
    public final FieldTemplateDescr template_slot() throws RecognitionException {
        FieldTemplateDescr fieldTemplateDescr = null;

        DroolsTree id=null;
        BaseDescr dt = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:122:2: ( ^( VT_SLOT dt= data_type id= VT_SLOT_ID ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:122:4: ^( VT_SLOT dt= data_type id= VT_SLOT_ID )
            {
            match(input,VT_SLOT,FOLLOW_VT_SLOT_in_template_slot423); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_data_type_in_template_slot427);
            dt=data_type();

            state._fsp--;

            id=(DroolsTree)match(input,VT_SLOT_ID,FOLLOW_VT_SLOT_ID_in_template_slot431); 

            match(input, Token.UP, null); 
            	fieldTemplateDescr = factory.createFieldTemplate(dt, id);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return fieldTemplateDescr;
    }
    // $ANTLR end "template_slot"

    public static class query_return extends TreeRuleReturnScope {
        public QueryDescr queryDescr;
    };

    // $ANTLR start "query"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:126:1: query returns [QueryDescr queryDescr] : ^(start= VK_QUERY id= VT_QUERY_ID (params= parameters )? lb= lhs_block end= VK_END ) ;
    public final DescrBuilderTree.query_return query() throws RecognitionException {
        DescrBuilderTree.query_return retval = new DescrBuilderTree.query_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree id=null;
        DroolsTree end=null;
        List params = null;

        AndDescr lb = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:127:2: ( ^(start= VK_QUERY id= VT_QUERY_ID (params= parameters )? lb= lhs_block end= VK_END ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:127:4: ^(start= VK_QUERY id= VT_QUERY_ID (params= parameters )? lb= lhs_block end= VK_END )
            {
            start=(DroolsTree)match(input,VK_QUERY,FOLLOW_VK_QUERY_in_query453); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,VT_QUERY_ID,FOLLOW_VT_QUERY_ID_in_query457); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:127:42: (params= parameters )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==VT_PARAM_LIST) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:127:42: params= parameters
                    {
                    pushFollow(FOLLOW_parameters_in_query461);
                    params=parameters();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_lhs_block_in_query466);
            lb=lhs_block();

            state._fsp--;

            end=(DroolsTree)match(input,VK_END,FOLLOW_VK_END_in_query470); 

            match(input, Token.UP, null); 
            	retval.queryDescr = factory.createQuery(start, id, params, lb, end);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "query"

    public static class rule_return extends TreeRuleReturnScope {
        public RuleDescr ruleDescr;
    };

    // $ANTLR start "rule"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:131:1: rule returns [RuleDescr ruleDescr] : ^(start= VK_RULE id= VT_RULE_ID ( ^( VK_EXTEND parent_id= VT_RULE_ID ) )? (dm= decl_metadata )* (ra= rule_attributes )? (wn= when_part )? content= VT_RHS_CHUNK ) ;
    public final DescrBuilderTree.rule_return rule() throws RecognitionException {
        DescrBuilderTree.rule_return retval = new DescrBuilderTree.rule_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree id=null;
        DroolsTree parent_id=null;
        DroolsTree content=null;
        Map dm = null;

        List ra = null;

        AndDescr wn = null;


        	List<Map> declMetadaList = new LinkedList<Map>();
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:133:2: ( ^(start= VK_RULE id= VT_RULE_ID ( ^( VK_EXTEND parent_id= VT_RULE_ID ) )? (dm= decl_metadata )* (ra= rule_attributes )? (wn= when_part )? content= VT_RHS_CHUNK ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:133:4: ^(start= VK_RULE id= VT_RULE_ID ( ^( VK_EXTEND parent_id= VT_RULE_ID ) )? (dm= decl_metadata )* (ra= rule_attributes )? (wn= when_part )? content= VT_RHS_CHUNK )
            {
            start=(DroolsTree)match(input,VK_RULE,FOLLOW_VK_RULE_in_rule497); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,VT_RULE_ID,FOLLOW_VT_RULE_ID_in_rule501); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:133:35: ( ^( VK_EXTEND parent_id= VT_RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==VK_EXTEND) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:133:36: ^( VK_EXTEND parent_id= VT_RULE_ID )
                    {
                    match(input,VK_EXTEND,FOLLOW_VK_EXTEND_in_rule506); 

                    match(input, Token.DOWN, null); 
                    parent_id=(DroolsTree)match(input,VT_RULE_ID,FOLLOW_VT_RULE_ID_in_rule510); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:134:3: (dm= decl_metadata )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==AT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:134:4: dm= decl_metadata
            	    {
            	    pushFollow(FOLLOW_decl_metadata_in_rule520);
            	    dm=decl_metadata();

            	    state._fsp--;

            	    declMetadaList.add(dm);	

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:135:6: (ra= rule_attributes )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==VT_RULE_ATTRIBUTES) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:135:6: ra= rule_attributes
                    {
                    pushFollow(FOLLOW_rule_attributes_in_rule531);
                    ra=rule_attributes();

                    state._fsp--;


                    }
                    break;

            }

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:136:6: (wn= when_part )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==WHEN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:136:6: wn= when_part
                    {
                    pushFollow(FOLLOW_when_part_in_rule540);
                    wn=when_part();

                    state._fsp--;


                    }
                    break;

            }

            content=(DroolsTree)match(input,VT_RHS_CHUNK,FOLLOW_VT_RHS_CHUNK_in_rule545); 

            match(input, Token.UP, null); 
            	retval.ruleDescr = factory.createRule(start, id, parent_id, ra, wn, content, declMetadaList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"


    // $ANTLR start "when_part"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:140:1: when_part returns [AndDescr andDescr] : WHEN lh= lhs_block ;
    public final AndDescr when_part() throws RecognitionException {
        AndDescr andDescr = null;

        AndDescr lh = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:141:2: ( WHEN lh= lhs_block )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:141:4: WHEN lh= lhs_block
            {
            match(input,WHEN,FOLLOW_WHEN_in_when_part564); 
            pushFollow(FOLLOW_lhs_block_in_when_part568);
            lh=lhs_block();

            state._fsp--;

            	andDescr = lh;	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return andDescr;
    }
    // $ANTLR end "when_part"


    // $ANTLR start "rule_attributes"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:145:1: rule_attributes returns [List attrList] : ^( VT_RULE_ATTRIBUTES ( VK_ATTRIBUTES )? (rl= rule_attribute )+ ) ;
    public final List rule_attributes() throws RecognitionException {
        List attrList = null;

        AttributeDescr rl = null;



        	attrList = new LinkedList<AttributeDescr>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:148:3: ( ^( VT_RULE_ATTRIBUTES ( VK_ATTRIBUTES )? (rl= rule_attribute )+ ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:148:5: ^( VT_RULE_ATTRIBUTES ( VK_ATTRIBUTES )? (rl= rule_attribute )+ )
            {
            match(input,VT_RULE_ATTRIBUTES,FOLLOW_VT_RULE_ATTRIBUTES_in_rule_attributes590); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:148:26: ( VK_ATTRIBUTES )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==VK_ATTRIBUTES) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:148:26: VK_ATTRIBUTES
                    {
                    match(input,VK_ATTRIBUTES,FOLLOW_VK_ATTRIBUTES_in_rule_attributes592); 

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:148:41: (rl= rule_attribute )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=VK_DATE_EFFECTIVE && LA15_0<=VK_ENABLED)||(LA15_0>=VK_ENTAIL && LA15_0<=VK_FILTER)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:148:42: rl= rule_attribute
            	    {
            	    pushFollow(FOLLOW_rule_attribute_in_rule_attributes598);
            	    rl=rule_attribute();

            	    state._fsp--;

            	    attrList.add(rl);

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
        return attrList;
    }
    // $ANTLR end "rule_attributes"


    // $ANTLR start "parameters"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:151:1: parameters returns [List paramList] : ^( VT_PARAM_LIST (p= param_definition )* ) ;
    public final List parameters() throws RecognitionException {
        List paramList = null;

        Map p = null;



        	paramList = new LinkedList<Map<BaseDescr, BaseDescr>>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:154:3: ( ^( VT_PARAM_LIST (p= param_definition )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:154:5: ^( VT_PARAM_LIST (p= param_definition )* )
            {
            match(input,VT_PARAM_LIST,FOLLOW_VT_PARAM_LIST_in_parameters622); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:154:21: (p= param_definition )*
                loop16:
                do {
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==VT_DATA_TYPE||LA16_0==ID) ) {
                        alt16=1;
                    }


                    switch (alt16) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:154:22: p= param_definition
                	    {
                	    pushFollow(FOLLOW_param_definition_in_parameters627);
                	    p=param_definition();

                	    state._fsp--;

                	    paramList.add(p);

                	    }
                	    break;

                	default :
                	    break loop16;
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
        return paramList;
    }
    // $ANTLR end "parameters"


    // $ANTLR start "param_definition"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:157:1: param_definition returns [Map param] : (dt= data_type )? a= argument ;
    public final Map param_definition() throws RecognitionException {
        Map param = null;

        BaseDescr dt = null;

        BaseDescr a = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:158:2: ( (dt= data_type )? a= argument )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:158:4: (dt= data_type )? a= argument
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:158:6: (dt= data_type )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==VT_DATA_TYPE) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:158:6: dt= data_type
                    {
                    pushFollow(FOLLOW_data_type_in_param_definition649);
                    dt=data_type();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_argument_in_param_definition654);
            a=argument();

            state._fsp--;

            	param = new HashMap<BaseDescr, BaseDescr>();
            		param.put(a, dt);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return param;
    }
    // $ANTLR end "param_definition"


    // $ANTLR start "argument"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:163:1: argument returns [BaseDescr arg] : id= ID ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* ;
    public final BaseDescr argument() throws RecognitionException {
        BaseDescr arg = null;

        DroolsTree id=null;
        DroolsTree rightList=null;
        List list_rightList=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:164:2: (id= ID ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:164:4: id= ID ( LEFT_SQUARE rightList+= RIGHT_SQUARE )*
            {
            id=(DroolsTree)match(input,ID,FOLLOW_ID_in_argument674); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:164:10: ( LEFT_SQUARE rightList+= RIGHT_SQUARE )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==LEFT_SQUARE) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:164:11: LEFT_SQUARE rightList+= RIGHT_SQUARE
            	    {
            	    match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_argument677); 
            	    rightList=(DroolsTree)match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_argument681); 
            	    if (list_rightList==null) list_rightList=new ArrayList();
            	    list_rightList.add(rightList);


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            	arg = factory.createArgument(id, list_rightList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "argument"


    // $ANTLR start "type_declaration"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:168:1: type_declaration returns [TypeDeclarationDescr declaration] : ^( VK_DECLARE id= VT_TYPE_DECLARE_ID (dm= decl_metadata )* (df= decl_field )* VK_END ) ;
    public final TypeDeclarationDescr type_declaration() throws RecognitionException {
        TypeDeclarationDescr declaration = null;

        DroolsTree id=null;
        Map dm = null;

        TypeFieldDescr df = null;


        	List<Map> declMetadaList = new LinkedList<Map>();
        		List<TypeFieldDescr> declFieldList = new LinkedList<TypeFieldDescr>(); 
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:171:2: ( ^( VK_DECLARE id= VT_TYPE_DECLARE_ID (dm= decl_metadata )* (df= decl_field )* VK_END ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:171:4: ^( VK_DECLARE id= VT_TYPE_DECLARE_ID (dm= decl_metadata )* (df= decl_field )* VK_END )
            {
            match(input,VK_DECLARE,FOLLOW_VK_DECLARE_in_type_declaration707); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,VT_TYPE_DECLARE_ID,FOLLOW_VT_TYPE_DECLARE_ID_in_type_declaration711); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:172:4: (dm= decl_metadata )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==AT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:172:5: dm= decl_metadata
            	    {
            	    pushFollow(FOLLOW_decl_metadata_in_type_declaration720);
            	    dm=decl_metadata();

            	    state._fsp--;

            	    declMetadaList.add(dm);	

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:173:4: (df= decl_field )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:173:5: df= decl_field
            	    {
            	    pushFollow(FOLLOW_decl_field_in_type_declaration733);
            	    df=decl_field();

            	    state._fsp--;

            	    declFieldList.add(df);	

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match(input,VK_END,FOLLOW_VK_END_in_type_declaration739); 

            match(input, Token.UP, null); 
            	declaration = factory.createTypeDeclr(id, declMetadaList, declFieldList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return declaration;
    }
    // $ANTLR end "type_declaration"


    // $ANTLR start "decl_metadata"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:177:1: decl_metadata returns [Map attData] : ^( AT att= ID (pc= VT_PAREN_CHUNK )? ) ;
    public final Map decl_metadata() throws RecognitionException {
        Map attData = null;

        DroolsTree att=null;
        DroolsTree pc=null;

        attData = new HashMap();
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:179:2: ( ^( AT att= ID (pc= VT_PAREN_CHUNK )? ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:179:4: ^( AT att= ID (pc= VT_PAREN_CHUNK )? )
            {
            match(input,AT,FOLLOW_AT_in_decl_metadata764); 

            match(input, Token.DOWN, null); 
            att=(DroolsTree)match(input,ID,FOLLOW_ID_in_decl_metadata768); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:179:18: (pc= VT_PAREN_CHUNK )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==VT_PAREN_CHUNK) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:179:18: pc= VT_PAREN_CHUNK
                    {
                    pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_decl_metadata772); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            	attData.put(att, pc);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return attData;
    }
    // $ANTLR end "decl_metadata"


    // $ANTLR start "decl_field"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:183:1: decl_field returns [TypeFieldDescr fieldDescr] : ^(id= ID (init= decl_field_initialization )? dt= data_type (dm= decl_metadata )* ) ;
    public final TypeFieldDescr decl_field() throws RecognitionException {
        TypeFieldDescr fieldDescr = null;

        DroolsTree id=null;
        String init = null;

        BaseDescr dt = null;

        Map dm = null;


        List<Map> declMetadaList = new LinkedList<Map>(); 
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:185:2: ( ^(id= ID (init= decl_field_initialization )? dt= data_type (dm= decl_metadata )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:185:4: ^(id= ID (init= decl_field_initialization )? dt= data_type (dm= decl_metadata )* )
            {
            id=(DroolsTree)match(input,ID,FOLLOW_ID_in_decl_field800); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:185:16: (init= decl_field_initialization )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==EQUALS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:185:16: init= decl_field_initialization
                    {
                    pushFollow(FOLLOW_decl_field_initialization_in_decl_field804);
                    init=decl_field_initialization();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_data_type_in_decl_field809);
            dt=data_type();

            state._fsp--;

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:185:57: (dm= decl_metadata )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==AT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:185:58: dm= decl_metadata
            	    {
            	    pushFollow(FOLLOW_decl_metadata_in_decl_field814);
            	    dm=decl_metadata();

            	    state._fsp--;

            	    declMetadaList.add(dm);

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            match(input, Token.UP, null); 
            	fieldDescr = factory.createTypeField(id, init, dt, declMetadaList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return fieldDescr;
    }
    // $ANTLR end "decl_field"


    // $ANTLR start "decl_field_initialization"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:189:1: decl_field_initialization returns [String expr] : ^( EQUALS pc= VT_PAREN_CHUNK ) ;
    public final String decl_field_initialization() throws RecognitionException {
        String expr = null;

        DroolsTree pc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:190:2: ( ^( EQUALS pc= VT_PAREN_CHUNK ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:190:4: ^( EQUALS pc= VT_PAREN_CHUNK )
            {
            match(input,EQUALS,FOLLOW_EQUALS_in_decl_field_initialization841); 

            match(input, Token.DOWN, null); 
            pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_decl_field_initialization845); 

            match(input, Token.UP, null); 
            	expr = (pc!=null?pc.getText():null).substring(1, (pc!=null?pc.getText():null).length() -1 ).trim();	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "decl_field_initialization"


    // $ANTLR start "rule_attribute"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:194:1: rule_attribute returns [AttributeDescr attributeDescr] : ( ^(attrName= VK_SALIENCE (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_NO_LOOP (value= BOOL )? ) | ^(attrName= VK_AGENDA_GROUP value= STRING ) | ^(attrName= VK_DURATION (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_ACTIVATION_GROUP value= STRING ) | ^(attrName= VK_AUTO_FOCUS (value= BOOL )? ) | ^(attrName= VK_DATE_EFFECTIVE value= STRING ) | ^(attrName= VK_DATE_EXPIRES value= STRING ) | ^(attrName= VK_ENABLED (value= BOOL | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_RULEFLOW_GROUP value= STRING ) | ^(attrName= VK_LOCK_ON_ACTIVE (value= BOOL )? ) | ^(attrName= VK_DIALECT value= STRING ) | ^(attrName= VK_PRIOR value= VT_PAREN_CHUNK ) | ^(attrName= VK_ENTAIL value= STRING ) | ^(attrName= VK_FILTER value= STRING ) ) ;
    public final AttributeDescr rule_attribute() throws RecognitionException {
        AttributeDescr attributeDescr = null;

        DroolsTree attrName=null;
        DroolsTree value=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:2: ( ( ^(attrName= VK_SALIENCE (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_NO_LOOP (value= BOOL )? ) | ^(attrName= VK_AGENDA_GROUP value= STRING ) | ^(attrName= VK_DURATION (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_ACTIVATION_GROUP value= STRING ) | ^(attrName= VK_AUTO_FOCUS (value= BOOL )? ) | ^(attrName= VK_DATE_EFFECTIVE value= STRING ) | ^(attrName= VK_DATE_EXPIRES value= STRING ) | ^(attrName= VK_ENABLED (value= BOOL | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_RULEFLOW_GROUP value= STRING ) | ^(attrName= VK_LOCK_ON_ACTIVE (value= BOOL )? ) | ^(attrName= VK_DIALECT value= STRING ) | ^(attrName= VK_PRIOR value= VT_PAREN_CHUNK ) | ^(attrName= VK_ENTAIL value= STRING ) | ^(attrName= VK_FILTER value= STRING ) ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:4: ( ^(attrName= VK_SALIENCE (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_NO_LOOP (value= BOOL )? ) | ^(attrName= VK_AGENDA_GROUP value= STRING ) | ^(attrName= VK_DURATION (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_ACTIVATION_GROUP value= STRING ) | ^(attrName= VK_AUTO_FOCUS (value= BOOL )? ) | ^(attrName= VK_DATE_EFFECTIVE value= STRING ) | ^(attrName= VK_DATE_EXPIRES value= STRING ) | ^(attrName= VK_ENABLED (value= BOOL | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_RULEFLOW_GROUP value= STRING ) | ^(attrName= VK_LOCK_ON_ACTIVE (value= BOOL )? ) | ^(attrName= VK_DIALECT value= STRING ) | ^(attrName= VK_PRIOR value= VT_PAREN_CHUNK ) | ^(attrName= VK_ENTAIL value= STRING ) | ^(attrName= VK_FILTER value= STRING ) )
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:4: ( ^(attrName= VK_SALIENCE (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_NO_LOOP (value= BOOL )? ) | ^(attrName= VK_AGENDA_GROUP value= STRING ) | ^(attrName= VK_DURATION (value= INT | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_ACTIVATION_GROUP value= STRING ) | ^(attrName= VK_AUTO_FOCUS (value= BOOL )? ) | ^(attrName= VK_DATE_EFFECTIVE value= STRING ) | ^(attrName= VK_DATE_EXPIRES value= STRING ) | ^(attrName= VK_ENABLED (value= BOOL | value= VT_PAREN_CHUNK ) ) | ^(attrName= VK_RULEFLOW_GROUP value= STRING ) | ^(attrName= VK_LOCK_ON_ACTIVE (value= BOOL )? ) | ^(attrName= VK_DIALECT value= STRING ) | ^(attrName= VK_PRIOR value= VT_PAREN_CHUNK ) | ^(attrName= VK_ENTAIL value= STRING ) | ^(attrName= VK_FILTER value= STRING ) )
            int alt30=15;
            switch ( input.LA(1) ) {
            case VK_SALIENCE:
                {
                alt30=1;
                }
                break;
            case VK_NO_LOOP:
                {
                alt30=2;
                }
                break;
            case VK_AGENDA_GROUP:
                {
                alt30=3;
                }
                break;
            case VK_DURATION:
                {
                alt30=4;
                }
                break;
            case VK_ACTIVATION_GROUP:
                {
                alt30=5;
                }
                break;
            case VK_AUTO_FOCUS:
                {
                alt30=6;
                }
                break;
            case VK_DATE_EFFECTIVE:
                {
                alt30=7;
                }
                break;
            case VK_DATE_EXPIRES:
                {
                alt30=8;
                }
                break;
            case VK_ENABLED:
                {
                alt30=9;
                }
                break;
            case VK_RULEFLOW_GROUP:
                {
                alt30=10;
                }
                break;
            case VK_LOCK_ON_ACTIVE:
                {
                alt30=11;
                }
                break;
            case VK_DIALECT:
                {
                alt30=12;
                }
                break;
            case VK_PRIOR:
                {
                alt30=13;
                }
                break;
            case VK_ENTAIL:
                {
                alt30=14;
                }
                break;
            case VK_FILTER:
                {
                alt30=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:5: ^(attrName= VK_SALIENCE (value= INT | value= VT_PAREN_CHUNK ) )
                    {
                    attrName=(DroolsTree)match(input,VK_SALIENCE,FOLLOW_VK_SALIENCE_in_rule_attribute868); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:28: (value= INT | value= VT_PAREN_CHUNK )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==INT) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==VT_PAREN_CHUNK) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:29: value= INT
                            {
                            value=(DroolsTree)match(input,INT,FOLLOW_INT_in_rule_attribute873); 

                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:195:39: value= VT_PAREN_CHUNK
                            {
                            value=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_rule_attribute877); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:196:4: ^(attrName= VK_NO_LOOP (value= BOOL )? )
                    {
                    attrName=(DroolsTree)match(input,VK_NO_LOOP,FOLLOW_VK_NO_LOOP_in_rule_attribute888); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:196:31: (value= BOOL )?
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==BOOL) ) {
                            alt25=1;
                        }
                        switch (alt25) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:196:31: value= BOOL
                                {
                                value=(DroolsTree)match(input,BOOL,FOLLOW_BOOL_in_rule_attribute892); 

                                }
                                break;

                        }


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:197:4: ^(attrName= VK_AGENDA_GROUP value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_AGENDA_GROUP,FOLLOW_VK_AGENDA_GROUP_in_rule_attribute904); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute908); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:198:4: ^(attrName= VK_DURATION (value= INT | value= VT_PAREN_CHUNK ) )
                    {
                    attrName=(DroolsTree)match(input,VK_DURATION,FOLLOW_VK_DURATION_in_rule_attribute919); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:198:27: (value= INT | value= VT_PAREN_CHUNK )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==INT) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==VT_PAREN_CHUNK) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:198:28: value= INT
                            {
                            value=(DroolsTree)match(input,INT,FOLLOW_INT_in_rule_attribute924); 

                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:198:38: value= VT_PAREN_CHUNK
                            {
                            value=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_rule_attribute928); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:199:4: ^(attrName= VK_ACTIVATION_GROUP value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_ACTIVATION_GROUP,FOLLOW_VK_ACTIVATION_GROUP_in_rule_attribute941); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute945); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:200:4: ^(attrName= VK_AUTO_FOCUS (value= BOOL )? )
                    {
                    attrName=(DroolsTree)match(input,VK_AUTO_FOCUS,FOLLOW_VK_AUTO_FOCUS_in_rule_attribute955); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:200:34: (value= BOOL )?
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==BOOL) ) {
                            alt27=1;
                        }
                        switch (alt27) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:200:34: value= BOOL
                                {
                                value=(DroolsTree)match(input,BOOL,FOLLOW_BOOL_in_rule_attribute959); 

                                }
                                break;

                        }


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:201:4: ^(attrName= VK_DATE_EFFECTIVE value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_DATE_EFFECTIVE,FOLLOW_VK_DATE_EFFECTIVE_in_rule_attribute970); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute974); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:202:4: ^(attrName= VK_DATE_EXPIRES value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_DATE_EXPIRES,FOLLOW_VK_DATE_EXPIRES_in_rule_attribute984); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute988); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:203:4: ^(attrName= VK_ENABLED (value= BOOL | value= VT_PAREN_CHUNK ) )
                    {
                    attrName=(DroolsTree)match(input,VK_ENABLED,FOLLOW_VK_ENABLED_in_rule_attribute998); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:203:26: (value= BOOL | value= VT_PAREN_CHUNK )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==BOOL) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==VT_PAREN_CHUNK) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:203:27: value= BOOL
                            {
                            value=(DroolsTree)match(input,BOOL,FOLLOW_BOOL_in_rule_attribute1003); 

                            }
                            break;
                        case 2 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:203:38: value= VT_PAREN_CHUNK
                            {
                            value=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_rule_attribute1007); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:204:4: ^(attrName= VK_RULEFLOW_GROUP value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_RULEFLOW_GROUP,FOLLOW_VK_RULEFLOW_GROUP_in_rule_attribute1018); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute1022); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:205:4: ^(attrName= VK_LOCK_ON_ACTIVE (value= BOOL )? )
                    {
                    attrName=(DroolsTree)match(input,VK_LOCK_ON_ACTIVE,FOLLOW_VK_LOCK_ON_ACTIVE_in_rule_attribute1032); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:205:38: (value= BOOL )?
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==BOOL) ) {
                            alt29=1;
                        }
                        switch (alt29) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:205:38: value= BOOL
                                {
                                value=(DroolsTree)match(input,BOOL,FOLLOW_BOOL_in_rule_attribute1036); 

                                }
                                break;

                        }


                        match(input, Token.UP, null); 
                    }

                    }
                    break;
                case 12 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:206:4: ^(attrName= VK_DIALECT value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_DIALECT,FOLLOW_VK_DIALECT_in_rule_attribute1046); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute1050); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:207:4: ^(attrName= VK_PRIOR value= VT_PAREN_CHUNK )
                    {
                    attrName=(DroolsTree)match(input,VK_PRIOR,FOLLOW_VK_PRIOR_in_rule_attribute1059); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_rule_attribute1063); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:208:4: ^(attrName= VK_ENTAIL value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_ENTAIL,FOLLOW_VK_ENTAIL_in_rule_attribute1072); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute1076); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:209:4: ^(attrName= VK_FILTER value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_FILTER,FOLLOW_VK_FILTER_in_rule_attribute1085); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_rule_attribute1089); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            	attributeDescr = factory.createAttribute(attrName, value);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return attributeDescr;
    }
    // $ANTLR end "rule_attribute"


    // $ANTLR start "constraint_attributes"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:215:1: constraint_attributes returns [List attrList] : ^( VT_CONSTR_ATTRIBUTES (conAtt= constr_attribute )+ ) ;
    public final List constraint_attributes() throws RecognitionException {
        List attrList = null;

        AttributeDescr conAtt = null;



          attrList = new LinkedList<AttributeDescr>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:218:3: ( ^( VT_CONSTR_ATTRIBUTES (conAtt= constr_attribute )+ ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:218:5: ^( VT_CONSTR_ATTRIBUTES (conAtt= constr_attribute )+ )
            {
            match(input,VT_CONSTR_ATTRIBUTES,FOLLOW_VT_CONSTR_ATTRIBUTES_in_constraint_attributes1116); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:218:28: (conAtt= constr_attribute )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==VK_CUT||LA31_0==VK_PRIOR||(LA31_0>=VK_CONSTRID && LA31_0<=VK_TYPE)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:218:29: conAtt= constr_attribute
            	    {
            	    pushFollow(FOLLOW_constr_attribute_in_constraint_attributes1121);
            	    conAtt=constr_attribute();

            	    state._fsp--;

            	    attrList.add(conAtt);

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
        return attrList;
    }
    // $ANTLR end "constraint_attributes"


    // $ANTLR start "constr_attribute"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:221:1: constr_attribute returns [AttributeDescr attributeDescr] : ( ^(attrName= VK_CONSTRID value= STRING ) | ^(attrName= VK_ARGS value= STRING ) | ^(attrName= VK_TYPE value= STRING ) | ^(attrName= VK_CUT value= STRING ) | ^(attrName= VK_PRIOR value= STRING ) ) ;
    public final AttributeDescr constr_attribute() throws RecognitionException {
        AttributeDescr attributeDescr = null;

        DroolsTree attrName=null;
        DroolsTree value=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:222:3: ( ( ^(attrName= VK_CONSTRID value= STRING ) | ^(attrName= VK_ARGS value= STRING ) | ^(attrName= VK_TYPE value= STRING ) | ^(attrName= VK_CUT value= STRING ) | ^(attrName= VK_PRIOR value= STRING ) ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:222:5: ( ^(attrName= VK_CONSTRID value= STRING ) | ^(attrName= VK_ARGS value= STRING ) | ^(attrName= VK_TYPE value= STRING ) | ^(attrName= VK_CUT value= STRING ) | ^(attrName= VK_PRIOR value= STRING ) )
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:222:5: ( ^(attrName= VK_CONSTRID value= STRING ) | ^(attrName= VK_ARGS value= STRING ) | ^(attrName= VK_TYPE value= STRING ) | ^(attrName= VK_CUT value= STRING ) | ^(attrName= VK_PRIOR value= STRING ) )
            int alt32=5;
            switch ( input.LA(1) ) {
            case VK_CONSTRID:
                {
                alt32=1;
                }
                break;
            case VK_ARGS:
                {
                alt32=2;
                }
                break;
            case VK_TYPE:
                {
                alt32=3;
                }
                break;
            case VK_CUT:
                {
                alt32=4;
                }
                break;
            case VK_PRIOR:
                {
                alt32=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:223:5: ^(attrName= VK_CONSTRID value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_CONSTRID,FOLLOW_VK_CONSTRID_in_constr_attribute1155); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_constr_attribute1159); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:224:5: ^(attrName= VK_ARGS value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_ARGS,FOLLOW_VK_ARGS_in_constr_attribute1170); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_constr_attribute1174); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:225:5: ^(attrName= VK_TYPE value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_TYPE,FOLLOW_VK_TYPE_in_constr_attribute1186); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_constr_attribute1190); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:226:5: ^(attrName= VK_CUT value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_CUT,FOLLOW_VK_CUT_in_constr_attribute1203); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_constr_attribute1207); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:227:5: ^(attrName= VK_PRIOR value= STRING )
                    {
                    attrName=(DroolsTree)match(input,VK_PRIOR,FOLLOW_VK_PRIOR_in_constr_attribute1220); 

                    match(input, Token.DOWN, null); 
                    value=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_constr_attribute1224); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

             attributeDescr = factory.createAttribute(attrName, value); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return attributeDescr;
    }
    // $ANTLR end "constr_attribute"


    // $ANTLR start "lhs_block"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:232:1: lhs_block returns [AndDescr andDescr] : ^( VT_AND_IMPLICIT (dt= lhs )* ) ;
    public final AndDescr lhs_block() throws RecognitionException {
        AndDescr andDescr = null;

        DescrBuilderTree.lhs_return dt = null;



        	andDescr = new AndDescr();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:235:3: ( ^( VT_AND_IMPLICIT (dt= lhs )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:235:5: ^( VT_AND_IMPLICIT (dt= lhs )* )
            {
            match(input,VT_AND_IMPLICIT,FOLLOW_VT_AND_IMPLICIT_in_lhs_block1259); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:235:23: (dt= lhs )*
                loop33:
                do {
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=VT_AND_PREFIX && LA33_0<=VT_XOR)||LA33_0==VT_PATTERN||LA33_0==VT_HEDGE||LA33_0==VK_EVAL||LA33_0==VK_NOT||(LA33_0>=VK_EXISTS && LA33_0<=VK_FORANY)||LA33_0==FROM) ) {
                        alt33=1;
                    }


                    switch (alt33) {
                	case 1 :
                	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:235:24: dt= lhs
                	    {
                	    pushFollow(FOLLOW_lhs_in_lhs_block1264);
                	    dt=lhs();

                	    state._fsp--;

                	    andDescr.addDescr((dt!=null?dt.baseDescr:null));

                	    }
                	    break;

                	default :
                	    break loop33;
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
        return andDescr;
    }
    // $ANTLR end "lhs_block"

    public static class lhs_return extends TreeRuleReturnScope {
        public BaseDescr baseDescr;
    };

    // $ANTLR start "lhs"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:238:1: lhs returns [BaseDescr baseDescr] : ( ^(start= VT_OR_PREFIX (attribs= constraint_attributes )? (dt= lhs )+ ) | ^(start= VT_OR_INFIX (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VT_AND_PREFIX (attribs= constraint_attributes )? (dt= lhs )+ ) | ^(start= VT_AND_INFIX (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VT_EQUIV (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VT_XOR (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VK_EXISTS dt= lhs ) | ^(start= VK_NOT dt= lhs ) | ^(start= VT_HEDGE dt= lhs ) | ^(start= VK_EVAL pc= VT_PAREN_CHUNK ) | ^(start= VK_FORALL (dt= lhs )+ ) | ^(start= VK_FORANY (arg= lhs ( VK_SUBJECT sub= lhs )? ( VK_WEIGHT wgt= lhs )? ) ) | ^( FROM pn= lhs_pattern fe= from_elements ) | pn= lhs_pattern );
    public final DescrBuilderTree.lhs_return lhs() throws RecognitionException {
        DescrBuilderTree.lhs_return retval = new DescrBuilderTree.lhs_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree pc=null;
        List attribs = null;

        DescrBuilderTree.lhs_return dt = null;

        DescrBuilderTree.lhs_return dt1 = null;

        DescrBuilderTree.lhs_return dt2 = null;

        DescrBuilderTree.lhs_return arg = null;

        DescrBuilderTree.lhs_return sub = null;

        DescrBuilderTree.lhs_return wgt = null;

        BaseDescr pn = null;

        DescrBuilderTree.from_elements_return fe = null;



        	List<BaseDescr> lhsList = new LinkedList<BaseDescr>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:241:3: ( ^(start= VT_OR_PREFIX (attribs= constraint_attributes )? (dt= lhs )+ ) | ^(start= VT_OR_INFIX (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VT_AND_PREFIX (attribs= constraint_attributes )? (dt= lhs )+ ) | ^(start= VT_AND_INFIX (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VT_EQUIV (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VT_XOR (attribs= constraint_attributes )? dt1= lhs dt2= lhs ) | ^(start= VK_EXISTS dt= lhs ) | ^(start= VK_NOT dt= lhs ) | ^(start= VT_HEDGE dt= lhs ) | ^(start= VK_EVAL pc= VT_PAREN_CHUNK ) | ^(start= VK_FORALL (dt= lhs )+ ) | ^(start= VK_FORANY (arg= lhs ( VK_SUBJECT sub= lhs )? ( VK_WEIGHT wgt= lhs )? ) ) | ^( FROM pn= lhs_pattern fe= from_elements ) | pn= lhs_pattern )
            int alt45=14;
            switch ( input.LA(1) ) {
            case VT_OR_PREFIX:
                {
                alt45=1;
                }
                break;
            case VT_OR_INFIX:
                {
                alt45=2;
                }
                break;
            case VT_AND_PREFIX:
                {
                alt45=3;
                }
                break;
            case VT_AND_INFIX:
                {
                alt45=4;
                }
                break;
            case VT_EQUIV:
                {
                alt45=5;
                }
                break;
            case VT_XOR:
                {
                alt45=6;
                }
                break;
            case VK_EXISTS:
                {
                alt45=7;
                }
                break;
            case VK_NOT:
                {
                alt45=8;
                }
                break;
            case VT_HEDGE:
                {
                alt45=9;
                }
                break;
            case VK_EVAL:
                {
                alt45=10;
                }
                break;
            case VK_FORALL:
                {
                alt45=11;
                }
                break;
            case VK_FORANY:
                {
                alt45=12;
                }
                break;
            case FROM:
                {
                alt45=13;
                }
                break;
            case VT_PATTERN:
                {
                alt45=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:241:5: ^(start= VT_OR_PREFIX (attribs= constraint_attributes )? (dt= lhs )+ )
                    {
                    start=(DroolsTree)match(input,VT_OR_PREFIX,FOLLOW_VT_OR_PREFIX_in_lhs1290); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:241:33: (attribs= constraint_attributes )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:241:33: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_lhs1294);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:241:57: (dt= lhs )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( ((LA35_0>=VT_AND_PREFIX && LA35_0<=VT_XOR)||LA35_0==VT_PATTERN||LA35_0==VT_HEDGE||LA35_0==VK_EVAL||LA35_0==VK_NOT||(LA35_0>=VK_EXISTS && LA35_0<=VK_FORANY)||LA35_0==FROM) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:241:58: dt= lhs
                    	    {
                    	    pushFollow(FOLLOW_lhs_in_lhs1300);
                    	    dt=lhs();

                    	    state._fsp--;

                    	    	lhsList.add((dt!=null?dt.baseDescr:null));	

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);


                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.createOr(start, lhsList, attribs);	

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:243:4: ^(start= VT_OR_INFIX (attribs= constraint_attributes )? dt1= lhs dt2= lhs )
                    {
                    start=(DroolsTree)match(input,VT_OR_INFIX,FOLLOW_VT_OR_INFIX_in_lhs1316); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:243:31: (attribs= constraint_attributes )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:243:31: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_lhs1320);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_lhs_in_lhs1325);
                    dt1=lhs();

                    state._fsp--;

                    pushFollow(FOLLOW_lhs_in_lhs1329);
                    dt2=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	lhsList.add((dt1!=null?dt1.baseDescr:null));
                    		lhsList.add((dt2!=null?dt2.baseDescr:null));
                    		retval.baseDescr = factory.createOr(start, lhsList, attribs);	

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:247:4: ^(start= VT_AND_PREFIX (attribs= constraint_attributes )? (dt= lhs )+ )
                    {
                    start=(DroolsTree)match(input,VT_AND_PREFIX,FOLLOW_VT_AND_PREFIX_in_lhs1341); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:247:33: (attribs= constraint_attributes )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:247:33: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_lhs1345);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:247:57: (dt= lhs )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=VT_AND_PREFIX && LA38_0<=VT_XOR)||LA38_0==VT_PATTERN||LA38_0==VT_HEDGE||LA38_0==VK_EVAL||LA38_0==VK_NOT||(LA38_0>=VK_EXISTS && LA38_0<=VK_FORANY)||LA38_0==FROM) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:247:58: dt= lhs
                    	    {
                    	    pushFollow(FOLLOW_lhs_in_lhs1351);
                    	    dt=lhs();

                    	    state._fsp--;

                    	    	lhsList.add((dt!=null?dt.baseDescr:null));	

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.createAnd(start, lhsList, attribs);	

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:249:4: ^(start= VT_AND_INFIX (attribs= constraint_attributes )? dt1= lhs dt2= lhs )
                    {
                    start=(DroolsTree)match(input,VT_AND_INFIX,FOLLOW_VT_AND_INFIX_in_lhs1367); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:249:32: (attribs= constraint_attributes )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:249:32: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_lhs1371);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_lhs_in_lhs1376);
                    dt1=lhs();

                    state._fsp--;

                    pushFollow(FOLLOW_lhs_in_lhs1380);
                    dt2=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	lhsList.add((dt1!=null?dt1.baseDescr:null));
                    		lhsList.add((dt2!=null?dt2.baseDescr:null));
                    		retval.baseDescr = factory.createAnd(start, lhsList, attribs);	

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:254:5: ^(start= VT_EQUIV (attribs= constraint_attributes )? dt1= lhs dt2= lhs )
                    {
                    start=(DroolsTree)match(input,VT_EQUIV,FOLLOW_VT_EQUIV_in_lhs1396); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:254:29: (attribs= constraint_attributes )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:254:29: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_lhs1400);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_lhs_in_lhs1405);
                    dt1=lhs();

                    state._fsp--;

                    pushFollow(FOLLOW_lhs_in_lhs1409);
                    dt2=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     lhsList.add((dt1!=null?dt1.baseDescr:null));
                        lhsList.add((dt2!=null?dt2.baseDescr:null));
                        retval.baseDescr = factory.createEquiv(start, lhsList, attribs);  

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:258:6: ^(start= VT_XOR (attribs= constraint_attributes )? dt1= lhs dt2= lhs )
                    {
                    start=(DroolsTree)match(input,VT_XOR,FOLLOW_VT_XOR_in_lhs1425); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:258:28: (attribs= constraint_attributes )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:258:28: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_lhs1429);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_lhs_in_lhs1434);
                    dt1=lhs();

                    state._fsp--;

                    pushFollow(FOLLOW_lhs_in_lhs1438);
                    dt2=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     lhsList.add((dt1!=null?dt1.baseDescr:null));
                        lhsList.add((dt2!=null?dt2.baseDescr:null));
                        retval.baseDescr = factory.createXor(start, lhsList, attribs);  

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:265:4: ^(start= VK_EXISTS dt= lhs )
                    {
                    start=(DroolsTree)match(input,VK_EXISTS,FOLLOW_VK_EXISTS_in_lhs1462); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lhs_in_lhs1466);
                    dt=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.createExists(start, (dt!=null?dt.baseDescr:null));	

                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:267:4: ^(start= VK_NOT dt= lhs )
                    {
                    start=(DroolsTree)match(input,VK_NOT,FOLLOW_VK_NOT_in_lhs1478); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lhs_in_lhs1482);
                    dt=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.createNot(start, (dt!=null?dt.baseDescr:null));	

                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:270:5: ^(start= VT_HEDGE dt= lhs )
                    {
                    start=(DroolsTree)match(input,VT_HEDGE,FOLLOW_VT_HEDGE_in_lhs1497); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lhs_in_lhs1501);
                    dt=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.baseDescr = factory.createHedge(start, (dt!=null?dt.baseDescr:null));  

                    }
                    break;
                case 10 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:274:4: ^(start= VK_EVAL pc= VT_PAREN_CHUNK )
                    {
                    start=(DroolsTree)match(input,VK_EVAL,FOLLOW_VK_EVAL_in_lhs1518); 

                    match(input, Token.DOWN, null); 
                    pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_lhs1522); 

                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.createEval(start, pc);	

                    }
                    break;
                case 11 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:276:4: ^(start= VK_FORALL (dt= lhs )+ )
                    {
                    start=(DroolsTree)match(input,VK_FORALL,FOLLOW_VK_FORALL_in_lhs1534); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:276:22: (dt= lhs )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( ((LA42_0>=VT_AND_PREFIX && LA42_0<=VT_XOR)||LA42_0==VT_PATTERN||LA42_0==VT_HEDGE||LA42_0==VK_EVAL||LA42_0==VK_NOT||(LA42_0>=VK_EXISTS && LA42_0<=VK_FORANY)||LA42_0==FROM) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:276:23: dt= lhs
                    	    {
                    	    pushFollow(FOLLOW_lhs_in_lhs1539);
                    	    dt=lhs();

                    	    state._fsp--;

                    	    	lhsList.add((dt!=null?dt.baseDescr:null));	

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);


                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.createForAll(start, lhsList);	

                    }
                    break;
                case 12 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:5: ^(start= VK_FORANY (arg= lhs ( VK_SUBJECT sub= lhs )? ( VK_WEIGHT wgt= lhs )? ) )
                    {
                    start=(DroolsTree)match(input,VK_FORANY,FOLLOW_VK_FORANY_in_lhs1558); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:23: (arg= lhs ( VK_SUBJECT sub= lhs )? ( VK_WEIGHT wgt= lhs )? )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:24: arg= lhs ( VK_SUBJECT sub= lhs )? ( VK_WEIGHT wgt= lhs )?
                    {
                    pushFollow(FOLLOW_lhs_in_lhs1563);
                    arg=lhs();

                    state._fsp--;

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:32: ( VK_SUBJECT sub= lhs )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==VK_SUBJECT) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:33: VK_SUBJECT sub= lhs
                            {
                            match(input,VK_SUBJECT,FOLLOW_VK_SUBJECT_in_lhs1566); 
                            pushFollow(FOLLOW_lhs_in_lhs1570);
                            sub=lhs();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:54: ( VK_WEIGHT wgt= lhs )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==VK_WEIGHT) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:279:55: VK_WEIGHT wgt= lhs
                            {
                            match(input,VK_WEIGHT,FOLLOW_VK_WEIGHT_in_lhs1575); 
                            pushFollow(FOLLOW_lhs_in_lhs1579);
                            wgt=lhs();

                            state._fsp--;


                            }
                            break;

                    }


                    }


                    match(input, Token.UP, null); 
                     retval.baseDescr = factory.createForAny(start, arg.baseDescr, sub == null ? null : sub.baseDescr, wgt == null ? null : wgt.baseDescr); 

                    }
                    break;
                case 13 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:282:4: ^( FROM pn= lhs_pattern fe= from_elements )
                    {
                    match(input,FROM,FOLLOW_FROM_in_lhs1597); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lhs_pattern_in_lhs1601);
                    pn=lhs_pattern();

                    state._fsp--;

                    pushFollow(FOLLOW_from_elements_in_lhs1605);
                    fe=from_elements();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.baseDescr = factory.setupFrom(pn, (fe!=null?fe.patternSourceDescr:null));	

                    }
                    break;
                case 14 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:284:4: pn= lhs_pattern
                    {
                    pushFollow(FOLLOW_lhs_pattern_in_lhs1616);
                    pn=lhs_pattern();

                    state._fsp--;

                    	retval.baseDescr = pn;	

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
        return retval;
    }
    // $ANTLR end "lhs"

    public static class from_elements_return extends TreeRuleReturnScope {
        public PatternSourceDescr patternSourceDescr;
    };

    // $ANTLR start "from_elements"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:288:1: from_elements returns [PatternSourceDescr patternSourceDescr] : ( ^(start= ACCUMULATE dt= lhs ret= accumulate_parts[$patternSourceDescr] ) | ^(start= COLLECT dt= lhs ) | ^(start= VK_ENTRY_POINT entryId= VT_ENTRYPOINT_ID ) | fs= from_source_clause );
    public final DescrBuilderTree.from_elements_return from_elements() throws RecognitionException {
        DescrBuilderTree.from_elements_return retval = new DescrBuilderTree.from_elements_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree entryId=null;
        DescrBuilderTree.lhs_return dt = null;

        AccumulateDescr ret = null;

        DescrBuilderTree.from_source_clause_return fs = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:289:2: ( ^(start= ACCUMULATE dt= lhs ret= accumulate_parts[$patternSourceDescr] ) | ^(start= COLLECT dt= lhs ) | ^(start= VK_ENTRY_POINT entryId= VT_ENTRYPOINT_ID ) | fs= from_source_clause )
            int alt46=4;
            switch ( input.LA(1) ) {
            case ACCUMULATE:
                {
                alt46=1;
                }
                break;
            case COLLECT:
                {
                alt46=2;
                }
                break;
            case VK_ENTRY_POINT:
                {
                alt46=3;
                }
                break;
            case VT_FROM_SOURCE:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:289:4: ^(start= ACCUMULATE dt= lhs ret= accumulate_parts[$patternSourceDescr] )
                    {
                    start=(DroolsTree)match(input,ACCUMULATE,FOLLOW_ACCUMULATE_in_from_elements1637); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lhs_in_from_elements1641);
                    dt=lhs();

                    state._fsp--;

                    	retval.patternSourceDescr = factory.createAccumulate(start, (dt!=null?dt.baseDescr:null));	
                    pushFollow(FOLLOW_accumulate_parts_in_from_elements1651);
                    ret=accumulate_parts(retval.patternSourceDescr);

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.patternSourceDescr = ret;	

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:293:4: ^(start= COLLECT dt= lhs )
                    {
                    start=(DroolsTree)match(input,COLLECT,FOLLOW_COLLECT_in_from_elements1664); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lhs_in_from_elements1668);
                    dt=lhs();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.patternSourceDescr = factory.createCollect(start, (dt!=null?dt.baseDescr:null));	

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:295:4: ^(start= VK_ENTRY_POINT entryId= VT_ENTRYPOINT_ID )
                    {
                    start=(DroolsTree)match(input,VK_ENTRY_POINT,FOLLOW_VK_ENTRY_POINT_in_from_elements1680); 

                    match(input, Token.DOWN, null); 
                    entryId=(DroolsTree)match(input,VT_ENTRYPOINT_ID,FOLLOW_VT_ENTRYPOINT_ID_in_from_elements1684); 

                    match(input, Token.UP, null); 
                    	retval.patternSourceDescr = factory.createEntryPoint(start, entryId);	

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:297:4: fs= from_source_clause
                    {
                    pushFollow(FOLLOW_from_source_clause_in_from_elements1695);
                    fs=from_source_clause();

                    state._fsp--;

                    	retval.patternSourceDescr = (fs!=null?fs.fromDescr:null);	

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
        return retval;
    }
    // $ANTLR end "from_elements"


    // $ANTLR start "accumulate_parts"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:301:1: accumulate_parts[PatternSourceDescr patternSourceDescr] returns [AccumulateDescr accumulateDescr] : (ac1= accumulate_init_clause[$patternSourceDescr] | ac2= accumulate_id_clause[$patternSourceDescr] );
    public final AccumulateDescr accumulate_parts(PatternSourceDescr patternSourceDescr) throws RecognitionException {
        AccumulateDescr accumulateDescr = null;

        DescrBuilderTree.accumulate_init_clause_return ac1 = null;

        AccumulateDescr ac2 = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:302:2: (ac1= accumulate_init_clause[$patternSourceDescr] | ac2= accumulate_id_clause[$patternSourceDescr] )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==VT_ACCUMULATE_INIT_CLAUSE) ) {
                alt47=1;
            }
            else if ( (LA47_0==VT_ACCUMULATE_ID_CLAUSE) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:302:4: ac1= accumulate_init_clause[$patternSourceDescr]
                    {
                    pushFollow(FOLLOW_accumulate_init_clause_in_accumulate_parts1716);
                    ac1=accumulate_init_clause(patternSourceDescr);

                    state._fsp--;

                    	accumulateDescr = (ac1!=null?ac1.accumulateDescr:null);	

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:304:4: ac2= accumulate_id_clause[$patternSourceDescr]
                    {
                    pushFollow(FOLLOW_accumulate_id_clause_in_accumulate_parts1727);
                    ac2=accumulate_id_clause(patternSourceDescr);

                    state._fsp--;

                    	accumulateDescr = ac2;	

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
        return accumulateDescr;
    }
    // $ANTLR end "accumulate_parts"

    public static class accumulate_init_clause_return extends TreeRuleReturnScope {
        public AccumulateDescr accumulateDescr;
    };

    // $ANTLR start "accumulate_init_clause"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:308:1: accumulate_init_clause[PatternSourceDescr accumulateParam] returns [AccumulateDescr accumulateDescr] : ^( VT_ACCUMULATE_INIT_CLAUSE ^(start= VK_INIT pc1= VT_PAREN_CHUNK ) ^( VK_ACTION pc2= VT_PAREN_CHUNK ) (rev= accumulate_init_reverse_clause )? ^( VK_RESULT pc3= VT_PAREN_CHUNK ) ) ;
    public final DescrBuilderTree.accumulate_init_clause_return accumulate_init_clause(PatternSourceDescr accumulateParam) throws RecognitionException {
        DescrBuilderTree.accumulate_init_clause_return retval = new DescrBuilderTree.accumulate_init_clause_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree pc1=null;
        DroolsTree pc2=null;
        DroolsTree pc3=null;
        DescrBuilderTree.accumulate_init_reverse_clause_return rev = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:309:2: ( ^( VT_ACCUMULATE_INIT_CLAUSE ^(start= VK_INIT pc1= VT_PAREN_CHUNK ) ^( VK_ACTION pc2= VT_PAREN_CHUNK ) (rev= accumulate_init_reverse_clause )? ^( VK_RESULT pc3= VT_PAREN_CHUNK ) ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:309:4: ^( VT_ACCUMULATE_INIT_CLAUSE ^(start= VK_INIT pc1= VT_PAREN_CHUNK ) ^( VK_ACTION pc2= VT_PAREN_CHUNK ) (rev= accumulate_init_reverse_clause )? ^( VK_RESULT pc3= VT_PAREN_CHUNK ) )
            {
            match(input,VT_ACCUMULATE_INIT_CLAUSE,FOLLOW_VT_ACCUMULATE_INIT_CLAUSE_in_accumulate_init_clause1750); 

            match(input, Token.DOWN, null); 
            start=(DroolsTree)match(input,VK_INIT,FOLLOW_VK_INIT_in_accumulate_init_clause1759); 

            match(input, Token.DOWN, null); 
            pc1=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_clause1763); 

            match(input, Token.UP, null); 
            match(input,VK_ACTION,FOLLOW_VK_ACTION_in_accumulate_init_clause1771); 

            match(input, Token.DOWN, null); 
            pc2=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_clause1775); 

            match(input, Token.UP, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:312:7: (rev= accumulate_init_reverse_clause )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==VK_REVERSE) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:312:7: rev= accumulate_init_reverse_clause
                    {
                    pushFollow(FOLLOW_accumulate_init_reverse_clause_in_accumulate_init_clause1784);
                    rev=accumulate_init_reverse_clause();

                    state._fsp--;


                    }
                    break;

            }

            match(input,VK_RESULT,FOLLOW_VK_RESULT_in_accumulate_init_clause1791); 

            match(input, Token.DOWN, null); 
            pc3=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_clause1795); 

            match(input, Token.UP, null); 

            match(input, Token.UP, null); 
            	if (null == rev){
            			retval.accumulateDescr = factory.setupAccumulateInit(accumulateParam, start, pc1, pc2, pc3, null);
            		} else {
            			retval.accumulateDescr = factory.setupAccumulateInit(accumulateParam, start, pc1, pc2, pc3, (rev!=null?rev.vkReverseChunk:null));
            		}	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "accumulate_init_clause"

    public static class accumulate_init_reverse_clause_return extends TreeRuleReturnScope {
        public DroolsTree vkReverse;
        public DroolsTree vkReverseChunk;
    };

    // $ANTLR start "accumulate_init_reverse_clause"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:321:1: accumulate_init_reverse_clause returns [DroolsTree vkReverse, DroolsTree vkReverseChunk] : ^(vk= VK_REVERSE pc= VT_PAREN_CHUNK ) ;
    public final DescrBuilderTree.accumulate_init_reverse_clause_return accumulate_init_reverse_clause() throws RecognitionException {
        DescrBuilderTree.accumulate_init_reverse_clause_return retval = new DescrBuilderTree.accumulate_init_reverse_clause_return();
        retval.start = input.LT(1);

        DroolsTree vk=null;
        DroolsTree pc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:322:2: ( ^(vk= VK_REVERSE pc= VT_PAREN_CHUNK ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:322:4: ^(vk= VK_REVERSE pc= VT_PAREN_CHUNK )
            {
            vk=(DroolsTree)match(input,VK_REVERSE,FOLLOW_VK_REVERSE_in_accumulate_init_reverse_clause1818); 

            match(input, Token.DOWN, null); 
            pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_reverse_clause1822); 

            match(input, Token.UP, null); 
            	retval.vkReverse = vk;
            		retval.vkReverseChunk = pc;	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "accumulate_init_reverse_clause"


    // $ANTLR start "accumulate_id_clause"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:327:1: accumulate_id_clause[PatternSourceDescr accumulateParam] returns [AccumulateDescr accumulateDescr] : ^( VT_ACCUMULATE_ID_CLAUSE id= ID pc= VT_PAREN_CHUNK ) ;
    public final AccumulateDescr accumulate_id_clause(PatternSourceDescr accumulateParam) throws RecognitionException {
        AccumulateDescr accumulateDescr = null;

        DroolsTree id=null;
        DroolsTree pc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:328:2: ( ^( VT_ACCUMULATE_ID_CLAUSE id= ID pc= VT_PAREN_CHUNK ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:328:4: ^( VT_ACCUMULATE_ID_CLAUSE id= ID pc= VT_PAREN_CHUNK )
            {
            match(input,VT_ACCUMULATE_ID_CLAUSE,FOLLOW_VT_ACCUMULATE_ID_CLAUSE_in_accumulate_id_clause1844); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,ID,FOLLOW_ID_in_accumulate_id_clause1848); 
            pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_accumulate_id_clause1852); 

            match(input, Token.UP, null); 
            	accumulateDescr = factory.setupAccumulateId(accumulateParam, id, pc);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return accumulateDescr;
    }
    // $ANTLR end "accumulate_id_clause"

    protected static class from_source_clause_scope {
        AccessorDescr accessorDescr;
    }
    protected Stack from_source_clause_stack = new Stack();

    public static class from_source_clause_return extends TreeRuleReturnScope {
        public FromDescr fromDescr;
        public AccessorDescr retAccessorDescr;
    };

    // $ANTLR start "from_source_clause"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:332:1: from_source_clause returns [FromDescr fromDescr, AccessorDescr retAccessorDescr] : ^( VT_FROM_SOURCE id= ID (pc= VT_PAREN_CHUNK )? ( expression_chain )? ) ;
    public final DescrBuilderTree.from_source_clause_return from_source_clause() throws RecognitionException {
        from_source_clause_stack.push(new from_source_clause_scope());
        DescrBuilderTree.from_source_clause_return retval = new DescrBuilderTree.from_source_clause_return();
        retval.start = input.LT(1);

        DroolsTree id=null;
        DroolsTree pc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:335:3: ( ^( VT_FROM_SOURCE id= ID (pc= VT_PAREN_CHUNK )? ( expression_chain )? ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:335:5: ^( VT_FROM_SOURCE id= ID (pc= VT_PAREN_CHUNK )? ( expression_chain )? )
            {
            match(input,VT_FROM_SOURCE,FOLLOW_VT_FROM_SOURCE_in_from_source_clause1874); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,ID,FOLLOW_ID_in_from_source_clause1878); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:335:30: (pc= VT_PAREN_CHUNK )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==VT_PAREN_CHUNK) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:335:30: pc= VT_PAREN_CHUNK
                    {
                    pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_from_source_clause1882); 

                    }
                    break;

            }

            	((from_source_clause_scope)from_source_clause_stack.peek()).accessorDescr = factory.createAccessor(id, pc);	
            		retval.retAccessorDescr = ((from_source_clause_scope)from_source_clause_stack.peek()).accessorDescr;	
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:338:3: ( expression_chain )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==VT_EXPRESSION_CHAIN) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:338:3: expression_chain
                    {
                    pushFollow(FOLLOW_expression_chain_in_from_source_clause1891);
                    expression_chain();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            	retval.fromDescr = factory.createFromSource(factory.setupAccessorOffset(((from_source_clause_scope)from_source_clause_stack.peek()).accessorDescr)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            from_source_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "from_source_clause"

    public static class expression_chain_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "expression_chain"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:342:1: expression_chain : ^(start= VT_EXPRESSION_CHAIN id= ID (sc= VT_SQUARE_CHUNK )? (pc= VT_PAREN_CHUNK )? ( expression_chain )? ) ;
    public final DescrBuilderTree.expression_chain_return expression_chain() throws RecognitionException {
        DescrBuilderTree.expression_chain_return retval = new DescrBuilderTree.expression_chain_return();
        retval.start = input.LT(1);

        DroolsTree start=null;
        DroolsTree id=null;
        DroolsTree sc=null;
        DroolsTree pc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:343:2: ( ^(start= VT_EXPRESSION_CHAIN id= ID (sc= VT_SQUARE_CHUNK )? (pc= VT_PAREN_CHUNK )? ( expression_chain )? ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:343:4: ^(start= VT_EXPRESSION_CHAIN id= ID (sc= VT_SQUARE_CHUNK )? (pc= VT_PAREN_CHUNK )? ( expression_chain )? )
            {
            start=(DroolsTree)match(input,VT_EXPRESSION_CHAIN,FOLLOW_VT_EXPRESSION_CHAIN_in_expression_chain1910); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,ID,FOLLOW_ID_in_expression_chain1914); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:343:40: (sc= VT_SQUARE_CHUNK )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==VT_SQUARE_CHUNK) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:343:40: sc= VT_SQUARE_CHUNK
                    {
                    sc=(DroolsTree)match(input,VT_SQUARE_CHUNK,FOLLOW_VT_SQUARE_CHUNK_in_expression_chain1918); 

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:343:60: (pc= VT_PAREN_CHUNK )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==VT_PAREN_CHUNK) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:343:60: pc= VT_PAREN_CHUNK
                    {
                    pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_expression_chain1923); 

                    }
                    break;

            }

            	DeclarativeInvokerDescr declarativeInvokerResult = factory.createExpressionChain(start, id, sc, pc);	
            		((from_source_clause_scope)from_source_clause_stack.peek()).accessorDescr.addInvoker(declarativeInvokerResult);	
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:346:3: ( expression_chain )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==VT_EXPRESSION_CHAIN) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:346:3: expression_chain
                    {
                    pushFollow(FOLLOW_expression_chain_in_expression_chain1931);
                    expression_chain();

                    state._fsp--;


                    }
                    break;

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
        return retval;
    }
    // $ANTLR end "expression_chain"


    // $ANTLR start "lhs_pattern"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:349:1: lhs_pattern returns [BaseDescr baseDescr] : ^( VT_PATTERN fe= fact_expression ) (oc= over_clause )? ;
    public final BaseDescr lhs_pattern() throws RecognitionException {
        BaseDescr baseDescr = null;

        DescrBuilderTree.fact_expression_return fe = null;

        List oc = null;


        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:350:2: ( ^( VT_PATTERN fe= fact_expression ) (oc= over_clause )? )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:350:4: ^( VT_PATTERN fe= fact_expression ) (oc= over_clause )?
            {
            match(input,VT_PATTERN,FOLLOW_VT_PATTERN_in_lhs_pattern1950); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_fact_expression_in_lhs_pattern1954);
            fe=fact_expression();

            state._fsp--;


            match(input, Token.UP, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:350:40: (oc= over_clause )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==OVER) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:350:40: oc= over_clause
                    {
                    pushFollow(FOLLOW_over_clause_in_lhs_pattern1960);
                    oc=over_clause();

                    state._fsp--;


                    }
                    break;

            }

            	
            	 baseDescr = factory.setupBehavior((fe!=null?fe.descr:null), oc);	  
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return baseDescr;
    }
    // $ANTLR end "lhs_pattern"


    // $ANTLR start "over_clause"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:356:1: over_clause returns [List behaviorList] : ^( OVER (oe= over_element )+ ) ;
    public final List over_clause() throws RecognitionException {
        List behaviorList = null;

        BehaviorDescr oe = null;


        behaviorList = new LinkedList();
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:358:2: ( ^( OVER (oe= over_element )+ ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:358:4: ^( OVER (oe= over_element )+ )
            {
            match(input,OVER,FOLLOW_OVER_in_over_clause1985); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:358:11: (oe= over_element )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==VT_BEHAVIOR) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:358:12: oe= over_element
            	    {
            	    pushFollow(FOLLOW_over_element_in_over_clause1990);
            	    oe=over_element();

            	    state._fsp--;

            	    behaviorList.add(oe);

            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
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
        return behaviorList;
    }
    // $ANTLR end "over_clause"


    // $ANTLR start "over_element"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:361:1: over_element returns [BehaviorDescr behavior] : ^( VT_BEHAVIOR ID id2= ID pc= VT_PAREN_CHUNK ) ;
    public final BehaviorDescr over_element() throws RecognitionException {
        BehaviorDescr behavior = null;

        DroolsTree id2=null;
        DroolsTree pc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:362:2: ( ^( VT_BEHAVIOR ID id2= ID pc= VT_PAREN_CHUNK ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:362:4: ^( VT_BEHAVIOR ID id2= ID pc= VT_PAREN_CHUNK )
            {
            match(input,VT_BEHAVIOR,FOLLOW_VT_BEHAVIOR_in_over_element2011); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_over_element2013); 
            id2=(DroolsTree)match(input,ID,FOLLOW_ID_in_over_element2017); 
            pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_over_element2021); 

            match(input, Token.UP, null); 
            	behavior = factory.createBehavior(id2,pc);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return behavior;
    }
    // $ANTLR end "over_element"

    public static class fact_expression_return extends TreeRuleReturnScope {
        public BaseDescr descr;
    };

    // $ANTLR start "fact_expression"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:366:1: fact_expression returns [BaseDescr descr] : ( ^( VT_FACT pt= pattern_type (fe= fact_expression )* (attribs= constraint_attributes )? ) | ^( VT_FACT_BINDING label= VT_LABEL fact= fact_expression ) | ^(start= VT_FACT_OR left= fact_expression right= fact_expression ) | ^( VT_FIELD field= field_element (fe= fact_expression )? (attribs= constraint_attributes )? ) | ^( VT_BIND_FIELD label= VT_LABEL fe= fact_expression ) | ^( VK_EVAL pc= VT_PAREN_CHUNK ) | ^(op= EQUAL fe= fact_expression ) | ^(op= NOT_EQUAL fe= fact_expression ) | ^(op= GREATER fe= fact_expression ) | ^(op= GREATER_EQUAL fe= fact_expression ) | ^(op= LESS fe= fact_expression ) | ^(op= LESS_EQUAL fe= fact_expression ) | ^(op= VK_OPERATOR (not= VK_NOT )? (approx= VK_APPROX )? (param= VT_SQUARE_CHUNK )? (attribs= constraint_attributes )? (fe= fact_expression )? ) | ^( VK_IN (not= VK_NOT )? (fe= fact_expression )+ ) | ^( ( DOUBLE_PIPE | SINGLE_PIPE ) (attribs= constraint_attributes )? left= fact_expression right= fact_expression ) | ^( ( DOUBLE_AMPER | SINGLE_AMPER ) (attribs= constraint_attributes )? left= fact_expression right= fact_expression ) | ^( VT_ACCESSOR_PATH (ae= accessor_element )+ ) | s= STRING | i= INT | f= FLOAT | b= BOOL | n= NULL | pc= VT_PAREN_CHUNK );
    public final DescrBuilderTree.fact_expression_return fact_expression() throws RecognitionException {
        DescrBuilderTree.fact_expression_return retval = new DescrBuilderTree.fact_expression_return();
        retval.start = input.LT(1);

        DroolsTree label=null;
        DroolsTree start=null;
        DroolsTree pc=null;
        DroolsTree op=null;
        DroolsTree not=null;
        DroolsTree approx=null;
        DroolsTree param=null;
        DroolsTree s=null;
        DroolsTree i=null;
        DroolsTree f=null;
        DroolsTree b=null;
        DroolsTree n=null;
        BaseDescr pt = null;

        DescrBuilderTree.fact_expression_return fe = null;

        List attribs = null;

        DescrBuilderTree.fact_expression_return fact = null;

        DescrBuilderTree.fact_expression_return left = null;

        DescrBuilderTree.fact_expression_return right = null;

        FieldConstraintDescr field = null;

        BaseDescr ae = null;



        	List<BaseDescr> exprList = new LinkedList<BaseDescr>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:369:3: ( ^( VT_FACT pt= pattern_type (fe= fact_expression )* (attribs= constraint_attributes )? ) | ^( VT_FACT_BINDING label= VT_LABEL fact= fact_expression ) | ^(start= VT_FACT_OR left= fact_expression right= fact_expression ) | ^( VT_FIELD field= field_element (fe= fact_expression )? (attribs= constraint_attributes )? ) | ^( VT_BIND_FIELD label= VT_LABEL fe= fact_expression ) | ^( VK_EVAL pc= VT_PAREN_CHUNK ) | ^(op= EQUAL fe= fact_expression ) | ^(op= NOT_EQUAL fe= fact_expression ) | ^(op= GREATER fe= fact_expression ) | ^(op= GREATER_EQUAL fe= fact_expression ) | ^(op= LESS fe= fact_expression ) | ^(op= LESS_EQUAL fe= fact_expression ) | ^(op= VK_OPERATOR (not= VK_NOT )? (approx= VK_APPROX )? (param= VT_SQUARE_CHUNK )? (attribs= constraint_attributes )? (fe= fact_expression )? ) | ^( VK_IN (not= VK_NOT )? (fe= fact_expression )+ ) | ^( ( DOUBLE_PIPE | SINGLE_PIPE ) (attribs= constraint_attributes )? left= fact_expression right= fact_expression ) | ^( ( DOUBLE_AMPER | SINGLE_AMPER ) (attribs= constraint_attributes )? left= fact_expression right= fact_expression ) | ^( VT_ACCESSOR_PATH (ae= accessor_element )+ ) | s= STRING | i= INT | f= FLOAT | b= BOOL | n= NULL | pc= VT_PAREN_CHUNK )
            int alt70=23;
            switch ( input.LA(1) ) {
            case VT_FACT:
                {
                alt70=1;
                }
                break;
            case VT_FACT_BINDING:
                {
                alt70=2;
                }
                break;
            case VT_FACT_OR:
                {
                alt70=3;
                }
                break;
            case VT_FIELD:
                {
                alt70=4;
                }
                break;
            case VT_BIND_FIELD:
                {
                alt70=5;
                }
                break;
            case VK_EVAL:
                {
                alt70=6;
                }
                break;
            case EQUAL:
                {
                alt70=7;
                }
                break;
            case NOT_EQUAL:
                {
                alt70=8;
                }
                break;
            case GREATER:
                {
                alt70=9;
                }
                break;
            case GREATER_EQUAL:
                {
                alt70=10;
                }
                break;
            case LESS:
                {
                alt70=11;
                }
                break;
            case LESS_EQUAL:
                {
                alt70=12;
                }
                break;
            case VK_OPERATOR:
                {
                alt70=13;
                }
                break;
            case VK_IN:
                {
                alt70=14;
                }
                break;
            case DOUBLE_PIPE:
            case SINGLE_PIPE:
                {
                alt70=15;
                }
                break;
            case DOUBLE_AMPER:
            case SINGLE_AMPER:
                {
                alt70=16;
                }
                break;
            case VT_ACCESSOR_PATH:
                {
                alt70=17;
                }
                break;
            case STRING:
                {
                alt70=18;
                }
                break;
            case INT:
                {
                alt70=19;
                }
                break;
            case FLOAT:
                {
                alt70=20;
                }
                break;
            case BOOL:
                {
                alt70=21;
                }
                break;
            case NULL:
                {
                alt70=22;
                }
                break;
            case VT_PAREN_CHUNK:
                {
                alt70=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:369:5: ^( VT_FACT pt= pattern_type (fe= fact_expression )* (attribs= constraint_attributes )? )
                    {
                    match(input,VT_FACT,FOLLOW_VT_FACT_in_fact_expression2044); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_pattern_type_in_fact_expression2048);
                    pt=pattern_type();

                    state._fsp--;

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:369:31: (fe= fact_expression )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==VT_FACT||LA56_0==VT_PAREN_CHUNK||(LA56_0>=VT_FACT_BINDING && LA56_0<=VT_ACCESSOR_PATH)||LA56_0==VK_EVAL||LA56_0==VK_IN||LA56_0==VK_OPERATOR||LA56_0==STRING||(LA56_0>=BOOL && LA56_0<=DOUBLE_AMPER)||(LA56_0>=SINGLE_PIPE && LA56_0<=SINGLE_AMPER)||(LA56_0>=EQUAL && LA56_0<=NULL)) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:369:32: fe= fact_expression
                    	    {
                    	    pushFollow(FOLLOW_fact_expression_in_fact_expression2053);
                    	    fe=fact_expression();

                    	    state._fsp--;

                    	    exprList.add((fe!=null?fe.descr:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:369:87: (attribs= constraint_attributes )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:369:87: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_fact_expression2061);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    	retval.descr = factory.createPattern(pt, exprList, attribs);	

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:371:4: ^( VT_FACT_BINDING label= VT_LABEL fact= fact_expression )
                    {
                    match(input,VT_FACT_BINDING,FOLLOW_VT_FACT_BINDING_in_fact_expression2072); 

                    match(input, Token.DOWN, null); 
                    label=(DroolsTree)match(input,VT_LABEL,FOLLOW_VT_LABEL_in_fact_expression2076); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2080);
                    fact=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupPatternBiding(label, (fact!=null?fact.descr:null));	

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:373:4: ^(start= VT_FACT_OR left= fact_expression right= fact_expression )
                    {
                    start=(DroolsTree)match(input,VT_FACT_OR,FOLLOW_VT_FACT_OR_in_fact_expression2093); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2097);
                    left=fact_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_fact_expression_in_fact_expression2101);
                    right=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.createFactOr(start, (left!=null?left.descr:null), (right!=null?right.descr:null));	

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:376:4: ^( VT_FIELD field= field_element (fe= fact_expression )? (attribs= constraint_attributes )? )
                    {
                    match(input,VT_FIELD,FOLLOW_VT_FIELD_in_fact_expression2113); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_field_element_in_fact_expression2117);
                    field=field_element();

                    state._fsp--;

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:376:37: (fe= fact_expression )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==VT_FACT||LA58_0==VT_PAREN_CHUNK||(LA58_0>=VT_FACT_BINDING && LA58_0<=VT_ACCESSOR_PATH)||LA58_0==VK_EVAL||LA58_0==VK_IN||LA58_0==VK_OPERATOR||LA58_0==STRING||(LA58_0>=BOOL && LA58_0<=DOUBLE_AMPER)||(LA58_0>=SINGLE_PIPE && LA58_0<=SINGLE_AMPER)||(LA58_0>=EQUAL && LA58_0<=NULL)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:376:37: fe= fact_expression
                            {
                            pushFollow(FOLLOW_fact_expression_in_fact_expression2121);
                            fe=fact_expression();

                            state._fsp--;


                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:376:62: (attribs= constraint_attributes )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:376:62: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_fact_expression2126);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    	if (null != fe){
                    			retval.descr = factory.setupFieldConstraint(field, (fe!=null?fe.descr:null), attribs);
                    		} else {
                    			retval.descr = factory.setupFieldConstraint(field, null, attribs);
                    		}	

                    }
                    break;
                case 5 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:382:4: ^( VT_BIND_FIELD label= VT_LABEL fe= fact_expression )
                    {
                    match(input,VT_BIND_FIELD,FOLLOW_VT_BIND_FIELD_in_fact_expression2137); 

                    match(input, Token.DOWN, null); 
                    label=(DroolsTree)match(input,VT_LABEL,FOLLOW_VT_LABEL_in_fact_expression2141); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2145);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.createFieldBinding(label, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 6 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:385:4: ^( VK_EVAL pc= VT_PAREN_CHUNK )
                    {
                    match(input,VK_EVAL,FOLLOW_VK_EVAL_in_fact_expression2156); 

                    match(input, Token.DOWN, null); 
                    pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_fact_expression2160); 

                    match(input, Token.UP, null); 
                    	retval.descr = factory.createPredicate(pc);	

                    }
                    break;
                case 7 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:388:4: ^(op= EQUAL fe= fact_expression )
                    {
                    op=(DroolsTree)match(input,EQUAL,FOLLOW_EQUAL_in_fact_expression2174); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2178);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupRestriction(op, null, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 8 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:390:4: ^(op= NOT_EQUAL fe= fact_expression )
                    {
                    op=(DroolsTree)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_fact_expression2190); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2194);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupRestriction(op, null, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 9 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:392:4: ^(op= GREATER fe= fact_expression )
                    {
                    op=(DroolsTree)match(input,GREATER,FOLLOW_GREATER_in_fact_expression2206); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2210);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupRestriction(op, null, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 10 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:394:4: ^(op= GREATER_EQUAL fe= fact_expression )
                    {
                    op=(DroolsTree)match(input,GREATER_EQUAL,FOLLOW_GREATER_EQUAL_in_fact_expression2222); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2226);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupRestriction(op, null, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 11 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:396:4: ^(op= LESS fe= fact_expression )
                    {
                    op=(DroolsTree)match(input,LESS,FOLLOW_LESS_in_fact_expression2238); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2242);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupRestriction(op, null, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 12 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:398:4: ^(op= LESS_EQUAL fe= fact_expression )
                    {
                    op=(DroolsTree)match(input,LESS_EQUAL,FOLLOW_LESS_EQUAL_in_fact_expression2254); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_fact_expression_in_fact_expression2258);
                    fe=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.setupRestriction(op, null, (fe!=null?fe.descr:null));	

                    }
                    break;
                case 13 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:4: ^(op= VK_OPERATOR (not= VK_NOT )? (approx= VK_APPROX )? (param= VT_SQUARE_CHUNK )? (attribs= constraint_attributes )? (fe= fact_expression )? )
                    {
                    op=(DroolsTree)match(input,VK_OPERATOR,FOLLOW_VK_OPERATOR_in_fact_expression2270); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:24: (not= VK_NOT )?
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==VK_NOT) ) {
                            alt60=1;
                        }
                        switch (alt60) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:24: not= VK_NOT
                                {
                                not=(DroolsTree)match(input,VK_NOT,FOLLOW_VK_NOT_in_fact_expression2274); 

                                }
                                break;

                        }

                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:39: (approx= VK_APPROX )?
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==VK_APPROX) ) {
                            alt61=1;
                        }
                        switch (alt61) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:39: approx= VK_APPROX
                                {
                                approx=(DroolsTree)match(input,VK_APPROX,FOLLOW_VK_APPROX_in_fact_expression2279); 

                                }
                                break;

                        }

                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:56: (param= VT_SQUARE_CHUNK )?
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==VT_SQUARE_CHUNK) ) {
                            alt62=1;
                        }
                        switch (alt62) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:56: param= VT_SQUARE_CHUNK
                                {
                                param=(DroolsTree)match(input,VT_SQUARE_CHUNK,FOLLOW_VT_SQUARE_CHUNK_in_fact_expression2284); 

                                }
                                break;

                        }

                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:81: (attribs= constraint_attributes )?
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==VT_CONSTR_ATTRIBUTES) ) {
                            alt63=1;
                        }
                        switch (alt63) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:81: attribs= constraint_attributes
                                {
                                pushFollow(FOLLOW_constraint_attributes_in_fact_expression2289);
                                attribs=constraint_attributes();

                                state._fsp--;


                                }
                                break;

                        }

                        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:107: (fe= fact_expression )?
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==VT_FACT||LA64_0==VT_PAREN_CHUNK||(LA64_0>=VT_FACT_BINDING && LA64_0<=VT_ACCESSOR_PATH)||LA64_0==VK_EVAL||LA64_0==VK_IN||LA64_0==VK_OPERATOR||LA64_0==STRING||(LA64_0>=BOOL && LA64_0<=DOUBLE_AMPER)||(LA64_0>=SINGLE_PIPE && LA64_0<=SINGLE_AMPER)||(LA64_0>=EQUAL && LA64_0<=NULL)) ) {
                            alt64=1;
                        }
                        switch (alt64) {
                            case 1 :
                                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:400:107: fe= fact_expression
                                {
                                pushFollow(FOLLOW_fact_expression_in_fact_expression2294);
                                fe=fact_expression();

                                state._fsp--;


                                }
                                break;

                        }


                        match(input, Token.UP, null); 
                    }
                    	retval.descr = factory.setupRestriction(op, not, (fe == null ? null : (fe!=null?fe.descr:null)), param, attribs);	

                    }
                    break;
                case 14 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:404:4: ^( VK_IN (not= VK_NOT )? (fe= fact_expression )+ )
                    {
                    match(input,VK_IN,FOLLOW_VK_IN_in_fact_expression2309); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:404:15: (not= VK_NOT )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==VK_NOT) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:404:15: not= VK_NOT
                            {
                            not=(DroolsTree)match(input,VK_NOT,FOLLOW_VK_NOT_in_fact_expression2313); 

                            }
                            break;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:404:24: (fe= fact_expression )+
                    int cnt66=0;
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==VT_FACT||LA66_0==VT_PAREN_CHUNK||(LA66_0>=VT_FACT_BINDING && LA66_0<=VT_ACCESSOR_PATH)||LA66_0==VK_EVAL||LA66_0==VK_IN||LA66_0==VK_OPERATOR||LA66_0==STRING||(LA66_0>=BOOL && LA66_0<=DOUBLE_AMPER)||(LA66_0>=SINGLE_PIPE && LA66_0<=SINGLE_AMPER)||(LA66_0>=EQUAL && LA66_0<=NULL)) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:404:25: fe= fact_expression
                    	    {
                    	    pushFollow(FOLLOW_fact_expression_in_fact_expression2319);
                    	    fe=fact_expression();

                    	    state._fsp--;

                    	    exprList.add((fe!=null?fe.descr:null));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt66 >= 1 ) break loop66;
                                EarlyExitException eee =
                                    new EarlyExitException(66, input);
                                throw eee;
                        }
                        cnt66++;
                    } while (true);


                    match(input, Token.UP, null); 
                    	retval.descr = factory.createRestrictionConnective(not, exprList);	

                    }
                    break;
                case 15 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:407:4: ^( ( DOUBLE_PIPE | SINGLE_PIPE ) (attribs= constraint_attributes )? left= fact_expression right= fact_expression )
                    {
                    if ( input.LA(1)==DOUBLE_PIPE||input.LA(1)==SINGLE_PIPE ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:407:42: (attribs= constraint_attributes )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:407:42: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_fact_expression2345);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fact_expression_in_fact_expression2350);
                    left=fact_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_fact_expression_in_fact_expression2354);
                    right=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.createOrRestrictionConnective((left!=null?left.descr:null), (right!=null?right.descr:null), attribs); 

                    }
                    break;
                case 16 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:410:4: ^( ( DOUBLE_AMPER | SINGLE_AMPER ) (attribs= constraint_attributes )? left= fact_expression right= fact_expression )
                    {
                    if ( input.LA(1)==DOUBLE_AMPER||input.LA(1)==SINGLE_AMPER ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:410:43: (attribs= constraint_attributes )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==VT_CONSTR_ATTRIBUTES) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:410:43: attribs= constraint_attributes
                            {
                            pushFollow(FOLLOW_constraint_attributes_in_fact_expression2380);
                            attribs=constraint_attributes();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fact_expression_in_fact_expression2385);
                    left=fact_expression();

                    state._fsp--;

                    pushFollow(FOLLOW_fact_expression_in_fact_expression2389);
                    right=fact_expression();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    	retval.descr = factory.createAndRestrictionConnective((left!=null?left.descr:null), (right!=null?right.descr:null), attribs); 
                    		
                    	

                    }
                    break;
                case 17 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:415:4: ^( VT_ACCESSOR_PATH (ae= accessor_element )+ )
                    {
                    match(input,VT_ACCESSOR_PATH,FOLLOW_VT_ACCESSOR_PATH_in_fact_expression2402); 

                    match(input, Token.DOWN, null); 
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:415:23: (ae= accessor_element )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==VT_ACCESSOR_ELEMENT) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:415:24: ae= accessor_element
                    	    {
                    	    pushFollow(FOLLOW_accessor_element_in_fact_expression2407);
                    	    ae=accessor_element();

                    	    state._fsp--;

                    	    exprList.add(ae);

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
                    	retval.descr = factory.createAccessorPath(exprList);	

                    }
                    break;
                case 18 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:417:4: s= STRING
                    {
                    s=(DroolsTree)match(input,STRING,FOLLOW_STRING_in_fact_expression2422); 
                    	retval.descr = factory.createStringLiteralRestriction(s);	

                    }
                    break;
                case 19 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:419:4: i= INT
                    {
                    i=(DroolsTree)match(input,INT,FOLLOW_INT_in_fact_expression2432); 
                    	retval.descr = factory.createIntLiteralRestriction(i);	

                    }
                    break;
                case 20 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:421:4: f= FLOAT
                    {
                    f=(DroolsTree)match(input,FLOAT,FOLLOW_FLOAT_in_fact_expression2443); 
                    	retval.descr = factory.createFloatLiteralRestriction(f);	

                    }
                    break;
                case 21 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:423:4: b= BOOL
                    {
                    b=(DroolsTree)match(input,BOOL,FOLLOW_BOOL_in_fact_expression2453); 
                    	retval.descr = factory.createBoolLiteralRestriction(b);	

                    }
                    break;
                case 22 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:425:4: n= NULL
                    {
                    n=(DroolsTree)match(input,NULL,FOLLOW_NULL_in_fact_expression2463); 
                    	retval.descr = factory.createNullLiteralRestriction(n);	

                    }
                    break;
                case 23 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:427:4: pc= VT_PAREN_CHUNK
                    {
                    pc=(DroolsTree)match(input,VT_PAREN_CHUNK,FOLLOW_VT_PAREN_CHUNK_in_fact_expression2473); 
                    	retval.descr = factory.createReturnValue(pc);	

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
        return retval;
    }
    // $ANTLR end "fact_expression"


    // $ANTLR start "field_element"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:431:1: field_element returns [FieldConstraintDescr element] : ^( VT_ACCESSOR_PATH (ae= accessor_element )+ ) ;
    public final FieldConstraintDescr field_element() throws RecognitionException {
        FieldConstraintDescr element = null;

        BaseDescr ae = null;



        	List<BaseDescr> aeList = new LinkedList<BaseDescr>();

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:434:3: ( ^( VT_ACCESSOR_PATH (ae= accessor_element )+ ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:434:5: ^( VT_ACCESSOR_PATH (ae= accessor_element )+ )
            {
            match(input,VT_ACCESSOR_PATH,FOLLOW_VT_ACCESSOR_PATH_in_field_element2495); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:434:24: (ae= accessor_element )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==VT_ACCESSOR_ELEMENT) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:434:25: ae= accessor_element
            	    {
            	    pushFollow(FOLLOW_accessor_element_in_field_element2500);
            	    ae=accessor_element();

            	    state._fsp--;

            	    aeList.add(ae);

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
            	element = factory.createFieldConstraint(aeList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "field_element"


    // $ANTLR start "accessor_element"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:438:1: accessor_element returns [BaseDescr element] : ^( VT_ACCESSOR_ELEMENT id= ID (sc+= VT_SQUARE_CHUNK )* ) ;
    public final BaseDescr accessor_element() throws RecognitionException {
        BaseDescr element = null;

        DroolsTree id=null;
        DroolsTree sc=null;
        List list_sc=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:439:2: ( ^( VT_ACCESSOR_ELEMENT id= ID (sc+= VT_SQUARE_CHUNK )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:439:4: ^( VT_ACCESSOR_ELEMENT id= ID (sc+= VT_SQUARE_CHUNK )* )
            {
            match(input,VT_ACCESSOR_ELEMENT,FOLLOW_VT_ACCESSOR_ELEMENT_in_accessor_element2524); 

            match(input, Token.DOWN, null); 
            id=(DroolsTree)match(input,ID,FOLLOW_ID_in_accessor_element2528); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:439:34: (sc+= VT_SQUARE_CHUNK )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==VT_SQUARE_CHUNK) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:439:34: sc+= VT_SQUARE_CHUNK
            	    {
            	    sc=(DroolsTree)match(input,VT_SQUARE_CHUNK,FOLLOW_VT_SQUARE_CHUNK_in_accessor_element2532); 
            	    if (list_sc==null) list_sc=new ArrayList();
            	    list_sc.add(sc);


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            match(input, Token.UP, null); 
            	element = factory.createAccessorElement(id, list_sc);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return element;
    }
    // $ANTLR end "accessor_element"


    // $ANTLR start "pattern_type"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:443:1: pattern_type returns [BaseDescr dataType] : ^( VT_PATTERN_TYPE (idList+= ID )+ ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* ) ;
    public final BaseDescr pattern_type() throws RecognitionException {
        BaseDescr dataType = null;

        DroolsTree idList=null;
        DroolsTree rightList=null;
        List list_idList=null;
        List list_rightList=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:444:2: ( ^( VT_PATTERN_TYPE (idList+= ID )+ ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:444:4: ^( VT_PATTERN_TYPE (idList+= ID )+ ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* )
            {
            match(input,VT_PATTERN_TYPE,FOLLOW_VT_PATTERN_TYPE_in_pattern_type2553); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:444:28: (idList+= ID )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==ID) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:444:28: idList+= ID
            	    {
            	    idList=(DroolsTree)match(input,ID,FOLLOW_ID_in_pattern_type2557); 
            	    if (list_idList==null) list_idList=new ArrayList();
            	    list_idList.add(idList);


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

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:444:34: ( LEFT_SQUARE rightList+= RIGHT_SQUARE )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==LEFT_SQUARE) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:444:35: LEFT_SQUARE rightList+= RIGHT_SQUARE
            	    {
            	    match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_pattern_type2561); 
            	    rightList=(DroolsTree)match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_pattern_type2565); 
            	    if (list_rightList==null) list_rightList=new ArrayList();
            	    list_rightList.add(rightList);


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            match(input, Token.UP, null); 
            	dataType = factory.createDataType(list_idList, list_rightList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return dataType;
    }
    // $ANTLR end "pattern_type"


    // $ANTLR start "data_type"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:448:1: data_type returns [BaseDescr dataType] : ^( VT_DATA_TYPE (idList+= ID )+ ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* ) ;
    public final BaseDescr data_type() throws RecognitionException {
        BaseDescr dataType = null;

        DroolsTree idList=null;
        DroolsTree rightList=null;
        List list_idList=null;
        List list_rightList=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:449:2: ( ^( VT_DATA_TYPE (idList+= ID )+ ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:449:4: ^( VT_DATA_TYPE (idList+= ID )+ ( LEFT_SQUARE rightList+= RIGHT_SQUARE )* )
            {
            match(input,VT_DATA_TYPE,FOLLOW_VT_DATA_TYPE_in_data_type2587); 

            match(input, Token.DOWN, null); 
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:449:25: (idList+= ID )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==ID) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:449:25: idList+= ID
            	    {
            	    idList=(DroolsTree)match(input,ID,FOLLOW_ID_in_data_type2591); 
            	    if (list_idList==null) list_idList=new ArrayList();
            	    list_idList.add(idList);


            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:449:31: ( LEFT_SQUARE rightList+= RIGHT_SQUARE )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==LEFT_SQUARE) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:449:32: LEFT_SQUARE rightList+= RIGHT_SQUARE
            	    {
            	    match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_data_type2595); 
            	    rightList=(DroolsTree)match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_data_type2599); 
            	    if (list_rightList==null) list_rightList=new ArrayList();
            	    list_rightList.add(rightList);


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            match(input, Token.UP, null); 
            	dataType = factory.createDataType(list_idList, list_rightList);	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return dataType;
    }
    // $ANTLR end "data_type"


    // $ANTLR start "cut"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:453:1: cut returns [boolean isCutter] : ^(start= VT_CUT VK_CUT ) ;
    public final boolean cut() throws RecognitionException {
        boolean isCutter = false;

        DroolsTree start=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:454:3: ( ^(start= VT_CUT VK_CUT ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:454:5: ^(start= VT_CUT VK_CUT )
            {
            start=(DroolsTree)match(input,VT_CUT,FOLLOW_VT_CUT_in_cut2627); 

            match(input, Token.DOWN, null); 
            match(input,VK_CUT,FOLLOW_VK_CUT_in_cut2629); 

            match(input, Token.UP, null); 
             isCutter = true; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return isCutter;
    }
    // $ANTLR end "cut"


    // $ANTLR start "constr_identifier"
    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:458:1: constr_identifier returns [String id] : ^(start= VT_CONSTRID ans= VK_AT ) ;
    public final String constr_identifier() throws RecognitionException {
        String id = null;

        DroolsTree start=null;
        DroolsTree ans=null;

        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:459:3: ( ^(start= VT_CONSTRID ans= VK_AT ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DescrBuilderTree.g:459:5: ^(start= VT_CONSTRID ans= VK_AT )
            {
            start=(DroolsTree)match(input,VT_CONSTRID,FOLLOW_VT_CONSTRID_in_constr_identifier2657); 

            match(input, Token.DOWN, null); 
            ans=(DroolsTree)match(input,VK_AT,FOLLOW_VK_AT_in_constr_identifier2661); 

            match(input, Token.UP, null); 
             id = (ans!=null?ans.getText():null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "constr_identifier"

    // Delegated rules


 

    public static final BitSet FOLLOW_VT_COMPILATION_UNIT_in_compilation_unit49 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_package_statement_in_compilation_unit51 = new BitSet(new long[]{0xFFC0000000000028L,0x0000000E00000FABL});
    public static final BitSet FOLLOW_statement_in_compilation_unit53 = new BitSet(new long[]{0xFFC0000000000028L,0x0000000E00000FABL});
    public static final BitSet FOLLOW_VK_PACKAGE_in_package_statement72 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_package_id_in_package_statement76 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_PACKAGE_ID_in_package_id103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_package_id107 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_rule_attribute_in_statement125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_import_statement_in_statement135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_statement_in_statement145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_in_statement156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_statement166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_template_in_statement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_statement186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_statement196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_declaration_in_statement206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VK_IMPORT_in_import_statement227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_import_name_in_import_statement231 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FUNCTION_IMPORT_in_function_import_statement253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_FUNCTION_in_function_import_statement255 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_import_name_in_function_import_statement259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_IMPORT_ID_in_import_name278 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_import_name282 = new BitSet(new long[]{0x0000000000000008L,0x00000A0000000000L});
    public static final BitSet FOLLOW_DOT_STAR_in_import_name287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_GLOBAL_in_global310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_data_type_in_global314 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_VT_GLOBAL_ID_in_global318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_FUNCTION_in_function340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_data_type_in_function344 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_VT_FUNCTION_ID_in_function349 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_parameters_in_function353 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_VT_CURLY_CHUNK_in_function357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_TEMPLATE_in_template382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_TEMPLATE_ID_in_template386 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_template_slot_in_template395 = new BitSet(new long[]{0x0000000000008000L,0x0000000008000000L});
    public static final BitSet FOLLOW_VK_END_in_template403 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_SLOT_in_template_slot423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_data_type_in_template_slot427 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_VT_SLOT_ID_in_template_slot431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_QUERY_in_query453 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_QUERY_ID_in_query457 = new BitSet(new long[]{0x0000400000400000L});
    public static final BitSet FOLLOW_parameters_in_query461 = new BitSet(new long[]{0x0000400000400000L});
    public static final BitSet FOLLOW_lhs_block_in_query466 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_VK_END_in_query470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_RULE_in_rule497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_RULE_ID_in_rule501 = new BitSet(new long[]{0x0000000000030000L,0x0009000000000010L});
    public static final BitSet FOLLOW_VK_EXTEND_in_rule506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_RULE_ID_in_rule510 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_decl_metadata_in_rule520 = new BitSet(new long[]{0x0000000000030000L,0x0009000000000000L});
    public static final BitSet FOLLOW_rule_attributes_in_rule531 = new BitSet(new long[]{0x0000000000020000L,0x0008000000000000L});
    public static final BitSet FOLLOW_when_part_in_rule540 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_VT_RHS_CHUNK_in_rule545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHEN_in_when_part564 = new BitSet(new long[]{0x0000400000400000L});
    public static final BitSet FOLLOW_lhs_block_in_when_part568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VT_RULE_ATTRIBUTES_in_rule_attributes590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_ATTRIBUTES_in_rule_attributes592 = new BitSet(new long[]{0xFFC0000000000000L,0x0000000E00000003L});
    public static final BitSet FOLLOW_rule_attribute_in_rule_attributes598 = new BitSet(new long[]{0xFFC0000000000008L,0x0000000E00000003L});
    public static final BitSet FOLLOW_VT_PARAM_LIST_in_parameters622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_param_definition_in_parameters627 = new BitSet(new long[]{0x0000010000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_data_type_in_param_definition649 = new BitSet(new long[]{0x0000010000000008L,0x0000020000000000L});
    public static final BitSet FOLLOW_argument_in_param_definition654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_argument674 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_argument677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_argument681 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_VK_DECLARE_in_type_declaration707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_TYPE_DECLARE_ID_in_type_declaration711 = new BitSet(new long[]{0x0000000000000000L,0x0001020008000000L});
    public static final BitSet FOLLOW_decl_metadata_in_type_declaration720 = new BitSet(new long[]{0x0000000000000000L,0x0001020008000000L});
    public static final BitSet FOLLOW_decl_field_in_type_declaration733 = new BitSet(new long[]{0x0000000000000000L,0x0000020008000000L});
    public static final BitSet FOLLOW_VK_END_in_type_declaration739 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AT_in_decl_metadata764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_decl_metadata768 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_decl_metadata772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_decl_field800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_decl_field_initialization_in_decl_field804 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_data_type_in_decl_field809 = new BitSet(new long[]{0x0000000000000008L,0x0001000000000000L});
    public static final BitSet FOLLOW_decl_metadata_in_decl_field814 = new BitSet(new long[]{0x0000000000000008L,0x0001000000000000L});
    public static final BitSet FOLLOW_EQUALS_in_decl_field_initialization841 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_decl_field_initialization845 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_SALIENCE_in_rule_attribute868 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_rule_attribute873 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_rule_attribute877 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_NO_LOOP_in_rule_attribute888 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOL_in_rule_attribute892 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_AGENDA_GROUP_in_rule_attribute904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute908 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_DURATION_in_rule_attribute919 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_rule_attribute924 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_rule_attribute928 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_ACTIVATION_GROUP_in_rule_attribute941 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_AUTO_FOCUS_in_rule_attribute955 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOL_in_rule_attribute959 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_DATE_EFFECTIVE_in_rule_attribute970 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute974 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_DATE_EXPIRES_in_rule_attribute984 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute988 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_ENABLED_in_rule_attribute998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOL_in_rule_attribute1003 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_rule_attribute1007 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_RULEFLOW_GROUP_in_rule_attribute1018 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute1022 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_LOCK_ON_ACTIVE_in_rule_attribute1032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BOOL_in_rule_attribute1036 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_DIALECT_in_rule_attribute1046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute1050 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_PRIOR_in_rule_attribute1059 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_rule_attribute1063 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_ENTAIL_in_rule_attribute1072 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute1076 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_FILTER_in_rule_attribute1085 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_rule_attribute1089 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_CONSTR_ATTRIBUTES_in_constraint_attributes1116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constr_attribute_in_constraint_attributes1121 = new BitSet(new long[]{0x0000000000000008L,0x000000E480000000L});
    public static final BitSet FOLLOW_VK_CONSTRID_in_constr_attribute1155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_constr_attribute1159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_ARGS_in_constr_attribute1170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_constr_attribute1174 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_TYPE_in_constr_attribute1186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_constr_attribute1190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_CUT_in_constr_attribute1203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_constr_attribute1207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_PRIOR_in_constr_attribute1220 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_constr_attribute1224 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_AND_IMPLICIT_in_lhs_block1259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_lhs_block1264 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_VT_OR_PREFIX_in_lhs1290 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_lhs1294 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1300 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_VT_OR_INFIX_in_lhs1316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_lhs1320 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1325 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_AND_PREFIX_in_lhs1341 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_lhs1345 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1351 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_VT_AND_INFIX_in_lhs1367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_lhs1371 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1376 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1380 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_EQUIV_in_lhs1396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_lhs1400 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1405 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1409 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_XOR_in_lhs1425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_lhs1429 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1434 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_EXISTS_in_lhs1462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_lhs1466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_NOT_in_lhs1478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_lhs1482 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_HEDGE_in_lhs1497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_lhs1501 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_EVAL_in_lhs1518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_lhs1522 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_FORALL_in_lhs1534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_lhs1539 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_VK_FORANY_in_lhs1558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_lhs1563 = new BitSet(new long[]{0x0000000000000008L,0x0000000060000000L});
    public static final BitSet FOLLOW_VK_SUBJECT_in_lhs1566 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1570 = new BitSet(new long[]{0x0000000000000008L,0x0000000040000000L});
    public static final BitSet FOLLOW_VK_WEIGHT_in_lhs1575 = new BitSet(new long[]{0x000100021F800008L,0x0100000000705000L});
    public static final BitSet FOLLOW_lhs_in_lhs1579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FROM_in_lhs1597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs1601 = new BitSet(new long[]{0x0000000080000000L,0x0C00000000002000L});
    public static final BitSet FOLLOW_from_elements_in_lhs1605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACCUMULATE_in_from_elements1637 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_from_elements1641 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_accumulate_parts_in_from_elements1651 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLLECT_in_from_elements1664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lhs_in_from_elements1668 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_ENTRY_POINT_in_from_elements1680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_ENTRYPOINT_ID_in_from_elements1684 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_from_source_clause_in_from_elements1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accumulate_init_clause_in_accumulate_parts1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accumulate_id_clause_in_accumulate_parts1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VT_ACCUMULATE_INIT_CLAUSE_in_accumulate_init_clause1750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_INIT_in_accumulate_init_clause1759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_clause1763 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_ACTION_in_accumulate_init_clause1771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_clause1775 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_accumulate_init_reverse_clause_in_accumulate_init_clause1784 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_VK_RESULT_in_accumulate_init_clause1791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_clause1795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_REVERSE_in_accumulate_init_reverse_clause1818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_accumulate_init_reverse_clause1822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_ACCUMULATE_ID_CLAUSE_in_accumulate_id_clause1844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_accumulate_id_clause1848 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_accumulate_id_clause1852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FROM_SOURCE_in_from_source_clause1874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_from_source_clause1878 = new BitSet(new long[]{0x0000000100100008L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_from_source_clause1882 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_expression_chain_in_from_source_clause1891 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_EXPRESSION_CHAIN_in_expression_chain1910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_expression_chain1914 = new BitSet(new long[]{0x0000000100180008L});
    public static final BitSet FOLLOW_VT_SQUARE_CHUNK_in_expression_chain1918 = new BitSet(new long[]{0x0000000100100008L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_expression_chain1923 = new BitSet(new long[]{0x0000000100000008L});
    public static final BitSet FOLLOW_expression_chain_in_expression_chain1931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_PATTERN_in_lhs_pattern1950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_lhs_pattern1954 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_over_clause_in_lhs_pattern1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_over_clause1985 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_over_element_in_over_clause1990 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_VT_BEHAVIOR_in_over_element2011 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_over_element2013 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_over_element2017 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_over_element2021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FACT_in_fact_expression2044 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_pattern_type_in_fact_expression2048 = new BitSet(new long[]{0x0002007C00100048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2053 = new BitSet(new long[]{0x0002007C00100048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_constraint_attributes_in_fact_expression2061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FACT_BINDING_in_fact_expression2072 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_LABEL_in_fact_expression2076 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2080 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FACT_OR_in_fact_expression2093 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2097 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2101 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_FIELD_in_fact_expression2113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_element_in_fact_expression2117 = new BitSet(new long[]{0x0002007C00100048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2121 = new BitSet(new long[]{0x0002000000000008L});
    public static final BitSet FOLLOW_constraint_attributes_in_fact_expression2126 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_BIND_FIELD_in_fact_expression2137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_LABEL_in_fact_expression2141 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2145 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_EVAL_in_fact_expression2156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_fact_expression2160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUAL_in_fact_expression2174 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_fact_expression2190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_in_fact_expression2206 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2210 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_EQUAL_in_fact_expression2222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2226 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_in_fact_expression2238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_EQUAL_in_fact_expression2254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_OPERATOR_in_fact_expression2270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_NOT_in_fact_expression2274 = new BitSet(new long[]{0x0002007C00180048L,0xB0F0100104009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_VK_APPROX_in_fact_expression2279 = new BitSet(new long[]{0x0002007C00180048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_VT_SQUARE_CHUNK_in_fact_expression2284 = new BitSet(new long[]{0x0002007C00100048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_constraint_attributes_in_fact_expression2289 = new BitSet(new long[]{0x0000007C00100048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VK_IN_in_fact_expression2309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_NOT_in_fact_expression2313 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2319 = new BitSet(new long[]{0x0000007C00100048L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_set_in_fact_expression2334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_fact_expression2345 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2350 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_fact_expression2370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_attributes_in_fact_expression2380 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2385 = new BitSet(new long[]{0x0000007C00100040L,0xB0F0100004009000L,0x000000000000007FL});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression2389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_ACCESSOR_PATH_in_fact_expression2402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_accessor_element_in_fact_expression2407 = new BitSet(new long[]{0x0000008000000008L});
    public static final BitSet FOLLOW_STRING_in_fact_expression2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_fact_expression2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_fact_expression2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_fact_expression2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_fact_expression2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VT_PAREN_CHUNK_in_fact_expression2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VT_ACCESSOR_PATH_in_field_element2495 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_accessor_element_in_field_element2500 = new BitSet(new long[]{0x0000008000000008L});
    public static final BitSet FOLLOW_VT_ACCESSOR_ELEMENT_in_accessor_element2524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_accessor_element2528 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_VT_SQUARE_CHUNK_in_accessor_element2532 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_VT_PATTERN_TYPE_in_pattern_type2553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_pattern_type2557 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_pattern_type2561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_pattern_type2565 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_VT_DATA_TYPE_in_data_type2587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_data_type2591 = new BitSet(new long[]{0x0000000000000008L,0x0000020000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_data_type2595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_data_type2599 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_VT_CUT_in_cut2627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_CUT_in_cut2629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VT_CONSTRID_in_constr_identifier2657 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VK_AT_in_constr_identifier2661 = new BitSet(new long[]{0x0000000000000008L});

}