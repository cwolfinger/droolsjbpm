// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g 2010-11-27 00:20:02

  package org.drools.lang.iri;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class iriLexer extends Lexer {
    public static final int RIGHT_SQUARE=20;
    public static final int DEC_OCTET=22;
    public static final int IPRIVATE=18;
    public static final int MINUS=11;
    public static final int HEXDIG=21;
    public static final int EOF=-1;
    public static final int ALPHA=8;
    public static final int UCSCHAR=23;
    public static final int COLON=4;
    public static final int AT=13;
    public static final int IUNRESERVED=14;
    public static final int WS=25;
    public static final int EOL=24;
    public static final int SLASH=17;
    public static final int QUESTION_MARK=5;
    public static final int SUB_DELIMS=16;
    public static final int DBL_SLASH=7;
    public static final int PLUS=10;
    public static final int DIGIT=9;
    public static final int DOT=12;
    public static final int LEFT_SQUARE=19;
    public static final int GATE=6;
    public static final int PCT_ENCODED=15;

    // delegates
    // delegators

    public iriLexer() {;} 
    public iriLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public iriLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g"; }

    // $ANTLR start "QUESTION_MARK"
    public final void mQUESTION_MARK() throws RecognitionException {
        try {
            int _type = QUESTION_MARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:180:2: ( '?' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:180:4: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION_MARK"

    // $ANTLR start "GATE"
    public final void mGATE() throws RecognitionException {
        try {
            int _type = GATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:184:2: ( '#' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:184:4: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GATE"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:188:2: ( '+' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:188:4: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:192:2: ( '-' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:192:4: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:196:2: ( '.' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:196:4: '.'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:200:2: ( ':' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:200:4: ':'
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

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:204:2: ( '@' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:204:4: '@'
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

    // $ANTLR start "DBL_SLASH"
    public final void mDBL_SLASH() throws RecognitionException {
        try {
            int _type = DBL_SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:208:2: ( '//' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:208:4: '//'
            {
            match("//"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DBL_SLASH"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:212:2: ( '/' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:212:4: '/'
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
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:216:2: ( '[' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:216:4: '['
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
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:220:2: ( ']' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:220:4: ']'
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

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            int _type = ALPHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:7: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                alt1=1;
            }
            else if ( ((LA1_0>='A' && LA1_0<='Z')) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:9: ( 'a' .. 'z' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:9: ( 'a' .. 'z' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:10: 'a' .. 'z'
                    {
                    matchRange('a','z'); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:22: ( 'A' .. 'Z' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:22: ( 'A' .. 'Z' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:224:23: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); if (state.failed) return ;

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
    // $ANTLR end "ALPHA"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:226:7: ( '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "SUB_DELIMS"
    public final void mSUB_DELIMS() throws RecognitionException {
        try {
            int _type = SUB_DELIMS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:228:12: ( '!' | '$' | '&' | '\\'' | '(' | ')' | '*' | '+' | ',' | ';' | '=' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            {
            if ( input.LA(1)=='!'||input.LA(1)=='$'||(input.LA(1)>='&' && input.LA(1)<=',')||input.LA(1)==';'||input.LA(1)=='=' ) {
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
    // $ANTLR end "SUB_DELIMS"

    // $ANTLR start "PCT_ENCODED"
    public final void mPCT_ENCODED() throws RecognitionException {
        try {
            int _type = PCT_ENCODED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:230:13: ( '%' HEXDIG HEXDIG )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:230:15: '%' HEXDIG HEXDIG
            {
            match('%'); if (state.failed) return ;
            mHEXDIG(); if (state.failed) return ;
            mHEXDIG(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PCT_ENCODED"

    // $ANTLR start "IUNRESERVED"
    public final void mIUNRESERVED() throws RecognitionException {
        try {
            int _type = IUNRESERVED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:233:3: ( '_' | '~' | UCSCHAR )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='_') ) {
                alt2=1;
            }
            else if ( (LA2_0=='~') ) {
                alt2=2;
            }
            else if ( ((LA2_0>='\u00A0' && LA2_0<='\uD7FF')||(LA2_0>='\uF900' && LA2_0<='\uFDCF')||(LA2_0>='\uFDF0' && LA2_0<='\uFFEF')) ) {
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
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:233:5: '_'
                    {
                    match('_'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:233:11: '~'
                    {
                    match('~'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:233:17: UCSCHAR
                    {
                    mUCSCHAR(); if (state.failed) return ;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IUNRESERVED"

    // $ANTLR start "HEXDIG"
    public final void mHEXDIG() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:2: ( DIGIT | ( 'a' .. 'f' ) | ( 'A' .. 'F' ) )
            int alt3=3;
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
                alt3=1;
                }
                break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                {
                alt3=2;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:5: DIGIT
                    {
                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:13: ( 'a' .. 'f' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:13: ( 'a' .. 'f' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:14: 'a' .. 'f'
                    {
                    matchRange('a','f'); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:26: ( 'A' .. 'F' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:26: ( 'A' .. 'F' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:238:27: 'A' .. 'F'
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
    // $ANTLR end "HEXDIG"

    // $ANTLR start "UCSCHAR"
    public final void mUCSCHAR() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:3: ( ( '\\u00a0' .. '\\ud7ff' ) | ( '\\uf900' .. '\\ufdcf' ) | ( '\\ufdf0' .. '\\uffef' ) )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='\u00A0' && LA4_0<='\uD7FF')) ) {
                alt4=1;
            }
            else if ( ((LA4_0>='\uF900' && LA4_0<='\uFDCF')) ) {
                alt4=2;
            }
            else if ( ((LA4_0>='\uFDF0' && LA4_0<='\uFFEF')) ) {
                alt4=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:5: ( '\\u00a0' .. '\\ud7ff' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:5: ( '\\u00a0' .. '\\ud7ff' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:6: '\\u00a0' .. '\\ud7ff'
                    {
                    matchRange('\u00A0','\uD7FF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:28: ( '\\uf900' .. '\\ufdcf' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:28: ( '\\uf900' .. '\\ufdcf' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:29: '\\uf900' .. '\\ufdcf'
                    {
                    matchRange('\uF900','\uFDCF'); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:51: ( '\\ufdf0' .. '\\uffef' )
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:51: ( '\\ufdf0' .. '\\uffef' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:243:52: '\\ufdf0' .. '\\uffef'
                    {
                    matchRange('\uFDF0','\uFFEF'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "UCSCHAR"

    // $ANTLR start "IPRIVATE"
    public final void mIPRIVATE() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:248:3: ( ( '\\ue000' .. '\\uf8ff' ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:248:5: ( '\\ue000' .. '\\uf8ff' )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:248:5: ( '\\ue000' .. '\\uf8ff' )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:248:6: '\\ue000' .. '\\uf8ff'
            {
            matchRange('\uE000','\uF8FF'); if (state.failed) return ;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "IPRIVATE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:285:3: ( ( ' ' | '\\t' | '\\f' | EOL )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:286:3: ( ' ' | '\\t' | '\\f' | EOL )+
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:286:3: ( ' ' | '\\t' | '\\f' | EOL )+
            int cnt5=0;
            loop5:
            do {
                int alt5=5;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt5=1;
                    }
                    break;
                case '\t':
                    {
                    alt5=2;
                    }
                    break;
                case '\f':
                    {
                    alt5=3;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt5=4;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:286:5: ' '
            	    {
            	    match(' '); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:287:5: '\\t'
            	    {
            	    match('\t'); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:288:5: '\\f'
            	    {
            	    match('\f'); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:289:5: EOL
            	    {
            	    mEOL(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:296:3: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:297:3: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:297:3: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') && (synpred1_iri())) {
                    alt6=1;
                }
                else {
                    alt6=2;}
            }
            else if ( (LA6_0=='\n') ) {
                alt6=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:297:5: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:298:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:299:5: '\\n'
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

    // $ANTLR start "DEC_OCTET"
    public final void mDEC_OCTET() throws RecognitionException {
        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:315:2: ( ( '1' .. '9' ) DIGIT | '1' DIGIT DIGIT | '2' ( '0' .. '4' ) DIGIT | '25' ( '0' .. '5' ) )
            int alt7=4;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:315:4: ( '1' .. '9' ) DIGIT
                    {
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:315:4: ( '1' .. '9' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:315:5: '1' .. '9'
                    {
                    matchRange('1','9'); if (state.failed) return ;

                    }

                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:316:4: '1' DIGIT DIGIT
                    {
                    match('1'); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:317:4: '2' ( '0' .. '4' ) DIGIT
                    {
                    match('2'); if (state.failed) return ;
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:317:8: ( '0' .. '4' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:317:9: '0' .. '4'
                    {
                    matchRange('0','4'); if (state.failed) return ;

                    }

                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:318:4: '25' ( '0' .. '5' )
                    {
                    match("25"); if (state.failed) return ;

                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:318:9: ( '0' .. '5' )
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:318:10: '0' .. '5'
                    {
                    matchRange('0','5'); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "DEC_OCTET"

    public void mTokens() throws RecognitionException {
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:8: ( QUESTION_MARK | GATE | PLUS | MINUS | DOT | COLON | AT | DBL_SLASH | SLASH | LEFT_SQUARE | RIGHT_SQUARE | ALPHA | DIGIT | SUB_DELIMS | PCT_ENCODED | IUNRESERVED | WS )
        int alt8=17;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:10: QUESTION_MARK
                {
                mQUESTION_MARK(); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:24: GATE
                {
                mGATE(); if (state.failed) return ;

                }
                break;
            case 3 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:29: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 4 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:34: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 5 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:40: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 6 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:44: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 7 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:50: AT
                {
                mAT(); if (state.failed) return ;

                }
                break;
            case 8 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:53: DBL_SLASH
                {
                mDBL_SLASH(); if (state.failed) return ;

                }
                break;
            case 9 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:63: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 10 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:69: LEFT_SQUARE
                {
                mLEFT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 11 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:81: RIGHT_SQUARE
                {
                mRIGHT_SQUARE(); if (state.failed) return ;

                }
                break;
            case 12 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:94: ALPHA
                {
                mALPHA(); if (state.failed) return ;

                }
                break;
            case 13 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:100: DIGIT
                {
                mDIGIT(); if (state.failed) return ;

                }
                break;
            case 14 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:106: SUB_DELIMS
                {
                mSUB_DELIMS(); if (state.failed) return ;

                }
                break;
            case 15 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:117: PCT_ENCODED
                {
                mPCT_ENCODED(); if (state.failed) return ;

                }
                break;
            case 16 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:129: IUNRESERVED
                {
                mIUNRESERVED(); if (state.failed) return ;

                }
                break;
            case 17 :
                // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:1:141: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_iri
    public final void synpred1_iri_fragment() throws RecognitionException {   
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:297:5: ( '\\r\\n' )
        // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:297:7: '\\r\\n'
        {
        match("\r\n"); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_iri

    public final boolean synpred1_iri() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_iri_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA7_eotS =
        "\4\uffff\3\3\3\uffff";
    static final String DFA7_eofS =
        "\12\uffff";
    static final String DFA7_minS =
        "\1\61\2\60\1\uffff\3\60\3\uffff";
    static final String DFA7_maxS =
        "\3\71\1\uffff\1\71\1\65\1\71\3\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\1\3\uffff\1\2\1\4\1\3";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\2\7\3",
            "\12\4",
            "\5\6\1\5\4\3",
            "",
            "\12\7",
            "\6\10",
            "\12\11",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "313:1: fragment DEC_OCTET : ( ( '1' .. '9' ) DIGIT | '1' DIGIT DIGIT | '2' ( '0' .. '4' ) DIGIT | '25' ( '0' .. '5' ) );";
        }
    }
    static final String DFA8_eotS =
        "\10\uffff\1\23\13\uffff";
    static final String DFA8_eofS =
        "\24\uffff";
    static final String DFA8_minS =
        "\1\11\7\uffff\1\57\13\uffff";
    static final String DFA8_maxS =
        "\1\uffef\7\uffff\1\57\13\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\1\13\1\14\1\15"+
        "\1\16\1\17\1\20\1\21\1\3\1\10\1\11";
    static final String DFA8_specialS =
        "\24\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\20\1\uffff\2\20\22\uffff\1\20\1\15\1\uffff\1\2\1\15\1\16"+
            "\5\15\1\3\1\15\1\4\1\5\1\10\12\14\1\6\1\15\1\uffff\1\15\1\uffff"+
            "\1\1\1\7\32\13\1\11\1\uffff\1\12\1\uffff\1\17\1\uffff\32\13"+
            "\3\uffff\1\17\41\uffff\ud760\17\u2100\uffff\u04d0\17\40\uffff"+
            "\u0200\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22",
            "",
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

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( QUESTION_MARK | GATE | PLUS | MINUS | DOT | COLON | AT | DBL_SLASH | SLASH | LEFT_SQUARE | RIGHT_SQUARE | ALPHA | DIGIT | SUB_DELIMS | PCT_ENCODED | IUNRESERVED | WS );";
        }
    }
 

}