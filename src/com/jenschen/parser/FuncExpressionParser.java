package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.FuncOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 11:53 2021/4/4
 */
public class FuncExpressionParser implements Parser{

    private static Parser argsExpressionParser = new ArgsExpressionParser();

    private static Parser compareExpressionParser = new CompareExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        Token methodName = iterator.next();

        if(!Type.LPAREN.equals(iterator.getNext().getType())){

        }
        iterator.next(); // skip (

        ASTNode argsNode = null;
        if(Type.RPAREN.equals(iterator.getNext().getType())){

        }else{
            argsNode = argsExpressionParser.parse(iterator);
        }

        iterator.next(); // skip then

        List<ASTNode> bodyNode = new ArrayList<>();
        while(Type.KEYWORD_END.equals(iterator.getNext().getType())){
            ASTNode node = compareExpressionParser.parse(iterator);
            bodyNode.add(node);
        }
        iterator.next(); // end;

        return new FuncOperationNode(methodName, argsNode, bodyNode);
    }
}
