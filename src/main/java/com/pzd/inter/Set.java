package com.pzd.inter;

import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/22
 * @apiNote 实现了左部为标识符且右部为一个表达式的赋值语句
 */
public class Set extends Stmt {
    public Id id;
    public Expr expr;

    public Set(Id i, Expr x) {
        id = i;
        expr = x;
        if (check(id.type, expr.type) == null) {
            error("type error");
        }
    }

    public Type check(Type p1, Type p2) {
        if (Type.numeric(p1) && Type.numeric(p2)) {
            return p2;
        } else if (p1 == Type.Bool && p2 == Type.Bool) {
            return p2;
        }
        return null;
    }

    @Override
    public void gen(int b, int a) {
        emit(id.toString() + " = " + expr.gen().toString());
    }
}
