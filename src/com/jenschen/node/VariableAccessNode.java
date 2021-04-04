package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.Interpretor.SymbolTable;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:54 2021/4/2
 */
public class VariableAccessNode implements ASTNode {

    private Token token;

    private ASTNode node;

    public VariableAccessNode(Token token, ASTNode node){
        this.node = node;
        this.token = token;
    }

    public VariableAccessNode(Token token){
        this.node = null;
        this.token = token;
    }

    @Override
    public Token operation() throws OperationException {
        Token t = this.token;
        if(node == null){
            return SymbolTable.getGlobalVariableMap((String) t.getValue());
        }
        t = node.operation();
        return SymbolTable.getGlobalVariableMap((String) t.getValue());
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Token t = this.token;
        if(node == null){
            return context.getVariable((String) t.getValue());
        }
        t = node.operation(context);
        return context.getVariable((String) t.getValue());
    }

    @Override
    public String toString() {
        return "VariableAccessNode{" +
                "token=" + token +
                ", node=" + node +
                '}';
    }
}
