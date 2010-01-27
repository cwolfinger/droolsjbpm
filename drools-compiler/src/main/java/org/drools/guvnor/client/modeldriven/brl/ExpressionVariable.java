package org.drools.guvnor.client.modeldriven.brl;


public class ExpressionVariable extends ExpressionPart {
	private FactPattern fact;
	
	@SuppressWarnings("unused")
	private ExpressionVariable() {}

	public ExpressionVariable(FactPattern fact) {
		if (!fact.isBound()) {
			throw new RuntimeException("the fact is not bounded: " + fact);
		}
		this.fact = fact;
	}

	@Override
	public String getText() {
		return fact.boundName + (getNext() != null ? getNext().getText() : "");
	}

	public FactPattern getFact() {
		return fact;
	}

	@Override
	public String getType() {
		return fact.factType;
	}
	
	@Override
	public String getName() {
		return fact.boundName;
	}
}
