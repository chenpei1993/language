package com.jenschen.parser;

import com.jenschen.exception.IllegalExpressionException;
import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.IfOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 16:11 2021/4/3
 */
public class IfExpressionParser implements Parser {

    private static Parser expressionParser = new ExpressionParser();
    private static Parser compareParser = new CompareExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {

        if(Type.KEYWORD_IF.equals(iterator.getNext().getType())){
            Token ifToken = iterator.next();
            ASTNode compareNode = compareParser.parse(iterator);
            if(!Type.KEYWORD_THEN.equals(iterator.getNext().getType())){
                throw new IllegalExpressionException("ThenExpression");
            }
            iterator.next();
            ASTNode thenNode = expressionParser.parse(iterator);
            ASTNode elseToken = null;
            if(Type.KEYWORD_ELSE.equals(iterator.getNext().getType())){
                iterator.next();
                elseToken = expressionParser.parse(iterator);
            }
            return new IfOperationNode(ifToken, compareNode, thenNode, elseToken);
        }

        throw new IllegalExpressionException("IfExpression");
    }
}
