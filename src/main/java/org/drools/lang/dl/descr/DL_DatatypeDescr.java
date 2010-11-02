package org.drools.lang.dl.descr;

public class DL_DatatypeDescr extends DL_aConceptDescr {

	public String toFullDownwardString(int n) {
		String s = super.toFullDownwardString(n);
		String tabs = "";
		for (int j = 0; j < n; j++)
			tabs += "\t";
		
		for (DL_aBaseDescr descr : getEquivalentTo())
			s += tabs + " <==> \t" + descr.toFullDownwardString(n+1);
		
		
		return s;
	}

}
