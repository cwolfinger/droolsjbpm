package org.drools.reteoo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Vector;

import org.drools.FactHandle;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.spi.PropagationContext;
import org.drools.util.Iterator;

public class ObservableRightTupleMemoryWrapper extends Observable 
	implements RightTupleMemory {
	
	
	private RightTupleMemory memory;
	private boolean adding;
	private boolean removing;
	private PropagationContext propContext;
	
	
	public boolean isAdding() {
		return adding;
	}
	
	public boolean isRemoving() {
		return removing;
	}
	
	
	public ObservableRightTupleMemoryWrapper(RightTupleMemory wrapped) {
		this.memory = wrapped;	
	}
	

	public EvalIterator getEvalIterator() {
		return new EvalIterator(memory.iterator());
	}
	
	public HandleIterator getHandleIterator() {
		return new HandleIterator(memory.iterator());
	}
	

	public LinkedList<Evaluation> getEvaluations() {
		LinkedList<Evaluation> ans = new LinkedList<Evaluation>();
		EvalIterator iter = this.getEvalIterator();
			while (iter.hasNext()) {
				ans.add(iter.next());
			}
		
		return ans;
	}
	
	public LinkedList<FactHandle> getHandles() {
		LinkedList<FactHandle> ans = new LinkedList<FactHandle>();
		HandleIterator iter = this.getHandleIterator();
			while (iter.hasNext()) {
				ans.add(iter.next());
			}
		
		return ans;
	}
	
	
	public void add(RightTuple rightTuple) {
		this.adding = true;
		memory.add(rightTuple);
			this.setChanged();
			this.notifyObservers(rightTuple);
		this.adding = false;
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


	public void remove(RightTuple rightTuple, PropagationContext context) {
		this.removing = true;
		this.setPropContext(context);
		memory.remove(rightTuple);
			this.setChanged();
			this.notifyObservers(rightTuple);
		this.removing = false;
		this.setPropContext(null);
	}
	
	public void remove(RightTuple rightTuple) {
		this.remove(rightTuple, null);
	}
	

	public int size() {
		return memory.size();
	}
	
	
	
	/**
	 * @param propContext the propContext to set
	 */
	public void setPropContext(PropagationContext propContext) {
		this.propContext = propContext;
	}

	/**
	 * @return the propContext
	 */
	public PropagationContext getPropContext() {
		return propContext;
	}



	class HandleIterator implements java.util.Iterator<FactHandle> {

		private Iterator iterator;
		
		public HandleIterator(Iterator iter) {
			this.iterator = iter;
		}
		
		public boolean hasNext() {
			return iterator.hasNext();
		}

		public FactHandle next() {
			return ((ImperfectRightTuple) iterator.next()).getFactHandle(); 
		}

		public void remove() {
			
		}
		
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
