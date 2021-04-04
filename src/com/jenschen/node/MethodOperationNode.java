package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.Interpretor.FuncTable;
import com.jenschen.Interpretor.MethodTable;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.method.Method;
import com.jenschen.token.EmptyToken;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 20:57 2021/4/4
 */
public class MethodOperationNode implements ASTNode {
    private String name;

    private ASTNode argsNode;

    public MethodOperationNode(String name, ASTNode argsNode) {
        this.name = name;
        this.argsNode = argsNode;
    }

    @Override
    public Token operation() throws OperationException {
        return null;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Method m = MethodTable.getFunc(this.name);
        m.run(context, argsNode);
        return null;
    }
}
