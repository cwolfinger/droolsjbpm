package org.drools.reteoo;

import java.util.Arrays;
import java.util.Comparator;

import org.drools.util.Iterator;
import org.drools.util.LinkedList;
import org.drools.util.ObjectHashMap;
import org.drools.util.ObjectHashMap.ObjectEntry;
import org.drools.reteoo.CompositeRightTupleSinkAdapter.HashKey;

public class AlphaNetworkCompiler {
    private StringBuilder builder;

    public void compile(ObjectTypeNode objectTypeNode) {
        builder = new StringBuilder();
        builder.append( "public class Compiled" + objectTypeNode.getObjectType() + "AlphaNetwork implements RightTupleSink { \n" );
        
        createVars( objectTypeNode.getSinkPropagator().getSinks(), 4  );
        
        builder.append( "    public void assertObject(....) { \n");

        compileAlphaNodes( objectTypeNode.getSinkPropagator(),
                           8 );
        
        builder.append( "    } \n" );
        builder.append( "} \n" );

        System.out.println( builder.toString() );
    }

    public void createVars(RightTupleSink[] sinks,
                           int indent) {
        for ( RightTupleSink sink : sinks ) {
            if ( sink instanceof AlphaNode ) {
                AlphaNode alphaNode = (AlphaNode) sink;
                builder.append( getIndent( indent ) + "AlphaNodeFieldConstraint alphaNodeConstraint" + alphaNode.getId() + ";\n" );
                createVars( alphaNode.getSinkPropagator().getSinks(), indent );
            } else if ( sink instanceof BetaNode ) {
                BetaNode betaNode = (BetaNode) sink;
                builder.append( getIndent( indent ) +  "RightTupleSink sink" + betaNode.getId() + ";\n" );
            } else if ( sink instanceof LeftInputAdapterNode ) {
                LeftInputAdapterNode liaNode = (LeftInputAdapterNode) sink;
                builder.append( getIndent( indent ) +  "RightTupleSink sink" + liaNode.getId() + ";\n" );
            }
        }
    }

    public void compileAlphaNodes(RightTupleSinkPropagator adapter,
                                  int indent) {
        if ( adapter instanceof SingleRightTupleSinkAdapter ) {
            compileAlphaNodeSingleConstraint( (SingleRightTupleSinkAdapter) adapter,
                                              indent );
        } else if ( adapter instanceof CompositeRightTupleSinkAdapter ) {
            compileAlphaNodeCompositeConstraint( (CompositeRightTupleSinkAdapter) adapter,
                                                 indent );
        }
    }

    private void compileAlphaNodeCompositeConstraint(CompositeRightTupleSinkAdapter adapter,
                                                     int indent) {
        RightTupleSinkNodeList sinks = adapter.getHashableSinks();
        if ( sinks != null ) {
            for ( RightTupleSinkNode sink = sinks.getFirst(); sink != null; sink = sink.getNextRightTupleSinkNode() ) {
                compileAlphaNodeSingleConstraint( sink,
                                                  indent );
            }
        }

        sinks = adapter.getOthers();
        if ( sinks != null ) {
            for ( RightTupleSinkNode sink = sinks.getFirst(); sink != null; sink = sink.getNextRightTupleSinkNode() ) {
                compileAlphaNodeSingleConstraint( sink,
                                                  indent );
            }
        }

        ObjectHashMap map = adapter.getHashedSinkMap();
        if ( map != null ) {
            ObjectEntry[] entries = new ObjectEntry[map.size()];
            Iterator it = map.iterator();
            int i = 0;
            for ( ObjectEntry entry = (ObjectEntry) it.next(); entry != null; entry = (ObjectEntry) it.next() ) {
                entries[i++] = entry;
            }

            // we sort as switch works faster with ordered cases
            Arrays.sort( entries,
                         new Comparator() {
                             public int compare(Object o1,
                                                Object o2) {
                                 ObjectEntry entry1 = (ObjectEntry) o1;
                                 ObjectEntry entry2 = (ObjectEntry) o2;
                                 return ((RightTupleSink) entry1.getValue()).getId() - ((RightTupleSink) entry2.getValue()).getId();
                             }

                         } );

            //final Iterator it = map.newIterator();
            builder.append( getIndent( indent ) + "HashKey key = new HashKey(handle);\n" );
            builder.append( getIndent( indent ) + "swtich ((RightTupleSink)this.hashedSinkedMap(key)).getId() {\n" );
            for ( ObjectEntry entry : entries ) {
                RightTupleSink sink = (RightTupleSink) entry.getValue();
                builder.append( getIndent( indent + 4 ) + "case " + sink.getId() + ": {\n" );
                //builder.append( getIndent( indent + 8 ) + "sink" + sink.getId() + ".assertRight(handle, wm, context);\n" );
                
                if (sink instanceof AlphaNode ) {
                    compileAlphaNodes( ((AlphaNode)sink).getSinkPropagator(),
                                       indent + 8 );                    
                }
                
                builder.append( getIndent( indent + 4 )+ "};\n" );
            }
            builder.append( getIndent( indent ) + "};\n" );
        }

    }

    public void compileAlphaNodeSingleConstraint(SingleRightTupleSinkAdapter adapter,
                                                 int indent) {
        compileAlphaNodeSingleConstraint( adapter.getSinks()[0],
                                          indent );
    }

    public void compileAlphaNodeSingleConstraint(RightTupleSink sink,
                                                 int indent) {
        if ( sink instanceof AlphaNode ) {
            AlphaNode alphaNode = (AlphaNode) sink;
            builder.append( getIndent( indent ) + "if ( alphaNodeConstraint" + alphaNode.getId() + ".isAllowed(handle, wm) ) {\n" );
            compileAlphaNodes( alphaNode.getSinkPropagator(),
                               indent + 4 );
            builder.append( getIndent( indent ) + "}\n" );
        } else if ( sink instanceof BetaNode ) {
            BetaNode betaNode = (BetaNode) sink;
            builder.append( getIndent( indent ) + "sink" + betaNode.getId() + ".assertRight(handle, wm, context);\n" );
        } else if ( sink instanceof LeftInputAdapterNode ) {
            LeftInputAdapterNode liaNode = (LeftInputAdapterNode) sink;
            builder.append( getIndent( indent ) + "sink" + liaNode.getId() + ".assertRight(handle, wm, context);\n" );
        }
    }

    public void compileAlphaNodeCompositeConstraint(RightTupleSink sink,
                                                    int indent) {
        if ( sink instanceof AlphaNode ) {
            AlphaNode alphaNode = (AlphaNode) sink;
            builder.append( getIndent( indent ) + "if ( alphaNodeConstraint" + alphaNode.getId() + ".isAllowed(handle, wm) ) {\n" );
            compileAlphaNodes( alphaNode.getSinkPropagator(),
                               indent + 4 );
            builder.append( getIndent( indent ) + "}\n" );
        } else if ( sink instanceof BetaNode ) {
            BetaNode betaNode = (BetaNode) sink;
            builder.append( getIndent( indent ) + "sink" + betaNode.getId() + ".assertRight(handle, wm, context);\n" );
        } else if ( sink instanceof LeftInputAdapterNode ) {
            LeftInputAdapterNode liaNode = (LeftInputAdapterNode) sink;
            builder.append( getIndent( indent ) + "sink" + liaNode.getId() + ".assertRight(handle, wm, context);\n" );
        }
    }

    private String getIndent(int indent) {
        char[] spaces = new char[indent];
        for ( int i = 0; i < spaces.length; i++ ) {
            spaces[i] = ' ';
        }

        return new String( spaces );
    }

}
