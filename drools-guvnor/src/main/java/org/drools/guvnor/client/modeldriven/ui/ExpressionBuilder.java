package org.drools.guvnor.client.modeldriven.ui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.drools.guvnor.client.common.DirtyableComposite;
import org.drools.guvnor.client.messages.Constants;
import org.drools.guvnor.client.modeldriven.SuggestionCompletionEngine;
import org.drools.guvnor.client.modeldriven.brl.ExpressionField;
import org.drools.guvnor.client.modeldriven.brl.ExpressionFormLine;
import org.drools.guvnor.client.modeldriven.brl.ExpressionMethod;
import org.drools.guvnor.client.modeldriven.brl.ExpressionVariable;
import org.drools.guvnor.client.modeldriven.brl.FactPattern;
import org.drools.guvnor.client.modeldriven.brl.RuleModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.widgets.form.Label;

public class ExpressionBuilder extends DirtyableComposite {

	private static final String FIElD_VALUE_PREFIX = "fl";
	private static final String VARIABLE_VALUE_PREFIX = "va";
	private static final String GLOBAL_COLLECTION_VALUE_PREFIX = "gc";
	private static final String GLOBAL_VARIABLE_VALUE_PREFIX = "gv";
	private static final String METHOD_VALUE_PREFIX = "mt";

	private Constants constants = ((Constants) GWT.create(Constants.class));
	private FlowPanel panel = new FlowPanel();

	private RuleModeller modeller;
	private ExpressionFormLine expression;

	public ExpressionBuilder(RuleModeller modeller,
			ExpressionFormLine expression) {
		super();
		this.expression = expression;
		this.modeller = modeller;
		if (expression == null || expression.getText().isEmpty()) {
			panel.add(createStartPointWidget());
		} else {
			panel.add(new Label(expression.getText()));
			panel.add(getWidgetForCurrentType());
		}
		initWidget(panel);
	}

