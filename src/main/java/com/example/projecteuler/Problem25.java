package com.example.projecteuler;

import java.util.Scanner;

public class Problem25 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (long i = 0; i < T; i++) {
            int numberOfDigits = scanner.nextInt();
            if (numberOfDigits == 1) System.out.println(1);
            else {
                int numberOfDigitsEncountered = 0;
                int nthFibonacci = 1;
                while (numberOfDigitsEncountered < numberOfDigits) {
                    double rootFive = Math.sqrt(5);
                    double logFiveOverTwo = Math.log10(rootFive);
                    double digits = nthFibonacci * Math.log10((1 + rootFive) / 2) - logFiveOverTwo;
                    int ds = (int) digits + 1;
                    if (ds == numberOfDigits) break;
                    numberOfDigitsEncountered = ds;
                    nthFibonacci += 1;
                }
                System.out.println(nthFibonacci);
            }
        }
    }
}
