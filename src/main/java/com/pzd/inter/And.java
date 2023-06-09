package com.pzd.inter;

import com.pzd.lexer.Token;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote
 */
public class And extends Logical {
    public And(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    @Override
    public void jumping(int t, int f) {
        int label = f != 0 ? f : newLabel();
        expr1.jumping(0, label);
        expr2.jumping(t, f);
        if (f == 0) {
            emitLabel(label);
        }
    }
}
