package com.jenschen.parser;

import com.jenschen.Interpretor.FuncTable;
import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.CallFuncOperationNode;
import com.jenschen.node.VariableAccessNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:14 2021/4/4
 */
public class CallFuncExpressionParser implements Parser{

    private Parser expressionParser = new ExpressionParser();

    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        Token funcToken = iterator.next();
        return parse(funcToken, iterator);
    }

    @Override
    public ASTNode parse(Token t, TokenIterator iterator) throws ParserException {
        String funcName = (String) t.getValue();

        ASTNode functionNode = FuncTable.getFunc(funcName);
        if(!Type.LPAREN.equals(iterator.getNext().getType())){

        }
        iterator.next(); // skip (
        List<ASTNode> args = new ArrayList<>();
        while(!Type.RPAREN.equals(iterator.getNext().getType())){
            if(Type.IDENTIFIER.equals(iterator.getNext().getType())){
                args.add(new VariableAccessNode(iterator.next()));
            }else{
                args.add(expressionParser.parse(iterator));
            }

        }

        iterator.next(); //skip )

        return new CallFuncOperationNode(funcName, args, functionNode);
    }

    @Override
    public String toString() {
        return "CallFuncExpressionParser{" +
                "compareExpressionParser=" + expressionParser +
                '}';
    }
}
