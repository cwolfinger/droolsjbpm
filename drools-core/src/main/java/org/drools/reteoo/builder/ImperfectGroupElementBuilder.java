package org.drools.reteoo.builder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.drools.InitialFact;
import org.drools.RuntimeDroolsException;
import org.drools.base.ClassObjectType;
import org.drools.common.BetaConstraints;
import org.drools.common.EmptyBetaConstraints;
import org.drools.common.TupleStartEqualsConstraint;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.NegationOperator;
import org.drools.reteoo.AndOperatorInstaller;
import org.drools.reteoo.ExistsNode;
import org.drools.reteoo.ImperfectExistsNode;
import org.drools.reteoo.ImperfectRuleBase;
import org.drools.reteoo.JoinNode;
import org.drools.reteoo.LeftInputAdapterNode;
import org.drools.reteoo.LeftTupleSource;
import org.drools.reteoo.NotNode;
import org.drools.reteoo.ObjectSource;
import org.drools.reteoo.OperatorInstaller;
import org.drools.reteoo.OrOperatorInstaller;
import org.drools.reteoo.RightInputAdapterNode;
import org.drools.rule.Behavior;
import org.drools.rule.GroupElement;
import org.drools.rule.Pattern;
import org.drools.rule.RuleConditionElement;
import org.drools.spi.ObjectType;
import org.drools.util.LinkedList;
import org.drools.util.LinkedListEntry;
import org.drools.util.LinkedListNode;

