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
 * @Date: Created in 09:22 2021/4/2
 */
public class TermParser implements Parser{

    private static List<Type> canParserType = new ArrayList<>();;

    private static NumberParser numberParser = new NumberParser();

    static{
        canParserType.add(Type.MUL);
        canParserType.add(Type.DIV);
    }

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        ASTNode left = numberParser.parse(iterator);

        while(canParserType.contains(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode right = numberParser.parse(iterator);
            left = new BinaryOperationNode(left, right, token);
        }
        return left;
    }
}
