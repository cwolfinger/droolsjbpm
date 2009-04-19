package org.drools.reteoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.drools.RuleBaseConfiguration.EventProcessingMode;
import org.drools.common.BaseNode;
import org.drools.common.InternalRuleBase;
import org.drools.reteoo.ReteooBuilder.IdGenerator;
import org.drools.reteoo.builder.BuildContext;
import org.drools.reteoo.builder.ImperfectReteooRuleBuilder;
import org.drools.reteoo.builder.ReteooRuleBuilder;
import org.drools.rule.GroupElement;
import org.drools.rule.InvalidPatternException;
import org.drools.rule.Rule;
import org.drools.time.TemporalDependencyMatrix;

public class ImperfectReteooBuilder extends ReteooBuilder {

	
		
	public ImperfectReteooBuilder(final InternalRuleBase ruleBase) {
        this.setRuleBase(ruleBase);
        setRules(new HashMap<Rule, BaseNode[]>());

        //Set to 1 as Rete node is set to 0
        setIdGenerator(new IdGenerator( 1 ));
        setRuleBuilder(new ImperfectReteooRuleBuilder());
    }
	
	
	
	
	
	

}
