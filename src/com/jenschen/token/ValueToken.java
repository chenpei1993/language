package com.jenschen.token;

/**
 * @Author: JensChen
 * @Description:
 * @Date: Created in 16:44 2021/4/4
 */
public class ValueToken<T> extends Token{

    private Type attr;

    public ValueToken(Type type, T value, Type attr){
        super(type, value);
        this.attr = attr;
    }

    public boolean isConst(){
        if(attr == null){
            return false;
        }

        if(Type.KEYWORD_CONST.equals(attr)){
            return true;
        }else{
            return false;
        }
    }

    public Type getAttr(){
        return this.attr;
    }
}
