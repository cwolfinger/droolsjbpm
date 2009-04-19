package org.drools.reteoo.builder;

import java.util.ArrayList;
import java.util.List;

import org.drools.RuleBase;
import org.drools.RuntimeDroolsException;
import org.drools.RuleBaseConfiguration.EventProcessingMode;
import org.drools.common.BaseNode;
import org.drools.common.InternalRuleBase;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.reteoo.ImperfectRuleBase;
import org.drools.reteoo.ModusPonensNode;
import org.drools.reteoo.QueryTerminalNode;
import org.drools.reteoo.ReteooBuilder;
import org.drools.reteoo.RuleTerminalNode;
import org.drools.reteoo.TerminalNode;
import org.drools.rule.Accumulate;
import org.drools.rule.Behavior;
import org.drools.rule.Collect;
import org.drools.rule.EntryPoint;
import org.drools.rule.EvalCondition;
import org.drools.rule.Forall;
import org.drools.rule.From;
import org.drools.rule.GroupElement;
import org.drools.rule.InvalidPatternException;
import org.drools.rule.Pattern;
import org.drools.rule.Query;
import org.drools.rule.Rule;
import org.drools.rule.RuleConditionElement;
import org.drools.time.TemporalDependencyMatrix;

public class ImperfectReteooRuleBuilder extends ReteooRuleBuilder {
	
	
	
	public ImperfectReteooRuleBuilder() {
        this.setUtils(new BuildUtils());

        this.getUtils().addBuilder( GroupElement.class,
                               new ImperfectGroupElementBuilder() );
        this.getUtils().addBuilder( Pattern.class,
                               new PatternBuilder() );
        this.getUtils().addBuilder( EvalCondition.class,
                               new EvalBuilder() );
        this.getUtils().addBuilder( From.class,
                               new FromBuilder() );
        this.getUtils().addBuilder( Collect.class,
                               new CollectBuilder() );
        this.getUtils().addBuilder( Accumulate.class,
                               new AccumulateBuilder() );
        this.getUtils().addBuilder( Forall.class,
                               new ImperfectForallBuilder() );
        this.getUtils().addBuilder( EntryPoint.class,
                               new EntryPointBuilder() );
    }
	
	
	/**
	 * Rules are no longer SPLIT! Instead, a full tree is computed
	 */
	public List<TerminalNode> addRule(final Rule rule,
            final InternalRuleBase rulebase,
            final ReteooBuilder.IdGenerator idGenerator) throws InvalidPatternException {

		
		// the list of terminal nodes
		final List<TerminalNode> nodes = new ArrayList<TerminalNode>();

		//GroupElement ruleRoot = (GroupElement) rule.getLhs().getChildren().get(0);
		GroupElement ruleRoot = rule.getLhs();
		
			

			final BuildContext context = new BuildContext( rulebase,
					idGenerator );
				context.setRule( rule );

				// if running in STREAM mode, calculate temporal distance for events
				if( EventProcessingMode.STREAM.equals( rulebase.getConfiguration().getEventProcessingMode() ) ) {
					TemporalDependencyMatrix temporal = getUtils().calculateTemporalDistance( ruleRoot );
					context.setTemporalDistance( temporal );
				}

				if ( rulebase.getConfiguration().isSequential() ) {
					context.setTupleMemoryEnabled( false );
					context.setObjectTypeNodeMemoryEnabled( false );
					context.setTerminalNodeMemoryEnabled( false );
					context.setAlphaNodeMemoryAllowed( false );
				} else {
					context.setTupleMemoryEnabled( true );
					context.setObjectTypeNodeMemoryEnabled( true );
					context.setTerminalNodeMemoryEnabled( true );
					context.setAlphaNodeMemoryAllowed( true );                
				}

			// 	adds subrule
			final TerminalNode node = this.addSubRule( context,
                                           ruleRoot,
                                           rule );

			// adds the terminal node to the list of terminal nodes
			nodes.add( node );

			return nodes;
	}
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
