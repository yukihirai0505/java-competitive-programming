package com.example.projecteuler;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem16 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> cache = new ArrayList<>();
        int length = 10000;
        int res = 0;
        int[] a = new int[length + 1];
        cache.add(1);
        int carry = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < cache.size(); j++) {
                if (cache.get(j) * 2 + carry < 10) {
                    cache.set(j, cache.get(j) * 2 + carry);
                    res += cache.get(j);
                    carry = 0;
                } else {
                    cache.set(j, (cache.get(j) * 2 + carry) % 10);
                    res += cache.get(j);
                    carry = 1;
                }
                if (carry == 1 && j == cache.size() - 1) {
                    res += carry;
                    cache.add(carry);
                    carry = 0;
                    break;
                }
            }
            a[i + 1] = res;
            res = 0;
        }

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(a[scanner.nextInt()]);
        }
        scanner.close();
    }
}
