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
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;


public class Evaluation extends Droobservable {

	
	public static final String EVAL = "EVAL";
	public static final String PRIOR = "PRIOR";

	private int nodeId;
	
	private ConstraintKey key;
	
	
	private Map<String,IDegree> degrees;
	private int totDegrees;
	private Map<String,Double> confidence;
	private Map<String,Boolean> killer;
	
	private IDegree aggDegree;
	
	private IMergeStrategy 				mergeStrat;
	private INullHandlingStrategy 		nullStrat;
	
	private IDegreeFactory				factory;
	
	private ArgList args;
	
	

	
	
	public Evaluation(int id, ConstraintKey key, Set<String> deps, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat, IDegreeFactory factory, ArgList args) {
		this.factory = factory;

		
		if (deps == null)
			deps = Collections.emptySet();
		this.nodeId = id;
		this.degrees = new HashMap<String,IDegree>();
		this.confidence = new HashMap<String,Double>();
		this.killer = new HashMap<String,Boolean>();
		
			this.degrees.put(PRIOR, null);	
			this.degrees.put(EVAL, null);
			for (String s : deps) {
				this.degrees.put(s, null);
				confidence.put(s,new Double(0));
				killer.put(s,false);
			}
			totDegrees = 2+deps.size();			
			
		this.key = key;
		this.nullStrat = nullStrat;
		this.mergeStrat = mergeStrat;
		
		this.args = args;
	}
	
	public Evaluation(int id, ConstraintKey key, Set<String> deps, IDegree evalDeg, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat, IDegreeFactory factory, ArgList args) {
		this(id,key,deps,mergeStrat,nullStrat,factory,args);
		this.addDegree(Evaluation.EVAL,evalDeg,1,true);
		
	}
	
	public Evaluation(int id, ConstraintKey key, Set<String> deps, IDegree evalDeg, String source, IMergeStrategy mergeStrat, INullHandlingStrategy nullStrat, IDegreeFactory factory, ArgList args) {
		this(id,key,deps,mergeStrat,nullStrat,factory,args);
		this.addDegree(source,evalDeg,1,true);
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
		this.addDegrees(other.degrees, other.confidence, other.killer);
	}

	private void addDegrees(Map<String, IDegree> moreDegrees, Map<String, Double> conf, Map<String, Boolean> killer) {
		boolean newContrib = false;
		
		for (String source : moreDegrees.keySet()) {
			IDegree evalDeg = moreDegrees.get(source);
			
			Boolean killerContri = killer.get(source);
				if (killerContri == null) 
					killerContri = false;
				
			if (evalDeg != null) {
				//System.out.println("Trying to merge degrees for source "+ source + "+1");
				
				/*
				confidence.put(source, conf.get(source));
				
				if (getDegreeBit(source) == null) {
					this.degrees.put(source,evalDeg);					
					newContrib = true;
				} else {
					this.degrees.put(source,evalDeg);
				}
				 */
				newContrib = newContrib || this.addDegree(source, evalDeg, conf.get(source),killerContri,false);
				
				
				
			}
		}
		if (newContrib) {
//			IDegree oldVal = aggDegree;
			aggDegree = mergeDegrees();
//			if (! oldVal.equals(aggDegree)) {
//				this.setChanged();
//				this.notifyObservers(this);
//			}
		}
	    
	
	}
	
	public boolean addDegree(String source, IDegree evalDeg, double wgt, boolean immediateUpdate) {
		return addDegree(source, evalDeg, wgt, false, immediateUpdate);
	}
		
