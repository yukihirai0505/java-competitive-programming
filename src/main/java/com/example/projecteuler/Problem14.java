package com.example.projecteuler;

import java.util.Scanner;

public class Problem14 {

    // if N = 5000000, the max value is 3732423
    private static final int MAX_VALUE = 3732423;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int max = 0;
        int result = 0;
        int[] arr = new int[(int) (5 * Math.pow(10, 6) + 1)];
        for (int i = 2; i <= MAX_VALUE; i++) {
            int count = getCnt(i);
            if (count > max) {
                max = count;
                result = i;
            } else if (max == count) {
                result = i;
            }

            arr[i] = result;
        }

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            if (N > MAX_VALUE) {
                System.out.println(MAX_VALUE);
            } else {
                System.out.println(arr[N]);
            }
        }
    }

    private static int getCnt(long num) {
        int i = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                i++;
                num = num / 2;
            } else {
                i++;
                num = num * 3 + 1;
            }
        }
        return i;
    }
}
