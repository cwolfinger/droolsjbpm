package org.drools.degrees.factory;

import java.util.StringTokenizer;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IDiscountOperator;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.degrees.operators.intervals.DefaultIntervalMergeStrategy;
import org.drools.degrees.operators.intervals.DefaultIntervalNullHandlingStrategy;
import org.drools.degrees.operators.intervals.IntervalDiscountOperator;
import org.drools.degrees.operators.intervals.IntervalDiscountStrategy;
import org.drools.degrees.operators.intervals.IntervalDoubleMPOperator;
import org.drools.degrees.operators.intervals.IntervalEquivOperator;
import org.drools.degrees.operators.intervals.IntervalExistsOperator;
import org.drools.degrees.operators.intervals.IntervalForAnyOperator;
import org.drools.degrees.operators.intervals.IntervalForallOperator;
import org.drools.degrees.operators.intervals.IntervalIntersectionOperator;
import org.drools.degrees.operators.intervals.IntervalLukasAndOperator;
import org.drools.degrees.operators.intervals.IntervalLukasImplicationOperator;
import org.drools.degrees.operators.intervals.IntervalLukasOrOperator;
import org.drools.degrees.operators.intervals.IntervalMaxOrOperator;
import org.drools.degrees.operators.intervals.IntervalMinAndOperator;
import org.drools.degrees.operators.intervals.IntervalModusPonensOperator;
import org.drools.degrees.operators.intervals.IntervalNegationOperator;
import org.drools.degrees.operators.intervals.IntervalXorOperator;
import org.drools.reteoo.DoubleMPOperatorInstaller;
import org.drools.reteoo.filters.DefaultIntervalFilterStrategy;
import org.drools.reteoo.filters.IFilterStrategy;

public class IntervalDegreeFactory implements IDegreeFactory {

	
	public static IDegree FALSE = new IntervalDegree(0,0);
	public static IDegree TRUE = new IntervalDegree(1,1);
	public static IDegree UNKNOWN = new IntervalDegree(0,1);
	
	private boolean cwa;
	
	public IDegree False() {
		return FALSE;
	}

	public IDegree True() {
		return TRUE;
	}

	public IDegree Unknown() {
		return UNKNOWN;
	}
	
	public IDegree Random() {
		float low = (float) Math.random();
		float upp = low + (1-low) * ((float) Math.random());
		return new IntervalDegree(low,upp);
	}

	public IDegree buildDegree(float val) {
		return new IntervalDegree(val,val);
	}

	public IDegree fromBoolean(boolean b) {
		return b ? True() : False();
	}

	public IDegreeCombiner getAggregator() {
		return new IntervalIntersectionOperator();
	}

	public IDegreeCombiner getAndOperator() {
		return new IntervalLukasAndOperator();
	}

	
	public IFilterStrategy getDefaultStrategy() {
		return new DefaultIntervalFilterStrategy();
	}

	public IDegreeCombiner getEquivOperator() {
		return new IntervalEquivOperator();
	}
	
	
	public IDegreeCombiner getXorOperator() {
		return new IntervalXorOperator();
	}

	public IDegreeCombiner getExistsOperator() {
		return new IntervalExistsOperator();
	}

	public IDegreeCombiner getForAnyOperator() {
		return new IntervalForAnyOperator();
	}

	public IDegreeCombiner getForallOperator() {
		return new IntervalForallOperator();
	}

	public IDegreeCombiner getMaxOrOperator() {
		return new IntervalMaxOrOperator();
	}

	public IMergeStrategy getMergeStrategy() {
		return new DefaultIntervalMergeStrategy();
	}

	public IDegreeCombiner getMinAndOperator() {
		return new IntervalMinAndOperator();
	}

	public IDegreeCombiner getModusPonensOp() {
		return new IntervalModusPonensOperator();
	}

	public IDegreeCombiner getNegationOperator() {
		return new IntervalNegationOperator();
	}

	public INullHandlingStrategy getNullHandlingStrategy() {
		return new DefaultIntervalNullHandlingStrategy();
	}

	public IDegreeCombiner getOrOperator() {
		return new IntervalLukasOrOperator();
	}

	public IDiscountOperator getDiscountOperator() {
		return new IntervalDiscountOperator();
	}

	public IDegreeCombiner getDoubleMPOperator() {
		return new IntervalDoubleMPOperator();
	}
	
	
	public IDegreeCombiner getImplicationOperator() {
		return new IntervalLukasImplicationOperator();
	}
	
	
	

	public IDegreeCombiner getAndOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getDiscountOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getDoubleMPOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getEquivOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getOrOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDegreeCombiner getXorOperator(String params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IDegreeCombiner getImplicationOperator(String params) {
		return new IntervalLukasImplicationOperator();
	}

	public IDegreeCombiner getHedgeOperator() {
		throw new UnsupportedOperationException("Not yet...");
	}

	public IDegreeCombiner getHedgeOperator(String params) {
		throw new UnsupportedOperationException("Not yet...");
	}

	public IDegree buildDegree(String priorStr) {
		if (priorStr.equals("unknown"))
			return Unknown();
		
		
		StringTokenizer tok = new StringTokenizer(priorStr,"[,]");
		if (tok.countTokens() == 2) {
			try {
				float low = Float.parseFloat(tok.nextToken());
				float upp = Float.parseFloat(tok.nextToken());
				return new IntervalDegree(low, upp);
			} catch (NumberFormatException nfe) {
				return Unknown();
			}	
						
		} else {
			try {
				float val = Float.parseFloat(tok.nextToken());
				return new IntervalDegree(val,val);
			} catch (NumberFormatException nfe) {
				return Unknown();
			}
		}
	}

	public IDegreeCombiner getModusPonensOperator(String params) {
		if (params == null)
			return getModusPonensOp();
		
		if (params.equals("implication")) {
			return getModusPonensOp();
		} else if (params.equals("equivalence")) {
			return getDoubleMPOperator();			
		} else
			return getModusPonensOp();
		
	}

	public IDiscountStrategy getDiscountStrategy() {
		return new IntervalDiscountStrategy(getDiscountOperator());
	}

	public boolean isClosedWorldAssumption() {
		return cwa;
	}

	public void setClosedWorldAssumption(boolean cwa) {
		this.cwa = cwa;		
	}

}
