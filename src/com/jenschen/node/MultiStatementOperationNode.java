package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.Interpretor.SymbolTable;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.exception.ParserException;
import com.jenschen.parser.Parser;
import com.jenschen.token.EmptyToken;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:09 2021/4/4
 */
public class MultiStatementOperationNode implements ASTNode {

    private List<ASTNode> nodes;

    public MultiStatementOperationNode(List<ASTNode> nodes){
        this.nodes = nodes;
    }


    @Override
    public Token operation() throws OperationException {
        return null;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        if(nodes.isEmpty()){
            return new EmptyToken();
        }

        Token answser = new EmptyToken();
        Iterator<ASTNode> iterator = nodes.iterator();
        while(iterator.hasNext()){
            answser = iterator.next().operation(context);
        }
        return answser;
    }
}
