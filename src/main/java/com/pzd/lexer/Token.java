package com.pzd.lexer;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote 此法单元类Token
 */
public class Token {
    public final int tag;

    public Token(int t) {
        tag = t;
    }

    @Override
    public String toString() {
        return "" + (char) tag;
    }
}
