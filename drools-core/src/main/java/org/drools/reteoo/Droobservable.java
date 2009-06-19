package org.drools.reteoo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;


public class Droobservable extends Observable {
	
	private boolean changd;
	
	private Vector<Observer> observers = new Vector<Observer>();
	
	public void deleteObserver(Observer o) {
		if (o == null)
			return;
		for (int j = 0; j < observers.size(); j++)
			if (observers.get(j) == o) {
				observers.remove(j);
				return;
			}
	}
	
	public void deleteObservers() {
		this.observers.clear();
	}
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public int countObservers() {
		return observers.size();
	}

	public void notifyObservers(Object arg) {
		if (isChanged()) {
			this.changd = false;
			Vector<Observer> observerz = new Vector<Observer>(observers);
			for (Observer o : observerz)
				o.update(this, arg);
				
		}
	}

	public void setChanged() {
		this.changd = true;
	}

	public boolean isChanged() {
		return changd;
	}
	
}
