package com.jenschen.token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 17:01 2021/4/3
 */
public final class NullToken extends Token{

    private final static Type type = Type.NULL;

    private final static String value = "";

    public NullToken() {
        super(type, value);
    }
}
