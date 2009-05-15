/*
 * Copyright 2006 JBoss Inc
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

package org.drools.rule;

/**
 * A simple factory for GroupElements
 * 
 * @author etirelli
 */
public class GroupElementFactory {

    private GroupElementFactory() {
    }

    public static GroupElement newAndInstance() {
        return new GroupElement( GroupElement.AND );
    }

    public static GroupElement newOrInstance() {
        return new GroupElement( GroupElement.OR );
    }

    public static GroupElement newNotInstance() {
        return new GroupElement( GroupElement.NOT );
    }

    public static GroupElement newExistsInstance() {
        return new GroupElement( GroupElement.EXISTS );
    }

//	public static GroupElement newForAnyInstance() {
//		return new GroupElement( GroupElement.FORANY );
//	}
	
	public static GroupElement newXorInstance() {
        return new GroupElement( GroupElement.XOR );
    }
	
	public static GroupElement newEqvInstance() {
        return new GroupElement( GroupElement.EQV );
    }

	public static GroupElement newDiscountInstance() {
		return new GroupElement( GroupElement.DISC );
	}

	public static GroupElement newAvgInstance() {
		return new GroupElement( GroupElement.AVG );
	}

	public static GroupElement newDblMPInstance() {
		return new GroupElement( GroupElement.DMP );
	}
	
	
	public static GroupElement newHedgeInstance() {
		return new GroupElement( GroupElement.HEDGE );
	}
	
	
	
	
	
	public static GroupElement newAndInstance(String params) {
        return new GroupElement( GroupElement.AND, params );
    }

    public static GroupElement newOrInstance(String params) {
        return new GroupElement( GroupElement.OR, params );
    }

    public static GroupElement newNotInstance(String params) {
        return new GroupElement( GroupElement.NOT, params );
    }

    public static GroupElement newExistsInstance(String params) {
        return new GroupElement( GroupElement.EXISTS, params );
    }

//	public static GroupElement newForAnyInstance() {
//		return new GroupElement( GroupElement.FORANY );
//	}
	
	public static GroupElement newXorInstance(String params) {
        return new GroupElement( GroupElement.XOR, params );
    }
	
	public static GroupElement newEqvInstance(String params) {
        return new GroupElement( GroupElement.EQV, params );
    }

	public static GroupElement newDiscountInstance(String params) {
		return new GroupElement( GroupElement.DISC, params );
	}

	public static GroupElement newAvgInstance(String params) {
		return new GroupElement( GroupElement.AVG, params );
	}

	public static GroupElement newDblMPInstance(String params) {
		return new GroupElement( GroupElement.DMP , params);
	}
	
	public static GroupElement newHedgeInstance(String params) {
		return new GroupElement( GroupElement.HEDGE , params);
	}
	
	
	

}
