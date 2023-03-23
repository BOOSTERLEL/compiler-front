package com.pzd.inter;

import com.pzd.lexer.Num;
import com.pzd.lexer.Token;
import com.pzd.lexer.Word;
import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote
 */
public class Constant extends Expr {
    public Constant(Token tok, Type p) {
        super(tok, p);
    }

    public Constant(int i) {
        super(new Num(i), Type.Int);
    }

    public static final Constant
            True = new Constant(Word.True, Type.Bool),
            False = new Constant(Word.False, Type.Bool);

    @Override
    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" + t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }
}
