package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.EmptyToken;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 18:09 2021/4/4
 */
public class EmptyNode implements ASTNode{
    @Override
    public Token operation() throws OperationException {
        return new EmptyToken();
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        return new EmptyToken();
    }
}
