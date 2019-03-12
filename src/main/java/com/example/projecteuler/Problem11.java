package com.example.projecteuler;

import java.util.Scanner;

public class Problem11 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create Grid
        int size = 20;
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int max = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if ((x + 3) < size) {
                    int product = grid[x][y]
                            * grid[x + 1][y]
                            * grid[x + 2][y]
                            * grid[x + 3][y];
                    max = Math.max(max, product);
                }
                if ((y + 3) < size) {
                    int product = grid[x][y]
                            * grid[x][y + 1]
                            * grid[x][y + 2]
                            * grid[x][y + 3];
                    max = Math.max(max, product);
                }
                if ((x + 3) < size && (y + 3) < size) {
                    int product = grid[x][y]
                            * grid[x + 1][y + 1]
                            * grid[x + 2][y + 2]
                            * grid[x + 3][y + 3];
                    max = Math.max(max, product);
                }
                if ((x + 3) < size && y >= 3) {
                    int product = grid[x][y]
                            * grid[x + 1][y - 1]
                            * grid[x + 2][y - 2]
                            * grid[x + 3][y - 3];
                    max = Math.max(max, product);
                }
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
