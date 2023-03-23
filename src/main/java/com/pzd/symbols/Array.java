package com.pzd.symbols;

import com.pzd.lexer.Tag;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote
 */
public class Array extends Type {
    public Type of;     // 数组的元素类型
    public int size = 1;  // 数组个数

    public Array(int sz, Type p) {
        super("[]", Tag.INDEX, sz * p.width);
        size = sz;
        of = p;
    }

    @Override
    public String toString() {
        return "[" + size + "]" + of.toString();
    }
}
