package com.jenschen.token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:11 2021/4/2
 */
public enum Type {
    NULL,
    INT,
    FLOAT,
    IDENTIFIER,
    VARIABLE,
    KEYWORD_LET("let"),
    KEYWORD_CONST("const"),
    SPACE(" "),
    TAB("\t"),
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    MODE("%"),
    POW("^"),
    EQ("="),
    LOGIC_EQ("=="),
    LOGIC_GT(">"),
    LOGIC_LT("<"),
    LOGIC_GE(">="),
    LOGIC_LE("<="),
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

    public boolean is(String s){
        if(this.symbol == null){
            return false;
        }

        return this.symbol.equals(s);
    }
}
