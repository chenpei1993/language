package com.jenschen.parser.node;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 09:27 2021/4/2
 */
public class NumberNode<T> extends BasicNode{

    private Token token;

    public NumberNode(Token token){
        this.token = token;
    }

    @Override
    public String toString() {
        return "NumberNode{" +
                "token=" + token +
                '}';
    }
}
