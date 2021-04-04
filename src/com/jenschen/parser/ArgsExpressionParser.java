package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.node.ArgsOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 11:58 2021/4/4
 */
public class ArgsExpressionParser implements Parser{
    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {
        List<Token> args = new ArrayList<>();
        while(!Type.RPAREN.equals(iterator.getNext().getType())){
            args.add(iterator.next());
        }
        return new ArgsOperationNode(args);
    }
}
