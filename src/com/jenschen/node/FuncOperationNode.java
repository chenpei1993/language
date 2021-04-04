package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.node.ASTNode;
import com.jenschen.token.EmptyToken;
import com.jenschen.token.Token;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:00 2021/4/4
 */
public class FuncOperationNode implements ASTNode {

    private Token funcName;

    private ASTNode argsNode;

    private List<ASTNode> bodyNode;

    public FuncOperationNode(Token funcName, ASTNode argsNode, List<ASTNode> bodyNode){
        this.funcName = funcName;
        this.argsNode = argsNode;
        this.bodyNode = bodyNode;
    }

    @Override
    public Token operation() throws OperationException {
        return null;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Iterator<ASTNode> iterator = bodyNode.iterator();
        Token res = new EmptyToken();
        while(iterator.hasNext()){
            res = iterator.next().operation(context);
        }
        return res;
    }

    public ArgsOperationNode getArgsNode(){
        return (ArgsOperationNode) this.argsNode;
    }

    @Override
    public String toString() {
        return "FuncOperationNode{" +
                "funcName=" + funcName +
                ", argsNode=" + argsNode +
                ", bodyNode=" + bodyNode +
                '}';
    }
}
