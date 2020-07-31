package com.oldpei.myback.utils;

import java.util.List;
import java.util.Objects;

/**
 * CommonUtils class.
 *
 * @author jixing.pei
 * @version 1.0
 */
public class CommonUtils {

    /**
     * check string is empty or not
     *
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
     *
     * @param str
     * @return String
     */
    public static String strNonNull(String str) {
        if (null == str) {
            str = "";
        }
        return str;
    }

    /**
     * format null string to ""
     *
     * @param str
     * @return String
     */
    public static boolean listNonNull(List<?> list) {
        if (Objects.nonNull(list) && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
