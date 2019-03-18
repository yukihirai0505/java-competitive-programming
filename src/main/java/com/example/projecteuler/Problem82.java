package com.example.projecteuler;

import java.util.*;

public class Problem82 {

    private static final Scanner scanner = new Scanner(System.in);

    private static long minSum(int[][] matrix) {
        int matrixSize = matrix.length;
        long[] dp = new long[matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            dp[i] = matrix[i][matrixSize - 1];
        }
        for (int i = matrixSize - 2; i >= 0; i--) {
            dp[0] += matrix[0][i];
            for (int j = 1; j < matrixSize; j++) {
                dp[j] = Math.min(dp[j - 1] + matrix[j][i], dp[j] + matrix[j][i]);
            }
            for (int j = matrixSize - 2; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1] + matrix[j][i]);
            }
        }
        OptionalLong min = Arrays.stream(dp).min();
        return min.isPresent() ? min.getAsLong() : -1;
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            scanner.nextLine();
            int[][] mtrix = new int[T][T];
            for (int j = 0; j < T; j++) {
                String[] next = scanner.nextLine().split(" ");
                for (int k = 0; k < next.length; k++) {
                    mtrix[j][k] = Integer.parseInt(next[k]);
                }
            }
            System.out.println(minSum(mtrix));
        }
        scanner.close();
    }
}
