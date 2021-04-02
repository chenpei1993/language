package com.jenschen.parser.node.operation;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.BinaryOperator;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 11:49 2021/4/2
 */
public class BinaryOperationFactory {

    private BinaryOperationFactory(){}

    public static BinaryOperator<Token> getOperation(Type type, Type operation){
        if(Type.FLOAT.equals(type)){
            return getFloatOperation(operation);
        }else if(Type.INT.equals(type)){
            return getIntOperation(operation);
        }
        return null;
    }

    private static BinaryOperator<Token> getFloatOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).doubleValue();
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
        }
        return null;
    }

    private static BinaryOperator<Token> getIntOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = ((Number) d1.getValue()).intValue();
                int n2 = ((Number) d2.getValue()).intValue();
                return new Token(Type.INT, n1 - n2);
            };
        }else if(Type.PLUS.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = ((Number) d1.getValue()).intValue();
                int n2 = ((Number) d2.getValue()).intValue();
                return new Token(Type.INT, n1 + n2);
            };
        }else if(Type.MUL.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = ((Number) d1.getValue()).intValue();
                int n2 = ((Number) d2.getValue()).intValue();
                return new Token(Type.INT, n1 * n2);
            };
        }else if(Type.DIV.equals(operation)){
            return (Token d1, Token d2) -> {
                int n1 = ((Number) d1.getValue()).intValue();
                int n2 = ((Number) d2.getValue()).intValue();
                return new Token(Type.INT, n1 / n2);
            };
        }else if(Type.MODE.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).intValue();
                double n2 = ((Number) d2.getValue()).intValue();
                return new Token(Type.INT, n1 % n2);
            };
        }else if(Type.POW.equals(operation)){
            return (Token d1, Token d2) -> {
                double n1 = ((Number) d1.getValue()).intValue();
                double n2 = ((Number) d2.getValue()).intValue();
                return new Token(Type.FLOAT, Math.pow(n1, n2));
            };
        }
        return null;
    }

}
