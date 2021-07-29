package com.jenschen.parser;

import com.jenschen.exception.ParserException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 22:40 2021/4/9
 */
public class ParserFactory {

    private static Map<String, Parser> parsers = new HashMap<>();

    static{
        parsers.put("args", new ArgsExpressionParser());
        parsers.put("arithmetic", new ArithmeticExpressionParser());
        parsers.put("callfunc", new CallFuncExpressionParser());
        parsers.put("expr", new ExpressionParser());
        parsers.put("func", new FuncExpressionParser());
        parsers.put("identifier", new IdentifierExpressionParser());
        parsers.put("if", new IfExpressionParser());
        parsers.put("localVariable", new LocalVariableParser());
        parsers.put("method", new MethodExpressionParser());
        parsers.put("number", new NumberParser());
        parsers.put("term", new TermParser());
        parsers.put("unary", new UnaryOperationParser());
        parsers.put("while", new WhileExpressionParser());

    }

    public static Parser getParser(String parserName) throws ParserException {
        if(parserName == null){
            throw new ParserException("parser name can't be null");
        }

        Parser p = parsers.get(parserName);

        if(p == null){
            throw new ParserException("parser name can't be null");
        }

        return p;
    }
}
