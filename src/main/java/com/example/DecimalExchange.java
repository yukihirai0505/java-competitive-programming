package com.example;

import java.util.Scanner;

public class DecimalExchange {
    private static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int fromBase = sc.nextInt();
        int toBase = sc.nextInt();
        String fact = convertFromBaseToBase(number, fromBase, toBase);
        System.out.println("Parse " + number + " to " + fact);
        sc.close();
    }

}
