package com.example.projecteuler;

import java.util.HashMap;
import java.util.Scanner;

public class Problem21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        HashMap<Integer, Long> sumUnderN = new HashMap<>();

        long sum = 0;
        for (int j = 1; j < 100000; j++) {
            long b = getSumOfProperDivisors(j);
            long db = getSumOfProperDivisors(b);
            if (j != b && j == db) {
                sum += j;
                sumUnderN.put(j, sum);
            } else sumUnderN.put(j, sum);
        }

        for (int i = 0; i < tests; i++) {
            int n = in.nextInt();
            System.out.println(sumUnderN.get(n));
        }
    }

    private static long getSumOfProperDivisors(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int maxD = (int) Math.sqrt(n);
        long sum = 1;
        for (int i = 2; i <= maxD; i++) {
            if (n % i == 0) {
                sum += i;
                long d = n / i;
                if (d != i)
                    sum += d;
            }
        }
        return sum;
    }
}
