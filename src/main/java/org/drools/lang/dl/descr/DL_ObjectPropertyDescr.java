package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class DL_ObjectPropertyDescr extends DL_RelationDescr {

	
	
	private Set<DL_DefinitionDescr> inverseOf;
	
	private Set<List<DL_RelationDescr>> subPropertyChains;
	
	
	
	
	public Set<DL_DefinitionDescr> getInverseOf() {
		return inverseOf;
	}
	public void setInverseOf(Set<DL_DefinitionDescr> inverseOf) {
		this.inverseOf = inverseOf;
	}
	public void addInverseOf(DL_DefinitionDescr descr) {
		this.inverseOf.add(descr);
	}
	public void addAllInverseOf(Collection<DL_DefinitionDescr> descr) {
		this.inverseOf.addAll(descr);
	}
	
	
	
	
	public void setSubPropertyChains(Set<List<DL_RelationDescr>> subPropertyChains) {
		this.subPropertyChains = subPropertyChains;
	}
	public Set<List<DL_RelationDescr>> getSubPropertyChains() {
		return subPropertyChains;
	}
	public void addSubPropertyChain(List<DL_RelationDescr> chain) {
		this.subPropertyChains.add(chain);
	}
	
	
	
	
	

}
