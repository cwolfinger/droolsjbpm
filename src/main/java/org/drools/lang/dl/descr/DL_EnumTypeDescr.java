package org.drools.lang.dl.descr;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;



public class DL_EnumTypeDescr extends DL_aLeafDescr {
	
	private Collection<Object> elements = new HashSet<Object>();

	@Override
	public String getType() {
		return "Set";
	}

	public Collection<Object> getElements() {
		return elements;
	}

	public void setElements(Collection<Object> elements) {
		this.elements = elements;
	}

	public boolean add(Object e) {
		return elements.add(e);
	}

	public boolean addAll(Collection<? extends Object> c) {
		return elements.addAll(c);
	}

	public boolean contains(Object o) {
		return elements.contains(o);
	}

	public Iterator<Object> iterator() {
		return elements.iterator();
	}

	public int size() {
		return elements.size();
	}
	
	
		
}
