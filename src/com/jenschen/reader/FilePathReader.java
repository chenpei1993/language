package com.jenschen.reader;

import com.jenschen.exception.IllegalFileException;

import java.io.*;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 17:06 2021/4/3
 */
public class FilePathReader implements Reader{
    @Override
    public String getText() throws IOException, IllegalFileException {
        System.out.println("input a file path: ");
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String filePath = scanner.readLine();
        if(!filePath.endsWith(".cp")){
            throw new IllegalFileException();
        }

        StringBuilder sb = new StringBuilder();
        String str;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            while((str = reader.readLine()) != null){
                sb.append(str);
            }
            return sb.toString();
        }
    }
}
