package org.drools.guvnor.client.modeldriven.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import org.drools.guvnor.client.common.ClickableLabel;
import org.drools.guvnor.client.common.DirtyableComposite;
import org.drools.guvnor.client.common.DirtyableFlexTable;
import org.drools.guvnor.client.common.DirtyableVerticalPane;
import org.drools.guvnor.client.common.FormStylePopup;
import org.drools.guvnor.client.modeldriven.HumanReadable;
import org.drools.guvnor.client.modeldriven.SuggestionCompletionEngine;
import org.drools.guvnor.client.modeldriven.brl.FactPattern;
import org.drools.guvnor.client.modeldriven.brl.FromCompositeFactPattern;
import org.drools.guvnor.client.messages.Constants;

/**
 *
 * @author esteban
 */
public class FromCompositeFactPatternWidget extends DirtyableComposite {

    protected final SuggestionCompletionEngine completions;
    protected FromCompositeFactPattern pattern;
    protected DirtyableFlexTable layout;
    protected RuleModeller modeller;
    protected Constants constants = ((Constants) GWT.create(Constants.class));

    public FromCompositeFactPatternWidget(RuleModeller modeller,
            FromCompositeFactPattern pattern) {
        this.completions = modeller.getSuggestionCompletions();
        this.pattern = pattern;
        this.modeller = modeller;

        this.layout = new DirtyableFlexTable();
        this.layout.setStyleName("model-builderInner-Background");

        doLayout();
        initWidget(layout);
    }

    protected void doLayout() {

        int r = 0;

        if (pattern.getFactPattern() != null) {
            DirtyableVerticalPane vert = new DirtyableVerticalPane();
            FactPattern fact = pattern.getFactPattern();
            if (fact != null) {
                vert.add(new FactPatternWidget(modeller,
                        fact,
                        true));
                this.layout.setWidget(r,
                        0,
                        vert);
                r++;
            }
        }

        this.layout.setWidget(r,
                0,
                getCompositeLabel());

    }

    protected Widget getCompositeLabel() {

        ClickListener click = new ClickListener() {

            public void onClick(Widget w) {
                showFactTypeSelector(w);
            }
        };
        String lbl = "<div class='x-form-field'>" + HumanReadable.getCEDisplayName("from") + "</div>";

        DirtyableFlexTable panel = new DirtyableFlexTable();

        int r = 0;

        if (pattern.getFactPattern() == null) {
            panel.setWidget(r, 0, new ClickableLabel("<br> <font color='red'>" + constants.clickToAddPatterns() + "</font>", click, !this.modeller.lockLHS()));
            r++;
        }


        panel.setWidget(r, 0, new HTML(lbl));
        panel.setWidget(r, 1, new ExpressionBuilder(modeller, this.pattern.getExpression()));


        return panel;
    }

    /**
     * Pops up the fact selector.
     */
    protected void showFactTypeSelector(final Widget w) {
        final ListBox box = new ListBox();
        String[] facts = completions.getFactTypes();

        box.addItem(constants.Choose());

        for ( int i = 0; i < facts.length; i++ ) {
            box.addItem( facts[i] );
        }
        box.setSelectedIndex( 0 );

        final FormStylePopup popup = new FormStylePopup();
        popup.setTitle(constants.NewFactPattern());
        popup.addAttribute(constants.chooseFactType(),
                            box );

        box.addChangeListener( new ChangeListener() {
            public void onChange(Widget w) {
                pattern.setFactPattern( new FactPattern( box.getItemText( box.getSelectedIndex() ) ) );
                modeller.refreshWidget();
                popup.hide();
            }
        } );

        popup.show();
    }

    public boolean isDirty() {
        return layout.hasDirty();
    }
}
