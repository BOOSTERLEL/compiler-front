package com.pzd.lexer;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote 浮点数
 */
public class Real extends Token {
    public final float value;

    public Real(float v) {
        super(Tag.REAL);
        value = v;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
