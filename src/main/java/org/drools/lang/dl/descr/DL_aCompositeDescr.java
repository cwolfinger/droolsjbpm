package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public abstract class DL_aCompositeDescr extends DL_aBaseDescr {
	
	private List<DL_aBaseDescr> children = new LinkedList<DL_aBaseDescr>();
	
	   
	public void addChild(DL_aBaseDescr child) {
		children.add(child);
		child.setFather(this);
		//child.setLevel(getLevel()+1);
		//this.setLevel(child.getLevel()+1);
	}
	
	public void addChildren(Collection<DL_aBaseDescr> childs) {
		for (DL_aBaseDescr child : childs)
			this.addChild(child);
	}

	public List<String> getChildTypes() {
		List<String> ans = new LinkedList<String>();
		for (DL_aBaseDescr child : children) {
			ans.add(child.getType());
		}
		return ans;
	}
	
	public List<DL_aBaseDescr> getChildren() {
		return children;
	}
	
	public List<DL_aBaseDescr> getChildrenReversed() {
		List<DL_aBaseDescr> rev = new LinkedList<DL_aBaseDescr>();
		for (int j = children.size()-1; j >= 0; j--) {
			rev.add(children.get(j));				
		}
		return rev;
	}
	
	public void removeChild(DL_aBaseDescr child) {
		children.remove(child);
	}
	
	public void replaceChild(DL_aBaseDescr oldChild, DL_aBaseDescr newChild) {
		int idx = children.indexOf(oldChild);
		children.set(idx, newChild);
		newChild.setFather(this);
		oldChild.setFather(null);
	}
	
	
	
	public String toDownwardString() {
		StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			for (DL_aBaseDescr child : children)
    			sb.append("\t"+child.toString());
		return sb.toString();
	}
	
	public String toFullDownwardString(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString() + formatAnnotations(1));
			for (DL_aBaseDescr child : children) {
				for (int j = 0; j < n; j++)
					sb.append("\t");
				sb.append(child.toFullDownwardString(n+1));
			}
			return sb.toString();
    }

}
