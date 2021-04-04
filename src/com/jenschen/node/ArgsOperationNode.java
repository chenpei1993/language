package com.jenschen.node;


import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.Token;

import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 17:53 2021/4/4
 */
public class ArgsOperationNode implements ASTNode {

    private List<Token> args;

    public ArgsOperationNode(List<Token> args){
        this.args = args;
    }

    @Override
    public Token operation() throws OperationException {
        return null;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        return null;
    }

    public List<Token> getArgs(){
        return args;
    }
}
