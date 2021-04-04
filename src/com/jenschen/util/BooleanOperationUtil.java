package com.jenschen.util;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 14:36 2021/4/3
 */
public class BooleanOperationUtil {

    public static BinaryOperator<Token> getBiBooleanOperation(Type operation){
        if(Type.KEYWORD_AND.equals(operation)){
            return (Token d1, Token d2) -> {
                boolean n1 = (boolean) d1.getValue();
                boolean n2 = transferToBoolean(d2);
                return new Token(Type.BOOLEAN, n1 && n2);
            };
        }else if(Type.KEYWORD_OR.equals(operation)){
            return (Token d1, Token d2) -> {
                boolean n1 = (boolean) d1.getValue();
                boolean n2 = transferToBoolean(d2);
                return new Token(Type.BOOLEAN, n1 || n2);
            };
        }
        return null;
    }

    public static Function<Token, Token> getBooleanOperation(Type operation){
        if(Type.KEYWORD_NOT.equals(operation)){
            return (Token d1) -> {
                boolean v =  transferToBoolean(d1);
                return new Token(Type.BOOLEAN, !v);
            };
        }
        return null;
    }

    public static boolean transferToBoolean(Token t) {
        boolean n2;
        if (t.getValue() instanceof Integer || t.getValue() instanceof Double) {
            n2 = ((Number) t.getValue()).intValue() > 0 ? true : false;
        } else if (t.getValue() instanceof String) {
            n2 = Boolean.parseBoolean(String.valueOf(t.getValue()));
        } else if (t.getValue() instanceof Boolean) {
            n2 = (boolean) t.getValue();
        } else {
            return false;
        }
        return n2;
    }
}
