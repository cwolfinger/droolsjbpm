package org.drools.decisiontable.parser;

import java.util.Properties;

import org.drools.decisiontable.model.Package;

/**
 * Listener used to parse decision table spreadsheets
 */
public interface RuleSheetListener
    extends
    SheetListener {

    /**
     * Return the rule sheet properties
     */
    public abstract Properties getProperties();

    /**
     * Build the final ruleset as parsed.
     */
    public abstract Package getRuleSet();

}
