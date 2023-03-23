package com.pzd.lexer;

import com.pzd.symbols.Type;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author PENG_Zhengda
 * @date 2023/3/20
 * @apiNote 词法分析器
 */
public class Lexer {
    public static int line = 1;
    char peek = ' ';
    Hashtable words = new Hashtable();

    void reserve(Word w) {
        words.put(w.lexeme, w);
    }

    public Lexer() {
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("dp", Tag.DO));
        reserve(new Word("break", Tag.BREAK));

        reserve(Word.True);
        reserve(Word.False);

        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
    }

    void readCh() throws IOException {
        peek = (char) System.in.read();
    }

    boolean readCh(char c) throws IOException {
        readCh();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for (; ; readCh()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }
        switch (peek) {
            case '&':
                if (readCh('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readCh('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readCh('=')) {
                    return Word.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readCh('=')) {
                    return Word.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readCh('=')) {
                    return Word.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readCh('=')) {
                    return Word.le;
                } else {
                    return new Token('>');
                }
        }
        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                readCh();
            } while (Character.isDigit(peek));
            if (peek != '.') {
                return new Num(v);
            }
            float x = v;
            float d = 10;
            for (; ; ) {
                readCh();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d *= 10;
            }
            return new Real(x);
        }
        if (Character.isLetter(peek)) {
            StringBuffer sb = new StringBuffer();
            do {
                sb.append(peek);
                readCh();
            } while (Character.isLetter(peek));
            String s = sb.toString();
            Word w = (Word) words.get(s);
            if (w != null) {
                return w;
            }
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }
        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }
}
