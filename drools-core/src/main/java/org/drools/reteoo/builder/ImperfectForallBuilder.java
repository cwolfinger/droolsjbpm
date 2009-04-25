package org.drools.reteoo.builder;

import java.util.Iterator;

import org.drools.rule.Forall;
import org.drools.rule.GroupElement;
import org.drools.rule.GroupElementFactory;
import org.drools.rule.Pattern;
import org.drools.rule.RuleConditionElement;

public class ImperfectForallBuilder extends ForallBuilder implements
		ReteooComponentBuilder {
	
	
	
    public void build(final BuildContext context,
            final BuildUtils utils,
            final RuleConditionElement rce) {
    	
    	final Forall forall = (Forall) rce;

    		// forall can be translated into
    		// not EXIST( basePattern and not EXIST( <remaining_patterns>+ ) ) 
    		// so we just do that:

    	final GroupElement not = GroupElementFactory.newNotInstance();    
    	final GroupElement exists = GroupElementFactory.newExistsInstance();
    	
    	final GroupElement and = GroupElementFactory.newAndInstance();
    	
    	final GroupElement notInner = GroupElementFactory.newNotInstance();
    	final GroupElement existsInner = GroupElementFactory.newExistsInstance();
    	final GroupElement andInner = GroupElementFactory.newAndInstance();
    	
    	
    	Pattern base = forall.getBasePattern();
    	//Pattern child1 = (Pattern) forall.getRemainingPatterns().get(0);
    	    	    	
//    	 if ( forall.getRemainingPatterns().size() == 1 ) {
//             notInner.addChild( (Pattern) forall.getRemainingPatterns().get( 0 ) );
//                     
//         	exists.addChild(notInner); 
//                                       
//         } 
    	 
    	 
    	 if ( forall.getRemainingPatterns().size() == 1 ) {
    		 	Pattern pat = (Pattern) forall.getRemainingPatterns().get( 0 );
    		 	pat.dropLastConstraint();
    		 	
    		 notInner.addChild(pat);
    		 exists.addChild(notInner);
    		 
    		 
    		 
//    		 and.addChild(base);
//    		 
//    		 
//             		existsInner.addChild( (Pattern) forall.getRemainingPatterns().get( 0 ) );
//             		             		
//             	notInner.addChild(existsInner);
//             and.addChild(notInner);
             
             
                     
//         	exists.addChild(and); 
                   
         } else if ( forall.getRemainingPatterns().size() > 1 ) {
        	
        	
        	and.addChild(base);
        	
        	
             for ( final Iterator it = forall.getRemainingPatterns().iterator(); it.hasNext(); ) {
                 andInner.addChild( (Pattern) it.next() );
             }             
             
             		existsInner.addChild( andInner );
          		notInner.addChild(existsInner);
          	and.addChild(notInner);
          	
          	exists.addChild(and);
          	
        	 
        	 /*
        	 and.addChild(base);
        	 for ( final Iterator it = forall.getRemainingPatterns().iterator(); it.hasNext(); ) {
                 and.addChild( (Pattern) it.next() );
             }
        	 
        	 notInner.addChild(and);
        	 exists.addChild(notInner);
        	 */
         }
    	
    	
    	
    	
    	
    	not.addChild(exists);
    	 
    	
    	
    	
    	
    	
    	
    	
    	
    	    	    	    	
    	GroupElement baseElement = not;    	    	    
    	// get builder for the CEs
    	final ReteooComponentBuilder builder = utils.getBuilderFor( baseElement );

    	// 	builds the CEs
    	builder.build( context,
    			utils,
    			not );
    }
	
	

}
