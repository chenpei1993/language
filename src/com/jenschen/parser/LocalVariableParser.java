package com.jenschen.parser;

import com.jenschen.exception.IllegalExpressionException;
import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.VariableAssignNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:17 2021/4/2
 */
public class LocalVariableParser implements Parser{

    private static  Parser compareExpressionParser = new CompareExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {


        if(!Type.IDENTIFIER.equals(iterator.getNext().getType())){
            throw new IllegalExpressionException("Local Variable");
        }

        Token variableName = iterator.next();

        if(!Type.EQ.equals(iterator.getNext().getType())){
            throw new IllegalExpressionException("Local Variable");
        }
        iterator.next();

        ASTNode right = compareExpressionParser.parse(iterator);

        return new VariableAssignNode(variableName, right);
    }
}
