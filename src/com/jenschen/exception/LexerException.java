package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:27 2021/4/2
 */
public class LexerException extends ParserException{

    public LexerException(String message){
        super("Oops, There is a bug in lexer process. ");
    }
}
