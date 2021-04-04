package com.jenschen.token;

import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 09:41 2021/4/2
 */
public class TokenIterator {

    private List<Token> tokens;

    private int index;

    public TokenIterator(List<Token> tokens){
        this.tokens = tokens;
        this.index = 0;
    }

    public Token next(){
        Token token = tokens.get(index);
        index++;
        return token;
    }

    public Token getNext(){
        if(index >= tokens.size()){
            return new Token(Type.NULL);
        }
        return tokens.get(index);
    }

    public boolean hasNext(){
        if(index >= tokens.size()){
            return false;
        }
        return tokens.get(index) != null;
    }
}
