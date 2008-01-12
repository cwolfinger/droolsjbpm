package org.drools.reteoo;

import java.lang.reflect.Field;
import java.util.Map;

import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.RuleTerminalNode.TerminalNodeMemory;
import org.drools.spi.ObjectType;
import org.drools.util.AbstractHashTable;
import org.drools.util.Entry;
import org.drools.util.FactHandleIndexHashTable;
import org.drools.util.FactHashTable;
import org.drools.util.ObjectHashSet;
import org.drools.util.ReflectiveVisitor;
import org.drools.util.TupleHashTable;
import org.drools.util.TupleIndexHashTable;

public class MemoryVisitor extends ReflectiveVisitor {
    private InternalWorkingMemory workingMemory;
    private int                   indent = 0;

    /**
     * Constructor.
     */
    public MemoryVisitor(final InternalWorkingMemory workingMemory) {
        this.workingMemory = workingMemory;
    }

    /**
     * RuleBaseImpl visits its Rete.
     */
    public void visitReteooRuleBase(final ReteooRuleBase ruleBase) {
        visit( (ruleBase).getRete() );
    }

    /**
     * Rete visits each of its ObjectTypeNodes.
     */
    public void visitRete(final Rete rete) {
        final Map<ObjectType, ObjectTypeNode> map = rete.getObjectTypeNodes();

        for( ObjectTypeNode node : map.values() ) {
            visit( node );
        }
    }

