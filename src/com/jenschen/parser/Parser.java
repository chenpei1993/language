package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.node.ASTNode;
import com.jenschen.token.TokenIterator;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:15 2021/4/2
 */
public interface Parser {

    ASTNode parse(TokenIterator iterator) throws ParserException;
}
