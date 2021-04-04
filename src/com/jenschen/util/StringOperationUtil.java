package com.jenschen.util;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 21:13 2021/4/4
 */
public class StringOperationUtil {

    public static String transferToString(Token t) {
        String n2;
        if (t.getValue() instanceof Integer || t.getValue() instanceof Double) {
            n2 = t.getValue().toString();
        } else if (t.getValue() instanceof String) {
            n2 = String.valueOf(t.getValue());
        } else if (t.getValue() instanceof Boolean) {
            n2 = ((boolean) t.getValue()) ? "true" : "false";
        } else {
            return "";
        }
        return n2;
    }
}
