package org.drools.lang.dl.descr;

public class DL_DefinitionDescr extends DL_aBaseDescr {

	private DL_aBaseDescr root;

	@Override
	public String getType() {
		return root != null ? ("DL_Def : " + root.getType()) : "WARN : NULL Definition";
	}
	
	public String toFullDownwardString(int n) {
    	return root.toFullDownwardString(n+1);
    }


	
	public DL_DefinitionDescr() {
		super();		
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
