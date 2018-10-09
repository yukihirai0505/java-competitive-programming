package com.example;

public class CountingValleys {

    // Complete the countingValleys function below.
    private static int countingValleys(String s) {
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

    public static void main(String[] args) {
        System.out.println(countingValleys("DDUUDDUDUUUD"));
        System.out.println(countingValleys("UDDDUDUU"));
    }
}
