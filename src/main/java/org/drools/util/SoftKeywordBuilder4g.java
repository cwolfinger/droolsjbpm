package org.drools.util;

public class SoftKeywordBuilder4g {
	
	public static void main(String[] args) {
		
//		String[] kws = {
//				"case",
//				"final",
//				"if",
//				"else",
//				"for",
//				"while",
//				"do",
//				"case",
//				"default",
//				"try",
//				"catch",
//				"finally",
//				"switch",
//				"synchronized",
//				"return",
//				"throw",
//				"break",
//				"continue",
//				"retract",
//				"assert",
//				"update",
//				"modify"								
//		};
		
		String[] kws = {
				"public",
				"protected",
				"private",
				"abstract",
				"native",
				"transient",
				"volatile",
				"strictfp",
				"throws",
				"interface",
				"enum"
				
		};
			
		for (String kw : kws) {
			System.out.println(format(kw));
		}
		
		
		for (String kw : kws) {
			System.out.println("  VK_"+kw.toUpperCase()+";");
		}
		
		
		
	}

	
	
	private static String format(String kw) {
		StringBuilder sb = new StringBuilder();				
		sb.append(kw.toLowerCase()).append("_key\n");
		sb.append("\t:");
		sb.append("\t{(helper.validateIdentifierKey(DroolsSoftKeywords.").append(kw.toUpperCase()).append("))}?=>  id=ID\n");
		sb.append("\t{	helper.emit($id, DroolsEditorType.KEYWORD);	}\n");
		sb.append("\t-> VK_").append(kw.toUpperCase()).append("[$id]\n");
		sb.append(";\n\n");
		return sb.toString();
	}
}
