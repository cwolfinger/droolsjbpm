// $ANTLR 3.1.1 /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g 2009-05-23 11:52:08

	package org.drools.lang;

	import org.drools.compiler.DroolsParserException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class DRLLexer extends Lexer {
    public static final int VT_ACCESSOR_ELEMENT=40;
    public static final int ACCUMULATE=124;
    public static final int VT_DATA_TYPE=41;
    public static final int DOT_STAR=109;
    public static final int VK_APPROX=98;
    public static final int VK_OPERATOR=92;
    public static final int VT_CONSTRID=48;
    public static final int VK_FUNCTION=75;
    public static final int VK_GLOBAL=76;
    public static final int VK_AND=82;
    public static final int EQUALS=116;
    public static final int SH_STYLE_SINGLE_LINE_COMMENT=151;
    public static final int VK_AUTO_FOCUS=59;
    public static final int VK_SALIENCE=65;
    public static final int EOF=-1;
    public static final int VT_CUT=51;
    public static final int VT_CONSTR_ATTRIBUTES=50;
    public static final int VT_PATTERN_TYPE=42;
    public static final int VT_FUNCTION_IMPORT=5;
    public static final int VT_OR_INFIX=26;
    public static final int DOUBLE_AMPER=121;
    public static final int GREATER=130;
    public static final int EOL=144;
    public static final int VK_EQUIV=83;
    public static final int VK_IMPORT=70;
    public static final int NOT_EQUAL=134;
    public static final int VK_ACTION=89;
    public static final int VT_EQUIV=27;
    public static final int VK_RULE=68;
    public static final int LESS=132;
    public static final int VT_SLOT=15;
    public static final int VK_OR=81;
    public static final int VK_ARGS=104;
    public static final int VT_HEDGE=49;
    public static final int VK_CUT=97;
    public static final int VT_AND_PREFIX=23;
    public static final int VK_AT=102;
    public static final int VK_FILTER=101;
    public static final int NULL=136;
    public static final int BOOL=118;
    public static final int VK_ENTAIL=99;
    public static final int VT_KIND=54;
    public static final int VK_QUERY=73;
    public static final int VK_SUBJECT=95;
    public static final int INT=119;
    public static final int SEMICOLON=106;
    public static final int VK_PRIOR=100;
    public static final int VT_FUNCTION_ID=46;
    public static final int VT_RHS_CHUNK=17;
    public static final int VT_FACT_BINDING=35;
    public static final int CUT=150;
    public static final int VK_RULEFLOW_GROUP=62;
    public static final int VK_ENTRY_POINT=78;
    public static final int SINGLE_AMPER=127;
    public static final int VT_PACKAGE_ID=43;
    public static final int VK_RESULT=91;
    public static final int VT_LABEL=8;
    public static final int WS=145;
    public static final int VK_NO_LOOP=58;
    public static final int LEFT_CURLY=140;
    public static final int VT_FACT=6;
    public static final int VT_PATTERN=34;
    public static final int VK_IN=80;
    public static final int LEFT_PAREN=111;
    public static final int LESS_EQUAL=133;
    public static final int VT_RULE_ID=12;
    public static final int VT_IMPORT_ID=44;
    public static final int MISC=142;
    public static final int FROM=122;
    public static final int VT_XOR=28;
    public static final int COLLECT=125;
    public static final int EscapeSequence=146;
    public static final int VK_ACTIVATION_GROUP=60;
    public static final int VK_ENABLED=66;
    public static final int C_STYLE_SINGLE_LINE_COMMENT=152;
    public static final int VK_END=93;
    public static final int VK_PACKAGE=71;
    public static final int OVER=123;
    public static final int VK_EXTEND=69;
    public static final int RIGHT_SQUARE=138;
    public static final int RIGHT_CURLY=141;
    public static final int SINGLE_PIPE=126;
    public static final int VT_FACT_OR=36;
    public static final int VK_IMPLIES=85;
    public static final int VT_FIELD=38;
    public static final int FLOAT=135;
    public static final int VT_ACCUMULATE_ID_CLAUSE=31;
    public static final int VK_EXISTS=86;
    public static final int VK_FORANY=88;
    public static final int VK_DATE_EXPIRES=56;
    public static final int ID=107;
    public static final int HexDigit=147;
    public static final int VK_EVAL=77;
    public static final int VT_OR_PREFIX=24;
    public static final int VK_WEIGHT=96;
    public static final int APPROX=143;
    public static final int AT=114;
    public static final int DOUBLE_PIPE=120;
    public static final int VT_ARGS=53;
    public static final int RIGHT_PAREN=113;
    public static final int VT_IMPLIES=29;
    public static final int VK_XOR=84;
    public static final int VT_COMPILATION_UNIT=4;
    public static final int THEN=139;
    public static final int VT_EXPRESSION_CHAIN=33;
    public static final int COMMA=112;
    public static final int EQUAL=129;
    public static final int VT_BEHAVIOR=21;
    public static final int VK_CONSTRID=103;
    public static final int VK_DIALECT=64;
    public static final int VT_QUERY_ID=9;
    public static final int DOT=108;
    public static final int VT_PRIOR=52;
    public static final int VT_GLOBAL_ID=45;
    public static final int VK_NOT=79;
    public static final int VT_FROM_SOURCE=32;
    public static final int VK_DECLARE=74;
    public static final int VT_ENTRYPOINT_ID=13;
    public static final int VT_PAREN_CHUNK=20;
    public static final int VT_TYPE_DECLARE_ID=11;
    public static final int VK_REVERSE=90;
    public static final int VK_LOCK_ON_ACTIVE=57;
    public static final int VK_TEMPLATE=72;
    public static final int VK_DURATION=63;
    public static final int VT_RULE_ATTRIBUTES=16;
    public static final int VT_AND_INFIX=25;
    public static final int VT_ACCESSOR_PATH=39;
    public static final int MULTI_LINE_COMMENT=153;
    public static final int VK_FORALL=87;
    public static final int COLON=115;
    public static final int VT_AND_IMPLICIT=22;
    public static final int VT_ACCUMULATE_INIT_CLAUSE=30;
    public static final int VT_CURLY_CHUNK=18;
    public static final int VT_SLOT_ID=14;
    public static final int VK_ATTRIBUTES=67;
    public static final int WHEN=117;
    public static final int UnicodeEscape=148;
    public static final int VT_SQUARE_CHUNK=19;
    public static final int VK_DATE_EFFECTIVE=55;
    public static final int VT_TEMPLATE_ID=10;
    public static final int VT_PARAM_LIST=47;
    public static final int ARROW=128;
    public static final int VT_BIND_FIELD=37;
    public static final int VK_AGENDA_GROUP=61;
    public static final int VT_CONSTRAINTS=7;
    public static final int LEFT_SQUARE=137;
    public static final int GREATER_EQUAL=131;
    public static final int OctalEscape=149;
    public static final int VK_KIND=105;
    public static final int VK_INIT=94;
    public static final int STRING=110;

    	private List<DroolsParserException> errors = new ArrayList<DroolsParserException>();
    	private DroolsParserExceptionFactory errorMessageFactory = new DroolsParserExceptionFactory(null, null);

    	/** The standard method called to automatically emit a token at the
    	 *  outermost lexical rule.  The token object should point into the
    	 *  char buffer start..stop.  If there is a text override in 'text',
    	 *  use that to set the token's text.  Override this method to emit
    	 *  custom Token objects.
    	 */
    	public Token emit() {
    		Token t = new DroolsToken(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);
    		t.setLine(state.tokenStartLine);
    		t.setText(state.text);
    		t.setCharPositionInLine(state.tokenStartCharPositionInLine);
    		emit(t);
    		return t;
    	}

    	public void reportError(RecognitionException ex) {
    		errors.add(errorMessageFactory.createDroolsException(ex));
    	}

    	/** return the raw DroolsParserException errors */
    	public List<DroolsParserException> getErrors() {
    		return errors;
    	}

    	/** Overrided this method to not output mesages */
    	public void emitErrorMessage(String msg) {
    	}


    // delegates
    // delegators

    public DRLLexer() {;} 
    public DRLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DRLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g"; }

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2174:9: ( ( ' ' | '\\t' | '\\f' | EOL )+ )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2174:17: ( ' ' | '\\t' | '\\f' | EOL )+
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2174:17: ( ' ' | '\\t' | '\\f' | EOL )+
            int cnt1=0;
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt1=1;
                    }
                    break;
                case '\t':
                    {
                    alt1=2;
                    }
                    break;
                case '\f':
                    {
                    alt1=3;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2174:19: ' '
            	    {
            	    match(' '); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2175:19: '\\t'
            	    {
            	    match('\t'); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2176:19: '\\f'
            	    {
            	    match('\f'); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2177:19: EOL
            	    {
            	    mEOL(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2183:6: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2184:6: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2184:6: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') && (synpred1_DRL())) {
                    alt2=1;
                }
                else {
                    alt2=2;}
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2184:14: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2185:25: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2186:25: '\\n'
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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2191:2: ( ( '-' )? ( '0' .. '9' )+ )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2191:4: ( '-' )? ( '0' .. '9' )+
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2191:4: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2191:5: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2191:10: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2191:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:2: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:4: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:4: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:5: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:10: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (state.failed) return ;

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

            match('.'); if (state.failed) return ;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:26: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2195:27: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:5: ( ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' ) | ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )* '\\'' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:8: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
                    {
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:8: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:9: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
                    {
                    match('\"'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:13: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:15: EscapeSequence
                    	    {
                    	    mEscapeSequence(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2199:32: ~ ( '\\\\' | '\"' )
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
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2200:8: ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )* '\\'' )
                    {
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2200:8: ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )* '\\'' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2200:9: '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2200:14: ( EscapeSequence | ~ ( '\\\\' | '\\'' ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2200:16: EscapeSequence
                    	    {
                    	    mEscapeSequence(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2200:33: ~ ( '\\\\' | '\\'' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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
                    	    break loop9;
                        }
                    } while (true);

                    match('\''); if (state.failed) return ;

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2204:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2204:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "HexDigit"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2208:5: ( '\\\\' ( 'b' | 'B' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '.' | 'o' | 'x' | 'a' | 'e' | 'c' | 'd' | 'D' | 's' | 'S' | 'w' | 'W' | 'p' | 'A' | 'G' | 'Z' | 'z' | 'Q' | 'E' | '*' | '[' | ']' | '(' | ')' | '$' | '^' | '{' | '}' | '?' | '+' | '-' | '&' | '|' ) | UnicodeEscape | OctalEscape )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\\') ) {
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
                    alt11=1;
                    }
                    break;
                case 'u':
                    {
                    alt11=2;
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
                    alt11=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2208:9: '\\\\' ( 'b' | 'B' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '.' | 'o' | 'x' | 'a' | 'e' | 'c' | 'd' | 'D' | 's' | 'S' | 'w' | 'W' | 'p' | 'A' | 'G' | 'Z' | 'z' | 'Q' | 'E' | '*' | '[' | ']' | '(' | ')' | '$' | '^' | '{' | '}' | '?' | '+' | '-' | '&' | '|' )
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
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2212:9: UnicodeEscape
                    {
                    mUnicodeEscape(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2213:9: OctalEscape
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
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='3')) ) {
                    int LA12_2 = input.LA(3);

                    if ( ((LA12_2>='0' && LA12_2<='7')) ) {
                        int LA12_5 = input.LA(4);

                        if ( ((LA12_5>='0' && LA12_5<='7')) ) {
                            alt12=1;
                        }
                        else {
                            alt12=2;}
                    }
                    else {
                        alt12=3;}
                }
                else if ( ((LA12_1>='4' && LA12_1<='7')) ) {
                    int LA12_3 = input.LA(3);

                    if ( ((LA12_3>='0' && LA12_3<='7')) ) {
                        alt12=2;
                    }
                    else {
                        alt12=3;}
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:14: ( '0' .. '3' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:15: '0' .. '3'
                    {
                    matchRange('0','3'); if (state.failed) return ;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:25: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:26: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:36: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2218:37: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2219:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2219:14: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2219:15: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2219:25: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2219:26: '0' .. '7'
                    {
                    matchRange('0','7'); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2220:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2220:14: ( '0' .. '7' )
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2220:15: '0' .. '7'
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
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2225:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2225:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); if (state.failed) return ;
            match('u'); if (state.failed) return ;
            mHexDigit(); if (state.failed) return ;
            mHexDigit(); if (state.failed) return ;
            mHexDigit(); if (state.failed) return ;
            mHexDigit(); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2229:2: ( ( 'true' | 'false' ) )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2229:4: ( 'true' | 'false' )
            {
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2229:4: ( 'true' | 'false' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='t') ) {
                alt13=1;
            }
            else if ( (LA13_0=='f') ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2229:5: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2229:12: 'false'
                    {
                    match("false"); if (state.failed) return ;


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
    // $ANTLR end "BOOL"

    // $ANTLR start "ACCUMULATE"
    public final void mACCUMULATE() throws RecognitionException {
        try {
            int _type = ACCUMULATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2233:2: ( 'accumulate' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2233:4: 'accumulate'
            {
            match("accumulate"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACCUMULATE"

    // $ANTLR start "COLLECT"
    public final void mCOLLECT() throws RecognitionException {
        try {
            int _type = COLLECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2237:2: ( 'collect' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2237:4: 'collect'
            {
            match("collect"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLLECT"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2241:2: ( 'from' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2241:4: 'from'
            {
            match("from"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2245:2: ( 'null' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2245:4: 'null'
            {
            match("null"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "OVER"
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2249:2: ( 'over' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2249:4: 'over'
            {
            match("over"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OVER"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2253:2: ( 'then' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2253:4: 'then'
            {
            match("then"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "WHEN"
    public final void mWHEN() throws RecognitionException {
        try {
            int _type = WHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2257:2: ( 'when' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2257:4: 'when'
            {
            match("when"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHEN"

    // $ANTLR start "APPROX"
    public final void mAPPROX() throws RecognitionException {
        try {
            int _type = APPROX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2262:3: ( '~' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2262:5: '~'
            {
            match('~'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "APPROX"

    // $ANTLR start "CUT"
    public final void mCUT() throws RecognitionException {
        try {
            int _type = CUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2266:3: ( '!' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2266:5: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CUT"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2270:4: ( '@' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2270:6: '@'
            {
            match('@'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2274:2: ( '=' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2274:4: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2278:2: ( ';' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2278:4: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "DOT_STAR"
    public final void mDOT_STAR() throws RecognitionException {
        try {
            int _type = DOT_STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2282:2: ( '.*' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2282:4: '.*'
            {
            match(".*"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT_STAR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2286:2: ( ':' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2286:4: ':'
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

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2290:2: ( '==' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2290:4: '=='
            {
            match("=="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2294:2: ( '!=' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2294:4: '!='
            {
            match("!="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2298:2: ( '>' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2298:4: '>'
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

    // $ANTLR start "GREATER_EQUAL"
    public final void mGREATER_EQUAL() throws RecognitionException {
        try {
            int _type = GREATER_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2302:2: ( '>=' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2302:4: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_EQUAL"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2306:2: ( '<' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2306:4: '<'
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

    // $ANTLR start "LESS_EQUAL"
    public final void mLESS_EQUAL() throws RecognitionException {
        try {
            int _type = LESS_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2310:2: ( '<=' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2310:4: '<='
            {
            match("<="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_EQUAL"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2314:2: ( '->' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2314:4: '->'
            {
            match("->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2318:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '\\u00c0' .. '\\u00ff' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00c0' .. '\\u00ff' )* | '`' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '\\u00c0' .. '\\u00ff' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00c0' .. '\\u00ff' )+ '`' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='$'||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')||(LA16_0>='\u00C0' && LA16_0<='\u00FF')) ) {
                alt16=1;
            }
            else if ( (LA16_0=='`') ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2318:4: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '\\u00c0' .. '\\u00ff' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00c0' .. '\\u00ff' )*
                    {
                    if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00FF') ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2318:50: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00c0' .. '\\u00ff' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')||(LA14_0>='\u00C0' && LA14_0<='\u00FF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00FF') ) {
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
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2319:4: '`' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '\\u00c0' .. '\\u00ff' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00c0' .. '\\u00ff' )+ '`'
                    {
                    match('`'); if (state.failed) return ;
                    if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00FF') ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2319:54: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '\\u00c0' .. '\\u00ff' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')||(LA15_0>='\u00C0' && LA15_0<='\u00FF')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00FF') ) {
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
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    match('`'); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      	state.text = getText().substring(1, getText().length() - 1);	
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "LEFT_PAREN"
    public final void mLEFT_PAREN() throws RecognitionException {
        try {
            int _type = LEFT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2324:9: ( '(' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2324:11: '('
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
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2328:9: ( ')' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2328:11: ')'
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

    // $ANTLR start "LEFT_SQUARE"
    public final void mLEFT_SQUARE() throws RecognitionException {
        try {
            int _type = LEFT_SQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2332:9: ( '[' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2332:11: '['
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
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2336:9: ( ']' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2336:11: ']'
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

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2340:9: ( '{' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2340:11: '{'
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
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2344:9: ( '}' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2344:11: '}'
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

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2347:7: ( ',' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2347:9: ','
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

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2350:5: ( '.' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2350:7: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOUBLE_AMPER"
    public final void mDOUBLE_AMPER() throws RecognitionException {
        try {
            int _type = DOUBLE_AMPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2354:2: ( '&&' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2354:4: '&&'
            {
            match("&&"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_AMPER"

    // $ANTLR start "DOUBLE_PIPE"
    public final void mDOUBLE_PIPE() throws RecognitionException {
        try {
            int _type = DOUBLE_PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2358:2: ( '||' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2358:4: '||'
            {
            match("||"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_PIPE"

    // $ANTLR start "SINGLE_AMPER"
    public final void mSINGLE_AMPER() throws RecognitionException {
        try {
            int _type = SINGLE_AMPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2362:3: ( '&' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2362:5: '&'
            {
            match('&'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLE_AMPER"

    // $ANTLR start "SINGLE_PIPE"
    public final void mSINGLE_PIPE() throws RecognitionException {
        try {
            int _type = SINGLE_PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2366:3: ( '|' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2366:5: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLE_PIPE"

    // $ANTLR start "SH_STYLE_SINGLE_LINE_COMMENT"
    public final void mSH_STYLE_SINGLE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = SH_STYLE_SINGLE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2370:2: ( '#' ( options {greedy=false; } : . )* EOL )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2370:4: '#' ( options {greedy=false; } : . )* EOL
            {
            match('#'); if (state.failed) return ;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2370:8: ( options {greedy=false; } : . )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\r') ) {
                    alt17=2;
                }
                else if ( (LA17_0=='\n') ) {
                    alt17=2;
                }
                else if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2370:35: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            mEOL(); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               _channel=HIDDEN; setText("//"+getText().substring(1));
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SH_STYLE_SINGLE_LINE_COMMENT"

    // $ANTLR start "C_STYLE_SINGLE_LINE_COMMENT"
    public final void mC_STYLE_SINGLE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = C_STYLE_SINGLE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2376:2: ( '//' ( options {greedy=false; } : . )* EOL )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2376:4: '//' ( options {greedy=false; } : . )* EOL
            {
            match("//"); if (state.failed) return ;

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2376:9: ( options {greedy=false; } : . )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\r') ) {
                    alt18=2;
                }
                else if ( (LA18_0=='\n') ) {
                    alt18=2;
                }
                else if ( ((LA18_0>='\u0000' && LA18_0<='\t')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2376:36: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            mEOL(); if (state.failed) return ;
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
    // $ANTLR end "C_STYLE_SINGLE_LINE_COMMENT"

    // $ANTLR start "MULTI_LINE_COMMENT"
    public final void mMULTI_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTI_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2381:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2381:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2381:9: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='*') ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1=='/') ) {
                        alt19=2;
                    }
                    else if ( ((LA19_1>='\u0000' && LA19_1<='.')||(LA19_1>='0' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<=')')||(LA19_0>='+' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2381:35: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match("*/"); if (state.failed) return ;

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
    // $ANTLR end "MULTI_LINE_COMMENT"

    // $ANTLR start "MISC"
    public final void mMISC() throws RecognitionException {
        try {
            int _type = MISC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2385:7: ( '$' | '%' | '^' | '*' | '_' | '-' | '+' | '?' | '/' | '\\'' | '\\\\' )
            // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:
            {
            if ( (input.LA(1)>='$' && input.LA(1)<='%')||input.LA(1)=='\''||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||input.LA(1)=='?'||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='_') ) {
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
    // $ANTLR end "MISC"

    public void mTokens() throws RecognitionException {
        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:8: ( WS | INT | FLOAT | STRING | BOOL | ACCUMULATE | COLLECT | FROM | NULL | OVER | THEN | WHEN | APPROX | CUT | AT | EQUALS | SEMICOLON | DOT_STAR | COLON | EQUAL | NOT_EQUAL | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | ARROW | ID | LEFT_PAREN | RIGHT_PAREN | LEFT_SQUARE | RIGHT_SQUARE | LEFT_CURLY | RIGHT_CURLY | COMMA | DOT | DOUBLE_AMPER | DOUBLE_PIPE | SINGLE_AMPER | SINGLE_PIPE | SH_STYLE_SINGLE_LINE_COMMENT | C_STYLE_SINGLE_LINE_COMMENT | MULTI_LINE_COMMENT | MISC )
        int alt20=43;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:10: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:13: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 3 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:17: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 4 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:23: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;
            case 5 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:30: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 6 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:35: ACCUMULATE
                {
                mACCUMULATE(); if (state.failed) return ;

                }
                break;
            case 7 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:46: COLLECT
                {
                mCOLLECT(); if (state.failed) return ;

                }
                break;
            case 8 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:54: FROM
                {
                mFROM(); if (state.failed) return ;

                }
                break;
            case 9 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:59: NULL
                {
                mNULL(); if (state.failed) return ;

                }
                break;
            case 10 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:64: OVER
                {
                mOVER(); if (state.failed) return ;

                }
                break;
            case 11 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:69: THEN
                {
                mTHEN(); if (state.failed) return ;

                }
                break;
            case 12 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:74: WHEN
                {
                mWHEN(); if (state.failed) return ;

                }
                break;
            case 13 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:79: APPROX
                {
                mAPPROX(); if (state.failed) return ;

                }
                break;
            case 14 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:86: CUT
                {
                mCUT(); if (state.failed) return ;

                }
                break;
            case 15 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:90: AT
                {
                mAT(); if (state.failed) return ;

                }
                break;
            case 16 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:93: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 17 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:100: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 18 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:110: DOT_STAR
                {
                mDOT_STAR(); if (state.failed) return ;

                }
                break;
            case 19 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:119: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 20 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:125: EQUAL
                {
                mEQUAL(); if (state.failed) return ;

                }
                break;
            case 21 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:131: NOT_EQUAL
                {
                mNOT_EQUAL(); if (state.failed) return ;

                }
                break;
            case 22 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:141: GREATER
                {
                mGREATER(); if (state.failed) return ;

                }
                break;
            case 23 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:149: GREATER_EQUAL
                {
                mGREATER_EQUAL(); if (state.failed) return ;

                }
                break;
            case 24 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:163: LESS
                {
                mLESS(); if (state.failed) return ;

                }
                break;
            case 25 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:168: LESS_EQUAL
                {
                mLESS_EQUAL(); if (state.failed) return ;

                }
                break;
            case 26 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:179: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 27 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:185: ID
                {
                mID(); if (state.failed) return ;

                }
                break;
            case 28 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:188: LEFT_PAREN
                {
                mLEFT_PAREN(); if (state.failed) return ;

                }
                break;
            case 29 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:199: RIGHT_PAREN
                {
                mRIGHT_PAREN(); if (state.failed) return ;

                }
                break;
            case 30 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:211: LEFT_SQUARE
                {
                mLEFT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 31 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:223: RIGHT_SQUARE
                {
                mRIGHT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 32 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:236: LEFT_CURLY
                {
                mLEFT_CURLY(); if (state.failed) return ;

                }
                break;
            case 33 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:247: RIGHT_CURLY
                {
                mRIGHT_CURLY(); if (state.failed) return ;

                }
                break;
            case 34 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:259: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 35 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:265: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 36 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:269: DOUBLE_AMPER
                {
                mDOUBLE_AMPER(); if (state.failed) return ;

                }
                break;
            case 37 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:282: DOUBLE_PIPE
                {
                mDOUBLE_PIPE(); if (state.failed) return ;

                }
                break;
            case 38 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:294: SINGLE_AMPER
                {
                mSINGLE_AMPER(); if (state.failed) return ;

                }
                break;
            case 39 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:307: SINGLE_PIPE
                {
                mSINGLE_PIPE(); if (state.failed) return ;

                }
                break;
            case 40 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:319: SH_STYLE_SINGLE_LINE_COMMENT
                {
                mSH_STYLE_SINGLE_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 41 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:348: C_STYLE_SINGLE_LINE_COMMENT
                {
                mC_STYLE_SINGLE_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 42 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:376: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 43 :
                // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1:395: MISC
                {
                mMISC(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_DRL
    public final void synpred1_DRL_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2184:14: ( '\\r\\n' )
        // /home/davide/Projects/Eclipse_Drools/drools/drools-compiler/src/main/resources/org/drools/lang/DRL.g:2184:16: '\\r\\n'
        {
        match("\r\n"); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_DRL

    public final boolean synpred1_DRL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_DRL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\2\uffff\1\43\1\46\1\uffff\1\43\7\27\1\uffff\1\61\1\uffff\1\63\1"+
        "\uffff\1\65\1\uffff\1\67\1\71\11\uffff\1\73\1\75\1\uffff\1\43\4"+
        "\uffff\11\27\20\uffff\11\27\1\122\1\123\1\27\1\125\2\27\1\130\1"+
        "\131\1\132\2\uffff\1\122\1\uffff\2\27\3\uffff\3\27\1\140\1\27\1"+
        "\uffff\1\27\1\143\1\uffff";
    static final String DFA20_eofS =
        "\144\uffff";
    static final String DFA20_minS =
        "\1\11\1\uffff\1\60\1\56\1\uffff\1\0\1\150\1\141\1\143\1\157\1\165"+
        "\1\166\1\150\1\uffff\1\75\1\uffff\1\75\1\uffff\1\52\1\uffff\2\75"+
        "\11\uffff\1\46\1\174\1\uffff\1\52\4\uffff\1\165\1\145\1\154\1\157"+
        "\1\143\2\154\2\145\20\uffff\1\145\1\156\1\163\1\155\1\165\2\154"+
        "\1\162\1\156\2\60\1\145\1\60\1\155\1\145\3\60\2\uffff\1\60\1\uffff"+
        "\1\165\1\143\3\uffff\1\154\1\164\1\141\1\60\1\164\1\uffff\1\145"+
        "\1\60\1\uffff";
    static final String DFA20_maxS =
        "\1\u00ff\1\uffff\1\76\1\71\1\uffff\1\uffff\2\162\1\143\1\157\1\165"+
        "\1\166\1\150\1\uffff\1\75\1\uffff\1\75\1\uffff\1\52\1\uffff\2\75"+
        "\11\uffff\1\46\1\174\1\uffff\1\57\4\uffff\1\165\1\145\1\154\1\157"+
        "\1\143\2\154\2\145\20\uffff\1\145\1\156\1\163\1\155\1\165\2\154"+
        "\1\162\1\156\2\u00ff\1\145\1\u00ff\1\155\1\145\3\u00ff\2\uffff\1"+
        "\u00ff\1\uffff\1\165\1\143\3\uffff\1\154\1\164\1\141\1\u00ff\1\164"+
        "\1\uffff\1\145\1\u00ff\1\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\10\uffff\1\15\1\uffff\1\17\1\uffff\1\21"+
        "\1\uffff\1\23\2\uffff\2\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\2"+
        "\uffff\1\50\1\uffff\1\53\1\32\1\3\1\2\11\uffff\1\25\1\16\1\24\1"+
        "\20\1\22\1\43\1\27\1\26\1\31\1\30\1\44\1\46\1\45\1\47\1\51\1\52"+
        "\22\uffff\1\5\1\13\1\uffff\1\10\2\uffff\1\11\1\12\1\14\5\uffff\1"+
        "\7\2\uffff\1\6";
    static final String DFA20_specialS =
        "\5\uffff\1\0\136\uffff}>";
    static final String[] DFA20_transitionS = {
            "\2\1\1\uffff\2\1\22\uffff\1\1\1\16\1\4\1\41\1\26\1\43\1\37\1"+
            "\5\1\30\1\31\2\43\1\36\1\2\1\22\1\42\12\3\1\23\1\21\1\25\1\20"+
            "\1\24\1\43\1\17\32\27\1\32\1\43\1\33\1\43\1\26\1\27\1\10\1\27"+
            "\1\11\2\27\1\7\7\27\1\12\1\13\4\27\1\6\2\27\1\14\3\27\1\34\1"+
            "\40\1\35\1\15\101\uffff\100\27",
            "",
            "\12\3\4\uffff\1\44",
            "\1\45\1\uffff\12\3",
            "",
            "\0\4",
            "\1\50\11\uffff\1\47",
            "\1\51\20\uffff\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "\1\60",
            "",
            "\1\62",
            "",
            "\1\64",
            "",
            "\1\66",
            "\1\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\72",
            "\1\74",
            "",
            "\1\77\4\uffff\1\76",
            "",
            "",
            "",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "\1\124",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "\1\126",
            "\1\127",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "",
            "\1\133",
            "\1\134",
            "",
            "",
            "",
            "\1\135",
            "\1\136",
            "\1\137",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
            "\1\141",
            "",
            "\1\142",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27\105\uffff\100"+
            "\27",
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
            return "1:1: Tokens : ( WS | INT | FLOAT | STRING | BOOL | ACCUMULATE | COLLECT | FROM | NULL | OVER | THEN | WHEN | APPROX | CUT | AT | EQUALS | SEMICOLON | DOT_STAR | COLON | EQUAL | NOT_EQUAL | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | ARROW | ID | LEFT_PAREN | RIGHT_PAREN | LEFT_SQUARE | RIGHT_SQUARE | LEFT_CURLY | RIGHT_CURLY | COMMA | DOT | DOUBLE_AMPER | DOUBLE_PIPE | SINGLE_AMPER | SINGLE_PIPE | SH_STYLE_SINGLE_LINE_COMMENT | C_STYLE_SINGLE_LINE_COMMENT | MULTI_LINE_COMMENT | MISC );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_5 = input.LA(1);

                        s = -1;
                        if ( ((LA20_5>='\u0000' && LA20_5<='\uFFFF')) ) {s = 4;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}