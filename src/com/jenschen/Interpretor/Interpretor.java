package com.jenschen.Interpretor;

import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.node.ASTNode;
import com.jenschen.token.Token;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 12:30 2021/4/4
 */
public class Interpretor implements Program{

    private Context currentContext;

    private List<ASTNode> nodes;

    public Interpretor(Context context, List<ASTNode> nodes){
        this.currentContext = context;
        this.nodes = nodes;
    }

    @Override
    public void run() {
        try{
            Iterator<ASTNode> nodeIterator = nodes.iterator();
            while(nodeIterator.hasNext()){
                ASTNode node = nodeIterator.next();
                Token answer = node.operation(currentContext);
//                System.out.println("result " + answer.getValue());
            }
        }catch (OperationException e) {
            e.printStackTrace();
        } catch (NotFoundVariableException e) {
            e.printStackTrace();
        }
    }
}