	public boolean addDegree(String source, IDegree evalDeg, double wgt, boolean isKiller, boolean immediateUpdate) {
		boolean newContrib = false;
		boolean rateIncr = false;
		Double prevConf;
		
		if (evalDeg == null) {
			/*
			newContrib = clearDegree(source);
			rateIncr = true;
			*/
		} else {
		
		
			prevConf = confidence.get(source);
			//System.out.println(prevConf);
				confidence.put(source, wgt);
			rateIncr = prevConf == null ? true : prevConf.doubleValue() < wgt;
			
						
			IDegree oldVal = getDegreeBit(source);
			if (oldVal == null) {
				//System.out.println(this.key+" Added degree for source "+ source + " with wgt "+wgt);
				this.degrees.put(source,evalDeg);
				this.killer.put(source,isKiller);
				newContrib = true;
			} else {
					if (oldVal.equals(evalDeg)) {
						//System.out.println(this.key+" No news for source "+ source + " with wgt "+wgt);
						newContrib = false;
					} else {
						//System.out.println(this.key+" UPDATED degree for source "+ source + " with wgt "+wgt);
						this.degrees.put(source,evalDeg);
						newContrib = true;
					}
					
					boolean wasKiller = killer.get(source);
					if (wasKiller != isKiller) {
						killer.put(source,isKiller);
						newContrib = true;
					}
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
		
		//System.out.println(this.getKey()+"\n\t\tAdd degree status immUpd = "+immediateUpdate + " , newcontr = "+newContrib+ " , rateincr ="+ rateIncr);
		
		
		if (immediateUpdate && newContrib)
			aggDegree = mergeDegrees();
		
		if (immediateUpdate && (newContrib || rateIncr)) {
			this.setChanged();
			this.notifyObservers(this);
		}
		
		return (newContrib || rateIncr);
		
	}
	
	protected void setInfoRate(String source, double delta) {
		confidence.put(source,new Double(delta));
	}
	
	
	/*	
	protected void update(boolean rateIncreased) {
		IDegree newDeg = mergeDegrees();
		
		if ((this.countObservers() > 0) &&  ((! newDeg.equals(aggDegree)) || rateIncreased)) {
			aggDegree = newDeg;
			this.setChanged();
			this.notifyObservers(newDeg);
		} else {
			aggDegree = newDeg;
		}
		
	}
	*/
	
	public boolean clearDegree(String source) {
		boolean cleared = false;
		if (getDegreeBit(source) != null) {
			cleared = true;
			setInfoRate(source,0);
		}
		this.degrees.put(source,null);
		return cleared;
	}
	
	
	public IDegree getDegreeBit(String source) {
		return degrees.get(source);
	}
	
	public Collection<String> getDegreeBitSources() {
		return this.degrees.keySet();
	}
	
	
	protected IDegree mergeDegrees() {
		IDegree[] bits = new IDegree[this.totDegrees];
		boolean[] killerFlags = new boolean[this.totDegrees];
		boolean needKill = false;
		
		int j = 0;
		for (String s : degrees.keySet()) {
			bits[j] = degrees.get(s);
			Boolean flag = killer.get(s);
			killerFlags[j] = flag == null ? false : flag;
				if (killerFlags[j]) 
					needKill = true;
			
			j++;
		}
		
		if (needKill)
			return this.mergeStrat.eval(bits, killerFlags, nullStrat, getFactory());
		else
			return this.mergeStrat.eval(bits, null, nullStrat, getFactory());
	}
	
	
	
	public String toString() {
		return "("+this.args.hashCode()+"@"+this.nodeId + ") : " + this.aggDegree +"/"+ this.getInfoRate() + " " + this.key +" "+ this.getBitS();
	}
	
	public String expand() {
		return toString();
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
	public double getInfoRate() {
		//Prior injection can't be controlled!
		double info = 0;
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
			else
				sb.append(s+" " + "o" + ",");
		}
		return sb.append("]").toString();
	}

	
	
	protected IMergeStrategy getMergeStrat() {
		return mergeStrat;
	}
	protected INullHandlingStrategy getNullHandlingStrat() {
		return nullStrat;
	}
	
	
	
	public int hashCode() {
		return this.key.hashCode() ^ args.hashCode();
	}
	
	public boolean equals(Object other) {
		if (other == null) 
			return false;
		if (other == this)
			return true;
		if (other instanceof Evaluation) {
			Evaluation otherEv = (Evaluation) other;
			return this.key.equals(otherEv.key)  && this.args.equals(otherEv.args);
		}
		return false;
	}
	
	public ArgList getArgs() {
		return args;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(IDegreeFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public IDegreeFactory getFactory() {
		return factory;
	}

	/**
	 * @param killer the killer to set
	 */
	public void setKiller(String id, boolean killer) {
		this.killer.put(id,killer);
	}

	/**
	 * @return the killer
	 */
	public boolean isKiller(String id) {
		return killer.get(id);
	}
	
	
}
