package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.Set;

public class DL_RelationDescr extends DL_aDeclarationDescr {
	
	private Set<DL_DefinitionDescr> equivalentTo;
	
	private Set<DL_DefinitionDescr> disjointWith;
	
	private Set<DL_DefinitionDescr> domain;
	
	private Set<DL_DefinitionDescr> range;
	
	private Set<DL_DefinitionDescr> subPropertyOf;
	
	private boolean functional;
	
	private boolean inverseFunctional;
	
	private boolean reflexive;
	
	private boolean irreflexive;
	
	private boolean symmetric;
	
	private boolean asymmetric;
	
	private boolean transitive; 
	
	private boolean inverse;
	
	
	

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
	
	
	
	
	public Set<DL_DefinitionDescr> getDisjointWith() {
		return disjointWith;
	}
	public void setDisjointWith(Set<DL_DefinitionDescr> disjointWith) {
		this.disjointWith = disjointWith;
	}
	public void addDisjointWith(DL_DefinitionDescr descr) {
		this.disjointWith.add(descr);
	}
	public void addAllDisjointWith(Collection<DL_DefinitionDescr> descrs) {
		this.disjointWith.addAll(descrs);
	}
	
	
	
	public Set<DL_DefinitionDescr> getDomain() {
		return domain;
	}
	public void setDomain(Set<DL_DefinitionDescr> domain) {
		this.domain = domain;
	}
	public void addDomain(DL_DefinitionDescr descr) {
		this.domain.add(descr);
	}
	public void addAllDomain(Collection<DL_DefinitionDescr> descrs) {
		this.domain.addAll(descrs);
	}
	
	
	
	
	public Set<DL_DefinitionDescr> getRange() {
		return range;
	}
	public void setRange(Set<DL_DefinitionDescr> range) {
		this.range = range;
	}
	public void addRange(DL_DefinitionDescr descr) {
		this.range.add(descr);
	}
	public void addAllRange(Collection<DL_DefinitionDescr> descrs) {
		this.range.addAll(descrs);
	}
	
	
	
	
	public Set<DL_DefinitionDescr> getSubPropertyOf() {
		return subPropertyOf;
	}
	public void setSubPropertyOf(Set<DL_DefinitionDescr> subPropertyOf) {
		this.subPropertyOf = subPropertyOf;
	}
	public void addSubPropertyOf(DL_DefinitionDescr descr) {
		this.subPropertyOf.add(descr);
	}
	public void addAllSubPropertyOf(Collection<DL_DefinitionDescr> descrs) {
		this.subPropertyOf.addAll(descrs);
	}
	
	
	
	
	
	
	
	
	
	public boolean isFunctional() {
		return functional;
	}
	public void setFunctional(boolean functional) {
		this.functional = functional;
	}
	public boolean isInverseFunctional() {
		return inverseFunctional;
	}
	public void setInverseFunctional(boolean inverseFunctional) {
		this.inverseFunctional = inverseFunctional;
	}
	public boolean isReflexive() {
		return reflexive;
	}
	public void setReflexive(boolean reflexive) {
		this.reflexive = reflexive;
	}
	public boolean isIrreflexive() {
		return irreflexive;
	}
	public void setIrreflexive(boolean irreflexive) {
		this.irreflexive = irreflexive;
	}
	public boolean isSymmetric() {
		return symmetric;
	}
	public void setSymmetric(boolean symmetric) {
		this.symmetric = symmetric;
	}
	public boolean isAsymmetric() {
		return asymmetric;
	}
	public void setAsymmetric(boolean asymmetric) {
		this.asymmetric = asymmetric;
	}
	public boolean isTransitive() {
		return transitive;
	}
	public void setTransitive(boolean transitive) {
		this.transitive = transitive;
	}
	public boolean isInverse() {
		return inverse;
	}
	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}
	
	
	
	

}
