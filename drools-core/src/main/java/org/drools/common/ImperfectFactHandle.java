package org.drools.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.drools.reteoo.ConstraintKey;
import org.drools.reteoo.Evaluation;

public class ImperfectFactHandle extends DefaultFactHandle {
	
	
	private Map<ConstraintKey, Evaluation> properties = null;
	
	public Evaluation getPropertyDegree(ConstraintKey key) {
		return properties.get(key);
	}
	
	public void addPropertyDegree(Evaluation eval) {
		Evaluation existing = properties.get(eval.getKey());
		if (existing == null) {
			properties.put(eval.getKey(),eval);
		} else {
			existing.merge(eval);
		}
	}
	
	public void addPropertyDegrees(Collection<Evaluation> storedEvals) {
		for (Evaluation eval : storedEvals)
			addPropertyDegree(eval);
		
	}

	
	
	
	
	public ImperfectFactHandle() {
		 properties = new HashMap<ConstraintKey, Evaluation>();
    }

    public ImperfectFactHandle(final int id,
                             final Object object) {
        this( id,
              object,
              id );
        properties = new HashMap<ConstraintKey, Evaluation>();
    }

    /**
     * Construct.
     *
     * @param id
     *            Handle id.
     */
    public ImperfectFactHandle(final int id,
                             final Object object,
                             final long recency) {
        super(id,object,recency);
        properties = new HashMap<ConstraintKey, Evaluation>();
    	//System.out.println(this.getClass().getName() + ": hacked fact handle to hold object "+object);

    }

	
}
