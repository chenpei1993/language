package com.jenschen.token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:11 2021/4/2
 */
public enum Type {
    NULL,
    BOOLEAN,
    INT,
    FLOAT,
    IDENTIFIER,
    KEYWORD,
    KEYWORD_LET("let"),
    KEYWORD_CONST("const"),
    KEYWORD_AND("and"),
    KEYWORD_OR("or"),
    KEYWORD_NOT("not"),
    KEYWORD_IF("if"),
    KEYWORD_THEN("then"),
    KEYWORD_ELSE("else"),
    KEYWORD_TRUE("true"),
    KEYWORD_FALSE("false"),
    KEYWORD_WHILE("while"),
    KEYWORD_END("end"),
    KEYWORD_FUNC("func"),
    KEYWORD_COMMA(","),
    SPACE(" "),
    TAB("\t"),
    COMMENT("//"),
    ENTER("\n"),
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
    LOGIC_NOT("!"),
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
