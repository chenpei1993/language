package com.jenschen.Interpretor;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:29 2021/4/4
 */
public class Context implements ISymbolTable {

    private ISymbolTable table;

    private Context parent;

    public Context(ISymbolTable table, Context parent){
        this.table = table;
        this.parent = parent;
    }


    public Token getVariable(String key) {
        Token t = table.getVariable(key);

        if(t != null){
            return t;
        }

        if(parent != null){
            t = parent.getVariable(key);
        }else{
            t = SymbolTable.getGlobalVariableMap(key);
        }

        if(t != null){
            return t;
        }

        return null;
//        throw new NotFoundVariableException(key);
    }

    @Override
    public void setVariable(String key, Token value) {

        Token t = table.getVariable(key);
        if(t != null){
            table.setVariable(key, value);
        }else{
            table.setVariable(key, value);
            parent.setVariable(key, value);
        }
    }
}
