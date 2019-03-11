package com.example.db;

public class Knapsack {

    private static int max(int[][] a, int maxWeight) {
        int[][] dp = new int[110][10010];
        for (int w = 0; w <= maxWeight; w++) {
            dp[0][w] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                int weight = a[i][0];
                int value = a[i][1];
                if (w >= weight) {
                    dp[i + 1][w] = Math.max(dp[i][w - weight] + value, dp[i][w]);
                } else {
                    dp[i + 1][w] = dp[i][w];
                }
            }
        }
        return dp[a.length][maxWeight];
    }

    public static void main(String[] args) {
        // should be 91
        System.out.println(max(
                new int[][]{
                        new int[]{2, 3},
                        new int[]{1, 2},
                        new int[]{3, 6},
                        new int[]{2, 1},
                        new int[]{1, 3},
                        new int[]{5, 85},
                }, 8
        ));
    }
}
