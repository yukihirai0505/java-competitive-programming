package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps {
    // 対象の数字を本来あるべきインデックスにswapしていく
    // ex: 3 7 6 9 1 8 10 4 2 5
    private static int minimumSwaps(int[] arr) {
        int count = 0,
                // 10 - 1 = 9
                arrIndexLen = arr.length - 1;
        for (int i = 0; i < arrIndexLen; i++) {
            // i == 0 のとき a は 3
            int a = arr[i];
            // ex: 0 < 2(3-1)
            if (i < a - 1) {
                // 0番目と=>2番目(本来のインデックス)をswapする
                swap(i, a - 1, arr);
                // 6 7 3 9 1 8 10 4 2 5 でaの3は本来あるべきインデックス2番目に配置される
                StringBuilder sb = new StringBuilder();
                for (int num : arr) {
                    sb.append(num);
                }
                System.out.println(sb.toString());
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
