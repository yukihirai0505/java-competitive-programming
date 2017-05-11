package com.example.originalLanguage.svm1;

/**
 * ALU is Arithmetic Logic Unit for only add and multiply
 * Created by Yuky on 2017/05/10.
 */
public class Alu {
    public byte add(byte a, byte b) {
        return (byte)(a + b);
    }
    public byte multiply(byte a, byte b) {
        return (byte)(a * b);
    }
}
