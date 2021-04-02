package com.jenschen.parser;

import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.token.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 14:30 2021/4/2
 */
public class VariableTable {
    private Map<String, Token> localVariableMap = new HashMap<>();

    private static Map<String, Token> constVariableMap = new HashMap<>();

    public Token getVariable(String key) throws NotFoundVariableException {
        Token t = localVariableMap.get(key);

        if(t != null){
            return t;
        }

        t = constVariableMap.get(key);

        if(t != null){
            return t;
        }

        throw new NotFoundVariableException(key);
    }

    public void setVariableMap(String key, Token value){
        localVariableMap.put(key, value);
    }

    public static void setGlobalVariableMap(String key, Token value){
        constVariableMap.put(key, value);
    }

    public static Token getGlobalVariableMap(String key){
        return constVariableMap.get(key);
    }

}
