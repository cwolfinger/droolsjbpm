package org.drools.lang.dl.descr;

import java.util.Collection;



public class DL_ImpliesDescr extends DL_CompositeDescr {
	
	public void addChild(DL_BaseDescr child) {
		if (getChildren().size() < 2)
			super.addChild(child);
	}
	
	public void addChildren(Collection<DL_BaseDescr> childs) {
		if (getChildren().size()+childs.size() <= 2)
			super.addChildren(childs);
	}
	
	@Override
	public String getType() {
		return (isNegated() ? "not" : "") + "DL_IMPLIES";
	}
	
}
