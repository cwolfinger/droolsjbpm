package org.drools.ide.editors.rete;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import junit.framework.TestCase;

import org.drools.PackageIntegrationException;
import org.drools.RuleBase;
import org.drools.compiler.DroolsParserException;
import org.drools.ide.editors.rete.model.ReteGraph;
import org.drools.reteoo.AlphaNodeVertex;
import org.drools.reteoo.BaseVertex;
import org.drools.reteoo.LeftInputAdapterNodeVertex;
import org.drools.reteoo.ObjectTypeNodeVertex;
import org.drools.reteoo.ReteVertex;
import org.drools.reteoo.ReteooVisitor;
import org.drools.reteoo.TerminalNodeVertex;

/**
 * 
 * Integration-like tests
 * 
 * Testing {@link ReteooLayoutFactory}
 * It is using following components:
 * {@link Row},
 * {@link RowList},
 * org.drools.reteoo.*Vertex,
 * org.drools.ide.editors.rete.model.*
 * 
 * @author Ahti Kitsik
 *
 */
public class ReteooLayoutFactoryTest extends TestCase {

    /**
     * Constructor.
     * 
     * @param name case name
     */
    public ReteooLayoutFactoryTest(String name) {
        super( name );
    }

    /**
     * Test method for {@link org.drools.ide.editors.rete.ReteooLayoutFactory#calculateReteRows(org.drools.reteoo.BaseVertex)}.
     * @throws IOException 
     * @throws DroolsParserException 
     * @throws PackageIntegrationException 
     */
    public final void testCalculateReteRows() throws IOException,
                                             PackageIntegrationException,
                                             DroolsParserException {
        ReteGraph graph = new ReteGraph();
        BaseVertex root = loadRete( graph );
        final RowList rows = ReteooLayoutFactory.calculateReteRows( root );

        int rownum = rows.getDepth();

        assertEquals( 5,
                      rownum );

        int[] expectedDepths = new int[]{-1, 0, 1, 2, 3};
        int[] expectedSizes = new int[]{1, 1, 2, 2, 2};

        for ( int j = 0; j < rownum; j++ ) {
            final Row row = rows.get( j );
            final int rowDepth = row.getDepth();
            assertEquals( expectedDepths[j],
                          rowDepth );
            assertEquals( expectedSizes[j],
                          row.getVertices().size() );
        }

    }

    /**
     * Test method for {@link org.drools.ide.editors.rete.ReteooLayoutFactory#layoutRowList(org.drools.ide.editors.rete.model.ReteGraph, org.drools.ide.editors.rete.RowList)}.
     * 
     * @throws IOException 
     * @throws DroolsParserException 
     * @throws PackageIntegrationException 
     */
    public final void testLayoutRowList() throws PackageIntegrationException,
                                         DroolsParserException,
                                         IOException {
        ReteGraph graph = new ReteGraph();
        BaseVertex root = loadRete( graph );
        final RowList rows = ReteooLayoutFactory.calculateReteRows( root );

        ReteooLayoutFactory.layoutRowList( graph,
                                           rows );

        final List nodes = graph.getChildren();

        BaseVertex[] yOrder = (BaseVertex[]) nodes.toArray( new BaseVertex[0] );
        Arrays.sort( yOrder,
                     new Comparator() {
                         public int compare(Object o1,
                                            Object o2) {
                             BaseVertex v1 = (BaseVertex) o1;
                             BaseVertex v2 = (BaseVertex) o2;
                             int y1 = v1.getLocation().y;
                             int y2 = v2.getLocation().y;
                             return new Integer( y1 ).compareTo( new Integer( y2 ) );
                         }

                     } );

        Class[] expectedTypes = new Class[]{ReteVertex.class, ObjectTypeNodeVertex.class, AlphaNodeVertex.class, AlphaNodeVertex.class, LeftInputAdapterNodeVertex.class, LeftInputAdapterNodeVertex.class, TerminalNodeVertex.class,
                TerminalNodeVertex.class};

        for ( int i = 0; i < yOrder.length; i++ ) {
            assertEquals( expectedTypes[i],
                          yOrder[i].getClass() );
            if ( i > 0 ) {
                // If current vertex has same type as previous then
                // y-pos should match and x-pos should not match.                
                // If type is different then y-pos should *not* match.

                BaseVertex current = yOrder[i];
                BaseVertex previous = yOrder[i - 1];
                if ( current.getClass().equals( previous.getClass() ) ) {
                    assertEquals( current.getLocation().y,
                                  previous.getLocation().y );
                    assertNotSame( new Integer( current.getLocation().x ),
                                   new Integer( previous.getLocation().x ) );
                } else {
                    assertNotSame( new Integer( current.getLocation().y ),
                                   new Integer( previous.getLocation().y ) );
                }
            }
        }

    }

    private BaseVertex loadRete(ReteGraph graph) throws IOException,
                                                DroolsParserException,
                                                PackageIntegrationException {
        final InputStream is = getClass().getClassLoader().getResourceAsStream( "simplerule.drl" );
        String drl = streamToString( is );

        final RuleBase ruleBase = ReteViewer.parseRuleBase( drl,
                                                            null );

        final ReteooVisitor visitor = new ReteooVisitor( graph );
        visitor.visit( ruleBase );

        BaseVertex root = visitor.getRootVertex();
        return root;
    }

    private String streamToString(InputStream is) throws IOException {
        byte[] buffer = new byte[4096];
        OutputStream outputStream = new ByteArrayOutputStream();

        while ( true ) {
            int read = is.read( buffer );

            if ( read == -1 ) {
                break;
            }

            outputStream.write( buffer,
                                0,
                                read );
        }

        outputStream.close();
        is.close();

        return outputStream.toString();
    }

    /**
     * Used by simplerule.drl
     *
     */
    public static class Message {
        public static final int HELLO   = 0;
        public static final int GOODBYE = 1;

        private String          message;

        private int             status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(final int status) {
            this.status = status;
        }
    }

}
