package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NonDivisibleSubset {


    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : S) {
            int remainder = num % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        int count = 0;
        for (int idx = k - 1; idx > k / 2; idx--) {
            count += Math.max(
                    map.getOrDefault(idx, 0),
                    map.getOrDefault(k - idx, 0)
            );
        }

        if (k % 2 == 0 && map.containsKey(k / 2) && map.get(k / 2) >= 1)
            count++;
        if (map.containsKey(0) && map.get(0) >= 1)
            count++;

        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(nonDivisibleSubset(3, new int[]{1, 7, 2, 4}));
        System.out.println(
                nonDivisibleSubset(
                        7,
                        new int[]{
                                278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436
                        }
                )
        );
    }

}
