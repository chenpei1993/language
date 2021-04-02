package com.jenschen.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 14:03 2021/4/2
 */
public class LexerUtil {

    private static final String DIGITS = "0123456789";

    private static final String LETTERS = "qwertyuiopasdfghjklzxcvbnm_QWERTYUIOPASDFGHJKLZXCVBNM";

    private static final String DIGITS_AND_LETTERS = DIGITS + LETTERS;

    private static final String DOT = ".";

    private static final List<String> KEYWORD = new ArrayList<>();

    static {
        KEYWORD.add("const");
        KEYWORD.add("let");
        KEYWORD.add("while");
        KEYWORD.add("if");
    }

    public static boolean isLetter(Character c){
        return LETTERS.indexOf(c) > 0 ? true : false;
    }

    public static boolean isValidCharacter(Character c){
        return DIGITS_AND_LETTERS.indexOf(c) > 0 ? true : false;
    }

    public static boolean isKeyword(String s){
        return KEYWORD.contains(s);
    }

    public static boolean isNumber(Character c){
        return DIGITS.indexOf(c) > 0 ? true : false;
    }

    public static boolean isDouble(Character c){
        return (DIGITS + DOT).indexOf(c) > 0 ? true : false;
    }

}
