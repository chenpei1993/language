package com.jenschen.Interpretor;

import com.jenschen.token.Token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 13:15 2021/4/4
 */
public interface ISymbolTable {

    Token getVariable(String key);

    void setVariable(String key, Token value);
}
