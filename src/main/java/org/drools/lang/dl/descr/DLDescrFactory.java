package org.drools.lang.dl.descr;

import java.util.List;

public class DLDescrFactory {

	private static int N = 0;
	
	public static DL_BaseDescr createImplies(List<DL_BaseDescr> children) {
		DL_CompositeDescr impl = new DL_ImpliesDescr();
			impl.addChildren(children);
		impl.setId(nextId());
		return impl;
	}
	
	public static DL_BaseDescr createAnd(List<DL_BaseDescr> children) {
		DL_CompositeDescr et = new DL_AndDescr();
			et.addChildren(children);
		et.setId(nextId());
		return et;
	}
	
	public static DL_BaseDescr createOr(List<DL_BaseDescr> children) {
		DL_CompositeDescr vel = new DL_OrDescr();
			vel.addChildren(children);	
		vel.setId(nextId());
		return vel;
	}
	
	public static DL_BaseDescr createNeg(DL_BaseDescr child) {
//		DL_CompositeDescr neg = new DL_NegDescr();
//		if (child instanceof DL_NegDescr) {
//			return ((DL_NegDescr) child).getChildren().get(0); 
//		} else if (child instanceof DL_ExistsDescr) {
//			DL_ExistsDescr ext = (DL_ExistsDescr) child;
//			ext.setNegated(! ext.isNegated());
//			return ext;
//		} else if (child instanceof DL_ForallDescr) {
//			DL_ForallDescr fal = (DL_ForallDescr) child;
//			fal.setNegated(! fal.isNegated());
//			return fal;
//		} else {
//			neg.addChild(child);
//			neg.setId(nextId());
//			return neg;
//		}	
		
		if (child instanceof DL_NegDescr) {
			return ((DL_NegDescr) child).getChildren().get(0); 
		} else {
			child.setNegated(! child.isNegated());
			return child;
		}
	}
	
	
	public static DL_BaseDescr createType(String klass) {
		DL_TypeDescr type = new DL_TypeDescr();
			type.setType(klass);
		type.setId(nextId());
		return type;
	}
	
	
	public static DL_BaseDescr createProperty(String klass) {
		DL_PropertyDescr prop = new DL_PropertyDescr();
			prop.setType(klass);
		prop.setId(nextId());
		return prop;
	}
	
	
	public static DL_BaseDescr createExists(DL_BaseDescr prop, DL_BaseDescr klass) {
		DL_CompositeDescr exist = new DL_ExistsDescr();
			exist.addChild(prop);
			exist.addChild(klass);
		exist.setId(nextId());
		return exist;
	}
	
	
	public static DL_BaseDescr createForall(DL_BaseDescr prop, DL_BaseDescr klass) {
		DL_CompositeDescr foral = new DL_ForallDescr();
			foral.addChild(prop);
			foral.addChild(klass);
		foral.setId(nextId());
		return foral;
	}
	
	
	public static DL_BaseDescr buildRootType(String klass, DL_BaseDescr def) {
		DL_RootNode root = new DL_RootNode();
			root.setType(klass);
			root.addChild(def);
		root.setId(nextId());
		return root;
	}
	
	
	public static DL_TypeDescr buildRandomTypeDescr() {
		int id = nextId();
		String type = "klass_"+id;
		DL_TypeDescr td = new DL_TypeDescr();
			td.setType(type);
		td.setId(id);	
		return td;
	}
	
	public static int nextId() {
		return N++;
	}
	
	
	
}
