package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 16:23 2021/4/3
 */
public class NoElseException extends OperationException{

    public NoElseException(){
        super("not found else expression");
    }
}
