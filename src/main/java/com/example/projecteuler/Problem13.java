package com.example.projecteuler;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem13 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            sum = sum.add(scanner.nextBigInteger());
        }
        System.out.println(sum.toString().substring(0, 10));
    }
}
