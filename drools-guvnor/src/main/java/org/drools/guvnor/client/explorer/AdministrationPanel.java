/**
 * Copyright 2010 JBoss Inc
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

package org.drools.guvnor.client.explorer;

import org.drools.guvnor.client.admin.ArchivedAssetManager;
import org.drools.guvnor.client.admin.BackupManager;
import org.drools.guvnor.client.admin.CategoryManager;
import org.drools.guvnor.client.admin.LogViewer;
import org.drools.guvnor.client.admin.PermissionViewer;
import org.drools.guvnor.client.admin.RepoConfigManager;
import org.drools.guvnor.client.admin.StateManager;
import org.drools.guvnor.client.common.FormStylePopup;
import org.drools.guvnor.client.common.SmallLabel;
import org.drools.guvnor.client.messages.Constants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import org.drools.guvnor.client.admin.RuleVerifierManager;

/**
 * @author Anton Arhipov
 */
public class AdministrationPanel extends GenericPanel {
    private static Constants constants = GWT.create( Constants.class );

    public AdministrationPanel(ExplorerViewCenterPanel tabbedPanel) {
        super( constants.Administration(),
               tabbedPanel );
        setIconCls( "nav-admin" ); //NON-NLS

        TreePanel adminTree = basicTreeStructure( /*ExplorerNodeConfig
                                                  .getAdminStructure()*/new TreeNode(),
                                                  new TreePanelListenerAdapter() {
                                                      public void onClick(TreeNode self,
                                                                          EventObject e) {

                                                          int id = Integer.parseInt( self.getAttribute( "id" ) );
                                                          switch ( id ) {
                                                              case 0 :
                                                                  if ( !centertabbedPanel.showIfOpen( "catman" ) ) //NON-NLS
                                                                  centertabbedPanel.addTab( constants.CategoryManager(),
                                                                                            new CategoryManager(),
                                                                                            "catman" ); //NON-NLS
                                                                  break;
                                                              case 1 :
                                                                  if ( !centertabbedPanel.showIfOpen( "archman" ) ) //NON-NLS
                                                                  centertabbedPanel.addTab( constants.ArchivedManager(),
                                                                                            new ArchivedAssetManager( centertabbedPanel ),
                                                                                            "archman" ); //NON-NLS
                                                                  break;

                                                              case 2 :
                                                                  if ( !centertabbedPanel.showIfOpen( "stateman" ) ) //NON-NLS
                                                                  centertabbedPanel.addTab( constants.StateManager(),
                                                                                            new StateManager(),
                                                                                            "stateman" );
                                                                  break;
                                                              case 3 :
                                                                  if ( !centertabbedPanel.showIfOpen( "bakman" ) ) centertabbedPanel.addTab( constants.ImportExport(),
                                                                                                                                             new BackupManager(),
                                                                                                                                             "bakman" );
                                                                  break;

                                                              case 4 :
                                                                  if ( !centertabbedPanel.showIfOpen( "errorLog" ) ) centertabbedPanel.addTab( constants.EventLog(),
                                                                                                                                               new LogViewer(),
                                                                                                                                               "errorLog" );
                                                                  break;
                                                              case 5 :
                                                                  if ( !centertabbedPanel.showIfOpen( "securityPermissions" ) ) centertabbedPanel.addTab( constants.UserPermissionMappings(),
                                                                                                                                                          new PermissionViewer(),
                                                                                                                                                          "securityPermissions" );
                                                                  break;
                                                              case 6 :
                                                                  Frame aboutFrame = new Frame( "version.txt" ); //NON-NLS

                                                                  FormStylePopup aboutPop = new FormStylePopup();
                                                                  aboutPop.setWidth( 600 + "px" );
                                                                  aboutPop.setTitle( constants.About() );
                                                                  String hhurl = GWT.getModuleBaseURL() + "webdav";
                                                                  aboutPop.addAttribute( constants.WebDAVURL(),
                                                                                         new SmallLabel( "<b>" + hhurl + "</b>" ) );
                                                                  aboutPop.addAttribute( constants.Version() + ":",
                                                                                         aboutFrame );
                                                                  aboutPop.show();
                                                                  break;
                                                              case 7 :
                                                                  if ( !centertabbedPanel.showIfOpen( "ruleVerifierManager" ) ) centertabbedPanel.addTab( constants.RulesVerificationManager(),
                                                                                                                                                          new RuleVerifierManager(),
                                                                                                                                                          "ruleVerifierManager" );
                                                                  break;
                                                              case 8 :
                                                                  if ( !centertabbedPanel.showIfOpen( "repoconfig" ) ) //NON-NLS
                                                                  centertabbedPanel.addTab( constants.RepositoryConfig(),
                                                                                            new RepoConfigManager(),
                                                                                            "repoconfig" );
                                                                  break;
                                                          }
                                                      }
                                                  } );
        adminTree.setRootVisible( false );

        VerticalPanel adminPanel = new VerticalPanel();
        adminPanel.add( adminTree );
        adminPanel.setWidth( "100%" );
        add( adminPanel );
    }

}
