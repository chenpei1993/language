package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 09:25 2021/4/2
 */
public class ParserException extends Exception {
    public ParserException(String message){
        super("Oops, There is a bug in parse process. " + message);
    }

}
