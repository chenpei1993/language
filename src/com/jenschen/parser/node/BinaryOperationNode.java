package com.jenschen.parser.node;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:07 2021/4/2
 */
public class BinaryOperationNode implements ASTNode, Operation {

    private ASTNode leftNode;

    private ASTNode rightNode;

    private Token token;

    public BinaryOperationNode(ASTNode leftNode, ASTNode rightNode, Token token){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.token = token;
    }

    @Override
    public void operation() {

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
