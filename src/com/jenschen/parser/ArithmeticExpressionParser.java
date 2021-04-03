package com.jenschen.parser;

import com.jenschen.exception.ParserException;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.parser.node.BinaryOperationNode;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;
import com.jenschen.token.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 08:12 2021/4/2
 */
public class ArithmeticExpressionParser implements Parser {

    private static List<Type> canParserType = new ArrayList<>();

    static{
        canParserType.add(Type.PLUS);
        canParserType.add(Type.MINUS);
    }

    private static TermParser termParser = new TermParser();
//    private static LocalVariableParser localVariableParser = new LocalVariableParser();


    @Override
    public ASTNode parse(TokenIterator iterator) throws ParserException {

//        if(Type.VARIABLE.equals(iterator.getNext().getType())){
//            Token token = iterator.next();
//
//            ASTNode node = null;
//            if(Type.KEYWORD_LET.is((String) token.getValue())){
//                node = localVariableParser.parse(iterator);
//            }else if(Type.KEYWORD_CONST.is((String) token.getValue())){
//                node = localVariableParser.parse(iterator);
//            }
//
//            return new VariableAccessNode(token, node);
//        }


        ASTNode left;

        left = termParser.parse(iterator);

        while(canParserType.contains(iterator.getNext().getType())){
            Token token = iterator.next();
            ASTNode right = termParser.parse(iterator);
            left = new BinaryOperationNode(left, right, token);
        }

        return left;
    }

}
