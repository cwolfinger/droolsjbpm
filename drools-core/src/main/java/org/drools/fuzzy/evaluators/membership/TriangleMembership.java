package org.drools.fuzzy.evaluators.membership;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;


public class TriangleMembership implements INumericSetMembershipFunction {

	protected Number center;
		
	protected Number ext;
	
	public Number getCenter() {
		return center;
	}
	
	
	
	public TriangleMembership() {
		
	}
	
	public void init(String[] args) {
		center = Double.parseDouble(args[0]);
		ext = Double.parseDouble(args[1]);
	}
	
	
	public TriangleMembership(Number center, Number ext) {
		this.center = center;
		this.ext = ext;	
	}
	
	
	
	
	public IDegree eval(Number number, IDegreeFactory factory) {
		double ans =  1 - Math.abs(number.doubleValue() - center.doubleValue()) / ext.doubleValue();
		return factory.buildDegree((float) Math.max(0,ans));
	}


	public IDegree eval(Object object, IDegreeFactory factory) {
		if (object instanceof Number)
			return eval( (Number) object, factory);
		else return null;
	}
	
	
	
	
    public int hashCode() {
        final int PRIME = 37;
        int result = PRIME * center.hashCode() * ext.hashCode();                    
        return result;
    }
	
	
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( !super.equals( obj ) ) return false;
        if ( getClass() != obj.getClass() ) return false;  
        TriangleMembership other = (TriangleMembership) obj;
        return (this.center == other.center) && (this.ext == other.ext);
    }
}
