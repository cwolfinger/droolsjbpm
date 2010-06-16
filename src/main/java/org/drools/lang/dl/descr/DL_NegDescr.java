package org.drools.lang.dl.descr;

import java.util.Collection;


public class DL_NegDescr extends DL_CompositeDescr {
	
	public void addChild(DL_BaseDescr child) {
		if (getChildren().size() == 0)
			super.addChild(child);
	}
	
	public void addChildren(Collection<DL_BaseDescr> childs) {
		if (getChildren().size() == 0 && childs.size() == 1)
			super.addChildren(childs);
	}
	
	@Override
	public String getType() {
		return "DL_NOT";
	}
	
}
