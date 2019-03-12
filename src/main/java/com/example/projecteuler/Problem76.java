package com.example.projecteuler;

import java.util.Scanner;

public class Problem76 {
    private static final int MOD = (int) Math.pow(10, 9) + 7;

    private static long getWays(int n) {
        long[] a = new long[n + 1];
        a[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                a[j] += a[j - i] % MOD;
            }
        }
        return a[n] % MOD;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(getWays(scanner.nextInt()));
        }
        scanner.close();
    }
}
