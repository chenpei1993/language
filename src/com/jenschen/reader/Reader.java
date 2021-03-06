package com.jenschen.reader;

import com.jenschen.exception.IllegalFileException;

import java.io.IOException;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 05:31 2021/4/2
 */
public interface Reader {

    String getText() throws IOException, IllegalFileException;
}
