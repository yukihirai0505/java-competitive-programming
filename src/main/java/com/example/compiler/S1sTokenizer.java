package com.example.compiler;

import java.util.Iterator;

/**
 * Created by Yuky on 2017/05/11.
 */
public class S1sTokenizer implements Iterator {
    private ScannerLine sline;

    public S1sTokenizer(String s) {
        sline = new ScannerLine(s);
    }

    @Override
    public boolean hasNext() {
        sline.cutWhitespace();
        return sline.hasNext();
    }

    @Override
    public Token next() {
        Token token = null;
        int index = sline.getIndex();
        char ch = sline.peek();
        if (Character.isDigit(ch)) {
            double n = 0;
            while (sline.hasNext() && Character.isDigit(ch)) {
                n = n * 10 + Double.parseDouble(Character.toString(sline.next()));
                ch = sline.peek();
            }
            token = new Token(TokenUtil.NUMBER, n);
        } else if (Character.isLetter(ch)) {
            StringBuilder sb = new StringBuilder();
            while (sline.hasNext() && Character.isLetter(ch)) {
                ch = sline.next();
                sb.append(ch);
                ch = sline.peek();
            }
            String s = sb.toString();
            if (TokenUtil.isKeyword(s)) {
                token = new Token(TokenUtil.KETWORD, s);
            } else {
                token = new Token(TokenUtil.IDENTIFIER, s);
            }
        } else {
            switch (ch) {
                case '{':
                    token = new Token(TokenUtil.L_BRACE, sline.next());
                    break;
                case '}':
                    token = new Token(TokenUtil.R_BRACE, sline.next());
                    break;
                case '(':
                    token = new Token(TokenUtil.L_PAREN, sline.next());
                    break;
                case ')':
                    token = new Token(TokenUtil.R_PAREN, sline.next());
                    break;
                case '+':
                case '-':
                    token = new Token(TokenUtil.OPE_AS, sline.next());
                    break;
                case '*':
                case '/':
                    token = new Token(TokenUtil.OPE_MD, sline.next());
                    break;
                default:
                    token = new Token(TokenUtil.ERROR, sline.next());
            }
        }
        token.setIndexNumber(index);
        return token;
    }

    public void remove() {

    }
}
