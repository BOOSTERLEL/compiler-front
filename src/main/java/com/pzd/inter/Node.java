package com.pzd.inter;

import com.pzd.lexer.Lexer;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote 抽象语法树的结点
 */
public class Node {
    int lexLine = 0;

    Node() {
        lexLine = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line" + lexLine + ": " + s);
    }

    static int labels = 0;

    public int newLabel() {
        return ++labels;
    }

    public void emitLabel(int i) {
        System.out.println("L" + i + ":");
    }

    public void emit(String s) {
        System.out.println("\t" + s);
    }
}
