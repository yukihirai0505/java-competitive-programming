package com.example;

import java.util.Scanner;

public class CountSwaps {


    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int n = a.length;
        int count = 0;
        for (int ignored : a) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    count++;
                }
            }
        }
        System.out.println(String.format("Array is sorted in %d swaps.", count));
        System.out.println(String.format("First Element: %d", a[0]));
        System.out.println(String.format("Last Element: %d", a[a.length - 1]));
    }

    private static void swap(int first, int second, int[] arr) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
