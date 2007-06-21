// $ANTLR 3.0 /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g 2007-06-21 12:24:49

	package org.drools.lang;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.HashMap;	
	import java.util.StringTokenizer;
	import org.drools.lang.descr.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class DRLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "PACKAGE", "IMPORT", "FUNCTION", "ID", "DOT", "GLOBAL", "LEFT_PAREN", "COMMA", "RIGHT_PAREN", "QUERY", "END", "TEMPLATE", "RULE", "WHEN", "DATE_EFFECTIVE", "STRING", "DATE_EXPIRES", "ENABLED", "BOOL", "SALIENCE", "INT", "NO_LOOP", "AUTO_FOCUS", "ACTIVATION_GROUP", "RULEFLOW_GROUP", "AGENDA_GROUP", "DURATION", "DIALECT", "LOCK_ON_ACTIVE", "OR", "DOUBLE_PIPE", "AND", "DOUBLE_AMPER", "FROM", "EXISTS", "NOT", "EVAL", "FORALL", "ACCUMULATE", "INIT", "ACTION", "REVERSE", "RESULT", "COLLECT", "CONTAINS", "EXCLUDES", "MATCHES", "MEMBEROF", "IN", "FLOAT", "NULL", "LEFT_CURLY", "RIGHT_CURLY", "LEFT_SQUARE", "RIGHT_SQUARE", "THEN", "EOL", "WS", "EscapeSequence", "HexDigit", "UnicodeEscape", "OctalEscape", "SH_STYLE_SINGLE_LINE_COMMENT", "C_STYLE_SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "MISC", "';'", "':'", "'.*'", "'->'", "'=='", "'>'", "'>='", "'<'", "'<='", "'!='"
    };
    public static final int COMMA=12;
    public static final int EXISTS=39;
    public static final int AUTO_FOCUS=27;
    public static final int END=15;
    public static final int HexDigit=64;
    public static final int FORALL=42;
    public static final int TEMPLATE=16;
    public static final int MISC=70;
    public static final int FLOAT=54;
    public static final int QUERY=14;
    public static final int THEN=60;
    public static final int RULE=17;
    public static final int INIT=44;
    public static final int IMPORT=6;
    public static final int DATE_EFFECTIVE=19;
    public static final int PACKAGE=5;
    public static final int OR=34;
    public static final int DOT=9;
    public static final int DOUBLE_PIPE=35;
    public static final int AND=36;
    public static final int FUNCTION=7;
    public static final int GLOBAL=10;
    public static final int EscapeSequence=63;
    public static final int DIALECT=32;
    public static final int INT=25;
    public static final int LOCK_ON_ACTIVE=33;
    public static final int DATE_EXPIRES=21;
    public static final int LEFT_SQUARE=58;
    public static final int CONTAINS=49;
    public static final int SH_STYLE_SINGLE_LINE_COMMENT=67;
    public static final int ATTRIBUTES=4;
    public static final int LEFT_CURLY=56;
    public static final int RESULT=47;
    public static final int ID=8;
    public static final int FROM=38;
    public static final int LEFT_PAREN=11;
    public static final int ACTIVATION_GROUP=28;
    public static final int DOUBLE_AMPER=37;
    public static final int RIGHT_CURLY=57;
    public static final int EXCLUDES=50;
    public static final int BOOL=23;
    public static final int MEMBEROF=52;
    public static final int WHEN=18;
    public static final int RULEFLOW_GROUP=29;
    public static final int WS=62;
    public static final int STRING=20;
    public static final int ACTION=45;
    public static final int COLLECT=48;
    public static final int IN=53;
    public static final int REVERSE=46;
    public static final int NO_LOOP=26;
    public static final int ACCUMULATE=43;
    public static final int UnicodeEscape=65;
    public static final int DURATION=31;
    public static final int EVAL=41;
    public static final int MATCHES=51;
    public static final int EOF=-1;
    public static final int EOL=61;
    public static final int NULL=55;
    public static final int AGENDA_GROUP=30;
    public static final int OctalEscape=66;
    public static final int SALIENCE=24;
    public static final int MULTI_LINE_COMMENT=69;
    public static final int RIGHT_PAREN=13;
    public static final int NOT=40;
    public static final int ENABLED=22;
    public static final int RIGHT_SQUARE=59;
    public static final int C_STYLE_SINGLE_LINE_COMMENT=68;

        public DRLParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[76+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g"; }


    	private PackageDescr packageDescr;
    	private List errors = new ArrayList();
    	private String source = "unknown";
    	private int lineOffset = 0;
    	private DescrFactory factory = new DescrFactory();
    	private boolean parserDebug = false;
    	private Location location = new Location( Location.LOCATION_UNKNOWN );
    	
    	// THE FOLLOWING LINES ARE DUMMY ATTRIBUTES TO WORK AROUND AN ANTLR BUG
    	private BaseDescr from = null;
    	private FieldConstraintDescr fc = null;
    	private RestrictionConnectiveDescr and = null;
    	private RestrictionConnectiveDescr or = null;
    	private ConditionalElementDescr base = null;
    	
    	public void setParserDebug(boolean parserDebug) {
    		this.parserDebug = parserDebug;
    	}
    	
    	public void debug(String message) {
    		if ( parserDebug ) 
    			System.err.println( "drl parser: " + message );
    	}
    	
    	public void setSource(String source) {
    		this.source = source;
    	}
    	public DescrFactory getFactory() {
    		return factory;
    	}	

    	public String getSource() {
    		return this.source;
    	}
    	
    	public PackageDescr getPackageDescr() {
    		return packageDescr;
    	}
    	
    	private int offset(int line) {
    		return line + lineOffset;
    	}
    	
    	/**
    	 * This will set the offset to record when reparsing. Normally is zero of course 
    	 */
    	public void setLineOffset(int i) {
    	 	this.lineOffset = i;
    	}
    	
    	private String getString(String token) {
    		return token.substring( 1, token.length() -1 );
    	}
    	
    	public void reportError(RecognitionException ex) {
    	        // if we've already reported an error and have not matched a token
                    // yet successfully, don't report any errors.
                    if ( errorRecovery ) {
                            return;
                    }
                    errorRecovery = true;

    		ex.line = offset(ex.line); //add the offset if there is one
    		errors.add( ex ); 
    	}
         	
         	/** return the raw RecognitionException errors */
         	public List getErrors() {
         		return errors;
         	}
         	
         	/** Return a list of pretty strings summarising the errors */
         	public List getErrorMessages() {
         		List messages = new ArrayList();
     		for ( Iterator errorIter = errors.iterator() ; errorIter.hasNext() ; ) {
         	     		messages.add( createErrorMessage( (RecognitionException) errorIter.next() ) );
         	     	}
         	     	return messages;
         	}
         	
         	/** return true if any parser errors were accumulated */
         	public boolean hasErrors() {
      		return ! errors.isEmpty();
         	}
         	
         	/** This will take a RecognitionException, and create a sensible error message out of it */
         	public String createErrorMessage(RecognitionException e)
            {
    		StringBuffer message = new StringBuffer();		
                    message.append( source + ":"+e.line+":"+e.charPositionInLine+" ");
                    if ( e instanceof MismatchedTokenException ) {
                            MismatchedTokenException mte = (MismatchedTokenException)e;
                            message.append("mismatched token: "+
                                                               e.token+
                                                               "; expecting type "+
                                                               tokenNames[mte.expecting]);
                    }
                    else if ( e instanceof MismatchedTreeNodeException ) {
                            MismatchedTreeNodeException mtne = (MismatchedTreeNodeException)e;
                            message.append("mismatched tree node: "+
                                                               mtne.toString() +
                                                               "; expecting type "+
                                                               tokenNames[mtne.expecting]);
                    }
                    else if ( e instanceof NoViableAltException ) {
                            NoViableAltException nvae = (NoViableAltException)e;
    			message.append( "Unexpected token '" + e.token.getText() + "'" );
                            /*
                            message.append("decision=<<"+nvae.grammarDecisionDescription+">>"+
                                                               " state "+nvae.stateNumber+
                                                               " (decision="+nvae.decisionNumber+
                                                               ") no viable alt; token="+
                                                               e.token);
                                                               */
                    }
                    else if ( e instanceof EarlyExitException ) {
                            EarlyExitException eee = (EarlyExitException)e;
                            message.append("required (...)+ loop (decision="+
                                                               eee.decisionNumber+
                                                               ") did not match anything; token="+
                                                               e.token);
                    }
                    else if ( e instanceof MismatchedSetException ) {
                            MismatchedSetException mse = (MismatchedSetException)e;
                            message.append("mismatched token '"+
                                                               e.token+
                                                               "' expecting set "+mse.expecting);
                    }
                    else if ( e instanceof MismatchedNotSetException ) {
                            MismatchedNotSetException mse = (MismatchedNotSetException)e;
                            message.append("mismatched token '"+
                                                               e.token+
                                                               "' expecting set "+mse.expecting);
                    }
                    else if ( e instanceof FailedPredicateException ) {
                            FailedPredicateException fpe = (FailedPredicateException)e;
                            message.append("rule "+fpe.ruleName+" failed predicate: {"+
                                                               fpe.predicateText+"}?");
                    } else if (e instanceof GeneralParseException) {
    			message.append(" " + e.getMessage());
    		}
                   	return message.toString();
            }   
            
            void checkTrailingSemicolon(String text, int line) {
            	if (text.trim().endsWith( ";" ) ) {
            		this.errors.add( new GeneralParseException( "Trailing semi-colon not allowed", offset(line) ) );
            	}
            }
            
            public Location getLocation() {
                    return this.location;
            }
          



    // $ANTLR start opt_semicolon
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:174:1: opt_semicolon : ( ';' )? ;
    public final void opt_semicolon() throws RecognitionException {
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:175:4: ( ( ';' )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:175:4: ( ';' )?
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:175:4: ( ';' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==71) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:175:4: ';'
                    {
                    match(input,71,FOLLOW_71_in_opt_semicolon39); if (failed) return ;

                    }
                    break;

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
    // $ANTLR end opt_semicolon


    // $ANTLR start compilation_unit
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:178:1: compilation_unit : prolog ( statement )+ ;
    public final void compilation_unit() throws RecognitionException {

        		// reset Location information
        		this.location = new Location( Location.LOCATION_UNKNOWN );
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:183:4: ( prolog ( statement )+ )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:183:4: prolog ( statement )+
            {
            pushFollow(FOLLOW_prolog_in_compilation_unit57);
            prolog();
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:184:3: ( statement )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=IMPORT && LA2_0<=FUNCTION)||LA2_0==GLOBAL||LA2_0==QUERY||(LA2_0>=TEMPLATE && LA2_0<=RULE)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:184:3: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_compilation_unit62);
            	    statement();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


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
    // $ANTLR end compilation_unit


    // $ANTLR start prolog
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:187:1: prolog : (pkgstmt= package_statement )? ( ATTRIBUTES ':' )? (a= rule_attribute ( ( ',' )? a= rule_attribute )* )? ;
    public final void prolog() throws RecognitionException {
        String pkgstmt = null;

        AttributeDescr a = null;



        		String packageName = "";
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:191:4: ( (pkgstmt= package_statement )? ( ATTRIBUTES ':' )? (a= rule_attribute ( ( ',' )? a= rule_attribute )* )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:191:4: (pkgstmt= package_statement )? ( ATTRIBUTES ':' )? (a= rule_attribute ( ( ',' )? a= rule_attribute )* )?
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:191:4: (pkgstmt= package_statement )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PACKAGE) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:191:6: pkgstmt= package_statement
                    {
                    pushFollow(FOLLOW_package_statement_in_prolog85);
                    pkgstmt=package_statement();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       packageName = pkgstmt; 
                    }

                    }
                    break;

            }

            if ( backtracking==0 ) {
               
              			this.packageDescr = factory.createPackage( packageName ); 
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:195:3: ( ATTRIBUTES ':' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ATTRIBUTES) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:195:4: ATTRIBUTES ':'
                    {
                    match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_prolog99); if (failed) return ;
                    match(input,72,FOLLOW_72_in_prolog101); if (failed) return ;

                    }
                    break;

            }

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:196:3: (a= rule_attribute ( ( ',' )? a= rule_attribute )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DATE_EFFECTIVE||(LA7_0>=DATE_EXPIRES && LA7_0<=ENABLED)||LA7_0==SALIENCE||(LA7_0>=NO_LOOP && LA7_0<=LOCK_ON_ACTIVE)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:196:5: a= rule_attribute ( ( ',' )? a= rule_attribute )*
                    {
                    pushFollow(FOLLOW_rule_attribute_in_prolog111);
                    a=rule_attribute();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {

                       	  	        	this.packageDescr.addAttribute( a );
                      	                
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:200:6: ( ( ',' )? a= rule_attribute )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==COMMA||LA6_0==DATE_EFFECTIVE||(LA6_0>=DATE_EXPIRES && LA6_0<=ENABLED)||LA6_0==SALIENCE||(LA6_0>=NO_LOOP && LA6_0<=LOCK_ON_ACTIVE)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:200:14: ( ',' )? a= rule_attribute
                    	    {
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:200:14: ( ',' )?
                    	    int alt5=2;
                    	    int LA5_0 = input.LA(1);

                    	    if ( (LA5_0==COMMA) ) {
                    	        alt5=1;
                    	    }
                    	    switch (alt5) {
                    	        case 1 :
                    	            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:200:14: ','
                    	            {
                    	            match(input,COMMA,FOLLOW_COMMA_in_prolog134); if (failed) return ;

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_rule_attribute_in_prolog139);
                    	    a=rule_attribute();
                    	    _fsp--;
                    	    if (failed) return ;
                    	    if ( backtracking==0 ) {

                    	       	  	        	this.packageDescr.addAttribute( a );
                    	      	                
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

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
    // $ANTLR end prolog


    // $ANTLR start package_statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:207:1: package_statement returns [String packageName] : PACKAGE n= dotted_name opt_semicolon ;
    public final String package_statement() throws RecognitionException {
        String packageName = null;

        dotted_name_return n = null;



        		packageName = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:212:3: ( PACKAGE n= dotted_name opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:212:3: PACKAGE n= dotted_name opt_semicolon
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_package_statement183); if (failed) return packageName;
            pushFollow(FOLLOW_dotted_name_in_package_statement187);
            n=dotted_name();
            _fsp--;
            if (failed) return packageName;
            pushFollow(FOLLOW_opt_semicolon_in_package_statement189);
            opt_semicolon();
            _fsp--;
            if (failed) return packageName;
            if ( backtracking==0 ) {

              			packageName = input.toString(n.start,n.stop);
              		
            }

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
    // $ANTLR end package_statement


    // $ANTLR start statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:217:1: statement : ( function_import_statement | import_statement | global | function | t= template | r= rule | q= query );
    public final void statement() throws RecognitionException {
        FactTemplateDescr t = null;

        RuleDescr r = null;

        QueryDescr q = null;


        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:218:4: ( function_import_statement | import_statement | global | function | t= template | r= rule | q= query )
            int alt8=7;
            switch ( input.LA(1) ) {
            case IMPORT:
                {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==FUNCTION) ) {
                    alt8=1;
                }
                else if ( (LA8_1==ID) ) {
                    alt8=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("217:1: statement : ( function_import_statement | import_statement | global | function | t= template | r= rule | q= query );", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case GLOBAL:
                {
                alt8=3;
                }
                break;
            case FUNCTION:
                {
                alt8=4;
                }
                break;
            case TEMPLATE:
                {
                alt8=5;
                }
                break;
            case RULE:
                {
                alt8=6;
                }
                break;
            case QUERY:
                {
                alt8=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("217:1: statement : ( function_import_statement | import_statement | global | function | t= template | r= rule | q= query );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:218:4: function_import_statement
                    {
                    pushFollow(FOLLOW_function_import_statement_in_statement203);
                    function_import_statement();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:219:4: import_statement
                    {
                    pushFollow(FOLLOW_import_statement_in_statement209);
                    import_statement();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:220:4: global
                    {
                    pushFollow(FOLLOW_global_in_statement215);
                    global();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 4 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:221:4: function
                    {
                    pushFollow(FOLLOW_function_in_statement221);
                    function();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 5 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:222:10: t= template
                    {
                    pushFollow(FOLLOW_template_in_statement235);
                    t=template();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       this.packageDescr.addFactTemplate( t ); 
                    }

                    }
                    break;
                case 6 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:223:4: r= rule
                    {
                    pushFollow(FOLLOW_rule_in_statement244);
                    r=rule();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       this.packageDescr.addRule( r ); 
                    }

                    }
                    break;
                case 7 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:224:4: q= query
                    {
                    pushFollow(FOLLOW_query_in_statement256);
                    q=query();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       this.packageDescr.addRule( q ); 
                    }

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
    // $ANTLR end statement


    // $ANTLR start import_statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:229:1: import_statement : IMPORT import_name[importDecl] opt_semicolon ;
    public final void import_statement() throws RecognitionException {
        Token IMPORT1=null;


                	ImportDescr importDecl = null;
                
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:233:4: ( IMPORT import_name[importDecl] opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:233:4: IMPORT import_name[importDecl] opt_semicolon
            {
            IMPORT1=(Token)input.LT(1);
            match(input,IMPORT,FOLLOW_IMPORT_in_import_statement285); if (failed) return ;
            if ( backtracking==0 ) {

              	            importDecl = factory.createImport( );
              	            importDecl.setStartCharacter( ((CommonToken)IMPORT1).getStartIndex() );
              		    if (packageDescr != null) {
              			packageDescr.addImport( importDecl );
              		    }
              	        
            }
            pushFollow(FOLLOW_import_name_in_import_statement308);
            import_name(importDecl);
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_opt_semicolon_in_import_statement311);
            opt_semicolon();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end import_statement


    // $ANTLR start function_import_statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:244:1: function_import_statement : IMPORT FUNCTION import_name[importDecl] opt_semicolon ;
    public final void function_import_statement() throws RecognitionException {
        Token IMPORT2=null;


                	FunctionImportDescr importDecl = null;
                
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:248:4: ( IMPORT FUNCTION import_name[importDecl] opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:248:4: IMPORT FUNCTION import_name[importDecl] opt_semicolon
            {
            IMPORT2=(Token)input.LT(1);
            match(input,IMPORT,FOLLOW_IMPORT_in_function_import_statement335); if (failed) return ;
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function_import_statement337); if (failed) return ;
            if ( backtracking==0 ) {

              	            importDecl = factory.createFunctionImport();
              	            importDecl.setStartCharacter( ((CommonToken)IMPORT2).getStartIndex() );
              		    if (packageDescr != null) {
              			packageDescr.addFunctionImport( importDecl );
              		    }
              	        
            }
            pushFollow(FOLLOW_import_name_in_function_import_statement360);
            import_name(importDecl);
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_opt_semicolon_in_function_import_statement363);
            opt_semicolon();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end function_import_statement


    // $ANTLR start import_name
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:260:1: import_name[ImportDescr importDecl] returns [String name] : ID ( DOT id= identifier )* (star= '.*' )? ;
    public final String import_name(ImportDescr importDecl) throws RecognitionException {
        String name = null;

        Token star=null;
        Token ID3=null;
        Token DOT4=null;
        identifier_return id = null;



        		name = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:265:3: ( ID ( DOT id= identifier )* (star= '.*' )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:265:3: ID ( DOT id= identifier )* (star= '.*' )?
            {
            ID3=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_import_name389); if (failed) return name;
            if ( backtracking==0 ) {
               
              		    name =ID3.getText(); 
              		    importDecl.setTarget( name );
              		    importDecl.setEndCharacter( ((CommonToken)ID3).getStopIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:271:3: ( DOT id= identifier )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==DOT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:271:5: DOT id= identifier
            	    {
            	    DOT4=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_import_name401); if (failed) return name;
            	    pushFollow(FOLLOW_identifier_in_import_name405);
            	    id=identifier();
            	    _fsp--;
            	    if (failed) return name;
            	    if ( backtracking==0 ) {
            	       
            	      		        name = name + DOT4.getText() + input.toString(id.start,id.stop); 
            	      			importDecl.setTarget( name );
            	      		        importDecl.setEndCharacter( ((CommonToken)((Token)id.start)).getStopIndex() );
            	      		    
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:278:3: (star= '.*' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==73) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:278:5: star= '.*'
                    {
                    star=(Token)input.LT(1);
                    match(input,73,FOLLOW_73_in_import_name429); if (failed) return name;
                    if ( backtracking==0 ) {
                       
                      		        name = name + star.getText(); 
                      			importDecl.setTarget( name );
                      		        importDecl.setEndCharacter( ((CommonToken)star).getStopIndex() );
                      		    
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end import_name


    // $ANTLR start global
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:288:1: global : GLOBAL type= dotted_name id= identifier opt_semicolon ;
    public final void global() throws RecognitionException {
        Token GLOBAL5=null;
        dotted_name_return type = null;

        identifier_return id = null;



        	    GlobalDescr global = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:293:3: ( GLOBAL type= dotted_name id= identifier opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:293:3: GLOBAL type= dotted_name id= identifier opt_semicolon
            {
            GLOBAL5=(Token)input.LT(1);
            match(input,GLOBAL,FOLLOW_GLOBAL_in_global463); if (failed) return ;
            if ( backtracking==0 ) {

              		    global = factory.createGlobal();
              	            global.setStartCharacter( ((CommonToken)GLOBAL5).getStartIndex() );
              		    packageDescr.addGlobal( global );
              		
            }
            pushFollow(FOLLOW_dotted_name_in_global474);
            type=dotted_name();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              		    global.setType( input.toString(type.start,type.stop) );
              		
            }
            pushFollow(FOLLOW_identifier_in_global485);
            id=identifier();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_opt_semicolon_in_global487);
            opt_semicolon();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              		    global.setIdentifier( input.toString(id.start,id.stop) );
              		    global.setEndCharacter( ((CommonToken)((Token)id.start)).getStopIndex() );
              		
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
    // $ANTLR end global


    // $ANTLR start function
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:311:1: function : FUNCTION (retType= dotted_name )? id= identifier LEFT_PAREN ( (paramType= dotted_name )? paramName= argument ( COMMA (paramType= dotted_name )? paramName= argument )* )? RIGHT_PAREN body= curly_chunk ;
    public final void function() throws RecognitionException {
        Token FUNCTION6=null;
        dotted_name_return retType = null;

        identifier_return id = null;

        dotted_name_return paramType = null;

        String paramName = null;

        curly_chunk_return body = null;



        		FunctionDescr f = null;
        		String type = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:317:3: ( FUNCTION (retType= dotted_name )? id= identifier LEFT_PAREN ( (paramType= dotted_name )? paramName= argument ( COMMA (paramType= dotted_name )? paramName= argument )* )? RIGHT_PAREN body= curly_chunk )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:317:3: FUNCTION (retType= dotted_name )? id= identifier LEFT_PAREN ( (paramType= dotted_name )? paramName= argument ( COMMA (paramType= dotted_name )? paramName= argument )* )? RIGHT_PAREN body= curly_chunk
            {
            FUNCTION6=(Token)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function512); if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:317:19: (retType= dotted_name )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=ATTRIBUTES && LA11_0<=ID)||LA11_0==GLOBAL||(LA11_0>=QUERY && LA11_0<=WHEN)||LA11_0==ENABLED||LA11_0==SALIENCE||LA11_0==DURATION||LA11_0==FROM||(LA11_0>=INIT && LA11_0<=RESULT)||(LA11_0>=CONTAINS && LA11_0<=IN)||LA11_0==THEN) ) {
                int LA11_1 = input.LA(2);

                if ( ((LA11_1>=ATTRIBUTES && LA11_1<=GLOBAL)||(LA11_1>=QUERY && LA11_1<=WHEN)||LA11_1==ENABLED||LA11_1==SALIENCE||LA11_1==DURATION||LA11_1==FROM||(LA11_1>=INIT && LA11_1<=RESULT)||(LA11_1>=CONTAINS && LA11_1<=IN)||LA11_1==LEFT_SQUARE||LA11_1==THEN) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:317:19: retType= dotted_name
                    {
                    pushFollow(FOLLOW_dotted_name_in_function516);
                    retType=dotted_name();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_identifier_in_function521);
            id=identifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              			//System.err.println( "function :: " + n.getText() );
              			type = retType != null ? input.toString(retType.start,retType.stop) : null;
              			f = factory.createFunction( input.toString(id.start,id.stop), type );
              			f.setLocation(offset(FUNCTION6.getLine()), FUNCTION6.getCharPositionInLine());
              	        	f.setStartCharacter( ((CommonToken)FUNCTION6).getStartIndex() );
              			packageDescr.addFunction( f );
              		
            }
            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_function530); if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:327:4: ( (paramType= dotted_name )? paramName= argument ( COMMA (paramType= dotted_name )? paramName= argument )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=ATTRIBUTES && LA15_0<=ID)||LA15_0==GLOBAL||(LA15_0>=QUERY && LA15_0<=WHEN)||LA15_0==ENABLED||LA15_0==SALIENCE||LA15_0==DURATION||LA15_0==FROM||(LA15_0>=INIT && LA15_0<=RESULT)||(LA15_0>=CONTAINS && LA15_0<=IN)||LA15_0==THEN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:327:6: (paramType= dotted_name )? paramName= argument ( COMMA (paramType= dotted_name )? paramName= argument )*
                    {
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:327:15: (paramType= dotted_name )?
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:327:15: paramType= dotted_name
                            {
                            pushFollow(FOLLOW_dotted_name_in_function539);
                            paramType=dotted_name();
                            _fsp--;
                            if (failed) return ;

                            }
                            break;

                    }

                    pushFollow(FOLLOW_argument_in_function544);
                    paramName=argument();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {

                      					type = paramType != null ? input.toString(paramType.start,paramType.stop) : null;
                      					f.addParameter( type, paramName );
                      				
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:332:5: ( COMMA (paramType= dotted_name )? paramName= argument )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:332:7: COMMA (paramType= dotted_name )? paramName= argument
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_function558); if (failed) return ;
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:332:22: (paramType= dotted_name )?
                    	    int alt13=2;
                    	    alt13 = dfa13.predict(input);
                    	    switch (alt13) {
                    	        case 1 :
                    	            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:332:22: paramType= dotted_name
                    	            {
                    	            pushFollow(FOLLOW_dotted_name_in_function562);
                    	            paramType=dotted_name();
                    	            _fsp--;
                    	            if (failed) return ;

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_argument_in_function567);
                    	    paramName=argument();
                    	    _fsp--;
                    	    if (failed) return ;
                    	    if ( backtracking==0 ) {

                    	      						type = paramType != null ? input.toString(paramType.start,paramType.stop) : null;
                    	      						f.addParameter( type, paramName );
                    	      					
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_function591); if (failed) return ;
            pushFollow(FOLLOW_curly_chunk_in_function597);
            body=curly_chunk();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              			//strip out '{','}'
              			f.setText( input.toString(body.start,body.stop).substring( 1, input.toString(body.start,body.stop).length()-1 ) );
              		
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
    // $ANTLR end function


    // $ANTLR start argument
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:347:1: argument returns [String name] : id= identifier ( '[' ']' )* ;
    public final String argument() throws RecognitionException {
        String name = null;

        identifier_return id = null;



        		name = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:351:4: (id= identifier ( '[' ']' )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:351:4: id= identifier ( '[' ']' )*
            {
            pushFollow(FOLLOW_identifier_in_argument624);
            id=identifier();
            _fsp--;
            if (failed) return name;
            if ( backtracking==0 ) {
               name =input.toString(id.start,id.stop); 
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:351:38: ( '[' ']' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==LEFT_SQUARE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:351:40: '[' ']'
            	    {
            	    match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_argument630); if (failed) return name;
            	    match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_argument632); if (failed) return name;
            	    if ( backtracking==0 ) {
            	       name += "[]";
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end argument


    // $ANTLR start query
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:356:1: query returns [QueryDescr query] : QUERY queryName= name ( LEFT_PAREN ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )? RIGHT_PAREN )? normal_lhs_block[lhs] END opt_semicolon ;
    public final QueryDescr query() throws RecognitionException {
        QueryDescr query = null;

        Token paramName=null;
        Token QUERY7=null;
        Token END8=null;
        String queryName = null;

        qualified_id_return paramType = null;



        		query = null;
        		AndDescr lhs = null;
        		List params = null;
        		List types = null;		
         
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:365:3: ( QUERY queryName= name ( LEFT_PAREN ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )? RIGHT_PAREN )? normal_lhs_block[lhs] END opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:365:3: QUERY queryName= name ( LEFT_PAREN ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )? RIGHT_PAREN )? normal_lhs_block[lhs] END opt_semicolon
            {
            QUERY7=(Token)input.LT(1);
            match(input,QUERY,FOLLOW_QUERY_in_query662); if (failed) return query;
            pushFollow(FOLLOW_name_in_query666);
            queryName=name();
            _fsp--;
            if (failed) return query;
            if ( backtracking==0 ) {
               
              			query = factory.createQuery( queryName ); 
              			query.setLocation( offset(QUERY7.getLine()), QUERY7.getCharPositionInLine() );
              			query.setStartCharacter( ((CommonToken)QUERY7).getStartIndex() );
              			lhs = new AndDescr(); query.setLhs( lhs ); 
              			lhs.setLocation( offset(QUERY7.getLine()), QUERY7.getCharPositionInLine() );
                                      location.setType( Location.LOCATION_RULE_HEADER );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:374:3: ( LEFT_PAREN ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )? RIGHT_PAREN )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:374:5: LEFT_PAREN ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )? RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_query676); if (failed) return query;
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:375:11: ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==ID) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:375:13: ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )*
                            {
                            if ( backtracking==0 ) {
                               params = new ArrayList(); types = new ArrayList();
                            }
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:377:15: ( (paramType= qualified_id )? paramName= ID )
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:377:16: (paramType= qualified_id )? paramName= ID
                            {
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:377:25: (paramType= qualified_id )?
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==ID) ) {
                                int LA17_1 = input.LA(2);

                                if ( ((LA17_1>=ID && LA17_1<=DOT)||LA17_1==LEFT_SQUARE) ) {
                                    alt17=1;
                                }
                            }
                            switch (alt17) {
                                case 1 :
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:377:25: paramType= qualified_id
                                    {
                                    pushFollow(FOLLOW_qualified_id_in_query711);
                                    paramType=qualified_id();
                                    _fsp--;
                                    if (failed) return query;

                                    }
                                    break;

                            }

                            paramName=(Token)input.LT(1);
                            match(input,ID,FOLLOW_ID_in_query716); if (failed) return query;
                            if ( backtracking==0 ) {
                               params.add( paramName.getText() ); String type = (paramType != null) ? input.toString(paramType.start,paramType.stop) : "Object"; types.add( type ); 
                            }

                            }

                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:378:15: ( COMMA (paramType= qualified_id )? paramName= ID )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==COMMA) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:378:16: COMMA (paramType= qualified_id )? paramName= ID
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_query737); if (failed) return query;
                            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:378:31: (paramType= qualified_id )?
                            	    int alt18=2;
                            	    int LA18_0 = input.LA(1);

                            	    if ( (LA18_0==ID) ) {
                            	        int LA18_1 = input.LA(2);

                            	        if ( ((LA18_1>=ID && LA18_1<=DOT)||LA18_1==LEFT_SQUARE) ) {
                            	            alt18=1;
                            	        }
                            	    }
                            	    switch (alt18) {
                            	        case 1 :
                            	            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:378:31: paramType= qualified_id
                            	            {
                            	            pushFollow(FOLLOW_qualified_id_in_query741);
                            	            paramType=qualified_id();
                            	            _fsp--;
                            	            if (failed) return query;

                            	            }
                            	            break;

                            	    }

                            	    paramName=(Token)input.LT(1);
                            	    match(input,ID,FOLLOW_ID_in_query746); if (failed) return query;
                            	    if ( backtracking==0 ) {
                            	       params.add( paramName.getText() );  String type = (paramType != null) ? input.toString(paramType.start,paramType.stop) : "Object"; types.add( type );  
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);

                            if ( backtracking==0 ) {
                              	query.setParameters( (String[]) params.toArray( new String[params.size()] ) ); 
                              		            	query.setParameterTypes( (String[]) types.toArray( new String[types.size()] ) ); 
                              		            
                            }

                            }
                            break;

                    }

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_query796); if (failed) return query;

                    }
                    break;

            }

            if ( backtracking==0 ) {

                                      location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
              	        
            }
            pushFollow(FOLLOW_normal_lhs_block_in_query825);
            normal_lhs_block(lhs);
            _fsp--;
            if (failed) return query;
            END8=(Token)input.LT(1);
            match(input,END,FOLLOW_END_in_query830); if (failed) return query;
            pushFollow(FOLLOW_opt_semicolon_in_query832);
            opt_semicolon();
            _fsp--;
            if (failed) return query;
            if ( backtracking==0 ) {

              			query.setEndCharacter( ((CommonToken)END8).getStopIndex() );
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return query;
    }
    // $ANTLR end query


    // $ANTLR start template
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:396:1: template returns [FactTemplateDescr template] : TEMPLATE templateName= name opt_semicolon (slot= template_slot )+ END opt_semicolon ;
    public final FactTemplateDescr template() throws RecognitionException {
        FactTemplateDescr template = null;

        Token TEMPLATE9=null;
        Token END10=null;
        String templateName = null;

        FieldTemplateDescr slot = null;



        		template = null;		
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:401:3: ( TEMPLATE templateName= name opt_semicolon (slot= template_slot )+ END opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:401:3: TEMPLATE templateName= name opt_semicolon (slot= template_slot )+ END opt_semicolon
            {
            TEMPLATE9=(Token)input.LT(1);
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_template860); if (failed) return template;
            pushFollow(FOLLOW_name_in_template864);
            templateName=name();
            _fsp--;
            if (failed) return template;
            pushFollow(FOLLOW_opt_semicolon_in_template866);
            opt_semicolon();
            _fsp--;
            if (failed) return template;
            if ( backtracking==0 ) {

              			template = new FactTemplateDescr(templateName);
              			template.setLocation( offset(TEMPLATE9.getLine()), TEMPLATE9.getCharPositionInLine() );			
              			template.setStartCharacter( ((CommonToken)TEMPLATE9).getStartIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:407:3: (slot= template_slot )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:408:4: slot= template_slot
            	    {
            	    pushFollow(FOLLOW_template_slot_in_template881);
            	    slot=template_slot();
            	    _fsp--;
            	    if (failed) return template;
            	    if ( backtracking==0 ) {

            	      				template.addFieldTemplate( slot );
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (backtracking>0) {failed=true; return template;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            END10=(Token)input.LT(1);
            match(input,END,FOLLOW_END_in_template896); if (failed) return template;
            pushFollow(FOLLOW_opt_semicolon_in_template898);
            opt_semicolon();
            _fsp--;
            if (failed) return template;
            if ( backtracking==0 ) {

              			template.setEndCharacter( ((CommonToken)END10).getStopIndex() );
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return template;
    }
    // $ANTLR end template


    // $ANTLR start template_slot
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:419:1: template_slot returns [FieldTemplateDescr field] : fieldType= qualified_id id= identifier opt_semicolon ;
    public final FieldTemplateDescr template_slot() throws RecognitionException {
        FieldTemplateDescr field = null;

        qualified_id_return fieldType = null;

        identifier_return id = null;



        		field = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:424:11: (fieldType= qualified_id id= identifier opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:424:11: fieldType= qualified_id id= identifier opt_semicolon
            {
            if ( backtracking==0 ) {

              			field = factory.createFieldTemplate();
              	         
            }
            pushFollow(FOLLOW_qualified_id_in_template_slot944);
            fieldType=qualified_id();
            _fsp--;
            if (failed) return field;
            if ( backtracking==0 ) {

              		        field.setClassType( input.toString(fieldType.start,fieldType.stop) );
              			field.setStartCharacter( ((CommonToken)((Token)fieldType.start)).getStartIndex() );
              			field.setEndCharacter( ((CommonToken)((Token)fieldType.stop)).getStopIndex() );
              		 
            }
            pushFollow(FOLLOW_identifier_in_template_slot960);
            id=identifier();
            _fsp--;
            if (failed) return field;
            pushFollow(FOLLOW_opt_semicolon_in_template_slot962);
            opt_semicolon();
            _fsp--;
            if (failed) return field;
            if ( backtracking==0 ) {

              		        field.setName( input.toString(id.start,id.stop) );
              			field.setLocation( offset(((Token)id.start).getLine()), ((Token)id.start).getCharPositionInLine() );
              			field.setEndCharacter( ((CommonToken)((Token)id.start)).getStopIndex() );
              		 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return field;
    }
    // $ANTLR end template_slot


    // $ANTLR start rule
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:442:1: rule returns [RuleDescr rule] : RULE ruleName= name ( rule_attributes[$rule] )? ( WHEN ( ':' )? normal_lhs_block[lhs] )? rhs_chunk[$rule] ;
    public final RuleDescr rule() throws RecognitionException {
        RuleDescr rule = null;

        Token RULE11=null;
        Token WHEN12=null;
        String ruleName = null;



        		rule = null;
        		AndDescr lhs = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:448:3: ( RULE ruleName= name ( rule_attributes[$rule] )? ( WHEN ( ':' )? normal_lhs_block[lhs] )? rhs_chunk[$rule] )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:448:3: RULE ruleName= name ( rule_attributes[$rule] )? ( WHEN ( ':' )? normal_lhs_block[lhs] )? rhs_chunk[$rule]
            {
            RULE11=(Token)input.LT(1);
            match(input,RULE,FOLLOW_RULE_in_rule993); if (failed) return rule;
            pushFollow(FOLLOW_name_in_rule997);
            ruleName=name();
            _fsp--;
            if (failed) return rule;
            if ( backtracking==0 ) {
               
              			location.setType( Location.LOCATION_RULE_HEADER );
              			debug( "start rule: " + ruleName );
              			rule = new RuleDescr( ruleName, null ); 
              			rule.setLocation( offset(RULE11.getLine()), RULE11.getCharPositionInLine() );
              			rule.setStartCharacter( ((CommonToken)RULE11).getStartIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:456:3: ( rule_attributes[$rule] )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ATTRIBUTES||LA23_0==DATE_EFFECTIVE||(LA23_0>=DATE_EXPIRES && LA23_0<=ENABLED)||LA23_0==SALIENCE||(LA23_0>=NO_LOOP && LA23_0<=LOCK_ON_ACTIVE)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:456:3: rule_attributes[$rule]
                    {
                    pushFollow(FOLLOW_rule_attributes_in_rule1006);
                    rule_attributes(rule);
                    _fsp--;
                    if (failed) return rule;

                    }
                    break;

            }

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:457:3: ( WHEN ( ':' )? normal_lhs_block[lhs] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==WHEN) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:458:4: WHEN ( ':' )? normal_lhs_block[lhs]
                    {
                    WHEN12=(Token)input.LT(1);
                    match(input,WHEN,FOLLOW_WHEN_in_rule1018); if (failed) return rule;
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:458:9: ( ':' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==72) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:458:9: ':'
                            {
                            match(input,72,FOLLOW_72_in_rule1020); if (failed) return rule;

                            }
                            break;

                    }

                    if ( backtracking==0 ) {
                       
                      				this.location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
                      				lhs = new AndDescr(); rule.setLhs( lhs ); 
                      				lhs.setLocation( offset(WHEN12.getLine()), WHEN12.getCharPositionInLine() );
                      				lhs.setStartCharacter( ((CommonToken)WHEN12).getStartIndex() );
                      			
                    }
                    pushFollow(FOLLOW_normal_lhs_block_in_rule1031);
                    normal_lhs_block(lhs);
                    _fsp--;
                    if (failed) return rule;

                    }
                    break;

            }

            pushFollow(FOLLOW_rhs_chunk_in_rule1041);
            rhs_chunk(rule);
            _fsp--;
            if (failed) return rule;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rule;
    }
    // $ANTLR end rule


    // $ANTLR start rule_attributes
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:472:1: rule_attributes[RuleDescr rule] : ( ATTRIBUTES ':' )? attr= rule_attribute ( ( ',' )? attr= rule_attribute )* ;
    public final void rule_attributes(RuleDescr rule) throws RecognitionException {
        AttributeDescr attr = null;


        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:474:2: ( ( ATTRIBUTES ':' )? attr= rule_attribute ( ( ',' )? attr= rule_attribute )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:474:2: ( ATTRIBUTES ':' )? attr= rule_attribute ( ( ',' )? attr= rule_attribute )*
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:474:2: ( ATTRIBUTES ':' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ATTRIBUTES) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:474:4: ATTRIBUTES ':'
                    {
                    match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_rule_attributes1061); if (failed) return ;
                    match(input,72,FOLLOW_72_in_rule_attributes1063); if (failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_rule_attribute_in_rule_attributes1071);
            attr=rule_attribute();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               rule.addAttribute( attr ); 
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:476:2: ( ( ',' )? attr= rule_attribute )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==COMMA||LA28_0==DATE_EFFECTIVE||(LA28_0>=DATE_EXPIRES && LA28_0<=ENABLED)||LA28_0==SALIENCE||(LA28_0>=NO_LOOP && LA28_0<=LOCK_ON_ACTIVE)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:476:4: ( ',' )? attr= rule_attribute
            	    {
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:476:4: ( ',' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==COMMA) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:476:4: ','
            	            {
            	            match(input,COMMA,FOLLOW_COMMA_in_rule_attributes1078); if (failed) return ;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_rule_attribute_in_rule_attributes1083);
            	    attr=rule_attribute();
            	    _fsp--;
            	    if (failed) return ;
            	    if ( backtracking==0 ) {
            	       rule.addAttribute( attr ); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


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
    // $ANTLR end rule_attributes


    // $ANTLR start rule_attribute
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:481:1: rule_attribute returns [AttributeDescr attr] : (a= salience | a= no_loop | a= agenda_group | a= duration | a= activation_group | a= auto_focus | a= date_effective | a= date_expires | a= enabled | a= ruleflow_group | a= lock_on_active | a= dialect );
    public final AttributeDescr rule_attribute() throws RecognitionException {
        AttributeDescr attr = null;

        AttributeDescr a = null;



        		attr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:488:4: (a= salience | a= no_loop | a= agenda_group | a= duration | a= activation_group | a= auto_focus | a= date_effective | a= date_expires | a= enabled | a= ruleflow_group | a= lock_on_active | a= dialect )
            int alt29=12;
            switch ( input.LA(1) ) {
            case SALIENCE:
                {
                alt29=1;
                }
                break;
            case NO_LOOP:
                {
                alt29=2;
                }
                break;
            case AGENDA_GROUP:
                {
                alt29=3;
                }
                break;
            case DURATION:
                {
                alt29=4;
                }
                break;
            case ACTIVATION_GROUP:
                {
                alt29=5;
                }
                break;
            case AUTO_FOCUS:
                {
                alt29=6;
                }
                break;
            case DATE_EFFECTIVE:
                {
                alt29=7;
                }
                break;
            case DATE_EXPIRES:
                {
                alt29=8;
                }
                break;
            case ENABLED:
                {
                alt29=9;
                }
                break;
            case RULEFLOW_GROUP:
                {
                alt29=10;
                }
                break;
            case LOCK_ON_ACTIVE:
                {
                alt29=11;
                }
                break;
            case DIALECT:
                {
                alt29=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return attr;}
                NoViableAltException nvae =
                    new NoViableAltException("481:1: rule_attribute returns [AttributeDescr attr] : (a= salience | a= no_loop | a= agenda_group | a= duration | a= activation_group | a= auto_focus | a= date_effective | a= date_expires | a= enabled | a= ruleflow_group | a= lock_on_active | a= dialect );", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:488:4: a= salience
                    {
                    pushFollow(FOLLOW_salience_in_rule_attribute1120);
                    a=salience();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:489:4: a= no_loop
                    {
                    pushFollow(FOLLOW_no_loop_in_rule_attribute1128);
                    a=no_loop();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:490:4: a= agenda_group
                    {
                    pushFollow(FOLLOW_agenda_group_in_rule_attribute1137);
                    a=agenda_group();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 4 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:491:4: a= duration
                    {
                    pushFollow(FOLLOW_duration_in_rule_attribute1146);
                    a=duration();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 5 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:492:4: a= activation_group
                    {
                    pushFollow(FOLLOW_activation_group_in_rule_attribute1155);
                    a=activation_group();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 6 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:493:4: a= auto_focus
                    {
                    pushFollow(FOLLOW_auto_focus_in_rule_attribute1163);
                    a=auto_focus();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 7 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:494:4: a= date_effective
                    {
                    pushFollow(FOLLOW_date_effective_in_rule_attribute1171);
                    a=date_effective();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 8 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:495:4: a= date_expires
                    {
                    pushFollow(FOLLOW_date_expires_in_rule_attribute1179);
                    a=date_expires();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 9 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:496:4: a= enabled
                    {
                    pushFollow(FOLLOW_enabled_in_rule_attribute1187);
                    a=enabled();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 10 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:497:4: a= ruleflow_group
                    {
                    pushFollow(FOLLOW_ruleflow_group_in_rule_attribute1195);
                    a=ruleflow_group();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 11 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:498:4: a= lock_on_active
                    {
                    pushFollow(FOLLOW_lock_on_active_in_rule_attribute1203);
                    a=lock_on_active();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;
                case 12 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:499:4: a= dialect
                    {
                    pushFollow(FOLLOW_dialect_in_rule_attribute1210);
                    a=dialect();
                    _fsp--;
                    if (failed) return attr;

                    }
                    break;

            }
            if ( backtracking==0 ) {

              		attr = a;
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return attr;
    }
    // $ANTLR end rule_attribute


    // $ANTLR start date_effective
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:502:1: date_effective returns [AttributeDescr descr] : DATE_EFFECTIVE STRING ;
    public final AttributeDescr date_effective() throws RecognitionException {
        AttributeDescr descr = null;

        Token STRING13=null;
        Token DATE_EFFECTIVE14=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:507:3: ( DATE_EFFECTIVE STRING )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:507:3: DATE_EFFECTIVE STRING
            {
            DATE_EFFECTIVE14=(Token)input.LT(1);
            match(input,DATE_EFFECTIVE,FOLLOW_DATE_EFFECTIVE_in_date_effective1236); if (failed) return descr;
            STRING13=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_date_effective1238); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "date-effective", getString( STRING13.getText() ) );
              			descr.setLocation( offset( DATE_EFFECTIVE14.getLine() ), DATE_EFFECTIVE14.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)DATE_EFFECTIVE14).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)STRING13).getStopIndex() );
              		
            }

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
    // $ANTLR end date_effective


    // $ANTLR start date_expires
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:517:1: date_expires returns [AttributeDescr descr] : DATE_EXPIRES STRING ;
    public final AttributeDescr date_expires() throws RecognitionException {
        AttributeDescr descr = null;

        Token STRING15=null;
        Token DATE_EXPIRES16=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:521:4: ( DATE_EXPIRES STRING )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:521:4: DATE_EXPIRES STRING
            {
            DATE_EXPIRES16=(Token)input.LT(1);
            match(input,DATE_EXPIRES,FOLLOW_DATE_EXPIRES_in_date_expires1267); if (failed) return descr;
            STRING15=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_date_expires1269); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "date-expires", getString( STRING15.getText() ) );
              			descr.setLocation( offset(DATE_EXPIRES16.getLine()), DATE_EXPIRES16.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)DATE_EXPIRES16).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)STRING15).getStopIndex() );
              		
            }

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
    // $ANTLR end date_expires


    // $ANTLR start enabled
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:530:1: enabled returns [AttributeDescr descr] : ENABLED BOOL ;
    public final AttributeDescr enabled() throws RecognitionException {
        AttributeDescr descr = null;

        Token BOOL17=null;
        Token ENABLED18=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:534:5: ( ENABLED BOOL )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:534:5: ENABLED BOOL
            {
            ENABLED18=(Token)input.LT(1);
            match(input,ENABLED,FOLLOW_ENABLED_in_enabled1298); if (failed) return descr;
            BOOL17=(Token)input.LT(1);
            match(input,BOOL,FOLLOW_BOOL_in_enabled1300); if (failed) return descr;
            if ( backtracking==0 ) {

              				descr = new AttributeDescr( "enabled", BOOL17.getText() );
              				descr.setLocation( offset(ENABLED18.getLine()), ENABLED18.getCharPositionInLine() );
              				descr.setStartCharacter( ((CommonToken)ENABLED18).getStartIndex() );
              				descr.setEndCharacter( ((CommonToken)BOOL17).getStopIndex() );
              			
            }

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
    // $ANTLR end enabled


    // $ANTLR start salience
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:543:1: salience returns [AttributeDescr descr] : SALIENCE ( INT | txt= paren_chunk ) ;
    public final AttributeDescr salience() throws RecognitionException {
        AttributeDescr descr = null;

        Token SALIENCE19=null;
        Token INT20=null;
        paren_chunk_return txt = null;



        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:548:3: ( SALIENCE ( INT | txt= paren_chunk ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:548:3: SALIENCE ( INT | txt= paren_chunk )
            {
            SALIENCE19=(Token)input.LT(1);
            match(input,SALIENCE,FOLLOW_SALIENCE_in_salience1333); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "salience" );
              			descr.setLocation( offset(SALIENCE19.getLine()), SALIENCE19.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)SALIENCE19).getStartIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:554:3: ( INT | txt= paren_chunk )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==INT) ) {
                alt30=1;
            }
            else if ( (LA30_0==LEFT_PAREN) ) {
                alt30=2;
            }
            else {
                if (backtracking>0) {failed=true; return descr;}
                NoViableAltException nvae =
                    new NoViableAltException("554:3: ( INT | txt= paren_chunk )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:554:5: INT
                    {
                    INT20=(Token)input.LT(1);
                    match(input,INT,FOLLOW_INT_in_salience1344); if (failed) return descr;
                    if ( backtracking==0 ) {

                      			descr.setValue( INT20.getText() );
                      			descr.setEndCharacter( ((CommonToken)INT20).getStopIndex() );
                      		
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:559:5: txt= paren_chunk
                    {
                    pushFollow(FOLLOW_paren_chunk_in_salience1359);
                    txt=paren_chunk();
                    _fsp--;
                    if (failed) return descr;
                    if ( backtracking==0 ) {

                      			descr.setValue( input.toString(txt.start,txt.stop) );
                      			descr.setEndCharacter( ((CommonToken)((Token)txt.stop)).getStopIndex() );
                      		
                    }

                    }
                    break;

            }


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
    // $ANTLR end salience


    // $ANTLR start no_loop
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:567:1: no_loop returns [AttributeDescr descr] : NO_LOOP ( BOOL )? ;
    public final AttributeDescr no_loop() throws RecognitionException {
        AttributeDescr descr = null;

        Token NO_LOOP21=null;
        Token BOOL22=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:571:4: ( NO_LOOP ( BOOL )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:571:4: NO_LOOP ( BOOL )?
            {
            NO_LOOP21=(Token)input.LT(1);
            match(input,NO_LOOP,FOLLOW_NO_LOOP_in_no_loop1389); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "no-loop", "true" );
              			descr.setLocation( offset(NO_LOOP21.getLine()), NO_LOOP21.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)NO_LOOP21).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)NO_LOOP21).getStopIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:578:3: ( BOOL )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==BOOL) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:578:5: BOOL
                    {
                    BOOL22=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_no_loop1402); if (failed) return descr;
                    if ( backtracking==0 ) {

                      				descr.setValue( BOOL22.getText() );
                      				descr.setEndCharacter( ((CommonToken)BOOL22).getStopIndex() );
                      			
                    }

                    }
                    break;

            }


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
    // $ANTLR end no_loop


    // $ANTLR start auto_focus
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:586:1: auto_focus returns [AttributeDescr descr] : AUTO_FOCUS ( BOOL )? ;
    public final AttributeDescr auto_focus() throws RecognitionException {
        AttributeDescr descr = null;

        Token AUTO_FOCUS23=null;
        Token BOOL24=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:590:4: ( AUTO_FOCUS ( BOOL )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:590:4: AUTO_FOCUS ( BOOL )?
            {
            AUTO_FOCUS23=(Token)input.LT(1);
            match(input,AUTO_FOCUS,FOLLOW_AUTO_FOCUS_in_auto_focus1437); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "auto-focus", "true" );
              			descr.setLocation( offset(AUTO_FOCUS23.getLine()), AUTO_FOCUS23.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)AUTO_FOCUS23).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)AUTO_FOCUS23).getStopIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:597:3: ( BOOL )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==BOOL) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:597:5: BOOL
                    {
                    BOOL24=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_auto_focus1450); if (failed) return descr;
                    if ( backtracking==0 ) {

                      				descr.setValue( BOOL24.getText() );
                      				descr.setEndCharacter( ((CommonToken)BOOL24).getStopIndex() );
                      			
                    }

                    }
                    break;

            }


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
    // $ANTLR end auto_focus


    // $ANTLR start activation_group
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:605:1: activation_group returns [AttributeDescr descr] : ACTIVATION_GROUP STRING ;
    public final AttributeDescr activation_group() throws RecognitionException {
        AttributeDescr descr = null;

        Token STRING25=null;
        Token ACTIVATION_GROUP26=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:609:4: ( ACTIVATION_GROUP STRING )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:609:4: ACTIVATION_GROUP STRING
            {
            ACTIVATION_GROUP26=(Token)input.LT(1);
            match(input,ACTIVATION_GROUP,FOLLOW_ACTIVATION_GROUP_in_activation_group1486); if (failed) return descr;
            STRING25=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_activation_group1488); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "activation-group", getString( STRING25.getText() ) );
              			descr.setLocation( offset(ACTIVATION_GROUP26.getLine()), ACTIVATION_GROUP26.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)ACTIVATION_GROUP26).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)STRING25).getStopIndex() );
              		
            }

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
    // $ANTLR end activation_group


    // $ANTLR start ruleflow_group
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:618:1: ruleflow_group returns [AttributeDescr descr] : RULEFLOW_GROUP STRING ;
    public final AttributeDescr ruleflow_group() throws RecognitionException {
        AttributeDescr descr = null;

        Token STRING27=null;
        Token RULEFLOW_GROUP28=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:622:4: ( RULEFLOW_GROUP STRING )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:622:4: RULEFLOW_GROUP STRING
            {
            RULEFLOW_GROUP28=(Token)input.LT(1);
            match(input,RULEFLOW_GROUP,FOLLOW_RULEFLOW_GROUP_in_ruleflow_group1516); if (failed) return descr;
            STRING27=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_ruleflow_group1518); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "ruleflow-group", getString( STRING27.getText() ) );
              			descr.setLocation( offset(RULEFLOW_GROUP28.getLine()), RULEFLOW_GROUP28.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)RULEFLOW_GROUP28).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)STRING27).getStopIndex() );
              		
            }

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
    // $ANTLR end ruleflow_group


    // $ANTLR start agenda_group
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:631:1: agenda_group returns [AttributeDescr descr] : AGENDA_GROUP STRING ;
    public final AttributeDescr agenda_group() throws RecognitionException {
        AttributeDescr descr = null;

        Token STRING29=null;
        Token AGENDA_GROUP30=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:635:4: ( AGENDA_GROUP STRING )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:635:4: AGENDA_GROUP STRING
            {
            AGENDA_GROUP30=(Token)input.LT(1);
            match(input,AGENDA_GROUP,FOLLOW_AGENDA_GROUP_in_agenda_group1546); if (failed) return descr;
            STRING29=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_agenda_group1548); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "agenda-group", getString( STRING29.getText() ) );
              			descr.setLocation( offset(AGENDA_GROUP30.getLine()), AGENDA_GROUP30.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)AGENDA_GROUP30).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)STRING29).getStopIndex() );
              		
            }

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
    // $ANTLR end agenda_group


    // $ANTLR start duration
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:644:1: duration returns [AttributeDescr descr] : DURATION INT ;
    public final AttributeDescr duration() throws RecognitionException {
        AttributeDescr descr = null;

        Token INT31=null;
        Token DURATION32=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:648:4: ( DURATION INT )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:648:4: DURATION INT
            {
            DURATION32=(Token)input.LT(1);
            match(input,DURATION,FOLLOW_DURATION_in_duration1576); if (failed) return descr;
            INT31=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_duration1578); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "duration", INT31.getText() );
              			descr.setLocation( offset(DURATION32.getLine()), DURATION32.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)DURATION32).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)INT31).getStopIndex() );
              		
            }

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
    // $ANTLR end duration


    // $ANTLR start dialect
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:657:1: dialect returns [AttributeDescr descr] : DIALECT STRING ;
    public final AttributeDescr dialect() throws RecognitionException {
        AttributeDescr descr = null;

        Token STRING33=null;
        Token DIALECT34=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:661:4: ( DIALECT STRING )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:661:4: DIALECT STRING
            {
            DIALECT34=(Token)input.LT(1);
            match(input,DIALECT,FOLLOW_DIALECT_in_dialect1606); if (failed) return descr;
            STRING33=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_dialect1608); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "dialect", getString( STRING33.getText() ) );
              			descr.setLocation( offset(DIALECT34.getLine()), DIALECT34.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)DIALECT34).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)STRING33).getStopIndex() );
              		
            }

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
    // $ANTLR end dialect


    // $ANTLR start lock_on_active
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:670:1: lock_on_active returns [AttributeDescr descr] : LOCK_ON_ACTIVE ( BOOL )? ;
    public final AttributeDescr lock_on_active() throws RecognitionException {
        AttributeDescr descr = null;

        Token LOCK_ON_ACTIVE35=null;
        Token BOOL36=null;


        		descr = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:674:4: ( LOCK_ON_ACTIVE ( BOOL )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:674:4: LOCK_ON_ACTIVE ( BOOL )?
            {
            LOCK_ON_ACTIVE35=(Token)input.LT(1);
            match(input,LOCK_ON_ACTIVE,FOLLOW_LOCK_ON_ACTIVE_in_lock_on_active1640); if (failed) return descr;
            if ( backtracking==0 ) {

              			descr = new AttributeDescr( "lock-on-active", "true" );
              			descr.setLocation( offset(LOCK_ON_ACTIVE35.getLine()), LOCK_ON_ACTIVE35.getCharPositionInLine() );
              			descr.setStartCharacter( ((CommonToken)LOCK_ON_ACTIVE35).getStartIndex() );
              			descr.setEndCharacter( ((CommonToken)LOCK_ON_ACTIVE35).getStopIndex() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:681:3: ( BOOL )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==BOOL) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:681:5: BOOL
                    {
                    BOOL36=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_lock_on_active1653); if (failed) return descr;
                    if ( backtracking==0 ) {

                      				descr.setValue( BOOL36.getText() );
                      				descr.setEndCharacter( ((CommonToken)BOOL36).getStopIndex() );
                      			
                    }

                    }
                    break;

            }


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
    // $ANTLR end lock_on_active


    // $ANTLR start normal_lhs_block
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:689:1: normal_lhs_block[AndDescr descr] : (d= lhs[$descr] )* ;
    public final void normal_lhs_block(AndDescr descr) throws RecognitionException {
        BaseDescr d = null;



        		location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:694:3: ( (d= lhs[$descr] )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:694:3: (d= lhs[$descr] )*
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:694:3: (d= lhs[$descr] )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==ID||LA34_0==LEFT_PAREN||(LA34_0>=EXISTS && LA34_0<=FORALL)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:694:5: d= lhs[$descr]
            	    {
            	    pushFollow(FOLLOW_lhs_in_normal_lhs_block1692);
            	    d=lhs(descr);
            	    _fsp--;
            	    if (failed) return ;
            	    if ( backtracking==0 ) {
            	       if( d != null) descr.addDescr( d ); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


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
    // $ANTLR end normal_lhs_block


    // $ANTLR start lhs
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:700:1: lhs[ConditionalElementDescr ce] returns [BaseDescr d] : l= lhs_or ;
    public final BaseDescr lhs(ConditionalElementDescr ce) throws RecognitionException {
        BaseDescr d = null;

        BaseDescr l = null;



        		d =null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:704:4: (l= lhs_or )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:704:4: l= lhs_or
            {
            pushFollow(FOLLOW_lhs_or_in_lhs1729);
            l=lhs_or();
            _fsp--;
            if (failed) return d;
            if ( backtracking==0 ) {
               d = l; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs


    // $ANTLR start lhs_or
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:708:1: lhs_or returns [BaseDescr d] : ( LEFT_PAREN OR (lhsand= lhs_and )+ RIGHT_PAREN | left= lhs_and ( ( OR | DOUBLE_PIPE ) right= lhs_and )* );
    public final BaseDescr lhs_or() throws RecognitionException {
        BaseDescr d = null;

        BaseDescr lhsand = null;

        BaseDescr left = null;

        BaseDescr right = null;



        		d = null;
        		OrDescr or = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:713:4: ( LEFT_PAREN OR (lhsand= lhs_and )+ RIGHT_PAREN | left= lhs_and ( ( OR | DOUBLE_PIPE ) right= lhs_and )* )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LEFT_PAREN) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==ID||LA37_1==LEFT_PAREN||LA37_1==AND||(LA37_1>=EXISTS && LA37_1<=FORALL)) ) {
                    alt37=2;
                }
                else if ( (LA37_1==OR) ) {
                    alt37=1;
                }
                else {
                    if (backtracking>0) {failed=true; return d;}
                    NoViableAltException nvae =
                        new NoViableAltException("708:1: lhs_or returns [BaseDescr d] : ( LEFT_PAREN OR (lhsand= lhs_and )+ RIGHT_PAREN | left= lhs_and ( ( OR | DOUBLE_PIPE ) right= lhs_and )* );", 37, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA37_0==ID||(LA37_0>=EXISTS && LA37_0<=FORALL)) ) {
                alt37=2;
            }
            else {
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("708:1: lhs_or returns [BaseDescr d] : ( LEFT_PAREN OR (lhsand= lhs_and )+ RIGHT_PAREN | left= lhs_and ( ( OR | DOUBLE_PIPE ) right= lhs_and )* );", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:713:4: LEFT_PAREN OR (lhsand= lhs_and )+ RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_lhs_or1754); if (failed) return d;
                    match(input,OR,FOLLOW_OR_in_lhs_or1756); if (failed) return d;
                    if ( backtracking==0 ) {

                      			or = new OrDescr();
                      			d = or;
                      			location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION_AND_OR );
                      		
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:719:9: (lhsand= lhs_and )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==ID||LA35_0==LEFT_PAREN||(LA35_0>=EXISTS && LA35_0<=FORALL)) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:719:9: lhsand= lhs_and
                    	    {
                    	    pushFollow(FOLLOW_lhs_and_in_lhs_or1767);
                    	    lhsand=lhs_and();
                    	    _fsp--;
                    	    if (failed) return d;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (backtracking>0) {failed=true; return d;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    if ( backtracking==0 ) {

                      			or.addDescr( lhsand );
                      		
                    }
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_lhs_or1777); if (failed) return d;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:725:10: left= lhs_and ( ( OR | DOUBLE_PIPE ) right= lhs_and )*
                    {
                    pushFollow(FOLLOW_lhs_and_in_lhs_or1795);
                    left=lhs_and();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = left; 
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:726:3: ( ( OR | DOUBLE_PIPE ) right= lhs_and )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( ((LA36_0>=OR && LA36_0<=DOUBLE_PIPE)) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:726:5: ( OR | DOUBLE_PIPE ) right= lhs_and
                    	    {
                    	    if ( (input.LA(1)>=OR && input.LA(1)<=DOUBLE_PIPE) ) {
                    	        input.consume();
                    	        errorRecovery=false;failed=false;
                    	    }
                    	    else {
                    	        if (backtracking>0) {failed=true; return d;}
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_lhs_or1803);    throw mse;
                    	    }

                    	    if ( backtracking==0 ) {

                    	      				location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION_AND_OR );
                    	      			
                    	    }
                    	    pushFollow(FOLLOW_lhs_and_in_lhs_or1819);
                    	    right=lhs_and();
                    	    _fsp--;
                    	    if (failed) return d;
                    	    if ( backtracking==0 ) {

                    	      				if ( or == null ) {
                    	      					or = new OrDescr();
                    	      					or.addDescr( left );
                    	      					d = or;
                    	      				}
                    	      				
                    	      				or.addDescr( right );
                    	      			
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


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
        return d;
    }
    // $ANTLR end lhs_or


    // $ANTLR start lhs_and
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:743:1: lhs_and returns [BaseDescr d] : ( LEFT_PAREN AND (lhsunary= lhs_unary )+ RIGHT_PAREN | left= lhs_unary ( ( AND | DOUBLE_AMPER ) right= lhs_unary )* );
    public final BaseDescr lhs_and() throws RecognitionException {
        BaseDescr d = null;

        BaseDescr lhsunary = null;

        BaseDescr left = null;

        BaseDescr right = null;



        		d = null;
        		AndDescr and = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:748:4: ( LEFT_PAREN AND (lhsunary= lhs_unary )+ RIGHT_PAREN | left= lhs_unary ( ( AND | DOUBLE_AMPER ) right= lhs_unary )* )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==LEFT_PAREN) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==AND) ) {
                    alt40=1;
                }
                else if ( (LA40_1==ID||LA40_1==LEFT_PAREN||(LA40_1>=EXISTS && LA40_1<=FORALL)) ) {
                    alt40=2;
                }
                else {
                    if (backtracking>0) {failed=true; return d;}
                    NoViableAltException nvae =
                        new NoViableAltException("743:1: lhs_and returns [BaseDescr d] : ( LEFT_PAREN AND (lhsunary= lhs_unary )+ RIGHT_PAREN | left= lhs_unary ( ( AND | DOUBLE_AMPER ) right= lhs_unary )* );", 40, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA40_0==ID||(LA40_0>=EXISTS && LA40_0<=FORALL)) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("743:1: lhs_and returns [BaseDescr d] : ( LEFT_PAREN AND (lhsunary= lhs_unary )+ RIGHT_PAREN | left= lhs_unary ( ( AND | DOUBLE_AMPER ) right= lhs_unary )* );", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:748:4: LEFT_PAREN AND (lhsunary= lhs_unary )+ RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_lhs_and1850); if (failed) return d;
                    match(input,AND,FOLLOW_AND_in_lhs_and1852); if (failed) return d;
                    if ( backtracking==0 ) {

                      			and = new AndDescr();
                      			d = and;
                      			location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION_AND_OR );
                      		
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:754:11: (lhsunary= lhs_unary )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==ID||LA38_0==LEFT_PAREN||(LA38_0>=EXISTS && LA38_0<=FORALL)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:754:11: lhsunary= lhs_unary
                    	    {
                    	    pushFollow(FOLLOW_lhs_unary_in_lhs_and1863);
                    	    lhsunary=lhs_unary();
                    	    _fsp--;
                    	    if (failed) return d;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                    	    if (backtracking>0) {failed=true; return d;}
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);

                    if ( backtracking==0 ) {

                      			and.addDescr( lhsunary );
                      		
                    }
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_lhs_and1873); if (failed) return d;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:760:10: left= lhs_unary ( ( AND | DOUBLE_AMPER ) right= lhs_unary )*
                    {
                    pushFollow(FOLLOW_lhs_unary_in_lhs_and1891);
                    left=lhs_unary();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = left; 
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:761:3: ( ( AND | DOUBLE_AMPER ) right= lhs_unary )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( ((LA39_0>=AND && LA39_0<=DOUBLE_AMPER)) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:761:5: ( AND | DOUBLE_AMPER ) right= lhs_unary
                    	    {
                    	    if ( (input.LA(1)>=AND && input.LA(1)<=DOUBLE_AMPER) ) {
                    	        input.consume();
                    	        errorRecovery=false;failed=false;
                    	    }
                    	    else {
                    	        if (backtracking>0) {failed=true; return d;}
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_lhs_and1899);    throw mse;
                    	    }

                    	    if ( backtracking==0 ) {

                    	      				location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION_AND_OR );
                    	      			
                    	    }
                    	    pushFollow(FOLLOW_lhs_unary_in_lhs_and1915);
                    	    right=lhs_unary();
                    	    _fsp--;
                    	    if (failed) return d;
                    	    if ( backtracking==0 ) {

                    	      				if ( and == null ) {
                    	      					and = new AndDescr();
                    	      					and.addDescr( left );
                    	      					d = and;
                    	      				}
                    	      				
                    	      				and.addDescr( right );
                    	      			
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


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
        return d;
    }
    // $ANTLR end lhs_and


    // $ANTLR start lhs_unary
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:778:1: lhs_unary returns [BaseDescr d] : (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_pattern ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )? | u= lhs_forall | LEFT_PAREN u= lhs_or RIGHT_PAREN ) opt_semicolon ;
    public final BaseDescr lhs_unary() throws RecognitionException {
        BaseDescr d = null;

        BaseDescr u = null;

        AccumulateDescr ac = null;

        CollectDescr cs = null;

        FromDescr fm = null;



        		d = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:782:4: ( (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_pattern ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )? | u= lhs_forall | LEFT_PAREN u= lhs_or RIGHT_PAREN ) opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:782:4: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_pattern ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )? | u= lhs_forall | LEFT_PAREN u= lhs_or RIGHT_PAREN ) opt_semicolon
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:782:4: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_pattern ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )? | u= lhs_forall | LEFT_PAREN u= lhs_or RIGHT_PAREN )
            int alt43=6;
            switch ( input.LA(1) ) {
            case EXISTS:
                {
                alt43=1;
                }
                break;
            case NOT:
                {
                alt43=2;
                }
                break;
            case EVAL:
                {
                alt43=3;
                }
                break;
            case ID:
                {
                alt43=4;
                }
                break;
            case FORALL:
                {
                alt43=5;
                }
                break;
            case LEFT_PAREN:
                {
                alt43=6;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("782:4: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_pattern ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )? | u= lhs_forall | LEFT_PAREN u= lhs_or RIGHT_PAREN )", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:782:6: u= lhs_exist
                    {
                    pushFollow(FOLLOW_lhs_exist_in_lhs_unary1952);
                    u=lhs_exist();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = u; 
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:783:5: u= lhs_not
                    {
                    pushFollow(FOLLOW_lhs_not_in_lhs_unary1962);
                    u=lhs_not();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = u; 
                    }

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:784:5: u= lhs_eval
                    {
                    pushFollow(FOLLOW_lhs_eval_in_lhs_unary1972);
                    u=lhs_eval();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = u; 
                    }

                    }
                    break;
                case 4 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:785:5: u= lhs_pattern ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )?
                    {
                    pushFollow(FOLLOW_lhs_pattern_in_lhs_unary1982);
                    u=lhs_pattern();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = u; 
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:785:34: ( FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==FROM) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:786:13: FROM ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) )
                            {
                            match(input,FROM,FOLLOW_FROM_in_lhs_unary2000); if (failed) return d;
                            if ( backtracking==0 ) {

                              				location.setType(Location.LOCATION_LHS_FROM);
                              				location.setProperty(Location.LOCATION_FROM_CONTENT, "");
                              		          
                            }
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:791:13: ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) )
                            int alt41=3;
                            switch ( input.LA(1) ) {
                            case ACCUMULATE:
                                {
                                alt41=1;
                                }
                                break;
                            case COLLECT:
                                {
                                alt41=2;
                                }
                                break;
                            case ATTRIBUTES:
                            case PACKAGE:
                            case IMPORT:
                            case FUNCTION:
                            case ID:
                            case GLOBAL:
                            case QUERY:
                            case END:
                            case TEMPLATE:
                            case RULE:
                            case WHEN:
                            case ENABLED:
                            case SALIENCE:
                            case DURATION:
                            case FROM:
                            case INIT:
                            case ACTION:
                            case REVERSE:
                            case RESULT:
                            case CONTAINS:
                            case EXCLUDES:
                            case MATCHES:
                            case MEMBEROF:
                            case IN:
                            case THEN:
                                {
                                alt41=3;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return d;}
                                NoViableAltException nvae =
                                    new NoViableAltException("791:13: ( options {k=1; } : (ac= accumulate_statement ) | (cs= collect_statement ) | (fm= from_statement ) )", 41, 0, input);

                                throw nvae;
                            }

                            switch (alt41) {
                                case 1 :
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:792:15: (ac= accumulate_statement )
                                    {
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:792:15: (ac= accumulate_statement )
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:792:17: ac= accumulate_statement
                                    {
                                    pushFollow(FOLLOW_accumulate_statement_in_lhs_unary2060);
                                    ac=accumulate_statement();
                                    _fsp--;
                                    if (failed) return d;
                                    if ( backtracking==0 ) {
                                       ac.setResultPattern((PatternDescr) u); d =ac; 
                                    }

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:793:15: (cs= collect_statement )
                                    {
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:793:15: (cs= collect_statement )
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:793:17: cs= collect_statement
                                    {
                                    pushFollow(FOLLOW_collect_statement_in_lhs_unary2083);
                                    cs=collect_statement();
                                    _fsp--;
                                    if (failed) return d;
                                    if ( backtracking==0 ) {
                                       cs.setResultPattern((PatternDescr) u); d =cs; 
                                    }

                                    }


                                    }
                                    break;
                                case 3 :
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:794:15: (fm= from_statement )
                                    {
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:794:15: (fm= from_statement )
                                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:794:17: fm= from_statement
                                    {
                                    pushFollow(FOLLOW_from_statement_in_lhs_unary2107);
                                    fm=from_statement();
                                    _fsp--;
                                    if (failed) return d;
                                    if ( backtracking==0 ) {
                                      fm.setPattern((PatternDescr) u); d =fm; 
                                    }

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:797:5: u= lhs_forall
                    {
                    pushFollow(FOLLOW_lhs_forall_in_lhs_unary2146);
                    u=lhs_forall();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       d = u; 
                    }

                    }
                    break;
                case 6 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:798:5: LEFT_PAREN u= lhs_or RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_lhs_unary2155); if (failed) return d;
                    pushFollow(FOLLOW_lhs_or_in_lhs_unary2159);
                    u=lhs_or();
                    _fsp--;
                    if (failed) return d;
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_lhs_unary2161); if (failed) return d;
                    if ( backtracking==0 ) {
                       d = u; 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_opt_semicolon_in_lhs_unary2172);
            opt_semicolon();
            _fsp--;
            if (failed) return d;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs_unary


    // $ANTLR start lhs_exist
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:803:1: lhs_exist returns [BaseDescr d] : EXISTS ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern ) ;
    public final BaseDescr lhs_exist() throws RecognitionException {
        BaseDescr d = null;

        Token EXISTS37=null;
        Token RIGHT_PAREN38=null;
        BaseDescr pattern = null;



        		d = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:807:4: ( EXISTS ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:807:4: EXISTS ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern )
            {
            EXISTS37=(Token)input.LT(1);
            match(input,EXISTS,FOLLOW_EXISTS_in_lhs_exist2194); if (failed) return d;
            if ( backtracking==0 ) {

              			d = new ExistsDescr( ); 
              			d.setLocation( offset(EXISTS37.getLine()), EXISTS37.getCharPositionInLine() );
              			d.setStartCharacter( ((CommonToken)EXISTS37).getStartIndex() );
              			location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION_EXISTS );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:814:10: ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LEFT_PAREN) ) {
                alt44=1;
            }
            else if ( (LA44_0==ID) ) {
                alt44=2;
            }
            else {
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("814:10: ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:814:12: ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN )
                    {
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:814:12: ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN )
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:814:14: LEFT_PAREN pattern= lhs_or RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_lhs_exist2214); if (failed) return d;
                    pushFollow(FOLLOW_lhs_or_in_lhs_exist2218);
                    pattern=lhs_or();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       if ( pattern != null ) ((ExistsDescr)d).addDescr( pattern ); 
                    }
                    RIGHT_PAREN38=(Token)input.LT(1);
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_lhs_exist2248); if (failed) return d;
                    if ( backtracking==0 ) {
                       d.setEndCharacter( ((CommonToken)RIGHT_PAREN38).getStopIndex() ); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:819:12: pattern= lhs_pattern
                    {
                    pushFollow(FOLLOW_lhs_pattern_in_lhs_exist2298);
                    pattern=lhs_pattern();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {

                      	                	if ( pattern != null ) {
                      	                		((ExistsDescr)d).addDescr( pattern );
                      	                		d.setEndCharacter( pattern.getEndCharacter() );
                      	                	}
                      	                
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs_exist


    // $ANTLR start lhs_not
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:829:1: lhs_not returns [NotDescr d] : NOT ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern ) ;
    public final NotDescr lhs_not() throws RecognitionException {
        NotDescr d = null;

        Token NOT39=null;
        Token RIGHT_PAREN40=null;
        BaseDescr pattern = null;



        		d = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:833:4: ( NOT ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:833:4: NOT ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern )
            {
            NOT39=(Token)input.LT(1);
            match(input,NOT,FOLLOW_NOT_in_lhs_not2350); if (failed) return d;
            if ( backtracking==0 ) {

              			d = new NotDescr( ); 
              			d.setLocation( offset(NOT39.getLine()), NOT39.getCharPositionInLine() );
              			d.setStartCharacter( ((CommonToken)NOT39).getStartIndex() );
              			location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION_NOT );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:840:3: ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==LEFT_PAREN) ) {
                alt45=1;
            }
            else if ( (LA45_0==ID) ) {
                alt45=2;
            }
            else {
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("840:3: ( ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN ) | pattern= lhs_pattern )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:840:5: ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN )
                    {
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:840:5: ( LEFT_PAREN pattern= lhs_or RIGHT_PAREN )
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:840:7: LEFT_PAREN pattern= lhs_or RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_lhs_not2363); if (failed) return d;
                    pushFollow(FOLLOW_lhs_or_in_lhs_not2367);
                    pattern=lhs_or();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {
                       if ( pattern != null ) d.addDescr( pattern ); 
                    }
                    RIGHT_PAREN40=(Token)input.LT(1);
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_lhs_not2398); if (failed) return d;
                    if ( backtracking==0 ) {
                       d.setEndCharacter( ((CommonToken)RIGHT_PAREN40).getStopIndex() ); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:846:3: pattern= lhs_pattern
                    {
                    pushFollow(FOLLOW_lhs_pattern_in_lhs_not2435);
                    pattern=lhs_pattern();
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {

                      	                	if ( pattern != null ) {
                      	                		d.addDescr( pattern );
                      	                		d.setEndCharacter( pattern.getEndCharacter() );
                      	                	}
                      	                
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs_not


    // $ANTLR start lhs_eval
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:856:1: lhs_eval returns [BaseDescr d] : EVAL c= paren_chunk ;
    public final BaseDescr lhs_eval() throws RecognitionException {
        BaseDescr d = null;

        Token EVAL41=null;
        paren_chunk_return c = null;



        		d = new EvalDescr( );
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:861:3: ( EVAL c= paren_chunk )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:861:3: EVAL c= paren_chunk
            {
            EVAL41=(Token)input.LT(1);
            match(input,EVAL,FOLLOW_EVAL_in_lhs_eval2481); if (failed) return d;
            if ( backtracking==0 ) {

              			location.setType( Location.LOCATION_LHS_INSIDE_EVAL );
              		
            }
            pushFollow(FOLLOW_paren_chunk_in_lhs_eval2492);
            c=paren_chunk();
            _fsp--;
            if (failed) return d;
            if ( backtracking==0 ) {
               
              			d.setStartCharacter( ((CommonToken)EVAL41).getStartIndex() );
              		        if( input.toString(c.start,c.stop) != null ) {
              	  		    this.location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
              		            String body = input.toString(c.start,c.stop).length() > 1 ? input.toString(c.start,c.stop).substring(1, input.toString(c.start,c.stop).length()-1) : "";
              			    checkTrailingSemicolon( body, offset(EVAL41.getLine()) );
              			    ((EvalDescr) d).setContent( body );
              			    location.setProperty(Location.LOCATION_EVAL_CONTENT, body);
              			}
              			if( ((Token)c.stop) != null ) {
              			    d.setEndCharacter( ((CommonToken)((Token)c.stop)).getStopIndex() );
              			}
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs_eval


    // $ANTLR start lhs_forall
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:881:1: lhs_forall returns [ForallDescr d] : FORALL LEFT_PAREN base= lhs_pattern ( ( COMMA )? pattern= lhs_pattern )+ RIGHT_PAREN ;
    public final ForallDescr lhs_forall() throws RecognitionException {
        ForallDescr d = null;

        Token FORALL42=null;
        Token RIGHT_PAREN43=null;
        BaseDescr base = null;

        BaseDescr pattern = null;



        		d = factory.createForall();
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:885:4: ( FORALL LEFT_PAREN base= lhs_pattern ( ( COMMA )? pattern= lhs_pattern )+ RIGHT_PAREN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:885:4: FORALL LEFT_PAREN base= lhs_pattern ( ( COMMA )? pattern= lhs_pattern )+ RIGHT_PAREN
            {
            FORALL42=(Token)input.LT(1);
            match(input,FORALL,FOLLOW_FORALL_in_lhs_forall2518); if (failed) return d;
            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_lhs_forall2520); if (failed) return d;
            pushFollow(FOLLOW_lhs_pattern_in_lhs_forall2524);
            base=lhs_pattern();
            _fsp--;
            if (failed) return d;
            if ( backtracking==0 ) {

              			d.setStartCharacter( ((CommonToken)FORALL42).getStartIndex() );
              		        // adding the base pattern
              		        d.addDescr( base );
              			d.setLocation( offset(FORALL42.getLine()), FORALL42.getCharPositionInLine() );
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:892:3: ( ( COMMA )? pattern= lhs_pattern )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==ID||LA47_0==COMMA) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:892:5: ( COMMA )? pattern= lhs_pattern
            	    {
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:892:5: ( COMMA )?
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==COMMA) ) {
            	        alt46=1;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:892:5: COMMA
            	            {
            	            match(input,COMMA,FOLLOW_COMMA_in_lhs_forall2537); if (failed) return d;

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_lhs_pattern_in_lhs_forall2542);
            	    pattern=lhs_pattern();
            	    _fsp--;
            	    if (failed) return d;
            	    if ( backtracking==0 ) {

            	      		        // adding additional patterns
            	      			d.addDescr( pattern );
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (backtracking>0) {failed=true; return d;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);

            RIGHT_PAREN43=(Token)input.LT(1);
            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_lhs_forall2555); if (failed) return d;
            if ( backtracking==0 ) {

              		        d.setEndCharacter( ((CommonToken)RIGHT_PAREN43).getStopIndex() );
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs_forall


    // $ANTLR start lhs_pattern
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:904:1: lhs_pattern returns [BaseDescr d] : (f= fact_binding | f= fact[null] );
    public final BaseDescr lhs_pattern() throws RecognitionException {
        BaseDescr d = null;

        BaseDescr f = null;



        		d =null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:911:4: (f= fact_binding | f= fact[null] )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==72) ) {
                    alt48=1;
                }
                else if ( (LA48_1==DOT||LA48_1==LEFT_PAREN||LA48_1==LEFT_SQUARE) ) {
                    alt48=2;
                }
                else {
                    if (backtracking>0) {failed=true; return d;}
                    NoViableAltException nvae =
                        new NoViableAltException("904:1: lhs_pattern returns [BaseDescr d] : (f= fact_binding | f= fact[null] );", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("904:1: lhs_pattern returns [BaseDescr d] : (f= fact_binding | f= fact[null] );", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:911:4: f= fact_binding
                    {
                    pushFollow(FOLLOW_fact_binding_in_lhs_pattern2588);
                    f=fact_binding();
                    _fsp--;
                    if (failed) return d;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:912:4: f= fact[null]
                    {
                    pushFollow(FOLLOW_fact_in_lhs_pattern2596);
                    f=fact(null);
                    _fsp--;
                    if (failed) return d;

                    }
                    break;

            }
            if ( backtracking==0 ) {

              		d =f;
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end lhs_pattern


    // $ANTLR start from_statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:915:1: from_statement returns [FromDescr d] : ds= from_source[$d] ;
    public final FromDescr from_statement() throws RecognitionException {
        FromDescr d = null;

        DeclarativeInvokerDescr ds = null;



        		d =factory.createFrom();
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:920:2: (ds= from_source[$d] )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:920:2: ds= from_source[$d]
            {
            pushFollow(FOLLOW_from_source_in_from_statement2623);
            ds=from_source(d);
            _fsp--;
            if (failed) return d;
            if ( backtracking==0 ) {

              		d.setDataSource( ds );
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end from_statement


    // $ANTLR start from_source
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:926:1: from_source[FromDescr from] returns [DeclarativeInvokerDescr ds] : ident= identifier ( options {k=1; } : args= paren_chunk )? ( expression_chain[$from, ad] )? ;
    public final DeclarativeInvokerDescr from_source(FromDescr from) throws RecognitionException {
        DeclarativeInvokerDescr ds = null;

        identifier_return ident = null;

        paren_chunk_return args = null;



        		ds = null;
        		AccessorDescr ad = null;
        		FunctionCallDescr fc = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:932:4: (ident= identifier ( options {k=1; } : args= paren_chunk )? ( expression_chain[$from, ad] )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:932:4: ident= identifier ( options {k=1; } : args= paren_chunk )? ( expression_chain[$from, ad] )?
            {
            pushFollow(FOLLOW_identifier_in_from_source2652);
            ident=identifier();
            _fsp--;
            if (failed) return ds;
            if ( backtracking==0 ) {

              			ad = new AccessorDescr(ident.start.getText());	
              			ad.setLocation( offset(ident.start.getLine()), ident.start.getCharPositionInLine() );
              			ad.setStartCharacter( ((CommonToken)ident.start).getStartIndex() );
              			ad.setEndCharacter( ((CommonToken)ident.start).getStopIndex() );
              			ds = ad;
              			location.setProperty(Location.LOCATION_FROM_CONTENT, ident.start.getText());
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:941:3: ( options {k=1; } : args= paren_chunk )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==LEFT_PAREN) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:948:5: args= paren_chunk
                    {
                    pushFollow(FOLLOW_paren_chunk_in_from_source2680);
                    args=paren_chunk();
                    _fsp--;
                    if (failed) return ds;
                    if ( backtracking==0 ) {

                      			if( input.toString(args.start,args.stop) != null ) {
                      				ad.setVariableName( null );
                      				fc = new FunctionCallDescr(((Token)ident.start).getText());
                      				fc.setLocation( offset(((Token)ident.start).getLine()), ((Token)ident.start).getCharPositionInLine() );			
                      				fc.setArguments(input.toString(args.start,args.stop));
                      				fc.setStartCharacter( ((CommonToken)((Token)ident.start)).getStartIndex() );
                      				fc.setEndCharacter( ((CommonToken)((Token)ident.start)).getStopIndex() );
                      				location.setProperty(Location.LOCATION_FROM_CONTENT, input.toString(args.start,args.stop));
                      				from.setEndCharacter( ((CommonToken)((Token)args.stop)).getStopIndex() );
                      			}
                      		
                    }

                    }
                    break;

            }

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:962:3: ( expression_chain[$from, ad] )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==DOT) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:962:3: expression_chain[$from, ad]
                    {
                    pushFollow(FOLLOW_expression_chain_in_from_source2693);
                    expression_chain(from,  ad);
                    _fsp--;
                    if (failed) return ds;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            		if( ad != null ) {
            			if( fc != null ) {
            				ad.addFirstInvoker( fc );
            			}
            			location.setProperty(Location.LOCATION_FROM_CONTENT, ad.toString() );
            		}
            	
        }
        return ds;
    }
    // $ANTLR end from_source


    // $ANTLR start expression_chain
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:973:1: expression_chain[FromDescr from, AccessorDescr as] : ( DOT field= identifier ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )? ( expression_chain[from, as] )? ) ;
    public final void expression_chain(FromDescr from, AccessorDescr as) throws RecognitionException {
        identifier_return field = null;

        square_chunk_return sqarg = null;

        paren_chunk_return paarg = null;



          		FieldAccessDescr fa = null;
        	    	MethodAccessDescr ma = null;	
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:979:2: ( ( DOT field= identifier ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )? ( expression_chain[from, as] )? ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:979:2: ( DOT field= identifier ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )? ( expression_chain[from, as] )? )
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:979:2: ( DOT field= identifier ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )? ( expression_chain[from, as] )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:979:4: DOT field= identifier ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )? ( expression_chain[from, as] )?
            {
            match(input,DOT,FOLLOW_DOT_in_expression_chain2724); if (failed) return ;
            pushFollow(FOLLOW_identifier_in_expression_chain2728);
            field=identifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              	        fa = new FieldAccessDescr(((Token)field.start).getText());	
              		fa.setLocation( offset(((Token)field.start).getLine()), ((Token)field.start).getCharPositionInLine() );
              		fa.setStartCharacter( ((CommonToken)((Token)field.start)).getStartIndex() );
              		fa.setEndCharacter( ((CommonToken)((Token)field.start)).getStopIndex() );
              	    
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:986:4: ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )?
            int alt51=3;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:987:6: ( LEFT_SQUARE )=>sqarg= square_chunk
                    {
                    pushFollow(FOLLOW_square_chunk_in_expression_chain2759);
                    sqarg=square_chunk();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {

                      	          fa.setArgument( input.toString(sqarg.start,sqarg.stop) );	
                      		  from.setEndCharacter( ((CommonToken)((Token)sqarg.stop)).getStopIndex() );
                      	      
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:993:6: ( LEFT_PAREN )=>paarg= paren_chunk
                    {
                    pushFollow(FOLLOW_paren_chunk_in_expression_chain2792);
                    paarg=paren_chunk();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {

                      	    	  ma = new MethodAccessDescr( ((Token)field.start).getText(), input.toString(paarg.start,paarg.stop) );	
                      		  ma.setLocation( offset(((Token)field.start).getLine()), ((Token)field.start).getCharPositionInLine() );
                      		  ma.setStartCharacter( ((CommonToken)((Token)field.start)).getStartIndex() );
                      		  from.setEndCharacter( ((CommonToken)((Token)paarg.stop)).getStopIndex() );
                      		
                    }

                    }
                    break;

            }

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1001:4: ( expression_chain[from, as] )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==DOT) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1001:4: expression_chain[from, as]
                    {
                    pushFollow(FOLLOW_expression_chain_in_expression_chain2807);
                    expression_chain(from,  as);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            		// must be added to the start, since it is a recursive rule
            		if( ma != null ) {
            			as.addFirstInvoker( ma );
            		} else {
            			as.addFirstInvoker( fa );
            		}
            	
        }
        return ;
    }
    // $ANTLR end expression_chain


    // $ANTLR start accumulate_statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1013:1: accumulate_statement returns [AccumulateDescr d] : ACCUMULATE LEFT_PAREN pattern= lhs_pattern ( COMMA )? INIT text= paren_chunk ( COMMA )? ACTION text= paren_chunk ( COMMA )? ( REVERSE text= paren_chunk ( COMMA )? )? RESULT text= paren_chunk RIGHT_PAREN ;
    public final AccumulateDescr accumulate_statement() throws RecognitionException {
        AccumulateDescr d = null;

        Token ACCUMULATE44=null;
        Token RIGHT_PAREN45=null;
        BaseDescr pattern = null;

        paren_chunk_return text = null;



        		d = factory.createAccumulate();
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1018:10: ( ACCUMULATE LEFT_PAREN pattern= lhs_pattern ( COMMA )? INIT text= paren_chunk ( COMMA )? ACTION text= paren_chunk ( COMMA )? ( REVERSE text= paren_chunk ( COMMA )? )? RESULT text= paren_chunk RIGHT_PAREN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1018:10: ACCUMULATE LEFT_PAREN pattern= lhs_pattern ( COMMA )? INIT text= paren_chunk ( COMMA )? ACTION text= paren_chunk ( COMMA )? ( REVERSE text= paren_chunk ( COMMA )? )? RESULT text= paren_chunk RIGHT_PAREN
            {
            ACCUMULATE44=(Token)input.LT(1);
            match(input,ACCUMULATE,FOLLOW_ACCUMULATE_in_accumulate_statement2851); if (failed) return d;
            if ( backtracking==0 ) {
               
              			d.setLocation( offset(ACCUMULATE44.getLine()), ACCUMULATE44.getCharPositionInLine() );
              			d.setStartCharacter( ((CommonToken)ACCUMULATE44).getStartIndex() );
              			location.setType( Location.LOCATION_LHS_FROM_ACCUMULATE );
              		
            }
            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_accumulate_statement2861); if (failed) return d;
            pushFollow(FOLLOW_lhs_pattern_in_accumulate_statement2865);
            pattern=lhs_pattern();
            _fsp--;
            if (failed) return d;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1024:34: ( COMMA )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==COMMA) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1024:34: COMMA
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_accumulate_statement2867); if (failed) return d;

                    }
                    break;

            }

            if ( backtracking==0 ) {

              		        d.setSourcePattern( (PatternDescr) pattern );
              		
            }
            match(input,INIT,FOLLOW_INIT_in_accumulate_statement2877); if (failed) return d;
            if ( backtracking==0 ) {

              			location.setType( Location.LOCATION_LHS_FROM_ACCUMULATE_INIT );
              		
            }
            pushFollow(FOLLOW_paren_chunk_in_accumulate_statement2888);
            text=paren_chunk();
            _fsp--;
            if (failed) return d;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1032:20: ( COMMA )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==COMMA) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1032:20: COMMA
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_accumulate_statement2890); if (failed) return d;

                    }
                    break;

            }

            if ( backtracking==0 ) {

              			if( input.toString(text.start,text.stop) != null ) {
              			        d.setInitCode( input.toString(text.start,text.stop).substring(1, input.toString(text.start,text.stop).length()-1) );
              				location.setProperty(Location.LOCATION_PROPERTY_FROM_ACCUMULATE_INIT_CONTENT, d.getInitCode());
              				location.setType( Location.LOCATION_LHS_FROM_ACCUMULATE_ACTION );
              			}
              		
            }
            match(input,ACTION,FOLLOW_ACTION_in_accumulate_statement2899); if (failed) return d;
            pushFollow(FOLLOW_paren_chunk_in_accumulate_statement2903);
            text=paren_chunk();
            _fsp--;
            if (failed) return d;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1040:27: ( COMMA )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==COMMA) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1040:27: COMMA
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_accumulate_statement2905); if (failed) return d;

                    }
                    break;

            }

            if ( backtracking==0 ) {

              			if( input.toString(text.start,text.stop) != null ) {
              			        d.setActionCode( input.toString(text.start,text.stop).substring(1, input.toString(text.start,text.stop).length()-1) );
              	       			location.setProperty(Location.LOCATION_PROPERTY_FROM_ACCUMULATE_ACTION_CONTENT, d.getActionCode());
              				location.setType( Location.LOCATION_LHS_FROM_ACCUMULATE_REVERSE );
              			}
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1048:3: ( REVERSE text= paren_chunk ( COMMA )? )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==REVERSE) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1048:5: REVERSE text= paren_chunk ( COMMA )?
                    {
                    match(input,REVERSE,FOLLOW_REVERSE_in_accumulate_statement2916); if (failed) return d;
                    pushFollow(FOLLOW_paren_chunk_in_accumulate_statement2920);
                    text=paren_chunk();
                    _fsp--;
                    if (failed) return d;
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1048:30: ( COMMA )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==COMMA) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1048:30: COMMA
                            {
                            match(input,COMMA,FOLLOW_COMMA_in_accumulate_statement2922); if (failed) return d;

                            }
                            break;

                    }

                    if ( backtracking==0 ) {

                      			if( input.toString(text.start,text.stop) != null ) {
                      			        d.setReverseCode( input.toString(text.start,text.stop).substring(1, input.toString(text.start,text.stop).length()-1) );
                      	       			location.setProperty(Location.LOCATION_PROPERTY_FROM_ACCUMULATE_REVERSE_CONTENT, d.getReverseCode());
                      				location.setType( Location.LOCATION_LHS_FROM_ACCUMULATE_RESULT );
                      			}
                      		
                    }

                    }
                    break;

            }

            match(input,RESULT,FOLLOW_RESULT_in_accumulate_statement2936); if (failed) return d;
            pushFollow(FOLLOW_paren_chunk_in_accumulate_statement2940);
            text=paren_chunk();
            _fsp--;
            if (failed) return d;
            if ( backtracking==0 ) {

              			if( input.toString(text.start,text.stop) != null ) {
              			        d.setResultCode( input.toString(text.start,text.stop).substring(1, input.toString(text.start,text.stop).length()-1) );
              				location.setProperty(Location.LOCATION_PROPERTY_FROM_ACCUMULATE_RESULT_CONTENT, d.getResultCode());
              			}
              		
            }
            RIGHT_PAREN45=(Token)input.LT(1);
            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_accumulate_statement2949); if (failed) return d;
            if ( backtracking==0 ) {

              			location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
              			d.setEndCharacter( ((CommonToken)RIGHT_PAREN45).getStopIndex() );
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end accumulate_statement


    // $ANTLR start collect_statement
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1071:1: collect_statement returns [CollectDescr d] : COLLECT LEFT_PAREN pattern= lhs_pattern RIGHT_PAREN ;
    public final CollectDescr collect_statement() throws RecognitionException {
        CollectDescr d = null;

        Token COLLECT46=null;
        Token RIGHT_PAREN47=null;
        BaseDescr pattern = null;



        		d = factory.createCollect();
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1076:10: ( COLLECT LEFT_PAREN pattern= lhs_pattern RIGHT_PAREN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1076:10: COLLECT LEFT_PAREN pattern= lhs_pattern RIGHT_PAREN
            {
            COLLECT46=(Token)input.LT(1);
            match(input,COLLECT,FOLLOW_COLLECT_in_collect_statement2990); if (failed) return d;
            if ( backtracking==0 ) {
               
              			d.setLocation( offset(COLLECT46.getLine()), COLLECT46.getCharPositionInLine() );
              			d.setStartCharacter( ((CommonToken)COLLECT46).getStartIndex() );
              			location.setType( Location.LOCATION_LHS_FROM_COLLECT );
              		
            }
            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_collect_statement3000); if (failed) return d;
            pushFollow(FOLLOW_lhs_pattern_in_collect_statement3004);
            pattern=lhs_pattern();
            _fsp--;
            if (failed) return d;
            RIGHT_PAREN47=(Token)input.LT(1);
            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_collect_statement3006); if (failed) return d;
            if ( backtracking==0 ) {

              		        d.setSourcePattern( (PatternDescr)pattern );
              			d.setEndCharacter( ((CommonToken)RIGHT_PAREN47).getStopIndex() );
              			location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end collect_statement


    // $ANTLR start fact_binding
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1090:1: fact_binding returns [BaseDescr d] : ID ':' (fe= fact[$ID.text] | LEFT_PAREN left= fact[$ID.text] ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )* RIGHT_PAREN ) ;
    public final BaseDescr fact_binding() throws RecognitionException {
        BaseDescr d = null;

        Token ID48=null;
        BaseDescr fe = null;

        BaseDescr left = null;

        BaseDescr right = null;



        		d =null;
        		OrDescr or = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1096:4: ( ID ':' (fe= fact[$ID.text] | LEFT_PAREN left= fact[$ID.text] ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )* RIGHT_PAREN ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1096:4: ID ':' (fe= fact[$ID.text] | LEFT_PAREN left= fact[$ID.text] ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )* RIGHT_PAREN )
            {
            ID48=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_fact_binding3038); if (failed) return d;
            match(input,72,FOLLOW_72_in_fact_binding3040); if (failed) return d;
            if ( backtracking==0 ) {

               		        // handling incomplete parsing
               		        d = new PatternDescr( );
               		        ((PatternDescr) d).setIdentifier( ID48.getText() );
               		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1102:3: (fe= fact[$ID.text] | LEFT_PAREN left= fact[$ID.text] ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )* RIGHT_PAREN )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==LEFT_PAREN) ) {
                alt59=2;
            }
            else {
                if (backtracking>0) {failed=true; return d;}
                NoViableAltException nvae =
                    new NoViableAltException("1102:3: (fe= fact[$ID.text] | LEFT_PAREN left= fact[$ID.text] ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )* RIGHT_PAREN )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1102:5: fe= fact[$ID.text]
                    {
                    pushFollow(FOLLOW_fact_in_fact_binding3054);
                    fe=fact(ID48.getText());
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {

                       		        // override previously instantiated pattern
                       			d =fe;
                       			if( d != null ) {
                         			    d.setStartCharacter( ((CommonToken)ID48).getStartIndex() );
                         			}
                       		
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1111:4: LEFT_PAREN left= fact[$ID.text] ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )* RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_fact_binding3070); if (failed) return d;
                    pushFollow(FOLLOW_fact_in_fact_binding3074);
                    left=fact(ID48.getText());
                    _fsp--;
                    if (failed) return d;
                    if ( backtracking==0 ) {

                       		        // override previously instantiated pattern
                       			d =left;
                       			if( d != null ) {
                         			    d.setStartCharacter( ((CommonToken)ID48).getStartIndex() );
                         			}
                       		
                    }
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1119:4: ( ( OR | DOUBLE_PIPE ) right= fact[$ID.text] )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( ((LA58_0>=OR && LA58_0<=DOUBLE_PIPE)) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1119:6: ( OR | DOUBLE_PIPE ) right= fact[$ID.text]
                    	    {
                    	    if ( (input.LA(1)>=OR && input.LA(1)<=DOUBLE_PIPE) ) {
                    	        input.consume();
                    	        errorRecovery=false;failed=false;
                    	    }
                    	    else {
                    	        if (backtracking>0) {failed=true; return d;}
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_fact_binding3087);    throw mse;
                    	    }

                    	    pushFollow(FOLLOW_fact_in_fact_binding3099);
                    	    right=fact(ID48.getText());
                    	    _fsp--;
                    	    if (failed) return d;
                    	    if ( backtracking==0 ) {

                    	      				if ( or == null ) {
                    	      					or = new OrDescr();
                    	      					or.addDescr( left );
                    	      					d = or;
                    	      				}
                    	      				or.addDescr( right );
                    	       			
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_fact_binding3117); if (failed) return d;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end fact_binding


    // $ANTLR start fact
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1134:1: fact[String ident] returns [BaseDescr d] : id= qualified_id LEFT_PAREN ( constraints[pattern] )? RIGHT_PAREN ;
    public final BaseDescr fact(String ident) throws RecognitionException {
        BaseDescr d = null;

        Token LEFT_PAREN49=null;
        Token RIGHT_PAREN50=null;
        qualified_id_return id = null;



        		d =null;
        		PatternDescr pattern = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1140:11: (id= qualified_id LEFT_PAREN ( constraints[pattern] )? RIGHT_PAREN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1140:11: id= qualified_id LEFT_PAREN ( constraints[pattern] )? RIGHT_PAREN
            {
            if ( backtracking==0 ) {

               			pattern = new PatternDescr( );
               			if( ident != null ) {
               				pattern.setIdentifier( ident );
               			}
               			d = pattern; 
               	        
            }
            pushFollow(FOLLOW_qualified_id_in_fact3172);
            id=qualified_id();
            _fsp--;
            if (failed) return d;
            if ( backtracking==0 ) {
               
               			if( id != null ) {
              	 		        pattern.setObjectType( input.toString(id.start,id.stop) );
               			        pattern.setEndCharacter( -1 );
              				pattern.setStartCharacter( ((CommonToken)((Token)id.start)).getStartIndex() );
               			}
               		
            }
            LEFT_PAREN49=(Token)input.LT(1);
            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_fact3182); if (failed) return d;
            if ( backtracking==0 ) {

              		        location.setType( Location.LOCATION_LHS_INSIDE_CONDITION_START );
                          		location.setProperty( Location.LOCATION_PROPERTY_CLASS_NAME, input.toString(id.start,id.stop) );
               				
               			pattern.setLocation( offset(LEFT_PAREN49.getLine()), LEFT_PAREN49.getCharPositionInLine() );
               			pattern.setLeftParentCharacter( ((CommonToken)LEFT_PAREN49).getStartIndex() );
               		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1163:4: ( constraints[pattern] )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=ATTRIBUTES && LA60_0<=ID)||(LA60_0>=GLOBAL && LA60_0<=LEFT_PAREN)||(LA60_0>=QUERY && LA60_0<=WHEN)||LA60_0==ENABLED||LA60_0==SALIENCE||LA60_0==DURATION||LA60_0==FROM||LA60_0==EVAL||(LA60_0>=INIT && LA60_0<=RESULT)||(LA60_0>=CONTAINS && LA60_0<=IN)||LA60_0==THEN) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1163:6: constraints[pattern]
                    {
                    pushFollow(FOLLOW_constraints_in_fact3196);
                    constraints(pattern);
                    _fsp--;
                    if (failed) return d;

                    }
                    break;

            }

            RIGHT_PAREN50=(Token)input.LT(1);
            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_fact3207); if (failed) return d;
            if ( backtracking==0 ) {

              			this.location.setType( Location.LOCATION_LHS_BEGIN_OF_CONDITION );
              			pattern.setEndLocation( offset(RIGHT_PAREN50.getLine()), RIGHT_PAREN50.getCharPositionInLine() );	
              			pattern.setEndCharacter( ((CommonToken)RIGHT_PAREN50).getStopIndex() );
              		        pattern.setRightParentCharacter( ((CommonToken)RIGHT_PAREN50).getStartIndex() );
               		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end fact


    // $ANTLR start constraints
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1174:1: constraints[PatternDescr pattern] : constraint[$pattern] ( COMMA constraint[$pattern] )* ;
    public final void constraints(PatternDescr pattern) throws RecognitionException {
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1175:4: ( constraint[$pattern] ( COMMA constraint[$pattern] )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1175:4: constraint[$pattern] ( COMMA constraint[$pattern] )*
            {
            pushFollow(FOLLOW_constraint_in_constraints3227);
            constraint(pattern);
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1176:3: ( COMMA constraint[$pattern] )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==COMMA) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1176:5: COMMA constraint[$pattern]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_constraints3234); if (failed) return ;
            	    if ( backtracking==0 ) {
            	       location.setType( Location.LOCATION_LHS_INSIDE_CONDITION_START ); 
            	    }
            	    pushFollow(FOLLOW_constraint_in_constraints3243);
            	    constraint(pattern);
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


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
    // $ANTLR end constraints


    // $ANTLR start constraint
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1181:1: constraint[PatternDescr pattern] : ( options {backtrack=true; } : or_constr[top] ) ;
    public final void constraint(PatternDescr pattern) throws RecognitionException {

        		ConditionalElementDescr top = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1186:3: ( ( options {backtrack=true; } : or_constr[top] ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1186:3: ( options {backtrack=true; } : or_constr[top] )
            {
            if ( backtracking==0 ) {

              			top = pattern.getConstraint();
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1189:3: ( options {backtrack=true; } : or_constr[top] )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1190:5: or_constr[top]
            {
            pushFollow(FOLLOW_or_constr_in_constraint3289);
            or_constr(top);
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end constraint


    // $ANTLR start or_constr
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1194:1: or_constr[ConditionalElementDescr base] : and_constr[or] ( DOUBLE_PIPE and_constr[or] )* ;
    public final void or_constr(ConditionalElementDescr base) throws RecognitionException {

        		OrDescr or = new OrDescr();
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1199:3: ( and_constr[or] ( DOUBLE_PIPE and_constr[or] )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1199:3: and_constr[or] ( DOUBLE_PIPE and_constr[or] )*
            {
            pushFollow(FOLLOW_and_constr_in_or_constr3316);
            and_constr(or);
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1200:3: ( DOUBLE_PIPE and_constr[or] )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==DOUBLE_PIPE) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1200:5: DOUBLE_PIPE and_constr[or]
            	    {
            	    match(input,DOUBLE_PIPE,FOLLOW_DOUBLE_PIPE_in_or_constr3324); if (failed) return ;
            	    if ( backtracking==0 ) {

            	      			location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_START);
            	      		
            	    }
            	    pushFollow(FOLLOW_and_constr_in_or_constr3333);
            	    and_constr(or);
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            if ( backtracking==0 ) {

              		        if( or.getDescrs().size() == 1 ) {
              		                base.addOrMerge( (BaseDescr) or.getDescrs().get(0) );
              		        } else if ( or.getDescrs().size() > 1 ) {
              		        	base.addDescr( or );
              		        }
              		
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
    // $ANTLR end or_constr


    // $ANTLR start and_constr
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1215:1: and_constr[ConditionalElementDescr base] : unary_constr[and] ( DOUBLE_AMPER unary_constr[and] )* ;
    public final void and_constr(ConditionalElementDescr base) throws RecognitionException {

        		AndDescr and = new AndDescr();
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1220:3: ( unary_constr[and] ( DOUBLE_AMPER unary_constr[and] )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1220:3: unary_constr[and] ( DOUBLE_AMPER unary_constr[and] )*
            {
            pushFollow(FOLLOW_unary_constr_in_and_constr3365);
            unary_constr(and);
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1221:3: ( DOUBLE_AMPER unary_constr[and] )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==DOUBLE_AMPER) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1221:5: DOUBLE_AMPER unary_constr[and]
            	    {
            	    match(input,DOUBLE_AMPER,FOLLOW_DOUBLE_AMPER_in_and_constr3373); if (failed) return ;
            	    if ( backtracking==0 ) {

            	      			location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_START);
            	      		
            	    }
            	    pushFollow(FOLLOW_unary_constr_in_and_constr3382);
            	    unary_constr(and);
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            if ( backtracking==0 ) {

              		        if( and.getDescrs().size() == 1) {
              		                base.addOrMerge( (BaseDescr) and.getDescrs().get(0) );
              		        } else if( and.getDescrs().size() > 1) {
              		        	base.addDescr( and );
              		        }
              		
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
    // $ANTLR end and_constr


    // $ANTLR start unary_constr
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1236:1: unary_constr[ConditionalElementDescr base] : ( field_constraint[$base] | LEFT_PAREN or_constr[$base] RIGHT_PAREN | EVAL predicate[$base] ) ;
    public final void unary_constr(ConditionalElementDescr base) throws RecognitionException {
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1238:3: ( ( field_constraint[$base] | LEFT_PAREN or_constr[$base] RIGHT_PAREN | EVAL predicate[$base] ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1238:3: ( field_constraint[$base] | LEFT_PAREN or_constr[$base] RIGHT_PAREN | EVAL predicate[$base] )
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1238:3: ( field_constraint[$base] | LEFT_PAREN or_constr[$base] RIGHT_PAREN | EVAL predicate[$base] )
            int alt64=3;
            switch ( input.LA(1) ) {
            case ATTRIBUTES:
            case PACKAGE:
            case IMPORT:
            case FUNCTION:
            case ID:
            case GLOBAL:
            case QUERY:
            case END:
            case TEMPLATE:
            case RULE:
            case WHEN:
            case ENABLED:
            case SALIENCE:
            case DURATION:
            case FROM:
            case INIT:
            case ACTION:
            case REVERSE:
            case RESULT:
            case CONTAINS:
            case EXCLUDES:
            case MATCHES:
            case MEMBEROF:
            case IN:
            case THEN:
                {
                alt64=1;
                }
                break;
            case LEFT_PAREN:
                {
                alt64=2;
                }
                break;
            case EVAL:
                {
                alt64=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1238:3: ( field_constraint[$base] | LEFT_PAREN or_constr[$base] RIGHT_PAREN | EVAL predicate[$base] )", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1238:5: field_constraint[$base]
                    {
                    pushFollow(FOLLOW_field_constraint_in_unary_constr3410);
                    field_constraint(base);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1239:5: LEFT_PAREN or_constr[$base] RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_unary_constr3418); if (failed) return ;
                    pushFollow(FOLLOW_or_constr_in_unary_constr3420);
                    or_constr(base);
                    _fsp--;
                    if (failed) return ;
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_unary_constr3423); if (failed) return ;

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1240:5: EVAL predicate[$base]
                    {
                    match(input,EVAL,FOLLOW_EVAL_in_unary_constr3429); if (failed) return ;
                    pushFollow(FOLLOW_predicate_in_unary_constr3431);
                    predicate(base);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

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
    // $ANTLR end unary_constr


    // $ANTLR start field_constraint
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1244:1: field_constraint[ConditionalElementDescr base] : ( ID ':' )? f= accessor_path ( options {backtrack=true; } : or_restr_connective[top] | '->' predicate[$base] )? ;
    public final void field_constraint(ConditionalElementDescr base) throws RecognitionException {
        Token ID51=null;
        accessor_path_return f = null;



        		FieldBindingDescr fbd = null;
        		FieldConstraintDescr fc = null;
        		RestrictionConnectiveDescr top = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1251:3: ( ( ID ':' )? f= accessor_path ( options {backtrack=true; } : or_restr_connective[top] | '->' predicate[$base] )? )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1251:3: ( ID ':' )? f= accessor_path ( options {backtrack=true; } : or_restr_connective[top] | '->' predicate[$base] )?
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1251:3: ( ID ':' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==72) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1251:5: ID ':'
                    {
                    ID51=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_field_constraint3461); if (failed) return ;
                    match(input,72,FOLLOW_72_in_field_constraint3463); if (failed) return ;
                    if ( backtracking==0 ) {
                       
                      			fbd = new FieldBindingDescr();
                      			fbd.setIdentifier( ID51.getText() );
                      			fbd.setLocation( offset(ID51.getLine()), ID51.getCharPositionInLine() );
                      			fbd.setStartCharacter( ((CommonToken)ID51).getStartIndex() );
                      			base.addDescr( fbd );

                      		    
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_accessor_path_in_field_constraint3484);
            f=accessor_path();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              		    // use ((Token)f.start) to get token matched in identifier
              		    // or use input.toString(f.start,f.stop) to get text.
              		    if( input.toString(f.start,f.stop) != null ) {
              			location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_OPERATOR);
              			location.setProperty(Location.LOCATION_PROPERTY_PROPERTY_NAME, input.toString(f.start,f.stop));
              		    
              			if ( fbd != null ) {
              			    fbd.setFieldName( input.toString(f.start,f.stop) );
              			    // may have been overwritten
              			    fbd.setStartCharacter( ((CommonToken)ID51).getStartIndex() );
              			} 
              			fc = new FieldConstraintDescr(input.toString(f.start,f.stop));
              			fc.setLocation( offset(((Token)f.start).getLine()), ((Token)f.start).getCharPositionInLine() );
              			fc.setStartCharacter( ((CommonToken)((Token)f.start)).getStartIndex() );
              			top = fc.getRestriction();
              			
              			// it must be a field constraint, as it is not a binding
              			if( ID51 == null ) {
              			    base.addDescr( fc );
              			}
              		    }
              		
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1285:3: ( options {backtrack=true; } : or_restr_connective[top] | '->' predicate[$base] )?
            int alt66=3;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==LEFT_PAREN||LA66_0==NOT||(LA66_0>=CONTAINS && LA66_0<=IN)||(LA66_0>=75 && LA66_0<=80)) ) {
                alt66=1;
            }
            else if ( (LA66_0==74) ) {
                alt66=2;
            }
            switch (alt66) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1287:6: or_restr_connective[top]
                    {
                    pushFollow(FOLLOW_or_restr_connective_in_field_constraint3510);
                    or_restr_connective(top);
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {

                      				// we must add now as we didn't before
                      				if( ID51 != null) {
                      				    base.addDescr( fc );
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1295:4: '->' predicate[$base]
                    {
                    match(input,74,FOLLOW_74_in_field_constraint3525); if (failed) return ;
                    pushFollow(FOLLOW_predicate_in_field_constraint3527);
                    predicate(base);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

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
    // $ANTLR end field_constraint


    // $ANTLR start or_restr_connective
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1300:1: or_restr_connective[ RestrictionConnectiveDescr base ] : and_restr_connective[or] ( options {backtrack=true; } : DOUBLE_PIPE and_restr_connective[or] )* ;
    public final void or_restr_connective(RestrictionConnectiveDescr base) throws RecognitionException {

        		RestrictionConnectiveDescr or = new RestrictionConnectiveDescr(RestrictionConnectiveDescr.OR);
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1305:3: ( and_restr_connective[or] ( options {backtrack=true; } : DOUBLE_PIPE and_restr_connective[or] )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1305:3: and_restr_connective[or] ( options {backtrack=true; } : DOUBLE_PIPE and_restr_connective[or] )*
            {
            pushFollow(FOLLOW_and_restr_connective_in_or_restr_connective3556);
            and_restr_connective(or);
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1306:3: ( options {backtrack=true; } : DOUBLE_PIPE and_restr_connective[or] )*
            loop67:
            do {
                int alt67=2;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1307:5: DOUBLE_PIPE and_restr_connective[or]
            	    {
            	    match(input,DOUBLE_PIPE,FOLLOW_DOUBLE_PIPE_in_or_restr_connective3575); if (failed) return ;
            	    if ( backtracking==0 ) {

            	      				location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_OPERATOR);
            	      			
            	    }
            	    pushFollow(FOLLOW_and_restr_connective_in_or_restr_connective3587);
            	    and_restr_connective(or);
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	        if( or.getRestrictions().size() == 1 ) {
            	                base.addOrMerge( (RestrictionDescr) or.getRestrictions().get( 0 ) );
            	        } else if ( or.getRestrictions().size() > 1 ) {
            	        	base.addRestriction( or );
            	        }
            	
        }
        return ;
    }
    // $ANTLR end or_restr_connective


    // $ANTLR start and_restr_connective
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1322:1: and_restr_connective[ RestrictionConnectiveDescr base ] : constraint_expression[and] ( options {backtrack=true; } : t= DOUBLE_AMPER constraint_expression[and] )* ;
    public final void and_restr_connective(RestrictionConnectiveDescr base) throws RecognitionException {
        Token t=null;


        		RestrictionConnectiveDescr and = new RestrictionConnectiveDescr(RestrictionConnectiveDescr.AND);
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1327:3: ( constraint_expression[and] ( options {backtrack=true; } : t= DOUBLE_AMPER constraint_expression[and] )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1327:3: constraint_expression[and] ( options {backtrack=true; } : t= DOUBLE_AMPER constraint_expression[and] )*
            {
            pushFollow(FOLLOW_constraint_expression_in_and_restr_connective3619);
            constraint_expression(and);
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1328:3: ( options {backtrack=true; } : t= DOUBLE_AMPER constraint_expression[and] )*
            loop68:
            do {
                int alt68=2;
                alt68 = dfa68.predict(input);
                switch (alt68) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1329:5: t= DOUBLE_AMPER constraint_expression[and]
            	    {
            	    t=(Token)input.LT(1);
            	    match(input,DOUBLE_AMPER,FOLLOW_DOUBLE_AMPER_in_and_restr_connective3640); if (failed) return ;
            	    if ( backtracking==0 ) {

            	      				location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_OPERATOR);
            	      			
            	    }
            	    pushFollow(FOLLOW_constraint_expression_in_and_restr_connective3651);
            	    constraint_expression(and);
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	        if( and.getRestrictions().size() == 1) {
            	                base.addOrMerge( (RestrictionDescr) and.getRestrictions().get( 0 ) );
            	        } else if ( and.getRestrictions().size() > 1 ) {
            	        	base.addRestriction( and );
            	        }
            	
        }
        return ;
    }
    // $ANTLR end and_restr_connective


    // $ANTLR start constraint_expression
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1344:1: constraint_expression[RestrictionConnectiveDescr base] : ( compound_operator[$base] | simple_operator[$base] | LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN ) ;
    public final void constraint_expression(RestrictionConnectiveDescr base) throws RecognitionException {
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1346:3: ( ( compound_operator[$base] | simple_operator[$base] | LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1346:3: ( compound_operator[$base] | simple_operator[$base] | LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN )
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1346:3: ( compound_operator[$base] | simple_operator[$base] | LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN )
            int alt69=3;
            switch ( input.LA(1) ) {
            case IN:
                {
                alt69=1;
                }
                break;
            case NOT:
                {
                int LA69_2 = input.LA(2);

                if ( (LA69_2==IN) ) {
                    alt69=1;
                }
                else if ( (LA69_2==CONTAINS||(LA69_2>=MATCHES && LA69_2<=MEMBEROF)) ) {
                    alt69=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("1346:3: ( compound_operator[$base] | simple_operator[$base] | LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN )", 69, 2, input);

                    throw nvae;
                }
                }
                break;
            case CONTAINS:
            case EXCLUDES:
            case MATCHES:
            case MEMBEROF:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
                {
                alt69=2;
                }
                break;
            case LEFT_PAREN:
                {
                alt69=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1346:3: ( compound_operator[$base] | simple_operator[$base] | LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN )", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1346:5: compound_operator[$base]
                    {
                    pushFollow(FOLLOW_compound_operator_in_constraint_expression3688);
                    compound_operator(base);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1347:5: simple_operator[$base]
                    {
                    pushFollow(FOLLOW_simple_operator_in_constraint_expression3695);
                    simple_operator(base);
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1348:5: LEFT_PAREN or_restr_connective[$base] RIGHT_PAREN
                    {
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_constraint_expression3702); if (failed) return ;
                    if ( backtracking==0 ) {

                      			location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_OPERATOR);
                      		
                    }
                    pushFollow(FOLLOW_or_restr_connective_in_constraint_expression3711);
                    or_restr_connective(base);
                    _fsp--;
                    if (failed) return ;
                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_constraint_expression3717); if (failed) return ;

                    }
                    break;

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
    // $ANTLR end constraint_expression


    // $ANTLR start simple_operator
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1357:1: simple_operator[RestrictionConnectiveDescr base] : (t= '==' | t= '>' | t= '>=' | t= '<' | t= '<=' | t= '!=' | t= CONTAINS | n= NOT t= CONTAINS | t= EXCLUDES | t= MATCHES | n= NOT t= MATCHES | t= MEMBEROF | n= NOT t= MEMBEROF ) rd= expression_value[$base, op] ;
    public final void simple_operator(RestrictionConnectiveDescr base) throws RecognitionException {
        Token t=null;
        Token n=null;
        RestrictionDescr rd = null;



        		String op = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1362:3: ( (t= '==' | t= '>' | t= '>=' | t= '<' | t= '<=' | t= '!=' | t= CONTAINS | n= NOT t= CONTAINS | t= EXCLUDES | t= MATCHES | n= NOT t= MATCHES | t= MEMBEROF | n= NOT t= MEMBEROF ) rd= expression_value[$base, op] )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1362:3: (t= '==' | t= '>' | t= '>=' | t= '<' | t= '<=' | t= '!=' | t= CONTAINS | n= NOT t= CONTAINS | t= EXCLUDES | t= MATCHES | n= NOT t= MATCHES | t= MEMBEROF | n= NOT t= MEMBEROF ) rd= expression_value[$base, op]
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1362:3: (t= '==' | t= '>' | t= '>=' | t= '<' | t= '<=' | t= '!=' | t= CONTAINS | n= NOT t= CONTAINS | t= EXCLUDES | t= MATCHES | n= NOT t= MATCHES | t= MEMBEROF | n= NOT t= MEMBEROF )
            int alt70=13;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt70=1;
                }
                break;
            case 76:
                {
                alt70=2;
                }
                break;
            case 77:
                {
                alt70=3;
                }
                break;
            case 78:
                {
                alt70=4;
                }
                break;
            case 79:
                {
                alt70=5;
                }
                break;
            case 80:
                {
                alt70=6;
                }
                break;
            case CONTAINS:
                {
                alt70=7;
                }
                break;
            case NOT:
                {
                switch ( input.LA(2) ) {
                case CONTAINS:
                    {
                    alt70=8;
                    }
                    break;
                case MEMBEROF:
                    {
                    alt70=13;
                    }
                    break;
                case MATCHES:
                    {
                    alt70=11;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("1362:3: (t= '==' | t= '>' | t= '>=' | t= '<' | t= '<=' | t= '!=' | t= CONTAINS | n= NOT t= CONTAINS | t= EXCLUDES | t= MATCHES | n= NOT t= MATCHES | t= MEMBEROF | n= NOT t= MEMBEROF )", 70, 8, input);

                    throw nvae;
                }

                }
                break;
            case EXCLUDES:
                {
                alt70=9;
                }
                break;
            case MATCHES:
                {
                alt70=10;
                }
                break;
            case MEMBEROF:
                {
                alt70=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1362:3: (t= '==' | t= '>' | t= '>=' | t= '<' | t= '<=' | t= '!=' | t= CONTAINS | n= NOT t= CONTAINS | t= EXCLUDES | t= MATCHES | n= NOT t= MATCHES | t= MEMBEROF | n= NOT t= MEMBEROF )", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1362:5: t= '=='
                    {
                    t=(Token)input.LT(1);
                    match(input,75,FOLLOW_75_in_simple_operator3748); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1363:5: t= '>'
                    {
                    t=(Token)input.LT(1);
                    match(input,76,FOLLOW_76_in_simple_operator3756); if (failed) return ;

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1364:5: t= '>='
                    {
                    t=(Token)input.LT(1);
                    match(input,77,FOLLOW_77_in_simple_operator3764); if (failed) return ;

                    }
                    break;
                case 4 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1365:5: t= '<'
                    {
                    t=(Token)input.LT(1);
                    match(input,78,FOLLOW_78_in_simple_operator3772); if (failed) return ;

                    }
                    break;
                case 5 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1366:5: t= '<='
                    {
                    t=(Token)input.LT(1);
                    match(input,79,FOLLOW_79_in_simple_operator3780); if (failed) return ;

                    }
                    break;
                case 6 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1367:5: t= '!='
                    {
                    t=(Token)input.LT(1);
                    match(input,80,FOLLOW_80_in_simple_operator3788); if (failed) return ;

                    }
                    break;
                case 7 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1368:5: t= CONTAINS
                    {
                    t=(Token)input.LT(1);
                    match(input,CONTAINS,FOLLOW_CONTAINS_in_simple_operator3796); if (failed) return ;

                    }
                    break;
                case 8 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1369:5: n= NOT t= CONTAINS
                    {
                    n=(Token)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_simple_operator3804); if (failed) return ;
                    t=(Token)input.LT(1);
                    match(input,CONTAINS,FOLLOW_CONTAINS_in_simple_operator3808); if (failed) return ;

                    }
                    break;
                case 9 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1370:5: t= EXCLUDES
                    {
                    t=(Token)input.LT(1);
                    match(input,EXCLUDES,FOLLOW_EXCLUDES_in_simple_operator3816); if (failed) return ;

                    }
                    break;
                case 10 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1371:5: t= MATCHES
                    {
                    t=(Token)input.LT(1);
                    match(input,MATCHES,FOLLOW_MATCHES_in_simple_operator3824); if (failed) return ;

                    }
                    break;
                case 11 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1372:5: n= NOT t= MATCHES
                    {
                    n=(Token)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_simple_operator3832); if (failed) return ;
                    t=(Token)input.LT(1);
                    match(input,MATCHES,FOLLOW_MATCHES_in_simple_operator3836); if (failed) return ;

                    }
                    break;
                case 12 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1373:5: t= MEMBEROF
                    {
                    t=(Token)input.LT(1);
                    match(input,MEMBEROF,FOLLOW_MEMBEROF_in_simple_operator3844); if (failed) return ;

                    }
                    break;
                case 13 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1374:5: n= NOT t= MEMBEROF
                    {
                    n=(Token)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_simple_operator3852); if (failed) return ;
                    t=(Token)input.LT(1);
                    match(input,MEMBEROF,FOLLOW_MEMBEROF_in_simple_operator3856); if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {

                		    location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_ARGUMENT);
                                  location.setProperty(Location.LOCATION_PROPERTY_OPERATOR, t.getText());
              		    if( n != null ) {
              		        op = "not "+t.getText();
              		    } else {
              		        op = t.getText();
              		    }
              		
            }
            pushFollow(FOLLOW_expression_value_in_simple_operator3870);
            rd=expression_value(base,  op);
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            		if ( rd == null && op != null ) {
            		        base.addRestriction( new LiteralRestrictionDescr(op, null) );
            		}
            	
        }
        return ;
    }
    // $ANTLR end simple_operator


    // $ANTLR start compound_operator
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1393:1: compound_operator[RestrictionConnectiveDescr base] : ( IN | NOT IN ) LEFT_PAREN rd= expression_value[group, op] ( COMMA rd= expression_value[group, op] )* RIGHT_PAREN ;
    public final void compound_operator(RestrictionConnectiveDescr base) throws RecognitionException {
        RestrictionDescr rd = null;



        		String op = null;
        		RestrictionConnectiveDescr group = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1399:3: ( ( IN | NOT IN ) LEFT_PAREN rd= expression_value[group, op] ( COMMA rd= expression_value[group, op] )* RIGHT_PAREN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1399:3: ( IN | NOT IN ) LEFT_PAREN rd= expression_value[group, op] ( COMMA rd= expression_value[group, op] )* RIGHT_PAREN
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1399:3: ( IN | NOT IN )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==IN) ) {
                alt71=1;
            }
            else if ( (LA71_0==NOT) ) {
                alt71=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("1399:3: ( IN | NOT IN )", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1399:5: IN
                    {
                    match(input,IN,FOLLOW_IN_in_compound_operator3900); if (failed) return ;
                    if ( backtracking==0 ) {

                      			  op = "==";
                      			  group = new RestrictionConnectiveDescr(RestrictionConnectiveDescr.OR);
                      			  base.addRestriction( group );
                        		    	  location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_ARGUMENT);
                                          	  location.setProperty(Location.LOCATION_PROPERTY_OPERATOR, "in");
                      			
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1407:5: NOT IN
                    {
                    match(input,NOT,FOLLOW_NOT_in_compound_operator3912); if (failed) return ;
                    match(input,IN,FOLLOW_IN_in_compound_operator3914); if (failed) return ;
                    if ( backtracking==0 ) {

                      			  op = "!=";
                      			  group = new RestrictionConnectiveDescr(RestrictionConnectiveDescr.AND);
                      			  base.addRestriction( group );
                        		    	  location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_ARGUMENT);
                                          	  location.setProperty(Location.LOCATION_PROPERTY_OPERATOR, "in");
                      			
                    }

                    }
                    break;

            }

            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_compound_operator3929); if (failed) return ;
            pushFollow(FOLLOW_expression_value_in_compound_operator3933);
            rd=expression_value(group,  op);
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1417:3: ( COMMA rd= expression_value[group, op] )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==COMMA) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1417:5: COMMA rd= expression_value[group, op]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_compound_operator3940); if (failed) return ;
            	    pushFollow(FOLLOW_expression_value_in_compound_operator3944);
            	    rd=expression_value(group,  op);
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_compound_operator3953); if (failed) return ;
            if ( backtracking==0 ) {

              			location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_END);
              		
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
    // $ANTLR end compound_operator


    // $ANTLR start expression_value
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1424:1: expression_value[RestrictionConnectiveDescr base, String op] returns [RestrictionDescr rd] : (ap= accessor_path | lc= literal_constraint | rvc= paren_chunk ) ;
    public final RestrictionDescr expression_value(RestrictionConnectiveDescr base, String op) throws RecognitionException {
        RestrictionDescr rd = null;

        accessor_path_return ap = null;

        String lc = null;

        paren_chunk_return rvc = null;



        		rd = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1429:3: ( (ap= accessor_path | lc= literal_constraint | rvc= paren_chunk ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1429:3: (ap= accessor_path | lc= literal_constraint | rvc= paren_chunk )
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1429:3: (ap= accessor_path | lc= literal_constraint | rvc= paren_chunk )
            int alt73=3;
            switch ( input.LA(1) ) {
            case ATTRIBUTES:
            case PACKAGE:
            case IMPORT:
            case FUNCTION:
            case ID:
            case GLOBAL:
            case QUERY:
            case END:
            case TEMPLATE:
            case RULE:
            case WHEN:
            case ENABLED:
            case SALIENCE:
            case DURATION:
            case FROM:
            case INIT:
            case ACTION:
            case REVERSE:
            case RESULT:
            case CONTAINS:
            case EXCLUDES:
            case MATCHES:
            case MEMBEROF:
            case IN:
            case THEN:
                {
                alt73=1;
                }
                break;
            case STRING:
            case BOOL:
            case INT:
            case FLOAT:
            case NULL:
                {
                alt73=2;
                }
                break;
            case LEFT_PAREN:
                {
                alt73=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return rd;}
                NoViableAltException nvae =
                    new NoViableAltException("1429:3: (ap= accessor_path | lc= literal_constraint | rvc= paren_chunk )", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1429:5: ap= accessor_path
                    {
                    pushFollow(FOLLOW_accessor_path_in_expression_value3987);
                    ap=accessor_path();
                    _fsp--;
                    if (failed) return rd;
                    if ( backtracking==0 ) {
                       
                      			        if( input.toString(ap.start,ap.stop).indexOf( '.' ) > -1 || input.toString(ap.start,ap.stop).indexOf( '[' ) > -1) {
                      					rd = new QualifiedIdentifierRestrictionDescr(op, input.toString(ap.start,ap.stop));
                      				} else {
                      					rd = new VariableRestrictionDescr(op, input.toString(ap.start,ap.stop));
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1437:5: lc= literal_constraint
                    {
                    pushFollow(FOLLOW_literal_constraint_in_expression_value4007);
                    lc=literal_constraint();
                    _fsp--;
                    if (failed) return rd;
                    if ( backtracking==0 ) {
                       
                      				rd = new LiteralRestrictionDescr(op, lc);
                      			
                    }

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1441:5: rvc= paren_chunk
                    {
                    pushFollow(FOLLOW_paren_chunk_in_expression_value4021);
                    rvc=paren_chunk();
                    _fsp--;
                    if (failed) return rd;
                    if ( backtracking==0 ) {
                       
                      				rd = new ReturnValueRestrictionDescr(op, input.toString(rvc.start,rvc.stop).substring(1, input.toString(rvc.start,rvc.stop).length()-1) );							
                      			
                    }

                    }
                    break;

            }

            if ( backtracking==0 ) {

              			if( rd != null ) {
              				base.addRestriction( rd );
              			}
              			location.setType(Location.LOCATION_LHS_INSIDE_CONDITION_END);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rd;
    }
    // $ANTLR end expression_value


    // $ANTLR start literal_constraint
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1454:1: literal_constraint returns [String text] : (t= STRING | t= INT | t= FLOAT | t= BOOL | t= NULL ) ;
    public final String literal_constraint() throws RecognitionException {
        String text = null;

        Token t=null;


        		text = null;
        	
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1458:4: ( (t= STRING | t= INT | t= FLOAT | t= BOOL | t= NULL ) )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1458:4: (t= STRING | t= INT | t= FLOAT | t= BOOL | t= NULL )
            {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1458:4: (t= STRING | t= INT | t= FLOAT | t= BOOL | t= NULL )
            int alt74=5;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt74=1;
                }
                break;
            case INT:
                {
                alt74=2;
                }
                break;
            case FLOAT:
                {
                alt74=3;
                }
                break;
            case BOOL:
                {
                alt74=4;
                }
                break;
            case NULL:
                {
                alt74=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return text;}
                NoViableAltException nvae =
                    new NoViableAltException("1458:4: (t= STRING | t= INT | t= FLOAT | t= BOOL | t= NULL )", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1458:6: t= STRING
                    {
                    t=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_literal_constraint4064); if (failed) return text;
                    if ( backtracking==0 ) {
                       text = getString( t.getText() ); 
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1459:5: t= INT
                    {
                    t=(Token)input.LT(1);
                    match(input,INT,FOLLOW_INT_in_literal_constraint4075); if (failed) return text;
                    if ( backtracking==0 ) {
                       text = t.getText(); 
                    }

                    }
                    break;
                case 3 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1460:5: t= FLOAT
                    {
                    t=(Token)input.LT(1);
                    match(input,FLOAT,FOLLOW_FLOAT_in_literal_constraint4088); if (failed) return text;
                    if ( backtracking==0 ) {
                       text = t.getText(); 
                    }

                    }
                    break;
                case 4 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1461:5: t= BOOL
                    {
                    t=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_literal_constraint4099); if (failed) return text;
                    if ( backtracking==0 ) {
                       text = t.getText(); 
                    }

                    }
                    break;
                case 5 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1462:5: t= NULL
                    {
                    t=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_literal_constraint4111); if (failed) return text;
                    if ( backtracking==0 ) {
                       text = null; 
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return text;
    }
    // $ANTLR end literal_constraint


    // $ANTLR start predicate
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1466:1: predicate[ConditionalElementDescr base] : text= paren_chunk ;
    public final void predicate(ConditionalElementDescr base) throws RecognitionException {
        paren_chunk_return text = null;



        		PredicateDescr d = null;
                
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1471:3: (text= paren_chunk )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1471:3: text= paren_chunk
            {
            pushFollow(FOLLOW_paren_chunk_in_predicate4149);
            text=paren_chunk();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

              		        if( input.toString(text.start,text.stop) != null ) {
              				d = new PredicateDescr( );
              			        d.setContent( input.toString(text.start,text.stop).substring(1, input.toString(text.start,text.stop).length()-1) );
              				d.setEndCharacter( ((CommonToken)((Token)text.stop)).getStopIndex() );
              				base.addDescr( d );
              		        }
              		
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
    // $ANTLR end predicate

    public static class curly_chunk_return extends ParserRuleReturnScope {
    };

    // $ANTLR start curly_chunk
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1483:1: curly_chunk : LEFT_CURLY (~ ( LEFT_CURLY | RIGHT_CURLY ) | curly_chunk )* RIGHT_CURLY ;
    public final curly_chunk_return curly_chunk() throws RecognitionException {
        curly_chunk_return retval = new curly_chunk_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1485:3: ( LEFT_CURLY (~ ( LEFT_CURLY | RIGHT_CURLY ) | curly_chunk )* RIGHT_CURLY )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1485:3: LEFT_CURLY (~ ( LEFT_CURLY | RIGHT_CURLY ) | curly_chunk )* RIGHT_CURLY
            {
            match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_curly_chunk4167); if (failed) return retval;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1485:14: (~ ( LEFT_CURLY | RIGHT_CURLY ) | curly_chunk )*
            loop75:
            do {
                int alt75=3;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0>=ATTRIBUTES && LA75_0<=NULL)||(LA75_0>=LEFT_SQUARE && LA75_0<=80)) ) {
                    alt75=1;
                }
                else if ( (LA75_0==LEFT_CURLY) ) {
                    alt75=2;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1485:16: ~ ( LEFT_CURLY | RIGHT_CURLY )
            	    {
            	    if ( (input.LA(1)>=ATTRIBUTES && input.LA(1)<=NULL)||(input.LA(1)>=LEFT_SQUARE && input.LA(1)<=80) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_curly_chunk4171);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1485:44: curly_chunk
            	    {
            	    pushFollow(FOLLOW_curly_chunk_in_curly_chunk4180);
            	    curly_chunk();
            	    _fsp--;
            	    if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_curly_chunk4185); if (failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end curly_chunk

    public static class paren_chunk_return extends ParserRuleReturnScope {
    };

    // $ANTLR start paren_chunk
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1488:1: paren_chunk : LEFT_PAREN (~ ( LEFT_PAREN | RIGHT_PAREN ) | paren_chunk )* RIGHT_PAREN ;
    public final paren_chunk_return paren_chunk() throws RecognitionException {
        paren_chunk_return retval = new paren_chunk_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1490:3: ( LEFT_PAREN (~ ( LEFT_PAREN | RIGHT_PAREN ) | paren_chunk )* RIGHT_PAREN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1490:3: LEFT_PAREN (~ ( LEFT_PAREN | RIGHT_PAREN ) | paren_chunk )* RIGHT_PAREN
            {
            match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_paren_chunk4199); if (failed) return retval;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1490:14: (~ ( LEFT_PAREN | RIGHT_PAREN ) | paren_chunk )*
            loop76:
            do {
                int alt76=3;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0>=ATTRIBUTES && LA76_0<=GLOBAL)||LA76_0==COMMA||(LA76_0>=QUERY && LA76_0<=80)) ) {
                    alt76=1;
                }
                else if ( (LA76_0==LEFT_PAREN) ) {
                    alt76=2;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1490:16: ~ ( LEFT_PAREN | RIGHT_PAREN )
            	    {
            	    if ( (input.LA(1)>=ATTRIBUTES && input.LA(1)<=GLOBAL)||input.LA(1)==COMMA||(input.LA(1)>=QUERY && input.LA(1)<=80) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_paren_chunk4203);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1490:44: paren_chunk
            	    {
            	    pushFollow(FOLLOW_paren_chunk_in_paren_chunk4212);
            	    paren_chunk();
            	    _fsp--;
            	    if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_paren_chunk4217); if (failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end paren_chunk

    public static class square_chunk_return extends ParserRuleReturnScope {
    };

    // $ANTLR start square_chunk
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1493:1: square_chunk : LEFT_SQUARE (~ ( LEFT_SQUARE | RIGHT_SQUARE ) | square_chunk )* RIGHT_SQUARE ;
    public final square_chunk_return square_chunk() throws RecognitionException {
        square_chunk_return retval = new square_chunk_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1495:3: ( LEFT_SQUARE (~ ( LEFT_SQUARE | RIGHT_SQUARE ) | square_chunk )* RIGHT_SQUARE )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1495:3: LEFT_SQUARE (~ ( LEFT_SQUARE | RIGHT_SQUARE ) | square_chunk )* RIGHT_SQUARE
            {
            match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_square_chunk4230); if (failed) return retval;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1495:15: (~ ( LEFT_SQUARE | RIGHT_SQUARE ) | square_chunk )*
            loop77:
            do {
                int alt77=3;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=ATTRIBUTES && LA77_0<=RIGHT_CURLY)||(LA77_0>=THEN && LA77_0<=80)) ) {
                    alt77=1;
                }
                else if ( (LA77_0==LEFT_SQUARE) ) {
                    alt77=2;
                }


                switch (alt77) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1495:17: ~ ( LEFT_SQUARE | RIGHT_SQUARE )
            	    {
            	    if ( (input.LA(1)>=ATTRIBUTES && input.LA(1)<=RIGHT_CURLY)||(input.LA(1)>=THEN && input.LA(1)<=80) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_square_chunk4234);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1495:47: square_chunk
            	    {
            	    pushFollow(FOLLOW_square_chunk_in_square_chunk4243);
            	    square_chunk();
            	    _fsp--;
            	    if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_square_chunk4248); if (failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end square_chunk

    public static class qualified_id_return extends ParserRuleReturnScope {
    };

    // $ANTLR start qualified_id
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1498:1: qualified_id : ID ( DOT identifier )* ( LEFT_SQUARE RIGHT_SQUARE )* ;
    public final qualified_id_return qualified_id() throws RecognitionException {
        qualified_id_return retval = new qualified_id_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1499:5: ( ID ( DOT identifier )* ( LEFT_SQUARE RIGHT_SQUARE )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1499:5: ID ( DOT identifier )* ( LEFT_SQUARE RIGHT_SQUARE )*
            {
            match(input,ID,FOLLOW_ID_in_qualified_id4261); if (failed) return retval;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1499:8: ( DOT identifier )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==DOT) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1499:10: DOT identifier
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualified_id4265); if (failed) return retval;
            	    pushFollow(FOLLOW_identifier_in_qualified_id4267);
            	    identifier();
            	    _fsp--;
            	    if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1499:28: ( LEFT_SQUARE RIGHT_SQUARE )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==LEFT_SQUARE) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1499:30: LEFT_SQUARE RIGHT_SQUARE
            	    {
            	    match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_qualified_id4274); if (failed) return retval;
            	    match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_qualified_id4276); if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end qualified_id

    public static class dotted_name_return extends ParserRuleReturnScope {
    };

    // $ANTLR start dotted_name
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1502:1: dotted_name : identifier ( DOT identifier )* ( LEFT_SQUARE RIGHT_SQUARE )* ;
    public final dotted_name_return dotted_name() throws RecognitionException {
        dotted_name_return retval = new dotted_name_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1503:4: ( identifier ( DOT identifier )* ( LEFT_SQUARE RIGHT_SQUARE )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1503:4: identifier ( DOT identifier )* ( LEFT_SQUARE RIGHT_SQUARE )*
            {
            pushFollow(FOLLOW_identifier_in_dotted_name4291);
            identifier();
            _fsp--;
            if (failed) return retval;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1503:15: ( DOT identifier )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==DOT) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1503:17: DOT identifier
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_dotted_name4295); if (failed) return retval;
            	    pushFollow(FOLLOW_identifier_in_dotted_name4297);
            	    identifier();
            	    _fsp--;
            	    if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1503:35: ( LEFT_SQUARE RIGHT_SQUARE )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==LEFT_SQUARE) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1503:37: LEFT_SQUARE RIGHT_SQUARE
            	    {
            	    match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_dotted_name4304); if (failed) return retval;
            	    match(input,RIGHT_SQUARE,FOLLOW_RIGHT_SQUARE_in_dotted_name4306); if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end dotted_name

    public static class accessor_path_return extends ParserRuleReturnScope {
    };

    // $ANTLR start accessor_path
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1506:1: accessor_path : accessor_element ( DOT accessor_element )* ;
    public final accessor_path_return accessor_path() throws RecognitionException {
        accessor_path_return retval = new accessor_path_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1507:4: ( accessor_element ( DOT accessor_element )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1507:4: accessor_element ( DOT accessor_element )*
            {
            pushFollow(FOLLOW_accessor_element_in_accessor_path4322);
            accessor_element();
            _fsp--;
            if (failed) return retval;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1507:21: ( DOT accessor_element )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==DOT) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1507:23: DOT accessor_element
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_accessor_path4326); if (failed) return retval;
            	    pushFollow(FOLLOW_accessor_element_in_accessor_path4328);
            	    accessor_element();
            	    _fsp--;
            	    if (failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end accessor_path


    // $ANTLR start accessor_element
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1510:1: accessor_element : identifier ( square_chunk )* ;
    public final void accessor_element() throws RecognitionException {
        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1512:3: ( identifier ( square_chunk )* )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1512:3: identifier ( square_chunk )*
            {
            pushFollow(FOLLOW_identifier_in_accessor_element4346);
            identifier();
            _fsp--;
            if (failed) return ;
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1512:14: ( square_chunk )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==LEFT_SQUARE) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1512:14: square_chunk
            	    {
            	    pushFollow(FOLLOW_square_chunk_in_accessor_element4348);
            	    square_chunk();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


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
    // $ANTLR end accessor_element


    // $ANTLR start rhs_chunk
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1515:1: rhs_chunk[RuleDescr rule] : THEN (~ END )* loc= END opt_semicolon ;
    public final void rhs_chunk(RuleDescr rule) throws RecognitionException {
        Token loc=null;
        Token THEN52=null;

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1517:3: ( THEN (~ END )* loc= END opt_semicolon )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1517:3: THEN (~ END )* loc= END opt_semicolon
            {
            THEN52=(Token)input.LT(1);
            match(input,THEN,FOLLOW_THEN_in_rhs_chunk4365); if (failed) return ;
            if ( backtracking==0 ) {
               location.setType( Location.LOCATION_RHS ); 
            }
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1518:3: (~ END )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( ((LA84_0>=ATTRIBUTES && LA84_0<=QUERY)||(LA84_0>=TEMPLATE && LA84_0<=80)) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1518:5: ~ END
            	    {
            	    if ( (input.LA(1)>=ATTRIBUTES && input.LA(1)<=QUERY)||(input.LA(1)>=TEMPLATE && input.LA(1)<=80) ) {
            	        input.consume();
            	        errorRecovery=false;failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_rhs_chunk4373);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            loc=(Token)input.LT(1);
            match(input,END,FOLLOW_END_in_rhs_chunk4397); if (failed) return ;
            pushFollow(FOLLOW_opt_semicolon_in_rhs_chunk4399);
            opt_semicolon();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {

                                  // ignoring first line in the consequence
                                  String buf = input.toString( THEN52, loc );
                                  // removing final END keyword
                                  buf = buf.substring( 0, buf.length()-3 );
                                  if( buf.indexOf( '\n' ) > -1 ) {
                                      buf = buf.substring( buf.indexOf( '\n' ) + 1 );
                                  } else if ( buf.indexOf( '\r' ) > -1 ) {
                                      buf = buf.substring( buf.indexOf( '\r' ) + 1 );
                                  }
              		    rule.setConsequence( buf );
                   		    rule.setConsequenceLocation(offset(THEN52.getLine()), THEN52.getCharPositionInLine());
               		    rule.setEndCharacter( ((CommonToken)loc).getStopIndex() );
               		    location.setProperty( Location.LOCATION_RHS_CONTENT, rule.getConsequence() );
                              
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
    // $ANTLR end rhs_chunk


    // $ANTLR start name
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1537:1: name returns [String name] : ( ID | STRING );
    public final String name() throws RecognitionException {
        String name = null;

        Token ID53=null;
        Token STRING54=null;

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1538:5: ( ID | STRING )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==ID) ) {
                alt85=1;
            }
            else if ( (LA85_0==STRING) ) {
                alt85=2;
            }
            else {
                if (backtracking>0) {failed=true; return name;}
                NoViableAltException nvae =
                    new NoViableAltException("1537:1: name returns [String name] : ( ID | STRING );", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1538:5: ID
                    {
                    ID53=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_name4433); if (failed) return name;
                    if ( backtracking==0 ) {
                       name = ID53.getText(); 
                    }

                    }
                    break;
                case 2 :
                    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1539:5: STRING
                    {
                    STRING54=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_name4441); if (failed) return name;
                    if ( backtracking==0 ) {
                       name = getString( STRING54.getText() ); 
                    }

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
        return name;
    }
    // $ANTLR end name

    public static class identifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start identifier
    // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1542:1: identifier : ( ID | PACKAGE | FUNCTION | GLOBAL | IMPORT | RULE | QUERY | TEMPLATE | ATTRIBUTES | ENABLED | SALIENCE | DURATION | FROM | INIT | ACTION | REVERSE | RESULT | CONTAINS | EXCLUDES | MEMBEROF | MATCHES | WHEN | THEN | END | IN );
    public final identifier_return identifier() throws RecognitionException {
        identifier_return retval = new identifier_return();
        retval.start = input.LT(1);

        try {
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1543:10: ( ID | PACKAGE | FUNCTION | GLOBAL | IMPORT | RULE | QUERY | TEMPLATE | ATTRIBUTES | ENABLED | SALIENCE | DURATION | FROM | INIT | ACTION | REVERSE | RESULT | CONTAINS | EXCLUDES | MEMBEROF | MATCHES | WHEN | THEN | END | IN )
            // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:
            {
            if ( (input.LA(1)>=ATTRIBUTES && input.LA(1)<=ID)||input.LA(1)==GLOBAL||(input.LA(1)>=QUERY && input.LA(1)<=WHEN)||input.LA(1)==ENABLED||input.LA(1)==SALIENCE||input.LA(1)==DURATION||input.LA(1)==FROM||(input.LA(1)>=INIT && input.LA(1)<=RESULT)||(input.LA(1)>=CONTAINS && input.LA(1)<=IN)||input.LA(1)==THEN ) {
                input.consume();
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_identifier0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end identifier

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:987:6: ( LEFT_SQUARE )
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:987:8: LEFT_SQUARE
        {
        match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_synpred12751); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:993:6: ( LEFT_PAREN )
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:993:8: LEFT_PAREN
        {
        match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_synpred22784); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1307:5: ( DOUBLE_PIPE and_restr_connective[or] )
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1307:5: DOUBLE_PIPE and_restr_connective[or]
        {
        match(input,DOUBLE_PIPE,FOLLOW_DOUBLE_PIPE_in_synpred53575); if (failed) return ;
        pushFollow(FOLLOW_and_restr_connective_in_synpred53587);
        and_restr_connective(or);
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred6
    public final void synpred6_fragment() throws RecognitionException {   
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1329:5: ( DOUBLE_AMPER constraint_expression[and] )
        // /home/etirelli/workspace/jboss/jbossrules/drools-compiler/src/main/resources/org/drools/lang/DRL.g:1329:5: DOUBLE_AMPER constraint_expression[and]
        {
        match(input,DOUBLE_AMPER,FOLLOW_DOUBLE_AMPER_in_synpred63640); if (failed) return ;
        pushFollow(FOLLOW_constraint_expression_in_synpred63651);
        constraint_expression(and);
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred6

    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA68 dfa68 = new DFA68(this);
    static final String DFA12_eotS =
        "\6\uffff";
    static final String DFA12_eofS =
        "\6\uffff";
    static final String DFA12_minS =
        "\2\4\1\73\2\uffff\1\4";
    static final String DFA12_maxS =
        "\2\74\1\73\2\uffff\1\74";
    static final String DFA12_acceptS =
        "\3\uffff\1\2\1\1\1\uffff";
    static final String DFA12_specialS =
        "\6\uffff}>";
    static final String[] DFA12_transitionS = {
            "\5\1\1\uffff\1\1\3\uffff\5\1\3\uffff\1\1\1\uffff\1\1\6\uffff"+
            "\1\1\6\uffff\1\1\5\uffff\4\1\1\uffff\5\1\6\uffff\1\1",
            "\7\4\1\uffff\2\3\5\4\3\uffff\1\4\1\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\1\4\5\uffff\4\4\1\uffff\5\4\4\uffff\1\2\1\uffff\1\4",
            "\1\5",
            "",
            "",
            "\5\4\1\uffff\1\4\1\uffff\2\3\5\4\3\uffff\1\4\1\uffff\1\4\6\uffff"+
            "\1\4\6\uffff\1\4\5\uffff\4\4\1\uffff\5\4\4\uffff\1\2\1\uffff"+
            "\1\4"
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
            return "327:15: (paramType= dotted_name )?";
        }
    }
    static final String DFA13_eotS =
        "\6\uffff";
    static final String DFA13_eofS =
        "\6\uffff";
    static final String DFA13_minS =
        "\2\4\1\73\2\uffff\1\4";
    static final String DFA13_maxS =
        "\2\74\1\73\2\uffff\1\74";
    static final String DFA13_acceptS =
        "\3\uffff\1\2\1\1\1\uffff";
    static final String DFA13_specialS =
        "\6\uffff}>";
    static final String[] DFA13_transitionS = {
            "\5\1\1\uffff\1\1\3\uffff\5\1\3\uffff\1\1\1\uffff\1\1\6\uffff"+
            "\1\1\6\uffff\1\1\5\uffff\4\1\1\uffff\5\1\6\uffff\1\1",
            "\7\4\1\uffff\2\3\5\4\3\uffff\1\4\1\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\1\4\5\uffff\4\4\1\uffff\5\4\4\uffff\1\2\1\uffff\1\4",
            "\1\5",
            "",
            "",
            "\5\4\1\uffff\1\4\1\uffff\2\3\5\4\3\uffff\1\4\1\uffff\1\4\6\uffff"+
            "\1\4\6\uffff\1\4\5\uffff\4\4\1\uffff\5\4\4\uffff\1\2\1\uffff"+
            "\1\4"
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
            return "332:22: (paramType= dotted_name )?";
        }
    }
    static final String DFA21_eotS =
        "\11\uffff";
    static final String DFA21_eofS =
        "\11\uffff";
    static final String DFA21_minS =
        "\2\10\1\uffff\1\10\1\uffff\1\4\1\73\2\10";
    static final String DFA21_maxS =
        "\2\52\1\uffff\1\110\1\uffff\1\74\1\73\2\72";
    static final String DFA21_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA21_specialS =
        "\11\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\2\uffff\1\1\3\uffff\1\2\27\uffff\4\2",
            "\1\3\2\uffff\1\2\1\uffff\1\4\24\uffff\1\2\1\uffff\1\2\2\uffff"+
            "\4\2",
            "",
            "\1\4\1\5\1\uffff\1\2\2\4\54\uffff\1\6\15\uffff\1\2",
            "",
            "\5\7\1\uffff\1\7\3\uffff\5\7\3\uffff\1\7\1\uffff\1\7\6\uffff"+
            "\1\7\6\uffff\1\7\5\uffff\4\7\1\uffff\5\7\6\uffff\1\7",
            "\1\10",
            "\1\4\1\5\1\uffff\1\2\56\uffff\1\6",
            "\1\4\2\uffff\1\2\56\uffff\1\6"
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
            return "374:3: ( LEFT_PAREN ( ( (paramType= qualified_id )? paramName= ID ) ( COMMA (paramType= qualified_id )? paramName= ID )* )? RIGHT_PAREN )?";
        }
    }
    static final String DFA51_eotS =
        "\150\uffff";
    static final String DFA51_eofS =
        "\150\uffff";
    static final String DFA51_minS =
        "\1\10\1\uffff\1\4\1\uffff\3\4\1\0\1\uffff\4\4\1\uffff\5\4\2\0\5"+
        "\4\1\0\1\4\1\0\1\4\1\0\3\4\3\0\2\4\2\0\3\4\2\0\1\4\1\0\1\4\2\0\3"+
        "\4\2\0\3\4\1\0\2\4\1\0\2\4\1\0\1\4\1\uffff\44\0";
    static final String DFA51_maxS =
        "\1\107\1\uffff\1\120\1\uffff\3\120\1\0\1\uffff\4\120\1\uffff\5\120"+
        "\2\0\5\120\1\0\1\120\1\0\1\120\1\0\3\120\3\0\2\120\2\0\3\120\2\0"+
        "\1\120\1\0\1\120\2\0\3\120\2\0\3\120\1\0\2\120\1\0\2\120\1\0\1\120"+
        "\1\uffff\44\0";
    static final String DFA51_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\4\uffff\1\2\4\uffff\1\2\65\uffff\1\2\44"+
        "\uffff";
    static final String DFA51_specialS =
        "\1\41\1\uffff\1\14\1\uffff\1\62\1\71\1\42\1\75\1\uffff\1\45\1\40"+
        "\1\74\1\11\1\uffff\1\36\1\46\1\76\1\7\1\57\1\66\1\26\1\47\1\70\1"+
        "\54\1\25\1\63\1\15\1\73\1\37\1\72\1\51\1\56\1\16\1\50\1\31\1\1\1"+
        "\4\1\6\1\5\1\0\1\64\1\33\1\34\1\30\1\55\1\22\1\24\1\12\1\23\1\13"+
        "\1\10\1\43\1\3\1\44\1\67\1\17\1\60\1\20\1\52\1\2\1\61\1\21\1\32"+
        "\1\53\1\35\1\65\1\27\45\uffff}>";
    static final String[] DFA51_transitionS = {
            "\2\3\1\uffff\1\2\1\uffff\1\3\1\uffff\1\3\22\uffff\4\3\1\uffff"+
            "\4\3\17\uffff\1\1\1\uffff\1\3\12\uffff\1\3",
            "",
            "\4\15\1\13\2\15\1\7\1\15\1\10\24\15\1\5\1\15\1\4\2\15\1\6\1"+
            "\11\1\12\1\14\46\15",
            "",
            "\4\15\1\21\2\15\1\23\1\15\1\10\31\15\1\16\1\17\1\20\1\22\46"+
            "\15",
            "\4\15\1\30\2\15\1\24\1\15\1\10\31\15\1\25\1\26\1\27\1\31\46"+
            "\15",
            "\4\15\1\33\2\15\1\32\1\15\1\10\103\15",
            "\1\uffff",
            "",
            "\4\15\1\35\2\15\1\34\1\15\1\10\103\15",
            "\7\15\1\36\1\15\1\10\103\15",
            "\5\15\1\40\1\15\1\42\1\15\1\10\54\15\1\41\15\15\1\37\10\15",
            "\7\15\1\43\1\15\1\10\103\15",
            "",
            "\4\15\1\45\2\15\1\44\1\15\1\10\103\15",
            "\4\15\1\46\2\15\1\47\1\15\1\10\103\15",
            "\7\15\1\50\1\15\1\10\103\15",
            "\5\15\1\52\1\15\1\54\1\15\1\10\54\15\1\53\15\15\1\51\10\15",
            "\7\15\1\55\1\15\1\10\103\15",
            "\1\uffff",
            "\1\uffff",
            "\4\15\1\56\2\15\1\57\1\15\1\10\103\15",
            "\4\15\1\60\2\15\1\61\1\15\1\10\103\15",
            "\7\15\1\62\1\15\1\10\103\15",
            "\5\15\1\64\1\15\1\66\1\15\1\10\54\15\1\65\15\15\1\63\10\15",
            "\7\15\1\67\1\15\1\10\103\15",
            "\1\uffff",
            "\5\15\1\71\1\15\1\73\1\15\1\10\54\15\1\72\15\15\1\70\10\15",
            "\1\uffff",
            "\5\15\1\75\1\15\1\76\1\15\1\10\54\15\1\77\15\15\1\74\10\15",
            "\1\uffff",
            "\4\15\1\100\2\15\1\101\1\15\1\10\103\15",
            "\5\102\1\15\1\102\1\103\1\15\1\10\5\102\3\15\1\102\1\15\1\102"+
            "\6\15\1\102\6\15\1\102\5\15\4\102\1\15\5\102\6\15\1\102\24\15",
            "\7\15\1\103\1\15\1\10\55\15\1\104\25\15",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\5\15\1\106\1\15\1\110\1\15\1\10\54\15\1\107\15\15\1\105\10"+
            "\15",
            "\5\15\1\112\1\15\1\114\1\15\1\10\54\15\1\113\15\15\1\111\10"+
            "\15",
            "\1\uffff",
            "\1\uffff",
            "\4\15\1\115\2\15\1\116\1\15\1\10\103\15",
            "\5\117\1\15\1\117\1\103\1\15\1\10\5\117\3\15\1\117\1\15\1\117"+
            "\6\15\1\117\6\15\1\117\5\15\4\117\1\15\5\117\6\15\1\117\24\15",
            "\7\15\1\103\1\15\1\10\55\15\1\120\25\15",
            "\1\uffff",
            "\1\uffff",
            "\5\15\1\122\1\15\1\124\1\15\1\10\54\15\1\123\15\15\1\121\10"+
            "\15",
            "\1\uffff",
            "\5\15\1\126\1\15\1\127\1\15\1\10\54\15\1\130\15\15\1\125\10"+
            "\15",
            "\1\uffff",
            "\1\uffff",
            "\4\15\1\131\2\15\1\132\1\15\1\10\103\15",
            "\5\133\1\15\1\133\1\103\1\15\1\10\5\133\3\15\1\133\1\15\1\133"+
            "\6\15\1\133\6\15\1\133\5\15\4\133\1\15\5\133\6\15\1\133\24\15",
            "\7\15\1\103\1\15\1\10\55\15\1\134\25\15",
            "\1\uffff",
            "\1\uffff",
            "\4\15\1\135\2\15\1\136\1\15\1\10\103\15",
            "\5\137\1\15\1\137\1\103\1\15\1\10\5\137\3\15\1\137\1\15\1\137"+
            "\6\15\1\137\6\15\1\137\5\15\4\137\1\15\5\137\6\15\1\137\24\15",
            "\7\15\1\103\1\15\1\10\55\15\1\140\25\15",
            "\1\uffff",
            "\4\15\1\141\2\15\1\142\1\15\1\10\103\15",
            "\5\143\1\15\1\143\1\103\1\15\1\10\5\143\3\15\1\143\1\15\1\143"+
            "\6\15\1\143\6\15\1\143\5\15\4\143\1\15\5\143\6\15\1\143\24\15",
            "\1\uffff",
            "\7\15\1\103\1\15\1\10\55\15\1\144\25\15",
            "\5\15\1\145\1\15\1\147\1\15\1\10\54\15\1\146\26\15",
            "\1\uffff",
            "\5\15\1\40\1\15\1\42\1\15\1\10\54\15\1\41\26\15",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
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
            return "986:4: ( ( LEFT_SQUARE )=>sqarg= square_chunk | ( LEFT_PAREN )=>paarg= paren_chunk )?";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_39 = input.LA(1);

                         
                        int index51_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_39);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA51_35 = input.LA(1);

                         
                        int index51_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_35);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA51_59 = input.LA(1);

                         
                        int index51_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_59);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA51_52 = input.LA(1);

                         
                        int index51_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_52==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_52>=ATTRIBUTES && LA51_52<=ID)||LA51_52==GLOBAL||(LA51_52>=QUERY && LA51_52<=WHEN)||LA51_52==ENABLED||LA51_52==SALIENCE||LA51_52==DURATION||LA51_52==FROM||(LA51_52>=INIT && LA51_52<=RESULT)||(LA51_52>=CONTAINS && LA51_52<=IN)||LA51_52==THEN) ) {s = 91;}

                        else if ( (LA51_52==LEFT_PAREN) && (synpred2())) {s = 67;}

                        else if ( (LA51_52==DOT||LA51_52==COMMA||(LA51_52>=DATE_EFFECTIVE && LA51_52<=DATE_EXPIRES)||LA51_52==BOOL||(LA51_52>=INT && LA51_52<=AGENDA_GROUP)||(LA51_52>=DIALECT && LA51_52<=DOUBLE_AMPER)||(LA51_52>=EXISTS && LA51_52<=ACCUMULATE)||LA51_52==COLLECT||(LA51_52>=FLOAT && LA51_52<=RIGHT_SQUARE)||(LA51_52>=EOL && LA51_52<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_52);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA51_36 = input.LA(1);

                         
                        int index51_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_36);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA51_38 = input.LA(1);

                         
                        int index51_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_38==72) ) {s = 73;}

                        else if ( (LA51_38==DOT) ) {s = 74;}

                        else if ( (LA51_38==LEFT_SQUARE) ) {s = 75;}

                        else if ( (LA51_38==LEFT_PAREN) ) {s = 76;}

                        else if ( (LA51_38==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_38>=ATTRIBUTES && LA51_38<=ID)||LA51_38==GLOBAL||LA51_38==COMMA||(LA51_38>=QUERY && LA51_38<=RIGHT_CURLY)||(LA51_38>=RIGHT_SQUARE && LA51_38<=71)||(LA51_38>=73 && LA51_38<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_38);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA51_37 = input.LA(1);

                         
                        int index51_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_37==72) ) {s = 69;}

                        else if ( (LA51_37==DOT) ) {s = 70;}

                        else if ( (LA51_37==LEFT_SQUARE) ) {s = 71;}

                        else if ( (LA51_37==LEFT_PAREN) ) {s = 72;}

                        else if ( (LA51_37==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_37>=ATTRIBUTES && LA51_37<=ID)||LA51_37==GLOBAL||LA51_37==COMMA||(LA51_37>=QUERY && LA51_37<=RIGHT_CURLY)||(LA51_37>=RIGHT_SQUARE && LA51_37<=71)||(LA51_37>=73 && LA51_37<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_37);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA51_17 = input.LA(1);

                         
                        int index51_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_17==72) ) {s = 41;}

                        else if ( (LA51_17==DOT) ) {s = 42;}

                        else if ( (LA51_17==LEFT_SQUARE) ) {s = 43;}

                        else if ( (LA51_17==LEFT_PAREN) ) {s = 44;}

                        else if ( (LA51_17==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_17>=ATTRIBUTES && LA51_17<=ID)||LA51_17==GLOBAL||LA51_17==COMMA||(LA51_17>=QUERY && LA51_17<=RIGHT_CURLY)||(LA51_17>=RIGHT_SQUARE && LA51_17<=71)||(LA51_17>=73 && LA51_17<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_17);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA51_50 = input.LA(1);

                         
                        int index51_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA51_12 = input.LA(1);

                         
                        int index51_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_12==LEFT_PAREN) ) {s = 35;}

                        else if ( (LA51_12==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_12>=ATTRIBUTES && LA51_12<=GLOBAL)||LA51_12==COMMA||(LA51_12>=QUERY && LA51_12<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA51_47 = input.LA(1);

                         
                        int index51_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_47);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA51_49 = input.LA(1);

                         
                        int index51_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_49);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA51_2 = input.LA(1);

                         
                        int index51_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_2==AND) ) {s = 4;}

                        else if ( (LA51_2==OR) ) {s = 5;}

                        else if ( (LA51_2==EXISTS) ) {s = 6;}

                        else if ( (LA51_2==LEFT_PAREN) ) {s = 7;}

                        else if ( (LA51_2==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_2==NOT) ) {s = 9;}

                        else if ( (LA51_2==EVAL) ) {s = 10;}

                        else if ( (LA51_2==ID) ) {s = 11;}

                        else if ( (LA51_2==FORALL) ) {s = 12;}

                        else if ( ((LA51_2>=ATTRIBUTES && LA51_2<=FUNCTION)||(LA51_2>=DOT && LA51_2<=GLOBAL)||LA51_2==COMMA||(LA51_2>=QUERY && LA51_2<=LOCK_ON_ACTIVE)||LA51_2==DOUBLE_PIPE||(LA51_2>=DOUBLE_AMPER && LA51_2<=FROM)||(LA51_2>=ACCUMULATE && LA51_2<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_2);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA51_26 = input.LA(1);

                         
                        int index51_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 13;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_26);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA51_32 = input.LA(1);

                         
                        int index51_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA51_32>=ATTRIBUTES && LA51_32<=ID)||LA51_32==GLOBAL||(LA51_32>=QUERY && LA51_32<=WHEN)||LA51_32==ENABLED||LA51_32==SALIENCE||LA51_32==DURATION||LA51_32==FROM||(LA51_32>=INIT && LA51_32<=RESULT)||(LA51_32>=CONTAINS && LA51_32<=IN)||LA51_32==THEN) ) {s = 66;}

                        else if ( (LA51_32==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_32==DOT||LA51_32==COMMA||(LA51_32>=DATE_EFFECTIVE && LA51_32<=DATE_EXPIRES)||LA51_32==BOOL||(LA51_32>=INT && LA51_32<=AGENDA_GROUP)||(LA51_32>=DIALECT && LA51_32<=DOUBLE_AMPER)||(LA51_32>=EXISTS && LA51_32<=ACCUMULATE)||LA51_32==COLLECT||(LA51_32>=FLOAT && LA51_32<=RIGHT_SQUARE)||(LA51_32>=EOL && LA51_32<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_32==LEFT_PAREN) && (synpred2())) {s = 67;}

                         
                        input.seek(index51_32);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA51_55 = input.LA(1);

                         
                        int index51_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_55);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA51_57 = input.LA(1);

                         
                        int index51_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_57==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_57>=ATTRIBUTES && LA51_57<=ID)||LA51_57==GLOBAL||(LA51_57>=QUERY && LA51_57<=WHEN)||LA51_57==ENABLED||LA51_57==SALIENCE||LA51_57==DURATION||LA51_57==FROM||(LA51_57>=INIT && LA51_57<=RESULT)||(LA51_57>=CONTAINS && LA51_57<=IN)||LA51_57==THEN) ) {s = 95;}

                        else if ( (LA51_57==LEFT_PAREN) && (synpred2())) {s = 67;}

                        else if ( (LA51_57==DOT||LA51_57==COMMA||(LA51_57>=DATE_EFFECTIVE && LA51_57<=DATE_EXPIRES)||LA51_57==BOOL||(LA51_57>=INT && LA51_57<=AGENDA_GROUP)||(LA51_57>=DIALECT && LA51_57<=DOUBLE_AMPER)||(LA51_57>=EXISTS && LA51_57<=ACCUMULATE)||LA51_57==COLLECT||(LA51_57>=FLOAT && LA51_57<=RIGHT_SQUARE)||(LA51_57>=EOL && LA51_57<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_57);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA51_61 = input.LA(1);

                         
                        int index51_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_61==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_61>=ATTRIBUTES && LA51_61<=ID)||LA51_61==GLOBAL||(LA51_61>=QUERY && LA51_61<=WHEN)||LA51_61==ENABLED||LA51_61==SALIENCE||LA51_61==DURATION||LA51_61==FROM||(LA51_61>=INIT && LA51_61<=RESULT)||(LA51_61>=CONTAINS && LA51_61<=IN)||LA51_61==THEN) ) {s = 99;}

                        else if ( (LA51_61==LEFT_PAREN) && (synpred2())) {s = 67;}

                        else if ( (LA51_61==DOT||LA51_61==COMMA||(LA51_61>=DATE_EFFECTIVE && LA51_61<=DATE_EXPIRES)||LA51_61==BOOL||(LA51_61>=INT && LA51_61<=AGENDA_GROUP)||(LA51_61>=DIALECT && LA51_61<=DOUBLE_AMPER)||(LA51_61>=EXISTS && LA51_61<=ACCUMULATE)||LA51_61==COLLECT||(LA51_61>=FLOAT && LA51_61<=RIGHT_SQUARE)||(LA51_61>=EOL && LA51_61<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_61);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA51_45 = input.LA(1);

                         
                        int index51_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_45);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA51_48 = input.LA(1);

                         
                        int index51_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_48==72) ) {s = 85;}

                        else if ( (LA51_48==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_48==DOT) ) {s = 86;}

                        else if ( (LA51_48==LEFT_PAREN) ) {s = 87;}

                        else if ( (LA51_48==LEFT_SQUARE) ) {s = 88;}

                        else if ( ((LA51_48>=ATTRIBUTES && LA51_48<=ID)||LA51_48==GLOBAL||LA51_48==COMMA||(LA51_48>=QUERY && LA51_48<=RIGHT_CURLY)||(LA51_48>=RIGHT_SQUARE && LA51_48<=71)||(LA51_48>=73 && LA51_48<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_48);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA51_46 = input.LA(1);

                         
                        int index51_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_46==72) ) {s = 81;}

                        else if ( (LA51_46==DOT) ) {s = 82;}

                        else if ( (LA51_46==LEFT_SQUARE) ) {s = 83;}

                        else if ( (LA51_46==LEFT_PAREN) ) {s = 84;}

                        else if ( (LA51_46==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_46>=ATTRIBUTES && LA51_46<=ID)||LA51_46==GLOBAL||LA51_46==COMMA||(LA51_46>=QUERY && LA51_46<=RIGHT_CURLY)||(LA51_46>=RIGHT_SQUARE && LA51_46<=71)||(LA51_46>=73 && LA51_46<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_46);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA51_24 = input.LA(1);

                         
                        int index51_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_24==72) ) {s = 51;}

                        else if ( (LA51_24==DOT) ) {s = 52;}

                        else if ( (LA51_24==LEFT_SQUARE) ) {s = 53;}

                        else if ( (LA51_24==LEFT_PAREN) ) {s = 54;}

                        else if ( (LA51_24==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_24>=ATTRIBUTES && LA51_24<=ID)||LA51_24==GLOBAL||LA51_24==COMMA||(LA51_24>=QUERY && LA51_24<=RIGHT_CURLY)||(LA51_24>=RIGHT_SQUARE && LA51_24<=71)||(LA51_24>=73 && LA51_24<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_24);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA51_20 = input.LA(1);

                         
                        int index51_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 13;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_20);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA51_66 = input.LA(1);

                         
                        int index51_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_66==LEFT_SQUARE) ) {s = 33;}

                        else if ( (LA51_66==LEFT_PAREN) ) {s = 34;}

                        else if ( (LA51_66==DOT) ) {s = 32;}

                        else if ( (LA51_66==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_66>=ATTRIBUTES && LA51_66<=ID)||LA51_66==GLOBAL||LA51_66==COMMA||(LA51_66>=QUERY && LA51_66<=RIGHT_CURLY)||(LA51_66>=RIGHT_SQUARE && LA51_66<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_66);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA51_43 = input.LA(1);

                         
                        int index51_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_43==RIGHT_SQUARE) ) {s = 80;}

                        else if ( (LA51_43==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_43>=ATTRIBUTES && LA51_43<=GLOBAL)||LA51_43==COMMA||(LA51_43>=QUERY && LA51_43<=LEFT_SQUARE)||(LA51_43>=THEN && LA51_43<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_43==LEFT_PAREN) && (synpred2())) {s = 67;}

                         
                        input.seek(index51_43);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA51_34 = input.LA(1);

                         
                        int index51_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_34);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA51_62 = input.LA(1);

                         
                        int index51_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_62);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA51_41 = input.LA(1);

                         
                        int index51_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_41==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_41==ID) ) {s = 77;}

                        else if ( (LA51_41==LEFT_PAREN) ) {s = 78;}

                        else if ( ((LA51_41>=ATTRIBUTES && LA51_41<=FUNCTION)||(LA51_41>=DOT && LA51_41<=GLOBAL)||LA51_41==COMMA||(LA51_41>=QUERY && LA51_41<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_41);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA51_42 = input.LA(1);

                         
                        int index51_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_42==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_42>=ATTRIBUTES && LA51_42<=ID)||LA51_42==GLOBAL||(LA51_42>=QUERY && LA51_42<=WHEN)||LA51_42==ENABLED||LA51_42==SALIENCE||LA51_42==DURATION||LA51_42==FROM||(LA51_42>=INIT && LA51_42<=RESULT)||(LA51_42>=CONTAINS && LA51_42<=IN)||LA51_42==THEN) ) {s = 79;}

                        else if ( (LA51_42==LEFT_PAREN) && (synpred2())) {s = 67;}

                        else if ( (LA51_42==DOT||LA51_42==COMMA||(LA51_42>=DATE_EFFECTIVE && LA51_42<=DATE_EXPIRES)||LA51_42==BOOL||(LA51_42>=INT && LA51_42<=AGENDA_GROUP)||(LA51_42>=DIALECT && LA51_42<=DOUBLE_AMPER)||(LA51_42>=EXISTS && LA51_42<=ACCUMULATE)||LA51_42==COLLECT||(LA51_42>=FLOAT && LA51_42<=RIGHT_SQUARE)||(LA51_42>=EOL && LA51_42<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_42);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA51_64 = input.LA(1);

                         
                        int index51_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_64==DOT) ) {s = 101;}

                        else if ( (LA51_64==LEFT_SQUARE) ) {s = 102;}

                        else if ( (LA51_64==LEFT_PAREN) ) {s = 103;}

                        else if ( (LA51_64==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_64>=ATTRIBUTES && LA51_64<=ID)||LA51_64==GLOBAL||LA51_64==COMMA||(LA51_64>=QUERY && LA51_64<=RIGHT_CURLY)||(LA51_64>=RIGHT_SQUARE && LA51_64<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_64);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA51_14 = input.LA(1);

                         
                        int index51_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_14==LEFT_PAREN) ) {s = 36;}

                        else if ( (LA51_14==ID) ) {s = 37;}

                        else if ( (LA51_14==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_14>=ATTRIBUTES && LA51_14<=FUNCTION)||(LA51_14>=DOT && LA51_14<=GLOBAL)||LA51_14==COMMA||(LA51_14>=QUERY && LA51_14<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_14);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA51_28 = input.LA(1);

                         
                        int index51_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 13;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_28);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA51_10 = input.LA(1);

                         
                        int index51_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_10==LEFT_PAREN) ) {s = 30;}

                        else if ( (LA51_10==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_10>=ATTRIBUTES && LA51_10<=GLOBAL)||LA51_10==COMMA||(LA51_10>=QUERY && LA51_10<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_10);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA51_0 = input.LA(1);

                         
                        int index51_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_0==LEFT_SQUARE) && (synpred1())) {s = 1;}

                        else if ( (LA51_0==LEFT_PAREN) ) {s = 2;}

                        else if ( ((LA51_0>=ID && LA51_0<=DOT)||LA51_0==RIGHT_PAREN||LA51_0==END||(LA51_0>=OR && LA51_0<=DOUBLE_AMPER)||(LA51_0>=EXISTS && LA51_0<=FORALL)||LA51_0==THEN||LA51_0==71) ) {s = 3;}

                         
                        input.seek(index51_0);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA51_6 = input.LA(1);

                         
                        int index51_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_6==LEFT_PAREN) ) {s = 26;}

                        else if ( (LA51_6==ID) ) {s = 27;}

                        else if ( (LA51_6==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_6>=ATTRIBUTES && LA51_6<=FUNCTION)||(LA51_6>=DOT && LA51_6<=GLOBAL)||LA51_6==COMMA||(LA51_6>=QUERY && LA51_6<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_6);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA51_51 = input.LA(1);

                         
                        int index51_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_51==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_51==ID) ) {s = 89;}

                        else if ( (LA51_51==LEFT_PAREN) ) {s = 90;}

                        else if ( ((LA51_51>=ATTRIBUTES && LA51_51<=FUNCTION)||(LA51_51>=DOT && LA51_51<=GLOBAL)||LA51_51==COMMA||(LA51_51>=QUERY && LA51_51<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_51);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA51_53 = input.LA(1);

                         
                        int index51_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_53==RIGHT_SQUARE) ) {s = 92;}

                        else if ( (LA51_53==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_53>=ATTRIBUTES && LA51_53<=GLOBAL)||LA51_53==COMMA||(LA51_53>=QUERY && LA51_53<=LEFT_SQUARE)||(LA51_53>=THEN && LA51_53<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_53==LEFT_PAREN) && (synpred2())) {s = 67;}

                         
                        input.seek(index51_53);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA51_9 = input.LA(1);

                         
                        int index51_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_9==LEFT_PAREN) ) {s = 28;}

                        else if ( (LA51_9==ID) ) {s = 29;}

                        else if ( (LA51_9==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_9>=ATTRIBUTES && LA51_9<=FUNCTION)||(LA51_9>=DOT && LA51_9<=GLOBAL)||LA51_9==COMMA||(LA51_9>=QUERY && LA51_9<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_9);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA51_15 = input.LA(1);

                         
                        int index51_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_15==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_15==ID) ) {s = 38;}

                        else if ( (LA51_15==LEFT_PAREN) ) {s = 39;}

                        else if ( ((LA51_15>=ATTRIBUTES && LA51_15<=FUNCTION)||(LA51_15>=DOT && LA51_15<=GLOBAL)||LA51_15==COMMA||(LA51_15>=QUERY && LA51_15<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_15);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA51_21 = input.LA(1);

                         
                        int index51_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_21==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_21==ID) ) {s = 46;}

                        else if ( (LA51_21==LEFT_PAREN) ) {s = 47;}

                        else if ( ((LA51_21>=ATTRIBUTES && LA51_21<=FUNCTION)||(LA51_21>=DOT && LA51_21<=GLOBAL)||LA51_21==COMMA||(LA51_21>=QUERY && LA51_21<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_21);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA51_33 = input.LA(1);

                         
                        int index51_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_33==RIGHT_SQUARE) ) {s = 68;}

                        else if ( (LA51_33==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_33>=ATTRIBUTES && LA51_33<=GLOBAL)||LA51_33==COMMA||(LA51_33>=QUERY && LA51_33<=LEFT_SQUARE)||(LA51_33>=THEN && LA51_33<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_33==LEFT_PAREN) && (synpred2())) {s = 67;}

                         
                        input.seek(index51_33);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA51_30 = input.LA(1);

                         
                        int index51_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 13;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_30);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA51_58 = input.LA(1);

                         
                        int index51_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_58==RIGHT_SQUARE) ) {s = 96;}

                        else if ( (LA51_58==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_58>=ATTRIBUTES && LA51_58<=GLOBAL)||LA51_58==COMMA||(LA51_58>=QUERY && LA51_58<=LEFT_SQUARE)||(LA51_58>=THEN && LA51_58<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_58==LEFT_PAREN) && (synpred2())) {s = 67;}

                         
                        input.seek(index51_58);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA51_63 = input.LA(1);

                         
                        int index51_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_63==RIGHT_SQUARE) ) {s = 100;}

                        else if ( (LA51_63==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_63>=ATTRIBUTES && LA51_63<=GLOBAL)||LA51_63==COMMA||(LA51_63>=QUERY && LA51_63<=LEFT_SQUARE)||(LA51_63>=THEN && LA51_63<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_63==LEFT_PAREN) && (synpred2())) {s = 67;}

                         
                        input.seek(index51_63);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA51_23 = input.LA(1);

                         
                        int index51_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_23==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_23>=ATTRIBUTES && LA51_23<=GLOBAL)||LA51_23==COMMA||(LA51_23>=QUERY && LA51_23<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_23==LEFT_PAREN) ) {s = 50;}

                         
                        input.seek(index51_23);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA51_44 = input.LA(1);

                         
                        int index51_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_44);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA51_31 = input.LA(1);

                         
                        int index51_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_31==ID) ) {s = 64;}

                        else if ( (LA51_31==LEFT_PAREN) ) {s = 65;}

                        else if ( (LA51_31==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_31>=ATTRIBUTES && LA51_31<=FUNCTION)||(LA51_31>=DOT && LA51_31<=GLOBAL)||LA51_31==COMMA||(LA51_31>=QUERY && LA51_31<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_31);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA51_18 = input.LA(1);

                         
                        int index51_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_18==LEFT_PAREN) ) {s = 45;}

                        else if ( (LA51_18==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_18>=ATTRIBUTES && LA51_18<=GLOBAL)||LA51_18==COMMA||(LA51_18>=QUERY && LA51_18<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_18);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA51_56 = input.LA(1);

                         
                        int index51_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_56==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_56==ID) ) {s = 93;}

                        else if ( (LA51_56==LEFT_PAREN) ) {s = 94;}

                        else if ( ((LA51_56>=ATTRIBUTES && LA51_56<=FUNCTION)||(LA51_56>=DOT && LA51_56<=GLOBAL)||LA51_56==COMMA||(LA51_56>=QUERY && LA51_56<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_56);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA51_60 = input.LA(1);

                         
                        int index51_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_60==ID) ) {s = 97;}

                        else if ( (LA51_60==LEFT_PAREN) ) {s = 98;}

                        else if ( (LA51_60==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_60>=ATTRIBUTES && LA51_60<=FUNCTION)||(LA51_60>=DOT && LA51_60<=GLOBAL)||LA51_60==COMMA||(LA51_60>=QUERY && LA51_60<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_60);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA51_4 = input.LA(1);

                         
                        int index51_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_4==EXISTS) ) {s = 14;}

                        else if ( (LA51_4==NOT) ) {s = 15;}

                        else if ( (LA51_4==EVAL) ) {s = 16;}

                        else if ( (LA51_4==ID) ) {s = 17;}

                        else if ( (LA51_4==FORALL) ) {s = 18;}

                        else if ( (LA51_4==LEFT_PAREN) ) {s = 19;}

                        else if ( (LA51_4==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_4>=ATTRIBUTES && LA51_4<=FUNCTION)||(LA51_4>=DOT && LA51_4<=GLOBAL)||LA51_4==COMMA||(LA51_4>=QUERY && LA51_4<=FROM)||(LA51_4>=ACCUMULATE && LA51_4<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_4);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA51_25 = input.LA(1);

                         
                        int index51_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_25==LEFT_PAREN) ) {s = 55;}

                        else if ( (LA51_25==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_25>=ATTRIBUTES && LA51_25<=GLOBAL)||LA51_25==COMMA||(LA51_25>=QUERY && LA51_25<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_25);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA51_40 = input.LA(1);

                         
                        int index51_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_40);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA51_65 = input.LA(1);

                         
                        int index51_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_65);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA51_19 = input.LA(1);

                         
                        int index51_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 13;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_19);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA51_54 = input.LA(1);

                         
                        int index51_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 67;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_54);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA51_22 = input.LA(1);

                         
                        int index51_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_22==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_22==ID) ) {s = 48;}

                        else if ( (LA51_22==LEFT_PAREN) ) {s = 49;}

                        else if ( ((LA51_22>=ATTRIBUTES && LA51_22<=FUNCTION)||(LA51_22>=DOT && LA51_22<=GLOBAL)||LA51_22==COMMA||(LA51_22>=QUERY && LA51_22<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_22);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA51_5 = input.LA(1);

                         
                        int index51_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_5==LEFT_PAREN) ) {s = 20;}

                        else if ( (LA51_5==EXISTS) ) {s = 21;}

                        else if ( (LA51_5==NOT) ) {s = 22;}

                        else if ( (LA51_5==EVAL) ) {s = 23;}

                        else if ( (LA51_5==ID) ) {s = 24;}

                        else if ( (LA51_5==FORALL) ) {s = 25;}

                        else if ( (LA51_5==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_5>=ATTRIBUTES && LA51_5<=FUNCTION)||(LA51_5>=DOT && LA51_5<=GLOBAL)||LA51_5==COMMA||(LA51_5>=QUERY && LA51_5<=FROM)||(LA51_5>=ACCUMULATE && LA51_5<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_5);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA51_29 = input.LA(1);

                         
                        int index51_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_29==72) ) {s = 60;}

                        else if ( (LA51_29==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( (LA51_29==DOT) ) {s = 61;}

                        else if ( (LA51_29==LEFT_PAREN) ) {s = 62;}

                        else if ( (LA51_29==LEFT_SQUARE) ) {s = 63;}

                        else if ( ((LA51_29>=ATTRIBUTES && LA51_29<=ID)||LA51_29==GLOBAL||LA51_29==COMMA||(LA51_29>=QUERY && LA51_29<=RIGHT_CURLY)||(LA51_29>=RIGHT_SQUARE && LA51_29<=71)||(LA51_29>=73 && LA51_29<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_29);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA51_27 = input.LA(1);

                         
                        int index51_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_27==72) ) {s = 56;}

                        else if ( (LA51_27==DOT) ) {s = 57;}

                        else if ( (LA51_27==LEFT_SQUARE) ) {s = 58;}

                        else if ( (LA51_27==LEFT_PAREN) ) {s = 59;}

                        else if ( (LA51_27==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_27>=ATTRIBUTES && LA51_27<=ID)||LA51_27==GLOBAL||LA51_27==COMMA||(LA51_27>=QUERY && LA51_27<=RIGHT_CURLY)||(LA51_27>=RIGHT_SQUARE && LA51_27<=71)||(LA51_27>=73 && LA51_27<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_27);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA51_11 = input.LA(1);

                         
                        int index51_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_11==72) ) {s = 31;}

                        else if ( (LA51_11==DOT) ) {s = 32;}

                        else if ( (LA51_11==LEFT_SQUARE) ) {s = 33;}

                        else if ( (LA51_11==LEFT_PAREN) ) {s = 34;}

                        else if ( (LA51_11==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_11>=ATTRIBUTES && LA51_11<=ID)||LA51_11==GLOBAL||LA51_11==COMMA||(LA51_11>=QUERY && LA51_11<=RIGHT_CURLY)||(LA51_11>=RIGHT_SQUARE && LA51_11<=71)||(LA51_11>=73 && LA51_11<=80)) && (synpred2())) {s = 13;}

                         
                        input.seek(index51_11);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA51_7 = input.LA(1);

                         
                        int index51_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2()) ) {s = 13;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index51_7);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA51_16 = input.LA(1);

                         
                        int index51_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_16==RIGHT_PAREN) && (synpred2())) {s = 8;}

                        else if ( ((LA51_16>=ATTRIBUTES && LA51_16<=GLOBAL)||LA51_16==COMMA||(LA51_16>=QUERY && LA51_16<=80)) && (synpred2())) {s = 13;}

                        else if ( (LA51_16==LEFT_PAREN) ) {s = 40;}

                         
                        input.seek(index51_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (backtracking>0) {failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\21\uffff";
    static final String DFA67_eofS =
        "\1\1\20\uffff";
    static final String DFA67_minS =
        "\1\14\1\uffff\1\4\1\11\1\0\1\4\1\uffff\1\4\11\0";
    static final String DFA67_maxS =
        "\1\45\1\uffff\2\120\1\0\1\120\1\uffff\1\120\11\0";
    static final String DFA67_acceptS =
        "\1\uffff\1\2\4\uffff\1\1\12\uffff";
    static final String DFA67_specialS =
        "\4\uffff\1\0\14\uffff}>";
    static final String[] DFA67_transitionS = {
            "\2\1\25\uffff\1\2\1\uffff\1\1",
            "",
            "\5\1\1\uffff\1\1\1\4\2\uffff\5\1\3\uffff\1\1\1\uffff\1\1\6\uffff"+
            "\1\1\6\uffff\1\1\1\uffff\1\6\1\1\2\uffff\4\1\1\uffff\1\5\1\7"+
            "\1\10\1\11\1\3\6\uffff\1\1\16\uffff\6\6",
            "\1\1\1\uffff\1\12\2\1\25\uffff\1\1\1\uffff\1\1\2\uffff\1\1\10"+
            "\uffff\5\1\4\uffff\1\1\17\uffff\7\1",
            "\1\uffff",
            "\5\6\1\1\1\6\1\20\2\1\5\6\1\uffff\1\6\1\uffff\4\6\5\uffff\1"+
            "\6\3\uffff\1\1\1\uffff\1\1\1\6\1\uffff\1\1\3\uffff\4\6\1\uffff"+
            "\1\14\1\15\1\16\1\17\1\13\2\6\2\uffff\1\1\1\uffff\1\6\15\uffff"+
            "\7\1",
            "",
            "\5\6\1\1\1\6\1\20\2\1\5\6\1\uffff\1\6\1\uffff\4\6\5\uffff\1"+
            "\6\3\uffff\1\1\1\uffff\1\1\1\6\1\uffff\1\1\3\uffff\4\6\1\uffff"+
            "\1\14\1\15\1\16\1\17\1\13\2\6\2\uffff\1\1\1\uffff\1\6\15\uffff"+
            "\7\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
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
            return "()* loopback of 1306:3: ( options {backtrack=true; } : DOUBLE_PIPE and_restr_connective[or] )*";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5()) ) {s = 6;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (backtracking>0) {failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\61\uffff";
    static final String DFA68_eofS =
        "\1\1\12\uffff\5\4\41\uffff";
    static final String DFA68_minS =
        "\1\14\1\uffff\1\4\1\11\1\uffff\6\4\1\11\5\4\1\11\1\0\2\4\34\0";
    static final String DFA68_maxS =
        "\1\45\1\uffff\2\120\1\uffff\6\120\1\72\4\74\2\120\1\0\2\120\34\0";
    static final String DFA68_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\54\uffff";
    static final String DFA68_specialS =
        "\22\uffff\1\0\36\uffff}>";
    static final String[] DFA68_transitionS = {
            "\2\1\25\uffff\1\1\1\uffff\1\2",
            "",
            "\5\1\1\uffff\1\1\1\11\2\uffff\5\1\3\uffff\1\1\1\uffff\1\1\6"+
            "\uffff\1\1\6\uffff\1\1\1\uffff\1\4\1\1\2\uffff\4\1\1\uffff\1"+
            "\5\1\6\1\7\1\10\1\3\6\uffff\1\1\16\uffff\6\4",
            "\1\1\1\uffff\1\12\2\1\25\uffff\1\1\1\uffff\1\1\2\uffff\1\1\10"+
            "\uffff\5\1\4\uffff\1\1\17\uffff\7\1",
            "",
            "\5\4\1\1\1\4\1\20\2\1\5\4\1\uffff\1\4\1\uffff\4\4\5\uffff\1"+
            "\4\3\uffff\1\1\1\uffff\1\1\1\4\1\uffff\1\1\3\uffff\4\4\1\uffff"+
            "\1\14\1\15\1\16\1\17\1\13\2\4\2\uffff\1\1\1\uffff\1\4\15\uffff"+
            "\7\1",
            "\5\4\1\1\1\4\1\20\2\1\5\4\1\uffff\1\4\1\uffff\4\4\5\uffff\1"+
            "\4\3\uffff\1\1\1\uffff\1\1\1\4\1\uffff\1\1\3\uffff\4\4\1\uffff"+
            "\1\14\1\15\1\16\1\17\1\13\2\4\2\uffff\1\1\1\uffff\1\4\15\uffff"+
            "\7\1",
            "\5\4\1\1\1\4\1\20\2\1\5\4\1\uffff\1\4\1\uffff\4\4\5\uffff\1"+
            "\4\3\uffff\1\1\1\uffff\1\1\1\4\1\uffff\1\1\3\uffff\4\4\1\uffff"+
            "\1\14\1\15\1\16\1\17\1\13\2\4\2\uffff\1\1\1\uffff\1\4\15\uffff"+
            "\7\1",
            "\5\4\1\1\1\4\1\20\2\1\5\4\1\uffff\1\4\1\uffff\4\4\5\uffff\1"+
            "\4\3\uffff\1\1\1\uffff\1\1\1\4\1\uffff\1\1\3\uffff\4\4\1\uffff"+
            "\1\14\1\15\1\16\1\17\1\13\2\4\2\uffff\1\1\1\uffff\1\4\15\uffff"+
            "\7\1",
            "\5\1\1\uffff\1\1\1\22\2\uffff\5\1\3\uffff\1\1\1\uffff\1\1\6"+
            "\uffff\1\1\6\uffff\1\1\1\uffff\1\4\1\1\2\uffff\4\1\1\uffff\1"+
            "\23\1\24\1\25\1\26\1\21\6\uffff\1\1\16\uffff\6\4",
            "\5\4\1\uffff\1\4\1\30\2\uffff\5\4\1\uffff\1\4\1\uffff\4\4\5"+
            "\uffff\1\4\6\uffff\1\4\1\uffff\1\1\3\uffff\4\4\1\uffff\1\31"+
            "\1\32\1\33\1\34\1\27\2\4\4\uffff\1\4\16\uffff\6\1",
            "\1\4\1\uffff\1\1\2\4\25\uffff\1\4\1\uffff\1\4\24\uffff\1\4",
            "\5\1\1\4\2\1\2\4\5\1\1\uffff\1\1\1\uffff\4\1\5\uffff\1\1\3\uffff"+
            "\1\4\1\uffff\1\4\1\1\5\uffff\4\1\1\uffff\7\1\2\uffff\1\4\1\uffff"+
            "\1\1",
            "\5\1\1\4\2\1\2\4\5\1\1\uffff\1\1\1\uffff\4\1\5\uffff\1\1\3\uffff"+
            "\1\4\1\uffff\1\4\1\1\5\uffff\4\1\1\uffff\7\1\2\uffff\1\4\1\uffff"+
            "\1\1",
            "\5\1\1\4\2\1\2\4\5\1\1\uffff\1\1\1\uffff\4\1\5\uffff\1\1\3\uffff"+
            "\1\4\1\uffff\1\4\1\1\5\uffff\4\1\1\uffff\7\1\2\uffff\1\4\1\uffff"+
            "\1\1",
            "\5\1\1\4\2\1\2\4\5\1\1\uffff\1\1\1\uffff\4\1\5\uffff\1\1\3\uffff"+
            "\1\4\1\uffff\1\4\1\1\5\uffff\4\1\1\uffff\7\1\2\uffff\1\4\1\uffff"+
            "\1\1",
            "\7\4\1\51\34\4\1\36\10\4\1\45\1\46\1\47\1\50\1\35\25\4\1\37"+
            "\1\40\1\41\1\42\1\43\1\44",
            "\1\1\1\uffff\1\52\1\uffff\1\1\25\uffff\1\1\1\uffff\1\1\2\uffff"+
            "\1\1\10\uffff\5\1\4\uffff\1\1\17\uffff\7\1",
            "\1\uffff",
            "\5\4\1\1\1\4\1\54\1\uffff\1\1\5\4\1\uffff\1\4\1\uffff\4\4\5"+
            "\uffff\1\4\3\uffff\1\1\1\uffff\1\1\1\4\1\uffff\1\1\3\uffff\4"+
            "\4\1\uffff\1\55\1\56\1\57\1\60\1\53\2\4\2\uffff\1\1\1\uffff"+
            "\1\4\15\uffff\7\1",
            "\5\4\1\1\1\4\1\54\1\uffff\1\1\5\4\1\uffff\1\4\1\uffff\4\4\5"+
            "\uffff\1\4\3\uffff\1\1\1\uffff\1\1\1\4\1\uffff\1\1\3\uffff\4"+
            "\4\1\uffff\1\55\1\56\1\57\1\60\1\53\2\4\2\uffff\1\1\1\uffff"+
            "\1\4\15\uffff\7\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "()* loopback of 1328:3: ( options {backtrack=true; } : t= DOUBLE_AMPER constraint_expression[and] )*";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_18 = input.LA(1);

                         
                        int index68_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6()) ) {s = 4;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index68_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (backtracking>0) {failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_71_in_opt_semicolon39 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prolog_in_compilation_unit57 = new BitSet(new long[]{0x00000000000344C0L});
    public static final BitSet FOLLOW_statement_in_compilation_unit62 = new BitSet(new long[]{0x00000000000344C2L});
    public static final BitSet FOLLOW_package_statement_in_prolog85 = new BitSet(new long[]{0x00000003FD680012L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_prolog99 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_prolog101 = new BitSet(new long[]{0x00000003FD680002L});
    public static final BitSet FOLLOW_rule_attribute_in_prolog111 = new BitSet(new long[]{0x00000003FD681002L});
    public static final BitSet FOLLOW_COMMA_in_prolog134 = new BitSet(new long[]{0x00000003FD680000L});
    public static final BitSet FOLLOW_rule_attribute_in_prolog139 = new BitSet(new long[]{0x00000003FD681002L});
    public static final BitSet FOLLOW_PACKAGE_in_package_statement183 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_dotted_name_in_package_statement187 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_package_statement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_import_statement_in_statement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_statement_in_statement209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_in_statement215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_statement221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_template_in_statement235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_statement244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_statement256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_import_statement285 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_import_name_in_import_statement308 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_import_statement311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_function_import_statement335 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FUNCTION_in_function_import_statement337 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_import_name_in_function_import_statement360 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_function_import_statement363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_import_name389 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000200L});
    public static final BitSet FOLLOW_DOT_in_import_name401 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_import_name405 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_import_name429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_in_global463 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_dotted_name_in_global474 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_global485 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_global487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function512 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_dotted_name_in_function516 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_function521 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_function530 = new BitSet(new long[]{0x103EF0408147E5F0L});
    public static final BitSet FOLLOW_dotted_name_in_function539 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_argument_in_function544 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_COMMA_in_function558 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_dotted_name_in_function562 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_argument_in_function567 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_function591 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_curly_chunk_in_function597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_argument624 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_argument630 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_argument632 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_QUERY_in_query662 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_name_in_query666 = new BitSet(new long[]{0x0000078000008900L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_query676 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_qualified_id_in_query711 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_query716 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_COMMA_in_query737 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_qualified_id_in_query741 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_query746 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_query796 = new BitSet(new long[]{0x0000078000008900L});
    public static final BitSet FOLLOW_normal_lhs_block_in_query825 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_query830 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_query832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEMPLATE_in_template860 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_name_in_template864 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_template866 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_template_slot_in_template881 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_END_in_template896 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_template898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualified_id_in_template_slot944 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_template_slot960 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_template_slot962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_rule993 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_name_in_rule997 = new BitSet(new long[]{0x10000003FD6C0010L});
    public static final BitSet FOLLOW_rule_attributes_in_rule1006 = new BitSet(new long[]{0x1000000000040000L});
    public static final BitSet FOLLOW_WHEN_in_rule1018 = new BitSet(new long[]{0x1000078000000900L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rule1020 = new BitSet(new long[]{0x1000078000000900L});
    public static final BitSet FOLLOW_normal_lhs_block_in_rule1031 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_rhs_chunk_in_rule1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_rule_attributes1061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rule_attributes1063 = new BitSet(new long[]{0x00000003FD680000L});
    public static final BitSet FOLLOW_rule_attribute_in_rule_attributes1071 = new BitSet(new long[]{0x00000003FD681002L});
    public static final BitSet FOLLOW_COMMA_in_rule_attributes1078 = new BitSet(new long[]{0x00000003FD680000L});
    public static final BitSet FOLLOW_rule_attribute_in_rule_attributes1083 = new BitSet(new long[]{0x00000003FD681002L});
    public static final BitSet FOLLOW_salience_in_rule_attribute1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_loop_in_rule_attribute1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_agenda_group_in_rule_attribute1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_duration_in_rule_attribute1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_activation_group_in_rule_attribute1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_auto_focus_in_rule_attribute1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_effective_in_rule_attribute1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_date_expires_in_rule_attribute1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enabled_in_rule_attribute1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleflow_group_in_rule_attribute1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lock_on_active_in_rule_attribute1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dialect_in_rule_attribute1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_EFFECTIVE_in_date_effective1236 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_date_effective1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_EXPIRES_in_date_expires1267 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_date_expires1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENABLED_in_enabled1298 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_BOOL_in_enabled1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SALIENCE_in_salience1333 = new BitSet(new long[]{0x0000000002000800L});
    public static final BitSet FOLLOW_INT_in_salience1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paren_chunk_in_salience1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NO_LOOP_in_no_loop1389 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BOOL_in_no_loop1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AUTO_FOCUS_in_auto_focus1437 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BOOL_in_auto_focus1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTIVATION_GROUP_in_activation_group1486 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_activation_group1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULEFLOW_GROUP_in_ruleflow_group1516 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_ruleflow_group1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AGENDA_GROUP_in_agenda_group1546 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_agenda_group1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DURATION_in_duration1576 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INT_in_duration1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIALECT_in_dialect1606 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_dialect1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOCK_ON_ACTIVE_in_lock_on_active1640 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_BOOL_in_lock_on_active1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_normal_lhs_block1692 = new BitSet(new long[]{0x0000078000000902L});
    public static final BitSet FOLLOW_lhs_or_in_lhs1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_lhs_or1754 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_OR_in_lhs_or1756 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or1767 = new BitSet(new long[]{0x0000078000002900L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_lhs_or1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or1795 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_set_in_lhs_or1803 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or1819 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_lhs_and1850 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_AND_in_lhs_and1852 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and1863 = new BitSet(new long[]{0x0000078000002900L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_lhs_and1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and1891 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_set_in_lhs_and1899 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and1915 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_lhs_exist_in_lhs_unary1952 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_lhs_not_in_lhs_unary1962 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_lhs_eval_in_lhs_unary1972 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs_unary1982 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_FROM_in_lhs_unary2000 = new BitSet(new long[]{0x103FF8408147C5F0L});
    public static final BitSet FOLLOW_accumulate_statement_in_lhs_unary2060 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_collect_statement_in_lhs_unary2083 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_from_statement_in_lhs_unary2107 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_lhs_forall_in_lhs_unary2146 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_lhs_unary2155 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_or_in_lhs_unary2159 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_lhs_unary2161 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_lhs_unary2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXISTS_in_lhs_exist2194 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_lhs_exist2214 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_or_in_lhs_exist2218 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_lhs_exist2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs_exist2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_lhs_not2350 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_lhs_not2363 = new BitSet(new long[]{0x0000078000000900L});
    public static final BitSet FOLLOW_lhs_or_in_lhs_not2367 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_lhs_not2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs_not2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_lhs_eval2481 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_paren_chunk_in_lhs_eval2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORALL_in_lhs_forall2518 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_lhs_forall2520 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs_forall2524 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_COMMA_in_lhs_forall2537 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_lhs_pattern_in_lhs_forall2542 = new BitSet(new long[]{0x0000000000003100L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_lhs_forall2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_binding_in_lhs_pattern2588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_lhs_pattern2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_from_source_in_from_statement2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_from_source2652 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_paren_chunk_in_from_source2680 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_expression_chain_in_from_source2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_expression_chain2724 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_expression_chain2728 = new BitSet(new long[]{0x0400000000000A02L});
    public static final BitSet FOLLOW_square_chunk_in_expression_chain2759 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_paren_chunk_in_expression_chain2792 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_expression_chain_in_expression_chain2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACCUMULATE_in_accumulate_statement2851 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_accumulate_statement2861 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_lhs_pattern_in_accumulate_statement2865 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_COMMA_in_accumulate_statement2867 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_INIT_in_accumulate_statement2877 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_paren_chunk_in_accumulate_statement2888 = new BitSet(new long[]{0x0000200000001000L});
    public static final BitSet FOLLOW_COMMA_in_accumulate_statement2890 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_accumulate_statement2899 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_paren_chunk_in_accumulate_statement2903 = new BitSet(new long[]{0x0000C00000001000L});
    public static final BitSet FOLLOW_COMMA_in_accumulate_statement2905 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_REVERSE_in_accumulate_statement2916 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_paren_chunk_in_accumulate_statement2920 = new BitSet(new long[]{0x0000800000001000L});
    public static final BitSet FOLLOW_COMMA_in_accumulate_statement2922 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RESULT_in_accumulate_statement2936 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_paren_chunk_in_accumulate_statement2940 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_accumulate_statement2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLLECT_in_collect_statement2990 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_collect_statement3000 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_lhs_pattern_in_collect_statement3004 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_collect_statement3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_fact_binding3038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_fact_binding3040 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_fact_in_fact_binding3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_fact_binding3070 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_fact_in_fact_binding3074 = new BitSet(new long[]{0x0000000C00002000L});
    public static final BitSet FOLLOW_set_in_fact_binding3087 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_fact_in_fact_binding3099 = new BitSet(new long[]{0x0000000C00002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_fact_binding3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualified_id_in_fact3172 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_fact3182 = new BitSet(new long[]{0x103EF2408147EDF0L});
    public static final BitSet FOLLOW_constraints_in_fact3196 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_fact3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constraint_in_constraints3227 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_COMMA_in_constraints3234 = new BitSet(new long[]{0x103EF2408147CDF0L});
    public static final BitSet FOLLOW_constraint_in_constraints3243 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_or_constr_in_constraint3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_constr_in_or_constr3316 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_DOUBLE_PIPE_in_or_constr3324 = new BitSet(new long[]{0x103EF2408147CDF0L});
    public static final BitSet FOLLOW_and_constr_in_or_constr3333 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_unary_constr_in_and_constr3365 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_DOUBLE_AMPER_in_and_constr3373 = new BitSet(new long[]{0x103EF2408147CDF0L});
    public static final BitSet FOLLOW_unary_constr_in_and_constr3382 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_field_constraint_in_unary_constr3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_unary_constr3418 = new BitSet(new long[]{0x103EF2408147CDF0L});
    public static final BitSet FOLLOW_or_constr_in_unary_constr3420 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_unary_constr3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_unary_constr3429 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_predicate_in_unary_constr3431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_field_constraint3461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_field_constraint3463 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_accessor_path_in_field_constraint3484 = new BitSet(new long[]{0x003E010000000802L,0x000000000001FC00L});
    public static final BitSet FOLLOW_or_restr_connective_in_field_constraint3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_field_constraint3525 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_predicate_in_field_constraint3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_restr_connective_in_or_restr_connective3556 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_DOUBLE_PIPE_in_or_restr_connective3575 = new BitSet(new long[]{0x003E010000000800L,0x000000000001F800L});
    public static final BitSet FOLLOW_and_restr_connective_in_or_restr_connective3587 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_constraint_expression_in_and_restr_connective3619 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_DOUBLE_AMPER_in_and_restr_connective3640 = new BitSet(new long[]{0x003E010000000800L,0x000000000001F800L});
    public static final BitSet FOLLOW_constraint_expression_in_and_restr_connective3651 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_compound_operator_in_constraint_expression3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_operator_in_constraint_expression3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_constraint_expression3702 = new BitSet(new long[]{0x003E010000000800L,0x000000000001F800L});
    public static final BitSet FOLLOW_or_restr_connective_in_constraint_expression3711 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_constraint_expression3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_simple_operator3748 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_76_in_simple_operator3756 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_77_in_simple_operator3764 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_78_in_simple_operator3772 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_79_in_simple_operator3780 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_80_in_simple_operator3788 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_CONTAINS_in_simple_operator3796 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_NOT_in_simple_operator3804 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_CONTAINS_in_simple_operator3808 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_EXCLUDES_in_simple_operator3816 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_MATCHES_in_simple_operator3824 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_NOT_in_simple_operator3832 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_MATCHES_in_simple_operator3836 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_MEMBEROF_in_simple_operator3844 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_NOT_in_simple_operator3852 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_MEMBEROF_in_simple_operator3856 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_expression_value_in_simple_operator3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_in_compound_operator3900 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NOT_in_compound_operator3912 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_IN_in_compound_operator3914 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_compound_operator3929 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_expression_value_in_compound_operator3933 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_COMMA_in_compound_operator3940 = new BitSet(new long[]{0x10FEF04083D7CDF0L});
    public static final BitSet FOLLOW_expression_value_in_compound_operator3944 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_compound_operator3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accessor_path_in_expression_value3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_constraint_in_expression_value4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paren_chunk_in_expression_value4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_literal_constraint4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_literal_constraint4075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_literal_constraint4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_literal_constraint4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal_constraint4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paren_chunk_in_predicate4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_curly_chunk4167 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_set_in_curly_chunk4171 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_curly_chunk_in_curly_chunk4180 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_curly_chunk4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_paren_chunk4199 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_set_in_paren_chunk4203 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_paren_chunk_in_paren_chunk4212 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_paren_chunk4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_square_chunk4230 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_set_in_square_chunk4234 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_square_chunk_in_square_chunk4243 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_square_chunk4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_qualified_id4261 = new BitSet(new long[]{0x0400000000000202L});
    public static final BitSet FOLLOW_DOT_in_qualified_id4265 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_qualified_id4267 = new BitSet(new long[]{0x0400000000000202L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_qualified_id4274 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_qualified_id4276 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_identifier_in_dotted_name4291 = new BitSet(new long[]{0x0400000000000202L});
    public static final BitSet FOLLOW_DOT_in_dotted_name4295 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_identifier_in_dotted_name4297 = new BitSet(new long[]{0x0400000000000202L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_dotted_name4304 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RIGHT_SQUARE_in_dotted_name4306 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_accessor_element_in_accessor_path4322 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DOT_in_accessor_path4326 = new BitSet(new long[]{0x103EF0408147C5F0L});
    public static final BitSet FOLLOW_accessor_element_in_accessor_path4328 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_identifier_in_accessor_element4346 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_square_chunk_in_accessor_element4348 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_THEN_in_rhs_chunk4365 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_set_in_rhs_chunk4373 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFFFL});
    public static final BitSet FOLLOW_END_in_rhs_chunk4397 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_opt_semicolon_in_rhs_chunk4399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_name4433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_name4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_identifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_synpred12751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_synpred22784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PIPE_in_synpred53575 = new BitSet(new long[]{0x003E010000000800L,0x000000000001F800L});
    public static final BitSet FOLLOW_and_restr_connective_in_synpred53587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_AMPER_in_synpred63640 = new BitSet(new long[]{0x003E010000000800L,0x000000000001F800L});
    public static final BitSet FOLLOW_constraint_expression_in_synpred63651 = new BitSet(new long[]{0x0000000000000002L});

}