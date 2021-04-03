package com.jenschen;

import com.jenschen.lexer.Lexer;
import com.jenschen.parser.ExpressionParser;
import com.jenschen.parser.Parser;
import com.jenschen.node.ASTNode;
import com.jenschen.reader.ConsoleReader;
import com.jenschen.reader.FilePathReader;
import com.jenschen.reader.Reader;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
//        Reader reader = new FilePathReader();
        try{
            while(true){
                String context = reader.getText();
//                System.out.println(context);
                if(context == null || context.isEmpty()){
                    return;
                }
                Lexer lexer = new Lexer(context);
                List<Token> tokens = lexer.lexerText();
                System.out.println(tokens);
                TokenIterator iterator = new TokenIterator(tokens);
                Parser parser = new ExpressionParser();
                ASTNode node = parser.parse(iterator);
                System.out.println(node.toString());
                Token answer = node.operation();
                System.out.println("result " + answer.getValue());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
