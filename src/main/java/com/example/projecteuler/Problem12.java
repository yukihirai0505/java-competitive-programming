package com.example.projecteuler;

import java.util.Scanner;

public class Problem12 {

    private static final Scanner scanner = new Scanner(System.in);

    private static int factor(int a) {
        int count = 0;
        if (a == 1) {
            return 1;
        }
        for (int i = 1; i < Math.ceil(Math.sqrt(a)); i++) {
            if ((a % i) == 0) {
                count += 2;
            }
        }
        if ((Math.ceil(Math.sqrt(a))) == Math.floor(Math.sqrt(a))) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] combination = new int[1001];
        int temp = 0;
        int box = 0;
        for (int i = 1; i < combination.length; i++) {
            while (temp <= i) {
                box++;
                temp = factor((box * (box + 1)) / 2);
            }
            combination[i] = (box * (box + 1)) / 2;
        }

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(combination[scanner.nextInt()]);
        }
    }
}
