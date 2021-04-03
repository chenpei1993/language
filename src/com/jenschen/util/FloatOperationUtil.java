package com.jenschen.util;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 13:38 2021/4/3
 */
public class FloatOperationUtil {

    //todo maybe use abstract factory
    public static BinaryOperator<Token> getBiFloatOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = Double.parseDouble(String.valueOf(d1.getValue()));
                double n2 = transferToFloat(d2);
                return new Token(Type.FLOAT, n1 - n2);
            };
        }else if(Type.PLUS.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.FLOAT, n1 + n2);
            };
        }else if(Type.MUL.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.FLOAT, n1 * n2 );
            };
        }else if(Type.DIV.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.FLOAT, n1 / n2);
            };
        }else if(Type.MODE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.FLOAT, n1 % n2);
            };
        }else if(Type.POW.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.FLOAT, Math.pow(n1, n2));
            };
        }else if(Type.LOGIC_LE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, Math.pow(n1, n2));
            };
        }else if(Type.LOGIC_LT.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, n1 < n2);
            };
        }else if(Type.LOGIC_LE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, n1 <= n2);
            };
        }else if(Type.LOGIC_EQ.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, n1 == n2);
            };
        }else if(Type.LOGIC_GE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, n1 > n2);
            };
        }else if(Type.LOGIC_GE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, n1 >= n2);
            };
        }else if(Type.KEYWORD_AND.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, (n1 > 0) && (n2 > 0));
            };
        }else if(Type.KEYWORD_OR.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = transferToFloat(d2);
                return new Token(Type.BOOLEAN, (n1 > 0) || (n2 > 0));
            };
        }
        return null;
    }

    public static Function<Token, Token> getFloatOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1) -> {
                Double v =  -transferToFloat(d1);
                return new Token(d1.getType(), v);
            };
        }else if(Type.PLUS.equals(operation)) {
            return (Token d1) -> {
                Double v =  transferToFloat(d1);
                return new Token(d1.getType(), v);
            };
        }else if(Type.KEYWORD_NOT.equals(operation)){
            return (Token d1) -> {
                double v =  transferToFloat(d1);
                boolean r = v > 0 ? false : true;
                return new Token(Type.BOOLEAN, r);
            };
        }
        return null;
    }

    private static double transferToFloat(Token t) {
        double n2;
        if (t.getValue() instanceof Integer || t.getValue() instanceof Double) {
            n2 = ((Number) t.getValue()).intValue();
        } else if (t.getValue() instanceof String) {
            n2 = Double.parseDouble(String.valueOf(t.getValue()));
        } else if (t.getValue() instanceof Boolean) {
            n2 = ((boolean) t.getValue()) ? 1.0 : 0.0;
        } else {
            return 0.0;
        }
        return n2;
    }
}