	private Widget createStartPointWidget() {
		ListBox startPoint = new ListBox();
		panel.add(startPoint);

		startPoint.addItem(constants.ChooseDotDotDot(), "");
		for (String gc : getCompletionEngine().getGlobalCollections()) {
			startPoint.addItem(gc, GLOBAL_COLLECTION_VALUE_PREFIX + "." + gc);
		}

		for (String gv : getCompletionEngine().getGlobalVariables()) {
			startPoint.addItem(gv, GLOBAL_VARIABLE_VALUE_PREFIX + "." + gv);
		}

		for (String v : getRuleModel().getBoundFacts()) {
			startPoint.addItem(v, VARIABLE_VALUE_PREFIX + "." + v);
		}

		startPoint.setVisibleItemCount(1);
		startPoint.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				ListBox lb = (ListBox) sender;
				int index = lb.getSelectedIndex();
				if (index > 0) {
					ExpressionBuilder.this.makeDirty();
					startPointChange(lb.getValue(index));
				}
			}
		});
		return startPoint;
	}

	private void startPointChange(String value) {
		panel.clear();
		Widget w;
		if (value.startsWith(VARIABLE_VALUE_PREFIX)) {
			FactPattern fact = getRuleModel().getBoundFact(
					value.substring(VARIABLE_VALUE_PREFIX.length() + 1));
			ExpressionVariable variable = new ExpressionVariable(fact);
			expression.appendPart(variable);
			w = getWidgetForCurrentType();

			if (!expression.isEmpty()) {
				panel.add(new Label(expression.getText()));
			}
			if (w != null) {
				panel.add(w);
			}
		}

		// panel.add(getWidgetFor(startPoint.getValue(index)));
		// ExpressionBuilder.this.expression.appendText(v);
	}

	private Widget getWidgetForCurrentType() {
		if (expression.isEmpty()) {
			return createStartPointWidget();
		}
		String factName = getCompletionEngine().getFactNameFromType(
				getCurrentType());
		if (factName != null) {
			ListBox lb = new ListBox();
			lb.setVisibleItemCount(1);
			lb.addItem(constants.ChooseDotDotDot(), "");
			lb.addItem("<==" + constants.DeleteItem(), "_delete_");
			for (Map.Entry<String, String> entry : getCompletionsForCurrentType()
					.entrySet()) {
				lb.addItem(entry.getKey(), entry.getValue());
			}

			lb.addChangeListener(new ChangeListener() {
				public void onChange(Widget sender) {
					ListBox box = (ListBox) sender;
					panel.remove(box);
					if (box.getSelectedIndex() > 0) {
						onChangeSelection(box.getValue(box.getSelectedIndex()));
					}
				}
			});
			return lb;
		} else if (isCollection()) {
			ListBox lb = new ListBox();
			lb.setVisibleItemCount(1);
			lb.addItem(constants.ChooseDotDotDot(), "");
			return lb;
		}
		return null;
	}

	private boolean isCollection() {
		String previousType = expression.getPreviousType();
		String factName = getCompletionEngine().getFactNameFromType(
				previousType);
		return true;
	}

	private void onChangeSelection(String value) {
		if ("_delete_".equals(value)) {
			expression.removeLast();
		} else {
			int dotPos = value.indexOf('.');
			String prefix = value.substring(0, dotPos);
			String option = value.substring(dotPos + 1);

			String factName = getCompletionEngine().getFactNameFromType(
					getCurrentType());

			if (FIElD_VALUE_PREFIX.equals(prefix)) {
				String fieldClassName = getCompletionEngine()
						.getFieldClassName(factName, option);
				expression.appendPart(new ExpressionField(option,
						fieldClassName));
			} else if (METHOD_VALUE_PREFIX.equals(prefix)) {
				String methodType = getCompletionEngine().getMethodClassType(
						factName, option);
				expression.appendPart(new ExpressionMethod(option.substring(0,
						option.indexOf('(')), methodType));
			}
		}
		Widget w = getWidgetForCurrentType();

		panel.clear();
		if (!expression.isEmpty()) {
			panel.add(new Label(expression.getText()));
		}
		if (w != null) {
			panel.add(w);
		}
	}

	private Map<String, String> getCompletionsForCurrentType() {
		String factName = getCompletionEngine().getFactNameFromType(
				getCurrentType());
		List<String> methodNames = getCompletionEngine().getMethodFullNames(
				factName);
		Map<String, String> completions = new LinkedHashMap<String, String>();

		for (String field : getCompletionEngine().getFieldCompletions(factName)) {
			boolean changed = false;
			for (Iterator<String> i = methodNames.iterator(); i.hasNext();) {
				String method = i.next();
				if (method.startsWith(field)) {
					completions.put(method, METHOD_VALUE_PREFIX + "." + method);
					i.remove();
					changed = true;
				}
			}
			if (!changed) {
				completions.put(field, FIElD_VALUE_PREFIX + "." + field);
			}
		}
		return completions;
	}

	/*
	 * protected Widget getWidgetFor(String value) { if (value == null ||
	 * value.isEmpty()) { throw new IllegalArgumentException("value is empty");
	 * } if (value.startsWith(VARIABLE_VALUE_PREFIX)) { FactPattern fact =
	 * getRuleModel
	 * ().getBoundFact(value.substring(VARIABLE_VALUE_PREFIX.length() + 1));
	 * 
	 * ListBox lb = new ListBox(); lb.setVisibleItemCount(1);
	 * lb.addItem(constants.ChooseDotDotDot(), "");
	 * 
	 * List<String> methodNames =
	 * getCompletionEngine().getMethodFullNames(fact.factType);
	 * 
	 * for (String field :
	 * getCompletionEngine().getFieldCompletions(fact.factType)) { boolean
	 * changed = false; for (Iterator<String> i = methodNames.iterator();
	 * i.hasNext();) { String method = i.next(); if (method.startsWith(field)) {
	 * lb.addItem(method, METHOD_VALUE_PREFIX + "." + method); i.remove();
	 * changed = true; } } if (!changed) { lb.addItem(field, FIElD_VALUE_PREFIX
	 * + "." + field); } }
	 * 
	 * lb.addChangeListener(new ChangeListener() {
	 * 
	 * public void onChange(Widget sender) { ExpressionBuilder.this.makeDirty();
	 * ListBox box = (ListBox) sender; if (box.getSelectedIndex() > 0);
	 * panel.remove(panel.getWidgetCount() - 1); String v =
	 * box.getValue(box.getSelectedIndex()); panel.add(new
	 * Label(v.substring(v.indexOf('.') + 1))); panel.add(getWidgetFor(v)); }
	 * });
	 * 
	 * return lb; } else if (value.startsWith(GLOBAL_COLLECTION_VALUE_PREFIX)) {
	 * return new Label("GLOBAL_COLLECTION_VALUE_PREFIX not implemented"); }
	 * else if (value.startsWith(GLOBAL_VARIABLE_VALUE_PREFIX)) { return new
	 * Label("GLOBAL_COLLECTION_VALUE_PREFIX not implemented"); } else if
	 * (value.startsWith(METHOD_VALUE_PREFIX)) { return new
	 * Label("GLOBAL_COLLECTION_VALUE_PREFIX not implemented"); } else if
	 * (value.startsWith(FIElD_VALUE_PREFIX)) { return new
	 * Label("GLOBAL_COLLECTION_VALUE_PREFIX not implemented"); } throw new
	 * IllegalArgumentException("value has invalidad prefix: '" + value + "'");
	 * }
	 */

	private RuleModel getRuleModel() {
		return modeller.getModel();
	}

	private SuggestionCompletionEngine getCompletionEngine() {
		return modeller.getSuggestionCompletions();
	}

	public String getCurrentType() {
		return expression.getType();
	}
}
