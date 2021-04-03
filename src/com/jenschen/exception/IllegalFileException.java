package com.jenschen.exception;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 17:09 2021/4/3
 */
public class IllegalFileException extends Exception{
    public IllegalFileException(){
        super("please provide .cp file");
    }
}
