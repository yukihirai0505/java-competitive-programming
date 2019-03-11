package com.example.db;

public class MaxSum {

    private static int max(int[] a) {
        int[] dp = new int[10010];
        dp[0] = 0;
        for (int i = 0; i < a.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i] + a[i]);
        }
        return dp[a.length];
    }

    public static void main(String[] args) {
        // should be 16
        System.out.println(max(new int[]{7, -6, 9}));
        // should be 0
        System.out.println(max(new int[]{-6, -16}));
    }
}
