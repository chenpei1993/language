package com.jenschen.lexer;

import com.jenschen.exception.LexerException;
import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:13 2021/4/2
 */
public class Lexer {

    private String context;

    private int pos;

    private Character curToken;

    public Lexer(String context){
        this.context = context;
        this.pos = -1;
        next();
    }

    private void next(){
        pos++;
        if(pos < context.length()){
            curToken = context.charAt(pos);
        }else{
            curToken = null;
        }
    }

    public List<Token> lexerText() throws LexerException {
        List<Token> tokens = new ArrayList<>();
        while(curToken != null){
            if(Type.DIGITS.is(curToken)){
                tokens.add(getDigits());
            }else if(Type.SPACE.is(curToken)){
                next();
            }else if(Type.TAB.is(curToken)){
                next();
            }else if(Type.PLUS.is(curToken)){
                tokens.add(new Token(Type.PLUS));
                next();
            }else if(Type.MINUS.is(curToken)){
                tokens.add(new Token(Type.MINUS));
                next();
            }else if(Type.MUL.is(curToken)){
                tokens.add(new Token(Type.MUL));
                next();
            }else if(Type.DIV.is(curToken)){
                tokens.add(new Token(Type.DIV));
                next();
            }else if(Type.LPAREN.is(curToken)){
                tokens.add(new Token(Type.LPAREN));
                next();
            }else if(Type.RPAREN.is(curToken)){
                tokens.add(new Token(Type.RPAREN));
                next();
            }else{
                throw new LexerException("illegal character");
            }
        }

        return tokens;
    }

    private Token getDigits() throws LexerException {
        StringBuilder sb = new StringBuilder();
        int dotCount = 0;
        while(curToken != null && (Type.DIGITS.is(curToken) || ".".equals(curToken))){
            if(".".equals(curToken)){
                sb.append(".");
                dotCount += 1;
            }else{
                sb.append(curToken);
            }
            next();
        }

        if(dotCount == 0){
            return new Token(Type.INT, sb.toString());
        }else if(dotCount == 1){
            return new Token(Type.FLOAT, sb.toString());
        }else{
            throw new LexerException("illegal character");
        }
    }


}
