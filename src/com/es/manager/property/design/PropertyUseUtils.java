package com.es.manager.property.design;

public class PropertyUseUtils {
	
	public static Class getClassForPropertyUseHint(String hint){
		switch (hint){
		case "K12 School":
			return K12SchoolType.class;
		case "Medical Office":
			return MedicalOfficeType.class;
		 		
		default:
			return null;
		}
	}
}
