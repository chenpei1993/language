package com.jenschen.node;

import com.jenschen.exception.OperationException;
import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:06 2021/4/2
 */
public interface Operation {

    Token operation() throws OperationException;
}
