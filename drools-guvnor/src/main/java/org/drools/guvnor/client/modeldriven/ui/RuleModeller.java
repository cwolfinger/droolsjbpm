/*
 * Copyright 2005 JBoss Inc
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

package org.drools.guvnor.client.modeldriven.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.guvnor.client.common.ClickableLabel;
import org.drools.guvnor.client.common.DirtyableComposite;
import org.drools.guvnor.client.common.DirtyableFlexTable;
import org.drools.guvnor.client.common.DirtyableHorizontalPane;
import org.drools.guvnor.client.common.DirtyableVerticalPane;
import org.drools.guvnor.client.common.ErrorPopup;
import org.drools.guvnor.client.common.FormStylePopup;
import org.drools.guvnor.client.common.ImageButton;
import org.drools.guvnor.client.common.InfoPopup;
import org.drools.guvnor.client.common.LoadingPopup;
import org.drools.guvnor.client.common.SmallLabel;
import org.drools.guvnor.client.messages.Constants;
import org.drools.guvnor.client.modeldriven.HumanReadable;
import org.drools.guvnor.client.packages.SuggestionCompletionCache;
import org.drools.guvnor.client.packages.WorkingSetManager;
import org.drools.guvnor.client.resources.Images;
import org.drools.guvnor.client.rpc.AnalysisReport;
import org.drools.guvnor.client.rpc.AnalysisReportLine;
import org.drools.guvnor.client.rpc.RuleAsset;
import org.drools.guvnor.client.rpc.VerificationService;
import org.drools.guvnor.client.rpc.VerificationServiceAsync;
import org.drools.guvnor.client.ruleeditor.RuleViewer;
import org.drools.guvnor.client.security.Capabilities;
import org.drools.guvnor.client.security.CapabilitiesManager;
import org.drools.guvnor.client.util.Format;
import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine;
import org.drools.ide.common.client.modeldriven.brl.ActionCallMethod;
import org.drools.ide.common.client.modeldriven.brl.ActionGlobalCollectionAdd;
import org.drools.ide.common.client.modeldriven.brl.ActionInsertFact;
import org.drools.ide.common.client.modeldriven.brl.ActionInsertLogicalFact;
import org.drools.ide.common.client.modeldriven.brl.ActionRetractFact;
import org.drools.ide.common.client.modeldriven.brl.ActionSetField;
import org.drools.ide.common.client.modeldriven.brl.ActionUpdateField;
import org.drools.ide.common.client.modeldriven.brl.CompositeFactPattern;
import org.drools.ide.common.client.modeldriven.brl.DSLSentence;
import org.drools.ide.common.client.modeldriven.brl.FactPattern;
import org.drools.ide.common.client.modeldriven.brl.FreeFormLine;
import org.drools.ide.common.client.modeldriven.brl.FromAccumulateCompositeFactPattern;
import org.drools.ide.common.client.modeldriven.brl.FromCollectCompositeFactPattern;
import org.drools.ide.common.client.modeldriven.brl.FromCompositeFactPattern;
import org.drools.ide.common.client.modeldriven.brl.IAction;
import org.drools.ide.common.client.modeldriven.brl.IPattern;
import org.drools.ide.common.client.modeldriven.brl.RuleMetadata;
import org.drools.ide.common.client.modeldriven.brl.RuleModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is the parent widget that contains the model based rule builder.
 *
 * @author Michael Neale
 *
 */
