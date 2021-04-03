package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.NumberNode;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 09:22 2021/4/2
 */
public class NumberParser implements Parser{

    private static List<Type> canParserType = new ArrayList<>();

    private static List<Type> unaryParserType = new ArrayList<>();

    private static UnaryOperationParser unaryOperationParser = new UnaryOperationParser();

    private static ArithmeticExpressionParser arithmeticExpressionParser = new ArithmeticExpressionParser();


    static{
        canParserType.add(Type.FLOAT);
        canParserType.add(Type.INT);

        unaryParserType.add(Type.MINUS);
        unaryParserType.add(Type.PLUS);
    }

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {

        if(unaryParserType.contains(iterator.getNext().getType())){
            return unaryOperationParser.parse(iterator);
        }

        if(canParserType.contains(iterator.getNext().getType())){
            return new NumberNode(iterator.next());
        }

        if(Type.LPAREN.equals(iterator.getNext().getType())){
            iterator.next();
            ASTNode node = arithmeticExpressionParser.parse(iterator);
            if(Type.RPAREN.equals(iterator.getNext().getType())){
                iterator.next();
            }
            return node;
        }

        throw new ParserException("can't parse this token in NumberParser");
    }
}
