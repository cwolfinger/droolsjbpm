package org.drools.reteoo;

import org.drools.common.InternalFactHandle;

public class ImperfectRightTuple extends RightTuple {
	
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

	
	public ImperfectRightTuple(InternalFactHandle handle,
            RightTupleSink sink,
            EvalRecord record) {
		super(handle,sink);
		setRecord(record);
	}
	

}
