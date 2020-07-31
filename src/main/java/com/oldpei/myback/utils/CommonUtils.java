package com.oldpei.myback.utils;

/**
* CommonUtils class.
* @author ben.zhang
* @version 1.0
*/
public class CommonUtils {

	 /**
	 * check string is empty or not
	 * @param str 
	 * @return String 
	 */
	public static boolean strIsEmpty(String str) {
		if (null == str || str.isEmpty()) {
			return true;
		}
		return false;
	}
	
	 /**
	 * format null string to ""
	 * @param str
	 * @return String 
	 */
	public static String strNonNull(String str) {
		if (null == str) {
			str = "";
		}
		return str;
	}
}
