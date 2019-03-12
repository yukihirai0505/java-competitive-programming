package com.example.projecteuler;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Problem15 {

    private static long factorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println(factorial(N + M) / (factorial(M) * factorial(N)) % 1000000007);
        }
        scanner.close();
    }
}
