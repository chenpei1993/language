package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.BinaryOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:12 2021/4/2
 */
public class ExpressionParser implements Parser {

    private static List<Type> canParserType = new ArrayList<>();

    static{
        canParserType.add(Type.PLUS);
        canParserType.add(Type.MINUS);
    }

    private static TermParser termParser = new TermParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        ASTNode left = termParser.parse(iterator);

        while(canParserType.contains(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode right = termParser.parse(iterator);
            left = new BinaryOperationNode(left, right, token);
        }

        return left;
    }

}
