package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.Interpretor.SymbolTable;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.node.ASTNode;
import com.jenschen.token.Token;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:13 2021/4/4
 */
public class CallFuncOperationNode implements ASTNode {

    private String funcName;

    private List<ASTNode> argNodes;

    private ASTNode bodyNode;

    public CallFuncOperationNode(String funcName, List<ASTNode> argNodes, ASTNode bodyNodes){
        this.funcName = funcName;
        this.argNodes = argNodes;
        this.bodyNode = bodyNodes;
    }

    @Override
    public Token operation() throws OperationException {
        return null;
    }

    @Override
    public Token operation(Context context) throws OperationException, NotFoundVariableException {

        Context newContext = new Context(new SymbolTable(), null);

        ArgsOperationNode argsIdentifierNode = null;
        if(bodyNode != null && bodyNode instanceof FuncOperationNode){
            argsIdentifierNode = ((FuncOperationNode) bodyNode).getArgsNode();
        }

        List<Token> identifierTokens = new ArrayList<>();
        if(argsIdentifierNode != null){
            identifierTokens = argsIdentifierNode.getArgs();
        }
        if(identifierTokens.size() != argNodes.size()){
            throw new OperationException("arg size is wrong");
        }
        Iterator<ASTNode> argsIterator = argNodes.iterator();
        Iterator<Token> identifierIterator = identifierTokens.iterator();
        List<String> globalVariable = new ArrayList<>();
        if(argNodes != null){
            while(argsIterator.hasNext() && identifierIterator.hasNext()){
                Token value = argsIterator.next().operation(context);
                String name = (String) identifierIterator.next().getValue();
                if(SymbolTable.getGlobalVariableMap(name) != null){
                    globalVariable.add(name);
                }
                newContext.setVariable(name, value);
            }
        }

        Token res = bodyNode.operation(newContext);

        Iterator<String> variableIterator = globalVariable.listIterator();
        while(variableIterator.hasNext()){
            String name = variableIterator.next();
            Token t = newContext.getVariable(name);
            SymbolTable.setGlobalVariableMap(name ,t);
        }

        return res;
    }
}
