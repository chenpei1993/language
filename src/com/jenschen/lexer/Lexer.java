package com.jenschen.lexer;

import com.jenschen.exception.LexerException;
import com.jenschen.token.Token;
import com.jenschen.token.Type;
import com.jenschen.util.LexerUtil;

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
            if(LexerUtil.isNumber(curToken)){
                tokens.add(getDigits());
            }else if(Type.SPACE.is(curToken)){
                next();
            }else if(LexerUtil.isSharp(curToken)){
                skipComment();
            }else if(Type.TAB.is(curToken)){
                next();
            }else if(Type.ENTER.is(curToken)){
                next();
            }else if(Type.KEYWORD_COMMA.is(curToken)){
                next();
            }else if(LexerUtil.isLetter(curToken)){
                tokens.add(getIdentifier());
            }else if(Type.POW.is(curToken)){
                tokens.add(new Token(Type.POW));
                next();
            }else if(Type.MODE.is(curToken)){
                tokens.add(new Token(Type.MODE));
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
            }else if(LexerUtil.isLogicSymbol(curToken)){
                tokens.add(getLogic());
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

    private Token getLogic() throws LexerException {
        StringBuilder sb = new StringBuilder();
        while(curToken != null && (LexerUtil.isLogicSymbol(curToken))){
            sb.append(curToken);
            next();
        }
        String symbol = sb.toString();

        if(Type.EQ.is(symbol)){
            return new Token(Type.EQ);
        }else if(Type.LOGIC_LE.is(symbol)){
            return new Token(Type.LOGIC_LE);
        }else if(Type.LOGIC_LT.is(symbol)){
            return new Token(Type.LOGIC_LT);
        }else if(Type.LOGIC_GE.is(symbol)){
            return new Token(Type.LOGIC_GE);
        }else if(Type.LOGIC_GT.is(symbol)){
            return new Token(Type.LOGIC_GT);
        }else if(Type.LOGIC_EQ.is(symbol)){
            return new Token(Type.LOGIC_EQ);
        }else{
            throw new LexerException("illegal logic symbol");
        }
    }

    private Token getIdentifier(){
        StringBuilder sb = new StringBuilder();
        while(curToken != null && (LexerUtil.isValidCharacter(curToken))){
            sb.append(curToken);
            next();
        }
        String word = sb.toString();
        if(LexerUtil.isKeyword(word)){
            Type t = LexerUtil.getKeyword(word);
            return new Token(t, word);
        }else{
            return new Token(Type.IDENTIFIER, word);
        }
    }

    private Token getDigits() throws LexerException {
        StringBuilder sb = new StringBuilder();
        int dotCount = 0;
        while(curToken != null && LexerUtil.isDouble(curToken)){
            if(curToken.equals('.')){
                sb.append(".");
                dotCount += 1;
            }else{
                sb.append(curToken);
            }
            next();
        }

        if(dotCount == 0){
            return new Token(Type.INT, Integer.valueOf(sb.toString()));
        }else if(dotCount == 1){
            return new Token(Type.FLOAT, Double.valueOf(sb.toString()));
        }else{
            throw new LexerException("illegal character");
        }
    }

    private void skipComment(){
        next();
        while(curToken != null && !Type.ENTER.is(curToken)){
            next();
        }
    }
}
