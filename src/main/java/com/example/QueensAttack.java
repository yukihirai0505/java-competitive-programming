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
        int rRObstacle = -1;
        int cRObstacle = -1;
        int rBRObstacle = -1;
        int cBRObstacle = -1;
        int rBObstacle = -1;
        int cBObstacle = -1;
        int rBLObstacle = -1;
        int cBLObstacle = -1;
        int rLObstacle = -1;
        int cLObstacle = -1;
        int rTLObstacle = -1;
        int cTLObstacle = -1;
        int rTObstacle = -1;
        int cTObstacle = -1;
        int rTRObstacle = -1;
        int cTRObstacle = -1;

        // Total squares attacked by the queen
        int reachableSquares = 0;

        // Finds the closest object in each direction
        for (int[] obstacle : obstacles) {
            int rObstacle = obstacle[0];
            int cObstacle = obstacle[1];

            //　Right
            if ((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > cQueen && rObstacle == rQueen) {
                rRObstacle = rObstacle;
                cRObstacle = cObstacle;
            }

            //　Bottom Right
            if (rQueen - rObstacle == cObstacle - cQueen && cObstacle > cQueen && rObstacle < rQueen
                    && ((rObstacle > rBRObstacle && cObstacle < cBRObstacle) || rBRObstacle == -1)) {
                rBRObstacle = rObstacle;
                cBRObstacle = cObstacle;
            }

            // Bottom
            if ((rObstacle > rBObstacle || rBObstacle == -1) && rObstacle < rQueen && cObstacle == cQueen) {
                rBObstacle = rObstacle;
                cBObstacle = cObstacle;
            }

            // Bottom Left
            if (rQueen - rObstacle == cQueen - cObstacle && cObstacle < cQueen && rObstacle < rQueen
                    && ((rObstacle > rBLObstacle && cObstacle > cBLObstacle) || rBLObstacle == -1)) {
                rBLObstacle = rObstacle;
                cBLObstacle = cObstacle;
            }

            // Left
            if ((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < cQueen && rObstacle == rQueen) {
                rLObstacle = rObstacle;
                cLObstacle = cObstacle;
            }

            // Top Left
            if (cQueen - cObstacle == rObstacle - rQueen && cObstacle < cQueen && rObstacle > rQueen
                    && ((rObstacle < rTLObstacle && cObstacle > cTLObstacle) || rTLObstacle == -1)) {
                rTLObstacle = rObstacle;
                cTLObstacle = cObstacle;
            }

            // Top
            if ((rObstacle < rTObstacle || rTObstacle == -1) && rObstacle > rQueen && cObstacle == cQueen) {
                rTObstacle = rObstacle;
                cTObstacle = cObstacle;
            }

            // Top Right
            if (rObstacle - rQueen == cObstacle - cQueen && cObstacle > cQueen
                    && rObstacle > rQueen && ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1)) {
                rTRObstacle = rObstacle;
                cTRObstacle = cObstacle;
            }

        }

        //Calculates the distance to the closest obstacle in each direction and adds it to reachableSquares
        //R B L T
        reachableSquares += (cRObstacle != -1) ? (cRObstacle - cQueen - 1) : n - cQueen;
        reachableSquares += (rBObstacle != -1) ? (rQueen - rBObstacle - 1) : rQueen - 1;
        reachableSquares += (cLObstacle != -1) ? (cQueen - cLObstacle - 1) : cQueen - 1;
        reachableSquares += (rTObstacle != -1) ? (rTObstacle - rQueen - 1) : n - rQueen;

        //BR BL TL TR
        reachableSquares += (cBRObstacle != -1) ? (cBRObstacle - cQueen - 1) : Math.min(n - cQueen, rQueen - 1);
        reachableSquares += (rBLObstacle != -1) ? (cQueen - cBLObstacle - 1) : Math.min(cQueen - 1, rQueen - 1);
        reachableSquares += (cTLObstacle != -1) ? (cQueen - cTLObstacle - 1) : Math.min(cQueen - 1, n - rQueen);
        reachableSquares += (rTRObstacle != -1) ? (cTRObstacle - cQueen - 1) : Math.min(n - cQueen, n - rQueen);
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
