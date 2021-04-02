package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.UnaryOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 10:38 2021/4/2
 */
public class UnaryOperationParser implements Parser{

    private static List<Type> canParserType = new ArrayList<>();;

    private static NumberParser numberParser = new NumberParser();

    static{
        canParserType.add(Type.INT);
        canParserType.add(Type.FLOAT);
    }

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        Token token = iterator.next();
        ASTNode value = null;
        while(canParserType.contains(iterator.getNext().getType())){
            value = numberParser.parse(iterator);
        }
        return new UnaryOperationNode(value, token);
    }
}
