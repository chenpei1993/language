package com.jenschen.parser;

import com.jenschen.exception.IllegalExpressionException;
import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.VariableAssignNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:17 2021/4/2
 */
public class LocalVariableParser implements Parser{

    private static ExpressionParser expressionParser = new ExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {


        if(!Type.IDENTIFIER.equals(iterator.getNext().getType())){
            throw new IllegalExpressionException();
        }

        Token variableName = iterator.next();

        if(!Type.EQ.equals(iterator.getNext().getType())){
            throw new IllegalExpressionException();
        }
        iterator.next();

        ASTNode right = expressionParser.parse(iterator);

        return new VariableAssignNode(variableName, right);
    }
}
