package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DL_ObjectPropertyDescr extends DL_RelationDescr {

	
	
	private Set<DL_DefinitionDescr> inverseOf = new HashSet<DL_DefinitionDescr>();
	
	private Set<List<DL_RelationDescr>> subPropertyChains = new HashSet<List<DL_RelationDescr>>();
	
	
	
	
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
	
	
	
	public String toFullDownwardString(int n) {
		String s = super.toFullDownwardString(n);
		String tabs = "";
		for (int j = 0; j < n; j++)
			tabs += "\t";
		
		for (DL_aBaseDescr descr : getInverseOf())
			s += tabs + "<<>> \t" + descr.toFullDownwardString(n+1);				
		
		for (List<DL_RelationDescr> list : getSubPropertyChains()) {			
			s += tabs + " oooo \t" ;
			for (DL_RelationDescr descr : list) 
				s += descr.toString() + "\t o \t";
		}
		
		
		for (DL_aBaseDescr descr : getDisjointWith())
			s += tabs + " =//= \t" + descr.toFullDownwardString(n+1);
		
		for (DL_aBaseDescr descr : getDomain())
			s += tabs + " |--- \t" + descr.toFullDownwardString(n+1);
		
		for (DL_aBaseDescr descr : getRange())
			s += tabs + " ---> \t" + descr.toFullDownwardString(n+1);
		
		
		
		
		
		return s;
	}
	

}
