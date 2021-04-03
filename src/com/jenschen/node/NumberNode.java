package com.jenschen.node;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 09:27 2021/4/2
 */
public class NumberNode implements ASTNode {

    private Token token;

    public NumberNode(Token token){
        this.token = token;
    }

    public Token getToken(){
        return this.token;
    }

    @Override
    public String toString() {
        return "NumberNode{" +
                "token=" + token +
                '}';
    }

    @Override
    public Token operation() {
        return new Token(this.token.getType(), this.token.getValue());
    }
}
