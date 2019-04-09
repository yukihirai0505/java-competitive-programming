package com.example;

public class TaumBday {

    // bc is cont of each b
    // wc is cost of each w
    // z is converting cost b <--> w
    static long taumBday(int b, int w, int bc, int wc, int z) {
        long minBlackPrice = Math.min(bc, wc + z);
        long minWhitePrice = Math.min(wc, bc + z);
        return ((minBlackPrice * b) + (minWhitePrice * w));
    }

    public static void main(String[] args) {
        System.out.println(taumBday(
                10, 10,
                1, 1, 1
        ));
        System.out.println(taumBday(
                5, 9,
                2, 3, 4
        ));
        System.out.println(taumBday(
                3, 6,
                9, 1, 1
        ));
        System.out.println(taumBday(
                7, 7,
                4, 2, 1
        ));
        System.out.println(taumBday(
                3, 3,
                1, 9, 2
        ));
    }
}
