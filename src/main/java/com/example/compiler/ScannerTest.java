package com.example.compiler;


import java.io.IOException;
import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class ScannerTest {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java ScannerTest <fileName>");
            return;
        }
        try {
            Scanner scanner = new Scanner(args[0]);
            List<Token> tokenList = scanner.createTokenList();
            for (Token t: tokenList) {
                System.out.println("--------");
                System.out.println(TokenUtil.toPrintFormat(t));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
