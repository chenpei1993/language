package com.jenschen.node;

import com.jenschen.Interpretor.Context;
import com.jenschen.exception.NotFoundVariableException;
import com.jenschen.exception.OperationException;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:06 2021/4/2
 */
public interface Operation {

    Token operation() throws OperationException;

    Token operation(Context context) throws OperationException, NotFoundVariableException;
}
