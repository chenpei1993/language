package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.CallFuncOperationNode;
import com.jenschen.node.VariableAccessNode;
import com.jenschen.node.VariableAssignNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:11 2021/4/4
 */
public class IdentifierExpressionParser implements Parser {

    private static Parser compareExpressionParser = new CompareExpressionParser();

    private static Parser callFuncExpressionParser = new CallFuncExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
//        Token variable = iterator.next();
//
//        if(Type.EQ.equals(iterator.getNext().getType())){
//            iterator.next(); // skip =
//            ASTNode node = compareExpressionParser.parse(iterator);
//            return new VariableAssignNode(variable, node);
//        }else if(Type.LPAREN.equals(iterator.getNext().getType())){
//            ASTNode body = callFuncExpressionParser.parse(iterator);
//            return new CallFuncOperationNode();
//        }else{
//            return new VariableAccessNode(variable);
//        }
        return null;
    }
}
