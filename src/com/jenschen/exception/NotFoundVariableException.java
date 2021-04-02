package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 14:33 2021/4/2
 */
public class NotFoundVariableException extends RuntimeException{
    public NotFoundVariableException(String variable){
        super("not found a variable " + variable);
    }
}
