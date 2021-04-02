package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:10 2021/4/2
 */
public class IllegalExpressionException extends ParserException{
    public IllegalExpressionException(){
        super("illegal expression ");
    }

}
