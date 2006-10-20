package org.drools.ide.editors.rete;

/*
 * Copyright 2006 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.drools.PackageIntegrationException;
import org.drools.RuleBase;
import org.drools.compiler.DrlParser;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.ide.DroolsIDEPlugin;
import org.drools.ide.builder.DroolsBuilder;
import org.drools.ide.editors.DSLAdapter;
import org.drools.ide.editors.rete.model.ReteGraph;
import org.drools.ide.editors.rete.part.VertexEditPartFactory;
import org.drools.ide.util.ProjectClassLoader;
import org.drools.lang.descr.PackageDescr;
import org.drools.reteoo.BaseVertex;
import org.drools.reteoo.ReteooRuleBase;
import org.drools.reteoo.ReteooVisitor;
import org.drools.rule.Package;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugException;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * GEF-based RETE Viewer
 * 
 * @author Ahti Kitsik
 *
 */
public class ReteViewer extends GraphicalEditor {

    ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();

    private IDocumentProvider    documentProvider;

    private ReteGraph            diagram      = new ReteGraph();

    /**
     * Constructor.
     * 
     * @param documentProvider documentProvider must contain Document with rules.
     */
    public ReteViewer(IDocumentProvider documentProvider) {
        super();
        this.documentProvider = documentProvider;
        setEditDomain( new DefaultEditDomain( this ) );
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
     */
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        GraphicalViewer viewer = getGraphicalViewer();
        viewer.getControl().setBackground( ColorConstants.white );
        viewer.setEditPartFactory( new VertexEditPartFactory() );
        viewer.setRootEditPart( rootEditPart );
        viewer.setKeyHandler( new GraphicalViewerKeyHandler( viewer ) );
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class type) {

        if ( type == ZoomManager.class ) return ((ScalableFreeformRootEditPart) getGraphicalViewer().getRootEditPart()).getZoomManager();
        if ( type == GraphicalViewer.class ) return getGraphicalViewer();
        if ( type == EditPart.class && getGraphicalViewer() != null ) return getGraphicalViewer().getRootEditPart();
        if ( type == IFigure.class && getGraphicalViewer() != null ) return ((GraphicalEditPart) getGraphicalViewer().getRootEditPart()).getFigure();
        return super.getAdapter( type );
    }

    private RuleBase getRuleBase() {
        if ( getEditorInput() instanceof IFileEditorInput ) {
            try {
                String contents = documentProvider.getDocument( getEditorInput() ).get();

                ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();
                ClassLoader newLoader = DroolsBuilder.class.getClassLoader();
                IFile file = ((IFileEditorInput) getEditorInput()).getFile();
                if ( file.getProject().getNature( "org.eclipse.jdt.core.javanature" ) != null ) {
                    IJavaProject project = JavaCore.create( file.getProject() );
                    newLoader = ProjectClassLoader.getProjectClassLoader( project );
                }

                Reader dslReader = DSLAdapter.getDSLContent( contents,
                                                             file );

                try {
                    Thread.currentThread().setContextClassLoader( newLoader );

                    return parseRuleBase( contents,
                                          dslReader );

                } catch ( Exception t ) {
                    throw t;
                } finally {
                    Thread.currentThread().setContextClassLoader( oldLoader );
                }
            } catch ( Throwable t ) {
                DroolsIDEPlugin.log( t );
            }
        }

        return null;

    }

    /**
     * 
     * 
     * @param contents
     * @param dslReader
     * @return
     * @throws DroolsParserException
     * @throws PackageIntegrationException
     */
    public static RuleBase parseRuleBase(String contents,
                                         Reader dslReader) throws DroolsParserException,
                                                          PackageIntegrationException {
        DrlParser parser = new DrlParser();

        PackageDescr packageDescr = null;
        if ( dslReader == null ) {
            packageDescr = parser.parse( contents );
        } else {
            packageDescr = parser.parse( contents,
                                         dslReader );
        }

        //pre build the package
        PackageBuilder builder = new PackageBuilder();
        builder.addPackage( packageDescr );
        Package pkg = builder.getPackage();

        //add the package to a rulebase
        ReteooRuleBase ruleBase = new ReteooRuleBase();
        ruleBase.addPackage( pkg );
        return ruleBase;
    }

    /**
     * Loads model from rule base,
     * calculates rete view and initializes diagram model.
     */
    public void loadReteModel() {
        try {

            diagram.removeAll();

            RuleBase ruleBase = getRuleBase();
            if ( ruleBase == null ) {
                DroolsIDEPlugin.log( new Exception( "Unable to load rule base!" ) );
            } else {

                final ReteooVisitor visitor = new ReteooVisitor( diagram );
                visitor.visit( ruleBase );

                BaseVertex rootVertex = visitor.getRootVertex();

                RowList rowList = ReteooLayoutFactory.calculateReteRows( rootVertex );
                ReteooLayoutFactory.layoutRowList( diagram,
                                                   rowList );

            }
        } catch ( Throwable t ) {
            t.printStackTrace();
            DroolsIDEPlugin.log( t );
        }
    }

    private ReteGraph getModel() {
        return diagram;
    }

    /**
     * Loads Rete model and initializes zoom manager.
     * 
     */
    protected void initializeGraphicalViewer() {
        GraphicalViewer viewer = getGraphicalViewer();

        // Generate rete and layout
        loadReteModel();

        zeroBaseDiagram();

        // Make rete graph visible
        viewer.setContents( getModel() ); // set the contents of this editor

        ZoomManager zoomManager = rootEditPart.getZoomManager();

        //List<String>
        List zoomLevels = new ArrayList( 3 );

        zoomLevels.add( ZoomManager.FIT_ALL );
        zoomLevels.add( ZoomManager.FIT_HEIGHT );
        zoomLevels.add( ZoomManager.FIT_WIDTH );

        zoomManager.setZoomLevelContributions( zoomLevels );

        // Zoom mousewheel - Ctrl+Mousewheel for zoom in/out
        getGraphicalViewer().setProperty( MouseWheelHandler.KeyGenerator.getKey( SWT.MOD1 ),
                                          MouseWheelZoomHandler.SINGLETON );

    }

    /**
     * Moves all <code>diagram</code> nodes to upper left corner
     * and shifting to right if neccessary to get rid of negative XY coordinates.
     * 
     */
    private void zeroBaseDiagram() {
        int minx = 0;
        int miny = 0;

        final Iterator nodeIter = diagram.getChildren().iterator();
        while ( nodeIter.hasNext() ) {
            Point loc = ((BaseVertex) (nodeIter.next())).getLocation();
            minx = Math.min( loc.x,
                             minx );
            miny = Math.min( loc.y,
                             miny );
        }

        minx = minx - 10;

        final Iterator nodeIter2 = diagram.getChildren().iterator();
        while ( nodeIter2.hasNext() ) {
            final BaseVertex vertex = (BaseVertex) (nodeIter2.next());
            Point loc = vertex.getLocation();
            vertex.setLocation( new Point( loc.x - minx,
                                           loc.y - miny ) );
        }
    }

    /**
     * No save operation in ReteViewer
     */
    public void doSave(IProgressMonitor monitor) {

    }

    /**
     * ReteViewer is never dirty.
     * This prevents editor close mechanism to ask file save confirmation
     * even after one of the vertices is moved.
     */
    public boolean isDirty() {
        return false;
    }

}