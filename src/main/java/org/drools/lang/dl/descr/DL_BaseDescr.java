package org.drools.lang.dl.descr;

/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public abstract class DL_BaseDescr  {

    private static final long serialVersionUID = 400L;       
    private int id;
    private DL_CompositeDescr father;
    private boolean negated = false;
//    private int level = 0;
    
        
    
    
    
    public String toUpwardString() {
    	StringBuilder sb = new StringBuilder();
    		sb.append(this.toString());
    		sb.append(" | son-of " + 
    						((father == null) ? "null" : father.toUpwardString()) 
    						);    		
    	return sb.toString();
    }
    
    public String toDownwardString() {
    	return toString();
    }
    
    public String toFullDownwardString(int n) {
    	return toString();
    }

    public String toString() {
    	//return "DL["+id+"]: " + this.getClass().getSimpleName() +"\n";
    	return "DL["+id+"]: " + this.getType() +"\n";
    }
    
    
    
	public void setFather(DL_CompositeDescr father) {
		this.father = father;
	}

	public DL_CompositeDescr getFather() {
		return father;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DL_BaseDescr other = (DL_BaseDescr) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public abstract String getType();

//	public void setLevel(int level) {
//		this.level = level;
//	}

	public int getLevel() {
		return (father == null) ? 0 : (1+father.getLevel());
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public boolean isNegated() {
		return negated;
	}
    
}