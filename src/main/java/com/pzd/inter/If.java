package com.pzd.inter;

import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/22
 * @apiNote
 */
public class If extends Stmt {
    Expr expr;
    Stmt stmt;

    public If(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    @Override
    public void gen(int b, int a) {
        // stmt的代码的标号
        int label = newLabel();
        // 为真时控制流穿越，为假时转向a
        expr.jumping(0, a);
        emitLabel(label);
        stmt.gen(label, a);
    }
}
