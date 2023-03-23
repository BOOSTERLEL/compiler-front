package com.pzd.inter;

import com.pzd.lexer.Tag;
import com.pzd.lexer.Word;
import com.pzd.symbols.Type;

/**
 * @author PENG_Zhengda
 * @date 2023/3/21
 * @apiNote
 */
public class Access extends Op {
    public Id array;
    public Expr index;

    public Access(Id a, Expr i, Type p) {   //p是将数组平坦化后的元素类型
        super(new Word("[]", Tag.INDEX), p);
        array = a;
        index = i;
    }

    @Override
    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    @Override
    public void jumping(int t, int f) {
        emitJumps(reduce().toString(), t, f);
    }

    @Override
    public String toString() {
        return array.toString() + " [ " + index.toString() + " ] ";
    }
}
