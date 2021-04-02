package com.jenschen.token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:06 2021/4/2
 */
public class Token<T>{

    private Type type;

    private T value;

    public Token(Type type){
        this.type = type;
        this.value = null;
    }

    public Token(Type type, T value){
        this.type = type;
        this.value = value;
    }

    public Type getType(){
        return type;
    }

    public T getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