public class RuleModeller extends DirtyableComposite
    implements
    RuleModelEditor {

    private Constants                 constants               = GWT.create( Constants.class );
    private static Images             images                  = GWT.create( Images.class );

    private DirtyableFlexTable        layout;
    private RuleModel                 model;
    private RuleModellerConfiguration configuration           = RuleModellerConfiguration.getInstance();
    private boolean                   showingOptions          = false;
    private int                       currentLayoutRow        = 0;
    private String                    packageName;
    private RuleAsset                 asset;
    private ModellerWidgetFactory     widgetFactory;

    private List<RuleModellerWidget>  lhsWidgets              = new ArrayList<RuleModellerWidget>();
    private List<RuleModellerWidget>  rhsWidgets              = new ArrayList<RuleModellerWidget>();

    private boolean                   hasModifiedWidgets;

    private final Command             onWidgetModifiedCommand = new Command() {

                                                                  public void execute() {
                                                                      hasModifiedWidgets = true;
                                                                  }
                                                              };

    public RuleModeller(RuleAsset asset,
                        RuleViewer viewer,
                        ModellerWidgetFactory widgetFactory) {
        this( asset,
              widgetFactory );
    }

    public RuleModeller(RuleAsset asset,
                        ModellerWidgetFactory widgetFactory) {
        this.asset = asset;
        this.model = (RuleModel) asset.content;
        this.packageName = asset.metaData.packageName;

        this.widgetFactory = widgetFactory;

        layout = new DirtyableFlexTable();

        initWidget();

        layout.setStyleName( "model-builder-Background" );
        initWidget( layout );
        setWidth( "100%" );
        setHeight( "100%" );
    }

    /**
     * This updates the widget to reflect the state of the model.
     */
    public void initWidget() {
        layout.clear();
        this.currentLayoutRow = 0;

        Image addPattern = new ImageButton( images.newItem() );
        addPattern.setTitle( constants.AddAConditionToThisRule() );
        addPattern.addClickHandler( new ClickHandler() {

            public void onClick(ClickEvent event) {
                showConditionSelector( (Widget) event.getSource(),
                                       null );
            }
        } );

        layout.getColumnFormatter().setWidth( 0,
                                              "8%" );
        layout.getColumnFormatter().setWidth( 1,
                                              "87%" );
        layout.getColumnFormatter().setWidth( 2,
                                              "5%" );

        if ( this.showLHS() ) {
            layout.setWidget( currentLayoutRow,
                              0,
                              new SmallLabel( "<b>" + constants.WHEN() + "</b>" ) );

            if ( !lockLHS() ) {
                layout.setWidget( currentLayoutRow,
                                  2,
                                  addPattern );
            }
            currentLayoutRow++;

            renderLhs( this.model );
        }

        if ( this.showRHS() ) {
            layout.setWidget( currentLayoutRow,
                              0,
                              new SmallLabel( "<b>" + constants.THEN() + "</b>" ) );

            Image addAction = new ImageButton( images.newItem() );
            addAction.setTitle( constants.AddAnActionToThisRule() );
            addAction.addClickHandler( new ClickHandler() {

                public void onClick(ClickEvent event) {
                    showActionSelector( (Widget) event.getSource(),
                                        null );
                }
            } );
            if ( !lockRHS() ) {
                layout.setWidget( currentLayoutRow,
                                  2,
                                  addAction );
            }
            currentLayoutRow++;

            renderRhs( this.model );
        }

        if ( showAttributes() ) {

            final int tmp1 = currentLayoutRow;
            final int tmp2 = currentLayoutRow + 1;

            final RuleModeller self = this;
            if ( !this.showingOptions ) {
                ClickableLabel showMoreOptions = new ClickableLabel( "(show options...)",
                                                                     new ClickHandler() {

                                                                         public void onClick(ClickEvent event) {
                                                                             showingOptions = true;
                                                                             layout.setWidget( tmp1,
                                                                                               0,
                                                                                               new SmallLabel( constants.optionsRuleModeller() ) );
                                                                             layout.setWidget( tmp1,
                                                                                               2,
                                                                                               getAddAttribute() );
                                                                             layout.setWidget( tmp2,
                                                                                               1,
                                                                                               new RuleAttributeWidget( self,
                                                                                                                        self.model ) );
                                                                         }
                                                                     } );
                layout.setWidget( tmp1,
                                  0,
                                  showMoreOptions );
            } else {
                layout.setWidget( tmp1,
                                  0,
                                  new SmallLabel( constants.optionsRuleModeller() ) );
                layout.setWidget( tmp1,
                                  2,
                                  getAddAttribute() );
                layout.setWidget( tmp2,
                                  1,
                                  new RuleAttributeWidget( self,
                                                           self.model ) );

            }

        }

        currentLayoutRow++;
        layout.setWidget( currentLayoutRow + 1,
                          1,
                          spacerWidget() );
        layout.getCellFormatter().setHeight( currentLayoutRow + 1,
                                             1,
                                             "100%" );

        this.verifyRule( null );
    }

    private boolean isLock(String attr) {

        if ( this.asset.isreadonly ) {
            return true;
        }

        if ( this.model.metadataList.length == 0 ) {
            return false;
        }

        for ( RuleMetadata at : this.model.metadataList ) {
            if ( at.attributeName.equals( attr ) ) {
                return true;
            }
        }
        return false;
    }

    public boolean showRHS() {
        return !this.configuration.isHideRHS();
    }

    /** return true if we should not allow unfrozen editing of the RHS */
    public boolean lockRHS() {
        return isLock( RuleAttributeWidget.LOCK_RHS );
    }

    public boolean showLHS() {
        return !this.configuration.isHideLHS();
    }

    /** return true if we should not allow unfrozen editing of the LHS */
    public boolean lockLHS() {
        return isLock( RuleAttributeWidget.LOCK_LHS );
    }

    private boolean showAttributes() {
        if ( !CapabilitiesManager.getInstance().shouldShow( Capabilities.SHOW_PACKAGE_VIEW ) ) {
            return false;
        }

        return !this.configuration.isHideAttributes();
    }

    public void refreshWidget() {
        initWidget();
        showWarningsAndErrors();
        makeDirty();
    }

    private Widget getAddAttribute() {
        Image add = new ImageButton( images.newItem() );
        add.setTitle( constants.AddAnOptionToTheRuleToModifyItsBehaviorWhenEvaluatedOrExecuted() );

        add.addClickHandler( new ClickHandler() {

            public void onClick(ClickEvent event) {
                showAttributeSelector();
            }
        } );
        return add;
    }

    protected void showAttributeSelector() {
        AttributeSelectorPopup pop = new AttributeSelectorPopup( model,
                                                                 lockLHS(),
                                                                 lockRHS(),
                                                                 new Command() {

                                                                     public void execute() {
                                                                         refreshWidget();
                                                                     }
                                                                 } );

        pop.show();
    }

    /**
     * Do all the widgets for the RHS.
     */
    private void renderRhs(final RuleModel model) {

        for ( int i = 0; i < model.rhs.length; i++ ) {
            DirtyableVerticalPane widget = new DirtyableVerticalPane();
            widget.setWidth( "100%" );
            IAction action = model.rhs[i];

            //if lockRHS() set the widget RO, otherwise let them decide.
            Boolean readOnly = this.lockRHS() ? true : null;

            RuleModellerWidget w = getWidgetFactory().getWidget( this,
                                                                 action,
                                                                 readOnly );
            w.addOnModifiedCommand( this.onWidgetModifiedCommand );

            w.setWidth( "100%" );
            widget.add( spacerWidget() );

            DirtyableHorizontalPane horiz = new DirtyableHorizontalPane();
            horiz.setWidth( "100%" );
            //horiz.setBorderWidth(2);

            Image remove = new ImageButton( images.deleteItemSmall() );
            remove.setTitle( constants.RemoveThisAction() );
            final int idx = i;
            remove.addClickHandler( new ClickHandler() {

                public void onClick(ClickEvent event) {
                    if ( Window.confirm( constants.RemoveThisItem() ) ) {
                        model.removeRhsItem( idx );
                        refreshWidget();
                    }
                }
            } );
            horiz.add( w );
            if ( !(w instanceof ActionRetractFactWidget) ) {
                w.setWidth( "100%" ); //NON-NLS
                horiz.setWidth( "100%" );
            }

            if ( !(this.lockRHS() || w.isReadOnly()) ) {
                horiz.add( remove );
            }

            widget.add( horiz );

            layout.setHTML( currentLayoutRow,
                            0,
                            "<div class='x-form-field'>" + (i + 1) + ".</div>" );
            layout.getFlexCellFormatter().setHorizontalAlignment( currentLayoutRow,
                                                                  0,
                                                                  HasHorizontalAlignment.ALIGN_CENTER );
            layout.getFlexCellFormatter().setVerticalAlignment( currentLayoutRow,
                                                                0,
                                                                HasVerticalAlignment.ALIGN_MIDDLE );

            layout.setWidget( currentLayoutRow,
                              1,
                              widget );
            layout.getFlexCellFormatter().setHorizontalAlignment( currentLayoutRow,
                                                                  1,
                                                                  HasHorizontalAlignment.ALIGN_LEFT );
            layout.getFlexCellFormatter().setVerticalAlignment( currentLayoutRow,
                                                                1,
                                                                HasVerticalAlignment.ALIGN_TOP );
            layout.getFlexCellFormatter().setWidth( currentLayoutRow,
                                                    1,
                                                    "100%" );

            final int index = i;
            if ( !(this.lockRHS() || w.isReadOnly()) ) {
                this.addActionsButtonsToLayout( constants.AddAnActionBelow(),
                                                new ClickHandler() {

                                                    public void onClick(ClickEvent event) {
                                                        showActionSelector( (Widget) event.getSource(),
                                                                            index + 1 );
                                                    }
                                                },
                                                new ClickHandler() {

                                                    public void onClick(ClickEvent event) {
                                                        model.moveRhsItemDown( index );
                                                        refreshWidget();
                                                    }
                                                },
                                                new ClickHandler() {

                                                    public void onClick(ClickEvent event) {
                                                        model.moveRhsItemUp( index );
                                                        refreshWidget();
                                                    }
                                                } );
            }

            this.rhsWidgets.add( w );
            currentLayoutRow++;

        }

    }

    /**
     * Pops up the fact selector.
     */
    protected void showConditionSelector(final Widget w,
                                         Integer position) {
        final FormStylePopup popup = new FormStylePopup();
        popup.setTitle( constants.AddAConditionToTheRule() );

        final Map<String, Command> cmds = new HashMap<String, Command>();

        final ListBox positionCbo = new ListBox();

        if ( position == null ) {
            positionCbo.addItem( constants.Bottom(),
                                 String.valueOf( this.model.lhs.length ) );
            positionCbo.addItem( constants.Top(),
                                 "0" );
            for ( int i = 1; i < model.lhs.length; i++ ) {
                positionCbo.addItem( Format.format( constants.Line0(),
                                                    i ),
                                     String.valueOf( i ) );
            }
        } else {
            //if position is fixed, we just add one element to the drop down.
            positionCbo.addItem( String.valueOf( position ) );
            positionCbo.setSelectedIndex( 0 );
        }

        final ListBox choices = new ListBox( true );

        //
        // The list of DSL sentences
        //
        SuggestionCompletionEngine completions = SuggestionCompletionCache.getInstance().getEngineFromCache( packageName );
        if ( completions.getDSLConditions().length > 0 ) {
            for ( int i = 0; i < completions.getDSLConditions().length; i++ ) {
                final DSLSentence sen = completions.getDSLConditions()[i];
                String key = "DSL" + i;
                choices.addItem( sen.toString(),
                                 key );
                cmds.put( key,
                          new Command() {

                              public void execute() {
                                  addNewDSLLhs( sen,
                                                Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                  popup.hide();
                              }
                          } );
            }
        }

        //
        // The list of facts
        //
        final String[] facts = completions.getFactTypes();
        if ( facts.length > 0 ) {
            choices.addItem( ".................." );

            for ( int i = 0; i < facts.length; i++ ) {
                final String f = facts[i];
                String key = "NF" + f;

                choices.addItem( f + " ...",
                                 key );
                cmds.put( key,
                          new Command() {

                              public void execute() {
                                  addNewFact( f,
                                              Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                  popup.hide();
                              }
                          } );
            }
        }

        //
        // The list of top level CEs
        //
        String ces[] = HumanReadable.CONDITIONAL_ELEMENTS;

        choices.addItem( ".................." );
        for ( int i = 0; i < ces.length; i++ ) {
            final String ce = ces[i];
            String key = "CE" + ce;
            choices.addItem( HumanReadable.getCEDisplayName( ce ) + " ...",
                             key );
            cmds.put( key,
                      new Command() {

                          public void execute() {
                              addNewCE( ce,
                                        Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              popup.hide();
                          }
                      } );
        }

        String fces[] = HumanReadable.FROM_CONDITIONAL_ELEMENTS;

        choices.addItem( ".................." );
        for ( int i = 0; i < fces.length; i++ ) {
            final String ce = fces[i];
            String key = "FCE" + ce;
            choices.addItem( HumanReadable.getCEDisplayName( ce ) + " ...",
                             key );
            cmds.put( key,
                      new Command() {

                          public void execute() {
                              addNewFCE( ce,
                                         Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              popup.hide();
                          }
                      } );
        }

        if ( CapabilitiesManager.getInstance().shouldShow( Capabilities.SHOW_PACKAGE_VIEW ) ) {
            choices.addItem( ".................." );
            choices.addItem( constants.FreeFormDrl(),
                             "FF" );
            cmds.put( "FF",
                      new Command() {

                          public void execute() {
                              model.addLhsItem( new FreeFormLine(),
                                                Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              refreshWidget();
                              popup.hide();
                          }
                      } );

        }

        if ( completions.getDSLConditions().length == 0 && facts.length == 0 ) {
            popup.addRow( new HTML( "<div class='highlight'>" + constants.NoModelTip() + "</div>" ) ); //NON-NLS
        }

        choices.addKeyUpHandler( new KeyUpHandler() {
            public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
                if ( event.getNativeKeyCode() == KeyCodes.KEY_ENTER ) {
                    selectSomething( choices,
                                     cmds );
                }
            }
        } );

        //only show the drop down if we are not using fixed position.
        if ( position == null ) {
            HorizontalPanel hp0 = new HorizontalPanel();
            hp0.add( new HTML( constants.PositionColon() ) );
            hp0.add( positionCbo );
            hp0.add( new InfoPopup( constants.PositionColon(),
                                    constants.ConditionPositionExplanation() ) );
            popup.addRow( hp0 );
        }

        HorizontalPanel hp = new HorizontalPanel();
        hp.add( choices );
        Button ok = new Button( constants.OK() );
        hp.add( ok );
        ok.addClickHandler( new ClickHandler() {

            public void onClick(ClickEvent event) {
                selectSomething( choices,
                                 cmds );
            }
        } );
        
        Button cancel = new Button( constants.Cancel() );
        hp.add( cancel );
        cancel.addClickHandler( new ClickHandler() {

            public void onClick(ClickEvent event) {
                popup.hide();
            }
        } );
        popup.addRow( hp );

        popup.show();
        choices.setFocus( true );

        popup.setAfterShow( new Command() {

            public void execute() {
                choices.setFocus( true );
            }
        } );
    }

    private void selectSomething(ListBox choices,
                                 Map<String, Command> cmds) {
        int sel = choices.getSelectedIndex();
        if ( sel != -1 ) {
            Command cmd = cmds.get( choices.getValue( choices.getSelectedIndex() ) );
            if ( cmd != null ) {
                cmd.execute();
            }
            verifyRule( null );
        }

    }

    protected void addNewDSLLhs(DSLSentence sentence,
                                int position) {
        model.addLhsItem( sentence.copy(),
                          position );
        refreshWidget();
    }

    protected void showActionSelector(Widget w,
                                      Integer position) {
        final FormStylePopup popup = new FormStylePopup();
        popup.setTitle( constants.AddANewAction() );

        final ListBox positionCbo = new ListBox();
        if ( position == null ) {
            positionCbo.addItem( constants.Bottom(),
                                 String.valueOf( this.model.rhs.length ) );
            positionCbo.addItem( constants.Top(),
                                 "0" );
            for ( int i = 1; i < model.rhs.length; i++ ) {
                positionCbo.addItem( Format.format( constants.Line0(),
                                                    i ),
                                     String.valueOf( i ) );
            }
        } else {
            //if position is fixed, we just add one element to the drop down.
            positionCbo.addItem( String.valueOf( position ) );
            positionCbo.setSelectedIndex( 0 );
        }

        final ListBox choices = new ListBox( true );
        final Map<String, Command> cmds = new HashMap<String, Command>();

        //
        // First load up the stuff to do with bound variables or globals
        //
        SuggestionCompletionEngine completions = SuggestionCompletionCache.getInstance().getEngineFromCache( packageName );
        List<String> vars = model.getBoundFacts();
        List<String> vars2 = model.getRhsBoundFacts();
        String[] globals = completions.getGlobalVariables();

        //
        // The list of DSL sentences
        //
        if ( completions.getDSLActions().length > 0 ) {

            for ( int i = 0; i < completions.getDSLActions().length; i++ ) {
                final DSLSentence sen = completions.getDSLActions()[i];
                if ( sen != null ) {
                    String sentence = sen.toString();
                    choices.addItem( sentence,
                                     "DSL" + sentence ); //NON-NLS
                    cmds.put( "DSL" + sentence,
                              new Command() { //NON-NLS

                                  public void execute() {
                                      addNewDSLRhs( sen,
                                                    Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                      popup.hide();
                                  }
                              } );
                }
            }

            choices.addItem( "................" );

        }

        //Do Set field (NOT modify)
        for ( Iterator<String> iter = vars.iterator(); iter.hasNext(); ) {
            final String v = iter.next();

            choices.addItem( Format.format( constants.ChangeFieldValuesOf0(),
                                            v ),
                             "VAR" + v ); //NON-NLS
            cmds.put( "VAR" + v,
                      new Command() { //NON-NLS

                          public void execute() {
                              addActionSetField( v,
                                                 Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              popup.hide();
                          }
                      } );

        }

        for ( int i = 0; i < globals.length; i++ ) { //we also do globals here...
            final String v = globals[i];
            choices.addItem( Format.format( constants.ChangeFieldValuesOf0(),
                                            v ),
                             "GLOBVAR" + v ); //NON-NLS
            cmds.put( "GLOBVAR" + v,
                      new Command() { //NON-NLS

                          public void execute() {
                              addActionSetField( v,
                                                 Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              popup.hide();
                          }
                      } );
        }

        //RETRACT
        for ( Iterator<String> iter = vars.iterator(); iter.hasNext(); ) {
            final String v = iter.next();
            choices.addItem( Format.format( constants.Retract0(),
                                            v ),
                             "RET" + v ); //NON-NLS
            cmds.put( "RET" + v,
                      new Command() { //NON-NLS

                          public void execute() {
                              addRetract( v,
                                          Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              popup.hide();
                          }
                      } );
        }

        //MODIFY
        for ( Iterator<String> iter = vars.iterator(); iter.hasNext(); ) {
            final String v = iter.next();

            choices.addItem( Format.format( constants.Modify0(),
                                            v ),
                             "MOD" + v ); //NON-NLS
            cmds.put( "MOD" + v,
                      new Command() { //NON-NLS

                          public void execute() {
                              addModify( v,
                                         Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              popup.hide();
                          }
                      } );
        }

        choices.addItem( "................" );

        //Now inserts:
        for ( int i = 0; i < completions.getFactTypes().length; i++ ) {
            final String item = completions.getFactTypes()[i];
            choices.addItem( Format.format( constants.InsertFact0(),
                                            item ),
                             "INS" + item ); //NON-NLS
            cmds.put( "INS" + item,
                      new Command() { //NON-NLS

                          public void execute() {
                              model.addRhsItem( new ActionInsertFact( item ),
                                                Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              refreshWidget();
                              popup.hide();
                          }
                      } );
        }

        for ( int i = 0; i < completions.getFactTypes().length; i++ ) {
            final String item = completions.getFactTypes()[i];
            choices.addItem( Format.format( constants.LogicallyInsertFact0(),
                                            item ),
                             "LINS" + item ); //NON-NLS
            cmds.put( "LINS" + item,
                      new Command() { //NON-NLS

                          public void execute() {
                              model.addRhsItem( new ActionInsertLogicalFact( item ),
                                                Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              refreshWidget();
                              popup.hide();
                          }
                      } );
        }

        choices.addItem( "................" );
        //now global collections
        if ( completions.getGlobalCollections().length > 0 && vars.size() > 0 ) {
            for ( String bf : vars ) {
                for ( int i = 0; i < completions.getGlobalCollections().length; i++ ) {
                    final String glob = completions.getGlobalCollections()[i];
                    final String var = bf;
                    choices.addItem( Format.format( constants.Append0ToList1(),
                                                    var,
                                                    glob ),
                                     "GLOBCOL" + glob + var ); //NON-NLS
                    cmds.put( "GLOBCOL" + glob + var,
                              new Command() { //NON-NLS

                                  public void execute() {
                                      ActionGlobalCollectionAdd gca = new ActionGlobalCollectionAdd();
                                      gca.globalName = glob;
                                      gca.factName = var;
                                      model.addRhsItem( gca,
                                                        Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                      refreshWidget();
                                      popup.hide();
                                  }
                              } );
                }
            }
        }

        if ( CapabilitiesManager.getInstance().shouldShow( Capabilities.SHOW_PACKAGE_VIEW ) ) {
            choices.addItem( constants.AddFreeFormDrl(),
                             "FF" ); //NON-NLS
            cmds.put( "FF",
                      new Command() { //NON-NLS

                          public void execute() {
                              model.addRhsItem( new FreeFormLine(),
                                                Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                              refreshWidget();
                              popup.hide();
                          }
                      } );
            for ( int i = 0; i < globals.length; i++ ) { //we also do globals here...
                final String v = globals[i];
                choices.addItem( Format.format( constants.CallMethodOn0(),
                                                v ),
                                 "GLOBCALL" + v ); //NON-NLS
                cmds.put( "GLOBCALL" + v,
                          new Command() { //NON-NLS

                              public void execute() {
                                  addCallMethod( v,
                                                 Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                  popup.hide();
                              }
                          } );

            }

            //CALL methods
            for ( Iterator<String> iter = vars.iterator(); iter.hasNext(); ) {
                final String v = iter.next();

                choices.addItem( Format.format( constants.CallMethodOn0(),
                                                v ),
                                 "CALL" + v ); //NON-NLS
                cmds.put( "CALL" + v,
                          new Command() { //NON-NLS

                              public void execute() {
                                  addCallMethod( v,
                                                 Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                  popup.hide();
                              }
                          } );
            }
            //Do Set field (NOT modify)
            for ( Iterator<String> iter = vars2.iterator(); iter.hasNext(); ) {
                final String v = iter.next();

                choices.addItem( Format.format( constants.CallMethodOn0(),
                                                v ),
                                 "CALL" + v ); //NON-NLS
                cmds.put( "CALL" + v,
                          new Command() { //NON-NLS

                              public void execute() {
                                  addCallMethod( v,
                                                 Integer.parseInt( positionCbo.getValue( positionCbo.getSelectedIndex() ) ) );
                                  popup.hide();
                              }
                          } );
            }
        }

        //only show the drop down if we are not using fixed position.
        if ( position == null ) {
            HorizontalPanel hp0 = new HorizontalPanel();
            hp0.add( new HTML( constants.PositionColon() ) );
            hp0.add( positionCbo );
            hp0.add( new InfoPopup( constants.PositionColon(),
                                    constants.ActionPositionExplanation() ) );
            popup.addRow( hp0 );
        }

        HorizontalPanel hp = new HorizontalPanel();

        choices.addKeyUpHandler( new KeyUpHandler() {

            public void onKeyUp(KeyUpEvent event) {
                selectSomethingElse( choices,
                                     cmds );
            }
        } );

        Button ok = new Button( constants.OK() );
        ok.addClickHandler( new ClickHandler() {

            public void onClick(ClickEvent event) {
                selectSomethingElse( choices,
                                     cmds );
            }
        } );
        hp.add( choices );
        hp.add( ok );
        popup.addRow( hp );

        popup.show();
        choices.setFocus( true );
    }

    private void selectSomethingElse(final ListBox choices,
                                     final Map<String, Command> cmds) {
        int sel = choices.getSelectedIndex();
        if ( sel != -1 ) {
            cmds.get( choices.getValue( sel ) ).execute();
        }
    }

    protected void addModify(String itemText,
                             int position) {
        this.model.addRhsItem( new ActionUpdateField( itemText ),
                               position );
        refreshWidget();
    }

    protected void addNewDSLRhs(DSLSentence sentence,
                                int position) {
        this.model.addRhsItem( sentence.copy(),
                               position );
        refreshWidget();
    }

    protected void addRetract(String var,
                              int position) {
        this.model.addRhsItem( new ActionRetractFact( var ),
                               position );
        refreshWidget();
    }

    protected void addActionSetField(String itemText,
                                     int position) {
        this.model.addRhsItem( new ActionSetField( itemText ),
                               position );
        refreshWidget();
    }

    protected void addCallMethod(String itemText,
                                 int position) {
        this.model.addRhsItem( new ActionCallMethod( itemText ),
                               position );
        refreshWidget();
    }

    protected void addNewCE(String s,
                            int position) {
        this.model.addLhsItem( new CompositeFactPattern( s ),
                               position );
        refreshWidget();
    }

    protected void addNewFCE(String type,
                             int position) {
        FromCompositeFactPattern p = null;
        if ( type.equals( "from" ) ) {
            p = new FromCompositeFactPattern();
        } else if ( type.equals( "from accumulate" ) ) {
            p = new FromAccumulateCompositeFactPattern();
        } else if ( type.equals( "from collect" ) ) {
            p = new FromCollectCompositeFactPattern();
        }

        this.model.addLhsItem( p,
                               position );
        refreshWidget();
    }

    /**
     * Adds a fact to the model, and then refreshes the display.
     */
    protected void addNewFact(String itemText,
                              int position) {
        this.model.addLhsItem( new FactPattern( itemText ),
                               position );
        refreshWidget();
    }

    /**
     * Builds all the condition widgets.
     */
    private void renderLhs(final RuleModel model) {

        for ( int i = 0; i < model.lhs.length; i++ ) {
            DirtyableVerticalPane vert = new DirtyableVerticalPane();
            vert.setWidth( "100%" );

            //if lockLHS() set the widget RO, otherwise let them decide.
            Boolean readOnly = this.lockLHS() ? true : null;

            IPattern pattern = model.lhs[i];

            RuleModellerWidget w = getWidgetFactory().getWidget( this,
                                                                 pattern,
                                                                 readOnly );
            w.addOnModifiedCommand( this.onWidgetModifiedCommand );

            vert.add( wrapLHSWidget( model,
                                     i,
                                     w ) );
            vert.add( spacerWidget() );

            layout.setWidget( currentLayoutRow,
                              0,
                              this.wrapLineNumber( i + 1,
                                                   true ) );
            layout.getFlexCellFormatter().setHorizontalAlignment( currentLayoutRow,
                                                                  0,
                                                                  HasHorizontalAlignment.ALIGN_CENTER );
            layout.getFlexCellFormatter().setVerticalAlignment( currentLayoutRow,
                                                                0,
                                                                HasVerticalAlignment.ALIGN_MIDDLE );

            layout.setWidget( currentLayoutRow,
                              1,
                              vert );
            layout.getFlexCellFormatter().setHorizontalAlignment( currentLayoutRow,
                                                                  1,
                                                                  HasHorizontalAlignment.ALIGN_LEFT );
            layout.getFlexCellFormatter().setVerticalAlignment( currentLayoutRow,
                                                                1,
                                                                HasVerticalAlignment.ALIGN_TOP );
            layout.getFlexCellFormatter().setWidth( currentLayoutRow,
                                                    1,
                                                    "100%" );

            final int index = i;
            if ( !(this.lockLHS() || w.isReadOnly()) ) {
                this.addActionsButtonsToLayout( constants.AddAConditionBelow(),
                                                new ClickHandler() {

                                                    public void onClick(ClickEvent event) {
                                                        showConditionSelector( (Widget) event.getSource(),
                                                                               index + 1 );
                                                    }
                                                },
                                                new ClickHandler() {

                                                    public void onClick(ClickEvent event) {
                                                        model.moveLhsItemDown( index );
                                                        refreshWidget();
                                                    }
                                                },
                                                new ClickHandler() {

                                                    public void onClick(ClickEvent event) {
                                                        model.moveLhsItemUp( index );
                                                        refreshWidget();
                                                    }
                                                } );
            }

            this.lhsWidgets.add( w );
            currentLayoutRow++;
        }

    }

    private HTML spacerWidget() {
        HTML h = new HTML( "&nbsp;" ); //NON-NLS
        h.setHeight( "2px" ); //NON-NLS
        return h;
    }

    /**
     * This adds the widget to the UI, also adding the remove icon.
     */
    private Widget wrapLHSWidget(final RuleModel model,
                                 int i,
                                 RuleModellerWidget w) {
        DirtyableHorizontalPane horiz = new DirtyableHorizontalPane();

        final Image remove = new ImageButton( images.deleteItemSmall() );
        remove.setTitle( constants.RemoveThisENTIREConditionAndAllTheFieldConstraintsThatBelongToIt() );
        final int idx = i;
        remove.addClickHandler( new ClickHandler() {

            public void onClick(ClickEvent event) {
                if ( Window.confirm( constants.RemoveThisEntireConditionQ() ) ) {
                    if ( model.removeLhsItem( idx ) ) {
                        refreshWidget();
                    } else {
                        ErrorPopup.showMessage( constants.CanTRemoveThatItemAsItIsUsedInTheActionPartOfTheRule() );
                    }
                }
            }
        } );

        horiz.setWidth( "100%" );
        w.setWidth( "100%" );

        horiz.add( w );
        if ( !(this.lockLHS() || w.isReadOnly()) ) {
            horiz.add( remove );
        }

        return horiz;
    }

    private Widget wrapLineNumber(int number,
                                  boolean isLHSLine) {
        String id = "rhsLine";
        if ( isLHSLine ) {
            id = "lhsLine";
        }
        id += number;

        DirtyableHorizontalPane horiz = new DirtyableHorizontalPane();
        horiz.add( new HTML( "<div class='x-form-field' id='" + id + "'>" + number + ".</div>" ) );

        return horiz;
    }

    private void addLineIcon(int row,
                             ImageResource img,
                             String title) {
        Widget widget = layout.getWidget( row,
                                          0 );
        if ( widget instanceof DirtyableHorizontalPane ) {
            DirtyableHorizontalPane horiz = (DirtyableHorizontalPane) widget;
            final Image icon = new ImageButton( img );
            icon.setTitle( title );
            horiz.add( icon );
        }
    }

    private void clearLineIcons(int row) {
        if ( layout.getCellCount( row ) <= 0 ) {
            return;
        }
        Widget widget = layout.getWidget( row,
                                          0 );
        if ( widget instanceof DirtyableHorizontalPane ) {
            DirtyableHorizontalPane horiz = (DirtyableHorizontalPane) widget;
            while ( horiz.getWidgetCount() > 1 ) {
                horiz.remove( horiz.getWidgetCount() - 1 );
            }
        }
    }

    private void clearLinesIcons() {
        for ( int i = 0; i < layout.getRowCount(); i++ ) {
            this.clearLineIcons( i );
        }
    }

    private void addActionsButtonsToLayout(String title,
                                           ClickHandler addBelowListener,
                                           ClickHandler moveDownListener,
                                           ClickHandler moveUpListener) {

        final DirtyableHorizontalPane hp = new DirtyableHorizontalPane();

        Image addPattern = new ImageButton( images.newItemBelow() );
        addPattern.setTitle( title );
        addPattern.addClickHandler( addBelowListener );

        Image moveDown = new ImageButton( images.shuffleDown() );
        moveDown.setTitle( constants.MoveDown() );
        moveDown.addClickHandler( moveDownListener );

        Image moveUp = new ImageButton( images.shuffleUp() );
        moveUp.setTitle( constants.MoveUp() );
        moveUp.addClickHandler( moveUpListener );

        hp.add( addPattern );
        hp.add( moveDown );
        hp.add( moveUp );

        layout.setWidget( currentLayoutRow,
                          2,
                          hp );
        layout.getFlexCellFormatter().setHorizontalAlignment( currentLayoutRow,
                                                              2,
                                                              HasHorizontalAlignment.ALIGN_CENTER );
        layout.getFlexCellFormatter().setVerticalAlignment( currentLayoutRow,
                                                            2,
                                                            HasVerticalAlignment.ALIGN_MIDDLE );
    }

    public RuleModel getModel() {
        return model;
    }

    /**
     * Returns true is a var name has already been used
     * either by the rule, or as a global.
     */
    public boolean isVariableNameUsed(String name) {
        SuggestionCompletionEngine completions = SuggestionCompletionCache.getInstance().getEngineFromCache( packageName );
        return model.isVariableNameUsed( name ) || completions.isGlobalVariable( name );
    }

    @Override
    public boolean isDirty() {
        return (layout.hasDirty() || dirtyflag);
    }

    public SuggestionCompletionEngine getSuggestionCompletions() {
        return SuggestionCompletionCache.getInstance().getEngineFromCache( packageName );
    }

    private List<AnalysisReportLine> errors;
    private List<AnalysisReportLine> warnings;

    public void verifyRule(final Command cmd) {
        this.verifyRule( cmd,
                         false );
    }

    public void verifyRule(final Command cmd,
                           boolean forceVerification) {
        errors = new ArrayList<AnalysisReportLine>();
        warnings = new ArrayList<AnalysisReportLine>();

        //if AutoVerifierEnabled is off or there are not modified widgets,
        //just execute cmd and return.
        if ( !forceVerification && (!WorkingSetManager.getInstance().isAutoVerifierEnabled() || !this.hasModifiedWidgets) ) {
            if ( cmd != null ) {
                cmd.execute();
            }
            return;
        }

        LoadingPopup.showMessage( constants.VerifyingItemPleaseWait() );
        Set<String> activeWorkingSets = WorkingSetManager.getInstance().getActiveAssetUUIDs( asset.metaData.packageName );

        VerificationServiceAsync verificationService = GWT.create( VerificationService.class );

        verificationService.verifyAssetWithoutVerifiersRules( this.asset,
                                                              activeWorkingSets,
                                                              new AsyncCallback<AnalysisReport>() {

                                                                  public void onSuccess(AnalysisReport report) {
                                                                      LoadingPopup.close();

                                                                      errors = Arrays.asList( report.errors );
                                                                      warnings = Arrays.asList( report.warnings );

                                                                      processWarningsAndErrors();

                                                                      hasModifiedWidgets = false;
                                                                      if ( cmd != null ) {
                                                                          cmd.execute();
                                                                      }
                                                                  }

                                                                  public void onFailure(Throwable arg0) {
                                                                      LoadingPopup.close();
                                                                  }
                                                              } );

    }

    private void processWarningsAndErrors() {

        if ( this.warnings.isEmpty() && this.errors.isEmpty() ) {
            for ( RuleModellerWidget ruleModellerWidget : this.lhsWidgets ) {
                ruleModellerWidget.setModified( false );
            }
            for ( RuleModellerWidget ruleModellerWidget : this.rhsWidgets ) {
                ruleModellerWidget.setModified( false );
            }
        }
        showWarningsAndErrors();
    }

    private void showWarningsAndErrors() {
        this.clearLinesIcons();
        if ( this.warnings != null ) {
            for ( AnalysisReportLine warning : this.warnings ) {
                if ( warning.patternOrderNumber != null ) {
                    this.addLineIcon( warning.patternOrderNumber + 1,
                                      images.warning(),
                                      warning.description );
                }
            }
        }
        if ( this.errors != null ) {
            for ( AnalysisReportLine error : this.errors ) {
                if ( error.patternOrderNumber != null ) {
                    this.addLineIcon( error.patternOrderNumber + 1,
                                      images.error(),
                                      error.description );
                }
            }
        }
    }

    public boolean hasVerifierErrors() {
        return this.errors != null && this.errors.size() > 0;
    }

    public boolean hasVerifierWarnings() {
        return this.warnings != null && this.warnings.size() > 0;
    }

    public ModellerWidgetFactory getWidgetFactory() {
        return widgetFactory;
    }

    public void setWidgetFactory(ModellerWidgetFactory widgetFactory) {
        this.widgetFactory = widgetFactory;
    }

    public RuleModeller getRuleModeller() {
        return this;
    }

    public boolean isTemplate() {
        return widgetFactory.isTemplate();
    }

    public RuleAsset getAsset() {
        return asset;
    }

}
