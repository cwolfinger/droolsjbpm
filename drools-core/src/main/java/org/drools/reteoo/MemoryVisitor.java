package org.drools.reteoo;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.beta.BetaLeftMemory;
import org.drools.reteoo.beta.BetaRightMemory;
import org.drools.util.PrimitiveLongMap;
import org.drools.util.ReflectiveVisitor;

public class MemoryVisitor extends ReflectiveVisitor {
    private ReteooWorkingMemory workingMemory;
    private int  indent = 0;

    /**
     * Constructor.
     */
    public MemoryVisitor(InternalWorkingMemory workingMemory) {
        this.workingMemory = (ReteooWorkingMemory) workingMemory;
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
        Collection nodes = rete.getObjectTypeNodes();

        Iterator it = nodes.iterator();
        for ( ObjectTypeNode entry = (ObjectTypeNode) it.next(); it.hasNext() ; entry = (ObjectTypeNode) it.next() ) {
            visit( entry );
        }
    }

    public void visitObjectTypeNode(final ObjectTypeNode node) {
        System.out.println( "\n" + indent() + node );
        
        PrimitiveLongMap memory  = ( PrimitiveLongMap ) this.workingMemory.getNodeMemory( node );   
        checkMemory( memory );          

        indent++;
        try {
            Field field = ObjectSource.class.getDeclaredField( "objectSinks" );
            field.setAccessible( true );
            ObjectSinkList sinklist = (ObjectSinkList) field.get( node );
            for( Iterator it = sinklist.iterator(); it.hasNext(); ) {
                ObjectSink sink = (ObjectSink) it.next();
                visit( sink );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        indent--;
    }

    public void visitAlphaNode(final AlphaNode node) {
        System.out.println( "\n" + indent() + node );
        
        Set memory  = ( Set ) this.workingMemory.getNodeMemory( node );  
        checkMemory(memory);
      
        indent++;
        try {
            Field field = ObjectSource.class.getDeclaredField( "objectSinks" );
            field.setAccessible( true );
            ObjectSinkList sinklist = (ObjectSinkList) field.get( node );
            for( Iterator it = sinklist.iterator(); it.hasNext(); ) {
                ObjectSink sink = (ObjectSink) it.next();
                visit( sink );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        indent--;
    }

    public void visitLeftInputAdapterNode(final LeftInputAdapterNode node) {
        System.out.println( "\n" + indent() + node );
        
        Map memory  = ( Map ) this.workingMemory.getNodeMemory( node );  
        checkMemory(memory);

        indent++;
        try {
            Field field = TupleSource.class.getDeclaredField( "tupleSinks" );
            field.setAccessible( true );
            List sinklist = (List) field.get( node );
            for( Iterator it = sinklist.iterator(); it.hasNext(); ) {
                visit( it.next() );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        indent--;
    }

    public void visitJoinNode(final JoinNode node) {
        System.out.println( "\n" + indent() + node );
        
        BetaMemory memory  = ( BetaMemory ) this.workingMemory.getNodeMemory( node );   
        checkMemory( memory.getLeftTupleMemory() );          
        checkMemory( memory.getRightObjectMemory() );
        
        indent++;
        try {
            Field field = TupleSource.class.getDeclaredField( "tupleSinks" );
            field.setAccessible( true );
            List sinklist = (List) field.get( node );
            for( Iterator it = sinklist.iterator(); it.hasNext(); ) {
                visit( it.next() );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        indent--;
    }

    public void visitNotNode(final NotNode node) {
        System.out.println( "\n" + indent() + node );
        
        BetaMemory memory  = ( BetaMemory ) this.workingMemory.getNodeMemory( node );   
        checkMemory( memory.getLeftTupleMemory() );          
        checkMemory( memory.getRightObjectMemory() );
        
        indent++;
        try {
            Field field = TupleSource.class.getDeclaredField( "tupleSinks" );
            field.setAccessible( true );
            List sinklist = (List) field.get( node );
            for( Iterator it = sinklist.iterator(); it.hasNext(); ) {
                visit( it.next() );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        indent--;
    }

    public void visitTerminalNode(final TerminalNode node) {
        System.out.println( "\n" + indent() + node );
    }
    
    private void checkMemory( PrimitiveLongMap memory ) {
        Collection values = memory.values();
        
        System.out.println( indent() + "PrimitiveLongMap: " + memory.size()  + ":" + values.size());
        if ( memory.size() != values.size() ) {
            System.out.println( indent() + "error" );
        }  
    }
    
    private void checkMemory( Set memory ) {
        System.out.println( indent() + "Set: " + memory.size());
    }
    
    private void checkMemory( Map memory ) {
        System.out.println( indent() + "Map: " + memory.size());
    }
    
    private void checkMemory( BetaLeftMemory memory ) {
        System.out.println( indent() + "BetaLeftMemory: " + memory.size());
    }
    
    private void checkMemory( BetaRightMemory memory ) {
        System.out.println( indent() + "BetaRightMemory: " + memory.size());
    }
    
    private String  indent() {
        StringBuffer buffer  = new  StringBuffer();
        for ( int i  =  0; i <  indent; i++ ) {
            buffer.append( "  " );
        }
        return buffer.toString();
    }
}
