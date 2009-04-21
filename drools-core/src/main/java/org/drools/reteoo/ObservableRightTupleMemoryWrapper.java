package org.drools.reteoo;

import java.util.Collection;
import java.util.Observable;
import java.util.Vector;

import org.drools.util.Iterator;

public class ObservableRightTupleMemoryWrapper extends Observable 
	implements RightTupleMemory {
	
	
	private RightTupleMemory memory;
	
	public ObservableRightTupleMemoryWrapper(RightTupleMemory wrapped) {
		this.memory = wrapped;
	}
	

	public EvalIterator getIterator() {
		return new EvalIterator(memory.iterator());
	}
	

	public Collection<Evaluation> getArgs() {
		Vector<Evaluation> ans = new Vector<Evaluation>(memory.size());
		EvalIterator iter = this.getIterator();
			while (iter.hasNext()) {
				ans.add(iter.next());
			}
		
		return ans;
	}
	
	
	public void add(RightTuple rightTuple) {
		memory.add(rightTuple);
		this.setChanged();
		this.notifyObservers(rightTuple);
	}

	public boolean contains(RightTuple rightTuple) {
		return memory.contains(rightTuple);	
	}

	public RightTuple getFirst(LeftTuple leftTuple) {
		return memory.getFirst(leftTuple);
	}

	public RightTuple getLast(LeftTuple leftTuple) {
		return memory.getLast(leftTuple);
	}

	public boolean isIndexed() {
		return memory.isIndexed();
	}

	public Iterator iterator() {
		return memory.iterator();
		
	}

	public void remove(RightTuple rightTuple) {
		memory.remove(rightTuple);
		this.setChanged();
		this.notifyObservers(rightTuple);
	}

	public int size() {
		return memory.size();
	}
	
	
	class EvalIterator implements java.util.Iterator<Evaluation> {

		private Iterator iterator;
		
		public EvalIterator(Iterator iter) {
			this.iterator = iter;
		}
		
		public boolean hasNext() {
			return iterator.hasNext();
		}

		public Evaluation next() {
			return ((ImperfectRightTuple) iterator.next()).getRecord(); 
		}

		public void remove() {
			
		}
		
	}

}
