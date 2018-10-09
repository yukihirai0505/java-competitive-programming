package com.example;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0;
        int count = 0;
        for (String step : s.split("")) {
            switch (step) {
                case "U":
                    level++;
                    break;
                case "D":
                    if (level == 0) count++;
                    level--;
                    break;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
    }
}
