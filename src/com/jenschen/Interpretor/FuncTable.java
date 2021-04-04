package com.jenschen.Interpretor;

import com.jenschen.node.FuncOperationNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 18:04 2021/4/4
 */
public class FuncTable {

    private static final Map<String, FuncOperationNode> funcs = new HashMap<>();

    public static void setFunc(String key, FuncOperationNode operationNode){
        funcs.put(key, operationNode);
    }

    public static FuncOperationNode getFunc(String key){
        if(key == null){
            return null;
        }

        return funcs.get(key);
    }

}
