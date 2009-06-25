package org.drools.degrees.factory;

import org.drools.degrees.IDegree;
import org.drools.degrees.SimpleDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.degrees.operators.IDiscountOperator;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;
import org.drools.degrees.operators.simple.SimpleAverage;
import org.drools.degrees.operators.simple.SimpleDiscountOperator;
import org.drools.degrees.operators.simple.SimpleDiscountStrategy;
import org.drools.degrees.operators.simple.SimpleDotAnd;
import org.drools.degrees.operators.simple.SimpleDoubleMPOperator;
import org.drools.degrees.operators.simple.SimpleEquiv;
import org.drools.degrees.operators.simple.SimpleExists;
import org.drools.degrees.operators.simple.SimpleIdentityOperator;
import org.drools.degrees.operators.simple.SimpleLukasAnd;
import org.drools.degrees.operators.simple.SimpleLukasImplication;
import org.drools.degrees.operators.simple.SimpleLukasOr;
import org.drools.degrees.operators.simple.SimpleMaxOr;
import org.drools.degrees.operators.simple.SimpleMinAnd;
import org.drools.degrees.operators.simple.SimpleMinMergeStrategy;
import org.drools.degrees.operators.simple.SimpleNot;
import org.drools.degrees.operators.simple.SimpleMaxMergeStrategy;
import org.drools.degrees.operators.simple.SimpleNullHandlingStrategy;
import org.drools.degrees.operators.simple.SimpleProbSumOr;
import org.drools.degrees.operators.simple.SimpleVeryModifier;
import org.drools.degrees.operators.simple.SimpleXor;

import org.drools.reteoo.filters.IFilterStrategy;
import org.drools.reteoo.filters.SimpleFilterStrategy;



public class SimpleDegreeFactory implements IDegreeFactory {
	
	private boolean cwa = true;
	
	
	public static IDegree FALSE = SimpleDegree.FALSE();
	public static IDegree TRUE = SimpleDegree.TRUE();
	
	//BEWARE OF OWA
	//private static IDegree UNKNOWN = SimpleDegree.UNKNOWN();
	
	public IDegree False() {
		return FALSE;
	}

	public IDegree True() {
		return TRUE;
	}

	public IDegree Unknown() {
		if (cwa) {
			return FALSE;
		} else {
			return TRUE;
		}
		//return UNKNOWN;
	}

	
	public IDegree Random() {
		return new SimpleDegree((float) Math.random());
	}
	
	public IDegree buildDegree(double val) {
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
	
	public IDegreeCombiner getXorOperator() {
		return new SimpleXor();
	}

	public IDegreeCombiner getAggregator() {
		return new SimpleMaxOr();
	}




	public IDegreeCombiner getModusPonensOp() {
		return new SimpleMinAnd();
	}

//	public IDegree mergeIntersect(IDegree d1,
//			IDegree d2) {
//		return getAggregator().eval(new IDegree[] {d1,d2});
//	}


	public IDegreeCombiner getEquivModusPonensOp() {
		// TODO Auto-generated method stub
		return new SimpleDotAnd();
	}


	public IDegreeCombiner getInductionOperator() {
		// TODO Auto-generated method stub
		return new SimpleAverage() ;
	}

	public IDegreeCombiner getImplicationOperator() {
		return new SimpleLukasImplication();
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
		if (cwa) {
			return new SimpleMaxMergeStrategy();
		} else {
			return new SimpleMinMergeStrategy();
		}		
	}

	public INullHandlingStrategy getNullHandlingStrategy() {
		return new SimpleNullHandlingStrategy();
	}

	public IDegreeCombiner getExistsOperator() {
		return new SimpleExists();
	}

	public IDegreeCombiner getForAnyOperator() {
		return new SimpleAverage();		
		//return new SimpleExists();
	}

	public IDegreeCombiner getForallOperator() {
		return this.getAndOperator();
	}

	public IDiscountOperator getDiscountOperator() {
		return new SimpleDiscountOperator(this.Unknown().asSimpleDegree());
	}

	public IDegreeCombiner getDoubleMPOperator() {
		return new SimpleDoubleMPOperator();
	}

	
	
	
	
	public IDegreeCombiner getAndOperator(String params) {
		if (params == null)
			return getAndOperator();
		if (params.equals("kind:Lukas"))
			return new SimpleLukasAnd();
		else if (params.equals("kind:Prod"))
			return new SimpleDotAnd();
		else if (params.equals("kind:Min"))
			return new SimpleMinAnd();
		else return getAndOperator();
	}

	public IDegreeCombiner getDiscountOperator(String params) {
		throw new UnsupportedOperationException("Not yet ready to do this :"+ params);	
	}

	public IDegreeCombiner getDoubleMPOperator(String params) {
		throw new UnsupportedOperationException("Not yet ready to do this :"+ params);
	}

	public IDegreeCombiner getEquivOperator(String params) {
		throw new UnsupportedOperationException("Not yet ready to do this :"+ params);
	}

	public IDegreeCombiner getOrOperator(String params) {
		if (params == null)
			return getOrOperator();
		
		if (params.equals("kind:Lukas"))
			return new SimpleLukasOr();
		else if (params.equals("kind:Plus"))
			return new SimpleProbSumOr();
		else if (params.equals("kind:Max"))
			return new SimpleMaxOr();
		else return getOrOperator();
	}

	public IDegreeCombiner getXorOperator(String params) {
		return new SimpleXor();
	}

	
	
	public IDegreeCombiner getHedgeOperator() {
		return new SimpleVeryModifier();
	}

	public IDegreeCombiner getHedgeOperator(String params) {
		if (params.equals("very")) {
			return new SimpleVeryModifier();	
		} else {
			return new SimpleVeryModifier();
		}
		
	}

	public IDegree buildDegree(String priorStr) {
		if (priorStr.toLowerCase().contains("unknown"))
			return this.Unknown();
		
		return new SimpleDegree(Float.parseFloat(priorStr));
	}

	public IDegreeCombiner getModusPonensOperator(String params) {
		if (params == null)
			return getModusPonensOp();
		
		return getAndOperator(params);
		
		
	}

	

	public IDegreeCombiner getImplicationOperator(String params) {
		return new SimpleLukasImplication();
	}
	
	public IDiscountStrategy getDiscountStrategy() {
		return new SimpleDiscountStrategy(this.getDiscountOperator());
	}

	public boolean isClosedWorldAssumption() {
		return cwa;
	}

	public void setClosedWorldAssumption(boolean cwa) {
		this.cwa = cwa;		
	}
	
}
