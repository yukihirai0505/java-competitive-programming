package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    private static long arrayManipulation(int n, int[][] queries) {
        // nのサイズのarrayをつくる
        long[] rows = new long[n];
        // 配列の中のmax値を保存するarrayをつくる
        long[] maxNums = new long[queries.length];
        // queriesの列ごとに a to b のインデックスに k を足していく
        for (int index = 0; index < queries.length; index++) {
            int[] query = queries[index];
            int fromIndex = query[0] - 1;
            int toIndex = query[1] - 1;
            int insertNum = query[2];
            for (int j = fromIndex; j <= toIndex; j++) {
                rows[j] = rows[j] + insertNum;
            }
//            StringBuilder output = new StringBuilder();
//            for (int row : rows) {
//                output.append(String.valueOf(row)).append(" ");
//            }
//            System.out.println(output.toString());
            // 計算が終わった後のmax値を保存する
            maxNums[index] = Arrays.stream(rows).max().orElse(0);
        }
        // 全ての計算が終わったらarrayのmax値を返す
        return Arrays.stream(maxNums).max().orElse(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        try {
            long result = arrayManipulation(n, queries);
            bufferedWriter.write(String.valueOf(result));
        } catch (Exception e) {
            bufferedWriter.write(e.getMessage());
        }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
