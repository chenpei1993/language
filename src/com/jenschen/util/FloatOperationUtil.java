package com.jenschen.util;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.BinaryOperator;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 13:38 2021/4/3
 */
public class FloatOperationUtil {

    //todo maybe use abstract factory
    public static BinaryOperator<Token> getFloatOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = Double.parseDouble(String.valueOf(d1.getValue()));
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.FLOAT, n1 - n2);
            };
        }else if(Type.PLUS.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.FLOAT, n1 + n2);
            };
        }else if(Type.MUL.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.FLOAT, n1 * n2 );
            };
        }else if(Type.DIV.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.FLOAT, n1 / n2);
            };
        }else if(Type.MODE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.FLOAT, n1 % n2);
            };
        }else if(Type.POW.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.FLOAT, Math.pow(n1, n2));
            };
        }else if(Type.LOGIC_LE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.BOOLEAN, Math.pow(n1, n2));
            };
        }else if(Type.LOGIC_LT.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.BOOLEAN, n1 < n2);
            };
        }else if(Type.LOGIC_LE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.BOOLEAN, n1 <= n2);
            };
        }else if(Type.LOGIC_EQ.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.BOOLEAN, n1 == n2);
            };
        }else if(Type.LOGIC_GE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.BOOLEAN, n1 > n2);
            };
        }else if(Type.LOGIC_GE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2 = ((Number) d2.getValue()).doubleValue();
                return new Token(Type.BOOLEAN, n1 >= n2);
            };
        }else if(Type.KEYWORD_AND.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2;
                if(d2.getValue() instanceof Boolean){
                    n2 = ((boolean) d2.getValue()) ? 1.0 : 0.0;
                }else{
                    n2 = Double.parseDouble(String.valueOf(d2.getValue()));
                }
                return new Token(Type.BOOLEAN, (n1 > 0) && (n2 > 0));
            };
        }else if(Type.KEYWORD_OR.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
                double n2;
                if(d2.getValue() instanceof Boolean){
                    n2 = ((boolean) d2.getValue()) ? 1.0 : 0.0;
                }else{
                    n2 = Double.parseDouble(String.valueOf(d2.getValue()));
                }
                return new Token(Type.BOOLEAN, (n1 > 0) || (n2 > 0));
            };
        }
        return null;
    }
}
