package com.pzd.inter;

import com.pzd.lexer.Token;
import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote
 */
public class Op extends Expr {
    public Op(Token tok, Type p) {
        super(tok, p);
    }

    @Override
    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString() + "=" + x.toString());
        return t;
    }
}
