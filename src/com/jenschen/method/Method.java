package com.jenschen.method;

import com.jenschen.Interpretor.Context;
import com.jenschen.node.ASTNode;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 21:16 2021/4/4
 */
public interface Method {
    public Token run(Context context, ASTNode argsNode);
}
