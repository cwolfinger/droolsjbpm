package org.drools.reteoo.test.dsl;

import static org.drools.reteoo.test.ReteDslTestEngine.BUILD_CONTEXT;
import static org.drools.reteoo.test.ReteDslTestEngine.WORKING_MEMORY;

import java.util.List;
import java.util.Map;

import org.drools.RuleBaseConfiguration;
import org.drools.common.InternalWorkingMemory;
import org.drools.reteoo.ReteooRuleBase;
import org.drools.reteoo.builder.BuildContext;

/**
 * A step in the setup of a nodeTestCase, it allows configuration parameters to
 * be passed.
 * 
 * @author lgomes
 * 
 */
public class ConfigStep implements Step {

    public void execute(Map<String, Object> context, List<String[]> args) {

        RuleBaseConfiguration conf = new RuleBaseConfiguration();

        for (String[] configOption : args) {
            conf.setProperty("drools." + configOption[0], configOption[1]);
        }

        ReteooRuleBase rbase = new ReteooRuleBase("ID", conf);
        BuildContext buildContext = new BuildContext(rbase, rbase
                .getReteooBuilder().getIdGenerator());

        InternalWorkingMemory wm = (InternalWorkingMemory) rbase
                .newStatefulSession(true);

        // Overwrite values now taking into account the configuration options.
        context.put(BUILD_CONTEXT, buildContext);
        context.put(WORKING_MEMORY, wm);

    }

}
