package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DL_OntologyDescr extends DL_aCompositeDescr {

	private DL_IriDescr name;
	private DL_IriDescr version;
	
	private Map<String,String> namespaces;
	
	private Collection<String> importRefs;
	
	
	private Collection<DL_aDeclarationDescr> declarations;
	
	
	
	public DL_OntologyDescr() {
		this.namespaces = new HashMap<String, String>();
		this.namespaces.put("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
		this.namespaces.put("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
		this.namespaces.put("xsd", "http://www.w3.org/2001/XMLSchema#");
		this.namespaces.put("owl", "http://www.w3.org/2002/07/owl#");
		this.namespaces.put("", "http://drools.jboss.org/test/v6#");
		
		this.importRefs = new LinkedList<String>();
		
		this.declarations = new LinkedList<DL_aDeclarationDescr>();
	}
	
	@Override
	public String getType() {		
		return "Ontology";		
	}

	
	public String toFullDownwardString(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toFullDownwardString(n)).append("\n");
		for (DL_aDeclarationDescr descr : declarations)
			sb.append(descr.toFullDownwardString(n+1)).append("\n");
		return sb.toString();
    }
	
	
	
	public DL_IriDescr getName() {
		return name;
	}

	public void setName(DL_IriDescr name) {
		this.name = name;
	}

	public DL_IriDescr getVersion() {
		return version;
	}

	public void setVersion(DL_IriDescr version) {
		this.version = version;
	}

	public void addNamespace(String key, String full) {
		this.namespaces.put(key, full);
		
		// prefixes come after ontology name and version, so need to check
		if (name != null && ! name.isResolved())
			name.resolve(namespaces);
		if (version != null && ! version.isResolved())
			version.resolve(namespaces);
	}

	public Map<String,String> getNamespaces() {
		return namespaces;
	}
	
	
	public String toString() {
		return "Ontology " + name + " - " + version; 
	}
	
	
	public void addImport(String tgtRef) {
		this.importRefs.add(tgtRef);
	}

	
	
	
	public void setDeclarations(Collection<DL_aDeclarationDescr> declarations) {
		this.declarations = declarations;
	}
	public Collection<? extends DL_aDeclarationDescr> getDeclarations() {
		return declarations;
	}
	public void addDeclaration(DL_aDeclarationDescr descr) {
		this.declarations.add(descr);
	}
	
	
	
	

}
