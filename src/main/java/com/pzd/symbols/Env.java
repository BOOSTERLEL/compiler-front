package com.pzd.symbols;

import com.pzd.inter.Id;
import com.pzd.lexer.Token;

import java.util.Hashtable;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote 将字符串词法单元映射为类Id的对象
 */
public class Env {
    private Hashtable table;
    protected Env prev;

    public Env(Env n) {
        table = new Hashtable();
        prev = n;
    }

    public void put(Token w, Id i) {
        table.put(w, i);
    }

    public Id get(Token w) {
        for (Env e = this; e != null; e = e.prev) {
            Id found = (Id) (e.table.get(w));
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
