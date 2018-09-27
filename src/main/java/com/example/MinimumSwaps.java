package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps {
    // Complete the minimumSwaps function below.
    private static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i < arr[i] - 1) {
                swap(i, Math.min(arr.length - 1, arr[i] - 1), arr);
                count++;
                i--;
            }
        }
        return count;
    }

    private static void swap(int first, int second, int[] arr) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