    public void visitObjectTypeNode(final ObjectTypeNode node) {
        System.out.println( indent() + node );

        final ObjectHashSet memory = (ObjectHashSet) this.workingMemory.getNodeMemory( node );
        //checkObjectHashTable( memory );

        this.indent++;
        try {
            final Field field = RightTupleSource.class.getDeclaredField( "sink" );
            field.setAccessible( true );
            final RightTupletSinkPropagator sink = (RightTupletSinkPropagator) field.get( node );
            final RightTupleSink[] sinks = sink.getSinks();
            for ( int i = 0, length = sinks.length; i < length; i++ ) {
                visit( sinks[i] );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }
        this.indent--;
    }

    public void visitAlphaNode(final AlphaNode node) {
        System.out.println( indent() + node );

        final FactHashTable memory = (FactHashTable) this.workingMemory.getNodeMemory( node );
        checkObjectHashTable( memory );

        this.indent++;
        try {
            final Field field = RightTupleSource.class.getDeclaredField( "sink" );
            field.setAccessible( true );
            final RightTupletSinkPropagator sink = (RightTupletSinkPropagator) field.get( node );
            final RightTupleSink[] sinks = sink.getSinks();
            for ( int i = 0, length = sinks.length; i < length; i++ ) {
                visit( sinks[i] );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }
        this.indent--;
    }

    public void visitLeftInputAdapterNode(final LeftInputAdapterNode node) {
        System.out.println( indent() + node );

        this.indent++;
        try {
            final Field field = LeftTupleSource.class.getDeclaredField( "sink" );
            field.setAccessible( true );
            final LeftTupleSinkPropagator sink = (LeftTupleSinkPropagator) field.get( node );
            final LeftTupleSink[] sinks = sink.getSinks();
            for ( int i = 0, length = sinks.length; i < length; i++ ) {
                visit( sinks[i] );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }
        this.indent--;
    }

    public void visitJoinNode(final JoinNode node) {
        System.out.println( indent() + node );

        try {
            final BetaMemory memory = (BetaMemory) this.workingMemory.getNodeMemory( node );
            checkObjectHashTable( memory.getRightTupleMemory() );
            checkTupleMemory( memory.getLeftTupleMemory() );
        } catch ( final Exception e ) {
            e.printStackTrace();
        }

        this.indent++;
        try {
            final Field field = LeftTupleSource.class.getDeclaredField( "sink" );
            field.setAccessible( true );
            final LeftTupleSinkPropagator sink = (LeftTupleSinkPropagator) field.get( node );
            final LeftTupleSink[] sinks = sink.getSinks();
            for ( int i = 0, length = sinks.length; i < length; i++ ) {
                visit( sinks[i] );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }
        this.indent--;
    }

    public void visitNotNode(final NotNode node) {
        System.out.println( indent() + node );
        try {
            final BetaMemory memory = (BetaMemory) this.workingMemory.getNodeMemory( node );
            checkObjectHashTable( memory.getRightTupleMemory() );
            checkTupleMemory( memory.getLeftTupleMemory() );
        } catch ( final Exception e ) {
            e.printStackTrace();
        }

        this.indent++;
        try {
            final Field field = LeftTupleSource.class.getDeclaredField( "sink" );
            field.setAccessible( true );
            final LeftTupleSinkPropagator sink = (LeftTupleSinkPropagator) field.get( node );
            final LeftTupleSink[] sinks = sink.getSinks();
            for ( int i = 0, length = sinks.length; i < length; i++ ) {
                visit( sinks[i] );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }
        this.indent--;
    }

    public void visitRuleTerminalNode(final RuleTerminalNode node) {
        System.out.println( indent() + node );
        final TerminalNodeMemory memory = (TerminalNodeMemory) this.workingMemory.getNodeMemory( node );
        checkTupleMemory( memory.getTupleMemory() );
    }

    //    private void checkObjectHashMap(final ObjectHashMap map) {
    //        final Entry[] entries = map.getTable();
    //        int count = 0;
    //        for ( int i = 0, length = entries.length; i < length; i++ ) {
    //            if ( entries[i] != null ) {
    //                count++;
    //            }
    //        }
    //
    //        System.out.println( "ObjectHashMap: " + indent() + map.size() + ":" + count );
    //        if ( map.size() != count ) {
    //            System.out.println( indent() + "error" );
    //        }
    //    }

    private void checkObjectHashTable(final RightTupleMemory memory) {
        if ( memory instanceof FactHashTable ) {
            checkRightTupleList( (FactHashTable) memory );
        } else if ( memory instanceof FactHandleIndexHashTable ) {
            checkRightTupleIndexHashTable( (FactHandleIndexHashTable) memory );
        } else {
            throw new RuntimeException( memory.getClass() + " should not be here" );
        }
    }

    private void checkRightTupleList(final FactHashTable memory) {
        RightTuple rightTuple = memory.getFirst( null );
        int count = 0;
        while ( rightTuple != null ) {
            count++;
            if  ( rightTuple.getBetaChildren() !=  null ) {
                System.out.println( indent() + "error : RightTuple has beta children " + rightTuple );
            }
            
            if ( rightTuple.getBlocked() != null) {
                System.out.println( indent() + "error : RightTuple is blocking a tuple " + rightTuple );
            }
            rightTuple = ( RightTuple ) rightTuple.getNext();            
        }

        System.out.println( indent() + "FactHashTable: " + memory.size() + ":" + count );
        if ( memory.size() != count ) {
            System.out.println( indent() + "error" );
        }
    }

    private void checkRightTupleIndexHashTable(final FactHandleIndexHashTable memory) {
        final Entry[] entries = memory.getTable();
        int factCount = 0;
        int bucketCount = 0;
        for ( int i = 0, length = entries.length; i < length; i++ ) {
            if ( entries[i] != null ) {
                FactHashTable alphaList = (FactHashTable) entries[i];
                while ( alphaList != null ) {
                    if ( alphaList.getFirst(null) != null ) {
                        RightTuple rightTuple = alphaList.getFirst(null);
                        while ( rightTuple != null ) {
                            if  ( rightTuple.getBetaChildren() !=  null ) {
                                System.out.println( indent() + "error : RightTuple has beta children " + rightTuple );
                            }
                            
                            if ( rightTuple.getBlocked() != null) {
                                System.out.println( indent() + "error : RightTuple is blocking a tuple " + rightTuple );
                            }                         
                            rightTuple = (RightTuple) rightTuple.getNext();                            
                            factCount++;
                        }
                    } else {
                        System.out.println( "error : RightTupleIndexHashTable cannot have empty RightTupleList objects" );
                    }
                    alphaList = (FactHashTable) alphaList.getNext();
                    bucketCount++;
                }
            }
        }

        try {
            final Field field = AbstractHashTable.class.getDeclaredField( "size" );
            field.setAccessible( true );
            System.out.println( indent() + "RightTupleBuckets: " + ((Integer) field.get( memory )).intValue() + ":" + bucketCount );
            if ( ((Integer) field.get( memory )).intValue() != bucketCount ) {
                System.out.println( indent() + "error" );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }

        System.out.println( indent() + "RightTupleFacts: " + memory.size() + ":" + factCount );
        if ( memory.size() != factCount ) {
            System.out.println( indent() + "error" );
        }
    }

    private void checkTupleMemory(final LeftTupleMemory memory) {
        if ( memory instanceof TupleHashTable ) {
            checkLeftTupleList( (TupleHashTable) memory );
        } else if ( memory instanceof TupleIndexHashTable ) {
            checkLeftTupleIndexedHashTable( (TupleIndexHashTable) memory );
        } else {
            throw new RuntimeException( memory.getClass() + " should not be here" );
        }
    }
    
    private void  checkLeftTupleList(final TupleHashTable memory){
        Entry entry = memory.getFirst( null );
        int count = 0;
        while ( entry != null ) {
            count++;
            entry = entry.getNext();
        }

        System.out.println( indent() + "TupleHashTable: " + memory.size() + ":" + count );
        if ( memory.size() != count ) {
            System.out.println( indent() + "error" );
        }
    }
    
    private void checkLeftTupleIndexedHashTable(final TupleIndexHashTable memory) {
        final Entry[] entries = memory.getTable();
        int factCount = 0;
        int bucketCount = 0;
        for ( int i = 0, length = entries.length; i < length; i++ ) {
            if ( entries[i] != null ) {
                TupleHashTable leftList = (TupleHashTable) entries[i];
                while ( leftList != null ) {
                    if ( leftList.getFirst(null) != null ) {
                        Entry entry = leftList.getFirst(null);
                        while ( entry != null ) {
                            entry = entry.getNext();
                            factCount++;
                        }
                    } else {
                        System.out.println( "error : LeftIndexHashTable cannot have empty TupleHashTable objects" );
                    }
                    leftList = (TupleHashTable) leftList.getNext();
                    bucketCount++;
                }
            }
        }

        try {
            final Field field = AbstractHashTable.class.getDeclaredField( "size" );
            field.setAccessible( true );
            System.out.println( indent() + "LeftIndexBuckets: " + ((Integer) field.get( memory )).intValue() + ":" + bucketCount );
            if ( ((Integer) field.get( memory )).intValue() != bucketCount ) {
                System.out.println( indent() + "error" );
            }
        } catch ( final Exception e ) {
            e.printStackTrace();
        }

        System.out.println( indent() + "LeftIndexFacts: " + memory.size() + ":" + factCount );
        if ( memory.size() != factCount ) {
            System.out.println( indent() + "error" );
        }        
    }

    private String indent() {
        final StringBuffer buffer = new StringBuffer();
        for ( int i = 0; i < this.indent; i++ ) {
            buffer.append( "  " );
        }
        return buffer.toString();
    }
}
