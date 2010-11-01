package org.drools.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.drools.compiler.DroolsParserException;



/**
 * This is a class to hold all the helper functions/methods used
 * by the DRL parser
 */
public class ParserHelper {
    public List<DroolsParserException>                errors                   = new ArrayList<DroolsParserException>();
    public LinkedList<DroolsSentence>                 editorInterface          = null;
    public boolean                                    isEditorInterfaceEnabled = false;
    public boolean                                    lookaheadTest            = false;
    private Stack<Map<DroolsParaphraseTypes, String>> paraphrases              = new Stack<Map<DroolsParaphraseTypes, String>>();

    // parameters from parser
    private Parser                       parser                   = null;
    private DroolsParserExceptionFactory              errorMessageFactory      = null;
    private TokenStream                               input                    = null;
    private RecognizerSharedState                     state                    = null;

    public ParserHelper(Parser parser,
                        String[] tokenNames,
                        TokenStream input,
                        RecognizerSharedState state) {
        this.parser = parser;
        this.errorMessageFactory = new DroolsParserExceptionFactory( tokenNames,
                                                                     paraphrases );
        this.input = input;
        this.state = state;
    }

    public LinkedList<DroolsSentence> getEditorInterface() {
        return editorInterface;
    }

    public void enableEditorInterface() {
        isEditorInterfaceEnabled = true;
    }

    public void disableEditorInterface() {
        isEditorInterfaceEnabled = false;
    }

    public void beginSentence(DroolsSentenceType sentenceType) {
        if ( isEditorInterfaceEnabled ) {
            if ( null == editorInterface ) {
                editorInterface = new LinkedList<DroolsSentence>();
            }
            DroolsSentence sentence = new DroolsSentence();
            sentence.setType( sentenceType );
            editorInterface.add( sentence );
        }
    }

    public DroolsSentence getActiveSentence() {
        return editorInterface.getLast();
    }

    public void emit(List< ? > tokens,
                      DroolsEditorType editorType) {
        if ( isEditorInterfaceEnabled && tokens != null ) {
            for ( Object activeObject : tokens ) {
                emit( (Token) activeObject,
                      editorType );
            }
        }
    }

    public void emit(Token token,
                      DroolsEditorType editorType) {
        if ( isEditorInterfaceEnabled && token != null ) {
            ((DroolsToken) token).setEditorType( editorType );
            getActiveSentence().addContent( (DroolsToken) token );
        }
    }

    public void emit(boolean forceEmit,
                      int activeContext) {
        if ( isEditorInterfaceEnabled ) {
            getActiveSentence().addContent( activeContext );
        }
    }

    public void emit(int activeContext) {
        if ( isEditorInterfaceEnabled ) {
            emit( false,
                  activeContext );
        }
    }

    public DroolsToken getLastTokenOnList(LinkedList< ? > list) {
        DroolsToken lastToken = null;
        for ( Object object : list ) {
            if ( object instanceof DroolsToken ) {
                lastToken = (DroolsToken) object;
            }
        }
        return lastToken;
    }

    public int getLastIntegerValue(LinkedList< ? > list) {
        int lastIntergerValue = -1;
        for ( Object object : list ) {
            if ( object instanceof Integer ) {
                lastIntergerValue = (Integer) object;
            }
        }
        return lastIntergerValue;
    }

    public String retrieveLT(int LTNumber) {
        if ( null == input ) return null;
        if ( null == input.LT( LTNumber ) ) return null;
        if ( null == input.LT( LTNumber ).getText() ) return null;

        return input.LT( LTNumber ).getText();
    }

    public boolean validateLT(int LTNumber,
                               String text) {    	
        String text2Validate = retrieveLT( LTNumber );       
        boolean ans = text2Validate == null ? false : text2Validate.equalsIgnoreCase( text );        
        return ans;
        
    }

    public boolean isPluggableEvaluator(int offset,
                                         boolean negated) {
        String text2Validate = retrieveLT( offset );
        return text2Validate == null ? false : DroolsSoftKeywords.isOperator( text2Validate,
                                                                              negated );
    }

    public boolean isPluggableEvaluator(boolean negated) {
        return isPluggableEvaluator( 1,
                                     negated );
    }

    public boolean validateIdentifierKey(String text) {
        return validateLT( 1,
                           text );
    }

    public boolean validateSpecialID(int index) {
        return validateLT( index,
                           DroolsSoftKeywords.THIS ) ||
               validateLT( index,
                           DroolsSoftKeywords.SUPER ) ||
               validateLT( index,
                           DroolsSoftKeywords.NEW ) ||
               validateLT( index,
                           DroolsSoftKeywords.CLASS );

    }

