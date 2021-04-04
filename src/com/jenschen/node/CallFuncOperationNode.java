package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.OperationException;
import com.jenschen.node.ASTNode;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:13 2021/4/4
 */
public class CallFuncOperationNode implements ASTNode {

    private Token funcName;

    private ASTNode argNodes;

    private ASTNode bodyNoes;

    public CallFuncOperationNode(){

    }

    @Override
    public Token operation() throws OperationException {
        return null;
    }

    @Override
    public Token operation(Context context) throws OperationException {
        return null;
    }
}
