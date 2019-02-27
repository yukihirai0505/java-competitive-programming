package com.example;

class LibraryFine {


    private static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return (y1 - y2) * 10000;
        }
        if (y1 == y2) {
            if (m1 > m2) {
                return (m1 - m2) * 500;
            }
            if (m1 == m2 & d1 > d2) {
                return (d1 - d2) * 15;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(libraryFine(
                9, 6, 2015,
                6, 6, 2015
        ));
        System.out.println(libraryFine(
                1, 12, 2017,
                1, 1, 2018
        ));
        System.out.println(libraryFine(
                5, 5, 2014,
                23, 2, 2014
        ));

    }
}
