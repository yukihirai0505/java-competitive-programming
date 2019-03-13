package com.example.projecteuler;

import java.util.HashMap;
import java.util.Scanner;

public class Problem26 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int[] cycleLengths = new int[10000];

        int maxSize = 0;
        int maxD = 0;
        for (int j = 3; j < 10000; j++) {
            if (isPrime(j) && j % 2 != 0) {
                HashMap<Integer, Integer> seenRemainders = new HashMap<>();
                int num = 1;
                int remainder = num % j;
                while (!seenRemainders.containsKey(remainder)) {
                    seenRemainders.put(remainder, num);
                    num = remainder * 10;
                    remainder = num % j;
                }
                if (seenRemainders.size() > maxSize) {
                    maxSize = seenRemainders.size();
                    maxD = j;
                }
                cycleLengths[j] = maxD;
            } else
                cycleLengths[j] = maxD;
        }

        for (int i = 0; i < T; i++)
            System.out.println(cycleLengths[scanner.nextInt() - 1]);
    }

    private static boolean isPrime(long num) {
        if (num > 2 && num % 2 == 0) return false;
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < top; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
