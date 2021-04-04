package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 16:28 2021/4/3
 */
public class OperationException extends RuntimeException{
    public OperationException(String message) {
        super("OperationException " + message);
    }
}
