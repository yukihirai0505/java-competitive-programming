package com.example.projecteuler;

import java.util.*;

public class Problem23 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        LinkedHashMap<Integer, Long> amicableNumbersMap = new LinkedHashMap<>();
        for (int i = 0; i <= 100000; i++) {
            long sumOfDivisors = getSumOfProperDivisors(i);
            if (sumOfDivisors > i) amicableNumbersMap.put(i, sumOfDivisors);
        }

        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            boolean pairFound = false;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                if (amicableNumbersMap.containsKey(j))
                    list.add(j);
            }

            for (int k = 0; k < list.size(); k++) {
                for (int l = k; l < list.size(); l++) {
                    if (list.get(k) + list.get(l) == n) {
                        pairFound = true;
                        break;
                    }
                }
                if (pairFound) break;
            }
            if (pairFound) System.out.println("YES");
            else System.out.println("NO");
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
