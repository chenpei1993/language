package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.Token;
import com.jenschen.node.operation.BinaryOperationFactory;

import java.util.function.BinaryOperator;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:07 2021/4/2
 */
public class BinaryOperationNode implements ASTNode {

    private ASTNode leftNode;

    private ASTNode rightNode;

    private Token token;

    public BinaryOperationNode(ASTNode leftNode, ASTNode rightNode, Token token){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.token = token;
    }

    @Override
    public Token operation() throws OperationException {
        Token left = leftNode.operation();
        Token right = rightNode.operation();
        BinaryOperator op = BinaryOperationFactory.getOperation(left.getType(), token.getType());
        Token t = (Token) op.apply(left, right);
        return t;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Token left = leftNode.operation(context);
        Token right = rightNode.operation(context);
        BinaryOperator op = BinaryOperationFactory.getOperation(left.getType(), token.getType());
        Token t = (Token) op.apply(left, right);
        return t;
    }

    @Override
    public String toString() {
        return "BinaryOperationNode{" +
                "leftNode=" + leftNode.toString() +
                ", token=" + token.toString() +
                ", rightNode=" + rightNode.toString() +
                '}';
    }
}
