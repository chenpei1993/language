package com.jenschen.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 07:21 2021/4/2
 */
public class ConsoleReader implements Reader{

    @Override
    public String getText() throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String str = scanner.readLine();
        return str;
    }
}
