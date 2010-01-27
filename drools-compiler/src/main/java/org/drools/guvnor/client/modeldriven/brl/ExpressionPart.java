package org.drools.guvnor.client.modeldriven.brl;

public abstract class ExpressionPart implements IPattern, IAction {
	private ExpressionPart prev;
	private ExpressionPart next;

	public ExpressionPart() {}

	public abstract String getName();
	
	public abstract String getText();

	public abstract String getType();
	
	public ExpressionPart getPrevious() {
		return prev;
	}

	public void setPrevious(ExpressionPart prev) {
		this.prev = prev;
		prev.next = this;
	}

	public ExpressionPart getNext() {
		return next;
	}

	public void setNext(ExpressionPart next) {
		this.next = next;
		next.prev = this;
	}

	@Override
	public String toString() {
		return getText();
	}
}
