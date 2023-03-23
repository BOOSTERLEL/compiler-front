package com.pzd.inter;

import com.pzd.lexer.Word;
import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote
 */
public class Id extends Expr {
    // 相对地址
    public int offset;

    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }
}
