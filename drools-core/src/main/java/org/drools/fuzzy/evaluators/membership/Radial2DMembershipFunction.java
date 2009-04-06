package org.drools.fuzzy.evaluators.membership;

import java.awt.geom.Point2D;

import org.drools.degrees.IDegree;
import org.drools.degrees.factory.IDegreeFactory;

public class Radial2DMembershipFunction implements IMembershipFunction {

	double x;
	double y;
	double extx;
	double exty;
	
	public Radial2DMembershipFunction(double x, double y, double extx, double exty) {
		this.x = x;
		this.y = y;
		this.extx = extx;
		this.exty = exty;
	}

	
	
	public IDegree eval(Object object, IDegreeFactory factory) {
		double[] vals = (double[]) object;
		
		double dx = (x - vals[0]) / extx;
		double dy = (y - vals[1]) / exty;
		double dist = Math.sqrt(dx*dx + dy*dy);
		double val = Math.exp(-dist*dist);
		return factory.buildDegree((float) val);
	}

	

}
