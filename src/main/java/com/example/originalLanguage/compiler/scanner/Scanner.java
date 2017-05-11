package com.example.originalLanguage.compiler.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class Scanner {
    private String fieldName;
    private int current;
    private BufferedReader reader;

    public Scanner(String fieldName) throws IOException {
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
                Iterator<Token> tokenizer = new S1sTokenizer(s);
                while (tokenizer.hasNext()) {
                    Token token = tokenizer.next();
                    token.setLineNumber(current);
                    tokenList.add(token);
                }
            }
        }
        return tokenList;
    }
}
