package org.drools.reteoo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GammaMemory {

	private Map<ArgList, Collection<Evaluation>> store;
	
	public GammaMemory() {
		store = new HashMap<ArgList, Collection<Evaluation>>();
	}
	
	public Collection<Evaluation> retrieve(ArgList o) {
		if (o.isPersistent())
			return this.store.get(o);
		else
			return this.store.remove(o);		
	}
	
	public Collection<ArgList> getKeys() {
		return store.keySet();
	}
	
	public void store(ArgList o, Evaluation eval) {
		Collection<Evaluation> coll = store.get(o);
		if (coll == null) {
			coll = new LinkedList<Evaluation>();
			store.put(o,coll);
		}
		coll.add(eval);
	}
	
}
