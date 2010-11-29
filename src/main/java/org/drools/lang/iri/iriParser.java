// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g 2010-11-27 00:20:02

  package org.drools.lang.iri;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class iriParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "QUESTION_MARK", "GATE", "DBL_SLASH", "ALPHA", "DIGIT", "PLUS", "MINUS", "DOT", "AT", "IUNRESERVED", "PCT_ENCODED", "SUB_DELIMS", "SLASH", "IPRIVATE", "LEFT_SQUARE", "RIGHT_SQUARE", "HEXDIG", "DEC_OCTET", "UCSCHAR", "EOL", "WS"
    };
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


        public iriParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public iriParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return iriParser.tokenNames; }
    public String getGrammarFileName() { return "/home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g"; }


    public static class iri_reference_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iri_reference"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:16:1: iri_reference : ( iri | irelative_ref );
    public final iriParser.iri_reference_return iri_reference() throws RecognitionException {
        iriParser.iri_reference_return retval = new iriParser.iri_reference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        iriParser.iri_return iri1 = null;

        iriParser.irelative_ref_return irelative_ref2 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:17:3: ( iri | irelative_ref )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:17:5: iri
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_iri_in_iri_reference67);
                    iri1=iri();

                    state._fsp--;

                    adaptor.addChild(root_0, iri1.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:18:5: irelative_ref
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_irelative_ref_in_iri_reference74);
                    irelative_ref2=irelative_ref();

                    state._fsp--;

                    adaptor.addChild(root_0, irelative_ref2.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iri_reference"

    public static class absolute_iri_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "absolute_iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:21:1: absolute_iri : scheme COLON ihier_part ( QUESTION_MARK iquery )? ;
    public final iriParser.absolute_iri_return absolute_iri() throws RecognitionException {
        iriParser.absolute_iri_return retval = new iriParser.absolute_iri_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON4=null;
        Token QUESTION_MARK6=null;
        iriParser.scheme_return scheme3 = null;

        iriParser.ihier_part_return ihier_part5 = null;

        iriParser.iquery_return iquery7 = null;


        Object COLON4_tree=null;
        Object QUESTION_MARK6_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:22:3: ( scheme COLON ihier_part ( QUESTION_MARK iquery )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:22:5: scheme COLON ihier_part ( QUESTION_MARK iquery )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_scheme_in_absolute_iri88);
            scheme3=scheme();

            state._fsp--;

            adaptor.addChild(root_0, scheme3.getTree());
            COLON4=(Token)match(input,COLON,FOLLOW_COLON_in_absolute_iri90); 
            COLON4_tree = (Object)adaptor.create(COLON4);
            adaptor.addChild(root_0, COLON4_tree);

            pushFollow(FOLLOW_ihier_part_in_absolute_iri92);
            ihier_part5=ihier_part();

            state._fsp--;

            adaptor.addChild(root_0, ihier_part5.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:23:5: ( QUESTION_MARK iquery )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QUESTION_MARK) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:23:6: QUESTION_MARK iquery
                    {
                    QUESTION_MARK6=(Token)match(input,QUESTION_MARK,FOLLOW_QUESTION_MARK_in_absolute_iri100); 
                    QUESTION_MARK6_tree = (Object)adaptor.create(QUESTION_MARK6);
                    adaptor.addChild(root_0, QUESTION_MARK6_tree);

                    pushFollow(FOLLOW_iquery_in_absolute_iri102);
                    iquery7=iquery();

                    state._fsp--;

                    adaptor.addChild(root_0, iquery7.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "absolute_iri"

    public static class iri_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iri"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:27:1: iri : scheme COLON ihier_part ( QUESTION_MARK iquery )? ( GATE ifragment )? ;
    public final iriParser.iri_return iri() throws RecognitionException {
        iriParser.iri_return retval = new iriParser.iri_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON9=null;
        Token QUESTION_MARK11=null;
        Token GATE13=null;
        iriParser.scheme_return scheme8 = null;

        iriParser.ihier_part_return ihier_part10 = null;

        iriParser.iquery_return iquery12 = null;

        iriParser.ifragment_return ifragment14 = null;


        Object COLON9_tree=null;
        Object QUESTION_MARK11_tree=null;
        Object GATE13_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:28:3: ( scheme COLON ihier_part ( QUESTION_MARK iquery )? ( GATE ifragment )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:28:5: scheme COLON ihier_part ( QUESTION_MARK iquery )? ( GATE ifragment )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_scheme_in_iri121);
            scheme8=scheme();

            state._fsp--;

            adaptor.addChild(root_0, scheme8.getTree());
            COLON9=(Token)match(input,COLON,FOLLOW_COLON_in_iri123); 
            COLON9_tree = (Object)adaptor.create(COLON9);
            adaptor.addChild(root_0, COLON9_tree);

            pushFollow(FOLLOW_ihier_part_in_iri125);
            ihier_part10=ihier_part();

            state._fsp--;

            adaptor.addChild(root_0, ihier_part10.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:29:5: ( QUESTION_MARK iquery )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUESTION_MARK) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:29:6: QUESTION_MARK iquery
                    {
                    QUESTION_MARK11=(Token)match(input,QUESTION_MARK,FOLLOW_QUESTION_MARK_in_iri133); 
                    QUESTION_MARK11_tree = (Object)adaptor.create(QUESTION_MARK11);
                    adaptor.addChild(root_0, QUESTION_MARK11_tree);

                    pushFollow(FOLLOW_iquery_in_iri135);
                    iquery12=iquery();

                    state._fsp--;

                    adaptor.addChild(root_0, iquery12.getTree());

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:30:5: ( GATE ifragment )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GATE) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:30:6: GATE ifragment
                    {
                    GATE13=(Token)match(input,GATE,FOLLOW_GATE_in_iri146); 
                    GATE13_tree = (Object)adaptor.create(GATE13);
                    adaptor.addChild(root_0, GATE13_tree);

                    pushFollow(FOLLOW_ifragment_in_iri148);
                    ifragment14=ifragment();

                    state._fsp--;

                    adaptor.addChild(root_0, ifragment14.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iri"

    public static class irelative_ref_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "irelative_ref"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:34:1: irelative_ref : irelative_part ( QUESTION_MARK iquery )? ( GATE ifragment )? ;
    public final iriParser.irelative_ref_return irelative_ref() throws RecognitionException {
        iriParser.irelative_ref_return retval = new iriParser.irelative_ref_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUESTION_MARK16=null;
        Token GATE18=null;
        iriParser.irelative_part_return irelative_part15 = null;

        iriParser.iquery_return iquery17 = null;

        iriParser.ifragment_return ifragment19 = null;


        Object QUESTION_MARK16_tree=null;
        Object GATE18_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:35:3: ( irelative_part ( QUESTION_MARK iquery )? ( GATE ifragment )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:35:5: irelative_part ( QUESTION_MARK iquery )? ( GATE ifragment )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_irelative_part_in_irelative_ref165);
            irelative_part15=irelative_part();

            state._fsp--;

            adaptor.addChild(root_0, irelative_part15.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:36:5: ( QUESTION_MARK iquery )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==QUESTION_MARK) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:36:6: QUESTION_MARK iquery
                    {
                    QUESTION_MARK16=(Token)match(input,QUESTION_MARK,FOLLOW_QUESTION_MARK_in_irelative_ref173); 
                    QUESTION_MARK16_tree = (Object)adaptor.create(QUESTION_MARK16);
                    adaptor.addChild(root_0, QUESTION_MARK16_tree);

                    pushFollow(FOLLOW_iquery_in_irelative_ref175);
                    iquery17=iquery();

                    state._fsp--;

                    adaptor.addChild(root_0, iquery17.getTree());

                    }
                    break;

            }

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:37:5: ( GATE ifragment )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==GATE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:37:6: GATE ifragment
                    {
                    GATE18=(Token)match(input,GATE,FOLLOW_GATE_in_irelative_ref184); 
                    GATE18_tree = (Object)adaptor.create(GATE18);
                    adaptor.addChild(root_0, GATE18_tree);

                    pushFollow(FOLLOW_ifragment_in_irelative_ref186);
                    ifragment19=ifragment();

                    state._fsp--;

                    adaptor.addChild(root_0, ifragment19.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "irelative_ref"

    public static class ihier_part_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ihier_part"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:42:1: ihier_part : ( DBL_SLASH iauthority ipath_abempty | ipath_absolute | ipath_rootless | );
    public final iriParser.ihier_part_return ihier_part() throws RecognitionException {
        iriParser.ihier_part_return retval = new iriParser.ihier_part_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DBL_SLASH20=null;
        iriParser.iauthority_return iauthority21 = null;

        iriParser.ipath_abempty_return ipath_abempty22 = null;

        iriParser.ipath_absolute_return ipath_absolute23 = null;

        iriParser.ipath_rootless_return ipath_rootless24 = null;


        Object DBL_SLASH20_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:43:3: ( DBL_SLASH iauthority ipath_abempty | ipath_absolute | ipath_rootless | )
            int alt7=4;
            switch ( input.LA(1) ) {
            case DBL_SLASH:
                {
                alt7=1;
                }
                break;
            case SLASH:
                {
                alt7=2;
                }
                break;
            case COLON:
            case ALPHA:
            case DIGIT:
            case MINUS:
            case DOT:
            case AT:
            case IUNRESERVED:
            case PCT_ENCODED:
            case SUB_DELIMS:
                {
                alt7=3;
                }
                break;
            case EOF:
            case QUESTION_MARK:
            case GATE:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:43:5: DBL_SLASH iauthority ipath_abempty
                    {
                    root_0 = (Object)adaptor.nil();

                    DBL_SLASH20=(Token)match(input,DBL_SLASH,FOLLOW_DBL_SLASH_in_ihier_part213); 
                    DBL_SLASH20_tree = (Object)adaptor.create(DBL_SLASH20);
                    adaptor.addChild(root_0, DBL_SLASH20_tree);

                    pushFollow(FOLLOW_iauthority_in_ihier_part215);
                    iauthority21=iauthority();

                    state._fsp--;

                    adaptor.addChild(root_0, iauthority21.getTree());
                    pushFollow(FOLLOW_ipath_abempty_in_ihier_part217);
                    ipath_abempty22=ipath_abempty();

                    state._fsp--;

                    adaptor.addChild(root_0, ipath_abempty22.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:44:5: ipath_absolute
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ipath_absolute_in_ihier_part223);
                    ipath_absolute23=ipath_absolute();

                    state._fsp--;

                    adaptor.addChild(root_0, ipath_absolute23.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:45:5: ipath_rootless
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ipath_rootless_in_ihier_part229);
                    ipath_rootless24=ipath_rootless();

                    state._fsp--;

                    adaptor.addChild(root_0, ipath_rootless24.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:47:3: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ihier_part"

    public static class irelative_part_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "irelative_part"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:49:1: irelative_part : ( DBL_SLASH iauthority ipath_abempty | ipath_absolute | ipath_noscheme | );
    public final iriParser.irelative_part_return irelative_part() throws RecognitionException {
        iriParser.irelative_part_return retval = new iriParser.irelative_part_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DBL_SLASH25=null;
        iriParser.iauthority_return iauthority26 = null;

        iriParser.ipath_abempty_return ipath_abempty27 = null;

        iriParser.ipath_absolute_return ipath_absolute28 = null;

        iriParser.ipath_noscheme_return ipath_noscheme29 = null;


        Object DBL_SLASH25_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:50:3: ( DBL_SLASH iauthority ipath_abempty | ipath_absolute | ipath_noscheme | )
            int alt8=4;
            switch ( input.LA(1) ) {
            case DBL_SLASH:
                {
                alt8=1;
                }
                break;
            case SLASH:
                {
                alt8=2;
                }
                break;
            case ALPHA:
            case DIGIT:
            case MINUS:
            case DOT:
            case AT:
            case IUNRESERVED:
            case PCT_ENCODED:
            case SUB_DELIMS:
                {
                alt8=3;
                }
                break;
            case EOF:
            case QUESTION_MARK:
            case GATE:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:50:5: DBL_SLASH iauthority ipath_abempty
                    {
                    root_0 = (Object)adaptor.nil();

                    DBL_SLASH25=(Token)match(input,DBL_SLASH,FOLLOW_DBL_SLASH_in_irelative_part250); 
                    DBL_SLASH25_tree = (Object)adaptor.create(DBL_SLASH25);
                    adaptor.addChild(root_0, DBL_SLASH25_tree);

                    pushFollow(FOLLOW_iauthority_in_irelative_part252);
                    iauthority26=iauthority();

                    state._fsp--;

                    adaptor.addChild(root_0, iauthority26.getTree());
                    pushFollow(FOLLOW_ipath_abempty_in_irelative_part254);
                    ipath_abempty27=ipath_abempty();

                    state._fsp--;

                    adaptor.addChild(root_0, ipath_abempty27.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:51:5: ipath_absolute
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ipath_absolute_in_irelative_part260);
                    ipath_absolute28=ipath_absolute();

                    state._fsp--;

                    adaptor.addChild(root_0, ipath_absolute28.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:52:5: ipath_noscheme
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ipath_noscheme_in_irelative_part266);
                    ipath_noscheme29=ipath_noscheme();

                    state._fsp--;

                    adaptor.addChild(root_0, ipath_noscheme29.getTree());

                    }
                    break;
                case 4 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:54:3: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "irelative_part"

    public static class scheme_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scheme"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:59:1: scheme : ALPHA ( ALPHA | DIGIT | PLUS | MINUS | DOT )* ;
    public final iriParser.scheme_return scheme() throws RecognitionException {
        iriParser.scheme_return retval = new iriParser.scheme_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ALPHA30=null;
        Token set31=null;

        Object ALPHA30_tree=null;
        Object set31_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:60:2: ( ALPHA ( ALPHA | DIGIT | PLUS | MINUS | DOT )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:60:5: ALPHA ( ALPHA | DIGIT | PLUS | MINUS | DOT )*
            {
            root_0 = (Object)adaptor.nil();

            ALPHA30=(Token)match(input,ALPHA,FOLLOW_ALPHA_in_scheme288); 
            ALPHA30_tree = (Object)adaptor.create(ALPHA30);
            adaptor.addChild(root_0, ALPHA30_tree);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:60:11: ( ALPHA | DIGIT | PLUS | MINUS | DOT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=ALPHA && LA9_0<=DOT)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            	    {
            	    set31=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ALPHA && input.LA(1)<=DOT) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set31));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scheme"

    public static class iauthority_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iauthority"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:69:1: iauthority : ( iuserinfo AT )? ihost ( COLON port )? ;
    public final iriParser.iauthority_return iauthority() throws RecognitionException {
        iriParser.iauthority_return retval = new iriParser.iauthority_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AT33=null;
        Token COLON35=null;
        iriParser.iuserinfo_return iuserinfo32 = null;

        iriParser.ihost_return ihost34 = null;

        iriParser.port_return port36 = null;


        Object AT33_tree=null;
        Object COLON35_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:70:3: ( ( iuserinfo AT )? ihost ( COLON port )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:70:5: ( iuserinfo AT )? ihost ( COLON port )?
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:70:5: ( iuserinfo AT )?
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:70:6: iuserinfo AT
                    {
                    pushFollow(FOLLOW_iuserinfo_in_iauthority339);
                    iuserinfo32=iuserinfo();

                    state._fsp--;

                    adaptor.addChild(root_0, iuserinfo32.getTree());
                    AT33=(Token)match(input,AT,FOLLOW_AT_in_iauthority341); 
                    AT33_tree = (Object)adaptor.create(AT33);
                    adaptor.addChild(root_0, AT33_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_ihost_in_iauthority345);
            ihost34=ihost();

            state._fsp--;

            adaptor.addChild(root_0, ihost34.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:70:27: ( COLON port )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==COLON) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:70:28: COLON port
                    {
                    COLON35=(Token)match(input,COLON,FOLLOW_COLON_in_iauthority348); 
                    COLON35_tree = (Object)adaptor.create(COLON35);
                    adaptor.addChild(root_0, COLON35_tree);

                    pushFollow(FOLLOW_port_in_iauthority350);
                    port36=port();

                    state._fsp--;

                    adaptor.addChild(root_0, port36.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iauthority"

    public static class iuserinfo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iuserinfo"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:73:1: iuserinfo : ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS | COLON )* ;
    public final iriParser.iuserinfo_return iuserinfo() throws RecognitionException {
        iriParser.iuserinfo_return retval = new iriParser.iuserinfo_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set37=null;

        Object set37_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:74:3: ( ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS | COLON )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:74:5: ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS | COLON )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:74:5: ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS | COLON )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COLON||(LA12_0>=ALPHA && LA12_0<=DIGIT)||(LA12_0>=MINUS && LA12_0<=DOT)||(LA12_0>=IUNRESERVED && LA12_0<=SUB_DELIMS)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            	    {
            	    set37=(Token)input.LT(1);
            	    if ( input.LA(1)==COLON||(input.LA(1)>=ALPHA && input.LA(1)<=DIGIT)||(input.LA(1)>=MINUS && input.LA(1)<=DOT)||(input.LA(1)>=IUNRESERVED && input.LA(1)<=SUB_DELIMS) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set37));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iuserinfo"

    public static class ihost_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ihost"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:77:1: ihost : ( ip_literal | ip_v4address | ireg_name );
    public final iriParser.ihost_return ihost() throws RecognitionException {
        iriParser.ihost_return retval = new iriParser.ihost_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        iriParser.ip_literal_return ip_literal38 = null;

        iriParser.ip_v4address_return ip_v4address39 = null;

        iriParser.ireg_name_return ireg_name40 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:78:3: ( ip_literal | ip_v4address | ireg_name )
            int alt13=3;
            switch ( input.LA(1) ) {
            case LEFT_SQUARE:
                {
                alt13=1;
                }
                break;
            case DEC_OCTET:
                {
                alt13=2;
                }
                break;
            case EOF:
            case COLON:
            case QUESTION_MARK:
            case GATE:
            case ALPHA:
            case DIGIT:
            case MINUS:
            case DOT:
            case IUNRESERVED:
            case PCT_ENCODED:
            case SUB_DELIMS:
            case SLASH:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:78:5: ip_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ip_literal_in_ihost429);
                    ip_literal38=ip_literal();

                    state._fsp--;

                    adaptor.addChild(root_0, ip_literal38.getTree());

                    }
                    break;
                case 2 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:79:5: ip_v4address
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ip_v4address_in_ihost436);
                    ip_v4address39=ip_v4address();

                    state._fsp--;

                    adaptor.addChild(root_0, ip_v4address39.getTree());

                    }
                    break;
                case 3 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:80:5: ireg_name
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ireg_name_in_ihost443);
                    ireg_name40=ireg_name();

                    state._fsp--;

                    adaptor.addChild(root_0, ireg_name40.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ihost"

    public static class port_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "port"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:83:1: port : ( DIGIT )* ;
    public final iriParser.port_return port() throws RecognitionException {
        iriParser.port_return retval = new iriParser.port_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DIGIT41=null;

        Object DIGIT41_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:84:2: ( ( DIGIT )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:84:4: ( DIGIT )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:84:4: ( DIGIT )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==DIGIT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:84:4: DIGIT
            	    {
            	    DIGIT41=(Token)match(input,DIGIT,FOLLOW_DIGIT_in_port456); 
            	    DIGIT41_tree = (Object)adaptor.create(DIGIT41);
            	    adaptor.addChild(root_0, DIGIT41_tree);


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "port"

    public static class ireg_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ireg_name"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:87:1: ireg_name : ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS )* ;
    public final iriParser.ireg_name_return ireg_name() throws RecognitionException {
        iriParser.ireg_name_return retval = new iriParser.ireg_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set42=null;

        Object set42_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:88:3: ( ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:88:5: ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:88:5: ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | PCT_ENCODED | SUB_DELIMS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=ALPHA && LA15_0<=DIGIT)||(LA15_0>=MINUS && LA15_0<=DOT)||(LA15_0>=IUNRESERVED && LA15_0<=SUB_DELIMS)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            	    {
            	    set42=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ALPHA && input.LA(1)<=DIGIT)||(input.LA(1)>=MINUS && input.LA(1)<=DOT)||(input.LA(1)>=IUNRESERVED && input.LA(1)<=SUB_DELIMS) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set42));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ireg_name"

    public static class ipath_abempty_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ipath_abempty"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:95:1: ipath_abempty : ( SLASH isegment )* ;
    public final iriParser.ipath_abempty_return ipath_abempty() throws RecognitionException {
        iriParser.ipath_abempty_return retval = new iriParser.ipath_abempty_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH43=null;
        iriParser.isegment_return isegment44 = null;


        Object SLASH43_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:96:3: ( ( SLASH isegment )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:96:5: ( SLASH isegment )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:96:5: ( SLASH isegment )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==SLASH) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:96:7: SLASH isegment
            	    {
            	    SLASH43=(Token)match(input,SLASH,FOLLOW_SLASH_in_ipath_abempty523); 
            	    SLASH43_tree = (Object)adaptor.create(SLASH43);
            	    adaptor.addChild(root_0, SLASH43_tree);

            	    pushFollow(FOLLOW_isegment_in_ipath_abempty525);
            	    isegment44=isegment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, isegment44.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ipath_abempty"

    public static class ipath_absolute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ipath_absolute"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:99:1: ipath_absolute : SLASH ( isegment_nz ( SLASH isegment )* )? ;
    public final iriParser.ipath_absolute_return ipath_absolute() throws RecognitionException {
        iriParser.ipath_absolute_return retval = new iriParser.ipath_absolute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH45=null;
        Token SLASH47=null;
        iriParser.isegment_nz_return isegment_nz46 = null;

        iriParser.isegment_return isegment48 = null;


        Object SLASH45_tree=null;
        Object SLASH47_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:100:3: ( SLASH ( isegment_nz ( SLASH isegment )* )? )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:100:5: SLASH ( isegment_nz ( SLASH isegment )* )?
            {
            root_0 = (Object)adaptor.nil();

            SLASH45=(Token)match(input,SLASH,FOLLOW_SLASH_in_ipath_absolute546); 
            SLASH45_tree = (Object)adaptor.create(SLASH45);
            adaptor.addChild(root_0, SLASH45_tree);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:100:11: ( isegment_nz ( SLASH isegment )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==COLON||(LA18_0>=ALPHA && LA18_0<=DIGIT)||(LA18_0>=MINUS && LA18_0<=SUB_DELIMS)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:100:12: isegment_nz ( SLASH isegment )*
                    {
                    pushFollow(FOLLOW_isegment_nz_in_ipath_absolute549);
                    isegment_nz46=isegment_nz();

                    state._fsp--;

                    adaptor.addChild(root_0, isegment_nz46.getTree());
                    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:100:24: ( SLASH isegment )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==SLASH) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:100:26: SLASH isegment
                    	    {
                    	    SLASH47=(Token)match(input,SLASH,FOLLOW_SLASH_in_ipath_absolute553); 
                    	    SLASH47_tree = (Object)adaptor.create(SLASH47);
                    	    adaptor.addChild(root_0, SLASH47_tree);

                    	    pushFollow(FOLLOW_isegment_in_ipath_absolute555);
                    	    isegment48=isegment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, isegment48.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ipath_absolute"

    public static class ipath_noscheme_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ipath_noscheme"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:103:1: ipath_noscheme : isegment_nz_nc ( SLASH isegment )* ;
    public final iriParser.ipath_noscheme_return ipath_noscheme() throws RecognitionException {
        iriParser.ipath_noscheme_return retval = new iriParser.ipath_noscheme_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH50=null;
        iriParser.isegment_nz_nc_return isegment_nz_nc49 = null;

        iriParser.isegment_return isegment51 = null;


        Object SLASH50_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:104:3: ( isegment_nz_nc ( SLASH isegment )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:104:5: isegment_nz_nc ( SLASH isegment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_isegment_nz_nc_in_ipath_noscheme575);
            isegment_nz_nc49=isegment_nz_nc();

            state._fsp--;

            adaptor.addChild(root_0, isegment_nz_nc49.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:104:20: ( SLASH isegment )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==SLASH) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:104:22: SLASH isegment
            	    {
            	    SLASH50=(Token)match(input,SLASH,FOLLOW_SLASH_in_ipath_noscheme579); 
            	    SLASH50_tree = (Object)adaptor.create(SLASH50);
            	    adaptor.addChild(root_0, SLASH50_tree);

            	    pushFollow(FOLLOW_isegment_in_ipath_noscheme581);
            	    isegment51=isegment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, isegment51.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ipath_noscheme"

    public static class ipath_rootless_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ipath_rootless"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:107:1: ipath_rootless : isegment_nz ( SLASH isegment )* ;
    public final iriParser.ipath_rootless_return ipath_rootless() throws RecognitionException {
        iriParser.ipath_rootless_return retval = new iriParser.ipath_rootless_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH53=null;
        iriParser.isegment_nz_return isegment_nz52 = null;

        iriParser.isegment_return isegment54 = null;


        Object SLASH53_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:108:3: ( isegment_nz ( SLASH isegment )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:108:5: isegment_nz ( SLASH isegment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_isegment_nz_in_ipath_rootless599);
            isegment_nz52=isegment_nz();

            state._fsp--;

            adaptor.addChild(root_0, isegment_nz52.getTree());
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:108:17: ( SLASH isegment )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==SLASH) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:108:19: SLASH isegment
            	    {
            	    SLASH53=(Token)match(input,SLASH,FOLLOW_SLASH_in_ipath_rootless603); 
            	    SLASH53_tree = (Object)adaptor.create(SLASH53);
            	    adaptor.addChild(root_0, SLASH53_tree);

            	    pushFollow(FOLLOW_isegment_in_ipath_rootless605);
            	    isegment54=isegment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, isegment54.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ipath_rootless"

    public static class isegment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isegment"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:120:1: isegment : ( ipchar )* ;
    public final iriParser.isegment_return isegment() throws RecognitionException {
        iriParser.isegment_return retval = new iriParser.isegment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        iriParser.ipchar_return ipchar55 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:121:3: ( ( ipchar )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:121:5: ( ipchar )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:121:5: ( ipchar )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COLON||(LA21_0>=ALPHA && LA21_0<=DIGIT)||(LA21_0>=MINUS && LA21_0<=SUB_DELIMS)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:121:5: ipchar
            	    {
            	    pushFollow(FOLLOW_ipchar_in_isegment640);
            	    ipchar55=ipchar();

            	    state._fsp--;

            	    adaptor.addChild(root_0, ipchar55.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "isegment"

    public static class isegment_nz_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isegment_nz"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:124:1: isegment_nz : ( ipchar )+ ;
    public final iriParser.isegment_nz_return isegment_nz() throws RecognitionException {
        iriParser.isegment_nz_return retval = new iriParser.isegment_nz_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        iriParser.ipchar_return ipchar56 = null;



        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:125:3: ( ( ipchar )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:125:5: ( ipchar )+
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:125:5: ( ipchar )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COLON||(LA22_0>=ALPHA && LA22_0<=DIGIT)||(LA22_0>=MINUS && LA22_0<=SUB_DELIMS)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:125:5: ipchar
            	    {
            	    pushFollow(FOLLOW_ipchar_in_isegment_nz654);
            	    ipchar56=ipchar();

            	    state._fsp--;

            	    adaptor.addChild(root_0, ipchar56.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "isegment_nz"

    public static class isegment_nz_nc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isegment_nz_nc"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:128:1: isegment_nz_nc : ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | AT )+ ;
    public final iriParser.isegment_nz_nc_return isegment_nz_nc() throws RecognitionException {
        iriParser.isegment_nz_nc_return retval = new iriParser.isegment_nz_nc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set57=null;

        Object set57_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:129:3: ( ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | AT )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:129:5: ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | AT )+
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:129:5: ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | AT )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=ALPHA && LA23_0<=DIGIT)||(LA23_0>=MINUS && LA23_0<=SUB_DELIMS)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            	    {
            	    set57=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ALPHA && input.LA(1)<=DIGIT)||(input.LA(1)>=MINUS && input.LA(1)<=SUB_DELIMS) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set57));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "isegment_nz_nc"

    public static class iquery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iquery"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:132:1: iquery : ( ipchar | IPRIVATE | SLASH | QUESTION_MARK )* ;
    public final iriParser.iquery_return iquery() throws RecognitionException {
        iriParser.iquery_return retval = new iriParser.iquery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IPRIVATE59=null;
        Token SLASH60=null;
        Token QUESTION_MARK61=null;
        iriParser.ipchar_return ipchar58 = null;


        Object IPRIVATE59_tree=null;
        Object SLASH60_tree=null;
        Object QUESTION_MARK61_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:3: ( ( ipchar | IPRIVATE | SLASH | QUESTION_MARK )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:5: ( ipchar | IPRIVATE | SLASH | QUESTION_MARK )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:5: ( ipchar | IPRIVATE | SLASH | QUESTION_MARK )*
            loop24:
            do {
                int alt24=5;
                switch ( input.LA(1) ) {
                case COLON:
                case ALPHA:
                case DIGIT:
                case MINUS:
                case DOT:
                case AT:
                case IUNRESERVED:
                case PCT_ENCODED:
                case SUB_DELIMS:
                    {
                    alt24=1;
                    }
                    break;
                case IPRIVATE:
                    {
                    alt24=2;
                    }
                    break;
                case SLASH:
                    {
                    alt24=3;
                    }
                    break;
                case QUESTION_MARK:
                    {
                    alt24=4;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:7: ipchar
            	    {
            	    pushFollow(FOLLOW_ipchar_in_iquery719);
            	    ipchar58=ipchar();

            	    state._fsp--;

            	    adaptor.addChild(root_0, ipchar58.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:16: IPRIVATE
            	    {
            	    IPRIVATE59=(Token)match(input,IPRIVATE,FOLLOW_IPRIVATE_in_iquery723); 
            	    IPRIVATE59_tree = (Object)adaptor.create(IPRIVATE59);
            	    adaptor.addChild(root_0, IPRIVATE59_tree);


            	    }
            	    break;
            	case 3 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:27: SLASH
            	    {
            	    SLASH60=(Token)match(input,SLASH,FOLLOW_SLASH_in_iquery727); 
            	    SLASH60_tree = (Object)adaptor.create(SLASH60);
            	    adaptor.addChild(root_0, SLASH60_tree);


            	    }
            	    break;
            	case 4 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:133:35: QUESTION_MARK
            	    {
            	    QUESTION_MARK61=(Token)match(input,QUESTION_MARK,FOLLOW_QUESTION_MARK_in_iquery731); 
            	    QUESTION_MARK61_tree = (Object)adaptor.create(QUESTION_MARK61);
            	    adaptor.addChild(root_0, QUESTION_MARK61_tree);


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iquery"

    public static class ifragment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifragment"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:136:1: ifragment : ( ipchar | SLASH | QUESTION_MARK )* ;
    public final iriParser.ifragment_return ifragment() throws RecognitionException {
        iriParser.ifragment_return retval = new iriParser.ifragment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH63=null;
        Token QUESTION_MARK64=null;
        iriParser.ipchar_return ipchar62 = null;


        Object SLASH63_tree=null;
        Object QUESTION_MARK64_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:137:3: ( ( ipchar | SLASH | QUESTION_MARK )* )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:137:5: ( ipchar | SLASH | QUESTION_MARK )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:137:5: ( ipchar | SLASH | QUESTION_MARK )*
            loop25:
            do {
                int alt25=4;
                switch ( input.LA(1) ) {
                case COLON:
                case ALPHA:
                case DIGIT:
                case MINUS:
                case DOT:
                case AT:
                case IUNRESERVED:
                case PCT_ENCODED:
                case SUB_DELIMS:
                    {
                    alt25=1;
                    }
                    break;
                case SLASH:
                    {
                    alt25=2;
                    }
                    break;
                case QUESTION_MARK:
                    {
                    alt25=3;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:137:7: ipchar
            	    {
            	    pushFollow(FOLLOW_ipchar_in_ifragment751);
            	    ipchar62=ipchar();

            	    state._fsp--;

            	    adaptor.addChild(root_0, ipchar62.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:137:16: SLASH
            	    {
            	    SLASH63=(Token)match(input,SLASH,FOLLOW_SLASH_in_ifragment755); 
            	    SLASH63_tree = (Object)adaptor.create(SLASH63);
            	    adaptor.addChild(root_0, SLASH63_tree);


            	    }
            	    break;
            	case 3 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:137:24: QUESTION_MARK
            	    {
            	    QUESTION_MARK64=(Token)match(input,QUESTION_MARK,FOLLOW_QUESTION_MARK_in_ifragment759); 
            	    QUESTION_MARK64_tree = (Object)adaptor.create(QUESTION_MARK64);
            	    adaptor.addChild(root_0, QUESTION_MARK64_tree);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifragment"

    public static class ipchar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ipchar"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:140:1: ipchar : ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | COLON | AT );
    public final iriParser.ipchar_return ipchar() throws RecognitionException {
        iriParser.ipchar_return retval = new iriParser.ipchar_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set65=null;

        Object set65_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:141:3: ( ALPHA | DIGIT | IUNRESERVED | MINUS | DOT | PCT_ENCODED | SUB_DELIMS | COLON | AT )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            {
            root_0 = (Object)adaptor.nil();

            set65=(Token)input.LT(1);
            if ( input.LA(1)==COLON||(input.LA(1)>=ALPHA && input.LA(1)<=DIGIT)||(input.LA(1)>=MINUS && input.LA(1)<=SUB_DELIMS) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set65));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ipchar"

    public static class ip_literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ip_literal"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:152:1: ip_literal : LEFT_SQUARE ip_vFuture RIGHT_SQUARE ;
    public final iriParser.ip_literal_return ip_literal() throws RecognitionException {
        iriParser.ip_literal_return retval = new iriParser.ip_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LEFT_SQUARE66=null;
        Token RIGHT_SQUARE68=null;
        iriParser.ip_vFuture_return ip_vFuture67 = null;


        Object LEFT_SQUARE66_tree=null;
        Object RIGHT_SQUARE68_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:153:2: ( LEFT_SQUARE ip_vFuture RIGHT_SQUARE )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:153:5: LEFT_SQUARE ip_vFuture RIGHT_SQUARE
            {
            root_0 = (Object)adaptor.nil();

            LEFT_SQUARE66=(Token)match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_ip_literal831); 
            LEFT_SQUARE66_tree = (Object)adaptor.create(LEFT_SQUARE66);
            adaptor.addChild(root_0, LEFT_SQUARE66_tree);

            pushFollow(FOLLOW_ip_vFuture_in_ip_literal834);
            ip_vFuture67=ip_vFuture();

            state._fsp--;

            adaptor.addChild(root_0, ip_vFuture67.getTree());
            RIGHT_SQUARE68=(Token)match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_ip_literal837); 
            RIGHT_SQUARE68_tree = (Object)adaptor.create(RIGHT_SQUARE68);
            adaptor.addChild(root_0, RIGHT_SQUARE68_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ip_literal"

    public static class ip_vFuture_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ip_vFuture"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:156:1: ip_vFuture : ALPHA HEXDIG DOT ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | SUB_DELIMS )+ ;
    public final iriParser.ip_vFuture_return ip_vFuture() throws RecognitionException {
        iriParser.ip_vFuture_return retval = new iriParser.ip_vFuture_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ALPHA69=null;
        Token HEXDIG70=null;
        Token DOT71=null;
        Token set72=null;

        Object ALPHA69_tree=null;
        Object HEXDIG70_tree=null;
        Object DOT71_tree=null;
        Object set72_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:157:2: ( ALPHA HEXDIG DOT ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | SUB_DELIMS )+ )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:157:4: ALPHA HEXDIG DOT ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | SUB_DELIMS )+
            {
            root_0 = (Object)adaptor.nil();

            ALPHA69=(Token)match(input,ALPHA,FOLLOW_ALPHA_in_ip_vFuture848); 
            ALPHA69_tree = (Object)adaptor.create(ALPHA69);
            adaptor.addChild(root_0, ALPHA69_tree);

            HEXDIG70=(Token)match(input,HEXDIG,FOLLOW_HEXDIG_in_ip_vFuture850); 
            HEXDIG70_tree = (Object)adaptor.create(HEXDIG70);
            adaptor.addChild(root_0, HEXDIG70_tree);

            DOT71=(Token)match(input,DOT,FOLLOW_DOT_in_ip_vFuture852); 
            DOT71_tree = (Object)adaptor.create(DOT71);
            adaptor.addChild(root_0, DOT71_tree);

            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:157:21: ( ALPHA | DIGIT | MINUS | DOT | IUNRESERVED | SUB_DELIMS )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=ALPHA && LA26_0<=DIGIT)||(LA26_0>=MINUS && LA26_0<=DOT)||LA26_0==IUNRESERVED||LA26_0==SUB_DELIMS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:
            	    {
            	    set72=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ALPHA && input.LA(1)<=DIGIT)||(input.LA(1)>=MINUS && input.LA(1)<=DOT)||input.LA(1)==IUNRESERVED||input.LA(1)==SUB_DELIMS ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set72));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ip_vFuture"

    public static class ip_v4address_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ip_v4address"
    // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:160:1: ip_v4address : DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET ;
    public final iriParser.ip_v4address_return ip_v4address() throws RecognitionException {
        iriParser.ip_v4address_return retval = new iriParser.ip_v4address_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DEC_OCTET73=null;
        Token DOT74=null;
        Token DEC_OCTET75=null;
        Token DOT76=null;
        Token DEC_OCTET77=null;
        Token DOT78=null;
        Token DEC_OCTET79=null;

        Object DEC_OCTET73_tree=null;
        Object DOT74_tree=null;
        Object DEC_OCTET75_tree=null;
        Object DOT76_tree=null;
        Object DEC_OCTET77_tree=null;
        Object DOT78_tree=null;
        Object DEC_OCTET79_tree=null;

        try {
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:161:2: ( DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET )
            // /home/davide/Projects/Eclipse/workspace/DRLv6/src/main/resources/iri.g:161:4: DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET DOT DEC_OCTET
            {
            root_0 = (Object)adaptor.nil();

            DEC_OCTET73=(Token)match(input,DEC_OCTET,FOLLOW_DEC_OCTET_in_ip_v4address890); 
            DEC_OCTET73_tree = (Object)adaptor.create(DEC_OCTET73);
            adaptor.addChild(root_0, DEC_OCTET73_tree);

            DOT74=(Token)match(input,DOT,FOLLOW_DOT_in_ip_v4address892); 
            DOT74_tree = (Object)adaptor.create(DOT74);
            adaptor.addChild(root_0, DOT74_tree);

            DEC_OCTET75=(Token)match(input,DEC_OCTET,FOLLOW_DEC_OCTET_in_ip_v4address894); 
            DEC_OCTET75_tree = (Object)adaptor.create(DEC_OCTET75);
            adaptor.addChild(root_0, DEC_OCTET75_tree);

            DOT76=(Token)match(input,DOT,FOLLOW_DOT_in_ip_v4address896); 
            DOT76_tree = (Object)adaptor.create(DOT76);
            adaptor.addChild(root_0, DOT76_tree);

            DEC_OCTET77=(Token)match(input,DEC_OCTET,FOLLOW_DEC_OCTET_in_ip_v4address898); 
            DEC_OCTET77_tree = (Object)adaptor.create(DEC_OCTET77);
            adaptor.addChild(root_0, DEC_OCTET77_tree);

            DOT78=(Token)match(input,DOT,FOLLOW_DOT_in_ip_v4address900); 
            DOT78_tree = (Object)adaptor.create(DOT78);
            adaptor.addChild(root_0, DOT78_tree);

            DEC_OCTET79=(Token)match(input,DEC_OCTET,FOLLOW_DEC_OCTET_in_ip_v4address902); 
            DEC_OCTET79_tree = (Object)adaptor.create(DEC_OCTET79);
            adaptor.addChild(root_0, DEC_OCTET79_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ip_v4address"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA1_eotS =
        "\5\uffff";
    static final String DFA1_eofS =
        "\2\2\1\uffff\1\2\1\uffff";
    static final String DFA1_minS =
        "\1\5\1\4\1\uffff\1\4\1\uffff";
    static final String DFA1_maxS =
        "\2\21\1\uffff\1\21\1\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA1_specialS =
        "\5\uffff}>";
    static final String[] DFA1_transitionS = {
            "\3\2\1\1\1\2\1\uffff\7\2",
            "\1\4\2\2\1\uffff\2\3\1\4\2\3\5\2",
            "",
            "\1\4\2\2\1\uffff\2\3\1\4\2\3\5\2",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "16:1: iri_reference : ( iri | irelative_ref );";
        }
    }
    static final String DFA10_eotS =
        "\6\uffff";
    static final String DFA10_eofS =
        "\2\3\2\uffff\2\3";
    static final String DFA10_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA10_maxS =
        "\1\26\1\21\2\uffff\2\21";
    static final String DFA10_acceptS =
        "\2\uffff\1\1\1\2\2\uffff";
    static final String DFA10_specialS =
        "\6\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\2\3\1\uffff\2\1\1\uffff\2\1\1\2\3\1\1\3\1\uffff\1\3\2\uffff"+
            "\1\3",
            "\1\4\2\3\1\uffff\2\1\1\uffff\2\1\1\2\3\1\1\3",
            "",
            "",
            "\1\2\2\3\1\uffff\1\2\1\5\1\uffff\6\2\1\3",
            "\1\2\2\3\1\uffff\1\2\1\5\1\uffff\6\2\1\3"
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
            return "70:5: ( iuserinfo AT )?";
        }
    }
 

    public static final BitSet FOLLOW_iri_in_iri_reference67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_irelative_ref_in_iri_reference74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scheme_in_absolute_iri88 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_absolute_iri90 = new BitSet(new long[]{0x000000000003FBB0L});
    public static final BitSet FOLLOW_ihier_part_in_absolute_iri92 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUESTION_MARK_in_absolute_iri100 = new BitSet(new long[]{0x000000000007FB30L});
    public static final BitSet FOLLOW_iquery_in_absolute_iri102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scheme_in_iri121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_iri123 = new BitSet(new long[]{0x000000000003FBF0L});
    public static final BitSet FOLLOW_ihier_part_in_iri125 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_QUESTION_MARK_in_iri133 = new BitSet(new long[]{0x000000000007FB70L});
    public static final BitSet FOLLOW_iquery_in_iri135 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_GATE_in_iri146 = new BitSet(new long[]{0x000000000003FB30L});
    public static final BitSet FOLLOW_ifragment_in_iri148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_irelative_part_in_irelative_ref165 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_QUESTION_MARK_in_irelative_ref173 = new BitSet(new long[]{0x000000000007FB70L});
    public static final BitSet FOLLOW_iquery_in_irelative_ref175 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_GATE_in_irelative_ref184 = new BitSet(new long[]{0x000000000003FB30L});
    public static final BitSet FOLLOW_ifragment_in_irelative_ref186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBL_SLASH_in_ihier_part213 = new BitSet(new long[]{0x000000000049FB10L});
    public static final BitSet FOLLOW_iauthority_in_ihier_part215 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ipath_abempty_in_ihier_part217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ipath_absolute_in_ihier_part223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ipath_rootless_in_ihier_part229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DBL_SLASH_in_irelative_part250 = new BitSet(new long[]{0x000000000049FB10L});
    public static final BitSet FOLLOW_iauthority_in_irelative_part252 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ipath_abempty_in_irelative_part254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ipath_absolute_in_irelative_part260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ipath_noscheme_in_irelative_part266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHA_in_scheme288 = new BitSet(new long[]{0x0000000000001F02L});
    public static final BitSet FOLLOW_set_in_scheme290 = new BitSet(new long[]{0x0000000000001F02L});
    public static final BitSet FOLLOW_iuserinfo_in_iauthority339 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_AT_in_iauthority341 = new BitSet(new long[]{0x000000000049FB10L});
    public static final BitSet FOLLOW_ihost_in_iauthority345 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_COLON_in_iauthority348 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_port_in_iauthority350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_iuserinfo371 = new BitSet(new long[]{0x000000000001DB12L});
    public static final BitSet FOLLOW_ip_literal_in_ihost429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ip_v4address_in_ihost436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ireg_name_in_ihost443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGIT_in_port456 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_set_in_ireg_name474 = new BitSet(new long[]{0x000000000001DB02L});
    public static final BitSet FOLLOW_SLASH_in_ipath_abempty523 = new BitSet(new long[]{0x000000000003FB10L});
    public static final BitSet FOLLOW_isegment_in_ipath_abempty525 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SLASH_in_ipath_absolute546 = new BitSet(new long[]{0x000000000001FB12L});
    public static final BitSet FOLLOW_isegment_nz_in_ipath_absolute549 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SLASH_in_ipath_absolute553 = new BitSet(new long[]{0x000000000003FB10L});
    public static final BitSet FOLLOW_isegment_in_ipath_absolute555 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_isegment_nz_nc_in_ipath_noscheme575 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SLASH_in_ipath_noscheme579 = new BitSet(new long[]{0x000000000003FB10L});
    public static final BitSet FOLLOW_isegment_in_ipath_noscheme581 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_isegment_nz_in_ipath_rootless599 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SLASH_in_ipath_rootless603 = new BitSet(new long[]{0x000000000003FB10L});
    public static final BitSet FOLLOW_isegment_in_ipath_rootless605 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ipchar_in_isegment640 = new BitSet(new long[]{0x000000000001FB12L});
    public static final BitSet FOLLOW_ipchar_in_isegment_nz654 = new BitSet(new long[]{0x000000000001FB12L});
    public static final BitSet FOLLOW_set_in_isegment_nz_nc671 = new BitSet(new long[]{0x000000000001FB02L});
    public static final BitSet FOLLOW_ipchar_in_iquery719 = new BitSet(new long[]{0x000000000007FB32L});
    public static final BitSet FOLLOW_IPRIVATE_in_iquery723 = new BitSet(new long[]{0x000000000007FB32L});
    public static final BitSet FOLLOW_SLASH_in_iquery727 = new BitSet(new long[]{0x000000000007FB32L});
    public static final BitSet FOLLOW_QUESTION_MARK_in_iquery731 = new BitSet(new long[]{0x000000000007FB32L});
    public static final BitSet FOLLOW_ipchar_in_ifragment751 = new BitSet(new long[]{0x000000000003FB32L});
    public static final BitSet FOLLOW_SLASH_in_ifragment755 = new BitSet(new long[]{0x000000000003FB32L});
    public static final BitSet FOLLOW_QUESTION_MARK_in_ifragment759 = new BitSet(new long[]{0x000000000003FB32L});
    public static final BitSet FOLLOW_set_in_ipchar0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_ip_literal831 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ip_vFuture_in_ip_literal834 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_ip_literal837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHA_in_ip_vFuture848 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_HEXDIG_in_ip_vFuture850 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_ip_vFuture852 = new BitSet(new long[]{0x0000000000015B00L});
    public static final BitSet FOLLOW_set_in_ip_vFuture854 = new BitSet(new long[]{0x0000000000015B02L});
    public static final BitSet FOLLOW_DEC_OCTET_in_ip_v4address890 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_ip_v4address892 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DEC_OCTET_in_ip_v4address894 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_ip_v4address896 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DEC_OCTET_in_ip_v4address898 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOT_in_ip_v4address900 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DEC_OCTET_in_ip_v4address902 = new BitSet(new long[]{0x0000000000000002L});

}