package org.drools.benchmark.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Peter Lin
 *
 * A simple class for benchmarking purposes
 */
public class Fact3 implements Serializable {

	protected String attr1 = null;

	protected String attr2 = null;

	protected String attr3 = null;

	protected String attr4 = null;

	protected String attr5 = null;

	protected String attr6 = null;

	protected String attr7 = null;

	protected String attr8 = null;

	protected String attr9 = null;

	protected String attr10 = null;

	protected ArrayList listeners = new ArrayList();

	/**
	 * 
	 */
	public Fact3() {
		super();
	}

	public void setAttr1(String val) {
		if (!val.equals(this.attr1)) {
			String old = this.attr1;
			this.attr1 = val;
			notifyListener("attr1", old, this.attr1);
		}
	}

	public String getAttr1() {
		return this.attr1;
	}

	public void setAttr2(String val) {
		if (!val.equals(this.attr2)) {
			String old = this.attr2;
			this.attr2 = val;
			notifyListener("attr2", old, this.attr2);
		}
	}

	public String getAttr2() {
		return this.attr2;
	}

	public void setAttr3(String val) {
		if (!val.equals(this.attr3)) {
			String old = this.attr3;
			this.attr3 = val;
			notifyListener("attr3", old, this.attr3);
		}
	}

	public String getAttr3() {
		return this.attr3;
	}

	public void setAttr4(String val) {
		if (!val.equals(this.attr4)) {
			String old = this.attr4;
			this.attr4 = val;
			notifyListener("attr4", old, this.attr4);
		}
	}

	public String getAttr4() {
		return this.attr4;
	}

	public void setAttr5(String val) {
		if (!val.equals(this.attr5)) {
			String old = this.attr5;
			this.attr5 = val;
			notifyListener("attr5", old, this.attr5);
		}
	}

	public String getAttr5() {
		return this.attr5;
	}

	public void setAttr6(String val) {
		if (!val.equals(this.attr6)) {
			String old = this.attr6;
			this.attr6 = val;
			notifyListener("attr6", old, this.attr6);
		}
	}

	public String getAttr6() {
		return this.attr6;
	}

	public void setAttr7(String val) {
		if (!val.equals(this.attr7)) {
			String old = this.attr7;
			this.attr7 = val;
			notifyListener("attr7", old, this.attr7);
		}
	}

	public String getAttr7() {
		return this.attr7;
	}

	public void setAttr8(String val) {
		if (!val.equals(this.attr8)) {
			String old = this.attr8;
			this.attr8 = val;
			notifyListener("attr8", old, this.attr8);
		}
	}

	public String getAttr8() {
		return this.attr8;
	}

	public void setAttr9(String val) {
		if (!val.equals(this.attr9)) {
			String old = this.attr9;
			this.attr9 = val;
			notifyListener("attr9", old, this.attr9);
		}
	}

	public String getAttr9() {
		return this.attr9;
	}

	public void setAttr10(String val) {
		if (!val.equals(this.attr10)) {
			String old = this.attr10;
			this.attr10 = val;
			notifyListener("attr10", old, this.attr10);
		}
	}

	public String getAttr10() {
		return this.attr10;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.add(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.listeners.remove(listener);
	}

	protected void notifyListener(String field, Object oldValue, Object newValue) {
		if (listeners == null || listeners.size() == 0) {
			return;
		} else {
			PropertyChangeEvent event = new PropertyChangeEvent(this, field,
					oldValue, newValue);

			for (int i = 0; i < listeners.size(); i++) {
				((java.beans.PropertyChangeListener) listeners.get(i))
						.propertyChange(event);
			}
		}

	}
}
