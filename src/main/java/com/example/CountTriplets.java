package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    private static long countTriplets(List<Long> arr, long r) {
        HashSet<int[]> set = new HashSet<>();
        int length = arr.size();
        for (int i = 0; i < length - 2; i++) {
            Long secondNum = arr.get(i) * r;
            Long thirdNum = secondNum * r;
            for (int j = i + 1; j < length; j++) {
                if (secondNum.equals(arr.get(j))) {
                    for (int k = j + 1; k < length; k++) {
                        if (thirdNum.equals(arr.get(k))) {
                            int[] comb = {i, j, k};
                            set.add(comb);
                        }
                    }
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
