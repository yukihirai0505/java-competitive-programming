package com.example.projecteuler;

import java.math.BigInteger;
import java.util.Scanner;

// WIP: test #6, #7 timeout
public class Problem78 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int target = in.nextInt();
            BigInteger[] ways = new BigInteger[target + 1];
            for (int temp = 0; temp < ways.length; temp++)
                ways[temp] = BigInteger.valueOf(0);
            ways[0] = BigInteger.valueOf(1);

            for (int j = 1; j <= target - 1; j++) {
                for (int k = j; k <= target; k++) {
                    ways[k] = ways[k].add(ways[k - j]);
                }
            }
            System.out.println((ways[ways.length - 1].add(BigInteger.valueOf(1))).mod(BigInteger.valueOf(1000000007)));
        }
    }

}
