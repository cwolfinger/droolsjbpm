// $ANTLR 3.0ea8 /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g 2006-08-10 17:33:11

	package org.drools.lang;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.StringTokenizer;
	import org.drools.lang.descr.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RuleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "EOL", "ID", "INT", "BOOL", "STRING", "FLOAT", "MISC", "WS", "SH_STYLE_SINGLE_LINE_COMMENT", "C_STYLE_SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "\';\'", "\'package\'", "\'import\'", "\'.\'", "\'.*\'", "\'expander\'", "\'global\'", "\'function\'", "\'(\'", "\',\'", "\')\'", "\'{\'", "\'}\'", "\'query\'", "\'end\'", "\'rule\'", "\'when\'", "\':\'", "\'then\'", "\'attributes\'", "\'salience\'", "\'no-loop\'", "\'auto-focus\'", "\'activation-group\'", "\'agenda-group\'", "\'duration\'", "\'or\'", "\'||\'", "\'==\'", "\'>\'", "\'>=\'", "\'<\'", "\'<=\'", "\'!=\'", "\'contains\'", "\'matches\'", "\'excludes\'", "\'null\'", "\'->\'", "\'and\'", "\'&&\'", "\'exists\'", "\'not\'", "\'eval\'", "\'[\'", "\']\'", "\'use\'"
    };
    public static final int BOOL=7;
    public static final int INT=6;
    public static final int WS=11;
    public static final int EOF=-1;
    public static final int MISC=10;
    public static final int STRING=8;
    public static final int EOL=4;
    public static final int FLOAT=9;
    public static final int SH_STYLE_SINGLE_LINE_COMMENT=12;
    public static final int MULTI_LINE_COMMENT=14;
    public static final int C_STYLE_SINGLE_LINE_COMMENT=13;
    public static final int ID=5;
        public RuleParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }


    	private ExpanderResolver expanderResolver;
    	private Expander expander;
    	private boolean expanderDebug = false;
    	private PackageDescr packageDescr;
    	private List errors = new ArrayList();
    	private String source = "unknown";
    	private int lineOffset = 0;
    	
    	private boolean parserDebug = false;
    	
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

    	/**
    	 * This may be set to enable debuggin of DSLs/expanders.
    	 * If set to true, expander stuff will be sent to the Std out.
    	 */	
    	public void setExpanderDebug(boolean status) {
    		expanderDebug = status;
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
    	
    	public void setExpanderResolver(ExpanderResolver expanderResolver) {
    		this.expanderResolver = expanderResolver;
    	}
    	
    	public ExpanderResolver getExpanderResolver() {
    		return expanderResolver;
    	}
    	
    	/** Expand the LHS */
    	private String runWhenExpander(String text, int line) throws RecognitionException {
    		String expanded = text.trim();
    		if (expanded.startsWith(">")) {
    			expanded = expanded.substring(1);  //escape !!
    		} else {
    			try {
    				expanded = expander.expand( "when", text );			
    			} catch (Exception e) {
    				this.errors.add(new ExpanderException("Unable to expand: " + text + ". Due to " + e.getMessage(), line));
    				return "";
    			}
    		}
    		if (expanderDebug) {
    			System.out.println("Expanding LHS: " + text + " ----> " + expanded + " --> from line: " + line);
    		}
    		return expanded;	
    		
    	}
    	
        	/** This will apply a list of constraints to an LHS block */
        	private String applyConstraints(List constraints, String block) {
        		//apply the constraints as a comma seperated list inside the previous block
        		//the block will end in something like "foo()" and the constraint patterns will be put in the ()
        		if (constraints == null) {
        			return block;
        		}
        		StringBuffer list = new StringBuffer();    		
        		for (Iterator iter = constraints.iterator(); iter.hasNext();) {
    				String con = (String) iter.next();
    				list.append("\n\t\t");
    				list.append(con);
    				if (iter.hasNext()) {
    					list.append(",");					
    				}			
    			}
        		if (block.endsWith("()")) {
        			return block.substring(0, block.length() - 2) + "(" + list.toString() + ")";
        		} else {
        			return block + "(" + list.toString() + ")";
        		}
        	}  	

            /** Reparse the results of the expansion */
        	private void reparseLhs(String text, AndDescr descrs) throws RecognitionException {
        		CharStream charStream = new ANTLRStringStream( text );
        		RuleParserLexer lexer = new RuleParserLexer( charStream );
        		TokenStream tokenStream = new CommonTokenStream( lexer );
        		RuleParser parser = new RuleParser( tokenStream );
        		parser.setLineOffset( descrs.getLine() );
        		parser.normal_lhs_block(descrs);
                
                    if (parser.hasErrors()) {
        			this.errors.addAll(parser.getErrors());
        		}
    		if (expanderDebug) {
    			System.out.println("Reparsing LHS: " + text + " --> successful:" + !parser.hasErrors());
    		}    		
        		
        	}
    	
    	/** Expand a line on the RHS */
    	private String runThenExpander(String text, int startLine) {
    		//System.err.println( "expand THEN [" + text + "]" );
    		StringTokenizer lines = new StringTokenizer( text, "\n\r" );

    		StringBuffer expanded = new StringBuffer();
    		
    		String eol = System.getProperty( "line.separator" );
    				
    		while ( lines.hasMoreTokens() ) {
    			startLine++;
    			String line = lines.nextToken();
    			line = line.trim();
    			if ( line.length() > 0 ) {
    				if ( line.startsWith( ">" ) ) {
    					expanded.append( line.substring( 1 ) );
    					expanded.append( eol );
    				} else {
    					try {
    						expanded.append( expander.expand( "then", line ) );
    						expanded.append( eol );
    					} catch (Exception e) {
    						this.errors.add(new ExpanderException("Unable to expand: " + line + ". Due to " + e.getMessage(), startLine));			
    					}
    				}
    			}
    		}
    		
    		if (expanderDebug) {
    			System.out.println("Expanding RHS: " + text + " ----> " + expanded.toString() + " --> from line starting: " + startLine);
    		}		
    		
    		return expanded.toString();
    	}
    	

    	
    	private String getString(Token token) {
    		String orig = token.getText();
    		return orig.substring( 1, orig.length() -1 );
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
                                                               mtne.foundNode+
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
          



    // $ANTLR start opt_eol
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:275:1: opt_eol : ( (';'|EOL))* ;
    public void opt_eol() throws RecognitionException {   
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:276:17: ( ( (';'|EOL))* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:276:17: ( (';'|EOL))*
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:276:17: ( (';'|EOL))*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);
                if ( LA1_0==EOL ) {
                    alt1=1;
                }
                else if ( LA1_0==15 ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:276:18: (';'|EOL)
            	    {
            	    if ( input.LA(1)==EOL||input.LA(1)==15 ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_opt_eol41);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end opt_eol


    // $ANTLR start compilation_unit
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:279:1: compilation_unit : opt_eol prolog (r= rule | q= query | extra_statement )* ;
    public void compilation_unit() throws RecognitionException {   
        RuleDescr r = null;

        QueryDescr q = null;


        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:280:17: ( opt_eol prolog (r= rule | q= query | extra_statement )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:280:17: opt_eol prolog (r= rule | q= query | extra_statement )*
            {
            following.push(FOLLOW_opt_eol_in_compilation_unit57);
            opt_eol();
            following.pop();

            following.push(FOLLOW_prolog_in_compilation_unit61);
            prolog();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:282:17: (r= rule | q= query | extra_statement )*
            loop2:
            do {
                int alt2=4;
                alt2 = dfa2.predict(input); 
                switch (alt2) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:282:25: r= rule
            	    {
            	    following.push(FOLLOW_rule_in_compilation_unit70);
            	    r=rule();
            	    following.pop();

            	    this.packageDescr.addRule( r ); 

            	    }
            	    break;
            	case 2 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:283:25: q= query
            	    {
            	    following.push(FOLLOW_query_in_compilation_unit83);
            	    q=query();
            	    following.pop();

            	    this.packageDescr.addRule( q ); 

            	    }
            	    break;
            	case 3 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:284:25: extra_statement
            	    {
            	    following.push(FOLLOW_extra_statement_in_compilation_unit91);
            	    extra_statement();
            	    following.pop();


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end compilation_unit


    // $ANTLR start prolog
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:288:1: prolog : opt_eol (name= package_statement )? ( extra_statement | expander )* opt_eol ;
    public void prolog() throws RecognitionException {   
        String name = null;



        		String packageName = "";
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:292:17: ( opt_eol (name= package_statement )? ( extra_statement | expander )* opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:292:17: opt_eol (name= package_statement )? ( extra_statement | expander )* opt_eol
            {
            following.push(FOLLOW_opt_eol_in_prolog115);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:293:17: (name= package_statement )?
            int alt3=2;
            int LA3_0 = input.LA(1);
            if ( LA3_0==16 ) {
                alt3=1;
            }
            else if ( LA3_0==-1||LA3_0==EOL||LA3_0==15||LA3_0==17||(LA3_0>=20 && LA3_0<=22)||LA3_0==28||LA3_0==30 ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("293:17: (name= package_statement )?", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:293:19: name= package_statement
                    {
                    following.push(FOLLOW_package_statement_in_prolog123);
                    name=package_statement();
                    following.pop();

                     packageName = name; 

                    }
                    break;

            }

             
            			this.packageDescr = new PackageDescr( name ); 
            		
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:297:17: ( extra_statement | expander )*
            loop4:
            do {
                int alt4=3;
                alt4 = dfa4.predict(input); 
                switch (alt4) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:297:25: extra_statement
            	    {
            	    following.push(FOLLOW_extra_statement_in_prolog138);
            	    extra_statement();
            	    following.pop();


            	    }
            	    break;
            	case 2 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:298:25: expander
            	    {
            	    following.push(FOLLOW_expander_in_prolog144);
            	    expander();
            	    following.pop();


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            following.push(FOLLOW_opt_eol_in_prolog156);
            opt_eol();
            following.pop();


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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:304:1: package_statement returns [String packageName] : 'package' opt_eol name= dotted_name ( ';' )? opt_eol ;
    public String package_statement() throws RecognitionException {   
        String packageName;
        String name = null;



        		packageName = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:309:17: ( 'package' opt_eol name= dotted_name ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:309:17: 'package' opt_eol name= dotted_name ( ';' )? opt_eol
            {
            match(input,16,FOLLOW_16_in_package_statement180); 
            following.push(FOLLOW_opt_eol_in_package_statement182);
            opt_eol();
            following.pop();

            following.push(FOLLOW_dotted_name_in_package_statement186);
            name=dotted_name();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:309:52: ( ';' )?
            int alt5=2;
            int LA5_0 = input.LA(1);
            if ( LA5_0==15 ) {
                alt5=1;
            }
            else if ( LA5_0==-1||LA5_0==EOL||LA5_0==17||(LA5_0>=20 && LA5_0<=22)||LA5_0==28||LA5_0==30 ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("309:52: ( \';\' )?", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:309:52: ';'
                    {
                    match(input,15,FOLLOW_15_in_package_statement188); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_package_statement191);
            opt_eol();
            following.pop();


            			packageName = name;
            		

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


    // $ANTLR start import_statement
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:315:1: import_statement : 'import' opt_eol name= import_name ( ';' )? opt_eol ;
    public void import_statement() throws RecognitionException {   
        String name = null;


        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:316:17: ( 'import' opt_eol name= import_name ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:316:17: 'import' opt_eol name= import_name ( ';' )? opt_eol
            {
            match(input,17,FOLLOW_17_in_import_statement207); 
            following.push(FOLLOW_opt_eol_in_import_statement209);
            opt_eol();
            following.pop();

            following.push(FOLLOW_import_name_in_import_statement213);
            name=import_name();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:316:51: ( ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);
            if ( LA6_0==15 ) {
                alt6=1;
            }
            else if ( LA6_0==-1||LA6_0==EOL||LA6_0==17||(LA6_0>=20 && LA6_0<=22)||LA6_0==28||LA6_0==30 ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("316:51: ( \';\' )?", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:316:51: ';'
                    {
                    match(input,15,FOLLOW_15_in_import_statement215); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_import_statement218);
            opt_eol();
            following.pop();


            			if (packageDescr != null) 
            				packageDescr.addImport( name );
            		

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


    // $ANTLR start import_name
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:323:1: import_name returns [String name] : id= ID ( '.' id= ID )* (star= '.*' )? ;
    public String import_name() throws RecognitionException {   
        String name;
        Token id=null;
        Token star=null;


        		name = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:328:17: (id= ID ( '.' id= ID )* (star= '.*' )? )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:328:17: id= ID ( '.' id= ID )* (star= '.*' )?
            {
            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_import_name249); 
             name=id.getText(); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:328:46: ( '.' id= ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);
                if ( LA7_0==18 ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:328:48: '.' id= ID
            	    {
            	    match(input,18,FOLLOW_18_in_import_name255); 
            	    id=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_import_name259); 
            	     name = name + "." + id.getText(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:328:99: (star= '.*' )?
            int alt8=2;
            int LA8_0 = input.LA(1);
            if ( LA8_0==19 ) {
                alt8=1;
            }
            else if ( LA8_0==-1||LA8_0==EOL||LA8_0==15||LA8_0==17||(LA8_0>=20 && LA8_0<=22)||LA8_0==28||LA8_0==30 ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("328:99: (star= \'.*\' )?", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:328:100: star= '.*'
                    {
                    star=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_import_name269); 
                     name = name + star.getText(); 

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


    // $ANTLR start expander
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:330:1: expander : 'expander' (name= dotted_name )? ( ';' )? opt_eol ;
    public void expander() throws RecognitionException {   
        String name = null;



        		String config=null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:334:17: ( 'expander' (name= dotted_name )? ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:334:17: 'expander' (name= dotted_name )? ( ';' )? opt_eol
            {
            match(input,20,FOLLOW_20_in_expander289); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:334:28: (name= dotted_name )?
            int alt9=2;
            int LA9_0 = input.LA(1);
            if ( LA9_0==ID ) {
                alt9=1;
            }
            else if ( LA9_0==-1||LA9_0==EOL||LA9_0==15||LA9_0==17||(LA9_0>=20 && LA9_0<=22)||LA9_0==28||LA9_0==30 ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("334:28: (name= dotted_name )?", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:334:29: name= dotted_name
                    {
                    following.push(FOLLOW_dotted_name_in_expander294);
                    name=dotted_name();
                    following.pop();


                    }
                    break;

            }

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:334:48: ( ';' )?
            int alt10=2;
            int LA10_0 = input.LA(1);
            if ( LA10_0==15 ) {
                alt10=1;
            }
            else if ( LA10_0==-1||LA10_0==EOL||LA10_0==17||(LA10_0>=20 && LA10_0<=22)||LA10_0==28||LA10_0==30 ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("334:48: ( \';\' )?", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:334:48: ';'
                    {
                    match(input,15,FOLLOW_15_in_expander298); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_expander301);
            opt_eol();
            following.pop();


            			if (expanderResolver == null) 
            				throw new IllegalArgumentException("Unable to use expander. Make sure a expander or dsl config is being passed to the parser. [ExpanderResolver was not set].");
            			if ( expander != null )
            				throw new IllegalArgumentException( "Only one 'expander' statement per file is allowed" );
            			expander = expanderResolver.get( name, config );
            		

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
    // $ANTLR end expander


    // $ANTLR start global
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:344:1: global : 'global' type= dotted_name id= ID ( ';' )? opt_eol ;
    public void global() throws RecognitionException {   
        Token id=null;
        String type = null;



        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:348:17: ( 'global' type= dotted_name id= ID ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:348:17: 'global' type= dotted_name id= ID ( ';' )? opt_eol
            {
            match(input,21,FOLLOW_21_in_global325); 
            following.push(FOLLOW_dotted_name_in_global329);
            type=dotted_name();
            following.pop();

            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_global333); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:348:49: ( ';' )?
            int alt11=2;
            int LA11_0 = input.LA(1);
            if ( LA11_0==15 ) {
                alt11=1;
            }
            else if ( LA11_0==-1||LA11_0==EOL||LA11_0==17||(LA11_0>=20 && LA11_0<=22)||LA11_0==28||LA11_0==30 ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("348:49: ( \';\' )?", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:348:49: ';'
                    {
                    match(input,15,FOLLOW_15_in_global335); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_global338);
            opt_eol();
            following.pop();


            			packageDescr.addGlobal( id.getText(), type );
            		

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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:354:1: function : 'function' opt_eol (retType= dotted_name )? opt_eol name= ID opt_eol '(' opt_eol ( (paramType= dotted_name )? opt_eol paramName= argument opt_eol ( ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )* )? ')' opt_eol '{' body= curly_chunk '}' opt_eol ;
    public void function() throws RecognitionException {   
        Token name=null;
        String retType = null;

        String paramType = null;

        String paramName = null;

        String body = null;



        		FunctionDescr f = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:359:17: ( 'function' opt_eol (retType= dotted_name )? opt_eol name= ID opt_eol '(' opt_eol ( (paramType= dotted_name )? opt_eol paramName= argument opt_eol ( ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )* )? ')' opt_eol '{' body= curly_chunk '}' opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:359:17: 'function' opt_eol (retType= dotted_name )? opt_eol name= ID opt_eol '(' opt_eol ( (paramType= dotted_name )? opt_eol paramName= argument opt_eol ( ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )* )? ')' opt_eol '{' body= curly_chunk '}' opt_eol
            {
            match(input,22,FOLLOW_22_in_function362); 
            following.push(FOLLOW_opt_eol_in_function364);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:359:36: (retType= dotted_name )?
            int alt12=2;
            alt12 = dfa12.predict(input); 
            switch (alt12) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:359:37: retType= dotted_name
                    {
                    following.push(FOLLOW_dotted_name_in_function369);
                    retType=dotted_name();
                    following.pop();


                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_function373);
            opt_eol();
            following.pop();

            name=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function377); 
            following.push(FOLLOW_opt_eol_in_function379);
            opt_eol();
            following.pop();


            			//System.err.println( "function :: " + name.getText() );
            			f = new FunctionDescr( name.getText(), retType );
            		
            match(input,23,FOLLOW_23_in_function388); 
            following.push(FOLLOW_opt_eol_in_function390);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:365:25: ( (paramType= dotted_name )? opt_eol paramName= argument opt_eol ( ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);
            if ( (LA16_0>=EOL && LA16_0<=ID)||LA16_0==15 ) {
                alt16=1;
            }
            else if ( LA16_0==25 ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("365:25: ( (paramType= dotted_name )? opt_eol paramName= argument opt_eol ( \',\' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )* )?", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:365:33: (paramType= dotted_name )? opt_eol paramName= argument opt_eol ( ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )*
                    {
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:365:33: (paramType= dotted_name )?
                    int alt13=2;
                    alt13 = dfa13.predict(input); 
                    switch (alt13) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:365:34: paramType= dotted_name
                            {
                            following.push(FOLLOW_dotted_name_in_function400);
                            paramType=dotted_name();
                            following.pop();


                            }
                            break;

                    }

                    following.push(FOLLOW_opt_eol_in_function404);
                    opt_eol();
                    following.pop();

                    following.push(FOLLOW_argument_in_function408);
                    paramName=argument();
                    following.pop();

                    following.push(FOLLOW_opt_eol_in_function410);
                    opt_eol();
                    following.pop();


                    					f.addParameter( paramType, paramName );
                    				
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:369:33: ( ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);
                        if ( LA15_0==24 ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:369:41: ',' opt_eol (paramType= dotted_name )? opt_eol paramName= argument opt_eol
                    	    {
                    	    match(input,24,FOLLOW_24_in_function424); 
                    	    following.push(FOLLOW_opt_eol_in_function426);
                    	    opt_eol();
                    	    following.pop();

                    	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:369:53: (paramType= dotted_name )?
                    	    int alt14=2;
                    	    alt14 = dfa14.predict(input); 
                    	    switch (alt14) {
                    	        case 1 :
                    	            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:369:54: paramType= dotted_name
                    	            {
                    	            following.push(FOLLOW_dotted_name_in_function431);
                    	            paramType=dotted_name();
                    	            following.pop();


                    	            }
                    	            break;

                    	    }

                    	    following.push(FOLLOW_opt_eol_in_function435);
                    	    opt_eol();
                    	    following.pop();

                    	    following.push(FOLLOW_argument_in_function439);
                    	    paramName=argument();
                    	    following.pop();

                    	    following.push(FOLLOW_opt_eol_in_function441);
                    	    opt_eol();
                    	    following.pop();


                    	    						f.addParameter( paramType, paramName );
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_function466); 
            following.push(FOLLOW_opt_eol_in_function470);
            opt_eol();
            following.pop();

            match(input,26,FOLLOW_26_in_function474); 
            following.push(FOLLOW_curly_chunk_in_function481);
            body=curly_chunk();
            following.pop();


            				f.setText( body );
            			
            match(input,27,FOLLOW_27_in_function490); 

            			packageDescr.addFunction( f );
            		
            following.push(FOLLOW_opt_eol_in_function498);
            opt_eol();
            following.pop();


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


    // $ANTLR start query
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:390:1: query returns [QueryDescr query] : opt_eol loc= 'query' queryName= word opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) 'end' opt_eol ;
    public QueryDescr query() throws RecognitionException {   
        QueryDescr query;
        Token loc=null;
        String queryName = null;



        		query = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:395:17: ( opt_eol loc= 'query' queryName= word opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) 'end' opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:395:17: opt_eol loc= 'query' queryName= word opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) 'end' opt_eol
            {
            following.push(FOLLOW_opt_eol_in_query522);
            opt_eol();
            following.pop();

            loc=(Token)input.LT(1);
            match(input,28,FOLLOW_28_in_query528); 
            following.push(FOLLOW_word_in_query532);
            queryName=word();
            following.pop();

            following.push(FOLLOW_opt_eol_in_query534);
            opt_eol();
            following.pop();

             
            			query = new QueryDescr( queryName, null ); 
            			query.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            			AndDescr lhs = new AndDescr(); query.setLhs( lhs ); 
            			lhs.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )
            int alt17=2;
            switch ( input.LA(1) ) {
            case 23:
                int LA17_1 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 1, input);

                    throw nvae;
                }
                break;
            case EOL:
                int LA17_2 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 2, input);

                    throw nvae;
                }
                break;
            case 29:
                int LA17_3 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 3, input);

                    throw nvae;
                }
                break;
            case 56:
                int LA17_4 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 4, input);

                    throw nvae;
                }
                break;
            case 57:
                int LA17_5 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 5, input);

                    throw nvae;
                }
                break;
            case 58:
                int LA17_6 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 6, input);

                    throw nvae;
                }
                break;
            case ID:
                int LA17_7 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 7, input);

                    throw nvae;
                }
                break;
            case 15:
                int LA17_8 = input.LA(2);
                if (  expander != null  ) {
                    alt17=1;
                }
                else if ( true ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 8, input);

                    throw nvae;
                }
                break;
            case INT:
            case BOOL:
            case STRING:
            case FLOAT:
            case MISC:
            case WS:
            case SH_STYLE_SINGLE_LINE_COMMENT:
            case C_STYLE_SINGLE_LINE_COMMENT:
            case MULTI_LINE_COMMENT:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 59:
            case 60:
            case 61:
                alt17=1;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("403:17: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:404:25: {...}? expander_lhs_block[lhs]
                    {
                    if ( !( expander != null ) ) {
                        throw new FailedPredicateException(input, "query", " expander != null ");
                    }
                    following.push(FOLLOW_expander_lhs_block_in_query550);
                    expander_lhs_block(lhs);
                    following.pop();


                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:405:27: normal_lhs_block[lhs]
                    {
                    following.push(FOLLOW_normal_lhs_block_in_query558);
                    normal_lhs_block(lhs);
                    following.pop();


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_query573); 
            following.push(FOLLOW_opt_eol_in_query575);
            opt_eol();
            following.pop();


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


    // $ANTLR start rule
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:411:1: rule returns [RuleDescr rule] : opt_eol loc= 'rule' ruleName= word opt_eol ( rule_attributes[rule] )? opt_eol ( (loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )? ( opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )* )? )? 'end' opt_eol ;
    public RuleDescr rule() throws RecognitionException {   
        RuleDescr rule;
        Token loc=null;
        Token any=null;
        String ruleName = null;



        		rule = null;
        		String consequence = "";
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:417:17: ( opt_eol loc= 'rule' ruleName= word opt_eol ( rule_attributes[rule] )? opt_eol ( (loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )? ( opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )* )? )? 'end' opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:417:17: opt_eol loc= 'rule' ruleName= word opt_eol ( rule_attributes[rule] )? opt_eol ( (loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )? ( opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )* )? )? 'end' opt_eol
            {
            following.push(FOLLOW_opt_eol_in_rule598);
            opt_eol();
            following.pop();

            loc=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_rule604); 
            following.push(FOLLOW_word_in_rule608);
            ruleName=word();
            following.pop();

            following.push(FOLLOW_opt_eol_in_rule610);
            opt_eol();
            following.pop();

             
            			debug( "start rule: " + ruleName );
            			rule = new RuleDescr( ruleName, null ); 
            			rule.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:424:17: ( rule_attributes[rule] )?
            int alt18=2;
            switch ( input.LA(1) ) {
            case 32:
            case 34:
                alt18=1;
                break;
            case EOL:
            case 15:
            case 24:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                alt18=1;
                break;
            case 31:
                alt18=1;
                break;
            case 33:
                alt18=1;
                break;
            case 29:
                alt18=1;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("424:17: ( rule_attributes[rule] )?", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:424:25: rule_attributes[rule]
                    {
                    following.push(FOLLOW_rule_attributes_in_rule621);
                    rule_attributes(rule);
                    following.pop();


                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_rule631);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:427:17: ( (loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )? ( opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )* )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);
            if ( LA25_0==EOL||LA25_0==15||LA25_0==31||LA25_0==33 ) {
                alt25=1;
            }
            else if ( LA25_0==29 ) {
                alt25=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("427:17: ( (loc= \'when\' ( \':\' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )? ( opt_eol loc= \'then\' ( \':\' )? opt_eol ( options {greedy=false; } : any= . )* )? )?", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:427:18: (loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )? ( opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )* )?
                    {
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:427:18: (loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);
                    if ( LA21_0==31 ) {
                        alt21=1;
                    }
                    else if ( LA21_0==EOL||LA21_0==15||LA21_0==29||LA21_0==33 ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("427:18: (loc= \'when\' ( \':\' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] ) )?", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:427:25: loc= 'when' ( ':' )? opt_eol ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )
                            {
                            loc=(Token)input.LT(1);
                            match(input,31,FOLLOW_31_in_rule640); 
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:427:36: ( ':' )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);
                            if ( LA19_0==32 ) {
                                int LA19_1 = input.LA(2);
                                if ( !( expander != null ) ) {
                                    alt19=1;
                                }
                                else if (  expander != null  ) {
                                    alt19=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("427:36: ( \':\' )?", 19, 1, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA19_0>=EOL && LA19_0<=31)||(LA19_0>=33 && LA19_0<=61) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("427:36: ( \':\' )?", 19, 0, input);

                                throw nvae;
                            }
                            switch (alt19) {
                                case 1 :
                                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:427:36: ':'
                                    {
                                    match(input,32,FOLLOW_32_in_rule642); 

                                    }
                                    break;

                            }

                            following.push(FOLLOW_opt_eol_in_rule645);
                            opt_eol();
                            following.pop();

                             
                            				AndDescr lhs = new AndDescr(); rule.setLhs( lhs ); 
                            				lhs.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
                            			
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )
                            int alt20=2;
                            switch ( input.LA(1) ) {
                            case 23:
                                int LA20_1 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 1, input);

                                    throw nvae;
                                }
                                break;
                            case EOL:
                                int LA20_2 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 2, input);

                                    throw nvae;
                                }
                                break;
                            case 15:
                                int LA20_3 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 3, input);

                                    throw nvae;
                                }
                                break;
                            case 33:
                                int LA20_4 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 4, input);

                                    throw nvae;
                                }
                                break;
                            case 29:
                                int LA20_5 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 5, input);

                                    throw nvae;
                                }
                                break;
                            case 56:
                                int LA20_6 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 6, input);

                                    throw nvae;
                                }
                                break;
                            case 57:
                                int LA20_7 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 7, input);

                                    throw nvae;
                                }
                                break;
                            case 58:
                                int LA20_8 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 8, input);

                                    throw nvae;
                                }
                                break;
                            case ID:
                                int LA20_9 = input.LA(2);
                                if (  expander != null  ) {
                                    alt20=1;
                                }
                                else if ( true ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 9, input);

                                    throw nvae;
                                }
                                break;
                            case INT:
                            case BOOL:
                            case STRING:
                            case FLOAT:
                            case MISC:
                            case WS:
                            case SH_STYLE_SINGLE_LINE_COMMENT:
                            case C_STYLE_SINGLE_LINE_COMMENT:
                            case MULTI_LINE_COMMENT:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 30:
                            case 31:
                            case 32:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 59:
                            case 60:
                            case 61:
                                alt20=1;
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("432:25: ({...}? expander_lhs_block[lhs] | normal_lhs_block[lhs] )", 20, 0, input);

                                throw nvae;
                            }

                            switch (alt20) {
                                case 1 :
                                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:433:33: {...}? expander_lhs_block[lhs]
                                    {
                                    if ( !( expander != null ) ) {
                                        throw new FailedPredicateException(input, "rule", " expander != null ");
                                    }
                                    following.push(FOLLOW_expander_lhs_block_in_rule663);
                                    expander_lhs_block(lhs);
                                    following.pop();


                                    }
                                    break;
                                case 2 :
                                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:434:35: normal_lhs_block[lhs]
                                    {
                                    following.push(FOLLOW_normal_lhs_block_in_rule672);
                                    normal_lhs_block(lhs);
                                    following.pop();


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:438:17: ( opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )* )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);
                    if ( LA24_0==EOL||LA24_0==15||LA24_0==33 ) {
                        alt24=1;
                    }
                    else if ( LA24_0==29 ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("438:17: ( opt_eol loc= \'then\' ( \':\' )? opt_eol ( options {greedy=false; } : any= . )* )?", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:438:19: opt_eol loc= 'then' ( ':' )? opt_eol ( options {greedy=false; } : any= . )*
                            {
                            following.push(FOLLOW_opt_eol_in_rule695);
                            opt_eol();
                            following.pop();

                            loc=(Token)input.LT(1);
                            match(input,33,FOLLOW_33_in_rule699); 
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:438:38: ( ':' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);
                            if ( LA22_0==32 ) {
                                alt22=1;
                            }
                            else if ( (LA22_0>=EOL && LA22_0<=31)||(LA22_0>=33 && LA22_0<=61) ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("438:38: ( \':\' )?", 22, 0, input);

                                throw nvae;
                            }
                            switch (alt22) {
                                case 1 :
                                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:438:38: ':'
                                    {
                                    match(input,32,FOLLOW_32_in_rule701); 

                                    }
                                    break;

                            }

                            following.push(FOLLOW_opt_eol_in_rule705);
                            opt_eol();
                            following.pop();

                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:439:25: ( options {greedy=false; } : any= . )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);
                                if ( LA23_0==29 ) {
                                    alt23=2;
                                }
                                else if ( (LA23_0>=EOL && LA23_0<=28)||(LA23_0>=30 && LA23_0<=61) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:439:52: any= .
                            	    {
                            	    any=(Token)input.LT(1);
                            	    matchAny(input); 

                            	    					consequence = consequence + " " + any.getText();
                            	    				

                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);


                            				if ( expander != null ) {
                            					String expanded = runThenExpander( consequence, offset(loc.getLine()) );
                            					rule.setConsequence( expanded );
                            				} else { 
                            					rule.setConsequence( consequence ); 
                            				}
                            				rule.setConsequenceLocation(offset(loc.getLine()), loc.getCharPositionInLine());
                            			

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_rule751); 
            following.push(FOLLOW_opt_eol_in_rule753);
            opt_eol();
            following.pop();


            			debug( "end rule: " + ruleName );
            		

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


    // $ANTLR start extra_statement
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:460:1: extra_statement : ( import_statement | global | function ) ;
    public void extra_statement() throws RecognitionException {   
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:462:9: ( ( import_statement | global | function ) )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:462:9: ( import_statement | global | function )
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:462:9: ( import_statement | global | function )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 17:
                alt26=1;
                break;
            case 21:
                alt26=2;
                break;
            case 22:
                alt26=3;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("462:9: ( import_statement | global | function )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:462:17: import_statement
                    {
                    following.push(FOLLOW_import_statement_in_extra_statement773);
                    import_statement();
                    following.pop();


                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:463:17: global
                    {
                    following.push(FOLLOW_global_in_extra_statement778);
                    global();
                    following.pop();


                    }
                    break;
                case 3 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:464:17: function
                    {
                    following.push(FOLLOW_function_in_extra_statement783);
                    function();
                    following.pop();


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
    // $ANTLR end extra_statement


    // $ANTLR start rule_attributes
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:468:1: rule_attributes[RuleDescr rule] : ( 'attributes' )? ( ':' )? opt_eol ( ( ',' )? a= rule_attribute opt_eol )* ;
    public void rule_attributes(RuleDescr rule) throws RecognitionException {   
        AttributeDescr a = null;


        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:470:25: ( ( 'attributes' )? ( ':' )? opt_eol ( ( ',' )? a= rule_attribute opt_eol )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:470:25: ( 'attributes' )? ( ':' )? opt_eol ( ( ',' )? a= rule_attribute opt_eol )*
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:470:25: ( 'attributes' )?
            int alt27=2;
            int LA27_0 = input.LA(1);
            if ( LA27_0==34 ) {
                alt27=1;
            }
            else if ( LA27_0==EOL||LA27_0==15||LA27_0==24||LA27_0==29||(LA27_0>=31 && LA27_0<=33)||(LA27_0>=35 && LA27_0<=40) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("470:25: ( \'attributes\' )?", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:470:25: 'attributes'
                    {
                    match(input,34,FOLLOW_34_in_rule_attributes802); 

                    }
                    break;

            }

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:470:39: ( ':' )?
            int alt28=2;
            int LA28_0 = input.LA(1);
            if ( LA28_0==32 ) {
                alt28=1;
            }
            else if ( LA28_0==EOL||LA28_0==15||LA28_0==24||LA28_0==29||LA28_0==31||LA28_0==33||(LA28_0>=35 && LA28_0<=40) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("470:39: ( \':\' )?", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:470:39: ':'
                    {
                    match(input,32,FOLLOW_32_in_rule_attributes805); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_rule_attributes808);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:471:25: ( ( ',' )? a= rule_attribute opt_eol )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);
                if ( LA30_0==24||(LA30_0>=35 && LA30_0<=40) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:471:33: ( ',' )? a= rule_attribute opt_eol
            	    {
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:471:33: ( ',' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);
            	    if ( LA29_0==24 ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0>=35 && LA29_0<=40) ) {
            	        alt29=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("471:33: ( \',\' )?", 29, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:471:33: ','
            	            {
            	            match(input,24,FOLLOW_24_in_rule_attributes815); 

            	            }
            	            break;

            	    }

            	    following.push(FOLLOW_rule_attribute_in_rule_attributes820);
            	    a=rule_attribute();
            	    following.pop();

            	    following.push(FOLLOW_opt_eol_in_rule_attributes822);
            	    opt_eol();
            	    following.pop();


            	    					rule.addAttribute( a );
            	    				

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:478:1: rule_attribute returns [AttributeDescr d] : (a= salience | a= no_loop | a= agenda_group | a= duration | a= activation_group | a= auto_focus );
    public AttributeDescr rule_attribute() throws RecognitionException {   
        AttributeDescr d;
        AttributeDescr a = null;



        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:483:25: (a= salience | a= no_loop | a= agenda_group | a= duration | a= activation_group | a= auto_focus )
            int alt31=6;
            switch ( input.LA(1) ) {
            case 35:
                alt31=1;
                break;
            case 36:
                alt31=2;
                break;
            case 39:
                alt31=3;
                break;
            case 40:
                alt31=4;
                break;
            case 38:
                alt31=5;
                break;
            case 37:
                alt31=6;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("478:1: rule_attribute returns [AttributeDescr d] : (a= salience | a= no_loop | a= agenda_group | a= duration | a= activation_group | a= auto_focus );", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:483:25: a= salience
                    {
                    following.push(FOLLOW_salience_in_rule_attribute861);
                    a=salience();
                    following.pop();

                     d = a; 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:484:25: a= no_loop
                    {
                    following.push(FOLLOW_no_loop_in_rule_attribute871);
                    a=no_loop();
                    following.pop();

                     d = a; 

                    }
                    break;
                case 3 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:485:25: a= agenda_group
                    {
                    following.push(FOLLOW_agenda_group_in_rule_attribute882);
                    a=agenda_group();
                    following.pop();

                     d = a; 

                    }
                    break;
                case 4 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:486:25: a= duration
                    {
                    following.push(FOLLOW_duration_in_rule_attribute895);
                    a=duration();
                    following.pop();

                     d = a; 

                    }
                    break;
                case 5 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:487:25: a= activation_group
                    {
                    following.push(FOLLOW_activation_group_in_rule_attribute909);
                    a=activation_group();
                    following.pop();

                     d = a; 

                    }
                    break;
                case 6 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:488:25: a= auto_focus
                    {
                    following.push(FOLLOW_auto_focus_in_rule_attribute920);
                    a=auto_focus();
                    following.pop();

                     d = a; 

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
    // $ANTLR end rule_attribute


    // $ANTLR start salience
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:492:1: salience returns [AttributeDescr d ] : loc= 'salience' opt_eol i= INT ( ';' )? opt_eol ;
    public AttributeDescr salience() throws RecognitionException {   
        AttributeDescr d;
        Token loc=null;
        Token i=null;


        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:497:17: (loc= 'salience' opt_eol i= INT ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:497:17: loc= 'salience' opt_eol i= INT ( ';' )? opt_eol
            {
            loc=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_salience953); 
            following.push(FOLLOW_opt_eol_in_salience955);
            opt_eol();
            following.pop();

            i=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_salience959); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:497:46: ( ';' )?
            int alt32=2;
            int LA32_0 = input.LA(1);
            if ( LA32_0==15 ) {
                alt32=1;
            }
            else if ( LA32_0==EOL||LA32_0==24||LA32_0==29||LA32_0==31||LA32_0==33||(LA32_0>=35 && LA32_0<=40) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("497:46: ( \';\' )?", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:497:46: ';'
                    {
                    match(input,15,FOLLOW_15_in_salience961); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_salience964);
            opt_eol();
            following.pop();


            			d = new AttributeDescr( "salience", i.getText() );
            			d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		

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
    // $ANTLR end salience


    // $ANTLR start no_loop
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:504:1: no_loop returns [AttributeDescr d] : ( (loc= 'no-loop' opt_eol ( ';' )? opt_eol ) | (loc= 'no-loop' t= BOOL opt_eol ( ';' )? opt_eol ) );
    public AttributeDescr no_loop() throws RecognitionException {   
        AttributeDescr d;
        Token loc=null;
        Token t=null;


        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:509:17: ( (loc= 'no-loop' opt_eol ( ';' )? opt_eol ) | (loc= 'no-loop' t= BOOL opt_eol ( ';' )? opt_eol ) )
            int alt35=2;
            int LA35_0 = input.LA(1);
            if ( LA35_0==36 ) {
                int LA35_1 = input.LA(2);
                if ( LA35_1==BOOL ) {
                    alt35=2;
                }
                else if ( LA35_1==EOL||LA35_1==15||LA35_1==24||LA35_1==29||LA35_1==31||LA35_1==33||(LA35_1>=35 && LA35_1<=40) ) {
                    alt35=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("504:1: no_loop returns [AttributeDescr d] : ( (loc= \'no-loop\' opt_eol ( \';\' )? opt_eol ) | (loc= \'no-loop\' t= BOOL opt_eol ( \';\' )? opt_eol ) );", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("504:1: no_loop returns [AttributeDescr d] : ( (loc= \'no-loop\' opt_eol ( \';\' )? opt_eol ) | (loc= \'no-loop\' t= BOOL opt_eol ( \';\' )? opt_eol ) );", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:509:17: (loc= 'no-loop' opt_eol ( ';' )? opt_eol )
                    {
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:509:17: (loc= 'no-loop' opt_eol ( ';' )? opt_eol )
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:510:25: loc= 'no-loop' opt_eol ( ';' )? opt_eol
                    {
                    loc=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_no_loop999); 
                    following.push(FOLLOW_opt_eol_in_no_loop1001);
                    opt_eol();
                    following.pop();

                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:510:47: ( ';' )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);
                    if ( LA33_0==15 ) {
                        alt33=1;
                    }
                    else if ( LA33_0==EOL||LA33_0==24||LA33_0==29||LA33_0==31||LA33_0==33||(LA33_0>=35 && LA33_0<=40) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("510:47: ( \';\' )?", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:510:47: ';'
                            {
                            match(input,15,FOLLOW_15_in_no_loop1003); 

                            }
                            break;

                    }

                    following.push(FOLLOW_opt_eol_in_no_loop1006);
                    opt_eol();
                    following.pop();


                    				d = new AttributeDescr( "no-loop", "true" );
                    				d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
                    			

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:517:17: (loc= 'no-loop' t= BOOL opt_eol ( ';' )? opt_eol )
                    {
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:517:17: (loc= 'no-loop' t= BOOL opt_eol ( ';' )? opt_eol )
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:518:25: loc= 'no-loop' t= BOOL opt_eol ( ';' )? opt_eol
                    {
                    loc=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_no_loop1031); 
                    t=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_no_loop1035); 
                    following.push(FOLLOW_opt_eol_in_no_loop1037);
                    opt_eol();
                    following.pop();

                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:518:54: ( ';' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);
                    if ( LA34_0==15 ) {
                        alt34=1;
                    }
                    else if ( LA34_0==EOL||LA34_0==24||LA34_0==29||LA34_0==31||LA34_0==33||(LA34_0>=35 && LA34_0<=40) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("518:54: ( \';\' )?", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:518:54: ';'
                            {
                            match(input,15,FOLLOW_15_in_no_loop1039); 

                            }
                            break;

                    }

                    following.push(FOLLOW_opt_eol_in_no_loop1042);
                    opt_eol();
                    following.pop();


                    				d = new AttributeDescr( "no-loop", t.getText() );
                    				d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
                    			

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
        return d;
    }
    // $ANTLR end no_loop


    // $ANTLR start auto_focus
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:528:1: auto_focus returns [AttributeDescr d] : ( (loc= 'auto-focus' opt_eol ( ';' )? opt_eol ) | (loc= 'auto-focus' t= BOOL opt_eol ( ';' )? opt_eol ) );
    public AttributeDescr auto_focus() throws RecognitionException {   
        AttributeDescr d;
        Token loc=null;
        Token t=null;


        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:533:17: ( (loc= 'auto-focus' opt_eol ( ';' )? opt_eol ) | (loc= 'auto-focus' t= BOOL opt_eol ( ';' )? opt_eol ) )
            int alt38=2;
            int LA38_0 = input.LA(1);
            if ( LA38_0==37 ) {
                int LA38_1 = input.LA(2);
                if ( LA38_1==BOOL ) {
                    alt38=2;
                }
                else if ( LA38_1==EOL||LA38_1==15||LA38_1==24||LA38_1==29||LA38_1==31||LA38_1==33||(LA38_1>=35 && LA38_1<=40) ) {
                    alt38=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("528:1: auto_focus returns [AttributeDescr d] : ( (loc= \'auto-focus\' opt_eol ( \';\' )? opt_eol ) | (loc= \'auto-focus\' t= BOOL opt_eol ( \';\' )? opt_eol ) );", 38, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("528:1: auto_focus returns [AttributeDescr d] : ( (loc= \'auto-focus\' opt_eol ( \';\' )? opt_eol ) | (loc= \'auto-focus\' t= BOOL opt_eol ( \';\' )? opt_eol ) );", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:533:17: (loc= 'auto-focus' opt_eol ( ';' )? opt_eol )
                    {
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:533:17: (loc= 'auto-focus' opt_eol ( ';' )? opt_eol )
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:534:25: loc= 'auto-focus' opt_eol ( ';' )? opt_eol
                    {
                    loc=(Token)input.LT(1);
                    match(input,37,FOLLOW_37_in_auto_focus1088); 
                    following.push(FOLLOW_opt_eol_in_auto_focus1090);
                    opt_eol();
                    following.pop();

                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:534:50: ( ';' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);
                    if ( LA36_0==15 ) {
                        alt36=1;
                    }
                    else if ( LA36_0==EOL||LA36_0==24||LA36_0==29||LA36_0==31||LA36_0==33||(LA36_0>=35 && LA36_0<=40) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("534:50: ( \';\' )?", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:534:50: ';'
                            {
                            match(input,15,FOLLOW_15_in_auto_focus1092); 

                            }
                            break;

                    }

                    following.push(FOLLOW_opt_eol_in_auto_focus1095);
                    opt_eol();
                    following.pop();


                    				d = new AttributeDescr( "auto-focus", "true" );
                    				d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
                    			

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:541:17: (loc= 'auto-focus' t= BOOL opt_eol ( ';' )? opt_eol )
                    {
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:541:17: (loc= 'auto-focus' t= BOOL opt_eol ( ';' )? opt_eol )
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:542:25: loc= 'auto-focus' t= BOOL opt_eol ( ';' )? opt_eol
                    {
                    loc=(Token)input.LT(1);
                    match(input,37,FOLLOW_37_in_auto_focus1120); 
                    t=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_auto_focus1124); 
                    following.push(FOLLOW_opt_eol_in_auto_focus1126);
                    opt_eol();
                    following.pop();

                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:542:57: ( ';' )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);
                    if ( LA37_0==15 ) {
                        alt37=1;
                    }
                    else if ( LA37_0==EOL||LA37_0==24||LA37_0==29||LA37_0==31||LA37_0==33||(LA37_0>=35 && LA37_0<=40) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("542:57: ( \';\' )?", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:542:57: ';'
                            {
                            match(input,15,FOLLOW_15_in_auto_focus1128); 

                            }
                            break;

                    }

                    following.push(FOLLOW_opt_eol_in_auto_focus1131);
                    opt_eol();
                    following.pop();


                    				d = new AttributeDescr( "auto-focus", t.getText() );
                    				d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
                    			

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
        return d;
    }
    // $ANTLR end auto_focus


    // $ANTLR start activation_group
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:552:1: activation_group returns [AttributeDescr d] : loc= 'activation-group' opt_eol name= STRING ( ';' )? opt_eol ;
    public AttributeDescr activation_group() throws RecognitionException {   
        AttributeDescr d;
        Token loc=null;
        Token name=null;


        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:557:17: (loc= 'activation-group' opt_eol name= STRING ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:557:17: loc= 'activation-group' opt_eol name= STRING ( ';' )? opt_eol
            {
            loc=(Token)input.LT(1);
            match(input,38,FOLLOW_38_in_activation_group1173); 
            following.push(FOLLOW_opt_eol_in_activation_group1175);
            opt_eol();
            following.pop();

            name=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_activation_group1179); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:557:60: ( ';' )?
            int alt39=2;
            int LA39_0 = input.LA(1);
            if ( LA39_0==15 ) {
                alt39=1;
            }
            else if ( LA39_0==EOL||LA39_0==24||LA39_0==29||LA39_0==31||LA39_0==33||(LA39_0>=35 && LA39_0<=40) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("557:60: ( \';\' )?", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:557:60: ';'
                    {
                    match(input,15,FOLLOW_15_in_activation_group1181); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_activation_group1184);
            opt_eol();
            following.pop();


            			d = new AttributeDescr( "activation-group", getString( name ) );
            			d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		

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
    // $ANTLR end activation_group


    // $ANTLR start agenda_group
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:564:1: agenda_group returns [AttributeDescr d] : loc= 'agenda-group' opt_eol name= STRING ( ';' )? opt_eol ;
    public AttributeDescr agenda_group() throws RecognitionException {   
        AttributeDescr d;
        Token loc=null;
        Token name=null;


        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:569:17: (loc= 'agenda-group' opt_eol name= STRING ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:569:17: loc= 'agenda-group' opt_eol name= STRING ( ';' )? opt_eol
            {
            loc=(Token)input.LT(1);
            match(input,39,FOLLOW_39_in_agenda_group1213); 
            following.push(FOLLOW_opt_eol_in_agenda_group1215);
            opt_eol();
            following.pop();

            name=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_agenda_group1219); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:569:56: ( ';' )?
            int alt40=2;
            int LA40_0 = input.LA(1);
            if ( LA40_0==15 ) {
                alt40=1;
            }
            else if ( LA40_0==EOL||LA40_0==24||LA40_0==29||LA40_0==31||LA40_0==33||(LA40_0>=35 && LA40_0<=40) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("569:56: ( \';\' )?", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:569:56: ';'
                    {
                    match(input,15,FOLLOW_15_in_agenda_group1221); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_agenda_group1224);
            opt_eol();
            following.pop();


            			d = new AttributeDescr( "agenda-group", getString( name ) );
            			d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		

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
    // $ANTLR end agenda_group


    // $ANTLR start duration
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:577:1: duration returns [AttributeDescr d] : loc= 'duration' opt_eol i= INT ( ';' )? opt_eol ;
    public AttributeDescr duration() throws RecognitionException {   
        AttributeDescr d;
        Token loc=null;
        Token i=null;


        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:582:17: (loc= 'duration' opt_eol i= INT ( ';' )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:582:17: loc= 'duration' opt_eol i= INT ( ';' )? opt_eol
            {
            loc=(Token)input.LT(1);
            match(input,40,FOLLOW_40_in_duration1256); 
            following.push(FOLLOW_opt_eol_in_duration1258);
            opt_eol();
            following.pop();

            i=(Token)input.LT(1);
            match(input,INT,FOLLOW_INT_in_duration1262); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:582:46: ( ';' )?
            int alt41=2;
            int LA41_0 = input.LA(1);
            if ( LA41_0==15 ) {
                alt41=1;
            }
            else if ( LA41_0==EOL||LA41_0==24||LA41_0==29||LA41_0==31||LA41_0==33||(LA41_0>=35 && LA41_0<=40) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("582:46: ( \';\' )?", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:582:46: ';'
                    {
                    match(input,15,FOLLOW_15_in_duration1264); 

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_duration1267);
            opt_eol();
            following.pop();


            			d = new AttributeDescr( "duration", i.getText() );
            			d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		

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
    // $ANTLR end duration


    // $ANTLR start normal_lhs_block
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:590:1: normal_lhs_block[AndDescr descrs] : (d= lhs opt_eol )* opt_eol ;
    public void normal_lhs_block(AndDescr descrs) throws RecognitionException {   
        PatternDescr d = null;


        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:592:17: ( (d= lhs opt_eol )* opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:592:17: (d= lhs opt_eol )* opt_eol
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:592:17: (d= lhs opt_eol )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);
                if ( LA42_0==ID||LA42_0==23||(LA42_0>=56 && LA42_0<=58) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:592:25: d= lhs opt_eol
            	    {
            	    following.push(FOLLOW_lhs_in_normal_lhs_block1293);
            	    d=lhs();
            	    following.pop();

            	    following.push(FOLLOW_opt_eol_in_normal_lhs_block1295);
            	    opt_eol();
            	    following.pop();

            	     descrs.addDescr( d ); 

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            following.push(FOLLOW_opt_eol_in_normal_lhs_block1307);
            opt_eol();
            following.pop();


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


    // $ANTLR start expander_lhs_block
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:600:1: expander_lhs_block[AndDescr descrs] : ( options {greedy=false; } : text= paren_chunk loc= EOL )* ;
    public void expander_lhs_block(AndDescr descrs) throws RecognitionException {   
        Token loc=null;
        String text = null;



        		String lhsBlock = null;
        		String eol = System.getProperty( "line.separator" );
        		List constraints = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:607:17: ( ( options {greedy=false; } : text= paren_chunk loc= EOL )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:607:17: ( options {greedy=false; } : text= paren_chunk loc= EOL )*
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:607:17: ( options {greedy=false; } : text= paren_chunk loc= EOL )*
            loop43:
            do {
                int alt43=2;
                switch ( input.LA(1) ) {
                case 29:
                    alt43=2;
                    break;
                case EOL:
                    alt43=2;
                    break;
                case 33:
                    alt43=2;
                    break;
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    alt43=1;
                    break;
                case 15:
                    alt43=2;
                    break;

                }

                switch (alt43) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:608:25: text= paren_chunk loc= EOL
            	    {
            	    following.push(FOLLOW_paren_chunk_in_expander_lhs_block1348);
            	    text=paren_chunk();
            	    following.pop();

            	    loc=(Token)input.LT(1);
            	    match(input,EOL,FOLLOW_EOL_in_expander_lhs_block1352); 

            	    				//only expand non null
            	    				if (text != null) {
            	    					if (text.trim().startsWith("-")) {
            	    						if (constraints == null) {
            	    							constraints = new ArrayList();
            	    						}
            	    						constraints.add(runWhenExpander( text, offset(loc.getLine())));
            	    					} else {
            	    						if (constraints != null) {
            	    							lhsBlock = applyConstraints(constraints, lhsBlock);
            	    							constraints = null;
            	    						}
            	    					
            	    					
            	    						if (lhsBlock == null) {					
            	    							lhsBlock = runWhenExpander( text, offset(loc.getLine()));
            	    						} else {
            	    							lhsBlock = lhsBlock + eol + runWhenExpander( text, offset(loc.getLine()));
            	    						}
            	    					}
            	    					text = null;
            	    				}
            	    			

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            	
            			//flush out any constraints left handing before the RHS
            			lhsBlock = applyConstraints(constraints, lhsBlock);
            			if (lhsBlock != null) {
            				reparseLhs(lhsBlock, descrs);
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
    // $ANTLR end expander_lhs_block


    // $ANTLR start lhs
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:649:1: lhs returns [PatternDescr d] : l= lhs_or ;
    public PatternDescr lhs() throws RecognitionException {   
        PatternDescr d;
        PatternDescr l = null;



        		d=null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:653:17: (l= lhs_or )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:653:17: l= lhs_or
            {
            following.push(FOLLOW_lhs_or_in_lhs1405);
            l=lhs_or();
            following.pop();

             d = l; 

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


    // $ANTLR start lhs_column
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:657:1: lhs_column returns [PatternDescr d] : (f= fact_binding | f= fact );
    public PatternDescr lhs_column() throws RecognitionException {   
        PatternDescr d;
        PatternDescr f = null;



        		d=null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:661:17: (f= fact_binding | f= fact )
            int alt44=2;
            alt44 = dfa44.predict(input); 
            switch (alt44) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:661:17: f= fact_binding
                    {
                    following.push(FOLLOW_fact_binding_in_lhs_column1433);
                    f=fact_binding();
                    following.pop();

                     d = f; 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:662:17: f= fact
                    {
                    following.push(FOLLOW_fact_in_lhs_column1442);
                    f=fact();
                    following.pop();

                     d = f; 

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
    // $ANTLR end lhs_column


    // $ANTLR start fact_binding
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:665:1: fact_binding returns [PatternDescr d] : id= ID opt_eol ':' opt_eol fe= fact_expression[id.getText()] ;
    public PatternDescr fact_binding() throws RecognitionException {   
        PatternDescr d;
        Token id=null;
        PatternDescr fe = null;



        		d=null;
        		boolean multi=false;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:671:17: (id= ID opt_eol ':' opt_eol fe= fact_expression[id.getText()] )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:671:17: id= ID opt_eol ':' opt_eol fe= fact_expression[id.getText()]
            {
            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_fact_binding1474); 
            following.push(FOLLOW_opt_eol_in_fact_binding1484);
            opt_eol();
            following.pop();

            match(input,32,FOLLOW_32_in_fact_binding1486); 
            following.push(FOLLOW_opt_eol_in_fact_binding1488);
            opt_eol();
            following.pop();

            following.push(FOLLOW_fact_expression_in_fact_binding1492);
            fe=fact_expression(id.getText());
            following.pop();


             			d=fe;
             		

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


    // $ANTLR start fact_expression
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:679:2: fact_expression[String id] returns [PatternDescr pd] : ( '(' opt_eol fe= fact_expression[id] opt_eol ')' | f= fact opt_eol ( ('or'|'||') opt_eol f= fact )* );
    public PatternDescr fact_expression(String id) throws RecognitionException {   
        PatternDescr pd;
        PatternDescr fe = null;

        PatternDescr f = null;



         		pd = null;
         		boolean multi = false;
         	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:684:17: ( '(' opt_eol fe= fact_expression[id] opt_eol ')' | f= fact opt_eol ( ('or'|'||') opt_eol f= fact )* )
            int alt46=2;
            int LA46_0 = input.LA(1);
            if ( LA46_0==23 ) {
                alt46=1;
            }
            else if ( LA46_0==ID ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("679:2: fact_expression[String id] returns [PatternDescr pd] : ( \'(\' opt_eol fe= fact_expression[id] opt_eol \')\' | f= fact opt_eol ( (\'or\'|\'||\') opt_eol f= fact )* );", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:684:17: '(' opt_eol fe= fact_expression[id] opt_eol ')'
                    {
                    match(input,23,FOLLOW_23_in_fact_expression1524); 
                    following.push(FOLLOW_opt_eol_in_fact_expression1526);
                    opt_eol();
                    following.pop();

                    following.push(FOLLOW_fact_expression_in_fact_expression1530);
                    fe=fact_expression(id);
                    following.pop();

                    following.push(FOLLOW_opt_eol_in_fact_expression1532);
                    opt_eol();
                    following.pop();

                    match(input,25,FOLLOW_25_in_fact_expression1534); 
                     pd=fe; 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:685:17: f= fact opt_eol ( ('or'|'||') opt_eol f= fact )*
                    {
                    following.push(FOLLOW_fact_in_fact_expression1545);
                    f=fact();
                    following.pop();

                    following.push(FOLLOW_opt_eol_in_fact_expression1547);
                    opt_eol();
                    following.pop();


                     			((ColumnDescr)f).setIdentifier( id );
                     			pd = f;
                     		
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:690:17: ( ('or'|'||') opt_eol f= fact )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);
                        if ( (LA45_0>=41 && LA45_0<=42) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:690:25: ('or'|'||') opt_eol f= fact
                    	    {
                    	    if ( (input.LA(1)>=41 && input.LA(1)<=42) ) {
                    	        input.consume();
                    	        errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_fact_expression1560);    throw mse;
                    	    }

                    	    following.push(FOLLOW_opt_eol_in_fact_expression1565);
                    	    opt_eol();
                    	    following.pop();

                    	    	if ( ! multi ) {
                    	     					PatternDescr first = pd;
                    	     					pd = new OrDescr();
                    	     					((OrDescr)pd).addDescr( first );
                    	     					multi=true;
                    	     				}
                    	     			
                    	    following.push(FOLLOW_fact_in_fact_expression1579);
                    	    f=fact();
                    	    following.pop();


                    	     				((ColumnDescr)f).setIdentifier( id );
                    	     				((OrDescr)pd).addDescr( f );
                    	     			

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
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
        return pd;
    }
    // $ANTLR end fact_expression


    // $ANTLR start fact
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:706:1: fact returns [PatternDescr d] : id= dotted_name opt_eol loc= '(' opt_eol (c= constraints )? opt_eol endLoc= ')' opt_eol ;
    public PatternDescr fact() throws RecognitionException {   
        PatternDescr d;
        Token loc=null;
        Token endLoc=null;
        String id = null;

        List c = null;



        		d=null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:710:17: (id= dotted_name opt_eol loc= '(' opt_eol (c= constraints )? opt_eol endLoc= ')' opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:710:17: id= dotted_name opt_eol loc= '(' opt_eol (c= constraints )? opt_eol endLoc= ')' opt_eol
            {
            following.push(FOLLOW_dotted_name_in_fact1618);
            id=dotted_name();
            following.pop();

             
             			d = new ColumnDescr( id ); 
             		
            following.push(FOLLOW_opt_eol_in_fact1626);
            opt_eol();
            following.pop();

            loc=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_fact1634); 

             				d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
             			
            following.push(FOLLOW_opt_eol_in_fact1637);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:716:34: (c= constraints )?
            int alt47=2;
            alt47 = dfa47.predict(input); 
            switch (alt47) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:716:41: c= constraints
                    {
                    following.push(FOLLOW_constraints_in_fact1643);
                    c=constraints();
                    following.pop();


                    		 			for ( Iterator cIter = c.iterator() ; cIter.hasNext() ; ) {
                     						((ColumnDescr)d).addDescr( (PatternDescr) cIter.next() );
                     					}
                     				

                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_fact1662);
            opt_eol();
            following.pop();

            endLoc=(Token)input.LT(1);
            match(input,25,FOLLOW_25_in_fact1666); 
            following.push(FOLLOW_opt_eol_in_fact1668);
            opt_eol();
            following.pop();


             					d.setEndLocation( offset(endLoc.getLine()), endLoc.getCharPositionInLine() );	
             				

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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:730:1: constraints returns [List constraints] : opt_eol ( constraint[constraints] | predicate[constraints] ) ( opt_eol ',' opt_eol ( constraint[constraints] | predicate[constraints] ) )* opt_eol ;
    public List constraints() throws RecognitionException {   
        List constraints;

        		constraints = new ArrayList();
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:734:17: ( opt_eol ( constraint[constraints] | predicate[constraints] ) ( opt_eol ',' opt_eol ( constraint[constraints] | predicate[constraints] ) )* opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:734:17: opt_eol ( constraint[constraints] | predicate[constraints] ) ( opt_eol ',' opt_eol ( constraint[constraints] | predicate[constraints] ) )* opt_eol
            {
            following.push(FOLLOW_opt_eol_in_constraints1700);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:735:17: ( constraint[constraints] | predicate[constraints] )
            int alt48=2;
            int LA48_0 = input.LA(1);
            if ( LA48_0==EOL||LA48_0==15 ) {
                alt48=1;
            }
            else if ( LA48_0==ID ) {
                int LA48_2 = input.LA(2);
                if ( LA48_2==32 ) {
                    int LA48_3 = input.LA(3);
                    if ( LA48_3==ID ) {
                        int LA48_8 = input.LA(4);
                        if ( LA48_8==53 ) {
                            alt48=2;
                        }
                        else if ( LA48_8==EOL||LA48_8==15||(LA48_8>=24 && LA48_8<=25)||(LA48_8>=43 && LA48_8<=51) ) {
                            alt48=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("735:17: ( constraint[constraints] | predicate[constraints] )", 48, 8, input);

                            throw nvae;
                        }
                    }
                    else if ( LA48_3==EOL||LA48_3==15 ) {
                        alt48=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("735:17: ( constraint[constraints] | predicate[constraints] )", 48, 3, input);

                        throw nvae;
                    }
                }
                else if ( LA48_2==EOL||LA48_2==15||(LA48_2>=24 && LA48_2<=25)||(LA48_2>=43 && LA48_2<=51) ) {
                    alt48=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("735:17: ( constraint[constraints] | predicate[constraints] )", 48, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("735:17: ( constraint[constraints] | predicate[constraints] )", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:735:18: constraint[constraints]
                    {
                    following.push(FOLLOW_constraint_in_constraints1705);
                    constraint(constraints);
                    following.pop();


                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:735:42: predicate[constraints]
                    {
                    following.push(FOLLOW_predicate_in_constraints1708);
                    predicate(constraints);
                    following.pop();


                    }
                    break;

            }

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:736:17: ( opt_eol ',' opt_eol ( constraint[constraints] | predicate[constraints] ) )*
            loop50:
            do {
                int alt50=2;
                alt50 = dfa50.predict(input); 
                switch (alt50) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:736:19: opt_eol ',' opt_eol ( constraint[constraints] | predicate[constraints] )
            	    {
            	    following.push(FOLLOW_opt_eol_in_constraints1716);
            	    opt_eol();
            	    following.pop();

            	    match(input,24,FOLLOW_24_in_constraints1718); 
            	    following.push(FOLLOW_opt_eol_in_constraints1720);
            	    opt_eol();
            	    following.pop();

            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:736:39: ( constraint[constraints] | predicate[constraints] )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);
            	    if ( LA49_0==EOL||LA49_0==15 ) {
            	        alt49=1;
            	    }
            	    else if ( LA49_0==ID ) {
            	        int LA49_2 = input.LA(2);
            	        if ( LA49_2==32 ) {
            	            int LA49_3 = input.LA(3);
            	            if ( LA49_3==ID ) {
            	                int LA49_8 = input.LA(4);
            	                if ( LA49_8==53 ) {
            	                    alt49=2;
            	                }
            	                else if ( LA49_8==EOL||LA49_8==15||(LA49_8>=24 && LA49_8<=25)||(LA49_8>=43 && LA49_8<=51) ) {
            	                    alt49=1;
            	                }
            	                else {
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("736:39: ( constraint[constraints] | predicate[constraints] )", 49, 8, input);

            	                    throw nvae;
            	                }
            	            }
            	            else if ( LA49_3==EOL||LA49_3==15 ) {
            	                alt49=1;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("736:39: ( constraint[constraints] | predicate[constraints] )", 49, 3, input);

            	                throw nvae;
            	            }
            	        }
            	        else if ( LA49_2==EOL||LA49_2==15||(LA49_2>=24 && LA49_2<=25)||(LA49_2>=43 && LA49_2<=51) ) {
            	            alt49=1;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("736:39: ( constraint[constraints] | predicate[constraints] )", 49, 2, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("736:39: ( constraint[constraints] | predicate[constraints] )", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:736:40: constraint[constraints]
            	            {
            	            following.push(FOLLOW_constraint_in_constraints1723);
            	            constraint(constraints);
            	            following.pop();


            	            }
            	            break;
            	        case 2 :
            	            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:736:64: predicate[constraints]
            	            {
            	            following.push(FOLLOW_predicate_in_constraints1726);
            	            predicate(constraints);
            	            following.pop();


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            following.push(FOLLOW_opt_eol_in_constraints1734);
            opt_eol();
            following.pop();


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return constraints;
    }
    // $ANTLR end constraints


    // $ANTLR start constraint
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:740:1: constraint[List constraints] : opt_eol (fb= ID opt_eol ':' opt_eol )? f= ID opt_eol (op= ('=='|'>'|'>='|'<'|'<='|'!='|'contains'|'matches'|'excludes') opt_eol (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint ) )? opt_eol ;
    public void constraint(List constraints) throws RecognitionException {   
        Token fb=null;
        Token f=null;
        Token op=null;
        Token bvc=null;
        String lc = null;

        String rvc = null;



        		PatternDescr d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:744:17: ( opt_eol (fb= ID opt_eol ':' opt_eol )? f= ID opt_eol (op= ('=='|'>'|'>='|'<'|'<='|'!='|'contains'|'matches'|'excludes') opt_eol (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint ) )? opt_eol )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:744:17: opt_eol (fb= ID opt_eol ':' opt_eol )? f= ID opt_eol (op= ('=='|'>'|'>='|'<'|'<='|'!='|'contains'|'matches'|'excludes') opt_eol (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint ) )? opt_eol
            {
            following.push(FOLLOW_opt_eol_in_constraint1753);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:745:17: (fb= ID opt_eol ':' opt_eol )?
            int alt51=2;
            alt51 = dfa51.predict(input); 
            switch (alt51) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:745:19: fb= ID opt_eol ':' opt_eol
                    {
                    fb=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_constraint1761); 
                    following.push(FOLLOW_opt_eol_in_constraint1763);
                    opt_eol();
                    following.pop();

                    match(input,32,FOLLOW_32_in_constraint1765); 
                    following.push(FOLLOW_opt_eol_in_constraint1767);
                    opt_eol();
                    following.pop();


                    }
                    break;

            }

            f=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_constraint1777); 

            			if ( fb != null ) {
            				//System.err.println( "fb: " + fb.getText() );
            				//System.err.println( " f: " + f.getText() );
            				d = new FieldBindingDescr( f.getText(), fb.getText() );
            				//System.err.println( "fbd: " + d );
            				
            				d.setLocation( offset(f.getLine()), f.getCharPositionInLine() );
            				constraints.add( d );
            			} 
            		
            following.push(FOLLOW_opt_eol_in_constraint1787);
            opt_eol();
            following.pop();

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:758:33: (op= ('=='|'>'|'>='|'<'|'<='|'!='|'contains'|'matches'|'excludes') opt_eol (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);
            if ( (LA53_0>=43 && LA53_0<=51) ) {
                alt53=1;
            }
            else if ( LA53_0==EOL||LA53_0==15||(LA53_0>=24 && LA53_0<=25) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("758:33: (op= (\'==\'|\'>\'|\'>=\'|\'<\'|\'<=\'|\'!=\'|\'contains\'|\'matches\'|\'excludes\') opt_eol (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint ) )?", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:758:41: op= ('=='|'>'|'>='|'<'|'<='|'!='|'contains'|'matches'|'excludes') opt_eol (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint )
                    {
                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=43 && input.LA(1)<=51) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_constraint1795);    throw mse;
                    }

                    following.push(FOLLOW_opt_eol_in_constraint1882);
                    opt_eol();
                    following.pop();

                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:769:41: (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint )
                    int alt52=4;
                    switch ( input.LA(1) ) {
                    case ID:
                        int LA52_1 = input.LA(2);
                        if ( LA52_1==18 ) {
                            alt52=2;
                        }
                        else if ( LA52_1==EOL||LA52_1==15||(LA52_1>=24 && LA52_1<=25) ) {
                            alt52=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("769:41: (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint )", 52, 1, input);

                            throw nvae;
                        }
                        break;
                    case INT:
                    case BOOL:
                    case STRING:
                    case FLOAT:
                    case 52:
                        alt52=3;
                        break;
                    case 23:
                        alt52=4;
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("769:41: (bvc= ID | lc= enum_constraint | lc= literal_constraint | rvc= retval_constraint )", 52, 0, input);

                        throw nvae;
                    }

                    switch (alt52) {
                        case 1 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:769:49: bvc= ID
                            {
                            bvc=(Token)input.LT(1);
                            match(input,ID,FOLLOW_ID_in_constraint1900); 

                            							d = new BoundVariableDescr( f.getText(), op.getText(), bvc.getText() );
                            							d.setLocation( offset(f.getLine()), f.getCharPositionInLine() );
                            							constraints.add( d );
                            						

                            }
                            break;
                        case 2 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:776:49: lc= enum_constraint
                            {
                            following.push(FOLLOW_enum_constraint_in_constraint1925);
                            lc=enum_constraint();
                            following.pop();

                             
                            							d = new LiteralDescr( f.getText(), op.getText(), lc, true ); 
                            							d.setLocation( offset(f.getLine()), f.getCharPositionInLine() );
                            							constraints.add( d );
                            						

                            }
                            break;
                        case 3 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:783:49: lc= literal_constraint
                            {
                            following.push(FOLLOW_literal_constraint_in_constraint1957);
                            lc=literal_constraint();
                            following.pop();

                             
                            							d = new LiteralDescr( f.getText(), op.getText(), lc ); 
                            							d.setLocation( offset(f.getLine()), f.getCharPositionInLine() );
                            							constraints.add( d );
                            						

                            }
                            break;
                        case 4 :
                            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:789:49: rvc= retval_constraint
                            {
                            following.push(FOLLOW_retval_constraint_in_constraint1977);
                            rvc=retval_constraint();
                            following.pop();

                             
                            							d = new ReturnValueDescr( f.getText(), op.getText(), rvc ); 
                            							d.setLocation( offset(f.getLine()), f.getCharPositionInLine() );
                            							constraints.add( d );
                            						

                            }
                            break;

                    }


                    }
                    break;

            }

            following.push(FOLLOW_opt_eol_in_constraint2010);
            opt_eol();
            following.pop();


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


    // $ANTLR start literal_constraint
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:800:1: literal_constraint returns [String text] : (t= STRING | t= INT | t= FLOAT | t= BOOL | t= 'null' ) ;
    public String literal_constraint() throws RecognitionException {   
        String text;
        Token t=null;


        		text = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:804:17: ( (t= STRING | t= INT | t= FLOAT | t= BOOL | t= 'null' ) )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:804:17: (t= STRING | t= INT | t= FLOAT | t= BOOL | t= 'null' )
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:804:17: (t= STRING | t= INT | t= FLOAT | t= BOOL | t= 'null' )
            int alt54=5;
            switch ( input.LA(1) ) {
            case STRING:
                alt54=1;
                break;
            case INT:
                alt54=2;
                break;
            case FLOAT:
                alt54=3;
                break;
            case BOOL:
                alt54=4;
                break;
            case 52:
                alt54=5;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("804:17: (t= STRING | t= INT | t= FLOAT | t= BOOL | t= \'null\' )", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:804:25: t= STRING
                    {
                    t=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_literal_constraint2037); 
                     text = getString( t ); 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:805:25: t= INT
                    {
                    t=(Token)input.LT(1);
                    match(input,INT,FOLLOW_INT_in_literal_constraint2048); 
                     text = t.getText(); 

                    }
                    break;
                case 3 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:806:25: t= FLOAT
                    {
                    t=(Token)input.LT(1);
                    match(input,FLOAT,FOLLOW_FLOAT_in_literal_constraint2061); 
                     text = t.getText(); 

                    }
                    break;
                case 4 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:807:25: t= BOOL
                    {
                    t=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_literal_constraint2072); 
                     text = t.getText(); 

                    }
                    break;
                case 5 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:808:25: t= 'null'
                    {
                    t=(Token)input.LT(1);
                    match(input,52,FOLLOW_52_in_literal_constraint2084); 
                     text = null; 

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


    // $ANTLR start enum_constraint
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:812:1: enum_constraint returns [String text] : (cls= ID '.' en= ID ) ;
    public String enum_constraint() throws RecognitionException {   
        String text;
        Token cls=null;
        Token en=null;


        		text = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:816:17: ( (cls= ID '.' en= ID ) )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:816:17: (cls= ID '.' en= ID )
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:816:17: (cls= ID '.' en= ID )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:816:18: cls= ID '.' en= ID
            {
            cls=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_enum_constraint2115); 
            match(input,18,FOLLOW_18_in_enum_constraint2117); 
            en=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_enum_constraint2121); 

            }

             text = cls.getText() + "." + en.getText(); 

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
    // $ANTLR end enum_constraint


    // $ANTLR start retval_constraint
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:819:1: retval_constraint returns [String text] : '(' c= paren_chunk ')' ;
    public String retval_constraint() throws RecognitionException {   
        String text;
        String c = null;



        		text = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:824:17: ( '(' c= paren_chunk ')' )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:824:17: '(' c= paren_chunk ')'
            {
            match(input,23,FOLLOW_23_in_retval_constraint2150); 
            following.push(FOLLOW_paren_chunk_in_retval_constraint2155);
            c=paren_chunk();
            following.pop();

            match(input,25,FOLLOW_25_in_retval_constraint2158); 
             text = c; 

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
    // $ANTLR end retval_constraint


    // $ANTLR start predicate
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:827:1: predicate[List constraints] : decl= ID ':' field= ID '->' '(' text= paren_chunk ')' ;
    public void predicate(List constraints) throws RecognitionException {   
        Token decl=null;
        Token field=null;
        String text = null;


        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:829:17: (decl= ID ':' field= ID '->' '(' text= paren_chunk ')' )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:829:17: decl= ID ':' field= ID '->' '(' text= paren_chunk ')'
            {
            decl=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_predicate2176); 
            match(input,32,FOLLOW_32_in_predicate2178); 
            field=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_predicate2182); 
            match(input,53,FOLLOW_53_in_predicate2184); 
            match(input,23,FOLLOW_23_in_predicate2186); 
            following.push(FOLLOW_paren_chunk_in_predicate2190);
            text=paren_chunk();
            following.pop();

            match(input,25,FOLLOW_25_in_predicate2192); 

            			PredicateDescr d = new PredicateDescr(field.getText(), decl.getText(), text );
            			constraints.add( d );
            		

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


    // $ANTLR start paren_chunk
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:836:1: paren_chunk returns [String text] : ( options {greedy=false; } : '(' c= paren_chunk ')' | any= . )* ;
    public String paren_chunk() throws RecognitionException {   
        String text;
        Token any=null;
        String c = null;



        		text = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:842:18: ( ( options {greedy=false; } : '(' c= paren_chunk ')' | any= . )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:842:18: ( options {greedy=false; } : '(' c= paren_chunk ')' | any= . )*
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:842:18: ( options {greedy=false; } : '(' c= paren_chunk ')' | any= . )*
            loop55:
            do {
                int alt55=3;
                switch ( input.LA(1) ) {
                case EOL:
                    alt55=3;
                    break;
                case 25:
                    alt55=3;
                    break;
                case 23:
                    alt55=1;
                    break;
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    alt55=2;
                    break;

                }

                switch (alt55) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:843:25: '(' c= paren_chunk ')'
            	    {
            	    match(input,23,FOLLOW_23_in_paren_chunk2238); 
            	    following.push(FOLLOW_paren_chunk_in_paren_chunk2242);
            	    c=paren_chunk();
            	    following.pop();

            	    match(input,25,FOLLOW_25_in_paren_chunk2244); 

            	    				if ( c == null ) {
            	    					c = "";
            	    				}
            	    				if ( text == null ) {
            	    					text = "( " + c + " )";
            	    				} else {
            	    					text = text + " ( " + c + " )";
            	    				}
            	    			

            	    }
            	    break;
            	case 2 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:854:19: any= .
            	    {
            	    any=(Token)input.LT(1);
            	    matchAny(input); 

            	    				if ( text == null ) {
            	    					text = any.getText();
            	    				} else {
            	    					text = text + " " + any.getText(); 
            	    				} 
            	    			

            	    }
            	    break;

            	default :
            	    break loop55;
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
        return text;
    }
    // $ANTLR end paren_chunk


    // $ANTLR start paren_chunk2
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:866:1: paren_chunk2 returns [String text] : ( options {greedy=false; } : '(' c= paren_chunk2 ')' | any= . )* ;
    public String paren_chunk2() throws RecognitionException {   
        String text;
        Token any=null;
        String c = null;



        		text = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:872:18: ( ( options {greedy=false; } : '(' c= paren_chunk2 ')' | any= . )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:872:18: ( options {greedy=false; } : '(' c= paren_chunk2 ')' | any= . )*
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:872:18: ( options {greedy=false; } : '(' c= paren_chunk2 ')' | any= . )*
            loop56:
            do {
                int alt56=3;
                switch ( input.LA(1) ) {
                case 25:
                    alt56=3;
                    break;
                case 23:
                    alt56=1;
                    break;
                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    alt56=2;
                    break;

                }

                switch (alt56) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:873:25: '(' c= paren_chunk2 ')'
            	    {
            	    match(input,23,FOLLOW_23_in_paren_chunk22315); 
            	    following.push(FOLLOW_paren_chunk2_in_paren_chunk22319);
            	    c=paren_chunk2();
            	    following.pop();

            	    match(input,25,FOLLOW_25_in_paren_chunk22321); 

            	    				if ( c == null ) {
            	    					c = "";
            	    				}
            	    				if ( text == null ) {
            	    					text = "( " + c + " )";
            	    				} else {
            	    					text = text + " ( " + c + " )";
            	    				}
            	    			

            	    }
            	    break;
            	case 2 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:884:19: any= .
            	    {
            	    any=(Token)input.LT(1);
            	    matchAny(input); 

            	    				if ( text == null ) {
            	    					text = any.getText();
            	    				} else {
            	    					text = text + " " + any.getText(); 
            	    				} 
            	    			

            	    }
            	    break;

            	default :
            	    break loop56;
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
        return text;
    }
    // $ANTLR end paren_chunk2


    // $ANTLR start curly_chunk
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:895:1: curly_chunk returns [String text] : ( options {greedy=false; } : '{' c= curly_chunk '}' | any= . )* ;
    public String curly_chunk() throws RecognitionException {   
        String text;
        Token any=null;
        String c = null;



        		text = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:901:17: ( ( options {greedy=false; } : '{' c= curly_chunk '}' | any= . )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:901:17: ( options {greedy=false; } : '{' c= curly_chunk '}' | any= . )*
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:901:17: ( options {greedy=false; } : '{' c= curly_chunk '}' | any= . )*
            loop57:
            do {
                int alt57=3;
                switch ( input.LA(1) ) {
                case 27:
                    alt57=3;
                    break;
                case 26:
                    alt57=1;
                    break;
                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    alt57=2;
                    break;

                }

                switch (alt57) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:902:25: '{' c= curly_chunk '}'
            	    {
            	    match(input,26,FOLLOW_26_in_curly_chunk2390); 
            	    following.push(FOLLOW_curly_chunk_in_curly_chunk2394);
            	    c=curly_chunk();
            	    following.pop();

            	    match(input,27,FOLLOW_27_in_curly_chunk2396); 

            	    				//System.err.println( "chunk [" + c + "]" );
            	    				if ( c == null ) {
            	    					c = "";
            	    				}
            	    				if ( text == null ) {
            	    					text = "{ " + c + " }";
            	    				} else {
            	    					text = text + " { " + c + " }";
            	    				}
            	    			

            	    }
            	    break;
            	case 2 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:914:19: any= .
            	    {
            	    any=(Token)input.LT(1);
            	    matchAny(input); 

            	    				//System.err.println( "any [" + any.getText() + "]" );
            	    				if ( text == null ) {
            	    					text = any.getText();
            	    				} else {
            	    					text = text + " " + any.getText(); 
            	    				} 
            	    			

            	    }
            	    break;

            	default :
            	    break loop57;
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
        return text;
    }
    // $ANTLR end curly_chunk


    // $ANTLR start lhs_or
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:926:1: lhs_or returns [PatternDescr d] : left= lhs_and ( ('or'|'||') opt_eol right= lhs_and )* ;
    public PatternDescr lhs_or() throws RecognitionException {   
        PatternDescr d;
        PatternDescr left = null;

        PatternDescr right = null;



        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:931:17: (left= lhs_and ( ('or'|'||') opt_eol right= lhs_and )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:931:17: left= lhs_and ( ('or'|'||') opt_eol right= lhs_and )*
            {
             OrDescr or = null; 
            following.push(FOLLOW_lhs_and_in_lhs_or2454);
            left=lhs_and();
            following.pop();

            d = left; 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:933:17: ( ('or'|'||') opt_eol right= lhs_and )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);
                if ( (LA58_0>=41 && LA58_0<=42) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:933:19: ('or'|'||') opt_eol right= lhs_and
            	    {
            	    if ( (input.LA(1)>=41 && input.LA(1)<=42) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_lhs_or2463);    throw mse;
            	    }

            	    following.push(FOLLOW_opt_eol_in_lhs_or2468);
            	    opt_eol();
            	    following.pop();

            	    following.push(FOLLOW_lhs_and_in_lhs_or2475);
            	    right=lhs_and();
            	    following.pop();


            	    				if ( or == null ) {
            	    					or = new OrDescr();
            	    					or.addDescr( left );
            	    					d = or;
            	    				}
            	    				
            	    				or.addDescr( right );
            	    			

            	    }
            	    break;

            	default :
            	    break loop58;
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
        return d;
    }
    // $ANTLR end lhs_or


    // $ANTLR start lhs_and
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:947:1: lhs_and returns [PatternDescr d] : left= lhs_unary ( ('and'|'&&') opt_eol right= lhs_unary )* ;
    public PatternDescr lhs_and() throws RecognitionException {   
        PatternDescr d;
        PatternDescr left = null;

        PatternDescr right = null;



        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:952:17: (left= lhs_unary ( ('and'|'&&') opt_eol right= lhs_unary )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:952:17: left= lhs_unary ( ('and'|'&&') opt_eol right= lhs_unary )*
            {
             AndDescr and = null; 
            following.push(FOLLOW_lhs_unary_in_lhs_and2515);
            left=lhs_unary();
            following.pop();

             d = left; 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:954:17: ( ('and'|'&&') opt_eol right= lhs_unary )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);
                if ( (LA59_0>=54 && LA59_0<=55) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:954:19: ('and'|'&&') opt_eol right= lhs_unary
            	    {
            	    if ( (input.LA(1)>=54 && input.LA(1)<=55) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_lhs_and2524);    throw mse;
            	    }

            	    following.push(FOLLOW_opt_eol_in_lhs_and2529);
            	    opt_eol();
            	    following.pop();

            	    following.push(FOLLOW_lhs_unary_in_lhs_and2536);
            	    right=lhs_unary();
            	    following.pop();


            	    				if ( and == null ) {
            	    					and = new AndDescr();
            	    					and.addDescr( left );
            	    					d = and;
            	    				}
            	    				
            	    				and.addDescr( right );
            	    			

            	    }
            	    break;

            	default :
            	    break loop59;
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
        return d;
    }
    // $ANTLR end lhs_and


    // $ANTLR start lhs_unary
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:968:1: lhs_unary returns [PatternDescr d] : (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' opt_eol u= lhs opt_eol ')' ) ;
    public PatternDescr lhs_unary() throws RecognitionException {   
        PatternDescr d;
        PatternDescr u = null;



        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:972:17: ( (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' opt_eol u= lhs opt_eol ')' ) )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:972:17: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' opt_eol u= lhs opt_eol ')' )
            {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:972:17: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' opt_eol u= lhs opt_eol ')' )
            int alt60=5;
            switch ( input.LA(1) ) {
            case 56:
                alt60=1;
                break;
            case 57:
                alt60=2;
                break;
            case 58:
                alt60=3;
                break;
            case ID:
                alt60=4;
                break;
            case 23:
                alt60=5;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("972:17: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | \'(\' opt_eol u= lhs opt_eol \')\' )", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:972:25: u= lhs_exist
                    {
                    following.push(FOLLOW_lhs_exist_in_lhs_unary2574);
                    u=lhs_exist();
                    following.pop();


                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:973:25: u= lhs_not
                    {
                    following.push(FOLLOW_lhs_not_in_lhs_unary2582);
                    u=lhs_not();
                    following.pop();


                    }
                    break;
                case 3 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:974:25: u= lhs_eval
                    {
                    following.push(FOLLOW_lhs_eval_in_lhs_unary2590);
                    u=lhs_eval();
                    following.pop();


                    }
                    break;
                case 4 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:975:25: u= lhs_column
                    {
                    following.push(FOLLOW_lhs_column_in_lhs_unary2598);
                    u=lhs_column();
                    following.pop();


                    }
                    break;
                case 5 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:976:25: '(' opt_eol u= lhs opt_eol ')'
                    {
                    match(input,23,FOLLOW_23_in_lhs_unary2604); 
                    following.push(FOLLOW_opt_eol_in_lhs_unary2606);
                    opt_eol();
                    following.pop();

                    following.push(FOLLOW_lhs_in_lhs_unary2610);
                    u=lhs();
                    following.pop();

                    following.push(FOLLOW_opt_eol_in_lhs_unary2612);
                    opt_eol();
                    following.pop();

                    match(input,25,FOLLOW_25_in_lhs_unary2614); 

                    }
                    break;

            }

             d = u; 

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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:980:1: lhs_exist returns [PatternDescr d] : loc= 'exists' ( '(' column= lhs_column ')' | column= lhs_column ) ;
    public PatternDescr lhs_exist() throws RecognitionException {   
        PatternDescr d;
        Token loc=null;
        PatternDescr column = null;



        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:984:17: (loc= 'exists' ( '(' column= lhs_column ')' | column= lhs_column ) )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:984:17: loc= 'exists' ( '(' column= lhs_column ')' | column= lhs_column )
            {
            loc=(Token)input.LT(1);
            match(input,56,FOLLOW_56_in_lhs_exist2644); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:984:30: ( '(' column= lhs_column ')' | column= lhs_column )
            int alt61=2;
            int LA61_0 = input.LA(1);
            if ( LA61_0==23 ) {
                alt61=1;
            }
            else if ( LA61_0==ID ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("984:30: ( \'(\' column= lhs_column \')\' | column= lhs_column )", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:984:31: '(' column= lhs_column ')'
                    {
                    match(input,23,FOLLOW_23_in_lhs_exist2647); 
                    following.push(FOLLOW_lhs_column_in_lhs_exist2651);
                    column=lhs_column();
                    following.pop();

                    match(input,25,FOLLOW_25_in_lhs_exist2653); 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:984:59: column= lhs_column
                    {
                    following.push(FOLLOW_lhs_column_in_lhs_exist2659);
                    column=lhs_column();
                    following.pop();


                    }
                    break;

            }

             
            			d = new ExistsDescr( (ColumnDescr) column ); 
            			d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		

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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:991:1: lhs_not returns [NotDescr d] : loc= 'not' ( '(' column= lhs_column ')' | column= lhs_column ) ;
    public NotDescr lhs_not() throws RecognitionException {   
        NotDescr d;
        Token loc=null;
        PatternDescr column = null;



        		d = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:995:17: (loc= 'not' ( '(' column= lhs_column ')' | column= lhs_column ) )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:995:17: loc= 'not' ( '(' column= lhs_column ')' | column= lhs_column )
            {
            loc=(Token)input.LT(1);
            match(input,57,FOLLOW_57_in_lhs_not2689); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:995:27: ( '(' column= lhs_column ')' | column= lhs_column )
            int alt62=2;
            int LA62_0 = input.LA(1);
            if ( LA62_0==23 ) {
                alt62=1;
            }
            else if ( LA62_0==ID ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("995:27: ( \'(\' column= lhs_column \')\' | column= lhs_column )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:995:28: '(' column= lhs_column ')'
                    {
                    match(input,23,FOLLOW_23_in_lhs_not2692); 
                    following.push(FOLLOW_lhs_column_in_lhs_not2696);
                    column=lhs_column();
                    following.pop();

                    match(input,25,FOLLOW_25_in_lhs_not2699); 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:995:57: column= lhs_column
                    {
                    following.push(FOLLOW_lhs_column_in_lhs_not2705);
                    column=lhs_column();
                    following.pop();


                    }
                    break;

            }


            			d = new NotDescr( (ColumnDescr) column ); 
            			d.setLocation( offset(loc.getLine()), loc.getCharPositionInLine() );
            		

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
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1002:1: lhs_eval returns [PatternDescr d] : 'eval' loc= '(' c= paren_chunk2 ')' ;
    public PatternDescr lhs_eval() throws RecognitionException {   
        PatternDescr d;
        Token loc=null;
        String c = null;



        		d = null;
        		String text = "";
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1007:17: ( 'eval' loc= '(' c= paren_chunk2 ')' )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1007:17: 'eval' loc= '(' c= paren_chunk2 ')'
            {
            match(input,58,FOLLOW_58_in_lhs_eval2731); 
            loc=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_lhs_eval2735); 
            following.push(FOLLOW_paren_chunk2_in_lhs_eval2743);
            c=paren_chunk2();
            following.pop();

            match(input,25,FOLLOW_25_in_lhs_eval2747); 
             
            			checkTrailingSemicolon( c, offset(loc.getLine()) );
            			d = new EvalDescr( c ); 
            		

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


    // $ANTLR start dotted_name
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1016:1: dotted_name returns [String name] : id= ID ( '.' id= ID )* ( '[' ']' )* ;
    public String dotted_name() throws RecognitionException {   
        String name;
        Token id=null;


        		name = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1021:17: (id= ID ( '.' id= ID )* ( '[' ']' )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1021:17: id= ID ( '.' id= ID )* ( '[' ']' )*
            {
            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_dotted_name2779); 
             name=id.getText(); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1021:46: ( '.' id= ID )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);
                if ( LA63_0==18 ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1021:48: '.' id= ID
            	    {
            	    match(input,18,FOLLOW_18_in_dotted_name2785); 
            	    id=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_dotted_name2789); 
            	     name = name + "." + id.getText(); 

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1021:99: ( '[' ']' )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);
                if ( LA64_0==59 ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1021:101: '[' ']'
            	    {
            	    match(input,59,FOLLOW_59_in_dotted_name2798); 
            	    match(input,60,FOLLOW_60_in_dotted_name2800); 
            	     name = name + "[]";

            	    }
            	    break;

            	default :
            	    break loop64;
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
    // $ANTLR end dotted_name


    // $ANTLR start argument
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1024:1: argument returns [String name] : id= ID ( '[' ']' )* ;
    public String argument() throws RecognitionException {   
        String name;
        Token id=null;


        		name = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1029:17: (id= ID ( '[' ']' )* )
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1029:17: id= ID ( '[' ']' )*
            {
            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_argument2830); 
             name=id.getText(); 
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1029:46: ( '[' ']' )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);
                if ( LA65_0==59 ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1029:48: '[' ']'
            	    {
            	    match(input,59,FOLLOW_59_in_argument2836); 
            	    match(input,60,FOLLOW_60_in_argument2838); 
            	     name = name + "[]";

            	    }
            	    break;

            	default :
            	    break loop65;
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


    // $ANTLR start word
    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1033:1: word returns [String word] : (id= ID | 'import' | 'use' | 'rule' | 'query' | 'salience' | 'no-loop' | 'when' | 'then' | 'end' | str= STRING );
    public String word() throws RecognitionException {   
        String word;
        Token id=null;
        Token str=null;


        		word = null;
        	
        try {
            // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1037:17: (id= ID | 'import' | 'use' | 'rule' | 'query' | 'salience' | 'no-loop' | 'when' | 'then' | 'end' | str= STRING )
            int alt66=11;
            switch ( input.LA(1) ) {
            case ID:
                alt66=1;
                break;
            case 17:
                alt66=2;
                break;
            case 61:
                alt66=3;
                break;
            case 30:
                alt66=4;
                break;
            case 28:
                alt66=5;
                break;
            case 35:
                alt66=6;
                break;
            case 36:
                alt66=7;
                break;
            case 31:
                alt66=8;
                break;
            case 33:
                alt66=9;
                break;
            case 29:
                alt66=10;
                break;
            case STRING:
                alt66=11;
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1033:1: word returns [String word] : (id= ID | \'import\' | \'use\' | \'rule\' | \'query\' | \'salience\' | \'no-loop\' | \'when\' | \'then\' | \'end\' | str= STRING );", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1037:17: id= ID
                    {
                    id=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_word2866); 
                     word=id.getText(); 

                    }
                    break;
                case 2 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1038:17: 'import'
                    {
                    match(input,17,FOLLOW_17_in_word2878); 
                     word="import"; 

                    }
                    break;
                case 3 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1039:17: 'use'
                    {
                    match(input,61,FOLLOW_61_in_word2887); 
                     word="use"; 

                    }
                    break;
                case 4 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1040:17: 'rule'
                    {
                    match(input,30,FOLLOW_30_in_word2899); 
                     word="rule"; 

                    }
                    break;
                case 5 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1041:17: 'query'
                    {
                    match(input,28,FOLLOW_28_in_word2910); 
                     word="query"; 

                    }
                    break;
                case 6 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1042:17: 'salience'
                    {
                    match(input,35,FOLLOW_35_in_word2920); 
                     word="salience"; 

                    }
                    break;
                case 7 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1043:17: 'no-loop'
                    {
                    match(input,36,FOLLOW_36_in_word2928); 
                     word="no-loop"; 

                    }
                    break;
                case 8 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1044:17: 'when'
                    {
                    match(input,31,FOLLOW_31_in_word2936); 
                     word="when"; 

                    }
                    break;
                case 9 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1045:17: 'then'
                    {
                    match(input,33,FOLLOW_33_in_word2947); 
                     word="then"; 

                    }
                    break;
                case 10 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1046:17: 'end'
                    {
                    match(input,29,FOLLOW_29_in_word2958); 
                     word="end"; 

                    }
                    break;
                case 11 :
                    // /home/michael/projects/jboss-rules-3.0.x/drools-compiler/src/main/resources/org/drools/lang/drl.g:1047:17: str= STRING
                    {
                    str=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_word2972); 
                     word=getString(str);

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
        return word;
    }
    // $ANTLR end word


    protected DFA2 dfa2 = new DFA2();protected DFA4 dfa4 = new DFA4();protected DFA12 dfa12 = new DFA12();protected DFA13 dfa13 = new DFA13();protected DFA14 dfa14 = new DFA14();protected DFA44 dfa44 = new DFA44();protected DFA47 dfa47 = new DFA47();protected DFA50 dfa50 = new DFA50();protected DFA51 dfa51 = new DFA51();
    class DFA2 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s1 = new DFA.State() {{alt=4;}};
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s4 = new DFA.State() {{alt=2;}};
        DFA.State s2 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 30:
                    return s3;

                case EOL:
                case 15:
                    return s2;

                case 28:
                    return s4;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;        }
            }
        };
        DFA.State s5 = new DFA.State() {{alt=3;}};
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case -1:
                    return s1;

                case EOL:
                case 15:
                    return s2;

                case 30:
                    return s3;

                case 28:
                    return s4;

                case 17:
                case 21:
                case 22:
                    return s5;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA4 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s1 = new DFA.State() {{alt=3;}};
        DFA.State s10 = new DFA.State() {{alt=1;}};
        DFA.State s9 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_9 = input.LA(1);
                if ( LA4_9==ID ) {return s10;}
                if ( LA4_9==EOL||LA4_9==15 ) {return s9;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 9, input);

                throw nvae;
            }
        };
        DFA.State s4 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_4 = input.LA(1);
                if ( LA4_4==EOL||LA4_4==15 ) {return s9;}
                if ( LA4_4==ID ) {return s10;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 4, input);

                throw nvae;
            }
        };
        DFA.State s18 = new DFA.State() {{alt=1;}};
        DFA.State s27 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_27 = input.LA(1);
                if ( LA4_27==ID ) {return s18;}
                if ( LA4_27==59 ) {return s17;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 27, input);

                throw nvae;
            }
        };
        DFA.State s17 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_17 = input.LA(1);
                if ( LA4_17==60 ) {return s27;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 17, input);

                throw nvae;
            }
        };
        DFA.State s26 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 59:
                    return s17;

                case ID:
                    return s18;

                case 18:
                    return s16;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 26, input);

                    throw nvae;        }
            }
        };
        DFA.State s16 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_16 = input.LA(1);
                if ( LA4_16==ID ) {return s26;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 16, input);

                throw nvae;
            }
        };
        DFA.State s11 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 18:
                    return s16;

                case 59:
                    return s17;

                case ID:
                    return s18;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 11, input);

                    throw nvae;        }
            }
        };
        DFA.State s5 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_5 = input.LA(1);
                if ( LA4_5==ID ) {return s11;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 5, input);

                throw nvae;
            }
        };
        DFA.State s121 = new DFA.State() {{alt=1;}};
        DFA.State s122 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 27:
                    return s121;

                case 26:
                    return s120;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s122;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 122, input);

                    throw nvae;        }
            }
        };
        DFA.State s120 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 26:
                    return s120;

                case 27:
                    return s121;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s122;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 120, input);

                    throw nvae;        }
            }
        };
        DFA.State s114 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 26:
                    return s120;

                case 27:
                    return s121;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s122;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 114, input);

                    throw nvae;        }
            }
        };
        DFA.State s115 = new DFA.State() {{alt=1;}};
        DFA.State s116 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 27:
                    return s115;

                case 26:
                    return s114;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s116;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 116, input);

                    throw nvae;        }
            }
        };
        DFA.State s105 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 26:
                    return s114;

                case 27:
                    return s115;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s116;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 105, input);

                    throw nvae;        }
            }
        };
        DFA.State s106 = new DFA.State() {{alt=1;}};
        DFA.State s107 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 27:
                    return s106;

                case 26:
                    return s105;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s107;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 107, input);

                    throw nvae;        }
            }
        };
        DFA.State s87 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 26:
                    return s105;

                case 27:
                    return s106;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s107;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 87, input);

                    throw nvae;        }
            }
        };
        DFA.State s88 = new DFA.State() {{alt=1;}};
        DFA.State s89 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 27:
                    return s88;

                case 26:
                    return s87;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s89;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 89, input);

                    throw nvae;        }
            }
        };
        DFA.State s67 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 26:
                    return s87;

                case 27:
                    return s88;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s89;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 67, input);

                    throw nvae;        }
            }
        };
        DFA.State s68 = new DFA.State() {{alt=1;}};
        DFA.State s69 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 27:
                    return s68;

                case 26:
                    return s67;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s69;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 69, input);

                    throw nvae;        }
            }
        };
        DFA.State s53 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 26:
                    return s67;

                case 27:
                    return s68;

                case EOL:
                case ID:
                case INT:
                case BOOL:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                    return s69;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 53, input);

                    throw nvae;        }
            }
        };
        DFA.State s52 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_52 = input.LA(1);
                if ( LA4_52==26 ) {return s53;}
                if ( LA4_52==EOL||LA4_52==15 ) {return s52;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 52, input);

                throw nvae;
            }
        };
        DFA.State s35 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_35 = input.LA(1);
                if ( LA4_35==EOL||LA4_35==15 ) {return s52;}
                if ( LA4_35==26 ) {return s53;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 35, input);

                throw nvae;
            }
        };
        DFA.State s60 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 24:
                    return s50;

                case 25:
                    return s35;

                case EOL:
                case 15:
                    return s60;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 60, input);

                    throw nvae;        }
            }
        };
        DFA.State s75 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s60;

                case 24:
                    return s50;

                case 25:
                    return s35;

                case 59:
                    return s59;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 75, input);

                    throw nvae;        }
            }
        };
        DFA.State s59 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_59 = input.LA(1);
                if ( LA4_59==60 ) {return s75;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 59, input);

                throw nvae;
            }
        };
        DFA.State s102 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 25:
                    return s35;

                case 24:
                    return s50;

                case EOL:
                case 15:
                    return s102;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 102, input);

                    throw nvae;        }
            }
        };
        DFA.State s84 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 59:
                    return s59;

                case EOL:
                case 15:
                    return s102;

                case 25:
                    return s35;

                case 24:
                    return s50;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 84, input);

                    throw nvae;        }
            }
        };
        DFA.State s83 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 25:
                    return s35;

                case 24:
                    return s50;

                case EOL:
                case 15:
                    return s83;

                case ID:
                    return s84;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 83, input);

                    throw nvae;        }
            }
        };
        DFA.State s64 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 18:
                    return s16;

                case 59:
                    return s47;

                case EOL:
                case 15:
                    return s83;

                case ID:
                    return s84;

                case 25:
                    return s35;

                case 24:
                    return s50;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 64, input);

                    throw nvae;        }
            }
        };
        DFA.State s63 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_63 = input.LA(1);
                if ( LA4_63==ID ) {return s64;}
                if ( LA4_63==EOL||LA4_63==15 ) {return s63;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 63, input);

                throw nvae;
            }
        };
        DFA.State s50 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_50 = input.LA(1);
                if ( LA4_50==EOL||LA4_50==15 ) {return s63;}
                if ( LA4_50==ID ) {return s64;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 50, input);

                throw nvae;
            }
        };
        DFA.State s49 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 59:
                    return s59;

                case EOL:
                case 15:
                    return s60;

                case 24:
                    return s50;

                case 25:
                    return s35;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 49, input);

                    throw nvae;        }
            }
        };
        DFA.State s48 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 24:
                    return s50;

                case 25:
                    return s35;

                case EOL:
                case 15:
                    return s48;

                case ID:
                    return s49;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 48, input);

                    throw nvae;        }
            }
        };
        DFA.State s54 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s48;

                case ID:
                    return s49;

                case 59:
                    return s47;

                case 24:
                    return s50;

                case 25:
                    return s35;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 54, input);

                    throw nvae;        }
            }
        };
        DFA.State s47 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_47 = input.LA(1);
                if ( LA4_47==60 ) {return s54;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 47, input);

                throw nvae;
            }
        };
        DFA.State s34 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 18:
                    return s16;

                case 59:
                    return s47;

                case EOL:
                case 15:
                    return s48;

                case ID:
                    return s49;

                case 24:
                    return s50;

                case 25:
                    return s35;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 34, input);

                    throw nvae;        }
            }
        };
        DFA.State s33 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case ID:
                    return s34;

                case EOL:
                case 15:
                    return s33;

                case 25:
                    return s35;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 33, input);

                    throw nvae;        }
            }
        };
        DFA.State s25 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s33;

                case ID:
                    return s34;

                case 25:
                    return s35;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 25, input);

                    throw nvae;        }
            }
        };
        DFA.State s31 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_31 = input.LA(1);
                if ( LA4_31==23 ) {return s25;}
                if ( LA4_31==EOL||LA4_31==15 ) {return s31;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 31, input);

                throw nvae;
            }
        };
        DFA.State s24 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_24 = input.LA(1);
                if ( LA4_24==EOL||LA4_24==15 ) {return s31;}
                if ( LA4_24==23 ) {return s25;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 24, input);

                throw nvae;
            }
        };
        DFA.State s23 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 23:
                    return s25;

                case EOL:
                case 15:
                    return s23;

                case ID:
                    return s24;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 23, input);

                    throw nvae;        }
            }
        };
        DFA.State s13 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 18:
                    return s16;

                case 59:
                    return s17;

                case EOL:
                case 15:
                    return s23;

                case ID:
                    return s24;

                case 23:
                    return s25;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 13, input);

                    throw nvae;        }
            }
        };
        DFA.State s12 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_12 = input.LA(1);
                if ( LA4_12==ID ) {return s13;}
                if ( LA4_12==EOL||LA4_12==15 ) {return s12;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 12, input);

                throw nvae;
            }
        };
        DFA.State s6 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA4_6 = input.LA(1);
                if ( LA4_6==EOL||LA4_6==15 ) {return s12;}
                if ( LA4_6==ID ) {return s13;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 4, 6, input);

                throw nvae;
            }
        };
        DFA.State s8 = new DFA.State() {{alt=2;}};
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case -1:
                case EOL:
                case 15:
                case 28:
                case 30:
                    return s1;

                case 17:
                    return s4;

                case 21:
                    return s5;

                case 22:
                    return s6;

                case 20:
                    return s8;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA12 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s5 = new DFA.State() {{alt=1;}};
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s3 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case ID:
                    return s5;

                case EOL:
                case 15:
                    return s3;

                case 23:
                    return s2;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;        }
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s3;

                case 23:
                    return s2;

                case ID:
                case 18:
                case 59:
                    return s5;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA12_0 = input.LA(1);
                if ( LA12_0==ID ) {return s1;}
                if ( LA12_0==EOL||LA12_0==15 ) {return s2;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
        };

    }class DFA13 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s5 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case ID:
                    return s3;

                case EOL:
                case 15:
                    return s5;

                case 24:
                case 25:
                    return s2;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 5, input);

                    throw nvae;        }
            }
        };
        DFA.State s9 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s5;

                case ID:
                    return s3;

                case 59:
                    return s4;

                case 24:
                case 25:
                    return s2;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 9, input);

                    throw nvae;        }
            }
        };
        DFA.State s4 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA13_4 = input.LA(1);
                if ( LA13_4==60 ) {return s9;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 13, 4, input);

                throw nvae;
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case ID:
                case 18:
                    return s3;

                case 59:
                    return s4;

                case EOL:
                case 15:
                    return s5;

                case 24:
                case 25:
                    return s2;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA13_0 = input.LA(1);
                if ( LA13_0==ID ) {return s1;}
                if ( LA13_0==EOL||LA13_0==15 ) {return s2;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
        };

    }class DFA14 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s7 = new DFA.State() {{alt=1;}};
        DFA.State s4 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 24:
                case 25:
                    return s2;

                case EOL:
                case 15:
                    return s4;

                case ID:
                    return s7;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

                    throw nvae;        }
            }
        };
        DFA.State s9 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s4;

                case 24:
                case 25:
                    return s2;

                case 59:
                    return s3;

                case ID:
                    return s7;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 9, input);

                    throw nvae;        }
            }
        };
        DFA.State s3 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA14_3 = input.LA(1);
                if ( LA14_3==60 ) {return s9;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 14, 3, input);

                throw nvae;
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 59:
                    return s3;

                case EOL:
                case 15:
                    return s4;

                case 24:
                case 25:
                    return s2;

                case ID:
                case 18:
                    return s7;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA14_0 = input.LA(1);
                if ( LA14_0==ID ) {return s1;}
                if ( LA14_0==EOL||LA14_0==15 ) {return s2;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
        };

    }class DFA44 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s6 = new DFA.State() {{alt=1;}};
        DFA.State s4 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 32:
                    return s6;

                case EOL:
                case 15:
                    return s4;

                case 23:
                    return s2;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 4, input);

                    throw nvae;        }
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 18:
                case 23:
                case 59:
                    return s2;

                case EOL:
                case 15:
                    return s4;

                case 32:
                    return s6;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA44_0 = input.LA(1);
                if ( LA44_0==ID ) {return s1;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
        };

    }class DFA47 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=1;}};
        DFA.State s3 = new DFA.State() {{alt=2;}};
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s1;

                case ID:
                    return s2;

                case 25:
                    return s3;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s1;

                case ID:
                    return s2;

                case 25:
                    return s3;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA50 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s1;

                case 25:
                    return s2;

                case 24:
                    return s3;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s1;

                case 25:
                    return s2;

                case 24:
                    return s3;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA51 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s4 = new DFA.State() {{alt=2;}};
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s2 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 24:
                case 25:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                    return s4;

                case EOL:
                case 15:
                    return s2;

                case 32:
                    return s3;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;        }
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case 15:
                    return s2;

                case 32:
                    return s3;

                case 24:
                case 25:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                    return s4;

                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA51_0 = input.LA(1);
                if ( LA51_0==ID ) {return s1;}

                NoViableAltException nvae =
        	    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
        };

    }


    public static final BitSet FOLLOW_set_in_opt_eol41 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_compilation_unit57 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_prolog_in_compilation_unit61 = new BitSet(new long[]{0x0000000000628012L});
    public static final BitSet FOLLOW_rule_in_compilation_unit70 = new BitSet(new long[]{0x0000000000628012L});
    public static final BitSet FOLLOW_query_in_compilation_unit83 = new BitSet(new long[]{0x0000000000628012L});
    public static final BitSet FOLLOW_extra_statement_in_compilation_unit91 = new BitSet(new long[]{0x0000000000628012L});
    public static final BitSet FOLLOW_opt_eol_in_prolog115 = new BitSet(new long[]{0x0000000000738012L});
    public static final BitSet FOLLOW_package_statement_in_prolog123 = new BitSet(new long[]{0x0000000000728012L});
    public static final BitSet FOLLOW_extra_statement_in_prolog138 = new BitSet(new long[]{0x0000000000728012L});
    public static final BitSet FOLLOW_expander_in_prolog144 = new BitSet(new long[]{0x0000000000728012L});
    public static final BitSet FOLLOW_opt_eol_in_prolog156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_package_statement180 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_package_statement182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_dotted_name_in_package_statement186 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_package_statement188 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_package_statement191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_import_statement207 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_import_statement209 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_import_name_in_import_statement213 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_import_statement215 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_import_statement218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_import_name249 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_import_name255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_import_name259 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_19_in_import_name269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_expander289 = new BitSet(new long[]{0x0000000000008032L});
    public static final BitSet FOLLOW_dotted_name_in_expander294 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_expander298 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_expander301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_global325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_dotted_name_in_global329 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_global333 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_global335 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_global338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_function362 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function364 = new BitSet(new long[]{0x0000000000008032L});
    public static final BitSet FOLLOW_dotted_name_in_function369 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function373 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_function377 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function379 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_function388 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function390 = new BitSet(new long[]{0x0000000002008032L});
    public static final BitSet FOLLOW_dotted_name_in_function400 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_argument_in_function408 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function410 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_function424 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function426 = new BitSet(new long[]{0x0000000000008032L});
    public static final BitSet FOLLOW_dotted_name_in_function431 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function435 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_argument_in_function439 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function441 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_function466 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function470 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_function474 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_curly_chunk_in_function481 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_function490 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_function498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opt_eol_in_query522 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_query528 = new BitSet(new long[]{0x2000001AF0020120L});
    public static final BitSet FOLLOW_word_in_query532 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_query534 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_expander_lhs_block_in_query550 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_normal_lhs_block_in_query558 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_query573 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_query575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opt_eol_in_rule598 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rule604 = new BitSet(new long[]{0x2000001AF0020120L});
    public static final BitSet FOLLOW_word_in_rule608 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule610 = new BitSet(new long[]{0x0000000500008012L});
    public static final BitSet FOLLOW_rule_attributes_in_rule621 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule631 = new BitSet(new long[]{0x00000000A0008012L});
    public static final BitSet FOLLOW_31_in_rule640 = new BitSet(new long[]{0x0000000100008012L});
    public static final BitSet FOLLOW_32_in_rule642 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule645 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_expander_lhs_block_in_rule663 = new BitSet(new long[]{0x0000000020008012L});
    public static final BitSet FOLLOW_normal_lhs_block_in_rule672 = new BitSet(new long[]{0x0000000020008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule695 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rule699 = new BitSet(new long[]{0x0000000100008012L});
    public static final BitSet FOLLOW_32_in_rule701 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule705 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_29_in_rule751 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_statement_in_extra_statement773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_in_extra_statement778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_extra_statement783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule_attributes802 = new BitSet(new long[]{0x0000000100008012L});
    public static final BitSet FOLLOW_32_in_rule_attributes805 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule_attributes808 = new BitSet(new long[]{0x000001F801000002L});
    public static final BitSet FOLLOW_24_in_rule_attributes815 = new BitSet(new long[]{0x000001F800000000L});
    public static final BitSet FOLLOW_rule_attribute_in_rule_attributes820 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_rule_attributes822 = new BitSet(new long[]{0x000001F801000002L});
    public static final BitSet FOLLOW_salience_in_rule_attribute861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_loop_in_rule_attribute871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_agenda_group_in_rule_attribute882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_duration_in_rule_attribute895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_activation_group_in_rule_attribute909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_auto_focus_in_rule_attribute920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_salience953 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_salience955 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_salience959 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_salience961 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_salience964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_no_loop999 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_no_loop1001 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_no_loop1003 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_no_loop1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_no_loop1031 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_BOOL_in_no_loop1035 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_no_loop1037 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_no_loop1039 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_no_loop1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_auto_focus1088 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_auto_focus1090 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_auto_focus1092 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_auto_focus1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_auto_focus1120 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_BOOL_in_auto_focus1124 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_auto_focus1126 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_auto_focus1128 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_auto_focus1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_activation_group1173 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_activation_group1175 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_activation_group1179 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_activation_group1181 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_activation_group1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_agenda_group1213 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_agenda_group1215 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_agenda_group1219 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_agenda_group1221 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_agenda_group1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_duration1256 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_duration1258 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_duration1262 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_duration1264 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_duration1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_normal_lhs_block1293 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_normal_lhs_block1295 = new BitSet(new long[]{0x0700000000808032L});
    public static final BitSet FOLLOW_opt_eol_in_normal_lhs_block1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paren_chunk_in_expander_lhs_block1348 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EOL_in_expander_lhs_block1352 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_lhs_or_in_lhs1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_binding_in_lhs_column1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_lhs_column1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_fact_binding1474 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact_binding1484 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_fact_binding1486 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact_binding1488 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_fact_expression_in_fact_binding1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_fact_expression1524 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact_expression1526 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_fact_expression_in_fact_expression1530 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact_expression1532 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_fact_expression1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_fact_expression1545 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact_expression1547 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_set_in_fact_expression1560 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact_expression1565 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_fact_in_fact_expression1579 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_dotted_name_in_fact1618 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact1626 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_fact1634 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact1637 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_constraints_in_fact1643 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact1662 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_fact1666 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_fact1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opt_eol_in_constraints1700 = new BitSet(new long[]{0x0000000000008032L});
    public static final BitSet FOLLOW_constraint_in_constraints1705 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_predicate_in_constraints1708 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraints1716 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_constraints1718 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraints1720 = new BitSet(new long[]{0x0000000000008032L});
    public static final BitSet FOLLOW_constraint_in_constraints1723 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_predicate_in_constraints1726 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraints1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opt_eol_in_constraint1753 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_constraint1761 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraint1763 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_constraint1765 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraint1767 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_constraint1777 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraint1787 = new BitSet(new long[]{0x000FF80000008012L});
    public static final BitSet FOLLOW_set_in_constraint1795 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraint1882 = new BitSet(new long[]{0x00100000008003E0L});
    public static final BitSet FOLLOW_ID_in_constraint1900 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_enum_constraint_in_constraint1925 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_literal_constraint_in_constraint1957 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_retval_constraint_in_constraint1977 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_constraint2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_literal_constraint2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_literal_constraint2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_literal_constraint2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_literal_constraint2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_literal_constraint2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_enum_constraint2115 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_enum_constraint2117 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_enum_constraint2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_retval_constraint2150 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_paren_chunk_in_retval_constraint2155 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_retval_constraint2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_predicate2176 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_predicate2178 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_predicate2182 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_predicate2184 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_predicate2186 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_paren_chunk_in_predicate2190 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_predicate2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_paren_chunk2238 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_paren_chunk_in_paren_chunk2242 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_paren_chunk2244 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_23_in_paren_chunk22315 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_paren_chunk2_in_paren_chunk22319 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_paren_chunk22321 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_26_in_curly_chunk2390 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_curly_chunk_in_curly_chunk2394 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_curly_chunk2396 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or2454 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_set_in_lhs_or2463 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_lhs_or2468 = new BitSet(new long[]{0x0700000000800020L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or2475 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and2515 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_set_in_lhs_and2524 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_lhs_and2529 = new BitSet(new long[]{0x0700000000800020L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and2536 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_lhs_exist_in_lhs_unary2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_not_in_lhs_unary2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_eval_in_lhs_unary2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_unary2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_lhs_unary2604 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_lhs_unary2606 = new BitSet(new long[]{0x0700000000800020L});
    public static final BitSet FOLLOW_lhs_in_lhs_unary2610 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_opt_eol_in_lhs_unary2612 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_lhs_unary2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_lhs_exist2644 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_lhs_exist2647 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_exist2651 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_lhs_exist2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_exist2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_lhs_not2689 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_lhs_not2692 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_not2696 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_lhs_not2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_not2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_lhs_eval2731 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_lhs_eval2735 = new BitSet(new long[]{0x3FFFFFFFFFFFFFF2L});
    public static final BitSet FOLLOW_paren_chunk2_in_lhs_eval2743 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_lhs_eval2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_dotted_name2779 = new BitSet(new long[]{0x0800000000040002L});
    public static final BitSet FOLLOW_18_in_dotted_name2785 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_dotted_name2789 = new BitSet(new long[]{0x0800000000040002L});
    public static final BitSet FOLLOW_59_in_dotted_name2798 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_dotted_name2800 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ID_in_argument2830 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_argument2836 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_argument2838 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ID_in_word2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_word2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_word2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_word2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_word2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_word2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_word2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_word2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_word2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_word2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_word2972 = new BitSet(new long[]{0x0000000000000002L});

}