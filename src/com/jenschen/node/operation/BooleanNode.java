package com.jenschen.node.operation;

import com.jenschen.exception.OperationException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.Operation;
import com.jenschen.token.Token;
import com.jenschen.token.Type;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 16:54 2021/4/3
 */
public class BooleanNode implements ASTNode, Operation {

    private Token token;

    public BooleanNode(Token token){
        this.token = token;
    }
    @Override
    public Token operation() throws OperationException {
        if(token == null){
            return new Token(Type.BOOLEAN, false);
        }
        return token;
    }
}
