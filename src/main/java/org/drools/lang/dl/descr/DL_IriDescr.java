package org.drools.lang.dl.descr;

import java.util.Map;

import sun.security.action.GetLongAction;

public class DL_IriDescr extends DL_aLeafDescr {
	
	private String namespace;
	private String localName;
		
	private String iri;
	private boolean resolved = false;

	public DL_IriDescr() {
		
	}
	
	public DL_IriDescr(String iri) {
		this.iri = iri;
		this.resolved = true;
	}
	
	public DL_IriDescr(String ns, String ln, Map<String,String> namespaces) {
		this.namespace = ns;
		this.localName = ln;
		
		resolved = namespaces.containsKey(ns);
		if (resolved)			
			this.iri = namespaces.get(ns) + ln;
	}
	
	
	
	public String getIri() {
		return iri;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	public String getLocalName() {
		return localName;
	}

	@Override
	public String getType() {		
		return localName;
	}
	
	public String toString() {
		return  iri + " (" + namespace + ":" + localName + ")";
	}
	
	public String toFullString() {
		return iri;
	}
	
	
	public boolean isResolved() {
		return resolved;
	}
	
	public void resolve(Map<String,String> namespaces) {
		if (! resolved) {
			resolved = namespaces.containsKey(getNamespace());
			if (resolved) 
				this.iri = namespaces.get(getNamespace()) + getLocalName(); 
		}
	}
	

}
