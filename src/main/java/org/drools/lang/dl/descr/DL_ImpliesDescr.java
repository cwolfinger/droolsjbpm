package org.drools.lang.dl.descr;

import java.util.Collection;



public class DL_ImpliesDescr extends DL_aCompositeDescr {
	
	public void addChild(DL_aBaseDescr child) {
		if (getChildren().size() < 2)
			super.addChild(child);
	}
	
	public void addChildren(Collection<DL_aBaseDescr> childs) {
		if (getChildren().size()+childs.size() <= 2)
			super.addChildren(childs);
	}
	
	@Override
	public String getType() {
		return (isNegated() ? "not" : "") + "DL_IMPLIES";
	}
	
}
