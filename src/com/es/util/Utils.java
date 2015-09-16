package com.es.util;

public final class Utils {
	
	private Utils(){}
	
	public static <T> T throwIfNull(T reference) {
		if (reference == null) {
			throw new NullPointerException();
		}
		return reference;
	}
	
	public static <T> T throwIfNull(T reference, Object errorMessage) {
	    if (reference == null) {
	      throw new NullPointerException(String.valueOf(errorMessage));
	    }
	    return reference;
	  }
}
