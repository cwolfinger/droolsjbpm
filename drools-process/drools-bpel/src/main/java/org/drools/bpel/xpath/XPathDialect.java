/**
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

package org.drools.bpel.xpath;

import java.util.List;
import java.util.Map;

import org.drools.base.TypeResolver;
import org.drools.compiler.Dialect;
import org.drools.io.Resource;
import org.drools.lang.descr.BaseDescr;
import org.drools.lang.descr.FunctionDescr;
import org.drools.lang.descr.ProcessDescr;
import org.drools.lang.descr.RuleDescr;
import org.drools.rule.builder.AccumulateBuilder;
import org.drools.rule.builder.ActionBuilder;
import org.drools.rule.builder.ConsequenceBuilder;
import org.drools.rule.builder.EnabledBuilder;
import org.drools.rule.builder.EngineElementBuilder;
import org.drools.rule.builder.EntryPointBuilder;
import org.drools.rule.builder.FromBuilder;
import org.drools.rule.builder.PackageBuildContext;
import org.drools.rule.builder.PatternBuilder;
import org.drools.rule.builder.PredicateBuilder;
import org.drools.rule.builder.ProcessBuildContext;
import org.drools.rule.builder.ProcessClassBuilder;
import org.drools.rule.builder.QueryBuilder;
import org.drools.rule.builder.ReturnValueBuilder;
import org.drools.rule.builder.ReturnValueEvaluatorBuilder;
import org.drools.rule.builder.RuleBuildContext;
import org.drools.rule.builder.RuleClassBuilder;
import org.drools.rule.builder.RuleConditionBuilder;
import org.drools.rule.builder.SalienceBuilder;

public class XPathDialect implements Dialect {

	private static final XPathReturnValueEvaluatorBuilder RETURN_VALUE_EVALUATOR_BUILDER = new XPathReturnValueEvaluatorBuilder();
	
	public String getId() {
		return "XPath2.0";
	}

	public String getExpressionDialectName() {
		return "XPath2.0";
	}

	public ReturnValueEvaluatorBuilder getReturnValueEvaluatorBuilder() {
		return RETURN_VALUE_EVALUATOR_BUILDER;
	}

	public ActionBuilder getActionBuilder() {
		return null;
	}

	public void addImport(String importEntry) {
	}

	public void addProcess(ProcessBuildContext context) {
	}

	public void addRule(RuleBuildContext context) {
	}

	public void addStaticImport(String importEntry) {
	}

	public void compileAll() {
	}

	public AccumulateBuilder getAccumulateBuilder() {
		return null;
	}

	public Map<Class<?>, EngineElementBuilder> getBuilders() {
		return null;
	}

	public ConsequenceBuilder getConsequenceBuilder() {
		return null;
	}

	public EntryPointBuilder getEntryPointBuilder() {
		return null;
	}

	public RuleConditionBuilder getEvalBuilder() {
		return null;
	}

	public FromBuilder getFromBuilder() {
		return null;
	}

	public PatternBuilder getPatternBuilder() {
		return null;
	}

	public PredicateBuilder getPredicateBuilder() {
		return null;
	}

	public ProcessClassBuilder getProcessClassBuilder() {
		return null;
	}

	public QueryBuilder getQueryBuilder() {
		return null;
	}

	public List<?> getResults() {
		return null;
	}

	public ReturnValueBuilder getReturnValueBuilder() {
		return null;
	}

	public RuleClassBuilder getRuleClassBuilder() {
		return null;
	}

	public SalienceBuilder getSalienceBuilder() {
		return null;
	}

	public TypeResolver getTypeResolver() {
		return null;
	}

	public void init(RuleDescr ruleDescr) {
	}

	public void init(ProcessDescr processDescr) {
	}

	public void postCompileAddFunction(FunctionDescr functionDescr,
			TypeResolver typeResolver) {
	}

	public void preCompileAddFunction(FunctionDescr functionDescr,
			TypeResolver typeResolver) {
	}

	public EnabledBuilder getEnabledBuilder() {
		return null;
	}

	public void addFunction(FunctionDescr functionDescr, TypeResolver typeResolver, Resource resource) {
	}

	public AnalysisResult analyzeBlock(PackageBuildContext context,
			BaseDescr descr, String text,
			Map<String, Class<?>>[] availableIdentifiers) {
		return null;
	}

	public AnalysisResult analyzeExpression(PackageBuildContext context,
			BaseDescr descr, Object content,
			Map<String, Class<?>>[] availableIdentifiers) {
		return null;
	}

	public EngineElementBuilder getBuilder(Class<?> clazz) {

		return null;
	}

}
