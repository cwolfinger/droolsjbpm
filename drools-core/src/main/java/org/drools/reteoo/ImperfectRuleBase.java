package org.drools.reteoo;

import org.drools.RuleBaseConfiguration;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.factory.SimpleFuzzyDegreeFactory;
import org.drools.spi.FactHandleFactory;

public class ImperfectRuleBase extends ReteooRuleBase {

	
	private IDegreeFactory degreeFactory = null;
	
	/**
     * Default constructor - for Externalizable. This should never be used by a user, as it
     * will result in an invalid state for the instance.
     */
    public ImperfectRuleBase() {

    }

    /**
     * Construct.
     *
     * @param id
     *            The rete network.
     */
    public ImperfectRuleBase(final String id) {
        this( id,
              null,
              new ImperfectFactHandleFactory() );

    }

    /**
     * @param factHandleFactory
     */
    public ImperfectRuleBase(final String id,
                          final FactHandleFactory factHandleFactory) {
        this( id,
              null,
              factHandleFactory );
    }

    public ImperfectRuleBase(final String id,
                          final RuleBaseConfiguration config) {
        this( id,
              config,
              new ImperfectFactHandleFactory() );
    }

    /**
     * @param config
     */
    public ImperfectRuleBase(final RuleBaseConfiguration config) {
        this( null,
              config,
              new ImperfectFactHandleFactory()
              );
    }

    
    /**
     * Construct.
     *
     * @param id
     *            The rete network.
     */
    public ImperfectRuleBase(final String id,
                          final RuleBaseConfiguration config,
                          final FactHandleFactory factHandleFactory
                          ) {
        super( id,
               config,
               factHandleFactory
               );               
        
        String factoryName = config.getProperty("drools.imperfect.factory");        
        IDegreeFactory factory = null;
        try {
			factory = (IDegreeFactory) Class.forName(factoryName).newInstance();
			System.out.println("Created instance of "+factoryName);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setDegreeFactory(factory);
    }
    
//    /**
//     * Construct.
//     *
//     * @param id
//     *            The rete network.
//     */
//    public ImperfectRuleBase(final String id,
//                          final RuleBaseConfiguration config,
//                          final FactHandleFactory factHandleFactory,
//                          final IDegreeFactory degreeFactory) {
//        super( id,
//               config,
//               factHandleFactory );       
//        this.degreeFactory = degreeFactory;
//    }

	/**
	 * @param degreeFactory the degreeFactory to set
	 */
	public void setDegreeFactory(IDegreeFactory degreeFactory) {
		this.degreeFactory = degreeFactory;
	}

	/**
	 * @return the degreeFactory
	 */
	public IDegreeFactory getDegreeFactory() {
		return degreeFactory;
	}

}
