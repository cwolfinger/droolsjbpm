package org.drools.reteoo;

import org.drools.common.InternalFactHandle;

public class ImperfectLeftTuple extends LeftTuple {

	private EvalRecord record;

	/**
	 * @param record the record to set
	 */
	public void setRecord(EvalRecord record) {
		this.record = record;
	}

	/**
	 * @return the record
	 */
	public EvalRecord getRecord() {
		return record;
	}

	
	public ImperfectLeftTuple(final InternalFactHandle factHandle,
            LeftTupleSink sink,
            boolean leftTupleMemoryEnabled,
            EvalRecord record) {
		
		super(factHandle,sink,leftTupleMemoryEnabled);
		this.record = record;
	}

	public ImperfectLeftTuple(final ImperfectLeftTuple leftTuple,
            LeftTupleSink sink,
            boolean leftTupleMemoryEnabled,
            EvalRecord record) {

		super(leftTuple,sink,leftTupleMemoryEnabled);
				
		this.record = record;
		
	}

	public ImperfectLeftTuple(final ImperfectLeftTuple leftTuple,
			final ImperfectRightTuple rightTuple,
            LeftTupleSink sink,
            boolean leftTupleMemoryEnabled,
            EvalRecord record
            ) {
		
		super(leftTuple,rightTuple,sink,leftTupleMemoryEnabled);
		
		this.record = record;

	}
	
	
}
