package com.jenschen.node;

import com.jenschen.exception.OperationException;
import com.jenschen.parser.VariableTable;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 15:35 2021/4/2
 */
public class VariableAssignNode implements ASTNode{
    private Token variable;

    private ASTNode right;

    public VariableAssignNode(Token variable, ASTNode right){
        this.variable = variable;
        this.right = right;
    }

    @Override
    public Token operation() throws OperationException {
        Token right = this.right.operation();
        String key = (String) variable.getValue();
        VariableTable.setGlobalVariableMap(key, right);
        return variable;
    }
}
