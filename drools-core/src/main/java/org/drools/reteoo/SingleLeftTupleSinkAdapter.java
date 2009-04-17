package org.drools.reteoo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.drools.common.BaseNode;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.common.RuleBasePartitionId;
import org.drools.degrees.factory.IDegreeFactory;
import org.drools.spi.PropagationContext;

public class SingleLeftTupleSinkAdapter extends AbstractLeftTupleSinkAdapter {
    protected LeftTupleSink sink;

    public SingleLeftTupleSinkAdapter() {
        this( RuleBasePartitionId.MAIN_PARTITION, null );
    }

    public SingleLeftTupleSinkAdapter( final RuleBasePartitionId partitionId, final LeftTupleSink sink ) {
        super( partitionId );
        this.sink = sink;
    }

    public void propagateAssertLeftTuple( final LeftTuple leftTuple, final RightTuple rightTuple,
                                          final PropagationContext context, final InternalWorkingMemory workingMemory,
                                          boolean leftTupleMemoryEnabled ) {
        doPropagateAssertLeftTuple( context, workingMemory,
                                    new LeftTuple( leftTuple, rightTuple, this.sink, leftTupleMemoryEnabled ) );
    }
    
    
    public void propagateAssertLeftTuple(ImperfectLeftTuple leftTuple,
			ImperfectRightTuple rightTuple, PropagationContext context,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord record, boolean leftTupleMemoryEnabled) {
    	
    	doPropagateAssertLeftTuple( context, workingMemory, factory, record,
                new ImperfectLeftTuple( leftTuple, rightTuple, this.sink, leftTupleMemoryEnabled, record ) );
		
	}

    
    
	

    public void propagateAssertLeftTuple( final LeftTuple tuple, final PropagationContext context,
                                          final InternalWorkingMemory workingMemory, boolean leftTupleMemoryEnabled ) {
        doPropagateAssertLeftTuple( context, workingMemory, new LeftTuple( tuple, this.sink, leftTupleMemoryEnabled ) );
    }



    
    
    public void propagateAssertLeftTuple(ImperfectLeftTuple tuple,
			PropagationContext context, InternalWorkingMemory workingMemory,
			IDegreeFactory factory, EvalRecord record,
			boolean leftTupleMemoryEnabled) {
    	doPropagateAssertLeftTuple( context, workingMemory, factory, record, new ImperfectLeftTuple( tuple, this.sink, leftTupleMemoryEnabled, record ) );
		
	}
    
    
    
    public void propagateRetractLeftTuple( final LeftTuple leftTuple, final PropagationContext context,
                                           final InternalWorkingMemory workingMemory ) {
        LeftTuple child = leftTuple.getBetaChildren();
        while( child != null ) {
            LeftTuple temp = child.getLeftParentNext();
            doPropagateRetractLeftTuple( context, workingMemory, child, child.getLeftTupleSink() );
            child.unlinkFromRightParent();
            child.unlinkFromLeftParent();
            child = temp;
        }
    }

    public void propagateRetractLeftTupleDestroyRightTuple( final LeftTuple leftTuple, final PropagationContext context,
                                                            final InternalWorkingMemory workingMemory ) {
        LeftTuple child = leftTuple.getBetaChildren();
        while( child != null ) {
            LeftTuple temp = child.getLeftParentNext();
            doPropagateRetractLeftTuple( context, workingMemory, child, child.getLeftTupleSink() );
            workingMemory.getFactHandleFactory().destroyFactHandle( child.getRightParent().getFactHandle() );
            child.unlinkFromRightParent();
            child.unlinkFromLeftParent();
            child = temp;
        }
    }

    public void propagateRetractRightTuple( final RightTuple rightTuple, final PropagationContext context,
                                            final InternalWorkingMemory workingMemory ) {
        LeftTuple child = rightTuple.getBetaChildren();
        while( child != null ) {
            LeftTuple temp = child.getRightParentNext();
            doPropagateRetractLeftTuple( context, workingMemory, child, child.getLeftTupleSink() );
            child.unlinkFromLeftParent();
            child.unlinkFromRightParent();
            child = temp;
        }
    }

    public void createAndPropagateAssertLeftTuple( final InternalFactHandle factHandle,
                                                   final PropagationContext context,
                                                   final InternalWorkingMemory workingMemory,
                                                   boolean leftTupleMemoryEnabled ) {
        doPropagateAssertLeftTuple( context, workingMemory,
                                    new LeftTuple( factHandle, this.sink, leftTupleMemoryEnabled ) );
    }
    
    
    public void createAndPropagateAssertLeftTuple(
			InternalFactHandle factHandle, PropagationContext context,
			InternalWorkingMemory workingMemory, IDegreeFactory factory,
			EvalRecord record, boolean leftTupleMemoryEnabled) {
    	
    	EvalRecord masterRecord = new EvalRecord(-1,factory.getAndOperator(),factory.getMergeStrategy(),factory.getNullHandlingStrategy());
    		masterRecord.addEvaluation(record);
    		
//    		System.out.println("--------------------------------------");
//    		System.out.println(record.expand());
//    		System.out.println("--------------------------------------");
//    		System.out.println(masterRecord.expand());
//    		System.out.println("--------------------------------------");
//    		if (1 == 1) throw new RuntimeException();
    	doPropagateAssertLeftTuple( context, workingMemory, factory, masterRecord,
                new ImperfectLeftTuple( factHandle, this.sink, leftTupleMemoryEnabled, masterRecord ) );
		
	}

	
    

    public BaseNode getMatchingNode( BaseNode candidate ) {
        if( candidate.equals( sink ) ) {
            return (BaseNode) sink;
        }
        return null;
    }

    public LeftTupleSink[] getSinks() {
        return new LeftTupleSink[]{this.sink};
    }

    public int size() {
        return (this.sink != null) ? 1 : 0;
    }

    public void readExternal( ObjectInput in ) throws IOException, ClassNotFoundException {
        super.readExternal( in );
        this.sink = (LeftTupleSink) in.readObject();
    }

    public void writeExternal( ObjectOutput out ) throws IOException {
        super.writeExternal( out );
        out.writeObject( this.sink );
    }

    /**
     * This is a hook method that may be overriden by subclasses. Please keep it
     * package protected.
     *
     * @param context
     * @param workingMemory
     * @param newLeftTuple
     */
    protected void doPropagateAssertLeftTuple( PropagationContext context, InternalWorkingMemory workingMemory,
                                               LeftTuple newLeftTuple ) {
        this.sink.assertLeftTuple( newLeftTuple, context, workingMemory );
    }
    
    
    protected void doPropagateAssertLeftTuple( PropagationContext context, InternalWorkingMemory workingMemory,
            IDegreeFactory factory, EvalRecord record, ImperfectLeftTuple newLeftTuple ) {
    	this.sink.assertLeftTuple( newLeftTuple, context, workingMemory, factory );
    }

    /**
     * This is a hook method that may be overriden by subclasses. Please keep it
     * package protected.
     *
     * @param context
     * @param workingMemory
     * @param child
     * @param tupleSink
     */
    protected void doPropagateRetractLeftTuple( PropagationContext context, InternalWorkingMemory workingMemory,
                                                LeftTuple child, LeftTupleSink tupleSink ) {
        tupleSink.retractLeftTuple( child, context, workingMemory );
    }

	

	

}
