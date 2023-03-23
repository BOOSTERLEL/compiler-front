package com.pzd.inter;

import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/22
 * @apiNote
 */
public class Do extends Stmt {
    Expr expr;
    Stmt stmt;

    public Do() {
        expr = null;
        stmt = null;
    }

    public void init(Stmt s, Expr x) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in do");
        }
    }

    @Override
    public void gen(int b, int a) {
        // 保存标号a
        after = a;
        // 用于expr标号
        int label = newLabel();
        stmt.gen(b, label);
        emitLabel(label);
        expr.jumping(b, 0);
    }
}
