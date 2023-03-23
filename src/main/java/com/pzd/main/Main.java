package com.pzd.main;

import com.pzd.lexer.Lexer;
import com.pzd.parser.Parser;

import java.io.IOException;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote 编译器前端main方法
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
        System.out.println('\n');
    }
}
