package com.example.projecteuler;

import java.util.*;

public class Problem18_67 {

    private static final Scanner scanner = new Scanner(System.in);

    private static int maxSum(int tri[][]) {
        int m = tri.length - 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i + 1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }
        return tri[0][0];
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int H = scanner.nextInt();
            scanner.nextLine();
            int[][] tri = new int[H][H];
            for (int j = 0; j < H; j++) {
                String[] next = scanner.nextLine().split(" ");
                for (int k = 0; k < next.length; k++) {
                    tri[j][k] = Integer.parseInt(next[k]);
                }
            }
            System.out.println(maxSum(tri));
        }
        scanner.close();
    }
}
