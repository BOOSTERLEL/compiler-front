package com.pzd.inter;

import com.pzd.lexer.Word;
import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote 临时名字
 */
public class Temp extends Expr {
    static int count = 0;
    int number = 0;

    public Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    @Override
    public String toString() {
        return "t" + number;
    }
}
