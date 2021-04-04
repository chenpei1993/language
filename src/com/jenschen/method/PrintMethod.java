package com.jenschen.method;

import com.jenschen.Interpretor.Context;
import com.jenschen.node.ASTNode;
import com.jenschen.node.ArgsOperationNode;
import com.jenschen.token.EmptyToken;
import com.jenschen.token.Token;
import com.jenschen.token.Type;
import com.jenschen.util.StringOperationUtil;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 20:42 2021/4/4
 */
public class PrintMethod implements Method {

    public Token run(Context context, ASTNode argsNode){
        ArgsOperationNode node = null;
        if(argsNode instanceof ArgsOperationNode){
            node = (ArgsOperationNode) argsNode;
        }

        if(argsNode == null){
            System.out.println("");
            return new EmptyToken();
        }
        List<Token> tokens = node.getArgs();
        Iterator<Token> tokenIterator = tokens.listIterator();
        StringBuilder sb = new StringBuilder();
        while (tokenIterator.hasNext()){
            Token t = tokenIterator.next();
            if(Type.IDENTIFIER.equals(t.getType())){
                Token v = context.getVariable((String) t.getValue());
                sb.append((StringOperationUtil.transferToString(v)));
            }else{
                sb.append((StringOperationUtil.transferToString(t)));

            }
        }

        System.out.println(sb.toString());
        return new EmptyToken();
    }
}
