package com.example;

public class NQueens {

    private static final int QUEENS = 4;
    private static final int[] VERTICAL = new int[QUEENS];
    private static final boolean[] HORIZONTAL = new boolean[QUEENS];
    private static final boolean[] DIP_POSITIVE = new boolean[QUEENS * 2 - 1];
    private static final boolean[] DIP_NEGATIVE = new boolean[QUEENS * 2 - 1];
    private static final boolean SAFE = false;
    private static final boolean OUT = true;
    private static int counter;

    public static void main(String[] args) {
        trySet(0);
        if (counter < 1) {
            System.out.println("not available");
        } else {
            System.out.println(counter + " pattern available");
        }
    }

    private static void trySet(int i) {
        for (int j = 0; j < QUEENS; j++) {
            if (HORIZONTAL[j] == SAFE && DIP_POSITIVE[i + j] == SAFE && DIP_NEGATIVE[i - j + (QUEENS - 1)] == SAFE) {
                VERTICAL[i] = j;
                if (i == (QUEENS - 1)) {
                    counter++;
                    printBoard();
                } else {
                    HORIZONTAL[j] = DIP_POSITIVE[i + j] = DIP_NEGATIVE[i - j + (QUEENS - 1)] = OUT;
                    trySet(i + 1);
                    HORIZONTAL[j] = DIP_POSITIVE[i + j] = DIP_NEGATIVE[i - j + (QUEENS - 1)] = SAFE;
                }
            }
        }
    }

    private static void printBoard() {
        System.out.println(counter + " pattern");
        for (int i = 0; i < QUEENS; i++) {
            for (int j = 0; j < QUEENS; j++) {
                System.out.printf("%s", j == VERTICAL[i] ? "● " : "□ ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
