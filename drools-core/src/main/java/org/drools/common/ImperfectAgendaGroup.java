package org.drools.common;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.drools.RuntimeDroolsException;
import org.drools.degrees.IDegree;
import org.drools.reteoo.Evaluation;
import org.drools.reteoo.ImperfectAgendaItem;
import org.drools.spi.Activation;


public class ImperfectAgendaGroup implements InternalAgendaGroup {
	
	
	private boolean active;
	
	private LinkedList<ImperfectAgendaItem> store = new LinkedList<ImperfectAgendaItem>();

	private String name; 
	
	
	public ImperfectAgendaGroup(String name, InternalRuleBase ruleBase) {
		this.name = name;
	}

	public void add(Activation activation) {
		
		ImperfectAgendaItem agItem = ((ImperfectAgendaItem) activation);
		
		int tgt = activation.hashCode();
		Iterator iter = store.iterator();
		System.out.print("Set is made of : ");
		while (iter.hasNext())  {
			ImperfectAgendaItem impAit = (ImperfectAgendaItem) iter.next();
			int code = impAit.hashCode();
			IDegree deg = impAit.getDegree();
			System.out.print(code + "/"+deg+" ( " + (tgt == code) + ")\t");
		}
		
		int idx = store.indexOf(agItem);
		if (idx != -1) {
			
			ImperfectAgendaItem oldAct = store.get(idx);
			store.remove(idx);		
			
			org.drools.util.LinkedList deps = oldAct.getLogicalDependencies();
			if (deps != null) {
				org.drools.util.Iterator depIter = deps.iterator();
				while (depIter.hasNext()) 
					agItem.addLogicalDependency((LogicalDependency) depIter.next() );
				System.out.println("Moved deps from old activ");
			}
				
				
			System.out.println("Replaced old activ");
		}
		
		System.out.println("added activation " + agItem.getEvaluation().hashCode() + " with degree " + agItem.getDegree());
		store.add(agItem);
		agItem.setActivated(true);
		
		System.out.println("After adding activation: ");
		System.out.println(this.getStatus());
		System.out.println();
	}

	public void clear() {
		this.store.clear();
	}

	public Activation getNext() {										
		
		
		System.out.println("Before getting next :");
		System.out.println(this.getStatus());
		System.out.println();
		
		Activation activ = store.iterator().next();
		int tgt = activ.hashCode();
		System.out.print("\n Looking for : "+activ.hashCode());
		
		Iterator iter = store.iterator();
		System.out.print("Set is made of : ");
		while (iter.hasNext())  {
			int code = iter.next().hashCode();
			System.out.print(code + "( " + (tgt == code) + "\t");
		}
		
		
		store.remove(activ);
		
		System.out.println("\nAfer getting next");
		System.out.println(this.getStatus());
		System.out.println();
		return activ;
	}

	public Activation[] getQueue() {
		throw new RuntimeDroolsException("nt here");
//		Activation[] ans = new Activation[store.size()];
//		int j = 0;
//			for (Activation act : store.values()) 
//				ans[j++] = act;
//		
//		System.out.println(this.getStatus());
//		System.out.println();	
//			
//		return ans;
	}

	public void setActive(boolean activate) {
		this.active = activate;
	}

	public org.drools.runtime.rule.Activation[] getActivations() {
		throw new RuntimeDroolsException("nt here");
//		org.drools.runtime.rule.Activation[] ans = (org.drools.runtime.rule.Activation[]) 
//        	this.store.values().toArray( new ImperfectAgendaItem[this.store.size()] );
//		
//		System.out.println(this.getStatus());
//		System.out.println();
//		
//		return ans;
	}

	public boolean isActive() {
		return isActive(); 		
	}

	public boolean isEmpty() {
		return this.store.size() == 0;
	}

	public int size() {
		return this.store.size();
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		store = (LinkedList<ImperfectAgendaItem>) in.readObject();
		active = in.readBoolean();

	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(store);
		out.writeBoolean(active);
		

	}

	public String getName() {
		return name;
	}

	public void setFocus() {
		throw new UnsupportedOperationException("No agenda focusing");
	}
	
	public boolean remove(Activation act) {
		return this.store.remove(act);
		
	}
	
	
	
	public String getStatus() {
		StringBuilder sb = new StringBuilder(this.getName()+"\n");
		
		
		Iterator<ImperfectAgendaItem> iter = store.iterator();
			
		while (iter.hasNext()) {
			sb.append("\t" + iter.next());
		}
		
//		for (Evaluation eval : store.keySet()) {
//			if (store.get(eval) == null) {
//				System.out.println(eval.equals(eval));
//				System.out.println(store.get(eval));
//				System.out.println(store.containsKey(eval));
//				System.out.println("???");
//				System.out.println(store.containsKey(eval));
//			}
//			sb.append((store.get(eval).toString()));
//		}
		return sb.toString();
		
	}

}
