package org.drools.spring.core;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.drools.RuleBase;
import org.drools.RuleBaseConfiguration;
import org.drools.RuleBaseFactory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderConfiguration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

/**
 * @author Geoffrey De Smet
 */
public class RuleBaseBeanFactory implements FactoryBean, InitializingBean {

	private List<Resource> drlResourceList;

    private RuleBase ruleBase;
    
    private RuleBaseConfiguration ruleBaseConfiguration;
    
    private int type;

    private  PackageBuilderConfiguration packageBuilderConfiguration;

    public void setDrlResourceList(List<Resource> drlResourceList) {
        this.drlResourceList = drlResourceList;
    }
    
    public void setRuleBaseConfiguration(RuleBaseConfiguration ruleBaseConfiguration) {
    	this.ruleBaseConfiguration = ruleBaseConfiguration;
    }
    
    public void setType(int type) {
    	this.type = type;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notEmpty(drlResourceList, "drlResourceList must not be empty");
        PackageBuilder builder = (packageBuilderConfiguration != null ? new PackageBuilder(packageBuilderConfiguration) : new PackageBuilder());
        for (Resource resource : drlResourceList) {
        	// TODO Identify file type to get build or get the rule base
        	// DRL
            builder.addPackageFromDrl(new InputStreamReader(resource.getInputStream())); // TODO will use default encoding which might not be wanted
            // RFM
            // XLS OR CSV
            // URL use rule agent, if the type is an URL, use resource.getURL() to get it
        }
        
        if (ruleBaseConfiguration == null && type != 0) {
            ruleBase = RuleBaseFactory.newRuleBase();
        } else if (ruleBaseConfiguration != null && type == RuleBase.RETEOO) {
        	ruleBase = RuleBaseFactory.newRuleBase(RuleBase.RETEOO, ruleBaseConfiguration);
        }else if (ruleBaseConfiguration != null && type == 0) {
        	ruleBase = RuleBaseFactory.newRuleBase(ruleBaseConfiguration);
        } else if (ruleBaseConfiguration == null && type != 0 && type != RuleBase.RETEOO) {
        	ruleBase = RuleBaseFactory.newRuleBase(type);
        }
        
        if (ruleBaseConfiguration == null) {
        	if (type == 0) {
        		ruleBase = RuleBaseFactory.newRuleBase();
        	} else if (type == RuleBase.RETEOO || type != 0) {
        		ruleBase = RuleBaseFactory.newRuleBase(type);
        	}
        } else {
        	if (type == 0) {
        		ruleBase = RuleBaseFactory.newRuleBase(ruleBaseConfiguration);
        	} else {
        		ruleBase = RuleBaseFactory.newRuleBase(type, ruleBaseConfiguration);
        	}
        }
        
        ruleBase.addPackage(builder.getPackage());
    }


    public RuleBase getObject() {
        return ruleBase;
    }

    public Class getObjectType() {
        return RuleBase.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setPackageBuilderConfiguration(PackageBuilderConfiguration packageBuilderConfiguration) {
        this.packageBuilderConfiguration = packageBuilderConfiguration;
    }
}
