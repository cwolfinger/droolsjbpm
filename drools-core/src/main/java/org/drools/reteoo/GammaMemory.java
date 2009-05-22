package org.drools.reteoo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GammaMemory {

	private Map<ArgList, Collection<Evaluation>> store;
	
	private Collection<Evaluation> all = null;
	
	public GammaMemory() {
		store = new HashMap<ArgList, Collection<Evaluation>>();
	}
	
	public Collection<Evaluation> retrieve(ArgList o) {
		Collection<Evaluation> ans;
							
		if (o.isPersistent())
			ans = this.store.get(o);
		else
			ans = this.store.remove(o);
		
		if (all != null) {
			
			if (ans == null) {
				ans = all;
			} else {
				ans.addAll(all);
			}
			
			
		}
		
		return ans;
	}
	
	public Collection<ArgList> getKeys() {
		return store.keySet();
	}
	
	public void store(ArgList o, Evaluation eval) {
		if (o.getObject() instanceof Jolly) {
			all = new LinkedList<Evaluation>();
			all.add(eval);
			return;
		}
		
		Collection<Evaluation> coll = store.get(o);
		if (coll == null) {
			coll = new LinkedList<Evaluation>();
			store.put(o,coll);
		}
		coll.add(eval);
	}
	
}
