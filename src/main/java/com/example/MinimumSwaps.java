package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.OptionalInt;
import java.util.Scanner;

public class MinimumSwaps {
    // Complete the minimumSwaps function below.
    private static int minimumSwaps(int[] arr) {
        return swapCount(arr, 0);
    }

    private static int swapCount(int[] arr, int count) {
        OptionalInt firstIndex = OptionalInt.empty(),
                secondIndex = OptionalInt.empty();
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i],
                    b = arr[i + 1];
            if (secondIndex.isPresent()) {
                if (arr[secondIndex.getAsInt()] > b) {
                    secondIndex = OptionalInt.of(i + 1);
                }
            }
            if (!firstIndex.isPresent()) {
                if (a > b) {
                    firstIndex = OptionalInt.of(i);
                    secondIndex = OptionalInt.of(i + 1);
                }
            }
        }
        if (firstIndex.isPresent() && secondIndex.isPresent()) {
            return swapCount(
                    swap(arr, firstIndex.getAsInt(), secondIndex.getAsInt())
                    , count + 1
            );
        } else {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num);
            }
            System.out.println(sb.toString());
            return count;
        }
    }

    private static int[] swap(int[] arr, int first, int second) {
        int firstNum = arr[first];
        int secondNum = arr[second];
        arr[first] = secondNum;
        arr[second] = firstNum;
        return arr;
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
