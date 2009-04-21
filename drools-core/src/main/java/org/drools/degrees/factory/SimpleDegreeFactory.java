package org.drools.degrees.factory;

import org.drools.degrees.IDegree;
import org.drools.degrees.IntervalDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.degrees.operators.simple.SimpleAverage;
import org.drools.degrees.operators.simple.SimpleDotAnd;
import org.drools.degrees.operators.simple.SimpleEquiv;
import org.drools.degrees.operators.simple.SimpleExists;
import org.drools.degrees.operators.simple.SimpleMaxOr;
import org.drools.degrees.operators.simple.SimpleMinAnd;
import org.drools.degrees.operators.simple.SimpleNot;
import org.drools.degrees.operators.simple.SimpleMergeStrategy;
import org.drools.degrees.operators.simple.SimpleNullHandlingStrategy;

import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.reteoo.filters.SimpleFilterStrategy;



public class SimpleDegreeFactory implements IDegreeFactory {
	
	public static IDegree FALSE = new SimpleDegree(0);
	public static IDegree TRUE = new SimpleDegree(1);
	
	//BEWARE OF CWA
	public static IDegree UNKNOWN = new SimpleDegree(0);
	
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
		return new SimpleDegree((float) Math.random());
	}
	
	public IDegree buildDegree(float val) {
		return new SimpleDegree(val);
	}

	

	public IDegree fromBoolean(boolean b) {
		return b ? new SimpleDegree(1) : new SimpleDegree(0);
	}


	public IDegreeCombiner getAndOperator() {
		return new SimpleDotAnd();
	}


	public IDegreeCombiner getOrOperator() {
		return new SimpleMaxOr();
	}
	
	public IDegreeCombiner getEquivOperator() {
		return new SimpleEquiv();
	}

	public IDegreeCombiner getAggregator() {
		return new SimpleMaxOr();
	}




	public IDegreeCombiner getModusPonensOp() {
		return new SimpleMinAnd();
	}

	public IDegree mergeIntersect(IDegree d1,
			IDegree d2) {
		return getAggregator().eval(new IDegree[] {d1,d2});
	}


	public IDegreeCombiner getEquivModusPonensOp() {
		// TODO Auto-generated method stub
		return new SimpleDotAnd();
	}


	public IDegreeCombiner getInductionOperator() {
		// TODO Auto-generated method stub
		return new SimpleAverage() ;
	}


	public IDegreeCombiner getMaxOrOperator() {
		return new SimpleMaxOr();
	}


	public IDegreeCombiner getMinAndOperator() {
		return new SimpleMinAnd();
	}

	public IDegreeCombiner getNegationOperator() {
		return new SimpleNot();
	}

	public IFilterStrategy getDefaultStrategy() {
		return SimpleFilterStrategy.getInstance();
	}

	public IMergeStrategy getMergeStrategy() {
		return new SimpleMergeStrategy();
	}

	public INullHandlingStrategy getNullHandlingStrategy() {
		return new SimpleNullHandlingStrategy();
	}

	public IDegreeCombiner getExistsOperator() {
		return new SimpleExists();
	}

	public IDegreeCombiner getForAnyOperator() {
		return new SimpleAverage();
	}

	public IDegreeCombiner getForallOperator() {
		return this.getAndOperator();
	}

}
