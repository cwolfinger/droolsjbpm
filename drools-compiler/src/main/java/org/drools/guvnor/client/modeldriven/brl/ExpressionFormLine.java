package org.drools.guvnor.client.modeldriven.brl;

import java.util.LinkedList;

public class ExpressionFormLine implements IAction, IPattern {
	
    private LinkedList<ExpressionPart> parts = new LinkedList<ExpressionPart>() ;
    
    public ExpressionFormLine() {}

	public String getText() {
		return parts.isEmpty() ? "" : parts.getFirst().getText();
	}
	
	public void appendPart(ExpressionPart part) {
		if (!parts.isEmpty()) {
			parts.getLast().setNext(part);
		}
		parts.add(part);
	}
	
	public void removeLast() {
		if (!parts.isEmpty()) {
			parts.removeLast();
		}
	}
	
	public String getPreviousType() {
		ExpressionPart last = parts.getLast();
		return last.getPrevious() == null ? null : last.getPrevious().getType(); 
	}
	
	public String getType() {
		return parts.getLast().getType();
	}
}
