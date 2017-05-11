package com.example.originalLanguage.compiler.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class SplitScanner {
    private String fieldName;
    private int current;
    private BufferedReader reader;

    public SplitScanner(String fieldName) throws IOException {
        this.fieldName = fieldName;
        reader = new BufferedReader(new FileReader(this.fieldName));
        current = 0;
    }

    public List<Token> createTokenList() throws IOException {
        List<Token> tokens = null;
        try {
            tokens = readLines();
        } finally {
            reader.close();
        }
        return tokens;
    }

    private List<Token> readLines() throws IOException {
        List<Token> tokenList = new LinkedList<>();
        String s = null;
        while ((s = reader.readLine()) != null) {
            current++;
            if (s.length() == 0) {
                continue;
            } else {
                for (String st: s.split("\\s")) {
                    if (st.length() == 0) continue;
                    Token token = createToken(st);
                    token.setLineNumber(current);
                    tokenList.add(token);
                }
            }
        }
        return tokenList;
    }

    private Token createToken(String s) {
        Token token = null;
        if (TokenUtil.isKeyword(s)) {
            token = new Token(TokenUtil.KEYWORD, s);
        } else if ("{".equals(s)) {
            token = new Token(TokenUtil.L_BRACE, s);
        } else if ("}".equals(s)) {
            token = new Token(TokenUtil.R_BRACE, s);
        } else if ("(".equals(s)) {
            token = new Token(TokenUtil.L_PAREN, s);
        } else if (")".equals(s)) {
            token = new Token(TokenUtil.R_PAREN, s);
        } else if ("+".equals(s) || "-".equals(s)) {
            token = new Token(TokenUtil.OPE_AS, s);
        } else if ("*".equals(s) || "/".equals(s)) {
            token = new Token(TokenUtil.OPE_MD, s);
        } else {
            char ch = s.charAt(0);
            if (Character.isDigit(ch)) {
                try {
                    double n = Double.parseDouble(s);
                    token = new Token(TokenUtil.NUMBER, n);
                } catch (NumberFormatException e) {
                    token = new Token(TokenUtil.ERROR, s);
                }
            } else if (Character.isLetter(ch)) {
                token = new Token(TokenUtil.IDENTIFIER, s);
            } else {
                token = new Token(TokenUtil.ERROR, s);
            }
        }
        return token;
    }
}
