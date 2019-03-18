package com.example;

public class QueensAttack {

    /**
     * FIXME: java.lang.OutOfMemoryError: Java heap space
     *
     * @param n:         an integer, the number of rows and columns on the board
     * @param k:         an integer, the number of obstacles on the board
     * @param r_q:       integer, the row number of queen's position
     * @param c_q:       integer, the column number of the queen's position
     * @param obstacles: a two dimensional array of integers where each element is an array of 2 integers, the row and column of an obstacle
     * @return the number of squares that the queen can attack from position(r_q, c_q)
     */
    private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int rQ = r_q - 1;
        int cQ = c_q - 1;
        // Create board
        int[][] board = new int[n][n];
        // Set obstacles
        for (int[] obstacle : obstacles) {
            int row = obstacle[0] - 1;
            int column = obstacle[1] - 1;
            board[row][column] = -1;
        }
        // Set the queen
        board[rQ][cQ] = 1;
        int count = 0;
        // down and up
        for (int i = r_q; i < n; i++) {
            if (board[i][cQ] != 0) break;
            count += 1;
        }
        for (int i = rQ - 1; i >= 0; i--) {
            if (board[i][cQ] != 0) break;
            count += 1;
        }
        // right and left
        for (int i = c_q; i < n; i++) {
            if (board[rQ][i] != 0) break;
            count += 1;
        }
        for (int i = cQ - 1; i >= 0; i--) {
            if (board[rQ][i] != 0) break;
            count += 1;
        }
        // diagonal right
        for (int row = rQ - 1, col = c_q; row >= 0 && col < n; row--, col++) {
            if (board[row][col] != 0) break;
            count += 1;
        }
        for (int row = r_q, col = cQ - 1; row < n && col >= 0; row++, col--) {
            if (board[row][col] != 0) break;
            count += 1;
        }
        // diagonal left
        for (int row = rQ - 1, col = cQ - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] != 0) break;
            count += 1;
        }
        for (int row = r_q, col = c_q; row < n && col < n; row++, col++) {
            if (board[row][col] != 0) break;
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(queensAttack(4, 0, 4, 4, new int[][]{}));
//        System.out.println(queensAttack(5, 3, 4, 3, new int[][]{
//                new int[]{5, 5},
//                new int[]{4, 2},
//                new int[]{2, 3},
//        }));
//        System.out.println(queensAttack(1, 0, 1, 1, new int[][]{}));
        // 308369
        System.out.println(queensAttack(100000, 0, 4187, 5068, new int[][]{}));
    }

}
