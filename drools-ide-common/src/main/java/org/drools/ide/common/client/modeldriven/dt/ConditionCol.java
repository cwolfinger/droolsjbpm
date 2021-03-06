/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.ide.common.client.modeldriven.dt;


/**
 * This is the config for a condition column. Typically many of them have their constraints added.
 *
 * @author Michael Neale
 *
 */
public class ConditionCol extends DTColumnConfig {

    private static final long serialVersionUID = 510l;

    /**
	 * What is displayed at the top
	 */
	private String header;

	/**
	 * The type of the fact - class - eg Driver, Person, Cheese etc.
	 */
	private String factType;

	/**
	 * The name that this gets referenced as. Multiple columns with the same name mean their constraints will be combined.
	 */
	private String boundName;

	/**
	 * The type of the value that is in the cell, eg if it is a formula, or literal value etc.
	 * The valid types are from ISingleFieldConstraint:
	 *   TYPE_LITERAL
	 *   TYPE_RET_VALUE
	 *   TYPE_PREDICATE (in this case, the field and operator are ignored).
	 */
	private int constraintValueType;


	/**
	 * The field of the fact that this pertains to (if its a predicate, ignore it).
	 */
	private String factField;


	/**
	 * The operator to use to compare the field with the value (unless its a predicate, in which case this is ignored).
	 */
	private String operator;

	/**
	 * A comma separated list of valid values. Optional.
	 */
	private String valueList;

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setFactType(String factType) {
        this.factType = factType;
    }

    public String getFactType() {
        return factType;
    }

    public void setBoundName(String boundName) {
        this.boundName = boundName;
    }

    public String getBoundName() {
        return boundName;
    }

    public void setConstraintValueType(int constraintValueType) {
        this.constraintValueType = constraintValueType;
    }

    public int getConstraintValueType() {
        return constraintValueType;
    }

    public void setFactField(String factField) {
        this.factField = factField;
    }

    public String getFactField() {
        return factField;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public String getValueList() {
        return valueList;
    }

}
