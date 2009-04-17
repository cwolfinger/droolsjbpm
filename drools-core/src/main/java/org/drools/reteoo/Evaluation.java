package org.drools.reteoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;


public class Evaluation extends Observable {

	
	public static final String EVAL = "EVAL";
	public static final String PRIOR = "PRIOR";

	private int nodeId;
	
	private ConstraintKey key;
	
	
	private Map<String,IDegree> degrees;
	private int totDegrees;
	private Map<String,Float> confidence;
	
	private IDegree aggDegree;
	
	private IMergeStrategy 				mergeStrat;
	private INullHandlingStrategy 		nullStrat;

	
	
	public Evaluation(int id, ConstraintKey key, Set<String> deps, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
		if (deps == null)
			deps = Collections.emptySet();
		this.nodeId = id;
		this.degrees = new HashMap<String,IDegree>();
		this.confidence = new HashMap<String,Float>();
			this.degrees.put(PRIOR, null);	
			this.degrees.put(EVAL, null);
			for (String s : deps) {
				this.degrees.put(s, null);
				confidence.put(s,new Float(0));
			}
			totDegrees = 2+deps.size();			
			
		this.key = key;
		this.nullStrat = nullStrat;
		this.mergeStrat = mergeStrat;
	}
	
	public Evaluation(int id, ConstraintKey key, Set<String> deps, IDegree evalDeg, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
		this(id,key,deps,mergeStrat,nullStrat);
		this.addDegree(Evaluation.EVAL,evalDeg,1);
	}
	
	public Evaluation(int id, ConstraintKey key, Set<String> deps, IDegree evalDeg, String source, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
		this(id,key,deps,mergeStrat,nullStrat);
		this.addDegree(source,evalDeg,1);
	}
	
	
//	/**
//	 * TODO : remove it and its dependencies
//	 * @param id
//	 * @param evalDeg
//	 * @param key
//	 * 
//	 * @deprecated
//	 */	
//	public Evaluation(int id, IDegree evalDeg, ConstraintKey key, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat) {
//		this(id,key, new HashSet<String>(),mergeStrat,nullStrat);
//		
//		this.addDegree(Evaluation.EVAL,evalDeg,1);
//	}
	
	

	public IDegree getDegree() {
		return aggDegree;
	}
	
	
	
	
	public void merge(Evaluation other) {	
		this.addDegrees(other.degrees, other.confidence);
	}

	private void addDegrees(Map<String, IDegree> moreDegrees, Map<String, Float> conf) {
		boolean newContrib = false;
		
		for (String source : moreDegrees.keySet()) {
			System.out.println("Trying to merge degrees for source "+ source + "+1");
			IDegree evalDeg = moreDegrees.get(source);
			if (evalDeg != null) {						
							
				confidence.put(source, conf.get(source));
				
				if (getDegreeBit(source) == null) {
					this.degrees.put(source,evalDeg);					
					newContrib = true;
				} else {
					this.degrees.put(source,evalDeg);
				}
			
				
				
			}
		}
	    update(newContrib);
	
	}
	
		
	public void addDegree(String source, IDegree evalDeg, float wgt) {
		
		boolean newContrib = false;
		
		if (evalDeg == null) {
			newContrib = clearDegree(source);			
		} else {
		
		
			
			confidence.put(source, wgt);
			
			if (getDegreeBit(source) == null) {
				System.out.println(this.key+" Added degree for source "+ source + " with wgt "+wgt);
				this.degrees.put(source,evalDeg);					
				newContrib = true;
			} else {
				System.out.println(this.key+" UPDATED degree for source "+ source + " with wgt "+wgt);				
					this.degrees.put(source,evalDeg);
					newContrib = true;
			}
			
//			if (getDegreeBit(source) == null) {
//				System.out.println(this.key+"Added degree for source "+ source + " with wgt "+wgt);
//				this.degrees.put(source,evalDeg);
//				incInfo(source,wgt);
//				newContrib = true;
//			} else {
//				this.degrees.put(source,evalDeg);
//			}
								
		}
		
		
		update(newContrib);
		
	}
	
	protected void incInfo(String source, float delta) {
		confidence.put(source,new Float(delta));
	}
	
	
		
	protected void update(boolean newContrib) {
		IDegree newDeg = mergeDegrees();
		
		if ((this.countObservers() > 0) &&  ((! newDeg.equals(aggDegree)) || newContrib)) {
			aggDegree = newDeg;
			this.setChanged();
			this.notifyObservers(newDeg);
		} else {
			aggDegree = newDeg;
		}
		
	}
	
	public boolean clearDegree(String source) {
		boolean cleared = false;
		if (getDegreeBit(source) != null) {
			cleared = true;
			incInfo(source,-1);
		}
		this.degrees.put(source,null);
		return cleared;
	}
	
	
	public IDegree getDegreeBit(String source) {
		return degrees.get(source);
	}
	
	protected IDegree mergeDegrees() {
		IDegree[] bits = new IDegree[this.totDegrees];
		int j = 0;
		for (String s : degrees.keySet())
			bits[j++] = degrees.get(s);
		
		return this.mergeStrat.eval(bits,nullStrat);		
	}
	
	
	
	public String toString() {
		return "("+this.nodeId + ")" + this.key+ " : " + this.aggDegree +" "+ this.getBitS();
	}
	
	
	

	


	/**
	 * @param id the id to set
	 */
	public void setNodeId(int id) {
		this.nodeId = id;
	}
	/**
	 * @return the id
	 */
	public int getNodeId() {
		return nodeId;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(ConstraintKey key) {
		this.key = key;
	}
	/**
	 * @return the key
	 */
	public ConstraintKey getKey() {
		return key;
	}

	
		
	public Collection<Evaluation> getEvalTree() {
		Collection<Evaluation> ans = new ArrayList<Evaluation>(1);			
			ans.add(this);
		return ans;
	}
	
	
	

	


	/**
	 * @return the infoRate
	 */
	public float getInfoRate() {
		//Prior injection can't be controlled!
		float info = 0;
		for (String s : confidence.keySet())
			info += confidence.get(s);
		
		if (degrees.get(PRIOR) != null)
			info -= confidence.get(PRIOR);
		
		return info/(totDegrees-1);
	}

	public String getBitS() {
		StringBuilder sb = new StringBuilder("[");
		for (String s : degrees.keySet()) {
			if (degrees.get(s) != null)
				sb.append(s+" " + this.degrees.get(s) +",");
		}
		return sb.append("]").toString();
	}

	
	
	protected IMergeStrategy getMergeStrat() {
		return mergeStrat;
	}
	protected INullHandlingStrategy getNullHandlingStrat() {
		return nullStrat;
	}
	

}
