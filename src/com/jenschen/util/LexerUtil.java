package com.jenschen.util;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 14:03 2021/4/2
 */
public class LexerUtil {

    private static final String DIGITS = "0123456789";

    private static final String LETTERS = "qwertyuiopasdfghjklzxcvbnm_QWERTYUIOPASDFGHJKLZXCVBNM";

    private static final String LOGIC_SYMBOL = ">=<!";

    private static final String DIGITS_AND_LETTERS = DIGITS + LETTERS;

    private static final String DOT = ".";

    private static final String BACKSLASH = "#";

    private static final List<Type> KEYWORD = new ArrayList<>();

    static {
        KEYWORD.add(Type.KEYWORD_LET);
        KEYWORD.add(Type.KEYWORD_AND);
        KEYWORD.add(Type.KEYWORD_OR);
        KEYWORD.add(Type.KEYWORD_NOT);
        KEYWORD.add(Type.KEYWORD_IF);
        KEYWORD.add(Type.KEYWORD_THEN);
        KEYWORD.add(Type.KEYWORD_ELSE);
        KEYWORD.add(Type.KEYWORD_TRUE);
        KEYWORD.add(Type.KEYWORD_FALSE);
        KEYWORD.add(Type.KEYWORD_WHILE);
        KEYWORD.add(Type.KEYWORD_END);
    }

    public static boolean isSharp(Character c){
        return BACKSLASH.indexOf(c) >= 0 ? true : false;
    }

    public static boolean isLogicSymbol(Character c){
        return LOGIC_SYMBOL.indexOf(c) >= 0 ? true : false;
    }

    public static boolean isLetter(Character c){
        return LETTERS.indexOf(c) >= 0 ? true : false;
    }

    public static boolean isValidCharacter(Character c){
        return DIGITS_AND_LETTERS.indexOf(c) >= 0 ? true : false;
    }

    public static boolean isKeyword(String s){

        Iterator<Type> iterator = KEYWORD.iterator();
        while(iterator.hasNext()){
            if(iterator.next().is(s)){
                return true;
            }
        }
        return false;
    }

    public static Type getKeyword(String s){
        Iterator<Type> iterator = KEYWORD.iterator();
        while(iterator.hasNext()){
            Type t = iterator.next();
            if(t.is(s)){
                return t;
            }
        }
        return null;
    }

    public static boolean isNumber(Character c){
        return DIGITS.indexOf(c) >= 0 ? true : false;
    }

    public static boolean isDouble(Character c){
        return (DIGITS + DOT).indexOf(c) >= 0 ? true : false;
    }

}
