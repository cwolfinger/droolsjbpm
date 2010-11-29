package org.drools.lang;


import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.drools.lang.iri.iriLexer;
import org.drools.lang.iri.iriParser;
import org.junit.Test;


public class IRI_Test {


	 
	
	
	
	@Test	
	public void test_iri() {
		String iri = "";
		
		iri = "http://sx.org";
		if (! check(iri)) fail();
		
		iri = "foo://username:password@example.com:8042/over/there/index.dtb?type=animal;name=narwhal#nose"; 
		if (! check(iri)) fail();
		
		iri = "urn:example:animal:ferret:nose";
		if (! check(iri)) fail();
	}
	
	
	protected boolean check(String iri) {
		try {						  		
			iriLexer lexer = new iriLexer( new ANTLRInputStream( new ByteArrayInputStream(iri.getBytes()) ));			
			iriParser parser = new iriParser(new CommonTokenStream( lexer ));						
				parser.iri();
				
			return (parser.getNumberOfSyntaxErrors() == 0);	
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		} catch (RecognitionException e) { 
			e.printStackTrace();
			return false;
		}
			
		
	}
	
		

    
    
    
               
            
    
    
    
    
    
    

	
	
	
	
	
	
}








