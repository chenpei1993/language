package com.jenschen.parser;

import com.jenschen.Interpretor.FuncTable;
import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.EmptyNode;
import com.jenschen.node.FuncOperationNode;
import com.jenschen.token.EmptyToken;
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

    private static Parser expressionParser = new ExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        iterator.next();
        Token methodName = iterator.next();

        if(!Type.LPAREN.equals(iterator.getNext().getType())){

        }
        iterator.next(); // skip (

        ASTNode argsNode = null;
        if(!Type.RPAREN.equals(iterator.getNext().getType())){
            argsNode = argsExpressionParser.parse(iterator);
        }
        iterator.next(); // skip )
        iterator.next(); // skip then

        List<ASTNode> bodyNode = new ArrayList<>();
        while(!Type.KEYWORD_END.equals(iterator.getNext().getType())){
            ASTNode node = expressionParser.parse(iterator);
            bodyNode.add(node);
        }

        iterator.next(); // end;
        FuncOperationNode func = new FuncOperationNode(methodName, argsNode, bodyNode);
        String name = (String) methodName.getValue(); 
        FuncTable.setFunc(name, func);
        return new EmptyNode();
    }
}
