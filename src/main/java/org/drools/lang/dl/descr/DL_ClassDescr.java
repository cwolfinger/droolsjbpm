package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DL_ClassDescr extends DL_aConceptDescr {

	private Set<DL_DefinitionDescr> subClassOf = new HashSet<DL_DefinitionDescr>();
	
	private Set<DL_DefinitionDescr> disjointWith = new HashSet<DL_DefinitionDescr>();
	
	private Set<DL_DefinitionDescr> disjointUnion = new HashSet<DL_DefinitionDescr>();
	
	private Set<DL_RelationDescr> hasKey = new HashSet<DL_RelationDescr>();

	
	
	
	
	public Set<DL_DefinitionDescr> getSubClassOf() {
		return subClassOf;
	}
	public void setSubClassOf(Set<DL_DefinitionDescr> subClassOf) {
		this.subClassOf = subClassOf;
	}
	public void addSubClassOf(DL_DefinitionDescr descr) {
		this.subClassOf.add(descr);
	}
	public void addAllSubClassOf(Collection<DL_DefinitionDescr> descrs) {
		this.subClassOf.addAll(descrs);
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
	public void addAllDisjointWith(Collection<DL_DefinitionDescr> descr) {
		this.disjointWith.addAll(descr);
	}
	

	
	
	
	
	public Set<DL_DefinitionDescr> getDisjointUnion() {
		return disjointUnion;
	}
	public void setDisjointUnion(Set<DL_DefinitionDescr> disjointUnion) {
		this.disjointUnion = disjointUnion;
	}
	public void addDisjointUnion(DL_DefinitionDescr descr) {
		this.disjointUnion.add(descr);
	}
	public void addAllDisjointUnion(Collection<DL_DefinitionDescr> descr) {
		this.disjointUnion.addAll(descr);
	}
	

	
	
	
	
	
	
	public Set<DL_RelationDescr> getHasKey() {
		return hasKey;
	}
	public void setHasKey(Set<DL_RelationDescr> hasKey) {
		this.hasKey = hasKey;
	}
	public void addHasKey(DL_RelationDescr descr) {
		this.hasKey.add(descr);
	}
	public void addAllHasKey(Collection<DL_RelationDescr> descr) {
		this.hasKey.addAll(descr);
	}
	
	
	
	
	public String toFullDownwardString(int n) {
		String s = super.toFullDownwardString(n);
		String tabs = "";
		for (int j = 0; j < n; j++)
			tabs += "\t";
		
		for (DL_aBaseDescr descr : getEquivalentTo())
			s += tabs + " <==> \t" + descr.toFullDownwardString(n+1);
		
		for (DL_aBaseDescr descr : getSubClassOf())
			s += tabs + " ===> \t" + descr.toFullDownwardString(n+1);
		
		for (DL_aBaseDescr descr : getDisjointWith())
			s += tabs + " =//= \t" + descr.toFullDownwardString(n+1);
		
		for (DL_aBaseDescr descr : getDisjointUnion())
			s += tabs + " |==| \t" + descr.toFullDownwardString(n+1);
		
		for (DL_RelationDescr key : getHasKey())
			s += tabs + "#### \t" + key.toFullDownwardString(n+1);
		
		return s;
	}

}
