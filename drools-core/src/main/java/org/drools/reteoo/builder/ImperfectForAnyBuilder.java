package org.drools.reteoo.builder;

import java.util.Iterator;

import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.builder.BuildUtils;
import org.drools.reteoo.builder.ReteooComponentBuilder;
import org.drools.rule.Forall;
import org.drools.rule.Forany;
import org.drools.rule.GroupElement;
import org.drools.rule.GroupElementFactory;
import org.drools.rule.Pattern;
import org.drools.rule.RuleConditionElement;

public class ImperfectForAnyBuilder implements ReteooComponentBuilder {
    /**
     * @inheritDoc
     */
    public void build(final BuildContext context,
                      final BuildUtils utils,
                      final RuleConditionElement rce) {
        final Forany forany = (Forany) rce;

        // forany can be translated into
        // Average* { Discount ( << integrand, constraint >> , weight) }                
        // so we just do that:

                
        RuleConditionElement temp = forany.getIntegrand();
        if (forany.getConstraint() != null) {
        	GroupElement dmp = GroupElementFactory.newDblMPInstance();
        		dmp.addChild(forany.getIntegrand());
        		dmp.addChild(forany.getConstraint());
        	temp = dmp;	
        }
        
        if (forany.getWeight() != null) {
        	GroupElement dsc = GroupElementFactory.newDiscountInstance();
        		dsc.addChild(temp);
        		dsc.addChild(forany.getWeight());
        	temp = dsc;	
        }
        
        
        GroupElement avg = GroupElementFactory.newAvgInstance();
        	avg.addChild(temp);
        
                	                
        // get builder for the CEs
        final ReteooComponentBuilder builder = utils.getBuilderFor( avg );

        // builds the CEs
        builder.build( context,
                       utils,
                       avg );
    }

    
    
    
    
    
    
    /**
     * @inheritDoc
     */
    public boolean requiresLeftActivation(final BuildUtils utils,
                                          final RuleConditionElement rce) {
        return true;
    }
	
}