    public boolean validateIdentifierSufix() {
        return validateLT( 1,
                           "[" ) || validateLT( 1,
                                                "(" ) || validateLT( 1,
                                                                     "<" ) || (validateLT( 1,
                                                                                           "." ) && validateSpecialID( 2 ));
    }

    public void checkTrailingSemicolon(String text,
                                       Token token) {
        if ( text.trim().endsWith( ";" ) ) {
            errors.add( errorMessageFactory
                    .createTrailingSemicolonException( ((DroolsToken) token)
                                                               .getLine(),
                                                       ((DroolsToken) token)
                                                               .getCharPositionInLine(),
                                                       ((DroolsToken) token)
                                                               .getStopIndex() ) );
        }
    }

//    public boolean validateNotWithBinding() {
//        if ( input.LA( 1 ) == ID && input.LA( 2 ) == ID && input.LA( 3 ) == COLON ) {
//            return true;
//        }
//        return false;
//    }

//    public boolean validateRestr() {
//        int lookahead = 2;
//        int countParen = 1;
//
//        while ( true ) {
//            if ( input.LA( lookahead ) == COMMA ) {
//                break;
//            } else if ( input.LA( lookahead ) == LEFT_PAREN ) {
//                countParen++;
//            } else if ( input.LA( lookahead ) == RIGHT_PAREN ) {
//                countParen--;
//            } else if ( input.LA( lookahead ) == EOF ) {
//                break;
//            }
//            if ( countParen == 0 ) {
//                break;
//            }
//            lookahead++;
//        }
//
//        boolean returnValue = false;
//        int activeIndex = input.index();
//        lookaheadTest = true;
//        try {
//            input.seek( input.LT( 2 ).getTokenIndex() );
//            parser.constraint_expression();
//            returnValue = true;
//        } catch ( RecognitionException e ) {
//        } finally {
//            input.seek( activeIndex );
//        }
//        lookaheadTest = false;
//
//        return returnValue;
//    }

    public String safeSubstring(String text,
                                 int start,
                                 int end) {
        return text.substring( Math.min( start,
                                         text.length() ),
                               Math.min( Math
                                                 .max( start,
                                                       end ),
                                         text.length() ) );
    }

    public void reportError(RecognitionException ex) {
        // if we've already reported an error and have not matched a token
        // yet successfully, don't report any errors.
        if ( state.errorRecovery ) {
            return;
        }
        state.errorRecovery = true;

        errors.add( errorMessageFactory.createDroolsException( ex ) );
    }

    /** return the raw DroolsParserException errors */
    public List<DroolsParserException> getErrors() {
        return errors;
    }

    /** Return a list of pretty strings summarising the errors */
    public List<String> getErrorMessages() {
        List<String> messages = new ArrayList<String>( errors.size() );

        for ( DroolsParserException activeException : errors ) {
            messages.add( activeException.getMessage() );
        }

        return messages;
    }

    /** return true if any parser errors were accumulated */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Method that adds a paraphrase type into paraphrases stack.
     * 
     * @param type
     *            paraphrase type
     */
    public void pushParaphrases(DroolsParaphraseTypes type) {
        Map<DroolsParaphraseTypes, String> activeMap = new HashMap<DroolsParaphraseTypes, String>();
        activeMap.put( type,
                       "" );
        paraphrases.push( activeMap );
    }

    public Map<DroolsParaphraseTypes, String> popParaphrases() {
        return paraphrases.pop();
    }

    /**
     * Method that sets paraphrase value for a type into paraphrases stack.
     * 
     * @param type
     *            paraphrase type
     * @param value
     *            paraphrase value
     */
    public void setParaphrasesValue(DroolsParaphraseTypes type,
                                     String value) {
        paraphrases.peek().put( type,
                                value );
    }

    /**
     * Helper method that creates a string from a token list.
     * 
     * @param tokenList
     *            token list
     * @return string
     */
    public String buildStringFromTokens(List<Token> tokenList) {
        StringBuilder sb = new StringBuilder();
        if ( null != tokenList ) {
            for ( Token activeToken : tokenList ) {
                if ( null != activeToken ) {
                    sb.append( activeToken.getText() );
                }
            }
        }
        return sb.toString();
    }

    /** Overrided this method to not output mesages */
    public void emitErrorMessage(String msg) {
    }

}
