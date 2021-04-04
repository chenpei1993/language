package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.EmptyToken;
import com.jenschen.token.Token;
import com.jenschen.util.BooleanOperationUtil;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 17:32 2021/4/3
 */
public class WhileOperationNode implements ASTNode, Operation{

    private ASTNode compareNode;

    private ASTNode exprNode;

    public WhileOperationNode(ASTNode compareNode, ASTNode exprNode){
        this.compareNode = compareNode;
        this.exprNode = exprNode;
    }
    @Override
    public Token operation() throws OperationException {
        Token booleanToken = compareNode.operation();
        boolean compareResult = BooleanOperationUtil.transferToBoolean(booleanToken);
        Token result = new EmptyToken();
        while(compareResult){
            result = exprNode.operation();
            booleanToken = compareNode.operation();
            compareResult = BooleanOperationUtil.transferToBoolean(booleanToken);
        }
        return result;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Token booleanToken = compareNode.operation(context);
        boolean compareResult = BooleanOperationUtil.transferToBoolean(booleanToken);
        Token result = new EmptyToken();
        while(compareResult){
            result = exprNode.operation(context);
            booleanToken = compareNode.operation(context);
            compareResult = BooleanOperationUtil.transferToBoolean(booleanToken);
        }
        return result;
    }

    @Override
    public String toString() {
        return "WhileOperationNode{" +
                "compareNode=" + compareNode +
                ", exprNode=" + exprNode +
                '}';
    }
}
