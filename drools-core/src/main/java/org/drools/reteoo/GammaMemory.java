package org.drools.reteoo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GammaMemory {

	private Map<Object, Collection<Evaluation>> store;
	
	public GammaMemory() {
		store = new HashMap<Object, Collection<Evaluation>>();
	}
	
	public Collection<Evaluation> retrieve(Object o) {
		return this.store.remove(o);		
	}
	
	public void store(Object o, Evaluation eval) {
		Collection<Evaluation> coll = store.get(o);
		if (coll == null) {
			coll = new LinkedList<Evaluation>();
			store.put(o,coll);
		}
		coll.add(eval);
	}
	
}
