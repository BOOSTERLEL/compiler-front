package com.pzd.inter;

import com.pzd.lexer.Token;
import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote 单目运算符
 */
public class Unary extends Op {
    public Expr expr;

    /**
     * 处理单目减法，对 ! 的处理见Not
     *
     * @param tok token
     * @param x   expr
     */
    public Unary(Token tok, Expr x) {
        super(tok, null);
        expr = x;
        type = Type.max(Type.Int, expr.type);
        if (type == null) {
            error("error type");
        }
    }

    @Override
    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    @Override
    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
