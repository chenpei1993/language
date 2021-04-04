package com.jenschen.Interpretor;

import com.jenschen.method.Method;
import com.jenschen.method.PrintMethod;
import com.jenschen.node.FuncOperationNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 21:16 2021/4/4
 */
public class MethodTable {

    private static final Map<String, Method> funcs = new HashMap<>();

    static {
        Method print = new PrintMethod();
        funcs.put("print", print);
    }

    public static void setFunc(String key, Method method){
        funcs.put(key, method);
    }

    public static Method getFunc(String key){
        if(key == null){
            return null;
        }

        return funcs.get(key);
    }
}
