package com.example.projecteuler;


import java.util.*;

public class Problem29 {

    private static Scanner scanner = new Scanner(System.in);

    private static List<Integer> calculateDuplicates(int b, int n) {
        int[] duplicates = new int[n - 1];
        for (int i = 2; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j < i; j++) {
                for (int k = 2; k <= j * b / i; k++) {
                    if ((i * k) % j == 0) {
                        set.add(k);
                    }
                }
            }
            duplicates[i - 2] = set.size();
        }

        List<Integer> list = new ArrayList<>();
        list.add(duplicates[0]);
        for (int i = 1; i < duplicates.length; i++) {
            list.add(duplicates[i] + list.get(i - 1));
        }
        return list;
    }

    private static long distinctPowers(int a, int b) {

        long total = (long) (a - 1) * (b - 1);
        int sqrta = (int) Math.sqrt(a);
        int log2a = (int) (Math.log(a) / Math.log(2));
        List<Integer> duplicatesSum = calculateDuplicates(b, log2a);
        Set<Integer> visited = new HashSet<>();

        for (int i = 2; i <= sqrta; i++) {
            if (!visited.contains(i)) {
                int logia = intLog(a, i);
                total -= duplicatesSum.get(logia - 2);
                for (int j = 2; j <= logia; j++) {
                    visited.add((int) Math.pow(i, j));
                }
            }
        }
        return total;
    }

    private static int intLog(int n, int base) {
        int start = 0;
        while (Math.pow(base, start) <= n) start += 1;
        return start - 1;
    }

    public static void main(String[] args) {
        int N = scanner.nextInt();
        System.out.println(distinctPowers(N, N));
    }
}