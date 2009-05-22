package org.drools.reteoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.FactException;
import org.drools.FactHandle;
import org.drools.RuleBaseConfiguration;
import org.drools.common.DefaultFactHandle;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.RuleBasePartitionId;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.factory.SimpleDegreeFactory;
import org.drools.degrees.factory.SimpleFuzzyDegreeFactory;
import org.drools.rule.EntryPoint;
import org.drools.rule.InvalidPatternException;
import org.drools.rule.Package;
import org.drools.rule.Rule;
import org.drools.spi.FactHandleFactory;
import org.drools.spi.PropagationContext;

public class ImperfectRuleBase extends ReteooRuleBase {

	
	private IDegreeFactory degreeFactory = null;
	private Map<ConstraintKey,Set<String>> dependencies = new HashMap<ConstraintKey, Set<String>>();
	
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
        
        String factoryName = config.getProperty("org.drools.chance.factory");
        	boolean cwa = config.getClosedWorldAssumption();
        IDegreeFactory factory = null;
        try {
			factory = (IDegreeFactory) Class.forName(factoryName).newInstance();
			factory.setClosedWorldAssumption(cwa);
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
    
    
    protected void setupRete() {
    	setRete(new Rete( this ));
    	setReteooBuilder(new ImperfectReteooBuilder( this ));

    	// 	always add the default entry point
    	EntryPointNode epn = new EntryPointNode( this.getReteooBuilder().getIdGenerator().getNextId(),
    			RuleBasePartitionId.MAIN_PARTITION,
    			this.config.isMultithreadEvaluation(),
    			this.getRete(),
    			EntryPoint.DEFAULT );
    	epn.attach();
    }
	

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
	
	
	
	public void assertObject(final FactHandle handle,
            final Object object,
            final PropagationContext context,
            final InternalWorkingMemory workingMemory) throws FactException {
			
				IDegreeFactory factory = this.getDegreeFactory();
				EvalRecord record = new EvalRecord(EvalRecord.INITIAL_ID,
						getDegreeFactory().getAndOperator(),
						getDegreeFactory().getMergeStrategy(),
						getDegreeFactory().getNullHandlingStrategy(),
						getDegreeFactory(),
						new ArgList(object));
		
				getRete().assertObject( (ImperfectFactHandle) handle,
						context,
						workingMemory, 
						factory, 
						record);
	}

	
	
	protected synchronized void addRule(final Rule rule) throws InvalidPatternException {
        // This adds the rule. ReteBuilder has a reference to the WorkingMemories and will propagate any existing facts.
        super.addRule( rule );
        for (ConstraintKey key : rule.getDependencies().keySet()) {
        	this.dependencies.put(key,rule.getDependencies().get(key));
        }                
    }
	
	public Map<ConstraintKey,Set<String>> getDependencies() {
		return dependencies;		
	}
	
}
