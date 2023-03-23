package com.pzd.inter;

import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/22
 * @apiNote
 */
public class Else extends Stmt {
    Expr expr;
    Stmt stmt1, stmt2;

    public Else(Expr x, Stmt s1, Stmt s2) {
        expr = x;
        stmt1 = s1;
        stmt2 = s2;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    @Override
    public void gen(int b, int a) {
        // label1用于语句stmt1
        int label1 = newLabel();
        // label2用于语句stmt2
        int label2 = newLabel();
        // 为真时控制流穿越到stmt1
        expr.jumping(0, label2);
        emitLabel(label1);
        stmt1.gen(label1, a);
        emit("goto L" + a);
        emitLabel(label2);
        stmt2.gen(label2, a);
    }
}
