package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.MethodOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 20:53 2021/4/4
 */
public class MethodExpressionParser implements Parser {

    private static Parser argsExpressionParser = new ArgsExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        Token t = iterator.next();
        String name = (String) t.getValue();
        if(!Type.LPAREN.equals(iterator.getNext().getType())){

        }
        iterator.next(); // skip (

        ASTNode argsNode = null;
        if(!Type.RPAREN.equals(iterator.getNext().getType())){
            argsNode = argsExpressionParser.parse(iterator);
        }
        iterator.next(); // skip )

        return new MethodOperationNode(name, argsNode);
    }
}
