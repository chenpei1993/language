package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.Interpretor.SymbolTable;
import com.jenschen.token.Token;
import com.jenschen.token.Type;
import com.jenschen.token.ValueToken;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:35 2021/4/2
 */
public class VariableAssignNode implements ASTNode{
    private Token variable;

    private ASTNode right;

    private Type attr;

    public VariableAssignNode(Token variable, ASTNode right){
        this.variable = variable;
        this.right = right;
        this.attr = variable.getType();
    }

    public VariableAssignNode(Token variable, ASTNode right, Type attr){
        this.variable = variable;
        this.right = right;
        this.attr = attr;
    }

    @Override
    public Token operation() throws OperationException {
        Token right = this.right.operation();
        String key = (String) variable.getValue();
        SymbolTable.setGlobalVariableMap(key, right);
        return variable;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {
        Token right = this.right.operation(context);
        String key = (String) variable.getValue();

        if(Type.KEYWORD_CONST.equals(attr)){
            context.setGlobalVariable(key, right);
        }else{
            context.setVariable(key, right);
        }
        return variable;
    }

    @Override
    public String toString() {
        return "VariableAssignNode{" +
                "variable=" + variable +
                ", right=" + right +
                '}';
    }
}
