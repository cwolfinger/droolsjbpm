package org.drools.guvnor.client.modeldriven.brl;


public class ExpressionField extends ExpressionPart {
	private String fieldName;
	private String fieldType; 
	
	@SuppressWarnings("unused")
	private ExpressionField() {}

	public ExpressionField(String fieldName, String fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}

	@Override
	public String getText() {
		return "." + getFieldName() + (getNext() == null ? "" : getNext().getText());
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}
	
	@Override
	public String getType() {
		return fieldType;
	}

	@Override
	public String getName() {
		return getFieldName();
	}
}
