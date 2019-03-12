package com.example.projecteuler;

import java.util.*;

// TODO: WIP
public class Problem19 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String[] start = scanner.nextLine().split(" ");
            String[] end = scanner.nextLine().split(" ");
            int numSundays =
                    countSundays(Integer.parseInt(end[1]), Integer.parseInt(end[0])) -
                            countSundays(Integer.parseInt(start[1]), Integer.parseInt(start[0]));
            System.out.println(numSundays);
        }
        scanner.close();
    }

    private static int countSundays(int finalMonth,
                                    int finalYear) {
        int weekday = 1;
        int month = 1;
        int year = 1900;

        int numSundays = 0;
        int monthLength = numberOfDays(month, year);

        while (!(month > finalMonth && year == finalYear) && !(year > finalYear)) {
            if (weekday == 0) {
                numSundays++;
            }
            int weekdayOffset = monthLength % 7;
            for (int i = 0; i < weekdayOffset; i++) {
                weekday = (weekday == 6) ? 0 : weekday + 1;
            }

            if (month != 12) {
                month++;
            } else {
                month = 1;
                year++;
            }

            monthLength = numberOfDays(month, year);
        }

        return numSundays;
    }

    private static int numberOfDays(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 9 || month == 4 || month == 6 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
