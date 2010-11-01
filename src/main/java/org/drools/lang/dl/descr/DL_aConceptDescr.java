package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.Set;

public abstract class DL_aConceptDescr extends DL_aDeclarationDescr {

	private Set<DL_DefinitionDescr> equivalentTo;

	public Set<DL_DefinitionDescr> getEquivalentTo() {
		return equivalentTo;
	}
	public void setEquivalentTo(Set<DL_DefinitionDescr> equivalentTo) {
		this.equivalentTo = equivalentTo;
	}
	public void addEquivalentTo(DL_DefinitionDescr descr) {
		this.equivalentTo.add(descr);
	}
	public void addAllEquivalentTo(Collection<DL_DefinitionDescr> descrs) {
		this.equivalentTo.addAll(descrs);
	}
	
	
}
