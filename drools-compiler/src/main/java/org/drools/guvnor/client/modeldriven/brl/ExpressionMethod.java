package org.drools.guvnor.client.modeldriven.brl;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExpressionMethod extends ExpressionPart {
	private String methodName;
	private String returnType;

	private Map<String, ExpressionPart> params = new LinkedHashMap<String, ExpressionPart>();

	@SuppressWarnings("unused")
	private ExpressionMethod() {
	}
	
	public ExpressionMethod(String methodName, String returnType) {
		super();
		this.methodName = methodName;
		this.returnType = returnType;
	}

	public String getMethodName() {
		return methodName;
	}

	public Map<String, ExpressionPart> getParams() {
		return params;
	}

	public void setParams(Map<String, ExpressionPart> params) {
		this.params = params;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	@Override
	public String getText() {
		return "." + methodName + paramsToString()
				+ (getNext() == null ? "" : getNext().getText());
	}

	private String paramsToString() {
		if (params.isEmpty()) {
			return "()";
		}
		String sep = ", ";
		StringBuilder s = new StringBuilder();
		for (ExpressionPart expr : params.values()) {
			s.append(sep).append(expr.getText());
		}
		return "(" + s.substring(sep.length()) + ")";
	}

	@Override
	public String getType() {
		return returnType;
	}
	
	@Override
	public String getName() {
		return getMethodName();
	}
}
