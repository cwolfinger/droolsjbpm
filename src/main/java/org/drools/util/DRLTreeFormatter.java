package org.drools.util;

import org.antlr.runtime.tree.CommonTree;

public class DRLTreeFormatter {

	public static String toIndentedStringTree(CommonTree tree) {
		String ts = new String(tree.toStringTree());		
		
		//ts = ts.substring(0, ts.indexOf("then"));
		StringBuilder sb = new StringBuilder();
		int dep = 0;
		for (int j = 0; j < ts.length(); j++) {			
			if (ts.charAt(j) == '(') {
				dep++;
				
				sb.append("\n");
				for (int k = 0; k < dep; k++)
					sb.append("\t");
				sb.append(ts.charAt(j));
				
			} else
			if (ts.charAt(j) == ')') {				
				sb.append("\n");
				for (int k = 0; k < dep; k++)
					sb.append("\t");
				sb.append(ts.charAt(j));
				dep--;				
			} else {
				sb.append(ts.charAt(j));
			}
		}
	
		return sb.toString();
	}
	
}
