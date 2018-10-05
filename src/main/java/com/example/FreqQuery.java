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

public class FreqQuery {

    // Complete the freqQuery function below.
    private static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Long, Long> map = new HashMap<>();
        queries.forEach(query -> {
            long num = query.get(1);
            switch (query.get(0)) {
                case 1:
                    map.put(num, map.getOrDefault(num, 0L) + 1);
                    break;
                case 2:
                    long value = map.getOrDefault(num, 0L);
                    if (value > 0) {
                        map.put(num, value - 1);
                    }
                    break;
                case 3:
                    if (map.containsValue(num)) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
            }
        });
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> queries = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 5));
            add(Arrays.asList(1, 6));
            add(Arrays.asList(3, 2));
            add(Arrays.asList(1, 10));
            add(Arrays.asList(1, 10));
            add(Arrays.asList(1, 6));
            add(Arrays.asList(2, 5));
            add(Arrays.asList(3, 2));
        }};
        freqQuery(queries).forEach(System.out::println);
    }
}
