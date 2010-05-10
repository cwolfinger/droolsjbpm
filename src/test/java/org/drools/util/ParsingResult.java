package org.drools.util;

import org.antlr.runtime.tree.CommonTree;


public class ParsingResult {
	
	private CommonTree tree = null;
	private long parseTime = -1;
	private int numErrors = -1;
	private Exception error = null;
	private String source = null;

	
	public boolean isSuccess() {
		return source != null && numErrors == 0 && error == null;
	}

	public String toString(boolean verbose) {
		StringBuffer buf = new StringBuffer();
		buf.append(">>>> RESULT : ");
			if (error != null) {
				buf.append(" EXCEPTION \n").append(error.toString()).append("\n");
			} else
			if (numErrors > 0) {
				buf.append(" FAILURE ").append(" -- " + numErrors + " errors").append("\n");
			} else {
				buf.append(" SUCCESS \n");
			}
		buf.append(">> TIME to parse " + parseTime).append("\n");	
		
		if (verbose) {
			if (source != null)
			buf.append(">> SOURCE : \n").append(source).append("\n");
			if (tree != null)
			buf.append(">> OUTPUT : \n").append(toIndentedStringTree());
		}
		
		return buf.toString();
		
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	
	
	public String toIndentedStringTree() {
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






	public CommonTree getTree() {
		return tree;
	}






	public void setTree(CommonTree resultTree) {
		this.tree = resultTree;
	}






	public long getParseTime() {
		return parseTime;
	}






	public void setParseTime(long parseTime) {
		this.parseTime = parseTime;
	}






	public int getNumErrors() {
		return numErrors;
	}






	public void setNumErrors(int numErrors) {
		this.numErrors = numErrors;
	}






	public Exception getError() {
		return error;
	}






	public void setError(Exception error) {
		this.error = error;
	}




	public void setSource(String source) {
		this.source = source;
	}




	public String getSource() {
		return source;
	}


	
	
}
