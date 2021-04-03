package com.jenschen.util;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 13:42 2021/4/3
 */
public class IntOperationUtil {

    public static BinaryOperator<Token> getBiIntOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.INT, n1 - n2);
            };
        }else if(Type.PLUS.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.INT, n1 + n2);
            };
        }else if(Type.MUL.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.INT, n1 * n2);
            };
        }else if(Type.DIV.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.INT, n1 / n2);
            };
        }else if(Type.MODE.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.INT, n1 % n2);
            };
        }else if(Type.POW.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.FLOAT, Math.pow(n1, n2));
            };
        }else if(Type.LOGIC_LE.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, n1 <= n2);
            };
        }else if(Type.LOGIC_LT.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, n1 < n2);
            };
        }else if(Type.LOGIC_EQ.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, n1 == n2);
            };
        }else if(Type.LOGIC_GE.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, n1 >= n2);
            };
        }else if(Type.LOGIC_GT.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, n1 > n2);
            };
        }else if(Type.KEYWORD_AND.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, (n1 > 0) && (n2 > 0));
            };
        }else if(Type.KEYWORD_OR.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = Integer.parseInt(String.valueOf(d1.getValue()));
                int n2 = transferToInt(d2);
                return new Token(Type.BOOLEAN, (n1 > 0) || (n2 > 0));
            };
        }
        return null;
    }

    public static Function<Token, Token> getIntOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1) -> {
                Integer v =  -transferToInt(d1);
                return new Token(d1.getType(), v);
            };
        }else if(Type.PLUS.equals(operation)) {
            return (Token d1) -> {
                Integer v =  transferToInt(d1);
                return new Token(d1.getType(), v);
            };
        }else if(Type.KEYWORD_NOT.equals(operation)){
            return (Token d1) -> {
                int v =  transferToInt(d1);
                boolean r = v > 0 ? false : true;
                return new Token(Type.BOOLEAN, r);
            };
        }
        return null;
    }

    private static int transferToInt(Token t){
        int n2;
        if (t.getValue() instanceof Integer || t.getValue() instanceof Double) {
            n2 = ((Number) t.getValue()).intValue();
        } else if (t.getValue() instanceof String) {
            n2 = Integer.parseInt(String.valueOf(t.getValue()));
        } else if (t.getValue() instanceof Boolean) {
            n2 = ((boolean) t.getValue()) ? 1 : 0;
        } else {
            return 0;
        }
        return n2;

    }
}
