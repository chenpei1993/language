package com.jenschen.parser.node;

import com.jenschen.exception.OperationException;
import com.jenschen.parser.VariableTable;
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
            return VariableTable.getGlobalVariableMap((String) t.getValue());
        }
        t = node.operation();
        return VariableTable.getGlobalVariableMap((String) t.getValue());
    }
}
