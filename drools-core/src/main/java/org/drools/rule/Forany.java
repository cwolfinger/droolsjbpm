package org.drools.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Forany extends ConditionalElement {

	private RuleConditionElement integrand;
	private RuleConditionElement constraint;
	private RuleConditionElement weight;
	
	
	
	
	
	
	
	
	public Object clone() {
		Forany ans = new Forany();
			ans.setIntegrand(this.integrand);
			ans.setConstraint(this.constraint);
			ans.setWeight(this.weight);
		return ans;
	}

	public Map<String, Declaration> getInnerDeclarations() {
		final Map<String,Declaration> inner = new HashMap<String, Declaration>( this.integrand.getOuterDeclarations() );
        if (this.constraint != null)
        	inner.putAll(constraint.getOuterDeclarations());
        if (this.weight != null)
        	inner.putAll(weight.getOuterDeclarations());
		
        return inner;
	}

	public List<RuleConditionElement> getNestedElements() {
		List<RuleConditionElement> ans = new ArrayList<RuleConditionElement>(3);
			ans.add(integrand);
			if (constraint != null) ans.add(constraint);
			if (weight != null) ans.add(weight);
		return ans;
	}

	public Map<String, Declaration> getOuterDeclarations() {
		return Collections.emptyMap();
	}

	public boolean isPatternScopeDelimiter() {		
		return true;
	}

	public Declaration resolveDeclaration(String identifier) {
		return (Declaration) this.getInnerDeclarations().get( identifier );
	}
	
	
	

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		integrand = (RuleConditionElement) in.readObject();
		Object constr = in.readObject();
			constraint = constr == null ? null : (RuleConditionElement) constr;
		Object wgt = in.readObject();
			weight = wgt == null ? null : (RuleConditionElement) wgt;

	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(integrand);
		out.writeObject(constraint);
		out.writeObject(weight);

	}
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @param integrand the integrand to set
	 */
	public void setIntegrand(RuleConditionElement integrand) {
		this.integrand = integrand;
	}

	/**
	 * @return the integrand
	 */
	public RuleConditionElement getIntegrand() {
		return integrand;
	}

	/**
	 * @param constraint the constraint to set
	 */
	public void setConstraint(RuleConditionElement constraint) {
		this.constraint = constraint;
	}

	/**
	 * @return the constraint
	 */
	public RuleConditionElement getConstraint() {
		return constraint;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(RuleConditionElement weight) {
		this.weight = weight;
	}

	/**
	 * @return the weight
	 */
	public RuleConditionElement getWeight() {
		return weight;
	}

	
	
	public boolean isCutter() {
    	return false;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
