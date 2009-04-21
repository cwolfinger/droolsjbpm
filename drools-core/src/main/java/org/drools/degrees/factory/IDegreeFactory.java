package org.drools.degrees.factory;

import org.drools.degrees.IDegree;
import org.drools.degrees.operators.IDegreeCombiner;
import org.drools.reteoo.filters.IFilterStrategy;

import org.drools.degrees.operators.IMergeStrategy;
import org.drools.degrees.operators.INullHandlingStrategy;

public interface IDegreeFactory {
	
	
	
	
	
	public IDegree buildDegree(float val);
	
	
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
	
	

}
