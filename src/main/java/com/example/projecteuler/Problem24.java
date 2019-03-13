package com.example.projecteuler;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem24 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        String s = "abcdefghijklm";

        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            if (n == 1) System.out.println(s);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < s.length(); j++)
                    list.add((int) s.charAt(j));

                StringBuilder sb = new StringBuilder();
                long remain = n - 1;
                for (int k = 1; k < s.length(); k++) {
                    long j = remain / factorial(s.length() - k);
                    remain = remain % factorial(s.length() - k);
                    sb.append((char) (int) list.get((int) j));
                    list.remove((int) j);

                    if (remain == 0)
                        break;
                }

                for (Integer aList : list) sb.append((char) (int) aList);
                System.out.println(sb);
            }
        }
    }

    private static long factorial(long n) {
        long fact = 1L;
        for (long i = 2L; i <= n; i++) fact *= i;
        return fact;
    }
}
