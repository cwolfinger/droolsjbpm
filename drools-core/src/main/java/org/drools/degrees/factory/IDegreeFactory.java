package org.drools.degrees.factory;

import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.filters.IFilterStrategy;

import org.drools.degrees.operators.IDiscountOperator;
import org.drools.degrees.operators.IDiscountStrategy;
import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public interface IDegreeFactory {
	
	
	public void setClosedWorldAssumption(boolean cwa);		
	
	public boolean isClosedWorldAssumption();
	
	
	public IDegree buildDegree(double val);
	
	
	public IDegree True();
	
	public IDegree False();
	
	public IDegree Unknown();
	
	public IDegree Random();
	
	public IDegree fromBoolean(boolean b);
	
	public IDegreeCombiner getAndOperator();
	
	public IDegreeCombiner getMinAndOperator();
	
	public IDegreeCombiner getOrOperator();
	
	public IDegreeCombiner getMaxOrOperator();

	public IDegreeCombiner getEquivOperator();
	
	public IDegreeCombiner getXorOperator();
	
	public IDegreeCombiner getImplicationOperator();
	
	
	public IDegreeCombiner getAggregator();
	
	
	public IDegreeCombiner getModusPonensOp();
	
	
	public IDegreeCombiner getExistsOperator();
	
	public IDegreeCombiner getForallOperator();
	
	public IDegreeCombiner getForAnyOperator();
	
	
//	public IDegreeCombiner getEquivModusPonensOp();
	
	
//	public IDegree mergeIntersect(IDegree d1, IDegree d2);


//	public IDegreeCombiner getInductionOperator();
	
	public IDegreeCombiner getNegationOperator();


	public IFilterStrategy getDefaultStrategy();
	
	public IMergeStrategy getMergeStrategy();
	
	public INullHandlingStrategy getNullHandlingStrategy();


	public IDegreeCombiner getDoubleMPOperator();


	public IDiscountOperator getDiscountOperator();
	
	
	public IDegreeCombiner getHedgeOperator();
	
	
	
	

	public IDegreeCombiner getModusPonensOperator(String params);

	public IDegreeCombiner getDoubleMPOperator(String params);


	public IDegreeCombiner getDiscountOperator(String params);


	public IDegreeCombiner getEquivOperator(String params);


	public IDegreeCombiner getXorOperator(String params);
	
	public IDegreeCombiner getImplicationOperator(String params);


	public IDegreeCombiner getOrOperator(String params);


	public IDegreeCombiner getAndOperator(String params);





	public IDegreeCombiner getHedgeOperator(String params);


	public IDegree buildDegree(String priorStr);


	public IDiscountStrategy getDiscountStrategy();
	
	

}
