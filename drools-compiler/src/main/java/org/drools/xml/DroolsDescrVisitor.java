package org.drools.xml;

import org.codehaus.janino.Java.FunctionDeclarator;
import org.drools.compiler.ReturnValueDescr;
import org.drools.lang.descr.AccessorDescr;
import org.drools.lang.descr.AccumulateDescr;
import org.drools.lang.descr.ActionDescr;
import org.drools.lang.descr.AndDescr;
import org.drools.lang.descr.AttributeDescr;
import org.drools.lang.descr.BehaviorDescr;
import org.drools.lang.descr.CollectDescr;
import org.drools.lang.descr.CutDescr;
import org.drools.lang.descr.DeclarativeInvokerDescr;
import org.drools.lang.descr.EntryPointDescr;
import org.drools.lang.descr.EqvDescr;
import org.drools.lang.descr.EvalDescr;
import org.drools.lang.descr.EvaluatorBasedRestrictionDescr;
import org.drools.lang.descr.ExistsDescr;
import org.drools.lang.descr.FactTemplateDescr;
import org.drools.lang.descr.FieldAccessDescr;
import org.drools.lang.descr.FieldBindingDescr;
import org.drools.lang.descr.FieldConstraintDescr;
import org.drools.lang.descr.ForAnyDescr;
import org.drools.lang.descr.ForallDescr;
import org.drools.lang.descr.FromDescr;
import org.drools.lang.descr.FunctionCallDescr;
import org.drools.lang.descr.FunctionDescr;
import org.drools.lang.descr.FunctionImportDescr;
import org.drools.lang.descr.GlobalDescr;
import org.drools.lang.descr.HedgeDescr;
import org.drools.lang.descr.ImpliesDescr;
import org.drools.lang.descr.ImportDescr;
import org.drools.lang.descr.LiteralRestrictionDescr;
import org.drools.lang.descr.MethodAccessDescr;
import org.drools.lang.descr.NotDescr;
import org.drools.lang.descr.OrDescr;
import org.drools.lang.descr.PackageDescr;
import org.drools.lang.descr.PatternDescr;
import org.drools.lang.descr.PatternSourceDescr;
import org.drools.lang.descr.PredicateDescr;
import org.drools.lang.descr.ProcessDescr;
import org.drools.lang.descr.QualifiedIdentifierRestrictionDescr;
import org.drools.lang.descr.QueryDescr;
import org.drools.lang.descr.Restriction;
import org.drools.lang.descr.RestrictionConnectiveDescr;
import org.drools.lang.descr.ReturnValueRestrictionDescr;
import org.drools.lang.descr.RuleDescr;
import org.drools.lang.descr.SlidingWindowDescr;
import org.drools.lang.descr.TypeDeclarationDescr;
import org.drools.lang.descr.TypeFieldDescr;
import org.drools.lang.descr.VariableRestrictionDescr;
import org.drools.lang.descr.XorDescr;

public interface DroolsDescrVisitor {
	
	public void visitActionDescr(ActionDescr descr);
	
	public void visitAndDescr(AndDescr descr);
	
	public void visitAttributeDescr(AttributeDescr descr);
	
	public void visitBehaviorDescr(BehaviorDescr descr);
	
	public void visitSlidingWindowDescr(SlidingWindowDescr descr);
	
	public void visitCutDescr(CutDescr descr);
	
	public void visitDeclarativeInvokerDescr(DeclarativeInvokerDescr descr);
	
	public void visitAccessorDescr(AccessorDescr descr);
	
	public void visitFieldAccessDescr(FieldAccessDescr descr);
	
	public void visitFunctionCallDescr(FunctionCallDescr descr);
	
	public void visitMethodAccessDescr(MethodAccessDescr descr);
	
	public void visitEqvDescr(EqvDescr descr);
	
	public void visitEvalDescr(EvalDescr descr);
	
	public void visitExistsDescr(ExistsDescr descr);
	
	public void visitFactTemplateDescr(FactTemplateDescr descr);
	
	public void visitFieldBindingDescr(FieldBindingDescr descr);
	
	public void visitFieldConstraintDescr(FieldConstraintDescr descr);
	
	public void visitForallDescr(ForallDescr descr);
	
	public void visitForAnyDescr(ForAnyDescr descr);
	
	public void visitFunctionDescr(FunctionDescr descr);
	
	public void visitGlobalDescr(GlobalDescr descr);
	
	public void visitHedgeDescr(HedgeDescr descr);
	
	public void visitImpliesDescr(ImpliesDescr descr);
	
	public void visitImportDescr(ImportDescr descr);
	
	public void visitFunctionImportDescr(FunctionImportDescr descr);
	
	public void visitNotDescr(NotDescr descr);
	
	public void visitOrDescr(OrDescr descr);
	
	public void visitPackageDescr(PackageDescr descr);
	
	public void visitPatternDescr(PatternDescr descr);
	
	public void visitPatternSourceDescr(PatternSourceDescr descr);
	
	public void visitAccumulateDescr(AccumulateDescr descr);
	
	public void visitCollectDescr(CollectDescr descr);
	
	public void visitEntryPointDescr(EntryPointDescr descr);
	
	public void visitFromDescr(FromDescr descr);
	
	public void visitProcessDescr(ProcessDescr descr);
	
	public void visitRestriction(Restriction descr);
	
	public void visitEvaluatorBasedRestrictionDescr(EvaluatorBasedRestrictionDescr descr);
	
	public void visitLiteralRestrictionDescr(LiteralRestrictionDescr descr);
	
	public void visitQualifiedIdentifierRestrictionDescr(QualifiedIdentifierRestrictionDescr descr);
	
	public void visitReturnValueRestrictionDescr(ReturnValueRestrictionDescr descr);
	
	public void visitVariableRestrictionDescr(VariableRestrictionDescr descr);
	
	public void visitPredicateDescr(PredicateDescr descr);
	
	public void visitRestrictionConnectiveDescr(RestrictionConnectiveDescr descr);
	
	public void visitReturnValueDescr(ReturnValueDescr descr);
	
	public void visitRuleDescr(RuleDescr descr);
	
	public void visitQueryDescr(QueryDescr descr);
	
	public void visitTypeDeclarationDescr(TypeDeclarationDescr descr);
	
	public void visitTypeFieldDescr(TypeFieldDescr descr);
	
	public void visitXorDescr(XorDescr descr);
	
	
	
	
	

}
