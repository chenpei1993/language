package com.jenschen.parser.node;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 10:35 2021/4/2
 */
public class UnaryOperationNode implements ASTNode{
    private ASTNode value;

    private Token token;

    public UnaryOperationNode(ASTNode value, Token token){
        this.value = value;
        this.token = token;
    }

    @Override
    public String toString() {
        return "UnaryOperationNode{" +
                "value=" + value +
                ", token=" + token +
                '}';
    }
}