public class ImperfectGroupElementBuilder extends GroupElementBuilder implements
		ReteooComponentBuilder {
	
	
	public ImperfectGroupElementBuilder() {
		
        this.getGeBuilders().put( GroupElement.AND,
                             new ImperfectAndBuilder() );
        this.getGeBuilders().put( GroupElement.OR,
                             new ImperfectOrBuilder() );
        this.getGeBuilders().put( GroupElement.NOT,
                             new ImperfectNotBuilder() );
        this.getGeBuilders().put( GroupElement.EXISTS,
                             new ImperfectExistsBuilder() );
    }

	
	
	
	
	
	
	
		
	

	private static class ImperfectAndBuilder
        implements
        ReteooComponentBuilder {

        /**
         * @inheritDoc
         * 
         * And group elements just iterate over their children
         * selecting and calling the build procedure for each one
         * 
         */
        public void build(final BuildContext context,
                          final BuildUtils utils,
                          final RuleConditionElement rce) {

        	
        	
        	IDegreeFactory factory = ((ImperfectRuleBase) context.getRuleBase()).getDegreeFactory();
            
            IDegreeCombiner operator;
            if (context.isNegated()) {
            	operator = factory.getNegationOperator();
            		((NegationOperator) operator).setOperator(factory.getAndOperator());
            	context.toggleNegated();	
            	
            } else {
            	operator = factory.getAndOperator();
            }
        	
        	
            final GroupElement ge = (GroupElement) rce;

            // iterate over each child and build it
            for ( final Iterator it = ge.getChildren().iterator(); it.hasNext(); ) {

                final RuleConditionElement child = (RuleConditionElement) it.next();

                final ReteooComponentBuilder builder = utils.getBuilderFor( child );

                builder.build( context,
                               utils,
                               child );

                // if a previous object source was bound, but no tuple source
                if ( context.getObjectSource() != null && context.getTupleSource() == null ) {
                    // adapt it to a Tuple source                    
                    context.setTupleSource( (LeftTupleSource) utils.attachNode( context,
                                                                                new LeftInputAdapterNode( context.getNextId(),
                                                                                                          context.getObjectSource(),
                                                                                                          context ) ) );

                    context.setObjectSource( null );
                }

                // if there was a previous tuple source, then a join node is needed
                if ( context.getObjectSource() != null && context.getTupleSource() != null ) {
                    // so, create the tuple source and clean up the constraints and object source
                    final BetaConstraints betaConstraints = utils.createBetaNodeConstraint( context,
                                                                                            context.getBetaconstraints(),
                                                                                            false );

                    Behavior[] behaviors = createBehaviorArray( context );

                    context.setTupleSource( (LeftTupleSource) utils.attachNode( context,
                    														    new JoinNode( context.getNextId(),
                    														    		context.getTupleSource(),
                    														    		context.getObjectSource(),
                    														    		betaConstraints,
                    														    		behaviors,
                    														    		context ) ) );
                    context.setBetaconstraints( null );
                    context.setObjectSource( null );
                }
            }
            
            int arity = ge.getChildren().size();
            	Object firstChild = ge.getChildren().get(0);
            	if (firstChild instanceof Pattern) {
            		Pattern pat = (Pattern) firstChild;
            		if (pat.getObjectType().isAssignableFrom(new ClassObjectType(InitialFact.class))) 
            			arity--;
            	}
//            	if (firstChild.isPatternScopeDelimiter())
//            		;
            		
            OperatorInstaller instNode = new AndOperatorInstaller(
														context.getTupleSource(),
														arity,
														context.getNextId(),
														context.getPartitionId(),
														context.getRuleBase().getConfiguration().isMultithreadEvaluation());
            
            
            instNode.buildEvaluationTemplate(operator,factory.getMergeStrategy(),factory.getNullHandlingStrategy());
            
            context.setTupleSource((LeftTupleSource) utils.attachNode(
            							context,
            							instNode
            							));
            
            
            
        }

        public boolean requiresLeftActivation(final BuildUtils utils,
                                              final RuleConditionElement rce) {
            final GroupElement and = (GroupElement) rce;

            // need to check this because in the case of an empty rule, the root AND
            // will have no child
            if ( and.getChildren().isEmpty() ) {
                return true;
            }

            final RuleConditionElement child = (RuleConditionElement) and.getChildren().get( 0 );
            final ReteooComponentBuilder builder = utils.getBuilderFor( child );

            return builder.requiresLeftActivation( utils,
                                                   child );
        }
    }

    private static class ImperfectOrBuilder
        implements
        ReteooComponentBuilder {

       
    	
    	 public void build(final BuildContext context,
                 final BuildUtils utils,
                 final RuleConditionElement rce) {

    		 IDegreeFactory factory = ((ImperfectRuleBase) context.getRuleBase()).getDegreeFactory();

    		 IDegreeCombiner operator;
             if (context.isNegated()) {
             	operator = factory.getNegationOperator();
             		((NegationOperator) operator).setOperator(factory.getOrOperator());
             	context.toggleNegated();	
             	
             } else {
             	operator = factory.getOrOperator();
             }
    		 
	
    		 final GroupElement ge = (GroupElement) rce;

    		 // 	iterate over each child and build it
    		 for ( final Iterator it = ge.getChildren().iterator(); it.hasNext(); ) {
    			 
    			 final RuleConditionElement child = (RuleConditionElement) it.next();

    			 final ReteooComponentBuilder builder = utils.getBuilderFor( child );

    			 builder.build( context,
    					 utils,
    					 child );

       // 	if a previous object source was bound, but no tuple source
    			 if ( context.getObjectSource() != null && context.getTupleSource() == null ) {
           // 	adapt it to a Tuple source                    
    				 context.setTupleSource( (LeftTupleSource) utils.attachNode( context,
                                                                       new LeftInputAdapterNode( context.getNextId(),
                                                                                                 context.getObjectSource(),
                                                                                                 context ) ) );

    				 context.setObjectSource( null );
    			 }

    			 // if there was a previous tuple source, then a join node is needed
    			 if ( context.getObjectSource() != null && context.getTupleSource() != null ) {
           // 	so, create the tuple source and clean up the constraints and object source
    				 final BetaConstraints betaConstraints = utils.createBetaNodeConstraint( context,
    						 context.getBetaconstraints(),
    						 false );

    				 Behavior[] behaviors = createBehaviorArray( context );

    				 context.setTupleSource( (LeftTupleSource) utils.attachNode( context,
    						 new JoinNode( context.getNextId(),
    								 context.getTupleSource(),
    								 context.getObjectSource(),
    								 betaConstraints,
    								 behaviors,
    								 context ) ) );
    				 context.setBetaconstraints( null );
    				 context.setObjectSource( null );
    			 }
    		 }
    		     		              
    		 OperatorInstaller instNode = new OrOperatorInstaller(
						context.getTupleSource(),
						ge.getChildren().size(),
						context.getNextId(),
						context.getPartitionId(),
						context.getRuleBase().getConfiguration().isMultithreadEvaluation());
    		 
    		 
    		 instNode.buildEvaluationTemplate(operator,factory.getMergeStrategy(),factory.getNullHandlingStrategy());
    		 
    		 context.setTupleSource((LeftTupleSource) utils.attachNode(
						context,
						instNode
						));
             
    	 }

    	 public boolean requiresLeftActivation(final BuildUtils utils,
    			 final RuleConditionElement rce) {
    		 final GroupElement and = (GroupElement) rce;

    		 // need to check this because in the case of an empty rule, the root AND
   // 	will have no child
    		 if ( and.getChildren().isEmpty() ) {
    			 return true;
    		 }

    		 final RuleConditionElement child = (RuleConditionElement) and.getChildren().get( 0 );
    		 final ReteooComponentBuilder builder = utils.getBuilderFor( child );

    		 return builder.requiresLeftActivation( utils,
                                          child );
    	 }
    	
    }

    private static class ImperfectNotBuilder
        implements
        ReteooComponentBuilder {

    	 public void build(final BuildContext context,
                 final BuildUtils utils,
                 final RuleConditionElement rce) {
    		 final GroupElement not = (GroupElement) rce;

    		 // 	get child
    		 final RuleConditionElement child = (RuleConditionElement) not.getChildren().get( 0 );

    		 // 	set negation. Multiple cascaded negation will be toggled in chain
    		 context.toggleNegated();
    		 
    		 // 	get builder for child
    		 final ReteooComponentBuilder builder = utils.getBuilderFor( child );

    		 // 		builds the child
    		 builder.build( context,
    				 utils,
    				 child );
    		     
    		 
    		 
    	 }

    	 /**
    	  * @inheritDoc
    	  */
    	 public boolean requiresLeftActivation(final BuildUtils utils,
                                     final RuleConditionElement rce) {
    		 final GroupElement not = (GroupElement) rce;

    		 // 	get child
    		 final RuleConditionElement child = (RuleConditionElement) not.getChildren().get(0);
    		 return utils.getBuilderFor(child).requiresLeftActivation(utils, child);

    	 }
    }

    private static class ImperfectExistsBuilder
        implements
        ReteooComponentBuilder {

        /**
         * @inheritDoc
         * 
         * Exists must verify what is the class of its child:
         * 
         * If it is a pattern, a simple ExistsNode is added to the rulebase
         * If it is a group element, than a subnetwork must be created
         */
        public void build(final BuildContext context,
                          final BuildUtils utils,
                          final RuleConditionElement rce) {
        	
        	IDegreeFactory factory = ((ImperfectRuleBase) context.getRuleBase()).getDegreeFactory();
            
            IDegreeCombiner operator;
            if (context.isNegated()) {
            	operator = factory.getNegationOperator();
            		((NegationOperator) operator).setOperator(factory.getExistsOperator());
            	context.toggleNegated();	
            	
            } else {
            	operator = factory.getExistsOperator();
            }
        	
        	
            final GroupElement exists = (GroupElement) rce;

            // EXISTS must save some context info to restore it later
            final int currentPatternIndex = context.getCurrentPatternOffset();
            final LeftTupleSource tupleSource = context.getTupleSource();

            // get child
            final RuleConditionElement child = (RuleConditionElement) exists.getChildren().get( 0 );

            // get builder for child
            final ReteooComponentBuilder builder = utils.getBuilderFor( child );

            // builds the child
            builder.build( context,
                           utils,
                           child );

            // if it is a subnetwork
            if ( context.getObjectSource() == null && context.getTupleSource() != null ) {

                // attach right input adapter node to convert tuple source into an object source
                context.setObjectSource( (ObjectSource) utils.attachNode( context,
                                                                          new RightInputAdapterNode( context.getNextId(),
                                                                                                     context.getTupleSource(),
                                                                                                     context ) ) );

                // restore tuple source from before the start of the sub network
                context.setTupleSource( tupleSource );

                // create a tuple start equals constraint and set it in the context
                final TupleStartEqualsConstraint constraint = TupleStartEqualsConstraint.getInstance();
                final List predicates = new ArrayList();
                predicates.add( constraint );
                context.setBetaconstraints( predicates );

            }

            BetaConstraints betaConstraints = utils.createBetaNodeConstraint( context,
                                                                                    context.getBetaconstraints(),            																		
                                                                                    false );
                                   
            

            Behavior[] behaviors = createBehaviorArray( context );

            // then attach the EXISTS node. It will work both as a simple exists node
            // or as subnetwork join node as the context was set appropriatelly
            // in each case
            
            
            
            
            ImperfectExistsNode	exNode = new ImperfectExistsNode( context.getNextId(),
                    context.getTupleSource(),
                    context.getObjectSource(),
                    betaConstraints,
                    behaviors,
                    context );
            
            exNode.buildEvaluationTemplate(operator,context.getRule().getDependencies(),factory.getMergeStrategy(),factory.getNullHandlingStrategy());
            
            context.setTupleSource( (LeftTupleSource) utils.attachNode( context,
                                                                         exNode) );
            context.setBetaconstraints( null );
            context.setObjectSource( null );

            // restore pattern index
            context.setCurrentPatternOffset( currentPatternIndex );
        }

        /**
         * @inheritDoc
         */
        public boolean requiresLeftActivation(final BuildUtils utils,
                                              final RuleConditionElement rce) {
        	
        	 return true;
        }
    }

	
	

}
