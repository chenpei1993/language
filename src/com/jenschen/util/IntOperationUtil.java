package com.jenschen.util;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.BinaryOperator;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 13:42 2021/4/3
 */
public class IntOperationUtil {

    public static BinaryOperator<Token> getIntOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.INT, n1 - n2);
            };
        }else if(Type.PLUS.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.INT, n1 + n2);
            };
        }else if(Type.MUL.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.INT, n1 * n2);
            };
        }else if(Type.DIV.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.INT, n1 / n2);
            };
        }else if(Type.MODE.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.INT, n1 % n2);
            };
        }else if(Type.POW.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.FLOAT, Math.pow(n1, n2));
            };
        }else if(Type.LOGIC_LE.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.BOOLEAN, n1 <= n2);
            };
        }else if(Type.LOGIC_LT.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.BOOLEAN, n1 < n2);
            };
        }else if(Type.LOGIC_EQ.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.BOOLEAN, n1 == n2);
            };
        }else if(Type.LOGIC_GE.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.BOOLEAN, n1 >= n2);
            };
        }else if(Type.LOGIC_GT.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                return new Token(Type.BOOLEAN, n1 > n2);
            };
        }else if(Type.KEYWORD_AND.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2;
                if(d2.getValue() instanceof Boolean){
                    n2 = ((boolean) d2.getValue()) ? 1 : 0;
                }else{
                    n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                }
                return new Token(Type.BOOLEAN, (n1 > 0) && (n2 > 0));
            };
        }else if(Type.KEYWORD_OR.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2;
                if(d2.getValue() instanceof Boolean){
                    n2 = ((boolean) d2.getValue()) ? 1 : 0;
                }else{
                    n2 = Integer.parseInt(String.valueOf(d2.getValue()));
                }
                return new Token(Type.BOOLEAN, (n1 > 0) || (n2 > 0));
            };
        }
        return null;
    }
}
