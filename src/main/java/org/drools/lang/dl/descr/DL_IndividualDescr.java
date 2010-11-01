package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.Set;

public class DL_IndividualDescr extends DL_aDeclarationDescr {

	private Set<DL_aConceptDescr> types;
	
	private Set<DL_FactDescr> facts;
	
	private Set<Object> sameAs;
	
	private Set<Object> differentFrom;


	
	
	
	public Set<DL_aConceptDescr> getTypes() {
		return types;
	}
	public void setTypes(Set<DL_aConceptDescr> types) {
		this.types = types;
	}
	public void addType(DL_aConceptDescr descr) {
		this.types.add(descr);
	}
	public void addAllType(Collection<DL_aConceptDescr> descr) {
		this.types.addAll(descr);
	}
	

	public Set<DL_FactDescr> getFacts() {
		return facts;
	}
	public void setFacts(Set<DL_FactDescr> facts) {
		this.facts = facts;
	}
	public void addFact(DL_FactDescr descr) {
		this.facts.add(descr);
	}
	public void addAllFact(Collection<DL_FactDescr> descr) {
		this.facts.addAll(descr);
	}
	
	
	public Set<Object> getSameAs() {
		return sameAs;
	}
	public void setSameAs(Set<Object> sameAs) {
		this.sameAs = sameAs;
	}
	public void addSameAs(Object descr) {
		this.sameAs.add(descr);
	}
	public void addAllSameAs(Collection<Object> descr) {
		this.sameAs.addAll(descr);
	}
	

	public Set<Object> getDifferentFrom() {
		return differentFrom;
	}
	public void setDifferentFrom(Set<Object> differentFrom) {
		this.differentFrom = differentFrom;
	}
	public void addDifferentFrom(Object descr) {
		this.differentFrom.add(descr);
	}
	public void addAllDifferentFrom(Collection<Object> descr) {
		this.differentFrom.addAll(descr);
	}
	
	

}
