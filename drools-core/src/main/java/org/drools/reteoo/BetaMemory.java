package org.drools.reteoo;

import java.io.Serializable;

import org.drools.util.ObjectHashMap;

public class BetaMemory implements Serializable {

	private static final long serialVersionUID = 400L;

	private LeftTupleMemory leftTupleMemory;
	private RightTupleMemory rightTupleMemory;
	private ObjectHashMap createdHandles;

	public BetaMemory(final LeftTupleMemory leftTupleMemory,
		final RightTupleMemory rightTupleMemory) {
		this.leftTupleMemory = leftTupleMemory;
		this.rightTupleMemory = rightTupleMemory;
	}

	public RightTupleMemory getRightTupleMemory() {
		return this.rightTupleMemory;
	}

	public LeftTupleMemory getLeftTupleMemory() {
		return this.leftTupleMemory;
	}

	public ObjectHashMap getCreatedHandles() {
		if (this.createdHandles == null) {
			this.createdHandles = new ObjectHashMap();
		}
		return this.createdHandles;
	}
}
