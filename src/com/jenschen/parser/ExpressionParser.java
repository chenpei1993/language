package com.jenschen.parser;

import com.jenschen.Interpretor.FuncTable;
import com.jenschen.exception.ParserException;
import com.jenschen.node.*;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
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

    private static Parser whileExpressionParser = new WhileExpressionParser();

    private static Parser funcExpressionParser = new FuncExpressionParser();

    private static Parser callFuncExpressionParser = new CallFuncExpressionParser();


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
            return localVariableParser.parse(iterator);
        }

        if(Type.KEYWORD_CONST.equals(iterator.getNext().getType())){
            return localVariableParser.parse(iterator);
        }

        if(Type.KEYWORD_WHILE.equals(iterator.getNext().getType())){
            return whileExpressionParser.parse(iterator);
        }

        if(Type.KEYWORD_FUNC.equals(iterator.getNext().getType())){
            return funcExpressionParser.parse(iterator);

        }
        if(Type.IDENTIFIER.equals(iterator.getNext().getType())){
            Token identifier = iterator.next();

            if(Type.LPAREN.equals(iterator.getNext().getType())){
                return callFuncExpressionParser.parse(identifier, iterator);
            }

            if(!Type.EQ.equals(iterator.getNext().getType())){
                return new VariableAccessNode(identifier);
            }
            iterator.next(); // skip =
            ASTNode node = compareExpressionParser.parse(iterator);
            return new VariableAssignNode(identifier, node);
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
