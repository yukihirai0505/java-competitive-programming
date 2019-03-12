package com.example.projecteuler;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem20 {

    private static int findSumOfDigits(int n) {
        ArrayList<Integer> cache = new ArrayList<>();
        cache.add(1);
        for (int i = 1; i <= n; i++) {
            int carry = 0;
            int size = cache.size();
            for (int j = 0; j < size; j++) {
                int res = carry + cache.get(j) * i;
                cache.set(j, res % 10);
                carry = res / 10;
            }
            while (carry != 0) {
                cache.add(carry % 10);
                carry /= 10;
            }
        }
        int sum = 0;
        for (Integer v : cache) sum += v;
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(findSumOfDigits(scanner.nextInt()));
        }
        scanner.close();
    }
}
