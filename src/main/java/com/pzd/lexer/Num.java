package com.pzd.lexer;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote Token子类Num
 */
public class Num extends Token {
    public final int value;

    public Num(int v) {
        super(Tag.NUM);
        value = v;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
