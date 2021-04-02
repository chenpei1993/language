package com.jenschen;

import com.jenschen.lexer.Lexer;
import com.jenschen.parser.Parser;
import com.jenschen.parser.ExpressionParser;
import com.jenschen.parser.node.ASTNode;
import com.jenschen.reader.ConsoleReader;
import com.jenschen.token.Token;
import com.jenschen.token.TokenIterator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        try{
//            while(true){
                System.out.println("input: ");
                String context = reader.getText();
//                System.out.println(context);
                Lexer lexer = new Lexer(context);
                List<Token> tokens = lexer.lexerText();
//                System.out.println(tokens);
                TokenIterator iterator = new TokenIterator(tokens);
                Parser parser = new ExpressionParser();
                ASTNode node = parser.parse(iterator);
                System.out.println(node.toString());
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
