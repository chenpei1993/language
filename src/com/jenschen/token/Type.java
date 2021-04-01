package com.jenschen.token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:11 2021/4/2
 */
public enum Type {
    INT,
    FLOAT,
    DIGITS("0123456789"),
    SPACE(" "),
    TAB("\t"),
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    LPAREN("("),
    RPAREN(")");

    private String symbol;

    Type(){

    }

    Type(String symbol){
        this.symbol = symbol;
    }

    public boolean is(Character character){
        if(this.symbol == null){
            return false;
        }

        return this.symbol.indexOf(character) < 0 ? false : true;
    }
}
