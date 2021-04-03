package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.BinaryOperationNode;
import com.jenschen.parser.node.UnaryOperationNode;
import com.jenschen.parser.node.VariableAccessNode;
import com.jenschen.parser.node.operation.BooleanNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:58 2021/4/3
 */
public class CompareExpressionParser implements Parser {

    private static Parser arithmeticExpressionParser = new ArithmeticExpressionParser();

    private static List<Type> canParserType = new ArrayList<>();
    static {
        canParserType.add(Type.LOGIC_GT);
        canParserType.add(Type.LOGIC_GE);
        canParserType.add(Type.LOGIC_EQ);
        canParserType.add(Type.LOGIC_LE);
        canParserType.add(Type.LOGIC_LT);
    }

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {

        if(Type.KEYWORD_TRUE.equals(iterator.getNext().getType())){
            iterator.next();
            return new BooleanNode(new Token(Type.BOOLEAN, true));

        }

        if(Type.KEYWORD_FALSE.equals(iterator.getNext().getType())){
            iterator.next();
            return new BooleanNode(new Token(Type.BOOLEAN, false));
        }

        if(Type.KEYWORD_NOT.equals(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode value = this.parse(iterator);
            return new UnaryOperationNode(value, token);
        }

        if(Type.LPAREN.equals(iterator.getNext().getType())){
            iterator.next();
            ASTNode node = this.parse(iterator);
            if(Type.RPAREN.equals(iterator.getNext().getType())){
                iterator.next();
            }
            return node;
        }

        ASTNode left;

        left = arithmeticExpressionParser.parse(iterator);

        while(canParserType.contains(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode right = arithmeticExpressionParser.parse(iterator);
            left = new BinaryOperationNode(left, right, token);
        }

        return left;
    }
}
