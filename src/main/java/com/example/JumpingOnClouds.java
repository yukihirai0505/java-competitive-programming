package com.example;

import java.util.Arrays;

public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    private static int jumpingOnClouds(int[] c) {
        int total = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (i < c.length - 2 && c[i + 2] != 1) {
                i++;
            }
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = Arrays.stream("0 0 0 0 1 0".split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(jumpingOnClouds(nums));
        int[] nums2 = Arrays.stream("0 0 1 0 0 1 0".split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(jumpingOnClouds(nums2));
        int[] nums3 = Arrays.stream("0 0 0 1 0 0".split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(jumpingOnClouds(nums3));
    }
}
