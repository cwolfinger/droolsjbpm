// $ANTLR 3.0ea7 /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g 2006-03-07 21:31:05

	package org.drools.lang;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Iterator;
	import org.drools.lang.descr.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RuleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "EOL", "ID", "INT", "STRING", "FLOAT", "MISC", "WS", "SH_STYLE_SINGLE_LINE_COMMENT", "C_STYLE_SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "\'package\'", "\'.\'", "\';\'", "\'import\'", "\'use\'", "\'expander\'", "\'rule\'", "\'when\'", "\':\'", "\'then\'", "\'end\'", "\'options\'", "\',\'", "\'salience\'", "\'no-loop\'", "\'(\'", "\')\'", "\'==\'", "\'>\'", "\'>=\'", "\'<\'", "\'<=\'", "\'!=\'", "\'or\'", "\'||\'", "\'and\'", "\'&&\'", "\'exists\'", "\'not\'", "\'eval\'"
    };
    public static final int INT=6;
    public static final int WS=10;
    public static final int MISC=9;
    public static final int EOL=4;
    public static final int STRING=7;
    public static final int FLOAT=8;
    public static final int SH_STYLE_SINGLE_LINE_COMMENT=11;
    public static final int MULTI_LINE_COMMENT=13;
    public static final int C_STYLE_SINGLE_LINE_COMMENT=12;
    public static final int ID=5;
        public RuleParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }


    	private PackageDescr packageDescr;
    	
    	public PackageDescr getPackageDescr() {
    		return packageDescr;
    	}
    /*
    	private String    packageName = "";
    	private List      rules       = new ArrayList();
    	private List      imports     = new ArrayList();
    	
    	public String getPackageName() { return packageName; }
    	public List getImports() { return imports; }
    	public List getRules() { return rules; }
    */




    // $ANTLR start opt_eol
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:32:1: opt_eol : ( EOL )* ;
    public void opt_eol() throws RecognitionException {   




        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:33:17: ( ( EOL )* )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:33:17: ( EOL )*
            {

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:33:17: ( EOL )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);
                if ( LA1_0==EOL ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:33:17: EOL
            	    {

            	    match(input,EOL,FOLLOW_EOL_in_opt_eol40);

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

    }
    // $ANTLR end opt_eol



    // $ANTLR start compilation_unit
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:36:1: compilation_unit : prolog (r= rule )* ;
    public void compilation_unit() throws RecognitionException {   



        RuleDescr r = null;


        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:37:17: ( prolog (r= rule )* )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:37:17: prolog (r= rule )*
            {

            following.push(FOLLOW_prolog_in_compilation_unit53);
            prolog();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:38:17: (r= rule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);
                if ( LA2_0==EOL||LA2_0==20 ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:38:18: r= rule
            	    {

            	    following.push(FOLLOW_rule_in_compilation_unit61);
            	    r=rule();
            	    following.pop();


            	    this.packageDescr.addRule( r ); 

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

    }
    // $ANTLR end compilation_unit



    // $ANTLR start prolog
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:41:1: prolog : opt_eol (name= package_statement )? opt_eol (name= import_statement )* opt_eol ( use_expander )? opt_eol ;
    public void prolog() throws RecognitionException {   



        String name = null;



        		String packageName = "";
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:45:17: ( opt_eol (name= package_statement )? opt_eol (name= import_statement )* opt_eol ( use_expander )? opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:45:17: opt_eol (name= package_statement )? opt_eol (name= import_statement )* opt_eol ( use_expander )? opt_eol
            {

            following.push(FOLLOW_opt_eol_in_prolog83);
            opt_eol();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:46:17: (name= package_statement )?
            int alt3=2;
            int LA3_0 = input.LA(1);
            if ( LA3_0==14 ) {
                alt3=1;
            }
            else if ( LA3_0==-1||LA3_0==EOL||(LA3_0>=17 && LA3_0<=18)||LA3_0==20 ) {
                alt3=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("46:17: (name= package_statement )?", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:46:19: name= package_statement
                    {

                    following.push(FOLLOW_package_statement_in_prolog91);
                    name=package_statement();
                    following.pop();


                     packageName = name; 

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_prolog100);
            opt_eol();
            following.pop();


             
            			this.packageDescr = new PackageDescr( name ); 
            		

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:51:17: (name= import_statement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);
                if ( LA4_0==17 ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:51:19: name= import_statement
            	    {

            	    following.push(FOLLOW_import_statement_in_prolog112);
            	    name=import_statement();
            	    following.pop();


            	     this.packageDescr.addImport( name ); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            following.push(FOLLOW_opt_eol_in_prolog121);
            opt_eol();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:53:17: ( use_expander )?
            int alt5=2;
            int LA5_0 = input.LA(1);
            if ( LA5_0==18 ) {
                alt5=1;
            }
            else if ( LA5_0==-1||LA5_0==EOL||LA5_0==20 ) {
                alt5=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("53:17: ( use_expander )?", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:53:17: use_expander
                    {

                    following.push(FOLLOW_use_expander_in_prolog125);
                    use_expander();
                    following.pop();


                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_prolog130);
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

    }
    // $ANTLR end prolog



    // $ANTLR start package_statement
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:57:1: package_statement returns [String packageName] : 'package' opt_eol id= ID ( '.' id= ID )* ( ';' )? opt_eol ;
    public String package_statement() throws RecognitionException {   

        String packageName;
        Token id=null;


        		packageName = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:61:17: ( 'package' opt_eol id= ID ( '.' id= ID )* ( ';' )? opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:61:17: 'package' opt_eol id= ID ( '.' id= ID )* ( ';' )? opt_eol
            {

            match(input,14,FOLLOW_14_in_package_statement151);

            following.push(FOLLOW_opt_eol_in_package_statement153);
            opt_eol();
            following.pop();


            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_package_statement157);

             packageName = id.getText(); 

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:61:73: ( '.' id= ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);
                if ( LA6_0==15 ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:61:75: '.' id= ID
            	    {

            	    match(input,15,FOLLOW_15_in_package_statement163);

            	    id=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_package_statement167);

            	     packageName += "." + id.getText(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:61:127: ( ';' )?
            int alt7=2;
            int LA7_0 = input.LA(1);
            if ( LA7_0==16 ) {
                alt7=1;
            }
            else if ( LA7_0==-1||LA7_0==EOL||(LA7_0>=17 && LA7_0<=18)||LA7_0==20 ) {
                alt7=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("61:127: ( \';\' )?", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:61:127: ';'
                    {

                    match(input,16,FOLLOW_16_in_package_statement174);

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_package_statement177);
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

        return packageName;

    }
    // $ANTLR end package_statement



    // $ANTLR start import_statement
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:64:1: import_statement returns [String importStatement] : 'import' opt_eol name= java_package_or_class ( ';' )? opt_eol ;
    public String import_statement() throws RecognitionException {   

        String importStatement;

        String name = null;



        		importStatement = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:68:17: ( 'import' opt_eol name= java_package_or_class ( ';' )? opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:68:17: 'import' opt_eol name= java_package_or_class ( ';' )? opt_eol
            {

            match(input,17,FOLLOW_17_in_import_statement200);

            following.push(FOLLOW_opt_eol_in_import_statement202);
            opt_eol();
            following.pop();


            following.push(FOLLOW_java_package_or_class_in_import_statement206);
            name=java_package_or_class();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:68:61: ( ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);
            if ( LA8_0==16 ) {
                alt8=1;
            }
            else if ( LA8_0==-1||LA8_0==EOL||(LA8_0>=17 && LA8_0<=18)||LA8_0==20 ) {
                alt8=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("68:61: ( \';\' )?", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:68:61: ';'
                    {

                    match(input,16,FOLLOW_16_in_import_statement208);

                    }
                    break;

            }


             importStatement = name; 

            following.push(FOLLOW_opt_eol_in_import_statement213);
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

        return importStatement;

    }
    // $ANTLR end import_statement



    // $ANTLR start use_expander
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:71:1: use_expander : 'use' 'expander' ID ( ';' )? opt_eol ;
    public void use_expander() throws RecognitionException {   




        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:72:17: ( 'use' 'expander' ID ( ';' )? opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:72:17: 'use' 'expander' ID ( ';' )? opt_eol
            {

            match(input,18,FOLLOW_18_in_use_expander225);

            match(input,19,FOLLOW_19_in_use_expander227);

            match(input,ID,FOLLOW_ID_in_use_expander229);

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:72:37: ( ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);
            if ( LA9_0==16 ) {
                alt9=1;
            }
            else if ( LA9_0==-1||LA9_0==EOL||LA9_0==20 ) {
                alt9=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("72:37: ( \';\' )?", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:72:37: ';'
                    {

                    match(input,16,FOLLOW_16_in_use_expander231);

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_use_expander234);
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

    }
    // $ANTLR end use_expander



    // $ANTLR start rule
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:76:1: rule returns [RuleDescr rule] : opt_eol loc= 'rule' ruleName= word opt_eol ( rule_options )? (loc= 'when' ( ':' )? opt_eol (l= lhs )* )? ( 'then' ( ':' )? (any= . )* )? EOL 'end' opt_eol ;
    public RuleDescr rule() throws RecognitionException {   

        RuleDescr rule;
        Token loc=null;
        Token any=null;
        String ruleName = null;

        PatternDescr l = null;



        		rule = null;
        		String consequence = "";
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:82:17: ( opt_eol loc= 'rule' ruleName= word opt_eol ( rule_options )? (loc= 'when' ( ':' )? opt_eol (l= lhs )* )? ( 'then' ( ':' )? (any= . )* )? EOL 'end' opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:82:17: opt_eol loc= 'rule' ruleName= word opt_eol ( rule_options )? (loc= 'when' ( ':' )? opt_eol (l= lhs )* )? ( 'then' ( ':' )? (any= . )* )? EOL 'end' opt_eol
            {

            following.push(FOLLOW_opt_eol_in_rule258);
            opt_eol();
            following.pop();


            loc=(Token)input.LT(1);
            match(input,20,FOLLOW_20_in_rule264);

            following.push(FOLLOW_word_in_rule268);
            ruleName=word();
            following.pop();


            following.push(FOLLOW_opt_eol_in_rule270);
            opt_eol();
            following.pop();


             
            			rule = new RuleDescr( ruleName, null ); 
            			rule.setLocation( loc.getLine(), loc.getCharPositionInLine() );
            		

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:88:17: ( rule_options )?
            int alt10=2;
            int LA10_0 = input.LA(1);
            if ( LA10_0==25 ) {
                alt10=1;
            }
            else if ( LA10_0==EOL||LA10_0==21||LA10_0==23 ) {
                alt10=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("88:17: ( rule_options )?", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:88:17: rule_options
                    {

                    following.push(FOLLOW_rule_options_in_rule279);
                    rule_options();
                    following.pop();


                    }
                    break;

            }


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:89:17: (loc= 'when' ( ':' )? opt_eol (l= lhs )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);
            if ( LA13_0==21 ) {
                alt13=1;
            }
            else if ( LA13_0==EOL||LA13_0==23 ) {
                alt13=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("89:17: (loc= \'when\' ( \':\' )? opt_eol (l= lhs )* )?", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:89:25: loc= 'when' ( ':' )? opt_eol (l= lhs )*
                    {

                    loc=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_rule288);

                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:89:36: ( ':' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);
                    if ( LA11_0==22 ) {
                        alt11=1;
                    }
                    else if ( (LA11_0>=EOL && LA11_0<=ID)||LA11_0==23||LA11_0==29||(LA11_0>=41 && LA11_0<=43) ) {
                        alt11=2;
                    }
                    else {

                        NoViableAltException nvae =
                            new NoViableAltException("89:36: ( \':\' )?", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:89:36: ':'
                            {

                            match(input,22,FOLLOW_22_in_rule290);

                            }
                            break;

                    }


                    following.push(FOLLOW_opt_eol_in_rule293);
                    opt_eol();
                    following.pop();


                     
                    				AndDescr lhs = new AndDescr(); rule.setLhs( lhs ); 
                    				lhs.setLocation( loc.getLine(), loc.getCharPositionInLine() );
                    			

                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:94:33: (l= lhs )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);
                        if ( LA12_0==ID||LA12_0==29||(LA12_0>=41 && LA12_0<=43) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:94:34: l= lhs
                    	    {

                    	    following.push(FOLLOW_lhs_in_rule307);
                    	    l=lhs();
                    	    following.pop();


                    	     lhs.addDescr( l ); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:96:17: ( 'then' ( ':' )? (any= . )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);
            if ( LA16_0==23 ) {
                alt16=1;
            }
            else if ( LA16_0==EOL ) {
                alt16=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("96:17: ( \'then\' ( \':\' )? (any= . )* )?", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:96:25: 'then' ( ':' )? (any= . )*
                    {

                    match(input,23,FOLLOW_23_in_rule323);

                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:96:32: ( ':' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);
                    if ( LA14_0==22 ) {
                        alt14=1;
                    }
                    else if ( (LA14_0>=EOL && LA14_0<=21)||(LA14_0>=23 && LA14_0<=43) ) {
                        alt14=2;
                    }
                    else {

                        NoViableAltException nvae =
                            new NoViableAltException("96:32: ( \':\' )?", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:96:32: ':'
                            {

                            match(input,22,FOLLOW_22_in_rule325);

                            }
                            break;

                    }


                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:97:25: (any= . )*
                    loop15:
                    do {
                        int alt15=2;
                        alt15 = dfa15.predict(input);
                        switch (alt15) {
                    	case 1 :
                    	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:97:26: any= .
                    	    {

                    	    any=(Token)input.LT(1);
                    	    matchAny(input);


                    	    					consequence = consequence + " " + any.getText();
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                     rule.setConsequence( consequence ); 

                    }
                    break;

            }


            match(input,EOL,FOLLOW_EOL_in_rule360);

            match(input,24,FOLLOW_24_in_rule362);

            following.push(FOLLOW_opt_eol_in_rule364);
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

        return rule;

    }
    // $ANTLR end rule



    // $ANTLR start rule_options
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:107:1: rule_options : 'options' ( ':' )? opt_eol ( salience | no_loop ) opt_eol ( ( ',' )? opt_eol ( salience | no_loop ) )* opt_eol ;
    public void rule_options() throws RecognitionException {   




        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:108:17: ( 'options' ( ':' )? opt_eol ( salience | no_loop ) opt_eol ( ( ',' )? opt_eol ( salience | no_loop ) )* opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:108:17: 'options' ( ':' )? opt_eol ( salience | no_loop ) opt_eol ( ( ',' )? opt_eol ( salience | no_loop ) )* opt_eol
            {

            match(input,25,FOLLOW_25_in_rule_options375);

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:108:27: ( ':' )?
            int alt17=2;
            int LA17_0 = input.LA(1);
            if ( LA17_0==22 ) {
                alt17=1;
            }
            else if ( LA17_0==EOL||(LA17_0>=27 && LA17_0<=28) ) {
                alt17=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("108:27: ( \':\' )?", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:108:27: ':'
                    {

                    match(input,22,FOLLOW_22_in_rule_options377);

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_rule_options380);
            opt_eol();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:25: ( salience | no_loop )
            int alt18=2;
            int LA18_0 = input.LA(1);
            if ( LA18_0==27 ) {
                alt18=1;
            }
            else if ( LA18_0==28 ) {
                alt18=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("109:25: ( salience | no_loop )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:27: salience
                    {

                    following.push(FOLLOW_salience_in_rule_options387);
                    salience();
                    following.pop();


                    }
                    break;
                case 2 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:38: no_loop
                    {

                    following.push(FOLLOW_no_loop_in_rule_options391);
                    no_loop();
                    following.pop();


                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_rule_options395);
            opt_eol();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:56: ( ( ',' )? opt_eol ( salience | no_loop ) )*
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:58: ( ',' )? opt_eol ( salience | no_loop )
            	    {

            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:58: ( ',' )?
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);
            	    if ( LA19_0==26 ) {
            	        alt19=1;
            	    }
            	    else if ( LA19_0==EOL||(LA19_0>=27 && LA19_0<=28) ) {
            	        alt19=2;
            	    }
            	    else {

            	        NoViableAltException nvae =
            	            new NoViableAltException("109:58: ( \',\' )?", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:58: ','
            	            {

            	            match(input,26,FOLLOW_26_in_rule_options399);

            	            }
            	            break;

            	    }


            	    following.push(FOLLOW_opt_eol_in_rule_options402);
            	    opt_eol();
            	    following.pop();


            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:71: ( salience | no_loop )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);
            	    if ( LA20_0==27 ) {
            	        alt20=1;
            	    }
            	    else if ( LA20_0==28 ) {
            	        alt20=2;
            	    }
            	    else {

            	        NoViableAltException nvae =
            	            new NoViableAltException("109:71: ( salience | no_loop )", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:73: salience
            	            {

            	            following.push(FOLLOW_salience_in_rule_options406);
            	            salience();
            	            following.pop();


            	            }
            	            break;
            	        case 2 :
            	            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:109:84: no_loop
            	            {

            	            following.push(FOLLOW_no_loop_in_rule_options410);
            	            no_loop();
            	            following.pop();


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            following.push(FOLLOW_opt_eol_in_rule_options417);
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

    }
    // $ANTLR end rule_options



    // $ANTLR start salience
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:112:1: salience : 'salience' INT ( ';' )? opt_eol ;
    public void salience() throws RecognitionException {   




        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:114:17: ( 'salience' INT ( ';' )? opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:114:17: 'salience' INT ( ';' )? opt_eol
            {

            match(input,27,FOLLOW_27_in_salience432);

            match(input,INT,FOLLOW_INT_in_salience434);

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:114:32: ( ';' )?
            int alt22=2;
            int LA22_0 = input.LA(1);
            if ( LA22_0==16 ) {
                alt22=1;
            }
            else if ( LA22_0==EOL||LA22_0==21||LA22_0==23||(LA22_0>=26 && LA22_0<=28) ) {
                alt22=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("114:32: ( \';\' )?", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:114:32: ';'
                    {

                    match(input,16,FOLLOW_16_in_salience436);

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_salience439);
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

    }
    // $ANTLR end salience



    // $ANTLR start no_loop
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:117:1: no_loop : 'no-loop' ( ';' )? opt_eol ;
    public void no_loop() throws RecognitionException {   




        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:119:17: ( 'no-loop' ( ';' )? opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:119:17: 'no-loop' ( ';' )? opt_eol
            {

            match(input,28,FOLLOW_28_in_no_loop453);

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:119:27: ( ';' )?
            int alt23=2;
            int LA23_0 = input.LA(1);
            if ( LA23_0==16 ) {
                alt23=1;
            }
            else if ( LA23_0==EOL||LA23_0==21||LA23_0==23||(LA23_0>=26 && LA23_0<=28) ) {
                alt23=2;
            }
            else {

                NoViableAltException nvae =
                    new NoViableAltException("119:27: ( \';\' )?", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:119:27: ';'
                    {

                    match(input,16,FOLLOW_16_in_no_loop455);

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_no_loop458);
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

    }
    // $ANTLR end no_loop



    // $ANTLR start lhs
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:123:1: lhs returns [PatternDescr d] : l= lhs_or ;
    public PatternDescr lhs() throws RecognitionException {   

        PatternDescr d;

        PatternDescr l = null;



        		d=null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:127:17: (l= lhs_or )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:127:17: l= lhs_or
            {

            following.push(FOLLOW_lhs_or_in_lhs484);
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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:131:1: lhs_column returns [ColumnDescr d] : (f= fact_binding | f= fact );
    public ColumnDescr lhs_column() throws RecognitionException {   

        ColumnDescr d;

        ColumnDescr f = null;



        		d=null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:135:17: (f= fact_binding | f= fact )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:135:17: f= fact_binding
                    {

                    following.push(FOLLOW_fact_binding_in_lhs_column511);
                    f=fact_binding();
                    following.pop();


                     d = f; 

                    }
                    break;
                case 2 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:136:17: f= fact
                    {

                    following.push(FOLLOW_fact_in_lhs_column520);
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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:139:1: fact_binding returns [ColumnDescr d] : id= ID opt_eol ':' opt_eol f= fact opt_eol ;
    public ColumnDescr fact_binding() throws RecognitionException {   

        ColumnDescr d;
        Token id=null;
        ColumnDescr f = null;



        		d=null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:144:17: (id= ID opt_eol ':' opt_eol f= fact opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:144:17: id= ID opt_eol ':' opt_eol f= fact opt_eol
            {

            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_fact_binding552);

            following.push(FOLLOW_opt_eol_in_fact_binding554);
            opt_eol();
            following.pop();


            match(input,22,FOLLOW_22_in_fact_binding556);

            following.push(FOLLOW_opt_eol_in_fact_binding558);
            opt_eol();
            following.pop();


            following.push(FOLLOW_fact_in_fact_binding562);
            f=fact();
            following.pop();


             d=f; 

            following.push(FOLLOW_opt_eol_in_fact_binding566);
            opt_eol();
            following.pop();



             			d=f;
             			d.setIdentifier( id.getText() );
             		

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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:151:1: fact returns [ColumnDescr d] : id= ID opt_eol '(' opt_eol (c= constraints )? opt_eol ')' opt_eol ;
    public ColumnDescr fact() throws RecognitionException {   

        ColumnDescr d;
        Token id=null;
        List c = null;



        		d=null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:155:17: (id= ID opt_eol '(' opt_eol (c= constraints )? opt_eol ')' opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:155:17: id= ID opt_eol '(' opt_eol (c= constraints )? opt_eol ')' opt_eol
            {

            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_fact598);

             d = new ColumnDescr( id.getText() ); 

            following.push(FOLLOW_opt_eol_in_fact602);
            opt_eol();
            following.pop();


            match(input,29,FOLLOW_29_in_fact608);

            following.push(FOLLOW_opt_eol_in_fact610);
            opt_eol();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:156:29: (c= constraints )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:156:33: c= constraints
                    {

                    following.push(FOLLOW_constraints_in_fact616);
                    c=constraints();
                    following.pop();



                    		 			for ( Iterator cIter = c.iterator() ; cIter.hasNext() ; ) {
                     						d.addDescr( (PatternDescr) cIter.next() );
                     					}
                     				

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_fact635);
            opt_eol();
            following.pop();


            match(input,30,FOLLOW_30_in_fact637);

            following.push(FOLLOW_opt_eol_in_fact639);
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

        return d;

    }
    // $ANTLR end fact



    // $ANTLR start constraints
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:167:1: constraints returns [List constraints] : opt_eol c= constraint ( opt_eol ',' opt_eol c= constraint )* opt_eol ;
    public List constraints() throws RecognitionException {   

        List constraints;

        PatternDescr c = null;



        		constraints = new ArrayList();
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:171:17: ( opt_eol c= constraint ( opt_eol ',' opt_eol c= constraint )* opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:171:17: opt_eol c= constraint ( opt_eol ',' opt_eol c= constraint )* opt_eol
            {

            following.push(FOLLOW_opt_eol_in_constraints665);
            opt_eol();
            following.pop();


            following.push(FOLLOW_constraint_in_constraints671);
            c=constraint();
            following.pop();


             constraints.add( c ); 

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:173:17: ( opt_eol ',' opt_eol c= constraint )*
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:173:19: opt_eol ',' opt_eol c= constraint
            	    {

            	    following.push(FOLLOW_opt_eol_in_constraints680);
            	    opt_eol();
            	    following.pop();


            	    match(input,26,FOLLOW_26_in_constraints682);

            	    following.push(FOLLOW_opt_eol_in_constraints684);
            	    opt_eol();
            	    following.pop();


            	    following.push(FOLLOW_constraint_in_constraints688);
            	    c=constraint();
            	    following.pop();


            	     constraints.add( c ); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            following.push(FOLLOW_opt_eol_in_constraints697);
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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:177:1: constraint returns [PatternDescr d] : opt_eol f= ID opt_eol op= ('=='|'>'|'>='|'<'|'<='|'!=') opt_eol (lc= literal_constraint | rvc= retval_constraint ) opt_eol ;
    public PatternDescr constraint() throws RecognitionException {   

        PatternDescr d;
        Token f=null;
        Token op=null;
        String lc = null;

        String rvc = null;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:181:17: ( opt_eol f= ID opt_eol op= ('=='|'>'|'>='|'<'|'<='|'!=') opt_eol (lc= literal_constraint | rvc= retval_constraint ) opt_eol )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:181:17: opt_eol f= ID opt_eol op= ('=='|'>'|'>='|'<'|'<='|'!=') opt_eol (lc= literal_constraint | rvc= retval_constraint ) opt_eol
            {

            following.push(FOLLOW_opt_eol_in_constraint719);
            opt_eol();
            following.pop();


            f=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_constraint725);

            following.push(FOLLOW_opt_eol_in_constraint727);
            opt_eol();
            following.pop();


            op=(Token)input.LT(1);
            if ( (input.LA(1)>=31 && input.LA(1)<=36) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_constraint734);    throw mse;
            }


            following.push(FOLLOW_opt_eol_in_constraint788);
            opt_eol();
            following.pop();


            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:190:41: (lc= literal_constraint | rvc= retval_constraint )
            int alt27=2;
            switch ( input.LA(1) ) {
            case STRING:
                alt27=1;
                break;
            case INT:
                alt27=1;
                break;
            case FLOAT:
                alt27=1;
                break;
            case EOL:
            case ID:
            case MISC:
            case WS:
            case SH_STYLE_SINGLE_LINE_COMMENT:
            case C_STYLE_SINGLE_LINE_COMMENT:
            case MULTI_LINE_COMMENT:
            case 14:
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
                alt27=2;
                break;
            default:

                NoViableAltException nvae =
                    new NoViableAltException("190:41: (lc= literal_constraint | rvc= retval_constraint )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:190:49: lc= literal_constraint
                    {

                    following.push(FOLLOW_literal_constraint_in_constraint806);
                    lc=literal_constraint();
                    following.pop();


                     d = new LiteralDescr( f.getText(), op.getText(), lc ); 

                    }
                    break;
                case 2 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:191:49: rvc= retval_constraint
                    {

                    following.push(FOLLOW_retval_constraint_in_constraint819);
                    rvc=retval_constraint();
                    following.pop();


                     d = new ReturnValueDescr( f.getText(), op.getText(), rvc ); 

                    }
                    break;

            }


            following.push(FOLLOW_opt_eol_in_constraint833);
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

        return d;

    }
    // $ANTLR end constraint



    // $ANTLR start literal_constraint
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:196:1: literal_constraint returns [String text] : (t= STRING | t= INT | t= FLOAT ) ;
    public String literal_constraint() throws RecognitionException {   

        String text;
        Token t=null;


        		text = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:200:17: ( (t= STRING | t= INT | t= FLOAT ) )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:200:17: (t= STRING | t= INT | t= FLOAT )
            {

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:200:17: (t= STRING | t= INT | t= FLOAT )
            int alt28=3;
            switch ( input.LA(1) ) {
            case STRING:
                alt28=1;
                break;
            case INT:
                alt28=2;
                break;
            case FLOAT:
                alt28=3;
                break;
            default:

                NoViableAltException nvae =
                    new NoViableAltException("200:17: (t= STRING | t= INT | t= FLOAT )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:200:25: t= STRING
                    {

                    t=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_literal_constraint859);

                     text = t.getText(); text=text.substring( 1, text.length() - 1 ); 

                    }
                    break;
                case 2 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:201:25: t= INT
                    {

                    t=(Token)input.LT(1);
                    match(input,INT,FOLLOW_INT_in_literal_constraint869);

                     text = t.getText(); 

                    }
                    break;
                case 3 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:202:25: t= FLOAT
                    {

                    t=(Token)input.LT(1);
                    match(input,FLOAT,FOLLOW_FLOAT_in_literal_constraint882);

                     text = t.getText(); 

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



    // $ANTLR start retval_constraint
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:206:1: retval_constraint returns [String text] : c= chunk ;
    public String retval_constraint() throws RecognitionException {   

        String text;

        String c = null;



        		text = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:211:17: (c= chunk )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:211:17: c= chunk
            {

            following.push(FOLLOW_chunk_in_retval_constraint916);
            c=chunk();
            following.pop();


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



    // $ANTLR start chunk
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:214:1: chunk returns [String text] : ( (any= . ) | ( '(' c= chunk ')' ) )* ;
    public String chunk() throws RecognitionException {   

        String text;
        Token any=null;
        String c = null;



        		text = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:218:17: ( ( (any= . ) | ( '(' c= chunk ')' ) )* )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:218:17: ( (any= . ) | ( '(' c= chunk ')' ) )*
            {

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:218:17: ( (any= . ) | ( '(' c= chunk ')' ) )*
            loop29:
            do {
                int alt29=3;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:218:25: (any= . )
            	    {

            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:218:25: (any= . )
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:218:27: any= .
            	    {

            	    any=(Token)input.LT(1);
            	    matchAny(input);


            	    					if ( text == null ) {
            	    						text = any.getText();
            	    					} else {
            	    						text = text + " " + any.getText(); 
            	    					} 
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:225:25: ( '(' c= chunk ')' )
            	    {

            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:225:25: ( '(' c= chunk ')' )
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:225:27: '(' c= chunk ')'
            	    {

            	    match(input,29,FOLLOW_29_in_chunk957);

            	    following.push(FOLLOW_chunk_in_chunk961);
            	    c=chunk();
            	    following.pop();


            	    match(input,30,FOLLOW_30_in_chunk963);


            	    							if ( text == null ) {
            	    								text = "( " + c + " )";
            	    							} else {
            	    								text = text + " ( " + c + " )";
            	    							}
            	    						

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // $ANTLR end chunk



    // $ANTLR start field_binding
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:236:1: field_binding : /* epsilon */ ;
    public void field_binding() throws RecognitionException {   




        // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:238:9: ( /* epsilon */ )
        // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:238:9: /* epsilon */
        {



        }



    }
    // $ANTLR end field_binding



    // $ANTLR start lhs_or
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:240:1: lhs_or returns [PatternDescr d] : left= lhs_and ( ('or'|'||')right= lhs_and )* ;
    public PatternDescr lhs_or() throws RecognitionException {   

        PatternDescr d;

        PatternDescr left = null;

        PatternDescr right = null;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:245:17: (left= lhs_and ( ('or'|'||')right= lhs_and )* )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:245:17: left= lhs_and ( ('or'|'||')right= lhs_and )*
            {

             OrDescr or = null; 

            following.push(FOLLOW_lhs_and_in_lhs_or1015);
            left=lhs_and();
            following.pop();


            d = left; 

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:247:17: ( ('or'|'||')right= lhs_and )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);
                if ( (LA30_0>=37 && LA30_0<=38) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:247:25: ('or'|'||')right= lhs_and
            	    {

            	    if ( (input.LA(1)>=37 && input.LA(1)<=38) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_lhs_or1025);    throw mse;
            	    }


            	    following.push(FOLLOW_lhs_and_in_lhs_or1036);
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

        return d;

    }
    // $ANTLR end lhs_or



    // $ANTLR start lhs_and
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:261:1: lhs_and returns [PatternDescr d] : left= lhs_unary ( ('and'|'&&')right= lhs_unary )* ;
    public PatternDescr lhs_and() throws RecognitionException {   

        PatternDescr d;

        PatternDescr left = null;

        PatternDescr right = null;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:266:17: (left= lhs_unary ( ('and'|'&&')right= lhs_unary )* )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:266:17: left= lhs_unary ( ('and'|'&&')right= lhs_unary )*
            {

             AndDescr and = null; 

            following.push(FOLLOW_lhs_unary_in_lhs_and1076);
            left=lhs_unary();
            following.pop();


             d = left; 

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:268:17: ( ('and'|'&&')right= lhs_unary )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);
                if ( (LA31_0>=39 && LA31_0<=40) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:268:25: ('and'|'&&')right= lhs_unary
            	    {

            	    if ( (input.LA(1)>=39 && input.LA(1)<=40) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_lhs_and1085);    throw mse;
            	    }


            	    following.push(FOLLOW_lhs_unary_in_lhs_and1096);
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
            	    break loop31;
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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:282:1: lhs_unary returns [PatternDescr d] : (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' u= lhs ')' ) ;
    public PatternDescr lhs_unary() throws RecognitionException {   

        PatternDescr d;

        PatternDescr u = null;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:286:17: ( (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' u= lhs ')' ) )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:286:17: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' u= lhs ')' )
            {

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:286:17: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | '(' u= lhs ')' )
            int alt32=5;
            switch ( input.LA(1) ) {
            case 41:
                alt32=1;
                break;
            case 42:
                alt32=2;
                break;
            case 43:
                alt32=3;
                break;
            case ID:
                alt32=4;
                break;
            case 29:
                alt32=5;
                break;
            default:

                NoViableAltException nvae =
                    new NoViableAltException("286:17: (u= lhs_exist | u= lhs_not | u= lhs_eval | u= lhs_column | \'(\' u= lhs \')\' )", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:286:25: u= lhs_exist
                    {

                    following.push(FOLLOW_lhs_exist_in_lhs_unary1134);
                    u=lhs_exist();
                    following.pop();


                    }
                    break;
                case 2 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:287:25: u= lhs_not
                    {

                    following.push(FOLLOW_lhs_not_in_lhs_unary1142);
                    u=lhs_not();
                    following.pop();


                    }
                    break;
                case 3 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:288:25: u= lhs_eval
                    {

                    following.push(FOLLOW_lhs_eval_in_lhs_unary1150);
                    u=lhs_eval();
                    following.pop();


                    }
                    break;
                case 4 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:289:25: u= lhs_column
                    {

                    following.push(FOLLOW_lhs_column_in_lhs_unary1158);
                    u=lhs_column();
                    following.pop();


                    }
                    break;
                case 5 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:290:25: '(' u= lhs ')'
                    {

                    match(input,29,FOLLOW_29_in_lhs_unary1164);

                    following.push(FOLLOW_lhs_in_lhs_unary1168);
                    u=lhs();
                    following.pop();


                    match(input,30,FOLLOW_30_in_lhs_unary1170);

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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:294:1: lhs_exist returns [PatternDescr d] : 'exists' column= lhs_column ;
    public PatternDescr lhs_exist() throws RecognitionException {   

        PatternDescr d;

        ColumnDescr column = null;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:298:17: ( 'exists' column= lhs_column )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:298:17: 'exists' column= lhs_column
            {

            match(input,41,FOLLOW_41_in_lhs_exist1198);

            following.push(FOLLOW_lhs_column_in_lhs_exist1202);
            column=lhs_column();
            following.pop();


             d = new ExistsDescr( column ); 

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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:301:1: lhs_not returns [NotDescr d] : 'not' column= lhs_column ;
    public NotDescr lhs_not() throws RecognitionException {   

        NotDescr d;

        ColumnDescr column = null;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:305:17: ( 'not' column= lhs_column )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:305:17: 'not' column= lhs_column
            {

            match(input,42,FOLLOW_42_in_lhs_not1227);

            following.push(FOLLOW_lhs_column_in_lhs_not1231);
            column=lhs_column();
            following.pop();


             d = new NotDescr( column ); 

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
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:308:1: lhs_eval returns [PatternDescr d] : 'eval' ;
    public PatternDescr lhs_eval() throws RecognitionException {   

        PatternDescr d;



        		d = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:312:17: ( 'eval' )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:312:17: 'eval'
            {

            match(input,43,FOLLOW_43_in_lhs_eval1254);

             d = new EvalDescr( "" ); 

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



    // $ANTLR start java_package_or_class
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:315:1: java_package_or_class returns [String name] : id= ID ( '.' id= ID )* ;
    public String java_package_or_class() throws RecognitionException {   

        String name;
        Token id=null;


        		name = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:320:17: (id= ID ( '.' id= ID )* )
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:320:17: id= ID ( '.' id= ID )*
            {

            id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_java_package_or_class1283);

             name=id.getText(); 

            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:320:46: ( '.' id= ID )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);
                if ( LA33_0==15 ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:320:48: '.' id= ID
            	    {

            	    match(input,15,FOLLOW_15_in_java_package_or_class1289);

            	    id=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_java_package_or_class1293);

            	     name = name + "." + id.getText(); 

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // $ANTLR end java_package_or_class



    // $ANTLR start word
    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:324:1: word returns [String word] : (id= ID | 'import' | 'use' | 'rule' | 'salience' | 'no-loop' | 'when' | 'then' | 'end' | str= STRING );
    public String word() throws RecognitionException {   

        String word;
        Token id=null;
        Token str=null;


        		word = null;
        	
        try {
            // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:328:17: (id= ID | 'import' | 'use' | 'rule' | 'salience' | 'no-loop' | 'when' | 'then' | 'end' | str= STRING )
            int alt34=10;
            switch ( input.LA(1) ) {
            case ID:
                alt34=1;
                break;
            case 17:
                alt34=2;
                break;
            case 18:
                alt34=3;
                break;
            case 20:
                alt34=4;
                break;
            case 27:
                alt34=5;
                break;
            case 28:
                alt34=6;
                break;
            case 21:
                alt34=7;
                break;
            case 23:
                alt34=8;
                break;
            case 24:
                alt34=9;
                break;
            case STRING:
                alt34=10;
                break;
            default:

                NoViableAltException nvae =
                    new NoViableAltException("324:1: word returns [String word] : (id= ID | \'import\' | \'use\' | \'rule\' | \'salience\' | \'no-loop\' | \'when\' | \'then\' | \'end\' | str= STRING );", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:328:17: id= ID
                    {

                    id=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_word1323);

                     word=id.getText(); 

                    }
                    break;
                case 2 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:329:17: 'import'
                    {

                    match(input,17,FOLLOW_17_in_word1335);

                     word="import"; 

                    }
                    break;
                case 3 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:330:17: 'use'
                    {

                    match(input,18,FOLLOW_18_in_word1344);

                     word="use"; 

                    }
                    break;
                case 4 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:331:17: 'rule'
                    {

                    match(input,20,FOLLOW_20_in_word1356);

                     word="rule"; 

                    }
                    break;
                case 5 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:332:17: 'salience'
                    {

                    match(input,27,FOLLOW_27_in_word1367);

                     word="salience"; 

                    }
                    break;
                case 6 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:333:17: 'no-loop'
                    {

                    match(input,28,FOLLOW_28_in_word1375);

                     word="no-loop"; 

                    }
                    break;
                case 7 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:334:17: 'when'
                    {

                    match(input,21,FOLLOW_21_in_word1383);

                     word="when"; 

                    }
                    break;
                case 8 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:335:17: 'then'
                    {

                    match(input,23,FOLLOW_23_in_word1394);

                     word="then"; 

                    }
                    break;
                case 9 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:336:17: 'end'
                    {

                    match(input,24,FOLLOW_24_in_word1405);

                     word="end"; 

                    }
                    break;
                case 10 :
                    // /Users/bob/Documents/workspace/jbossrules/drools-compiler/src/main/java/org/drools/lang/drl.g:337:17: str= STRING
                    {

                    str=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_word1419);

                     word=str.getText(); word=word.substring( 1, word.length()-1 ); 

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


    protected DFA15 dfa15 = new DFA15();protected DFA21 dfa21 = new DFA21();protected DFA24 dfa24 = new DFA24();protected DFA25 dfa25 = new DFA25();protected DFA26 dfa26 = new DFA26();protected DFA29 dfa29 = new DFA29();
    class DFA15 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=1;}};
        DFA.State s8 = new DFA.State() {{alt=2;}};
        DFA.State s16 = new DFA.State() {{alt=1;}};
        DFA.State s17 = new DFA.State() {{alt=1;}};
        DFA.State s18 = new DFA.State() {{alt=1;}};
        DFA.State s19 = new DFA.State() {{alt=1;}};
        DFA.State s20 = new DFA.State() {{alt=1;}};
        DFA.State s21 = new DFA.State() {{alt=1;}};
        DFA.State s22 = new DFA.State() {{alt=1;}};
        DFA.State s23 = new DFA.State() {{alt=1;}};
        DFA.State s24 = new DFA.State() {{alt=1;}};
        DFA.State s25 = new DFA.State() {{alt=1;}};
        DFA.State s7 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                case INT:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
                case 15:
                case 16:
                case 19:
                case 22:
                case 25:
                case 26:
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
                    return s2;

                case ID:
                    return s16;

                case 17:
                    return s17;

                case 18:
                    return s18;

                case 20:
                    return s19;

                case 27:
                    return s20;

                case 28:
                    return s21;

                case 21:
                    return s22;

                case 23:
                    return s23;

                case 24:
                    return s24;

                case STRING:
                    return s25;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 7, input);

                    throw nvae;        }
            }
        };
        DFA.State s6 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case ID:
                case INT:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    return s2;

                case -1:
                    return s8;

                case EOL:
                    return s6;

                case 20:
                    return s7;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 6, input);

                    throw nvae;        }
            }
        };
        DFA.State s3 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s6;

                case 20:
                    return s7;

                case -1:
                    return s8;

                case ID:
                case INT:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    return s2;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;        }
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA15_1 = input.LA(1);
                if ( LA15_1==24 ) {return s3;}
                if ( (LA15_1>=EOL && LA15_1<=23)||(LA15_1>=25 && LA15_1<=43) ) {return s2;}


                NoViableAltException nvae =
        	    new NoViableAltException("", 15, 1, input);

                throw nvae;
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA15_0 = input.LA(1);
                if ( LA15_0==EOL ) {return s1;}
                if ( (LA15_0>=ID && LA15_0<=43) ) {return s2;}


                NoViableAltException nvae =
        	    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
        };

    }class DFA21 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s4 = new DFA.State() {{alt=1;}};
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 21:
                case 23:
                case 24:
                    return s2;

                case EOL:
                    return s1;

                case 27:
                case 28:
                    return s4;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s1;

                case 21:
                case 23:
                    return s2;

                case 26:
                case 27:
                case 28:
                    return s4;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA24 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s4 = new DFA.State() {{alt=2;}};
        DFA.State s2 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 22:
                    return s3;

                case EOL:
                    return s2;

                case 29:
                    return s4;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;        }
            }
        };
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s2;

                case 22:
                    return s3;

                case 29:
                    return s4;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA24_0 = input.LA(1);
                if ( LA24_0==ID ) {return s1;}


                NoViableAltException nvae =
        	    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
        };

    }class DFA25 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s3 = new DFA.State() {{alt=2;}};
        DFA.State s2 = new DFA.State() {{alt=1;}};
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 30:
                    return s3;

                case EOL:
                    return s1;

                case ID:
                    return s2;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s1;

                case ID:
                    return s2;

                case 30:
                    return s3;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA26 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s2 = new DFA.State() {{alt=2;}};
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s1 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case 30:
                    return s2;

                case EOL:
                    return s1;

                case 26:
                    return s3;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;        }
            }
        };
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s1;

                case 30:
                    return s2;

                case 26:
                    return s3;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 0, input);

                    throw nvae;        }
            }
        };

    }class DFA29 extends DFA {
        public int predict(IntStream input) throws RecognitionException {
            return predict(input, s0);
        }
        DFA.State s1 = new DFA.State() {{alt=1;}};
        DFA.State s4 = new DFA.State() {{alt=1;}};
        DFA.State s22 = new DFA.State() {{alt=1;}};
        DFA.State s18 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                int LA29_18 = input.LA(1);
                if ( LA29_18==EOL ) {return s18;}
                if ( (LA29_18>=ID && LA29_18<=43) ) {return s22;}


                NoViableAltException nvae =
        	    new NoViableAltException("", 29, 18, input);

                throw nvae;
            }
        };
        DFA.State s10 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s18;

                case 26:
                case 29:
                case 30:
                    return s4;

                case ID:
                case INT:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
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
                case 27:
                case 28:
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
                    return s22;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 10, input);

                    throw nvae;        }
            }
        };
        DFA.State s6 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s6;

                case INT:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
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
                    return s4;

                case ID:
                    return s10;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 6, input);

                    throw nvae;        }
            }
        };
        DFA.State s2 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s6;

                case INT:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
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
                    return s4;

                case ID:
                    return s10;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 2, input);

                    throw nvae;        }
            }
        };
        DFA.State s3 = new DFA.State() {{alt=1;}};
        DFA.State s0 = new DFA.State() {
            public DFA.State transition(IntStream input) throws RecognitionException {
                switch ( input.LA(1) ) {
                case EOL:
                    return s1;

                case 26:
                    return s2;

                case 30:
                    return s3;

                case ID:
                case INT:
                case STRING:
                case FLOAT:
                case MISC:
                case WS:
                case SH_STYLE_SINGLE_LINE_COMMENT:
                case C_STYLE_SINGLE_LINE_COMMENT:
                case MULTI_LINE_COMMENT:
                case 14:
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
                case 27:
                case 28:
                case 29:
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
                    return s4;

                default:

                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 0, input);

                    throw nvae;        }
            }
        };

    }


    public static final BitSet FOLLOW_EOL_in_opt_eol40 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_prolog_in_compilation_unit53 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_rule_in_compilation_unit61 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_prolog83 = new BitSet(new long[]{16402L});
    public static final BitSet FOLLOW_package_statement_in_prolog91 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_prolog100 = new BitSet(new long[]{131090L});
    public static final BitSet FOLLOW_import_statement_in_prolog112 = new BitSet(new long[]{131090L});
    public static final BitSet FOLLOW_opt_eol_in_prolog121 = new BitSet(new long[]{262162L});
    public static final BitSet FOLLOW_use_expander_in_prolog125 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_prolog130 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_14_in_package_statement151 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_package_statement153 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_ID_in_package_statement157 = new BitSet(new long[]{98322L});
    public static final BitSet FOLLOW_15_in_package_statement163 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_ID_in_package_statement167 = new BitSet(new long[]{98322L});
    public static final BitSet FOLLOW_16_in_package_statement174 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_package_statement177 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_17_in_import_statement200 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_import_statement202 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_java_package_or_class_in_import_statement206 = new BitSet(new long[]{65554L});
    public static final BitSet FOLLOW_16_in_import_statement208 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_import_statement213 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_18_in_use_expander225 = new BitSet(new long[]{524288L});
    public static final BitSet FOLLOW_19_in_use_expander227 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_ID_in_use_expander229 = new BitSet(new long[]{65554L});
    public static final BitSet FOLLOW_16_in_use_expander231 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_use_expander234 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_opt_eol_in_rule258 = new BitSet(new long[]{1048576L});
    public static final BitSet FOLLOW_20_in_rule264 = new BitSet(new long[]{431358112L});
    public static final BitSet FOLLOW_word_in_rule268 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_rule270 = new BitSet(new long[]{44040208L});
    public static final BitSet FOLLOW_rule_options_in_rule279 = new BitSet(new long[]{10485776L});
    public static final BitSet FOLLOW_21_in_rule288 = new BitSet(new long[]{4194322L});
    public static final BitSet FOLLOW_22_in_rule290 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_rule293 = new BitSet(new long[]{15393708048432L});
    public static final BitSet FOLLOW_lhs_in_rule307 = new BitSet(new long[]{15393708048432L});
    public static final BitSet FOLLOW_23_in_rule323 = new BitSet(new long[]{17592186044400L});
    public static final BitSet FOLLOW_22_in_rule325 = new BitSet(new long[]{17592186044400L});
    public static final BitSet FOLLOW_EOL_in_rule360 = new BitSet(new long[]{16777216L});
    public static final BitSet FOLLOW_24_in_rule362 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_rule364 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_25_in_rule_options375 = new BitSet(new long[]{4194322L});
    public static final BitSet FOLLOW_22_in_rule_options377 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_rule_options380 = new BitSet(new long[]{402653184L});
    public static final BitSet FOLLOW_salience_in_rule_options387 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_no_loop_in_rule_options391 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_rule_options395 = new BitSet(new long[]{67108882L});
    public static final BitSet FOLLOW_26_in_rule_options399 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_rule_options402 = new BitSet(new long[]{402653184L});
    public static final BitSet FOLLOW_salience_in_rule_options406 = new BitSet(new long[]{67108882L});
    public static final BitSet FOLLOW_no_loop_in_rule_options410 = new BitSet(new long[]{67108882L});
    public static final BitSet FOLLOW_opt_eol_in_rule_options417 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_27_in_salience432 = new BitSet(new long[]{64L});
    public static final BitSet FOLLOW_INT_in_salience434 = new BitSet(new long[]{65554L});
    public static final BitSet FOLLOW_16_in_salience436 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_salience439 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_28_in_no_loop453 = new BitSet(new long[]{65554L});
    public static final BitSet FOLLOW_16_in_no_loop455 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_no_loop458 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_lhs_or_in_lhs484 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_fact_binding_in_lhs_column511 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_fact_in_lhs_column520 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_ID_in_fact_binding552 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact_binding554 = new BitSet(new long[]{4194304L});
    public static final BitSet FOLLOW_22_in_fact_binding556 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact_binding558 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_fact_in_fact_binding562 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact_binding566 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_ID_in_fact598 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact602 = new BitSet(new long[]{536870912L});
    public static final BitSet FOLLOW_29_in_fact608 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact610 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_constraints_in_fact616 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact635 = new BitSet(new long[]{1073741824L});
    public static final BitSet FOLLOW_30_in_fact637 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_fact639 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_opt_eol_in_constraints665 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_constraint_in_constraints671 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_constraints680 = new BitSet(new long[]{67108864L});
    public static final BitSet FOLLOW_26_in_constraints682 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_constraints684 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_constraint_in_constraints688 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_constraints697 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_opt_eol_in_constraint719 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_ID_in_constraint725 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_constraint727 = new BitSet(new long[]{135291469824L});
    public static final BitSet FOLLOW_set_in_constraint734 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_constraint788 = new BitSet(new long[]{17592186044402L});
    public static final BitSet FOLLOW_literal_constraint_in_constraint806 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_retval_constraint_in_constraint819 = new BitSet(new long[]{18L});
    public static final BitSet FOLLOW_opt_eol_in_constraint833 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_STRING_in_literal_constraint859 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_INT_in_literal_constraint869 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_FLOAT_in_literal_constraint882 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_chunk_in_retval_constraint916 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_29_in_chunk957 = new BitSet(new long[]{17592186044402L});
    public static final BitSet FOLLOW_chunk_in_chunk961 = new BitSet(new long[]{1073741824L});
    public static final BitSet FOLLOW_30_in_chunk963 = new BitSet(new long[]{17592186044402L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or1015 = new BitSet(new long[]{412316860418L});
    public static final BitSet FOLLOW_set_in_lhs_or1025 = new BitSet(new long[]{15393699659808L});
    public static final BitSet FOLLOW_lhs_and_in_lhs_or1036 = new BitSet(new long[]{412316860418L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and1076 = new BitSet(new long[]{1649267441666L});
    public static final BitSet FOLLOW_set_in_lhs_and1085 = new BitSet(new long[]{15393699659808L});
    public static final BitSet FOLLOW_lhs_unary_in_lhs_and1096 = new BitSet(new long[]{1649267441666L});
    public static final BitSet FOLLOW_lhs_exist_in_lhs_unary1134 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_lhs_not_in_lhs_unary1142 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_lhs_eval_in_lhs_unary1150 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_unary1158 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_29_in_lhs_unary1164 = new BitSet(new long[]{15393699659808L});
    public static final BitSet FOLLOW_lhs_in_lhs_unary1168 = new BitSet(new long[]{1073741824L});
    public static final BitSet FOLLOW_30_in_lhs_unary1170 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_41_in_lhs_exist1198 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_exist1202 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_42_in_lhs_not1227 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_lhs_column_in_lhs_not1231 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_43_in_lhs_eval1254 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_ID_in_java_package_or_class1283 = new BitSet(new long[]{32770L});
    public static final BitSet FOLLOW_15_in_java_package_or_class1289 = new BitSet(new long[]{32L});
    public static final BitSet FOLLOW_ID_in_java_package_or_class1293 = new BitSet(new long[]{32770L});
    public static final BitSet FOLLOW_ID_in_word1323 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_17_in_word1335 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_18_in_word1344 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_20_in_word1356 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_27_in_word1367 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_28_in_word1375 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_21_in_word1383 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_23_in_word1394 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_24_in_word1405 = new BitSet(new long[]{2L});
    public static final BitSet FOLLOW_STRING_in_word1419 = new BitSet(new long[]{2L});

}