package org.drools.lang.dl.descr;

public class DL_DefinitionDescr extends DL_aBaseDescr {

	private DL_aBaseDescr root;

	@Override
	public String getType() {
		return root.getType();
	}

	public DL_DefinitionDescr(DL_aBaseDescr root) {
		super();
		this.root = root;
	}

	public DL_aBaseDescr getRoot() {
		return root;
	}

	public void setRoot(DL_aBaseDescr root) {
		this.root = root;
	}
	
	
	

}
