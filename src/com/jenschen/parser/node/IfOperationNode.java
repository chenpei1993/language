package com.jenschen.parser.node;

import com.jenschen.exception.NoElseException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 16:19 2021/4/3
 */
public class IfOperationNode implements ASTNode, Operation {
    private Token token;

    private ASTNode compareNode;

    private ASTNode thenNode;

    private ASTNode elseNode;

    public IfOperationNode(Token token,ASTNode compareNode, ASTNode thenNode,ASTNode elseToken){
        this.token = token;
        this.compareNode = compareNode;
        this.thenNode = thenNode;
        this.elseNode = elseToken;
    }

    @Override
    public Token operation() throws OperationException {

        Token t = compareNode.operation();

        if(!(t.getValue() instanceof Boolean)){
            throw new NoElseException();
        }

        boolean r = (boolean) t.getValue();
        if(r){
            return thenNode.operation();
        }else{
            if(elseNode != null){
                return elseNode.operation();
            }
        }
        return null;
    }
}
