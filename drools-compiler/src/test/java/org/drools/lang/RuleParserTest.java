package org.drools.lang;

import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.drools.lang.descr.AndDescr;
import org.drools.lang.descr.ColumnDescr;
import org.drools.lang.descr.LiteralDescr;
import org.drools.lang.descr.RuleDescr;

public class RuleParserTest extends TestCase {
	
	private RuleParser parser;
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPackage_OneSegment() throws Exception {
		String packageName = parse( "package foo" ).package_statement();
		assertEquals( "foo", packageName );
	}
	
	public void testPackage_MultipleSegments() throws Exception {
		String packageName = parse( "package foo.bar.baz;" ).package_statement();
		assertEquals( "foo.bar.baz", packageName );
	}
	
	public void testImportStatement() throws Exception {
		String name = parse( "import com.foo.Bar;" ).import_statement();
		assertEquals( "com.foo.Bar", name );
	}
	
	public void testProlog() throws Exception {
		parse( "package foo; import com.foo.Bar; import com.foo.Baz;" ).prolog();
		assertEquals( "foo", parser.getPackageDescr().getName() );
		assertEquals( 2, parser.getPackageDescr().getImports().size() );
		assertEquals( "com.foo.Bar", parser.getPackageDescr().getImports().get( 0 ) );
		assertEquals( "com.foo.Baz", parser.getPackageDescr().getImports().get( 1 ) );
	}
	
	public void testEmptyRule() throws Exception {
		RuleDescr rule = parseResource( "empty_rule.drl" ).rule();
		
		assertNotNull( rule );
		
		assertEquals( "empty", rule.getName() );
		assertNull( rule.getLhs() );
		assertNull( rule.getConsequence() );
	}
	
	public void testAlmostEmptyRule() throws Exception {
		RuleDescr rule = parseResource( "almost_empty_rule.drl" ).rule();
		
		assertNotNull( rule );
		
		assertEquals( "almost_empty", rule.getName() );
		assertNotNull( rule.getLhs() );
		assertEquals( "", rule.getConsequence().trim() );
	}
	
	public void testQuotedStringNameRule() throws Exception {
		RuleDescr rule = parseResource( "quoted_string_name_rule.drl" ).rule();
		
		assertNotNull( rule );
		
		assertEquals( "quoted string name", rule.getName() );
		assertNotNull( rule.getLhs() );
		assertEquals( "", rule.getConsequence().trim() );
	}
	
	public void testChunkWithoutParens() throws Exception {
		String chunk = parse( "foo" ).chunk();
		
		assertEquals( "foo", chunk );
	}
	
	public void testChunkWithParens() throws Exception {
		String chunk = parse( "fnord()" ).chunk();
		
		assertEqualsIgnoreWhitespace( "fnord()", chunk );
	}
	
	public void testChunkWithParensAndQuotedString() throws Exception {
		String chunk = parse( "fnord(\"cheese\")" ).chunk();
		
		assertEqualsIgnoreWhitespace( "fnord(\"cheese\")", chunk );
	}
	
	public void testChunkWithRandomCharac5ters() throws Exception {
		String chunk = parse( "%*9dkj" ).chunk();
		
		assertEqualsIgnoreWhitespace( "%*9dkj", chunk );
	}
	
	public void testSimpleRule() throws Exception {
		RuleDescr rule = parseResource( "simple_rule.drl" ).rule();
		
		assertNotNull( rule );
		
		assertEquals( "simple_rule", rule.getName() );
		
		AndDescr lhs = rule.getLhs();
		
		assertNotNull( lhs );
		
		assertEquals( 2, lhs.getDescrs().size() );
		
		ColumnDescr first = (ColumnDescr) lhs.getDescrs().get( 0 );
		ColumnDescr second = (ColumnDescr) lhs.getDescrs().get( 1 );
		
		assertEquals( "foo", first.getIdentifier() );
		assertEquals( "Bar", first.getObjectType() );
		
		assertEquals( 1, first.getDescrs().size() );
		
		LiteralDescr constraint = (LiteralDescr) first.getDescrs().get( 0 );
		
		assertNotNull( constraint );
		
		assertEquals( "a", constraint.getFieldName() );
		assertEquals( "==", constraint.getEvaluator() );
		assertEquals( "3", constraint.getText() );
		
		assertNull( second.getIdentifier() );
		assertEquals( "Baz", second.getObjectType() );
		
		assertEqualsIgnoreWhitespace( 
				"if ( a == b ) { " +
				"  assert( foo );" +
				"} else {" +
				"  retract( foo );" +
				"}", 
				rule.getConsequence() );
	}
	
	private RuleParser parse(String text) throws Exception {
		parser = newParser( newTokenStream( newLexer( newCharStream( text ) ) ) );
		return parser;
	}
	
	private RuleParser parseResource(String name) throws Exception {
		
		InputStream in = getClass().getResourceAsStream( name );
		
		InputStreamReader reader = new InputStreamReader( in );
		
		StringBuffer text = new StringBuffer();
		
		char[] buf = new char[1024];
		int len = 0;
		
		while ( ( len = reader.read( buf ) ) >= 0 ) {
			text.append( buf, 0, len );
		}
		
		return parse( text.toString() );
	}
	
	private CharStream newCharStream(String text) {
		return new ANTLRStringStream( text );
	}
	
	private RuleParserLexer newLexer(CharStream charStream) {
		return new RuleParserLexer( charStream );
	}
	
	private TokenStream newTokenStream(Lexer lexer) {
		return new CommonTokenStream( lexer );
	}
	
	private RuleParser newParser(TokenStream tokenStream) {
		return new RuleParser( tokenStream );
	}
	
	private void assertEqualsIgnoreWhitespace(String expected, String actual) {
		String cleanExpected = expected.replaceAll( "\\s+", "" );
		String cleanActual   = actual.replaceAll( "\\s+", "" );
		
		assertEquals( cleanExpected, cleanActual );
	}

}
