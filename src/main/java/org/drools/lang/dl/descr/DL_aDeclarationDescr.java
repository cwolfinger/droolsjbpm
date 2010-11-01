package org.drools.lang.dl.descr;

public class DL_aDeclarationDescr extends DL_aBaseDescr {

	private DL_IriDescr iri;
	
		
	public String getType() {
		return iri.getIri();
	}


	public DL_IriDescr getIri() {
		return iri;
	}

	public void setIri(DL_IriDescr iri) {
		this.iri = iri;
	}

}
