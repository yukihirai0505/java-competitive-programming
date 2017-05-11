package com.example.compiler;

/**
 * Created by Yuky on 2017/05/11.
 */
public class Svm1c {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Svm1c <source file>");
            return;
        }
        String fileName = args[0];
        Compiler compiler = new Compiler();
        try {
            compiler.compile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
