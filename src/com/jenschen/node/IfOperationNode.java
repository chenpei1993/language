package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NoElseException;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.EmptyToken;
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
        return new EmptyToken();
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Token t = compareNode.operation(context);

        if(!(t.getValue() instanceof Boolean)){
            throw new NoElseException();
        }

        boolean r = (boolean) t.getValue();
        if(r){
            return thenNode.operation(context);
        }else{
            if(elseNode != null){
                return elseNode.operation(context);
            }
        }
        return new EmptyToken();
    }

    @Override
    public String toString() {
        return "IfOperationNode{" +
                "token=" + token +
                ", compareNode=" + compareNode +
                ", thenNode=" + thenNode +
                ", elseNode=" + elseNode +
                '}';
    }
}
