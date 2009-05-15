package org.drools.rule.builder;

import java.util.Iterator;

import org.drools.lang.descr.BaseDescr;
import org.drools.lang.descr.ForAnyDescr;
import org.drools.lang.descr.ForallDescr;
import org.drools.lang.descr.PatternDescr;
import org.drools.reteoo.builder.ReteooComponentBuilder;
import org.drools.rule.ConditionalElement;
import org.drools.rule.Forall;
import org.drools.rule.Forany;
import org.drools.rule.Pattern;
import org.drools.rule.RuleConditionElement;

public class ForAnyBuilder
implements
RuleConditionBuilder {

	public RuleConditionElement build(final RuleBuildContext context,
                                final BaseDescr descr) {
		return build( context,
				descr,
				null );
	}

	public RuleConditionElement build(final RuleBuildContext context,
                                final BaseDescr descr,
                                final Pattern prefixPattern) {
		
		final ForAnyDescr foranyDescr = (ForAnyDescr) descr;
		Forany forany = new Forany();
		
		
		
		
		final RuleConditionBuilder integrandBuilder;
		final RuleConditionBuilder constraintBuilder;
		final RuleConditionBuilder weightBuilder;
		
		integrandBuilder = (RuleConditionBuilder) context.getDialect().getBuilder( foranyDescr.getIntegrandDescr().getClass() );
		
		
		final RuleConditionElement integrand = integrandBuilder.build(context, foranyDescr.getIntegrandDescr()); 		
			if ( integrand == null ) {
				return null;
			}

		forany.setIntegrand(integrand);
		
		context.getBuildStack().push( forany );
		if ( foranyDescr.getConstraintDescr() != null) {
		
			constraintBuilder = (RuleConditionBuilder) context.getDialect().getBuilder( foranyDescr.getConstraintDescr().getClass() );
			
			final RuleConditionElement constraint = constraintBuilder.build(context, foranyDescr.getConstraintDescr());
			
			forany.setConstraint(constraint);
											
		}
		
					
			if (foranyDescr.getWeightDescr() != null) {
			
				weightBuilder = (RuleConditionBuilder) context.getDialect().getBuilder( foranyDescr.getWeightDescr().getClass() );
				
				final RuleConditionElement weight = weightBuilder.build(context, foranyDescr.getWeightDescr());
				
				forany.setWeight(weight);
			}			
		
		context.getBuildStack().pop();
		
					
		return forany;
	}
	
}
