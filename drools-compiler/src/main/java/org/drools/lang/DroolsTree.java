package org.drools.lang;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 * An extension of the CommonTree class that keeps the char offset information.
 * 
 * @author porcelli
 * 
 */
public class DroolsTree extends CommonTree {

	/**
	 * start char offset
	 */
	int startCharOffset = -1;

	/**
	 * end char offset
	 */
	int endCharOffset = -1;

	/**
	 * editor type
	 * 
	 * @see DroolsEditorType
	 */
	DroolsEditorType editorElementType = DroolsEditorType.IDENTIFIER;

	public DroolsTree(DroolsTree node) {
		super(node);
		this.token = node.token;
	}

	public DroolsTree(Token token) {
		super(token);
	}

	public Tree dupNode() {
		return new DroolsTree(this);
	}

	/**
	 * getter for start char offset
	 * 
	 * @return start char offset
	 */
	public int getStartCharOffset() {
		return startCharOffset;
	}

	/**
	 * setter for start char offset
	 * 
	 * @param startCharOffset
	 *            start char offset
	 */
	public void setStartCharOffset(int startCharOffset) {
		this.startCharOffset = startCharOffset;
	}

	/**
	 * getter of end char offset
	 * 
	 * @return end char offset
	 */
	public int getEndCharOffset() {
		return endCharOffset;
	}

	/**
	 * setter of end char offset
	 * 
	 * @param endCharOffset
	 *            end char offset
	 */
	public void setEndCharOffset(int endCharOffset) {
		this.endCharOffset = endCharOffset;
	}

	/**
	 * getter of editor type
	 * 
	 * @return editor type
	 * @see DroolsEditorType
	 */
	public DroolsEditorType getEditorElementType() {
		return editorElementType;
	}

	/**
	 * setter of editor type
	 * 
	 * @param editorElementType
	 *            editor type
	 * @see DroolsEditorType
	 */
	public void setEditorElementType(DroolsEditorType editorElementType) {
		this.editorElementType = editorElementType;
	}
	
	
	
	public String toIndentedStringTree() {
		String ts = new String(this.toStringTree());
		
//		System.out.println(this.toStringTree().hashCode());
//		System.out.println(ts.hashCode());
//		System.out.println(ts == this.toStringTree());
		
		ts = ts.substring(0, ts.indexOf("then"));
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