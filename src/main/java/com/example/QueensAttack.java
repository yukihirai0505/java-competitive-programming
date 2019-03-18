package com.example;

public class QueensAttack {

    /**
     * @param n:         an integer, the number of rows and columns on the board
     * @param k:         an integer, the number of obstacles on the board
     * @param rQueen:    integer, the row number of queen's position
     * @param cQueen:    integer, the column number of the queen's position
     * @param obstacles: a two dimensional array of integers where each element is an array of 2 integers, the row and column of an obstacle
     * @return the number of squares that the queen can attack from position(r_q, c_q)
     */
    private static int queensAttack(int n, int k, int rQueen, int cQueen, int[][] obstacles) {
        // Row Column coordinates of the closes object in each direction

        // Right
        int rR = -1;
        int cR = -1;

        // Bottom Right
        int rBR = -1;
        int cBR = -1;

        // Bottom
        int rB = -1;
        int cB = -1;

        // Bottom Left
        int rBL = -1;
        int cBL = -1;

        // Left
        int rL = -1;
        int cL = -1;

        // Top Left
        int rTL = -1;
        int cTL = -1;

        // Top
        int rT = -1;
        int cT = -1;

        // Top Right
        int rTR = -1;
        int cTR = -1;

        // Total squares attacked by the queen
        int reachableSquares = 0;

        // Finds the closest object in each direction
        for (int[] obstacle : obstacles) {
            int row = obstacle[0];
            int column = obstacle[1];

            // Right
            if ((column < cR || rR == -1) && column > cQueen && row == rQueen) {
                rR = row;
                cR = column;
            }

            // Bottom Right
            if (rQueen - row == column - cQueen && column > cQueen && row < rQueen
                    && ((row > rBR && column < cBR) || rBR == -1)) {
                rBR = row;
                cBR = column;
            }

            // Bottom
            if ((row > rB || rB == -1) && row < rQueen && column == cQueen) {
                rB = row;
                cB = column;
            }

            // Bottom Left
            if (rQueen - row == cQueen - column && column < cQueen && row < rQueen
                    && ((row > rBL && column > cBL) || rBL == -1)) {
                rBL = row;
                cBL = column;
            }

            // Left
            if ((column > cL || rL == -1) && column < cQueen && row == rQueen) {
                rL = row;
                cL = column;
            }

            // Top Left
            if (cQueen - column == row - rQueen && column < cQueen && row > rQueen
                    && ((row < rTL && column > cTL) || rTL == -1)) {
                rTL = row;
                cTL = column;
            }

            // Top
            if ((row < rT || rT == -1) && row > rQueen && column == cQueen) {
                rT = row;
                cT = column;
            }

            // Top Right
            if (row - rQueen == column - cQueen && column > cQueen
                    && row > rQueen && ((row < rTR && column < cTR) || rTR == -1)) {
                rTR = row;
                cTR = column;
            }

        }

        // Calculates the distance to the closest obstacle in each direction and adds it to reachableSquares
        // Right
        reachableSquares += (cR != -1) ? (cR - cQueen - 1) : n - cQueen;
        // Bottom
        reachableSquares += (rB != -1) ? (rQueen - rB - 1) : rQueen - 1;
        // Left
        reachableSquares += (cL != -1) ? (cQueen - cL - 1) : cQueen - 1;
        // Top
        reachableSquares += (rT != -1) ? (rT - rQueen - 1) : n - rQueen;

        // Bottom Right
        reachableSquares += (cBR != -1) ? (cBR - cQueen - 1) : Math.min(n - cQueen, rQueen - 1);
        // Bottom Left
        reachableSquares += (rBL != -1) ? (cQueen - cBL - 1) : Math.min(cQueen - 1, rQueen - 1);
        // TopLeft
        reachableSquares += (cTL != -1) ? (cQueen - cTL - 1) : Math.min(cQueen - 1, n - rQueen);
        // TopRight
        reachableSquares += (rTR != -1) ? (cTR - cQueen - 1) : Math.min(n - cQueen, n - rQueen);
        return reachableSquares;
    }

    public static void main(String[] args) {
        System.out.println(queensAttack(4, 0, 4, 4, new int[][]{}));
        System.out.println(queensAttack(5, 3, 4, 3, new int[][]{
                new int[]{5, 5},
                new int[]{4, 2},
                new int[]{2, 3},
        }));
        System.out.println(queensAttack(1, 0, 1, 1, new int[][]{}));
        // 308369
        System.out.println(queensAttack(100000, 0, 4187, 5068, new int[][]{}));
    }

}
