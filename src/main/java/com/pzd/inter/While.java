package com.pzd.inter;

import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/22
 * @apiNote
 */
public class While extends Stmt {
    Expr expr;
    Stmt stmt;

    public While() {
        expr = null;
        stmt = null;
    }

    public void init(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in while");
        }
    }

    @Override
    public void gen(int b, int a) {
        // 保存标号a
        after = a;
        expr.jumping(0, a);
        // 用于stmt标号
        int label = newLabel();
        emitLabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
