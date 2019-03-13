package com.example.projecteuler;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem28 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            BigInteger n = scanner.nextBigInteger();
            n = n.subtract(BigInteger.valueOf(1));
            n = n.divide(BigInteger.valueOf(2));

            BigInteger p1 = n.pow(3);
            p1 = p1.multiply(BigInteger.valueOf(16));
            BigInteger p2 = n.pow(2);
            p2 = p2.multiply(BigInteger.valueOf(30));
            BigInteger p3 = n.multiply(BigInteger.valueOf(26));
            BigInteger res = p1.add(p2).add(p3).add(BigInteger.valueOf(3));
            res = res.divide(BigInteger.valueOf(3));
            System.out.println(res.mod(BigInteger.valueOf(1000000007)));
        }
    }
}