package com.jenschen.parser.node.operation;

import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.function.Function;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:06 2021/4/2
 */
public class UnaryOperationFactory {

    public static Function<Token, Token> getOperation(Type type, Type operation){
        if(Type.FLOAT.equals(type)){
            return getFloatOperation(operation);
        }else if(Type.INT.equals(type)){
            return getIntOperation(operation);
        }
        return null;
    }

    private static Function<Token, Token> getFloatOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1) -> {
                Double v =  -((Number) d1.getValue()).doubleValue();
                return new Token(d1.getType(), v);
            };
        }else if(Type.PLUS.equals(operation)) {
            return (Token d1) -> {
                Double v =  ((Number) d1.getValue()).doubleValue();
                return new Token(d1.getType(), v);
            };
        }
        return null;
    }

    private static Function<Token, Token> getIntOperation(Type operation){
        if(Type.MINUS.equals(operation)){
            return (Token d1) -> {
                Integer v =  -((Number) d1.getValue()).intValue();
                return new Token(d1.getType(), v);
            };
        }else if(Type.PLUS.equals(operation)) {
            return (Token d1) -> {
                Integer v =  ((Number) d1.getValue()).intValue();
                return new Token(d1.getType(), v);
            };
        }
        return null;
    }

}
