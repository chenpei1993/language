package com.jenschen.parser.node.operation;

import com.jenschen.token.Token;
import com.jenschen.token.Type;
import com.jenschen.util.BooleanOperationUtil;
import com.jenschen.util.FloatOperationUtil;
import com.jenschen.util.IntOperationUtil;

import java.util.function.Function;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:06 2021/4/2
 */
public class UnaryOperationFactory {

    public static Function<Token, Token> getOperation(Type type, Type operation){
        if(Type.FLOAT.equals(type)){
            return FloatOperationUtil.getFloatOperation(operation);
        }else if(Type.INT.equals(type)){
            return IntOperationUtil.getIntOperation(operation);
        }else if(Type.BOOLEAN.equals(type)){
            return BooleanOperationUtil.getBooleanOperation(operation);
        }
        return null;
    }





}
