package com.jenschen.parser;

import com.jenschen.exception.IllegalExpressionException;
import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.WhileOperationNode;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 17:29 2021/4/3
 */
public class WhileExpressionParser implements Parser {

    private static Parser compareExpressionParser = new CompareExpressionParser();

    private static Parser expressionParser = new ExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        iterator.next(); // skip while
        ASTNode compareNode = compareExpressionParser.parse(iterator);
        iterator.next(); // skip then
        ASTNode expr = expressionParser.parse(iterator);
        if(!Type.KEYWORD_END.equals(iterator.getNext().getType())){
            throw new IllegalExpressionException("WhileExpression");
        }
        iterator.next(); // skip end
        return new WhileOperationNode(compareNode, expr);
    }
}
