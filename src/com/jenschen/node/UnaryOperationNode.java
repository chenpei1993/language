package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.Token;
import com.jenschen.node.operation.UnaryOperationFactory;

import java.util.function.Function;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 10:35 2021/4/2
 */
public class UnaryOperationNode implements ASTNode{
    private ASTNode value;

    private Token token;

    public UnaryOperationNode(ASTNode value, Token token){
        this.value = value;
        this.token = token;
    }

    @Override
    public Token operation() throws OperationException {
        Token v = value.operation();
        Function f = UnaryOperationFactory.getOperation(v.getType(), token.getType());
        return (Token) f.apply(v);
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Token v = value.operation(context);
        Function f = UnaryOperationFactory.getOperation(v.getType(), token.getType());
        return (Token) f.apply(v);
    }

    @Override
    public String toString() {
        return "UnaryOperationNode{" +
                "value=" + value +
                ", token=" + token +
                '}';
    }
}
