package com.jenschen;

import com.jenschen.lexer.Lexer;
import com.jenschen.reader.ConsoleReader;
import com.jenschen.token.Token;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        try{
            while(true){
                System.out.println("input: ");
                String context = reader.getText();
                System.out.println(context);
                Lexer lexer = new Lexer(context);
                List<Token> tokens = lexer.lexerText();
                System.out.println(tokens);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
