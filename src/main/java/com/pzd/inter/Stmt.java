package com.pzd.inter;

/**
 * @author PENG_Zhengda
 * @date 2023/3/22
 * @apiNote
 */
public class Stmt extends Node {
    public Stmt() {

    }

    public static Stmt Null = new Stmt();

    /**
     * @param b 语句开始处的标号
     * @param a 语句下一条指令的标号
     */
    public void gen(int b, int a) {

    }

    // 保存语句的下一条指令的标号
    int after = 0;

    // 用于break语句
    public static Stmt Enclosing = Stmt.Null;
}
