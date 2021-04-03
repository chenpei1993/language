package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.BinaryOperationNode;
import com.jenschen.parser.node.UnaryOperationNode;
import com.jenschen.parser.node.VariableAccessNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:47 2021/4/3
 */
public class ExpressionParser implements Parser {

    private static Parser localVariableParser = new LocalVariableParser();

    private static Parser compareExpressionParser = new CompareExpressionParser();

    private static Parser ifExpressionParser = new IfExpressionParser();

    private static List<Type> canParserType = new ArrayList<>();
    static {
        canParserType.add(Type.KEYWORD_AND);
        canParserType.add(Type.KEYWORD_OR);
    }

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {

        if(Type.KEYWORD_IF.equals(iterator.getNext().getType())){
            ASTNode token = ifExpressionParser.parse(iterator);
            return token;
        }

        if(Type.KEYWORD_LET.equals(iterator.getNext().getType())){
            Token token = iterator.next();

            ASTNode node = null;
            if(Type.KEYWORD_LET.is((String) token.getValue())){
                node = localVariableParser.parse(iterator);
            }else if(Type.KEYWORD_CONST.is((String) token.getValue())){
                node = localVariableParser.parse(iterator);
            }

            return new VariableAccessNode(token, node);
        }

        if(Type.LOGIC_NOT.equals(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode value = compareExpressionParser.parse(iterator);
            return new UnaryOperationNode(value, token);
        }

        ASTNode left = compareExpressionParser.parse(iterator);
        while(canParserType.contains(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode right = compareExpressionParser.parse(iterator);
            left = new BinaryOperationNode(left, right, token);
        }

        return left;
    }
}
